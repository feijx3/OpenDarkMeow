/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.gson.JsonElement;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="url", type=String.class), @RecordComponents.Value(name="hash", type=String.class), @RecordComponents.Value(name="required", type=boolean.class), @RecordComponents.Value(name="prompt", type=JsonElement.class)})
public final class LastResourcePack
extends J_L_Record
implements StorableObject {
    private final String url;
    private final String hash;
    private final boolean required;
    private final @Nullable JsonElement prompt;

    public LastResourcePack(String url, String hash, boolean required, @Nullable JsonElement prompt) {
        this.url = url;
        this.hash = hash;
        this.required = required;
        this.prompt = prompt;
    }

    @Override
    public final String toString() {
        return LastResourcePack.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return LastResourcePack.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return LastResourcePack.jvmdowngrader$equals$equals(this, o2);
    }

    public String url() {
        return this.url;
    }

    public String hash() {
        return this.hash;
    }

    public boolean required() {
        return this.required;
    }

    public @Nullable JsonElement prompt() {
        return this.prompt;
    }

    private static String jvmdowngrader$toString$toString(LastResourcePack lastResourcePack) {
        LastResourcePack lastResourcePack2 = lastResourcePack;
        return "LastResourcePack[" + "url=" + lastResourcePack.url + ", " + "hash=" + lastResourcePack.hash + ", " + "required=" + lastResourcePack.required + ", " + "prompt=" + lastResourcePack.prompt + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(LastResourcePack lastResourcePack) {
        Object[] objectArray = new Object[]{lastResourcePack.url, lastResourcePack.hash, lastResourcePack.required, lastResourcePack.prompt};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(LastResourcePack lastResourcePack, Object object) {
        if (lastResourcePack == object) {
            return true;
        }
        if (object != null && object instanceof LastResourcePack) {
            LastResourcePack lastResourcePack2 = (LastResourcePack)object;
            if (Objects.equals(lastResourcePack.url, lastResourcePack2.url) && Objects.equals(lastResourcePack.hash, lastResourcePack2.hash) && lastResourcePack.required == lastResourcePack2.required && Objects.equals(lastResourcePack.prompt, lastResourcePack2.prompt)) {
                return true;
            }
        }
        return false;
    }
}

