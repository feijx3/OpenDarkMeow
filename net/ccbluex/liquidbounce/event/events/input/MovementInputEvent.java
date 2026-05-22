/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.util.MovementInput
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.input;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.util.MovementInput;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent;", "", "<init>", "()V", "PRE", "POST", "DarkMeow"})
public final class MovementInputEvent {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$POST;", "Lnet/ccbluex/liquidbounce/event/Event;", "movementInput", "Lnet/minecraft/util/MovementInput;", "isCancelledPre", "", "<init>", "(Lnet/minecraft/util/MovementInput;Z)V", "getMovementInput", "()Lnet/minecraft/util/MovementInput;", "()Z", "DarkMeow"})
    public static final class POST
    extends Event {
        @NotNull
        private final MovementInput movementInput;
        private final boolean isCancelledPre;

        public POST(@NotNull MovementInput movementInput, boolean isCancelledPre) {
            Intrinsics.checkNotNullParameter(movementInput, "movementInput");
            this.movementInput = movementInput;
            this.isCancelledPre = isCancelledPre;
        }

        @NotNull
        public final MovementInput getMovementInput() {
            return this.movementInput;
        }

        public final boolean isCancelledPre() {
            return this.isCancelledPre;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0003H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u0012\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "keyStateForward", "", "keyStateBack", "keyStateLeft", "keyStateRight", "keyStateJump", "keyStateSneak", "<init>", "(ZZZZZZ)V", "getKeyStateForward", "()Z", "setKeyStateForward", "(Z)V", "getKeyStateBack", "setKeyStateBack", "getKeyStateLeft", "setKeyStateLeft", "getKeyStateRight", "setKeyStateRight", "getKeyStateJump", "setKeyStateJump", "getKeyStateSneak", "setKeyStateSneak", "shouldApplySneakSlow", "isMoving", "jump", "sneak", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nMovementInputEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovementInputEvent.kt\nnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,61:1\n12637#2,2:62\n*S KotlinDebug\n*F\n+ 1 MovementInputEvent.kt\nnet/ccbluex/liquidbounce/event/events/input/MovementInputEvent$PRE\n*L\n49#1:62,2\n*E\n"})
    public static final class PRE
    extends CancellableEvent {
        private boolean keyStateForward;
        private boolean keyStateBack;
        private boolean keyStateLeft;
        private boolean keyStateRight;
        private boolean keyStateJump;
        private boolean keyStateSneak;
        @JvmField
        public boolean shouldApplySneakSlow;

        public PRE(boolean keyStateForward, boolean keyStateBack, boolean keyStateLeft, boolean keyStateRight, boolean keyStateJump, boolean keyStateSneak) {
            this.keyStateForward = keyStateForward;
            this.keyStateBack = keyStateBack;
            this.keyStateLeft = keyStateLeft;
            this.keyStateRight = keyStateRight;
            this.keyStateJump = keyStateJump;
            this.shouldApplySneakSlow = this.keyStateSneak = keyStateSneak;
        }

        public final boolean getKeyStateForward() {
            return this.keyStateForward;
        }

        public final void setKeyStateForward(boolean bl2) {
            this.keyStateForward = bl2;
        }

        public final boolean getKeyStateBack() {
            return this.keyStateBack;
        }

        public final void setKeyStateBack(boolean bl2) {
            this.keyStateBack = bl2;
        }

        public final boolean getKeyStateLeft() {
            return this.keyStateLeft;
        }

        public final void setKeyStateLeft(boolean bl2) {
            this.keyStateLeft = bl2;
        }

        public final boolean getKeyStateRight() {
            return this.keyStateRight;
        }

        public final void setKeyStateRight(boolean bl2) {
            this.keyStateRight = bl2;
        }

        public final boolean getKeyStateJump() {
            return this.keyStateJump;
        }

        public final void setKeyStateJump(boolean bl2) {
            this.keyStateJump = bl2;
        }

        public final boolean getKeyStateSneak() {
            return this.keyStateSneak;
        }

        public final void setKeyStateSneak(boolean bl2) {
            this.keyStateSneak = bl2;
        }

        @JvmOverloads
        public final boolean isMoving(boolean jump, boolean sneak) {
            boolean bl2;
            block1: {
                Boolean[] booleanArray = new Boolean[]{this.keyStateForward, this.keyStateBack, this.keyStateLeft, this.keyStateRight, this.keyStateJump && jump, this.keyStateSneak && sneak};
                Boolean[] $this$any$iv = booleanArray;
                boolean $i$f$any = false;
                for (Boolean element$iv : $this$any$iv) {
                    boolean it = element$iv;
                    boolean bl3 = false;
                    if (!it) continue;
                    bl2 = true;
                    break block1;
                }
                bl2 = false;
            }
            return bl2;
        }

        public static /* synthetic */ boolean isMoving$default(PRE pRE, boolean bl2, boolean bl3, int n2, Object object) {
            if ((n2 & 1) != 0) {
                bl2 = false;
            }
            if ((n2 & 2) != 0) {
                bl3 = false;
            }
            return pRE.isMoving(bl2, bl3);
        }

        @JvmOverloads
        public final boolean isMoving(boolean jump) {
            return PRE.isMoving$default(this, jump, false, 2, null);
        }

        @JvmOverloads
        public final boolean isMoving() {
            return PRE.isMoving$default(this, false, false, 3, null);
        }
    }
}

