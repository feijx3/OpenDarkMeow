/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.combat;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.controller.ControllerUseEntityAttackEvent;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.utils.file.FileUtils;
import net.ccbluex.liquidbounce.utils.timer.delay.MSDelay;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0016\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010$\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006("}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoEZ;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "sendDelay", "Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "getSendDelay", "()Lnet/ccbluex/liquidbounce/utils/timer/delay/MSDelay;", "attacks", "Ljava/util/HashSet;", "Lnet/minecraft/entity/player/EntityPlayer;", "Lkotlin/collections/HashSet;", "getAttacks", "()Ljava/util/HashSet;", "setAttacks", "(Ljava/util/HashSet;)V", "messages", "", "", "getMessages", "()Ljava/util/List;", "messagePrevIndex", "", "getMessagePrevIndex", "()I", "setMessagePrevIndex", "(I)V", "onEnable", "", "onDisable", "sendMessage", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "attack", "tag", "getTag", "()Ljava/lang/String;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nAutoEZ.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoEZ.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoEZ\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n12#2,3:95\n12#2,3:98\n20#2,3:101\n1#3:104\n774#4:105\n865#4,2:106\n774#4:108\n865#4,2:109\n295#4,2:111\n*S KotlinDebug\n*F\n+ 1 AutoEZ.kt\nnet/ccbluex/liquidbounce/features/module/modules/combat/AutoEZ\n*L\n65#1:95,3\n68#1:98,3\n73#1:101,3\n52#1:105\n52#1:106,2\n53#1:108\n53#1:109,2\n76#1:111,2\n*E\n"})
public final class AutoEZ
extends Module {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final IntegerRangeValue delayValue = new IntegerRangeValue("Delay", new IntRange(3000, 3000), new IntRange(0, 5000));
    @NotNull
    private final MSDelay sendDelay = new MSDelay();
    @NotNull
    private HashSet<EntityPlayer> attacks = new HashSet();
    @NotNull
    private final List<String> messages = new ArrayList();
    private int messagePrevIndex;
    @NotNull
    private static final File FILE = new File(DarkMeow.INSTANCE.getFileManager().getDir(), "auto-ez-messages.txt");

    public AutoEZ() {
        super("AutoEZ", ModuleCategory.COMBAT, null, null, 12, null);
        ListenableOwner $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> AutoEZ._init_$lambda$4(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> AutoEZ._init_$lambda$7(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(ControllerUseEntityAttackEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> AutoEZ._init_$lambda$11(this, arg_0, arg_1);
        priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<WorldEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), $receiver$iv));
    }

    @NotNull
    public final MSDelay getSendDelay() {
        return this.sendDelay;
    }

    @NotNull
    public final HashSet<EntityPlayer> getAttacks() {
        return this.attacks;
    }

    public final void setAttacks(@NotNull HashSet<EntityPlayer> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.attacks = hashSet;
    }

    @NotNull
    public final List<String> getMessages() {
        return this.messages;
    }

    public final int getMessagePrevIndex() {
        return this.messagePrevIndex;
    }

    public final void setMessagePrevIndex(int n2) {
        this.messagePrevIndex = n2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onEnable() {
        block3: {
            List list;
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            void $this$filterTo$iv$iv2;
            Object object;
            if (!FILE.exists()) {
                FileUtils.INSTANCE.unpackResourceFile(DarkMeow.INSTANCE.getFileManager().resourceDir + "/default/auto-ez-messages.txt", FILE);
            }
            Object object2 = new String[]{"\n"};
            Object it = object2 = StringsKt.split$default((CharSequence)StringsKt.replace$default(FilesKt.readText(FILE, Charsets.UTF_8), "\r", "", false, 4, null), object2, false, 0, 6, null);
            boolean bl2 = false;
            Object object3 = object = !((Collection)it).isEmpty() ? object2 : null;
            if (object == null) break block3;
            Iterable $this$filter$iv2 = (Iterable)object;
            boolean $i$f$filter22 = false;
            Iterable iterable = $this$filter$iv2;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                String it2 = (String)element$iv$iv;
                boolean bl3 = false;
                boolean bl4 = ((CharSequence)it2).length() > 0;
                if (!bl4) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $i$f$filter22 = (List)destination$iv$iv;
            boolean $i$f$filter = false;
            destination$iv$iv = $this$filter$iv;
            Collection destination$iv$iv2 = new ArrayList();
            boolean $i$f$filterTo2 = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                String it3 = (String)element$iv$iv;
                boolean bl5 = false;
                if (!(!StringsKt.startsWith$default(it3, "#", false, 2, null))) continue;
                destination$iv$iv2.add(element$iv$iv);
            }
            List it4 = list = (List)destination$iv$iv2;
            boolean bl6 = false;
            this.messages.clear();
            this.messages.addAll(it4);
        }
    }

    @Override
    public void onDisable() {
        this.attacks.clear();
    }

    public final void sendMessage(@NotNull EntityPlayerSP player, @NotNull EntityPlayer attack) {
        String string;
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(attack, "attack");
        String it = string = this.messages.get(this.messagePrevIndex);
        boolean bl2 = false;
        this.sendDelay.reset(this.delayValue);
        it = string;
        boolean bl3 = false;
        this.messagePrevIndex = this.messagePrevIndex >= this.messages.size() - 1 ? 0 : this.messagePrevIndex + 1;
        String string2 = attack.func_70005_c_();
        Intrinsics.checkNotNullExpressionValue(string2, "getName(...)");
        it = string = StringsKt.replace$default(string, "%player%", string2, false, 4, null);
        boolean bl4 = false;
        player.func_71165_d(it);
    }

    @Override
    @NotNull
    public String getTag() {
        return "" + this.messagePrevIndex + '/' + this.messages.size();
    }

    private static final Unit _init_$lambda$4(AutoEZ this$0, ListenerBase $this$listener, WorldEvent event) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.onDisable();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(AutoEZ this$0, ListenerBase $this$listener, ControllerUseEntityAttackEvent event) {
        block1: {
            EntityPlayer entityPlayer;
            EntityPlayer entityPlayer2;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            Entity entity = event.getTarget();
            EntityPlayer entityPlayer3 = entityPlayer2 = entity instanceof EntityPlayer ? (EntityPlayer)entity : null;
            if (entityPlayer2 == null) break block1;
            EntityPlayer it = entityPlayer = entityPlayer2;
            boolean bl2 = false;
            Object object = entity = !it.func_175149_v() ? entityPlayer : null;
            if (entity != null) {
                it = entityPlayer = entity;
                boolean bl3 = false;
                this$0.attacks.add(it);
            }
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit _init_$lambda$11(AutoEZ this$0, SafeListenerBase $this$safeListener, MovementInputEvent.PRE it) {
        block3: {
            Object v1;
            EntityPlayer entityPlayer;
            block2: {
                void $this$firstOrNull$iv;
                EntityPlayer entityPlayer2;
                Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
                Intrinsics.checkNotNullParameter(it, "it");
                Object it2 = entityPlayer = this$0.attacks;
                boolean bl2 = false;
                Object object = entityPlayer2 = MSDelay.hasPassed$default(this$0.sendDelay, 0L, 1, null) ? entityPlayer : null;
                if (entityPlayer2 == null) break block3;
                it2 = (Iterable)entityPlayer2;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    EntityPlayer it3 = (EntityPlayer)element$iv;
                    boolean bl3 = false;
                    if (!(!it3.func_70089_S())) continue;
                    v1 = element$iv;
                    break block2;
                }
                v1 = null;
            }
            entityPlayer = v1;
            if (entityPlayer != null) {
                EntityPlayer entityPlayer3;
                EntityPlayer target = entityPlayer3 = entityPlayer;
                boolean bl4 = false;
                this$0.attacks.remove(target);
                this$0.sendMessage($this$safeListener.getPlayer(), target);
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoEZ$Companion;", "", "<init>", "()V", "FILE", "Ljava/io/File;", "getFILE", "()Ljava/io/File;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final File getFILE() {
            return FILE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

