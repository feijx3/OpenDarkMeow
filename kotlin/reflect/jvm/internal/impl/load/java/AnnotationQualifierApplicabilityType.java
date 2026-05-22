/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

public final class AnnotationQualifierApplicabilityType
extends Enum<AnnotationQualifierApplicabilityType> {
    @NotNull
    private final String javaTarget;
    public static final /* enum */ AnnotationQualifierApplicabilityType METHOD_RETURN_TYPE = new AnnotationQualifierApplicabilityType("METHOD");
    public static final /* enum */ AnnotationQualifierApplicabilityType VALUE_PARAMETER = new AnnotationQualifierApplicabilityType("PARAMETER");
    public static final /* enum */ AnnotationQualifierApplicabilityType FIELD = new AnnotationQualifierApplicabilityType("FIELD");
    public static final /* enum */ AnnotationQualifierApplicabilityType TYPE_USE = new AnnotationQualifierApplicabilityType("TYPE_USE");
    public static final /* enum */ AnnotationQualifierApplicabilityType TYPE_PARAMETER_BOUNDS = new AnnotationQualifierApplicabilityType("TYPE_USE");
    public static final /* enum */ AnnotationQualifierApplicabilityType TYPE_PARAMETER = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER");
    private static final /* synthetic */ AnnotationQualifierApplicabilityType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private AnnotationQualifierApplicabilityType(String javaTarget) {
        this.javaTarget = javaTarget;
    }

    @NotNull
    public final String getJavaTarget() {
        return this.javaTarget;
    }

    public static AnnotationQualifierApplicabilityType[] values() {
        return (AnnotationQualifierApplicabilityType[])$VALUES.clone();
    }

    public static AnnotationQualifierApplicabilityType valueOf(String value) {
        return Enum.valueOf(AnnotationQualifierApplicabilityType.class, value);
    }

    static {
        $VALUES = annotationQualifierApplicabilityTypeArray = new AnnotationQualifierApplicabilityType[]{AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.TYPE_USE, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_PARAMETER};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

