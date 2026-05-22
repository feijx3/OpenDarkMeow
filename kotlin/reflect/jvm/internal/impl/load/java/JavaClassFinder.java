/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaClassFinder {
    @Nullable
    public JavaClass findClass(@NotNull Request var1);

    @Nullable
    public JavaPackage findPackage(@NotNull FqName var1, boolean var2);

    @Nullable
    public Set<String> knownClassNamesInPackage(@NotNull FqName var1);

    public static final class Request {
        @NotNull
        private final ClassId classId;
        @Nullable
        private final byte[] previouslyFoundClassFileContent;
        @Nullable
        private final JavaClass outerClass;

        public Request(@NotNull ClassId classId, @Nullable byte[] previouslyFoundClassFileContent, @Nullable JavaClass outerClass) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.previouslyFoundClassFileContent = previouslyFoundClassFileContent;
            this.outerClass = outerClass;
        }

        public /* synthetic */ Request(ClassId classId, byte[] byArray, JavaClass javaClass, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                byArray = null;
            }
            if ((n2 & 4) != 0) {
                javaClass = null;
            }
            this(classId, byArray, javaClass);
        }

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        @NotNull
        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        public int hashCode() {
            int result = this.classId.hashCode();
            result = result * 31 + (this.previouslyFoundClassFileContent == null ? 0 : Arrays.hashCode(this.previouslyFoundClassFileContent));
            result = result * 31 + (this.outerClass == null ? 0 : this.outerClass.hashCode());
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Request)) {
                return false;
            }
            Request request = (Request)other;
            if (!Intrinsics.areEqual(this.classId, request.classId)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.previouslyFoundClassFileContent, request.previouslyFoundClassFileContent)) {
                return false;
            }
            return Intrinsics.areEqual(this.outerClass, request.outerClass);
        }
    }
}

