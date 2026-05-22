/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketPlayerTryUseItem.class})
public interface AccessorCPacketPlayerTryUseItem {
    @Accessor(value="hand")
    public EnumHand func_187028_a();

    @Accessor(value="hand")
    public void setHand(EnumHand var1);
}

