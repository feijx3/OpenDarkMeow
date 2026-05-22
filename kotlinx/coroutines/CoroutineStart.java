/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlinx.coroutines.DelicateCoroutinesApi
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JY\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r\u00a2\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u0002H\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0087\u0002\u00a2\u0006\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\u0019"}, d2={"Lkotlinx/coroutines/CoroutineStart;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "invoke", "", "R", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "kotlinx-coroutines-core"})
public final class CoroutineStart
extends Enum<CoroutineStart> {
    public static final /* enum */ CoroutineStart DEFAULT = new CoroutineStart();
    public static final /* enum */ CoroutineStart LAZY = new CoroutineStart();
    @DelicateCoroutinesApi
    public static final /* enum */ CoroutineStart ATOMIC = new CoroutineStart();
    public static final /* enum */ CoroutineStart UNDISPATCHED = new CoroutineStart();
    private static final /* synthetic */ CoroutineStart[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    @InternalCoroutinesApi
    public final <R, T> void invoke(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> block, R receiver, @NotNull Continuation<? super T> completion) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                CancellableKt.startCoroutineCancellable(block, receiver, completion);
                break;
            }
            case 2: {
                ContinuationKt.startCoroutine(block, receiver, completion);
                break;
            }
            case 3: {
                UndispatchedKt.startCoroutineUndispatched(block, receiver, completion);
                break;
            }
            case 4: {
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[])$VALUES.clone();
    }

    public static CoroutineStart valueOf(String value) {
        return Enum.valueOf(CoroutineStart.class, value);
    }

    @NotNull
    public static EnumEntries<CoroutineStart> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = coroutineStartArray = new CoroutineStart[]{CoroutineStart.DEFAULT, CoroutineStart.LAZY, CoroutineStart.ATOMIC, CoroutineStart.UNDISPATCHED};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[CoroutineStart.values().length];
            try {
                nArray[CoroutineStart.DEFAULT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CoroutineStart.ATOMIC.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[CoroutineStart.LAZY.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

