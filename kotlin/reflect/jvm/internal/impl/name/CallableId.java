/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nCallableId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallableId.kt\norg/jetbrains/kotlin/name/CallableId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class CallableId {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final FqName packageName;
    @Nullable
    private final FqName className;
    @NotNull
    private final Name callableName;
    @Nullable
    private final ClassId classId;
    @Nullable
    private final FqName pathToLocal;
    @NotNull
    private static final Name LOCAL_NAME = SpecialNames.LOCAL;
    @NotNull
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL = FqName.Companion.topLevel(LOCAL_NAME);

    private CallableId(FqName packageName, FqName className, Name callableName, ClassId classId, FqName pathToLocal) {
        this.packageName = packageName;
        this.className = className;
        this.callableName = callableName;
        this.classId = classId;
        this.pathToLocal = pathToLocal;
    }

    public CallableId(@NotNull FqName packageName, @NotNull Name callableName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(callableName, "callableName");
        this(packageName, null, callableName, null, null);
    }

    public boolean equals(@Nullable Object other) {
        return this == other ? true : (!(other instanceof CallableId) ? false : Intrinsics.areEqual(this.packageName, ((CallableId)other).packageName) && Intrinsics.areEqual(this.className, ((CallableId)other).className) && Intrinsics.areEqual(this.callableName, ((CallableId)other).callableName));
    }

    public int hashCode() {
        int result = 17;
        result = result * 31 + this.packageName.hashCode();
        FqName fqName = this.className;
        result = result * 31 + (fqName != null ? ((Object)fqName).hashCode() : 0);
        result = result * 31 + this.callableName.hashCode();
        return result;
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder $this$toString_u24lambda_u241 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        $this$toString_u24lambda_u241.append(StringsKt.replace$default(this.packageName.asString(), '.', '/', false, 4, null));
        $this$toString_u24lambda_u241.append("/");
        if (this.className != null) {
            $this$toString_u24lambda_u241.append(this.className);
            $this$toString_u24lambda_u241.append(".");
        }
        $this$toString_u24lambda_u241.append(this.callableName);
        return stringBuilder.toString();
    }

    @SourceDebugExtension(value={"SMAP\nCallableId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallableId.kt\norg/jetbrains/kotlin/name/CallableId$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

