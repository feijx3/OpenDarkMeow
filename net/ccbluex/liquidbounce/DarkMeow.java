/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ClientShutdownEvent;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.manager.BaritoneManager;
import net.ccbluex.liquidbounce.features.manager.ClickGuiManager;
import net.ccbluex.liquidbounce.features.module.ModuleManager;
import net.ccbluex.liquidbounce.file.FileConfig;
import net.ccbluex.liquidbounce.file.FileManager;
import net.ccbluex.liquidbounce.file.config.ConfigManager;
import net.ccbluex.liquidbounce.handler.combat.CombatManager;
import net.ccbluex.liquidbounce.handler.language.LanguageManager;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.ccbluex.liquidbounce.handler.movement.MovementManager;
import net.ccbluex.liquidbounce.handler.network.NetworkManager;
import net.ccbluex.liquidbounce.handler.rotation.RotationManager;
import net.ccbluex.liquidbounce.handler.update.UpdateManager;
import net.ccbluex.liquidbounce.handler.visual.VisualManager;
import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.HUDManager;
import net.ccbluex.liquidbounce.ui.client.keybind.KeyBindManager;
import net.ccbluex.liquidbounce.ui.font.Fonts;
import net.ccbluex.liquidbounce.ui.sound.TipSoundManager;
import net.ccbluex.liquidbounce.utils.file.ClientInfoUtils;
import net.darkmeow.darkmeow.commands.CommandManager;
import net.darkmeow.darkmeow.manager.inventory.InventoryManager;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.ShaderUpdateManager;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\n\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0002J\n\u0010\u0084\u0001\u001a\u00030\u0082\u0001H\u0002J\b\u0010\u0085\u0001\u001a\u00030\u0082\u0001J\u0013\u0010\u0086\u0001\u001a\u00030\u0082\u00012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\rR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020FX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020RX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020XX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020^X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020pX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020vX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001b\u0010{\u001a\u00020|X\u0086.\u00a2\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001\u00a8\u0006\u0088\u0001"}, d2={"Lnet/ccbluex/liquidbounce/DarkMeow;", "", "<init>", "()V", "mc", "Lnet/minecraft/client/Minecraft;", "CLIENT_NAME", "", "getCLIENT_NAME", "()Ljava/lang/String;", "CLIENT_VERSION", "getCLIENT_VERSION", "isDestroy", "", "isStarting", "languageManager", "Lnet/ccbluex/liquidbounce/handler/language/LanguageManager;", "getLanguageManager", "()Lnet/ccbluex/liquidbounce/handler/language/LanguageManager;", "setLanguageManager", "(Lnet/ccbluex/liquidbounce/handler/language/LanguageManager;)V", "baritoneManager", "Lnet/ccbluex/liquidbounce/features/manager/BaritoneManager;", "getBaritoneManager", "()Lnet/ccbluex/liquidbounce/features/manager/BaritoneManager;", "setBaritoneManager", "(Lnet/ccbluex/liquidbounce/features/manager/BaritoneManager;)V", "moduleManager", "Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "getModuleManager", "()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "setModuleManager", "(Lnet/ccbluex/liquidbounce/features/module/ModuleManager;)V", "commandManager", "Lnet/darkmeow/darkmeow/commands/CommandManager;", "getCommandManager", "()Lnet/darkmeow/darkmeow/commands/CommandManager;", "setCommandManager", "(Lnet/darkmeow/darkmeow/commands/CommandManager;)V", "eventManager", "Lnet/ccbluex/liquidbounce/event/EventManager;", "getEventManager", "()Lnet/ccbluex/liquidbounce/event/EventManager;", "setEventManager", "(Lnet/ccbluex/liquidbounce/event/EventManager;)V", "fileManager", "Lnet/ccbluex/liquidbounce/file/FileManager;", "getFileManager", "()Lnet/ccbluex/liquidbounce/file/FileManager;", "setFileManager", "(Lnet/ccbluex/liquidbounce/file/FileManager;)V", "combatManager", "Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "getCombatManager", "()Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;", "setCombatManager", "(Lnet/ccbluex/liquidbounce/handler/combat/CombatManager;)V", "tipSoundManager", "Lnet/ccbluex/liquidbounce/ui/sound/TipSoundManager;", "getTipSoundManager", "()Lnet/ccbluex/liquidbounce/ui/sound/TipSoundManager;", "setTipSoundManager", "(Lnet/ccbluex/liquidbounce/ui/sound/TipSoundManager;)V", "configManager", "Lnet/ccbluex/liquidbounce/file/config/ConfigManager;", "getConfigManager", "()Lnet/ccbluex/liquidbounce/file/config/ConfigManager;", "setConfigManager", "(Lnet/ccbluex/liquidbounce/file/config/ConfigManager;)V", "keyBindManager", "Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyBindManager;", "getKeyBindManager", "()Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyBindManager;", "setKeyBindManager", "(Lnet/ccbluex/liquidbounce/ui/client/keybind/KeyBindManager;)V", "visualManager", "Lnet/ccbluex/liquidbounce/handler/visual/VisualManager;", "getVisualManager", "()Lnet/ccbluex/liquidbounce/handler/visual/VisualManager;", "setVisualManager", "(Lnet/ccbluex/liquidbounce/handler/visual/VisualManager;)V", "clickGuiManager", "Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "getClickGuiManager", "()Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;", "setClickGuiManager", "(Lnet/ccbluex/liquidbounce/features/manager/ClickGuiManager;)V", "rotationManager", "Lnet/ccbluex/liquidbounce/handler/rotation/RotationManager;", "getRotationManager", "()Lnet/ccbluex/liquidbounce/handler/rotation/RotationManager;", "setRotationManager", "(Lnet/ccbluex/liquidbounce/handler/rotation/RotationManager;)V", "movementManager", "Lnet/ccbluex/liquidbounce/handler/movement/MovementManager;", "getMovementManager", "()Lnet/ccbluex/liquidbounce/handler/movement/MovementManager;", "setMovementManager", "(Lnet/ccbluex/liquidbounce/handler/movement/MovementManager;)V", "messageManager", "Lnet/ccbluex/liquidbounce/handler/message/MessageManager;", "getMessageManager", "()Lnet/ccbluex/liquidbounce/handler/message/MessageManager;", "setMessageManager", "(Lnet/ccbluex/liquidbounce/handler/message/MessageManager;)V", "updateManager", "Lnet/ccbluex/liquidbounce/handler/update/UpdateManager;", "getUpdateManager", "()Lnet/ccbluex/liquidbounce/handler/update/UpdateManager;", "setUpdateManager", "(Lnet/ccbluex/liquidbounce/handler/update/UpdateManager;)V", "networkManager", "Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;", "getNetworkManager", "()Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;", "setNetworkManager", "(Lnet/ccbluex/liquidbounce/handler/network/NetworkManager;)V", "inventoryManager", "Lnet/darkmeow/darkmeow/manager/inventory/InventoryManager;", "getInventoryManager", "()Lnet/darkmeow/darkmeow/manager/inventory/InventoryManager;", "setInventoryManager", "(Lnet/darkmeow/darkmeow/manager/inventory/InventoryManager;)V", "hudManager", "Lnet/ccbluex/liquidbounce/ui/client/hud/HUDManager;", "getHudManager", "()Lnet/ccbluex/liquidbounce/ui/client/hud/HUDManager;", "setHudManager", "(Lnet/ccbluex/liquidbounce/ui/client/hud/HUDManager;)V", "startClient", "", "loadGui", "loadConfigs", "stopClient", "destroyClient", "gc", "DarkMeow"})
public final class DarkMeow {
    @NotNull
    public static final DarkMeow INSTANCE = new DarkMeow();
    @JvmField
    @NotNull
    public static final Minecraft mc;
    @NotNull
    private static final String CLIENT_NAME;
    @NotNull
    private static final String CLIENT_VERSION;
    @JvmField
    public static boolean isDestroy;
    @JvmField
    public static boolean isStarting;
    public static LanguageManager languageManager;
    public static BaritoneManager baritoneManager;
    public static ModuleManager moduleManager;
    public static CommandManager commandManager;
    public static EventManager eventManager;
    public static FileManager fileManager;
    public static CombatManager combatManager;
    public static TipSoundManager tipSoundManager;
    public static ConfigManager configManager;
    public static KeyBindManager keyBindManager;
    public static VisualManager visualManager;
    public static ClickGuiManager clickGuiManager;
    public static RotationManager rotationManager;
    public static MovementManager movementManager;
    public static MessageManager messageManager;
    public static UpdateManager updateManager;
    public static NetworkManager networkManager;
    public static InventoryManager inventoryManager;
    public static HUDManager hudManager;

    private DarkMeow() {
    }

    @NotNull
    public final String getCLIENT_NAME() {
        return CLIENT_NAME;
    }

    @NotNull
    public final String getCLIENT_VERSION() {
        return CLIENT_VERSION;
    }

    @NotNull
    public final LanguageManager getLanguageManager() {
        LanguageManager languageManager = DarkMeow.languageManager;
        if (languageManager != null) {
            return languageManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("languageManager");
        return null;
    }

    public final void setLanguageManager(@NotNull LanguageManager languageManager) {
        Intrinsics.checkNotNullParameter(languageManager, "<set-?>");
        DarkMeow.languageManager = languageManager;
    }

    @NotNull
    public final BaritoneManager getBaritoneManager() {
        BaritoneManager baritoneManager = DarkMeow.baritoneManager;
        if (baritoneManager != null) {
            return baritoneManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baritoneManager");
        return null;
    }

    public final void setBaritoneManager(@NotNull BaritoneManager baritoneManager) {
        Intrinsics.checkNotNullParameter(baritoneManager, "<set-?>");
        DarkMeow.baritoneManager = baritoneManager;
    }

    @NotNull
    public final ModuleManager getModuleManager() {
        ModuleManager moduleManager = DarkMeow.moduleManager;
        if (moduleManager != null) {
            return moduleManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("moduleManager");
        return null;
    }

    public final void setModuleManager(@NotNull ModuleManager moduleManager) {
        Intrinsics.checkNotNullParameter(moduleManager, "<set-?>");
        DarkMeow.moduleManager = moduleManager;
    }

    @NotNull
    public final CommandManager getCommandManager() {
        CommandManager commandManager = DarkMeow.commandManager;
        if (commandManager != null) {
            return commandManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("commandManager");
        return null;
    }

    public final void setCommandManager(@NotNull CommandManager commandManager) {
        Intrinsics.checkNotNullParameter(commandManager, "<set-?>");
        DarkMeow.commandManager = commandManager;
    }

    @NotNull
    public final EventManager getEventManager() {
        EventManager eventManager = DarkMeow.eventManager;
        if (eventManager != null) {
            return eventManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventManager");
        return null;
    }

    public final void setEventManager(@NotNull EventManager eventManager) {
        Intrinsics.checkNotNullParameter(eventManager, "<set-?>");
        DarkMeow.eventManager = eventManager;
    }

    @NotNull
    public final FileManager getFileManager() {
        FileManager fileManager = DarkMeow.fileManager;
        if (fileManager != null) {
            return fileManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fileManager");
        return null;
    }

    public final void setFileManager(@NotNull FileManager fileManager) {
        Intrinsics.checkNotNullParameter(fileManager, "<set-?>");
        DarkMeow.fileManager = fileManager;
    }

    @NotNull
    public final CombatManager getCombatManager() {
        CombatManager combatManager = DarkMeow.combatManager;
        if (combatManager != null) {
            return combatManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("combatManager");
        return null;
    }

    public final void setCombatManager(@NotNull CombatManager combatManager) {
        Intrinsics.checkNotNullParameter(combatManager, "<set-?>");
        DarkMeow.combatManager = combatManager;
    }

    @NotNull
    public final TipSoundManager getTipSoundManager() {
        TipSoundManager tipSoundManager = DarkMeow.tipSoundManager;
        if (tipSoundManager != null) {
            return tipSoundManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tipSoundManager");
        return null;
    }

    public final void setTipSoundManager(@NotNull TipSoundManager tipSoundManager) {
        Intrinsics.checkNotNullParameter(tipSoundManager, "<set-?>");
        DarkMeow.tipSoundManager = tipSoundManager;
    }

    @NotNull
    public final ConfigManager getConfigManager() {
        ConfigManager configManager = DarkMeow.configManager;
        if (configManager != null) {
            return configManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configManager");
        return null;
    }

    public final void setConfigManager(@NotNull ConfigManager configManager) {
        Intrinsics.checkNotNullParameter(configManager, "<set-?>");
        DarkMeow.configManager = configManager;
    }

    @NotNull
    public final KeyBindManager getKeyBindManager() {
        KeyBindManager keyBindManager = DarkMeow.keyBindManager;
        if (keyBindManager != null) {
            return keyBindManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyBindManager");
        return null;
    }

    public final void setKeyBindManager(@NotNull KeyBindManager keyBindManager) {
        Intrinsics.checkNotNullParameter((Object)keyBindManager, "<set-?>");
        DarkMeow.keyBindManager = keyBindManager;
    }

    @NotNull
    public final VisualManager getVisualManager() {
        VisualManager visualManager = DarkMeow.visualManager;
        if (visualManager != null) {
            return visualManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("visualManager");
        return null;
    }

    public final void setVisualManager(@NotNull VisualManager visualManager) {
        Intrinsics.checkNotNullParameter(visualManager, "<set-?>");
        DarkMeow.visualManager = visualManager;
    }

    @NotNull
    public final ClickGuiManager getClickGuiManager() {
        ClickGuiManager clickGuiManager = DarkMeow.clickGuiManager;
        if (clickGuiManager != null) {
            return clickGuiManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clickGuiManager");
        return null;
    }

    public final void setClickGuiManager(@NotNull ClickGuiManager clickGuiManager) {
        Intrinsics.checkNotNullParameter(clickGuiManager, "<set-?>");
        DarkMeow.clickGuiManager = clickGuiManager;
    }

    @NotNull
    public final RotationManager getRotationManager() {
        RotationManager rotationManager = DarkMeow.rotationManager;
        if (rotationManager != null) {
            return rotationManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rotationManager");
        return null;
    }

    public final void setRotationManager(@NotNull RotationManager rotationManager) {
        Intrinsics.checkNotNullParameter(rotationManager, "<set-?>");
        DarkMeow.rotationManager = rotationManager;
    }

    @NotNull
    public final MovementManager getMovementManager() {
        MovementManager movementManager = DarkMeow.movementManager;
        if (movementManager != null) {
            return movementManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("movementManager");
        return null;
    }

    public final void setMovementManager(@NotNull MovementManager movementManager) {
        Intrinsics.checkNotNullParameter(movementManager, "<set-?>");
        DarkMeow.movementManager = movementManager;
    }

    @NotNull
    public final MessageManager getMessageManager() {
        MessageManager messageManager = DarkMeow.messageManager;
        if (messageManager != null) {
            return messageManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("messageManager");
        return null;
    }

    public final void setMessageManager(@NotNull MessageManager messageManager) {
        Intrinsics.checkNotNullParameter(messageManager, "<set-?>");
        DarkMeow.messageManager = messageManager;
    }

    @NotNull
    public final UpdateManager getUpdateManager() {
        UpdateManager updateManager = DarkMeow.updateManager;
        if (updateManager != null) {
            return updateManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateManager");
        return null;
    }

    public final void setUpdateManager(@NotNull UpdateManager updateManager) {
        Intrinsics.checkNotNullParameter(updateManager, "<set-?>");
        DarkMeow.updateManager = updateManager;
    }

    @NotNull
    public final NetworkManager getNetworkManager() {
        NetworkManager networkManager = DarkMeow.networkManager;
        if (networkManager != null) {
            return networkManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("networkManager");
        return null;
    }

    public final void setNetworkManager(@NotNull NetworkManager networkManager) {
        Intrinsics.checkNotNullParameter(networkManager, "<set-?>");
        DarkMeow.networkManager = networkManager;
    }

    @NotNull
    public final InventoryManager getInventoryManager() {
        InventoryManager inventoryManager = DarkMeow.inventoryManager;
        if (inventoryManager != null) {
            return inventoryManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inventoryManager");
        return null;
    }

    public final void setInventoryManager(@NotNull InventoryManager inventoryManager) {
        Intrinsics.checkNotNullParameter(inventoryManager, "<set-?>");
        DarkMeow.inventoryManager = inventoryManager;
    }

    @NotNull
    public final HUDManager getHudManager() {
        HUDManager hUDManager = hudManager;
        if (hUDManager != null) {
            return hUDManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hudManager");
        return null;
    }

    public final void setHudManager(@NotNull HUDManager hUDManager) {
        Intrinsics.checkNotNullParameter(hUDManager, "<set-?>");
        hudManager = hUDManager;
    }

    public final void startClient() {
        this.setFileManager(new FileManager());
        Fonts.INSTANCE.loadFonts();
        this.setVisualManager(new VisualManager());
        this.setLanguageManager(new LanguageManager(this));
        this.getLanguageManager().onReload();
        this.setBaritoneManager(new BaritoneManager());
        this.setConfigManager(new ConfigManager(this));
        this.setEventManager(new EventManager());
        this.setInventoryManager(new InventoryManager(this));
        this.setCombatManager(new CombatManager(this));
        this.setTipSoundManager(new TipSoundManager());
        this.setCommandManager(new CommandManager(this));
        this.setKeyBindManager(new KeyBindManager());
        this.setClickGuiManager(new ClickGuiManager());
        this.setRotationManager(new RotationManager(this));
        this.setMovementManager(new MovementManager(this));
        this.setModuleManager(new ModuleManager(this));
        this.getModuleManager().registerModules();
        MinecraftImpl minecraftImpl = MinecraftInstance.mc;
        Intrinsics.checkNotNullExpressionValue(minecraftImpl, "mc");
        this.setMessageManager(new MessageManager(minecraftImpl));
        this.setHudManager(new HUDManager());
        this.loadGui();
        this.loadConfigs();
        this.setUpdateManager(new UpdateManager());
        this.setNetworkManager(new NetworkManager(this));
        ShaderUpdateManager.disable = new File(this.getFileManager().getDir(), "DISABLE_SHADER").exists();
        EventManager.registerListener$default(this.getEventManager(), ShaderUpdateManager.INSTANCE, false, false, 6, null);
        this.getConfigManager().initLoad();
        isStarting = false;
    }

    private final void loadGui() {
        this.getClickGuiManager().load();
    }

    private final void loadConfigs() {
        FileConfig[] fileConfigArray = new FileConfig[]{this.getFileManager().getAccountsConfig(), this.getFileManager().getFriendsConfig(), this.getFileManager().getSpecialConfig(), this.getFileManager().getClickGuiConfig(), this.getFileManager().getXrayConfig()};
        this.getFileManager().loadConfigs(fileConfigArray);
    }

    public final void stopClient() {
        if (isDestroy) {
            return;
        }
        EventManager.callEvent$default(this.getEventManager(), new ClientShutdownEvent(), null, 2, null);
        this.getConfigManager().save(false);
        this.getFileManager().saveAllConfigs();
        isDestroy = true;
    }

    public final void destroyClient(boolean gc2) {
        this.stopClient();
        MinecraftInstance.mc_nowarp.func_147108_a(null);
        this.getCommandManager().unregisterAllCommands();
        this.getEventManager().unregisterAllListeners();
        if (gc2) {
            System.gc();
        }
    }

    public static /* synthetic */ void destroyClient$default(DarkMeow darkMeow, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        darkMeow.destroyClient(bl2);
    }

    static {
        Minecraft minecraft = Minecraft.func_71410_x();
        Intrinsics.checkNotNullExpressionValue(minecraft, "getMinecraft(...)");
        mc = minecraft;
        CLIENT_NAME = ClientInfoUtils.INSTANCE.getName();
        CLIENT_VERSION = ClientInfoUtils.INSTANCE.getVersion();
        isStarting = true;
    }
}

