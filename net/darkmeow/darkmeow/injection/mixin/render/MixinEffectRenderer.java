/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleEmitter
 *  net.minecraft.client.particle.ParticleManager
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package net.darkmeow.darkmeow.injection.mixin.render;

import com.google.common.collect.Lists;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Queue;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEmitter;
import net.minecraft.client.particle.ParticleManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SideOnly(value=Side.CLIENT)
@Mixin(value={ParticleManager.class})
public abstract class MixinEffectRenderer {
    @Shadow
    @Final
    private Queue<ParticleEmitter> field_178933_d;
    @Shadow
    @Final
    private Queue<Particle> field_187241_h;
    @Shadow
    @Final
    private ArrayDeque<Particle>[][] field_78876_b;

    @Shadow
    protected abstract void func_178922_a(int var1);

    @Overwrite
    public void func_78868_a() {
        try {
            for (int i2 = 0; i2 < 4; ++i2) {
                this.func_178922_a(i2);
            }
            if (!this.field_178933_d.isEmpty()) {
                ArrayList list = Lists.newArrayList();
                for (ParticleEmitter particleemitter : this.field_178933_d) {
                    particleemitter.func_189213_a();
                    if (particleemitter.func_187113_k()) continue;
                    list.add(particleemitter);
                }
                this.field_178933_d.removeAll(list);
            }
            if (!this.field_187241_h.isEmpty()) {
                Particle particle = this.field_187241_h.poll();
                while (particle != null) {
                    int k2;
                    int j2 = particle.func_70537_b();
                    int n2 = k2 = particle.func_187111_c() ? 0 : 1;
                    if (this.field_78876_b[j2][k2].size() >= 16384) {
                        this.field_78876_b[j2][k2].removeFirst();
                    }
                    this.field_78876_b[j2][k2].add(particle);
                    particle = this.field_187241_h.poll();
                }
            }
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            // empty catch block
        }
    }
}

