/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KotlinClassFinder
extends KotlinMetadataFinder {
    @Nullable
    public Result findKotlinClassOrContent(@NotNull ClassId var1, @NotNull MetadataVersion var2);

    @Nullable
    public Result findKotlinClassOrContent(@NotNull JavaClass var1, @NotNull MetadataVersion var2);

    public static abstract class Result {
        private Result() {
        }

        @Nullable
        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            KotlinClass kotlinClass = this instanceof KotlinClass ? (KotlinClass)this : null;
            return kotlinClass != null ? kotlinClass.getKotlinJvmBinaryClass() : null;
        }

        public /* synthetic */ Result(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class ClassFileContent
        extends Result {
            @NotNull
            private final byte[] content;

            @NotNull
            public final byte[] getContent() {
                return this.content;
            }
        }

        public static final class KotlinClass
        extends Result {
            @NotNull
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;
            @Nullable
            private final byte[] byteContent;

            public KotlinClass(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @Nullable byte[] byteContent) {
                Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                super(null);
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass;
                this.byteContent = byteContent;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] byArray, int n2, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n2 & 2) != 0) {
                    byArray = null;
                }
                this(kotlinJvmBinaryClass, byArray);
            }

            @NotNull
            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }
        }
    }
}

