/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render.projectiles.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.render.projectiles.ProjectilesInfo;
import net.ccbluex.liquidbounce.features.module.modules.render.projectiles.ProjectilesMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/impl/ProjectilesModeBow;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/ProjectilesMode;", "<init>", "()V", "canHandleProjectiles", "", "item", "Lnet/minecraft/item/Item;", "doHandleProjectiles", "Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/ProjectilesInfo;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nProjectilesModeBow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProjectilesModeBow.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/impl/ProjectilesModeBow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,26:1\n1#2:27\n*E\n"})
public final class ProjectilesModeBow
extends ProjectilesMode {
    public ProjectilesModeBow() {
        super("Bow");
    }

    @Override
    public boolean canHandleProjectiles(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ItemBow;
    }

    @Override
    @Nullable
    public ProjectilesInfo doHandleProjectiles() {
        ProjectilesInfo projectilesInfo;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP != null) {
            EntityPlayerSP entityPlayerSP2;
            EntityPlayerSP player = entityPlayerSP;
            boolean bl2 = false;
            EntityPlayerSP it = entityPlayerSP2 = player;
            boolean bl3 = false;
            Object object = it.func_184587_cr() ? entityPlayerSP2 : null;
            if (object != null) {
                it = object;
                boolean bl4 = false;
                float power = (float)player.func_184612_cw() / 20.0f;
                if ((power = (power * power + power * 2.0f) / 3.0f) < 0.1f) {
                    return null;
                }
                if (power > 1.0f) {
                    power = 1.0f;
                }
                projectilesInfo = new ProjectilesInfo(true, power * 3.0f, 0.0f, 0.05f, 0.3f, 4, null);
            } else {
                projectilesInfo = null;
            }
        } else {
            projectilesInfo = null;
        }
        return projectilesInfo;
    }
}

