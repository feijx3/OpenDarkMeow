/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class FunctionTypeKind {
    @NotNull
    private final FqName packageFqName;
    @NotNull
    private final String classNamePrefix;
    private final boolean isReflectType;
    @Nullable
    private final ClassId annotationOnInvokeClassId;
    private final boolean isInlineable;

    public FunctionTypeKind(@NotNull FqName packageFqName, @NotNull String classNamePrefix, boolean isReflectType, @Nullable ClassId annotationOnInvokeClassId, boolean isInlineable) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(classNamePrefix, "classNamePrefix");
        this.packageFqName = packageFqName;
        this.classNamePrefix = classNamePrefix;
        this.isReflectType = isReflectType;
        this.annotationOnInvokeClassId = annotationOnInvokeClassId;
        this.isInlineable = isInlineable;
    }

    @NotNull
    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @NotNull
    public final Name numberedClassName(int arity) {
        Name name = Name.identifier(this.classNamePrefix + arity);
        Intrinsics.checkNotNullExpressionValue(name, "identifier(...)");
        return name;
    }

    @NotNull
    public String toString() {
        return this.packageFqName + '.' + this.classNamePrefix + 'N';
    }

    public static final class Function
    extends FunctionTypeKind {
        @NotNull
        public static final Function INSTANCE = new Function();

        private Function() {
            super(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, null, true);
        }
    }

    public static final class KFunction
    extends FunctionTypeKind {
        @NotNull
        public static final KFunction INSTANCE = new KFunction();

        private KFunction() {
            super(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction", true, null, false);
        }
    }

    public static final class KSuspendFunction
    extends FunctionTypeKind {
        @NotNull
        public static final KSuspendFunction INSTANCE = new KSuspendFunction();

        private KSuspendFunction() {
            super(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction", true, null, false);
        }
    }

    public static final class SuspendFunction
    extends FunctionTypeKind {
        @NotNull
        public static final SuspendFunction INSTANCE = new SuspendFunction();

        private SuspendFunction() {
            super(StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", false, null, true);
        }
    }
}

