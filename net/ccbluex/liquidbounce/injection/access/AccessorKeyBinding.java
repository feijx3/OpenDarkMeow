/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 */
package net.ccbluex.liquidbounce.injection.access;

import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={KeyBinding.class})
public interface AccessorKeyBinding {
    @Accessor(value="pressTime")
    public int getPressTime();

    @Accessor(value="pressTime")
    public void setPressTime(int var1);

    @Accessor(value="pressed")
    public boolean getPressed();

    @Accessor(value="pressed")
    public void setPressed(boolean var1);

    @Invoker(value="unpressKey")
    public void invokeUnpressKey();
}

