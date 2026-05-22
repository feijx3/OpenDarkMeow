/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.world.GameType
 */
package net.ccbluex.liquidbounce.injection.access.player;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.world.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={PlayerControllerMP.class})
public interface AccessorPlayerControllerMP {
    @Accessor(value="blockHitDelay")
    public int getBlockHitDelay();

    @Accessor(value="blockHitDelay")
    public void setBlockHitDelay(int var1);

    @Accessor(value="curBlockDamageMP")
    public float getCurBlockDamageMP();

    @Accessor(value="curBlockDamageMP")
    public void setCurBlockDamageMP(float var1);

    @Accessor(value="isHittingBlock")
    public void setIsHittingBlock(boolean var1);

    @Accessor(value="currentPlayerItem")
    public int getCurrentPlayerItem();

    @Accessor(value="currentPlayerItem")
    public void setCurrentPlayerItem(int var1);

    @Accessor(value="currentGameType")
    public void setCurrentGameType(GameType var1);

    @Invoker(value="syncCurrentPlayItem")
    public void darkMeow_syncCurrentPlayItem();
}

