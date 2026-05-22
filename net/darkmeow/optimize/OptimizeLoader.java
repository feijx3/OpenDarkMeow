/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.optimize;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2={"Lnet/darkmeow/optimize/OptimizeLoader;", "", "<init>", "()V", "loadOptimize", "", "DarkMeow"})
public final class OptimizeLoader {
    @NotNull
    public static final OptimizeLoader INSTANCE = new OptimizeLoader();

    private OptimizeLoader() {
    }

    @JvmStatic
    public static final void loadOptimize() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.darkmeow.optimize.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
        System.out.println((Object)"[Optimize] Inject Mixin successfully!");
    }
}

