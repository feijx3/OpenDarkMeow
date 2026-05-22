/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.rotation.value;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.MovementMode;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeSilent;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue;", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "name", "", "defaultMode", "Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;", "<init>", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;)V", "getMovementMode", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMovementModeValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovementModeValue.kt\nnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,14:1\n37#2:15\n36#2,3:16\n*S KotlinDebug\n*F\n+ 1 MovementModeValue.kt\nnet/ccbluex/liquidbounce/handler/rotation/value/MovementModeValue\n*L\n10#1:15\n10#1:16,3\n*E\n"})
public final class MovementModeValue
extends ListValue {
    public MovementModeValue(@NotNull String name, @Nullable MovementMode defaultMode) {
        Intrinsics.checkNotNullParameter(name, "name");
        Collection $this$toTypedArray$iv = DarkMeow.INSTANCE.getRotationManager().movementModeManager.getListModes();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Object object = defaultMode;
        if (object == null || (object = ((MovementMode)object).getName()) == null) {
            object = "None";
        }
        super(name, thisCollection$iv.toArray(new String[0]), (String)object);
    }

    public /* synthetic */ MovementModeValue(String string, MovementMode movementMode, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            movementMode = MovementModeSilent.INSTANCE;
        }
        this(string, movementMode);
    }

    @Nullable
    public final MovementMode getMovementMode() {
        return DarkMeow.INSTANCE.getRotationManager().movementModeManager.getModes().get(this.getValue());
    }
}

