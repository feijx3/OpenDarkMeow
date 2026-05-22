/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal;

import java.util.ArrayList;
import net.darkmeow.irc.lib.io.netty.util.internal.ObjectUtil;

public final class AdaptiveCalculator {
    private static final int INDEX_INCREMENT = 4;
    private static final int INDEX_DECREMENT = 1;
    private static final int[] SIZE_TABLE;
    private final int minIndex;
    private final int maxIndex;
    private final int minCapacity;
    private final int maxCapacity;
    private int index;
    private int nextSize;
    private boolean decreaseNow;

    private static int getSizeTableIndex(int size) {
        int a2;
        int mid;
        int low = 0;
        int high = SIZE_TABLE.length - 1;
        while (true) {
            if (high < low) {
                return low;
            }
            if (high == low) {
                return high;
            }
            mid = low + high >>> 1;
            a2 = SIZE_TABLE[mid];
            int b2 = SIZE_TABLE[mid + 1];
            if (size > b2) {
                low = mid + 1;
                continue;
            }
            if (size >= a2) break;
            high = mid - 1;
        }
        if (size == a2) {
            return mid;
        }
        return mid + 1;
    }

    public AdaptiveCalculator(int minimum, int initial, int maximum) {
        ObjectUtil.checkPositive(minimum, "minimum");
        if (initial < minimum) {
            throw new IllegalArgumentException("initial: " + initial);
        }
        if (maximum < initial) {
            throw new IllegalArgumentException("maximum: " + maximum);
        }
        int minIndex = AdaptiveCalculator.getSizeTableIndex(minimum);
        this.minIndex = SIZE_TABLE[minIndex] < minimum ? minIndex + 1 : minIndex;
        int maxIndex = AdaptiveCalculator.getSizeTableIndex(maximum);
        this.maxIndex = SIZE_TABLE[maxIndex] > maximum ? maxIndex - 1 : maxIndex;
        int initialIndex = AdaptiveCalculator.getSizeTableIndex(initial);
        this.index = SIZE_TABLE[initialIndex] > initial ? initialIndex - 1 : initialIndex;
        this.minCapacity = minimum;
        this.maxCapacity = maximum;
        this.nextSize = Math.max(SIZE_TABLE[this.index], this.minCapacity);
    }

    public void record(int size) {
        if (size <= SIZE_TABLE[Math.max(0, this.index - 1)]) {
            if (this.decreaseNow) {
                this.index = Math.max(this.index - 1, this.minIndex);
                this.nextSize = Math.max(SIZE_TABLE[this.index], this.minCapacity);
                this.decreaseNow = false;
            } else {
                this.decreaseNow = true;
            }
        } else if (size >= this.nextSize) {
            this.index = Math.min(this.index + 4, this.maxIndex);
            this.nextSize = Math.min(SIZE_TABLE[this.index], this.maxCapacity);
            this.decreaseNow = false;
        }
    }

    public int nextSize() {
        return this.nextSize;
    }

    static {
        int i2;
        ArrayList<Integer> sizeTable = new ArrayList<Integer>();
        for (i2 = 16; i2 < 512; i2 += 16) {
            sizeTable.add(i2);
        }
        for (i2 = 512; i2 > 0; i2 <<= 1) {
            sizeTable.add(i2);
        }
        SIZE_TABLE = new int[sizeTable.size()];
        for (i2 = 0; i2 < SIZE_TABLE.length; ++i2) {
            AdaptiveCalculator.SIZE_TABLE[i2] = (Integer)sizeTable.get(i2);
        }
    }
}

