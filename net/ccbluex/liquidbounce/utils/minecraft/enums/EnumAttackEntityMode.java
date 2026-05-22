/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.minecraft.enums;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bj\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/utils/minecraft/enums/EnumAttackEntityMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "PACKET", "sendAttack", "", "mc", "Lnet/minecraft/client/Minecraft;", "entity", "Lnet/minecraft/entity/Entity;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nEnumAttackEntityMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumAttackEntityMode.kt\nnet/ccbluex/liquidbounce/utils/minecraft/enums/EnumAttackEntityMode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1#2:26\n*E\n"})
public final class EnumAttackEntityMode
extends Enum<EnumAttackEntityMode> {
    public static final /* enum */ EnumAttackEntityMode NORMAL = new EnumAttackEntityMode();
    public static final /* enum */ EnumAttackEntityMode PACKET = new EnumAttackEntityMode();
    private static final /* synthetic */ EnumAttackEntityMode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public final boolean sendAttack(@NotNull Minecraft mc, @NotNull Entity entity) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(entity, "entity");
        switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                EntityPlayerSP entityPlayerSP = mc.field_71439_g;
                if (entityPlayerSP != null) {
                    EntityPlayerSP entityPlayerSP2;
                    EntityPlayerSP player = entityPlayerSP2 = entityPlayerSP;
                    boolean bl3 = false;
                    mc.field_71442_b.func_78764_a((EntityPlayer)player, entity);
                    EntityPlayerSP it = entityPlayerSP2;
                    boolean bl4 = false;
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 2: {
                NetHandlerPlayClient netHandlerPlayClient = mc.func_147114_u();
                if (netHandlerPlayClient != null) {
                    netHandlerPlayClient.func_147297_a((Packet)new CPacketUseEntity(entity));
                    Unit it = Unit.INSTANCE;
                    boolean bl5 = false;
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return bl2;
    }

    public static EnumAttackEntityMode[] values() {
        return (EnumAttackEntityMode[])$VALUES.clone();
    }

    public static EnumAttackEntityMode valueOf(String value) {
        return Enum.valueOf(EnumAttackEntityMode.class, value);
    }

    @NotNull
    public static EnumEntries<EnumAttackEntityMode> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = enumAttackEntityModeArray = new EnumAttackEntityMode[]{EnumAttackEntityMode.NORMAL, EnumAttackEntityMode.PACKET};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumAttackEntityMode.values().length];
            try {
                nArray[EnumAttackEntityMode.NORMAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumAttackEntityMode.PACKET.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

