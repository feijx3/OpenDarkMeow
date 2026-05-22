/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.audio.SoundEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="SoundBlocker", category=ModuleCategory.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/SoundBlocker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "soundDebuggerValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "blocksValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "onSound", "", "event", "Lnet/ccbluex/liquidbounce/event/events/audio/SoundEvent;", "DarkMeow"})
public final class SoundBlocker
extends Module {
    @NotNull
    public static final SoundBlocker INSTANCE = new SoundBlocker();
    @JvmField
    @NotNull
    public static final BoolValue soundDebuggerValue = new BoolValue("SoundDebugger", false);
    @JvmField
    @NotNull
    public static final TextValue blocksValue = new TextValue("Blocks", "");

    private SoundBlocker() {
        super(null, null, null, null, 15, null);
    }

    @EventTarget
    public final void onSound(@NotNull SoundEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (((Boolean)soundDebuggerValue.get()).booleanValue()) {
            String string;
            String it = string = "\u00a7d" + event.getSound().func_147650_b() + " \u00a7b" + System.currentTimeMillis() % (long)0xFFFFFF + '\n' + ("    \u00a77Category \u00a75: \u00a77" + event.getSound().func_184365_d().name()) + '\n' + ("    \u00a77Position \u00a75: \u00a77" + event.getSound().func_147649_g() + ' ' + event.getSound().func_147654_h() + ' ' + event.getSound().func_147651_i());
            boolean bl2 = false;
            MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
            Intrinsics.checkNotNull(it);
            messageManager.displayChatMessage(it);
        }
        CharSequence charSequence = (CharSequence)blocksValue.get();
        String string = event.getSound().func_147650_b().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (StringsKt.contains$default(charSequence, string, false, 2, null)) {
            event.cancelEvent();
        }
    }
}

