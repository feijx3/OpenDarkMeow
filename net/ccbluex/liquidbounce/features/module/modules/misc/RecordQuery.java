/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityNameEvent;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DPlayerTabOverlayEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.mode.RecordQueryMode;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state.RecordQueryState;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state.RecordQueryStateFailed;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state.RecordQueryStateSuccess;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.state.RecordQueryStateWorking;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.KeyUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/RecordQuery;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "modes", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/mode/RecordQueryMode;", "queries", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/state/RecordQueryState;", "query", "profile", "Lcom/mojang/authlib/GameProfile;", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "tabValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "tabFormatValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "nameTagsValue", "nameTagsFormatValue", "debugValue", "onRender2DPlayerTabOverlayPre", "", "event", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DPlayerTabOverlayEvent$PRE;", "onRenderEntityName", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityNameEvent;", "onDisable", "tag", "getTag", "()Ljava/lang/String;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nRecordQuery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordQuery.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/RecordQuery\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,173:1\n1#2:174\n1#2:198\n1#2:204\n1563#3:175\n1634#3,3:176\n1056#3:179\n1869#3:180\n1869#3,2:181\n1870#3:183\n1617#3,9:188\n1869#3:197\n1870#3:199\n1626#3:200\n1869#3,2:201\n37#4:184\n36#4,3:185\n640#5:203\n*S KotlinDebug\n*F\n+ 1 RecordQuery.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/RecordQuery\n*L\n134#1:198\n165#1:204\n104#1:175\n104#1:176,3\n105#1:179\n106#1:180\n108#1:181,2\n106#1:183\n134#1:188,9\n134#1:197\n134#1:199\n134#1:200\n141#1:201,2\n121#1:184\n121#1:185,3\n165#1:203\n*E\n"})
public final class RecordQuery
extends Module {
    @JvmField
    @NotNull
    public final Map<String, RecordQueryMode> modes;
    @JvmField
    @NotNull
    public final Map<String, RecordQueryState> queries;
    @JvmField
    @NotNull
    public final ListValue modeValue;
    @JvmField
    @NotNull
    public final BoolValue tabValue;
    @JvmField
    @NotNull
    public final TextValue tabFormatValue;
    @JvmField
    @NotNull
    public final BoolValue nameTagsValue;
    @JvmField
    @NotNull
    public final TextValue nameTagsFormatValue;
    @JvmField
    @NotNull
    public final BoolValue debugValue;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public RecordQuery() {
        Unit unit;
        Object object;
        block6: {
            Unit unit2;
            Iterator $i$f$mapTo22;
            block5: {
                block4: {
                    void $this$forEach$iv;
                    void $this$sortedBy$iv;
                    void $this$mapTo$iv$iv;
                    List<Class<RecordQueryMode>> $this$nameTagsFormatValue_u24lambda_u2412;
                    TextValue $this$tabFormatValue_u24lambda_u2411;
                    super("RecordQuery", ModuleCategory.MISC, null, null, 12, null);
                    this.modes = new LinkedHashMap();
                    this.queries = new LinkedHashMap();
                    this.modeValue = new ListValue("Mode", null, "Hyt", 2, null);
                    this.tabValue = new BoolValue("Tab", true);
                    object = new TextValue("TabFormat", "\u00a77[%query\u00a77]\u00a7f%name");
                    TextValue textValue = object;
                    Object object2 = this;
                    boolean bl2 = false;
                    $this$tabFormatValue_u24lambda_u2411.setSuperValue(this.tabValue);
                    ((RecordQuery)object2).tabFormatValue = object;
                    this.nameTagsValue = new BoolValue("NameTags", true);
                    object = new TextValue("NameTagsFormat", "\u00a77[%query\u00a77]\u00a7f%name");
                    $this$tabFormatValue_u24lambda_u2411 = object;
                    object2 = this;
                    boolean bl3 = false;
                    ((Value)((Object)$this$nameTagsFormatValue_u24lambda_u2412)).setSuperValue(this.tabValue);
                    ((RecordQuery)object2).nameTagsFormatValue = object;
                    this.debugValue = new BoolValue("Debug", false);
                    List<Class<RecordQueryMode>> it = $this$nameTagsFormatValue_u24lambda_u2412 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".record_query.mode.impl", RecordQueryMode.class);
                    boolean bl4 = false;
                    this.getValues().add(this.modeValue);
                    it = $this$nameTagsFormatValue_u24lambda_u2412;
                    boolean bl5 = false;
                    Object object3 = object = !((Collection)it).isEmpty() ? $this$nameTagsFormatValue_u24lambda_u2412 : null;
                    if (object == null) break block4;
                    List $this$map$iv = (List)object;
                    boolean $i$f$map22 = false;
                    List list = $this$map$iv;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    boolean $i$f$mapTo22 = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it2;
                        Class clazz = (Class)item$iv$iv;
                        object2 = destination$iv$iv;
                        boolean bl6 = false;
                        object2.add((RecordQueryMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    Iterable $i$f$map22 = (List)destination$iv$iv;
                    boolean $i$f$sortedBy22 = false;
                    $this$map$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                        public final int compare(T a2, T b2) {
                            RecordQueryMode it = (RecordQueryMode)a2;
                            boolean bl2 = false;
                            Comparable comparable = (Comparable)((Object)it.getName());
                            it = (RecordQueryMode)b2;
                            Comparable comparable2 = comparable;
                            bl2 = false;
                            return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                        }
                    });
                    if ($this$map$iv == null) break block4;
                    Iterable $i$f$sortedBy22 = $this$map$iv;
                    boolean $i$f$forEach = false;
                    $i$f$mapTo22 = $this$forEach$iv.iterator();
                    break block5;
                }
                unit = null;
                break block6;
            }
            while ($i$f$mapTo22.hasNext()) {
                Object element$iv = $i$f$mapTo22.next();
                RecordQueryMode it = (RecordQueryMode)element$iv;
                boolean bl7 = false;
                it.setInstance(this);
                Iterable $this$forEach$iv = it.getValues();
                boolean $i$f$forEach = false;
                for (Object element$iv2 : $this$forEach$iv) {
                    Value value = (Value)element$iv2;
                    boolean bl8 = false;
                    value.setName(it.getName() + value.getName());
                    if (value.getSuperValue() == null) {
                        value.setSuperValue(this.modeValue);
                        value.setSuperValueMeta(it.getName());
                    }
                    this.getValues().add(value);
                }
                this.modes.put(it.getName(), it);
            }
            Unit it = unit2 = Unit.INSTANCE;
            boolean bl9 = false;
            Collection $this$toTypedArray$iv = this.modes.keySet();
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            this.modeValue.setValues(thisCollection$iv.toArray(new String[0]));
            unit = Unit.INSTANCE;
        }
        Object it = object = unit;
        boolean bl10 = false;
        Value[] valueArray = new Value[]{this.tabValue, this.tabFormatValue};
        CollectionsKt.addAll((Collection)this.getValues(), valueArray);
        valueArray = new Value[]{this.nameTagsValue, this.nameTagsFormatValue};
        CollectionsKt.addAll((Collection)this.getValues(), valueArray);
        this.getValues().add(this.debugValue);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public final String query(@NotNull GameProfile profile) {
        String string;
        block8: {
            void $this$query_u24lambda_u2410_u24lambda_u249;
            Object object;
            block7: {
                String string2;
                Intrinsics.checkNotNullParameter(profile, "profile");
                RecordQueryState recordQueryState = this.queries.get(profile.getName());
                if (recordQueryState == null) break block7;
                RecordQueryState state = recordQueryState;
                boolean bl2 = false;
                object = state;
                if (object instanceof RecordQueryStateWorking) {
                    return "\u67e5\u8be2\u4e2d";
                }
                if (object instanceof RecordQueryStateSuccess) {
                    string2 = ((RecordQueryStateSuccess)state).getMessage();
                } else {
                    if (object instanceof RecordQueryStateFailed) {
                        return "";
                    }
                    string2 = null;
                }
                if ((string = string2) != null) break block8;
            }
            RecordQuery it = this;
            boolean bl3 = false;
            object = this.queries;
            String string3 = profile.getName();
            String string4 = profile.getName();
            Intrinsics.checkNotNullExpressionValue(string4, "getName(...)");
            Object object2 = new Thread(() -> RecordQuery.query$lambda$10$lambda$8(profile, this));
            Thread thread2 = object2;
            String string5 = string4;
            boolean bl4 = false;
            $this$query_u24lambda_u2410_u24lambda_u249.setDaemon(true);
            $this$query_u24lambda_u2410_u24lambda_u249.setName($this$query_u24lambda_u2410_u24lambda_u249.getName() + '-' + profile.getName());
            $this$query_u24lambda_u2410_u24lambda_u249.start();
            DefaultConstructorMarker defaultConstructorMarker = null;
            int n2 = 4;
            boolean bl5 = false;
            Thread thread3 = object2;
            String string6 = string5;
            object2 = new RecordQueryStateWorking(string6, thread3, bl5, n2, defaultConstructorMarker);
            object.put(string3, object2);
            return null;
        }
        String string7 = string;
        return string7;
    }

    /*
     * Unable to fully structure code
     */
    @EventTarget(priority=-100)
    public final void onRender2DPlayerTabOverlayPre(@NotNull Render2DPlayerTabOverlayEvent.PRE event) {
        block4: {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!((Boolean)this.tabValue.get()).booleanValue()) break block4;
            $this$mapNotNull$iv = event.getList();
            $i$f$mapNotNull = false;
            var4_4 = $this$mapNotNull$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$mapNotNullTo = false;
            $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            $i$f$forEach = false;
            var9_12 = $this$forEach$iv$iv$iv.iterator();
            while (var9_12.hasNext()) {
                element$iv$iv = element$iv$iv$iv = var9_12.next();
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                info = (NetworkPlayerInfo)element$iv$iv;
                $i$a$-mapNotNull-RecordQuery$onRender2DPlayerTabOverlayPre$1 = false;
                v0 = info.func_178845_a();
                Intrinsics.checkNotNullExpressionValue(v0, "getGameProfile(...)");
                var15_18 = this.query(v0);
                if (var15_18 == null) ** GOTO lbl-1000
                it = var16_19 = var15_18;
                $i$a$-takeIf-RecordQuery$onRender2DPlayerTabOverlayPre$1$1 = false;
                v1 = var19_22 = ((CharSequence)it).length() > 0 != false ? var16_19 : null;
                if (var19_22 != null) {
                    query = var19_22;
                    $i$a$-let-RecordQuery$onRender2DPlayerTabOverlayPre$1$2 = false;
                    v2 = new Pair<NetworkPlayerInfo, String>(info, query);
                } else lbl-1000:
                // 2 sources

                {
                    v2 = null;
                }
                if (v2 == null) continue;
                it$iv$iv = v2;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                destination$iv$iv.add(it$iv$iv);
            }
            $this$forEach$iv = (List)destination$iv$iv;
            $i$f$forEach = false;
            for (E element$iv : $this$forEach$iv) {
                var6_7 = (Pair)element$iv;
                $i$a$-forEach-RecordQuery$onRender2DPlayerTabOverlayPre$2 = false;
                info = (NetworkPlayerInfo)var6_7.component1();
                query = (String)var6_7.component2();
                ((Map)event.getOverwriteNames()).put(info, StringsKt.replace$default(StringsKt.replace$default((String)this.tabFormatValue.get(), "%query", query, false, 4, null), "%name", Render2DPlayerTabOverlayEvent.PRE.getPlayerName$default(event, info, false, 2, null), false, 4, null));
            }
        }
    }

    @EventTarget(priority=-100)
    public final void onRenderEntityName(@NotNull RenderEntityNameEvent event) {
        block3: {
            EntityPlayer entityPlayer;
            Intrinsics.checkNotNullParameter(event, "event");
            if (!((Boolean)this.nameTagsValue.get()).booleanValue()) break block3;
            Object object = event.getEntity();
            EntityPlayer entityPlayer2 = entityPlayer = object instanceof EntityPlayer ? (EntityPlayer)object : null;
            if (entityPlayer != null) {
                EntityPlayer it = entityPlayer;
                boolean bl2 = false;
                GameProfile gameProfile = it.func_146103_bH();
                Intrinsics.checkNotNullExpressionValue(gameProfile, "getGameProfile(...)");
                object = this.query(gameProfile);
                if (object != null) {
                    Object object2;
                    Object object3;
                    Object it2 = object3 = object;
                    boolean bl3 = false;
                    Object object4 = object2 = ((CharSequence)it2).length() > 0 ? object3 : null;
                    if (object2 != null) {
                        Object query = object3 = object2;
                        boolean bl4 = false;
                        event.setDisplayName(StringsKt.replace$default(StringsKt.replace$default((String)this.nameTagsFormatValue.get(), "%query", (String)query, false, 4, null), "%name", event.getDisplayName(), false, 4, null));
                    }
                }
            }
        }
    }

    @Override
    public void onDisable() {
        KeyBinding keyBinding = MinecraftInstance.mc.getGameSettings().field_74311_E;
        Intrinsics.checkNotNullExpressionValue(keyBinding, "keyBindSneak");
        if (KeyUtils.INSTANCE.isKeyDownSystem(keyBinding)) {
            Map<String, RecordQueryState> map;
            Map<String, RecordQueryState> $this$onEach$iv = this.queries;
            boolean $i$f$onEach = false;
            Map<String, RecordQueryState> $this$onEach_u24lambda_u242$iv = map = $this$onEach$iv;
            boolean bl2 = false;
            Iterator<Map.Entry<String, RecordQueryState>> iterator2 = $this$onEach_u24lambda_u242$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry<String, RecordQueryState> element$iv;
                Map.Entry<String, RecordQueryState> it = element$iv = iterator2.next();
                boolean bl3 = false;
                RecordQueryState recordQueryState = it.getValue();
                RecordQueryStateWorking recordQueryStateWorking = recordQueryState instanceof RecordQueryStateWorking ? (RecordQueryStateWorking)recordQueryState : null;
                if (recordQueryStateWorking == null) continue;
                recordQueryStateWorking.setInvalid(true);
            }
            map.clear();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(this.queries.size());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void query$lambda$10$lambda$8(GameProfile $profile, RecordQuery this$0) {
        RecordQuery recordQuery;
        String name = $profile.getName();
        RecordQueryMode recordQueryMode = this$0.modes.get(this$0.modeValue.get());
        if (recordQueryMode != null) {
            Object object;
            RecordQueryMode recordQueryMode2;
            RecordQueryMode it = recordQueryMode2 = recordQueryMode;
            boolean bl2 = false;
            if (((Boolean)this$0.debugValue.get()).booleanValue()) {
                DarkMeow.INSTANCE.getMessageManager().display.displayInfo("QueryLaunch(name=" + name + ')');
            }
            Object object2 = recordQueryMode2;
            try {
                RecordQueryMode $this$query_u24lambda_u2410_u24lambda_u248_u24lambda_u242 = object2;
                boolean bl3 = false;
                object = Result.constructor-impl($this$query_u24lambda_u2410_u24lambda_u248_u24lambda_u242.query($profile));
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl(ResultKt.createFailure(throwable));
            }
            Throwable throwable = Result.exceptionOrNull-impl(object);
            if (throwable != null) {
                Throwable throwable2;
                Throwable e2 = throwable2 = throwable;
                boolean bl4 = false;
                ClientUtils.INSTANCE.logWarn("Failed to query record. (name=" + $profile.getName() + ')', e2);
            }
            if ((object = (String)(Result.isFailure-impl(object2 = object) ? null : object2)) != null) {
                Object object3;
                Object object4;
                Object it2 = object4 = object;
                boolean bl5 = false;
                RecordQueryState recordQueryState = this$0.queries.get($profile.getName());
                RecordQueryStateWorking recordQueryStateWorking = recordQueryState instanceof RecordQueryStateWorking ? (RecordQueryStateWorking)recordQueryState : null;
                Object object5 = object3 = (recordQueryStateWorking != null ? !recordQueryStateWorking.isInvalid() : false) ? object4 : null;
                if (object3 != null) {
                    Object object6;
                    Object object7;
                    Object it3 = object7 = object3;
                    boolean bl6 = false;
                    RecordQueryState recordQueryState2 = this$0.queries.get($profile.getName());
                    RecordQueryStateWorking recordQueryStateWorking2 = recordQueryState2 instanceof RecordQueryStateWorking ? (RecordQueryStateWorking)recordQueryState2 : null;
                    if (recordQueryStateWorking2 != null) {
                        recordQueryStateWorking2.setInvalid(true);
                    }
                    Object result = object6 = object7;
                    boolean bl7 = false;
                    Map<String, RecordQueryState> map = this$0.queries;
                    String string = $profile.getName();
                    Intrinsics.checkNotNull(name);
                    map.put(string, new RecordQueryStateSuccess(name, (String)result));
                    if ((Boolean)this$0.debugValue.get() == false) return;
                    DarkMeow.INSTANCE.getMessageManager().display.displayInfo("QuerySuccess(name=" + name + ", message=" + (String)result + "\u00a77)");
                    return;
                }
            }
        }
        RecordQuery it = recordQuery = this$0;
        boolean bl8 = false;
        Map<String, RecordQueryState> map = this$0.queries;
        String string = $profile.getName();
        Intrinsics.checkNotNull(name);
        map.put(string, new RecordQueryStateFailed(name));
        if ((Boolean)this$0.debugValue.get() == false) return;
        DarkMeow.INSTANCE.getMessageManager().display.displayInfo("QueryFailed(name=" + name + ')');
    }
}

