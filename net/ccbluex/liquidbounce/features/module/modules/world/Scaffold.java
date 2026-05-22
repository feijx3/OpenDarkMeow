/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.event.events.player.move.PlayerSPUpdateWalkingEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldExtend;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldSelectMode;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldStatic;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.impl.MovementModeSilent;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayer;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J \u0010/\u001a\u00020!2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020!H\u0002J\u0012\u00105\u001a\u000206*\u00020'2\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u0004\u0018\u00010'2\u0006\u00100\u001a\u000201J\u001c\u0010:\u001a\u0004\u0018\u000108*\u00020'2\u0006\u00100\u001a\u0002012\u0006\u00104\u001a\u00020!J\u0012\u0010;\u001a\u000206*\u00020'2\u0006\u00100\u001a\u000201R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>\u00a8\u0006@"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "settingsSelectModeValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "selectModes", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldSelectMode;", "Lkotlin/collections/LinkedHashMap;", "settingsExtendsValues", "extends", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldExtend;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "spartanValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "placeDelayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "selectModeValue", "placeSwingValue", "offGroundTicks", "", "getOffGroundTicks", "()I", "setOffGroundTicks", "(I)V", "onGroundTicks", "getOnGroundTicks", "setOnGroundTicks", "allowTelly", "", "getAllowTelly", "()Z", "setAllowTelly", "(Z)V", "placeData", "Lnet/minecraft/util/math/BlockPos;", "getPlaceData", "()Lnet/minecraft/util/math/BlockPos;", "setPlaceData", "(Lnet/minecraft/util/math/BlockPos;)V", "onEnable", "", "onDisable", "place", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "world", "Lnet/minecraft/client/multiplayer/WorldClient;", "allowUp", "getFacingVec3d", "Lnet/minecraft/util/math/Vec3d;", "facing", "Lnet/minecraft/util/EnumFacing;", "getPlacePosition", "getPlaceSide", "getBestHitFeet", "values", "getValues", "()Ljava/util/List;", "RotationModes", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffold.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scaffold.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,353:1\n1#2:354\n1#2:387\n1#2:392\n1#2:397\n1#2:434\n1563#3:355\n1634#3,3:356\n1056#3:359\n1869#3:360\n1869#3,2:361\n1870#3:363\n1563#3:368\n1634#3,3:369\n1056#3:372\n1869#3:373\n1869#3,2:374\n1870#3:376\n774#3:383\n865#3,2:384\n2756#3:386\n774#3:388\n865#3,2:389\n2756#3:391\n774#3:393\n865#3,2:394\n2756#3:396\n1563#3:398\n1634#3,3:399\n774#3:402\n865#3,2:403\n2423#3,14:405\n774#3:419\n865#3:420\n866#3:423\n1617#3,9:424\n1869#3:433\n1870#3:435\n1626#3:436\n2423#3,14:437\n37#4:364\n36#4,3:365\n20#5,3:377\n20#5,3:380\n12434#6,2:421\n*S KotlinDebug\n*F\n+ 1 Scaffold.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold\n*L\n124#1:387\n134#1:392\n228#1:397\n289#1:434\n70#1:355\n70#1:356,3\n71#1:359\n72#1:360\n74#1:361,2\n72#1:363\n90#1:368\n90#1:369,3\n91#1:372\n92#1:373\n100#1:374,2\n92#1:376\n123#1:383\n123#1:384,2\n124#1:386\n133#1:388\n133#1:389,2\n134#1:391\n227#1:393\n227#1:394,2\n228#1:396\n264#1:398\n264#1:399,3\n269#1:402\n269#1:403,2\n270#1:405,14\n278#1:419\n278#1:420\n278#1:423\n289#1:424,9\n289#1:433\n289#1:435\n289#1:436\n295#1:437,14\n86#1:364\n86#1:365,3\n138#1:377,3\n144#1:380,3\n284#1:421,2\n*E\n"})
public final class Scaffold
extends Module {
    @NotNull
    private final List<Value<?>> settingsSelectModeValues = new ArrayList();
    @NotNull
    private final LinkedHashMap<String, ScaffoldSelectMode> selectModes = new LinkedHashMap();
    @NotNull
    private final List<Value<?>> settingsExtendsValues = new ArrayList();
    @NotNull
    private final LinkedHashMap<String, ScaffoldExtend> extends = new LinkedHashMap();
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final BoolValue spartanValue;
    @JvmField
    @NotNull
    public final IntegerValue placeDelayValue;
    @JvmField
    @NotNull
    public final ListValue selectModeValue;
    @JvmField
    @NotNull
    public final ListValue placeSwingValue;
    private int offGroundTicks;
    private int onGroundTicks;
    private boolean allowTelly;
    @Nullable
    private BlockPos placeData;
    @NotNull
    private final List<Value<?>> values;

    /*
     * WARNING - void declaration
     */
    public Scaffold() {
        super("Scaffold", ModuleCategory.WORLD, null, null, 12, null);
        void $this$values_u24lambda_u2465;
        Object $receiver$iv;
        Object $this$forEach$iv;
        Object it;
        boolean $i$f$forEach3;
        boolean $i$f$sortedBy;
        void it2;
        boolean $i$f$mapTo;
        Object destination$iv$iv;
        Iterable<Object> $this$map$iv;
        List<Class<ScaffoldSelectMode>> $this$placeDelayValue_u24lambda_u241;
        String[] $this$placeDelayValue_u24lambda_u240;
        Object object = new String[]{"Telly", "Snap"};
        this.modeValue = new ListValue("Mode", (String[])object, "Telly");
        this.spartanValue = new BoolValue("Spartan", true);
        String[] stringArray = object = new IntegerValue("PlaceDelay", 4, new IntRange(1, 5));
        Object object2 = this;
        boolean bl2 = false;
        $this$placeDelayValue_u24lambda_u240.setSuperValue(this.modeValue);
        $this$placeDelayValue_u24lambda_u240 = object;
        boolean bl3 = false;
        ((Value)((Object)$this$placeDelayValue_u24lambda_u241)).setSuperValueMeta("Telly");
        ((Scaffold)object2).placeDelayValue = object;
        this.selectModeValue = new ListValue("SelectMode", null, "HeldItemChange", 2, null);
        object = new String[]{"Normal", "Silent", "None"};
        this.placeSwingValue = new ListValue("PlaceSwing", (String[])object, "Normal");
        List<Class<MinecraftInstance>> it3 = $this$placeDelayValue_u24lambda_u241 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".scaffolds.selects", ScaffoldSelectMode.class);
        boolean bl4 = false;
        Object object3 = object = !((Collection)it3).isEmpty() ? $this$placeDelayValue_u24lambda_u241 : null;
        if (object != null) {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            $this$map$iv = (List)object;
            boolean $i$f$map22 = false;
            List list = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                object2 = destination$iv$iv;
                boolean bl5 = false;
                object2.add((ScaffoldSelectMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ScaffoldSelectMode it = (ScaffoldSelectMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (ScaffoldSelectMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if ($this$map$iv != null) {
                void $this$forEach$iv2;
                $this$sortedBy$iv = $this$map$iv;
                $i$f$forEach3 = false;
                for (Object element$iv : $this$forEach$iv2) {
                    it = (ScaffoldSelectMode)element$iv;
                    boolean bl6 = false;
                    ((ScaffoldSelectMode)it).setInstance(this);
                    $this$forEach$iv = ((ScaffoldSelectMode)it).getValues();
                    boolean $i$f$forEach2 = false;
                    Iterator iterator2 = $this$forEach$iv.iterator();
                    while (iterator2.hasNext()) {
                        Object element$iv2 = iterator2.next();
                        Value value = (Value)element$iv2;
                        boolean bl7 = false;
                        value.setName("SelectMode" + ((ScaffoldSelectMode)it).getName() + value.getName());
                        value.setSuperValue(this.selectModeValue);
                        value.setSuperValueMeta(((ScaffoldSelectMode)it).getName());
                        this.settingsSelectModeValues.add(value);
                    }
                    ((Map)this.selectModes).put(((ScaffoldSelectMode)it).getName(), it);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it);
                    EventManager.registerListener$default(eventManager, (ListenableOwner)it, false, false, 6, null);
                }
            }
        }
        Set<String> set = this.selectModes.keySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-keys>(...)");
        Object $this$toTypedArray$iv = (List<Class<ScaffoldExtend>>)((Object)set);
        boolean $i$f$toTypedArray22 = false;
        List<Class<ScaffoldExtend>> thisCollection$iv = $this$toTypedArray$iv;
        this.selectModeValue.setValues(thisCollection$iv.toArray(new String[0]));
        Object $i$f$toTypedArray22 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".scaffolds.extend", ScaffoldExtend.class);
        it3 = $i$f$toTypedArray22;
        boolean bl8 = false;
        Object object4 = $this$toTypedArray$iv = !((Collection)it3).isEmpty() ? $i$f$toTypedArray22 : null;
        if ($this$toTypedArray$iv != null) {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            $this$map$iv = (Iterable)$this$toTypedArray$iv;
            boolean $i$f$map32 = false;
            Iterable<Object> $i$f$forEach3 = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                $this$forEach$iv = (Class)item$iv$iv;
                object2 = destination$iv$iv;
                boolean bl9 = false;
                object2.add((ScaffoldExtend)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map32 = (List)destination$iv$iv;
            $i$f$sortedBy = false;
            $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ScaffoldExtend it = (ScaffoldExtend)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (ScaffoldExtend)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if ($this$map$iv != null) {
                void $this$forEach$iv3;
                $this$sortedBy$iv = $this$map$iv;
                $i$f$forEach3 = false;
                for (Object element$iv : $this$forEach$iv3) {
                    it = (ScaffoldExtend)element$iv;
                    boolean bl10 = false;
                    BoolValue modulesMode2 = new BoolValue(((ScaffoldExtend)it).getName(), ((ScaffoldExtend)it).getDefaultState());
                    ((ScaffoldExtend)it).setLinkedStatValue(modulesMode2);
                    ((ScaffoldExtend)it).setInstance(this);
                    this.settingsExtendsValues.add(modulesMode2);
                    Iterable $this$forEach$iv4 = ((ScaffoldExtend)it).getValues();
                    boolean $i$f$forEach4 = false;
                    for (Object element$iv3 : $this$forEach$iv4) {
                        Value value = (Value)element$iv3;
                        boolean bl11 = false;
                        value.setName(((ScaffoldExtend)it).getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(modulesMode2);
                        }
                        this.settingsExtendsValues.add(value);
                    }
                    ((Map)this.extends).put(((ScaffoldExtend)it).getName(), it);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(it);
                    EventManager.registerListener$default(eventManager, (ListenableOwner)it, false, false, 6, null);
                }
            }
        }
        $this$toTypedArray$iv = ListenableOwnerExtends.INSTANCE;
        $i$f$toTypedArray22 = this;
        Function2<SafeListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> Scaffold._init_$lambda$19(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.POST>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(PlayerSPUpdateWalkingEvent.POST.class), (ListenableOwner)$receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> Scaffold._init_$lambda$36(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<PlayerSPUpdateWalkingEvent.POST>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), (ListenableOwner)$receiver$iv));
        $receiver$iv = object = (List)new ArrayList();
        object2 = this;
        boolean bl12 = false;
        $this$values_u24lambda_u2465.add(this.modeValue);
        $this$values_u24lambda_u2465.add(this.placeDelayValue);
        $this$values_u24lambda_u2465.add(this.spartanValue);
        $this$values_u24lambda_u2465.add(this.selectModeValue);
        $this$values_u24lambda_u2465.addAll((Collection)this.settingsSelectModeValues);
        $this$values_u24lambda_u2465.add(this.placeSwingValue);
        $this$values_u24lambda_u2465.addAll((Collection)this.settingsExtendsValues);
        ((Scaffold)object2).values = object;
    }

    public final int getOffGroundTicks() {
        return this.offGroundTicks;
    }

    public final void setOffGroundTicks(int n2) {
        this.offGroundTicks = n2;
    }

    public final int getOnGroundTicks() {
        return this.onGroundTicks;
    }

    public final void setOnGroundTicks(int n2) {
        this.onGroundTicks = n2;
    }

    public final boolean getAllowTelly() {
        return this.allowTelly;
    }

    public final void setAllowTelly(boolean bl2) {
        this.allowTelly = bl2;
    }

    @Nullable
    public final BlockPos getPlaceData() {
        return this.placeData;
    }

    public final void setPlaceData(@Nullable BlockPos blockPos) {
        this.placeData = blockPos;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        ScaffoldExtend it;
        void $this$filterTo$iv$iv;
        Collection<ScaffoldExtend> collection = this.extends.values();
        Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
        Iterable $this$filter$iv = collection;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (ScaffoldExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$onEach$iv = (List)destination$iv$iv;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            it = (ScaffoldExtend)element$iv;
            boolean bl4 = false;
            it.onEnable();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onDisable() {
        ScaffoldExtend it;
        void $this$filterTo$iv$iv;
        this.placeData = null;
        this.allowTelly = false;
        ScaffoldSelectMode scaffoldSelectMode = this.selectModes.get(this.selectModeValue.get());
        if (scaffoldSelectMode != null) {
            scaffoldSelectMode.onDisable();
        }
        Collection<ScaffoldExtend> collection = this.extends.values();
        Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
        Iterable $this$filter$iv = collection;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            it = (ScaffoldExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$onEach$iv = (List)destination$iv$iv;
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = iterable = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            it = (ScaffoldExtend)element$iv;
            boolean bl4 = false;
            it.onDisable();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean place(EntityPlayerSP player, WorldClient world, boolean allowUp) {
        BlockPos blockPos = this.placeData;
        if (blockPos == null) return false;
        EnumFacing enumFacing = this.getPlaceSide(blockPos, player, allowUp);
        if (enumFacing == null) return false;
        EnumFacing facing = enumFacing;
        boolean bl2 = false;
        EnumHand enumHand = ScaffoldStatic.INSTANCE.getScaffoldPlaceHand(player);
        if (enumHand == null) return false;
        EnumHand hand = enumHand;
        boolean bl3 = false;
        Pair<EnumFacing, EnumHand> pair = new Pair<EnumFacing, EnumHand>(facing, hand);
        Pair<EnumFacing, EnumHand> pair2 = pair;
        if (pair2 == null) return false;
        Object object = pair2;
        boolean bl4 = false;
        EnumFacing facing2 = ((Pair)object).component1();
        EnumHand hand2 = ((Pair)object).component2();
        BlockPos blockPos2 = this.placeData;
        if (blockPos2 != null) {
            void $this$onEach$iv;
            ScaffoldExtend it;
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv;
            Object object2;
            EnumActionResult enumActionResult;
            BlockPos placeAt = blockPos2;
            EnumActionResult result = enumActionResult = MinecraftInstance.mc.getPlayerController().func_187099_a(player, world, placeAt, facing2, this.getFacingVec3d(placeAt, facing2), hand2);
            boolean bl5 = false;
            if (result == EnumActionResult.SUCCESS) {
                object2 = (String)this.placeSwingValue.get();
                if (Intrinsics.areEqual(object2, "Normal")) {
                    player.func_184609_a(hand2);
                } else if (Intrinsics.areEqual(object2, "Silent")) {
                    player.field_71174_a.func_147297_a((Packet)new CPacketAnimation(hand2));
                }
            }
            result = enumActionResult;
            boolean bl6 = false;
            ScaffoldSelectMode scaffoldSelectMode = this.selectModes.get(this.selectModeValue.get());
            if (scaffoldSelectMode != null) {
                Intrinsics.checkNotNull(result);
                scaffoldSelectMode.onPlacePost(result);
            }
            Collection<ScaffoldExtend> collection = this.extends.values();
            Intrinsics.checkNotNullExpressionValue(collection, "<get-values>(...)");
            object2 = collection;
            boolean $i$f$filter = false;
            void var18_25 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                it = (ScaffoldExtend)element$iv$iv;
                boolean bl7 = false;
                if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$onEach = false;
            void $this$onEach_u24lambda_u2418$iv = var18_25 = $this$onEach$iv;
            boolean bl8 = false;
            for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                it = (ScaffoldExtend)element$iv;
                boolean bl9 = false;
                Intrinsics.checkNotNull(result);
                it.onPlaced(placeAt, facing2, result);
            }
        }
        Object it = object = Unit.INSTANCE;
        boolean bl10 = false;
        this.placeData = null;
        Unit it2 = Unit.INSTANCE;
        return true;
    }

    @NotNull
    public final Vec3d getFacingVec3d(@NotNull BlockPos $this$getFacingVec3d, @NotNull EnumFacing facing) {
        Intrinsics.checkNotNullParameter($this$getFacingVec3d, "<this>");
        Intrinsics.checkNotNullParameter(facing, "facing");
        return new Vec3d((double)$this$getFacingVec3d.func_177958_n() + 0.5 + (double)facing.func_176730_m().func_177958_n() * 0.5, (double)$this$getFacingVec3d.func_177956_o() + 0.5 + (double)facing.func_176730_m().func_177956_o() * 0.5, (double)$this$getFacingVec3d.func_177952_p() + 0.5 + (double)facing.func_176730_m().func_177952_p() * 0.5);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final BlockPos getPlacePosition(@NotNull EntityPlayerSP player) {
        BlockPos blockPos;
        Object v1;
        void $this$minByOrNull$iv;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        BlockPos pos;
        Iterable iterable;
        Intrinsics.checkNotNullParameter(player, "player");
        BlockPos playerPos = new BlockPos((Entity)player).func_177977_b();
        boolean bl2 = false;
        Set $this$getPlacePosition_u24lambda_u2454_u24lambda_u2448 = iterable = (Set)new LinkedHashSet();
        boolean $i$a$-apply-Scaffold$getPlacePosition$1$22 = false;
        for (int x2 = -5; x2 < 6; ++x2) {
            for (int y2 = -5; y2 < 1; ++y2) {
                for (int z2 = -5; z2 < 6; ++z2) {
                    BlockPos blockPos2;
                    BlockPos blockPos3;
                    pos = blockPos3 = playerPos.func_177982_a(x2, y2, z2);
                    boolean bl3 = false;
                    IBlockState blockState = player.field_70170_p.func_180495_p(pos);
                    Object object = blockPos2 = !blockState.func_185904_a().func_76222_j() && !ArraysKt.contains(ScaffoldStatic.INSTANCE.getInvalidBlocks(), blockState.func_177230_c()) ? blockPos3 : null;
                    if (blockPos2 == null) continue;
                    pos = blockPos3 = blockPos2;
                    boolean bl4 = false;
                    $this$getPlacePosition_u24lambda_u2454_u24lambda_u2448.add(pos);
                }
            }
        }
        iterable = iterable;
        boolean $i$f$map = false;
        void $i$a$-apply-Scaffold$getPlacePosition$1$22 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            pos = (BlockPos)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl5 = false;
            Vec3d vec = this.getBestHitFeet(pos, player);
            boolean bl6 = false;
            collection.add(new Pair<BlockPos, Double>(pos, player.func_174824_e(1.0f).func_186679_c(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c)));
        }
        $this$map$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$mapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Pair it = (Pair)element$iv$iv;
            boolean bl7 = false;
            if (!(((Number)it.getSecond()).doubleValue() < 25.0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$minByOrNull = false;
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v1 = null;
        } else {
            Object minElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v1 = minElem$iv;
            } else {
                Pair it = (Pair)minElem$iv;
                boolean bl8 = false;
                double minValue$iv = ((Number)it.getSecond()).doubleValue();
                do {
                    Object e$iv = iterator$iv.next();
                    Pair it2 = (Pair)e$iv;
                    $i$a$-minByOrNull-Scaffold$getPlacePosition$1$4 = false;
                    double v$iv = ((Number)it2.getSecond()).doubleValue();
                    if (Double.compare(minValue$iv, v$iv) <= 0) continue;
                    minElem$iv = e$iv;
                    minValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v1 = minElem$iv;
            }
        }
        Pair pair = v1;
        if (pair != null) {
            Pair it = pair;
            boolean bl9 = false;
            blockPos = new BlockPos((Vec3i)it.getFirst());
        } else {
            blockPos = null;
        }
        return blockPos;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public final EnumFacing getPlaceSide(@NotNull BlockPos $this$getPlaceSide, @NotNull EntityPlayerSP player, boolean allowUp) {
        Intrinsics.checkNotNullParameter($this$getPlaceSide, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        playerPos = new BlockPos((Entity)player);
        $i$a$-let-Scaffold$getPlaceSide$1 = false;
        var6_6 = EntriesMappings.entries$0;
        $i$f$filter = false;
        var8_9 = $this$filter$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterTo = false;
        for (T element$iv$iv : $this$filterTo$iv$iv) {
            facing = (EnumFacing)element$iv$iv;
            $i$a$-filter-Scaffold$getPlaceSide$1$1 = false;
            block0 : switch (WhenMappings.$EnumSwitchMapping$0[facing.ordinal()]) {
                case 1: {
                    var17_28 = new Boolean[]{allowUp, (Boolean)this.spartanValue.get() == false || (double)player.field_70143_R > 0.2, player.field_70170_p.func_180495_p(playerPos.func_177977_b()).func_185904_a().func_76222_j()};
                    $i$f$all = false;
                    for (void element$iv : $this$all$iv) {
                        it = element$iv.booleanValue();
                        $i$a$-all-Scaffold$getPlaceSide$1$1$1 = false;
                        if (it) continue;
                        v0 = false;
                        break block0;
                    }
                    v0 = true;
                    break;
                }
                case 2: {
                    v0 = false;
                    break;
                }
                default: {
                    v0 = true;
                }
            }
            if (!v0) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        $i$f$mapNotNull = false;
        $this$filterTo$iv$iv = $this$mapNotNull$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$mapNotNullTo = false;
        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        $i$f$forEach = false;
        facing = $this$forEach$iv$iv$iv.iterator();
        while (facing.hasNext()) {
            element$iv$iv = element$iv$iv$iv = facing.next();
            $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
            facing = (EnumFacing)element$iv$iv;
            $i$a$-mapNotNull-Scaffold$getPlaceSide$1$2 = false;
            it = var21_34 = $this$getPlaceSide.func_177972_a(facing);
            $i$a$-takeIf-Scaffold$getPlaceSide$1$2$1 = false;
            v1 /* !! */  = var24_40 = Intrinsics.areEqual(it, playerPos) == false != false ? var21_34 : null;
            if (var24_40 == null) ** GOTO lbl-1000
            it = var22_36 = var24_40;
            $i$a$-takeIf-Scaffold$getPlaceSide$1$2$2 = false;
            v2 /* !! */  = var21_34 = player.field_70170_p.func_180495_p(it).func_185904_a().func_76222_j() != false ? var22_36 : null;
            if (var21_34 != null) {
                it = var21_34;
                $i$a$-let-Scaffold$getPlaceSide$1$2$3 = false;
                v3 = new Pair<EnumFacing, Vec3d>(facing, this.getBestHitFeet(it, player));
            } else lbl-1000:
            // 2 sources

            {
                v3 = null;
            }
            if (v3 == null) continue;
            it$iv$iv = v3;
            $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
            destination$iv$iv.add(it$iv$iv);
        }
        $this$mapNotNull$iv = (List)destination$iv$iv;
        $i$f$minByOrNull = false;
        iterator$iv = $this$minByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v4 = null;
        } else {
            minElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v4 = minElem$iv;
            } else {
                $i$f$mapNotNullTo = (Pair)minElem$iv;
                $i$a$-minByOrNull-Scaffold$getPlaceSide$1$3 = false;
                vec = (Vec3d)$i$f$mapNotNullTo.component2();
                minValue$iv = player.func_70011_f(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c);
                do {
                    e$iv = iterator$iv.next();
                    vec = (Pair)e$iv;
                    $i$a$-minByOrNull-Scaffold$getPlaceSide$1$3 = false;
                    vec = (Vec3d)vec.component2();
                    v$iv = player.func_70011_f(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c);
                    if (Double.compare(minValue$iv, v$iv) <= 0) continue;
                    minElem$iv = e$iv;
                    minValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v4 = minElem$iv;
            }
        }
        var28_44 = v4;
        if (var28_44 == null) ** GOTO lbl-1000
        var8_9 = var7_8 = var28_44;
        $i$a$-takeIf-Scaffold$getPlaceSide$1$4 = false;
        vec = (Vec3d)var8_9.component2();
        vec3 = this.getBestHitFeet($this$getPlaceSide, player);
        v5 = var6_6 = player.func_70011_f(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c) <= player.func_70011_f(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c) != false ? var7_8 : null;
        if (var6_6 != null) {
            v6 = (EnumFacing)var6_6.getFirst();
        } else lbl-1000:
        // 2 sources

        {
            v6 = null;
        }
        return v6;
    }

    @NotNull
    public final Vec3d getBestHitFeet(@NotNull BlockPos $this$getBestHitFeet, @NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter($this$getBestHitFeet, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        AxisAlignedBB box = player.field_70170_p.func_180495_p($this$getBestHitFeet).func_185900_c((IBlockAccess)player.field_70170_p, $this$getBestHitFeet);
        boolean bl2 = false;
        return new Vec3d(RangesKt.coerceIn(player.field_70165_t, (double)$this$getBestHitFeet.func_177958_n(), (double)$this$getBestHitFeet.func_177958_n() + box.field_72336_d), RangesKt.coerceIn(player.field_70163_u, (double)$this$getBestHitFeet.func_177956_o(), (double)$this$getBestHitFeet.func_177956_o() + box.field_72337_e), RangesKt.coerceIn(player.field_70161_v, (double)$this$getBestHitFeet.func_177952_p(), (double)$this$getBestHitFeet.func_177952_p() + box.field_72334_f));
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }

    private static final Unit _init_$lambda$19(Scaffold this$0, SafeListenerBase $this$safeListener, PlayerSPUpdateWalkingEvent.POST it) {
        block2: {
            BlockPos blockPos;
            BlockPos blockPos2;
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(it, "it");
            BlockPos blockPos3 = this$0.placeData;
            if (blockPos3 == null) break block2;
            BlockPos it2 = blockPos2 = blockPos3;
            boolean bl2 = false;
            Object object = blockPos = this$0.allowTelly ? blockPos2 : null;
            if (blockPos != null) {
                BlockPos blockPos4;
                BlockPos it3 = blockPos4 = blockPos;
                boolean bl3 = false;
                RotationTask rotationTask = DarkMeow.INSTANCE.getRotationManager().getTask();
                Object object2 = blockPos2 = Intrinsics.areEqual(rotationTask != null ? rotationTask.getName() : null, this$0.getName()) ? blockPos4 : null;
                if (blockPos2 != null) {
                    it3 = blockPos4 = blockPos2;
                    boolean bl4 = false;
                    EntityPlayerSP entityPlayerSP = $this$safeListener.getPlayer();
                    WorldClient worldClient = $this$safeListener.getWorld();
                    KeyBinding keyBinding = $this$safeListener.getMc().field_71474_y.field_74314_A;
                    Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindJump");
                    this$0.place(entityPlayerSP, worldClient, KeyUtils.INSTANCE.isKeyDownSystem(keyBinding));
                }
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static final Unit _init_$lambda$36(Scaffold this$0, SafeListenerBase $this$safeListener, MovementInputEvent.PRE event) {
        block14: {
            Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
            Intrinsics.checkNotNullParameter(event, "event");
            this$0.onGroundTicks = $this$safeListener.getPlayer().field_70122_E != false ? this$0.onGroundTicks + 1 : 0;
            this$0.offGroundTicks = $this$safeListener.getPlayer().field_70122_E == false ? this$0.offGroundTicks + 1 : 0;
            ExtendEntityPlayer.INSTANCE.setFlyToggleTimer((EntityPlayer)$this$safeListener.getPlayer(), 0);
            this$0.placeData = this$0.getPlacePosition($this$safeListener.getPlayer());
            var5_4 = var4_3 /* !! */  = $this$safeListener.getPlayer();
            var13_5 = this$0;
            $i$a$-takeIf-Scaffold$10$1 = false;
            var14_12 = Intrinsics.areEqual(this$0.modeValue.get(), "Telly");
            v0 = var13_5;
            v1 /* !! */  = var3_13 = var14_12 != false ? var4_3 /* !! */  : null;
            if (var3_13 == null || (var4_3 /* !! */  = var3_13.field_70170_p) == null || (it /* !! */  = var4_3 /* !! */ .func_180495_p(new BlockPos((Entity)$this$safeListener.getPlayer()).func_177981_b(2))) == null) ** GOTO lbl-1000
            var8_19 = var7_14 = it /* !! */ ;
            var13_5 = v0;
            $i$a$-takeIf-Scaffold$10$2 = false;
            var14_12 = it.func_177230_c() instanceof BlockAir;
            v0 = var13_5;
            v2 /* !! */  = $i$a$-takeIf-Scaffold$10$1 = var14_12 != false ? var7_14 : null;
            if ($i$a$-takeIf-Scaffold$10$1 != null) {
                $i$a$-takeIf-Scaffold$10$2 = $i$a$-takeIf-Scaffold$10$1;
                var13_5 = v0;
                $i$a$-let-Scaffold$10$3 = false;
                v3 = $this$safeListener.getMc().field_71474_y.field_74314_A;
                Intrinsics.checkNotNullExpressionValue(v3, "keyBindJump");
                var14_12 = KeyUtils.INSTANCE.isKeyDownSystem(v3) ? this$0.offGroundTicks >= ((Boolean)this$0.spartanValue.get() != false ? 3 : 1) : this$0.offGroundTicks >= ((Number)this$0.placeDelayValue.get()).intValue();
                v0 = var13_5;
                v4 = var14_12;
            } else lbl-1000:
            // 2 sources

            {
                v4 = true;
            }
            v0.allowTelly = v4;
            var3_13 = this$0.placeData;
            if (var3_13 != null) {
                it = it /* !! */  = var3_13;
                $i$a$-takeIf-Scaffold$10$4 = false;
                v5 /* !! */  = var4_3 /* !! */  = this$0.allowTelly != false ? it /* !! */  : null;
                if (var4_3 /* !! */  != null) {
                    it /* !! */  = var4_3 /* !! */ ;
                    $i$a$-let-Scaffold$10$5 = false;
                    it /* !! */  = (EntityPlayerSP)RotationModes.INSTANCE.getRotationBlock($this$safeListener.getPlayer(), (BlockPos)it /* !! */ );
                    if (it /* !! */  != null) {
                        rotation = it = it /* !! */ ;
                        $i$a$-also-Scaffold$10$6 = false;
                        DarkMeow.INSTANCE.getRotationManager().addTask(new RotationTask(this$0.getName(), new Rotation((float)rotation[0], (float)rotation[1]), MovementModeSilent.INSTANCE, 0));
                    }
                }
            }
            it /* !! */  = var4_3 /* !! */  = event;
            $i$a$-takeIf-Scaffold$10$7 = false;
            v6 /* !! */  = var3_13 = this$0.allowTelly == false != false ? var4_3 /* !! */  : null;
            if (var3_13 != null) {
                it = var5_4 = var3_13;
                $i$a$-takeIf-Scaffold$10$8 = false;
                v7 /* !! */  = var4_3 /* !! */  = this$0.onGroundTicks > 0 != false ? var5_4 : null;
                if (var4_3 /* !! */  != null) {
                    it = it = var4_3 /* !! */ ;
                    $i$a$-takeIf-Scaffold$10$9 = false;
                    v8 /* !! */  = var5_4 = this$0.offGroundTicks == 0 != false ? it : null;
                    if (var5_4 != null) {
                        it = it = var5_4;
                        $i$a$-takeIf-Scaffold$10$10 = false;
                        v9 /* !! */  = it = $this$safeListener.getPlayer().field_70122_E != false ? it : null;
                        if (it != null) {
                            it = var8_22 = it;
                            $i$a$-takeIf-Scaffold$10$11 = false;
                            v10 /* !! */  = it = MovementInputEvent.PRE.isMoving$default(event, false, false, 3, null) != false ? var8_22 : null;
                            if (it != null) {
                                it = var9_26 = it;
                                $i$a$-takeIf-Scaffold$10$12 = false;
                                v11 /* !! */  = var8_22 = event.getKeyStateSneak() == false != false ? var9_26 : null;
                                if (var8_22 != null) {
                                    it = var10_28 = var8_22;
                                    $i$a$-takeIf-Scaffold$10$13 = false;
                                    v12 /* !! */  = var9_26 = $this$safeListener.getPlayer().field_70170_p.func_180495_p(new BlockPos((Entity)$this$safeListener.getPlayer()).func_177981_b(2)).func_177230_c() instanceof BlockAir != false ? var10_28 : null;
                                    if (var9_26 != null) {
                                        it = var10_28 = var9_26;
                                        $i$a$-also-Scaffold$10$14 = false;
                                        it.setKeyStateJump(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            var3_13 = this$0.placeData;
            if (var3_13 == null) break block14;
            it = var5_4 = var3_13;
            $i$a$-takeIf-Scaffold$10$15 = false;
            v13 /* !! */  = var4_3 /* !! */  = this$0.allowTelly != false ? var5_4 : null;
            if (var4_3 /* !! */  != null) {
                it = var5_4 = var4_3 /* !! */ ;
                $i$a$-also-Scaffold$10$16 = false;
                v14 = this$0.selectModes.get(this$0.selectModeValue.get());
                if (v14 != null) {
                    v14.onPlacePre();
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<EnumFacing> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])EnumFacing.values()));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold$RotationModes;", "", "<init>", "()V", "getRotationsByVec", "", "origin", "Lnet/minecraft/util/math/Vec3d;", "position", "getRotationBlock", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "pos", "Lnet/minecraft/util/math/BlockPos;", "flat", "vec3", "DarkMeow"})
    public static final class RotationModes {
        @NotNull
        public static final RotationModes INSTANCE = new RotationModes();

        private RotationModes() {
        }

        @NotNull
        public final float[] getRotationsByVec(@NotNull Vec3d origin, @NotNull Vec3d position) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            Intrinsics.checkNotNullParameter(position, "position");
            Vec3d vec3d = position.func_178788_d(origin);
            Intrinsics.checkNotNullExpressionValue(vec3d, "subtract(...)");
            Vec3d difference = vec3d;
            double distance = this.flat(difference).func_72433_c();
            float yaw = (float)Math.toDegrees(Math.atan2(difference.field_72449_c, difference.field_72450_a)) - 90.0f;
            float pitch = (float)(-Math.toDegrees(Math.atan2(difference.field_72448_b, distance)));
            float[] fArray = new float[]{yaw, pitch};
            return fArray;
        }

        @NotNull
        public final float[] getRotationBlock(@NotNull EntityPlayerSP player, @NotNull BlockPos pos) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(pos, "pos");
            Vec3d position = new Vec3d((double)pos.func_177958_n() + 0.5, (double)pos.func_177956_o() + 0.5, (double)pos.func_177952_p() + 0.5);
            Vec3d vec3d = player.func_174791_d().func_72441_c(0.0, (double)player.func_70047_e(), 0.0);
            Intrinsics.checkNotNullExpressionValue(vec3d, "add(...)");
            return this.getRotationsByVec(vec3d, position);
        }

        @NotNull
        public final Vec3d flat(@NotNull Vec3d vec3) {
            Intrinsics.checkNotNullParameter(vec3, "vec3");
            return new Vec3d(vec3.field_72450_a, 0.0, vec3.field_72449_c);
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[EnumFacing.values().length];
            try {
                nArray[EnumFacing.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[EnumFacing.DOWN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

