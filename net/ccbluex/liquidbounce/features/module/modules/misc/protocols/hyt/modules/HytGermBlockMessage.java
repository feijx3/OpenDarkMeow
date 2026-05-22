/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.play.server.SPacketChat
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.modules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.HytModule;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.network.play.server.SPacketChat;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytGermBlockMessage;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/HytModule;", "<init>", "()V", "unreadMailValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nHytGermBlockMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HytGermBlockMessage.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytGermBlockMessage\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,26:1\n12637#2,2:27\n1#3:29\n*S KotlinDebug\n*F\n+ 1 HytGermBlockMessage.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/modules/HytGermBlockMessage\n*L\n20#1:27,2\n*E\n"})
public final class HytGermBlockMessage
extends HytModule {
    @NotNull
    private final BoolValue unreadMailValue = new BoolValue(this.getValuePrefix() + "UnreadMail", true);

    public HytGermBlockMessage() {
        super("BlockMessage");
    }

    /*
     * Unable to fully structure code
     */
    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        block4: {
            block3: {
                Intrinsics.checkNotNullParameter(event, "event");
                packet = event.getPacket();
                if (!(packet instanceof SPacketChat)) break block4;
                var4_3 = new Boolean[1];
                if (!((Boolean)this.unreadMailValue.get()).booleanValue()) ** GOTO lbl-1000
                v0 = ((SPacketChat)packet).func_148915_c().func_150260_c();
                Intrinsics.checkNotNullExpressionValue(v0, "getUnformattedText(...)");
                if (StringsKt.contains$default((CharSequence)v0, "\u5c01\u672a\u8bfb\u90ae\u4ef6\uff0c\u6309M\u952e\u67e5\u770b", false, 2, null)) {
                    v1 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v1 = false;
                }
                var4_3[0] = v1;
                $i$f$any = false;
                for (void element$iv : $this$any$iv) {
                    it = element$iv.booleanValue();
                    $i$a$-any-HytGermBlockMessage$onPacket$1 = false;
                    if (!it) continue;
                    v2 = true;
                    break block3;
                }
                v2 = false;
            }
            var4_3 = v2;
            it = var4_3.booleanValue();
            $i$a$-takeIf-HytGermBlockMessage$onPacket$2 = false;
            v3 = var3_10 = it != false ? var4_3 : null;
            if (var3_10 == null) break block4;
            var4_3 = var3_10;
            it = var4_3.booleanValue();
            $i$a$-also-HytGermBlockMessage$onPacket$3 = false;
            event.cancelEvent();
        }
    }
}

