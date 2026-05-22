/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.auto_walk.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.auto_walk.AutoWalkMode;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/movement/auto_walk/impl/AutoWalkModeMovementInput;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/auto_walk/AutoWalkMode;", "<init>", "()V", "forwardModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "strafeModeValue", "jumpModeValue", "inventoryMoveValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "onMovementInputPre", "", "event", "Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "DarkMeow"})
public final class AutoWalkModeMovementInput
extends AutoWalkMode {
    @JvmField
    @NotNull
    public final ListValue forwardModeValue;
    @JvmField
    @NotNull
    public final ListValue strafeModeValue;
    @JvmField
    @NotNull
    public final ListValue jumpModeValue;
    @JvmField
    @NotNull
    public final BoolValue inventoryMoveValue;

    public AutoWalkModeMovementInput() {
        super("MovementInput");
        String[] stringArray = new String[]{"None", "Forward", "Back", "Zero"};
        this.forwardModeValue = new ListValue("ForwardMode", stringArray, "Forward");
        stringArray = new String[]{"None", "Left", "Right", "Zero"};
        this.strafeModeValue = new ListValue("StrafeMode", stringArray, "None");
        stringArray = new String[]{"None", "Jump", "Zero"};
        this.jumpModeValue = new ListValue("JumpMode", stringArray, "None");
        this.inventoryMoveValue = new BoolValue("InventoryMove", false);
    }

    /*
     * Unable to fully structure code
     */
    @EventTarget(priority=0)
    public final void onMovementInputPre(@NotNull MovementInputEvent.PRE event) {
        block25: {
            Intrinsics.checkNotNullParameter(event, "event");
            v0 = MinecraftInstance.mc.getPlayer();
            if (v0 == null) {
                return;
            }
            player = v0;
            if (!player.func_70089_S() || player.field_70173_aa < 2) {
                return;
            }
            if (!((Boolean)this.inventoryMoveValue.get()).booleanValue() && MinecraftInstance.mc.getCurrentScreen() != null) {
                return;
            }
            var3_3 = (String)this.forwardModeValue.get();
            switch (var3_3.hashCode()) {
                case 2781896: {
                    if (!var3_3.equals("Zero")) {
                        ** break;
                    }
                    break block25;
                }
                case 2062599: {
                    if (var3_3.equals("Back")) break;
                    ** break;
                }
                case 987507365: {
                    if (!var3_3.equals("Forward")) ** break;
                    event.setKeyStateForward(true);
                    event.setKeyStateBack(false);
                    ** break;
                }
            }
            event.setKeyStateForward(false);
            event.setKeyStateBack(true);
            ** break;
        }
        event.setKeyStateForward(false);
        event.setKeyStateBack(false);
lbl30:
        // 7 sources

        var3_3 = (String)this.strafeModeValue.get();
        tmp = -1;
        switch (var3_3.hashCode()) {
            case 2781896: {
                if (var3_3.equals("Zero")) {
                    tmp = 1;
                }
                break;
            }
            case 2364455: {
                if (var3_3.equals("Left")) {
                    tmp = 2;
                }
                break;
            }
            case 78959100: {
                if (var3_3.equals("Right")) {
                    tmp = 3;
                }
                break;
            }
        }
        switch (tmp) {
            case 2: {
                event.setKeyStateLeft(true);
                event.setKeyStateRight(false);
                break;
            }
            case 3: {
                event.setKeyStateLeft(false);
                event.setKeyStateRight(true);
                break;
            }
            case 1: {
                event.setKeyStateLeft(false);
                event.setKeyStateRight(false);
            }
        }
        var3_3 = (String)this.jumpModeValue.get();
        if (Intrinsics.areEqual(var3_3, "Jump")) {
            event.setKeyStateJump(true);
        } else if (Intrinsics.areEqual(var3_3, "Zero")) {
            event.setKeyStateJump(false);
        }
    }
}

