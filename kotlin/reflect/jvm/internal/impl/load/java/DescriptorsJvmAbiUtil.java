/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public final class DescriptorsJvmAbiUtil {
    public static boolean isPropertyWithBackingFieldInOuterClass(@NotNull PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            DescriptorsJvmAbiUtil.$$$reportNull$$$0(0);
        }
        if (propertyDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (DescriptorsJvmAbiUtil.isClassCompanionObjectWithBackingFieldsInOuter(propertyDescriptor.getContainingDeclaration())) {
            return true;
        }
        return DescriptorUtils.isCompanionObject(propertyDescriptor.getContainingDeclaration()) && DescriptorsJvmAbiUtil.hasJvmFieldAnnotation(propertyDescriptor);
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(@NotNull DeclarationDescriptor companionObject) {
        if (companionObject == null) {
            DescriptorsJvmAbiUtil.$$$reportNull$$$0(1);
        }
        return DescriptorUtils.isCompanionObject(companionObject) && DescriptorUtils.isClassOrEnumClass(companionObject.getContainingDeclaration()) && !DescriptorsJvmAbiUtil.isMappedIntrinsicCompanionObject((ClassDescriptor)companionObject);
    }

    public static boolean isMappedIntrinsicCompanionObject(@NotNull ClassDescriptor companionObject) {
        if (companionObject == null) {
            DescriptorsJvmAbiUtil.$$$reportNull$$$0(2);
        }
        return CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, companionObject);
    }

    public static boolean hasJvmFieldAnnotation(@NotNull CallableMemberDescriptor memberDescriptor) {
        FieldDescriptor field;
        if (memberDescriptor == null) {
            DescriptorsJvmAbiUtil.$$$reportNull$$$0(3);
        }
        if (memberDescriptor instanceof PropertyDescriptor && (field = ((PropertyDescriptor)memberDescriptor).getBackingField()) != null && field.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME)) {
            return true;
        }
        return memberDescriptor.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME);
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3 = new Object[3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "propertyDescriptor";
                break;
            }
            case 1: 
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "companionObject";
                break;
            }
            case 3: {
                objectArray2 = objectArray3;
                objectArray3[0] = "memberDescriptor";
                break;
            }
        }
        objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "isPropertyWithBackingFieldInOuterClass";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
                break;
            }
            case 2: {
                objectArray = objectArray2;
                objectArray2[2] = "isMappedIntrinsicCompanionObject";
                break;
            }
            case 3: {
                objectArray = objectArray2;
                objectArray2[2] = "hasJvmFieldAnnotation";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

