/*
 * Decompiled with CFR 0.152.
 */
package javassist.convert;

import javassist.CtMethod;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.convert.TransformCall;
import javassist.convert.Transformer;

public class TransformCallToStatic
extends TransformCall {
    public TransformCallToStatic(Transformer next, CtMethod origMethod, CtMethod substMethod) {
        super(next, origMethod, substMethod);
        this.methodDescriptor = origMethod.getMethodInfo2().getDescriptor();
    }

    @Override
    protected int match(int c2, int pos, CodeIterator iterator2, int typedesc, ConstPool cp2) {
        if (this.newIndex == 0) {
            String desc = Descriptor.insertParameter(this.classname, this.methodDescriptor);
            int nt = cp2.addNameAndTypeInfo(this.newMethodname, desc);
            int ci2 = cp2.addClassInfo(this.newClassname);
            this.newIndex = cp2.addMethodrefInfo(ci2, nt);
            this.constPool = cp2;
        }
        iterator2.writeByte(184, pos);
        iterator2.write16bit(this.newIndex, pos + 1);
        return pos;
    }
}

