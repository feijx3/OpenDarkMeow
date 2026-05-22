/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.util.text.ITextComponent
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.event.events.render.in_game_2d;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.ITextComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DPlayerTabOverlayEvent;", "", "<init>", "()V", "PRE", "POST", "DarkMeow"})
public final class Render2DPlayerTabOverlayEvent {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DPlayerTabOverlayEvent$POST;", "Lnet/ccbluex/liquidbounce/event/Event;", "<init>", "()V", "DarkMeow"})
    public static final class POST
    extends Event {
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR-\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0014`\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DPlayerTabOverlayEvent$PRE;", "Lnet/ccbluex/liquidbounce/event/Event;", "list", "", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "header", "Lnet/minecraft/util/text/ITextComponent;", "footer", "<init>", "(Ljava/util/List;Lnet/minecraft/util/text/ITextComponent;Lnet/minecraft/util/text/ITextComponent;)V", "getList", "()Ljava/util/List;", "getHeader", "()Lnet/minecraft/util/text/ITextComponent;", "setHeader", "(Lnet/minecraft/util/text/ITextComponent;)V", "getFooter", "setFooter", "overwriteNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getOverwriteNames", "()Ljava/util/HashMap;", "getPlayerName", "info", "ignoreOverwrite", "", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nRender2DPlayerTabOverlayEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Render2DPlayerTabOverlayEvent.kt\nnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DPlayerTabOverlayEvent$PRE\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
    public static final class PRE
    extends Event {
        @NotNull
        private final List<NetworkPlayerInfo> list;
        @Nullable
        private ITextComponent header;
        @Nullable
        private ITextComponent footer;
        @NotNull
        private final HashMap<NetworkPlayerInfo, String> overwriteNames;

        public PRE(@NotNull List<NetworkPlayerInfo> list, @Nullable ITextComponent header, @Nullable ITextComponent footer) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.header = header;
            this.footer = footer;
            this.overwriteNames = new HashMap();
        }

        @NotNull
        public final List<NetworkPlayerInfo> getList() {
            return this.list;
        }

        @Nullable
        public final ITextComponent getHeader() {
            return this.header;
        }

        public final void setHeader(@Nullable ITextComponent iTextComponent) {
            this.header = iTextComponent;
        }

        @Nullable
        public final ITextComponent getFooter() {
            return this.footer;
        }

        public final void setFooter(@Nullable ITextComponent iTextComponent) {
            this.footer = iTextComponent;
        }

        @NotNull
        public final HashMap<NetworkPlayerInfo, String> getOverwriteNames() {
            return this.overwriteNames;
        }

        /*
         * Enabled aggressive block sorting
         */
        @JvmOverloads
        @NotNull
        public final String getPlayerName(@NotNull NetworkPlayerInfo info, boolean ignoreOverwrite) {
            String string;
            Intrinsics.checkNotNullParameter(info, "info");
            String string2 = this.overwriteNames.get(info);
            if (string2 != null) {
                String string3;
                String string4;
                String it = string4 = string2;
                boolean bl2 = false;
                String string5 = string3 = !ignoreOverwrite ? string4 : null;
                if (string3 != null) {
                    string = string3;
                    return string;
                }
            }
            ITextComponent iTextComponent = info.func_178854_k();
            String string6 = iTextComponent != null ? iTextComponent.func_150254_d() : null;
            string = string6;
            if (string6 != null) return string;
            String string7 = ScorePlayerTeam.func_96667_a((Team)((Team)info.func_178850_i()), (String)info.func_178845_a().getName());
            string = string7;
            Intrinsics.checkNotNullExpressionValue(string7, "formatPlayerName(...)");
            return string;
        }

        public static /* synthetic */ String getPlayerName$default(PRE pRE, NetworkPlayerInfo networkPlayerInfo, boolean bl2, int n2, Object object) {
            if ((n2 & 2) != 0) {
                bl2 = false;
            }
            return pRE.getPlayerName(networkPlayerInfo, bl2);
        }

        @JvmOverloads
        @NotNull
        public final String getPlayerName(@NotNull NetworkPlayerInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return PRE.getPlayerName$default(this, info, false, 2, null);
        }
    }
}

