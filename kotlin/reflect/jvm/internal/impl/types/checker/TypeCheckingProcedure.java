/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerProcedureCallbacksImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import kotlin.reflect.jvm.internal.impl.types.checker.UtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeCheckingProcedure {
    @Nullable
    public static KotlinType findCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        if (subtype == null) {
            TypeCheckingProcedure.$$$reportNull$$$0(0);
        }
        if (supertype == null) {
            TypeCheckingProcedure.$$$reportNull$$$0(1);
        }
        return TypeCheckingProcedure.findCorrespondingSupertype(subtype, supertype, new TypeCheckerProcedureCallbacksImpl());
    }

    @Nullable
    public static KotlinType findCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        if (subtype == null) {
            TypeCheckingProcedure.$$$reportNull$$$0(2);
        }
        if (supertype == null) {
            TypeCheckingProcedure.$$$reportNull$$$0(3);
        }
        if (typeCheckingProcedureCallbacks == null) {
            TypeCheckingProcedure.$$$reportNull$$$0(4);
        }
        return UtilsKt.findCorrespondingSupertype(subtype, supertype, typeCheckingProcedureCallbacks);
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
            case 7: 
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
            case 7: 
            case 10: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "subtype";
                break;
            }
            case 1: 
            case 3: 
            case 18: 
            case 20: {
                objectArray2 = objectArray3;
                objectArray3[0] = "supertype";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeCheckingProcedureCallbacks";
                break;
            }
            case 5: 
            case 8: 
            case 23: {
                objectArray2 = objectArray3;
                objectArray3[0] = "parameter";
                break;
            }
            case 6: 
            case 9: {
                objectArray2 = objectArray3;
                objectArray3[0] = "argument";
                break;
            }
            case 7: 
            case 10: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            }
            case 11: {
                objectArray2 = objectArray3;
                objectArray3[0] = "type1";
                break;
            }
            case 12: {
                objectArray2 = objectArray3;
                objectArray3[0] = "type2";
                break;
            }
            case 13: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeParameter";
                break;
            }
            case 14: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeArgument";
                break;
            }
            case 15: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeParameterVariance";
                break;
            }
            case 16: {
                objectArray2 = objectArray3;
                objectArray3[0] = "typeArgumentVariance";
                break;
            }
            case 21: {
                objectArray2 = objectArray3;
                objectArray3[0] = "subtypeArgumentProjection";
                break;
            }
            case 22: {
                objectArray2 = objectArray3;
                objectArray3[0] = "supertypeArgumentProjection";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            }
            case 7: {
                objectArray = objectArray2;
                objectArray2[1] = "getOutType";
                break;
            }
            case 10: {
                objectArray = objectArray2;
                objectArray2[1] = "getInType";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "findCorrespondingSupertype";
                break;
            }
            case 5: 
            case 6: {
                objectArray = objectArray;
                objectArray[2] = "getOutType";
                break;
            }
            case 7: 
            case 10: {
                break;
            }
            case 8: 
            case 9: {
                objectArray = objectArray;
                objectArray[2] = "getInType";
                break;
            }
            case 11: 
            case 12: {
                objectArray = objectArray;
                objectArray[2] = "equalTypes";
                break;
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                objectArray = objectArray;
                objectArray[2] = "getEffectiveProjectionKind";
                break;
            }
            case 17: 
            case 18: {
                objectArray = objectArray;
                objectArray[2] = "isSubtypeOf";
                break;
            }
            case 19: 
            case 20: {
                objectArray = objectArray;
                objectArray[2] = "checkSubtypeForTheSameConstructor";
                break;
            }
            case 21: 
            case 22: 
            case 23: {
                objectArray = objectArray;
                objectArray[2] = "capture";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 7: 
            case 10: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

