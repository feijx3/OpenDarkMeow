/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

public final class ScopeKind
extends Enum<ScopeKind> {
    public static final /* enum */ ScopeKind PACKAGE = new ScopeKind();
    public static final /* enum */ ScopeKind CLASSIFIER = new ScopeKind();
    private static final /* synthetic */ ScopeKind[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ScopeKind[] values() {
        return (ScopeKind[])$VALUES.clone();
    }

    public static ScopeKind valueOf(String value) {
        return Enum.valueOf(ScopeKind.class, value);
    }

    static {
        $VALUES = scopeKindArray = new ScopeKind[]{ScopeKind.PACKAGE, ScopeKind.CLASSIFIER};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

