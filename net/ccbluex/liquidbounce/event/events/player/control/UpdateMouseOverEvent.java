/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event.events.player.control;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.darkmeow.darkmeow.utils.movement.RayCastUtils;
import net.darkmeow.darkmeow.utils.movement.ray_cast.through_wall.ThroughWallCheck;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateMouseOverEvent;", "", "<init>", "()V", "PRE", "POST", "DarkMeow"})
public final class UpdateMouseOverEvent {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateMouseOverEvent$POST;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "Lnet/minecraft/util/math/RayTraceResult;", "result", "currentEntity", "Lnet/minecraft/entity/Entity;", "partialTicks", "", "lookVec", "Lnet/minecraft/util/math/Vec3d;", "<init>", "(Lnet/minecraft/util/math/RayTraceResult;Lnet/minecraft/entity/Entity;FLnet/minecraft/util/math/Vec3d;)V", "getCurrentEntity", "()Lnet/minecraft/entity/Entity;", "getPartialTicks", "()F", "getLookVec", "()Lnet/minecraft/util/math/Vec3d;", "DarkMeow"})
    public static final class POST
    extends ChangeValueEvent<RayTraceResult> {
        @NotNull
        private final Entity currentEntity;
        private final float partialTicks;
        @NotNull
        private final Vec3d lookVec;

        public POST(@NotNull RayTraceResult result, @NotNull Entity currentEntity, float partialTicks, @NotNull Vec3d lookVec) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(currentEntity, "currentEntity");
            Intrinsics.checkNotNullParameter(lookVec, "lookVec");
            super(result);
            this.currentEntity = currentEntity;
            this.partialTicks = partialTicks;
            this.lookVec = lookVec;
        }

        @NotNull
        public final Entity getCurrentEntity() {
            return this.currentEntity;
        }

        public final float getPartialTicks() {
            return this.partialTicks;
        }

        @NotNull
        public final Vec3d getLookVec() {
            return this.lookVec;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0015J\u0006\u00103\u001a\u00020\u000bJ\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\tH\u00c6\u0003J\t\u00109\u001a\u00020\u000bH\u00c6\u0003J\t\u0010:\u001a\u00020\u000bH\u00c6\u0003J\t\u0010;\u001a\u00020\u000bH\u00c6\u0003J\t\u0010<\u001a\u00020\u000fH\u00c6\u0003Jc\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010@H\u00d6\u0003J\t\u0010A\u001a\u000202H\u00d6\u0001J\t\u0010B\u001a\u00020CH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u001eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2={"Lnet/ccbluex/liquidbounce/event/events/player/control/UpdateMouseOverEvent$PRE;", "Lnet/ccbluex/liquidbounce/event/Event;", "partialTicks", "", "currentEntity", "Lnet/minecraft/entity/Entity;", "blockRange", "entityRange", "entityThroughWall", "Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/ThroughWallCheck;", "entityNoRiding", "", "noBlockInteract", "noEntityInteract", "lookVec", "Lnet/minecraft/util/math/Vec3d;", "<init>", "(FLnet/minecraft/entity/Entity;FFLnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/ThroughWallCheck;ZZZLnet/minecraft/util/math/Vec3d;)V", "entity", "playerController", "Lnet/minecraft/client/multiplayer/PlayerControllerMP;", "(FLnet/minecraft/entity/Entity;Lnet/minecraft/client/multiplayer/PlayerControllerMP;)V", "getPartialTicks", "()F", "getCurrentEntity", "()Lnet/minecraft/entity/Entity;", "setCurrentEntity", "(Lnet/minecraft/entity/Entity;)V", "getBlockRange", "setBlockRange", "(F)V", "getEntityRange", "setEntityRange", "getEntityThroughWall", "()Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/ThroughWallCheck;", "setEntityThroughWall", "(Lnet/darkmeow/darkmeow/utils/movement/ray_cast/through_wall/ThroughWallCheck;)V", "getEntityNoRiding", "()Z", "setEntityNoRiding", "(Z)V", "getNoBlockInteract", "setNoBlockInteract", "getNoEntityInteract", "setNoEntityInteract", "getLookVec", "()Lnet/minecraft/util/math/Vec3d;", "setLookVec", "(Lnet/minecraft/util/math/Vec3d;)V", "launchHash", "", "hasChanged", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "", "DarkMeow"})
    public static final class PRE
    extends Event {
        private final float partialTicks;
        @NotNull
        private Entity currentEntity;
        private float blockRange;
        private float entityRange;
        @NotNull
        private ThroughWallCheck entityThroughWall;
        private boolean entityNoRiding;
        private boolean noBlockInteract;
        private boolean noEntityInteract;
        @NotNull
        private Vec3d lookVec;
        private int launchHash;

        public PRE(float partialTicks, @NotNull Entity currentEntity, float blockRange, float entityRange, @NotNull ThroughWallCheck entityThroughWall, boolean entityNoRiding, boolean noBlockInteract, boolean noEntityInteract, @NotNull Vec3d lookVec) {
            Intrinsics.checkNotNullParameter(currentEntity, "currentEntity");
            Intrinsics.checkNotNullParameter(entityThroughWall, "entityThroughWall");
            Intrinsics.checkNotNullParameter(lookVec, "lookVec");
            this.partialTicks = partialTicks;
            this.currentEntity = currentEntity;
            this.blockRange = blockRange;
            this.entityRange = entityRange;
            this.entityThroughWall = entityThroughWall;
            this.entityNoRiding = entityNoRiding;
            this.noBlockInteract = noBlockInteract;
            this.noEntityInteract = noEntityInteract;
            this.lookVec = lookVec;
            this.launchHash = this.hashCode();
        }

        public /* synthetic */ PRE(float f2, Entity entity, float f3, float f4, ThroughWallCheck throughWallCheck, boolean bl2, boolean bl3, boolean bl4, Vec3d vec3d, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 0x10) != 0) {
                throughWallCheck = RayCastUtils.INSTANCE.getDEFAULT_THROUGH_WALL_CHECK();
            }
            if ((n2 & 0x20) != 0) {
                bl2 = true;
            }
            if ((n2 & 0x40) != 0) {
                bl3 = false;
            }
            if ((n2 & 0x80) != 0) {
                bl4 = false;
            }
            if ((n2 & 0x100) != 0) {
                Vec3d vec3d2 = entity.func_70676_i(f2);
                Intrinsics.checkNotNullExpressionValue(vec3d2, "getLook(...)");
                vec3d = vec3d2;
            }
            this(f2, entity, f3, f4, throughWallCheck, bl2, bl3, bl4, vec3d);
        }

        public final float getPartialTicks() {
            return this.partialTicks;
        }

        @NotNull
        public final Entity getCurrentEntity() {
            return this.currentEntity;
        }

        public final void setCurrentEntity(@NotNull Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "<set-?>");
            this.currentEntity = entity;
        }

        public final float getBlockRange() {
            return this.blockRange;
        }

        public final void setBlockRange(float f2) {
            this.blockRange = f2;
        }

        public final float getEntityRange() {
            return this.entityRange;
        }

        public final void setEntityRange(float f2) {
            this.entityRange = f2;
        }

        @NotNull
        public final ThroughWallCheck getEntityThroughWall() {
            return this.entityThroughWall;
        }

        public final void setEntityThroughWall(@NotNull ThroughWallCheck throughWallCheck) {
            Intrinsics.checkNotNullParameter(throughWallCheck, "<set-?>");
            this.entityThroughWall = throughWallCheck;
        }

        public final boolean getEntityNoRiding() {
            return this.entityNoRiding;
        }

        public final void setEntityNoRiding(boolean bl2) {
            this.entityNoRiding = bl2;
        }

        public final boolean getNoBlockInteract() {
            return this.noBlockInteract;
        }

        public final void setNoBlockInteract(boolean bl2) {
            this.noBlockInteract = bl2;
        }

        public final boolean getNoEntityInteract() {
            return this.noEntityInteract;
        }

        public final void setNoEntityInteract(boolean bl2) {
            this.noEntityInteract = bl2;
        }

        @NotNull
        public final Vec3d getLookVec() {
            return this.lookVec;
        }

        public final void setLookVec(@NotNull Vec3d vec3d) {
            Intrinsics.checkNotNullParameter(vec3d, "<set-?>");
            this.lookVec = vec3d;
        }

        public PRE(float partialTicks, @NotNull Entity entity, @NotNull PlayerControllerMP playerController) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(playerController, "playerController");
            this(partialTicks, entity, playerController.func_78757_d(), playerController.func_78749_i() ? 6.0f : 3.0f, null, false, false, false, null, 496, null);
        }

        public final boolean hasChanged() {
            return this.launchHash != this.hashCode();
        }

        public final float component1() {
            return this.partialTicks;
        }

        @NotNull
        public final Entity component2() {
            return this.currentEntity;
        }

        public final float component3() {
            return this.blockRange;
        }

        public final float component4() {
            return this.entityRange;
        }

        @NotNull
        public final ThroughWallCheck component5() {
            return this.entityThroughWall;
        }

        public final boolean component6() {
            return this.entityNoRiding;
        }

        public final boolean component7() {
            return this.noBlockInteract;
        }

        public final boolean component8() {
            return this.noEntityInteract;
        }

        @NotNull
        public final Vec3d component9() {
            return this.lookVec;
        }

        @NotNull
        public final PRE copy(float partialTicks, @NotNull Entity currentEntity, float blockRange, float entityRange, @NotNull ThroughWallCheck entityThroughWall, boolean entityNoRiding, boolean noBlockInteract, boolean noEntityInteract, @NotNull Vec3d lookVec) {
            Intrinsics.checkNotNullParameter(currentEntity, "currentEntity");
            Intrinsics.checkNotNullParameter(entityThroughWall, "entityThroughWall");
            Intrinsics.checkNotNullParameter(lookVec, "lookVec");
            return new PRE(partialTicks, currentEntity, blockRange, entityRange, entityThroughWall, entityNoRiding, noBlockInteract, noEntityInteract, lookVec);
        }

        public static /* synthetic */ PRE copy$default(PRE pRE, float f2, Entity entity, float f3, float f4, ThroughWallCheck throughWallCheck, boolean bl2, boolean bl3, boolean bl4, Vec3d vec3d, int n2, Object object) {
            if ((n2 & 1) != 0) {
                f2 = pRE.partialTicks;
            }
            if ((n2 & 2) != 0) {
                entity = pRE.currentEntity;
            }
            if ((n2 & 4) != 0) {
                f3 = pRE.blockRange;
            }
            if ((n2 & 8) != 0) {
                f4 = pRE.entityRange;
            }
            if ((n2 & 0x10) != 0) {
                throughWallCheck = pRE.entityThroughWall;
            }
            if ((n2 & 0x20) != 0) {
                bl2 = pRE.entityNoRiding;
            }
            if ((n2 & 0x40) != 0) {
                bl3 = pRE.noBlockInteract;
            }
            if ((n2 & 0x80) != 0) {
                bl4 = pRE.noEntityInteract;
            }
            if ((n2 & 0x100) != 0) {
                vec3d = pRE.lookVec;
            }
            return pRE.copy(f2, entity, f3, f4, throughWallCheck, bl2, bl3, bl4, vec3d);
        }

        @NotNull
        public String toString() {
            return "PRE(partialTicks=" + this.partialTicks + ", currentEntity=" + this.currentEntity + ", blockRange=" + this.blockRange + ", entityRange=" + this.entityRange + ", entityThroughWall=" + this.entityThroughWall + ", entityNoRiding=" + this.entityNoRiding + ", noBlockInteract=" + this.noBlockInteract + ", noEntityInteract=" + this.noEntityInteract + ", lookVec=" + this.lookVec + ')';
        }

        public int hashCode() {
            int result = Float.hashCode(this.partialTicks);
            result = result * 31 + this.currentEntity.hashCode();
            result = result * 31 + Float.hashCode(this.blockRange);
            result = result * 31 + Float.hashCode(this.entityRange);
            result = result * 31 + this.entityThroughWall.hashCode();
            result = result * 31 + Boolean.hashCode(this.entityNoRiding);
            result = result * 31 + Boolean.hashCode(this.noBlockInteract);
            result = result * 31 + Boolean.hashCode(this.noEntityInteract);
            result = result * 31 + this.lookVec.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PRE)) {
                return false;
            }
            PRE pRE = (PRE)other;
            if (Float.compare(this.partialTicks, pRE.partialTicks) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual(this.currentEntity, pRE.currentEntity)) {
                return false;
            }
            if (Float.compare(this.blockRange, pRE.blockRange) != 0) {
                return false;
            }
            if (Float.compare(this.entityRange, pRE.entityRange) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual(this.entityThroughWall, pRE.entityThroughWall)) {
                return false;
            }
            if (this.entityNoRiding != pRE.entityNoRiding) {
                return false;
            }
            if (this.noBlockInteract != pRE.noBlockInteract) {
                return false;
            }
            if (this.noEntityInteract != pRE.noEntityInteract) {
                return false;
            }
            return Intrinsics.areEqual(this.lookVec, pRE.lookVec);
        }
    }
}

