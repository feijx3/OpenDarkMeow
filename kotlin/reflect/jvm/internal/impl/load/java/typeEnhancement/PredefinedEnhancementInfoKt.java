/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$10;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$11;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$12;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$13;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$14;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$15;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$16;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$17;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$18;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$19;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$2;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$20;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$21;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$22;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$23;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$24;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$25;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$26;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$27;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$28;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$29;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$3;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$30;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$31;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$32;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$33;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$34;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$35;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$36;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$37;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$38;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$39;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$4;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$40;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$41;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$42;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$43;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$5;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$6;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$7;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$8;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$9;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder\n*L\n1#1,347:1\n287#1:349\n13#2:348\n293#3:350\n293#3:351\n293#3:352\n293#3:353\n293#3:354\n293#3:355\n293#3:356\n293#3:357\n293#3:358\n293#3:359\n293#3:360\n293#3:361\n293#3:362\n293#3:363\n293#3:364\n293#3:365\n293#3:366\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n*L\n67#1:349\n56#1:348\n68#1:350\n73#1:351\n78#1:352\n93#1:353\n117#1:354\n134#1:355\n154#1:356\n202#1:357\n214#1:358\n234#1:359\n240#1:360\n246#1:361\n253#1:362\n258#1:363\n264#1:364\n270#1:365\n277#1:366\n*E\n"})
public final class PredefinedEnhancementInfoKt {
    @NotNull
    private static final JavaTypeQualifiers NULLABLE;
    @NotNull
    private static final JavaTypeQualifiers NOT_PLATFORM;
    @NotNull
    private static final JavaTypeQualifiers NOT_NULLABLE;
    @NotNull
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;

