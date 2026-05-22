/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemSword
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.player.move;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSword;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "type", "Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent$SlowDownType;", "<init>", "(Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent$SlowDownType;)V", "getPlayer", "()Lnet/minecraft/client/entity/EntityPlayerSP;", "getType", "()Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent$SlowDownType;", "value", "", "forward", "getForward", "()F", "setForward", "(F)V", "strafe", "getStrafe", "setStrafe", "SlowDownType", "DarkMeow"})
public final class SlowDownEvent
extends CancellableEvent {
    @NotNull
    private final EntityPlayerSP player;
    @NotNull
    private final SlowDownType type;

    public SlowDownEvent(@NotNull EntityPlayerSP player, @NotNull SlowDownType type) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        this.player = player;
        this.type = type;
    }

    @NotNull
    public final EntityPlayerSP getPlayer() {
        return this.player;
    }

    @NotNull
    public final SlowDownType getType() {
        return this.type;
    }

    public final float getForward() {
        return this.player.field_71158_b.field_192832_b;
    }

    public final void setForward(float value) {
        this.player.field_71158_b.field_192832_b = value;
    }

    public final float getStrafe() {
        return this.player.field_71158_b.field_78902_a;
    }

    public final void setStrafe(float value) {
        this.player.field_71158_b.field_78902_a = value;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent$SlowDownType;", "", "<init>", "(Ljava/lang/String;I)V", "BLOCKING", "BOW", "EATING", "Companion", "DarkMeow"})
    public static final class SlowDownType
    extends Enum<SlowDownType> {
        @NotNull
        public static final Companion Companion;
        public static final /* enum */ SlowDownType BLOCKING;
        public static final /* enum */ SlowDownType BOW;
        public static final /* enum */ SlowDownType EATING;
        private static final /* synthetic */ SlowDownType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static SlowDownType[] values() {
            return (SlowDownType[])$VALUES.clone();
        }

        public static SlowDownType valueOf(String value) {
            return Enum.valueOf(SlowDownType.class, value);
        }

        @NotNull
        public static EnumEntries<SlowDownType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        @NotNull
        public static final SlowDownType getSlowDownTypeByItem(@NotNull Item item) {
            return Companion.getSlowDownTypeByItem(item);
        }

        static {
            BLOCKING = new SlowDownType();
            BOW = new SlowDownType();
            EATING = new SlowDownType();
            $VALUES = slowDownTypeArray = new SlowDownType[]{SlowDownType.BLOCKING, SlowDownType.BOW, SlowDownType.EATING};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            Companion = new Companion(null);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent$SlowDownType$Companion;", "", "<init>", "()V", "getSlowDownTypeByItem", "Lnet/ccbluex/liquidbounce/event/events/player/move/SlowDownEvent$SlowDownType;", "item", "Lnet/minecraft/item/Item;", "DarkMeow"})
        public static final class Companion {
            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final SlowDownType getSlowDownTypeByItem(@NotNull Item item) {
                Intrinsics.checkNotNullParameter(item, "item");
                Item item2 = item;
                return item2 instanceof ItemSword || item2 instanceof ItemShield ? BLOCKING : (item2 instanceof ItemBow ? BOW : EATING);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

