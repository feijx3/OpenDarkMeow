/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/handler/combat/LastAttackInfo;", "", "entity", "Lnet/minecraft/entity/Entity;", "updateId", "", "<init>", "(Lnet/minecraft/entity/Entity;J)V", "getEntity", "()Lnet/minecraft/entity/Entity;", "getUpdateId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class LastAttackInfo {
    @NotNull
    private final Entity entity;
    private final long updateId;

    public LastAttackInfo(@NotNull Entity entity, long updateId) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.entity = entity;
        this.updateId = updateId;
    }

    @NotNull
    public final Entity getEntity() {
        return this.entity;
    }

    public final long getUpdateId() {
        return this.updateId;
    }

    @NotNull
    public final Entity component1() {
        return this.entity;
    }

    public final long component2() {
        return this.updateId;
    }

    @NotNull
    public final LastAttackInfo copy(@NotNull Entity entity, long updateId) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return new LastAttackInfo(entity, updateId);
    }

    public static /* synthetic */ LastAttackInfo copy$default(LastAttackInfo lastAttackInfo, Entity entity, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            entity = lastAttackInfo.entity;
        }
        if ((n2 & 2) != 0) {
            l2 = lastAttackInfo.updateId;
        }
        return lastAttackInfo.copy(entity, l2);
    }

    @NotNull
    public String toString() {
        return "LastAttackInfo(entity=" + this.entity + ", updateId=" + this.updateId + ')';
    }

    public int hashCode() {
        int result = this.entity.hashCode();
        result = result * 31 + Long.hashCode(this.updateId);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LastAttackInfo)) {
            return false;
        }
        LastAttackInfo lastAttackInfo = (LastAttackInfo)other;
        if (!Intrinsics.areEqual(this.entity, lastAttackInfo.entity)) {
            return false;
        }
        return this.updateId == lastAttackInfo.updateId;
    }
}

