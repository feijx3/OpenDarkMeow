/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.handler.codec.http;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBuf;
import net.darkmeow.irc.lib.io.netty.buffer.Unpooled;
import net.darkmeow.irc.lib.io.netty.channel.ChannelHandlerContext;
import net.darkmeow.irc.lib.io.netty.handler.codec.ByteToMessageDecoder;
import net.darkmeow.irc.lib.io.netty.handler.codec.DecoderResult;
import net.darkmeow.irc.lib.io.netty.handler.codec.PrematureChannelClosureException;
import net.darkmeow.irc.lib.io.netty.handler.codec.TooLongFrameException;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpContent;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultHttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.DefaultLastHttpContent;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpContent;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpDecoderConfig;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpExpectationFailedEvent;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaderNames;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaderValues;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeaders;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpHeadersFactory;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMessage;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpMessageDecoderResult;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponse;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpResponseStatus;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpStatusClass;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpUtil;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.HttpVersion;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.LastHttpContent;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.TooLongHttpHeaderException;
import net.darkmeow.irc.lib.io.netty.handler.codec.http.TooLongHttpLineException;
import net.darkmeow.irc.lib.io.netty.util.AsciiString;
import net.darkmeow.irc.lib.io.netty.util.ByteProcessor;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.StringUtil;

