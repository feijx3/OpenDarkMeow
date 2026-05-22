/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import java.util.Arrays;

public final class ArrayUtil {
    public static <T> T[] add(T[] array, T element) {
        int length = array.length;
        T[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = element;
        return newArray;
    }

    @SafeVarargs
    public static <T> T[] add(T[] array, T ... elements) {
        int length = array.length;
        T[] newArray = Arrays.copyOf(array, length + elements.length);
        System.arraycopy(elements, 0, newArray, length, elements.length);
        return newArray;
    }

    public static <T> T[] remove(T[] array, int index) {
        T[] newArray = Arrays.copyOf(array, array.length - 1);
        System.arraycopy(array, index + 1, newArray, index, newArray.length - index);
        return newArray;
    }

    public static Float[] boxedArray(float[] array) {
        Float[] boxedArray = new Float[array.length];
        for (int i2 = 0; i2 < array.length; ++i2) {
            boxedArray[i2] = Float.valueOf(array[i2]);
        }
        return boxedArray;
    }

    public static Integer[] boxedArray(int[] array) {
        Integer[] boxedArray = new Integer[array.length];
        for (int i2 = 0; i2 < array.length; ++i2) {
            boxedArray[i2] = array[i2];
        }
        return boxedArray;
    }

    public static Boolean[] boxedArray(boolean[] array) {
        Boolean[] boxedArray = new Boolean[array.length];
        for (int i2 = 0; i2 < array.length; ++i2) {
            boxedArray[i2] = array[i2];
        }
        return boxedArray;
    }
}

