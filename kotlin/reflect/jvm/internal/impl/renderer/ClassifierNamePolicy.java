/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public interface ClassifierNamePolicy {
    @NotNull
    public String renderClassifier(@NotNull ClassifierDescriptor var1, @NotNull DescriptorRenderer var2);

    public static final class FULLY_QUALIFIED
    implements ClassifierNamePolicy {
        @NotNull
        public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();

        private FULLY_QUALIFIED() {
        }

        @Override
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            if (classifier instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor)classifier).getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                return renderer.renderName(name, false);
            }
            FqNameUnsafe fqNameUnsafe = DescriptorUtils.getFqName(classifier);
            Intrinsics.checkNotNullExpressionValue(fqNameUnsafe, "getFqName(...)");
            return renderer.renderFqName(fqNameUnsafe);
        }
    }

    public static final class SHORT
    implements ClassifierNamePolicy {
        @NotNull
        public static final SHORT INSTANCE = new SHORT();

        private SHORT() {
        }

        @Override
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            if (classifier instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor)classifier).getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                return renderer.renderName(name, false);
            }
            ArrayList<Name> qualifiedNameElements = new ArrayList<Name>();
            DeclarationDescriptor current = classifier;
            do {
                qualifiedNameElements.add(current.getName());
            } while ((current = current.getContainingDeclaration()) instanceof ClassDescriptor);
            return RenderingUtilsKt.renderFqName(CollectionsKt.asReversedMutable((List)qualifiedNameElements));
        }
    }

    public static final class SOURCE_CODE_QUALIFIED
    implements ClassifierNamePolicy {
        @NotNull
        public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();

        private SOURCE_CODE_QUALIFIED() {
        }

        @Override
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            Intrinsics.checkNotNullParameter(renderer, "renderer");
            return this.qualifiedNameForSourceCode(classifier);
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor descriptor2) {
            Name name = descriptor2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String nameString = RenderingUtilsKt.render(name);
            if (descriptor2 instanceof TypeParameterDescriptor) {
                return nameString;
            }
            DeclarationDescriptor declarationDescriptor = descriptor2.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(declarationDescriptor, "getContainingDeclaration(...)");
            String qualifier = this.qualifierName(declarationDescriptor);
            return qualifier != null && !Intrinsics.areEqual(qualifier, "") ? qualifier + '.' + nameString : nameString;
        }

        private final String qualifierName(DeclarationDescriptor descriptor2) {
            DeclarationDescriptor declarationDescriptor = descriptor2;
            return declarationDescriptor instanceof ClassDescriptor ? this.qualifiedNameForSourceCode((ClassifierDescriptor)descriptor2) : (declarationDescriptor instanceof PackageFragmentDescriptor ? RenderingUtilsKt.render(((PackageFragmentDescriptor)descriptor2).getFqName().toUnsafe()) : null);
        }
    }
}

