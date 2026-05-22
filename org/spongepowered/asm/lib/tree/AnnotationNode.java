/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AnnotationNode
extends AnnotationVisitor {
    public String desc;
    public List<Object> values;

    public AnnotationNode(String desc) {
        this(327680, desc);
        if (this.getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationNode(int api2, String desc) {
        super(api2);
        this.desc = desc;
    }

    AnnotationNode(List<Object> values) {
        super(327680);
        this.values = values;
    }

    @Override
    public void visit(String name, Object value) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        if (value instanceof byte[]) {
            byte[] v2 = (byte[])value;
            ArrayList<Byte> l2 = new ArrayList<Byte>(v2.length);
            for (byte b2 : v2) {
                l2.add(b2);
            }
            this.values.add(l2);
        } else if (value instanceof boolean[]) {
            boolean[] v3 = (boolean[])value;
            ArrayList<Boolean> l3 = new ArrayList<Boolean>(v3.length);
            for (boolean b3 : v3) {
                l3.add(b3);
            }
            this.values.add(l3);
        } else if (value instanceof short[]) {
            short[] v4 = (short[])value;
            ArrayList<Short> l4 = new ArrayList<Short>(v4.length);
            for (short s2 : v4) {
                l4.add(s2);
            }
            this.values.add(l4);
        } else if (value instanceof char[]) {
            char[] v5 = (char[])value;
            ArrayList<Character> l5 = new ArrayList<Character>(v5.length);
            for (char c2 : v5) {
                l5.add(Character.valueOf(c2));
            }
            this.values.add(l5);
        } else if (value instanceof int[]) {
            int[] v6 = (int[])value;
            ArrayList<Integer> l6 = new ArrayList<Integer>(v6.length);
            for (int i2 : v6) {
                l6.add(i2);
            }
            this.values.add(l6);
        } else if (value instanceof long[]) {
            long[] v7 = (long[])value;
            ArrayList<Long> l7 = new ArrayList<Long>(v7.length);
            for (long lng : v7) {
                l7.add(lng);
            }
            this.values.add(l7);
        } else if (value instanceof float[]) {
            float[] v8 = (float[])value;
            ArrayList<Float> l8 = new ArrayList<Float>(v8.length);
            for (float f2 : v8) {
                l8.add(Float.valueOf(f2));
            }
            this.values.add(l8);
        } else if (value instanceof double[]) {
            double[] v9 = (double[])value;
            ArrayList<Double> l9 = new ArrayList<Double>(v9.length);
            for (double d2 : v9) {
                l9.add(d2);
            }
            this.values.add(l9);
        } else {
            this.values.add(value);
        }
    }

    @Override
    public void visitEnum(String name, String desc, String value) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        this.values.add(new String[]{desc, value});
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        AnnotationNode annotation = new AnnotationNode(desc);
        this.values.add(annotation);
        return annotation;
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
        if (this.values == null) {
            this.values = new ArrayList<Object>(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        ArrayList<Object> array = new ArrayList<Object>();
        this.values.add(array);
        return new AnnotationNode(array);
    }

    @Override
    public void visitEnd() {
    }

    public void check(int api2) {
    }

    public void accept(AnnotationVisitor av2) {
        if (av2 != null) {
            if (this.values != null) {
                for (int i2 = 0; i2 < this.values.size(); i2 += 2) {
                    String name = (String)this.values.get(i2);
                    Object value = this.values.get(i2 + 1);
                    AnnotationNode.accept(av2, name, value);
                }
            }
            av2.visitEnd();
        }
    }

    static void accept(AnnotationVisitor av2, String name, Object value) {
        if (av2 != null) {
            if (value instanceof String[]) {
                String[] typeconst = (String[])value;
                av2.visitEnum(name, typeconst[0], typeconst[1]);
            } else if (value instanceof AnnotationNode) {
                AnnotationNode an2 = (AnnotationNode)value;
                an2.accept(av2.visitAnnotation(name, an2.desc));
            } else if (value instanceof List) {
                AnnotationVisitor v2 = av2.visitArray(name);
                if (v2 != null) {
                    List array = (List)value;
                    for (int j2 = 0; j2 < array.size(); ++j2) {
                        AnnotationNode.accept(v2, null, array.get(j2));
                    }
                    v2.visitEnd();
                }
            } else {
                av2.visit(name, value);
            }
        }
    }
}

