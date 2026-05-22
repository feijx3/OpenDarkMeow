/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketConfirmTransaction
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.client.CPacketConfirmTransaction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketConfirmTransaction.class})
public interface AccessorCPacketConfirmTransaction {
    @Accessor(value="accepted")
    public boolean getAccepted();

    @Accessor(value="accepted")
    public void setAccepted(boolean var1);

    @Accessor(value="uid")
    public short func_149533_d();

    @Accessor(value="uid")
    public void setUid(short var1);

    @Accessor(value="windowId")
    public int func_149532_c();

    @Accessor(value="windowId")
    public void setWindowId(int var1);
}

