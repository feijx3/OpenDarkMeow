/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.base;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006\u0016"}, d2={"Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseState;", "", "defaultState", "", "lockToDefaultState", "<init>", "(ZZ)V", "getDefaultState", "()Z", "setDefaultState", "(Z)V", "getLockToDefaultState", "setLockToDefaultState", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class ModuleBaseState {
    private boolean defaultState;
    private boolean lockToDefaultState;

    public ModuleBaseState(boolean defaultState, boolean lockToDefaultState) {
        this.defaultState = defaultState;
        this.lockToDefaultState = lockToDefaultState;
    }

    public /* synthetic */ ModuleBaseState(boolean bl2, boolean bl3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        if ((n2 & 2) != 0) {
            bl3 = false;
        }
        this(bl2, bl3);
    }

    public final boolean getDefaultState() {
        return this.defaultState;
    }

    public final void setDefaultState(boolean bl2) {
        this.defaultState = bl2;
    }

    public final boolean getLockToDefaultState() {
        return this.lockToDefaultState;
    }

    public final void setLockToDefaultState(boolean bl2) {
        this.lockToDefaultState = bl2;
    }

    public final boolean component1() {
        return this.defaultState;
    }

    public final boolean component2() {
        return this.lockToDefaultState;
    }

    @NotNull
    public final ModuleBaseState copy(boolean defaultState, boolean lockToDefaultState) {
        return new ModuleBaseState(defaultState, lockToDefaultState);
    }

    public static /* synthetic */ ModuleBaseState copy$default(ModuleBaseState moduleBaseState, boolean bl2, boolean bl3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = moduleBaseState.defaultState;
        }
        if ((n2 & 2) != 0) {
            bl3 = moduleBaseState.lockToDefaultState;
        }
        return moduleBaseState.copy(bl2, bl3);
    }

    @NotNull
    public String toString() {
        return "ModuleBaseState(defaultState=" + this.defaultState + ", lockToDefaultState=" + this.lockToDefaultState + ')';
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.defaultState);
        result = result * 31 + Boolean.hashCode(this.lockToDefaultState);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModuleBaseState)) {
            return false;
        }
        ModuleBaseState moduleBaseState = (ModuleBaseState)other;
        if (this.defaultState != moduleBaseState.defaultState) {
            return false;
        }
        return this.lockToDefaultState == moduleBaseState.lockToDefaultState;
    }

    public ModuleBaseState() {
        this(false, false, 3, null);
    }
}

