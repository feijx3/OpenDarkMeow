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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SignatureEnhancementBuilder {
    @NotNull
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures = new LinkedHashMap();

    @NotNull
    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }

    public final class ClassEnhancementBuilder {
        @NotNull
        private final String className;

        public ClassEnhancementBuilder(String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.className = className;
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        public final void function(@NotNull String name, @Nullable String errorsSinceLanguageVersion, @NotNull Function1<? super FunctionEnhancementBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(block, "block");
            Map map = SignatureEnhancementBuilder.this.signatures;
            Object object = new FunctionEnhancementBuilder(name, errorsSinceLanguageVersion);
            block.invoke((FunctionEnhancementBuilder)object);
            object = ((FunctionEnhancementBuilder)object).build();
            map.put(((Pair)object).getFirst(), ((Pair)object).getSecond());
        }

        public static /* synthetic */ void function$default(ClassEnhancementBuilder classEnhancementBuilder, String string, String string2, Function1 function1, int n2, Object object) {
            if ((n2 & 2) != 0) {
                string2 = null;
            }
            classEnhancementBuilder.function(string, string2, function1);
        }

        @SourceDebugExtension(value={"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,347:1\n1222#2,2:348\n1252#2,4:350\n1222#2,2:354\n1252#2,4:356\n1563#2:360\n1634#2,3:361\n1563#2:364\n1634#2,3:365\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder\n*L\n319#1:348,2\n319#1:350,4\n330#1:354,2\n330#1:356,4\n338#1:360\n338#1:361,3\n339#1:364\n339#1:365,3\n*E\n"})
        public final class FunctionEnhancementBuilder {
            @NotNull
            private final String functionName;
            @Nullable
            private final String errorsSinceLanguageVersion;
            @NotNull
            private final List<Pair<String, TypeEnhancementInfo>> parameters;
            @NotNull
            private Pair<String, TypeEnhancementInfo> returnType;

            public FunctionEnhancementBuilder(@Nullable String functionName, String errorsSinceLanguageVersion) {
                Intrinsics.checkNotNullParameter(functionName, "functionName");
                this.functionName = functionName;
                this.errorsSinceLanguageVersion = errorsSinceLanguageVersion;
                this.parameters = new ArrayList();
                this.returnType = TuplesKt.to("V", null);
            }

            /*
             * WARNING - void declaration
             */
            public final void parameter(@NotNull String type, JavaTypeQualifiers ... qualifiers) {
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
                Collection collection = this.parameters;
                String string = type;
                if (qualifiers.length == 0) {
                    typeEnhancementInfo = null;
                } else {
                    void $this$associateByTo$iv$iv;
                    void $this$associateBy$iv;
                    Iterable<IndexedValue<JavaTypeQualifiers>> iterable = ArraysKt.withIndex(qualifiers);
                    String string2 = string;
                    boolean $i$f$associateBy = false;
                    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                    void var7_8 = $this$associateBy$iv;
                    Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                    boolean $i$f$associateByTo = false;
                    for (Object element$iv$iv : $this$associateByTo$iv$iv) {
                        IndexedValue indexedValue = (IndexedValue)element$iv$iv;
                        Map map = destination$iv$iv;
                        boolean bl2 = false;
                        IndexedValue it = (IndexedValue)element$iv$iv;
                        Integer n2 = it.getIndex();
                        boolean bl3 = false;
                        JavaTypeQualifiers javaTypeQualifiers = (JavaTypeQualifiers)it.getValue();
                        map.put(n2, javaTypeQualifiers);
                    }
                    string = string2;
                    Map map = destination$iv$iv;
                    typeEnhancementInfo = new TypeEnhancementInfo(map);
                }
                collection.add(TuplesKt.to(string, typeEnhancementInfo));
            }

            /*
             * WARNING - void declaration
             */
            public final void returns(@NotNull String type, JavaTypeQualifiers ... qualifiers) {
                Map map;
                void $this$associateByTo$iv$iv;
                void $this$associateBy$iv;
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
                Iterable<IndexedValue<JavaTypeQualifiers>> iterable = ArraysKt.withIndex(qualifiers);
                String string = type;
                FunctionEnhancementBuilder functionEnhancementBuilder = this;
                boolean $i$f$associateBy = false;
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                void var6_8 = $this$associateBy$iv;
                Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                boolean $i$f$associateByTo = false;
                for (Object element$iv$iv : $this$associateByTo$iv$iv) {
                    IndexedValue indexedValue = (IndexedValue)element$iv$iv;
                    map = destination$iv$iv;
                    boolean bl2 = false;
                    IndexedValue it = (IndexedValue)element$iv$iv;
                    Integer n2 = it.getIndex();
                    boolean bl3 = false;
                    JavaTypeQualifiers javaTypeQualifiers = (JavaTypeQualifiers)it.getValue();
                    map.put(n2, javaTypeQualifiers);
                }
                Map map2 = map = destination$iv$iv;
                functionEnhancementBuilder.returnType = TuplesKt.to(string, new TypeEnhancementInfo(map2));
            }

            public final void returns(@NotNull JvmPrimitiveType type) {
                Intrinsics.checkNotNullParameter((Object)type, "type");
                String string = type.getDesc();
                Intrinsics.checkNotNullExpressionValue(string, "getDesc(...)");
                this.returnType = TuplesKt.to(string, null);
            }

            @NotNull
            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                Pair it;
                Collection<TypeEnhancementInfo> collection;
                Iterable $this$mapTo$iv$iv;
                Iterable $this$map$iv;
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                ClassEnhancementBuilder classEnhancementBuilder = ClassEnhancementBuilder.this;
                SignatureBuildingComponents $this$build_u24lambda_u246 = signatureBuildingComponents;
                boolean bl2 = false;
                Iterable iterable = this.parameters;
                Object object = this.functionName;
                SignatureBuildingComponents signatureBuildingComponents2 = $this$build_u24lambda_u246;
                String string = classEnhancementBuilder.getClassName();
                Object object2 = $this$build_u24lambda_u246;
                boolean $i$f$map = false;
                void var11_11 = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Pair pair = (Pair)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl3 = false;
                    collection.add((TypeEnhancementInfo)((Object)((String)it.getFirst())));
                }
                collection = (List)destination$iv$iv;
                String string2 = ((SignatureBuildingComponents)object2).signature(string, signatureBuildingComponents2.jvmDescriptor((String)object, (List<String>)collection, this.returnType.getFirst()));
                $this$map$iv = this.parameters;
                object = this.returnType.getSecond();
                object2 = string2;
                $i$f$map = false;
                $this$mapTo$iv$iv = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    it = (Pair)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl4 = false;
                    collection.add((TypeEnhancementInfo)it.getSecond());
                }
                collection = (List)destination$iv$iv;
                String string3 = this.errorsSinceLanguageVersion;
                Collection<TypeEnhancementInfo> collection2 = collection;
                Object object3 = object;
                return TuplesKt.to(object2, new PredefinedFunctionEnhancementInfo((TypeEnhancementInfo)object3, (List<TypeEnhancementInfo>)collection2, string3));
            }
        }
    }
}

