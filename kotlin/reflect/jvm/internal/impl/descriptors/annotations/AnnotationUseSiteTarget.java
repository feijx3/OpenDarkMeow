/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import org.jetbrains.annotations.NotNull;

public final class AnnotationUseSiteTarget
extends Enum<AnnotationUseSiteTarget> {
    @NotNull
    private final String renderName;
    public static final /* enum */ AnnotationUseSiteTarget ALL = new AnnotationUseSiteTarget("ALL", 0, null, 1, null);
    public static final /* enum */ AnnotationUseSiteTarget FIELD = new AnnotationUseSiteTarget("FIELD", 1, null, 1, null);
    public static final /* enum */ AnnotationUseSiteTarget FILE = new AnnotationUseSiteTarget("FILE", 2, null, 1, null);
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 3, null, 1, null);
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY_GETTER = new AnnotationUseSiteTarget("get");
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY_SETTER = new AnnotationUseSiteTarget("set");
    public static final /* enum */ AnnotationUseSiteTarget RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 6, null, 1, null);
    public static final /* enum */ AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("param");
    public static final /* enum */ AnnotationUseSiteTarget SETTER_PARAMETER = new AnnotationUseSiteTarget("setparam");
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("delegate");
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private AnnotationUseSiteTarget(String renderName) {
        String string = renderName;
        if (string == null) {
            string = CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(this.name());
        }
        this.renderName = string;
    }

    /* synthetic */ AnnotationUseSiteTarget(String string, int n2, String string2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            string2 = null;
        }
        this(string2);
    }

    @NotNull
    public final String getRenderName() {
        return this.renderName;
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[])$VALUES.clone();
    }

    public static AnnotationUseSiteTarget valueOf(String value) {
        return Enum.valueOf(AnnotationUseSiteTarget.class, value);
    }

    static {
        $VALUES = annotationUseSiteTargetArray = new AnnotationUseSiteTarget[]{AnnotationUseSiteTarget.ALL, AnnotationUseSiteTarget.FIELD, AnnotationUseSiteTarget.FILE, AnnotationUseSiteTarget.PROPERTY, AnnotationUseSiteTarget.PROPERTY_GETTER, AnnotationUseSiteTarget.PROPERTY_SETTER, AnnotationUseSiteTarget.RECEIVER, AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER, AnnotationUseSiteTarget.SETTER_PARAMETER, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

