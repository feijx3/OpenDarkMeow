/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nconstantValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 constantValues.kt\norg/jetbrains/kotlin/resolve/constants/EnumValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,320:1\n1#2:321\n*E\n"})
public final class EnumValue
extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    @NotNull
    private final ClassId enumClassId;
    @NotNull
    private final Name enumEntryName;

    public EnumValue(@NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
        Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
        Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
        super(TuplesKt.to(enumClassId, enumEntryName));
        this.enumClassId = enumClassId;
        this.enumEntryName = enumEntryName;
    }

    @NotNull
    public final Name getEnumEntryName() {
        return this.enumEntryName;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor module) {
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter(module, "module");
        Annotated annotated = FindClassInModuleKt.findClassAcrossModuleDependencies(module, this.enumClassId);
        if (annotated != null) {
            ClassDescriptor classDescriptor = annotated;
            DeclarationDescriptor p0 = classDescriptor;
            boolean bl2 = false;
            annotated = DescriptorUtils.isEnumClass(p0) ? classDescriptor : null;
            if (annotated != null && (annotated = annotated.getDefaultType()) != null) {
                kotlinType = (KotlinType)annotated;
                return kotlinType;
            }
        }
        String[] stringArray = new String[]{this.enumClassId.toString(), this.enumEntryName.toString()};
        kotlinType = ErrorUtils.createErrorType(ErrorTypeKind.ERROR_ENUM_TYPE, stringArray);
        return kotlinType;
    }

    @Override
    @NotNull
    public String toString() {
        return "" + this.enumClassId.getShortClassName() + '.' + this.enumEntryName;
    }
}

