/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JvmDescriptorTypeWriter<T> {
    @NotNull
    private final JvmTypeFactory<T> jvmTypeFactory;
    private int jvmCurrentTypeArrayLevel;
    @Nullable
    private T jvmCurrentType;

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            ++this.jvmCurrentTypeArrayLevel;
        }
    }

    public void writeArrayEnd() {
    }

    public void writeClass(@NotNull T objectType) {
        Intrinsics.checkNotNullParameter(objectType, "objectType");
        this.writeJvmTypeAsIs(objectType);
    }

    protected final void writeJvmTypeAsIs(@NotNull T type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.jvmCurrentType == null) {
            this.jvmCurrentType = this.jvmCurrentTypeArrayLevel > 0 ? this.jvmTypeFactory.createFromString(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(type)) : type;
        }
    }

    public void writeTypeVariable(@NotNull Name name, @NotNull T type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.writeJvmTypeAsIs(type);
    }
}

