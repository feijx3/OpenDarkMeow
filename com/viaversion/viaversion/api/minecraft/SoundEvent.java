/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="identifier", type=String.class), @RecordComponents.Value(name="fixedRange", type=Float.class)})
public final class SoundEvent
extends J_L_Record {
    private final String identifier;
    private final @Nullable Float fixedRange;
    private static final Holder<SoundEvent> UNKNOWN = Holder.of(new SoundEvent("viaversion:unknown", Float.valueOf(0.0f)));

    public SoundEvent(String identifier, @Nullable Float fixedRange) {
        this.identifier = identifier;
        this.fixedRange = fixedRange;
    }

    public SoundEvent withIdentifier(String identifier) {
        return new SoundEvent(identifier, this.fixedRange);
    }

    public static @Nullable Holder<SoundEvent> rewriteHolder(@Nullable Holder<SoundEvent> holder, Int2IntFunction soundRewriteFunction) {
        if (holder == null) {
            return null;
        }
        return holder.updateId(soundRewriteFunction, () -> UNKNOWN);
    }

    @Override
    public final String toString() {
        return SoundEvent.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return SoundEvent.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return SoundEvent.jvmdowngrader$equals$equals(this, o2);
    }

    public String identifier() {
        return this.identifier;
    }

    public @Nullable Float fixedRange() {
        return this.fixedRange;
    }

    private static String jvmdowngrader$toString$toString(SoundEvent soundEvent) {
        SoundEvent soundEvent2 = soundEvent;
        return "SoundEvent[" + "identifier=" + soundEvent.identifier + ", " + "fixedRange=" + soundEvent.fixedRange + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(SoundEvent soundEvent) {
        Object[] objectArray = new Object[]{soundEvent.identifier, soundEvent.fixedRange};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(SoundEvent soundEvent, Object object) {
        if (soundEvent == object) {
            return true;
        }
        if (object != null && object instanceof SoundEvent) {
            SoundEvent soundEvent2 = (SoundEvent)object;
            if (Objects.equals(soundEvent.identifier, soundEvent2.identifier) && Objects.equals(soundEvent.fixedRange, soundEvent2.fixedRange)) {
                return true;
            }
        }
        return false;
    }
}

