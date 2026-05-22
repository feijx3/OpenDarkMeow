/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16RecordComponentsLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nReflectJavaRecordComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaRecordComponent.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaRecordComponent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class ReflectJavaRecordComponent
extends ReflectJavaMember
implements JavaRecordComponent {
    @NotNull
    private final Object recordComponent;

    public ReflectJavaRecordComponent(@NotNull Object recordComponent) {
        Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        this.recordComponent = recordComponent;
    }

    @Override
    @NotNull
    public JavaType getType() {
        Class<?> clazz = Java16RecordComponentsLoader.INSTANCE.loadGetType(this.recordComponent);
        if (clazz == null) {
            throw new NoSuchMethodError("Can't find `getType` method");
        }
        Class<?> it = clazz;
        boolean bl2 = false;
        return new ReflectJavaClassifierType(it);
    }

    @Override
    public boolean isVararg() {
        return false;
    }

    @Override
    @NotNull
    public Member getMember() {
        Method method = Java16RecordComponentsLoader.INSTANCE.loadGetAccessor(this.recordComponent);
        if (method == null) {
            throw new NoSuchMethodError("Can't find `getAccessor` method");
        }
        return method;
    }
}

