/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.util.Printer;
import org.spongepowered.asm.lib.util.TraceAnnotationVisitor;

public final class TraceFieldVisitor
extends FieldVisitor {
    public final Printer p;

    public TraceFieldVisitor(Printer p2) {
        this(null, p2);
    }

    public TraceFieldVisitor(FieldVisitor fv2, Printer p2) {
        super(327680, fv2);
        this.p = p2;
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        Printer p2 = this.p.visitFieldAnnotation(desc, visible);
        AnnotationVisitor av2 = this.fv == null ? null : this.fv.visitAnnotation(desc, visible);
        return new TraceAnnotationVisitor(av2, p2);
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        Printer p2 = this.p.visitFieldTypeAnnotation(typeRef, typePath, desc, visible);
        AnnotationVisitor av2 = this.fv == null ? null : this.fv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        return new TraceAnnotationVisitor(av2, p2);
    }

    public void visitAttribute(Attribute attr) {
        this.p.visitFieldAttribute(attr);
        super.visitAttribute(attr);
    }

    public void visitEnd() {
        this.p.visitFieldEnd();
        super.visitEnd();
    }
}

