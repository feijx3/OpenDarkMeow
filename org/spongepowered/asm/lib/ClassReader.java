/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import java.io.IOException;
import java.io.InputStream;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Context;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Item;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.MethodWriter;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;

public class ClassReader {
    static final boolean SIGNATURES = true;
    static final boolean ANNOTATIONS = true;
    static final boolean FRAMES = true;
    static final boolean WRITER = true;
    static final boolean RESIZE = true;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    public static final int EXPAND_FRAMES = 8;
    static final int EXPAND_ASM_INSNS = 256;
    public final byte[] b;
    private final int[] items;
    private final String[] strings;
    private final int maxStringLength;
    public final int header;

    public ClassReader(byte[] b2) {
        this(b2, 0, b2.length);
    }

    public ClassReader(byte[] b2, int off, int len) {
        this.b = b2;
        if (this.readShort(off + 6) > 52) {
            throw new IllegalArgumentException();
        }
        this.items = new int[this.readUnsignedShort(off + 8)];
        int n2 = this.items.length;
        this.strings = new String[n2];
        int max = 0;
        int index = off + 10;
        for (int i2 = 1; i2 < n2; ++i2) {
            int size;
            this.items[i2] = index + 1;
            switch (b2[index]) {
                case 3: 
                case 4: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 18: {
                    size = 5;
                    break;
                }
                case 5: 
                case 6: {
                    size = 9;
                    ++i2;
                    break;
                }
                case 1: {
                    size = 3 + this.readUnsignedShort(index + 1);
                    if (size <= max) break;
                    max = size;
                    break;
                }
                case 15: {
                    size = 4;
                    break;
                }
                default: {
                    size = 3;
                }
            }
            index += size;
        }
        this.maxStringLength = max;
        this.header = index;
    }

    public int getAccess() {
        return this.readUnsignedShort(this.header);
    }

