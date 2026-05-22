/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityStatus
 */
package net.ccbluex.liquidbounce.injection.access.network;

import net.minecraft.network.play.server.SPacketEntityStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketEntityStatus.class})
public interface AccessorSPacketEntityStatus {
    @Accessor(value="entityId")
    public int getEntityId();

    @Accessor(value="entityId")
    public void setEntityId(int var1);

    @Accessor(value="logicOpcode")
    public byte getOpcode();

    @Accessor(value="logicOpcode")
    public void setOpcode(byte var1);
}

