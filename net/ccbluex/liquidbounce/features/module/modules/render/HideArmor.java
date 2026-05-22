/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/HideArmor;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "headValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "chestValue", "legsValue", "feetValue", "isHidden", "", "slot", "Lnet/minecraft/inventory/EntityEquipmentSlot;", "DarkMeow"})
public final class HideArmor
extends Module {
    @NotNull
    public static final HideArmor INSTANCE = new HideArmor();
    @JvmField
    @NotNull
    public static final BoolValue headValue = new BoolValue("Head", true);
    @JvmField
    @NotNull
    public static final BoolValue chestValue = new BoolValue("Chest", true);
    @JvmField
    @NotNull
    public static final BoolValue legsValue = new BoolValue("Legs", true);
    @JvmField
    @NotNull
    public static final BoolValue feetValue = new BoolValue("Feet", true);

    private HideArmor() {
        super("HideArmor", ModuleCategory.RENDER, null, null, 12, null);
    }

    @JvmStatic
    public static final boolean isHidden(@NotNull EntityEquipmentSlot slot) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(slot, "slot");
        switch (WhenMappings.$EnumSwitchMapping$0[slot.ordinal()]) {
            case 1: {
                bl2 = (Boolean)headValue.get();
                break;
            }
            case 2: {
                bl2 = (Boolean)chestValue.get();
                break;
            }
            case 3: {
                bl2 = (Boolean)legsValue.get();
                break;
            }
            case 4: {
                bl2 = (Boolean)feetValue.get();
                break;
            }
            default: {
                bl2 = false;
            }
        }
        return bl2;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EntityEquipmentSlot.values().length];
            try {
                nArray[EntityEquipmentSlot.HEAD.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EntityEquipmentSlot.CHEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EntityEquipmentSlot.LEGS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EntityEquipmentSlot.FEET.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

