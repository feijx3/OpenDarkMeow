/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  awt
 *  fy
 */
package baritone;

import baritone.ge;

public final class gk
extends ge {
    public gk(fy object) {
        int n2;
        Object object2 = object.l("Materials");
        if (!((String)object2).equals("Alpha")) {
            throw new IllegalStateException("bad schematic ".concat(String.valueOf(object2)));
        }
        this.x = object.h("Width");
        this.y = object.h("Height");
        this.z = object.h("Length");
        object2 = object.m("Blocks");
        byte[] byArray = object.m("Data");
        byte[] byArray2 = null;
        if (object.e("AddBlocks")) {
            byte[] byArray3 = object.m("AddBlocks");
            object = byArray3;
            byArray2 = new byte[byArray3.length << 1];
            for (n2 = 0; n2 < ((fy)object).length; ++n2) {
                byArray2[n2 << 1] = (byte)(object[n2] >> 4 & 0xF);
                byArray2[(n2 << 1) + 1] = (byte)(object[n2] & 0xF);
            }
        }
        this.a = new awt[this.x][this.z][this.y];
        for (int i2 = 0; i2 < this.y; ++i2) {
            for (n2 = 0; n2 < this.z; ++n2) {
                for (int i3 = 0; i3 < this.x; ++i3) {
                    int n3 = (i2 * this.z + n2) * this.x + i3;
                    int n4 = object2[n3] & 0xFF;
                    if (byArray2 != null) {
                        n4 |= byArray2[n3] << 8;
                    }
                    aow aow2 = (aow)aow.h.a(n4);
                    n3 = byArray[n3] & 0xFF;
                    this.a[i3][n2][i2] = aow2.a(n3);
                }
            }
        }
    }
}

