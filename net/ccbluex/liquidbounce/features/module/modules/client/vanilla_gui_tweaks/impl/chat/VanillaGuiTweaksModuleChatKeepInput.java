/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.impl.chat;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.ccbluex.liquidbounce.features.module.modules.client.vanilla_gui_tweaks.VanillaGuiTweaksModule;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/chat/VanillaGuiTweaksModuleChatKeepInput;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/VanillaGuiTweaksModule;", "<init>", "()V", "onlyRemoteCloseValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "message", "", "DarkMeow"})
public final class VanillaGuiTweaksModuleChatKeepInput
extends VanillaGuiTweaksModule {
    @NotNull
    public static final VanillaGuiTweaksModuleChatKeepInput INSTANCE = new VanillaGuiTweaksModuleChatKeepInput();
    @JvmField
    @NotNull
    public static final BoolValue onlyRemoteCloseValue = new BoolValue("OnlyRemoteClose", true);
    @JvmField
    @NotNull
    public static String message = "";

    private VanillaGuiTweaksModuleChatKeepInput() {
        super("ChatKeepMessage", false);
    }
}