    @NotNull
    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$1$lambda$0(String $JFConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM};
        $this$function.parameter($JFConsumer, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$3$lambda$2(SignatureBuildingComponents $this_signatures, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM};
        $this$function.returns($this_signatures.javaUtil("Spliterator"), javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$4(String $JFPredicate, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM};
        $this$function.parameter($JFPredicate, javaTypeQualifiersArray);
        $this$function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$5(String $JUStream, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM};
        $this$function.returns($JUStream, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$6(String $JUStream, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM};
        $this$function.returns($JUStream, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$8(String $JFUnaryOperator, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM};
        $this$function.parameter($JFUnaryOperator, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$9(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$10(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$11(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$12(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$14(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$15(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$16(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$17(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$19(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$20(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$21(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$22(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$23(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$24(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$26(String $JFBiConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM};
        $this$function.parameter($JFBiConsumer, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$27(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$28(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$29(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        $this$function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$30(String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM};
        $this$function.parameter($JFBiFunction, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$31(String $JLObject, String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM, NULLABLE, NULLABLE};
        $this$function.parameter($JFBiFunction, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$32(String $JLObject, String $JFFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM, NOT_PLATFORM};
        $this$function.parameter($JFFunction, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$33(String $JLObject, String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_PLATFORM, NOT_NULLABLE, NULLABLE};
        $this$function.parameter($JFBiFunction, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$34(String $JLObject, String $JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_NULLABLE};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_NULLABLE, NOT_NULLABLE, NULLABLE};
        $this$function.parameter($JFBiFunction, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$36(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$37(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$39(String $JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_NULLABLE};
        $this$function.returns($JUOptional, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$40(String $JLObject, String $JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_NULLABLE};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_NULLABLE};
        $this$function.returns($JUOptional, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$41(String $JLObject, String $JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_NULLABLE};
        $this$function.returns($JUOptional, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$42(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$43(String $JFConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM, NOT_NULLABLE};
        $this$function.parameter($JFConsumer, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$46$lambda$45(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NULLABLE};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$48$lambda$47(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        $this$function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$50$lambda$49(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        $this$function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$52$lambda$51(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$54$lambda$53(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$56$lambda$55(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$58$lambda$57(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.parameter($JLObject, javaTypeQualifiersArray);
        javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    private static final Unit PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$60$lambda$59(String $JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder $this$function) {
        Intrinsics.checkNotNullParameter($this$function, "$this$function");
        JavaTypeQualifiers[] javaTypeQualifiersArray = new JavaTypeQualifiers[]{NOT_PLATFORM};
        $this$function.returns($JLObject, javaTypeQualifiersArray);
        return Unit.INSTANCE;
    }

    static {
        SignatureEnhancementBuilder this_$iv;
        SignatureEnhancementBuilder signatureEnhancementBuilder;
        NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
        NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
        NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);
        boolean $i$f$signatures = false;
        SignatureBuildingComponents $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462 = SignatureBuildingComponents.INSTANCE;
        boolean bl2 = false;
        String JLObject = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaLang("Object");
        String JFPredicate = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("Predicate");
        String JFFunction = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("Function");
        String JFConsumer = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("Consumer");
        String JFBiFunction = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("BiFunction");
        String JFBiConsumer = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("BiConsumer");
        String JFUnaryOperator = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("UnaryOperator");
        String JUStream = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("stream/Stream");
        String JUOptional = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("Optional");
        boolean $i$f$enhancement = false;
        SignatureEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461 = signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        boolean bl3 = false;
        SignatureEnhancementBuilder signatureEnhancementBuilder2 = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        String internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("Iterator");
        boolean $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u241 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl4 = false;
        Object object = JFConsumer;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u241, "forEachRemaining", null, new PredefinedEnhancementInfoKt$$Lambda$0((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaLang("Iterable");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u243 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl5 = false;
        object = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u243, "spliterator", null, new PredefinedEnhancementInfoKt$$Lambda$1((SignatureBuildingComponents)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("Collection");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u247 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl6 = false;
        object = JFPredicate;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u247, "removeIf", null, new PredefinedEnhancementInfoKt$$Lambda$2((String)object), 2, null);
        object = JUStream;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u247, "stream", null, new PredefinedEnhancementInfoKt$$Lambda$3((String)object), 2, null);
        object = JUStream;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u247, "parallelStream", null, new PredefinedEnhancementInfoKt$$Lambda$4((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("List");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2413 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl7 = false;
        object = JFUnaryOperator;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2413, "replaceAll", null, new PredefinedEnhancementInfoKt$$Lambda$5((String)object), 2, null);
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2413.function("addFirst", "2.1", new PredefinedEnhancementInfoKt$$Lambda$6((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2413.function("addLast", "2.1", new PredefinedEnhancementInfoKt$$Lambda$7((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2413.function("removeFirst", "2.1", new PredefinedEnhancementInfoKt$$Lambda$8((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2413.function("removeLast", "2.1", new PredefinedEnhancementInfoKt$$Lambda$9((String)object));
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("LinkedList");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2418 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl8 = false;
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2418.function("addFirst", "2.1", new PredefinedEnhancementInfoKt$$Lambda$10((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2418.function("addLast", "2.1", new PredefinedEnhancementInfoKt$$Lambda$11((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2418.function("removeFirst", "2.1", new PredefinedEnhancementInfoKt$$Lambda$12((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2418.function("removeLast", "2.1", new PredefinedEnhancementInfoKt$$Lambda$13((String)object));
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("LinkedHashSet");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2425 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl9 = false;
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2425.function("addFirst", "2.2", new PredefinedEnhancementInfoKt$$Lambda$14((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2425.function("addLast", "2.2", new PredefinedEnhancementInfoKt$$Lambda$15((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2425.function("removeFirst", "2.2", new PredefinedEnhancementInfoKt$$Lambda$16((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2425.function("removeLast", "2.2", new PredefinedEnhancementInfoKt$$Lambda$17((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2425.function("getFirst", "2.2", new PredefinedEnhancementInfoKt$$Lambda$18((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2425.function("getLast", "2.2", new PredefinedEnhancementInfoKt$$Lambda$19((String)object));
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("Map");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl10 = false;
        object = JFBiConsumer;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "forEach", null, new PredefinedEnhancementInfoKt$$Lambda$20((String)object), 2, null);
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "putIfAbsent", null, new PredefinedEnhancementInfoKt$$Lambda$21((String)object), 2, null);
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "replace", null, new PredefinedEnhancementInfoKt$$Lambda$22((String)object), 2, null);
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "replace", null, new PredefinedEnhancementInfoKt$$Lambda$23((String)object), 2, null);
        object = JFBiFunction;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "replaceAll", null, new PredefinedEnhancementInfoKt$$Lambda$24((String)object), 2, null);
        object = JFBiFunction;
        String string = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "compute", null, new PredefinedEnhancementInfoKt$$Lambda$25(string, (String)object), 2, null);
        object = JFFunction;
        string = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "computeIfAbsent", null, new PredefinedEnhancementInfoKt$$Lambda$26(string, (String)object), 2, null);
        object = JFBiFunction;
        string = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "computeIfPresent", null, new PredefinedEnhancementInfoKt$$Lambda$27(string, (String)object), 2, null);
        object = JFBiFunction;
        string = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2435, "merge", null, new PredefinedEnhancementInfoKt$$Lambda$28(string, (String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaUtil("LinkedHashMap");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2438 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl11 = false;
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2438.function("putFirst", "2.2", new PredefinedEnhancementInfoKt$$Lambda$29((String)object));
        object = JLObject;
        $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2438.function("putLast", "2.2", new PredefinedEnhancementInfoKt$$Lambda$30((String)object));
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        boolean $i$f$forClass2 = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2444 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, JUOptional);
        boolean bl12 = false;
        object = JUOptional;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2444, "empty", null, new PredefinedEnhancementInfoKt$$Lambda$31((String)object), 2, null);
        object = JUOptional;
        string = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2444, "of", null, new PredefinedEnhancementInfoKt$$Lambda$32(string, (String)object), 2, null);
        object = JUOptional;
        string = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2444, "ofNullable", null, new PredefinedEnhancementInfoKt$$Lambda$33(string, (String)object), 2, null);
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2444, "get", null, new PredefinedEnhancementInfoKt$$Lambda$34((String)object), 2, null);
        object = JFConsumer;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2444, "ifPresent", null, new PredefinedEnhancementInfoKt$$Lambda$35((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaLang("ref/Reference");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2446 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl13 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2446, "get", null, new PredefinedEnhancementInfoKt$$Lambda$36((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2448 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, JFPredicate);
        boolean bl14 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2448, "test", null, new PredefinedEnhancementInfoKt$$Lambda$37((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("BiPredicate");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2450 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl15 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2450, "test", null, new PredefinedEnhancementInfoKt$$Lambda$38((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2452 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, JFConsumer);
        boolean bl16 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2452, "accept", null, new PredefinedEnhancementInfoKt$$Lambda$39((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2454 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, JFBiConsumer);
        boolean bl17 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2454, "accept", null, new PredefinedEnhancementInfoKt$$Lambda$40((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2456 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, JFFunction);
        boolean bl18 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2456, "apply", null, new PredefinedEnhancementInfoKt$$Lambda$41((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2458 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, JFBiFunction);
        boolean bl19 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2458, "apply", null, new PredefinedEnhancementInfoKt$$Lambda$42((String)object), 2, null);
        this_$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461;
        internalName$iv = $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462.javaFunction("Supplier");
        $i$f$forClass = false;
        SignatureEnhancementBuilder.ClassEnhancementBuilder $this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2460 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(this_$iv, internalName$iv);
        boolean bl20 = false;
        object = JLObject;
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default($this$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE_u24lambda_u2462_u24lambda_u2461_u24lambda_u2460, "get", null, new PredefinedEnhancementInfoKt$$Lambda$43((String)object), 2, null);
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda0(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$1$lambda$0(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda1(SignatureBuildingComponents signatureBuildingComponents, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$3$lambda$2(signatureBuildingComponents, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda2(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$4(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda3(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$5(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda4(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$7$lambda$6(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda5(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$8(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda6(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$9(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda7(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$10(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda8(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$11(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda9(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$13$lambda$12(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda10(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$14(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda11(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$15(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda12(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$16(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda13(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$18$lambda$17(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda14(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$19(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda15(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$20(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda16(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$21(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda17(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$22(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda18(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$23(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda19(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$25$lambda$24(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda20(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$26(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda21(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$27(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda22(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$28(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda23(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$29(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda24(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$30(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda25(String string, String string2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$31(string, string2, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda26(String string, String string2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$32(string, string2, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda27(String string, String string2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$33(string, string2, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda28(String string, String string2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$35$lambda$34(string, string2, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda29(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$36(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda30(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$38$lambda$37(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda31(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$39(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda32(String string, String string2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$40(string, string2, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda33(String string, String string2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$41(string, string2, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda34(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$42(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda35(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$44$lambda$43(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda36(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$46$lambda$45(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda37(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$48$lambda$47(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda38(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$50$lambda$49(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda39(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$52$lambda$51(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda40(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$54$lambda$53(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda41(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$56$lambda$55(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda42(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$58$lambda$57(string, functionEnhancementBuilder);
    }

    static /* synthetic */ Unit accessor$PredefinedEnhancementInfoKt$lambda43(String string, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        return PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$62$lambda$61$lambda$60$lambda$59(string, functionEnhancementBuilder);
    }
}

