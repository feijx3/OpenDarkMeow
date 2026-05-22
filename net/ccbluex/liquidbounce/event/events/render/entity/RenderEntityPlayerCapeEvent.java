/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event.events.render.entity;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerCapeEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "Lnet/minecraft/util/ResourceLocation;", "info", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "cape", "<init>", "(Lnet/minecraft/client/network/NetworkPlayerInfo;Lnet/minecraft/util/ResourceLocation;)V", "getInfo", "()Lnet/minecraft/client/network/NetworkPlayerInfo;", "DarkMeow"})
public final class RenderEntityPlayerCapeEvent
extends ChangeValueEvent<ResourceLocation> {
    @Nullable
    private final NetworkPlayerInfo info;

    public RenderEntityPlayerCapeEvent(@Nullable NetworkPlayerInfo info, @Nullable ResourceLocation cape) {
        super(cape);
        this.info = info;
    }

    @Nullable
    public final NetworkPlayerInfo getInfo() {
        return this.info;
    }
}

