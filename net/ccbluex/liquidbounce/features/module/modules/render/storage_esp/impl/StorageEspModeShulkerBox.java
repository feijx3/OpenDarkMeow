/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityShulkerBox
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render.storage_esp.impl;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.render.storage_esp.StorageEspMode;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.utils.visual.ColorUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityShulkerBox;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/impl/StorageEspModeShulkerBox;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/StorageEspMode;", "<init>", "()V", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "colorDefaultAlphaValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "colorCustomValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "getTileEntityColor", "Ljava/awt/Color;", "tile", "Lnet/minecraft/tileentity/TileEntity;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStorageEspModeShulkerBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageEspModeShulkerBox.kt\nnet/ccbluex/liquidbounce/features/module/modules/render/storage_esp/impl/StorageEspModeShulkerBox\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class StorageEspModeShulkerBox
extends StorageEspMode {
    @JvmField
    @NotNull
    public final ListValue colorModeValue;
    @JvmField
    @NotNull
    public final IntegerValue colorDefaultAlphaValue;
    @JvmField
    @NotNull
    public final ColorValue colorCustomValue;

    /*
     * WARNING - void declaration
     */
    public StorageEspModeShulkerBox() {
        super("Shulker");
        void $this$colorCustomValue_u24lambda_u243;
        Object $this$colorCustomValue_u24lambda_u242;
        Object $this$colorDefaultAlphaValue_u24lambda_u241;
        Object $this$colorDefaultAlphaValue_u24lambda_u240;
        Object object = new String[]{"Default", "Custom"};
        this.colorModeValue = new ListValue("ColorMode", (String[])object, "Default");
        Object object2 = object = new IntegerValue("ShulkerBoxDefaultColorAlpha", 120, new IntRange(1, 255));
        StorageEspModeShulkerBox storageEspModeShulkerBox = this;
        boolean bl2 = false;
        $this$colorDefaultAlphaValue_u24lambda_u240.setSuperValue(this.colorModeValue);
        $this$colorDefaultAlphaValue_u24lambda_u240 = object;
        boolean bl3 = false;
        $this$colorDefaultAlphaValue_u24lambda_u241.setSuperValueMeta("Default");
        storageEspModeShulkerBox.colorDefaultAlphaValue = object;
        $this$colorDefaultAlphaValue_u24lambda_u241 = object = new ColorValue("ColorCustom", new ColorValueInfo(new Color(0, 0, 0, 120)), false, 4, null);
        storageEspModeShulkerBox = this;
        boolean bl4 = false;
        $this$colorCustomValue_u24lambda_u242.setSuperValue(this.colorModeValue);
        $this$colorCustomValue_u24lambda_u242 = object;
        boolean bl5 = false;
        $this$colorCustomValue_u24lambda_u243.setSuperValueMeta("Custom");
        storageEspModeShulkerBox.colorCustomValue = object;
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
        Object object = tileEntity = it instanceof TileEntityShulkerBox ? tileEntity2 : null;
        if (tileEntity != null) {
            it = tileEntity;
            boolean bl3 = false;
            String string = (String)this.colorModeValue.get();
            color = Intrinsics.areEqual(string, "Default") ? ColorUtils.INSTANCE.withAlpha(new Color(((TileEntityShulkerBox)it).func_190592_s().func_193350_e()), ((Number)this.colorDefaultAlphaValue.get()).intValue()) : (Intrinsics.areEqual(string, "Custom") ? ColorValue.getColor$default(this.colorCustomValue, null, 1, null) : null);
        } else {
            color = null;
        }
        return color;
    }
}

