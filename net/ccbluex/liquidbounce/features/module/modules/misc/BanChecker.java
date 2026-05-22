/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketChat
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketChat;
import org.jetbrains.annotations.NotNull;

@ModuleInfo(name="BanChecker", category=ModuleCategory.MISC)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/BanChecker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "regexValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "selfCheckValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "selfCheckSendChatValue", "selfCheckSendChatMessageValue", "selfCheckQuitValue", "otherPlayerCheck", "otherPlayerCheckSendChatValue", "otherPlayerCheckSendChatMessageValue", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onPlayerBanned", "name", "", "tag", "getTag", "()Ljava/lang/String;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nBanChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BanChecker.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/BanChecker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
public final class BanChecker
extends Module {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TextValue regexValue = new TextValue("Regex", "\u73a9\u5bb6(.*?)\u5728\u672c\u5c40\u6e38\u620f\u4e2d\u884c\u4e3a\u5f02\u5e38");
    @NotNull
    private final BoolValue selfCheckValue = new BoolValue("SelfCheck", true);
    @NotNull
    private final BoolValue selfCheckSendChatValue;
    @NotNull
    private final TextValue selfCheckSendChatMessageValue;
    @NotNull
    private final BoolValue selfCheckQuitValue;
    @NotNull
    private final BoolValue otherPlayerCheck;
    @NotNull
    private final BoolValue otherPlayerCheckSendChatValue;
    @NotNull
    private final TextValue otherPlayerCheckSendChatMessageValue;
    private static int banCount;

    public BanChecker() {
        super(null, null, null, null, 15, null);
        Value it;
        Value value = new BoolValue("SelfCheckSendChat", false);
        BoolValue boolValue = value;
        BanChecker banChecker = this;
        boolean bl2 = false;
        it.setSuperValue(this.selfCheckValue);
        banChecker.selfCheckSendChatValue = value;
        it = value = new TextValue("SelfCheckSendChatMessage", "");
        banChecker = this;
        boolean bl3 = false;
        it.setSuperValue(this.selfCheckSendChatValue);
        banChecker.selfCheckSendChatMessageValue = value;
        it = value = new BoolValue("SelfCheckQuit", true);
        banChecker = this;
        boolean bl4 = false;
        it.setSuperValue(this.selfCheckValue);
        banChecker.selfCheckQuitValue = value;
        this.otherPlayerCheck = new BoolValue("OtherPlayerCheck", false);
        it = value = new BoolValue("OtherPlayerCheckSendChat", false);
        banChecker = this;
        boolean bl5 = false;
        it.setSuperValue(this.otherPlayerCheck);
        banChecker.otherPlayerCheckSendChatValue = value;
        it = value = new TextValue("OtherPlayerCheckSendChatMessage", "\u53d7\u5bb3\u8005\u7531\u4e8e\u98df\u7528\u4e86 SilenceFix \u5bfc\u81f4\u5c01\u7981.");
        banChecker = this;
        boolean bl6 = false;
        it.setSuperValue(this.otherPlayerCheckSendChatValue);
        banChecker.otherPlayerCheckSendChatMessageValue = value;
    }

    @EventTarget
    public final void onPacket(@NotNull PacketEvent event) {
        block1: {
            String string;
            String string2;
            Matcher matcher;
            Intrinsics.checkNotNullParameter(event, "event");
            Packet<?> packet = event.getPacket();
            if (!(packet instanceof SPacketChat) || !(matcher = Pattern.compile((String)this.regexValue.get()).matcher(((SPacketChat)packet).func_148915_c().func_150260_c())).find()) break block1;
            int n2 = banCount;
            banCount = n2 + 1;
            String it = string2 = matcher.group(1);
            boolean bl2 = false;
            Intrinsics.checkNotNull(it);
            String string3 = string = ((CharSequence)it).length() > 0 ? string2 : null;
            if (string != null) {
                it = string2 = string;
                boolean bl3 = false;
                this.onPlayerBanned(it);
            }
        }
    }

    private final void onPlayerBanned(String name) {
        WorldClient worldClient = MinecraftInstance.mc.getWorld();
        if (worldClient == null) {
            return;
        }
        WorldClient world = worldClient;
        EntityPlayerSP entityPlayerSP = MinecraftInstance.mc.getPlayer();
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        boolean bl2 = Intrinsics.areEqual(player.func_70005_c_(), name);
        if (bl2) {
            if (this.selfCheckValue.getState()) {
                if (this.selfCheckSendChatValue.getState()) {
                    player.func_71165_d((String)this.selfCheckSendChatMessageValue.get());
                }
                if (this.selfCheckQuitValue.getState()) {
                    world.func_72882_A();
                }
            }
        } else if (!bl2) {
            if (this.otherPlayerCheck.getState() && this.otherPlayerCheckSendChatValue.getState()) {
                player.func_71165_d((String)this.otherPlayerCheckSendChatMessageValue.get());
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override
    @NotNull
    public String getTag() {
        return String.valueOf(banCount);
    }

    public static final int getBanCount() {
        return Companion.getBanCount();
    }

    public static final void setBanCount(int n2) {
        Companion.setBanCount(n2);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/BanChecker$Companion;", "", "<init>", "()V", "banCount", "", "getBanCount$annotations", "getBanCount", "()I", "setBanCount", "(I)V", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        public final int getBanCount() {
            return banCount;
        }

        public final void setBanCount(int n2) {
            banCount = n2;
        }

        @JvmStatic
        public static /* synthetic */ void getBanCount$annotations() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

