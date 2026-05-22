/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2={"Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "completion", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/coroutines/Continuation;)V", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"})
@SinceKotlin(version="1.3")
public abstract class RestrictedSuspendLambda
extends RestrictedContinuationImpl
implements FunctionBase<Object>,
SuspendFunction {
    private final int arity;

    public RestrictedSuspendLambda(int arity, @Nullable Continuation<Object> completion) {
        super(completion);
        this.arity = arity;
    }

    @Override
    public int getArity() {
        return this.arity;
    }

    public RestrictedSuspendLambda(int arity) {
        this(arity, null);
    }

    @Override
    @NotNull
    public String toString() {
        String string;
        if (this.getCompletion() == null) {
            String string2 = Reflection.renderLambdaToString(this);
            string = string2;
            Intrinsics.checkNotNullExpressionValue(string2, "renderLambdaToString(...)");
        } else {
            string = super.toString();
        }
        return string;
    }
}

