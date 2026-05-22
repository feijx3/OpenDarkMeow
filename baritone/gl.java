/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  awt
 *  axj
 *  fy
 *  it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap
 *  nf
 */
package baritone;

import baritone.ge;
import baritone.gm;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public final class gl
extends ge {
    public gl(fy fy2) {
        int n2;
        Object object;
        int n3;
        Object object22;
        this.x = fy2.h("Width");
        this.y = fy2.h("Height");
        this.z = fy2.h("Length");
        this.a = new awt[this.x][this.z][this.y];
        Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap();
        fy fy3 = fy2.p("Palette");
        for (Object object22 : fy3.c()) {
            n3 = fy3.h((String)object22);
            a a2 = baritone.gl$a.b((String)object22);
            if (a2 == null) {
                throw new IllegalArgumentException("Unable to parse palette tag");
            }
            object = baritone.gl$a.a(a2);
            if (object == null) {
                throw new IllegalArgumentException("Unable to deserialize palette tag");
            }
            int2ObjectArrayMap.put(n3, object);
        }
        Object object3 = fy2.m("BlockData");
        object22 = new int[this.x * this.y * this.z];
        n3 = 0;
        for (n2 = 0; n2 < ((Object)object22).length; ++n2) {
            if (n3 >= ((Object)object3).length) {
                throw new IllegalArgumentException("No remaining bytes in BlockData for complete schematic");
            }
            object = gm.a((byte[])object3, n3);
            object22[n2] = object.a;
            n3 += object.b;
        }
        for (n2 = 0; n2 < this.y; ++n2) {
            for (int i2 = 0; i2 < this.z; ++i2) {
                for (int i3 = 0; i3 < this.x; ++i3) {
                    int n4 = (n2 * this.z + i2) * this.x + i3;
                    object3 = (awt)int2ObjectArrayMap.get((int)object22[n4]);
                    if (object3 == null) {
                        throw new IllegalArgumentException("Invalid Palette Index ".concat(String.valueOf(n4)));
                    }
                    this.a[i3][i2][n2] = object3;
                }
            }
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static final class a {
        private static final Pattern a = Pattern.compile("(?<location>(\\w+:)?\\w+)(\\[(?<properties>(\\w+=\\w+,?)+)])?");
        private final nf a;
        private final Map<String, String> a;
        private awt a;

        private a(nf nf2, Map<String, String> map) {
            this.a = nf2;
            this.a = map;
        }

        private static a b(String stringArray) {
            if (!(stringArray = a.matcher((CharSequence)stringArray)).matches()) {
                return null;
            }
            try {
                String string = stringArray.group("location");
                stringArray = stringArray.group("properties");
                string = new nf(string);
                HashMap<String, String> hashMap = new HashMap<String, String>();
                if (stringArray != null) {
                    stringArray = stringArray.split(",");
                    int n2 = stringArray.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        String[] stringArray2 = stringArray[i2].split("=");
                        hashMap.put(stringArray2[0], stringArray2[1]);
                    }
                }
                return new a((nf)string, hashMap);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }

        static /* synthetic */ awt a(a a2) {
            if (a2.a == null) {
                aow aow2 = (aow)aow.h.c((Object)a2.a);
                a2.a = aow2.t();
                a2.a.keySet().stream().sorted(String::compareTo).forEachOrdered(string -> {
                    if ((aow2 = aow2.s().a(string)) != null) {
                        Object object = (String)this.a.get(string);
                        string = aow2;
                        aow2 = this.a;
                        if (!((Optional)(object = string.b((String)object).toJavaUtil())).isPresent()) {
                            throw new IllegalArgumentException("Invalid value for property ".concat(String.valueOf(string)));
                        }
                        this.a = aow2.a((axj)string, (Comparable)((Optional)object).get());
                    }
                });
            }
            return a2.a;
        }
    }
}

