/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementInfo\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,347:1\n463#2:348\n413#2:349\n1252#3,4:350\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementInfo\n*L\n28#1:348\n28#1:349\n28#1:350,4\n*E\n"})
public final class TypeEnhancementInfo {
    @NotNull
    private final Map<Integer, JavaTypeQualifiers> map;

    public TypeEnhancementInfo(@NotNull Map<Integer, JavaTypeQualifiers> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    @NotNull
    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.map;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final TypeEnhancementInfo copyForWarnings() {
        void $this$mapValuesTo$iv$iv;
        Map<Integer, JavaTypeQualifiers> $this$mapValues$iv = this.map;
        boolean $i$f$mapValues = false;
        Map<Integer, JavaTypeQualifiers> map = $this$mapValues$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            void it;
            void it$iv$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map2 = destination$iv$iv;
            boolean bl2 = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            Object k2 = it$iv$iv.getKey();
            Map map3 = map2;
            boolean bl3 = false;
            JavaTypeQualifiers javaTypeQualifiers = JavaTypeQualifiers.copy$default((JavaTypeQualifiers)it.getValue(), null, null, false, true, 7, null);
            map3.put(k2, javaTypeQualifiers);
        }
        Map map4 = destination$iv$iv;
        return new TypeEnhancementInfo(map4);
    }
}

