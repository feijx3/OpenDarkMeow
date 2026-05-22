/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ain
 *  aip
 */
package baritone.launch.mixins;

import baritone.api.utils.accessor.IItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={aip.class})
public abstract class MixinItemStack
implements IItemStack {
    @Shadow
    @Final
    private ain e;
    @Shadow
    private int h;
    @Unique
    private int baritoneHash;

    private void recalculateHash() {
        this.baritoneHash = this.e == null ? -1 : this.e.hashCode() + this.h;
    }

    @Inject(method={"<init>*"}, at={@At(value="RETURN")})
    private void onInit(CallbackInfo callbackInfo) {
        this.recalculateHash();
    }

    @Inject(method={"setItemDamage"}, at={@At(value="TAIL")})
    private void onItemDamageSet(CallbackInfo callbackInfo) {
        this.recalculateHash();
    }

    @Override
    public int getBaritoneHash() {
        return this.baritoneHash;
    }
}

