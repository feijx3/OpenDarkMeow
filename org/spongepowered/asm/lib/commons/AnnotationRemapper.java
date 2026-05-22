/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.commons.Remapper;

public class AnnotationRemapper
extends AnnotationVisitor {
    protected final Remapper remapper;

    public AnnotationRemapper(AnnotationVisitor av2, Remapper remapper) {
        this(327680, av2, remapper);
    }

    protected AnnotationRemapper(int api2, AnnotationVisitor av2, Remapper remapper) {
        super(api2, av2);
        this.remapper = remapper;
    }

    public void visit(String name, Object value) {
        this.av.visit(name, this.remapper.mapValue(value));
    }

    public void visitEnum(String name, String desc, String value) {
        this.av.visitEnum(name, this.remapper.mapDesc(desc), value);
    }

    public AnnotationVisitor visitAnnotation(String name, String desc) {
        AnnotationVisitor v2 = this.av.visitAnnotation(name, this.remapper.mapDesc(desc));
        return v2 == null ? null : (v2 == this.av ? this : new AnnotationRemapper(v2, this.remapper));
    }

    public AnnotationVisitor visitArray(String name) {
        AnnotationVisitor v2 = this.av.visitArray(name);
        return v2 == null ? null : (v2 == this.av ? this : new AnnotationRemapper(v2, this.remapper));
    }
}

