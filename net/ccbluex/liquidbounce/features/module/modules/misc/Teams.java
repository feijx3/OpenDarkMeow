/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.util.text.ITextComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.client.UpdateSelectTargetStatusEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Teams", description="Prevents Killaura from attacking team mates.", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/Teams;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "scoreboardValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "colorValue", "gommeSWValue", "armorColorValue", "isInYourTeam", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "onUpdateAllowTargets", "", "event", "Lnet/ccbluex/liquidbounce/event/events/client/UpdateSelectTargetStatusEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nTeams.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Teams.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/Teams\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class Teams
extends Module {
    @NotNull
    private final BoolValue scoreboardValue = new BoolValue("ScoreboardTeam", true);
    @NotNull
    private final BoolValue colorValue = new BoolValue("Color", true);
    @NotNull
    private final BoolValue gommeSWValue = new BoolValue("GommeSW", false);
    @NotNull
    private final BoolValue armorColorValue = new BoolValue("ArmorColor", false);

    public Teams() {
        super(null, null, null, null, 15, null);
    }

    public final boolean isInYourTeam(@NotNull EntityLivingBase entity) {
        String clientName;
        String targetName;
        Intrinsics.checkNotNullParameter(entity, "entity");
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return false;
        }
        EntityPlayerSP player = entityPlayerSP;
        if (((Boolean)this.scoreboardValue.get()).booleanValue() && player.func_96124_cp() != null && entity.func_96124_cp() != null) {
            Team team = player.func_96124_cp();
            Intrinsics.checkNotNull(team);
            Team team2 = entity.func_96124_cp();
            Intrinsics.checkNotNull(team2);
            if (team.func_142054_a(team2)) {
                return true;
            }
        }
        ITextComponent displayName = player.func_145748_c_();
        if (((Boolean)this.armorColorValue.get()).booleanValue()) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if (player.field_71071_by.field_70460_b.get(3) != null && entityPlayer.field_71071_by.field_70460_b.get(3) != null) {
                Object object = player.field_71071_by.field_70460_b.get(3);
                Intrinsics.checkNotNullExpressionValue(object, "get(...)");
                ItemStack myHead = (ItemStack)object;
                Item item = myHead.func_77973_b();
                Intrinsics.checkNotNull(item);
                ItemArmor myItemArmor = (ItemArmor)item;
                Object object2 = entityPlayer.field_71071_by.field_70460_b.get(3);
                Intrinsics.checkNotNullExpressionValue(object2, "get(...)");
                ItemStack entityHead = (ItemStack)object2;
                Item item2 = myHead.func_77973_b();
                Intrinsics.checkNotNull(item2);
                ItemArmor entityItemArmor = (ItemArmor)item2;
                if (myItemArmor.func_82814_b(myHead) == entityItemArmor.func_82814_b(entityHead)) {
                    return true;
                }
            }
        }
        if (((Boolean)this.gommeSWValue.get()).booleanValue() && displayName != null && entity.func_145748_c_() != null) {
            ITextComponent iTextComponent = entity.func_145748_c_();
            Intrinsics.checkNotNull(iTextComponent);
            String string = iTextComponent.func_150254_d();
            Intrinsics.checkNotNullExpressionValue(string, "getFormattedText(...)");
            targetName = StringsKt.replace$default(string, "\u00a7r", "", false, 4, null);
            String string2 = displayName.func_150254_d();
            Intrinsics.checkNotNullExpressionValue(string2, "getFormattedText(...)");
            clientName = StringsKt.replace$default(string2, "\u00a7r", "", false, 4, null);
            if (StringsKt.startsWith$default(targetName, "T", false, 2, null) && StringsKt.startsWith$default(clientName, "T", false, 2, null) && Character.isDigit(targetName.charAt(1)) && Character.isDigit(clientName.charAt(1))) {
                return targetName.charAt(1) == clientName.charAt(1);
            }
        }
        if (((Boolean)this.colorValue.get()).booleanValue() && displayName != null && entity.func_145748_c_() != null) {
            ITextComponent iTextComponent = entity.func_145748_c_();
            Intrinsics.checkNotNull(iTextComponent);
            String string = iTextComponent.func_150254_d();
            Intrinsics.checkNotNullExpressionValue(string, "getFormattedText(...)");
            targetName = StringsKt.replace$default(string, "\u00a7r", "", false, 4, null);
            String string3 = displayName.func_150254_d();
            Intrinsics.checkNotNullExpressionValue(string3, "getFormattedText(...)");
            clientName = StringsKt.replace$default(string3, "\u00a7r", "", false, 4, null);
            return StringsKt.startsWith$default(targetName, "" + '\u00a7' + clientName.charAt(1), false, 2, null);
        }
        return false;
    }

    @EventTarget(priority=0)
    public final void onUpdateAllowTargets(@NotNull UpdateSelectTargetStatusEvent event) {
        block2: {
            EntityPlayer entityPlayer;
            EntityPlayer entityPlayer2;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityLivingBase entityLivingBase = event.getTarget();
            EntityPlayer entityPlayer3 = entityPlayer2 = entityLivingBase instanceof EntityPlayer ? (EntityPlayer)entityLivingBase : null;
            if (entityPlayer2 == null) break block2;
            EntityPlayer it = entityPlayer = entityPlayer2;
            boolean bl2 = false;
            Object object = entityLivingBase = !event.isFriendEntity() ? entityPlayer : null;
            if (entityLivingBase != null) {
                EntityLivingBase entityLivingBase2;
                EntityLivingBase it2 = entityLivingBase2 = entityLivingBase;
                boolean bl3 = false;
                Object object2 = entityPlayer = this.isInYourTeam(it2) ? entityLivingBase2 : null;
                if (entityPlayer != null) {
                    it2 = entityLivingBase2 = entityPlayer;
                    boolean bl4 = false;
                    event.setFriendEntity();
                }
            }
        }
    }
}

