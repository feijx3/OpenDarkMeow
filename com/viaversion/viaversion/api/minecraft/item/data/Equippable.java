/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="equipmentSlot", type=int.class), @RecordComponents.Value(name="soundEvent", type=Holder.class), @RecordComponents.Value(name="model", type=String.class), @RecordComponents.Value(name="cameraOverlay", type=String.class), @RecordComponents.Value(name="allowedEntities", type=HolderSet.class), @RecordComponents.Value(name="dispensable", type=boolean.class), @RecordComponents.Value(name="swappable", type=boolean.class), @RecordComponents.Value(name="damageOnHurt", type=boolean.class), @RecordComponents.Value(name="equipOnInteract", type=boolean.class), @RecordComponents.Value(name="canBeSheared", type=boolean.class), @RecordComponents.Value(name="shearingSound", type=Holder.class)})
@NestMembers(value={3.class, 2.class, 1.class})
public final class Equippable
extends J_L_Record
implements Rewritable {
    private final int equipmentSlot;
    private final Holder<SoundEvent> soundEvent;
    private final @Nullable String model;
    private final @Nullable String cameraOverlay;
    private final @Nullable HolderSet allowedEntities;
    private final boolean dispensable;
    private final boolean swappable;
    private final boolean damageOnHurt;
    private final boolean equipOnInteract;
    private final boolean canBeSheared;
    private final Holder<SoundEvent> shearingSound;
    public static final Type<Equippable> TYPE1_21_2 = new Type<Equippable>(Equippable.class){

        @Override
        public Equippable read(ByteBuf buffer) {
            int equipmentSlot = Types.VAR_INT.readPrimitive(buffer);
            Object soundEvent = Types.SOUND_EVENT.read(buffer);
            String model = (String)Types.OPTIONAL_STRING.read(buffer);
            String cameraOverlay = (String)Types.OPTIONAL_STRING.read(buffer);
            HolderSet allowedEntities = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(buffer);
            boolean dispensable = buffer.readBoolean();
            boolean swappable = buffer.readBoolean();
            boolean damageOnHurt = buffer.readBoolean();
            return new Equippable(equipmentSlot, (Holder<SoundEvent>)soundEvent, model, cameraOverlay, allowedEntities, dispensable, swappable, damageOnHurt);
        }

        @Override
        public void write(ByteBuf buffer, Equippable value) {
            Types.VAR_INT.writePrimitive(buffer, value.equipmentSlot());
            Types.SOUND_EVENT.write(buffer, value.soundEvent());
            Types.OPTIONAL_STRING.write(buffer, value.model());
            Types.OPTIONAL_STRING.write(buffer, value.cameraOverlay());
            Types.OPTIONAL_HOLDER_SET.write(buffer, value.allowedEntities());
            buffer.writeBoolean(value.dispensable());
            buffer.writeBoolean(value.swappable());
            buffer.writeBoolean(value.damageOnHurt());
        }
    };
    public static final Type<Equippable> TYPE1_21_5 = new Type<Equippable>(Equippable.class){

        @Override
        public Equippable read(ByteBuf buffer) {
            int equipmentSlot = Types.VAR_INT.readPrimitive(buffer);
            Object soundEvent = Types.SOUND_EVENT.read(buffer);
            String model = (String)Types.OPTIONAL_STRING.read(buffer);
            String cameraOverlay = (String)Types.OPTIONAL_STRING.read(buffer);
            HolderSet allowedEntities = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(buffer);
            boolean dispensable = buffer.readBoolean();
            boolean swappable = buffer.readBoolean();
            boolean damageOnHurt = buffer.readBoolean();
            boolean equipOnInteract = buffer.readBoolean();
            return new Equippable(equipmentSlot, (Holder<SoundEvent>)soundEvent, model, cameraOverlay, allowedEntities, dispensable, swappable, damageOnHurt, equipOnInteract);
        }

        @Override
        public void write(ByteBuf buffer, Equippable value) {
            Types.VAR_INT.writePrimitive(buffer, value.equipmentSlot());
            Types.SOUND_EVENT.write(buffer, value.soundEvent());
            Types.OPTIONAL_STRING.write(buffer, value.model());
            Types.OPTIONAL_STRING.write(buffer, value.cameraOverlay());
            Types.OPTIONAL_HOLDER_SET.write(buffer, value.allowedEntities());
            buffer.writeBoolean(value.dispensable());
            buffer.writeBoolean(value.swappable());
            buffer.writeBoolean(value.damageOnHurt());
            buffer.writeBoolean(value.equipOnInteract());
        }
    };
    public static final Type<Equippable> TYPE1_21_6 = new Type<Equippable>(Equippable.class){

        @Override
        public Equippable read(ByteBuf buffer) {
            int equipmentSlot = Types.VAR_INT.readPrimitive(buffer);
            Object soundEvent = Types.SOUND_EVENT.read(buffer);
            String model = (String)Types.OPTIONAL_STRING.read(buffer);
            String cameraOverlay = (String)Types.OPTIONAL_STRING.read(buffer);
            HolderSet allowedEntities = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(buffer);
            boolean dispensable = buffer.readBoolean();
            boolean swappable = buffer.readBoolean();
            boolean damageOnHurt = buffer.readBoolean();
            boolean equipOnInteract = buffer.readBoolean();
            boolean canBeSheared = buffer.readBoolean();
            Object shearingSound = Types.SOUND_EVENT.read(buffer);
            return new Equippable(equipmentSlot, (Holder<SoundEvent>)soundEvent, model, cameraOverlay, allowedEntities, dispensable, swappable, damageOnHurt, equipOnInteract, canBeSheared, (Holder<SoundEvent>)shearingSound);
        }

        @Override
        public void write(ByteBuf buffer, Equippable value) {
            Types.VAR_INT.writePrimitive(buffer, value.equipmentSlot());
            Types.SOUND_EVENT.write(buffer, value.soundEvent());
            Types.OPTIONAL_STRING.write(buffer, value.model());
            Types.OPTIONAL_STRING.write(buffer, value.cameraOverlay());
            Types.OPTIONAL_HOLDER_SET.write(buffer, value.allowedEntities());
            buffer.writeBoolean(value.dispensable());
            buffer.writeBoolean(value.swappable());
            buffer.writeBoolean(value.damageOnHurt());
            buffer.writeBoolean(value.equipOnInteract());
            buffer.writeBoolean(value.canBeSheared());
            Types.SOUND_EVENT.write(buffer, value.shearingSound());
        }
    };

    public Equippable(int equipmentSlot, Holder<SoundEvent> soundEvent, @Nullable String model, @Nullable String cameraOverlay, @Nullable HolderSet allowedEntities, boolean dispensable, boolean swappable, boolean damageOnHurt) {
        this(equipmentSlot, soundEvent, model, cameraOverlay, allowedEntities, dispensable, swappable, damageOnHurt, true);
    }

    public Equippable(int equipmentSlot, Holder<SoundEvent> soundEvent, @Nullable String model, @Nullable String cameraOverlay, @Nullable HolderSet allowedEntities, boolean dispensable, boolean swappable, boolean damageOnHurt, boolean equipOnInteract) {
        this(equipmentSlot, soundEvent, model, cameraOverlay, allowedEntities, dispensable, swappable, damageOnHurt, equipOnInteract, false, Holder.of(false));
    }

    public Equippable(int equipmentSlot, Holder<SoundEvent> soundEvent, @Nullable String model, @Nullable String cameraOverlay, @Nullable HolderSet allowedEntities, boolean dispensable, boolean swappable, boolean damageOnHurt, boolean equipOnInteract, boolean canBeSheared, Holder<SoundEvent> shearingSound) {
        this.equipmentSlot = equipmentSlot;
        this.soundEvent = soundEvent;
        this.model = model;
        this.cameraOverlay = cameraOverlay;
        this.allowedEntities = allowedEntities;
        this.dispensable = dispensable;
        this.swappable = swappable;
        this.damageOnHurt = damageOnHurt;
        this.equipOnInteract = equipOnInteract;
        this.canBeSheared = canBeSheared;
        this.shearingSound = shearingSound;
    }

    @Override
    public Equippable rewrite(UserConnection connection, Protocol<?, ?, ?, ?> protocol, boolean clientbound) {
        Holder<SoundEvent> soundEvent = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, clientbound));
        Holder<SoundEvent> shearingSound = SoundEvent.rewriteHolder(this.shearingSound, Rewritable.soundRewriteFunction(protocol, clientbound));
        HolderSet allowedEntities = this.allowedEntities != null ? this.allowedEntities.rewrite(Rewritable.entityRewriteFunction(protocol, clientbound)) : null;
        return soundEvent == this.soundEvent && shearingSound == this.shearingSound && allowedEntities == this.allowedEntities ? this : new Equippable(this.equipmentSlot, soundEvent, this.model, this.cameraOverlay, allowedEntities, this.dispensable, this.swappable, this.damageOnHurt, this.equipOnInteract, this.canBeSheared, shearingSound);
    }

    @Override
    public final String toString() {
        return Equippable.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return Equippable.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return Equippable.jvmdowngrader$equals$equals(this, o2);
    }

    public int equipmentSlot() {
        return this.equipmentSlot;
    }

    public Holder<SoundEvent> soundEvent() {
        return this.soundEvent;
    }

    public @Nullable String model() {
        return this.model;
    }

    public @Nullable String cameraOverlay() {
        return this.cameraOverlay;
    }

    public @Nullable HolderSet allowedEntities() {
        return this.allowedEntities;
    }

    public boolean dispensable() {
        return this.dispensable;
    }

    public boolean swappable() {
        return this.swappable;
    }

    public boolean damageOnHurt() {
        return this.damageOnHurt;
    }

    public boolean equipOnInteract() {
        return this.equipOnInteract;
    }

    public boolean canBeSheared() {
        return this.canBeSheared;
    }

    public Holder<SoundEvent> shearingSound() {
        return this.shearingSound;
    }

    private static String jvmdowngrader$toString$toString(Equippable equippable) {
        Equippable equippable2 = equippable;
        return "Equippable[" + "equipmentSlot=" + equippable.equipmentSlot + ", " + "soundEvent=" + equippable.soundEvent + ", " + "model=" + equippable.model + ", " + "cameraOverlay=" + equippable.cameraOverlay + ", " + "allowedEntities=" + equippable.allowedEntities + ", " + "dispensable=" + equippable.dispensable + ", " + "swappable=" + equippable.swappable + ", " + "damageOnHurt=" + equippable.damageOnHurt + ", " + "equipOnInteract=" + equippable.equipOnInteract + ", " + "canBeSheared=" + equippable.canBeSheared + ", " + "shearingSound=" + equippable.shearingSound + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(Equippable equippable) {
        Object[] objectArray = new Object[]{equippable.equipmentSlot, equippable.soundEvent, equippable.model, equippable.cameraOverlay, equippable.allowedEntities, equippable.dispensable, equippable.swappable, equippable.damageOnHurt, equippable.equipOnInteract, equippable.canBeSheared, equippable.shearingSound};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(Equippable equippable, Object object) {
        if (equippable == object) {
            return true;
        }
        if (object != null && object instanceof Equippable) {
            Equippable equippable2 = (Equippable)object;
            if (equippable.equipmentSlot == equippable2.equipmentSlot && Objects.equals(equippable.soundEvent, equippable2.soundEvent) && Objects.equals(equippable.model, equippable2.model) && Objects.equals(equippable.cameraOverlay, equippable2.cameraOverlay) && Objects.equals(equippable.allowedEntities, equippable2.allowedEntities) && equippable.dispensable == equippable2.dispensable && equippable.swappable == equippable2.swappable && equippable.damageOnHurt == equippable2.damageOnHurt && equippable.equipOnInteract == equippable2.equipOnInteract && equippable.canBeSheared == equippable2.canBeSheared && Objects.equals(equippable.shearingSound, equippable2.shearingSound)) {
                return true;
            }
        }
        return false;
    }
}

