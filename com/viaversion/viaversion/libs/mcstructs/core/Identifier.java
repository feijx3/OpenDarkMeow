/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.core;

import lombok.Generated;

public class Identifier {
    public static final String DEFAULT_NAMESPACE = "minecraft";
    public static final String VALID_KEY_CHARS = "[_\\-a-z0-9.]*";
    public static final String VALID_VALUE_CHARS = "[_\\-a-z0-9/.]*";
    private final String key;
    private final String value;

    public static Identifier defaultNamespace(String value) {
        return Identifier.of(DEFAULT_NAMESPACE, value);
    }

    public static Identifier of(String value) {
        int splitIndex = value.indexOf(58);
        String key = splitIndex <= 0 ? DEFAULT_NAMESPACE : value.substring(0, splitIndex);
        String val = splitIndex == -1 ? value : value.substring(splitIndex + 1);
        return Identifier.of(key, val);
    }

    public static Identifier tryOf(String value) {
        try {
            return Identifier.of(value);
        }
        catch (Throwable t2) {
            return null;
        }
    }

    public static Identifier of(String key, String value) {
        return new Identifier(key, value);
    }

    private Identifier(String key, String value) {
        if (!key.matches(VALID_KEY_CHARS)) {
            throw new IllegalArgumentException("Key contains illegal chars");
        }
        if (!value.matches(VALID_VALUE_CHARS)) {
            throw new IllegalArgumentException("Value contains illegal chars");
        }
        this.key = key;
        this.value = value;
    }

    public String get() {
        return this.key + ":" + this.value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(String key, String value) {
        return this.key.equals(key) && this.value.equals(value);
    }

    public String toString() {
        return this.get();
    }

    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof Identifier)) {
            return false;
        }
        Identifier other = (Identifier)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$key = this.getKey();
        String other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        String this$value = this.getValue();
        String other$value = other.getValue();
        return !(this$value == null ? other$value != null : !this$value.equals(other$value));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Identifier;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $key = this.getKey();
        result = result * 59 + ($key == null ? 43 : $key.hashCode());
        String $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        return result;
    }
}

