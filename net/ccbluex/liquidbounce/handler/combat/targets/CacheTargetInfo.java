/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.combat.targets;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/handler/combat/targets/CacheTargetInfo;", "", "allowNormal", "", "allowAttack", "<init>", "(ZZ)V", "getAllowNormal", "()Z", "setAllowNormal", "(Z)V", "getAllowAttack", "setAllowAttack", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class CacheTargetInfo {
    private boolean allowNormal;
    private boolean allowAttack;

    public CacheTargetInfo(boolean allowNormal, boolean allowAttack) {
        this.allowNormal = allowNormal;
        this.allowAttack = allowAttack;
    }

    public /* synthetic */ CacheTargetInfo(boolean bl2, boolean bl3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        if ((n2 & 2) != 0) {
            bl3 = false;
        }
        this(bl2, bl3);
    }

    public final boolean getAllowNormal() {
        return this.allowNormal;
    }

    public final void setAllowNormal(boolean bl2) {
        this.allowNormal = bl2;
    }

    public final boolean getAllowAttack() {
        return this.allowAttack;
    }

    public final void setAllowAttack(boolean bl2) {
        this.allowAttack = bl2;
    }

    public final boolean component1() {
        return this.allowNormal;
    }

    public final boolean component2() {
        return this.allowAttack;
    }

    @NotNull
    public final CacheTargetInfo copy(boolean allowNormal, boolean allowAttack) {
        return new CacheTargetInfo(allowNormal, allowAttack);
    }

    public static /* synthetic */ CacheTargetInfo copy$default(CacheTargetInfo cacheTargetInfo, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = cacheTargetInfo.allowNormal;
        }
        if ((n2 & 2) != 0) {
            bl3 = cacheTargetInfo.allowAttack;
        }
        return cacheTargetInfo.copy(bl2, bl3);
    }

    @NotNull
    public String toString() {
        return "CacheTargetInfo(allowNormal=" + this.allowNormal + ", allowAttack=" + this.allowAttack + ')';
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.allowNormal);
        result = result * 31 + Boolean.hashCode(this.allowAttack);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheTargetInfo)) {
            return false;
        }
        CacheTargetInfo cacheTargetInfo = (CacheTargetInfo)other;
        if (this.allowNormal != cacheTargetInfo.allowNormal) {
            return false;
        }
        return this.allowAttack == cacheTargetInfo.allowAttack;
    }

    public CacheTargetInfo() {
        this(false, false, 3, null);
    }
}

