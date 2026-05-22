/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.GuiConnecting
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.client.multiplayer.WorldClient
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.ui.client.GuiMainMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/utils/ServerDataUtils;", "", "<init>", "()V", "connect", "Lnet/minecraft/client/Minecraft;", "Lnet/minecraft/client/multiplayer/ServerData;", "mc", "DarkMeow"})
public final class ServerDataUtils {
    @NotNull
    public static final ServerDataUtils INSTANCE = new ServerDataUtils();

    private ServerDataUtils() {
    }

    @NotNull
    public final Minecraft connect(@NotNull ServerData $this$connect, @NotNull Minecraft mc) {
        Minecraft minecraft;
        Intrinsics.checkNotNullParameter($this$connect, "<this>");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Minecraft $this$connect_u24lambda_u240 = minecraft = mc;
        boolean bl2 = false;
        WorldClient worldClient = $this$connect_u24lambda_u240.field_71441_e;
        if (worldClient != null) {
            worldClient.func_72882_A();
        }
        $this$connect_u24lambda_u240.func_147108_a((GuiScreen)new GuiConnecting((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()), mc, $this$connect));
        return minecraft;
    }
}

