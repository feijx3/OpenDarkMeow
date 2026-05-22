/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", "S", "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");

    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME;
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC;
    private static final Set<String> WRAPPER_CLASS_INTERNAL_NAMES;
    private static final Map<String, String> OWNER_TO_BOXING_METHOD_DESCRIPTOR;
    private final PrimitiveType primitiveType;
    private final String name;
    private final String desc;
    private final FqName wrapperFqName;

    @NotNull
    public static JvmPrimitiveType get(@NotNull String name) {
        JvmPrimitiveType result;
        if (name == null) {
            JvmPrimitiveType.$$$reportNull$$$0(3);
        }
        if ((result = TYPE_BY_NAME.get(name)) == null) {
            throw new AssertionError((Object)("Non-primitive type name passed: " + name));
        }
        JvmPrimitiveType jvmPrimitiveType = result;
        if (jvmPrimitiveType == null) {
            JvmPrimitiveType.$$$reportNull$$$0(4);
        }
        return jvmPrimitiveType;
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull PrimitiveType type) {
        if (type == null) {
            JvmPrimitiveType.$$$reportNull$$$0(5);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_PRIMITIVE_TYPE.get((Object)type);
        if (jvmPrimitiveType == null) {
            JvmPrimitiveType.$$$reportNull$$$0(6);
        }
        return jvmPrimitiveType;
    }

    private JvmPrimitiveType(@NotNull PrimitiveType primitiveType, @NotNull String name, String desc, String wrapperClassName) {
        if (primitiveType == null) {
            JvmPrimitiveType.$$$reportNull$$$0(8);
        }
        if (name == null) {
            JvmPrimitiveType.$$$reportNull$$$0(9);
        }
        if (desc == null) {
            JvmPrimitiveType.$$$reportNull$$$0(10);
        }
        if (wrapperClassName == null) {
            JvmPrimitiveType.$$$reportNull$$$0(11);
        }
        this.primitiveType = primitiveType;
        this.name = name;
        this.desc = desc;
        this.wrapperFqName = new FqName(wrapperClassName);
    }

    @NotNull
    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType = this.primitiveType;
        if (primitiveType == null) {
            JvmPrimitiveType.$$$reportNull$$$0(12);
        }
        return primitiveType;
    }

    @NotNull
    public String getJavaKeywordName() {
        String string = this.name;
        if (string == null) {
            JvmPrimitiveType.$$$reportNull$$$0(13);
        }
        return string;
    }

    @NotNull
    public String getDesc() {
        String string = this.desc;
        if (string == null) {
            JvmPrimitiveType.$$$reportNull$$$0(14);
        }
        return string;
    }

    @NotNull
    public FqName getWrapperFqName() {
        FqName fqName = this.wrapperFqName;
        if (fqName == null) {
            JvmPrimitiveType.$$$reportNull$$$0(15);
        }
        return fqName;
    }

    static {
        TYPE_BY_NAME = new HashMap<String, JvmPrimitiveType>();
        TYPE_BY_PRIMITIVE_TYPE = new EnumMap<PrimitiveType, JvmPrimitiveType>(PrimitiveType.class);
        TYPE_BY_DESC = new HashMap<String, JvmPrimitiveType>();
        WRAPPER_CLASS_INTERNAL_NAMES = new HashSet<String>();
        OWNER_TO_BOXING_METHOD_DESCRIPTOR = new HashMap<String, String>();
        for (JvmPrimitiveType type : JvmPrimitiveType.values()) {
            TYPE_BY_NAME.put(type.getJavaKeywordName(), type);
            TYPE_BY_PRIMITIVE_TYPE.put(type.getPrimitiveType(), type);
            TYPE_BY_DESC.put(type.getDesc(), type);
            String internalName = type.wrapperFqName.asString().replace('.', '/');
            WRAPPER_CLASS_INTERNAL_NAMES.add(internalName);
            OWNER_TO_BOXING_METHOD_DESCRIPTOR.put(internalName, "(" + type.desc + ")L" + internalName + ";");
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n3;
        String string;
        switch (n2) {
            default: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 4: 
            case 6: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 4: 
            case 6: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "internalName";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "owner";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "methodDescriptor";
                break;
            }
            case 3: 
            case 9: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 4: 
            case 6: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            }
            case 5: {
                objectArray2 = objectArray3;
                objectArray3[0] = "type";
                break;
            }
            case 7: 
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "desc";
                break;
            }
            case 8: {
                objectArray2 = objectArray3;
                objectArray3[0] = "primitiveType";
                break;
            }
            case 11: {
                objectArray2 = objectArray3;
                objectArray3[0] = "wrapperClassName";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            }
            case 4: 
            case 6: {
                objectArray = objectArray2;
                objectArray2[1] = "get";
                break;
            }
            case 12: {
                objectArray = objectArray2;
                objectArray2[1] = "getPrimitiveType";
                break;
            }
            case 13: {
                objectArray = objectArray2;
                objectArray2[1] = "getJavaKeywordName";
                break;
            }
            case 14: {
                objectArray = objectArray2;
                objectArray2[1] = "getDesc";
                break;
            }
            case 15: {
                objectArray = objectArray2;
                objectArray2[1] = "getWrapperFqName";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "isWrapperClassInternalName";
                break;
            }
            case 1: 
            case 2: {
                objectArray = objectArray;
                objectArray[2] = "isBoxingMethodDescriptor";
                break;
            }
            case 3: 
            case 5: {
                objectArray = objectArray;
                objectArray[2] = "get";
                break;
            }
            case 4: 
            case 6: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                break;
            }
            case 7: {
                objectArray = objectArray;
                objectArray[2] = "getByDesc";
                break;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 4: 
            case 6: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

