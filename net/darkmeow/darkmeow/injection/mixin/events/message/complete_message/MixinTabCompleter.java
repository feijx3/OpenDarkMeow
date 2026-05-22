/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.util.TabCompleter
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.events.message.complete_message;

import java.util.List;
import javax.annotation.Nullable;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.events.player.CompleteMessageEvent;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.util.TabCompleter;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(value=Side.CLIENT)
@Mixin(value={TabCompleter.class})
public abstract class MixinTabCompleter {
    @Shadow
    protected boolean field_186847_d;
    @Shadow
    protected int field_186848_e;
    @Shadow
    protected List<String> field_186849_f;

    @Shadow
    @Nullable
    public abstract BlockPos func_186839_b();

    @Shadow
    public abstract void func_186840_a(String ... var1);

    @Inject(method={"requestCompletions"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleClientCommandCompletion(String prefix, CallbackInfo ci2) {
        try {
            CompleteMessageEvent event = new CompleteMessageEvent(prefix, this.func_186839_b());
            DarkMeow.eventManager.callEvent(event);
            if (event.isChanged()) {
                ci2.cancel();
                this.field_186847_d = true;
                this.func_186840_a((String[])event.getReturnValue());
                if (this.field_186849_f.size() >= this.field_186848_e) {
                    this.field_186848_e = 0;
                }
            }
        }
        catch (Throwable e2) {
            ClientUtils.logger.error("Unable to call complete message event.", e2);
        }
    }
}

