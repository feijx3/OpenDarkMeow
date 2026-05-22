/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.Interner;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.TableElementWrapper;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;

public abstract class MutableTable<Element extends GeneratedMessageLite.Builder<?, Element>, Table extends GeneratedMessageLite, TableBuilder extends GeneratedMessageLite.Builder<Table, TableBuilder>> {
    @NotNull
    private final Interner<TableElementWrapper<Element>> interner;

    public final int get(@NotNull Element type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.interner.intern(new TableElementWrapper<Element>(type));
    }
}