public abstract class HttpObjectDecoder
extends ByteToMessageDecoder {
    public static final int DEFAULT_MAX_INITIAL_LINE_LENGTH = 4096;
    public static final int DEFAULT_MAX_HEADER_SIZE = 8192;
    public static final boolean DEFAULT_CHUNKED_SUPPORTED = true;
    public static final boolean DEFAULT_ALLOW_PARTIAL_CHUNKS = true;
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    public static final boolean DEFAULT_VALIDATE_HEADERS = true;
    public static final int DEFAULT_INITIAL_BUFFER_SIZE = 128;
    public static final boolean DEFAULT_ALLOW_DUPLICATE_CONTENT_LENGTHS = false;
    private final int maxChunkSize;
    private final boolean chunkedSupported;
    private final boolean allowPartialChunks;
    @Deprecated
    protected final boolean validateHeaders;
    protected final HttpHeadersFactory headersFactory;
    protected final HttpHeadersFactory trailersFactory;
    private final boolean allowDuplicateContentLengths;
    private final ByteBuf parserScratchBuffer;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private HttpMessage message;
    private long chunkSize;
    private long contentLength = Long.MIN_VALUE;
    private boolean chunked;
    private boolean isSwitchingToNonHttp1Protocol;
    private final AtomicBoolean resetRequested = new AtomicBoolean();
    private AsciiString name;
    private String value;
    private LastHttpContent trailer;
    private State currentState = State.SKIP_CONTROL_CHARS;
    private static final boolean[] SP_LENIENT_BYTES;
    private static final boolean[] LATIN_WHITESPACE;
    private static final boolean[] ISO_CONTROL_OR_WHITESPACE;
    private static final ByteProcessor SKIP_CONTROL_CHARS_BYTES;

    @Override
    protected void handlerRemoved0(ChannelHandlerContext ctx) throws Exception {
        try {
            this.parserScratchBuffer.release();
        }
        finally {
            super.handlerRemoved0(ctx);
        }
    }

    protected HttpObjectDecoder() {
        this(new HttpDecoderConfig());
    }

    @Deprecated
    protected HttpObjectDecoder(int maxInitialLineLength, int maxHeaderSize, int maxChunkSize, boolean chunkedSupported) {
        this(new HttpDecoderConfig().setMaxInitialLineLength(maxInitialLineLength).setMaxHeaderSize(maxHeaderSize).setMaxChunkSize(maxChunkSize).setChunkedSupported(chunkedSupported));
    }

    @Deprecated
    protected HttpObjectDecoder(int maxInitialLineLength, int maxHeaderSize, int maxChunkSize, boolean chunkedSupported, boolean validateHeaders) {
        this(new HttpDecoderConfig().setMaxInitialLineLength(maxInitialLineLength).setMaxHeaderSize(maxHeaderSize).setMaxChunkSize(maxChunkSize).setChunkedSupported(chunkedSupported).setValidateHeaders(validateHeaders));
    }

    @Deprecated
    protected HttpObjectDecoder(int maxInitialLineLength, int maxHeaderSize, int maxChunkSize, boolean chunkedSupported, boolean validateHeaders, int initialBufferSize) {
        this(new HttpDecoderConfig().setMaxInitialLineLength(maxInitialLineLength).setMaxHeaderSize(maxHeaderSize).setMaxChunkSize(maxChunkSize).setChunkedSupported(chunkedSupported).setValidateHeaders(validateHeaders).setInitialBufferSize(initialBufferSize));
    }

    @Deprecated
    protected HttpObjectDecoder(int maxInitialLineLength, int maxHeaderSize, int maxChunkSize, boolean chunkedSupported, boolean validateHeaders, int initialBufferSize, boolean allowDuplicateContentLengths) {
        this(new HttpDecoderConfig().setMaxInitialLineLength(maxInitialLineLength).setMaxHeaderSize(maxHeaderSize).setMaxChunkSize(maxChunkSize).setChunkedSupported(chunkedSupported).setValidateHeaders(validateHeaders).setInitialBufferSize(initialBufferSize).setAllowDuplicateContentLengths(allowDuplicateContentLengths));
    }

    @Deprecated
    protected HttpObjectDecoder(int maxInitialLineLength, int maxHeaderSize, int maxChunkSize, boolean chunkedSupported, boolean validateHeaders, int initialBufferSize, boolean allowDuplicateContentLengths, boolean allowPartialChunks) {
        this(new HttpDecoderConfig().setMaxInitialLineLength(maxInitialLineLength).setMaxHeaderSize(maxHeaderSize).setMaxChunkSize(maxChunkSize).setChunkedSupported(chunkedSupported).setValidateHeaders(validateHeaders).setInitialBufferSize(initialBufferSize).setAllowDuplicateContentLengths(allowDuplicateContentLengths).setAllowPartialChunks(allowPartialChunks));
    }

    protected HttpObjectDecoder(HttpDecoderConfig config) {
        ObjectUtil.checkNotNull(config, "config");
        this.parserScratchBuffer = Unpooled.buffer(config.getInitialBufferSize());
        this.lineParser = new LineParser(this.parserScratchBuffer, config.getMaxInitialLineLength());
        this.headerParser = new HeaderParser(this.parserScratchBuffer, config.getMaxHeaderSize());
        this.maxChunkSize = config.getMaxChunkSize();
        this.chunkedSupported = config.isChunkedSupported();
        this.headersFactory = config.getHeadersFactory();
        this.trailersFactory = config.getTrailersFactory();
        this.validateHeaders = this.isValidating(this.headersFactory);
        this.allowDuplicateContentLengths = config.isAllowDuplicateContentLengths();
        this.allowPartialChunks = config.isAllowPartialChunks();
    }

    protected boolean isValidating(HttpHeadersFactory headersFactory) {
        if (headersFactory instanceof DefaultHttpHeadersFactory) {
            DefaultHttpHeadersFactory builder = (DefaultHttpHeadersFactory)headersFactory;
            return builder.isValidatingHeaderNames() || builder.isValidatingHeaderValues();
        }
        return true;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        if (this.resetRequested.get()) {
            this.resetNow();
        }
        switch (this.currentState) {
            case SKIP_CONTROL_CHARS: 
            case READ_INITIAL: {
                try {
                    ByteBuf line = this.lineParser.parse(buffer);
                    if (line == null) {
                        return;
                    }
                    String[] initialLine = this.splitInitialLine(line);
                    assert (initialLine.length == 3) : "initialLine::length must be 3";
                    this.message = this.createMessage(initialLine);
                    this.currentState = State.READ_HEADER;
                }
                catch (Exception e2) {
                    out.add(this.invalidMessage(this.message, buffer, e2));
                    return;
                }
            }
            case READ_HEADER: {
                try {
                    State nextState = this.readHeaders(buffer);
                    if (nextState == null) {
                        return;
                    }
                    this.currentState = nextState;
                    switch (nextState) {
                        case SKIP_CONTROL_CHARS: {
                            this.addCurrentMessage(out);
                            out.add(LastHttpContent.EMPTY_LAST_CONTENT);
                            this.resetNow();
                            return;
                        }
                        case READ_CHUNK_SIZE: {
                            if (!this.chunkedSupported) {
                                throw new IllegalArgumentException("Chunked messages not supported");
                            }
                            this.addCurrentMessage(out);
                            return;
                        }
                    }
                    if (this.contentLength == 0L || this.contentLength == -1L && this.isDecodingRequest()) {
                        this.addCurrentMessage(out);
                        out.add(LastHttpContent.EMPTY_LAST_CONTENT);
                        this.resetNow();
                        return;
                    }
                    assert (nextState == State.READ_FIXED_LENGTH_CONTENT || nextState == State.READ_VARIABLE_LENGTH_CONTENT);
                    this.addCurrentMessage(out);
                    if (nextState == State.READ_FIXED_LENGTH_CONTENT) {
                        this.chunkSize = this.contentLength;
                    }
                    return;
                }
                catch (Exception e3) {
                    out.add(this.invalidMessage(this.message, buffer, e3));
                    return;
                }
            }
            case READ_VARIABLE_LENGTH_CONTENT: {
                int toRead = Math.min(buffer.readableBytes(), this.maxChunkSize);
                if (toRead > 0) {
                    ByteBuf content = buffer.readRetainedSlice(toRead);
                    out.add(new DefaultHttpContent(content));
                }
                return;
            }
            case READ_FIXED_LENGTH_CONTENT: {
                int readLimit = buffer.readableBytes();
                if (readLimit == 0) {
                    return;
                }
                int toRead = Math.min(readLimit, this.maxChunkSize);
                if ((long)toRead > this.chunkSize) {
                    toRead = (int)this.chunkSize;
                }
                ByteBuf content = buffer.readRetainedSlice(toRead);
                this.chunkSize -= (long)toRead;
                if (this.chunkSize == 0L) {
                    out.add(new DefaultLastHttpContent(content, this.trailersFactory));
                    this.resetNow();
                } else {
                    out.add(new DefaultHttpContent(content));
                }
                return;
            }
            case READ_CHUNK_SIZE: {
                try {
                    ByteBuf line = this.lineParser.parse(buffer);
                    if (line == null) {
                        return;
                    }
                    int chunkSize = HttpObjectDecoder.getChunkSize(line.array(), line.arrayOffset() + line.readerIndex(), line.readableBytes());
                    this.chunkSize = chunkSize;
                    if (chunkSize == 0) {
                        this.currentState = State.READ_CHUNK_FOOTER;
                        return;
                    }
                    this.currentState = State.READ_CHUNKED_CONTENT;
                }
                catch (Exception e4) {
                    out.add(this.invalidChunk(buffer, e4));
                    return;
                }
            }
            case READ_CHUNKED_CONTENT: {
                assert (this.chunkSize <= Integer.MAX_VALUE);
                int toRead = Math.min((int)this.chunkSize, this.maxChunkSize);
                if (!this.allowPartialChunks && buffer.readableBytes() < toRead) {
                    return;
                }
                if ((toRead = Math.min(toRead, buffer.readableBytes())) == 0) {
                    return;
                }
                DefaultHttpContent chunk = new DefaultHttpContent(buffer.readRetainedSlice(toRead));
                this.chunkSize -= (long)toRead;
                out.add(chunk);
                if (this.chunkSize != 0L) {
                    return;
                }
                this.currentState = State.READ_CHUNK_DELIMITER;
            }
            case READ_CHUNK_DELIMITER: {
                int wIdx = buffer.writerIndex();
                int rIdx = buffer.readerIndex();
                while (wIdx > rIdx) {
                    byte next;
                    if ((next = buffer.getByte(rIdx++)) != 10) continue;
                    this.currentState = State.READ_CHUNK_SIZE;
                    break;
                }
                buffer.readerIndex(rIdx);
                return;
            }
            case READ_CHUNK_FOOTER: {
                try {
                    LastHttpContent trailer = this.readTrailingHeaders(buffer);
                    if (trailer == null) {
                        return;
                    }
                    out.add(trailer);
                    this.resetNow();
                    return;
                }
                catch (Exception e5) {
                    out.add(this.invalidChunk(buffer, e5));
                    return;
                }
            }
            case BAD_MESSAGE: {
                buffer.skipBytes(buffer.readableBytes());
                break;
            }
            case UPGRADED: {
                int readableBytes = buffer.readableBytes();
                if (readableBytes <= 0) break;
                out.add(buffer.readBytes(readableBytes));
                break;
            }
        }
    }

    @Override
    protected void decodeLast(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        super.decodeLast(ctx, in, out);
        if (this.resetRequested.get()) {
            this.resetNow();
        }
        switch (this.currentState) {
            case READ_VARIABLE_LENGTH_CONTENT: {
                if (!this.chunked && !in.isReadable()) {
                    out.add(LastHttpContent.EMPTY_LAST_CONTENT);
                    this.resetNow();
                }
                return;
            }
            case READ_HEADER: {
                out.add(this.invalidMessage(this.message, Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                this.resetNow();
                return;
            }
            case READ_CHUNK_SIZE: 
            case READ_FIXED_LENGTH_CONTENT: 
            case READ_CHUNKED_CONTENT: 
            case READ_CHUNK_DELIMITER: 
            case READ_CHUNK_FOOTER: {
                boolean prematureClosure;
                if (this.isDecodingRequest() || this.chunked) {
                    prematureClosure = true;
                } else {
                    boolean bl2 = prematureClosure = this.contentLength > 0L;
                }
                if (!prematureClosure) {
                    out.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                this.resetNow();
                return;
            }
            case SKIP_CONTROL_CHARS: 
            case READ_INITIAL: 
            case BAD_MESSAGE: 
            case UPGRADED: {
                break;
            }
            default: {
                throw new IllegalStateException("Unhandled state " + (Object)((Object)this.currentState));
            }
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof HttpExpectationFailedEvent) {
            switch (this.currentState) {
                case READ_CHUNK_SIZE: 
                case READ_VARIABLE_LENGTH_CONTENT: 
                case READ_FIXED_LENGTH_CONTENT: {
                    this.reset();
                    break;
                }
            }
        }
        super.userEventTriggered(ctx, evt);
    }

    private void addCurrentMessage(List<Object> out) {
        HttpMessage message = this.message;
        assert (message != null);
        this.message = null;
        out.add(message);
    }

    protected boolean isContentAlwaysEmpty(HttpMessage msg) {
        if (msg instanceof HttpResponse) {
            HttpResponse res = (HttpResponse)msg;
            HttpResponseStatus status = res.status();
            int code = status.code();
            HttpStatusClass statusClass = status.codeClass();
            if (statusClass == HttpStatusClass.INFORMATIONAL) {
                return code != 101 || res.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) || !res.headers().contains(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET, true);
            }
            switch (code) {
                case 204: 
                case 304: {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    protected boolean isSwitchingToNonHttp1Protocol(HttpResponse msg) {
        if (msg.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String newProtocol = msg.headers().get(HttpHeaderNames.UPGRADE);
        return newProtocol == null || !newProtocol.contains(HttpVersion.HTTP_1_0.text()) && !newProtocol.contains(HttpVersion.HTTP_1_1.text());
    }

    public void reset() {
        this.resetRequested.lazySet(true);
    }

    private void resetNow() {
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.chunked = false;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (this.isSwitchingToNonHttp1Protocol) {
            this.isSwitchingToNonHttp1Protocol = false;
            this.currentState = State.UPGRADED;
            return;
        }
        this.resetRequested.lazySet(false);
        this.currentState = State.SKIP_CONTROL_CHARS;
    }

    private HttpMessage invalidMessage(HttpMessage current, ByteBuf in, Exception cause) {
        this.currentState = State.BAD_MESSAGE;
        this.message = null;
        this.trailer = null;
        in.skipBytes(in.readableBytes());
        if (current == null) {
            current = this.createInvalidMessage();
        }
        current.setDecoderResult(DecoderResult.failure(cause));
        return current;
    }

    private HttpContent invalidChunk(ByteBuf in, Exception cause) {
        this.currentState = State.BAD_MESSAGE;
        this.message = null;
        this.trailer = null;
        in.skipBytes(in.readableBytes());
        DefaultLastHttpContent chunk = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        chunk.setDecoderResult(DecoderResult.failure(cause));
        return chunk;
    }

    private State readHeaders(ByteBuf buffer) {
        HttpMessage message = this.message;
        HttpHeaders headers = message.headers();
        HeaderParser headerParser = this.headerParser;
        ByteBuf line = headerParser.parse(buffer);
        if (line == null) {
            return null;
        }
        int lineLength = line.readableBytes();
        while (lineLength > 0) {
            byte[] lineContent = line.array();
            int startLine = line.arrayOffset() + line.readerIndex();
            byte firstChar = lineContent[startLine];
            if (this.name != null && (firstChar == 32 || firstChar == 9)) {
                String trimmedLine = HttpObjectDecoder.langAsciiString(lineContent, startLine, lineLength).trim();
                String valueStr = this.value;
                this.value = valueStr + ' ' + trimmedLine;
            } else {
                if (this.name != null) {
                    headers.add((CharSequence)this.name, (Object)this.value);
                }
                this.splitHeader(lineContent, startLine, lineLength);
            }
            line = headerParser.parse(buffer);
            if (line == null) {
                return null;
            }
            lineLength = line.readableBytes();
        }
        if (this.name != null) {
            headers.add((CharSequence)this.name, (Object)this.value);
        }
        this.name = null;
        this.value = null;
        HttpMessageDecoderResult decoderResult = new HttpMessageDecoderResult(this.lineParser.size, headerParser.size);
        message.setDecoderResult(decoderResult);
        List<String> contentLengthFields = headers.getAll(HttpHeaderNames.CONTENT_LENGTH);
        if (!contentLengthFields.isEmpty()) {
            HttpVersion version = message.protocolVersion();
            boolean isHttp10OrEarlier = version.majorVersion() < 1 || version.majorVersion() == 1 && version.minorVersion() == 0;
            this.contentLength = HttpUtil.normalizeAndGetContentLength(contentLengthFields, isHttp10OrEarlier, this.allowDuplicateContentLengths);
            if (this.contentLength != -1L) {
                String lengthValue = contentLengthFields.get(0).trim();
                if (contentLengthFields.size() > 1 || !lengthValue.equals(Long.toString(this.contentLength))) {
                    headers.set((CharSequence)HttpHeaderNames.CONTENT_LENGTH, (Object)this.contentLength);
                }
            }
        } else {
            this.contentLength = HttpUtil.getWebSocketContentLength(message);
        }
        if (!this.isDecodingRequest() && message instanceof HttpResponse) {
            HttpResponse res = (HttpResponse)message;
            this.isSwitchingToNonHttp1Protocol = this.isSwitchingToNonHttp1Protocol(res);
        }
        if (this.isContentAlwaysEmpty(message)) {
            HttpUtil.setTransferEncodingChunked(message, false);
            return State.SKIP_CONTROL_CHARS;
        }
        if (HttpUtil.isTransferEncodingChunked(message)) {
            this.chunked = true;
            if (!contentLengthFields.isEmpty() && message.protocolVersion() == HttpVersion.HTTP_1_1) {
                this.handleTransferEncodingChunkedWithContentLength(message);
            }
            return State.READ_CHUNK_SIZE;
        }
        if (this.contentLength >= 0L) {
            return State.READ_FIXED_LENGTH_CONTENT;
        }
        return State.READ_VARIABLE_LENGTH_CONTENT;
    }

    protected void handleTransferEncodingChunkedWithContentLength(HttpMessage message) {
        message.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
        this.contentLength = Long.MIN_VALUE;
    }

    private LastHttpContent readTrailingHeaders(ByteBuf buffer) {
        HeaderParser headerParser = this.headerParser;
        ByteBuf line = headerParser.parse(buffer);
        if (line == null) {
            return null;
        }
        LastHttpContent trailer = this.trailer;
        int lineLength = line.readableBytes();
        if (lineLength == 0 && trailer == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        AsciiString lastHeader = null;
        if (trailer == null) {
            trailer = this.trailer = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.trailersFactory);
        }
        while (lineLength > 0) {
            byte[] lineContent = line.array();
            int startLine = line.arrayOffset() + line.readerIndex();
            byte firstChar = lineContent[startLine];
            if (lastHeader != null && (firstChar == 32 || firstChar == 9)) {
                List<String> current = trailer.trailingHeaders().getAll(lastHeader);
                if (!current.isEmpty()) {
                    int lastPos = current.size() - 1;
                    String lineTrimmed = HttpObjectDecoder.langAsciiString(lineContent, startLine, line.readableBytes()).trim();
                    String currentLastPos = current.get(lastPos);
                    current.set(lastPos, currentLastPos + lineTrimmed);
                }
            } else {
                this.splitHeader(lineContent, startLine, lineLength);
                AsciiString headerName = this.name;
                if (!(HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(headerName) || HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(headerName) || HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(headerName))) {
                    trailer.trailingHeaders().add((CharSequence)headerName, (Object)this.value);
                }
                lastHeader = this.name;
                this.name = null;
                this.value = null;
            }
            line = headerParser.parse(buffer);
            if (line == null) {
                return null;
            }
            lineLength = line.readableBytes();
        }
        this.trailer = null;
        return trailer;
    }

    protected abstract boolean isDecodingRequest();

    protected abstract HttpMessage createMessage(String[] var1) throws Exception;

    protected abstract HttpMessage createInvalidMessage();

    private static int skipWhiteSpaces(byte[] hex, int start, int length) {
        for (int i2 = 0; i2 < length; ++i2) {
            if (HttpObjectDecoder.isWhitespace(hex[start + i2])) continue;
            return i2;
        }
        return length;
    }

    private static int getChunkSize(byte[] hex, int start, int length) {
        int skipped = HttpObjectDecoder.skipWhiteSpaces(hex, start, length);
        if (skipped == length) {
            throw new NumberFormatException();
        }
        start += skipped;
        length -= skipped;
        int result = 0;
        for (int i2 = 0; i2 < length; ++i2) {
            int digit = StringUtil.decodeHexNibble(hex[start + i2]);
            if (digit == -1) {
                byte b2 = hex[start + i2];
                if (b2 == 59 || HttpObjectDecoder.isControlOrWhitespaceAsciiChar(b2)) {
                    if (i2 == 0) {
                        throw new NumberFormatException("Empty chunk size");
                    }
                    return result;
                }
                throw new NumberFormatException("Invalid character in chunk size");
            }
            result *= 16;
            if ((result += digit) >= 0) continue;
            throw new NumberFormatException("Chunk size overflow: " + result);
        }
        return result;
    }

    private String[] splitInitialLine(ByteBuf asciiBuffer) {
        int arrayOffset;
        int startContent;
        int end;
        byte[] asciiBytes = asciiBuffer.array();
        byte lastByte = asciiBytes[(end = (startContent = (arrayOffset = asciiBuffer.arrayOffset()) + asciiBuffer.readerIndex()) + asciiBuffer.readableBytes()) - 1];
        if (HttpObjectDecoder.isControlOrWhitespaceAsciiChar(lastByte) && (this.isDecodingRequest() || !HttpObjectDecoder.isOWS(lastByte))) {
            throw new IllegalArgumentException("Illegal character in request line: 0x" + Integer.toHexString(lastByte));
        }
        int aStart = HttpObjectDecoder.findNonSPLenient(asciiBytes, startContent, end);
        int aEnd = HttpObjectDecoder.findSPLenient(asciiBytes, aStart, end);
        int bStart = HttpObjectDecoder.findNonSPLenient(asciiBytes, aEnd, end);
        int bEnd = HttpObjectDecoder.findSPLenient(asciiBytes, bStart, end);
        int cStart = HttpObjectDecoder.findNonSPLenient(asciiBytes, bEnd, end);
        int cEnd = HttpObjectDecoder.findEndOfString(asciiBytes, Math.max(cStart - 1, startContent), end);
        return new String[]{this.splitFirstWordInitialLine(asciiBytes, aStart, aEnd - aStart), this.splitSecondWordInitialLine(asciiBytes, bStart, bEnd - bStart), cStart < cEnd ? this.splitThirdWordInitialLine(asciiBytes, cStart, cEnd - cStart) : ""};
    }

    protected String splitFirstWordInitialLine(byte[] asciiContent, int start, int length) {
        return HttpObjectDecoder.langAsciiString(asciiContent, start, length);
    }

    protected String splitSecondWordInitialLine(byte[] asciiContent, int start, int length) {
        return HttpObjectDecoder.langAsciiString(asciiContent, start, length);
    }

    protected String splitThirdWordInitialLine(byte[] asciiContent, int start, int length) {
        return HttpObjectDecoder.langAsciiString(asciiContent, start, length);
    }

    private static String langAsciiString(byte[] asciiContent, int start, int length) {
        if (length == 0) {
            return "";
        }
        if (start == 0) {
            if (length == asciiContent.length) {
                return new String(asciiContent, 0, 0, asciiContent.length);
            }
            return new String(asciiContent, 0, 0, length);
        }
        return new String(asciiContent, 0, start, length);
    }

    private void splitHeader(byte[] line, int start, int length) {
        int colonEnd;
        byte ch2;
        int nameEnd;
        int end = start + length;
        int nameStart = start;
        boolean isDecodingRequest = this.isDecodingRequest();
        for (nameEnd = nameStart; nameEnd < end && (ch2 = line[nameEnd]) != 58 && (isDecodingRequest || !HttpObjectDecoder.isOWS(ch2)); ++nameEnd) {
        }
        if (nameEnd == end) {
            throw new IllegalArgumentException("No colon found");
        }
        for (colonEnd = nameEnd; colonEnd < end; ++colonEnd) {
            if (line[colonEnd] != 58) continue;
            ++colonEnd;
            break;
        }
        this.name = this.splitHeaderName(line, nameStart, nameEnd - nameStart);
        int valueStart = HttpObjectDecoder.findNonWhitespace(line, colonEnd, end);
        if (valueStart == end) {
            this.value = "";
        } else {
            int valueEnd = HttpObjectDecoder.findEndOfString(line, start, end);
            this.value = HttpObjectDecoder.langAsciiString(line, valueStart, valueEnd - valueStart);
        }
    }

    protected AsciiString splitHeaderName(byte[] sb, int start, int length) {
        return new AsciiString(sb, start, length, true);
    }

    private static int findNonSPLenient(byte[] sb, int offset, int end) {
        for (int result = offset; result < end; ++result) {
            byte c2 = sb[result];
            if (HttpObjectDecoder.isSPLenient(c2)) continue;
            if (HttpObjectDecoder.isWhitespace(c2)) {
                throw new IllegalArgumentException("Invalid separator");
            }
            return result;
        }
        return end;
    }

    private static int findSPLenient(byte[] sb, int offset, int end) {
        for (int result = offset; result < end; ++result) {
            if (!HttpObjectDecoder.isSPLenient(sb[result])) continue;
            return result;
        }
        return end;
    }

    private static boolean isSPLenient(byte c2) {
        return SP_LENIENT_BYTES[c2 + 128];
    }

    private static boolean isWhitespace(byte b2) {
        return LATIN_WHITESPACE[b2 + 128];
    }

    private static int findNonWhitespace(byte[] sb, int offset, int end) {
        for (int result = offset; result < end; ++result) {
            byte c2 = sb[result];
            if (!HttpObjectDecoder.isWhitespace(c2)) {
                return result;
            }
            if (HttpObjectDecoder.isOWS(c2)) continue;
            throw new IllegalArgumentException("Invalid separator, only a single space or horizontal tab allowed, but received a '" + c2 + "' (0x" + Integer.toHexString(c2) + ")");
        }
        return end;
    }

    private static int findEndOfString(byte[] sb, int start, int end) {
        for (int result = end - 1; result > start; --result) {
            if (HttpObjectDecoder.isOWS(sb[result])) continue;
            return result + 1;
        }
        return 0;
    }

    private static boolean isOWS(byte ch2) {
        return ch2 == 32 || ch2 == 9;
    }

    private static boolean isControlOrWhitespaceAsciiChar(byte b2) {
        return ISO_CONTROL_OR_WHITESPACE[128 + b2];
    }

    static {
        byte b2;
        SP_LENIENT_BYTES = new boolean[256];
        HttpObjectDecoder.SP_LENIENT_BYTES[160] = true;
        HttpObjectDecoder.SP_LENIENT_BYTES[137] = true;
        HttpObjectDecoder.SP_LENIENT_BYTES[139] = true;
        HttpObjectDecoder.SP_LENIENT_BYTES[140] = true;
        HttpObjectDecoder.SP_LENIENT_BYTES[141] = true;
        LATIN_WHITESPACE = new boolean[256];
        for (b2 = -128; b2 < 127; b2 = (byte)((byte)(b2 + 1))) {
            HttpObjectDecoder.LATIN_WHITESPACE[128 + b2] = Character.isWhitespace(b2);
        }
        ISO_CONTROL_OR_WHITESPACE = new boolean[256];
        for (b2 = -128; b2 < 127; b2 = (byte)(b2 + 1)) {
            HttpObjectDecoder.ISO_CONTROL_OR_WHITESPACE[128 + b2] = Character.isISOControl(b2) || HttpObjectDecoder.isWhitespace(b2);
        }
        SKIP_CONTROL_CHARS_BYTES = new ByteProcessor(){

            @Override
            public boolean process(byte value) {
                return ISO_CONTROL_OR_WHITESPACE[128 + value];
            }
        };
    }

    private final class LineParser
    extends HeaderParser {
        LineParser(ByteBuf seq, int maxLength) {
            super(seq, maxLength);
        }

        @Override
        public ByteBuf parse(ByteBuf buffer) {
            this.reset();
            int readableBytes = buffer.readableBytes();
            if (readableBytes == 0) {
                return null;
            }
            int readerIndex = buffer.readerIndex();
            if (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS && this.skipControlChars(buffer, readableBytes, readerIndex)) {
                return null;
            }
            return super.parse(buffer);
        }

        private boolean skipControlChars(ByteBuf buffer, int readableBytes, int readerIndex) {
            assert (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS);
            int maxToSkip = Math.min(this.maxLength, readableBytes);
            int firstNonControlIndex = buffer.forEachByte(readerIndex, maxToSkip, SKIP_CONTROL_CHARS_BYTES);
            if (firstNonControlIndex == -1) {
                buffer.skipBytes(maxToSkip);
                if (readableBytes > this.maxLength) {
                    throw this.newException(this.maxLength);
                }
                return true;
            }
            buffer.readerIndex(firstNonControlIndex);
            HttpObjectDecoder.this.currentState = State.READ_INITIAL;
            return false;
        }

        @Override
        protected TooLongFrameException newException(int maxLength) {
            return new TooLongHttpLineException("An HTTP line is larger than " + maxLength + " bytes.");
        }
    }

    private static class HeaderParser {
        protected final ByteBuf seq;
        protected final int maxLength;
        int size;

        HeaderParser(ByteBuf seq, int maxLength) {
            this.seq = seq;
            this.maxLength = maxLength;
        }

        public ByteBuf parse(ByteBuf buffer) {
            int readableBytes = buffer.readableBytes();
            int readerIndex = buffer.readerIndex();
            int maxBodySize = this.maxLength - this.size;
            assert (maxBodySize >= 0);
            long maxBodySizeWithCRLF = (long)maxBodySize + 2L;
            int toProcess = (int)Math.min(maxBodySizeWithCRLF, (long)readableBytes);
            int toIndexExclusive = readerIndex + toProcess;
            assert (toIndexExclusive >= readerIndex);
            int indexOfLf = buffer.indexOf(readerIndex, toIndexExclusive, (byte)10);
            if (indexOfLf == -1) {
                if (readableBytes > maxBodySize) {
                    throw this.newException(this.maxLength);
                }
                return null;
            }
            int endOfSeqIncluded = indexOfLf > readerIndex && buffer.getByte(indexOfLf - 1) == 13 ? indexOfLf - 1 : indexOfLf;
            int newSize = endOfSeqIncluded - readerIndex;
            if (newSize == 0) {
                this.seq.clear();
                buffer.readerIndex(indexOfLf + 1);
                return this.seq;
            }
            int size = this.size + newSize;
            if (size > this.maxLength) {
                throw this.newException(this.maxLength);
            }
            this.size = size;
            this.seq.clear();
            this.seq.writeBytes(buffer, readerIndex, newSize);
            buffer.readerIndex(indexOfLf + 1);
            return this.seq;
        }

        public void reset() {
            this.size = 0;
        }

        protected TooLongFrameException newException(int maxLength) {
            return new TooLongHttpHeaderException("HTTP header is larger than " + maxLength + " bytes.");
        }
    }

    private static enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED;

    }
}

