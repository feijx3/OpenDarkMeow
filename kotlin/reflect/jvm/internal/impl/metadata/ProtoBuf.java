/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$ValueOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$ArgumentOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$AnnotationOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ClassOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginDataOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ConstructorOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ContractOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EffectOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntryOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ExpressionOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$FunctionOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragmentOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PropertyOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedNameOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$ArgumentOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAliasOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameterOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameterOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementOrBuilder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

public final class ProtoBuf {

    public static final class CompilerPluginData
    extends GeneratedMessageLite
    implements ProtoBuf$CompilerPluginDataOrBuilder {
        private static final CompilerPluginData defaultInstance;
        private final ByteString unknownFields;
        public static Parser<CompilerPluginData> PARSER;
        private int bitField0_;
        private int pluginId_;
        private ByteString data_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private CompilerPluginData(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private CompilerPluginData(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static CompilerPluginData getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public CompilerPluginData getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private CompilerPluginData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block20: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block20;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block20;
                            done = true;
                            continue block20;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.pluginId_ = input.readInt32();
                            continue block20;
                        }
                        case 18: 
                    }
                    this.bitField0_ |= 2;
                    this.data_ = input.readBytes();
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<CompilerPluginData> getParserForType() {
            return PARSER;
        }

        public boolean hasPluginId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getPluginId() {
            return this.pluginId_;
        }

        public boolean hasData() {
            return (this.bitField0_ & 2) == 2;
        }

        public ByteString getData() {
            return this.data_;
        }

        private void initFields() {
            this.pluginId_ = 0;
            this.data_ = ByteString.EMPTY;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasPluginId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.hasData()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.pluginId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBytes(2, this.data_);
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.pluginId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, this.data_);
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return CompilerPluginData.newBuilder();
        }

