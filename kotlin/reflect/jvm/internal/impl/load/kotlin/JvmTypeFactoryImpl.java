/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nmethodSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/JvmTypeFactoryImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,200:1\n1#2:201\n1310#3,2:202\n*S KotlinDebug\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/JvmTypeFactoryImpl\n*L\n144#1:202,2\n*E\n"})
final class JvmTypeFactoryImpl
implements JvmTypeFactory<JvmType> {
    @NotNull
    public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();

    private JvmTypeFactoryImpl() {
    }

    @Override
    @NotNull
    public JvmType boxType(@NotNull JvmType possiblyPrimitiveType) {
        JvmType jvmType;
        Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (possiblyPrimitiveType instanceof JvmType.Primitive && ((JvmType.Primitive)possiblyPrimitiveType).getJvmPrimitiveType() != null) {
            String string = JvmClassName.byFqNameWithoutInnerClasses(((JvmType.Primitive)possiblyPrimitiveType).getJvmPrimitiveType().getWrapperFqName()).getInternalName();
            Intrinsics.checkNotNullExpressionValue(string, "getInternalName(...)");
            jvmType = this.createObjectType(string);
        } else {
            jvmType = possiblyPrimitiveType;
        }
        return jvmType;
    }

    @Override
    @NotNull
    public JvmType createFromString(@NotNull String representation) {
        JvmType jvmType;
        JvmPrimitiveType jvmPrimitiveType;
        char firstChar;
        block8: {
            JvmPrimitiveType jvmPrimitiveType2;
            boolean bl2;
            Intrinsics.checkNotNullParameter(representation, "representation");
            boolean bl3 = bl2 = ((CharSequence)representation).length() > 0;
            if (_Assertions.ENABLED && !bl2) {
                boolean bl4 = false;
                String string = "empty string as JvmType";
                throw new AssertionError((Object)string);
            }
            firstChar = representation.charAt(0);
            JvmPrimitiveType[] $this$firstOrNull$iv = JvmPrimitiveType.values();
            boolean $i$f$firstOrNull = false;
            int n2 = $this$firstOrNull$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                JvmPrimitiveType element$iv;
                JvmPrimitiveType it = element$iv = $this$firstOrNull$iv[i2];
                boolean bl5 = false;
                if (!(it.getDesc().charAt(0) == firstChar)) continue;
                jvmPrimitiveType2 = element$iv;
                break block8;
            }
            jvmPrimitiveType2 = jvmPrimitiveType = null;
        }
        if (jvmPrimitiveType != null) {
            JvmPrimitiveType it = jvmPrimitiveType;
            boolean bl6 = false;
            return new JvmType.Primitive(it);
        }
        switch (firstChar) {
            case 'V': {
                jvmType = new JvmType.Primitive(null);
                break;
            }
            case '[': {
                String string = representation.substring(1);
                Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                jvmType = new JvmType.Array(this.createFromString(string));
                break;
            }
            default: {
                boolean bl7;
                boolean bl8 = bl7 = firstChar == 'L' && StringsKt.endsWith$default((CharSequence)representation, ';', false, 2, null);
                if (_Assertions.ENABLED && !bl7) {
                    boolean bl9 = false;
                    String string = "Type that is not primitive nor array should be Object, but '" + representation + "' was found";
                    throw new AssertionError((Object)string);
                }
                String string = representation.substring(1, representation.length() - 1);
                Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                jvmType = new JvmType.Object(string);
            }
        }
        return jvmType;
    }

    @Override
    @NotNull
    public JvmType createPrimitiveType(@NotNull PrimitiveType primitiveType) {
        JvmType jvmType;
        Intrinsics.checkNotNullParameter((Object)primitiveType, "primitiveType");
        switch (WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1: {
                jvmType = JvmType.Companion.getBOOLEAN$descriptors_jvm();
                break;
            }
            case 2: {
                jvmType = JvmType.Companion.getCHAR$descriptors_jvm();
                break;
            }
            case 3: {
                jvmType = JvmType.Companion.getBYTE$descriptors_jvm();
                break;
            }
            case 4: {
                jvmType = JvmType.Companion.getSHORT$descriptors_jvm();
                break;
            }
            case 5: {
                jvmType = JvmType.Companion.getINT$descriptors_jvm();
                break;
            }
            case 6: {
                jvmType = JvmType.Companion.getFLOAT$descriptors_jvm();
                break;
            }
            case 7: {
                jvmType = JvmType.Companion.getLONG$descriptors_jvm();
                break;
            }
            case 8: {
                jvmType = JvmType.Companion.getDOUBLE$descriptors_jvm();
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return jvmType;
    }

    @Override
    @NotNull
    public JvmType.Object createObjectType(@NotNull String internalName) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        return new JvmType.Object(internalName);
    }

    @Override
    @NotNull
    public String toString(@NotNull JvmType type) {
        Object object;
        Intrinsics.checkNotNullParameter(type, "type");
        JvmType jvmType = type;
        if (jvmType instanceof JvmType.Array) {
            object = '[' + this.toString(((JvmType.Array)type).getElementType());
        } else if (jvmType instanceof JvmType.Primitive) {
            object = ((JvmType.Primitive)type).getJvmPrimitiveType();
            if (object == null || (object = object.getDesc()) == null) {
                object = "V";
            }
        } else if (jvmType instanceof JvmType.Object) {
            object = 'L' + ((JvmType.Object)type).getInternalName() + ';';
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return object;
    }

    @Override
    @NotNull
    public JvmType getJavaLangClassType() {
        return this.createObjectType("java/lang/Class");
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[PrimitiveType.values().length];
            try {
                nArray[PrimitiveType.BOOLEAN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.CHAR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.BYTE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.SHORT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.INT.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.FLOAT.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.LONG.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PrimitiveType.DOUBLE.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

