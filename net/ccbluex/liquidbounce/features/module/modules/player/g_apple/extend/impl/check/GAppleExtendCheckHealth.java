/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.check;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.GAppleExtend;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/check/GAppleExtendCheckHealth;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/GAppleExtend;", "<init>", "()V", "limitValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "preEat", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "DarkMeow"})
public final class GAppleExtendCheckHealth
extends GAppleExtend {
    @JvmField
    @NotNull
    public final IntegerValue limitValue = new IntegerValue("Limit", 10, new IntRange(1, 20));

    public GAppleExtendCheckHealth() {
        super("CheckHealth", false);
    }

    @Override
    public boolean preEat(@NotNull SafeListenerBase $this$preEat) {
        Intrinsics.checkNotNullParameter($this$preEat, "<this>");
        return $this$preEat.getPlayer().func_110143_aJ() < (float)((Number)this.limitValue.get()).intValue();
    }
}