        public static Builder newBuilder(CompilerPluginData prototype) {
            return CompilerPluginData.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return CompilerPluginData.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<CompilerPluginData>(){

                @Override
                public CompilerPluginData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new CompilerPluginData(input, extensionRegistry);
                }
            };
            defaultInstance = new CompilerPluginData(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<CompilerPluginData, Builder>
        implements ProtoBuf$CompilerPluginDataOrBuilder {
            private int bitField0_;
            private int pluginId_;
            private ByteString data_ = ByteString.EMPTY;

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public CompilerPluginData getDefaultInstanceForType() {
                return CompilerPluginData.getDefaultInstance();
            }

            @Override
            public CompilerPluginData build() {
                CompilerPluginData result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public CompilerPluginData buildPartial() {
                CompilerPluginData result = new CompilerPluginData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.pluginId_ = this.pluginId_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.data_ = this.data_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(CompilerPluginData other) {
                if (other == CompilerPluginData.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPluginId()) {
                    this.setPluginId(other.getPluginId());
                }
                if (other.hasData()) {
                    this.setData(other.getData());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasPluginId()) {
                    return false;
                }
                return this.hasData();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                CompilerPluginData parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (CompilerPluginData)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasPluginId() {
                return (this.bitField0_ & 1) == 1;
            }

            public Builder setPluginId(int value) {
                this.bitField0_ |= 1;
                this.pluginId_ = value;
                return this;
            }

            public boolean hasData() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.data_ = value;
                return this;
            }
        }
    }

    public static final class Expression
    extends GeneratedMessageLite
    implements ProtoBuf$ExpressionOrBuilder {
        private static final Expression defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Expression> PARSER;
        private int bitField0_;
        private int flags_;
        private int valueParameterReference_;
        private ConstantValue constantValue_;
        private Type isInstanceType_;
        private int isInstanceTypeId_;
        private List<Expression> andArgument_;
        private List<Expression> orArgument_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Expression(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Expression(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Expression(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block25: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block25;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block25;
                            done = true;
                            continue block25;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block25;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = input.readInt32();
                            continue block25;
                        }
                        case 24: {
                            int rawValue = input.readEnum();
                            ConstantValue value = ConstantValue.valueOf(rawValue);
                            if (value == null) {
                                unknownFieldsCodedOutput.writeRawVarint32(tag);
                                unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                continue block25;
                            }
                            this.bitField0_ |= 4;
                            this.constantValue_ = value;
                            continue block25;
                        }
                        case 34: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 8) == 8) {
                                subBuilder = this.isInstanceType_.toBuilder();
                            }
                            this.isInstanceType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.isInstanceType_);
                                this.isInstanceType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue block25;
                        }
                        case 40: {
                            this.bitField0_ |= 0x10;
                            this.isInstanceTypeId_ = input.readInt32();
                            continue block25;
                        }
                        case 50: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.andArgument_ = new ArrayList<Expression>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.andArgument_.add(input.readMessage(PARSER, extensionRegistry));
                            continue block25;
                        }
                        case 58: 
                    }
                    if ((mutable_bitField0_ & 0x40) != 64) {
                        this.orArgument_ = new ArrayList<Expression>();
                        mutable_bitField0_ |= 0x40;
                    }
                    this.orArgument_.add(input.readMessage(PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                }
                if ((mutable_bitField0_ & 0x40) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasValueParameterReference() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public List<Expression> getAndArgumentList() {
            return this.andArgument_;
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public Expression getAndArgument(int index) {
            return this.andArgument_.get(index);
        }

        public List<Expression> getOrArgumentList() {
            return this.orArgument_;
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        public Expression getOrArgument(int index) {
            return this.orArgument_.get(index);
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            int i2;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (this.hasIsInstanceType() && !this.getIsInstanceType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getAndArgumentCount(); ++i2) {
                if (this.getAndArgument(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getOrArgumentCount(); ++i2) {
                if (this.getOrArgument(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeEnum(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.isInstanceTypeId_);
            }
            for (i2 = 0; i2 < this.andArgument_.size(); ++i2) {
                output.writeMessage(6, this.andArgument_.get(i2));
            }
            for (i2 = 0; i2 < this.orArgument_.size(); ++i2) {
                output.writeMessage(7, this.orArgument_.get(i2));
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i2;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
            }
            for (i2 = 0; i2 < this.andArgument_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
            }
            for (i2 = 0; i2 < this.orArgument_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i2));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Expression.newBuilder();
        }

        public static Builder newBuilder(Expression prototype) {
            return Expression.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Expression.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Expression>(){

                @Override
                public Expression parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Expression(input, extensionRegistry);
                }
            };
            defaultInstance = new Expression(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<Expression, Builder>
        implements ProtoBuf$ExpressionOrBuilder {
            private int bitField0_;
            private int flags_;
            private int valueParameterReference_;
            private ConstantValue constantValue_ = ConstantValue.TRUE;
            private Type isInstanceType_ = Type.getDefaultInstance();
            private int isInstanceTypeId_;
            private List<Expression> andArgument_ = Collections.emptyList();
            private List<Expression> orArgument_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override
            public Expression build() {
                Expression result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Expression buildPartial() {
                Expression result = new Expression(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.valueParameterReference_ = this.valueParameterReference_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.constantValue_ = this.constantValue_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.isInstanceType_ = this.isInstanceType_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.isInstanceTypeId_ = this.isInstanceTypeId_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.andArgument_ = this.andArgument_;
                if ((this.bitField0_ & 0x40) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    this.bitField0_ &= 0xFFFFFFBF;
                }
                result.orArgument_ = this.orArgument_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Expression other) {
                if (other == Expression.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasValueParameterReference()) {
                    this.setValueParameterReference(other.getValueParameterReference());
                }
                if (other.hasConstantValue()) {
                    this.setConstantValue(other.getConstantValue());
                }
                if (other.hasIsInstanceType()) {
                    this.mergeIsInstanceType(other.getIsInstanceType());
                }
                if (other.hasIsInstanceTypeId()) {
                    this.setIsInstanceTypeId(other.getIsInstanceTypeId());
                }
                if (!other.andArgument_.isEmpty()) {
                    if (this.andArgument_.isEmpty()) {
                        this.andArgument_ = other.andArgument_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureAndArgumentIsMutable();
                        this.andArgument_.addAll(other.andArgument_);
                    }
                }
                if (!other.orArgument_.isEmpty()) {
                    if (this.orArgument_.isEmpty()) {
                        this.orArgument_ = other.orArgument_;
                        this.bitField0_ &= 0xFFFFFFBF;
                    } else {
                        this.ensureOrArgumentIsMutable();
                        this.orArgument_.addAll(other.orArgument_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i2;
                if (this.hasIsInstanceType() && !this.getIsInstanceType().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getAndArgumentCount(); ++i2) {
                    if (this.getAndArgument(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getOrArgumentCount(); ++i2) {
                    if (this.getOrArgument(i2).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Expression parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Expression)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder setValueParameterReference(int value) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = value;
                return this;
            }

            public Builder setConstantValue(ConstantValue value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.constantValue_ = value;
                return this;
            }

            public boolean hasIsInstanceType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Builder mergeIsInstanceType(Type value) {
                this.isInstanceType_ = (this.bitField0_ & 8) == 8 && this.isInstanceType_ != Type.getDefaultInstance() ? Type.newBuilder(this.isInstanceType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setIsInstanceTypeId(int value) {
                this.bitField0_ |= 0x10;
                this.isInstanceTypeId_ = value;
                return this;
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.andArgument_ = new ArrayList<Expression>(this.andArgument_);
                    this.bitField0_ |= 0x20;
                }
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            public Expression getAndArgument(int index) {
                return this.andArgument_.get(index);
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.orArgument_ = new ArrayList<Expression>(this.orArgument_);
                    this.bitField0_ |= 0x40;
                }
            }

            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            public Expression getOrArgument(int index) {
                return this.orArgument_.get(index);
            }
        }

        public static enum ConstantValue implements Internal.EnumLite
        {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);

            private static Internal.EnumLiteMap<ConstantValue> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int value) {
                switch (value) {
                    case 0: {
                        return TRUE;
                    }
                    case 1: {
                        return FALSE;
                    }
                    case 2: {
                        return NULL;
                    }
                }
                return null;
            }

            private ConstantValue(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<ConstantValue>(){

                    @Override
                    public ConstantValue findValueByNumber(int number) {
                        return ConstantValue.valueOf(number);
                    }
                };
            }
        }
    }

    public static final class Effect
    extends GeneratedMessageLite
    implements ProtoBuf$EffectOrBuilder {
        private static final Effect defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Effect> PARSER;
        private int bitField0_;
        private EffectType effectType_;
        private List<Expression> effectConstructorArgument_;
        private Expression conclusionOfConditionalEffect_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Effect(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Effect(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Effect(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block22: while (!done) {
                    Enum value;
                    int rawValue;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block22;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block22;
                            done = true;
                            continue block22;
                        }
                        case 8: {
                            rawValue = input.readEnum();
                            value = EffectType.valueOf(rawValue);
                            if (value == null) {
                                unknownFieldsCodedOutput.writeRawVarint32(tag);
                                unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                continue block22;
                            }
                            this.bitField0_ |= 1;
                            this.effectType_ = value;
                            continue block22;
                        }
                        case 18: {
                            if ((mutable_bitField0_ & 2) != 2) {
                                this.effectConstructorArgument_ = new ArrayList<Expression>();
                                mutable_bitField0_ |= 2;
                            }
                            this.effectConstructorArgument_.add(input.readMessage(Expression.PARSER, extensionRegistry));
                            continue block22;
                        }
                        case 26: {
                            Expression.Builder subBuilder = null;
                            if ((this.bitField0_ & 2) == 2) {
                                subBuilder = this.conclusionOfConditionalEffect_.toBuilder();
                            }
                            this.conclusionOfConditionalEffect_ = input.readMessage(Expression.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.conclusionOfConditionalEffect_);
                                this.conclusionOfConditionalEffect_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                            continue block22;
                        }
                        case 32: 
                    }
                    rawValue = input.readEnum();
                    value = InvocationKind.valueOf(rawValue);
                    if (value == null) {
                        unknownFieldsCodedOutput.writeRawVarint32(tag);
                        unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                        continue;
                    }
                    this.bitField0_ |= 4;
                    this.kind_ = value;
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 2) == 2) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public List<Expression> getEffectConstructorArgumentList() {
            return this.effectConstructorArgument_;
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public Expression getEffectConstructorArgument(int index) {
            return this.effectConstructorArgument_.get(index);
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public boolean hasKind() {
            return (this.bitField0_ & 4) == 4;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.getEffectConstructorArgumentCount(); ++i2) {
                if (this.getEffectConstructorArgument(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasConclusionOfConditionalEffect() && !this.getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeEnum(1, this.effectType_.getNumber());
            }
            for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); ++i2) {
                output.writeMessage(2, this.effectConstructorArgument_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeEnum(4, this.kind_.getNumber());
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber());
            }
            for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Effect.newBuilder();
        }

        public static Builder newBuilder(Effect prototype) {
            return Effect.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Effect.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Effect>(){

                @Override
                public Effect parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Effect(input, extensionRegistry);
                }
            };
            defaultInstance = new Effect(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<Effect, Builder>
        implements ProtoBuf$EffectOrBuilder {
            private int bitField0_;
            private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
            private List<Expression> effectConstructorArgument_ = Collections.emptyList();
            private Expression conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            @Override
            public Effect build() {
                Effect result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Effect buildPartial() {
                Effect result = new Effect(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.effectType_ = this.effectType_;
                if ((this.bitField0_ & 2) == 2) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.effectConstructorArgument_ = this.effectConstructorArgument_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 2;
                }
                result.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 4;
                }
                result.kind_ = this.kind_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Effect other) {
                if (other == Effect.getDefaultInstance()) {
                    return this;
                }
                if (other.hasEffectType()) {
                    this.setEffectType(other.getEffectType());
                }
                if (!other.effectConstructorArgument_.isEmpty()) {
                    if (this.effectConstructorArgument_.isEmpty()) {
                        this.effectConstructorArgument_ = other.effectConstructorArgument_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureEffectConstructorArgumentIsMutable();
                        this.effectConstructorArgument_.addAll(other.effectConstructorArgument_);
                    }
                }
                if (other.hasConclusionOfConditionalEffect()) {
                    this.mergeConclusionOfConditionalEffect(other.getConclusionOfConditionalEffect());
                }
                if (other.hasKind()) {
                    this.setKind(other.getKind());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < this.getEffectConstructorArgumentCount(); ++i2) {
                    if (this.getEffectConstructorArgument(i2).isInitialized()) continue;
                    return false;
                }
                return !this.hasConclusionOfConditionalEffect() || this.getConclusionOfConditionalEffect().isInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Effect parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Effect)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setEffectType(EffectType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.effectType_ = value;
                return this;
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.effectConstructorArgument_ = new ArrayList<Expression>(this.effectConstructorArgument_);
                    this.bitField0_ |= 2;
                }
            }

            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            public Expression getEffectConstructorArgument(int index) {
                return this.effectConstructorArgument_.get(index);
            }

            public boolean hasConclusionOfConditionalEffect() {
                return (this.bitField0_ & 4) == 4;
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression value) {
                this.conclusionOfConditionalEffect_ = (this.bitField0_ & 4) == 4 && this.conclusionOfConditionalEffect_ != Expression.getDefaultInstance() ? Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setKind(InvocationKind value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.kind_ = value;
                return this;
            }
        }

        public static enum InvocationKind implements Internal.EnumLite
        {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);

            private static Internal.EnumLiteMap<InvocationKind> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int value) {
                switch (value) {
                    case 0: {
                        return AT_MOST_ONCE;
                    }
                    case 1: {
                        return EXACTLY_ONCE;
                    }
                    case 2: {
                        return AT_LEAST_ONCE;
                    }
                }
                return null;
            }

            private InvocationKind(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<InvocationKind>(){

                    @Override
                    public InvocationKind findValueByNumber(int number) {
                        return InvocationKind.valueOf(number);
                    }
                };
            }
        }

        public static enum EffectType implements Internal.EnumLite
        {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);

            private static Internal.EnumLiteMap<EffectType> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int value) {
                switch (value) {
                    case 0: {
                        return RETURNS_CONSTANT;
                    }
                    case 1: {
                        return CALLS;
                    }
                    case 2: {
                        return RETURNS_NOT_NULL;
                    }
                }
                return null;
            }

            private EffectType(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<EffectType>(){

                    @Override
                    public EffectType findValueByNumber(int number) {
                        return EffectType.valueOf(number);
                    }
                };
            }
        }
    }

    public static final class Contract
    extends GeneratedMessageLite
    implements ProtoBuf$ContractOrBuilder {
        private static final Contract defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Contract> PARSER;
        private List<Effect> effect_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Contract(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Contract(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Contract(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 10: 
                    }
                    if (!(mutable_bitField0_ & true)) {
                        this.effect_ = new ArrayList<Effect>();
                        mutable_bitField0_ |= true;
                    }
                    this.effect_.add(input.readMessage(Effect.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        public List<Effect> getEffectList() {
            return this.effect_;
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        public Effect getEffect(int index) {
            return this.effect_.get(index);
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.getEffectCount(); ++i2) {
                if (this.getEffect(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            for (int i2 = 0; i2 < this.effect_.size(); ++i2) {
                output.writeMessage(1, this.effect_.get(i2));
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i2 = 0; i2 < this.effect_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(1, this.effect_.get(i2));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Contract.newBuilder();
        }

        public static Builder newBuilder(Contract prototype) {
            return Contract.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Contract.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Contract>(){

                @Override
                public Contract parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Contract(input, extensionRegistry);
                }
            };
            defaultInstance = new Contract(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<Contract, Builder>
        implements ProtoBuf$ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            @Override
            public Contract build() {
                Contract result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Contract buildPartial() {
                Contract result = new Contract(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.effect_ = this.effect_;
                return result;
            }

            @Override
            public Builder mergeFrom(Contract other) {
                if (other == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!other.effect_.isEmpty()) {
                    if (this.effect_.isEmpty()) {
                        this.effect_ = other.effect_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureEffectIsMutable();
                        this.effect_.addAll(other.effect_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < this.getEffectCount(); ++i2) {
                    if (this.getEffect(i2).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Contract parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Contract)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureEffectIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.effect_ = new ArrayList<Effect>(this.effect_);
                    this.bitField0_ |= 1;
                }
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            public Effect getEffect(int index) {
                return this.effect_.get(index);
            }
        }
    }

    public static final class PackageFragment
    extends GeneratedMessageLite.ExtendableMessage<PackageFragment>
    implements ProtoBuf$PackageFragmentOrBuilder {
        private static final PackageFragment defaultInstance;
        private final ByteString unknownFields;
        public static Parser<PackageFragment> PARSER;
        private int bitField0_;
        private StringTable strings_;
        private QualifiedNameTable qualifiedNames_;
        private Package package_;
        private List<Class> class__;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private PackageFragment(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private PackageFragment(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block22: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block22;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block22;
                            done = true;
                            continue block22;
                        }
                        case 10: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 1) == 1) {
                                subBuilder = this.strings_.toBuilder();
                            }
                            this.strings_ = input.readMessage(StringTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((StringTable.Builder)subBuilder).mergeFrom(this.strings_);
                                this.strings_ = ((StringTable.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 1;
                            continue block22;
                        }
                        case 18: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 2) == 2) {
                                subBuilder = this.qualifiedNames_.toBuilder();
                            }
                            this.qualifiedNames_ = input.readMessage(QualifiedNameTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((QualifiedNameTable.Builder)subBuilder).mergeFrom(this.qualifiedNames_);
                                this.qualifiedNames_ = ((QualifiedNameTable.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 2;
                            continue block22;
                        }
                        case 26: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.package_.toBuilder();
                            }
                            this.package_ = input.readMessage(Package.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((Package.Builder)subBuilder).mergeFrom(this.package_);
                                this.package_ = ((Package.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block22;
                        }
                        case 34: 
                    }
                    if ((mutable_bitField0_ & 8) != 8) {
                        this.class__ = new ArrayList<Class>();
                        mutable_bitField0_ |= 8;
                    }
                    this.class__.add(input.readMessage(Class.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public boolean hasStrings() {
            return (this.bitField0_ & 1) == 1;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public Package getPackage() {
            return this.package_;
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public Class getClass_(int index) {
            return this.class__.get(index);
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (this.hasQualifiedNames() && !this.getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasPackage() && !this.getPackage().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i2 = 0; i2 < this.getClass_Count(); ++i2) {
                if (this.getClass_(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeMessage(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(3, this.package_);
            }
            for (int i2 = 0; i2 < this.class__.size(); ++i2) {
                output.writeMessage(4, this.class__.get(i2));
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeMessageSize(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(3, this.package_);
            }
            for (int i2 = 0; i2 < this.class__.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(4, this.class__.get(i2));
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static PackageFragment parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return PackageFragment.newBuilder();
        }

        public static Builder newBuilder(PackageFragment prototype) {
            return PackageFragment.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return PackageFragment.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<PackageFragment>(){

                @Override
                public PackageFragment parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new PackageFragment(input, extensionRegistry);
                }
            };
            defaultInstance = new PackageFragment(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder>
        implements ProtoBuf$PackageFragmentOrBuilder {
            private int bitField0_;
            private StringTable strings_ = StringTable.getDefaultInstance();
            private QualifiedNameTable qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            private Package package_ = Package.getDefaultInstance();
            private List<Class> class__ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            @Override
            public PackageFragment build() {
                PackageFragment result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public PackageFragment buildPartial() {
                PackageFragment result = new PackageFragment(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.strings_ = this.strings_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.qualifiedNames_ = this.qualifiedNames_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.package_ = this.package_;
                if ((this.bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result.class__ = this.class__;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(PackageFragment other) {
                if (other == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (other.hasStrings()) {
                    this.mergeStrings(other.getStrings());
                }
                if (other.hasQualifiedNames()) {
                    this.mergeQualifiedNames(other.getQualifiedNames());
                }
                if (other.hasPackage()) {
                    this.mergePackage(other.getPackage());
                }
                if (!other.class__.isEmpty()) {
                    if (this.class__.isEmpty()) {
                        this.class__ = other.class__;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        this.ensureClass_IsMutable();
                        this.class__.addAll(other.class__);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (this.hasQualifiedNames() && !this.getQualifiedNames().isInitialized()) {
                    return false;
                }
                if (this.hasPackage() && !this.getPackage().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.getClass_Count(); ++i2) {
                    if (this.getClass_(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PackageFragment parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (PackageFragment)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder mergeStrings(StringTable value) {
                this.strings_ = (this.bitField0_ & 1) == 1 && this.strings_ != StringTable.getDefaultInstance() ? StringTable.newBuilder(this.strings_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 1;
                return this;
            }

            public boolean hasQualifiedNames() {
                return (this.bitField0_ & 2) == 2;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public Builder mergeQualifiedNames(QualifiedNameTable value) {
                this.qualifiedNames_ = (this.bitField0_ & 2) == 2 && this.qualifiedNames_ != QualifiedNameTable.getDefaultInstance() ? QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 2;
                return this;
            }

            public boolean hasPackage() {
                return (this.bitField0_ & 4) == 4;
            }

            public Package getPackage() {
                return this.package_;
            }

            public Builder mergePackage(Package value) {
                this.package_ = (this.bitField0_ & 4) == 4 && this.package_ != Package.getDefaultInstance() ? Package.newBuilder(this.package_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 4;
                return this;
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.class__ = new ArrayList<Class>(this.class__);
                    this.bitField0_ |= 8;
                }
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            public Class getClass_(int index) {
                return this.class__.get(index);
            }
        }
    }

    public static final class VersionRequirementTable
    extends GeneratedMessageLite
    implements ProtoBuf$VersionRequirementTableOrBuilder {
        private static final VersionRequirementTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<VersionRequirementTable> PARSER;
        private List<VersionRequirement> requirement_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private VersionRequirementTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirementTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private VersionRequirementTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 10: 
                    }
                    if (!(mutable_bitField0_ & true)) {
                        this.requirement_ = new ArrayList<VersionRequirement>();
                        mutable_bitField0_ |= true;
                    }
                    this.requirement_.add(input.readMessage(VersionRequirement.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            for (int i2 = 0; i2 < this.requirement_.size(); ++i2) {
                output.writeMessage(1, this.requirement_.get(i2));
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i2 = 0; i2 < this.requirement_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i2));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return VersionRequirementTable.newBuilder();
        }

        public static Builder newBuilder(VersionRequirementTable prototype) {
            return VersionRequirementTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return VersionRequirementTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<VersionRequirementTable>(){

                @Override
                public VersionRequirementTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new VersionRequirementTable(input, extensionRegistry);
                }
            };
            defaultInstance = new VersionRequirementTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder>
        implements ProtoBuf$VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override
            public VersionRequirementTable build() {
                VersionRequirementTable result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable result = new VersionRequirementTable(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.requirement_ = this.requirement_;
                return result;
            }

            @Override
            public Builder mergeFrom(VersionRequirementTable other) {
                if (other == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.requirement_.isEmpty()) {
                    if (this.requirement_.isEmpty()) {
                        this.requirement_ = other.requirement_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureRequirementIsMutable();
                        this.requirement_.addAll(other.requirement_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VersionRequirementTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (VersionRequirementTable)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureRequirementIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.requirement_ = new ArrayList<VersionRequirement>(this.requirement_);
                    this.bitField0_ |= 1;
                }
            }
        }
    }

    public static final class VersionRequirement
    extends GeneratedMessageLite
    implements ProtoBuf$VersionRequirementOrBuilder {
        private static final VersionRequirement defaultInstance;
        private final ByteString unknownFields;
        public static Parser<VersionRequirement> PARSER;
        private int bitField0_;
        private int version_;
        private int versionFull_;
        private Level level_;
        private int errorCode_;
        private int message_;
        private VersionKind versionKind_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private VersionRequirement(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private VersionRequirement(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private VersionRequirement(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block24: while (!done) {
                    Enum value;
                    int rawValue;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block24;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block24;
                            done = true;
                            continue block24;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.version_ = input.readInt32();
                            continue block24;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.versionFull_ = input.readInt32();
                            continue block24;
                        }
                        case 24: {
                            rawValue = input.readEnum();
                            value = Level.valueOf(rawValue);
                            if (value == null) {
                                unknownFieldsCodedOutput.writeRawVarint32(tag);
                                unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                continue block24;
                            }
                            this.bitField0_ |= 4;
                            this.level_ = value;
                            continue block24;
                        }
                        case 32: {
                            this.bitField0_ |= 8;
                            this.errorCode_ = input.readInt32();
                            continue block24;
                        }
                        case 40: {
                            this.bitField0_ |= 0x10;
                            this.message_ = input.readInt32();
                            continue block24;
                        }
                        case 48: 
                    }
                    rawValue = input.readEnum();
                    value = VersionKind.valueOf(rawValue);
                    if (value == null) {
                        unknownFieldsCodedOutput.writeRawVarint32(tag);
                        unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                        continue;
                    }
                    this.bitField0_ |= 0x20;
                    this.versionKind_ = value;
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        public Level getLevel() {
            return this.level_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public boolean hasMessage() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getMessage() {
            return this.message_;
        }

        public boolean hasVersionKind() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeEnum(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(4, this.errorCode_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.message_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeEnum(6, this.versionKind_.getNumber());
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.errorCode_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.message_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return VersionRequirement.newBuilder();
        }

        public static Builder newBuilder(VersionRequirement prototype) {
            return VersionRequirement.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return VersionRequirement.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<VersionRequirement>(){

                @Override
                public VersionRequirement parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new VersionRequirement(input, extensionRegistry);
                }
            };
            defaultInstance = new VersionRequirement(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<VersionRequirement, Builder>
        implements ProtoBuf$VersionRequirementOrBuilder {
            private int bitField0_;
            private int version_;
            private int versionFull_;
            private Level level_ = Level.ERROR;
            private int errorCode_;
            private int message_;
            private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override
            public VersionRequirement build() {
                VersionRequirement result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public VersionRequirement buildPartial() {
                VersionRequirement result = new VersionRequirement(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.version_ = this.version_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.versionFull_ = this.versionFull_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.level_ = this.level_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.errorCode_ = this.errorCode_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.message_ = this.message_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.versionKind_ = this.versionKind_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(VersionRequirement other) {
                if (other == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (other.hasVersion()) {
                    this.setVersion(other.getVersion());
                }
                if (other.hasVersionFull()) {
                    this.setVersionFull(other.getVersionFull());
                }
                if (other.hasLevel()) {
                    this.setLevel(other.getLevel());
                }
                if (other.hasErrorCode()) {
                    this.setErrorCode(other.getErrorCode());
                }
                if (other.hasMessage()) {
                    this.setMessage(other.getMessage());
                }
                if (other.hasVersionKind()) {
                    this.setVersionKind(other.getVersionKind());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VersionRequirement parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (VersionRequirement)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setVersion(int value) {
                this.bitField0_ |= 1;
                this.version_ = value;
                return this;
            }

            public Builder setVersionFull(int value) {
                this.bitField0_ |= 2;
                this.versionFull_ = value;
                return this;
            }

            public Builder setLevel(Level value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.level_ = value;
                return this;
            }

            public Builder setErrorCode(int value) {
                this.bitField0_ |= 8;
                this.errorCode_ = value;
                return this;
            }

            public Builder setMessage(int value) {
                this.bitField0_ |= 0x10;
                this.message_ = value;
                return this;
            }

            public Builder setVersionKind(VersionKind value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.versionKind_ = value;
                return this;
            }
        }

        public static enum VersionKind implements Internal.EnumLite
        {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);

            private static Internal.EnumLiteMap<VersionKind> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int value) {
                switch (value) {
                    case 0: {
                        return LANGUAGE_VERSION;
                    }
                    case 1: {
                        return COMPILER_VERSION;
                    }
                    case 2: {
                        return API_VERSION;
                    }
                }
                return null;
            }

            private VersionKind(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<VersionKind>(){

                    @Override
                    public VersionKind findValueByNumber(int number) {
                        return VersionKind.valueOf(number);
                    }
                };
            }
        }

        public static enum Level implements Internal.EnumLite
        {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);

            private static Internal.EnumLiteMap<Level> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int value) {
                switch (value) {
                    case 0: {
                        return WARNING;
                    }
                    case 1: {
                        return ERROR;
                    }
                    case 2: {
                        return HIDDEN;
                    }
                }
                return null;
            }

            private Level(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<Level>(){

                    @Override
                    public Level findValueByNumber(int number) {
                        return Level.valueOf(number);
                    }
                };
            }
        }
    }

    public static final class EnumEntry
    extends GeneratedMessageLite.ExtendableMessage<EnumEntry>
    implements ProtoBuf$EnumEntryOrBuilder {
        private static final EnumEntry defaultInstance;
        private final ByteString unknownFields;
        public static Parser<EnumEntry> PARSER;
        private int bitField0_;
        private int name_;
        private List<Annotation> annotation_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private EnumEntry(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private EnumEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block20: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block20;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block20;
                            done = true;
                            continue block20;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.name_ = input.readInt32();
                            continue block20;
                        }
                        case 18: 
                    }
                    if ((mutable_bitField0_ & 2) != 2) {
                        this.annotation_ = new ArrayList<Annotation>();
                        mutable_bitField0_ |= 2;
                    }
                    this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 2) == 2) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getName() {
            return this.name_;
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        private void initFields() {
            this.name_ = 0;
            this.annotation_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                if (this.getAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.name_);
            }
            for (int i2 = 0; i2 < this.annotation_.size(); ++i2) {
                output.writeMessage(2, this.annotation_.get(i2));
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.name_);
            }
            for (int i2 = 0; i2 < this.annotation_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(2, this.annotation_.get(i2));
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return EnumEntry.newBuilder();
        }

        public static Builder newBuilder(EnumEntry prototype) {
            return EnumEntry.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return EnumEntry.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<EnumEntry>(){

                @Override
                public EnumEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new EnumEntry(input, extensionRegistry);
                }
            };
            defaultInstance = new EnumEntry(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder>
        implements ProtoBuf$EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;
            private List<Annotation> annotation_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override
            public EnumEntry build() {
                EnumEntry result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public EnumEntry buildPartial() {
                EnumEntry result = new EnumEntry(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.name_ = this.name_;
                if ((this.bitField0_ & 2) == 2) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.annotation_ = this.annotation_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(EnumEntry other) {
                if (other == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                    if (this.getAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EnumEntry parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (EnumEntry)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 2;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            public Builder addAnnotation(Annotation value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureAnnotationIsMutable();
                this.annotation_.add(value);
                return this;
            }
        }
    }

    public static final class TypeAlias
    extends GeneratedMessageLite.ExtendableMessage<TypeAlias>
    implements ProtoBuf$TypeAliasOrBuilder {
        private static final TypeAlias defaultInstance;
        private final ByteString unknownFields;
        public static Parser<TypeAlias> PARSER;
        private int bitField0_;
        private int flags_;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private Type underlyingType_;
        private int underlyingTypeId_;
        private Type expandedType_;
        private int expandedTypeId_;
        private List<Annotation> annotation_;
        private List<Integer> versionRequirement_;
        private List<CompilerPluginData> compilerPluginData_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeAlias(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private TypeAlias(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block29: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block29;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block29;
                            done = true;
                            continue block29;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block29;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.name_ = input.readInt32();
                            continue block29;
                        }
                        case 26: {
                            if ((mutable_bitField0_ & 4) != 4) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 4;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block29;
                        }
                        case 34: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.underlyingType_.toBuilder();
                            }
                            this.underlyingType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.underlyingType_);
                                this.underlyingType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block29;
                        }
                        case 40: {
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = input.readInt32();
                            continue block29;
                        }
                        case 50: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) {
                                subBuilder = this.expandedType_.toBuilder();
                            }
                            this.expandedType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.expandedType_);
                                this.expandedType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x10;
                            continue block29;
                        }
                        case 56: {
                            this.bitField0_ |= 0x20;
                            this.expandedTypeId_ = input.readInt32();
                            continue block29;
                        }
                        case 66: {
                            if ((mutable_bitField0_ & 0x80) != 128) {
                                this.annotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x80;
                            }
                            this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block29;
                        }
                        case 248: {
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.versionRequirement_.add(input.readInt32());
                            continue block29;
                        }
                        case 250: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x100) != 256 && input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x100;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block29;
                        }
                        case 258: 
                    }
                    if ((mutable_bitField0_ & 0x200) != 512) {
                        this.compilerPluginData_ = new ArrayList<CompilerPluginData>();
                        mutable_bitField0_ |= 0x200;
                    }
                    this.compilerPluginData_.add(input.readMessage(CompilerPluginData.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((mutable_bitField0_ & 0x80) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((mutable_bitField0_ & 0x100) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if ((mutable_bitField0_ & 0x200) == 512) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getName() {
            return this.name_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public CompilerPluginData getCompilerPluginData(int index) {
            return this.compilerPluginData_.get(index);
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
            this.compilerPluginData_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            int i2;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                if (this.getTypeParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasUnderlyingType() && !this.getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasExpandedType() && !this.getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                if (this.getAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                if (this.getCompilerPluginData(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.name_);
            }
            for (i2 = 0; i2 < this.typeParameter_.size(); ++i2) {
                output.writeMessage(3, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeMessage(6, this.expandedType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(7, this.expandedTypeId_);
            }
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                output.writeMessage(8, this.annotation_.get(i2));
            }
            for (i2 = 0; i2 < this.versionRequirement_.size(); ++i2) {
                output.writeInt32(31, this.versionRequirement_.get(i2));
            }
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                output.writeMessage(32, this.compilerPluginData_.get(i2));
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i2;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            for (i2 = 0; i2 < this.typeParameter_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
            }
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i2));
            }
            int dataSize = 0;
            for (int i3 = 0; i3 < this.versionRequirement_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i3));
            }
            size += dataSize;
            size += 2 * this.getVersionRequirementList().size();
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(32, this.compilerPluginData_.get(i2));
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static TypeAlias parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return TypeAlias.newBuilder();
        }

        public static Builder newBuilder(TypeAlias prototype) {
            return TypeAlias.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return TypeAlias.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<TypeAlias>(){

                @Override
                public TypeAlias parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new TypeAlias(input, extensionRegistry);
                }
            };
            defaultInstance = new TypeAlias(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder>
        implements ProtoBuf$TypeAliasOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private int name_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type underlyingType_ = Type.getDefaultInstance();
            private int underlyingTypeId_;
            private Type expandedType_ = Type.getDefaultInstance();
            private int expandedTypeId_;
            private List<Annotation> annotation_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private List<CompilerPluginData> compilerPluginData_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override
            public TypeAlias build() {
                TypeAlias result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public TypeAlias buildPartial() {
                TypeAlias result = new TypeAlias(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.name_ = this.name_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 4;
                }
                result.underlyingType_ = this.underlyingType_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 8;
                }
                result.underlyingTypeId_ = this.underlyingTypeId_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x10;
                }
                result.expandedType_ = this.expandedType_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result.expandedTypeId_ = this.expandedTypeId_;
                if ((this.bitField0_ & 0x80) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFFFFF7F;
                }
                result.annotation_ = this.annotation_;
                if ((this.bitField0_ & 0x100) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                result.versionRequirement_ = this.versionRequirement_;
                if ((this.bitField0_ & 0x200) == 512) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                    this.bitField0_ &= 0xFFFFFDFF;
                }
                result.compilerPluginData_ = this.compilerPluginData_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(TypeAlias other) {
                if (other == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (other.hasUnderlyingType()) {
                    this.mergeUnderlyingType(other.getUnderlyingType());
                }
                if (other.hasUnderlyingTypeId()) {
                    this.setUnderlyingTypeId(other.getUnderlyingTypeId());
                }
                if (other.hasExpandedType()) {
                    this.mergeExpandedType(other.getExpandedType());
                }
                if (other.hasExpandedTypeId()) {
                    this.setExpandedTypeId(other.getExpandedTypeId());
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFFFFF7F;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                if (!other.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = other.versionRequirement_;
                        this.bitField0_ &= 0xFFFFFEFF;
                    } else {
                        this.ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(other.versionRequirement_);
                    }
                }
                if (!other.compilerPluginData_.isEmpty()) {
                    if (this.compilerPluginData_.isEmpty()) {
                        this.compilerPluginData_ = other.compilerPluginData_;
                        this.bitField0_ &= 0xFFFFFDFF;
                    } else {
                        this.ensureCompilerPluginDataIsMutable();
                        this.compilerPluginData_.addAll(other.compilerPluginData_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i2;
                if (!this.hasName()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                    if (this.getTypeParameter(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasUnderlyingType() && !this.getUnderlyingType().isInitialized()) {
                    return false;
                }
                if (this.hasExpandedType() && !this.getExpandedType().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                    if (this.getAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                    if (this.getCompilerPluginData(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TypeAlias parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (TypeAlias)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 2;
                this.name_ = value;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 4;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            public boolean hasUnderlyingType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public Builder mergeUnderlyingType(Type value) {
                this.underlyingType_ = (this.bitField0_ & 8) == 8 && this.underlyingType_ != Type.getDefaultInstance() ? Type.newBuilder(this.underlyingType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setUnderlyingTypeId(int value) {
                this.bitField0_ |= 0x10;
                this.underlyingTypeId_ = value;
                return this;
            }

            public boolean hasExpandedType() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public Builder mergeExpandedType(Type value) {
                this.expandedType_ = (this.bitField0_ & 0x20) == 32 && this.expandedType_ != Type.getDefaultInstance() ? Type.newBuilder(this.expandedType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x20;
                return this;
            }

            public Builder setExpandedTypeId(int value) {
                this.bitField0_ |= 0x40;
                this.expandedTypeId_ = value;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 0x80) != 128) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 0x80;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.versionRequirement_ = new ArrayList<Integer>(this.versionRequirement_);
                    this.bitField0_ |= 0x100;
                }
            }

            private void ensureCompilerPluginDataIsMutable() {
                if ((this.bitField0_ & 0x200) != 512) {
                    this.compilerPluginData_ = new ArrayList<CompilerPluginData>(this.compilerPluginData_);
                    this.bitField0_ |= 0x200;
                }
            }

            public int getCompilerPluginDataCount() {
                return this.compilerPluginData_.size();
            }

            public CompilerPluginData getCompilerPluginData(int index) {
                return this.compilerPluginData_.get(index);
            }
        }
    }

    public static final class ValueParameter
    extends GeneratedMessageLite.ExtendableMessage<ValueParameter>
    implements ProtoBuf$ValueParameterOrBuilder {
        private static final ValueParameter defaultInstance;
        private final ByteString unknownFields;
        public static Parser<ValueParameter> PARSER;
        private int bitField0_;
        private int flags_;
        private int name_;
        private Type type_;
        private int typeId_;
        private Type varargElementType_;
        private int varargElementTypeId_;
        private List<Annotation> annotation_;
        private Annotation.Argument.Value annotationParameterDefaultValue_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private ValueParameter(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private ValueParameter(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block26: while (!done) {
                    GeneratedMessageLite.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block26;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block26;
                            done = true;
                            continue block26;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block26;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.name_ = input.readInt32();
                            continue block26;
                        }
                        case 26: {
                            subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.type_.toBuilder();
                            }
                            this.type_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((Type.Builder)subBuilder).mergeFrom(this.type_);
                                this.type_ = ((Type.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block26;
                        }
                        case 34: {
                            subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) {
                                subBuilder = this.varargElementType_.toBuilder();
                            }
                            this.varargElementType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((Type.Builder)subBuilder).mergeFrom(this.varargElementType_);
                                this.varargElementType_ = ((Type.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 0x10;
                            continue block26;
                        }
                        case 40: {
                            this.bitField0_ |= 8;
                            this.typeId_ = input.readInt32();
                            continue block26;
                        }
                        case 48: {
                            this.bitField0_ |= 0x20;
                            this.varargElementTypeId_ = input.readInt32();
                            continue block26;
                        }
                        case 58: {
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.annotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block26;
                        }
                        case 66: 
                    }
                    subBuilder = null;
                    if ((this.bitField0_ & 0x40) == 64) {
                        subBuilder = this.annotationParameterDefaultValue_.toBuilder();
                    }
                    this.annotationParameterDefaultValue_ = input.readMessage(Annotation.Argument.Value.PARSER, extensionRegistry);
                    if (subBuilder != null) {
                        ((Annotation.Argument.Value.Builder)subBuilder).mergeFrom(this.annotationParameterDefaultValue_);
                        this.annotationParameterDefaultValue_ = ((Annotation.Argument.Value.Builder)subBuilder).buildPartial();
                    }
                    this.bitField0_ |= 0x40;
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x40) == 64) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type getType() {
            return this.type_;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        public boolean hasAnnotationParameterDefaultValue() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public Annotation.Argument.Value getAnnotationParameterDefaultValue() {
            return this.annotationParameterDefaultValue_;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.annotationParameterDefaultValue_ = Annotation.Argument.Value.getDefaultInstance();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasType() && !this.getType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasVarargElementType() && !this.getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                if (this.getAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasAnnotationParameterDefaultValue() && !this.getAnnotationParameterDefaultValue().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(3, this.type_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeMessage(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(5, this.typeId_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.varargElementTypeId_);
            }
            for (int i2 = 0; i2 < this.annotation_.size(); ++i2) {
                output.writeMessage(7, this.annotation_.get(i2));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeMessage(8, this.annotationParameterDefaultValue_);
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(3, this.type_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(5, this.typeId_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
            }
            for (int i2 = 0; i2 < this.annotation_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(7, this.annotation_.get(i2));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeMessageSize(8, this.annotationParameterDefaultValue_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return ValueParameter.newBuilder();
        }

        public static Builder newBuilder(ValueParameter prototype) {
            return ValueParameter.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return ValueParameter.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<ValueParameter>(){

                @Override
                public ValueParameter parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new ValueParameter(input, extensionRegistry);
                }
            };
            defaultInstance = new ValueParameter(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder>
        implements ProtoBuf$ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private Type type_ = Type.getDefaultInstance();
            private int typeId_;
            private Type varargElementType_ = Type.getDefaultInstance();
            private int varargElementTypeId_;
            private List<Annotation> annotation_ = Collections.emptyList();
            private Annotation.Argument.Value annotationParameterDefaultValue_ = Annotation.Argument.Value.getDefaultInstance();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override
            public ValueParameter build() {
                ValueParameter result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public ValueParameter buildPartial() {
                ValueParameter result = new ValueParameter(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.typeId_ = this.typeId_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.varargElementType_ = this.varargElementType_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.varargElementTypeId_ = this.varargElementTypeId_;
                if ((this.bitField0_ & 0x40) == 64) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFFFFFBF;
                }
                result.annotation_ = this.annotation_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x40;
                }
                result.annotationParameterDefaultValue_ = this.annotationParameterDefaultValue_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(ValueParameter other) {
                if (other == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasType()) {
                    this.mergeType(other.getType());
                }
                if (other.hasTypeId()) {
                    this.setTypeId(other.getTypeId());
                }
                if (other.hasVarargElementType()) {
                    this.mergeVarargElementType(other.getVarargElementType());
                }
                if (other.hasVarargElementTypeId()) {
                    this.setVarargElementTypeId(other.getVarargElementTypeId());
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFFFFFBF;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                if (other.hasAnnotationParameterDefaultValue()) {
                    this.mergeAnnotationParameterDefaultValue(other.getAnnotationParameterDefaultValue());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasName()) {
                    return false;
                }
                if (this.hasType() && !this.getType().isInitialized()) {
                    return false;
                }
                if (this.hasVarargElementType() && !this.getVarargElementType().isInitialized()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                    if (this.getAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasAnnotationParameterDefaultValue() && !this.getAnnotationParameterDefaultValue().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ValueParameter parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (ValueParameter)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 2;
                this.name_ = value;
                return this;
            }

            public boolean hasType() {
                return (this.bitField0_ & 4) == 4;
            }

            public Type getType() {
                return this.type_;
            }

            public Builder setType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeType(Type value) {
                this.type_ = (this.bitField0_ & 4) == 4 && this.type_ != Type.getDefaultInstance() ? Type.newBuilder(this.type_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setTypeId(int value) {
                this.bitField0_ |= 8;
                this.typeId_ = value;
                return this;
            }

            public boolean hasVarargElementType() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public Builder setVarargElementType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.varargElementType_ = value;
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder mergeVarargElementType(Type value) {
                this.varargElementType_ = (this.bitField0_ & 0x10) == 16 && this.varargElementType_ != Type.getDefaultInstance() ? Type.newBuilder(this.varargElementType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder setVarargElementTypeId(int value) {
                this.bitField0_ |= 0x20;
                this.varargElementTypeId_ = value;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 0x40;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> values) {
                this.ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.annotation_);
                return this;
            }

            public boolean hasAnnotationParameterDefaultValue() {
                return (this.bitField0_ & 0x80) == 128;
            }

            public Annotation.Argument.Value getAnnotationParameterDefaultValue() {
                return this.annotationParameterDefaultValue_;
            }

            public Builder setAnnotationParameterDefaultValue(Annotation.Argument.Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.annotationParameterDefaultValue_ = value;
                this.bitField0_ |= 0x80;
                return this;
            }

            public Builder mergeAnnotationParameterDefaultValue(Annotation.Argument.Value value) {
                this.annotationParameterDefaultValue_ = (this.bitField0_ & 0x80) == 128 && this.annotationParameterDefaultValue_ != Annotation.Argument.Value.getDefaultInstance() ? Annotation.Argument.Value.newBuilder(this.annotationParameterDefaultValue_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x80;
                return this;
            }
        }
    }

    public static final class Property
    extends GeneratedMessageLite.ExtendableMessage<Property>
    implements ProtoBuf$PropertyOrBuilder {
        private static final Property defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Property> PARSER;
        private int bitField0_;
        private int flags_;
        private int oldFlags_;
        private int name_;
        private Type returnType_;
        private int returnTypeId_;
        private List<TypeParameter> typeParameter_;
        private Type receiverType_;
        private int receiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<Integer> contextReceiverTypeId_;
        private int contextReceiverTypeIdMemoizedSerializedSize = -1;
        private List<ValueParameter> contextParameter_;
        private ValueParameter setterValueParameter_;
        private int getterFlags_;
        private int setterFlags_;
        private List<Integer> versionRequirement_;
        private List<CompilerPluginData> compilerPluginData_;
        private List<Annotation> annotation_;
        private List<Annotation> getterAnnotation_;
        private List<Annotation> setterAnnotation_;
        private List<Annotation> extensionReceiverAnnotation_;
        private List<Annotation> backingFieldAnnotation_;
        private List<Annotation> delegateFieldAnnotation_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Property(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Property(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block42: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block42;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block42;
                            done = true;
                            continue block42;
                        }
                        case 8: {
                            this.bitField0_ |= 2;
                            this.oldFlags_ = input.readInt32();
                            continue block42;
                        }
                        case 16: {
                            this.bitField0_ |= 4;
                            this.name_ = input.readInt32();
                            continue block42;
                        }
                        case 26: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 8) == 8) {
                                subBuilder = this.returnType_.toBuilder();
                            }
                            this.returnType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.returnType_);
                                this.returnType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue block42;
                        }
                        case 34: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 42: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x20) == 32) {
                                subBuilder = this.receiverType_.toBuilder();
                            }
                            this.receiverType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.receiverType_);
                                this.receiverType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x20;
                            continue block42;
                        }
                        case 50: {
                            ValueParameter.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x80) == 128) {
                                subBuilder = this.setterValueParameter_.toBuilder();
                            }
                            this.setterValueParameter_ = input.readMessage(ValueParameter.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.setterValueParameter_);
                                this.setterValueParameter_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x80;
                            continue block42;
                        }
                        case 56: {
                            this.bitField0_ |= 0x100;
                            this.getterFlags_ = input.readInt32();
                            continue block42;
                        }
                        case 64: {
                            this.bitField0_ |= 0x200;
                            this.setterFlags_ = input.readInt32();
                            continue block42;
                        }
                        case 72: {
                            this.bitField0_ |= 0x10;
                            this.returnTypeId_ = input.readInt32();
                            continue block42;
                        }
                        case 80: {
                            this.bitField0_ |= 0x40;
                            this.receiverTypeId_ = input.readInt32();
                            continue block42;
                        }
                        case 88: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block42;
                        }
                        case 98: {
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.contextReceiverType_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.contextReceiverType_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 104: {
                            if ((mutable_bitField0_ & 0x200) != 512) {
                                this.contextReceiverTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x200;
                            }
                            this.contextReceiverTypeId_.add(input.readInt32());
                            continue block42;
                        }
                        case 106: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x200) != 512 && input.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x200;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block42;
                        }
                        case 114: {
                            if ((mutable_bitField0_ & 0x10000) != 65536) {
                                this.annotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x10000;
                            }
                            this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 122: {
                            if ((mutable_bitField0_ & 0x20000) != 131072) {
                                this.getterAnnotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x20000;
                            }
                            this.getterAnnotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 130: {
                            if ((mutable_bitField0_ & 0x40000) != 262144) {
                                this.setterAnnotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x40000;
                            }
                            this.setterAnnotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 138: {
                            if ((mutable_bitField0_ & 0x400) != 1024) {
                                this.contextParameter_ = new ArrayList<ValueParameter>();
                                mutable_bitField0_ |= 0x400;
                            }
                            this.contextParameter_.add(input.readMessage(ValueParameter.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 248: {
                            if ((mutable_bitField0_ & 0x4000) != 16384) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x4000;
                            }
                            this.versionRequirement_.add(input.readInt32());
                            continue block42;
                        }
                        case 250: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x4000) != 16384 && input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x4000;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block42;
                        }
                        case 258: {
                            if ((mutable_bitField0_ & 0x8000) != 32768) {
                                this.compilerPluginData_ = new ArrayList<CompilerPluginData>();
                                mutable_bitField0_ |= 0x8000;
                            }
                            this.compilerPluginData_.add(input.readMessage(CompilerPluginData.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 266: {
                            if ((mutable_bitField0_ & 0x80000) != 524288) {
                                this.extensionReceiverAnnotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x80000;
                            }
                            this.extensionReceiverAnnotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 274: {
                            if ((mutable_bitField0_ & 0x100000) != 0x100000) {
                                this.backingFieldAnnotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x100000;
                            }
                            this.backingFieldAnnotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block42;
                        }
                        case 282: 
                    }
                    if ((mutable_bitField0_ & 0x200000) != 0x200000) {
                        this.delegateFieldAnnotation_ = new ArrayList<Annotation>();
                        mutable_bitField0_ |= 0x200000;
                    }
                    this.delegateFieldAnnotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((mutable_bitField0_ & 0x100) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if ((mutable_bitField0_ & 0x200) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if ((mutable_bitField0_ & 0x10000) == 65536) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((mutable_bitField0_ & 0x20000) == 131072) {
                    this.getterAnnotation_ = Collections.unmodifiableList(this.getterAnnotation_);
                }
                if ((mutable_bitField0_ & 0x40000) == 262144) {
                    this.setterAnnotation_ = Collections.unmodifiableList(this.setterAnnotation_);
                }
                if ((mutable_bitField0_ & 0x400) == 1024) {
                    this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                }
                if ((mutable_bitField0_ & 0x4000) == 16384) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if ((mutable_bitField0_ & 0x8000) == 32768) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                }
                if ((mutable_bitField0_ & 0x80000) == 524288) {
                    this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                }
                if ((mutable_bitField0_ & 0x100000) == 0x100000) {
                    this.backingFieldAnnotation_ = Collections.unmodifiableList(this.backingFieldAnnotation_);
                }
                if ((mutable_bitField0_ & 0x200000) == 0x200000) {
                    this.delegateFieldAnnotation_ = Collections.unmodifiableList(this.delegateFieldAnnotation_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int index) {
            return this.contextReceiverType_.get(index);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public int getContextParameterCount() {
            return this.contextParameter_.size();
        }

        public ValueParameter getContextParameter(int index) {
            return this.contextParameter_.get(index);
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public boolean hasGetterFlags() {
            return (this.bitField0_ & 0x100) == 256;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public boolean hasSetterFlags() {
            return (this.bitField0_ & 0x200) == 512;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public CompilerPluginData getCompilerPluginData(int index) {
            return this.compilerPluginData_.get(index);
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        public List<Annotation> getGetterAnnotationList() {
            return this.getterAnnotation_;
        }

        public int getGetterAnnotationCount() {
            return this.getterAnnotation_.size();
        }

        public Annotation getGetterAnnotation(int index) {
            return this.getterAnnotation_.get(index);
        }

        public List<Annotation> getSetterAnnotationList() {
            return this.setterAnnotation_;
        }

        public int getSetterAnnotationCount() {
            return this.setterAnnotation_.size();
        }

        public Annotation getSetterAnnotation(int index) {
            return this.setterAnnotation_.get(index);
        }

        public List<Annotation> getExtensionReceiverAnnotationList() {
            return this.extensionReceiverAnnotation_;
        }

        public int getExtensionReceiverAnnotationCount() {
            return this.extensionReceiverAnnotation_.size();
        }

        public Annotation getExtensionReceiverAnnotation(int index) {
            return this.extensionReceiverAnnotation_.get(index);
        }

        public List<Annotation> getBackingFieldAnnotationList() {
            return this.backingFieldAnnotation_;
        }

        public int getBackingFieldAnnotationCount() {
            return this.backingFieldAnnotation_.size();
        }

        public Annotation getBackingFieldAnnotation(int index) {
            return this.backingFieldAnnotation_.get(index);
        }

        public List<Annotation> getDelegateFieldAnnotationList() {
            return this.delegateFieldAnnotation_;
        }

        public int getDelegateFieldAnnotationCount() {
            return this.delegateFieldAnnotation_.size();
        }

        public Annotation getDelegateFieldAnnotation(int index) {
            return this.delegateFieldAnnotation_.get(index);
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.contextParameter_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
            this.compilerPluginData_ = Collections.emptyList();
            this.annotation_ = Collections.emptyList();
            this.getterAnnotation_ = Collections.emptyList();
            this.setterAnnotation_ = Collections.emptyList();
            this.extensionReceiverAnnotation_ = Collections.emptyList();
            this.backingFieldAnnotation_ = Collections.emptyList();
            this.delegateFieldAnnotation_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            int i2;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                if (this.getTypeParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getContextReceiverTypeCount(); ++i2) {
                if (this.getContextReceiverType(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getContextParameterCount(); ++i2) {
                if (this.getContextParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasSetterValueParameter() && !this.getSetterValueParameter().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                if (this.getCompilerPluginData(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                if (this.getAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getGetterAnnotationCount(); ++i2) {
                if (this.getGetterAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getSetterAnnotationCount(); ++i2) {
                if (this.getSetterAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getExtensionReceiverAnnotationCount(); ++i2) {
                if (this.getExtensionReceiverAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getBackingFieldAnnotationCount(); ++i2) {
                if (this.getBackingFieldAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getDelegateFieldAnnotationCount(); ++i2) {
                if (this.getDelegateFieldAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(3, this.returnType_);
            }
            for (i2 = 0; i2 < this.typeParameter_.size(); ++i2) {
                output.writeMessage(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeMessage(5, this.receiverType_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeMessage(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(11, this.flags_);
            }
            for (i2 = 0; i2 < this.contextReceiverType_.size(); ++i2) {
                output.writeMessage(12, this.contextReceiverType_.get(i2));
            }
            if (this.getContextReceiverTypeIdList().size() > 0) {
                output.writeRawVarint32(106);
                output.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.contextReceiverTypeId_.size(); ++i2) {
                output.writeInt32NoTag(this.contextReceiverTypeId_.get(i2));
            }
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                output.writeMessage(14, this.annotation_.get(i2));
            }
            for (i2 = 0; i2 < this.getterAnnotation_.size(); ++i2) {
                output.writeMessage(15, this.getterAnnotation_.get(i2));
            }
            for (i2 = 0; i2 < this.setterAnnotation_.size(); ++i2) {
                output.writeMessage(16, this.setterAnnotation_.get(i2));
            }
            for (i2 = 0; i2 < this.contextParameter_.size(); ++i2) {
                output.writeMessage(17, this.contextParameter_.get(i2));
            }
            for (i2 = 0; i2 < this.versionRequirement_.size(); ++i2) {
                output.writeInt32(31, this.versionRequirement_.get(i2));
            }
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                output.writeMessage(32, this.compilerPluginData_.get(i2));
            }
            for (i2 = 0; i2 < this.extensionReceiverAnnotation_.size(); ++i2) {
                output.writeMessage(33, this.extensionReceiverAnnotation_.get(i2));
            }
            for (i2 = 0; i2 < this.backingFieldAnnotation_.size(); ++i2) {
                output.writeMessage(34, this.backingFieldAnnotation_.get(i2));
            }
            for (i2 = 0; i2 < this.delegateFieldAnnotation_.size(); ++i2) {
                output.writeMessage(35, this.delegateFieldAnnotation_.get(i2));
            }
            extensionWriter.writeUntil(19000, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i2;
            int i3;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (i3 = 0; i3 < this.typeParameter_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(11, this.flags_);
            }
            for (i3 = 0; i3 < this.contextReceiverType_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(i3));
            }
            int dataSize = 0;
            for (i2 = 0; i2 < this.contextReceiverTypeId_.size(); ++i2) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i2));
            }
            size += dataSize;
            if (!this.getContextReceiverTypeIdList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = dataSize;
            for (i3 = 0; i3 < this.annotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(14, this.annotation_.get(i3));
            }
            for (i3 = 0; i3 < this.getterAnnotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(15, this.getterAnnotation_.get(i3));
            }
            for (i3 = 0; i3 < this.setterAnnotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(16, this.setterAnnotation_.get(i3));
            }
            for (i3 = 0; i3 < this.contextParameter_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(17, this.contextParameter_.get(i3));
            }
            dataSize = 0;
            for (i2 = 0; i2 < this.versionRequirement_.size(); ++i2) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i2));
            }
            size += dataSize;
            size += 2 * this.getVersionRequirementList().size();
            for (i3 = 0; i3 < this.compilerPluginData_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(32, this.compilerPluginData_.get(i3));
            }
            for (i3 = 0; i3 < this.extensionReceiverAnnotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(33, this.extensionReceiverAnnotation_.get(i3));
            }
            for (i3 = 0; i3 < this.backingFieldAnnotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(34, this.backingFieldAnnotation_.get(i3));
            }
            for (i3 = 0; i3 < this.delegateFieldAnnotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(35, this.delegateFieldAnnotation_.get(i3));
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Property.newBuilder();
        }

        public static Builder newBuilder(Property prototype) {
            return Property.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Property.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Property>(){

                @Override
                public Property parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Property(input, extensionRegistry);
                }
            };
            defaultInstance = new Property(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Property, Builder>
        implements ProtoBuf$PropertyOrBuilder {
            private int bitField0_;
            private int flags_ = 518;
            private int oldFlags_ = 2054;
            private int name_;
            private Type returnType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private int receiverTypeId_;
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<ValueParameter> contextParameter_ = Collections.emptyList();
            private ValueParameter setterValueParameter_ = ValueParameter.getDefaultInstance();
            private int getterFlags_;
            private int setterFlags_;
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private List<CompilerPluginData> compilerPluginData_ = Collections.emptyList();
            private List<Annotation> annotation_ = Collections.emptyList();
            private List<Annotation> getterAnnotation_ = Collections.emptyList();
            private List<Annotation> setterAnnotation_ = Collections.emptyList();
            private List<Annotation> extensionReceiverAnnotation_ = Collections.emptyList();
            private List<Annotation> backingFieldAnnotation_ = Collections.emptyList();
            private List<Annotation> delegateFieldAnnotation_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override
            public Property build() {
                Property result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Property buildPartial() {
                Property result = new Property(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.oldFlags_ = this.oldFlags_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.returnType_ = this.returnType_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result.receiverType_ = this.receiverType_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x40;
                }
                result.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 0x100) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                result.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 0x200) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= 0xFFFFFDFF;
                }
                result.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 0x400) == 1024) {
                    this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                    this.bitField0_ &= 0xFFFFFBFF;
                }
                result.contextParameter_ = this.contextParameter_;
                if ((from_bitField0_ & 0x800) == 2048) {
                    to_bitField0_ |= 0x80;
                }
                result.setterValueParameter_ = this.setterValueParameter_;
                if ((from_bitField0_ & 0x1000) == 4096) {
                    to_bitField0_ |= 0x100;
                }
                result.getterFlags_ = this.getterFlags_;
                if ((from_bitField0_ & 0x2000) == 8192) {
                    to_bitField0_ |= 0x200;
                }
                result.setterFlags_ = this.setterFlags_;
                if ((this.bitField0_ & 0x4000) == 16384) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= 0xFFFFBFFF;
                }
                result.versionRequirement_ = this.versionRequirement_;
                if ((this.bitField0_ & 0x8000) == 32768) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                    this.bitField0_ &= 0xFFFF7FFF;
                }
                result.compilerPluginData_ = this.compilerPluginData_;
                if ((this.bitField0_ & 0x10000) == 65536) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFFEFFFF;
                }
                result.annotation_ = this.annotation_;
                if ((this.bitField0_ & 0x20000) == 131072) {
                    this.getterAnnotation_ = Collections.unmodifiableList(this.getterAnnotation_);
                    this.bitField0_ &= 0xFFFDFFFF;
                }
                result.getterAnnotation_ = this.getterAnnotation_;
                if ((this.bitField0_ & 0x40000) == 262144) {
                    this.setterAnnotation_ = Collections.unmodifiableList(this.setterAnnotation_);
                    this.bitField0_ &= 0xFFFBFFFF;
                }
                result.setterAnnotation_ = this.setterAnnotation_;
                if ((this.bitField0_ & 0x80000) == 524288) {
                    this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                    this.bitField0_ &= 0xFFF7FFFF;
                }
                result.extensionReceiverAnnotation_ = this.extensionReceiverAnnotation_;
                if ((this.bitField0_ & 0x100000) == 0x100000) {
                    this.backingFieldAnnotation_ = Collections.unmodifiableList(this.backingFieldAnnotation_);
                    this.bitField0_ &= 0xFFEFFFFF;
                }
                result.backingFieldAnnotation_ = this.backingFieldAnnotation_;
                if ((this.bitField0_ & 0x200000) == 0x200000) {
                    this.delegateFieldAnnotation_ = Collections.unmodifiableList(this.delegateFieldAnnotation_);
                    this.bitField0_ &= 0xFFDFFFFF;
                }
                result.delegateFieldAnnotation_ = this.delegateFieldAnnotation_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Property other) {
                if (other == Property.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasOldFlags()) {
                    this.setOldFlags(other.getOldFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasReturnType()) {
                    this.mergeReturnType(other.getReturnType());
                }
                if (other.hasReturnTypeId()) {
                    this.setReturnTypeId(other.getReturnTypeId());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (other.hasReceiverType()) {
                    this.mergeReceiverType(other.getReceiverType());
                }
                if (other.hasReceiverTypeId()) {
                    this.setReceiverTypeId(other.getReceiverTypeId());
                }
                if (!other.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = other.contextReceiverType_;
                        this.bitField0_ &= 0xFFFFFEFF;
                    } else {
                        this.ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(other.contextReceiverType_);
                    }
                }
                if (!other.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = other.contextReceiverTypeId_;
                        this.bitField0_ &= 0xFFFFFDFF;
                    } else {
                        this.ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(other.contextReceiverTypeId_);
                    }
                }
                if (!other.contextParameter_.isEmpty()) {
                    if (this.contextParameter_.isEmpty()) {
                        this.contextParameter_ = other.contextParameter_;
                        this.bitField0_ &= 0xFFFFFBFF;
                    } else {
                        this.ensureContextParameterIsMutable();
                        this.contextParameter_.addAll(other.contextParameter_);
                    }
                }
                if (other.hasSetterValueParameter()) {
                    this.mergeSetterValueParameter(other.getSetterValueParameter());
                }
                if (other.hasGetterFlags()) {
                    this.setGetterFlags(other.getGetterFlags());
                }
                if (other.hasSetterFlags()) {
                    this.setSetterFlags(other.getSetterFlags());
                }
                if (!other.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = other.versionRequirement_;
                        this.bitField0_ &= 0xFFFFBFFF;
                    } else {
                        this.ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(other.versionRequirement_);
                    }
                }
                if (!other.compilerPluginData_.isEmpty()) {
                    if (this.compilerPluginData_.isEmpty()) {
                        this.compilerPluginData_ = other.compilerPluginData_;
                        this.bitField0_ &= 0xFFFF7FFF;
                    } else {
                        this.ensureCompilerPluginDataIsMutable();
                        this.compilerPluginData_.addAll(other.compilerPluginData_);
                    }
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFFEFFFF;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                if (!other.getterAnnotation_.isEmpty()) {
                    if (this.getterAnnotation_.isEmpty()) {
                        this.getterAnnotation_ = other.getterAnnotation_;
                        this.bitField0_ &= 0xFFFDFFFF;
                    } else {
                        this.ensureGetterAnnotationIsMutable();
                        this.getterAnnotation_.addAll(other.getterAnnotation_);
                    }
                }
                if (!other.setterAnnotation_.isEmpty()) {
                    if (this.setterAnnotation_.isEmpty()) {
                        this.setterAnnotation_ = other.setterAnnotation_;
                        this.bitField0_ &= 0xFFFBFFFF;
                    } else {
                        this.ensureSetterAnnotationIsMutable();
                        this.setterAnnotation_.addAll(other.setterAnnotation_);
                    }
                }
                if (!other.extensionReceiverAnnotation_.isEmpty()) {
                    if (this.extensionReceiverAnnotation_.isEmpty()) {
                        this.extensionReceiverAnnotation_ = other.extensionReceiverAnnotation_;
                        this.bitField0_ &= 0xFFF7FFFF;
                    } else {
                        this.ensureExtensionReceiverAnnotationIsMutable();
                        this.extensionReceiverAnnotation_.addAll(other.extensionReceiverAnnotation_);
                    }
                }
                if (!other.backingFieldAnnotation_.isEmpty()) {
                    if (this.backingFieldAnnotation_.isEmpty()) {
                        this.backingFieldAnnotation_ = other.backingFieldAnnotation_;
                        this.bitField0_ &= 0xFFEFFFFF;
                    } else {
                        this.ensureBackingFieldAnnotationIsMutable();
                        this.backingFieldAnnotation_.addAll(other.backingFieldAnnotation_);
                    }
                }
                if (!other.delegateFieldAnnotation_.isEmpty()) {
                    if (this.delegateFieldAnnotation_.isEmpty()) {
                        this.delegateFieldAnnotation_ = other.delegateFieldAnnotation_;
                        this.bitField0_ &= 0xFFDFFFFF;
                    } else {
                        this.ensureDelegateFieldAnnotationIsMutable();
                        this.delegateFieldAnnotation_.addAll(other.delegateFieldAnnotation_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i2;
                if (!this.hasName()) {
                    return false;
                }
                if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                    if (this.getTypeParameter(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getContextReceiverTypeCount(); ++i2) {
                    if (this.getContextReceiverType(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getContextParameterCount(); ++i2) {
                    if (this.getContextParameter(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasSetterValueParameter() && !this.getSetterValueParameter().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                    if (this.getCompilerPluginData(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                    if (this.getAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getGetterAnnotationCount(); ++i2) {
                    if (this.getGetterAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getSetterAnnotationCount(); ++i2) {
                    if (this.getSetterAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getExtensionReceiverAnnotationCount(); ++i2) {
                    if (this.getExtensionReceiverAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getBackingFieldAnnotationCount(); ++i2) {
                    if (this.getBackingFieldAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getDelegateFieldAnnotationCount(); ++i2) {
                    if (this.getDelegateFieldAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Property parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Property)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder setOldFlags(int value) {
                this.bitField0_ |= 2;
                this.oldFlags_ = value;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 4;
                this.name_ = value;
                return this;
            }

            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder setReturnType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.returnType_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeReturnType(Type value) {
                this.returnType_ = (this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance() ? Type.newBuilder(this.returnType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnTypeId(int value) {
                this.bitField0_ |= 0x10;
                this.returnTypeId_ = value;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 0x20;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            public Builder addTypeParameter(TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(value);
                return this;
            }

            public boolean hasReceiverType() {
                return (this.bitField0_ & 0x40) == 64;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder setReceiverType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.receiverType_ = value;
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder mergeReceiverType(Type value) {
                this.receiverType_ = (this.bitField0_ & 0x40) == 64 && this.receiverType_ != Type.getDefaultInstance() ? Type.newBuilder(this.receiverType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder setReceiverTypeId(int value) {
                this.bitField0_ |= 0x80;
                this.receiverTypeId_ = value;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.contextReceiverType_ = new ArrayList<Type>(this.contextReceiverType_);
                    this.bitField0_ |= 0x100;
                }
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int index) {
                return this.contextReceiverType_.get(index);
            }

            public Builder addAllContextReceiverType(Iterable<? extends Type> values) {
                this.ensureContextReceiverTypeIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.contextReceiverType_);
                return this;
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 0x200) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList<Integer>(this.contextReceiverTypeId_);
                    this.bitField0_ |= 0x200;
                }
            }

            private void ensureContextParameterIsMutable() {
                if ((this.bitField0_ & 0x400) != 1024) {
                    this.contextParameter_ = new ArrayList<ValueParameter>(this.contextParameter_);
                    this.bitField0_ |= 0x400;
                }
            }

            public int getContextParameterCount() {
                return this.contextParameter_.size();
            }

            public ValueParameter getContextParameter(int index) {
                return this.contextParameter_.get(index);
            }

            public boolean hasSetterValueParameter() {
                return (this.bitField0_ & 0x800) == 2048;
            }

            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public Builder setSetterValueParameter(ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.setterValueParameter_ = value;
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder mergeSetterValueParameter(ValueParameter value) {
                this.setterValueParameter_ = (this.bitField0_ & 0x800) == 2048 && this.setterValueParameter_ != ValueParameter.getDefaultInstance() ? ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder setGetterFlags(int value) {
                this.bitField0_ |= 0x1000;
                this.getterFlags_ = value;
                return this;
            }

            public Builder setSetterFlags(int value) {
                this.bitField0_ |= 0x2000;
                this.setterFlags_ = value;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 0x4000) != 16384) {
                    this.versionRequirement_ = new ArrayList<Integer>(this.versionRequirement_);
                    this.bitField0_ |= 0x4000;
                }
            }

            public Builder addAllVersionRequirement(Iterable<? extends Integer> values) {
                this.ensureVersionRequirementIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.versionRequirement_);
                return this;
            }

            private void ensureCompilerPluginDataIsMutable() {
                if ((this.bitField0_ & 0x8000) != 32768) {
                    this.compilerPluginData_ = new ArrayList<CompilerPluginData>(this.compilerPluginData_);
                    this.bitField0_ |= 0x8000;
                }
            }

            public int getCompilerPluginDataCount() {
                return this.compilerPluginData_.size();
            }

            public CompilerPluginData getCompilerPluginData(int index) {
                return this.compilerPluginData_.get(index);
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 0x10000) != 65536) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 0x10000;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> values) {
                this.ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.annotation_);
                return this;
            }

            private void ensureGetterAnnotationIsMutable() {
                if ((this.bitField0_ & 0x20000) != 131072) {
                    this.getterAnnotation_ = new ArrayList<Annotation>(this.getterAnnotation_);
                    this.bitField0_ |= 0x20000;
                }
            }

            public int getGetterAnnotationCount() {
                return this.getterAnnotation_.size();
            }

            public Annotation getGetterAnnotation(int index) {
                return this.getterAnnotation_.get(index);
            }

            public Builder addAllGetterAnnotation(Iterable<? extends Annotation> values) {
                this.ensureGetterAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.getterAnnotation_);
                return this;
            }

            private void ensureSetterAnnotationIsMutable() {
                if ((this.bitField0_ & 0x40000) != 262144) {
                    this.setterAnnotation_ = new ArrayList<Annotation>(this.setterAnnotation_);
                    this.bitField0_ |= 0x40000;
                }
            }

            public int getSetterAnnotationCount() {
                return this.setterAnnotation_.size();
            }

            public Annotation getSetterAnnotation(int index) {
                return this.setterAnnotation_.get(index);
            }

            public Builder addAllSetterAnnotation(Iterable<? extends Annotation> values) {
                this.ensureSetterAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.setterAnnotation_);
                return this;
            }

            private void ensureExtensionReceiverAnnotationIsMutable() {
                if ((this.bitField0_ & 0x80000) != 524288) {
                    this.extensionReceiverAnnotation_ = new ArrayList<Annotation>(this.extensionReceiverAnnotation_);
                    this.bitField0_ |= 0x80000;
                }
            }

            public int getExtensionReceiverAnnotationCount() {
                return this.extensionReceiverAnnotation_.size();
            }

            public Annotation getExtensionReceiverAnnotation(int index) {
                return this.extensionReceiverAnnotation_.get(index);
            }

            public Builder addAllExtensionReceiverAnnotation(Iterable<? extends Annotation> values) {
                this.ensureExtensionReceiverAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.extensionReceiverAnnotation_);
                return this;
            }

            private void ensureBackingFieldAnnotationIsMutable() {
                if ((this.bitField0_ & 0x100000) != 0x100000) {
                    this.backingFieldAnnotation_ = new ArrayList<Annotation>(this.backingFieldAnnotation_);
                    this.bitField0_ |= 0x100000;
                }
            }

            public int getBackingFieldAnnotationCount() {
                return this.backingFieldAnnotation_.size();
            }

            public Annotation getBackingFieldAnnotation(int index) {
                return this.backingFieldAnnotation_.get(index);
            }

            public Builder addAllBackingFieldAnnotation(Iterable<? extends Annotation> values) {
                this.ensureBackingFieldAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.backingFieldAnnotation_);
                return this;
            }

            private void ensureDelegateFieldAnnotationIsMutable() {
                if ((this.bitField0_ & 0x200000) != 0x200000) {
                    this.delegateFieldAnnotation_ = new ArrayList<Annotation>(this.delegateFieldAnnotation_);
                    this.bitField0_ |= 0x200000;
                }
            }

            public int getDelegateFieldAnnotationCount() {
                return this.delegateFieldAnnotation_.size();
            }

            public Annotation getDelegateFieldAnnotation(int index) {
                return this.delegateFieldAnnotation_.get(index);
            }

            public Builder addAllDelegateFieldAnnotation(Iterable<? extends Annotation> values) {
                this.ensureDelegateFieldAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.delegateFieldAnnotation_);
                return this;
            }
        }
    }

    public static final class Function
    extends GeneratedMessageLite.ExtendableMessage<Function>
    implements ProtoBuf$FunctionOrBuilder {
        private static final Function defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Function> PARSER;
        private int bitField0_;
        private int flags_;
        private int oldFlags_;
        private int name_;
        private Type returnType_;
        private int returnTypeId_;
        private List<TypeParameter> typeParameter_;
        private Type receiverType_;
        private int receiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<Integer> contextReceiverTypeId_;
        private int contextReceiverTypeIdMemoizedSerializedSize = -1;
        private List<ValueParameter> contextParameter_;
        private List<ValueParameter> valueParameter_;
        private TypeTable typeTable_;
        private List<Integer> versionRequirement_;
        private Contract contract_;
        private List<CompilerPluginData> compilerPluginData_;
        private List<Annotation> annotation_;
        private List<Annotation> extensionReceiverAnnotation_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Function(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Function(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block38: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block38;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block38;
                            done = true;
                            continue block38;
                        }
                        case 8: {
                            this.bitField0_ |= 2;
                            this.oldFlags_ = input.readInt32();
                            continue block38;
                        }
                        case 16: {
                            this.bitField0_ |= 4;
                            this.name_ = input.readInt32();
                            continue block38;
                        }
                        case 26: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 8) == 8) {
                                subBuilder = this.returnType_.toBuilder();
                            }
                            this.returnType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.returnType_);
                                this.returnType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue block38;
                        }
                        case 34: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block38;
                        }
                        case 42: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x20) == 32) {
                                subBuilder = this.receiverType_.toBuilder();
                            }
                            this.receiverType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.receiverType_);
                                this.receiverType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x20;
                            continue block38;
                        }
                        case 50: {
                            if ((mutable_bitField0_ & 0x800) != 2048) {
                                this.valueParameter_ = new ArrayList<ValueParameter>();
                                mutable_bitField0_ |= 0x800;
                            }
                            this.valueParameter_.add(input.readMessage(ValueParameter.PARSER, extensionRegistry));
                            continue block38;
                        }
                        case 56: {
                            this.bitField0_ |= 0x10;
                            this.returnTypeId_ = input.readInt32();
                            continue block38;
                        }
                        case 64: {
                            this.bitField0_ |= 0x40;
                            this.receiverTypeId_ = input.readInt32();
                            continue block38;
                        }
                        case 72: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block38;
                        }
                        case 82: {
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.contextReceiverType_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.contextReceiverType_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block38;
                        }
                        case 88: {
                            if ((mutable_bitField0_ & 0x200) != 512) {
                                this.contextReceiverTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x200;
                            }
                            this.contextReceiverTypeId_.add(input.readInt32());
                            continue block38;
                        }
                        case 90: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x200) != 512 && input.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x200;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block38;
                        }
                        case 98: {
                            if ((mutable_bitField0_ & 0x10000) != 65536) {
                                this.annotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x10000;
                            }
                            this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block38;
                        }
                        case 106: {
                            if ((mutable_bitField0_ & 0x400) != 1024) {
                                this.contextParameter_ = new ArrayList<ValueParameter>();
                                mutable_bitField0_ |= 0x400;
                            }
                            this.contextParameter_.add(input.readMessage(ValueParameter.PARSER, extensionRegistry));
                            continue block38;
                        }
                        case 242: {
                            TypeTable.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x80) == 128) {
                                subBuilder = this.typeTable_.toBuilder();
                            }
                            this.typeTable_ = input.readMessage(TypeTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.typeTable_);
                                this.typeTable_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x80;
                            continue block38;
                        }
                        case 248: {
                            if ((mutable_bitField0_ & 0x2000) != 8192) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x2000;
                            }
                            this.versionRequirement_.add(input.readInt32());
                            continue block38;
                        }
                        case 250: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x2000) != 8192 && input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x2000;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block38;
                        }
                        case 258: {
                            Contract.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x100) == 256) {
                                subBuilder = this.contract_.toBuilder();
                            }
                            this.contract_ = input.readMessage(Contract.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.contract_);
                                this.contract_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x100;
                            continue block38;
                        }
                        case 266: {
                            if ((mutable_bitField0_ & 0x8000) != 32768) {
                                this.compilerPluginData_ = new ArrayList<CompilerPluginData>();
                                mutable_bitField0_ |= 0x8000;
                            }
                            this.compilerPluginData_.add(input.readMessage(CompilerPluginData.PARSER, extensionRegistry));
                            continue block38;
                        }
                        case 274: 
                    }
                    if ((mutable_bitField0_ & 0x20000) != 131072) {
                        this.extensionReceiverAnnotation_ = new ArrayList<Annotation>();
                        mutable_bitField0_ |= 0x20000;
                    }
                    this.extensionReceiverAnnotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((mutable_bitField0_ & 0x800) == 2048) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                }
                if ((mutable_bitField0_ & 0x100) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if ((mutable_bitField0_ & 0x200) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if ((mutable_bitField0_ & 0x10000) == 65536) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((mutable_bitField0_ & 0x400) == 1024) {
                    this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                }
                if ((mutable_bitField0_ & 0x2000) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if ((mutable_bitField0_ & 0x8000) == 32768) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                }
                if ((mutable_bitField0_ & 0x20000) == 131072) {
                    this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int index) {
            return this.contextReceiverType_.get(index);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public int getContextParameterCount() {
            return this.contextParameter_.size();
        }

        public ValueParameter getContextParameter(int index) {
            return this.contextParameter_.get(index);
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public ValueParameter getValueParameter(int index) {
            return this.valueParameter_.get(index);
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            return (this.bitField0_ & 0x100) == 256;
        }

        public Contract getContract() {
            return this.contract_;
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public CompilerPluginData getCompilerPluginData(int index) {
            return this.compilerPluginData_.get(index);
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        public List<Annotation> getExtensionReceiverAnnotationList() {
            return this.extensionReceiverAnnotation_;
        }

        public int getExtensionReceiverAnnotationCount() {
            return this.extensionReceiverAnnotation_.size();
        }

        public Annotation getExtensionReceiverAnnotation(int index) {
            return this.extensionReceiverAnnotation_.get(index);
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.contextParameter_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
            this.compilerPluginData_ = Collections.emptyList();
            this.annotation_ = Collections.emptyList();
            this.extensionReceiverAnnotation_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            int i2;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                if (this.getTypeParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getContextReceiverTypeCount(); ++i2) {
                if (this.getContextReceiverType(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getContextParameterCount(); ++i2) {
                if (this.getContextParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getValueParameterCount(); ++i2) {
                if (this.getValueParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasContract() && !this.getContract().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                if (this.getCompilerPluginData(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                if (this.getAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getExtensionReceiverAnnotationCount(); ++i2) {
                if (this.getExtensionReceiverAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(3, this.returnType_);
            }
            for (i2 = 0; i2 < this.typeParameter_.size(); ++i2) {
                output.writeMessage(4, this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeMessage(5, this.receiverType_);
            }
            for (i2 = 0; i2 < this.valueParameter_.size(); ++i2) {
                output.writeMessage(6, this.valueParameter_.get(i2));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(9, this.flags_);
            }
            for (i2 = 0; i2 < this.contextReceiverType_.size(); ++i2) {
                output.writeMessage(10, this.contextReceiverType_.get(i2));
            }
            if (this.getContextReceiverTypeIdList().size() > 0) {
                output.writeRawVarint32(90);
                output.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.contextReceiverTypeId_.size(); ++i2) {
                output.writeInt32NoTag(this.contextReceiverTypeId_.get(i2));
            }
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                output.writeMessage(12, this.annotation_.get(i2));
            }
            for (i2 = 0; i2 < this.contextParameter_.size(); ++i2) {
                output.writeMessage(13, this.contextParameter_.get(i2));
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeMessage(30, this.typeTable_);
            }
            for (i2 = 0; i2 < this.versionRequirement_.size(); ++i2) {
                output.writeInt32(31, this.versionRequirement_.get(i2));
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeMessage(32, this.contract_);
            }
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                output.writeMessage(33, this.compilerPluginData_.get(i2));
            }
            for (i2 = 0; i2 < this.extensionReceiverAnnotation_.size(); ++i2) {
                output.writeMessage(34, this.extensionReceiverAnnotation_.get(i2));
            }
            extensionWriter.writeUntil(19000, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i2;
            int i3;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (i3 = 0; i3 < this.typeParameter_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i3));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            for (i3 = 0; i3 < this.valueParameter_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i3));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(9, this.flags_);
            }
            for (i3 = 0; i3 < this.contextReceiverType_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(i3));
            }
            int dataSize = 0;
            for (i2 = 0; i2 < this.contextReceiverTypeId_.size(); ++i2) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i2));
            }
            size += dataSize;
            if (!this.getContextReceiverTypeIdList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = dataSize;
            for (i3 = 0; i3 < this.annotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(12, this.annotation_.get(i3));
            }
            for (i3 = 0; i3 < this.contextParameter_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(13, this.contextParameter_.get(i3));
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            dataSize = 0;
            for (i2 = 0; i2 < this.versionRequirement_.size(); ++i2) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i2));
            }
            size += dataSize;
            size += 2 * this.getVersionRequirementList().size();
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeMessageSize(32, this.contract_);
            }
            for (i3 = 0; i3 < this.compilerPluginData_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(33, this.compilerPluginData_.get(i3));
            }
            for (i3 = 0; i3 < this.extensionReceiverAnnotation_.size(); ++i3) {
                size += CodedOutputStream.computeMessageSize(34, this.extensionReceiverAnnotation_.get(i3));
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Function parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Function.newBuilder();
        }

        public static Builder newBuilder(Function prototype) {
            return Function.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Function.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Function>(){

                @Override
                public Function parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Function(input, extensionRegistry);
                }
            };
            defaultInstance = new Function(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Function, Builder>
        implements ProtoBuf$FunctionOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private int oldFlags_ = 6;
            private int name_;
            private Type returnType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private int receiverTypeId_;
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<ValueParameter> contextParameter_ = Collections.emptyList();
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private Contract contract_ = Contract.getDefaultInstance();
            private List<CompilerPluginData> compilerPluginData_ = Collections.emptyList();
            private List<Annotation> annotation_ = Collections.emptyList();
            private List<Annotation> extensionReceiverAnnotation_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override
            public Function build() {
                Function result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Function buildPartial() {
                Function result = new Function(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.oldFlags_ = this.oldFlags_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.returnType_ = this.returnType_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result.receiverType_ = this.receiverType_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x40;
                }
                result.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 0x100) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                result.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 0x200) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= 0xFFFFFDFF;
                }
                result.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 0x400) == 1024) {
                    this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                    this.bitField0_ &= 0xFFFFFBFF;
                }
                result.contextParameter_ = this.contextParameter_;
                if ((this.bitField0_ & 0x800) == 2048) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= 0xFFFFF7FF;
                }
                result.valueParameter_ = this.valueParameter_;
                if ((from_bitField0_ & 0x1000) == 4096) {
                    to_bitField0_ |= 0x80;
                }
                result.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 0x2000) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= 0xFFFFDFFF;
                }
                result.versionRequirement_ = this.versionRequirement_;
                if ((from_bitField0_ & 0x4000) == 16384) {
                    to_bitField0_ |= 0x100;
                }
                result.contract_ = this.contract_;
                if ((this.bitField0_ & 0x8000) == 32768) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                    this.bitField0_ &= 0xFFFF7FFF;
                }
                result.compilerPluginData_ = this.compilerPluginData_;
                if ((this.bitField0_ & 0x10000) == 65536) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFFEFFFF;
                }
                result.annotation_ = this.annotation_;
                if ((this.bitField0_ & 0x20000) == 131072) {
                    this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                    this.bitField0_ &= 0xFFFDFFFF;
                }
                result.extensionReceiverAnnotation_ = this.extensionReceiverAnnotation_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Function other) {
                if (other == Function.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasOldFlags()) {
                    this.setOldFlags(other.getOldFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasReturnType()) {
                    this.mergeReturnType(other.getReturnType());
                }
                if (other.hasReturnTypeId()) {
                    this.setReturnTypeId(other.getReturnTypeId());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (other.hasReceiverType()) {
                    this.mergeReceiverType(other.getReceiverType());
                }
                if (other.hasReceiverTypeId()) {
                    this.setReceiverTypeId(other.getReceiverTypeId());
                }
                if (!other.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = other.contextReceiverType_;
                        this.bitField0_ &= 0xFFFFFEFF;
                    } else {
                        this.ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(other.contextReceiverType_);
                    }
                }
                if (!other.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = other.contextReceiverTypeId_;
                        this.bitField0_ &= 0xFFFFFDFF;
                    } else {
                        this.ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(other.contextReceiverTypeId_);
                    }
                }
                if (!other.contextParameter_.isEmpty()) {
                    if (this.contextParameter_.isEmpty()) {
                        this.contextParameter_ = other.contextParameter_;
                        this.bitField0_ &= 0xFFFFFBFF;
                    } else {
                        this.ensureContextParameterIsMutable();
                        this.contextParameter_.addAll(other.contextParameter_);
                    }
                }
                if (!other.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = other.valueParameter_;
                        this.bitField0_ &= 0xFFFFF7FF;
                    } else {
                        this.ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(other.valueParameter_);
                    }
                }
                if (other.hasTypeTable()) {
                    this.mergeTypeTable(other.getTypeTable());
                }
                if (!other.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = other.versionRequirement_;
                        this.bitField0_ &= 0xFFFFDFFF;
                    } else {
                        this.ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(other.versionRequirement_);
                    }
                }
                if (other.hasContract()) {
                    this.mergeContract(other.getContract());
                }
                if (!other.compilerPluginData_.isEmpty()) {
                    if (this.compilerPluginData_.isEmpty()) {
                        this.compilerPluginData_ = other.compilerPluginData_;
                        this.bitField0_ &= 0xFFFF7FFF;
                    } else {
                        this.ensureCompilerPluginDataIsMutable();
                        this.compilerPluginData_.addAll(other.compilerPluginData_);
                    }
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFFEFFFF;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                if (!other.extensionReceiverAnnotation_.isEmpty()) {
                    if (this.extensionReceiverAnnotation_.isEmpty()) {
                        this.extensionReceiverAnnotation_ = other.extensionReceiverAnnotation_;
                        this.bitField0_ &= 0xFFFDFFFF;
                    } else {
                        this.ensureExtensionReceiverAnnotationIsMutable();
                        this.extensionReceiverAnnotation_.addAll(other.extensionReceiverAnnotation_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i2;
                if (!this.hasName()) {
                    return false;
                }
                if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                    if (this.getTypeParameter(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getContextReceiverTypeCount(); ++i2) {
                    if (this.getContextReceiverType(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getContextParameterCount(); ++i2) {
                    if (this.getContextParameter(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getValueParameterCount(); ++i2) {
                    if (this.getValueParameter(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                    return false;
                }
                if (this.hasContract() && !this.getContract().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                    if (this.getCompilerPluginData(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                    if (this.getAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getExtensionReceiverAnnotationCount(); ++i2) {
                    if (this.getExtensionReceiverAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Function parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Function)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder setOldFlags(int value) {
                this.bitField0_ |= 2;
                this.oldFlags_ = value;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 4;
                this.name_ = value;
                return this;
            }

            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder mergeReturnType(Type value) {
                this.returnType_ = (this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance() ? Type.newBuilder(this.returnType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnTypeId(int value) {
                this.bitField0_ |= 0x10;
                this.returnTypeId_ = value;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 0x20;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            public boolean hasReceiverType() {
                return (this.bitField0_ & 0x40) == 64;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder mergeReceiverType(Type value) {
                this.receiverType_ = (this.bitField0_ & 0x40) == 64 && this.receiverType_ != Type.getDefaultInstance() ? Type.newBuilder(this.receiverType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder setReceiverTypeId(int value) {
                this.bitField0_ |= 0x80;
                this.receiverTypeId_ = value;
                return this;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.contextReceiverType_ = new ArrayList<Type>(this.contextReceiverType_);
                    this.bitField0_ |= 0x100;
                }
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int index) {
                return this.contextReceiverType_.get(index);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 0x200) != 512) {
                    this.contextReceiverTypeId_ = new ArrayList<Integer>(this.contextReceiverTypeId_);
                    this.bitField0_ |= 0x200;
                }
            }

            private void ensureContextParameterIsMutable() {
                if ((this.bitField0_ & 0x400) != 1024) {
                    this.contextParameter_ = new ArrayList<ValueParameter>(this.contextParameter_);
                    this.bitField0_ |= 0x400;
                }
            }

            public int getContextParameterCount() {
                return this.contextParameter_.size();
            }

            public ValueParameter getContextParameter(int index) {
                return this.contextParameter_.get(index);
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 0x800) != 2048) {
                    this.valueParameter_ = new ArrayList<ValueParameter>(this.valueParameter_);
                    this.bitField0_ |= 0x800;
                }
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public ValueParameter getValueParameter(int index) {
                return this.valueParameter_.get(index);
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 0x1000) == 4096;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable value) {
                this.typeTable_ = (this.bitField0_ & 0x1000) == 4096 && this.typeTable_ != TypeTable.getDefaultInstance() ? TypeTable.newBuilder(this.typeTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x1000;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 0x2000) != 8192) {
                    this.versionRequirement_ = new ArrayList<Integer>(this.versionRequirement_);
                    this.bitField0_ |= 0x2000;
                }
            }

            public boolean hasContract() {
                return (this.bitField0_ & 0x4000) == 16384;
            }

            public Contract getContract() {
                return this.contract_;
            }

            public Builder mergeContract(Contract value) {
                this.contract_ = (this.bitField0_ & 0x4000) == 16384 && this.contract_ != Contract.getDefaultInstance() ? Contract.newBuilder(this.contract_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x4000;
                return this;
            }

            private void ensureCompilerPluginDataIsMutable() {
                if ((this.bitField0_ & 0x8000) != 32768) {
                    this.compilerPluginData_ = new ArrayList<CompilerPluginData>(this.compilerPluginData_);
                    this.bitField0_ |= 0x8000;
                }
            }

            public int getCompilerPluginDataCount() {
                return this.compilerPluginData_.size();
            }

            public CompilerPluginData getCompilerPluginData(int index) {
                return this.compilerPluginData_.get(index);
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 0x10000) != 65536) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 0x10000;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> values) {
                this.ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.annotation_);
                return this;
            }

            private void ensureExtensionReceiverAnnotationIsMutable() {
                if ((this.bitField0_ & 0x20000) != 131072) {
                    this.extensionReceiverAnnotation_ = new ArrayList<Annotation>(this.extensionReceiverAnnotation_);
                    this.bitField0_ |= 0x20000;
                }
            }

            public int getExtensionReceiverAnnotationCount() {
                return this.extensionReceiverAnnotation_.size();
            }

            public Annotation getExtensionReceiverAnnotation(int index) {
                return this.extensionReceiverAnnotation_.get(index);
            }

            public Builder addAllExtensionReceiverAnnotation(Iterable<? extends Annotation> values) {
                this.ensureExtensionReceiverAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.extensionReceiverAnnotation_);
                return this;
            }
        }
    }

    public static final class Constructor
    extends GeneratedMessageLite.ExtendableMessage<Constructor>
    implements ProtoBuf$ConstructorOrBuilder {
        private static final Constructor defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Constructor> PARSER;
        private int bitField0_;
        private int flags_;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;
        private List<CompilerPluginData> compilerPluginData_;
        private List<Annotation> annotation_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Constructor(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Constructor(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block24: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block24;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block24;
                            done = true;
                            continue block24;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block24;
                        }
                        case 18: {
                            if ((mutable_bitField0_ & 2) != 2) {
                                this.valueParameter_ = new ArrayList<ValueParameter>();
                                mutable_bitField0_ |= 2;
                            }
                            this.valueParameter_.add(input.readMessage(ValueParameter.PARSER, extensionRegistry));
                            continue block24;
                        }
                        case 26: {
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.annotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block24;
                        }
                        case 248: {
                            if ((mutable_bitField0_ & 4) != 4) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 4;
                            }
                            this.versionRequirement_.add(input.readInt32());
                            continue block24;
                        }
                        case 250: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 4) != 4 && input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 4;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block24;
                        }
                        case 258: 
                    }
                    if ((mutable_bitField0_ & 8) != 8) {
                        this.compilerPluginData_ = new ArrayList<CompilerPluginData>();
                        mutable_bitField0_ |= 8;
                    }
                    this.compilerPluginData_.add(input.readMessage(CompilerPluginData.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                }
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((mutable_bitField0_ & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if ((mutable_bitField0_ & 8) == 8) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public ValueParameter getValueParameter(int index) {
            return this.valueParameter_.get(index);
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public CompilerPluginData getCompilerPluginData(int index) {
            return this.compilerPluginData_.get(index);
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
            this.compilerPluginData_ = Collections.emptyList();
            this.annotation_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            int i2;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (i2 = 0; i2 < this.getValueParameterCount(); ++i2) {
                if (this.getValueParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                if (this.getCompilerPluginData(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                if (this.getAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            for (i2 = 0; i2 < this.valueParameter_.size(); ++i2) {
                output.writeMessage(2, this.valueParameter_.get(i2));
            }
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                output.writeMessage(3, this.annotation_.get(i2));
            }
            for (i2 = 0; i2 < this.versionRequirement_.size(); ++i2) {
                output.writeInt32(31, this.versionRequirement_.get(i2));
            }
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                output.writeMessage(32, this.compilerPluginData_.get(i2));
            }
            extensionWriter.writeUntil(19000, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i2;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            for (i2 = 0; i2 < this.valueParameter_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i2));
            }
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(3, this.annotation_.get(i2));
            }
            int dataSize = 0;
            for (int i3 = 0; i3 < this.versionRequirement_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i3));
            }
            size += dataSize;
            size += 2 * this.getVersionRequirementList().size();
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(32, this.compilerPluginData_.get(i2));
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Constructor.newBuilder();
        }

        public static Builder newBuilder(Constructor prototype) {
            return Constructor.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Constructor.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Constructor>(){

                @Override
                public Constructor parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Constructor(input, extensionRegistry);
                }
            };
            defaultInstance = new Constructor(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder>
        implements ProtoBuf$ConstructorOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private List<CompilerPluginData> compilerPluginData_ = Collections.emptyList();
            private List<Annotation> annotation_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override
            public Constructor build() {
                Constructor result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Constructor buildPartial() {
                Constructor result = new Constructor(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.flags_ = this.flags_;
                if ((this.bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.valueParameter_ = this.valueParameter_;
                if ((this.bitField0_ & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.versionRequirement_ = this.versionRequirement_;
                if ((this.bitField0_ & 8) == 8) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result.compilerPluginData_ = this.compilerPluginData_;
                if ((this.bitField0_ & 0x10) == 16) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result.annotation_ = this.annotation_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Constructor other) {
                if (other == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (!other.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = other.valueParameter_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(other.valueParameter_);
                    }
                }
                if (!other.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = other.versionRequirement_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        this.ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(other.versionRequirement_);
                    }
                }
                if (!other.compilerPluginData_.isEmpty()) {
                    if (this.compilerPluginData_.isEmpty()) {
                        this.compilerPluginData_ = other.compilerPluginData_;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        this.ensureCompilerPluginDataIsMutable();
                        this.compilerPluginData_.addAll(other.compilerPluginData_);
                    }
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i2;
                for (i2 = 0; i2 < this.getValueParameterCount(); ++i2) {
                    if (this.getValueParameter(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                    if (this.getCompilerPluginData(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                    if (this.getAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Constructor parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Constructor)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.valueParameter_ = new ArrayList<ValueParameter>(this.valueParameter_);
                    this.bitField0_ |= 2;
                }
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public ValueParameter getValueParameter(int index) {
                return this.valueParameter_.get(index);
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.versionRequirement_ = new ArrayList<Integer>(this.versionRequirement_);
                    this.bitField0_ |= 4;
                }
            }

            private void ensureCompilerPluginDataIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.compilerPluginData_ = new ArrayList<CompilerPluginData>(this.compilerPluginData_);
                    this.bitField0_ |= 8;
                }
            }

            public int getCompilerPluginDataCount() {
                return this.compilerPluginData_.size();
            }

            public CompilerPluginData getCompilerPluginData(int index) {
                return this.compilerPluginData_.get(index);
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 0x10;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> values) {
                this.ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.annotation_);
                return this;
            }
        }
    }

    public static final class TypeTable
    extends GeneratedMessageLite
    implements ProtoBuf$TypeTableOrBuilder {
        private static final TypeTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<TypeTable> PARSER;
        private int bitField0_;
        private List<Type> type_;
        private int firstNullable_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private TypeTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private TypeTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block20: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block20;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block20;
                            done = true;
                            continue block20;
                        }
                        case 10: {
                            if (!(mutable_bitField0_ & true)) {
                                this.type_ = new ArrayList<Type>();
                                mutable_bitField0_ |= true;
                            }
                            this.type_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block20;
                        }
                        case 16: 
                    }
                    this.bitField0_ |= 1;
                    this.firstNullable_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public Type getType(int index) {
            return this.type_.get(index);
        }

        public boolean hasFirstNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.getTypeCount(); ++i2) {
                if (this.getType(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            for (int i2 = 0; i2 < this.type_.size(); ++i2) {
                output.writeMessage(1, this.type_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(2, this.firstNullable_);
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i2 = 0; i2 < this.type_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(1, this.type_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return TypeTable.newBuilder();
        }

        public static Builder newBuilder(TypeTable prototype) {
            return TypeTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return TypeTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<TypeTable>(){

                @Override
                public TypeTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new TypeTable(input, extensionRegistry);
                }
            };
            defaultInstance = new TypeTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<TypeTable, Builder>
        implements ProtoBuf$TypeTableOrBuilder {
            private int bitField0_;
            private List<Type> type_ = Collections.emptyList();
            private int firstNullable_ = -1;

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override
            public TypeTable build() {
                TypeTable result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public TypeTable buildPartial() {
                TypeTable result = new TypeTable(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & 1) == 1) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 1;
                }
                result.firstNullable_ = this.firstNullable_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(TypeTable other) {
                if (other == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = other.type_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureTypeIsMutable();
                        this.type_.addAll(other.type_);
                    }
                }
                if (other.hasFirstNullable()) {
                    this.setFirstNullable(other.getFirstNullable());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < this.getTypeCount(); ++i2) {
                    if (this.getType(i2).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TypeTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (TypeTable)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.type_ = new ArrayList<Type>(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            public Type getType(int index) {
                return this.type_.get(index);
            }

            public Builder setFirstNullable(int value) {
                this.bitField0_ |= 2;
                this.firstNullable_ = value;
                return this;
            }
        }
    }

    public static final class Package
    extends GeneratedMessageLite.ExtendableMessage<Package>
    implements ProtoBuf$PackageOrBuilder {
        private static final Package defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Package> PARSER;
        private int bitField0_;
        private List<Function> function_;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private VersionRequirementTable versionRequirementTable_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Package(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Package(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block23: while (!done) {
                    GeneratedMessageLite.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block23;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block23;
                            done = true;
                            continue block23;
                        }
                        case 26: {
                            if ((mutable_bitField0_ & 1) != 1) {
                                this.function_ = new ArrayList<Function>();
                                mutable_bitField0_ |= 1;
                            }
                            this.function_.add(input.readMessage(Function.PARSER, extensionRegistry));
                            continue block23;
                        }
                        case 34: {
                            if ((mutable_bitField0_ & 2) != 2) {
                                this.property_ = new ArrayList<Property>();
                                mutable_bitField0_ |= 2;
                            }
                            this.property_.add(input.readMessage(Property.PARSER, extensionRegistry));
                            continue block23;
                        }
                        case 42: {
                            if ((mutable_bitField0_ & 4) != 4) {
                                this.typeAlias_ = new ArrayList<TypeAlias>();
                                mutable_bitField0_ |= 4;
                            }
                            this.typeAlias_.add(input.readMessage(TypeAlias.PARSER, extensionRegistry));
                            continue block23;
                        }
                        case 242: {
                            subBuilder = null;
                            if ((this.bitField0_ & 1) == 1) {
                                subBuilder = this.typeTable_.toBuilder();
                            }
                            this.typeTable_ = input.readMessage(TypeTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((TypeTable.Builder)subBuilder).mergeFrom(this.typeTable_);
                                this.typeTable_ = ((TypeTable.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 1;
                            continue block23;
                        }
                        case 258: 
                    }
                    subBuilder = null;
                    if ((this.bitField0_ & 2) == 2) {
                        subBuilder = this.versionRequirementTable_.toBuilder();
                    }
                    this.versionRequirementTable_ = input.readMessage(VersionRequirementTable.PARSER, extensionRegistry);
                    if (subBuilder != null) {
                        ((VersionRequirementTable.Builder)subBuilder).mergeFrom(this.versionRequirementTable_);
                        this.versionRequirementTable_ = ((VersionRequirementTable.Builder)subBuilder).buildPartial();
                    }
                    this.bitField0_ |= 2;
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((mutable_bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((mutable_bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public Function getFunction(int index) {
            return this.function_.get(index);
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public Property getProperty(int index) {
            return this.property_.get(index);
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public TypeAlias getTypeAlias(int index) {
            return this.typeAlias_.get(index);
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 2) == 2;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        @Override
        public final boolean isInitialized() {
            int i2;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (i2 = 0; i2 < this.getFunctionCount(); ++i2) {
                if (this.getFunction(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getPropertyCount(); ++i2) {
                if (this.getProperty(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getTypeAliasCount(); ++i2) {
                if (this.getTypeAlias(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            for (i2 = 0; i2 < this.function_.size(); ++i2) {
                output.writeMessage(3, this.function_.get(i2));
            }
            for (i2 = 0; i2 < this.property_.size(); ++i2) {
                output.writeMessage(4, this.property_.get(i2));
            }
            for (i2 = 0; i2 < this.typeAlias_.size(); ++i2) {
                output.writeMessage(5, this.typeAlias_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(32, this.versionRequirementTable_);
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i2;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (i2 = 0; i2 < this.function_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(3, this.function_.get(i2));
            }
            for (i2 = 0; i2 < this.property_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(4, this.property_.get(i2));
            }
            for (i2 = 0; i2 < this.typeAlias_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Package parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Package.newBuilder();
        }

        public static Builder newBuilder(Package prototype) {
            return Package.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Package.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Package>(){

                @Override
                public Package parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Package(input, extensionRegistry);
                }
            };
            defaultInstance = new Package(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Package, Builder>
        implements ProtoBuf$PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            @Override
            public Package build() {
                Package result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Package buildPartial() {
                Package result = new Package(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.function_ = this.function_;
                if ((this.bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.property_ = this.property_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.typeAlias_ = this.typeAlias_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 1;
                }
                result.typeTable_ = this.typeTable_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 2;
                }
                result.versionRequirementTable_ = this.versionRequirementTable_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Package other) {
                if (other == Package.getDefaultInstance()) {
                    return this;
                }
                if (!other.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = other.function_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureFunctionIsMutable();
                        this.function_.addAll(other.function_);
                    }
                }
                if (!other.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = other.property_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensurePropertyIsMutable();
                        this.property_.addAll(other.property_);
                    }
                }
                if (!other.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = other.typeAlias_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        this.ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(other.typeAlias_);
                    }
                }
                if (other.hasTypeTable()) {
                    this.mergeTypeTable(other.getTypeTable());
                }
                if (other.hasVersionRequirementTable()) {
                    this.mergeVersionRequirementTable(other.getVersionRequirementTable());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i2;
                for (i2 = 0; i2 < this.getFunctionCount(); ++i2) {
                    if (this.getFunction(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getPropertyCount(); ++i2) {
                    if (this.getProperty(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getTypeAliasCount(); ++i2) {
                    if (this.getTypeAlias(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Package parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Package)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.function_ = new ArrayList<Function>(this.function_);
                    this.bitField0_ |= 1;
                }
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Function getFunction(int index) {
                return this.function_.get(index);
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.property_ = new ArrayList<Property>(this.property_);
                    this.bitField0_ |= 2;
                }
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Property getProperty(int index) {
                return this.property_.get(index);
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeAlias_ = new ArrayList<TypeAlias>(this.typeAlias_);
                    this.bitField0_ |= 4;
                }
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeAlias getTypeAlias(int index) {
                return this.typeAlias_.get(index);
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 8) == 8;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable value) {
                this.typeTable_ = (this.bitField0_ & 8) == 8 && this.typeTable_ != TypeTable.getDefaultInstance() ? TypeTable.newBuilder(this.typeTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable value) {
                this.versionRequirementTable_ = (this.bitField0_ & 0x10) == 16 && this.versionRequirementTable_ != VersionRequirementTable.getDefaultInstance() ? VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x10;
                return this;
            }
        }
    }

    public static final class Class
    extends GeneratedMessageLite.ExtendableMessage<Class>
    implements ProtoBuf$ClassOrBuilder {
        private static final Class defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Class> PARSER;
        private int bitField0_;
        private int flags_;
        private int fqName_;
        private int companionObjectName_;
        private List<TypeParameter> typeParameter_;
        private List<Type> supertype_;
        private List<Integer> supertypeId_;
        private int supertypeIdMemoizedSerializedSize = -1;
        private List<Integer> nestedClassName_;
        private int nestedClassNameMemoizedSerializedSize = -1;
        private List<Type> contextReceiverType_;
        private List<Integer> contextReceiverTypeId_;
        private int contextReceiverTypeIdMemoizedSerializedSize = -1;
        private List<Constructor> constructor_;
        private List<Function> function_;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private List<EnumEntry> enumEntry_;
        private List<Integer> sealedSubclassFqName_;
        private int sealedSubclassFqNameMemoizedSerializedSize = -1;
        private int inlineClassUnderlyingPropertyName_;
        private Type inlineClassUnderlyingType_;
        private int inlineClassUnderlyingTypeId_;
        private List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
        private List<Type> multiFieldValueClassUnderlyingType_;
        private List<Integer> multiFieldValueClassUnderlyingTypeId_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
        private List<Annotation> annotation_;
        private TypeTable typeTable_;
        private List<Integer> versionRequirement_;
        private VersionRequirementTable versionRequirementTable_;
        private List<CompilerPluginData> compilerPluginData_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Class(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Class(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block51: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block51;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block51;
                            done = true;
                            continue block51;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block51;
                        }
                        case 16: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.supertypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.supertypeId_.add(input.readInt32());
                            continue block51;
                        }
                        case 18: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) {
                                this.supertypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x20;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.supertypeId_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block51;
                        }
                        case 24: {
                            this.bitField0_ |= 2;
                            this.fqName_ = input.readInt32();
                            continue block51;
                        }
                        case 32: {
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = input.readInt32();
                            continue block51;
                        }
                        case 42: {
                            if ((mutable_bitField0_ & 8) != 8) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 8;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 50: {
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.supertype_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.supertype_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 56: {
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.nestedClassName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.nestedClassName_.add(input.readInt32());
                            continue block51;
                        }
                        case 58: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x40) != 64 && input.getBytesUntilLimit() > 0) {
                                this.nestedClassName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x40;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.nestedClassName_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block51;
                        }
                        case 66: {
                            if ((mutable_bitField0_ & 0x200) != 512) {
                                this.constructor_ = new ArrayList<Constructor>();
                                mutable_bitField0_ |= 0x200;
                            }
                            this.constructor_.add(input.readMessage(Constructor.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 74: {
                            if ((mutable_bitField0_ & 0x400) != 1024) {
                                this.function_ = new ArrayList<Function>();
                                mutable_bitField0_ |= 0x400;
                            }
                            this.function_.add(input.readMessage(Function.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 82: {
                            if ((mutable_bitField0_ & 0x800) != 2048) {
                                this.property_ = new ArrayList<Property>();
                                mutable_bitField0_ |= 0x800;
                            }
                            this.property_.add(input.readMessage(Property.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 90: {
                            if ((mutable_bitField0_ & 0x1000) != 4096) {
                                this.typeAlias_ = new ArrayList<TypeAlias>();
                                mutable_bitField0_ |= 0x1000;
                            }
                            this.typeAlias_.add(input.readMessage(TypeAlias.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 106: {
                            if ((mutable_bitField0_ & 0x2000) != 8192) {
                                this.enumEntry_ = new ArrayList<EnumEntry>();
                                mutable_bitField0_ |= 0x2000;
                            }
                            this.enumEntry_.add(input.readMessage(EnumEntry.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 128: {
                            if ((mutable_bitField0_ & 0x4000) != 16384) {
                                this.sealedSubclassFqName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x4000;
                            }
                            this.sealedSubclassFqName_.add(input.readInt32());
                            continue block51;
                        }
                        case 130: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x4000) != 16384 && input.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x4000;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block51;
                        }
                        case 136: {
                            this.bitField0_ |= 8;
                            this.inlineClassUnderlyingPropertyName_ = input.readInt32();
                            continue block51;
                        }
                        case 146: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) {
                                subBuilder = this.inlineClassUnderlyingType_.toBuilder();
                            }
                            this.inlineClassUnderlyingType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.inlineClassUnderlyingType_);
                                this.inlineClassUnderlyingType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x10;
                            continue block51;
                        }
                        case 152: {
                            this.bitField0_ |= 0x20;
                            this.inlineClassUnderlyingTypeId_ = input.readInt32();
                            continue block51;
                        }
                        case 162: {
                            if ((mutable_bitField0_ & 0x80) != 128) {
                                this.contextReceiverType_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x80;
                            }
                            this.contextReceiverType_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 168: {
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.contextReceiverTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.contextReceiverTypeId_.add(input.readInt32());
                            continue block51;
                        }
                        case 170: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x100) != 256 && input.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x100;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block51;
                        }
                        case 176: {
                            if ((mutable_bitField0_ & 0x40000) != 262144) {
                                this.multiFieldValueClassUnderlyingName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x40000;
                            }
                            this.multiFieldValueClassUnderlyingName_.add(input.readInt32());
                            continue block51;
                        }
                        case 178: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x40000) != 262144 && input.getBytesUntilLimit() > 0) {
                                this.multiFieldValueClassUnderlyingName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x40000;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.multiFieldValueClassUnderlyingName_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block51;
                        }
                        case 186: {
                            if ((mutable_bitField0_ & 0x80000) != 524288) {
                                this.multiFieldValueClassUnderlyingType_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x80000;
                            }
                            this.multiFieldValueClassUnderlyingType_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 192: {
                            if ((mutable_bitField0_ & 0x100000) != 0x100000) {
                                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x100000;
                            }
                            this.multiFieldValueClassUnderlyingTypeId_.add(input.readInt32());
                            continue block51;
                        }
                        case 194: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x100000) != 0x100000 && input.getBytesUntilLimit() > 0) {
                                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x100000;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.multiFieldValueClassUnderlyingTypeId_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block51;
                        }
                        case 202: {
                            if ((mutable_bitField0_ & 0x200000) != 0x200000) {
                                this.annotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x200000;
                            }
                            this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block51;
                        }
                        case 242: {
                            TypeTable.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x40) == 64) {
                                subBuilder = this.typeTable_.toBuilder();
                            }
                            this.typeTable_ = input.readMessage(TypeTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.typeTable_);
                                this.typeTable_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x40;
                            continue block51;
                        }
                        case 248: {
                            if ((mutable_bitField0_ & 0x800000) != 0x800000) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x800000;
                            }
                            this.versionRequirement_.add(input.readInt32());
                            continue block51;
                        }
                        case 250: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x800000) != 0x800000 && input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x800000;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block51;
                        }
                        case 258: {
                            VersionRequirementTable.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x80) == 128) {
                                subBuilder = this.versionRequirementTable_.toBuilder();
                            }
                            this.versionRequirementTable_ = input.readMessage(VersionRequirementTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.versionRequirementTable_);
                                this.versionRequirementTable_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x80;
                            continue block51;
                        }
                        case 266: 
                    }
                    if ((mutable_bitField0_ & 0x2000000) != 0x2000000) {
                        this.compilerPluginData_ = new ArrayList<CompilerPluginData>();
                        mutable_bitField0_ |= 0x2000000;
                    }
                    this.compilerPluginData_.add(input.readMessage(CompilerPluginData.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                }
                if ((mutable_bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                }
                if ((mutable_bitField0_ & 0x40) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                }
                if ((mutable_bitField0_ & 0x200) == 512) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                }
                if ((mutable_bitField0_ & 0x400) == 1024) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((mutable_bitField0_ & 0x800) == 2048) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((mutable_bitField0_ & 0x1000) == 4096) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                if ((mutable_bitField0_ & 0x2000) == 8192) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                }
                if ((mutable_bitField0_ & 0x4000) == 16384) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                }
                if ((mutable_bitField0_ & 0x80) == 128) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if ((mutable_bitField0_ & 0x100) == 256) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if ((mutable_bitField0_ & 0x40000) == 262144) {
                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                }
                if ((mutable_bitField0_ & 0x80000) == 524288) {
                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                }
                if ((mutable_bitField0_ & 0x100000) == 0x100000) {
                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                }
                if ((mutable_bitField0_ & 0x200000) == 0x200000) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((mutable_bitField0_ & 0x800000) == 0x800000) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if ((mutable_bitField0_ & 0x2000000) == 0x2000000) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public Type getSupertype(int index) {
            return this.supertype_.get(index);
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public Type getContextReceiverType(int index) {
            return this.contextReceiverType_.get(index);
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public Constructor getConstructor(int index) {
            return this.constructor_.get(index);
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public Function getFunction(int index) {
            return this.function_.get(index);
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public Property getProperty(int index) {
            return this.property_.get(index);
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public TypeAlias getTypeAlias(int index) {
            return this.typeAlias_.get(index);
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public EnumEntry getEnumEntry(int index) {
            return this.enumEntry_.get(index);
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public Type getMultiFieldValueClassUnderlyingType(int index) {
            return this.multiFieldValueClassUnderlyingType_.get(index);
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public int getCompilerPluginDataCount() {
            return this.compilerPluginData_.size();
        }

        public CompilerPluginData getCompilerPluginData(int index) {
            return this.compilerPluginData_.get(index);
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.annotation_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
            this.compilerPluginData_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            int i2;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasFqName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                if (this.getTypeParameter(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getSupertypeCount(); ++i2) {
                if (this.getSupertype(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getContextReceiverTypeCount(); ++i2) {
                if (this.getContextReceiverType(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getConstructorCount(); ++i2) {
                if (this.getConstructor(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getFunctionCount(); ++i2) {
                if (this.getFunction(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getPropertyCount(); ++i2) {
                if (this.getProperty(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getTypeAliasCount(); ++i2) {
                if (this.getTypeAlias(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getEnumEntryCount(); ++i2) {
                if (this.getEnumEntry(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasInlineClassUnderlyingType() && !this.getInlineClassUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getMultiFieldValueClassUnderlyingTypeCount(); ++i2) {
                if (this.getMultiFieldValueClassUnderlyingType(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                if (this.getAnnotation(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                if (this.getCompilerPluginData(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            if (this.getSupertypeIdList().size() > 0) {
                output.writeRawVarint32(18);
                output.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.supertypeId_.size(); ++i2) {
                output.writeInt32NoTag(this.supertypeId_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt32(4, this.companionObjectName_);
            }
            for (i2 = 0; i2 < this.typeParameter_.size(); ++i2) {
                output.writeMessage(5, this.typeParameter_.get(i2));
            }
            for (i2 = 0; i2 < this.supertype_.size(); ++i2) {
                output.writeMessage(6, this.supertype_.get(i2));
            }
            if (this.getNestedClassNameList().size() > 0) {
                output.writeRawVarint32(58);
                output.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.nestedClassName_.size(); ++i2) {
                output.writeInt32NoTag(this.nestedClassName_.get(i2));
            }
            for (i2 = 0; i2 < this.constructor_.size(); ++i2) {
                output.writeMessage(8, this.constructor_.get(i2));
            }
            for (i2 = 0; i2 < this.function_.size(); ++i2) {
                output.writeMessage(9, this.function_.get(i2));
            }
            for (i2 = 0; i2 < this.property_.size(); ++i2) {
                output.writeMessage(10, this.property_.get(i2));
            }
            for (i2 = 0; i2 < this.typeAlias_.size(); ++i2) {
                output.writeMessage(11, this.typeAlias_.get(i2));
            }
            for (i2 = 0; i2 < this.enumEntry_.size(); ++i2) {
                output.writeMessage(13, this.enumEntry_.get(i2));
            }
            if (this.getSealedSubclassFqNameList().size() > 0) {
                output.writeRawVarint32(130);
                output.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.sealedSubclassFqName_.size(); ++i2) {
                output.writeInt32NoTag(this.sealedSubclassFqName_.get(i2));
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeMessage(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(19, this.inlineClassUnderlyingTypeId_);
            }
            for (i2 = 0; i2 < this.contextReceiverType_.size(); ++i2) {
                output.writeMessage(20, this.contextReceiverType_.get(i2));
            }
            if (this.getContextReceiverTypeIdList().size() > 0) {
                output.writeRawVarint32(170);
                output.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.contextReceiverTypeId_.size(); ++i2) {
                output.writeInt32NoTag(this.contextReceiverTypeId_.get(i2));
            }
            if (this.getMultiFieldValueClassUnderlyingNameList().size() > 0) {
                output.writeRawVarint32(178);
                output.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.multiFieldValueClassUnderlyingName_.size(); ++i2) {
                output.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(i2));
            }
            for (i2 = 0; i2 < this.multiFieldValueClassUnderlyingType_.size(); ++i2) {
                output.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(i2));
            }
            if (this.getMultiFieldValueClassUnderlyingTypeIdList().size() > 0) {
                output.writeRawVarint32(194);
                output.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.multiFieldValueClassUnderlyingTypeId_.size(); ++i2) {
                output.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i2));
            }
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                output.writeMessage(25, this.annotation_.get(i2));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeMessage(30, this.typeTable_);
            }
            for (i2 = 0; i2 < this.versionRequirement_.size(); ++i2) {
                output.writeInt32(31, this.versionRequirement_.get(i2));
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeMessage(32, this.versionRequirementTable_);
            }
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                output.writeMessage(33, this.compilerPluginData_.get(i2));
            }
            extensionWriter.writeUntil(19000, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i2;
            int i3;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            int dataSize = 0;
            for (i3 = 0; i3 < this.supertypeId_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i3));
            }
            size += dataSize;
            if (!this.getSupertypeIdList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.supertypeIdMemoizedSerializedSize = dataSize;
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
            }
            for (i2 = 0; i2 < this.typeParameter_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i2));
            }
            for (i2 = 0; i2 < this.supertype_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i2));
            }
            dataSize = 0;
            for (i3 = 0; i3 < this.nestedClassName_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i3));
            }
            size += dataSize;
            if (!this.getNestedClassNameList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.nestedClassNameMemoizedSerializedSize = dataSize;
            for (i2 = 0; i2 < this.constructor_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i2));
            }
            for (i2 = 0; i2 < this.function_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(9, this.function_.get(i2));
            }
            for (i2 = 0; i2 < this.property_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(10, this.property_.get(i2));
            }
            for (i2 = 0; i2 < this.typeAlias_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i2));
            }
            for (i2 = 0; i2 < this.enumEntry_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i2));
            }
            dataSize = 0;
            for (i3 = 0; i3 < this.sealedSubclassFqName_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i3));
            }
            size += dataSize;
            if (!this.getSealedSubclassFqNameList().isEmpty()) {
                size += 2;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = dataSize;
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
            }
            for (i2 = 0; i2 < this.contextReceiverType_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(i2));
            }
            dataSize = 0;
            for (i3 = 0; i3 < this.contextReceiverTypeId_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i3));
            }
            size += dataSize;
            if (!this.getContextReceiverTypeIdList().isEmpty()) {
                size += 2;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.contextReceiverTypeIdMemoizedSerializedSize = dataSize;
            dataSize = 0;
            for (i3 = 0; i3 < this.multiFieldValueClassUnderlyingName_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(i3));
            }
            size += dataSize;
            if (!this.getMultiFieldValueClassUnderlyingNameList().isEmpty()) {
                size += 2;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = dataSize;
            for (i2 = 0; i2 < this.multiFieldValueClassUnderlyingType_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(i2));
            }
            dataSize = 0;
            for (i3 = 0; i3 < this.multiFieldValueClassUnderlyingTypeId_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(i3));
            }
            size += dataSize;
            if (!this.getMultiFieldValueClassUnderlyingTypeIdList().isEmpty()) {
                size += 2;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = dataSize;
            for (i2 = 0; i2 < this.annotation_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(25, this.annotation_.get(i2));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            dataSize = 0;
            for (i3 = 0; i3 < this.versionRequirement_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i3));
            }
            size += dataSize;
            size += 2 * this.getVersionRequirementList().size();
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
            }
            for (i2 = 0; i2 < this.compilerPluginData_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(33, this.compilerPluginData_.get(i2));
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Class parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Class.newBuilder();
        }

        public static Builder newBuilder(Class prototype) {
            return Class.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Class.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Class>(){

                @Override
                public Class parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Class(input, extensionRegistry);
                }
            };
            defaultInstance = new Class(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Class, Builder>
        implements ProtoBuf$ClassOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private int fqName_;
            private int companionObjectName_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private List<Type> supertype_ = Collections.emptyList();
            private List<Integer> supertypeId_ = Collections.emptyList();
            private List<Integer> nestedClassName_ = Collections.emptyList();
            private List<Type> contextReceiverType_ = Collections.emptyList();
            private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
            private List<Constructor> constructor_ = Collections.emptyList();
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private List<EnumEntry> enumEntry_ = Collections.emptyList();
            private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
            private int inlineClassUnderlyingPropertyName_;
            private Type inlineClassUnderlyingType_ = Type.getDefaultInstance();
            private int inlineClassUnderlyingTypeId_;
            private List<Integer> multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            private List<Type> multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            private List<Integer> multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            private List<Annotation> annotation_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private List<Integer> versionRequirement_ = Collections.emptyList();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
            private List<CompilerPluginData> compilerPluginData_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override
            public Class build() {
                Class result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Class buildPartial() {
                Class result = new Class(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.fqName_ = this.fqName_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.companionObjectName_ = this.companionObjectName_;
                if ((this.bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result.typeParameter_ = this.typeParameter_;
                if ((this.bitField0_ & 0x10) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result.supertype_ = this.supertype_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.supertypeId_ = this.supertypeId_;
                if ((this.bitField0_ & 0x40) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    this.bitField0_ &= 0xFFFFFFBF;
                }
                result.nestedClassName_ = this.nestedClassName_;
                if ((this.bitField0_ & 0x80) == 128) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    this.bitField0_ &= 0xFFFFFF7F;
                }
                result.contextReceiverType_ = this.contextReceiverType_;
                if ((this.bitField0_ & 0x100) == 256) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                result.contextReceiverTypeId_ = this.contextReceiverTypeId_;
                if ((this.bitField0_ & 0x200) == 512) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    this.bitField0_ &= 0xFFFFFDFF;
                }
                result.constructor_ = this.constructor_;
                if ((this.bitField0_ & 0x400) == 1024) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= 0xFFFFFBFF;
                }
                result.function_ = this.function_;
                if ((this.bitField0_ & 0x800) == 2048) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= 0xFFFFF7FF;
                }
                result.property_ = this.property_;
                if ((this.bitField0_ & 0x1000) == 4096) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= 0xFFFFEFFF;
                }
                result.typeAlias_ = this.typeAlias_;
                if ((this.bitField0_ & 0x2000) == 8192) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    this.bitField0_ &= 0xFFFFDFFF;
                }
                result.enumEntry_ = this.enumEntry_;
                if ((this.bitField0_ & 0x4000) == 16384) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    this.bitField0_ &= 0xFFFFBFFF;
                }
                result.sealedSubclassFqName_ = this.sealedSubclassFqName_;
                if ((from_bitField0_ & 0x8000) == 32768) {
                    to_bitField0_ |= 8;
                }
                result.inlineClassUnderlyingPropertyName_ = this.inlineClassUnderlyingPropertyName_;
                if ((from_bitField0_ & 0x10000) == 65536) {
                    to_bitField0_ |= 0x10;
                }
                result.inlineClassUnderlyingType_ = this.inlineClassUnderlyingType_;
                if ((from_bitField0_ & 0x20000) == 131072) {
                    to_bitField0_ |= 0x20;
                }
                result.inlineClassUnderlyingTypeId_ = this.inlineClassUnderlyingTypeId_;
                if ((this.bitField0_ & 0x40000) == 262144) {
                    this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ &= 0xFFFBFFFF;
                }
                result.multiFieldValueClassUnderlyingName_ = this.multiFieldValueClassUnderlyingName_;
                if ((this.bitField0_ & 0x80000) == 524288) {
                    this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ &= 0xFFF7FFFF;
                }
                result.multiFieldValueClassUnderlyingType_ = this.multiFieldValueClassUnderlyingType_;
                if ((this.bitField0_ & 0x100000) == 0x100000) {
                    this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ &= 0xFFEFFFFF;
                }
                result.multiFieldValueClassUnderlyingTypeId_ = this.multiFieldValueClassUnderlyingTypeId_;
                if ((this.bitField0_ & 0x200000) == 0x200000) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFDFFFFF;
                }
                result.annotation_ = this.annotation_;
                if ((from_bitField0_ & 0x400000) == 0x400000) {
                    to_bitField0_ |= 0x40;
                }
                result.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 0x800000) == 0x800000) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= 0xFF7FFFFF;
                }
                result.versionRequirement_ = this.versionRequirement_;
                if ((from_bitField0_ & 0x1000000) == 0x1000000) {
                    to_bitField0_ |= 0x80;
                }
                result.versionRequirementTable_ = this.versionRequirementTable_;
                if ((this.bitField0_ & 0x2000000) == 0x2000000) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                    this.bitField0_ &= 0xFDFFFFFF;
                }
                result.compilerPluginData_ = this.compilerPluginData_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Class other) {
                if (other == Class.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasFqName()) {
                    this.setFqName(other.getFqName());
                }
                if (other.hasCompanionObjectName()) {
                    this.setCompanionObjectName(other.getCompanionObjectName());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (!other.supertype_.isEmpty()) {
                    if (this.supertype_.isEmpty()) {
                        this.supertype_ = other.supertype_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        this.ensureSupertypeIsMutable();
                        this.supertype_.addAll(other.supertype_);
                    }
                }
                if (!other.supertypeId_.isEmpty()) {
                    if (this.supertypeId_.isEmpty()) {
                        this.supertypeId_ = other.supertypeId_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureSupertypeIdIsMutable();
                        this.supertypeId_.addAll(other.supertypeId_);
                    }
                }
                if (!other.nestedClassName_.isEmpty()) {
                    if (this.nestedClassName_.isEmpty()) {
                        this.nestedClassName_ = other.nestedClassName_;
                        this.bitField0_ &= 0xFFFFFFBF;
                    } else {
                        this.ensureNestedClassNameIsMutable();
                        this.nestedClassName_.addAll(other.nestedClassName_);
                    }
                }
                if (!other.contextReceiverType_.isEmpty()) {
                    if (this.contextReceiverType_.isEmpty()) {
                        this.contextReceiverType_ = other.contextReceiverType_;
                        this.bitField0_ &= 0xFFFFFF7F;
                    } else {
                        this.ensureContextReceiverTypeIsMutable();
                        this.contextReceiverType_.addAll(other.contextReceiverType_);
                    }
                }
                if (!other.contextReceiverTypeId_.isEmpty()) {
                    if (this.contextReceiverTypeId_.isEmpty()) {
                        this.contextReceiverTypeId_ = other.contextReceiverTypeId_;
                        this.bitField0_ &= 0xFFFFFEFF;
                    } else {
                        this.ensureContextReceiverTypeIdIsMutable();
                        this.contextReceiverTypeId_.addAll(other.contextReceiverTypeId_);
                    }
                }
                if (!other.constructor_.isEmpty()) {
                    if (this.constructor_.isEmpty()) {
                        this.constructor_ = other.constructor_;
                        this.bitField0_ &= 0xFFFFFDFF;
                    } else {
                        this.ensureConstructorIsMutable();
                        this.constructor_.addAll(other.constructor_);
                    }
                }
                if (!other.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = other.function_;
                        this.bitField0_ &= 0xFFFFFBFF;
                    } else {
                        this.ensureFunctionIsMutable();
                        this.function_.addAll(other.function_);
                    }
                }
                if (!other.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = other.property_;
                        this.bitField0_ &= 0xFFFFF7FF;
                    } else {
                        this.ensurePropertyIsMutable();
                        this.property_.addAll(other.property_);
                    }
                }
                if (!other.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = other.typeAlias_;
                        this.bitField0_ &= 0xFFFFEFFF;
                    } else {
                        this.ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(other.typeAlias_);
                    }
                }
                if (!other.enumEntry_.isEmpty()) {
                    if (this.enumEntry_.isEmpty()) {
                        this.enumEntry_ = other.enumEntry_;
                        this.bitField0_ &= 0xFFFFDFFF;
                    } else {
                        this.ensureEnumEntryIsMutable();
                        this.enumEntry_.addAll(other.enumEntry_);
                    }
                }
                if (!other.sealedSubclassFqName_.isEmpty()) {
                    if (this.sealedSubclassFqName_.isEmpty()) {
                        this.sealedSubclassFqName_ = other.sealedSubclassFqName_;
                        this.bitField0_ &= 0xFFFFBFFF;
                    } else {
                        this.ensureSealedSubclassFqNameIsMutable();
                        this.sealedSubclassFqName_.addAll(other.sealedSubclassFqName_);
                    }
                }
                if (other.hasInlineClassUnderlyingPropertyName()) {
                    this.setInlineClassUnderlyingPropertyName(other.getInlineClassUnderlyingPropertyName());
                }
                if (other.hasInlineClassUnderlyingType()) {
                    this.mergeInlineClassUnderlyingType(other.getInlineClassUnderlyingType());
                }
                if (other.hasInlineClassUnderlyingTypeId()) {
                    this.setInlineClassUnderlyingTypeId(other.getInlineClassUnderlyingTypeId());
                }
                if (!other.multiFieldValueClassUnderlyingName_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingName_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingName_ = other.multiFieldValueClassUnderlyingName_;
                        this.bitField0_ &= 0xFFFBFFFF;
                    } else {
                        this.ensureMultiFieldValueClassUnderlyingNameIsMutable();
                        this.multiFieldValueClassUnderlyingName_.addAll(other.multiFieldValueClassUnderlyingName_);
                    }
                }
                if (!other.multiFieldValueClassUnderlyingType_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingType_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingType_ = other.multiFieldValueClassUnderlyingType_;
                        this.bitField0_ &= 0xFFF7FFFF;
                    } else {
                        this.ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                        this.multiFieldValueClassUnderlyingType_.addAll(other.multiFieldValueClassUnderlyingType_);
                    }
                }
                if (!other.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                    if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty()) {
                        this.multiFieldValueClassUnderlyingTypeId_ = other.multiFieldValueClassUnderlyingTypeId_;
                        this.bitField0_ &= 0xFFEFFFFF;
                    } else {
                        this.ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                        this.multiFieldValueClassUnderlyingTypeId_.addAll(other.multiFieldValueClassUnderlyingTypeId_);
                    }
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFDFFFFF;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                if (other.hasTypeTable()) {
                    this.mergeTypeTable(other.getTypeTable());
                }
                if (!other.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = other.versionRequirement_;
                        this.bitField0_ &= 0xFF7FFFFF;
                    } else {
                        this.ensureVersionRequirementIsMutable();
                        this.versionRequirement_.addAll(other.versionRequirement_);
                    }
                }
                if (other.hasVersionRequirementTable()) {
                    this.mergeVersionRequirementTable(other.getVersionRequirementTable());
                }
                if (!other.compilerPluginData_.isEmpty()) {
                    if (this.compilerPluginData_.isEmpty()) {
                        this.compilerPluginData_ = other.compilerPluginData_;
                        this.bitField0_ &= 0xFDFFFFFF;
                    } else {
                        this.ensureCompilerPluginDataIsMutable();
                        this.compilerPluginData_.addAll(other.compilerPluginData_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i2;
                if (!this.hasFqName()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getTypeParameterCount(); ++i2) {
                    if (this.getTypeParameter(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getSupertypeCount(); ++i2) {
                    if (this.getSupertype(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getContextReceiverTypeCount(); ++i2) {
                    if (this.getContextReceiverType(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getConstructorCount(); ++i2) {
                    if (this.getConstructor(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getFunctionCount(); ++i2) {
                    if (this.getFunction(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getPropertyCount(); ++i2) {
                    if (this.getProperty(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getTypeAliasCount(); ++i2) {
                    if (this.getTypeAlias(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getEnumEntryCount(); ++i2) {
                    if (this.getEnumEntry(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasInlineClassUnderlyingType() && !this.getInlineClassUnderlyingType().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getMultiFieldValueClassUnderlyingTypeCount(); ++i2) {
                    if (this.getMultiFieldValueClassUnderlyingType(i2).isInitialized()) continue;
                    return false;
                }
                for (i2 = 0; i2 < this.getAnnotationCount(); ++i2) {
                    if (this.getAnnotation(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                    return false;
                }
                for (i2 = 0; i2 < this.getCompilerPluginDataCount(); ++i2) {
                    if (this.getCompilerPluginData(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Class parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Class)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public boolean hasFqName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setFqName(int value) {
                this.bitField0_ |= 2;
                this.fqName_ = value;
                return this;
            }

            public Builder setCompanionObjectName(int value) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = value;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 8;
                }
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.supertype_ = new ArrayList<Type>(this.supertype_);
                    this.bitField0_ |= 0x10;
                }
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public Type getSupertype(int index) {
                return this.supertype_.get(index);
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.supertypeId_ = new ArrayList<Integer>(this.supertypeId_);
                    this.bitField0_ |= 0x20;
                }
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.nestedClassName_ = new ArrayList<Integer>(this.nestedClassName_);
                    this.bitField0_ |= 0x40;
                }
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 0x80) != 128) {
                    this.contextReceiverType_ = new ArrayList<Type>(this.contextReceiverType_);
                    this.bitField0_ |= 0x80;
                }
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Type getContextReceiverType(int index) {
                return this.contextReceiverType_.get(index);
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.contextReceiverTypeId_ = new ArrayList<Integer>(this.contextReceiverTypeId_);
                    this.bitField0_ |= 0x100;
                }
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 0x200) != 512) {
                    this.constructor_ = new ArrayList<Constructor>(this.constructor_);
                    this.bitField0_ |= 0x200;
                }
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public Constructor getConstructor(int index) {
                return this.constructor_.get(index);
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 0x400) != 1024) {
                    this.function_ = new ArrayList<Function>(this.function_);
                    this.bitField0_ |= 0x400;
                }
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Function getFunction(int index) {
                return this.function_.get(index);
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 0x800) != 2048) {
                    this.property_ = new ArrayList<Property>(this.property_);
                    this.bitField0_ |= 0x800;
                }
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Property getProperty(int index) {
                return this.property_.get(index);
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 0x1000) != 4096) {
                    this.typeAlias_ = new ArrayList<TypeAlias>(this.typeAlias_);
                    this.bitField0_ |= 0x1000;
                }
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeAlias getTypeAlias(int index) {
                return this.typeAlias_.get(index);
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 0x2000) != 8192) {
                    this.enumEntry_ = new ArrayList<EnumEntry>(this.enumEntry_);
                    this.bitField0_ |= 0x2000;
                }
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public EnumEntry getEnumEntry(int index) {
                return this.enumEntry_.get(index);
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 0x4000) != 16384) {
                    this.sealedSubclassFqName_ = new ArrayList<Integer>(this.sealedSubclassFqName_);
                    this.bitField0_ |= 0x4000;
                }
            }

            public Builder setInlineClassUnderlyingPropertyName(int value) {
                this.bitField0_ |= 0x8000;
                this.inlineClassUnderlyingPropertyName_ = value;
                return this;
            }

            public boolean hasInlineClassUnderlyingType() {
                return (this.bitField0_ & 0x10000) == 65536;
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Builder mergeInlineClassUnderlyingType(Type value) {
                this.inlineClassUnderlyingType_ = (this.bitField0_ & 0x10000) == 65536 && this.inlineClassUnderlyingType_ != Type.getDefaultInstance() ? Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x10000;
                return this;
            }

            public Builder setInlineClassUnderlyingTypeId(int value) {
                this.bitField0_ |= 0x20000;
                this.inlineClassUnderlyingTypeId_ = value;
                return this;
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 0x40000) != 262144) {
                    this.multiFieldValueClassUnderlyingName_ = new ArrayList<Integer>(this.multiFieldValueClassUnderlyingName_);
                    this.bitField0_ |= 0x40000;
                }
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 0x80000) != 524288) {
                    this.multiFieldValueClassUnderlyingType_ = new ArrayList<Type>(this.multiFieldValueClassUnderlyingType_);
                    this.bitField0_ |= 0x80000;
                }
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public Type getMultiFieldValueClassUnderlyingType(int index) {
                return this.multiFieldValueClassUnderlyingType_.get(index);
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 0x100000) != 0x100000) {
                    this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList<Integer>(this.multiFieldValueClassUnderlyingTypeId_);
                    this.bitField0_ |= 0x100000;
                }
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 0x200000) != 0x200000) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 0x200000;
                }
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> values) {
                this.ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.annotation_);
                return this;
            }

            public boolean hasTypeTable() {
                return (this.bitField0_ & 0x400000) == 0x400000;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder mergeTypeTable(TypeTable value) {
                this.typeTable_ = (this.bitField0_ & 0x400000) == 0x400000 && this.typeTable_ != TypeTable.getDefaultInstance() ? TypeTable.newBuilder(this.typeTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x400000;
                return this;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 0x800000) != 0x800000) {
                    this.versionRequirement_ = new ArrayList<Integer>(this.versionRequirement_);
                    this.bitField0_ |= 0x800000;
                }
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable value) {
                this.versionRequirementTable_ = (this.bitField0_ & 0x1000000) == 0x1000000 && this.versionRequirementTable_ != VersionRequirementTable.getDefaultInstance() ? VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x1000000;
                return this;
            }

            private void ensureCompilerPluginDataIsMutable() {
                if ((this.bitField0_ & 0x2000000) != 0x2000000) {
                    this.compilerPluginData_ = new ArrayList<CompilerPluginData>(this.compilerPluginData_);
                    this.bitField0_ |= 0x2000000;
                }
            }

            public int getCompilerPluginDataCount() {
                return this.compilerPluginData_.size();
            }

            public CompilerPluginData getCompilerPluginData(int index) {
                return this.compilerPluginData_.get(index);
            }
        }

        public static enum Kind implements Internal.EnumLite
        {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);

            private static Internal.EnumLiteMap<Kind> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int value) {
                switch (value) {
                    case 0: {
                        return CLASS;
                    }
                    case 1: {
                        return INTERFACE;
                    }
                    case 2: {
                        return ENUM_CLASS;
                    }
                    case 3: {
                        return ENUM_ENTRY;
                    }
                    case 4: {
                        return ANNOTATION_CLASS;
                    }
                    case 5: {
                        return OBJECT;
                    }
                    case 6: {
                        return COMPANION_OBJECT;
                    }
                }
                return null;
            }

            private Kind(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<Kind>(){

                    @Override
                    public Kind findValueByNumber(int number) {
                        return Kind.valueOf(number);
                    }
                };
            }
        }
    }

    public static final class TypeParameter
    extends GeneratedMessageLite.ExtendableMessage<TypeParameter>
    implements ProtoBuf$TypeParameterOrBuilder {
        private static final TypeParameter defaultInstance;
        private final ByteString unknownFields;
        public static Parser<TypeParameter> PARSER;
        private int bitField0_;
        private int id_;
        private int name_;
        private boolean reified_;
        private Variance variance_;
        private List<Type> upperBound_;
        private List<Integer> upperBoundId_;
        private int upperBoundIdMemoizedSerializedSize = -1;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeParameter(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private TypeParameter(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block25: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block25;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block25;
                            done = true;
                            continue block25;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.id_ = input.readInt32();
                            continue block25;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.name_ = input.readInt32();
                            continue block25;
                        }
                        case 24: {
                            this.bitField0_ |= 4;
                            this.reified_ = input.readBool();
                            continue block25;
                        }
                        case 32: {
                            int rawValue = input.readEnum();
                            Variance value = Variance.valueOf(rawValue);
                            if (value == null) {
                                unknownFieldsCodedOutput.writeRawVarint32(tag);
                                unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                continue block25;
                            }
                            this.bitField0_ |= 8;
                            this.variance_ = value;
                            continue block25;
                        }
                        case 42: {
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.upperBound_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.upperBound_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block25;
                        }
                        case 48: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.upperBoundId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.upperBoundId_.add(input.readInt32());
                            continue block25;
                        }
                        case 50: 
                    }
                    int length = input.readRawVarint32();
                    int limit = input.pushLimit(length);
                    if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) {
                        this.upperBoundId_ = new ArrayList<Integer>();
                        mutable_bitField0_ |= 0x20;
                    }
                    while (input.getBytesUntilLimit() > 0) {
                        this.upperBoundId_.add(input.readInt32());
                    }
                    input.popLimit(limit);
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getName() {
            return this.name_;
        }

        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean getReified() {
            return this.reified_;
        }

        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public Type getUpperBound(int index) {
            return this.upperBound_.get(index);
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i2 = 0; i2 < this.getUpperBoundCount(); ++i2) {
                if (this.getUpperBound(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i2;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeEnum(4, this.variance_.getNumber());
            }
            for (i2 = 0; i2 < this.upperBound_.size(); ++i2) {
                output.writeMessage(5, this.upperBound_.get(i2));
            }
            if (this.getUpperBoundIdList().size() > 0) {
                output.writeRawVarint32(50);
                output.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
            }
            for (i2 = 0; i2 < this.upperBoundId_.size(); ++i2) {
                output.writeInt32NoTag(this.upperBoundId_.get(i2));
            }
            extensionWriter.writeUntil(1000, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeBoolSize(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
            }
            for (int i2 = 0; i2 < this.upperBound_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i2));
            }
            int dataSize = 0;
            for (int i3 = 0; i3 < this.upperBoundId_.size(); ++i3) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i3));
            }
            size += dataSize;
            if (!this.getUpperBoundIdList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.upperBoundIdMemoizedSerializedSize = dataSize;
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return TypeParameter.newBuilder();
        }

        public static Builder newBuilder(TypeParameter prototype) {
            return TypeParameter.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return TypeParameter.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<TypeParameter>(){

                @Override
                public TypeParameter parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new TypeParameter(input, extensionRegistry);
                }
            };
            defaultInstance = new TypeParameter(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder>
        implements ProtoBuf$TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private Variance variance_ = Variance.INV;
            private List<Type> upperBound_ = Collections.emptyList();
            private List<Integer> upperBoundId_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override
            public TypeParameter build() {
                TypeParameter result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public TypeParameter buildPartial() {
                TypeParameter result = new TypeParameter(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.reified_ = this.reified_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.variance_ = this.variance_;
                if ((this.bitField0_ & 0x10) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result.upperBound_ = this.upperBound_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.upperBoundId_ = this.upperBoundId_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(TypeParameter other) {
                if (other == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.setId(other.getId());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasReified()) {
                    this.setReified(other.getReified());
                }
                if (other.hasVariance()) {
                    this.setVariance(other.getVariance());
                }
                if (!other.upperBound_.isEmpty()) {
                    if (this.upperBound_.isEmpty()) {
                        this.upperBound_ = other.upperBound_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        this.ensureUpperBoundIsMutable();
                        this.upperBound_.addAll(other.upperBound_);
                    }
                }
                if (!other.upperBoundId_.isEmpty()) {
                    if (this.upperBoundId_.isEmpty()) {
                        this.upperBoundId_ = other.upperBoundId_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureUpperBoundIdIsMutable();
                        this.upperBoundId_.addAll(other.upperBoundId_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasId()) {
                    return false;
                }
                if (!this.hasName()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.getUpperBoundCount(); ++i2) {
                    if (this.getUpperBound(i2).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TypeParameter parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (TypeParameter)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public Builder setId(int value) {
                this.bitField0_ |= 1;
                this.id_ = value;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 2;
                this.name_ = value;
                return this;
            }

            public Builder setReified(boolean value) {
                this.bitField0_ |= 4;
                this.reified_ = value;
                return this;
            }

            public Builder setVariance(Variance value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.variance_ = value;
                return this;
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.upperBound_ = new ArrayList<Type>(this.upperBound_);
                    this.bitField0_ |= 0x10;
                }
            }

            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            public Type getUpperBound(int index) {
                return this.upperBound_.get(index);
            }

            public Builder addUpperBound(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureUpperBoundIsMutable();
                this.upperBound_.add(value);
                return this;
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.upperBoundId_ = new ArrayList<Integer>(this.upperBoundId_);
                    this.bitField0_ |= 0x20;
                }
            }
        }

        public static enum Variance implements Internal.EnumLite
        {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);

            private static Internal.EnumLiteMap<Variance> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int value) {
                switch (value) {
                    case 0: {
                        return IN;
                    }
                    case 1: {
                        return OUT;
                    }
                    case 2: {
                        return INV;
                    }
                }
                return null;
            }

            private Variance(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<Variance>(){

                    @Override
                    public Variance findValueByNumber(int number) {
                        return Variance.valueOf(number);
                    }
                };
            }
        }
    }

    public static final class Type
    extends GeneratedMessageLite.ExtendableMessage<Type>
    implements ProtoBuf$TypeOrBuilder {
        private static final Type defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Type> PARSER;
        private int bitField0_;
        private List<Argument> argument_;
        private boolean nullable_;
        private int flexibleTypeCapabilitiesId_;
        private Type flexibleUpperBound_;
        private int flexibleUpperBoundId_;
        private int className_;
        private int typeParameter_;
        private int typeParameterName_;
        private int typeAliasName_;
        private Type outerType_;
        private int outerTypeId_;
        private Type abbreviatedType_;
        private int abbreviatedTypeId_;
        private int flags_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Type(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Type(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block32: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block32;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block32;
                            done = true;
                            continue block32;
                        }
                        case 8: {
                            this.bitField0_ |= 0x1000;
                            this.flags_ = input.readInt32();
                            continue block32;
                        }
                        case 18: {
                            if (!(mutable_bitField0_ & true)) {
                                this.argument_ = new ArrayList<Argument>();
                                mutable_bitField0_ |= true;
                            }
                            this.argument_.add(input.readMessage(Argument.PARSER, extensionRegistry));
                            continue block32;
                        }
                        case 24: {
                            this.bitField0_ |= 1;
                            this.nullable_ = input.readBool();
                            continue block32;
                        }
                        case 32: {
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = input.readInt32();
                            continue block32;
                        }
                        case 42: {
                            Builder subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.flexibleUpperBound_.toBuilder();
                            }
                            this.flexibleUpperBound_ = input.readMessage(PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.flexibleUpperBound_);
                                this.flexibleUpperBound_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block32;
                        }
                        case 48: {
                            this.bitField0_ |= 0x10;
                            this.className_ = input.readInt32();
                            continue block32;
                        }
                        case 56: {
                            this.bitField0_ |= 0x20;
                            this.typeParameter_ = input.readInt32();
                            continue block32;
                        }
                        case 64: {
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = input.readInt32();
                            continue block32;
                        }
                        case 72: {
                            this.bitField0_ |= 0x40;
                            this.typeParameterName_ = input.readInt32();
                            continue block32;
                        }
                        case 82: {
                            Builder subBuilder = null;
                            if ((this.bitField0_ & 0x100) == 256) {
                                subBuilder = this.outerType_.toBuilder();
                            }
                            this.outerType_ = input.readMessage(PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.outerType_);
                                this.outerType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x100;
                            continue block32;
                        }
                        case 88: {
                            this.bitField0_ |= 0x200;
                            this.outerTypeId_ = input.readInt32();
                            continue block32;
                        }
                        case 96: {
                            this.bitField0_ |= 0x80;
                            this.typeAliasName_ = input.readInt32();
                            continue block32;
                        }
                        case 106: {
                            Builder subBuilder = null;
                            if ((this.bitField0_ & 0x400) == 1024) {
                                subBuilder = this.abbreviatedType_.toBuilder();
                            }
                            this.abbreviatedType_ = input.readMessage(PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.abbreviatedType_);
                                this.abbreviatedType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x400;
                            continue block32;
                        }
                        case 112: 
                    }
                    this.bitField0_ |= 0x800;
                    this.abbreviatedTypeId_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Type> getParserForType() {
            return PARSER;
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public Argument getArgument(int index) {
            return this.argument_.get(index);
        }

        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean hasClassName() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getClassName() {
            return this.className_;
        }

        public boolean hasTypeParameter() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 0x100) == 256;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 0x200) == 512;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 0x400) == 1024;
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 0x800) == 2048;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 0x1000) == 4096;
        }

        public int getFlags() {
            return this.flags_;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = Type.getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = Type.getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = Type.getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.getArgumentCount(); ++i2) {
                if (this.getArgument(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasFlexibleUpperBound() && !this.getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasOuterType() && !this.getOuterType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasAbbreviatedType() && !this.getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 0x1000) == 4096) {
                output.writeInt32(1, this.flags_);
            }
            for (int i2 = 0; i2 < this.argument_.size(); ++i2) {
                output.writeMessage(2, this.argument_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(6, this.className_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeMessage(10, this.outerType_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                output.writeMessage(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                output.writeInt32(14, this.abbreviatedTypeId_);
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 0x1000) == 4096) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            for (int i2 = 0; i2 < this.argument_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeBoolSize(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(6, this.className_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeMessageSize(10, this.outerType_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Type.newBuilder();
        }

        public static Builder newBuilder(Type prototype) {
            return Type.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Type.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Type>(){

                @Override
                public Type parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Type(input, extensionRegistry);
                }
            };
            defaultInstance = new Type(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Type, Builder>
        implements ProtoBuf$TypeOrBuilder {
            private int bitField0_;
            private List<Argument> argument_ = Collections.emptyList();
            private boolean nullable_;
            private int flexibleTypeCapabilitiesId_;
            private Type flexibleUpperBound_ = Type.getDefaultInstance();
            private int flexibleUpperBoundId_;
            private int className_;
            private int typeParameter_;
            private int typeParameterName_;
            private int typeAliasName_;
            private Type outerType_ = Type.getDefaultInstance();
            private int outerTypeId_;
            private Type abbreviatedType_ = Type.getDefaultInstance();
            private int abbreviatedTypeId_;
            private int flags_;

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            @Override
            public Type build() {
                Type result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Type buildPartial() {
                Type result = new Type(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & 1) == 1) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.argument_ = this.argument_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 1;
                }
                result.nullable_ = this.nullable_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 2;
                }
                result.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 4;
                }
                result.flexibleUpperBound_ = this.flexibleUpperBound_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 8;
                }
                result.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x10;
                }
                result.className_ = this.className_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x40;
                }
                result.typeParameterName_ = this.typeParameterName_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x80;
                }
                result.typeAliasName_ = this.typeAliasName_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x100;
                }
                result.outerType_ = this.outerType_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 0x200;
                }
                result.outerTypeId_ = this.outerTypeId_;
                if ((from_bitField0_ & 0x800) == 2048) {
                    to_bitField0_ |= 0x400;
                }
                result.abbreviatedType_ = this.abbreviatedType_;
                if ((from_bitField0_ & 0x1000) == 4096) {
                    to_bitField0_ |= 0x800;
                }
                result.abbreviatedTypeId_ = this.abbreviatedTypeId_;
                if ((from_bitField0_ & 0x2000) == 8192) {
                    to_bitField0_ |= 0x1000;
                }
                result.flags_ = this.flags_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Type other) {
                if (other == Type.getDefaultInstance()) {
                    return this;
                }
                if (!other.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = other.argument_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureArgumentIsMutable();
                        this.argument_.addAll(other.argument_);
                    }
                }
                if (other.hasNullable()) {
                    this.setNullable(other.getNullable());
                }
                if (other.hasFlexibleTypeCapabilitiesId()) {
                    this.setFlexibleTypeCapabilitiesId(other.getFlexibleTypeCapabilitiesId());
                }
                if (other.hasFlexibleUpperBound()) {
                    this.mergeFlexibleUpperBound(other.getFlexibleUpperBound());
                }
                if (other.hasFlexibleUpperBoundId()) {
                    this.setFlexibleUpperBoundId(other.getFlexibleUpperBoundId());
                }
                if (other.hasClassName()) {
                    this.setClassName(other.getClassName());
                }
                if (other.hasTypeParameter()) {
                    this.setTypeParameter(other.getTypeParameter());
                }
                if (other.hasTypeParameterName()) {
                    this.setTypeParameterName(other.getTypeParameterName());
                }
                if (other.hasTypeAliasName()) {
                    this.setTypeAliasName(other.getTypeAliasName());
                }
                if (other.hasOuterType()) {
                    this.mergeOuterType(other.getOuterType());
                }
                if (other.hasOuterTypeId()) {
                    this.setOuterTypeId(other.getOuterTypeId());
                }
                if (other.hasAbbreviatedType()) {
                    this.mergeAbbreviatedType(other.getAbbreviatedType());
                }
                if (other.hasAbbreviatedTypeId()) {
                    this.setAbbreviatedTypeId(other.getAbbreviatedTypeId());
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < this.getArgumentCount(); ++i2) {
                    if (this.getArgument(i2).isInitialized()) continue;
                    return false;
                }
                if (this.hasFlexibleUpperBound() && !this.getFlexibleUpperBound().isInitialized()) {
                    return false;
                }
                if (this.hasOuterType() && !this.getOuterType().isInitialized()) {
                    return false;
                }
                if (this.hasAbbreviatedType() && !this.getAbbreviatedType().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Type parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Type)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.argument_ = new ArrayList<Argument>(this.argument_);
                    this.bitField0_ |= 1;
                }
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Argument getArgument(int index) {
                return this.argument_.get(index);
            }

            public Builder addArgument(Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.add(builderForValue.build());
                return this;
            }

            public Builder setNullable(boolean value) {
                this.bitField0_ |= 2;
                this.nullable_ = value;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int value) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = value;
                return this;
            }

            public boolean hasFlexibleUpperBound() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Builder setFlexibleUpperBound(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.flexibleUpperBound_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeFlexibleUpperBound(Type value) {
                this.flexibleUpperBound_ = (this.bitField0_ & 8) == 8 && this.flexibleUpperBound_ != Type.getDefaultInstance() ? Type.newBuilder(this.flexibleUpperBound_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int value) {
                this.bitField0_ |= 0x10;
                this.flexibleUpperBoundId_ = value;
                return this;
            }

            public Builder setClassName(int value) {
                this.bitField0_ |= 0x20;
                this.className_ = value;
                return this;
            }

            public Builder setTypeParameter(int value) {
                this.bitField0_ |= 0x40;
                this.typeParameter_ = value;
                return this;
            }

            public Builder setTypeParameterName(int value) {
                this.bitField0_ |= 0x80;
                this.typeParameterName_ = value;
                return this;
            }

            public Builder setTypeAliasName(int value) {
                this.bitField0_ |= 0x100;
                this.typeAliasName_ = value;
                return this;
            }

            public boolean hasOuterType() {
                return (this.bitField0_ & 0x200) == 512;
            }

            public Type getOuterType() {
                return this.outerType_;
            }

            public Builder setOuterType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.outerType_ = value;
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder mergeOuterType(Type value) {
                this.outerType_ = (this.bitField0_ & 0x200) == 512 && this.outerType_ != Type.getDefaultInstance() ? Type.newBuilder(this.outerType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder setOuterTypeId(int value) {
                this.bitField0_ |= 0x400;
                this.outerTypeId_ = value;
                return this;
            }

            public boolean hasAbbreviatedType() {
                return (this.bitField0_ & 0x800) == 2048;
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Builder setAbbreviatedType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.abbreviatedType_ = value;
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder mergeAbbreviatedType(Type value) {
                this.abbreviatedType_ = (this.bitField0_ & 0x800) == 2048 && this.abbreviatedType_ != Type.getDefaultInstance() ? Type.newBuilder(this.abbreviatedType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder setAbbreviatedTypeId(int value) {
                this.bitField0_ |= 0x1000;
                this.abbreviatedTypeId_ = value;
                return this;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 0x2000;
                this.flags_ = value;
                return this;
            }
        }

        public static final class Argument
        extends GeneratedMessageLite
        implements ProtoBuf$Type$ArgumentOrBuilder {
            private static final Argument defaultInstance;
            private final ByteString unknownFields;
            public static Parser<Argument> PARSER;
            private int bitField0_;
            private Projection projection_;
            private Type type_;
            private int typeId_;
            private byte memoizedIsInitialized = (byte)-1;
            private int memoizedSerializedSize = -1;

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean noInit) {
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            private Argument(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this.initFields();
                boolean mutable_bitField0_ = false;
                ByteString.Output unknownFieldsOutput = ByteString.newOutput();
                CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
                try {
                    boolean done = false;
                    block21: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block21;
                            }
                            default: {
                                if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block21;
                                done = true;
                                continue block21;
                            }
                            case 8: {
                                int rawValue = input.readEnum();
                                Projection value = Projection.valueOf(rawValue);
                                if (value == null) {
                                    unknownFieldsCodedOutput.writeRawVarint32(tag);
                                    unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                    continue block21;
                                }
                                this.bitField0_ |= 1;
                                this.projection_ = value;
                                continue block21;
                            }
                            case 18: {
                                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder subBuilder = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    subBuilder = this.type_.toBuilder();
                                }
                                this.type_ = input.readMessage(PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(this.type_);
                                    this.type_ = subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                                continue block21;
                            }
                            case 24: 
                        }
                        this.bitField0_ |= 4;
                        this.typeId_ = input.readInt32();
                    }
                }
                catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
                catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
                finally {
                    try {
                        unknownFieldsCodedOutput.flush();
                    }
                    catch (IOException iOException) {
                    }
                    finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    this.makeExtensionsImmutable();
                }
            }

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasTypeId() {
                return (this.bitField0_ & 4) == 4;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            @Override
            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized == 1) {
                    return true;
                }
                if (isInitialized == 0) {
                    return false;
                }
                if (this.hasType() && !this.getType().isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override
            public void writeTo(CodedOutputStream output) throws IOException {
                this.getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    output.writeEnum(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeMessage(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeInt32(3, this.typeId_);
                }
                output.writeRawBytes(this.unknownFields);
            }

            @Override
            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if ((this.bitField0_ & 1) == 1) {
                    size += CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    size += CodedOutputStream.computeMessageSize(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    size += CodedOutputStream.computeInt32Size(3, this.typeId_);
                }
                this.memoizedSerializedSize = size += this.unknownFields.size();
                return size;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override
            public Builder newBuilderForType() {
                return Argument.newBuilder();
            }

            public static Builder newBuilder(Argument prototype) {
                return Argument.newBuilder().mergeFrom(prototype);
            }

            @Override
            public Builder toBuilder() {
                return Argument.newBuilder(this);
            }

            static {
                PARSER = new AbstractParser<Argument>(){

                    @Override
                    public Argument parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        return new Argument(input, extensionRegistry);
                    }
                };
                defaultInstance = new Argument(true);
                defaultInstance.initFields();
            }

            public static final class Builder
            extends GeneratedMessageLite.Builder<Argument, Builder>
            implements ProtoBuf$Type$ArgumentOrBuilder {
                private int bitField0_;
                private Projection projection_ = Projection.INV;
                private Type type_ = Type.getDefaultInstance();
                private int typeId_;

                private Builder() {
                    this.maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                }

                private static Builder create() {
                    return new Builder();
                }

                @Override
                public Builder clone() {
                    return Builder.create().mergeFrom(this.buildPartial());
                }

                @Override
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override
                public Argument build() {
                    Argument result = this.buildPartial();
                    if (!result.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result);
                    }
                    return result;
                }

                public Argument buildPartial() {
                    Argument result = new Argument(this);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ |= 1;
                    }
                    result.projection_ = this.projection_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result.type_ = this.type_;
                    if ((from_bitField0_ & 4) == 4) {
                        to_bitField0_ |= 4;
                    }
                    result.typeId_ = this.typeId_;
                    result.bitField0_ = to_bitField0_;
                    return result;
                }

                @Override
                public Builder mergeFrom(Argument other) {
                    if (other == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasProjection()) {
                        this.setProjection(other.getProjection());
                    }
                    if (other.hasType()) {
                        this.mergeType(other.getType());
                    }
                    if (other.hasTypeId()) {
                        this.setTypeId(other.getTypeId());
                    }
                    this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                    return this;
                }

                @Override
                public final boolean isInitialized() {
                    return !this.hasType() || this.getType().isInitialized();
                }

                @Override
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    Argument parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e2) {
                        parsedMessage = (Argument)e2.getUnfinishedMessage();
                        throw e2;
                    }
                    finally {
                        if (parsedMessage != null) {
                            this.mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                public Builder setProjection(Projection value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 1;
                    this.projection_ = value;
                    return this;
                }

                public boolean hasType() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Type getType() {
                    return this.type_;
                }

                public Builder setType(Type value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.type_ = value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder mergeType(Type value) {
                    this.type_ = (this.bitField0_ & 2) == 2 && this.type_ != Type.getDefaultInstance() ? Type.newBuilder(this.type_).mergeFrom(value).buildPartial() : value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setTypeId(int value) {
                    this.bitField0_ |= 4;
                    this.typeId_ = value;
                    return this;
                }
            }

            public static enum Projection implements Internal.EnumLite
            {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);

                private static Internal.EnumLiteMap<Projection> internalValueMap;
                private final int value;

                @Override
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int value) {
                    switch (value) {
                        case 0: {
                            return IN;
                        }
                        case 1: {
                            return OUT;
                        }
                        case 2: {
                            return INV;
                        }
                        case 3: {
                            return STAR;
                        }
                    }
                    return null;
                }

                private Projection(int index, int value) {
                    this.value = value;
                }

                static {
                    internalValueMap = new Internal.EnumLiteMap<Projection>(){

                        @Override
                        public Projection findValueByNumber(int number) {
                            return Projection.valueOf(number);
                        }
                    };
                }
            }
        }
    }

    public static final class Annotation
    extends GeneratedMessageLite
    implements ProtoBuf$AnnotationOrBuilder {
        private static final Annotation defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Annotation> PARSER;
        private int bitField0_;
        private int id_;
        private List<Argument> argument_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private Annotation(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Annotation(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Annotation(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block20: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block20;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block20;
                            done = true;
                            continue block20;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.id_ = input.readInt32();
                            continue block20;
                        }
                        case 18: 
                    }
                    if ((mutable_bitField0_ & 2) != 2) {
                        this.argument_ = new ArrayList<Argument>();
                        mutable_bitField0_ |= 2;
                    }
                    this.argument_.add(input.readMessage(Argument.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getId() {
            return this.id_;
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public Argument getArgument(int index) {
            return this.argument_.get(index);
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i2 = 0; i2 < this.getArgumentCount(); ++i2) {
                if (this.getArgument(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.id_);
            }
            for (int i2 = 0; i2 < this.argument_.size(); ++i2) {
                output.writeMessage(2, this.argument_.get(i2));
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            for (int i2 = 0; i2 < this.argument_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Annotation.newBuilder();
        }

        public static Builder newBuilder(Annotation prototype) {
            return Annotation.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Annotation.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Annotation>(){

                @Override
                public Annotation parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Annotation(input, extensionRegistry);
                }
            };
            defaultInstance = new Annotation(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<Annotation, Builder>
        implements ProtoBuf$AnnotationOrBuilder {
            private int bitField0_;
            private int id_;
            private List<Argument> argument_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override
            public Annotation build() {
                Annotation result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public Annotation buildPartial() {
                Annotation result = new Annotation(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.id_ = this.id_;
                if ((this.bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.argument_ = this.argument_;
                result.bitField0_ = to_bitField0_;
                return result;
            }

            @Override
            public Builder mergeFrom(Annotation other) {
                if (other == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.setId(other.getId());
                }
                if (!other.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = other.argument_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureArgumentIsMutable();
                        this.argument_.addAll(other.argument_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasId()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.getArgumentCount(); ++i2) {
                    if (this.getArgument(i2).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Annotation parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (Annotation)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public Builder setId(int value) {
                this.bitField0_ |= 1;
                this.id_ = value;
                return this;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.argument_ = new ArrayList<Argument>(this.argument_);
                    this.bitField0_ |= 2;
                }
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public Argument getArgument(int index) {
                return this.argument_.get(index);
            }

            public Builder addArgument(Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.add(builderForValue.build());
                return this;
            }
        }

        public static final class Argument
        extends GeneratedMessageLite
        implements ProtoBuf$Annotation$ArgumentOrBuilder {
            private static final Argument defaultInstance;
            private final ByteString unknownFields;
            public static Parser<Argument> PARSER;
            private int bitField0_;
            private int nameId_;
            private Value value_;
            private byte memoizedIsInitialized = (byte)-1;
            private int memoizedSerializedSize = -1;

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean noInit) {
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            private Argument(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this.initFields();
                boolean mutable_bitField0_ = false;
                ByteString.Output unknownFieldsOutput = ByteString.newOutput();
                CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
                try {
                    boolean done = false;
                    block20: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block20;
                            }
                            default: {
                                if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block20;
                                done = true;
                                continue block20;
                            }
                            case 8: {
                                this.bitField0_ |= 1;
                                this.nameId_ = input.readInt32();
                                continue block20;
                            }
                            case 18: 
                        }
                        Value.Builder subBuilder = null;
                        if ((this.bitField0_ & 2) == 2) {
                            subBuilder = this.value_.toBuilder();
                        }
                        this.value_ = input.readMessage(Value.PARSER, extensionRegistry);
                        if (subBuilder != null) {
                            subBuilder.mergeFrom(this.value_);
                            this.value_ = subBuilder.buildPartial();
                        }
                        this.bitField0_ |= 2;
                    }
                }
                catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
                catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
                finally {
                    try {
                        unknownFieldsCodedOutput.flush();
                    }
                    catch (IOException iOException) {
                    }
                    finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    this.makeExtensionsImmutable();
                }
            }

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getNameId() {
                return this.nameId_;
            }

            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public Value getValue() {
                return this.value_;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            @Override
            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized == 1) {
                    return true;
                }
                if (isInitialized == 0) {
                    return false;
                }
                if (!this.hasNameId()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                if (!this.hasValue()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                if (!this.getValue().isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override
            public void writeTo(CodedOutputStream output) throws IOException {
                this.getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    output.writeInt32(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeMessage(2, this.value_);
                }
                output.writeRawBytes(this.unknownFields);
            }

            @Override
            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if ((this.bitField0_ & 1) == 1) {
                    size += CodedOutputStream.computeInt32Size(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size += CodedOutputStream.computeMessageSize(2, this.value_);
                }
                this.memoizedSerializedSize = size += this.unknownFields.size();
                return size;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override
            public Builder newBuilderForType() {
                return Argument.newBuilder();
            }

            public static Builder newBuilder(Argument prototype) {
                return Argument.newBuilder().mergeFrom(prototype);
            }

            @Override
            public Builder toBuilder() {
                return Argument.newBuilder(this);
            }

            static {
                PARSER = new AbstractParser<Argument>(){

                    @Override
                    public Argument parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        return new Argument(input, extensionRegistry);
                    }
                };
                defaultInstance = new Argument(true);
                defaultInstance.initFields();
            }

            public static final class Builder
            extends GeneratedMessageLite.Builder<Argument, Builder>
            implements ProtoBuf$Annotation$ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_ = Value.getDefaultInstance();

                private Builder() {
                    this.maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                }

                private static Builder create() {
                    return new Builder();
                }

                @Override
                public Builder clone() {
                    return Builder.create().mergeFrom(this.buildPartial());
                }

                @Override
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override
                public Argument build() {
                    Argument result = this.buildPartial();
                    if (!result.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result);
                    }
                    return result;
                }

                public Argument buildPartial() {
                    Argument result = new Argument(this);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ |= 1;
                    }
                    result.nameId_ = this.nameId_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result.value_ = this.value_;
                    result.bitField0_ = to_bitField0_;
                    return result;
                }

                @Override
                public Builder mergeFrom(Argument other) {
                    if (other == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasNameId()) {
                        this.setNameId(other.getNameId());
                    }
                    if (other.hasValue()) {
                        this.mergeValue(other.getValue());
                    }
                    this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                    return this;
                }

                @Override
                public final boolean isInitialized() {
                    if (!this.hasNameId()) {
                        return false;
                    }
                    if (!this.hasValue()) {
                        return false;
                    }
                    return this.getValue().isInitialized();
                }

                @Override
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    Argument parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e2) {
                        parsedMessage = (Argument)e2.getUnfinishedMessage();
                        throw e2;
                    }
                    finally {
                        if (parsedMessage != null) {
                            this.mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                public boolean hasNameId() {
                    return (this.bitField0_ & 1) == 1;
                }

                public Builder setNameId(int value) {
                    this.bitField0_ |= 1;
                    this.nameId_ = value;
                    return this;
                }

                public boolean hasValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Value getValue() {
                    return this.value_;
                }

                public Builder setValue(Value value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.value_ = value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder mergeValue(Value value) {
                    this.value_ = (this.bitField0_ & 2) == 2 && this.value_ != Value.getDefaultInstance() ? Value.newBuilder(this.value_).mergeFrom(value).buildPartial() : value;
                    this.bitField0_ |= 2;
                    return this;
                }
            }

            public static final class Value
            extends GeneratedMessageLite
            implements ProtoBuf$Annotation$Argument$ValueOrBuilder {
                private static final Value defaultInstance;
                private final ByteString unknownFields;
                public static Parser<Value> PARSER;
                private int bitField0_;
                private Type type_;
                private long intValue_;
                private float floatValue_;
                private double doubleValue_;
                private int stringValue_;
                private int classId_;
                private int enumValueId_;
                private Annotation annotation_;
                private List<Value> arrayElement_;
                private int arrayDimensionCount_;
                private int flags_;
                private byte memoizedIsInitialized = (byte)-1;
                private int memoizedSerializedSize = -1;

                private Value(GeneratedMessageLite.Builder builder) {
                    super(builder);
                    this.unknownFields = builder.getUnknownFields();
                }

                private Value(boolean noInit) {
                    this.unknownFields = ByteString.EMPTY;
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                @Override
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                private Value(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    this.initFields();
                    int mutable_bitField0_ = 0;
                    ByteString.Output unknownFieldsOutput = ByteString.newOutput();
                    CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
                    try {
                        boolean done = false;
                        block29: while (!done) {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0: {
                                    done = true;
                                    continue block29;
                                }
                                default: {
                                    if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block29;
                                    done = true;
                                    continue block29;
                                }
                                case 8: {
                                    int rawValue = input.readEnum();
                                    Type value = Type.valueOf(rawValue);
                                    if (value == null) {
                                        unknownFieldsCodedOutput.writeRawVarint32(tag);
                                        unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                        continue block29;
                                    }
                                    this.bitField0_ |= 1;
                                    this.type_ = value;
                                    continue block29;
                                }
                                case 16: {
                                    this.bitField0_ |= 2;
                                    this.intValue_ = input.readSInt64();
                                    continue block29;
                                }
                                case 29: {
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = input.readFloat();
                                    continue block29;
                                }
                                case 33: {
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = input.readDouble();
                                    continue block29;
                                }
                                case 40: {
                                    this.bitField0_ |= 0x10;
                                    this.stringValue_ = input.readInt32();
                                    continue block29;
                                }
                                case 48: {
                                    this.bitField0_ |= 0x20;
                                    this.classId_ = input.readInt32();
                                    continue block29;
                                }
                                case 56: {
                                    this.bitField0_ |= 0x40;
                                    this.enumValueId_ = input.readInt32();
                                    continue block29;
                                }
                                case 66: {
                                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Builder subBuilder = null;
                                    if ((this.bitField0_ & 0x80) == 128) {
                                        subBuilder = this.annotation_.toBuilder();
                                    }
                                    this.annotation_ = input.readMessage(Annotation.PARSER, extensionRegistry);
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom(this.annotation_);
                                        this.annotation_ = subBuilder.buildPartial();
                                    }
                                    this.bitField0_ |= 0x80;
                                    continue block29;
                                }
                                case 74: {
                                    if ((mutable_bitField0_ & 0x100) != 256) {
                                        this.arrayElement_ = new ArrayList<Value>();
                                        mutable_bitField0_ |= 0x100;
                                    }
                                    this.arrayElement_.add(input.readMessage(PARSER, extensionRegistry));
                                    continue block29;
                                }
                                case 80: {
                                    this.bitField0_ |= 0x200;
                                    this.flags_ = input.readInt32();
                                    continue block29;
                                }
                                case 88: 
                            }
                            this.bitField0_ |= 0x100;
                            this.arrayDimensionCount_ = input.readInt32();
                        }
                    }
                    catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                    catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                    finally {
                        if ((mutable_bitField0_ & 0x100) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        }
                        try {
                            unknownFieldsCodedOutput.flush();
                        }
                        catch (IOException iOException) {
                        }
                        finally {
                            this.unknownFields = unknownFieldsOutput.toByteString();
                        }
                        this.makeExtensionsImmutable();
                    }
                }

                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                public boolean hasType() {
                    return (this.bitField0_ & 1) == 1;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public boolean hasStringValue() {
                    return (this.bitField0_ & 0x10) == 16;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public boolean hasClassId() {
                    return (this.bitField0_ & 0x20) == 32;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 0x40) == 64;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 0x80) == 128;
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public Value getArrayElement(int index) {
                    return this.arrayElement_.get(index);
                }

                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 0x100) == 256;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public boolean hasFlags() {
                    return (this.bitField0_ & 0x200) == 512;
                }

                public int getFlags() {
                    return this.flags_;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                @Override
                public final boolean isInitialized() {
                    byte isInitialized = this.memoizedIsInitialized;
                    if (isInitialized == 1) {
                        return true;
                    }
                    if (isInitialized == 0) {
                        return false;
                    }
                    if (this.hasAnnotation() && !this.getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                    for (int i2 = 0; i2 < this.getArrayElementCount(); ++i2) {
                        if (this.getArrayElement(i2).isInitialized()) continue;
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                    this.memoizedIsInitialized = 1;
                    return true;
                }

                @Override
                public void writeTo(CodedOutputStream output) throws IOException {
                    this.getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        output.writeEnum(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        output.writeSInt64(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        output.writeFloat(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        output.writeDouble(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 0x10) == 16) {
                        output.writeInt32(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 0x20) == 32) {
                        output.writeInt32(6, this.classId_);
                    }
                    if ((this.bitField0_ & 0x40) == 64) {
                        output.writeInt32(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 0x80) == 128) {
                        output.writeMessage(8, this.annotation_);
                    }
                    for (int i2 = 0; i2 < this.arrayElement_.size(); ++i2) {
                        output.writeMessage(9, this.arrayElement_.get(i2));
                    }
                    if ((this.bitField0_ & 0x200) == 512) {
                        output.writeInt32(10, this.flags_);
                    }
                    if ((this.bitField0_ & 0x100) == 256) {
                        output.writeInt32(11, this.arrayDimensionCount_);
                    }
                    output.writeRawBytes(this.unknownFields);
                }

                @Override
                public int getSerializedSize() {
                    int size = this.memoizedSerializedSize;
                    if (size != -1) {
                        return size;
                    }
                    size = 0;
                    if ((this.bitField0_ & 1) == 1) {
                        size += CodedOutputStream.computeEnumSize(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        size += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        size += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        size += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 0x10) == 16) {
                        size += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 0x20) == 32) {
                        size += CodedOutputStream.computeInt32Size(6, this.classId_);
                    }
                    if ((this.bitField0_ & 0x40) == 64) {
                        size += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 0x80) == 128) {
                        size += CodedOutputStream.computeMessageSize(8, this.annotation_);
                    }
                    for (int i2 = 0; i2 < this.arrayElement_.size(); ++i2) {
                        size += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i2));
                    }
                    if ((this.bitField0_ & 0x200) == 512) {
                        size += CodedOutputStream.computeInt32Size(10, this.flags_);
                    }
                    if ((this.bitField0_ & 0x100) == 256) {
                        size += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                    }
                    this.memoizedSerializedSize = size += this.unknownFields.size();
                    return size;
                }

                public static Builder newBuilder() {
                    return Builder.create();
                }

                @Override
                public Builder newBuilderForType() {
                    return Value.newBuilder();
                }

                public static Builder newBuilder(Value prototype) {
                    return Value.newBuilder().mergeFrom(prototype);
                }

                @Override
                public Builder toBuilder() {
                    return Value.newBuilder(this);
                }

                static {
                    PARSER = new AbstractParser<Value>(){

                        @Override
                        public Value parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                            return new Value(input, extensionRegistry);
                        }
                    };
                    defaultInstance = new Value(true);
                    defaultInstance.initFields();
                }

                public static final class Builder
                extends GeneratedMessageLite.Builder<Value, Builder>
                implements ProtoBuf$Annotation$Argument$ValueOrBuilder {
                    private int bitField0_;
                    private Type type_ = Type.BYTE;
                    private long intValue_;
                    private float floatValue_;
                    private double doubleValue_;
                    private int stringValue_;
                    private int classId_;
                    private int enumValueId_;
                    private Annotation annotation_ = Annotation.getDefaultInstance();
                    private List<Value> arrayElement_ = Collections.emptyList();
                    private int arrayDimensionCount_;
                    private int flags_;

                    private Builder() {
                        this.maybeForceBuilderInitialization();
                    }

                    private void maybeForceBuilderInitialization() {
                    }

                    private static Builder create() {
                        return new Builder();
                    }

                    @Override
                    public Builder clone() {
                        return Builder.create().mergeFrom(this.buildPartial());
                    }

                    @Override
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override
                    public Value build() {
                        Value result = this.buildPartial();
                        if (!result.isInitialized()) {
                            throw Builder.newUninitializedMessageException(result);
                        }
                        return result;
                    }

                    public Value buildPartial() {
                        Value result = new Value(this);
                        int from_bitField0_ = this.bitField0_;
                        int to_bitField0_ = 0;
                        if ((from_bitField0_ & 1) == 1) {
                            to_bitField0_ |= 1;
                        }
                        result.type_ = this.type_;
                        if ((from_bitField0_ & 2) == 2) {
                            to_bitField0_ |= 2;
                        }
                        result.intValue_ = this.intValue_;
                        if ((from_bitField0_ & 4) == 4) {
                            to_bitField0_ |= 4;
                        }
                        result.floatValue_ = this.floatValue_;
                        if ((from_bitField0_ & 8) == 8) {
                            to_bitField0_ |= 8;
                        }
                        result.doubleValue_ = this.doubleValue_;
                        if ((from_bitField0_ & 0x10) == 16) {
                            to_bitField0_ |= 0x10;
                        }
                        result.stringValue_ = this.stringValue_;
                        if ((from_bitField0_ & 0x20) == 32) {
                            to_bitField0_ |= 0x20;
                        }
                        result.classId_ = this.classId_;
                        if ((from_bitField0_ & 0x40) == 64) {
                            to_bitField0_ |= 0x40;
                        }
                        result.enumValueId_ = this.enumValueId_;
                        if ((from_bitField0_ & 0x80) == 128) {
                            to_bitField0_ |= 0x80;
                        }
                        result.annotation_ = this.annotation_;
                        if ((this.bitField0_ & 0x100) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            this.bitField0_ &= 0xFFFFFEFF;
                        }
                        result.arrayElement_ = this.arrayElement_;
                        if ((from_bitField0_ & 0x200) == 512) {
                            to_bitField0_ |= 0x100;
                        }
                        result.arrayDimensionCount_ = this.arrayDimensionCount_;
                        if ((from_bitField0_ & 0x400) == 1024) {
                            to_bitField0_ |= 0x200;
                        }
                        result.flags_ = this.flags_;
                        result.bitField0_ = to_bitField0_;
                        return result;
                    }

                    @Override
                    public Builder mergeFrom(Value other) {
                        if (other == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (other.hasType()) {
                            this.setType(other.getType());
                        }
                        if (other.hasIntValue()) {
                            this.setIntValue(other.getIntValue());
                        }
                        if (other.hasFloatValue()) {
                            this.setFloatValue(other.getFloatValue());
                        }
                        if (other.hasDoubleValue()) {
                            this.setDoubleValue(other.getDoubleValue());
                        }
                        if (other.hasStringValue()) {
                            this.setStringValue(other.getStringValue());
                        }
                        if (other.hasClassId()) {
                            this.setClassId(other.getClassId());
                        }
                        if (other.hasEnumValueId()) {
                            this.setEnumValueId(other.getEnumValueId());
                        }
                        if (other.hasAnnotation()) {
                            this.mergeAnnotation(other.getAnnotation());
                        }
                        if (!other.arrayElement_.isEmpty()) {
                            if (this.arrayElement_.isEmpty()) {
                                this.arrayElement_ = other.arrayElement_;
                                this.bitField0_ &= 0xFFFFFEFF;
                            } else {
                                this.ensureArrayElementIsMutable();
                                this.arrayElement_.addAll(other.arrayElement_);
                            }
                        }
                        if (other.hasArrayDimensionCount()) {
                            this.setArrayDimensionCount(other.getArrayDimensionCount());
                        }
                        if (other.hasFlags()) {
                            this.setFlags(other.getFlags());
                        }
                        this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                        return this;
                    }

                    @Override
                    public final boolean isInitialized() {
                        if (this.hasAnnotation() && !this.getAnnotation().isInitialized()) {
                            return false;
                        }
                        for (int i2 = 0; i2 < this.getArrayElementCount(); ++i2) {
                            if (this.getArrayElement(i2).isInitialized()) continue;
                            return false;
                        }
                        return true;
                    }

                    @Override
                    public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                        Value parsedMessage = null;
                        try {
                            parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                        }
                        catch (InvalidProtocolBufferException e2) {
                            parsedMessage = (Value)e2.getUnfinishedMessage();
                            throw e2;
                        }
                        finally {
                            if (parsedMessage != null) {
                                this.mergeFrom(parsedMessage);
                            }
                        }
                        return this;
                    }

                    public Builder setType(Type value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.bitField0_ |= 1;
                        this.type_ = value;
                        return this;
                    }

                    public Builder setIntValue(long value) {
                        this.bitField0_ |= 2;
                        this.intValue_ = value;
                        return this;
                    }

                    public Builder setFloatValue(float value) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = value;
                        return this;
                    }

                    public Builder setDoubleValue(double value) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = value;
                        return this;
                    }

                    public Builder setStringValue(int value) {
                        this.bitField0_ |= 0x10;
                        this.stringValue_ = value;
                        return this;
                    }

                    public Builder setClassId(int value) {
                        this.bitField0_ |= 0x20;
                        this.classId_ = value;
                        return this;
                    }

                    public Builder setEnumValueId(int value) {
                        this.bitField0_ |= 0x40;
                        this.enumValueId_ = value;
                        return this;
                    }

                    public boolean hasAnnotation() {
                        return (this.bitField0_ & 0x80) == 128;
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Builder setAnnotation(Annotation value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.annotation_ = value;
                        this.bitField0_ |= 0x80;
                        return this;
                    }

                    public Builder mergeAnnotation(Annotation value) {
                        this.annotation_ = (this.bitField0_ & 0x80) == 128 && this.annotation_ != Annotation.getDefaultInstance() ? Annotation.newBuilder(this.annotation_).mergeFrom(value).buildPartial() : value;
                        this.bitField0_ |= 0x80;
                        return this;
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 0x100) != 256) {
                            this.arrayElement_ = new ArrayList<Value>(this.arrayElement_);
                            this.bitField0_ |= 0x100;
                        }
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    public Value getArrayElement(int index) {
                        return this.arrayElement_.get(index);
                    }

                    public Builder addArrayElement(Builder builderForValue) {
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.add(builderForValue.build());
                        return this;
                    }

                    public Builder setArrayDimensionCount(int value) {
                        this.bitField0_ |= 0x200;
                        this.arrayDimensionCount_ = value;
                        return this;
                    }

                    public Builder setFlags(int value) {
                        this.bitField0_ |= 0x400;
                        this.flags_ = value;
                        return this;
                    }
                }

                public static enum Type implements Internal.EnumLite
                {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);

                    private static Internal.EnumLiteMap<Type> internalValueMap;
                    private final int value;

                    @Override
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int value) {
                        switch (value) {
                            case 0: {
                                return BYTE;
                            }
                            case 1: {
                                return CHAR;
                            }
                            case 2: {
                                return SHORT;
                            }
                            case 3: {
                                return INT;
                            }
                            case 4: {
                                return LONG;
                            }
                            case 5: {
                                return FLOAT;
                            }
                            case 6: {
                                return DOUBLE;
                            }
                            case 7: {
                                return BOOLEAN;
                            }
                            case 8: {
                                return STRING;
                            }
                            case 9: {
                                return CLASS;
                            }
                            case 10: {
                                return ENUM;
                            }
                            case 11: {
                                return ANNOTATION;
                            }
                            case 12: {
                                return ARRAY;
                            }
                        }
                        return null;
                    }

                    private Type(int index, int value) {
                        this.value = value;
                    }

                    static {
                        internalValueMap = new Internal.EnumLiteMap<Type>(){

                            @Override
                            public Type findValueByNumber(int number) {
                                return Type.valueOf(number);
                            }
                        };
                    }
                }
            }
        }
    }

    public static final class QualifiedNameTable
    extends GeneratedMessageLite
    implements ProtoBuf$QualifiedNameTableOrBuilder {
        private static final QualifiedNameTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<QualifiedNameTable> PARSER;
        private List<QualifiedName> qualifiedName_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private QualifiedNameTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private QualifiedNameTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private QualifiedNameTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 10: 
                    }
                    if (!(mutable_bitField0_ & true)) {
                        this.qualifiedName_ = new ArrayList<QualifiedName>();
                        mutable_bitField0_ |= true;
                    }
                    this.qualifiedName_.add(input.readMessage(QualifiedName.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        public QualifiedName getQualifiedName(int index) {
            return this.qualifiedName_.get(index);
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.getQualifiedNameCount(); ++i2) {
                if (this.getQualifiedName(i2).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            for (int i2 = 0; i2 < this.qualifiedName_.size(); ++i2) {
                output.writeMessage(1, this.qualifiedName_.get(i2));
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i2 = 0; i2 < this.qualifiedName_.size(); ++i2) {
                size += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i2));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return QualifiedNameTable.newBuilder();
        }

        public static Builder newBuilder(QualifiedNameTable prototype) {
            return QualifiedNameTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return QualifiedNameTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<QualifiedNameTable>(){

                @Override
                public QualifiedNameTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new QualifiedNameTable(input, extensionRegistry);
                }
            };
            defaultInstance = new QualifiedNameTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder>
        implements ProtoBuf$QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override
            public QualifiedNameTable build() {
                QualifiedNameTable result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable result = new QualifiedNameTable(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.qualifiedName_ = this.qualifiedName_;
                return result;
            }

            @Override
            public Builder mergeFrom(QualifiedNameTable other) {
                if (other == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.qualifiedName_.isEmpty()) {
                    if (this.qualifiedName_.isEmpty()) {
                        this.qualifiedName_ = other.qualifiedName_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureQualifiedNameIsMutable();
                        this.qualifiedName_.addAll(other.qualifiedName_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i2 = 0; i2 < this.getQualifiedNameCount(); ++i2) {
                    if (this.getQualifiedName(i2).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                QualifiedNameTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (QualifiedNameTable)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.qualifiedName_ = new ArrayList<QualifiedName>(this.qualifiedName_);
                    this.bitField0_ |= 1;
                }
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            public QualifiedName getQualifiedName(int index) {
                return this.qualifiedName_.get(index);
            }
        }

        public static final class QualifiedName
        extends GeneratedMessageLite
        implements ProtoBuf$QualifiedNameTable$QualifiedNameOrBuilder {
            private static final QualifiedName defaultInstance;
            private final ByteString unknownFields;
            public static Parser<QualifiedName> PARSER;
            private int bitField0_;
            private int parentQualifiedName_;
            private int shortName_;
            private Kind kind_;
            private byte memoizedIsInitialized = (byte)-1;
            private int memoizedSerializedSize = -1;

            private QualifiedName(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.unknownFields = builder.getUnknownFields();
            }

            private QualifiedName(boolean noInit) {
                this.unknownFields = ByteString.EMPTY;
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            @Override
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            private QualifiedName(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this.initFields();
                boolean mutable_bitField0_ = false;
                ByteString.Output unknownFieldsOutput = ByteString.newOutput();
                CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
                try {
                    boolean done = false;
                    block21: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block21;
                            }
                            default: {
                                if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block21;
                                done = true;
                                continue block21;
                            }
                            case 8: {
                                this.bitField0_ |= 1;
                                this.parentQualifiedName_ = input.readInt32();
                                continue block21;
                            }
                            case 16: {
                                this.bitField0_ |= 2;
                                this.shortName_ = input.readInt32();
                                continue block21;
                            }
                            case 24: 
                        }
                        int rawValue = input.readEnum();
                        Kind value = Kind.valueOf(rawValue);
                        if (value == null) {
                            unknownFieldsCodedOutput.writeRawVarint32(tag);
                            unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                            continue;
                        }
                        this.bitField0_ |= 4;
                        this.kind_ = value;
                    }
                }
                catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
                catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
                finally {
                    try {
                        unknownFieldsCodedOutput.flush();
                    }
                    catch (IOException iOException) {
                    }
                    finally {
                        this.unknownFields = unknownFieldsOutput.toByteString();
                    }
                    this.makeExtensionsImmutable();
                }
            }

            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            public boolean hasShortName() {
                return (this.bitField0_ & 2) == 2;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            public Kind getKind() {
                return this.kind_;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            @Override
            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized == 1) {
                    return true;
                }
                if (isInitialized == 0) {
                    return false;
                }
                if (!this.hasShortName()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override
            public void writeTo(CodedOutputStream output) throws IOException {
                this.getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    output.writeInt32(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeEnum(3, this.kind_.getNumber());
                }
                output.writeRawBytes(this.unknownFields);
            }

            @Override
            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if ((this.bitField0_ & 1) == 1) {
                    size += CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size += CodedOutputStream.computeInt32Size(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
                }
                this.memoizedSerializedSize = size += this.unknownFields.size();
                return size;
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override
            public Builder newBuilderForType() {
                return QualifiedName.newBuilder();
            }

            public static Builder newBuilder(QualifiedName prototype) {
                return QualifiedName.newBuilder().mergeFrom(prototype);
            }

            @Override
            public Builder toBuilder() {
                return QualifiedName.newBuilder(this);
            }

            static {
                PARSER = new AbstractParser<QualifiedName>(){

                    @Override
                    public QualifiedName parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        return new QualifiedName(input, extensionRegistry);
                    }
                };
                defaultInstance = new QualifiedName(true);
                defaultInstance.initFields();
            }

            public static final class Builder
            extends GeneratedMessageLite.Builder<QualifiedName, Builder>
            implements ProtoBuf$QualifiedNameTable$QualifiedNameOrBuilder {
                private int bitField0_;
                private int parentQualifiedName_ = -1;
                private int shortName_;
                private Kind kind_ = Kind.PACKAGE;

                private Builder() {
                    this.maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                }

                private static Builder create() {
                    return new Builder();
                }

                @Override
                public Builder clone() {
                    return Builder.create().mergeFrom(this.buildPartial());
                }

                @Override
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override
                public QualifiedName build() {
                    QualifiedName result = this.buildPartial();
                    if (!result.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result);
                    }
                    return result;
                }

                public QualifiedName buildPartial() {
                    QualifiedName result = new QualifiedName(this);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ |= 1;
                    }
                    result.parentQualifiedName_ = this.parentQualifiedName_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result.shortName_ = this.shortName_;
                    if ((from_bitField0_ & 4) == 4) {
                        to_bitField0_ |= 4;
                    }
                    result.kind_ = this.kind_;
                    result.bitField0_ = to_bitField0_;
                    return result;
                }

                @Override
                public Builder mergeFrom(QualifiedName other) {
                    if (other == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasParentQualifiedName()) {
                        this.setParentQualifiedName(other.getParentQualifiedName());
                    }
                    if (other.hasShortName()) {
                        this.setShortName(other.getShortName());
                    }
                    if (other.hasKind()) {
                        this.setKind(other.getKind());
                    }
                    this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                    return this;
                }

                @Override
                public final boolean isInitialized() {
                    return this.hasShortName();
                }

                @Override
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    QualifiedName parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e2) {
                        parsedMessage = (QualifiedName)e2.getUnfinishedMessage();
                        throw e2;
                    }
                    finally {
                        if (parsedMessage != null) {
                            this.mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                public Builder setParentQualifiedName(int value) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = value;
                    return this;
                }

                public boolean hasShortName() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Builder setShortName(int value) {
                    this.bitField0_ |= 2;
                    this.shortName_ = value;
                    return this;
                }

                public Builder setKind(Kind value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 4;
                    this.kind_ = value;
                    return this;
                }
            }

            public static enum Kind implements Internal.EnumLite
            {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);

                private static Internal.EnumLiteMap<Kind> internalValueMap;
                private final int value;

                @Override
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int value) {
                    switch (value) {
                        case 0: {
                            return CLASS;
                        }
                        case 1: {
                            return PACKAGE;
                        }
                        case 2: {
                            return LOCAL;
                        }
                    }
                    return null;
                }

                private Kind(int index, int value) {
                    this.value = value;
                }

                static {
                    internalValueMap = new Internal.EnumLiteMap<Kind>(){

                        @Override
                        public Kind findValueByNumber(int number) {
                            return Kind.valueOf(number);
                        }
                    };
                }
            }
        }
    }

    public static final class StringTable
    extends GeneratedMessageLite
    implements ProtoBuf$StringTableOrBuilder {
        private static final StringTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<StringTable> PARSER;
        private LazyStringList string_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;

        private StringTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private StringTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput, 1);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 10: 
                    }
                    ByteString bs2 = input.readBytes();
                    if (!(mutable_bitField0_ & true)) {
                        this.string_ = new LazyStringArrayList();
                        mutable_bitField0_ |= true;
                    }
                    this.string_.add(bs2);
                }
            }
            catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(this);
            }
            catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.string_ = this.string_.getUnmodifiableView();
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException iOException) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        public ProtocolStringList getStringList() {
            return this.string_;
        }

        public String getString(int index) {
            return (String)this.string_.get(index);
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            for (int i2 = 0; i2 < this.string_.size(); ++i2) {
                output.writeBytes(1, this.string_.getByteString(i2));
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            int dataSize = 0;
            for (int i2 = 0; i2 < this.string_.size(); ++i2) {
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i2));
            }
            size += dataSize;
            size += 1 * this.getStringList().size();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return StringTable.newBuilder();
        }

        public static Builder newBuilder(StringTable prototype) {
            return StringTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return StringTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<StringTable>(){

                @Override
                public StringTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new StringTable(input, extensionRegistry);
                }
            };
            defaultInstance = new StringTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<StringTable, Builder>
        implements ProtoBuf$StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_ = LazyStringArrayList.EMPTY;

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override
            public StringTable build() {
                StringTable result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            public StringTable buildPartial() {
                StringTable result = new StringTable(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.string_ = this.string_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.string_ = this.string_;
                return result;
            }

            @Override
            public Builder mergeFrom(StringTable other) {
                if (other == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.string_.isEmpty()) {
                    if (this.string_.isEmpty()) {
                        this.string_ = other.string_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureStringIsMutable();
                        this.string_.addAll(other.string_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                StringTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e2) {
                    parsedMessage = (StringTable)e2.getUnfinishedMessage();
                    throw e2;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.string_ = new LazyStringArrayList(this.string_);
                    this.bitField0_ |= 1;
                }
            }
        }
    }

    public static enum MemberKind implements Internal.EnumLite
    {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);

        private static Internal.EnumLiteMap<MemberKind> internalValueMap;
        private final int value;

        @Override
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int value) {
            switch (value) {
                case 0: {
                    return DECLARATION;
                }
                case 1: {
                    return FAKE_OVERRIDE;
                }
                case 2: {
                    return DELEGATION;
                }
                case 3: {
                    return SYNTHESIZED;
                }
            }
            return null;
        }

        private MemberKind(int index, int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<MemberKind>(){

                @Override
                public MemberKind findValueByNumber(int number) {
                    return MemberKind.valueOf(number);
                }
            };
        }
    }

    public static enum Visibility implements Internal.EnumLite
    {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);

        private static Internal.EnumLiteMap<Visibility> internalValueMap;
        private final int value;

        @Override
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int value) {
            switch (value) {
                case 0: {
                    return INTERNAL;
                }
                case 1: {
                    return PRIVATE;
                }
                case 2: {
                    return PROTECTED;
                }
                case 3: {
                    return PUBLIC;
                }
                case 4: {
                    return PRIVATE_TO_THIS;
                }
                case 5: {
                    return LOCAL;
                }
            }
            return null;
        }

        private Visibility(int index, int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<Visibility>(){

                @Override
                public Visibility findValueByNumber(int number) {
                    return Visibility.valueOf(number);
                }
            };
        }
    }

    public static enum Modality implements Internal.EnumLite
    {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);

        private static Internal.EnumLiteMap<Modality> internalValueMap;
        private final int value;

        @Override
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int value) {
            switch (value) {
                case 0: {
                    return FINAL;
                }
                case 1: {
                    return OPEN;
                }
                case 2: {
                    return ABSTRACT;
                }
                case 3: {
                    return SEALED;
                }
            }
            return null;
        }

        private Modality(int index, int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<Modality>(){

                @Override
                public Modality findValueByNumber(int number) {
                    return Modality.valueOf(number);
                }
            };
        }
    }
}

