/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 */
package net.ccbluex.liquidbounce.injection.access.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Entity.class})
public interface AccessorEntity {
    @Accessor(value="isInWeb")
    public boolean getIsInWeb();

    @Accessor(value="isInWeb")
    public void setIsInWeb(boolean var1);

    @Invoker(value="getFlag")
    public boolean darkMeow_getFlag(int var1);

    @Invoker(value="setFlag")
    public void darkMeow_setFlag(int var1, boolean var2);

    @Invoker(value="getVectorForRotation")
    public Vec3d darkMeow_getVectorForRotation(float var1, float var2);
}

