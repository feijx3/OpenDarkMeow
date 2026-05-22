/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityDispenser
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render.storage_esp.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.render.storage_esp.StorageEspMode;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/impl/StorageEspModeDispenser;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/StorageEspMode;", "<init>", "()V", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "getTileEntityColor", "Ljava/awt/Color;", "tile", "Lnet/minecraft/tileentity/TileEntity;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStorageEspModeDispenser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageEspModeDispenser.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/impl/StorageEspModeDispenser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,20:1\n1#2:21\n*E\n"})
public final class StorageEspModeDispenser
extends StorageEspMode {
    @JvmField
    @NotNull
    public final ColorValue colorValue = new ColorValue("Color", new ColorValueInfo(new Color(0, 0, 0, 120)), false, 4, null);

    public StorageEspModeDispenser() {
        super("Dispenser");
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
        Object object = tileEntity = it instanceof TileEntityDispenser ? tileEntity2 : null;
        if (tileEntity != null) {
            it = tileEntity;
            boolean bl3 = false;
            color = ColorValue.getColor$default(this.colorValue, null, 1, null);
        } else {
            color = null;
        }
        return color;
    }
}

