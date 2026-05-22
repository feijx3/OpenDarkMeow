/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeMappingMode {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean needPrimitiveBoxing;
    private final boolean needInlineClassWrapping;
    private final boolean isForAnnotationParameter;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;
    @Nullable
    private final TypeMappingMode genericArgumentMode;
    private final boolean kotlinCollectionsToJavaCollections;
    @Nullable
    private final TypeMappingMode genericContravariantArgumentMode;
    @Nullable
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean mapTypeAliases;
    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT = new TypeMappingMode(false, false, false, false, false, null, false, null, null, false, 1023, null);
    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST = new TypeMappingMode(false, false, false, false, false, null, false, null, null, true, 511, null);
    @JvmField
    @NotNull
    public static final TypeMappingMode RETURN_TYPE_BOXED = new TypeMappingMode(false, true, false, false, false, null, false, null, null, false, 1021, null);
    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT;
    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT_UAST;
    @JvmField
    @NotNull
    public static final TypeMappingMode CLASS_DECLARATION;
    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE;
    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;
    @JvmField
    @NotNull
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;

    public TypeMappingMode(boolean needPrimitiveBoxing, boolean needInlineClassWrapping, boolean isForAnnotationParameter, boolean skipDeclarationSiteWildcards, boolean skipDeclarationSiteWildcardsIfPossible, @Nullable TypeMappingMode genericArgumentMode, boolean kotlinCollectionsToJavaCollections, @Nullable TypeMappingMode genericContravariantArgumentMode, @Nullable TypeMappingMode genericInvariantArgumentMode, boolean mapTypeAliases) {
        this.needPrimitiveBoxing = needPrimitiveBoxing;
        this.needInlineClassWrapping = needInlineClassWrapping;
        this.isForAnnotationParameter = isForAnnotationParameter;
        this.skipDeclarationSiteWildcards = skipDeclarationSiteWildcards;
        this.skipDeclarationSiteWildcardsIfPossible = skipDeclarationSiteWildcardsIfPossible;
        this.genericArgumentMode = genericArgumentMode;
        this.kotlinCollectionsToJavaCollections = kotlinCollectionsToJavaCollections;
        this.genericContravariantArgumentMode = genericContravariantArgumentMode;
        this.genericInvariantArgumentMode = genericInvariantArgumentMode;
        this.mapTypeAliases = mapTypeAliases;
    }

    public /* synthetic */ TypeMappingMode(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, TypeMappingMode typeMappingMode, boolean bl7, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean bl8, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl2 = true;
        }
        if ((n2 & 2) != 0) {
            bl3 = true;
        }
        if ((n2 & 4) != 0) {
            bl4 = false;
        }
        if ((n2 & 8) != 0) {
            bl5 = false;
        }
        if ((n2 & 0x10) != 0) {
            bl6 = false;
        }
        if ((n2 & 0x20) != 0) {
            typeMappingMode = null;
        }
        if ((n2 & 0x40) != 0) {
            bl7 = true;
        }
        if ((n2 & 0x80) != 0) {
            typeMappingMode2 = typeMappingMode;
        }
        if ((n2 & 0x100) != 0) {
            typeMappingMode3 = typeMappingMode;
        }
        if ((n2 & 0x200) != 0) {
            bl8 = false;
        }
        this(bl2, bl3, bl4, bl5, bl6, typeMappingMode, bl7, typeMappingMode2, typeMappingMode3, bl8);
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    @NotNull
    public final TypeMappingMode toGenericArgumentMode(@NotNull Variance effectiveVariance, boolean ofArray) {
        TypeMappingMode typeMappingMode;
        Intrinsics.checkNotNullParameter((Object)effectiveVariance, "effectiveVariance");
        if (ofArray && this.isForAnnotationParameter) {
            typeMappingMode = this;
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()]) {
                case 1: {
                    typeMappingMode = this.genericContravariantArgumentMode;
                    if (typeMappingMode != null) break;
                    typeMappingMode = this;
                    break;
                }
                case 2: {
                    typeMappingMode = this.genericInvariantArgumentMode;
                    if (typeMappingMode != null) break;
                    typeMappingMode = this;
                    break;
                }
                default: {
                    typeMappingMode = this.genericArgumentMode;
                    if (typeMappingMode != null) break;
                    typeMappingMode = this;
                }
            }
        }
        return typeMappingMode;
    }

    @NotNull
    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    static {
        TypeMappingMode typeMappingMode = GENERIC_ARGUMENT;
        DEFAULT = new TypeMappingMode(false, false, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        typeMappingMode = GENERIC_ARGUMENT_UAST;
        DEFAULT_UAST = new TypeMappingMode(false, false, false, false, false, typeMappingMode, false, null, null, true, 476, null);
        typeMappingMode = GENERIC_ARGUMENT;
        CLASS_DECLARATION = new TypeMappingMode(false, true, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        SUPER_TYPE = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT, false, null, null, false, 983, null);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT, false, null, null, false, 919, null);
        typeMappingMode = GENERIC_ARGUMENT;
        VALUE_FOR_ANNOTATION = new TypeMappingMode(false, false, true, false, false, typeMappingMode, false, null, null, false, 984, null);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Variance.values().length];
            try {
                nArray[Variance.IN_VARIANCE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Variance.INVARIANT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

