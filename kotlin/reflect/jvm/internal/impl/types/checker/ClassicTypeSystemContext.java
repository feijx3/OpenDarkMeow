/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerStateKt;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ClassicTypeSystemContext
extends TypeSystemCommonBackendContext,
TypeSystemInferenceExtensionContext {
    @Override
    @NotNull
    public SimpleTypeMarker withNullability(@NotNull RigidTypeMarker var1, boolean var2);

    @Override
    @Nullable
    public SimpleTypeMarker asRigidType(@NotNull KotlinTypeMarker var1);

    @Override
    @NotNull
    public SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker var1);

    @Override
    @NotNull
    public SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker var1);

    @Override
    @Nullable
    public CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker var1);

    @Override
    @NotNull
    public TypeConstructorMarker typeConstructor(@NotNull RigidTypeMarker var1);

    @Override
    public boolean isStarProjection(@NotNull TypeArgumentMarker var1);

    @Override
    public boolean isSingleClassifierType(@NotNull RigidTypeMarker var1);

    @NotNull
    public KotlinTypeMarker createFlexibleType(@NotNull RigidTypeMarker var1, @NotNull RigidTypeMarker var2);

    @SourceDebugExtension(value={"SMAP\nClassicTypeSystemContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContextKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 6 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n*L\n1#1,970:1\n1#2:971\n964#3:972\n964#3:973\n964#3:974\n964#3:975\n964#3:976\n964#3:977\n964#3:978\n964#3:979\n964#3:980\n964#3:981\n964#3:982\n964#3:983\n964#3:984\n964#3:985\n964#3:986\n964#3:987\n964#3:988\n964#3:989\n964#3:990\n964#3:991\n964#3:992\n964#3:993\n964#3:994\n964#3:995\n964#3:996\n964#3:997\n964#3:998\n964#3:999\n964#3:1000\n964#3:1001\n964#3:1002\n964#3:1003\n964#3:1004\n964#3:1005\n964#3:1006\n964#3:1007\n964#3:1008\n964#3:1009\n964#3:1010\n964#3:1011\n964#3:1012\n964#3:1013\n964#3:1014\n964#3:1015\n964#3:1016\n964#3:1017\n964#3:1018\n964#3:1019\n964#3:1020\n964#3:1021\n964#3:1022\n964#3:1023\n964#3:1024\n964#3:1025\n964#3:1026\n964#3:1027\n964#3:1028\n964#3:1029\n964#3:1030\n964#3:1031\n964#3:1032\n964#3:1033\n964#3:1034\n964#3:1035\n964#3:1036\n964#3:1037\n964#3:1038\n964#3:1039\n964#3:1040\n964#3:1041\n964#3:1042\n964#3:1043\n964#3:1044\n964#3:1048\n964#3:1049\n964#3:1050\n964#3:1051\n964#3:1052\n964#3:1053\n964#3:1054\n964#3:1055\n964#3:1061\n964#3:1062\n964#3:1063\n964#3:1064\n964#3:1065\n964#3:1066\n964#3:1073\n964#3:1074\n964#3:1075\n964#3:1090\n964#3:1091\n964#3:1092\n964#3:1093\n964#3:1104\n964#3:1105\n964#3:1106\n964#3:1107\n964#3:1108\n964#3:1109\n964#3:1110\n964#3:1111\n964#3:1112\n964#3:1113\n964#3:1114\n964#3:1115\n964#3:1116\n964#3:1117\n964#3:1118\n964#3:1119\n964#3:1120\n964#3:1121\n964#3:1122\n964#3:1123\n964#3:1124\n964#3:1125\n964#3:1126\n964#3:1127\n964#3:1128\n964#3:1129\n827#4:1045\n855#4,2:1046\n774#4:1058\n865#4,2:1059\n1563#4:1069\n1634#4,3:1070\n1563#4:1076\n1634#4,3:1077\n2783#4,7:1080\n827#4:1087\n855#4,2:1088\n1563#4:1094\n1634#4,3:1095\n1285#4,2:1098\n1299#4,4:1100\n21#5,2:1056\n264#6,2:1067\n*S KotlinDebug\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n*L\n41#1:972\n46#1:973\n59#1:974\n64#1:975\n70#1:976\n76#1:977\n81#1:978\n86#1:979\n91#1:980\n96#1:981\n101#1:982\n106#1:983\n111#1:984\n120#1:985\n126#1:986\n131#1:987\n136#1:988\n137#1:989\n142#1:990\n147#1:991\n152#1:992\n157#1:993\n166#1:994\n171#1:995\n176#1:996\n181#1:997\n193#1:998\n198#1:999\n203#1:1000\n208#1:1001\n213#1:1002\n218#1:1003\n223#1:1004\n228#1:1005\n233#1:1006\n234#1:1007\n240#1:1008\n246#1:1009\n251#1:1010\n256#1:1011\n261#1:1012\n266#1:1013\n271#1:1014\n276#1:1015\n281#1:1016\n286#1:1017\n291#1:1018\n292#1:1019\n298#1:1020\n299#1:1021\n304#1:1022\n309#1:1023\n314#1:1024\n320#1:1025\n328#1:1026\n334#1:1027\n339#1:1028\n344#1:1029\n349#1:1030\n354#1:1031\n359#1:1032\n364#1:1033\n378#1:1034\n388#1:1035\n393#1:1036\n419#1:1037\n424#1:1038\n429#1:1039\n430#1:1040\n471#1:1041\n477#1:1042\n482#1:1043\n487#1:1044\n493#1:1048\n498#1:1049\n515#1:1050\n521#1:1051\n526#1:1052\n531#1:1053\n542#1:1054\n553#1:1055\n576#1:1061\n581#1:1062\n586#1:1063\n593#1:1064\n598#1:1065\n604#1:1066\n609#1:1073\n636#1:1074\n637#1:1075\n693#1:1090\n698#1:1091\n703#1:1092\n708#1:1093\n746#1:1104\n751#1:1105\n756#1:1106\n761#1:1107\n766#1:1108\n771#1:1109\n776#1:1110\n781#1:1111\n786#1:1112\n791#1:1113\n796#1:1114\n801#1:1115\n806#1:1116\n811#1:1117\n816#1:1118\n821#1:1119\n826#1:1120\n831#1:1121\n836#1:1122\n845#1:1123\n846#1:1124\n857#1:1125\n862#1:1126\n867#1:1127\n898#1:1128\n905#1:1129\n488#1:1045\n488#1:1046,2\n561#1:1058\n561#1:1059,2\n605#1:1069\n605#1:1070,3\n679#1:1076\n679#1:1077,3\n679#1:1080,7\n685#1:1087\n685#1:1088,2\n734#1:1094\n734#1:1095,3\n735#1:1098,2\n735#1:1100,4\n555#1:1056,2\n605#1:1067,2\n*E\n"})
    public static final class DefaultImpls {
        public static boolean isDenotable(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((TypeConstructor)$receiver).isDenotable();
        }

        public static boolean isIntegerLiteralTypeConstructor(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return $receiver instanceof IntegerLiteralTypeConstructor;
        }

        @Nullable
        public static TypeParameterMarker getTypeParameter(@NotNull ClassicTypeSystemContext $this, @NotNull TypeVariableTypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof NewTypeVariableConstructor)) {
                boolean bl2 = false;
                TypeVariableTypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((NewTypeVariableConstructor)((Object)$receiver)).getOriginalTypeParameter();
        }

        @NotNull
        public static Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            TypeConstructorMarker typeConstructor2 = $this.typeConstructor($receiver);
            if (!(typeConstructor2 instanceof IntegerLiteralTypeConstructor)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((IntegerLiteralTypeConstructor)typeConstructor2).getPossibleTypes();
        }

        @NotNull
        public static SimpleTypeMarker withNullability(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver, boolean nullable) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((SimpleType)$receiver).makeNullableAsSpecified(nullable);
        }

        public static boolean isError(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return KotlinTypeKt.isError((KotlinType)$receiver);
        }

        public static boolean isStubType(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return TypeUtilsKt.isStubType((KotlinType)((Object)$receiver));
        }

        public static boolean isStubTypeForBuilderInference(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType)((Object)$receiver));
        }

        @Nullable
        public static KotlinTypeMarker lowerType(@NotNull ClassicTypeSystemContext $this, @NotNull CapturedTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof NewCapturedType)) {
                boolean bl2 = false;
                CapturedTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((NewCapturedType)$receiver).getLowerType();
        }

        public static boolean isIntersection(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return $receiver instanceof IntersectionTypeConstructor;
        }

        public static boolean identicalArguments(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker a2, @NotNull RigidTypeMarker b2) {
            Intrinsics.checkNotNullParameter(a2, "a");
            Intrinsics.checkNotNullParameter(b2, "b");
            if (!(a2 instanceof SimpleType)) {
                boolean $i$a$-require-ClassicTypeSystemContext$identicalArguments$32 = false;
                RigidTypeMarker $this$errorMessage$iv = a2;
                boolean $i$f$errorMessage = false;
                String $i$a$-require-ClassicTypeSystemContext$identicalArguments$32 = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException($i$a$-require-ClassicTypeSystemContext$identicalArguments$32.toString());
            }
            if (!(b2 instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = b2;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((SimpleType)a2).getArguments() == ((SimpleType)b2).getArguments();
        }

        @Nullable
        public static SimpleTypeMarker asRigidType(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            UnwrappedType unwrappedType = ((KotlinType)$receiver).unwrap();
            return unwrappedType instanceof SimpleType ? (SimpleType)unwrappedType : null;
        }

        @Nullable
        public static FlexibleTypeMarker asFlexibleType(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            UnwrappedType unwrappedType = ((KotlinType)$receiver).unwrap();
            return unwrappedType instanceof FlexibleType ? (FlexibleType)unwrappedType : null;
        }

        @Nullable
        public static DynamicTypeMarker asDynamicType(@NotNull ClassicTypeSystemContext $this, @NotNull FlexibleTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof FlexibleType)) {
                boolean bl2 = false;
                FlexibleTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            FlexibleTypeMarker flexibleTypeMarker = $receiver;
            return flexibleTypeMarker instanceof DynamicType ? (DynamicType)flexibleTypeMarker : null;
        }

        public static boolean isRawType(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return $receiver instanceof RawType;
        }

        @NotNull
        public static SimpleTypeMarker upperBound(@NotNull ClassicTypeSystemContext $this, @NotNull FlexibleTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof FlexibleType)) {
                boolean bl2 = false;
                FlexibleTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((FlexibleType)$receiver).getUpperBound();
        }

        @NotNull
        public static SimpleTypeMarker lowerBound(@NotNull ClassicTypeSystemContext $this, @NotNull FlexibleTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof FlexibleType)) {
                boolean bl2 = false;
                FlexibleTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((FlexibleType)$receiver).getLowerBound();
        }

        @Nullable
        public static CapturedTypeMarker asCapturedType(@NotNull ClassicTypeSystemContext $this, @NotNull SimpleTypeMarker $receiver) {
            SimpleTypeMarker simpleTypeMarker;
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                SimpleTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return $receiver instanceof SimpleTypeWithEnhancement ? $this.asCapturedType(((SimpleTypeWithEnhancement)$receiver).getOrigin()) : (CapturedTypeMarker)((simpleTypeMarker = $receiver) instanceof NewCapturedType ? (NewCapturedType)simpleTypeMarker : null);
        }

        @Nullable
        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            RigidTypeMarker rigidTypeMarker = $receiver;
            return rigidTypeMarker instanceof DefinitelyNotNullType ? (DefinitelyNotNullType)rigidTypeMarker : null;
        }

        public static boolean isNotNullTypeParameter(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return $receiver instanceof NotNullTypeParameter;
        }

        public static boolean isMarkedNullable(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return $receiver instanceof SimpleType && ((SimpleType)$receiver).isMarkedNullable();
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((SimpleType)$receiver).getConstructor();
        }

        @NotNull
        public static CapturedTypeConstructorMarker typeConstructor(@NotNull ClassicTypeSystemContext $this, @NotNull CapturedTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof NewCapturedType)) {
                boolean bl2 = false;
                CapturedTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((NewCapturedType)$receiver).getConstructor();
        }

        @NotNull
        public static TypeArgumentMarker projection(@NotNull ClassicTypeSystemContext $this, @NotNull CapturedTypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof NewCapturedTypeConstructor)) {
                boolean bl2 = false;
                CapturedTypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((NewCapturedTypeConstructor)$receiver).getProjection();
        }

        public static int argumentsCount(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((KotlinType)$receiver).getArguments().size();
        }

        @NotNull
        public static TypeArgumentMarker getArgument(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver, int index) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((KotlinType)$receiver).getArguments().get(index);
        }

        @NotNull
        public static List<TypeArgumentMarker> getArguments(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((KotlinType)$receiver).getArguments();
        }

        public static boolean isStarProjection(@NotNull ClassicTypeSystemContext $this, @NotNull TypeArgumentMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeProjection)) {
                boolean bl2 = false;
                TypeArgumentMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((TypeProjection)$receiver).isStarProjection();
        }

        @NotNull
        public static TypeVariance getVariance(@NotNull ClassicTypeSystemContext $this, @NotNull TypeArgumentMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeProjection)) {
                boolean bl2 = false;
                TypeArgumentMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            Variance variance = ((TypeProjection)$receiver).getProjectionKind();
            Intrinsics.checkNotNullExpressionValue((Object)variance, "getProjectionKind(...)");
            return TypeSystemContextKt.convertVariance(variance);
        }

        @Nullable
        public static KotlinTypeMarker getType(@NotNull ClassicTypeSystemContext $this, @NotNull TypeArgumentMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if ($this.isStarProjection($receiver)) {
                return null;
            }
            if (!($receiver instanceof TypeProjection)) {
                boolean bl2 = false;
                TypeArgumentMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((TypeProjection)$receiver).getType().unwrap();
        }

        public static int parametersCount(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((TypeConstructor)$receiver).getParameters().size();
        }

        @NotNull
        public static TypeParameterMarker getParameter(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver, int index) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor)$receiver).getParameters().get(index);
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "get(...)");
            return typeParameterDescriptor;
        }

        @NotNull
        public static List<TypeParameterMarker> getParameters(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            List<TypeParameterMarker> list = ((TypeConstructor)$receiver).getParameters();
            Intrinsics.checkNotNullExpressionValue(list, "getParameters(...)");
            return list;
        }

        @NotNull
        public static Collection<KotlinTypeMarker> supertypes(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            Collection<KotlinTypeMarker> collection = ((TypeConstructor)$receiver).getSupertypes();
            Intrinsics.checkNotNullExpressionValue(collection, "getSupertypes(...)");
            return collection;
        }

        @NotNull
        public static TypeVariance getVariance(@NotNull ClassicTypeSystemContext $this, @NotNull TypeParameterMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeParameterDescriptor)) {
                boolean bl2 = false;
                TypeParameterMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            Variance variance = ((TypeParameterDescriptor)$receiver).getVariance();
            Intrinsics.checkNotNullExpressionValue((Object)variance, "getVariance(...)");
            return TypeSystemContextKt.convertVariance(variance);
        }

        @NotNull
        public static List<KotlinTypeMarker> getUpperBounds(@NotNull ClassicTypeSystemContext $this, @NotNull TypeParameterMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeParameterDescriptor)) {
                boolean bl2 = false;
                TypeParameterMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            List<KotlinTypeMarker> list = ((TypeParameterDescriptor)$receiver).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(list, "getUpperBounds(...)");
            return list;
        }

        public static boolean hasRecursiveBounds(@NotNull ClassicTypeSystemContext $this, @NotNull TypeParameterMarker $receiver, @Nullable TypeConstructorMarker selfConstructor) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeParameterDescriptor)) {
                boolean bl2 = false;
                TypeParameterMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            TypeConstructorMarker typeConstructorMarker = selfConstructor;
            boolean bl3 = typeConstructorMarker == null ? true : typeConstructorMarker instanceof TypeConstructor;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)$receiver;
            if (!bl3) {
                boolean bl4 = false;
                TypeParameterDescriptor $this$errorMessage$iv = typeParameterDescriptor;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return TypeUtilsKt.hasTypeParameterRecursiveBounds$default((TypeParameterDescriptor)$receiver, (TypeConstructor)selfConstructor, null, 4, null);
        }

        public static boolean areEqualTypeConstructors(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker c1, @NotNull TypeConstructorMarker c2) {
            Intrinsics.checkNotNullParameter(c1, "c1");
            Intrinsics.checkNotNullParameter(c2, "c2");
            if (!(c1 instanceof TypeConstructor)) {
                boolean $i$a$-require-ClassicTypeSystemContext$areEqualTypeConstructors$32 = false;
                TypeConstructorMarker $this$errorMessage$iv = c1;
                boolean $i$f$errorMessage = false;
                String $i$a$-require-ClassicTypeSystemContext$areEqualTypeConstructors$32 = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException($i$a$-require-ClassicTypeSystemContext$areEqualTypeConstructors$32.toString());
            }
            if (!(c2 instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = c2;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return Intrinsics.areEqual(c1, c2);
        }

        public static boolean isClassTypeConstructor(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((TypeConstructor)$receiver).getDeclarationDescriptor() instanceof ClassDescriptor;
        }

        public static boolean isCommonFinalClassConstructor(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            ClassifierDescriptor classifierDescriptor = ((TypeConstructor)$receiver).getDeclarationDescriptor();
            ClassDescriptor classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
            if (classDescriptor == null) {
                return false;
            }
            ClassDescriptor classDescriptor2 = classDescriptor;
            return ModalityUtilsKt.isFinalClass(classDescriptor2) && classDescriptor2.getKind() != ClassKind.ENUM_ENTRY && classDescriptor2.getKind() != ClassKind.ANNOTATION_CLASS;
        }

        @NotNull
        public static TypeArgumentListMarker asArgumentList(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return (TypeArgumentListMarker)((Object)$receiver);
        }

        @Nullable
        public static SimpleType captureFromArguments(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker type, @NotNull CaptureStatus status) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter((Object)status, "status");
            if (!(type instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = type;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return NewCapturedTypeKt.captureFromArguments((SimpleType)type, status);
        }

        public static boolean isAnyConstructor(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor)$receiver, StandardNames.FqNames.any);
        }

        public static boolean isNothingConstructor(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor)$receiver, StandardNames.FqNames.nothing);
        }

        @NotNull
        public static TypeArgumentMarker asTypeArgument(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return TypeUtilsKt.asTypeProjection((KotlinType)$receiver);
        }

        public static boolean isSingleClassifierType(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return !KotlinTypeKt.isError((KotlinType)((Object)$receiver)) && !(((SimpleType)$receiver).getConstructor().getDeclarationDescriptor() instanceof TypeAliasDescriptor) && (((SimpleType)$receiver).getConstructor().getDeclarationDescriptor() != null || $receiver instanceof CapturedType || $receiver instanceof NewCapturedType || $receiver instanceof DefinitelyNotNullType || ((SimpleType)$receiver).getConstructor() instanceof IntegerLiteralTypeConstructor || DefaultImpls.isSingleClassifierTypeWithEnhancement($this, (SimpleTypeMarker)$receiver));
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext $this, SimpleTypeMarker $receiver) {
            return $receiver instanceof SimpleTypeWithEnhancement && $this.isSingleClassifierType(((SimpleTypeWithEnhancement)$receiver).getOrigin());
        }

        @NotNull
        public static KotlinTypeMarker intersectTypes(@NotNull ClassicTypeSystemContext $this, @NotNull Collection<? extends KotlinTypeMarker> types) {
            Intrinsics.checkNotNullParameter(types, "types");
            return IntersectionTypeKt.intersectTypes(types);
        }

        @NotNull
        public static KotlinTypeMarker createFlexibleType(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker lowerBound, @NotNull RigidTypeMarker upperBound) {
            Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
            Intrinsics.checkNotNullParameter(upperBound, "upperBound");
            if (!(lowerBound instanceof SimpleType)) {
                boolean $i$a$-require-ClassicTypeSystemContext$createFlexibleType$32 = false;
                ClassicTypeSystemContext $this$errorMessage$iv = $this;
                boolean $i$f$errorMessage = false;
                String $i$a$-require-ClassicTypeSystemContext$createFlexibleType$32 = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException($i$a$-require-ClassicTypeSystemContext$createFlexibleType$32.toString());
            }
            if (!(upperBound instanceof SimpleType)) {
                boolean bl2 = false;
                ClassicTypeSystemContext $this$errorMessage$iv = $this;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return KotlinTypeFactory.flexibleType((SimpleType)lowerBound, (SimpleType)upperBound);
        }

        @NotNull
        public static KotlinTypeMarker withNullability(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver, boolean nullable) {
            KotlinTypeMarker kotlinTypeMarker;
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            KotlinTypeMarker kotlinTypeMarker2 = $receiver;
            if (kotlinTypeMarker2 instanceof RigidTypeMarker) {
                kotlinTypeMarker = $this.withNullability((RigidTypeMarker)$receiver, nullable);
            } else if (kotlinTypeMarker2 instanceof FlexibleTypeMarker) {
                kotlinTypeMarker = $this.createFlexibleType($this.withNullability($this.lowerBound((FlexibleTypeMarker)$receiver), nullable), $this.withNullability($this.upperBound((FlexibleTypeMarker)$receiver), nullable));
            } else {
                throw new IllegalStateException("sealed".toString());
            }
            return kotlinTypeMarker;
        }

        @NotNull
        public static TypeCheckerState newTypeCheckerState(@NotNull ClassicTypeSystemContext $this, boolean errorTypesEqualToAnything, boolean stubTypesEqualToAnything, boolean dnnTypesEqualToFlexible) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(errorTypesEqualToAnything, stubTypesEqualToAnything, $this, null, null, 24, null);
        }

        @NotNull
        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver, boolean preserveAttributes) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof UnwrappedType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ClassicTypeSystemContextKt.access$makeDefinitelyNotNullOrNotNullInternal((UnwrappedType)$receiver);
        }

        public static boolean isProjectionNotNull(@NotNull ClassicTypeSystemContext $this, @NotNull CapturedTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof NewCapturedType)) {
                boolean bl2 = false;
                CapturedTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((NewCapturedType)$receiver).isProjectionNotNull();
        }

        @NotNull
        public static CaptureStatus captureStatus(@NotNull ClassicTypeSystemContext $this, @NotNull CapturedTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof NewCapturedType)) {
                boolean bl2 = false;
                CapturedTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((NewCapturedType)$receiver).getCaptureStatus();
        }

        public static boolean isOldCapturedType(@NotNull ClassicTypeSystemContext $this, @NotNull CapturedTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return $receiver instanceof CapturedType;
        }

        public static boolean isNullableType(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return TypeUtils.isNullableType((KotlinType)$receiver);
        }

        @NotNull
        public static SimpleTypeMarker original(@NotNull ClassicTypeSystemContext $this, @NotNull DefinitelyNotNullTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof DefinitelyNotNullType)) {
                boolean bl2 = false;
                DefinitelyNotNullTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((DefinitelyNotNullType)$receiver).getOriginal();
        }

        public static boolean isPrimitiveType(@NotNull ClassicTypeSystemContext $this, @NotNull SimpleTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                SimpleTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return KotlinBuiltIns.isPrimitiveType((KotlinType)((Object)$receiver));
        }

        public static boolean hasAnnotation(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return ((KotlinType)$receiver).getAnnotations().hasAnnotation(fqName);
        }

        @Nullable
        public static TypeParameterMarker getTypeParameterClassifier(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            ClassifierDescriptor classifierDescriptor = ((TypeConstructor)$receiver).getDeclarationDescriptor();
            return classifierDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor)classifierDescriptor : null;
        }

        public static boolean isInlineClass(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            ClassifierDescriptor classifierDescriptor = ((TypeConstructor)$receiver).getDeclarationDescriptor();
            ClassDescriptor classDescriptor = classifierDescriptor instanceof ClassDescriptor ? (ClassDescriptor)classifierDescriptor : null;
            return (classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null) instanceof InlineClassRepresentation;
        }

        @NotNull
        public static KotlinTypeMarker getRepresentativeUpperBound(@NotNull ClassicTypeSystemContext $this, @NotNull TypeParameterMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeParameterDescriptor)) {
                boolean bl2 = false;
                TypeParameterMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor)$receiver);
        }

        @Nullable
        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof KotlinType)) {
                boolean bl2 = false;
                KotlinTypeMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType)$receiver);
        }

        @Nullable
        public static PrimitiveType getPrimitiveType(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            ClassifierDescriptor classifierDescriptor = ((TypeConstructor)$receiver).getDeclarationDescriptor();
            Intrinsics.checkNotNull(classifierDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveType((ClassDescriptor)classifierDescriptor);
        }

        @Nullable
        public static PrimitiveType getPrimitiveArrayType(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            ClassifierDescriptor classifierDescriptor = ((TypeConstructor)$receiver).getDeclarationDescriptor();
            Intrinsics.checkNotNull(classifierDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor)classifierDescriptor);
        }

        public static boolean isUnderKotlinPackage(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            boolean bl2;
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl3 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            ClassifierDescriptor classifierDescriptor = ((TypeConstructor)$receiver).getDeclarationDescriptor();
            if (classifierDescriptor != null) {
                DeclarationDescriptor p0 = classifierDescriptor;
                boolean bl4 = false;
                bl2 = KotlinBuiltIns.isUnderKotlinPackage(p0);
            } else {
                bl2 = false;
            }
            return bl2;
        }

        @NotNull
        public static FqNameUnsafe getClassFqNameUnsafe(@NotNull ClassicTypeSystemContext $this, @NotNull TypeConstructorMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            if (!($receiver instanceof TypeConstructor)) {
                boolean bl2 = false;
                TypeConstructorMarker $this$errorMessage$iv = $receiver;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            ClassifierDescriptor classifierDescriptor = ((TypeConstructor)$receiver).getDeclarationDescriptor();
            Intrinsics.checkNotNull(classifierDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor)classifierDescriptor);
        }

        @NotNull
        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull ClassicTypeSystemContext $this, @NotNull RigidTypeMarker type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (!(type instanceof SimpleType)) {
                boolean bl2 = false;
                RigidTypeMarker $this$errorMessage$iv = type;
                boolean $i$f$errorMessage = false;
                String string = "ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass());
                throw new IllegalArgumentException(string.toString());
            }
            TypeSubstitutor substitutor = TypeConstructorSubstitution.Companion.create((KotlinType)((Object)type)).buildSubstitutor();
            return new TypeCheckerState.SupertypesPolicy.DoCustomTransform($this, substitutor){
                final /* synthetic */ ClassicTypeSystemContext this$0;
                final /* synthetic */ TypeSubstitutor $substitutor;
                {
                    this.this$0 = $receiver;
                    this.$substitutor = $substitutor;
                }

                public SimpleTypeMarker transformType(TypeCheckerState state, KotlinTypeMarker type) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(type, "type");
                    RigidTypeMarker rigidTypeMarker = this.this$0.lowerBoundIfFlexible(type);
                    Intrinsics.checkNotNull(rigidTypeMarker, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                    KotlinType kotlinType = this.$substitutor.safeSubstitute((KotlinType)((Object)rigidTypeMarker), Variance.INVARIANT);
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "safeSubstitute(...)");
                    SimpleTypeMarker simpleTypeMarker = this.this$0.asRigidType(kotlinType);
                    Intrinsics.checkNotNull(simpleTypeMarker);
                    return simpleTypeMarker;
                }
            };
        }

        public static boolean isTypeVariableType(@NotNull ClassicTypeSystemContext $this, @NotNull KotlinTypeMarker $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return $receiver instanceof UnwrappedType && ((UnwrappedType)$receiver).getConstructor() instanceof NewTypeVariableConstructor;
        }

        public static boolean isK2(@NotNull ClassicTypeSystemContext $this) {
            return false;
        }
    }
}

