/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.client.UpdateSelectTargetStatusEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.features.module.modules.misc.AntiBot;
import net.ccbluex.liquidbounce.features.module.modules.misc.antibots.AntiBotMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="AntiBot", description="Prevents KillAura from attacking AntiCheat bots.", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0018H\u0007R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/AntiBot;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/antibots/AntiBotMode;", "Lkotlin/collections/HashMap;", "settingsModuleName", "", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "settingsModuleValues", "Lnet/ccbluex/liquidbounce/value/Value;", "onEnable", "", "onWorld", "event", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "isBot", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "onUpdateAllowTargets", "Lnet/ccbluex/liquidbounce/event/events/client/UpdateSelectTargetStatusEvent;", "values", "getValues", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAntiBot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AntiBot.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/AntiBot\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,78:1\n1869#2,2:79\n1563#2:92\n1634#2,3:93\n1056#2:96\n1869#2:97\n1869#2,2:98\n1870#2:100\n1#3:81\n536#4:82\n521#4,6:83\n188#5,3:89\n*S KotlinDebug\n*F\n+ 1 AntiBot.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/AntiBot\n*L\n54#1:79,2\n29#1:92\n29#1:93,3\n30#1:96\n31#1:97\n43#1:98,2\n31#1:100\n66#1:82\n66#1:83,6\n67#1:89,3\n*E\n"})
public final class AntiBot
extends Module {
    @NotNull
    public static final AntiBot INSTANCE;
    @NotNull
    private static final HashMap<String, AntiBotMode> modes;
    @NotNull
    private static final List<BoolValue> settingsModuleName;
    @NotNull
    private static final List<Value<?>> settingsModuleValues;
    @NotNull
    private static final List<Value<?>> values;

    private AntiBot() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onEnable() {
        Iterable $this$forEach$iv = settingsModuleName;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            BoolValue it = (BoolValue)element$iv;
            boolean bl2 = false;
            if (!((Boolean)it.get()).booleanValue()) continue;
            AntiBotMode antiBotMode = modes.get(it.getName());
            if (antiBotMode == null) continue;
            antiBotMode.onReload();
        }
    }

    @EventTarget
    public final void onWorld(@NotNull WorldEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.onEnable();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static final boolean isBot(@NotNull EntityLivingBase entity) {
        AntiBotMode check;
        boolean bl2;
        EntityPlayer entityPlayer;
        void $this$any$iv;
        void $this$filterTo$iv$iv;
        HashMap<String, AntiBotMode> hashMap;
        HashMap<String, AntiBotMode> hashMap2;
        Intrinsics.checkNotNullParameter(entity, "entity");
        HashMap<String, AntiBotMode> it = hashMap2 = modes;
        boolean bl3 = false;
        if (!(entity instanceof EntityPlayer)) return false;
        HashMap<String, AntiBotMode> hashMap3 = hashMap2;
        HashMap<String, AntiBotMode> hashMap4 = hashMap3;
        if (hashMap4 == null) return false;
        HashMap<String, AntiBotMode> hashMap5 = hashMap = hashMap4;
        boolean bl4 = false;
        if (!INSTANCE.getState()) return false;
        HashMap<String, AntiBotMode> hashMap6 = hashMap;
        hashMap2 = hashMap6;
        if (hashMap2 == null) return false;
        Map map = hashMap2;
        boolean $i$f$filter22 = false;
        Map map2 = map;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        Object object = $this$filterTo$iv$iv.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry element$iv$iv;
            Map.Entry entry = element$iv$iv = object.next();
            boolean bl5 = false;
            AntiBotMode check2 = (AntiBotMode)entry.getValue();
            if (!((Boolean)check2.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
        }
        Map $i$f$filter22 = destination$iv$iv;
        boolean $i$f$any = false;
        if ($this$any$iv.isEmpty()) {
            return false;
        }
        Iterator iterator2 = $this$any$iv.entrySet().iterator();
        do {
            if (!iterator2.hasNext()) return false;
            Map.Entry element$iv = iterator2.next();
            object = element$iv;
            boolean bl6 = false;
            entityPlayer = entity instanceof EntityPlayer ? (EntityPlayer)entity : null;
        } while (!(entityPlayer == null ? (bl2 = false) : (check = (AntiBotMode)object.getValue()).isBot(entityPlayer)));
        return true;
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
                Object object2 = entityPlayer = AntiBot.isBot(it2) ? entityLivingBase2 : null;
                if (entityPlayer != null) {
                    it2 = entityLivingBase2 = entityPlayer;
                    boolean bl4 = false;
                    event.setFriendEntity();
                }
            }
        }
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return values;
    }

    private static final boolean lambda$5$lambda$4$lambda$3(4.modulesMode.1 $modulesMode) {
        return (Boolean)$modulesMode.get();
    }

    /*
     * WARNING - void declaration
     */
    static {
        List<Class<AntiBotMode>> list;
        List<Class<AntiBotMode>> list2;
        INSTANCE = new AntiBot();
        modes = new HashMap();
        settingsModuleName = new ArrayList();
        settingsModuleValues = new ArrayList();
        List<Class<AntiBotMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(INSTANCE.getClass().getPackage().getName() + ".antibots", AntiBotMode.class);
        boolean bl2 = false;
        List<Class<AntiBotMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
        if (list != null) {
            String it2;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((AntiBotMode)((Class)((Object)it2)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $this$sortedBy$iv = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    AntiBotMode it = (AntiBotMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getModeName());
                    it = (AntiBotMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
                }
            });
            if (list4 != null) {
                Iterable $this$forEach$iv = list4;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    AntiBotMode it3 = (AntiBotMode)element$iv;
                    boolean bl4 = false;
                    it2 = it3.getModeName();
                    BoolValue modulesMode2 = new BoolValue(it3, it2){
                        final /* synthetic */ AntiBotMode $it;
                        {
                            this.$it = $it;
                            super($super_call_param$1, false);
                        }

                        protected void onChange(boolean oldValue, boolean newValue) {
                            if (AntiBot.INSTANCE.getState() && newValue) {
                                this.$it.onReload();
                            }
                        }
                    };
                    it3.setInstance(INSTANCE);
                    it3.setLinkedStatValue(modulesMode2);
                    settingsModuleName.add(modulesMode2);
                    settingsModuleValues.add(modulesMode2);
                    Iterable $this$forEach$iv2 = it3.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl5 = false;
                        settingsModuleValues.add(value.displayable(() -> AntiBot.lambda$5$lambda$4$lambda$3(modulesMode2)));
                    }
                    ((Map)modes).put(it3.getModeName(), it3);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it3);
                    EventManager.registerListener$default(eventManager, it3, false, false, 6, null);
                }
            }
        }
        values = settingsModuleValues;
    }
}

