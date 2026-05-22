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
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class JvmType {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Primitive BOOLEAN = new Primitive(JvmPrimitiveType.BOOLEAN);
    @NotNull
    private static final Primitive CHAR = new Primitive(JvmPrimitiveType.CHAR);
    @NotNull
    private static final Primitive BYTE = new Primitive(JvmPrimitiveType.BYTE);
    @NotNull
    private static final Primitive SHORT = new Primitive(JvmPrimitiveType.SHORT);
    @NotNull
    private static final Primitive INT = new Primitive(JvmPrimitiveType.INT);
    @NotNull
    private static final Primitive FLOAT = new Primitive(JvmPrimitiveType.FLOAT);
    @NotNull
    private static final Primitive LONG = new Primitive(JvmPrimitiveType.LONG);
    @NotNull
    private static final Primitive DOUBLE = new Primitive(JvmPrimitiveType.DOUBLE);

    private JvmType() {
    }

    @NotNull
    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    public /* synthetic */ JvmType(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final class Array
    extends JvmType {
        @NotNull
        private final JvmType elementType;

        public Array(@NotNull JvmType elementType) {
            Intrinsics.checkNotNullParameter(elementType, "elementType");
            super(null);
            this.elementType = elementType;
        }

        @NotNull
        public final JvmType getElementType() {
            return this.elementType;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Primitive getBOOLEAN$descriptors_jvm() {
            return BOOLEAN;
        }

        @NotNull
        public final Primitive getCHAR$descriptors_jvm() {
            return CHAR;
        }

        @NotNull
        public final Primitive getBYTE$descriptors_jvm() {
            return BYTE;
        }

        @NotNull
        public final Primitive getSHORT$descriptors_jvm() {
            return SHORT;
        }

        @NotNull
        public final Primitive getINT$descriptors_jvm() {
            return INT;
        }

        @NotNull
        public final Primitive getFLOAT$descriptors_jvm() {
            return FLOAT;
        }

        @NotNull
        public final Primitive getLONG$descriptors_jvm() {
            return LONG;
        }

        @NotNull
        public final Primitive getDOUBLE$descriptors_jvm() {
            return DOUBLE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public static final class Object
    extends JvmType {
        @NotNull
        private final String internalName;

        public Object(@NotNull String internalName) {
            Intrinsics.checkNotNullParameter(internalName, "internalName");
            super(null);
            this.internalName = internalName;
        }

        @NotNull
        public final String getInternalName() {
            return this.internalName;
        }
    }

    public static final class Primitive
    extends JvmType {
        @Nullable
        private final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(@Nullable JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType;
        }

        @Nullable
        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }
}

