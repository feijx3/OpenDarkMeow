/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AnnotationAndConstantLoader<A, C>
extends AnnotationLoader<A> {
    @Nullable
    public C loadPropertyConstant(@NotNull ProtoContainer var1, @NotNull ProtoBuf.Property var2, @NotNull KotlinType var3);

    @Nullable
    public C loadAnnotationDefaultValue(@NotNull ProtoContainer var1, @NotNull ProtoBuf.Property var2, @NotNull KotlinType var3);
}

