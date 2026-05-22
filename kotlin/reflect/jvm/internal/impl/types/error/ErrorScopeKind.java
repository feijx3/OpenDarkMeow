/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

public final class ErrorScopeKind
extends Enum<ErrorScopeKind> {
    @NotNull
    private final String debugMessage;
    public static final /* enum */ ErrorScopeKind CAPTURED_TYPE_SCOPE = new ErrorScopeKind("No member resolution should be done on captured type, it used only during constraint system resolution");
    public static final /* enum */ ErrorScopeKind INTEGER_LITERAL_TYPE_SCOPE = new ErrorScopeKind("Scope for integer literal type (%s)");
    public static final /* enum */ ErrorScopeKind ERASED_RECEIVER_TYPE_SCOPE = new ErrorScopeKind("Error scope for erased receiver type");
    public static final /* enum */ ErrorScopeKind SCOPE_FOR_ABBREVIATION_TYPE = new ErrorScopeKind("Scope for abbreviation %s");
    public static final /* enum */ ErrorScopeKind STUB_TYPE_SCOPE = new ErrorScopeKind("Scope for stub type %s");
    public static final /* enum */ ErrorScopeKind NON_CLASSIFIER_SUPER_TYPE_SCOPE = new ErrorScopeKind("A scope for common supertype which is not a normal classifier");
    public static final /* enum */ ErrorScopeKind ERROR_TYPE_SCOPE = new ErrorScopeKind("Scope for error type %s");
    public static final /* enum */ ErrorScopeKind UNSUPPORTED_TYPE_SCOPE = new ErrorScopeKind("Scope for unsupported type %s");
    public static final /* enum */ ErrorScopeKind SCOPE_FOR_ERROR_CLASS = new ErrorScopeKind("Error scope for class %s with arguments: %s");
    public static final /* enum */ ErrorScopeKind SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE = new ErrorScopeKind("Error resolution candidate for call %s");
    private static final /* synthetic */ ErrorScopeKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ErrorScopeKind(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    @NotNull
    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public static ErrorScopeKind[] values() {
        return (ErrorScopeKind[])$VALUES.clone();
    }

    public static ErrorScopeKind valueOf(String value) {
        return Enum.valueOf(ErrorScopeKind.class, value);
    }

    static {
        $VALUES = errorScopeKindArray = new ErrorScopeKind[]{ErrorScopeKind.CAPTURED_TYPE_SCOPE, ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, ErrorScopeKind.ERASED_RECEIVER_TYPE_SCOPE, ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE, ErrorScopeKind.STUB_TYPE_SCOPE, ErrorScopeKind.NON_CLASSIFIER_SUPER_TYPE_SCOPE, ErrorScopeKind.ERROR_TYPE_SCOPE, ErrorScopeKind.UNSUPPORTED_TYPE_SCOPE, ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, ErrorScopeKind.SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

