/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Slot
 */
package net.ccbluex.liquidbounce.injection.access;

import net.minecraft.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Slot.class})
public interface AccessorSlot {
    @Invoker(value="onSwapCraft")
    public void trollOnSwapCraft(int var1);
}