    public String getClassName() {
        return this.readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public String getSuperName() {
        return this.readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public String[] getInterfaces() {
        int index = this.header + 6;
        int n2 = this.readUnsignedShort(index);
        String[] interfaces = new String[n2];
        if (n2 > 0) {
            char[] buf = new char[this.maxStringLength];
            for (int i2 = 0; i2 < n2; ++i2) {
                interfaces[i2] = this.readClass(index += 2, buf);
            }
        }
        return interfaces;
    }

    void copyPool(ClassWriter classWriter) {
        char[] buf = new char[this.maxStringLength];
        int ll = this.items.length;
        Item[] items2 = new Item[ll];
        for (int i2 = 1; i2 < ll; ++i2) {
            int index = this.items[i2];
            byte tag = this.b[index - 1];
            Item item = new Item(i2);
            switch (tag) {
                case 9: 
                case 10: 
                case 11: {
                    int nameType = this.items[this.readUnsignedShort(index + 2)];
                    item.set(tag, this.readClass(index, buf), this.readUTF8(nameType, buf), this.readUTF8(nameType + 2, buf));
                    break;
                }
                case 3: {
                    item.set(this.readInt(index));
                    break;
                }
                case 4: {
                    item.set(Float.intBitsToFloat(this.readInt(index)));
                    break;
                }
                case 12: {
                    item.set(tag, this.readUTF8(index, buf), this.readUTF8(index + 2, buf), null);
                    break;
                }
                case 5: {
                    item.set(this.readLong(index));
                    ++i2;
                    break;
                }
                case 6: {
                    item.set(Double.longBitsToDouble(this.readLong(index)));
                    ++i2;
                    break;
                }
                case 1: {
                    String s2 = this.strings[i2];
                    if (s2 == null) {
                        index = this.items[i2];
                        s2 = this.strings[i2] = this.readUTF(index + 2, this.readUnsignedShort(index), buf);
                    }
                    item.set(tag, s2, null, null);
                    break;
                }
                case 15: {
                    int fieldOrMethodRef = this.items[this.readUnsignedShort(index + 1)];
                    int nameType = this.items[this.readUnsignedShort(fieldOrMethodRef + 2)];
                    item.set(20 + this.readByte(index), this.readClass(fieldOrMethodRef, buf), this.readUTF8(nameType, buf), this.readUTF8(nameType + 2, buf));
                    break;
                }
                case 18: {
                    if (classWriter.bootstrapMethods == null) {
                        this.copyBootstrapMethods(classWriter, items2, buf);
                    }
                    int nameType = this.items[this.readUnsignedShort(index + 2)];
                    item.set(this.readUTF8(nameType, buf), this.readUTF8(nameType + 2, buf), this.readUnsignedShort(index));
                    break;
                }
                default: {
                    item.set(tag, this.readUTF8(index, buf), null, null);
                }
            }
            int index2 = item.hashCode % items2.length;
            item.next = items2[index2];
            items2[index2] = item;
        }
        int off = this.items[1] - 1;
        classWriter.pool.putByteArray(this.b, off, this.header - off);
        classWriter.items = items2;
        classWriter.threshold = (int)(0.75 * (double)ll);
        classWriter.index = ll;
    }

    private void copyBootstrapMethods(ClassWriter classWriter, Item[] items, char[] c2) {
        int u2 = this.getAttributes();
        boolean found = false;
        for (int i2 = this.readUnsignedShort(u2); i2 > 0; --i2) {
            String attrName = this.readUTF8(u2 + 2, c2);
            if ("BootstrapMethods".equals(attrName)) {
                found = true;
                break;
            }
            u2 += 6 + this.readInt(u2 + 4);
        }
        if (!found) {
            return;
        }
        int boostrapMethodCount = this.readUnsignedShort(u2 + 8);
        int v2 = u2 + 10;
        for (int j2 = 0; j2 < boostrapMethodCount; ++j2) {
            int position = v2 - u2 - 10;
            int hashCode = this.readConst(this.readUnsignedShort(v2), c2).hashCode();
            for (int k2 = this.readUnsignedShort(v2 + 2); k2 > 0; --k2) {
                hashCode ^= this.readConst(this.readUnsignedShort(v2 + 4), c2).hashCode();
                v2 += 2;
            }
            v2 += 4;
            Item item = new Item(j2);
            item.set(position, hashCode & Integer.MAX_VALUE);
            int index = item.hashCode % items.length;
            item.next = items[index];
            items[index] = item;
        }
        int attrSize = this.readInt(u2 + 4);
        ByteVector bootstrapMethods = new ByteVector(attrSize + 62);
        bootstrapMethods.putByteArray(this.b, u2 + 10, attrSize - 2);
        classWriter.bootstrapMethodsCount = boostrapMethodCount;
        classWriter.bootstrapMethods = bootstrapMethods;
    }

    public ClassReader(InputStream is) throws IOException {
        this(ClassReader.readClass(is, false));
    }

    public ClassReader(String name) throws IOException {
        this(ClassReader.readClass(ClassLoader.getSystemResourceAsStream(name.replace('.', '/') + ".class"), true));
    }

    private static byte[] readClass(InputStream is, boolean close) throws IOException {
        if (is == null) {
            throw new IOException("Class not found");
        }
        try {
            byte[] b2 = new byte[is.available()];
            int len = 0;
            while (true) {
                int n2;
                if ((n2 = is.read(b2, len, b2.length - len)) == -1) {
                    byte[] c2;
                    if (len < b2.length) {
                        c2 = new byte[len];
                        System.arraycopy(b2, 0, c2, 0, len);
                        b2 = c2;
                    }
                    c2 = b2;
                    return c2;
                }
                if ((len += n2) != b2.length) continue;
                int last = is.read();
                if (last < 0) {
                    byte[] byArray = b2;
                    return byArray;
                }
                byte[] c3 = new byte[b2.length + 1000];
                System.arraycopy(b2, 0, c3, 0, len);
                c3[len++] = (byte)last;
                b2 = c3;
            }
        }
        finally {
            if (close) {
                is.close();
            }
        }
    }

    public void accept(ClassVisitor classVisitor, int flags) {
        this.accept(classVisitor, new Attribute[0], flags);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attrs, int flags) {
        int i2;
        int u2 = this.header;
        char[] c2 = new char[this.maxStringLength];
        Context context = new Context();
        context.attrs = attrs;
        context.flags = flags;
        context.buffer = c2;
        int access = this.readUnsignedShort(u2);
        String name = this.readClass(u2 + 2, c2);
        String superClass = this.readClass(u2 + 4, c2);
        String[] interfaces = new String[this.readUnsignedShort(u2 + 6)];
        u2 += 8;
        for (int i3 = 0; i3 < interfaces.length; ++i3) {
            interfaces[i3] = this.readClass(u2, c2);
            u2 += 2;
        }
        String signature = null;
        String sourceFile = null;
        String sourceDebug = null;
        String enclosingOwner = null;
        String enclosingName = null;
        String enclosingDesc = null;
        int anns = 0;
        int ianns = 0;
        int tanns = 0;
        int itanns = 0;
        int innerClasses = 0;
        Attribute attributes = null;
        u2 = this.getAttributes();
        for (i2 = this.readUnsignedShort(u2); i2 > 0; --i2) {
            String attrName = this.readUTF8(u2 + 2, c2);
            if ("SourceFile".equals(attrName)) {
                sourceFile = this.readUTF8(u2 + 8, c2);
            } else if ("InnerClasses".equals(attrName)) {
                innerClasses = u2 + 8;
            } else if ("EnclosingMethod".equals(attrName)) {
                enclosingOwner = this.readClass(u2 + 8, c2);
                int item = this.readUnsignedShort(u2 + 10);
                if (item != 0) {
                    enclosingName = this.readUTF8(this.items[item], c2);
                    enclosingDesc = this.readUTF8(this.items[item] + 2, c2);
                }
            } else if ("Signature".equals(attrName)) {
                signature = this.readUTF8(u2 + 8, c2);
            } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                anns = u2 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = u2 + 8;
            } else if ("Deprecated".equals(attrName)) {
                access |= 0x20000;
            } else if ("Synthetic".equals(attrName)) {
                access |= 0x41000;
            } else if ("SourceDebugExtension".equals(attrName)) {
                int len = this.readInt(u2 + 4);
                sourceDebug = this.readUTF(u2 + 8, len, new char[len]);
            } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                ianns = u2 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = u2 + 8;
            } else if ("BootstrapMethods".equals(attrName)) {
                int[] bootstrapMethods = new int[this.readUnsignedShort(u2 + 8)];
                int v2 = u2 + 10;
                for (int j2 = 0; j2 < bootstrapMethods.length; ++j2) {
                    bootstrapMethods[j2] = v2;
                    v2 += 2 + this.readUnsignedShort(v2 + 2) << 1;
                }
                context.bootstrapMethods = bootstrapMethods;
            } else {
                Attribute attr = this.readAttribute(attrs, attrName, u2 + 8, this.readInt(u2 + 4), c2, -1, null);
                if (attr != null) {
                    attr.next = attributes;
                    attributes = attr;
                }
            }
            u2 += 6 + this.readInt(u2 + 4);
        }
        classVisitor.visit(this.readInt(this.items[1] - 7), access, name, signature, superClass, interfaces);
        if ((flags & 2) == 0 && (sourceFile != null || sourceDebug != null)) {
            classVisitor.visitSource(sourceFile, sourceDebug);
        }
        if (enclosingOwner != null) {
            classVisitor.visitOuterClass(enclosingOwner, enclosingName, enclosingDesc);
        }
        if (anns != 0) {
            int v3 = anns + 2;
            for (i2 = this.readUnsignedShort(anns); i2 > 0; --i2) {
                v3 = this.readAnnotationValues(v3 + 2, c2, true, classVisitor.visitAnnotation(this.readUTF8(v3, c2), true));
            }
        }
        if (ianns != 0) {
            int v4 = ianns + 2;
            for (i2 = this.readUnsignedShort(ianns); i2 > 0; --i2) {
                v4 = this.readAnnotationValues(v4 + 2, c2, true, classVisitor.visitAnnotation(this.readUTF8(v4, c2), false));
            }
        }
        if (tanns != 0) {
            int v5 = tanns + 2;
            for (i2 = this.readUnsignedShort(tanns); i2 > 0; --i2) {
                v5 = this.readAnnotationTarget(context, v5);
                v5 = this.readAnnotationValues(v5 + 2, c2, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v5, c2), true));
            }
        }
        if (itanns != 0) {
            int v6 = itanns + 2;
            for (i2 = this.readUnsignedShort(itanns); i2 > 0; --i2) {
                v6 = this.readAnnotationTarget(context, v6);
                v6 = this.readAnnotationValues(v6 + 2, c2, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v6, c2), false));
            }
        }
        while (attributes != null) {
            Attribute attr = attributes.next;
            attributes.next = null;
            classVisitor.visitAttribute(attributes);
            attributes = attr;
        }
        if (innerClasses != 0) {
            int v7 = innerClasses + 2;
            for (int i4 = this.readUnsignedShort(innerClasses); i4 > 0; --i4) {
                classVisitor.visitInnerClass(this.readClass(v7, c2), this.readClass(v7 + 2, c2), this.readUTF8(v7 + 4, c2), this.readUnsignedShort(v7 + 6));
                v7 += 8;
            }
        }
        u2 = this.header + 10 + 2 * interfaces.length;
        for (i2 = this.readUnsignedShort(u2 - 2); i2 > 0; --i2) {
            u2 = this.readField(classVisitor, context, u2);
        }
        for (i2 = this.readUnsignedShort((u2 += 2) - 2); i2 > 0; --i2) {
            u2 = this.readMethod(classVisitor, context, u2);
        }
        classVisitor.visitEnd();
    }

    private int readField(ClassVisitor classVisitor, Context context, int u2) {
        int v2;
        char[] c2 = context.buffer;
        int access = this.readUnsignedShort(u2);
        String name = this.readUTF8(u2 + 2, c2);
        String desc = this.readUTF8(u2 + 4, c2);
        u2 += 6;
        String signature = null;
        int anns = 0;
        int ianns = 0;
        int tanns = 0;
        int itanns = 0;
        Object value = null;
        Attribute attributes = null;
        for (int i2 = this.readUnsignedShort(u2); i2 > 0; --i2) {
            String attrName = this.readUTF8(u2 + 2, c2);
            if ("ConstantValue".equals(attrName)) {
                int item = this.readUnsignedShort(u2 + 8);
                value = item == 0 ? null : this.readConst(item, c2);
            } else if ("Signature".equals(attrName)) {
                signature = this.readUTF8(u2 + 8, c2);
            } else if ("Deprecated".equals(attrName)) {
                access |= 0x20000;
            } else if ("Synthetic".equals(attrName)) {
                access |= 0x41000;
            } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                anns = u2 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = u2 + 8;
            } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                ianns = u2 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = u2 + 8;
            } else {
                Attribute attr = this.readAttribute(context.attrs, attrName, u2 + 8, this.readInt(u2 + 4), c2, -1, null);
                if (attr != null) {
                    attr.next = attributes;
                    attributes = attr;
                }
            }
            u2 += 6 + this.readInt(u2 + 4);
        }
        u2 += 2;
        FieldVisitor fv2 = classVisitor.visitField(access, name, desc, signature, value);
        if (fv2 == null) {
            return u2;
        }
        if (anns != 0) {
            v2 = anns + 2;
            for (int i3 = this.readUnsignedShort(anns); i3 > 0; --i3) {
                v2 = this.readAnnotationValues(v2 + 2, c2, true, fv2.visitAnnotation(this.readUTF8(v2, c2), true));
            }
        }
        if (ianns != 0) {
            v2 = ianns + 2;
            for (int i4 = this.readUnsignedShort(ianns); i4 > 0; --i4) {
                v2 = this.readAnnotationValues(v2 + 2, c2, true, fv2.visitAnnotation(this.readUTF8(v2, c2), false));
            }
        }
        if (tanns != 0) {
            v2 = tanns + 2;
            for (int i5 = this.readUnsignedShort(tanns); i5 > 0; --i5) {
                v2 = this.readAnnotationTarget(context, v2);
                v2 = this.readAnnotationValues(v2 + 2, c2, true, fv2.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v2, c2), true));
            }
        }
        if (itanns != 0) {
            v2 = itanns + 2;
            for (int i6 = this.readUnsignedShort(itanns); i6 > 0; --i6) {
                v2 = this.readAnnotationTarget(context, v2);
                v2 = this.readAnnotationValues(v2 + 2, c2, true, fv2.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v2, c2), false));
            }
        }
        while (attributes != null) {
            Attribute attr = attributes.next;
            attributes.next = null;
            fv2.visitAttribute(attributes);
            attributes = attr;
        }
        fv2.visitEnd();
        return u2;
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int u2) {
        int v2;
        char[] c2 = context.buffer;
        context.access = this.readUnsignedShort(u2);
        context.name = this.readUTF8(u2 + 2, c2);
        context.desc = this.readUTF8(u2 + 4, c2);
        u2 += 6;
        int code = 0;
        int exception = 0;
        String[] exceptions = null;
        String signature = null;
        int methodParameters = 0;
        int anns = 0;
        int ianns = 0;
        int tanns = 0;
        int itanns = 0;
        int dann = 0;
        int mpanns = 0;
        int impanns = 0;
        int firstAttribute = u2;
        Attribute attributes = null;
        for (int i2 = this.readUnsignedShort(u2); i2 > 0; --i2) {
            String attrName = this.readUTF8(u2 + 2, c2);
            if ("Code".equals(attrName)) {
                if ((context.flags & 1) == 0) {
                    code = u2 + 8;
                }
            } else if ("Exceptions".equals(attrName)) {
                exceptions = new String[this.readUnsignedShort(u2 + 8)];
                exception = u2 + 10;
                for (int j2 = 0; j2 < exceptions.length; ++j2) {
                    exceptions[j2] = this.readClass(exception, c2);
                    exception += 2;
                }
            } else if ("Signature".equals(attrName)) {
                signature = this.readUTF8(u2 + 8, c2);
            } else if ("Deprecated".equals(attrName)) {
                context.access |= 0x20000;
            } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                anns = u2 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = u2 + 8;
            } else if ("AnnotationDefault".equals(attrName)) {
                dann = u2 + 8;
            } else if ("Synthetic".equals(attrName)) {
                context.access |= 0x41000;
            } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                ianns = u2 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = u2 + 8;
            } else if ("RuntimeVisibleParameterAnnotations".equals(attrName)) {
                mpanns = u2 + 8;
            } else if ("RuntimeInvisibleParameterAnnotations".equals(attrName)) {
                impanns = u2 + 8;
            } else if ("MethodParameters".equals(attrName)) {
                methodParameters = u2 + 8;
            } else {
                Attribute attr = this.readAttribute(context.attrs, attrName, u2 + 8, this.readInt(u2 + 4), c2, -1, null);
                if (attr != null) {
                    attr.next = attributes;
                    attributes = attr;
                }
            }
            u2 += 6 + this.readInt(u2 + 4);
        }
        u2 += 2;
        MethodVisitor mv = classVisitor.visitMethod(context.access, context.name, context.desc, signature, exceptions);
        if (mv == null) {
            return u2;
        }
        if (mv instanceof MethodWriter) {
            MethodWriter mw = (MethodWriter)mv;
            if (mw.cw.cr == this && signature == mw.signature) {
                boolean sameExceptions = false;
                if (exceptions == null) {
                    sameExceptions = mw.exceptionCount == 0;
                } else if (exceptions.length == mw.exceptionCount) {
                    sameExceptions = true;
                    for (int j3 = exceptions.length - 1; j3 >= 0; --j3) {
                        if (mw.exceptions[j3] == this.readUnsignedShort(exception -= 2)) continue;
                        sameExceptions = false;
                        break;
                    }
                }
                if (sameExceptions) {
                    mw.classReaderOffset = firstAttribute;
                    mw.classReaderLength = u2 - firstAttribute;
                    return u2;
                }
            }
        }
        if (methodParameters != 0) {
            int i3 = this.b[methodParameters] & 0xFF;
            v2 = methodParameters + 1;
            while (i3 > 0) {
                mv.visitParameter(this.readUTF8(v2, c2), this.readUnsignedShort(v2 + 2));
                --i3;
                v2 += 4;
            }
        }
        if (dann != 0) {
            AnnotationVisitor dv2 = mv.visitAnnotationDefault();
            this.readAnnotationValue(dann, c2, null, dv2);
            if (dv2 != null) {
                dv2.visitEnd();
            }
        }
        if (anns != 0) {
            v2 = anns + 2;
            for (int i4 = this.readUnsignedShort(anns); i4 > 0; --i4) {
                v2 = this.readAnnotationValues(v2 + 2, c2, true, mv.visitAnnotation(this.readUTF8(v2, c2), true));
            }
        }
        if (ianns != 0) {
            v2 = ianns + 2;
            for (int i5 = this.readUnsignedShort(ianns); i5 > 0; --i5) {
                v2 = this.readAnnotationValues(v2 + 2, c2, true, mv.visitAnnotation(this.readUTF8(v2, c2), false));
            }
        }
        if (tanns != 0) {
            v2 = tanns + 2;
            for (int i6 = this.readUnsignedShort(tanns); i6 > 0; --i6) {
                v2 = this.readAnnotationTarget(context, v2);
                v2 = this.readAnnotationValues(v2 + 2, c2, true, mv.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v2, c2), true));
            }
        }
        if (itanns != 0) {
            v2 = itanns + 2;
            for (int i7 = this.readUnsignedShort(itanns); i7 > 0; --i7) {
                v2 = this.readAnnotationTarget(context, v2);
                v2 = this.readAnnotationValues(v2 + 2, c2, true, mv.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(v2, c2), false));
            }
        }
        if (mpanns != 0) {
            this.readParameterAnnotations(mv, context, mpanns, true);
        }
        if (impanns != 0) {
            this.readParameterAnnotations(mv, context, impanns, false);
        }
        while (attributes != null) {
            Attribute attr = attributes.next;
            attributes.next = null;
            mv.visitAttribute(attributes);
            attributes = attr;
        }
        if (code != 0) {
            mv.visitCode();
            this.readCode(mv, context, code);
        }
        mv.visitEnd();
        return u2;
    }

    private void readCode(MethodVisitor mv, Context context, int u2) {
        int i2;
        byte[] b2 = this.b;
        char[] c2 = context.buffer;
        int maxStack = this.readUnsignedShort(u2);
        int maxLocals = this.readUnsignedShort(u2 + 2);
        int codeLength = this.readInt(u2 + 4);
        int codeStart = u2 += 8;
        int codeEnd = u2 + codeLength;
        context.labels = new Label[codeLength + 2];
        Label[] labels = context.labels;
        this.readLabel(codeLength + 1, labels);
        block31: while (u2 < codeEnd) {
            int offset = u2 - codeStart;
            int opcode = b2[u2] & 0xFF;
            switch (ClassWriter.TYPE[opcode]) {
                case 0: 
                case 4: {
                    ++u2;
                    continue block31;
                }
                case 9: {
                    this.readLabel(offset + this.readShort(u2 + 1), labels);
                    u2 += 3;
                    continue block31;
                }
                case 18: {
                    this.readLabel(offset + this.readUnsignedShort(u2 + 1), labels);
                    u2 += 3;
                    continue block31;
                }
                case 10: {
                    this.readLabel(offset + this.readInt(u2 + 1), labels);
                    u2 += 5;
                    continue block31;
                }
                case 17: {
                    opcode = b2[u2 + 1] & 0xFF;
                    if (opcode == 132) {
                        u2 += 6;
                        continue block31;
                    }
                    u2 += 4;
                    continue block31;
                }
                case 14: {
                    int i3;
                    u2 = u2 + 4 - (offset & 3);
                    this.readLabel(offset + this.readInt(u2), labels);
                    for (i3 = this.readInt(u2 + 8) - this.readInt(u2 + 4) + 1; i3 > 0; --i3) {
                        this.readLabel(offset + this.readInt(u2 + 12), labels);
                        u2 += 4;
                    }
                    u2 += 12;
                    continue block31;
                }
                case 15: {
                    int i3;
                    u2 = u2 + 4 - (offset & 3);
                    this.readLabel(offset + this.readInt(u2), labels);
                    for (i3 = this.readInt(u2 + 4); i3 > 0; --i3) {
                        this.readLabel(offset + this.readInt(u2 + 12), labels);
                        u2 += 8;
                    }
                    u2 += 8;
                    continue block31;
                }
                case 1: 
                case 3: 
                case 11: {
                    u2 += 2;
                    continue block31;
                }
                case 2: 
                case 5: 
                case 6: 
                case 12: 
                case 13: {
                    u2 += 3;
                    continue block31;
                }
                case 7: 
                case 8: {
                    u2 += 5;
                    continue block31;
                }
            }
            u2 += 4;
        }
        for (int i4 = this.readUnsignedShort(u2); i4 > 0; --i4) {
            Label start = this.readLabel(this.readUnsignedShort(u2 + 2), labels);
            Label end = this.readLabel(this.readUnsignedShort(u2 + 4), labels);
            Label handler = this.readLabel(this.readUnsignedShort(u2 + 6), labels);
            String type = this.readUTF8(this.items[this.readUnsignedShort(u2 + 8)], c2);
            mv.visitTryCatchBlock(start, end, handler, type);
            u2 += 8;
        }
        u2 += 2;
        int[] tanns = null;
        int[] itanns = null;
        int tann = 0;
        int itann = 0;
        int ntoff = -1;
        int nitoff = -1;
        int varTable = 0;
        int varTypeTable = 0;
        boolean zip = true;
        boolean unzip = (context.flags & 8) != 0;
        int stackMap = 0;
        int stackMapSize = 0;
        int frameCount = 0;
        Context frame = null;
        Attribute attributes = null;
        for (i2 = this.readUnsignedShort(u2); i2 > 0; --i2) {
            int label;
            int j2;
            int v2;
            String attrName = this.readUTF8(u2 + 2, c2);
            if ("LocalVariableTable".equals(attrName)) {
                if ((context.flags & 2) == 0) {
                    varTable = u2 + 8;
                    v2 = u2;
                    for (j2 = this.readUnsignedShort(u2 + 8); j2 > 0; --j2) {
                        label = this.readUnsignedShort(v2 + 10);
                        if (labels[label] == null) {
                            this.readLabel((int)label, (Label[])labels).status |= 1;
                        }
                        if (labels[label += this.readUnsignedShort(v2 + 12)] == null) {
                            this.readLabel((int)label, (Label[])labels).status |= 1;
                        }
                        v2 += 10;
                    }
                }
            } else if ("LocalVariableTypeTable".equals(attrName)) {
                varTypeTable = u2 + 8;
            } else if ("LineNumberTable".equals(attrName)) {
                if ((context.flags & 2) == 0) {
                    v2 = u2;
                    for (j2 = this.readUnsignedShort(u2 + 8); j2 > 0; --j2) {
                        label = this.readUnsignedShort(v2 + 10);
                        if (labels[label] == null) {
                            this.readLabel((int)label, (Label[])labels).status |= 1;
                        }
                        Label l2 = labels[label];
                        while (l2.line > 0) {
                            if (l2.next == null) {
                                l2.next = new Label();
                            }
                            l2 = l2.next;
                        }
                        l2.line = this.readUnsignedShort(v2 + 12);
                        v2 += 4;
                    }
                }
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = this.readTypeAnnotations(mv, context, u2 + 8, true);
                ntoff = tanns.length == 0 || this.readByte(tanns[0]) < 67 ? -1 : this.readUnsignedShort(tanns[0] + 1);
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = this.readTypeAnnotations(mv, context, u2 + 8, false);
                nitoff = itanns.length == 0 || this.readByte(itanns[0]) < 67 ? -1 : this.readUnsignedShort(itanns[0] + 1);
            } else if ("StackMapTable".equals(attrName)) {
                if ((context.flags & 4) == 0) {
                    stackMap = u2 + 10;
                    stackMapSize = this.readInt(u2 + 4);
                    frameCount = this.readUnsignedShort(u2 + 8);
                }
            } else if ("StackMap".equals(attrName)) {
                if ((context.flags & 4) == 0) {
                    zip = false;
                    stackMap = u2 + 10;
                    stackMapSize = this.readInt(u2 + 4);
                    frameCount = this.readUnsignedShort(u2 + 8);
                }
            } else {
                for (j2 = 0; j2 < context.attrs.length; ++j2) {
                    Attribute attr;
                    if (!context.attrs[j2].type.equals(attrName) || (attr = context.attrs[j2].read(this, u2 + 8, this.readInt(u2 + 4), c2, codeStart - 8, labels)) == null) continue;
                    attr.next = attributes;
                    attributes = attr;
                }
            }
            u2 += 6 + this.readInt(u2 + 4);
        }
        u2 += 2;
        if (stackMap != 0) {
            frame = context;
            frame.offset = -1;
            frame.mode = 0;
            frame.localCount = 0;
            frame.localDiff = 0;
            frame.stackCount = 0;
            frame.local = new Object[maxLocals];
            frame.stack = new Object[maxStack];
            if (unzip) {
                this.getImplicitFrame(context);
            }
            for (i2 = stackMap; i2 < stackMap + stackMapSize - 2; ++i2) {
                int v3;
                if (b2[i2] != 8 || (v3 = this.readUnsignedShort(i2 + 1)) < 0 || v3 >= codeLength || (b2[codeStart + v3] & 0xFF) != 187) continue;
                this.readLabel(v3, labels);
            }
        }
        if ((context.flags & 0x100) != 0) {
            mv.visitFrame(-1, maxLocals, null, 0, null);
        }
        int opcodeDelta = (context.flags & 0x100) == 0 ? -33 : 0;
        u2 = codeStart;
        while (u2 < codeEnd) {
            int offset = u2 - codeStart;
            Label l3 = labels[offset];
            if (l3 != null) {
                Label next = l3.next;
                l3.next = null;
                mv.visitLabel(l3);
                if ((context.flags & 2) == 0 && l3.line > 0) {
                    mv.visitLineNumber(l3.line, l3);
                    while (next != null) {
                        mv.visitLineNumber(next.line, l3);
                        next = next.next;
                    }
                }
            }
            while (frame != null && (frame.offset == offset || frame.offset == -1)) {
                if (frame.offset != -1) {
                    if (!zip || unzip) {
                        mv.visitFrame(-1, frame.localCount, frame.local, frame.stackCount, frame.stack);
                    } else {
                        mv.visitFrame(frame.mode, frame.localDiff, frame.local, frame.stackCount, frame.stack);
                    }
                }
                if (frameCount > 0) {
                    stackMap = this.readFrame(stackMap, zip, unzip, frame);
                    --frameCount;
                    continue;
                }
                frame = null;
            }
            int opcode = b2[u2] & 0xFF;
            switch (ClassWriter.TYPE[opcode]) {
                case 0: {
                    mv.visitInsn(opcode);
                    ++u2;
                    break;
                }
                case 4: {
                    if (opcode > 54) {
                        mv.visitVarInsn(54 + ((opcode -= 59) >> 2), opcode & 3);
                    } else {
                        mv.visitVarInsn(21 + ((opcode -= 26) >> 2), opcode & 3);
                    }
                    ++u2;
                    break;
                }
                case 9: {
                    mv.visitJumpInsn(opcode, labels[offset + this.readShort(u2 + 1)]);
                    u2 += 3;
                    break;
                }
                case 10: {
                    mv.visitJumpInsn(opcode + opcodeDelta, labels[offset + this.readInt(u2 + 1)]);
                    u2 += 5;
                    break;
                }
                case 18: {
                    opcode = opcode < 218 ? opcode - 49 : opcode - 20;
                    Label target = labels[offset + this.readUnsignedShort(u2 + 1)];
                    if (opcode == 167 || opcode == 168) {
                        mv.visitJumpInsn(opcode + 33, target);
                    } else {
                        opcode = opcode <= 166 ? (opcode + 1 ^ 1) - 1 : opcode ^ 1;
                        Label endif = new Label();
                        mv.visitJumpInsn(opcode, endif);
                        mv.visitJumpInsn(200, target);
                        mv.visitLabel(endif);
                        if (stackMap != 0 && (frame == null || frame.offset != offset + 3)) {
                            mv.visitFrame(256, 0, null, 0, null);
                        }
                    }
                    u2 += 3;
                    break;
                }
                case 17: {
                    opcode = b2[u2 + 1] & 0xFF;
                    if (opcode == 132) {
                        mv.visitIincInsn(this.readUnsignedShort(u2 + 2), this.readShort(u2 + 4));
                        u2 += 6;
                        break;
                    }
                    mv.visitVarInsn(opcode, this.readUnsignedShort(u2 + 2));
                    u2 += 4;
                    break;
                }
                case 14: {
                    u2 = u2 + 4 - (offset & 3);
                    int label = offset + this.readInt(u2);
                    int min = this.readInt(u2 + 4);
                    int max = this.readInt(u2 + 8);
                    Label[] table = new Label[max - min + 1];
                    u2 += 12;
                    for (int i5 = 0; i5 < table.length; ++i5) {
                        table[i5] = labels[offset + this.readInt(u2)];
                        u2 += 4;
                    }
                    mv.visitTableSwitchInsn(min, max, labels[label], table);
                    break;
                }
                case 15: {
                    u2 = u2 + 4 - (offset & 3);
                    int label = offset + this.readInt(u2);
                    int len = this.readInt(u2 + 4);
                    int[] keys = new int[len];
                    Label[] values = new Label[len];
                    u2 += 8;
                    for (int i6 = 0; i6 < len; ++i6) {
                        keys[i6] = this.readInt(u2);
                        values[i6] = labels[offset + this.readInt(u2 + 4)];
                        u2 += 8;
                    }
                    mv.visitLookupSwitchInsn(labels[label], keys, values);
                    break;
                }
                case 3: {
                    mv.visitVarInsn(opcode, b2[u2 + 1] & 0xFF);
                    u2 += 2;
                    break;
                }
                case 1: {
                    mv.visitIntInsn(opcode, b2[u2 + 1]);
                    u2 += 2;
                    break;
                }
                case 2: {
                    mv.visitIntInsn(opcode, this.readShort(u2 + 1));
                    u2 += 3;
                    break;
                }
                case 11: {
                    mv.visitLdcInsn(this.readConst(b2[u2 + 1] & 0xFF, c2));
                    u2 += 2;
                    break;
                }
                case 12: {
                    mv.visitLdcInsn(this.readConst(this.readUnsignedShort(u2 + 1), c2));
                    u2 += 3;
                    break;
                }
                case 6: 
                case 7: {
                    int cpIndex = this.items[this.readUnsignedShort(u2 + 1)];
                    boolean itf = b2[cpIndex - 1] == 11;
                    String iowner = this.readClass(cpIndex, c2);
                    cpIndex = this.items[this.readUnsignedShort(cpIndex + 2)];
                    String iname = this.readUTF8(cpIndex, c2);
                    String idesc = this.readUTF8(cpIndex + 2, c2);
                    if (opcode < 182) {
                        mv.visitFieldInsn(opcode, iowner, iname, idesc);
                    } else {
                        mv.visitMethodInsn(opcode, iowner, iname, idesc, itf);
                    }
                    if (opcode == 185) {
                        u2 += 5;
                        break;
                    }
                    u2 += 3;
                    break;
                }
                case 8: {
                    int cpIndex = this.items[this.readUnsignedShort(u2 + 1)];
                    int bsmIndex = context.bootstrapMethods[this.readUnsignedShort(cpIndex)];
                    Handle bsm = (Handle)this.readConst(this.readUnsignedShort(bsmIndex), c2);
                    int bsmArgCount = this.readUnsignedShort(bsmIndex + 2);
                    Object[] bsmArgs = new Object[bsmArgCount];
                    bsmIndex += 4;
                    for (int i7 = 0; i7 < bsmArgCount; ++i7) {
                        bsmArgs[i7] = this.readConst(this.readUnsignedShort(bsmIndex), c2);
                        bsmIndex += 2;
                    }
                    cpIndex = this.items[this.readUnsignedShort(cpIndex + 2)];
                    String iname = this.readUTF8(cpIndex, c2);
                    String idesc = this.readUTF8(cpIndex + 2, c2);
                    mv.visitInvokeDynamicInsn(iname, idesc, bsm, bsmArgs);
                    u2 += 5;
                    break;
                }
                case 5: {
                    mv.visitTypeInsn(opcode, this.readClass(u2 + 1, c2));
                    u2 += 3;
                    break;
                }
                case 13: {
                    mv.visitIincInsn(b2[u2 + 1] & 0xFF, b2[u2 + 2]);
                    u2 += 3;
                    break;
                }
                default: {
                    mv.visitMultiANewArrayInsn(this.readClass(u2 + 1, c2), b2[u2 + 3] & 0xFF);
                    u2 += 4;
                }
            }
            while (tanns != null && tann < tanns.length && ntoff <= offset) {
                if (ntoff == offset) {
                    int v4 = this.readAnnotationTarget(context, tanns[tann]);
                    this.readAnnotationValues(v4 + 2, c2, true, mv.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(v4, c2), true));
                }
                ntoff = ++tann >= tanns.length || this.readByte(tanns[tann]) < 67 ? -1 : this.readUnsignedShort(tanns[tann] + 1);
            }
            while (itanns != null && itann < itanns.length && nitoff <= offset) {
                if (nitoff == offset) {
                    int v5 = this.readAnnotationTarget(context, itanns[itann]);
                    this.readAnnotationValues(v5 + 2, c2, true, mv.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(v5, c2), false));
                }
                nitoff = ++itann >= itanns.length || this.readByte(itanns[itann]) < 67 ? -1 : this.readUnsignedShort(itanns[itann] + 1);
            }
        }
        if (labels[codeLength] != null) {
            mv.visitLabel(labels[codeLength]);
        }
        if ((context.flags & 2) == 0 && varTable != 0) {
            int[] typeTable = null;
            if (varTypeTable != 0) {
                u2 = varTypeTable + 2;
                typeTable = new int[this.readUnsignedShort(varTypeTable) * 3];
                int i8 = typeTable.length;
                while (i8 > 0) {
                    typeTable[--i8] = u2 + 6;
                    typeTable[--i8] = this.readUnsignedShort(u2 + 8);
                    typeTable[--i8] = this.readUnsignedShort(u2);
                    u2 += 10;
                }
            }
            u2 = varTable + 2;
            for (int i9 = this.readUnsignedShort(varTable); i9 > 0; --i9) {
                int start = this.readUnsignedShort(u2);
                int length = this.readUnsignedShort(u2 + 2);
                int index = this.readUnsignedShort(u2 + 8);
                String vsignature = null;
                if (typeTable != null) {
                    for (int j3 = 0; j3 < typeTable.length; j3 += 3) {
                        if (typeTable[j3] != start || typeTable[j3 + 1] != index) continue;
                        vsignature = this.readUTF8(typeTable[j3 + 2], c2);
                        break;
                    }
                }
                mv.visitLocalVariable(this.readUTF8(u2 + 4, c2), this.readUTF8(u2 + 6, c2), vsignature, labels[start], labels[start + length], index);
                u2 += 10;
            }
        }
        if (tanns != null) {
            for (int i10 = 0; i10 < tanns.length; ++i10) {
                if (this.readByte(tanns[i10]) >> 1 != 32) continue;
                int v6 = this.readAnnotationTarget(context, tanns[i10]);
                v6 = this.readAnnotationValues(v6 + 2, c2, true, mv.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(v6, c2), true));
            }
        }
        if (itanns != null) {
            for (int i11 = 0; i11 < itanns.length; ++i11) {
                if (this.readByte(itanns[i11]) >> 1 != 32) continue;
                int v7 = this.readAnnotationTarget(context, itanns[i11]);
                v7 = this.readAnnotationValues(v7 + 2, c2, true, mv.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(v7, c2), false));
            }
        }
        while (attributes != null) {
            Attribute attr = attributes.next;
            attributes.next = null;
            mv.visitAttribute(attributes);
            attributes = attr;
        }
        mv.visitMaxs(maxStack, maxLocals);
    }

    private int[] readTypeAnnotations(MethodVisitor mv, Context context, int u2, boolean visible) {
        char[] c2 = context.buffer;
        int[] offsets = new int[this.readUnsignedShort(u2)];
        u2 += 2;
        for (int i2 = 0; i2 < offsets.length; ++i2) {
            offsets[i2] = u2;
            int target = this.readInt(u2);
            switch (target >>> 24) {
                case 0: 
                case 1: 
                case 22: {
                    u2 += 2;
                    break;
                }
                case 19: 
                case 20: 
                case 21: {
                    ++u2;
                    break;
                }
                case 64: 
                case 65: {
                    for (int j2 = this.readUnsignedShort(u2 + 1); j2 > 0; --j2) {
                        int start = this.readUnsignedShort(u2 + 3);
                        int length = this.readUnsignedShort(u2 + 5);
                        this.readLabel(start, context.labels);
                        this.readLabel(start + length, context.labels);
                        u2 += 6;
                    }
                    u2 += 3;
                    break;
                }
                case 71: 
                case 72: 
                case 73: 
                case 74: 
                case 75: {
                    u2 += 4;
                    break;
                }
                default: {
                    u2 += 3;
                }
            }
            int pathLength = this.readByte(u2);
            if (target >>> 24 == 66) {
                TypePath path = pathLength == 0 ? null : new TypePath(this.b, u2);
                u2 += 1 + 2 * pathLength;
                u2 = this.readAnnotationValues(u2 + 2, c2, true, mv.visitTryCatchAnnotation(target, path, this.readUTF8(u2, c2), visible));
                continue;
            }
            u2 = this.readAnnotationValues(u2 + 3 + 2 * pathLength, c2, true, null);
        }
        return offsets;
    }

    private int readAnnotationTarget(Context context, int u2) {
        int target = this.readInt(u2);
        switch (target >>> 24) {
            case 0: 
            case 1: 
            case 22: {
                target &= 0xFFFF0000;
                u2 += 2;
                break;
            }
            case 19: 
            case 20: 
            case 21: {
                target &= 0xFF000000;
                ++u2;
                break;
            }
            case 64: 
            case 65: {
                target &= 0xFF000000;
                int n2 = this.readUnsignedShort(u2 + 1);
                context.start = new Label[n2];
                context.end = new Label[n2];
                context.index = new int[n2];
                u2 += 3;
                for (int i2 = 0; i2 < n2; ++i2) {
                    int start = this.readUnsignedShort(u2);
                    int length = this.readUnsignedShort(u2 + 2);
                    context.start[i2] = this.readLabel(start, context.labels);
                    context.end[i2] = this.readLabel(start + length, context.labels);
                    context.index[i2] = this.readUnsignedShort(u2 + 4);
                    u2 += 6;
                }
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                target &= 0xFF0000FF;
                u2 += 4;
                break;
            }
            default: {
                target &= target >>> 24 < 67 ? -256 : -16777216;
                u2 += 3;
            }
        }
        int pathLength = this.readByte(u2);
        context.typeRef = target;
        context.typePath = pathLength == 0 ? null : new TypePath(this.b, u2);
        return u2 + 1 + 2 * pathLength;
    }

    private void readParameterAnnotations(MethodVisitor mv, Context context, int v2, boolean visible) {
        AnnotationVisitor av2;
        int i2;
        int n2 = this.b[v2++] & 0xFF;
        int synthetics = Type.getArgumentTypes(context.desc).length - n2;
        for (i2 = 0; i2 < synthetics; ++i2) {
            av2 = mv.visitParameterAnnotation(i2, "Ljava/lang/Synthetic;", false);
            if (av2 == null) continue;
            av2.visitEnd();
        }
        char[] c2 = context.buffer;
        while (i2 < n2 + synthetics) {
            int j2 = this.readUnsignedShort(v2);
            v2 += 2;
            while (j2 > 0) {
                av2 = mv.visitParameterAnnotation(i2, this.readUTF8(v2, c2), visible);
                v2 = this.readAnnotationValues(v2 + 2, c2, true, av2);
                --j2;
            }
            ++i2;
        }
    }

    private int readAnnotationValues(int v2, char[] buf, boolean named, AnnotationVisitor av2) {
        int i2 = this.readUnsignedShort(v2);
        v2 += 2;
        if (named) {
            while (i2 > 0) {
                v2 = this.readAnnotationValue(v2 + 2, buf, this.readUTF8(v2, buf), av2);
                --i2;
            }
        } else {
            while (i2 > 0) {
                v2 = this.readAnnotationValue(v2, buf, null, av2);
                --i2;
            }
        }
        if (av2 != null) {
            av2.visitEnd();
        }
        return v2;
    }

    private int readAnnotationValue(int v2, char[] buf, String name, AnnotationVisitor av2) {
        if (av2 == null) {
            switch (this.b[v2] & 0xFF) {
                case 101: {
                    return v2 + 5;
                }
                case 64: {
                    return this.readAnnotationValues(v2 + 3, buf, true, null);
                }
                case 91: {
                    return this.readAnnotationValues(v2 + 1, buf, false, null);
                }
            }
            return v2 + 3;
        }
        block5 : switch (this.b[v2++] & 0xFF) {
            case 68: 
            case 70: 
            case 73: 
            case 74: {
                av2.visit(name, this.readConst(this.readUnsignedShort(v2), buf));
                v2 += 2;
                break;
            }
            case 66: {
                av2.visit(name, (byte)this.readInt(this.items[this.readUnsignedShort(v2)]));
                v2 += 2;
                break;
            }
            case 90: {
                av2.visit(name, this.readInt(this.items[this.readUnsignedShort(v2)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                v2 += 2;
                break;
            }
            case 83: {
                av2.visit(name, (short)this.readInt(this.items[this.readUnsignedShort(v2)]));
                v2 += 2;
                break;
            }
            case 67: {
                av2.visit(name, Character.valueOf((char)this.readInt(this.items[this.readUnsignedShort(v2)])));
                v2 += 2;
                break;
            }
            case 115: {
                av2.visit(name, this.readUTF8(v2, buf));
                v2 += 2;
                break;
            }
            case 101: {
                av2.visitEnum(name, this.readUTF8(v2, buf), this.readUTF8(v2 + 2, buf));
                v2 += 4;
                break;
            }
            case 99: {
                av2.visit(name, Type.getType(this.readUTF8(v2, buf)));
                v2 += 2;
                break;
            }
            case 64: {
                v2 = this.readAnnotationValues(v2 + 2, buf, true, av2.visitAnnotation(name, this.readUTF8(v2, buf)));
                break;
            }
            case 91: {
                int size = this.readUnsignedShort(v2);
                v2 += 2;
                if (size == 0) {
                    return this.readAnnotationValues(v2 - 2, buf, false, av2.visitArray(name));
                }
                switch (this.b[v2++] & 0xFF) {
                    case 66: {
                        byte[] bv2 = new byte[size];
                        for (int i2 = 0; i2 < size; ++i2) {
                            bv2[i2] = (byte)this.readInt(this.items[this.readUnsignedShort(v2)]);
                            v2 += 3;
                        }
                        av2.visit(name, bv2);
                        --v2;
                        break block5;
                    }
                    case 90: {
                        boolean[] zv = new boolean[size];
                        for (int i3 = 0; i3 < size; ++i3) {
                            zv[i3] = this.readInt(this.items[this.readUnsignedShort(v2)]) != 0;
                            v2 += 3;
                        }
                        av2.visit(name, zv);
                        --v2;
                        break block5;
                    }
                    case 83: {
                        short[] sv = new short[size];
                        for (int i4 = 0; i4 < size; ++i4) {
                            sv[i4] = (short)this.readInt(this.items[this.readUnsignedShort(v2)]);
                            v2 += 3;
                        }
                        av2.visit(name, sv);
                        --v2;
                        break block5;
                    }
                    case 67: {
                        char[] cv2 = new char[size];
                        for (int i5 = 0; i5 < size; ++i5) {
                            cv2[i5] = (char)this.readInt(this.items[this.readUnsignedShort(v2)]);
                            v2 += 3;
                        }
                        av2.visit(name, cv2);
                        --v2;
                        break block5;
                    }
                    case 73: {
                        int[] iv = new int[size];
                        for (int i6 = 0; i6 < size; ++i6) {
                            iv[i6] = this.readInt(this.items[this.readUnsignedShort(v2)]);
                            v2 += 3;
                        }
                        av2.visit(name, iv);
                        --v2;
                        break block5;
                    }
                    case 74: {
                        long[] lv = new long[size];
                        for (int i7 = 0; i7 < size; ++i7) {
                            lv[i7] = this.readLong(this.items[this.readUnsignedShort(v2)]);
                            v2 += 3;
                        }
                        av2.visit(name, lv);
                        --v2;
                        break block5;
                    }
                    case 70: {
                        float[] fv2 = new float[size];
                        for (int i8 = 0; i8 < size; ++i8) {
                            fv2[i8] = Float.intBitsToFloat(this.readInt(this.items[this.readUnsignedShort(v2)]));
                            v2 += 3;
                        }
                        av2.visit(name, fv2);
                        --v2;
                        break block5;
                    }
                    case 68: {
                        double[] dv2 = new double[size];
                        for (int i9 = 0; i9 < size; ++i9) {
                            dv2[i9] = Double.longBitsToDouble(this.readLong(this.items[this.readUnsignedShort(v2)]));
                            v2 += 3;
                        }
                        av2.visit(name, dv2);
                        --v2;
                        break block5;
                    }
                }
                v2 = this.readAnnotationValues(v2 - 3, buf, false, av2.visitArray(name));
            }
        }
        return v2;
    }

    private void getImplicitFrame(Context frame) {
        String desc = frame.desc;
        Object[] locals = frame.local;
        int local = 0;
        if ((frame.access & 8) == 0) {
            locals[local++] = "<init>".equals(frame.name) ? Opcodes.UNINITIALIZED_THIS : this.readClass(this.header + 2, frame.buffer);
        }
        int i2 = 1;
        block8: while (true) {
            int j2 = i2;
            switch (desc.charAt(i2++)) {
                case 'B': 
                case 'C': 
                case 'I': 
                case 'S': 
                case 'Z': {
                    locals[local++] = Opcodes.INTEGER;
                    continue block8;
                }
                case 'F': {
                    locals[local++] = Opcodes.FLOAT;
                    continue block8;
                }
                case 'J': {
                    locals[local++] = Opcodes.LONG;
                    continue block8;
                }
                case 'D': {
                    locals[local++] = Opcodes.DOUBLE;
                    continue block8;
                }
                case '[': {
                    while (desc.charAt(i2) == '[') {
                        ++i2;
                    }
                    if (desc.charAt(i2) == 'L') {
                        ++i2;
                        while (desc.charAt(i2) != ';') {
                            ++i2;
                        }
                    }
                    locals[local++] = desc.substring(j2, ++i2);
                    continue block8;
                }
                case 'L': {
                    while (desc.charAt(i2) != ';') {
                        ++i2;
                    }
                    locals[local++] = desc.substring(j2 + 1, i2++);
                    continue block8;
                }
            }
            break;
        }
        frame.localCount = local;
    }

    private int readFrame(int stackMap, boolean zip, boolean unzip, Context frame) {
        int delta;
        int tag;
        char[] c2 = frame.buffer;
        Label[] labels = frame.labels;
        if (zip) {
            tag = this.b[stackMap++] & 0xFF;
        } else {
            tag = 255;
            frame.offset = -1;
        }
        frame.localDiff = 0;
        if (tag < 64) {
            delta = tag;
            frame.mode = 3;
            frame.stackCount = 0;
        } else if (tag < 128) {
            delta = tag - 64;
            stackMap = this.readFrameType(frame.stack, 0, stackMap, c2, labels);
            frame.mode = 4;
            frame.stackCount = 1;
        } else {
            delta = this.readUnsignedShort(stackMap);
            stackMap += 2;
            if (tag == 247) {
                stackMap = this.readFrameType(frame.stack, 0, stackMap, c2, labels);
                frame.mode = 4;
                frame.stackCount = 1;
            } else if (tag >= 248 && tag < 251) {
                frame.mode = 2;
                frame.localDiff = 251 - tag;
                frame.localCount -= frame.localDiff;
                frame.stackCount = 0;
            } else if (tag == 251) {
                frame.mode = 3;
                frame.stackCount = 0;
            } else if (tag < 255) {
                int local = unzip ? frame.localCount : 0;
                for (int i2 = tag - 251; i2 > 0; --i2) {
                    stackMap = this.readFrameType(frame.local, local++, stackMap, c2, labels);
                }
                frame.mode = 1;
                frame.localDiff = tag - 251;
                frame.localCount += frame.localDiff;
                frame.stackCount = 0;
            } else {
                frame.mode = 0;
                int n2 = this.readUnsignedShort(stackMap);
                stackMap += 2;
                frame.localDiff = n2;
                frame.localCount = n2;
                int local = 0;
                while (n2 > 0) {
                    stackMap = this.readFrameType(frame.local, local++, stackMap, c2, labels);
                    --n2;
                }
                n2 = this.readUnsignedShort(stackMap);
                stackMap += 2;
                frame.stackCount = n2;
                int stack = 0;
                while (n2 > 0) {
                    stackMap = this.readFrameType(frame.stack, stack++, stackMap, c2, labels);
                    --n2;
                }
            }
        }
        frame.offset += delta + 1;
        this.readLabel(frame.offset, labels);
        return stackMap;
    }

    private int readFrameType(Object[] frame, int index, int v2, char[] buf, Label[] labels) {
        int type = this.b[v2++] & 0xFF;
        switch (type) {
            case 0: {
                frame[index] = Opcodes.TOP;
                break;
            }
            case 1: {
                frame[index] = Opcodes.INTEGER;
                break;
            }
            case 2: {
                frame[index] = Opcodes.FLOAT;
                break;
            }
            case 3: {
                frame[index] = Opcodes.DOUBLE;
                break;
            }
            case 4: {
                frame[index] = Opcodes.LONG;
                break;
            }
            case 5: {
                frame[index] = Opcodes.NULL;
                break;
            }
            case 6: {
                frame[index] = Opcodes.UNINITIALIZED_THIS;
                break;
            }
            case 7: {
                frame[index] = this.readClass(v2, buf);
                v2 += 2;
                break;
            }
            default: {
                frame[index] = this.readLabel(this.readUnsignedShort(v2), labels);
                v2 += 2;
            }
        }
        return v2;
    }

    protected Label readLabel(int offset, Label[] labels) {
        if (labels[offset] == null) {
            labels[offset] = new Label();
        }
        return labels[offset];
    }

    private int getAttributes() {
        int j2;
        int i2;
        int u2 = this.header + 8 + this.readUnsignedShort(this.header + 6) * 2;
        for (i2 = this.readUnsignedShort(u2); i2 > 0; --i2) {
            for (j2 = this.readUnsignedShort(u2 + 8); j2 > 0; --j2) {
                u2 += 6 + this.readInt(u2 + 12);
            }
            u2 += 8;
        }
        for (i2 = this.readUnsignedShort(u2 += 2); i2 > 0; --i2) {
            for (j2 = this.readUnsignedShort(u2 + 8); j2 > 0; --j2) {
                u2 += 6 + this.readInt(u2 + 12);
            }
            u2 += 8;
        }
        return u2 + 2;
    }

    private Attribute readAttribute(Attribute[] attrs, String type, int off, int len, char[] buf, int codeOff, Label[] labels) {
        for (int i2 = 0; i2 < attrs.length; ++i2) {
            if (!attrs[i2].type.equals(type)) continue;
            return attrs[i2].read(this, off, len, buf, codeOff, labels);
        }
        return new Attribute(type).read(this, off, len, null, -1, null);
    }

    public int getItemCount() {
        return this.items.length;
    }

    public int getItem(int item) {
        return this.items[item];
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int readByte(int index) {
        return this.b[index] & 0xFF;
    }

    public int readUnsignedShort(int index) {
        byte[] b2 = this.b;
        return (b2[index] & 0xFF) << 8 | b2[index + 1] & 0xFF;
    }

    public short readShort(int index) {
        byte[] b2 = this.b;
        return (short)((b2[index] & 0xFF) << 8 | b2[index + 1] & 0xFF);
    }

    public int readInt(int index) {
        byte[] b2 = this.b;
        return (b2[index] & 0xFF) << 24 | (b2[index + 1] & 0xFF) << 16 | (b2[index + 2] & 0xFF) << 8 | b2[index + 3] & 0xFF;
    }

    public long readLong(int index) {
        long l1 = this.readInt(index);
        long l0 = (long)this.readInt(index + 4) & 0xFFFFFFFFL;
        return l1 << 32 | l0;
    }

    public String readUTF8(int index, char[] buf) {
        int item = this.readUnsignedShort(index);
        if (index == 0 || item == 0) {
            return null;
        }
        String s2 = this.strings[item];
        if (s2 != null) {
            return s2;
        }
        index = this.items[item];
        this.strings[item] = this.readUTF(index + 2, this.readUnsignedShort(index), buf);
        return this.strings[item];
    }

    private String readUTF(int index, int utfLen, char[] buf) {
        int endIndex = index + utfLen;
        byte[] b2 = this.b;
        int strLen = 0;
        int st = 0;
        int cc2 = 0;
        while (index < endIndex) {
            int c2 = b2[index++];
            switch (st) {
                case 0: {
                    if ((c2 &= 0xFF) < 128) {
                        buf[strLen++] = (char)c2;
                        break;
                    }
                    if (c2 < 224 && c2 > 191) {
                        cc2 = (char)(c2 & 0x1F);
                        st = 1;
                        break;
                    }
                    cc2 = (char)(c2 & 0xF);
                    st = 2;
                    break;
                }
                case 1: {
                    buf[strLen++] = (char)(cc2 << 6 | c2 & 0x3F);
                    st = 0;
                    break;
                }
                case 2: {
                    cc2 = (char)(cc2 << 6 | c2 & 0x3F);
                    st = 1;
                }
            }
        }
        return new String(buf, 0, strLen);
    }

    public String readClass(int index, char[] buf) {
        return this.readUTF8(this.items[this.readUnsignedShort(index)], buf);
    }

    public Object readConst(int item, char[] buf) {
        int index = this.items[item];
        switch (this.b[index - 1]) {
            case 3: {
                return this.readInt(index);
            }
            case 4: {
                return Float.valueOf(Float.intBitsToFloat(this.readInt(index)));
            }
            case 5: {
                return this.readLong(index);
            }
            case 6: {
                return Double.longBitsToDouble(this.readLong(index));
            }
            case 7: {
                return Type.getObjectType(this.readUTF8(index, buf));
            }
            case 8: {
                return this.readUTF8(index, buf);
            }
            case 16: {
                return Type.getMethodType(this.readUTF8(index, buf));
            }
        }
        int tag = this.readByte(index);
        int[] items = this.items;
        int cpIndex = items[this.readUnsignedShort(index + 1)];
        boolean itf = this.b[cpIndex - 1] == 11;
        String owner = this.readClass(cpIndex, buf);
        cpIndex = items[this.readUnsignedShort(cpIndex + 2)];
        String name = this.readUTF8(cpIndex, buf);
        String desc = this.readUTF8(cpIndex + 2, buf);
        return new Handle(tag, owner, name, desc, itf);
    }
}

