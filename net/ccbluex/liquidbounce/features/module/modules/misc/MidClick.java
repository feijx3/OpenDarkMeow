/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Mouse
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render2DEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.file.impl.FriendsConfig;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;

@ModuleInfo(name="MidClick", description="Allows you to add a player as a friend by right clicking him.", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/MidClick;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "wasDown", "", "onRender", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "DarkMeow"})
public final class MidClick
extends Module {
    private boolean wasDown;

    public MidClick() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onRender(@Nullable Render2DEvent event) {
        if (MinecraftInstance.mc.getCurrentScreen() != null) {
            return;
        }
        if (!this.wasDown && Mouse.isButtonDown((int)2)) {
            RayTraceResult rayTraceResult = MinecraftInstance.mc.getObjectMouseOver();
            Intrinsics.checkNotNull(rayTraceResult);
            Entity entity = rayTraceResult.field_72308_g;
            if (entity instanceof EntityPlayer) {
                String string = ColorUtils.stripColor(((EntityPlayer)entity).func_70005_c_());
                if (string == null) {
                    return;
                }
                String playerName = string;
                FriendsConfig friendsConfig = DarkMeow.INSTANCE.getFileManager().getFriendsConfig();
                if (!friendsConfig.isFriend(playerName)) {
                    FriendsConfig.addFriend$default(friendsConfig, playerName, null, 2, null);
                    DarkMeow.INSTANCE.getFileManager().saveConfig(friendsConfig);
                    ClientUtils.displayChatMessage("\u00a7a\u00a7l" + playerName + "\u00a7c was added to your friends.");
                } else {
                    friendsConfig.removeFriend(playerName);
                    DarkMeow.INSTANCE.getFileManager().saveConfig(friendsConfig);
                    ClientUtils.displayChatMessage("\u00a7a\u00a7l" + playerName + "\u00a7c was removed from your friends.");
                }
            } else {
                ClientUtils.displayChatMessage("\u00a7c\u00a7lError: \u00a7aYou need to select a player.");
            }
        }
        this.wasDown = Mouse.isButtonDown((int)2);
    }
}

