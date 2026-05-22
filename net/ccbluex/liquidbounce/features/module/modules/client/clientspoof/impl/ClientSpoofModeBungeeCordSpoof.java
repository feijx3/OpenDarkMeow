/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.EnumConnectionState
 *  net.minecraft.network.Packet
 *  net.minecraft.util.Session
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.clientspoof.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.modules.client.clientspoof.ClientSpoofMode;
import net.ccbluex.liquidbounce.injection.access.network.AccessorC00Handshake;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.Packet;
import net.minecraft.util.Session;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/clientspoof/impl/ClientSpoofModeBungeeCordSpoof;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/clientspoof/ClientSpoofMode;", "<init>", "()V", "bungeeCordSpoofIPValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
public final class ClientSpoofModeBungeeCordSpoof
extends ClientSpoofMode {
    @NotNull
    private final TextValue bungeeCordSpoofIPValue = new TextValue(this.getValuePrefix() + "IP", "10.1.1.1");

    public ClientSpoofModeBungeeCordSpoof() {
        super("BungeeCordSpoof");
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Session session = MinecraftInstance.mc.getSession();
        if (session == null) {
            return;
        }
        Session session2 = session;
        Packet<?> packet = event.getPacket();
        if (packet instanceof AccessorC00Handshake) {
            EnumConnectionState enumConnectionState = ((AccessorC00Handshake)packet).func_149594_c();
            if ((enumConnectionState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[enumConnectionState.ordinal()]) == 1) {
                AccessorC00Handshake accessorC00Handshake = (AccessorC00Handshake)packet;
                StringBuilder stringBuilder = new StringBuilder().append(((AccessorC00Handshake)packet).getIp()).append('\u0000').append((String)this.bungeeCordSpoofIPValue.get()).append('\u0000');
                String string = session2.func_148255_b();
                Intrinsics.checkNotNullExpressionValue(string, "getPlayerID(...)");
                accessorC00Handshake.setIp(stringBuilder.append(StringsKt.replace$default(string, "-", "", false, 4, null)).toString());
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumConnectionState.values().length];
            try {
                nArray[EnumConnectionState.HANDSHAKING.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

