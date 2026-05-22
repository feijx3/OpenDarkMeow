/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Checks {
    @Nullable
    private final Name name;
    @Nullable
    private final Regex regex;
    @Nullable
    private final Collection<Name> nameList;
    @NotNull
    private final Function1<FunctionDescriptor, String> additionalCheck;
    @NotNull
    private final Check[] checks;

    private Checks(Name name, Regex regex, Collection<Name> nameList, Function1<? super FunctionDescriptor, String> additionalCheck, Check ... checks) {
        this.name = name;
        this.regex = regex;
        this.nameList = nameList;
        this.additionalCheck = additionalCheck;
        this.checks = checks;
    }

    public final boolean isApplicable(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (this.name != null && !Intrinsics.areEqual(functionDescriptor.getName(), this.name)) {
            return false;
        }
        if (this.regex != null) {
            String string = functionDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(string, "asString(...)");
            CharSequence charSequence = string;
            if (!this.regex.matches(charSequence)) {
                return false;
            }
        }
        return this.nameList == null || this.nameList.contains(functionDescriptor.getName());
    }

    @NotNull
    public final CheckResult checkAll(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        for (Check check : this.checks) {
            String checkResult = check.invoke(functionDescriptor);
            if (checkResult == null) continue;
            return new CheckResult.IllegalSignature(checkResult);
        }
        String additionalCheckResult = this.additionalCheck.invoke(functionDescriptor);
        if (additionalCheckResult != null) {
            return new CheckResult.IllegalSignature(additionalCheckResult);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public Checks(@NotNull Name name, @NotNull Check[] checks, @NotNull Function1<? super FunctionDescriptor, String> additionalChecks) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
        this(name, null, null, additionalChecks, Arrays.copyOf(checks, checks.length));
    }

    public /* synthetic */ Checks(Name name, Check[] checkArray, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            function1 = 2.INSTANCE;
        }
        this(name, checkArray, (Function1<? super FunctionDescriptor, String>)function1);
    }

    public Checks(@NotNull Regex regex, @NotNull Check[] checks, @NotNull Function1<? super FunctionDescriptor, String> additionalChecks) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
        this(null, regex, null, additionalChecks, Arrays.copyOf(checks, checks.length));
    }

    public /* synthetic */ Checks(Regex regex, Check[] checkArray, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            function1 = 3.INSTANCE;
        }
        this(regex, checkArray, (Function1<? super FunctionDescriptor, String>)function1);
    }

    public Checks(@NotNull Collection<Name> nameList, @NotNull Check[] checks, @NotNull Function1<? super FunctionDescriptor, String> additionalChecks) {
        Intrinsics.checkNotNullParameter(nameList, "nameList");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
        this(null, null, nameList, additionalChecks, Arrays.copyOf(checks, checks.length));
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArray, Function1 function1, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            function1 = 4.INSTANCE;
        }
        this(collection, checkArray, (Function1<? super FunctionDescriptor, String>)function1);
    }
}

