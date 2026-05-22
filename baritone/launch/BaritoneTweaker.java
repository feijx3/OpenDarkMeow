/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.github.impactdevelopment.simpletweaker.SimpleTweaker
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.launchwrapper.LaunchClassLoader
 */
package baritone.launch;

import io.github.impactdevelopment.simpletweaker.SimpleTweaker;
import java.util.List;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

public class BaritoneTweaker
extends SimpleTweaker {
    public void injectIntoClassLoader(LaunchClassLoader object) {
        super.injectIntoClassLoader((LaunchClassLoader)object);
        MixinBootstrap.init();
        object = (List)Launch.blackboard.get("TweakClasses");
        String string2 = "notch";
        if (object.stream().anyMatch(string -> string.contains("net.minecraftforge.fml.common.launcher"))) {
            string2 = "searge";
        }
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext(string2);
        Mixins.addConfiguration("mixins.baritone.json");
    }
}

