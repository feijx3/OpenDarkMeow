/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.minecraft.enums;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/utils/minecraft/enums/EnumAnimationMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "PACKET", "NONE", "sendAnimation", "", "mc", "Lnet/minecraft/client/Minecraft;", "hand", "Lnet/minecraft/util/EnumHand;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nEnumAnimationMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumAnimationMode.kt\nnet/ccbluex/liquidbounce/utils/minecraft/enums/EnumAnimationMode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class EnumAnimationMode
extends Enum<EnumAnimationMode> {
    public static final /* enum */ EnumAnimationMode NORMAL = new EnumAnimationMode();
    public static final /* enum */ EnumAnimationMode PACKET = new EnumAnimationMode();
    public static final /* enum */ EnumAnimationMode NONE = new EnumAnimationMode();
    private static final /* synthetic */ EnumAnimationMode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    @JvmOverloads
    public final boolean sendAnimation(@NotNull Minecraft mc, @NotNull EnumHand hand) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(hand, "hand");
        switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                EntityPlayerSP entityPlayerSP = mc.field_71439_g;
                if (entityPlayerSP != null) {
                    entityPlayerSP.func_184609_a(hand);
                    Unit it = Unit.INSTANCE;
                    boolean bl3 = false;
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 2: {
                NetHandlerPlayClient netHandlerPlayClient = mc.func_147114_u();
                if (netHandlerPlayClient != null) {
                    netHandlerPlayClient.func_147297_a((Packet)new CPacketAnimation(hand));
                    Unit it = Unit.INSTANCE;
                    boolean bl4 = false;
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 3: {
                bl2 = true;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return bl2;
    }

    public static /* synthetic */ boolean sendAnimation$default(EnumAnimationMode enumAnimationMode, Minecraft minecraft, EnumHand enumHand, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendAnimation");
        }
        if ((n2 & 2) != 0) {
            enumHand = EnumHand.MAIN_HAND;
        }
        return enumAnimationMode.sendAnimation(minecraft, enumHand);
    }

    public static EnumAnimationMode[] values() {
        return (EnumAnimationMode[])$VALUES.clone();
    }

    public static EnumAnimationMode valueOf(String value) {
        return Enum.valueOf(EnumAnimationMode.class, value);
    }

    @NotNull
    public static EnumEntries<EnumAnimationMode> getEntries() {
        return $ENTRIES;
    }

    @JvmOverloads
    public final boolean sendAnimation(@NotNull Minecraft mc) {
        Intrinsics.checkNotNullParameter(mc, "mc");
        return EnumAnimationMode.sendAnimation$default(this, mc, null, 2, null);
    }

    static {
        $VALUES = enumAnimationModeArray = new EnumAnimationMode[]{EnumAnimationMode.NORMAL, EnumAnimationMode.PACKET, EnumAnimationMode.NONE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumAnimationMode.values().length];
            try {
                nArray[EnumAnimationMode.NORMAL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumAnimationMode.PACKET.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumAnimationMode.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

