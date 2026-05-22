/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.access.network.AccessorCPacketChatMessage;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="ChatControl", description="\u804a\u5929\u63a7\u5236", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/ChatControl;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "utfChat", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "utfChatCmd", "Lnet/ccbluex/liquidbounce/value/Value;", "", "prefix", "prefixText", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "suffix", "suffixText", "checkInvalidMessageValue", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "unicodeText", "", "input", "DarkMeow"})
public final class ChatControl
extends Module {
    @NotNull
    private final BoolValue utfChat = new BoolValue("ForceUnicodeChat", false);
    @NotNull
    private final Value<Boolean> utfChatCmd = new BoolValue("ForceUnicodeChatCommand", false).displayable(() -> ChatControl.utfChatCmd$lambda$0(this));
    @NotNull
    private final BoolValue prefix = new BoolValue("Prefix", true);
    @NotNull
    private final TextValue prefixText = new TextValue("PrefixText", "\u00bb ");
    @NotNull
    private final BoolValue suffix = new BoolValue("Suffix", true);
    @NotNull
    private final TextValue suffixText = new TextValue("SuffixText", " \u271eDarkMeow\u271e ^owo^");
    @NotNull
    private final BoolValue checkInvalidMessageValue = new BoolValue("CheckInvalidMessage", false);

    public ChatControl() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Packet<?> packet = event.getPacket();
        if (packet instanceof AccessorCPacketChatMessage) {
            String string = ((AccessorCPacketChatMessage)packet).func_149439_c();
            if (string == null) {
                return;
            }
            String message = string;
            if (((Boolean)this.checkInvalidMessageValue.get()).booleanValue() && StringsKt.contains$default((CharSequence)message, "\u00a7", false, 2, null)) {
                event.cancelEvent();
            }
            if (!(!((Boolean)this.utfChat.get()).booleanValue() || this.utfChatCmd.get().booleanValue() && StringsKt.startsWith$default(message, "/", false, 2, null))) {
                message = this.unicodeText(message);
            }
            if (!StringsKt.startsWith$default(message, "/", false, 2, null)) {
                if (((Boolean)this.prefix.get()).booleanValue()) {
                    message = (String)this.prefixText.get() + message;
                }
                if (((Boolean)this.suffix.get()).booleanValue()) {
                    message = message + (String)this.suffixText.get();
                }
            }
            ((AccessorCPacketChatMessage)packet).setMessage(message);
        }
    }

    private final String unicodeText(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArray = input.toCharArray();
        Intrinsics.checkNotNullExpressionValue(cArray, "toCharArray(...)");
        for (char c2 : cArray) {
            char c3 = c2;
            StringBuilder stringBuilder2 = ('!' <= c3 ? c3 < '\u0081' : false) ? stringBuilder.append(Character.toChars(c2 + 65248)) : stringBuilder.append(c2);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final boolean utfChatCmd$lambda$0(ChatControl this$0) {
        return (Boolean)this$0.utfChat.get();
    }
}

