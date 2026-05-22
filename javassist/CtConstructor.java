/*
 * Decompiled with CFR 0.152.
 */
package javassist;

import javassist.CannotCompileException;
import javassist.ClassMap;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public final class CtConstructor
extends CtBehavior {
    protected CtConstructor(MethodInfo minfo, CtClass declaring) {
        super(declaring, minfo);
    }

    public CtConstructor(CtClass[] parameters, CtClass declaring) {
        this((MethodInfo)null, declaring);
        ConstPool cp2 = declaring.getClassFile2().getConstPool();
        String desc = Descriptor.ofConstructor(parameters);
        this.methodInfo = new MethodInfo(cp2, "<init>", desc);
        this.setModifiers(1);
    }

    public CtConstructor(CtConstructor src, CtClass declaring, ClassMap map) throws CannotCompileException {
        this((MethodInfo)null, declaring);
        this.copy(src, true, map);
    }

    public boolean isConstructor() {
        return this.methodInfo.isConstructor();
    }

    public boolean isClassInitializer() {
        return this.methodInfo.isStaticInitializer();
    }

    @Override
    public String getLongName() {
        return this.getDeclaringClass().getName() + (this.isConstructor() ? Descriptor.toString(this.getSignature()) : ".<clinit>()");
    }

    @Override
    public String getName() {
        if (this.methodInfo.isStaticInitializer()) {
            return "<clinit>";
        }
        return this.declaringClass.getSimpleName();
    }

    @Override
    public boolean isEmpty() {
        CodeAttribute ca2 = this.getMethodInfo2().getCodeAttribute();
        if (ca2 == null) {
            return false;
        }
        ConstPool cp2 = ca2.getConstPool();
        CodeIterator it = ca2.iterator();
        try {
            int desc;
            int pos;
            int op0 = it.byteAt(it.next());
            return op0 == 177 || op0 == 42 && it.byteAt(pos = it.next()) == 183 && (desc = cp2.isConstructor(this.getSuperclassName(), it.u16bitAt(pos + 1))) != 0 && "()V".equals(cp2.getUtf8Info(desc)) && it.byteAt(it.next()) == 177 && !it.hasNext();
        }
        catch (BadBytecode badBytecode) {
            return false;
        }
    }

    private String getSuperclassName() {
        ClassFile cf2 = this.declaringClass.getClassFile2();
        return cf2.getSuperclass();
    }

    public boolean callsSuper() throws CannotCompileException {
        CodeAttribute codeAttr = this.methodInfo.getCodeAttribute();
        if (codeAttr != null) {
            CodeIterator it = codeAttr.iterator();
            try {
                int index = it.skipSuperConstructor();
                return index >= 0;
            }
            catch (BadBytecode e2) {
                throw new CannotCompileException(e2);
            }
        }
        return false;
    }

    @Override
    public void setBody(String src) throws CannotCompileException {
        if (src == null) {
            src = this.isClassInitializer() ? ";" : "super();";
        }
        super.setBody(src);
    }

    public void setBody(CtConstructor src, ClassMap map) throws CannotCompileException {
        CtConstructor.setBody0(src.declaringClass, src.methodInfo, this.declaringClass, this.methodInfo, map);
    }

    public void insertBeforeBody(String src) throws CannotCompileException {
        CtClass cc2 = this.declaringClass;
        cc2.checkModify();
        if (this.isClassInitializer()) {
            throw new CannotCompileException("class initializer");
        }
        CodeAttribute ca2 = this.methodInfo.getCodeAttribute();
        CodeIterator iterator2 = ca2.iterator();
        Bytecode b2 = new Bytecode(this.methodInfo.getConstPool(), ca2.getMaxStack(), ca2.getMaxLocals());
        b2.setStackDepth(ca2.getMaxStack());
        Javac jv = new Javac(b2, cc2);
        try {
            jv.recordParams(this.getParameterTypes(), false);
            jv.compileStmnt(src);
            ca2.setMaxStack(b2.getMaxStack());
            ca2.setMaxLocals(b2.getMaxLocals());
            iterator2.skipConstructor();
            int pos = iterator2.insertEx(b2.get());
            iterator2.insert(b2.getExceptionTable(), pos);
            this.methodInfo.rebuildStackMapIf6(cc2.getClassPool(), cc2.getClassFile2());
        }
        catch (NotFoundException e2) {
            throw new CannotCompileException(e2);
        }
        catch (CompileError e3) {
            throw new CannotCompileException(e3);
        }
        catch (BadBytecode e4) {
            throw new CannotCompileException(e4);
        }
    }

    @Override
    int getStartPosOfBody(CodeAttribute ca2) throws CannotCompileException {
        CodeIterator ci2 = ca2.iterator();
        try {
            ci2.skipConstructor();
            return ci2.next();
        }
        catch (BadBytecode e2) {
            throw new CannotCompileException(e2);
        }
    }

    public CtMethod toMethod(String name, CtClass declaring) throws CannotCompileException {
        return this.toMethod(name, declaring, null);
    }

    public CtMethod toMethod(String name, CtClass declaring, ClassMap map) throws CannotCompileException {
        MethodInfo minfo;
        CodeAttribute ca2;
        CtMethod method = new CtMethod(null, declaring);
        method.copy(this, false, map);
        if (this.isConstructor() && (ca2 = (minfo = method.getMethodInfo2()).getCodeAttribute()) != null) {
            CtConstructor.removeConsCall(ca2);
            try {
                this.methodInfo.rebuildStackMapIf6(declaring.getClassPool(), declaring.getClassFile2());
            }
            catch (BadBytecode e2) {
                throw new CannotCompileException(e2);
            }
        }
        method.setName(name);
        return method;
    }

    private static void removeConsCall(CodeAttribute ca2) throws CannotCompileException {
        CodeIterator iterator2 = ca2.iterator();
        try {
            int pos = iterator2.skipConstructor();
            if (pos >= 0) {
                int mref = iterator2.u16bitAt(pos + 1);
                String desc = ca2.getConstPool().getMethodrefType(mref);
                int num = Descriptor.numOfParameters(desc) + 1;
                if (num > 3) {
                    pos = iterator2.insertGapAt((int)pos, (int)(num - 3), (boolean)false).position;
                }
                iterator2.writeByte(87, pos++);
                iterator2.writeByte(0, pos);
                iterator2.writeByte(0, pos + 1);
                Descriptor.Iterator it = new Descriptor.Iterator(desc);
                while (true) {
                    it.next();
                    if (it.isParameter()) {
                        iterator2.writeByte(it.is2byte() ? 88 : 87, pos++);
                        continue;
                    }
                    break;
                }
            }
        }
        catch (BadBytecode e2) {
            throw new CannotCompileException(e2);
        }
    }
}

