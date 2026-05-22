/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viabackwards.api.rewriters;

import ViaBackwards.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Arrays;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@Deprecated
@NestMembers(value={SoundData.class})
public abstract class LegacySoundRewriter<T extends BackwardsProtocol<?, ?, ?, ?>>
extends RewriterBase<T> {
    protected final Int2ObjectMap<SoundData> soundRewrites = new Int2ObjectOpenHashMap<SoundData>(64);

    protected LegacySoundRewriter(T protocol) {
        super(protocol);
    }

    public SoundData added(int id, int replacement) {
        return this.added(id, replacement, -1.0f);
    }

    public SoundData added(int id, int replacement, float newPitch) {
        SoundData data = new SoundData(replacement, true, newPitch, true);
        this.soundRewrites.put(id, data);
        return data;
    }

    public SoundData removed(int id) {
        SoundData data = new SoundData(-1, false, -1.0f, false);
        this.soundRewrites.put(id, data);
        return data;
    }

    public int handleSounds(int soundId) {
        int newSoundId = soundId;
        SoundData data = (SoundData)this.soundRewrites.get(soundId);
        if (data != null) {
            return data.replacementSound();
        }
        for (Int2ObjectMap.Entry entry : this.soundRewrites.int2ObjectEntrySet()) {
            if (soundId <= entry.getIntKey()) continue;
            if (((SoundData)entry.getValue()).added()) {
                --newSoundId;
                continue;
            }
            ++newSoundId;
        }
        return newSoundId;
    }

    public boolean hasPitch(int soundId) {
        SoundData data = (SoundData)this.soundRewrites.get(soundId);
        return data != null && data.changePitch();
    }

    public float handlePitch(int soundId) {
        SoundData data = (SoundData)this.soundRewrites.get(soundId);
        return data != null ? data.newPitch() : 1.0f;
    }

    @RecordComponents(value={@RecordComponents.Value(name="replacementSound", type=int.class), @RecordComponents.Value(name="changePitch", type=boolean.class), @RecordComponents.Value(name="newPitch", type=float.class), @RecordComponents.Value(name="added", type=boolean.class)})
    @NestHost(value=LegacySoundRewriter.class)
    public static final class SoundData
    extends J_L_Record {
        private final int replacementSound;
        private final boolean changePitch;
        private final float newPitch;
        private final boolean added;

        public SoundData(int replacementSound, boolean changePitch, float newPitch, boolean added) {
            this.replacementSound = replacementSound;
            this.changePitch = changePitch;
            this.newPitch = newPitch;
            this.added = added;
        }

        @Override
        public final String toString() {
            return SoundData.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return SoundData.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return SoundData.jvmdowngrader$equals$equals(this, o2);
        }

        public int replacementSound() {
            return this.replacementSound;
        }

        public boolean changePitch() {
            return this.changePitch;
        }

        public float newPitch() {
            return this.newPitch;
        }

        public boolean added() {
            return this.added;
        }

        private static String jvmdowngrader$toString$toString(SoundData soundData) {
            SoundData soundData2 = soundData;
            return "LegacySoundRewriter$SoundData[" + "replacementSound=" + soundData.replacementSound + ", " + "changePitch=" + soundData.changePitch + ", " + "newPitch=" + soundData.newPitch + ", " + "added=" + soundData.added + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(SoundData soundData) {
            Object[] objectArray = new Object[]{soundData.replacementSound, soundData.changePitch, Float.valueOf(soundData.newPitch), soundData.added};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(SoundData soundData, Object object) {
            if (soundData == object) {
                return true;
            }
            if (object != null && object instanceof SoundData) {
                SoundData soundData2 = (SoundData)object;
                if (soundData.replacementSound == soundData2.replacementSound && soundData.changePitch == soundData2.changePitch && soundData.newPitch == soundData2.newPitch && soundData.added == soundData2.added) {
                    return true;
                }
            }
            return false;
        }
    }
}

