/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.manager;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.IBaritoneProvider;
import baritone.api.Settings;
import baritone.api.process.IBaritoneProcess;
import com.google.common.collect.ImmutableSet;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0011\u0010\u001b\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u0006#"}, d2={"Lnet/ccbluex/liquidbounce/features/manager/BaritoneManager;", "", "<init>", "()V", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "provider", "Lbaritone/api/IBaritoneProvider;", "getProvider", "()Lbaritone/api/IBaritoneProvider;", "settings", "Lbaritone/api/Settings;", "getSettings", "()Lbaritone/api/Settings;", "primary", "Lbaritone/api/IBaritone;", "getPrimary", "()Lbaritone/api/IBaritone;", "prefix", "", "getPrefix", "()Ljava/lang/String;", "isPathing", "isActive", "cancelEverything", "()Ljava/lang/Boolean;", "baritoneCachedBlocks", "Lcom/google/common/collect/ImmutableSet;", "Lnet/minecraft/block/Block;", "getBaritoneCachedBlocks", "()Lcom/google/common/collect/ImmutableSet;", "DarkMeow"})
public final class BaritoneManager {
    private boolean initialized;
    @NotNull
    private final ImmutableSet<Block> baritoneCachedBlocks;

    public BaritoneManager() {
        Object[] objectArray = new Block[]{Blocks.field_150477_bB, Blocks.field_150460_al, Blocks.field_150486_ae, Blocks.field_150447_bR, Blocks.field_150384_bq, Blocks.field_150378_br, Blocks.field_150474_ac, Blocks.field_180401_cv, Blocks.field_190976_dk, Blocks.field_190977_dl, Blocks.field_190978_dm, Blocks.field_190979_dn, Blocks.field_190980_do, Blocks.field_190981_dp, Blocks.field_190982_dq, Blocks.field_190983_dr, Blocks.field_190984_ds, Blocks.field_190985_dt, Blocks.field_190986_du, Blocks.field_190987_dv, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190990_dy, Blocks.field_190991_dz, Blocks.field_190975_dA, Blocks.field_150427_aO, Blocks.field_150438_bZ, Blocks.field_150461_bJ, Blocks.field_150382_bo, Blocks.field_150465_bP, Blocks.field_150381_bn, Blocks.field_150467_bQ, Blocks.field_150470_am, Blocks.field_150324_C, Blocks.field_150380_bt, Blocks.field_150421_aI, Blocks.field_185775_db, Blocks.field_150321_G, Blocks.field_150388_bm, Blocks.field_150468_ap, Blocks.field_150395_bd};
        ImmutableSet immutableSet = ImmutableSet.of((Object)Blocks.field_150484_ah, (Object)Blocks.field_150402_ci, (Object)Blocks.field_150339_S, (Object)Blocks.field_150340_R, (Object)Blocks.field_150412_bA, (Object)Blocks.field_150475_bE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue(immutableSet, "of(...)");
        this.baritoneCachedBlocks = immutableSet;
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final void setInitialized(boolean bl2) {
        this.initialized = bl2;
    }

    @Nullable
    public final IBaritoneProvider getProvider() {
        return this.initialized ? BaritoneAPI.getProvider() : null;
    }

    @Nullable
    public final Settings getSettings() {
        return this.initialized ? BaritoneAPI.getSettings() : null;
    }

    @Nullable
    public final IBaritone getPrimary() {
        IBaritoneProvider iBaritoneProvider = this.getProvider();
        return iBaritoneProvider != null ? iBaritoneProvider.getPrimaryBaritone() : null;
    }

    @NotNull
    public final String getPrefix() {
        Object object = this.getSettings();
        if (object == null || (object = ((Settings)object).prefix) == null || (object = (String)((Settings.Setting)object).value) == null) {
            object = "#";
        }
        return object;
    }

    public final boolean isPathing() {
        Object object = this.getPrimary();
        return object != null && (object = object.getPathingBehavior()) != null ? object.isPathing() : false;
    }

    public final boolean isActive() {
        Object object;
        Object object2 = this.getPrimary();
        return (object2 != null && (object2 = object2.getCustomGoalProcess()) != null ? object2.isActive() : false) || ((object = this.getPrimary()) != null && (object = object.getPathingControlManager()) != null && (object = object.mostRecentInControl()) != null && (object = (IBaritoneProcess)((Optional)object).orElse(null)) != null ? object.isActive() : false);
    }

    @Nullable
    public final Boolean cancelEverything() {
        Object object = this.getPrimary();
        return object != null && (object = object.getPathingBehavior()) != null ? Boolean.valueOf(object.cancelEverything()) : null;
    }

    @NotNull
    public final ImmutableSet<Block> getBaritoneCachedBlocks() {
        return this.baritoneCachedBlocks;
    }
}

