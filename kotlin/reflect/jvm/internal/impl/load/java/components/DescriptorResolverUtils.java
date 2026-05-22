/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorResolverUtils {
    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(@NotNull Name name, @NotNull Collection<D> membersFromSupertypes, @NotNull Collection<D> membersFromCurrent, @NotNull ClassDescriptor classDescriptor, @NotNull ErrorReporter errorReporter, @NotNull OverridingUtil overridingUtil) {
        if (name == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(0);
        }
        if (membersFromSupertypes == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(1);
        }
        if (membersFromCurrent == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(2);
        }
        if (classDescriptor == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(3);
        }
        if (errorReporter == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(4);
        }
        if (overridingUtil == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(5);
        }
        return DescriptorResolverUtils.resolveOverrides(name, membersFromSupertypes, membersFromCurrent, classDescriptor, errorReporter, overridingUtil, false);
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(@NotNull Name name, @NotNull Collection<D> membersFromSupertypes, @NotNull Collection<D> membersFromCurrent, @NotNull ClassDescriptor classDescriptor, @NotNull ErrorReporter errorReporter, @NotNull OverridingUtil overridingUtil) {
        if (name == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(6);
        }
        if (membersFromSupertypes == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(7);
        }
        if (membersFromCurrent == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(8);
        }
        if (classDescriptor == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(9);
        }
        if (errorReporter == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(10);
        }
        if (overridingUtil == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(11);
        }
        return DescriptorResolverUtils.resolveOverrides(name, membersFromSupertypes, membersFromCurrent, classDescriptor, errorReporter, overridingUtil, true);
    }

    @NotNull
    private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(@NotNull Name name, @NotNull Collection<D> membersFromSupertypes, @NotNull Collection<D> membersFromCurrent, @NotNull ClassDescriptor classDescriptor, final @NotNull ErrorReporter errorReporter, @NotNull OverridingUtil overridingUtil, final boolean isStaticContext) {
        if (name == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(12);
        }
        if (membersFromSupertypes == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(13);
        }
        if (membersFromCurrent == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(14);
        }
        if (classDescriptor == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(15);
        }
        if (errorReporter == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(16);
        }
        if (overridingUtil == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(17);
        }
        final LinkedHashSet result = new LinkedHashSet();
        overridingUtil.generateOverridesInFunctionGroup(name, membersFromSupertypes, membersFromCurrent, classDescriptor, new NonReportingOverrideStrategy(){

            @Override
            public void addFakeOverride(@NotNull CallableMemberDescriptor fakeOverride) {
                if (fakeOverride == null) {
                    1.$$$reportNull$$$0(0);
                }
                OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, new Function1<CallableMemberDescriptor, Unit>(){

                    @Override
                    public Unit invoke(@NotNull CallableMemberDescriptor descriptor2) {
                        if (descriptor2 == null) {
                            1.$$$reportNull$$$0(0);
                        }
                        errorReporter.reportCannotInferVisibility(descriptor2);
                        return Unit.INSTANCE;
                    }

                    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
                    }
                });
                result.add(fakeOverride);
            }

            @Override
            public void conflict(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
                if (fromSuper == null) {
                    1.$$$reportNull$$$0(1);
                }
                if (fromCurrent == null) {
                    1.$$$reportNull$$$0(2);
                }
            }

            @Override
            public void setOverriddenDescriptors(@NotNull CallableMemberDescriptor member, @NotNull Collection<? extends CallableMemberDescriptor> overridden) {
                if (member == null) {
                    1.$$$reportNull$$$0(3);
                }
                if (overridden == null) {
                    1.$$$reportNull$$$0(4);
                }
                if (isStaticContext && member.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                    return;
                }
                super.setOverriddenDescriptors(member, overridden);
            }

            private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                Object[] objectArray;
                Object[] objectArray2;
                Object[] objectArray3 = new Object[3];
                switch (n2) {
                    default: {
                        objectArray2 = objectArray3;
                        objectArray3[0] = "fakeOverride";
                        break;
                    }
                    case 1: {
                        objectArray2 = objectArray3;
                        objectArray3[0] = "fromSuper";
                        break;
                    }
                    case 2: {
                        objectArray2 = objectArray3;
                        objectArray3[0] = "fromCurrent";
                        break;
                    }
                    case 3: {
                        objectArray2 = objectArray3;
                        objectArray3[0] = "member";
                        break;
                    }
                    case 4: {
                        objectArray2 = objectArray3;
                        objectArray3[0] = "overridden";
                        break;
                    }
                }
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
                switch (n2) {
                    default: {
                        objectArray = objectArray2;
                        objectArray2[2] = "addFakeOverride";
                        break;
                    }
                    case 1: 
                    case 2: {
                        objectArray = objectArray2;
                        objectArray2[2] = "conflict";
                        break;
                    }
                    case 3: 
                    case 4: {
                        objectArray = objectArray2;
                        objectArray2[2] = "setOverriddenDescriptors";
                        break;
                    }
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
            }
        });
        LinkedHashSet linkedHashSet = result;
        if (linkedHashSet == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(18);
        }
        return linkedHashSet;
    }

    @Nullable
    public static ValueParameterDescriptor getAnnotationParameterByName(@NotNull Name name, @NotNull ClassDescriptor annotationClass) {
        Collection<ClassConstructorDescriptor> constructors2;
        if (name == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(19);
        }
        if (annotationClass == null) {
            DescriptorResolverUtils.$$$reportNull$$$0(20);
        }
        if ((constructors2 = annotationClass.getConstructors()).size() != 1) {
            return null;
        }
        for (ValueParameterDescriptor parameter : constructors2.iterator().next().getValueParameters()) {
            if (!parameter.getName().equals(name)) continue;
            return parameter;
        }
        return null;
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
            case 18: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 18: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "name";
                break;
            }
            case 1: 
            case 7: 
            case 13: {
                objectArray2 = objectArray3;
                objectArray3[0] = "membersFromSupertypes";
                break;
            }
            case 2: 
            case 8: 
            case 14: {
                objectArray2 = objectArray3;
                objectArray3[0] = "membersFromCurrent";
                break;
            }
            case 3: 
            case 9: 
            case 15: {
                objectArray2 = objectArray3;
                objectArray3[0] = "classDescriptor";
                break;
            }
            case 4: 
            case 10: 
            case 16: {
                objectArray2 = objectArray3;
                objectArray3[0] = "errorReporter";
                break;
            }
            case 5: 
            case 11: 
            case 17: {
                objectArray2 = objectArray3;
                objectArray3[0] = "overridingUtil";
                break;
            }
            case 18: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            }
            case 20: {
                objectArray2 = objectArray3;
                objectArray3[0] = "annotationClass";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            }
            case 18: {
                objectArray = objectArray2;
                objectArray2[1] = "resolveOverrides";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "resolveOverridesForNonStaticMembers";
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                objectArray = objectArray;
                objectArray[2] = "resolveOverridesForStaticMembers";
                break;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                objectArray = objectArray;
                objectArray[2] = "resolveOverrides";
                break;
            }
            case 18: {
                break;
            }
            case 19: 
            case 20: {
                objectArray = objectArray;
                objectArray[2] = "getAnnotationParameterByName";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 18: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

