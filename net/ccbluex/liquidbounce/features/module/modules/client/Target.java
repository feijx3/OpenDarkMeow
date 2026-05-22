/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import com.google.gson.JsonElement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.client.UpdateSelectTargetStatusEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.handler.combat.targets.EnumTargetAllowStatus;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.EntityUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="Target", category=ModuleCategory.CLIENT, canEnable=false)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/Target;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "deathValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "invisibleValue", "playerValue", "entityStates", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getEntityStates", "()Ljava/util/HashMap;", "onUpdateAllowTargets", "", "event", "Lnet/ccbluex/liquidbounce/event/events/client/UpdateSelectTargetStatusEvent;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nTarget.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Target.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/Target\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class Target
extends Module {
    @NotNull
    public static final Target INSTANCE;
    @JvmField
    @NotNull
    public static final BoolValue deathValue;
    @JvmField
    @NotNull
    public static final BoolValue invisibleValue;
    @JvmField
    @NotNull
    public static final BoolValue playerValue;
    @NotNull
    private static final HashMap<String, Boolean> entityStates;

    private Target() {
        super(null, null, null, null, 15, null);
    }

    @NotNull
    public final HashMap<String, Boolean> getEntityStates() {
        return entityStates;
    }

    @EventTarget(ignoreCondition=true)
    public final void onUpdateAllowTargets(@NotNull UpdateSelectTargetStatusEvent event) {
        block7: {
            boolean bl2;
            EntityLivingBase entityLivingBase;
            EntityLivingBase entityLivingBase2;
            EntityLivingBase entityLivingBase3;
            Intrinsics.checkNotNullParameter(event, "event");
            EntityLivingBase it = entityLivingBase3 = event.getTarget();
            boolean bl3 = false;
            Object object = entityLivingBase2 = (Boolean)deathValue.get() == false || it.func_70089_S() ? entityLivingBase3 : null;
            if (entityLivingBase2 == null) break block7;
            EntityLivingBase it2 = entityLivingBase = entityLivingBase2;
            boolean bl4 = false;
            boolean bl5 = it2 instanceof EntityPlayer;
            if (bl5) {
                bl2 = (Boolean)playerValue.get();
            } else if (!bl5) {
                Boolean bl6 = entityStates.get(it2.getClass().getName());
                bl2 = bl6 != null ? bl6 : false;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Object object2 = entityLivingBase3 = bl2 ? entityLivingBase : null;
            if (entityLivingBase3 != null) {
                EntityLivingBase entityLivingBase4;
                EntityLivingBase entityLivingBase5;
                EntityLivingBase it3 = entityLivingBase5 = entityLivingBase3;
                boolean bl7 = false;
                event.setReturnValue(EnumTargetAllowStatus.ONLY_RENDER);
                EntityLivingBase it4 = entityLivingBase4 = entityLivingBase5;
                boolean bl8 = false;
                Object object3 = entityLivingBase5 = (Boolean)invisibleValue.get() != false || !it4.func_82150_aj() ? entityLivingBase4 : null;
                if (entityLivingBase5 != null) {
                    EntityLivingBase entityLivingBase6;
                    EntityLivingBase it5 = entityLivingBase6 = entityLivingBase5;
                    boolean bl9 = false;
                    EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
                    Object object4 = entityLivingBase4 = !(entityPlayerSP != null ? it5.func_145782_y() == entityPlayerSP.func_145782_y() : false) ? entityLivingBase6 : null;
                    if (entityLivingBase4 != null) {
                        it5 = entityLivingBase6 = entityLivingBase4;
                        boolean bl10 = false;
                        event.setReturnValue(EnumTargetAllowStatus.COMBAT);
                    }
                }
            }
        }
    }

    static {
        Class<? extends Entity>[] classArray;
        INSTANCE = new Target();
        deathValue = new BoolValue("Death", false);
        invisibleValue = new BoolValue("Invisible", true);
        playerValue = new BoolValue("Player", true);
        entityStates = new HashMap();
        BoolValue[] boolValueArray = new BoolValue[]{deathValue, invisibleValue, playerValue};
        INSTANCE.getValues().addAll((Collection)CollectionsKt.mutableListOf(boolValueArray));
        for (Class<? extends Entity> it : classArray = EntityUtils.INSTANCE.getENTITY_CLASSES()) {
            String string;
            String string2;
            boolean bl2 = false;
            List<Value<?>> list = INSTANCE.getValues();
            Intrinsics.checkNotNullExpressionValue(it.getSimpleName(), "getSimpleName(...)");
            int n2 = 6;
            Intrinsics.checkNotNullExpressionValue(string2.substring(n2), "substring(...)");
            list.add(new BoolValue(it, string){
                final /* synthetic */ Class<? extends Entity> $it;
                {
                    this.$it = $it;
                    super($super_call_param$1, false);
                }

                protected void onChange(boolean oldValue, boolean newValue) {
                    ((Map)Target.INSTANCE.getEntityStates()).put(this.$it.getName(), newValue);
                }

                public void fromJson(JsonElement element) {
                    Intrinsics.checkNotNullParameter(element, "element");
                    super.fromJson(element);
                    this.onChange((Boolean)this.getValue(), (Boolean)this.getValue());
                }
            });
        }
    }
}

