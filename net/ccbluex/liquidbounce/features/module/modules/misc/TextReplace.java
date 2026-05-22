/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.render.entity.RenderEntityNameEvent;
import net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DPlayerTabOverlayEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.ListenerBaseUtils;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.network.NetworkPlayerInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/TextReplace;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "replacesValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "replaceSelfNameValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "replaceSelfNameTextValue", "replaces", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getReplaces", "()Ljava/util/HashMap;", "updateReplaces", "", "replace", "old", "onEnable", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nTextReplace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextReplace.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/TextReplace\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,86:1\n1617#2,9:87\n1869#2:96\n1870#2:99\n1626#2:100\n1803#2,3:101\n1869#2,2:104\n1#3:97\n1#3:98\n12#4,3:106\n13#4,2:109\n13#4,2:111\n*S KotlinDebug\n*F\n+ 1 TextReplace.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/TextReplace\n*L\n44#1:87,9\n44#1:96\n44#1:99\n44#1:100\n63#1:101,3\n74#1:104,2\n44#1:98\n70#1:106,3\n73#1:109,2\n81#1:111,2\n*E\n"})
public final class TextReplace
extends Module {
    @NotNull
    public static final TextReplace INSTANCE;
    @JvmField
    @NotNull
    public static final TextValue replacesValue;
    @JvmField
    @NotNull
    public static final BoolValue replaceSelfNameValue;
    @JvmField
    @NotNull
    public static final TextValue replaceSelfNameTextValue;
    @NotNull
    private static final HashMap<String, String> replaces;

    private TextReplace() {
        super("TextReplace", ModuleCategory.MISC, null, null, 12, null);
    }

    @NotNull
    public final HashMap<String, String> getReplaces() {
        return replaces;
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    public static final void updateReplaces() {
        void var3_5;
        void $this$mapNotNullTo$iv$iv;
        Object object = new String[]{";"};
        Iterable $this$mapNotNull$iv = StringsKt.split$default((CharSequence)replacesValue.get(), object, false, 0, 6, null);
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Pair pair;
            Object object2;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            String pair2 = (String)element$iv$iv;
            boolean bl3 = false;
            Object object3 = new String[]{","};
            Object it = object3 = StringsKt.split$default((CharSequence)pair2, (String[])object3, false, 0, 6, null);
            boolean bl4 = false;
            Object object4 = object2 = it.size() == 2 ? object3 : null;
            if (object2 != null) {
                it = object2;
                boolean bl5 = false;
                pair = TuplesKt.to(it.get(0), it.get(1));
            } else {
                pair = null;
            }
            if (pair == null) continue;
            Pair it$iv$iv = pair;
            boolean bl6 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        Object newReplaces = object = (List)var3_5;
        boolean bl7 = false;
        replaces.clear();
        MapsKt.putAll((Map)replaces, (Iterable)newReplaces);
        if (((Boolean)replaceSelfNameValue.get()).booleanValue()) {
            ListenerBaseUtils.INSTANCE.safeExecute(TextReplace::updateReplaces$lambda$4);
        }
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @NotNull
    public static final String replace(@NotNull String old) {
        void $this$fold$iv;
        Intrinsics.checkNotNullParameter(old, "old");
        Set<Map.Entry<String, String>> set = replaces.entrySet();
        Intrinsics.checkNotNullExpressionValue(set, "<get-entries>(...)");
        Iterable iterable = set;
        String initial$iv = old;
        boolean $i$f$fold = false;
        String accumulator$iv = initial$iv;
        for (Object element$iv : $this$fold$iv) {
            Map.Entry entry = (Map.Entry)element$iv;
            String acc = accumulator$iv;
            boolean bl2 = false;
            Intrinsics.checkNotNull(entry);
            Object k2 = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(k2, "component1(...)");
            String k3 = (String)k2;
            Object v2 = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(v2, "component2(...)");
            String v3 = (String)v2;
            accumulator$iv = StringsKt.replace$default(acc, k3, v3, false, 4, null);
        }
        return accumulator$iv;
    }

    @Override
    public void onEnable() {
        TextReplace.updateReplaces();
    }

    private static final Unit updateReplaces$lambda$4(SafeListenerBase $this$safeExecute) {
        Intrinsics.checkNotNullParameter($this$safeExecute, "$this$safeExecute");
        ((Map)replaces).put($this$safeExecute.getPlayer().func_146103_bH().getName(), replaceSelfNameTextValue.get());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        TextReplace.updateReplaces();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(ListenerBase $this$listener, Render2DPlayerTabOverlayEvent.PRE event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        Iterable $this$forEach$iv = event.getList();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String replacedName;
            NetworkPlayerInfo info = (NetworkPlayerInfo)element$iv;
            boolean bl2 = false;
            String originName = event.getPlayerName(info, false);
            if (Intrinsics.areEqual(originName, replacedName = TextReplace.replace(originName))) continue;
            ((Map)event.getOverwriteNames()).put(info, replacedName);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(ListenerBase $this$listener, RenderEntityNameEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        event.setDisplayName(TextReplace.replace(event.getDisplayName()));
        return Unit.INSTANCE;
    }

    static {
        ListenableOwner $this$listener$iv;
        ListenableOwner $receiver$iv;
        INSTANCE = new TextReplace();
        replacesValue = new TextValue(){

            protected void onChanged(String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                Intrinsics.checkNotNullParameter(newValue, "newValue");
                TextReplace.updateReplaces();
            }
        };
        replaceSelfNameValue = new BoolValue(){

            protected void onChanged(boolean oldValue, boolean newValue) {
                TextReplace.updateReplaces();
            }
        };
        replaceSelfNameTextValue = new TextValue(){

            protected void onChanged(String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(oldValue, "oldValue");
                Intrinsics.checkNotNullParameter(newValue, "newValue");
                TextReplace.updateReplaces();
            }
        };
        replaces = new HashMap();
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = INSTANCE;
        Function2<ListenerBase, Event, Unit> function$iv = TextReplace::_init_$lambda$6;
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = INSTANCE;
        priority$iv = 0;
        function$iv = TextReplace::_init_$lambda$8;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$listener$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(Render2DPlayerTabOverlayEvent.PRE.class), $this$listener$iv));
        ListenableOwnerExtends this_$iv = ListenableOwnerExtends.INSTANCE;
        $this$listener$iv = INSTANCE;
        priority$iv = 0;
        function$iv = TextReplace::_init_$lambda$9;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($this$listener$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(RenderEntityNameEvent.class), $this$listener$iv));
    }
}

