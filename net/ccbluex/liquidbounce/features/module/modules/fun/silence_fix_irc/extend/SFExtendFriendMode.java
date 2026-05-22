/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.text.ITextComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Event;
import net.ccbluex.liquidbounce.event.WorldEvent;
import net.ccbluex.liquidbounce.event.events.client.UpdateSelectTargetStatusEvent;
import net.ccbluex.liquidbounce.event.events.player.UpdateEvent;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFStatic;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend.SFExtendOtherProfile;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.hook.EventHookSafeOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u00020\u0013*\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendFriendMode;", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "<init>", "()V", "notificationValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "state", "", "getState", "()Z", "setState", "(Z)V", "otherProfile", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile;", "getOtherProfile", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile;", "setOtherProfile", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendOtherProfile;)V", "onConnected", "", "channel", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "updateState", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "sendNotificationMessage", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSFExtendFriendMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SFExtendFriendMode.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendFriendMode\n+ 2 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n20#2,3:81\n12#2,3:84\n12#2,3:87\n808#3,11:90\n774#3:101\n865#3,2:102\n1761#3,3:104\n1#4:107\n*S KotlinDebug\n*F\n+ 1 SFExtendFriendMode.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/extend/SFExtendFriendMode\n*L\n43#1:81,3\n46#1:84,3\n49#1:87,3\n60#1:90,11\n61#1:101\n61#1:102,2\n62#1:104,3\n*E\n"})
public final class SFExtendFriendMode
extends SFExtend {
    @JvmField
    @NotNull
    public final ListValue notificationValue;
    private boolean state;
    public SFExtendOtherProfile otherProfile;

    public SFExtendFriendMode() {
        super("FriendMode", true, false, 4, null);
        ListenableOwner $receiver$iv;
        Object object = new String[]{"Simple", "Spam", "None"};
        this.notificationValue = new ListValue("Notification", (String[])object, "Spam");
        object = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = this;
        Function2<ListenerBase, Event, Unit> function$iv = (arg_0, arg_1) -> SFExtendFriendMode._init_$lambda$0(this, arg_0, arg_1);
        int priority$iv = 0;
        boolean $i$f$safeListener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookSafeOwnerCheck<UpdateEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(UpdateEvent.class), $receiver$iv));
        ListenableOwnerExtends $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> SFExtendFriendMode._init_$lambda$1(this, arg_0, arg_1);
        priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<UpdateEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(WorldEvent.class), $receiver$iv));
        $this$iv = ListenableOwnerExtends.INSTANCE;
        $receiver$iv = this;
        function$iv = (arg_0, arg_1) -> SFExtendFriendMode._init_$lambda$6(this, arg_0, arg_1);
        priority$iv = 0;
        $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get($receiver$iv).add(new EventHookOwnerCheck<UpdateEvent>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(UpdateSelectTargetStatusEvent.class), $receiver$iv));
    }

    public final boolean getState() {
        return this.state;
    }

    public final void setState(boolean bl2) {
        this.state = bl2;
    }

    @NotNull
    public final SFExtendOtherProfile getOtherProfile() {
        SFExtendOtherProfile sFExtendOtherProfile = this.otherProfile;
        if (sFExtendOtherProfile != null) {
            return sFExtendOtherProfile;
        }
        Intrinsics.throwUninitializedPropertyAccessException("otherProfile");
        return null;
    }

    public final void setOtherProfile(@NotNull SFExtendOtherProfile sFExtendOtherProfile) {
        Intrinsics.checkNotNullParameter(sFExtendOtherProfile, "<set-?>");
        this.otherProfile = sFExtendOtherProfile;
    }

    @Override
    public void onConnected(@NotNull SFConnection channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        SFExtend sFExtend = this.getInstance().getExtends().get("OtherProfile");
        Intrinsics.checkNotNull(sFExtend, "null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.extend.SFExtendOtherProfile");
        this.setOtherProfile((SFExtendOtherProfile)sFExtend);
    }

    public final void updateState(@NotNull SafeListenerBase $this$updateState) {
        block10: {
            Boolean bl2;
            boolean bl3;
            block9: {
                Iterator $this$filterTo$iv$iv;
                Iterable $this$filterIsInstanceTo$iv$iv;
                Intrinsics.checkNotNullParameter($this$updateState, "<this>");
                List list = $this$updateState.getWorld().field_72996_f;
                Intrinsics.checkNotNullExpressionValue(list, "loadedEntityList");
                Iterable $this$filterIsInstance$iv = list;
                boolean $i$f$filterIsInstance = false;
                Iterable iterable = $this$filterIsInstance$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterIsInstanceTo = false;
                for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                    if (!(element$iv$iv instanceof EntityPlayer)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                Iterable $this$filter$iv = (List)destination$iv$iv;
                boolean $i$f$filter = false;
                $this$filterIsInstanceTo$iv$iv = $this$filter$iv;
                destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                Iterator iterator2 = $this$filterTo$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    Object element$iv$iv;
                    element$iv$iv = iterator2.next();
                    EntityPlayer it = (EntityPlayer)element$iv$iv;
                    boolean bl4 = false;
                    if (!(!(it instanceof EntityPlayerSP))) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                Iterable $this$any$iv = (List)destination$iv$iv;
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl3 = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        EntityPlayer it = (EntityPlayer)element$iv;
                        boolean bl5 = false;
                        if (!(!this.getOtherProfile().getUsers().containsKey(it.func_146103_bH().getId()))) continue;
                        bl3 = true;
                        break block9;
                    }
                    bl3 = false;
                }
            }
            Boolean bl6 = bl3;
            boolean it = bl6;
            boolean bl7 = false;
            Boolean bl8 = bl2 = it != this.state ? bl6 : null;
            if (bl2 == null) break block10;
            bl6 = bl2;
            boolean newState = bl6;
            boolean bl9 = false;
            String string = (String)this.notificationValue.get();
            if (Intrinsics.areEqual(string, "Simple")) {
                this.sendNotificationMessage(newState);
            } else if (Intrinsics.areEqual(string, "Spam")) {
                int n2 = 8;
                int n3 = 0;
                while (n3 < n2) {
                    int it2 = n3++;
                    boolean bl10 = false;
                    this.sendNotificationMessage(newState);
                }
            }
            this.state = newState;
        }
    }

    public final void sendNotificationMessage(boolean state) {
        MessageManager messageManager = DarkMeow.INSTANCE.getMessageManager();
        ITextComponent iTextComponent = SFStatic.INSTANCE.getPrefix().func_150258_a("\u00a7f\u5df2" + (state ? "\u5f00\u542f" : "\u5173\u95ed") + "\u53cb\u597d\u6a21\u5f0f");
        Intrinsics.checkNotNullExpressionValue(iTextComponent, "appendText(...)");
        messageManager.displayChatMessage(iTextComponent);
    }

    private static final Unit _init_$lambda$0(SFExtendFriendMode this$0, SafeListenerBase $this$safeListener, UpdateEvent event) {
        Intrinsics.checkNotNullParameter($this$safeListener, "$this$safeListener");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getUpdateId() % 20L == 0L) {
            this$0.updateState($this$safeListener);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(SFExtendFriendMode this$0, ListenerBase $this$listener, WorldEvent it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.state = false;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(SFExtendFriendMode this$0, ListenerBase $this$listener, UpdateSelectTargetStatusEvent event) {
        block2: {
            EntityLivingBase entityLivingBase;
            EntityLivingBase entityLivingBase2;
            Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
            Intrinsics.checkNotNullParameter(event, "event");
            EntityLivingBase it = entityLivingBase2 = event.getTarget();
            boolean bl2 = false;
            Object object = entityLivingBase = this$0.state ? entityLivingBase2 : null;
            if (entityLivingBase == null) break block2;
            EntityLivingBase it2 = entityLivingBase;
            boolean bl3 = false;
            entityLivingBase2 = it2 instanceof EntityPlayer ? (EntityPlayer)it2 : null;
            if (entityLivingBase2 != null) {
                EntityLivingBase entityLivingBase3;
                EntityLivingBase entityLivingBase4;
                EntityLivingBase player = entityLivingBase4 = entityLivingBase2;
                boolean bl4 = false;
                Object object2 = entityLivingBase3 = this$0.getOtherProfile().getUsers().containsKey(player.func_146103_bH().getId()) ? entityLivingBase4 : null;
                if (entityLivingBase3 != null) {
                    EntityLivingBase it3 = entityLivingBase4 = entityLivingBase3;
                    boolean bl5 = false;
                    event.setFriendEntity();
                }
            }
        }
        return Unit.INSTANCE;
    }
}

