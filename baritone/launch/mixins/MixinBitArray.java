/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  qw
 */
package baritone.launch.mixins;

import baritone.fk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={qw.class})
public abstract class MixinBitArray
implements fk {
    @Shadow
    @Final
    private long[] a;
    @Shadow
    @Final
    private int b;
    @Shadow
    @Final
    private long c;
    @Shadow
    @Final
    private int d;

    @Override
    @Unique
    public int[] toArray() {
        int[] nArray = new int[this.d];
        int n2 = 0;
        int n3 = this.b - 1;
        while (n2 < this.d) {
            int n4 = n2 * this.b;
            int n5 = n4 >> 6;
            int n6 = n3 >> 6;
            long l2 = this.a[n5] >>> (n4 &= 0x3F);
            nArray[n2] = n5 == n6 ? (int)(l2 & this.c) : (int)((l2 | this.a[n6] << 64 - n4) & this.c);
            ++n2;
            n3 += this.b;
        }
        return nArray;
    }

    @Override
    public long getMaxEntryValue() {
        return this.c;
    }

    @Override
    public int getBitsPerEntry() {
        return this.b;
    }
}

