/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.IProjectile
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.checks;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.features.module.modules.combat.autoblocks.AutoBlockCheck;
import net.ccbluex.liquidbounce.utils.EntityUtils;
import net.ccbluex.liquidbounce.value.impl.FloatRangeValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/checks/AutoBlockCheckRange;", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/AutoBlockCheck;", "<init>", "()V", "selectedValue", "Lnet/ccbluex/liquidbounce/value/impl/FloatRangeValue;", "projectileValue", "canBlock", "", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "checkSelected", "entity", "Lnet/minecraft/entity/Entity;", "checkProjectile", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoBlockCheckRange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBlockCheckRange.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/checks/AutoBlockCheckRange\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n295#2:41\n296#2:44\n12637#3,2:42\n1#4:45\n*S KotlinDebug\n*F\n+ 1 AutoBlockCheckRange.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/autoblocks/checks/AutoBlockCheckRange\n*L\n19#1:41\n19#1:44\n23#1:42,2\n*E\n"})
public final class AutoBlockCheckRange
extends AutoBlockCheck {
    @NotNull
    private final FloatRangeValue selectedValue = new FloatRangeValue(this.getValuePrefix() + "Selected", (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 5.0f), (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 6.0f));
    @NotNull
    private final FloatRangeValue projectileValue = new FloatRangeValue(this.getValuePrefix() + "Projectile", (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 5.0f), (ClosedRange<Float>)RangesKt.rangeTo(0.0f, 6.0f));

    public AutoBlockCheckRange() {
        super("Range", false, 2, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean canBlock(@NotNull EntityPlayerSP player) {
        Object v2;
        block3: {
            Intrinsics.checkNotNullParameter(player, "player");
            World world = player.field_70170_p;
            boolean bl2 = false;
            List list = world.field_72996_f;
            Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
            Iterable $this$firstOrNull$iv = list;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                boolean bl3;
                block2: {
                    void $this$any$iv;
                    Entity entity = (Entity)element$iv;
                    boolean bl4 = false;
                    Boolean[] booleanArray = new Boolean[2];
                    Intrinsics.checkNotNull(entity);
                    booleanArray[0] = this.checkSelected(player, entity);
                    booleanArray[1] = this.checkProjectile(player, entity);
                    boolean $i$f$any = false;
                    for (void element$iv2 : $this$any$iv) {
                        boolean it = element$iv2.booleanValue();
                        boolean bl5 = false;
                        if (!it) continue;
                        bl3 = true;
                        break block2;
                    }
                    bl3 = false;
                }
                if (!bl3) continue;
                v2 = element$iv;
                break block3;
            }
            v2 = null;
        }
        return v2 != null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean checkSelected(EntityPlayerSP player, Entity entity) {
        Boolean bl2 = EntityUtils.isSelected(entity, true);
        boolean it = bl2;
        boolean bl3 = false;
        if (!it) return false;
        Boolean bl4 = bl2;
        Boolean bl5 = bl4;
        if (bl5 == null) return false;
        Boolean bl6 = bl5;
        boolean it2 = bl6;
        boolean bl7 = false;
        if (!((ClosedRange)this.selectedValue.getValue()).contains((Comparable)Float.valueOf(player.func_70032_d(entity)))) return false;
        Boolean bl8 = bl6;
        bl2 = bl8;
        if (bl2 == null) return false;
        boolean bl9 = bl2;
        return bl9;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean checkProjectile(EntityPlayerSP player, Entity entity) {
        Entity entity2;
        Entity entity3;
        Entity entity4;
        Entity it = entity4 = entity;
        boolean bl2 = false;
        if (!(it instanceof IProjectile)) return false;
        Entity entity5 = entity4;
        Entity entity6 = entity5;
        if (entity6 == null) return false;
        Entity it2 = entity3 = entity6;
        boolean bl3 = false;
        if (it2.field_70122_E) return false;
        boolean bl4 = true;
        if (!bl4) return false;
        Entity entity7 = entity3;
        entity4 = entity7;
        if (entity4 == null) return false;
        Entity it3 = entity2 = entity4;
        boolean bl5 = false;
        if (!((ClosedRange)this.projectileValue.getValue()).contains((Comparable)Float.valueOf(player.func_70032_d(entity)))) return false;
        Entity entity8 = entity2;
        entity3 = entity8;
        if (entity3 == null) return false;
        Entity it4 = entity3;
        return true;
    }
}

