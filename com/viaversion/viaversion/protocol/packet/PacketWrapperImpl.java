/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelFuture
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.protocol.packet;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.util.PipelineUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={PacketValue.class})
public class PacketWrapperImpl
implements PacketWrapper {
    private final Deque<PacketValue<?>> readableObjects = new ArrayDeque();
    private final List<PacketValue<?>> packetValues = new ArrayList();
    private final ByteBuf inputBuffer;
    private final UserConnection userConnection;
    private boolean send = true;
    private PacketType packetType;
    private boolean allActionsRead;
    private int id;

    public PacketWrapperImpl(int packetId, @Nullable ByteBuf inputBuffer, UserConnection userConnection) {
        this.id = packetId;
        this.inputBuffer = inputBuffer;
        this.userConnection = userConnection;
    }

    public PacketWrapperImpl(@Nullable PacketType packetType, @Nullable ByteBuf inputBuffer, UserConnection userConnection) {
        this.packetType = packetType;
        this.id = packetType != null ? packetType.getId() : -1;
        this.inputBuffer = inputBuffer;
        this.userConnection = userConnection;
    }

    @Override
    public <T> T get(Type<T> type, int index) throws InformativeException {
        int currentIndex = 0;
        for (PacketValue<?> packetValue : this.packetValues) {
            if (packetValue.type() != type) continue;
            if (currentIndex == index) {
                return (T)packetValue.value();
            }
            ++currentIndex;
        }
        throw this.createInformativeException(new ArrayIndexOutOfBoundsException(PacketWrapperImpl.jvmdowngrader$concat$get$1(type.getTypeName(), index)), type, index);
    }

    @Override
    public boolean is(Type type, int index) {
        int currentIndex = 0;
        for (PacketValue<?> packetValue : this.packetValues) {
            if (packetValue.type() != type) continue;
            if (currentIndex == index) {
                return true;
            }
            ++currentIndex;
        }
        return false;
    }

    @Override
    public boolean isReadable(Type type, int index) {
        int currentIndex = 0;
        for (PacketValue<?> packetValue : this.readableObjects) {
            if (packetValue.type().getBaseClass() != type.getBaseClass()) continue;
            if (currentIndex == index) {
                return true;
            }
            ++currentIndex;
        }
        return false;
    }

    @Override
    public <T> void set(Type<T> type, int index, @Nullable T value) throws InformativeException {
        int currentIndex = 0;
        for (PacketValue<?> packetValue : this.packetValues) {
            if (packetValue.type() != type) continue;
            if (currentIndex == index) {
                packetValue.setValue(value);
                return;
            }
            ++currentIndex;
        }
        throw this.createInformativeException(new ArrayIndexOutOfBoundsException(PacketWrapperImpl.jvmdowngrader$concat$get$1(type.getTypeName(), index)), type, index);
    }

    @Override
    public <T> T read(Type<T> type) {
        return (T)(this.readableObjects.isEmpty() ? this.readFromBuffer(type) : this.pollReadableObject(type).jvmdowngrader$nest$com_viaversion_viaversion_protocol_packet_PacketWrapperImpl$PacketValue$get$value());
    }

    private <T> T readFromBuffer(Type<T> type) {
        Preconditions.checkNotNull((Object)this.inputBuffer, (Object)"This packet does not have an input buffer.");
        try {
            return type.read(this.inputBuffer);
        }
        catch (Exception e2) {
            throw this.createInformativeException(e2, type, this.packetValues.size() + 1);
        }
    }

    private <T> PacketValue<T> pollReadableObject(Type<T> type) {
        PacketValue<?> readValue = this.readableObjects.poll();
        Type<?> readType = readValue.type();
        if (readType == type || type.getBaseClass() == readType.getBaseClass() && type.getOutputClass() == readType.getOutputClass()) {
            return readValue;
        }
        throw this.createInformativeException(new IOException(PacketWrapperImpl.jvmdowngrader$concat$pollReadableObject$1(type.getTypeName(), readValue.type().getTypeName())), type, this.readableObjects.size());
    }

    @Override
    public <T> void write(Type<T> type, T value) {
        this.addPacketValue(new PacketValue<T>(type, value));
    }

    private <T> @Nullable T attemptTransform(Type<T> expectedType, @Nullable Object value) {
        if (value != null && !expectedType.getOutputClass().isAssignableFrom(value.getClass())) {
            if (expectedType instanceof TypeConverter) {
                return ((TypeConverter)((Object)expectedType)).from(value);
            }
            Via.getPlatform().getLogger().warning(PacketWrapperImpl.jvmdowngrader$concat$attemptTransform$1(value.getClass().getName(), String.valueOf(expectedType.getOutputClass())));
        }
        return (T)value;
    }

    @Override
    public <T> T passthrough(Type<T> type) throws InformativeException {
        if (this.readableObjects.isEmpty()) {
            T value = this.readFromBuffer(type);
            this.addPacketValue(new PacketValue<T>(type, value));
            return value;
        }
        PacketValue<T> value = this.pollReadableObject(type);
        this.addPacketValue(value);
        return (T)value.jvmdowngrader$nest$com_viaversion_viaversion_protocol_packet_PacketWrapperImpl$PacketValue$get$value();
    }

    private void addPacketValue(PacketValue<?> packetValue) {
        if (!this.allActionsRead) {
            this.packetValues.add(packetValue);
        }
    }

    @Override
    public <T> T passthroughAndMap(Type<?> type, Type<T> mappedType) throws InformativeException {
        if (type == mappedType) {
            return this.passthrough(mappedType);
        }
        Object value = this.read(type);
        T mappedValue = this.attemptTransform(mappedType, value);
        this.write(mappedType, mappedValue);
        return mappedValue;
    }

    @Override
    public void passthroughAll() throws InformativeException {
        this.packetValues.addAll(this.readableObjects);
        this.readableObjects.clear();
        if (this.inputBuffer.isReadable()) {
            this.passthrough(Types.REMAINING_BYTES);
        }
    }

    @Override
    public void writeToBuffer(ByteBuf buffer) throws InformativeException {
        this.writeProcessedValues(buffer);
        if (this.inputBuffer != null) {
            buffer.writeBytes(this.inputBuffer);
        }
    }

    public boolean areStoredPacketValuesEmpty() {
        return this.packetValues.isEmpty() && this.readableObjects.isEmpty();
    }

    public void writeProcessedValues(ByteBuf buffer) throws InformativeException {
        if (this.id != -1) {
            Types.VAR_INT.writePrimitive(buffer, this.id);
        }
        if (!this.readableObjects.isEmpty()) {
            this.packetValues.addAll(this.readableObjects);
            this.readableObjects.clear();
        }
        for (int i2 = 0; i2 < this.packetValues.size(); ++i2) {
            PacketValue<?> packetValue = this.packetValues.get(i2);
            try {
                packetValue.write(buffer);
                continue;
            }
            catch (Exception e2) {
                throw this.createInformativeException(e2, packetValue.type(), i2);
            }
        }
    }

    private InformativeException createInformativeException(Exception cause, Type<?> type, int index) {
        ProtocolInfo protocolInfo = this.user().getProtocolInfo();
        return new InformativeException(cause).set("Packet Type", this.packetType).set("Client Protocol", protocolInfo.protocolVersion().getName()).set("Server Protocol", protocolInfo.serverProtocolVersion().getName()).set("Index", index).set("Type", type.getTypeName()).set("Data", this.packetValues).set("Packet ID", this.id);
    }

    @Override
    public void clearInputBuffer() {
        if (this.inputBuffer != null) {
            this.inputBuffer.clear();
        }
        this.readableObjects.clear();
    }

    @Override
    public void clearPacket() {
        this.clearInputBuffer();
        this.packetValues.clear();
    }

    @Override
    public void send(Class<? extends Protocol> protocol, boolean skipCurrentPipeline) throws InformativeException {
        this.send0(protocol, skipCurrentPipeline, true);
    }

    @Override
    public void scheduleSend(Class<? extends Protocol> protocol, boolean skipCurrentPipeline) throws InformativeException {
        this.send0(protocol, skipCurrentPipeline, false);
    }

    private void send0(Class<? extends Protocol> protocol, boolean skipCurrentPipeline, boolean currentThread) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        UserConnection connection = this.user();
        if (currentThread) {
            this.sendNow(protocol, skipCurrentPipeline);
        } else {
            connection.getChannel().eventLoop().submit(() -> this.sendNow(protocol, skipCurrentPipeline));
        }
    }

    private void sendNow(Class<? extends Protocol> protocol, boolean skipCurrentPipeline) throws InformativeException {
        block4: {
            try {
                ByteBuf output = this.constructPacket(protocol, skipCurrentPipeline, Direction.CLIENTBOUND);
                this.user().sendRawPacket(output);
            }
            catch (InformativeException e2) {
                throw e2;
            }
            catch (CancelException e2) {
            }
            catch (Exception e3) {
                if (PipelineUtil.containsCause(e3, CancelException.class)) break block4;
                throw new InformativeException(e3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ByteBuf constructPacket(@Nullable Class<? extends Protocol> protocolClass, boolean skipCurrentPipeline, Direction direction) throws InformativeException, CancelException {
        this.resetReader();
        ProtocolInfo protocolInfo = this.user().getProtocolInfo();
        List<Protocol> protocols = protocolInfo.getPipeline().pipes(protocolClass, skipCurrentPipeline, direction);
        this.apply(direction, protocolInfo.getState(direction), protocols);
        ByteBuf output = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(output);
            ByteBuf byteBuf = output.retain();
            return byteBuf;
        }
        finally {
            output.release();
        }
    }

    @Override
    public ChannelFuture sendFuture(Class<? extends Protocol> protocolClass) throws InformativeException {
        if (!this.isCancelled()) {
            ByteBuf output;
            try {
                output = this.constructPacket(protocolClass, true, Direction.CLIENTBOUND);
            }
            catch (CancelException e2) {
                return this.user().getChannel().newFailedFuture((Throwable)new RuntimeException("Cancelled packet"));
            }
            return this.user().sendRawPacketFuture(output);
        }
        return this.cancelledFuture();
    }

    @Override
    public void sendRaw() throws InformativeException {
        this.sendRaw(true);
    }

    @Override
    public ChannelFuture sendFutureRaw() throws InformativeException {
        if (this.isCancelled()) {
            return this.cancelledFuture();
        }
        ByteBuf output = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(output);
            ChannelFuture channelFuture = this.user().sendRawPacketFuture(output.retain());
            return channelFuture;
        }
        finally {
            output.release();
        }
    }

    @Override
    public void scheduleSendRaw() throws InformativeException {
        this.sendRaw(false);
    }

    private void sendRaw(boolean currentThread) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        ByteBuf output = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(output);
            if (currentThread) {
                this.user().sendRawPacket(output.retain());
            } else {
                this.user().scheduleSendRawPacket(output.retain());
            }
        }
        finally {
            output.release();
        }
    }

    private ByteBuf allocateOutputBuffer() {
        if (this.inputBuffer == null) {
            return this.user().getChannel().alloc().buffer();
        }
        return this.inputBuffer.alloc().buffer(Math.max(this.inputBuffer.readableBytes(), 256));
    }

    private ChannelFuture cancelledFuture() {
        return this.user().getChannel().newFailedFuture((Throwable)new RuntimeException("Tried to send cancelled packet"));
    }

    @Override
    public PacketWrapperImpl create(int packetId) {
        return new PacketWrapperImpl(packetId, null, this.user());
    }

    @Override
    public PacketWrapperImpl create(int packetId, PacketHandler handler) throws InformativeException {
        PacketWrapperImpl wrapper = this.create(packetId);
        handler.handle(wrapper);
        return wrapper;
    }

    @Override
    public void apply(Direction direction, State state, List<Protocol> pipeline) throws InformativeException, CancelException {
        int size = pipeline.size();
        for (int i2 = 0; i2 < size; ++i2) {
            Protocol protocol = pipeline.get(i2);
            protocol.transform(direction, state, this);
            this.resetReader();
            if (this.packetType == null) continue;
            state = this.packetType.state();
        }
    }

    @Override
    public boolean isCancelled() {
        return !this.send;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.send = !cancel;
    }

    @Override
    public UserConnection user() {
        return this.userConnection;
    }

    @Override
    public void resetReader() {
        for (int i2 = this.packetValues.size() - 1; i2 >= 0; --i2) {
            this.readableObjects.addFirst(this.packetValues.get(i2));
        }
        this.packetValues.clear();
    }

    @Override
    public void sendToServerRaw() throws InformativeException {
        this.sendToServerRaw(true);
    }

    @Override
    public void scheduleSendToServerRaw() throws InformativeException {
        this.sendToServerRaw(false);
    }

    private void sendToServerRaw(boolean currentThread) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        ByteBuf output = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(output);
            if (currentThread) {
                this.user().sendRawPacketToServer(output.retain());
            } else {
                this.user().scheduleSendRawPacketToServer(output.retain());
            }
        }
        finally {
            output.release();
        }
    }

    @Override
    public void sendToServer(Class<? extends Protocol> protocol, boolean skipCurrentPipeline) throws InformativeException {
        this.sendToServer0(protocol, skipCurrentPipeline, true);
    }

    @Override
    public void scheduleSendToServer(Class<? extends Protocol> protocol, boolean skipCurrentPipeline) throws InformativeException {
        this.sendToServer0(protocol, skipCurrentPipeline, false);
    }

    private void sendToServer0(Class<? extends Protocol> protocol, boolean skipCurrentPipeline, boolean currentThread) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        UserConnection connection = this.user();
        if (currentThread) {
            block6: {
                try {
                    ByteBuf output = this.constructPacket(protocol, skipCurrentPipeline, Direction.SERVERBOUND);
                    connection.sendRawPacketToServer(output);
                }
                catch (InformativeException e2) {
                    throw e2;
                }
                catch (CancelException e2) {
                }
                catch (Exception e3) {
                    if (PipelineUtil.containsCause(e3, CancelException.class)) break block6;
                    throw new InformativeException(e3);
                }
            }
            return;
        }
        connection.getChannel().eventLoop().submit(() -> {
            block4: {
                try {
                    ByteBuf output = this.constructPacket(protocol, skipCurrentPipeline, Direction.SERVERBOUND);
                    connection.sendRawPacketToServer(output);
                }
                catch (InformativeException e2) {
                    throw e2;
                }
                catch (CancelException e2) {
                }
                catch (Exception e3) {
                    if (PipelineUtil.containsCause(e3, CancelException.class)) break block4;
                    throw new InformativeException(e3);
                }
            }
        });
    }

    @Override
    public @Nullable PacketType getPacketType() {
        return this.packetType;
    }

    @Override
    public void setPacketType(PacketType packetType) {
        this.packetType = packetType;
        this.id = packetType != null ? packetType.getId() : -1;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    @Deprecated
    public void setId(int id) {
        this.packetType = null;
        this.id = id;
    }

    public @Nullable ByteBuf getInputBuffer() {
        return this.inputBuffer;
    }

    public void setAllActionsRead(boolean allActionsRead) {
        this.allActionsRead = allActionsRead;
    }

    public String toString() {
        return PacketWrapperImpl.jvmdowngrader$concat$toString$1(String.valueOf(this.packetType), this.id, String.valueOf(this.packetValues), String.valueOf(this.readableObjects));
    }

    private static String jvmdowngrader$concat$get$1(String string, int n2) {
        return "Could not find type " + string + " at " + n2;
    }

    private static String jvmdowngrader$concat$pollReadableObject$1(String string, String string2) {
        return "Unable to read type " + string + ", found " + string2;
    }

    private static String jvmdowngrader$concat$attemptTransform$1(String string, String string2) {
        return "Possible type mismatch: " + string + " -> " + string2;
    }

    private static String jvmdowngrader$concat$toString$1(String string, int n2, String string2, String string3) {
        return "PacketWrapper{type=" + string + ", id=" + n2 + ", values=" + string2 + ", readable=" + string3 + "}";
    }

    @NestHost(value=PacketWrapperImpl.class)
    public static final class PacketValue<T> {
        private final Type<T> type;
        private T value;

        PacketValue(Type<T> type, @Nullable T value) {
            this.type = type;
            this.value = value;
        }

        public Type<T> type() {
            return this.type;
        }

        public @Nullable Object value() {
            return this.value;
        }

        public void write(ByteBuf buffer) throws Exception {
            this.type.write(buffer, this.value);
        }

        public void setValue(@Nullable T value) {
            this.value = value;
        }

        public boolean equals(Object o2) {
            if (this == o2) {
                return true;
            }
            if (o2 == null || this.getClass() != o2.getClass()) {
                return false;
            }
            PacketValue that = (PacketValue)o2;
            if (!this.type.equals(that.type)) {
                return false;
            }
            return Objects.equals(this.value, that.value);
        }

        public int hashCode() {
            int result = this.type.hashCode();
            result = 31 * result + (this.value != null ? this.value.hashCode() : 0);
            return result;
        }

        public String toString() {
            return PacketValue.jvmdowngrader$concat$toString$1(String.valueOf(this.type), String.valueOf(this.value));
        }

        public Object jvmdowngrader$nest$com_viaversion_viaversion_protocol_packet_PacketWrapperImpl$PacketValue$get$value() {
            return this.value;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocol_packet_PacketWrapperImpl$PacketValue$set$value(Object object) {
            this.value = object;
        }

        private static String jvmdowngrader$concat$toString$1(String string, String string2) {
            return "{" + string + ": " + string2 + "}";
        }
    }
}

