/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nClassLiteralValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassLiteralValue.kt\norg/jetbrains/kotlin/resolve/constants/ClassLiteralValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,17:1\n1#2:18\n*E\n"})
public final class ClassLiteralValue {
    @NotNull
    private final ClassId classId;
    private final int arrayNestedness;

    public ClassLiteralValue(@NotNull ClassId classId, int arrayNestedness) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.classId = classId;
        this.arrayNestedness = arrayNestedness;
    }

    @NotNull
    public final ClassId getClassId() {
        return this.classId;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    @NotNull
    public String toString() {
        int it;
        StringBuilder stringBuilder;
        StringBuilder $this$toString_u24lambda_u242 = stringBuilder = new StringBuilder();
        boolean bl2 = false;
        int n2 = this.arrayNestedness;
        int n3 = 0;
        while (n3 < n2) {
            it = n3++;
            boolean bl3 = false;
            $this$toString_u24lambda_u242.append("kotlin/Array<");
        }
        $this$toString_u24lambda_u242.append(this.classId);
        n2 = this.arrayNestedness;
        n3 = 0;
        while (n3 < n2) {
            it = n3++;
            boolean bl4 = false;
            $this$toString_u24lambda_u242.append(">");
        }
        return stringBuilder.toString();
    }

    @NotNull
    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public int hashCode() {
        int result = this.classId.hashCode();
        result = result * 31 + Integer.hashCode(this.arrayNestedness);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue)other;
        if (!Intrinsics.areEqual(this.classId, classLiteralValue.classId)) {
            return false;
        }
        return this.arrayNestedness == classLiteralValue.arrayNestedness;
    }
}

