/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class CheckResult {
    private final boolean isSuccess;

    private CheckResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public /* synthetic */ CheckResult(boolean isSuccess, DefaultConstructorMarker $constructor_marker) {
        this(isSuccess);
    }

    public static final class IllegalFunctionName
    extends CheckResult {
        @NotNull
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        private IllegalFunctionName() {
            super(false, null);
        }
    }

    public static final class IllegalSignature
    extends CheckResult {
        @NotNull
        private final String error;

        public IllegalSignature(@NotNull String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            super(false, null);
            this.error = error;
        }
    }

    public static final class SuccessCheck
    extends CheckResult {
        @NotNull
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        private SuccessCheck() {
            super(true, null);
        }
    }
}

