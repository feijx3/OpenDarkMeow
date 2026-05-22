/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.event.GAppleDoEatPreEvent;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/GAppleExtendModifyMovement;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "doEatPre", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "event", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/event/GAppleDoEatPreEvent;", "DarkMeow"})
public final class GAppleExtendModifyMovement
extends GAppleExtend {
    @JvmField
    @NotNull
    public final ListValue modeValue;

    public GAppleExtendModifyMovement() {
        super("ModifyMovement", true);
        String[] stringArray = new String[]{"SlowDown", "Zero"};
        this.modeValue = new ListValue("Mode", stringArray, "SlowDown");
    }

    @Override
    public void doEatPre(@NotNull SafeListenerBase $this$doEatPre, @NotNull GAppleDoEatPreEvent event) {
        Intrinsics.checkNotNullParameter($this$doEatPre, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        String string = (String)this.modeValue.get();
        if (Intrinsics.areEqual(string, "SlowDown")) {
            if (!$this$doEatPre.getPlayer().func_184587_cr()) {
                EntityPlayerSP entityPlayerSP = $this$doEatPre.getPlayer();
                entityPlayerSP.field_191988_bg *= 0.2f;
                entityPlayerSP = $this$doEatPre.getPlayer();
                entityPlayerSP.field_70702_br *= 0.2f;
            }
        } else if (Intrinsics.areEqual(string, "Zero")) {
            $this$doEatPre.getPlayer().field_191988_bg = 0.0f;
            $this$doEatPre.getPlayer().field_70702_br = 0.0f;
        }
    }
}

