/*
 * Decompiled with CFR 0.152.
 */
package javassist.convert;

import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeIterator;
import javassist.convert.TransformBefore;
import javassist.convert.Transformer;

public class TransformAfter
extends TransformBefore {
    public TransformAfter(Transformer next, CtMethod origMethod, CtMethod afterMethod) throws NotFoundException {
        super(next, origMethod, afterMethod);
    }

    @Override
    protected int match2(int pos, CodeIterator iterator2) throws BadBytecode {
        iterator2.move(pos);
        iterator2.insert(this.saveCode);
        iterator2.insert(this.loadCode);
        int p2 = iterator2.insertGap(3);
        iterator2.setMark(p2);
        iterator2.insert(this.loadCode);
        pos = iterator2.next();
        p2 = iterator2.getMark();
        iterator2.writeByte(iterator2.byteAt(pos), p2);
        iterator2.write16bit(iterator2.u16bitAt(pos + 1), p2 + 1);
        iterator2.writeByte(184, pos);
        iterator2.write16bit(this.newIndex, pos + 1);
        iterator2.move(p2);
        return iterator2.next();
    }
}

