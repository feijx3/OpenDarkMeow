/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_11to1_10.storage;

public class ChestedHorseStorage {
    private boolean chested;
    private int liamaStrength;
    private int liamaCarpetColor = -1;
    private int liamaVariant;

    public boolean isChested() {
        return this.chested;
    }

    public void setChested(boolean chested) {
        this.chested = chested;
    }

    public int getLiamaStrength() {
        return this.liamaStrength;
    }

    public void setLiamaStrength(int liamaStrength) {
        this.liamaStrength = liamaStrength;
    }

    public int getLiamaCarpetColor() {
        return this.liamaCarpetColor;
    }

    public void setLiamaCarpetColor(int liamaCarpetColor) {
        this.liamaCarpetColor = liamaCarpetColor;
    }

    public int getLiamaVariant() {
        return this.liamaVariant;
    }

    public void setLiamaVariant(int liamaVariant) {
        this.liamaVariant = liamaVariant;
    }

    public String toString() {
        return ChestedHorseStorage.jvmdowngrader$concat$toString$1(this.chested, this.liamaStrength, this.liamaCarpetColor, this.liamaVariant);
    }

    private static String jvmdowngrader$concat$toString$1(boolean bl2, int n2, int n3, int n4) {
        return "ChestedHorseStorage{chested=" + bl2 + ", liamaStrength=" + n2 + ", liamaCarpetColor=" + n3 + ", liamaVariant=" + n4 + "}";
    }
}

