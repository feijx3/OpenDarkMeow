/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import java.util.Objects;

public class IdAndData {
    private int id;
    private byte data;

    public IdAndData(int id) {
        this.id = id;
        this.data = (byte)-1;
    }

    public IdAndData(int id, int data) {
        Preconditions.checkArgument((data >= 0 && data <= 15 ? 1 : 0) != 0, (Object)IdAndData.jvmdowngrader$concat$$init$$1(id, data));
        this.id = id;
        this.data = (byte)data;
    }

    public static int getId(int rawData) {
        return rawData >> 4;
    }

    public static int getData(int rawData) {
        return rawData & 0xF;
    }

    public static int toRawData(int id) {
        return id << 4;
    }

    public static int removeData(int data) {
        return data & 0xFFFFFFF0;
    }

    public static IdAndData fromRawData(int rawData) {
        return new IdAndData(rawData >> 4, rawData & 0xF);
    }

    public static int toRawData(int id, int data) {
        return id << 4 | data & 0xF;
    }

    public int toRawData() {
        return IdAndData.toRawData(this.id, this.data);
    }

    public IdAndData withData(int data) {
        return new IdAndData(this.id, data);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = (byte)data;
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        IdAndData idAndData = (IdAndData)o2;
        return this.id == idAndData.id && this.data == idAndData.data;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.data);
    }

    public String toString() {
        return IdAndData.jvmdowngrader$concat$toString$1(this.id, this.data);
    }

    private static String jvmdowngrader$concat$$init$$1(int n2, int n3) {
        return "Data has to be between 0 and 15: (id: " + n2 + " data: " + n3 + ")";
    }

    private static String jvmdowngrader$concat$toString$1(int n2, byte by2) {
        return "IdAndData{id=" + n2 + ", data=" + by2 + "}";
    }
}

