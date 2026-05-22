/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nKotlinTarget.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTarget.kt\norg/jetbrains/kotlin/descriptors/annotations/KotlinTarget\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,140:1\n774#2:141\n865#2,2:142\n*S KotlinDebug\n*F\n+ 1 KotlinTarget.kt\norg/jetbrains/kotlin/descriptors/annotations/KotlinTarget\n*L\n81#1:141\n81#1:142,2\n*E\n"})
public final class KotlinTarget
extends Enum<KotlinTarget> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String description;
    private final boolean isDefault;
    @NotNull
    private static final HashMap<String, KotlinTarget> map;
    @NotNull
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET;
    @NotNull
    private static final Set<KotlinTarget> ALL_TARGET_SET;
    @NotNull
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST;
    @NotNull
    private static final List<KotlinTarget> LOCAL_CLASS_LIST;
    @NotNull
    private static final List<KotlinTarget> CLASS_LIST;
    @NotNull
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST;
    @NotNull
    private static final List<KotlinTarget> OBJECT_LIST;
    @NotNull
    private static final List<KotlinTarget> INTERFACE_LIST;
    @NotNull
    private static final List<KotlinTarget> ENUM_LIST;
    @NotNull
    private static final List<KotlinTarget> ENUM_ENTRY_LIST;
    @NotNull
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST;
    @NotNull
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST;
    @NotNull
    private static final List<KotlinTarget> FUNCTION_LIST;
    @NotNull
    private static final List<KotlinTarget> FILE_LIST;
    @NotNull
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING;
    public static final /* enum */ KotlinTarget CLASS;
    public static final /* enum */ KotlinTarget ANNOTATION_CLASS;
    public static final /* enum */ KotlinTarget TYPE_PARAMETER;
    public static final /* enum */ KotlinTarget PROPERTY;
    public static final /* enum */ KotlinTarget FIELD;
    public static final /* enum */ KotlinTarget LOCAL_VARIABLE;
    public static final /* enum */ KotlinTarget VALUE_PARAMETER;
    public static final /* enum */ KotlinTarget CONSTRUCTOR;
    public static final /* enum */ KotlinTarget FUNCTION;
    public static final /* enum */ KotlinTarget PROPERTY_GETTER;
    public static final /* enum */ KotlinTarget PROPERTY_SETTER;
    public static final /* enum */ KotlinTarget TYPE;
    public static final /* enum */ KotlinTarget EXPRESSION;
    public static final /* enum */ KotlinTarget FILE;
    public static final /* enum */ KotlinTarget TYPEALIAS;
    public static final /* enum */ KotlinTarget TYPE_PROJECTION;
    public static final /* enum */ KotlinTarget STAR_PROJECTION;
    public static final /* enum */ KotlinTarget PROPERTY_PARAMETER;
    public static final /* enum */ KotlinTarget CLASS_ONLY;
    public static final /* enum */ KotlinTarget OBJECT;
    public static final /* enum */ KotlinTarget STANDALONE_OBJECT;
    public static final /* enum */ KotlinTarget COMPANION_OBJECT;
    public static final /* enum */ KotlinTarget INTERFACE;
    public static final /* enum */ KotlinTarget ENUM_CLASS;
    public static final /* enum */ KotlinTarget ENUM_ENTRY;
    public static final /* enum */ KotlinTarget LOCAL_CLASS;
    public static final /* enum */ KotlinTarget LOCAL_FUNCTION;
    public static final /* enum */ KotlinTarget MEMBER_FUNCTION;
    public static final /* enum */ KotlinTarget TOP_LEVEL_FUNCTION;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY_WITH_BACKING_FIELD;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY_WITH_DELEGATE;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY_WITH_DELEGATE;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE;
    public static final /* enum */ KotlinTarget BACKING_FIELD;
    public static final /* enum */ KotlinTarget INITIALIZER;
    public static final /* enum */ KotlinTarget DESTRUCTURING_DECLARATION;
    public static final /* enum */ KotlinTarget LAMBDA_EXPRESSION;
    public static final /* enum */ KotlinTarget ANONYMOUS_FUNCTION;
    public static final /* enum */ KotlinTarget OBJECT_LITERAL;
    private static final /* synthetic */ KotlinTarget[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private KotlinTarget(String description, boolean isDefault) {
        this.description = description;
        this.isDefault = isDefault;
    }

    /* synthetic */ KotlinTarget(String string, int n2, String string2, boolean bl2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            bl2 = true;
        }
        this(string2, bl2);
    }

    public static KotlinTarget[] values() {
        return (KotlinTarget[])$VALUES.clone();
    }

    public static KotlinTarget valueOf(String value) {
        return Enum.valueOf(KotlinTarget.class, value);
    }

    @NotNull
    public static EnumEntries<KotlinTarget> getEntries() {
        return $ENTRIES;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_4;
        void $this$filterTo$iv$iv;
        CLASS = new KotlinTarget("CLASS", 0, "class", false, 2, null);
        ANNOTATION_CLASS = new KotlinTarget("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
        TYPE_PARAMETER = new KotlinTarget("type parameter", false);
        PROPERTY = new KotlinTarget("PROPERTY", 3, "property", false, 2, null);
        FIELD = new KotlinTarget("FIELD", 4, "field", false, 2, null);
        LOCAL_VARIABLE = new KotlinTarget("LOCAL_VARIABLE", 5, "local variable", false, 2, null);
        VALUE_PARAMETER = new KotlinTarget("VALUE_PARAMETER", 6, "value parameter", false, 2, null);
        CONSTRUCTOR = new KotlinTarget("CONSTRUCTOR", 7, "constructor", false, 2, null);
        FUNCTION = new KotlinTarget("FUNCTION", 8, "function", false, 2, null);
        PROPERTY_GETTER = new KotlinTarget("PROPERTY_GETTER", 9, "getter", false, 2, null);
        PROPERTY_SETTER = new KotlinTarget("PROPERTY_SETTER", 10, "setter", false, 2, null);
        TYPE = new KotlinTarget("type usage", false);
        EXPRESSION = new KotlinTarget("expression", false);
        FILE = new KotlinTarget("file", false);
        TYPEALIAS = new KotlinTarget("typealias", false);
        TYPE_PROJECTION = new KotlinTarget("type projection", false);
        STAR_PROJECTION = new KotlinTarget("star projection", false);
        PROPERTY_PARAMETER = new KotlinTarget("property constructor parameter", false);
        CLASS_ONLY = new KotlinTarget("class", false);
        OBJECT = new KotlinTarget("object", false);
        STANDALONE_OBJECT = new KotlinTarget("standalone object", false);
        COMPANION_OBJECT = new KotlinTarget("companion object", false);
        INTERFACE = new KotlinTarget("interface", false);
        ENUM_CLASS = new KotlinTarget("enum class", false);
        ENUM_ENTRY = new KotlinTarget("enum entry", false);
        LOCAL_CLASS = new KotlinTarget("local class", false);
        LOCAL_FUNCTION = new KotlinTarget("local function", false);
        MEMBER_FUNCTION = new KotlinTarget("member function", false);
        TOP_LEVEL_FUNCTION = new KotlinTarget("top level function", false);
        MEMBER_PROPERTY = new KotlinTarget("member property", false);
        MEMBER_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("member property with backing field", false);
        MEMBER_PROPERTY_WITH_DELEGATE = new KotlinTarget("member property with delegate", false);
        MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("member property without backing field or delegate", false);
        TOP_LEVEL_PROPERTY = new KotlinTarget("top level property", false);
        TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("top level property with backing field", false);
        TOP_LEVEL_PROPERTY_WITH_DELEGATE = new KotlinTarget("top level property with delegate", false);
        TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("top level property without backing field or delegate", false);
        BACKING_FIELD = new KotlinTarget("BACKING_FIELD", 37, "backing field", false, 2, null);
        INITIALIZER = new KotlinTarget("initializer", false);
        DESTRUCTURING_DECLARATION = new KotlinTarget("destructuring declaration", false);
        LAMBDA_EXPRESSION = new KotlinTarget("lambda expression", false);
        ANONYMOUS_FUNCTION = new KotlinTarget("anonymous function", false);
        OBJECT_LITERAL = new KotlinTarget("object literal", false);
        $VALUES = kotlinTargetArray = new KotlinTarget[]{KotlinTarget.CLASS, KotlinTarget.ANNOTATION_CLASS, KotlinTarget.TYPE_PARAMETER, KotlinTarget.PROPERTY, KotlinTarget.FIELD, KotlinTarget.LOCAL_VARIABLE, KotlinTarget.VALUE_PARAMETER, KotlinTarget.CONSTRUCTOR, KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER, KotlinTarget.TYPE, KotlinTarget.EXPRESSION, KotlinTarget.FILE, KotlinTarget.TYPEALIAS, KotlinTarget.TYPE_PROJECTION, KotlinTarget.STAR_PROJECTION, KotlinTarget.PROPERTY_PARAMETER, KotlinTarget.CLASS_ONLY, KotlinTarget.OBJECT, KotlinTarget.STANDALONE_OBJECT, KotlinTarget.COMPANION_OBJECT, KotlinTarget.INTERFACE, KotlinTarget.ENUM_CLASS, KotlinTarget.ENUM_ENTRY, KotlinTarget.LOCAL_CLASS, KotlinTarget.LOCAL_FUNCTION, KotlinTarget.MEMBER_FUNCTION, KotlinTarget.TOP_LEVEL_FUNCTION, KotlinTarget.MEMBER_PROPERTY, KotlinTarget.MEMBER_PROPERTY_WITH_BACKING_FIELD, KotlinTarget.MEMBER_PROPERTY_WITH_DELEGATE, KotlinTarget.MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, KotlinTarget.TOP_LEVEL_PROPERTY, KotlinTarget.TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD, KotlinTarget.TOP_LEVEL_PROPERTY_WITH_DELEGATE, KotlinTarget.TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, KotlinTarget.BACKING_FIELD, KotlinTarget.INITIALIZER, KotlinTarget.DESTRUCTURING_DECLARATION, KotlinTarget.LAMBDA_EXPRESSION, KotlinTarget.ANONYMOUS_FUNCTION, KotlinTarget.OBJECT_LITERAL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
        map = new HashMap();
        for (KotlinTarget target : KotlinTarget.getEntries()) {
            ((Map)map).put(target.name(), target);
        }
        Iterable $this$filter$iv = KotlinTarget.getEntries();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            KotlinTarget it = (KotlinTarget)((Object)element$iv$iv);
            boolean bl2 = false;
            if (!it.isDefault) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        DEFAULT_TARGET_SET = CollectionsKt.toSet((List)var3_4);
        ALL_TARGET_SET = CollectionsKt.toSet((Iterable)KotlinTarget.getEntries());
        Object[] objectArray = new KotlinTarget[]{ANNOTATION_CLASS, CLASS};
        ANNOTATION_CLASS_LIST = CollectionsKt.listOf(objectArray);
        objectArray = new KotlinTarget[]{LOCAL_CLASS, CLASS};
        LOCAL_CLASS_LIST = CollectionsKt.listOf(objectArray);
        objectArray = new KotlinTarget[]{CLASS_ONLY, CLASS};
        CLASS_LIST = CollectionsKt.listOf(objectArray);
        objectArray = new KotlinTarget[]{COMPANION_OBJECT, OBJECT, CLASS};
        COMPANION_OBJECT_LIST = CollectionsKt.listOf(objectArray);
        objectArray = new KotlinTarget[]{STANDALONE_OBJECT, OBJECT, CLASS};
        OBJECT_LIST = CollectionsKt.listOf(objectArray);
        objectArray = new KotlinTarget[]{INTERFACE, CLASS};
        INTERFACE_LIST = CollectionsKt.listOf(objectArray);
        objectArray = new KotlinTarget[]{ENUM_CLASS, CLASS};
        ENUM_LIST = CollectionsKt.listOf(objectArray);
        objectArray = new KotlinTarget[]{ENUM_ENTRY, PROPERTY, FIELD};
        ENUM_ENTRY_LIST = CollectionsKt.listOf(objectArray);
        PROPERTY_SETTER_LIST = CollectionsKt.listOf(PROPERTY_SETTER);
        PROPERTY_GETTER_LIST = CollectionsKt.listOf(PROPERTY_GETTER);
        FUNCTION_LIST = CollectionsKt.listOf(FUNCTION);
        FILE_LIST = CollectionsKt.listOf(FILE);
        objectArray = new Pair[]{TuplesKt.to(AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.FIELD, FIELD), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, PROPERTY), TuplesKt.to(AnnotationUseSiteTarget.FILE, FILE), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, FIELD)};
        USE_SITE_MAPPING = MapsKt.mapOf(objectArray);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

