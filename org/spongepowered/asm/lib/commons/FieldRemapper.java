/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.commons.AnnotationRemapper;
import org.spongepowered.asm.lib.commons.Remapper;

public class FieldRemapper
extends FieldVisitor {
    private final Remapper remapper;

    public FieldRemapper(FieldVisitor fv2, Remapper remapper) {
        this(327680, fv2, remapper);
    }

    protected FieldRemapper(int api2, FieldVisitor fv2, Remapper remapper) {
        super(api2, fv2);
        this.remapper = remapper;
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationVisitor av2 = this.fv.visitAnnotation(this.remapper.mapDesc(desc), visible);
        return av2 == null ? null : new AnnotationRemapper(av2, this.remapper);
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AnnotationVisitor av2 = super.visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(desc), visible);
        return av2 == null ? null : new AnnotationRemapper(av2, this.remapper);
    }
}

