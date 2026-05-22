/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.StuckModule;
import net.ccbluex.liquidbounce.features.module.modules.player.stucks.sync.StuckSyncMovementModule;
import net.ccbluex.liquidbounce.handler.movement.stuck.MovementStuckManagerExtend;
import net.ccbluex.liquidbounce.handler.rotation.data.Rotation;
import net.ccbluex.liquidbounce.handler.rotation.data.RotationTask;
import net.ccbluex.liquidbounce.injection.extend.entity.ExtendEntityPlayerSP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckModuleSyncMovement;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/StuckModule;", "<init>", "()V", "modes", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckSyncMovementModule;", "Lkotlin/collections/HashMap;", "settingsModuleValues", "", "Lnet/ccbluex/liquidbounce/value/Value;", "onPositionUpdateTicksLimitValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "doSyncMovement", "", "tryDoSyncMovement", "", "event", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "value", "values", "getValues", "()Ljava/util/List;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nStuckModuleSyncMovement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StuckModuleSyncMovement.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckModuleSyncMovement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1563#2:117\n1634#2,3:118\n1056#2:121\n2756#2:122\n1869#2,2:124\n1#3:123\n1#3:126\n*S KotlinDebug\n*F\n+ 1 StuckModuleSyncMovement.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckModuleSyncMovement\n*L\n47#1:117\n47#1:118,3\n48#1:121\n49#1:122\n57#1:124,2\n49#1:123\n*E\n"})
public final class StuckModuleSyncMovement
extends StuckModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final HashMap<String, StuckSyncMovementModule> modes = new HashMap();
    @NotNull
    private final List<Value<?>> settingsModuleValues = new ArrayList();
    @JvmField
    @NotNull
    public final ListValue onPositionUpdateTicksLimitValue;
    @NotNull
    private final List<Value<?>> values;
    @NotNull
    private static final String[] SETTINGS;

    public StuckModuleSyncMovement() {
        super("SyncMovement", false, true, 2, null);
        StuckSyncMovementModule it;
        Iterable $this$mapTo$iv$iv;
        Object object = new String[]{"Cancel", "Travel", "Ignore"};
        this.onPositionUpdateTicksLimitValue = new ListValue("OnPositionUpdateTicksLimit", (String[])object, "Travel");
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".impl", StuckSyncMovementModule.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((StuckSyncMovementModule)((Class)((Object)it)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$onEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                StuckSyncMovementModule it = (StuckSyncMovementModule)a2;
                boolean bl2 = false;
                Comparable comparable = (Comparable)((Object)it.getModeName());
                it = (StuckSyncMovementModule)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getModeName()));
            }
        });
        boolean $i$f$onEach = false;
        Iterable $this$onEach_u24lambda_u2418$iv = $this$mapTo$iv$iv = $this$onEach$iv;
        boolean bl3 = false;
        for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
            it = (StuckSyncMovementModule)element$iv;
            boolean bl4 = false;
            ListValue modulesMode2 = new ListValue(it.getModeName(), SETTINGS, "SyncOrCancel");
            it.setInstance(this);
            it.setLinkedStatValue(modulesMode2);
            this.settingsModuleValues.add(modulesMode2);
            Iterable $this$forEach$iv = it.getValues();
            boolean $i$f$forEach = false;
            for (Object element$iv2 : $this$forEach$iv) {
                Value value = (Value)element$iv2;
                boolean bl5 = false;
                this.settingsModuleValues.add(value);
            }
            ((Map)this.modes).put(it.getModeName(), it);
            EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
            Intrinsics.checkNotNull(it);
            EventManager.registerListener$default(eventManager, it, false, false, 6, null);
        }
        object = $this$mapTo$iv$iv;
        List it2 = (List)object;
        boolean bl6 = false;
        this.settingsModuleValues.add(this.onPositionUpdateTicksLimitValue);
        this.values = this.settingsModuleValues;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean doSyncMovement() {
        boolean bl2;
        EntityPlayerSP entityPlayerSP;
        block9: {
            block7: {
                block8: {
                    EntityPlayerSP entityPlayerSP2;
                    EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
                    if (entityPlayerSP3 == null) return true;
                    EntityPlayerSP player = entityPlayerSP2 = entityPlayerSP3;
                    boolean bl3 = false;
                    Rotation rotation = DarkMeow.INSTANCE.getRotationManager().serverRotation;
                    Object object = DarkMeow.INSTANCE.getRotationManager().getTask();
                    if (object == null || (object = ((RotationTask)object).getRotation()) == null) {
                        object = new Rotation((Entity)player);
                    }
                    if (Intrinsics.areEqual(rotation, object)) return true;
                    boolean bl4 = true;
                    if (!bl4) return true;
                    EntityPlayerSP entityPlayerSP4 = entityPlayerSP2;
                    EntityPlayerSP entityPlayerSP5 = entityPlayerSP4;
                    if (entityPlayerSP5 == null) return true;
                    EntityPlayerSP player2 = entityPlayerSP5;
                    boolean bl5 = false;
                    EntityPlayerSP it = entityPlayerSP = player2;
                    boolean bl6 = false;
                    if (ExtendEntityPlayerSP.INSTANCE.getPositionUpdateTicks(it) <= 18) break block7;
                    String string = (String)this.onPositionUpdateTicksLimitValue.get();
                    switch (string.hashCode()) {
                        case -1781830854: {
                            if (string.equals("Travel")) break;
                            return false;
                        }
                        case -2106529294: {
                            if (!string.equals("Ignore")) {
                                return false;
                            }
                            break block8;
                        }
                        case 2011110042: {
                            if (!string.equals("Cancel")) return false;
                            return false;
                        }
                    }
                    MovementStuckManagerExtend.travelOnStuck$default(MovementStuckManagerExtend.INSTANCE, it, 0.0f, 0.0f, 0.0f, 7, null);
                    Unit it2 = Unit.INSTANCE;
                    boolean bl7 = false;
                    bl2 = true;
                    break block9;
                }
                bl2 = true;
                break block9;
                return false;
            }
            bl2 = true;
        }
        if (!bl2) return false;
        EntityPlayerSP entityPlayerSP6 = entityPlayerSP;
        EntityPlayerSP entityPlayerSP7 = entityPlayerSP6;
        if (entityPlayerSP7 == null) return false;
        MovementStuckManagerExtend.INSTANCE.syncPositionToServerOnStuck(entityPlayerSP7);
        Unit it = Unit.INSTANCE;
        return true;
    }

    public final void tryDoSyncMovement(@NotNull CancellableEvent event, @NotNull ListValue value) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(value, "value");
        switch ((String)value.get()) {
            case "SyncOrCancel": {
                if (this.doSyncMovement()) break;
                event.cancelEventAndNext();
                break;
            }
            case "SyncOrNone": {
                this.doSyncMovement();
                break;
            }
            case "Cancel": {
                event.cancelEventAndNext();
            }
        }
    }

    @Override
    @NotNull
    public List<Value<?>> getValues() {
        return this.values;
    }

    static {
        String[] stringArray = new String[]{"SyncOrCancel", "SyncOrNone", "Cancel", "None"};
        SETTINGS = stringArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/stucks/sync/StuckModuleSyncMovement$Companion;", "", "<init>", "()V", "SETTINGS", "", "", "getSETTINGS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String[] getSETTINGS() {
            return SETTINGS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

