/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,347:1\n1563#2:348\n1634#2,3:349\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedFunctionEnhancementInfo\n*L\n41#1:348\n41#1:349,3\n*E\n"})
public final class PredefinedFunctionEnhancementInfo {
    @Nullable
    private final TypeEnhancementInfo returnTypeInfo;
    @NotNull
    private final List<TypeEnhancementInfo> parametersInfo;
    @Nullable
    private final String errorsSinceLanguageVersion;
    @Nullable
    private final PredefinedFunctionEnhancementInfo warningModeClone;

    /*
     * WARNING - void declaration
     */
    public PredefinedFunctionEnhancementInfo(@Nullable TypeEnhancementInfo returnTypeInfo, @NotNull List<TypeEnhancementInfo> parametersInfo, @Nullable String errorsSinceLanguageVersion) {
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
        Intrinsics.checkNotNullParameter(parametersInfo, "parametersInfo");
        this.returnTypeInfo = returnTypeInfo;
        this.parametersInfo = parametersInfo;
        this.errorsSinceLanguageVersion = errorsSinceLanguageVersion;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo2 = this;
        if (this.errorsSinceLanguageVersion != null) {
            Collection<TypeEnhancementInfo> collection;
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            TypeEnhancementInfo typeEnhancementInfo = this.returnTypeInfo;
            Iterable iterable = this.parametersInfo;
            TypeEnhancementInfo typeEnhancementInfo2 = typeEnhancementInfo != null ? typeEnhancementInfo.copyForWarnings() : null;
            PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo3 = predefinedFunctionEnhancementInfo2;
            boolean $i$f$map = false;
            void var6_8 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                TypeEnhancementInfo typeEnhancementInfo3 = (TypeEnhancementInfo)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl2 = false;
                void v2 = it;
                collection.add(v2 != null ? v2.copyForWarnings() : null);
            }
            collection = (List)destination$iv$iv;
            predefinedFunctionEnhancementInfo2 = predefinedFunctionEnhancementInfo3;
            String string = null;
            List list = collection;
            TypeEnhancementInfo typeEnhancementInfo4 = typeEnhancementInfo2;
            predefinedFunctionEnhancementInfo = new PredefinedFunctionEnhancementInfo(typeEnhancementInfo4, list, string);
        } else {
            predefinedFunctionEnhancementInfo = null;
        }
        predefinedFunctionEnhancementInfo2.warningModeClone = predefinedFunctionEnhancementInfo;
    }

    public /* synthetic */ PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List list, String string, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            typeEnhancementInfo = null;
        }
        if ((n2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((n2 & 4) != 0) {
            string = null;
        }
        this(typeEnhancementInfo, list, string);
    }

    @Nullable
    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    @NotNull
    public final List<TypeEnhancementInfo> getParametersInfo() {
        return this.parametersInfo;
    }

    @Nullable
    public final String getErrorsSinceLanguageVersion() {
        return this.errorsSinceLanguageVersion;
    }

    @Nullable
    public final PredefinedFunctionEnhancementInfo getWarningModeClone() {
        return this.warningModeClone;
    }

    public PredefinedFunctionEnhancementInfo() {
        this(null, null, null, 7, null);
    }
}

