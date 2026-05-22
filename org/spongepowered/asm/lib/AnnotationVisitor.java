/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

public abstract class AnnotationVisitor {
    protected final int api;
    protected AnnotationVisitor av;

    public AnnotationVisitor(int api2) {
        this(api2, null);
    }

    public AnnotationVisitor(int api2, AnnotationVisitor av2) {
        if (api2 != 262144 && api2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.api = api2;
        this.av = av2;
    }

    public void visit(String name, Object value) {
        if (this.av != null) {
            this.av.visit(name, value);
        }
    }

    public void visitEnum(String name, String desc, String value) {
        if (this.av != null) {
            this.av.visitEnum(name, desc, value);
        }
    }

    public AnnotationVisitor visitAnnotation(String name, String desc) {
        if (this.av != null) {
            return this.av.visitAnnotation(name, desc);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String name) {
        if (this.av != null) {
            return this.av.visitArray(name);
        }
        return null;
    }

    public void visitEnd() {
        if (this.av != null) {
            this.av.visitEnd();
        }
    }
}

