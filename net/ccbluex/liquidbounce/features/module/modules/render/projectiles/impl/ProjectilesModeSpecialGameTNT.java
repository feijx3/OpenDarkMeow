/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockTNT
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.projectiles.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.render.projectiles.ProjectilesInfo;
import net.ccbluex.liquidbounce.features.module.modules.render.projectiles.ProjectilesMode;
import net.minecraft.block.BlockTNT;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/impl/ProjectilesModeSpecialGameTNT;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/ProjectilesMode;", "<init>", "()V", "canHandleProjectiles", "", "item", "Lnet/minecraft/item/Item;", "doHandleProjectiles", "Lnet/ccbluex/liquidbounce/features/module/modules/render/projectiles/ProjectilesInfo;", "DarkMeow"})
public final class ProjectilesModeSpecialGameTNT
extends ProjectilesMode {
    public ProjectilesModeSpecialGameTNT() {
        super("SpecialGameTNT");
    }

    @Override
    public boolean canHandleProjectiles(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemBlock itemBlock = item instanceof ItemBlock ? (ItemBlock)item : null;
        return (itemBlock != null ? itemBlock.func_179223_d() : null) instanceof BlockTNT;
    }

    @Override
    @NotNull
    public ProjectilesInfo doHandleProjectiles() {
        return new ProjectilesInfo(false, 0.0f, 0.0f, 0.03f, 0.25f, 7, null);
    }
}

