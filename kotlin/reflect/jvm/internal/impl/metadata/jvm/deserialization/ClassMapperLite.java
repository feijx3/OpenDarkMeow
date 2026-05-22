/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class ClassMapperLite {
    @NotNull
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();
    @NotNull
    private static final String kotlin;
    @NotNull
    private static final Map<String, String> map;

    private ClassMapperLite() {
    }

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull String classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String string = map.get(classId);
        if (string == null) {
            string = 'L' + StringsKt.replace$default(classId, '.', '$', false, 4, null) + ';';
        }
        return string;
    }

    private static final void map$lambda$0$add(Map<String, String> $this_apply, String kotlinSimpleName, String javaInternalName) {
        $this_apply.put(kotlin + '/' + kotlinSimpleName, 'L' + javaInternalName + ';');
    }

    /*
     * WARNING - void declaration
     */
    static {
        Object object = new Character[]{Character.valueOf('k'), Character.valueOf('o'), Character.valueOf('t'), Character.valueOf('l'), Character.valueOf('i'), Character.valueOf('n')};
        kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf(object), "", null, null, 0, null, null, 62, null);
        Object $this$map_u24lambda_u240 = object = (Map)new LinkedHashMap();
        boolean bl2 = false;
        String[] stringArray = new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"};
        int n2 = 0;
        List<String> primitives = CollectionsKt.listOf(stringArray);
        int n22 = ((Collection)primitives).size() + -1;
        int n3 = ProgressionUtilKt.getProgressionLastElement(0, n22, 2);
        if (n2 <= n3) {
            while (true) {
                void var5_10;
                $this$map_u24lambda_u240.put(kotlin + '/' + primitives.get((int)var5_10), primitives.get((int)(var5_10 + true)));
                $this$map_u24lambda_u240.put(kotlin + '/' + primitives.get((int)var5_10) + "Array", '[' + primitives.get((int)(var5_10 + true)));
                if (var5_10 == n3) break;
                var5_10 += 2;
            }
        }
        $this$map_u24lambda_u240.put(kotlin + "/Unit", "V");
        ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "Any", "java/lang/Object");
        ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "Nothing", "java/lang/Void");
        ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "Annotation", "java/lang/annotation/Annotation");
        String[] stringArray2 = new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"};
        for (String string : CollectionsKt.listOf(stringArray2)) {
            ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, string, "java/lang/" + string);
        }
        String[] stringArray3 = new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"};
        for (String string : CollectionsKt.listOf(stringArray3)) {
            ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "collections/" + string, "java/util/" + string);
            ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "collections/Mutable" + string, "java/util/" + string);
        }
        ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "collections/Iterable", "java/lang/Iterable");
        ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "collections/MutableIterable", "java/lang/Iterable");
        ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "collections/Map.Entry", "java/util/Map$Entry");
        ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; ++i3) {
            ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "Function" + i3, kotlin + "/jvm/functions/Function" + i3);
            ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, "reflect/KFunction" + i3, kotlin + "/reflect/KFunction");
        }
        String[] stringArray4 = new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"};
        for (String string : CollectionsKt.listOf(stringArray4)) {
            ClassMapperLite.map$lambda$0$add((Map<String, String>)$this$map_u24lambda_u240, string + ".Companion", kotlin + "/jvm/internal/" + string + "CompanionObject");
        }
        map = object;
    }
}

