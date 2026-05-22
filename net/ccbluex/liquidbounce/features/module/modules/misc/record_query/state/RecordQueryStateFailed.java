/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state.RecordQueryState;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/state/RecordQueryStateFailed;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/state/RecordQueryState;", "name", "", "<init>", "(Ljava/lang/String;)V", "DarkMeow"})
public final class RecordQueryStateFailed
extends RecordQueryState {
    public RecordQueryStateFailed(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        super(name);
    }
}

