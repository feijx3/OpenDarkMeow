/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaDescriptorVisibilities {
    @NotNull
    public static final DescriptorVisibility PACKAGE_VISIBILITY = new DelegatedDescriptorVisibility(JavaVisibilities.PackageVisibility.INSTANCE){

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                1.$$$reportNull$$$0(0);
            }
            if (from == null) {
                1.$$$reportNull$$$0(1);
            }
            return JavaDescriptorVisibilities.areInSamePackage(what, from);
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = new Object[3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "what";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "from";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "fromPackage";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "myPackage";
                    break;
                }
            }
            objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[2] = "isVisible";
                    break;
                }
                case 2: 
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[2] = "visibleFromPackage";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    };
    @NotNull
    public static final DescriptorVisibility PROTECTED_STATIC_VISIBILITY = new DelegatedDescriptorVisibility(JavaVisibilities.ProtectedStaticVisibility.INSTANCE){

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                2.$$$reportNull$$$0(0);
            }
            if (from == null) {
                2.$$$reportNull$$$0(1);
            }
            return JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiver, what, from);
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2 = new Object[3];
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[0] = "what";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[0] = "from";
                    break;
                }
            }
            objectArray[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objectArray[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    };
    @NotNull
    public static final DescriptorVisibility PROTECTED_AND_PACKAGE = new DelegatedDescriptorVisibility(JavaVisibilities.ProtectedAndPackage.INSTANCE){

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from, boolean useSpecialRulesForPrivateSealedConstructors) {
            if (what == null) {
                3.$$$reportNull$$$0(0);
            }
            if (from == null) {
                3.$$$reportNull$$$0(1);
            }
            return JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiver, what, from);
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2 = new Object[3];
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[0] = "what";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[0] = "from";
                    break;
                }
            }
            objectArray[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objectArray[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    };
    @NotNull
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = new HashMap<Visibility, DescriptorVisibility>();

    private static boolean isVisibleForProtectedAndPackage(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
        if (what == null) {
            JavaDescriptorVisibilities.$$$reportNull$$$0(0);
        }
        if (from == null) {
            JavaDescriptorVisibilities.$$$reportNull$$$0(1);
        }
        if (JavaDescriptorVisibilities.areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(what), from)) {
            return true;
        }
        return DescriptorVisibilities.PROTECTED.isVisible(receiver, what, from, false);
    }

    private static boolean areInSamePackage(@NotNull DeclarationDescriptor first, @NotNull DeclarationDescriptor second) {
        if (first == null) {
            JavaDescriptorVisibilities.$$$reportNull$$$0(2);
        }
        if (second == null) {
            JavaDescriptorVisibilities.$$$reportNull$$$0(3);
        }
        PackageFragmentDescriptor whatPackage = DescriptorUtils.getParentOfType(first, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor fromPackage = DescriptorUtils.getParentOfType(second, PackageFragmentDescriptor.class, false);
        return fromPackage != null && whatPackage != null && whatPackage.getFqName().equals(fromPackage.getFqName());
    }

    private static void recordVisibilityMapping(DescriptorVisibility visibility2) {
        visibilitiesMapping.put(visibility2.getDelegate(), visibility2);
    }

    @NotNull
    public static DescriptorVisibility toDescriptorVisibility(@NotNull Visibility visibility2) {
        DescriptorVisibility correspondingVisibility;
        if (visibility2 == null) {
            JavaDescriptorVisibilities.$$$reportNull$$$0(4);
        }
        if ((correspondingVisibility = visibilitiesMapping.get(visibility2)) == null) {
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(visibility2);
            if (descriptorVisibility == null) {
                JavaDescriptorVisibilities.$$$reportNull$$$0(5);
            }
            return descriptorVisibility;
        }
        DescriptorVisibility descriptorVisibility = correspondingVisibility;
        if (descriptorVisibility == null) {
            JavaDescriptorVisibilities.$$$reportNull$$$0(6);
        }
        return descriptorVisibility;
    }

    static {
        JavaDescriptorVisibilities.recordVisibilityMapping(PACKAGE_VISIBILITY);
        JavaDescriptorVisibilities.recordVisibilityMapping(PROTECTED_STATIC_VISIBILITY);
        JavaDescriptorVisibilities.recordVisibilityMapping(PROTECTED_AND_PACKAGE);
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
            case 5: 
            case 6: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 5: 
            case 6: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "what";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "from";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "first";
                break;
            }
            case 3: {
                objectArray2 = objectArray3;
                objectArray3[0] = "second";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "visibility";
                break;
            }
            case 5: 
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            }
            case 5: 
            case 6: {
                objectArray = objectArray2;
                objectArray2[1] = "toDescriptorVisibility";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "isVisibleForProtectedAndPackage";
                break;
            }
            case 2: 
            case 3: {
                objectArray = objectArray;
                objectArray[2] = "areInSamePackage";
                break;
            }
            case 4: {
                objectArray = objectArray;
                objectArray[2] = "toDescriptorVisibility";
                break;
            }
            case 5: 
            case 6: {
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 5: 
            case 6: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

