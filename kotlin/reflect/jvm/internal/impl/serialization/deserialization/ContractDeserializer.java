/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ContractDeserializer {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$Companion.$$INSTANCE;

    @Nullable
    public Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(@NotNull ProtoBuf.Function var1, @NotNull FunctionDescriptor var2, @NotNull TypeTable var3, @NotNull TypeDeserializer var4);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final ContractDeserializer DEFAULT;

        private Companion() {
        }

        @NotNull
        public final ContractDeserializer getDEFAULT() {
            return DEFAULT;
        }

        static {
            $$INSTANCE = new Companion();
            DEFAULT = new ContractDeserializer(){

                public Pair deserializeContractFromFunction(ProtoBuf.Function proto, FunctionDescriptor ownerFunction, TypeTable typeTable, TypeDeserializer typeDeserializer) {
                    Intrinsics.checkNotNullParameter(proto, "proto");
                    Intrinsics.checkNotNullParameter(ownerFunction, "ownerFunction");
                    Intrinsics.checkNotNullParameter(typeTable, "typeTable");
                    Intrinsics.checkNotNullParameter(typeDeserializer, "typeDeserializer");
                    return null;
                }
            };
        }
    }
}

