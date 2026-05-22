/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.MovementInput
 */
package net.darkmeow.darkmeow.injection.mixin.util;

import net.minecraft.util.MovementInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={MovementInput.class})
public class MixinMovementInput {
    @Shadow
    public float field_192832_b;
    @Shadow
    public float field_78902_a;
    @Shadow
    public boolean field_78901_c;
    @Shadow
    public boolean field_78899_d;

    @Unique
    public void darkMeow$reset() {
        this.field_78902_a = 0.0f;
        this.field_192832_b = 0.0f;
        this.field_78901_c = false;
        this.field_78899_d = false;
    }
}

