/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render.storage_esp.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.render.storage_esp.StorageEspMode;
import net.ccbluex.liquidbounce.features.module.modules.world.ContainerAura;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/impl/StorageEspModeChest;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/StorageEspMode;", "<init>", "()V", "normalColorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "openedColorValue", "isOpenedCheck", "Lkotlin/Function1;", "Lnet/minecraft/util/math/BlockPos;", "", "()Lkotlin/jvm/functions/Function1;", "setOpenedCheck", "(Lkotlin/jvm/functions/Function1;)V", "onEnable", "", "getTileEntityColor", "Ljava/awt/Color;", "tile", "Lnet/minecraft/tileentity/TileEntity;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStorageEspModeChest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageEspModeChest.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/impl/StorageEspModeChest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1#2:41\n*E\n"})
public final class StorageEspModeChest
extends StorageEspMode {
    @JvmField
    @NotNull
    public final ColorValue normalColorValue = new ColorValue("NormalColor", new ColorValueInfo(new Color(0, 255, 0, 120)), false, 4, null);
    @JvmField
    @NotNull
    public final ColorValue openedColorValue = new ColorValue("OpenedColor", new ColorValueInfo(new Color(255, 0, 0, 120)), false, 4, null);
    @NotNull
    private Function1<? super BlockPos, Boolean> isOpenedCheck = StorageEspModeChest::isOpenedCheck$lambda$0;

    public StorageEspModeChest() {
        super("Chest");
    }

    @NotNull
    public final Function1<BlockPos, Boolean> isOpenedCheck() {
        return this.isOpenedCheck;
    }

    public final void setOpenedCheck(@NotNull Function1<? super BlockPos, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.isOpenedCheck = function1;
    }

    @Override
    public void onEnable() {
        block0: {
            ContainerAura containerAura;
            ContainerAura containerAura2 = DarkMeow.INSTANCE.getModuleManager().get(ContainerAura.class);
            if (containerAura2 == null) break block0;
            ContainerAura module = containerAura = containerAura2;
            boolean bl2 = false;
            this.isOpenedCheck = new Function1<BlockPos, Boolean>((Object)module){

                public final Boolean invoke(BlockPos p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return ((ContainerAura)this.receiver).isOpened(p0);
                }
            };
        }
    }

    @Override
    @Nullable
    public Color getTileEntityColor(@NotNull TileEntity tile) {
        Color color;
        TileEntity tileEntity;
        TileEntity tileEntity2;
        Intrinsics.checkNotNullParameter(tile, "tile");
        TileEntity it = tileEntity2 = tile;
        boolean bl2 = false;
        Object object = tileEntity = it instanceof TileEntityChest ? tileEntity2 : null;
        if (tileEntity != null) {
            it = tileEntity;
            boolean bl3 = false;
            BlockPos blockPos = it.func_174877_v();
            Intrinsics.checkNotNullExpressionValue(blockPos, "getPos(...)");
            color = this.isOpenedCheck.invoke((BlockPos)blockPos).booleanValue() ? ColorValue.getColor$default(this.openedColorValue, null, 1, null) : ColorValue.getColor$default(this.normalColorValue, null, 1, null);
        } else {
            color = null;
        }
        return color;
    }

    private static final boolean isOpenedCheck$lambda$0(BlockPos it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }
}

