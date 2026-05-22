/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Item;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;

final class AnnotationWriter
extends AnnotationVisitor {
    private final ClassWriter cw;
    private int size;
    private final boolean named;
    private final ByteVector bv;
    private final ByteVector parent;
    private final int offset;
    AnnotationWriter next;
    AnnotationWriter prev;

    AnnotationWriter(ClassWriter cw2, boolean named, ByteVector bv2, ByteVector parent, int offset) {
        super(327680);
        this.cw = cw2;
        this.named = named;
        this.bv = bv2;
        this.parent = parent;
        this.offset = offset;
    }

    public void visit(String name, Object value) {
        ++this.size;
        if (this.named) {
            this.bv.putShort(this.cw.newUTF8(name));
        }
        if (value instanceof String) {
            this.bv.put12(115, this.cw.newUTF8((String)value));
        } else if (value instanceof Byte) {
            this.bv.put12(66, this.cw.newInteger((int)((Byte)value).byteValue()).index);
        } else if (value instanceof Boolean) {
            int v2 = (Boolean)value != false ? 1 : 0;
            this.bv.put12(90, this.cw.newInteger((int)v2).index);
        } else if (value instanceof Character) {
            this.bv.put12(67, this.cw.newInteger((int)((Character)value).charValue()).index);
        } else if (value instanceof Short) {
            this.bv.put12(83, this.cw.newInteger((int)((Short)value).shortValue()).index);
        } else if (value instanceof Type) {
            this.bv.put12(99, this.cw.newUTF8(((Type)value).getDescriptor()));
        } else if (value instanceof byte[]) {
            byte[] v3 = (byte[])value;
            this.bv.put12(91, v3.length);
            for (int i2 = 0; i2 < v3.length; ++i2) {
                this.bv.put12(66, this.cw.newInteger((int)v3[i2]).index);
            }
        } else if (value instanceof boolean[]) {
            boolean[] v4 = (boolean[])value;
            this.bv.put12(91, v4.length);
            for (int i3 = 0; i3 < v4.length; ++i3) {
                this.bv.put12(90, this.cw.newInteger((int)(v4[i3] ? 1 : 0)).index);
            }
        } else if (value instanceof short[]) {
            short[] v5 = (short[])value;
            this.bv.put12(91, v5.length);
            for (int i4 = 0; i4 < v5.length; ++i4) {
                this.bv.put12(83, this.cw.newInteger((int)v5[i4]).index);
            }
        } else if (value instanceof char[]) {
            char[] v6 = (char[])value;
            this.bv.put12(91, v6.length);
            for (int i5 = 0; i5 < v6.length; ++i5) {
                this.bv.put12(67, this.cw.newInteger((int)v6[i5]).index);
            }
        } else if (value instanceof int[]) {
            int[] v7 = (int[])value;
            this.bv.put12(91, v7.length);
            for (int i6 = 0; i6 < v7.length; ++i6) {
                this.bv.put12(73, this.cw.newInteger((int)v7[i6]).index);
            }
        } else if (value instanceof long[]) {
            long[] v8 = (long[])value;
            this.bv.put12(91, v8.length);
            for (int i7 = 0; i7 < v8.length; ++i7) {
                this.bv.put12(74, this.cw.newLong((long)v8[i7]).index);
            }
        } else if (value instanceof float[]) {
            float[] v9 = (float[])value;
            this.bv.put12(91, v9.length);
            for (int i8 = 0; i8 < v9.length; ++i8) {
                this.bv.put12(70, this.cw.newFloat((float)v9[i8]).index);
            }
        } else if (value instanceof double[]) {
            double[] v10 = (double[])value;
            this.bv.put12(91, v10.length);
            for (int i9 = 0; i9 < v10.length; ++i9) {
                this.bv.put12(68, this.cw.newDouble((double)v10[i9]).index);
            }
        } else {
            Item i10 = this.cw.newConstItem(value);
            this.bv.put12(".s.IFJDCS".charAt(i10.type), i10.index);
        }
    }

    public void visitEnum(String name, String desc, String value) {
        ++this.size;
        if (this.named) {
            this.bv.putShort(this.cw.newUTF8(name));
        }
        this.bv.put12(101, this.cw.newUTF8(desc)).putShort(this.cw.newUTF8(value));
    }

    public AnnotationVisitor visitAnnotation(String name, String desc) {
        ++this.size;
        if (this.named) {
            this.bv.putShort(this.cw.newUTF8(name));
        }
        this.bv.put12(64, this.cw.newUTF8(desc)).putShort(0);
        return new AnnotationWriter(this.cw, true, this.bv, this.bv, this.bv.length - 2);
    }

    public AnnotationVisitor visitArray(String name) {
        ++this.size;
        if (this.named) {
            this.bv.putShort(this.cw.newUTF8(name));
        }
        this.bv.put12(91, 0);
        return new AnnotationWriter(this.cw, false, this.bv, this.bv, this.bv.length - 2);
    }

    public void visitEnd() {
        if (this.parent != null) {
            byte[] data = this.parent.data;
            data[this.offset] = (byte)(this.size >>> 8);
            data[this.offset + 1] = (byte)this.size;
        }
    }

    int getSize() {
        int size = 0;
        AnnotationWriter aw2 = this;
        while (aw2 != null) {
            size += aw2.bv.length;
            aw2 = aw2.next;
        }
        return size;
    }

    void put(ByteVector out) {
        int n2 = 0;
        int size = 2;
        AnnotationWriter aw2 = this;
        AnnotationWriter last = null;
        while (aw2 != null) {
            ++n2;
            size += aw2.bv.length;
            aw2.visitEnd();
            aw2.prev = last;
            last = aw2;
            aw2 = aw2.next;
        }
        out.putInt(size);
        out.putShort(n2);
        aw2 = last;
        while (aw2 != null) {
            out.putByteArray(aw2.bv.data, 0, aw2.bv.length);
            aw2 = aw2.prev;
        }
    }

    static void put(AnnotationWriter[] panns, int off, ByteVector out) {
        int i2;
        int size = 1 + 2 * (panns.length - off);
        for (i2 = off; i2 < panns.length; ++i2) {
            size += panns[i2] == null ? 0 : panns[i2].getSize();
        }
        out.putInt(size).putByte(panns.length - off);
        for (i2 = off; i2 < panns.length; ++i2) {
            AnnotationWriter aw2 = panns[i2];
            AnnotationWriter last = null;
            int n2 = 0;
            while (aw2 != null) {
                ++n2;
                aw2.visitEnd();
                aw2.prev = last;
                last = aw2;
                aw2 = aw2.next;
            }
            out.putShort(n2);
            aw2 = last;
            while (aw2 != null) {
                out.putByteArray(aw2.bv.data, 0, aw2.bv.length);
                aw2 = aw2.prev;
            }
        }
    }

    static void putTarget(int typeRef, TypePath typePath, ByteVector out) {
        switch (typeRef >>> 24) {
            case 0: 
            case 1: 
            case 22: {
                out.putShort(typeRef >>> 16);
                break;
            }
            case 19: 
            case 20: 
            case 21: {
                out.putByte(typeRef >>> 24);
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                out.putInt(typeRef);
                break;
            }
            default: {
                out.put12(typeRef >>> 24, (typeRef & 0xFFFF00) >> 8);
            }
        }
        if (typePath == null) {
            out.putByte(0);
        } else {
            int length = typePath.b[typePath.offset] * 2 + 1;
            out.putByteArray(typePath.b, typePath.offset, length);
        }
    }
}

