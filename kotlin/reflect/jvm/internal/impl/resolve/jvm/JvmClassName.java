/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public class JvmClassName {
    private final String internalName;
    private FqName fqName;

    @NotNull
    public static JvmClassName byInternalName(@NotNull String internalName) {
        if (internalName == null) {
            JvmClassName.$$$reportNull$$$0(0);
        }
        return new JvmClassName(internalName);
    }

    @NotNull
    public static JvmClassName byClassId(@NotNull ClassId classId) {
        if (classId == null) {
            JvmClassName.$$$reportNull$$$0(1);
        }
        return new JvmClassName(JvmClassName.internalNameByClassId(classId));
    }

    @NotNull
    public static String internalNameByClassId(@NotNull ClassId classId) {
        if (classId == null) {
            JvmClassName.$$$reportNull$$$0(2);
        }
        FqName packageFqName = classId.getPackageFqName();
        String relativeClassName = classId.getRelativeClassName().asString().replace('.', '$');
        String string = packageFqName.isRoot() ? relativeClassName : packageFqName.asString().replace('.', '/') + "/" + relativeClassName;
        if (string == null) {
            JvmClassName.$$$reportNull$$$0(3);
        }
        return string;
    }

    @NotNull
    public static JvmClassName byFqNameWithoutInnerClasses(@NotNull FqName fqName) {
        if (fqName == null) {
            JvmClassName.$$$reportNull$$$0(4);
        }
        JvmClassName r2 = new JvmClassName(fqName.asString().replace('.', '/'));
        r2.fqName = fqName;
        JvmClassName jvmClassName = r2;
        if (jvmClassName == null) {
            JvmClassName.$$$reportNull$$$0(5);
        }
        return jvmClassName;
    }

    private JvmClassName(@NotNull String internalName) {
        if (internalName == null) {
            JvmClassName.$$$reportNull$$$0(7);
        }
        this.internalName = internalName;
    }

    @NotNull
    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', '.'));
    }

    @NotNull
    public FqName getPackageFqName() {
        int lastSlash = this.internalName.lastIndexOf("/");
        if (lastSlash == -1) {
            FqName fqName = FqName.ROOT;
            if (fqName == null) {
                JvmClassName.$$$reportNull$$$0(9);
            }
            return fqName;
        }
        return new FqName(this.internalName.substring(0, lastSlash).replace('/', '.'));
    }

    @NotNull
    public String getInternalName() {
        String string = this.internalName;
        if (string == null) {
            JvmClassName.$$$reportNull$$$0(10);
        }
        return string;
    }

    public String toString() {
        return this.internalName;
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        return this.internalName.equals(((JvmClassName)o2).internalName);
    }

    public int hashCode() {
        return this.internalName.hashCode();
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
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
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
            case 1: 
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "classId";
                break;
            }
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            }
            case 4: 
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "fqName";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            }
            case 3: {
                objectArray = objectArray2;
                objectArray2[1] = "internalNameByClassId";
                break;
            }
            case 5: {
                objectArray = objectArray2;
                objectArray2[1] = "byFqNameWithoutInnerClasses";
                break;
            }
            case 8: {
                objectArray = objectArray2;
                objectArray2[1] = "getFqNameForClassNameWithoutDollars";
                break;
            }
            case 9: {
                objectArray = objectArray2;
                objectArray2[1] = "getPackageFqName";
                break;
            }
            case 10: {
                objectArray = objectArray2;
                objectArray2[1] = "getInternalName";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "byInternalName";
                break;
            }
            case 1: {
                objectArray = objectArray;
                objectArray[2] = "byClassId";
                break;
            }
            case 2: {
                objectArray = objectArray;
                objectArray[2] = "internalNameByClassId";
                break;
            }
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                break;
            }
            case 4: 
            case 6: {
                objectArray = objectArray;
                objectArray[2] = "byFqNameWithoutInnerClasses";
                break;
            }
            case 7: {
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
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

