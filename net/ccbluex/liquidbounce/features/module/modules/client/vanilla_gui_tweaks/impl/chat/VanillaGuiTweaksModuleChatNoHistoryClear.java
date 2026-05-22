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
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/impl/chat/VanillaGuiTweaksModuleChatNoHistoryClear;", "Lnet/ccbluex/liquidbounce/features/module/modules/client/vanilla_gui_tweaks/VanillaGuiTweaksModule;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "DarkMeow"})
public final class VanillaGuiTweaksModuleChatNoHistoryClear
extends VanillaGuiTweaksModule {
    @NotNull
    public static final VanillaGuiTweaksModuleChatNoHistoryClear INSTANCE = new VanillaGuiTweaksModuleChatNoHistoryClear();
    @JvmField
    @NotNull
    public static final ListValue modeValue;

    private VanillaGuiTweaksModuleChatNoHistoryClear() {
        super("ChatNoHistoryClear", true);
    }

    static {
        String[] stringArray = new String[]{"OnlySendHistory", "SendAndMessageHistory"};
        modeValue = new ListValue("Mode", stringArray, "OnlySendHistory");
    }
}

