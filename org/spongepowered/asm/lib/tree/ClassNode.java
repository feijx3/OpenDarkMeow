/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.InnerClassNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

public class ClassNode
extends ClassVisitor {
    public int version;
    public int access;
    public String name;
    public String signature;
    public String superName;
    public List<String> interfaces = new ArrayList<String>();
    public String sourceFile;
    public String sourceDebug;
    public String outerClass;
    public String outerMethod;
    public String outerMethodDesc;
    public List<AnnotationNode> visibleAnnotations;
    public List<AnnotationNode> invisibleAnnotations;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public List<Attribute> attrs;
    public List<InnerClassNode> innerClasses = new ArrayList<InnerClassNode>();
    public List<FieldNode> fields = new ArrayList<FieldNode>();
    public List<MethodNode> methods = new ArrayList<MethodNode>();

    public ClassNode() {
        this(327680);
        if (this.getClass() != ClassNode.class) {
            throw new IllegalStateException();
        }
    }

    public ClassNode(int api2) {
        super(api2);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.version = version;
        this.access = access;
        this.name = name;
        this.signature = signature;
        this.superName = superName;
        if (interfaces != null) {
            this.interfaces.addAll(Arrays.asList(interfaces));
        }
    }

    public void visitSource(String file, String debug) {
        this.sourceFile = file;
        this.sourceDebug = debug;
    }

    public void visitOuterClass(String owner, String name, String desc) {
        this.outerClass = owner;
        this.outerMethod = name;
        this.outerMethodDesc = desc;
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationNode an2 = new AnnotationNode(desc);
        if (visible) {
            if (this.visibleAnnotations == null) {
                this.visibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            this.visibleAnnotations.add(an2);
        } else {
            if (this.invisibleAnnotations == null) {
                this.invisibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            this.invisibleAnnotations.add(an2);
        }
        return an2;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        TypeAnnotationNode an2 = new TypeAnnotationNode(typeRef, typePath, desc);
        if (visible) {
            if (this.visibleTypeAnnotations == null) {
                this.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            this.visibleTypeAnnotations.add(an2);
        } else {
            if (this.invisibleTypeAnnotations == null) {
                this.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            this.invisibleTypeAnnotations.add(an2);
        }
        return an2;
    }

    public void visitAttribute(Attribute attr) {
        if (this.attrs == null) {
            this.attrs = new ArrayList<Attribute>(1);
        }
        this.attrs.add(attr);
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        InnerClassNode icn = new InnerClassNode(name, outerName, innerName, access);
        this.innerClasses.add(icn);
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        FieldNode fn2 = new FieldNode(access, name, desc, signature, value);
        this.fields.add(fn2);
        return fn2;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodNode mn = new MethodNode(access, name, desc, signature, exceptions);
        this.methods.add(mn);
        return mn;
    }

    public void visitEnd() {
    }

    public void check(int api2) {
        if (api2 == 262144) {
            if (this.visibleTypeAnnotations != null && this.visibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (this.invisibleTypeAnnotations != null && this.invisibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            for (FieldNode f2 : this.fields) {
                f2.check(api2);
            }
            for (MethodNode m2 : this.methods) {
                m2.check(api2);
            }
        }
    }

    public void accept(ClassVisitor cv2) {
        AnnotationNode an2;
        int i2;
        String[] interfaces = new String[this.interfaces.size()];
        this.interfaces.toArray(interfaces);
        cv2.visit(this.version, this.access, this.name, this.signature, this.superName, interfaces);
        if (this.sourceFile != null || this.sourceDebug != null) {
            cv2.visitSource(this.sourceFile, this.sourceDebug);
        }
        if (this.outerClass != null) {
            cv2.visitOuterClass(this.outerClass, this.outerMethod, this.outerMethodDesc);
        }
        int n2 = this.visibleAnnotations == null ? 0 : this.visibleAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.visibleAnnotations.get(i2);
            an2.accept(cv2.visitAnnotation(an2.desc, true));
        }
        n2 = this.invisibleAnnotations == null ? 0 : this.invisibleAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.invisibleAnnotations.get(i2);
            an2.accept(cv2.visitAnnotation(an2.desc, false));
        }
        n2 = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.visibleTypeAnnotations.get(i2);
            an2.accept(cv2.visitTypeAnnotation(((TypeAnnotationNode)an2).typeRef, ((TypeAnnotationNode)an2).typePath, ((TypeAnnotationNode)an2).desc, true));
        }
        n2 = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();
        for (i2 = 0; i2 < n2; ++i2) {
            an2 = this.invisibleTypeAnnotations.get(i2);
            an2.accept(cv2.visitTypeAnnotation(((TypeAnnotationNode)an2).typeRef, ((TypeAnnotationNode)an2).typePath, ((TypeAnnotationNode)an2).desc, false));
        }
        n2 = this.attrs == null ? 0 : this.attrs.size();
        for (i2 = 0; i2 < n2; ++i2) {
            cv2.visitAttribute(this.attrs.get(i2));
        }
        for (i2 = 0; i2 < this.innerClasses.size(); ++i2) {
            this.innerClasses.get(i2).accept(cv2);
        }
        for (i2 = 0; i2 < this.fields.size(); ++i2) {
            this.fields.get(i2).accept(cv2);
        }
        for (i2 = 0; i2 < this.methods.size(); ++i2) {
            this.methods.get(i2).accept(cv2);
        }
        cv2.visitEnd();
    }
}

