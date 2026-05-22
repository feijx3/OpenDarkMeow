/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.projectile.EntityArrow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import java.awt.Color;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render3DEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.render.ColorUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityArrow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(name="ItemESP", description="Allows you to see items through walls.", category=ModuleCategory.RENDER)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/ItemESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "colorRedValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "colorGreenValue", "colorBlueValue", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getColor", "Ljava/awt/Color;", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "DarkMeow"})
public final class ItemESP
extends Module {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final IntegerValue colorRedValue;
    @NotNull
    private final IntegerValue colorGreenValue;
    @NotNull
    private final IntegerValue colorBlueValue;
    @NotNull
    private final BoolValue colorRainbow;

    public ItemESP() {
        super(null, null, null, null, 15, null);
        String[] stringArray = new String[]{"Box", "OtherBox"};
        this.modeValue = new ListValue("Mode", stringArray, "Box");
        this.colorRedValue = new IntegerValue("R", 0, 0, 255);
        this.colorGreenValue = new IntegerValue("G", 255, 0, 255);
        this.colorBlueValue = new IntegerValue("B", 0, 0, 255);
        this.colorRainbow = new BoolValue("Rainbow", true);
    }

    private final Color getColor() {
        return (Boolean)this.colorRainbow.get() != false ? ColorUtils.rainbow() : new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue());
    }

    @EventTarget
    public final void onRender3D(@Nullable Render3DEvent event) {
        Color color = this.getColor();
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        Intrinsics.checkNotNull(worldClient);
        for (Entity entity : worldClient.field_72996_f) {
            String string;
            if (!(entity instanceof EntityItem) && !(entity instanceof EntityArrow)) continue;
            Intrinsics.checkNotNullExpressionValue(((String)this.modeValue.get()).toLowerCase(Locale.ROOT), "toLowerCase(...)");
            if (Intrinsics.areEqual(string, "box")) {
                RenderUtils.drawEntityBox(entity, color, true);
                continue;
            }
            if (!Intrinsics.areEqual(string, "otherbox")) continue;
            RenderUtils.drawEntityBox(entity, color, false);
        }
    }
}

