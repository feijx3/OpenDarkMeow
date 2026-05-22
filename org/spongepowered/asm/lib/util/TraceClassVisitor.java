/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import java.io.PrintWriter;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.util.Printer;
import org.spongepowered.asm.lib.util.Textifier;
import org.spongepowered.asm.lib.util.TraceAnnotationVisitor;
import org.spongepowered.asm.lib.util.TraceFieldVisitor;
import org.spongepowered.asm.lib.util.TraceMethodVisitor;

public final class TraceClassVisitor
extends ClassVisitor {
    private final PrintWriter pw;
    public final Printer p;

    public TraceClassVisitor(PrintWriter pw) {
        this(null, pw);
    }

    public TraceClassVisitor(ClassVisitor cv2, PrintWriter pw) {
        this(cv2, new Textifier(), pw);
    }

    public TraceClassVisitor(ClassVisitor cv2, Printer p2, PrintWriter pw) {
        super(327680, cv2);
        this.pw = pw;
        this.p = p2;
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.p.visit(version, access, name, signature, superName, interfaces);
        super.visit(version, access, name, signature, superName, interfaces);
    }

    public void visitSource(String file, String debug) {
        this.p.visitSource(file, debug);
        super.visitSource(file, debug);
    }

    public void visitOuterClass(String owner, String name, String desc) {
        this.p.visitOuterClass(owner, name, desc);
        super.visitOuterClass(owner, name, desc);
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        Printer p2 = this.p.visitClassAnnotation(desc, visible);
        AnnotationVisitor av2 = this.cv == null ? null : this.cv.visitAnnotation(desc, visible);
        return new TraceAnnotationVisitor(av2, p2);
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        Printer p2 = this.p.visitClassTypeAnnotation(typeRef, typePath, desc, visible);
        AnnotationVisitor av2 = this.cv == null ? null : this.cv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        return new TraceAnnotationVisitor(av2, p2);
    }

    public void visitAttribute(Attribute attr) {
        this.p.visitClassAttribute(attr);
        super.visitAttribute(attr);
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        this.p.visitInnerClass(name, outerName, innerName, access);
        super.visitInnerClass(name, outerName, innerName, access);
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        Printer p2 = this.p.visitField(access, name, desc, signature, value);
        FieldVisitor fv2 = this.cv == null ? null : this.cv.visitField(access, name, desc, signature, value);
        return new TraceFieldVisitor(fv2, p2);
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        Printer p2 = this.p.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor mv = this.cv == null ? null : this.cv.visitMethod(access, name, desc, signature, exceptions);
        return new TraceMethodVisitor(mv, p2);
    }

    public void visitEnd() {
        this.p.visitClassEnd();
        if (this.pw != null) {
            this.p.print(this.pw);
            this.pw.flush();
        }
        super.visitEnd();
    }
}

