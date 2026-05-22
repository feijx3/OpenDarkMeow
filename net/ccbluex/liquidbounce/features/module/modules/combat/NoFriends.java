/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.client.UpdateSelectTargetStatusEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="NoFriends", description="Allows you to attack friends.", category=ModuleCategory.COMBAT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/NoFriends;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "onUpdateAllowTargets", "", "event", "Lnet/ccbluex/liquidbounce/event/events/client/UpdateSelectTargetStatusEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNoFriends.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoFriends.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/NoFriends\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,26:1\n1#2:27\n12434#3,2:28\n*S KotlinDebug\n*F\n+ 1 NoFriends.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/NoFriends\n*L\n22#1:28,2\n*E\n"})
public final class NoFriends
extends Module {
    public NoFriends() {
        super(null, null, null, null, 15, null);
    }

    /*
     * WARNING - void declaration
     */
    @EventTarget(priority=0)
    public final void onUpdateAllowTargets(@NotNull UpdateSelectTargetStatusEvent event) {
        block4: {
            EntityPlayer entityPlayer;
            EntityPlayer entityPlayer2;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityLivingBase entityLivingBase = event.getTarget();
            EntityPlayer entityPlayer3 = entityPlayer2 = entityLivingBase instanceof EntityPlayer ? (EntityPlayer)entityLivingBase : null;
            if (entityPlayer2 == null) break block4;
            EntityPlayer it = entityPlayer = entityPlayer2;
            boolean bl2 = false;
            Object object = entityLivingBase = !event.isFriendEntity() ? entityPlayer : null;
            if (entityLivingBase != null) {
                boolean bl3;
                EntityLivingBase it2;
                EntityLivingBase entityLivingBase2;
                block3: {
                    void $this$all$iv;
                    it2 = entityLivingBase2 = entityLivingBase;
                    boolean bl4 = false;
                    Boolean[] booleanArray = new Boolean[2];
                    Object object2 = it2 instanceof EntityPlayer ? it2 : null;
                    booleanArray[0] = object2 != null ? PlayerExtensionKt.isClientFriend((EntityPlayer)object2) : false;
                    booleanArray[1] = !this.getState();
                    boolean $i$f$all = false;
                    for (void element$iv : $this$all$iv) {
                        boolean it3 = element$iv.booleanValue();
                        boolean bl5 = false;
                        if (it3) continue;
                        bl3 = false;
                        break block3;
                    }
                    bl3 = true;
                }
                Object object3 = entityPlayer = bl3 ? entityLivingBase2 : null;
                if (entityPlayer != null) {
                    it2 = entityLivingBase2 = entityPlayer;
                    boolean bl6 = false;
                    event.setFriendEntity();
                }
            }
        }
    }
}

