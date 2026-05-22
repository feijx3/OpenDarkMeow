/*
 * Decompiled with CFR 0.152.
 */
package net.ccbluex.liquidbounce.event.events.render;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/RenderFovModifierEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "", "fov", "<init>", "(F)V", "DarkMeow"})
public final class RenderFovModifierEvent
extends ChangeValueEvent<Float> {
    public RenderFovModifierEvent(float fov) {
        super(Float.valueOf(fov));
    }
}

