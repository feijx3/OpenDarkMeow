/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.ExperimentalReflectionOnLambdas;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nreflectLambda.kt\nKotlin\n*S Kotlin\n*F\n+ 1 reflectLambda.kt\nkotlin/reflect/jvm/ReflectLambdaKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public final class ReflectLambdaKt {
    @ExperimentalReflectionOnLambdas
    @Nullable
    public static final <R> KFunction<R> reflect(@NotNull Function<? extends R> $this$reflect) {
        String[] stringArray;
        Intrinsics.checkNotNullParameter($this$reflect, "<this>");
        Metadata metadata = $this$reflect.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        Metadata annotation = metadata;
        String[] p0 = stringArray = annotation.d1();
        boolean bl2 = false;
        Object object = !(p0.length == 0) ? stringArray : null;
        if (object == null) {
            return null;
        }
        String[] data = object;
        Pair<JvmNameResolver, ProtoBuf.Function> pair = JvmProtoBufUtil.readFunctionDataFrom(data, annotation.d2());
        JvmNameResolver nameResolver = pair.component1();
        ProtoBuf.Function proto = pair.component2();
        MetadataVersion metadataVersion = new MetadataVersion(annotation.mv(), (annotation.xi() & 8) != 0);
        Class<?> clazz = $this$reflect.getClass();
        MessageLite messageLite = proto;
        NameResolver nameResolver2 = nameResolver;
        ProtoBuf.TypeTable typeTable = proto.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        SimpleFunctionDescriptor descriptor2 = (SimpleFunctionDescriptor)UtilKt.deserializeToDescriptor(clazz, messageLite, nameResolver2, new TypeTable(typeTable), metadataVersion, reflect.descriptor.1.INSTANCE);
        return new KFunctionImpl(EmptyContainerForLocal.INSTANCE, descriptor2);
    }
}

