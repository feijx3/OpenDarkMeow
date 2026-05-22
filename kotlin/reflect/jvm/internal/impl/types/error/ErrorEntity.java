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

public final class ErrorEntity
extends Enum<ErrorEntity> {
    @NotNull
    private final String debugText;
    public static final /* enum */ ErrorEntity ERROR_CLASS = new ErrorEntity("<Error class: %s>");
    public static final /* enum */ ErrorEntity ERROR_FUNCTION = new ErrorEntity("<Error function>");
    public static final /* enum */ ErrorEntity ERROR_SCOPE = new ErrorEntity("<Error scope>");
    public static final /* enum */ ErrorEntity ERROR_MODULE = new ErrorEntity("<Error module>");
    public static final /* enum */ ErrorEntity ERROR_PROPERTY = new ErrorEntity("<Error property>");
    public static final /* enum */ ErrorEntity ERROR_TYPE = new ErrorEntity("[Error type: %s]");
    public static final /* enum */ ErrorEntity PARENT_OF_ERROR_SCOPE = new ErrorEntity("<Fake parent for error lexical scope>");
    private static final /* synthetic */ ErrorEntity[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ErrorEntity(String debugText) {
        this.debugText = debugText;
    }

    @NotNull
    public final String getDebugText() {
        return this.debugText;
    }

    public static ErrorEntity[] values() {
        return (ErrorEntity[])$VALUES.clone();
    }

    public static ErrorEntity valueOf(String value) {
        return Enum.valueOf(ErrorEntity.class, value);
    }

    static {
        $VALUES = errorEntityArray = new ErrorEntity[]{ErrorEntity.ERROR_CLASS, ErrorEntity.ERROR_FUNCTION, ErrorEntity.ERROR_SCOPE, ErrorEntity.ERROR_MODULE, ErrorEntity.ERROR_PROPERTY, ErrorEntity.ERROR_TYPE, ErrorEntity.PARENT_OF_ERROR_SCOPE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

