/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.event.events.input.MovementInputEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.utils.timer.MSTimer;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.IntegerRangeValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixSpammer;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "globalChatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "versionValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "delayValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerRangeValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "delay", "", "onEnable", "", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSilenceFixSpammer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SilenceFixSpammer.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixSpammer\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n20#2,3:60\n1#3:63\n*S KotlinDebug\n*F\n+ 1 SilenceFixSpammer.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixSpammer\n*L\n45#1:60,3\n*E\n"})
public final class SilenceFixSpammer
extends Module {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final BoolValue globalChatValue = new BoolValue("GlobalChat", false);
    @JvmField
    @NotNull
    public final TextValue versionValue = new TextValue("Version", "39.0");
    @JvmField
    @NotNull
    public final IntegerRangeValue delayValue = new IntegerRangeValue("Delay", new IntRange(9000, 9000), new IntRange(1000, 9000));
    @NotNull
    private final MSTimer msTimer = new MSTimer();
    private int delay = this.delayValue.random();
    @NotNull
    private static final String[] MESSAGES;

    /*
     * WARNING - void declaration
     */
    public SilenceFixSpammer() {
        super("SilenceFixSpammer", ModuleCategory.FUN, null, null, 12, null);
        void $receiver$iv;
        ListenableOwnerExtends listenableOwnerExtends = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<SafeListenerBase, MovementInputEvent.PRE, Unit> function$iv = (arg_0, arg_1) -> SilenceFixSpammer._init_$lambda$2(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookSafeOwnerCheck<MovementInputEvent.PRE>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(MovementInputEvent.PRE.class), (ListenableOwner)$receiver$iv));
    }

    @Override
    public void onEnable() {
        this.msTimer.reset();
        this.delay = this.delayValue.random();
    }

    private static final Unit _init_$lambda$2(SilenceFixSpammer this$0, SafeListenerBase $this$safeListener, MovementInputEvent.PRE it) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.msTimer.hasTimePassed(this$0.delay)) {
            String string;
            String it2 = StringsKt.replace$default(ArraysKt.random(MESSAGES, (Random)Random.Default), "%{version}", (String)this$0.versionValue.get(), false, 4, null);
            boolean bl2 = false;
            String message = string = (Boolean)this$0.globalChatValue.get() != false ? '@' + it2 : it2;
            boolean bl3 = false;
            $this$safeListener.getPlayer().func_71165_d(message);
            this$0.onEnable();
        }
        return Unit.INSTANCE;
    }

    static {
        String[] stringArray = new String[]{"@\u6b23\u6b23\u516c\u76ca%{version} \u5168\u5929\u514d\u8d39\u7684\u5185\u7f6e\u8fdb\u670d\u82b1\u96e8\u5ead \u770b\u5230\u4e86\u5c31\u8d76\u5feb\u52a0\u5165\u6211\u4eec\u4e00\u8d77\u514d\u8d39\u4f7f\u7528\u5e76\u83b7\u53d6\u5427 \u6211\u4eec\u4e5f\u6709\u6700\u5f3a\u7684\u5e03\u5409\u5c9b \u514d\u8d39\u70b9\u51fb\u4ee3\u7801heshuyou.xyz ><", "@\u6b23\u6b23\u516c\u76ca%{version} \u5168\u5929\u514d\u8d39\u7684\u5185\u7f6e\u8fdb\u670d\u82b1\u96e8\u5ead \u5b66\u751f\u515a\u53ef\u4ee5\u653e\u5b66\u6e38\u73a9\u82b1\u96e8\u5ead\uff01\u5feb\u6765\u514d\u8d39\u83b7\u53d6\u5427 \u6211\u4eec\u4e5f\u6709\u6700\u5f3a\u7684\u5e03\u5409\u5c9b \u514d\u8d39\u70b9\u51fb\u4ee3\u7801heshuyou.xyz ><", "@\u6b23\u6b23\u516c\u76ca%{version} \u5168\u5929\u514d\u8d39\u7684\u5185\u7f6e\u8fdb\u670d\u82b1\u96e8\u5ead \u5168\u7f51\u72ec\u5bb6\u8d77\u5e8a20CPS\u6700\u5f3a\u5ba2\u6237\u7aef \u4e0d\u670d\u540c\u88c5\u5907\u5bf9\u5200\u4e00\u4e0b\u5417 \u540c\u8ddd\u79bb\u65e0\u654c \u6211\u4eec\u4e5f\u6709\u6700\u5f3a\u7684\u5e03\u5409\u5c9b \u514d\u8d39\u70b9\u51fbheshuyou.xyz ><", "SilenceFix Best The Config Free 205521532 ><"};
        MESSAGES = stringArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixSpammer$Companion;", "", "<init>", "()V", "MESSAGES", "", "", "getMESSAGES$annotations", "getMESSAGES", "()[Ljava/lang/String;", "[Ljava/lang/String;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String[] getMESSAGES() {
            return MESSAGES;
        }

        public static /* synthetic */ void getMESSAGES$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

