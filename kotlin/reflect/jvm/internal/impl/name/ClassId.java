/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin._Assertions;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nClassId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,141:1\n1#2:142\n231#3:143\n231#3:144\n*S KotlinDebug\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n*L\n37#1:143\n47#1:144\n*E\n"})
public final class ClassId {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final FqName packageFqName;
    @NotNull
    private final FqName relativeClassName;
    private final boolean isLocal;

    public ClassId(@NotNull FqName packageFqName, @NotNull FqName relativeClassName, boolean isLocal) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(relativeClassName, "relativeClassName");
        this.packageFqName = packageFqName;
        this.relativeClassName = relativeClassName;
        this.isLocal = isLocal;
        boolean bl3 = bl2 = !this.relativeClassName.isRoot();
        if (_Assertions.ENABLED && !bl2) {
            boolean bl4 = false;
            String string = "Class name must not be root: " + this.packageFqName + (this.isLocal ? " (local)" : "");
            throw new AssertionError((Object)string);
        }
    }

    @NotNull
    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public ClassId(@NotNull FqName packageFqName, @NotNull Name topLevelName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(topLevelName, "topLevelName");
        this(packageFqName, FqName.Companion.topLevel(topLevelName), false);
    }

    @NotNull
    public final Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    @Nullable
    public final ClassId getOuterClassId() {
        ClassId classId;
        FqName parent = this.relativeClassName.parent();
        boolean condition$iv = !parent.isRoot();
        boolean $i$f$runIf = false;
        if (condition$iv) {
            boolean bl2 = false;
            classId = new ClassId(this.packageFqName, parent, this.isLocal);
        } else {
            classId = null;
        }
        return classId;
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    @NotNull
    public final ClassId createNestedClassId(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ClassId(this.packageFqName, this.relativeClassName.child(name), this.isLocal);
    }

    @NotNull
    public final FqName asSingleFqName() {
        return this.packageFqName.isRoot() ? this.relativeClassName : new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    @NotNull
    public final String asString() {
        String string;
        if (this.packageFqName.isRoot()) {
            string = ClassId.asString$escapeSlashes(this.relativeClassName);
        } else {
            StringBuilder stringBuilder;
            StringBuilder $this$asString_u24lambda_u243 = stringBuilder = new StringBuilder();
            boolean bl2 = false;
            $this$asString_u24lambda_u243.append(StringsKt.replace$default(this.packageFqName.asString(), '.', '/', false, 4, null));
            $this$asString_u24lambda_u243.append("/");
            $this$asString_u24lambda_u243.append(ClassId.asString$escapeSlashes(this.relativeClassName));
            string = stringBuilder.toString();
        }
        return string;
    }

    @NotNull
    public String toString() {
        return this.packageFqName.isRoot() ? '/' + this.asString() : this.asString();
    }

    public int hashCode() {
        int result = this.packageFqName.hashCode();
        result = result * 31 + this.relativeClassName.hashCode();
        result = result * 31 + Boolean.hashCode(this.isLocal);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassId)) {
            return false;
        }
        ClassId classId = (ClassId)other;
        if (!Intrinsics.areEqual(this.packageFqName, classId.packageFqName)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName)) {
            return false;
        }
        return this.isLocal == classId.isLocal;
    }

    private static final String asString$escapeSlashes(FqName $this$asString_u24escapeSlashes) {
        String res = $this$asString_u24escapeSlashes.asString();
        if (StringsKt.contains$default((CharSequence)res, '/', false, 2, null)) {
            return '`' + res + '`';
        }
        return res;
    }

    @JvmStatic
    @NotNull
    public static final ClassId topLevel(@NotNull FqName topLevelFqName) {
        return Companion.topLevel(topLevelFqName);
    }

    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ClassId topLevel(@NotNull FqName topLevelFqName) {
            Intrinsics.checkNotNullParameter(topLevelFqName, "topLevelFqName");
            return new ClassId(topLevelFqName.parent(), topLevelFqName.shortName());
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ClassId fromString(@NotNull String string, boolean isLocal) {
            Intrinsics.checkNotNullParameter(string, "string");
            int tickIndex = StringsKt.indexOf$default((CharSequence)string, '`', 0, false, 6, null);
            int lastSlashIndex = StringsKt.lastIndexOf$default((CharSequence)string, "/", tickIndex == -1 ? string.length() : tickIndex, false, 4, null);
            String packageName = null;
            String className = null;
            if (lastSlashIndex == -1) {
                packageName = "";
                className = StringsKt.replace$default(string, "`", "", false, 4, null);
            } else {
                String string2 = string.substring(0, lastSlashIndex);
                Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
                packageName = StringsKt.replace$default(string2, '/', '.', false, 4, null);
                String string3 = string.substring(lastSlashIndex + 1);
                Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
                className = StringsKt.replace$default(string3, "`", "", false, 4, null);
            }
            return new ClassId(new FqName(packageName), new FqName(className), isLocal);
        }

        public static /* synthetic */ ClassId fromString$default(Companion companion, String string, boolean bl2, int n2, Object object) {
            if ((n2 & 2) != 0) {
                bl2 = false;
            }
            return companion.fromString(string, bl2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

