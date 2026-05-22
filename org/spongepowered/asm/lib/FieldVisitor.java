/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.TypePath;

public abstract class FieldVisitor {
    protected final int api;
    protected FieldVisitor fv;

    public FieldVisitor(int api2) {
        this(api2, null);
    }

    public FieldVisitor(int api2, FieldVisitor fv2) {
        if (api2 != 262144 && api2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.api = api2;
        this.fv = fv2;
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (this.fv != null) {
            return this.fv.visitAnnotation(desc, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api < 327680) {
            throw new RuntimeException();
        }
        if (this.fv != null) {
            return this.fv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attr) {
        if (this.fv != null) {
            this.fv.visitAttribute(attr);
        }
    }

    public void visitEnd() {
        if (this.fv != null) {
            this.fv.visitEnd();
        }
    }
}

