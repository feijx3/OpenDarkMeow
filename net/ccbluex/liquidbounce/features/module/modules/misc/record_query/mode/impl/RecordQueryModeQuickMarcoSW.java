/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.mojang.authlib.GameProfile
 *  kotlin.jvm.JvmField
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.record_query.mode.impl;

import com.google.gson.Gson;
import com.mojang.authlib.GameProfile;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.features.module.modules.misc.record_query.mode.RecordQueryMode;
import net.ccbluex.liquidbounce.utils.misc.HttpUtils;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/mode/impl/RecordQueryModeQuickMarcoSW;", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/mode/RecordQueryMode;", "<init>", "()V", "formatValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "eloColorValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "query", "", "profile", "Lcom/mojang/authlib/GameProfile;", "getEloColor", "elo", "", "PlayerData", "DarkMeow"})
public final class RecordQueryModeQuickMarcoSW
extends RecordQueryMode {
    @JvmField
    @NotNull
    public final TextValue formatValue = new TextValue("Format", "%elo");
    @JvmField
    @NotNull
    public final BoolValue eloColorValue = new BoolValue("EloColor", true);
    @NotNull
    private final Gson gson = new Gson();

    public RecordQueryModeQuickMarcoSW() {
        super("QuickMarcoSW");
    }

    @NotNull
    public final Gson getGson() {
        return this.gson;
    }

    @Override
    @NotNull
    public String query(@NotNull GameProfile profile) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        PlayerData data = (PlayerData)this.gson.fromJson(HttpUtils.get("https://mc-api.16163.com/search/skywars.html?uid=" + profile.getName()), PlayerData.class);
        String string = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String)this.formatValue.get(), "%kill", String.valueOf((int)data.getKillNum()), false, 4, null), "%playNum", String.valueOf(data.getPlayNum()), false, 4, null), "%rank", String.valueOf(data.getRank()), false, 4, null), "%winRate", String.valueOf(data.getWinRate()), false, 4, null);
        String string2 = "%.2f";
        Object[] objectArray = new Object[]{data.getKillDead()};
        String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue(string3, "format(...)");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string, "%kd", string3, false, 4, null), "%elo", ((Boolean)this.eloColorValue.get() != false ? this.getEloColor(data.getScore()) : "") + data.getScore() + "\u00a7r", false, 4, null), "%tier", data.getDuanwei(), false, 4, null);
    }

    private final String getEloColor(int elo) {
        String string;
        block1: {
            int n2;
            block4: {
                block3: {
                    block2: {
                        block0: {
                            n2 = elo;
                            boolean bl2 = Integer.MIN_VALUE <= n2 ? n2 < 1500 : false;
                            if (!bl2) break block0;
                            string = "\u00a78";
                            break block1;
                        }
                        boolean bl3 = 1500 <= n2 ? n2 < 1700 : false;
                        if (!bl3) break block2;
                        string = "\u00a77";
                        break block1;
                    }
                    boolean bl4 = 1700 <= n2 ? n2 < 2000 : false;
                    if (!bl4) break block3;
                    string = "\u00a7f";
                    break block1;
                }
                boolean bl5 = 2000 <= n2 ? n2 < 2100 : false;
                if (!bl5) break block4;
                string = "\u00a7e";
                break block1;
            }
            string = (2100 <= n2 ? n2 < 2500 : false) ? "\u00a7c" : ((2500 <= n2 ? n2 <= Integer.MAX_VALUE : false) ? "\u00a7d" : "");
        }
        return string;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000bH\u00c6\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001J\t\u0010$\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/record_query/mode/impl/RecordQueryModeQuickMarcoSW$PlayerData;", "", "killNum", "", "playNum", "", "rank", "winRate", "killDead", "score", "duanwei", "", "<init>", "(DIIDDILjava/lang/String;)V", "getKillNum", "()D", "getPlayNum", "()I", "getRank", "getWinRate", "getKillDead", "getScore", "getDuanwei", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "DarkMeow"})
    public static final class PlayerData {
        private final double killNum;
        private final int playNum;
        private final int rank;
        private final double winRate;
        private final double killDead;
        private final int score;
        @NotNull
        private final String duanwei;

        public PlayerData(double killNum, int playNum, int rank, double winRate, double killDead, int score, @NotNull String duanwei) {
            Intrinsics.checkNotNullParameter(duanwei, "duanwei");
            this.killNum = killNum;
            this.playNum = playNum;
            this.rank = rank;
            this.winRate = winRate;
            this.killDead = killDead;
            this.score = score;
            this.duanwei = duanwei;
        }

        public final double getKillNum() {
            return this.killNum;
        }

        public final int getPlayNum() {
            return this.playNum;
        }

        public final int getRank() {
            return this.rank;
        }

        public final double getWinRate() {
            return this.winRate;
        }

        public final double getKillDead() {
            return this.killDead;
        }

        public final int getScore() {
            return this.score;
        }

        @NotNull
        public final String getDuanwei() {
            return this.duanwei;
        }

        public final double component1() {
            return this.killNum;
        }

        public final int component2() {
            return this.playNum;
        }

        public final int component3() {
            return this.rank;
        }

        public final double component4() {
            return this.winRate;
        }

        public final double component5() {
            return this.killDead;
        }

        public final int component6() {
            return this.score;
        }

        @NotNull
        public final String component7() {
            return this.duanwei;
        }

        @NotNull
        public final PlayerData copy(double killNum, int playNum, int rank, double winRate, double killDead, int score, @NotNull String duanwei) {
            Intrinsics.checkNotNullParameter(duanwei, "duanwei");
            return new PlayerData(killNum, playNum, rank, winRate, killDead, score, duanwei);
        }

        public static /* synthetic */ PlayerData copy$default(PlayerData playerData, double d2, int n2, int n3, double d3, double d4, int n4, String string, int n5, Object object) {
            if ((n5 & 1) != 0) {
                d2 = playerData.killNum;
            }
            if ((n5 & 2) != 0) {
                n2 = playerData.playNum;
            }
            if ((n5 & 4) != 0) {
                n3 = playerData.rank;
            }
            if ((n5 & 8) != 0) {
                d3 = playerData.winRate;
            }
            if ((n5 & 0x10) != 0) {
                d4 = playerData.killDead;
            }
            if ((n5 & 0x20) != 0) {
                n4 = playerData.score;
            }
            if ((n5 & 0x40) != 0) {
                string = playerData.duanwei;
            }
            return playerData.copy(d2, n2, n3, d3, d4, n4, string);
        }

        @NotNull
        public String toString() {
            return "PlayerData(killNum=" + this.killNum + ", playNum=" + this.playNum + ", rank=" + this.rank + ", winRate=" + this.winRate + ", killDead=" + this.killDead + ", score=" + this.score + ", duanwei=" + this.duanwei + ')';
        }

        public int hashCode() {
            int result = Double.hashCode(this.killNum);
            result = result * 31 + Integer.hashCode(this.playNum);
            result = result * 31 + Integer.hashCode(this.rank);
            result = result * 31 + Double.hashCode(this.winRate);
            result = result * 31 + Double.hashCode(this.killDead);
            result = result * 31 + Integer.hashCode(this.score);
            result = result * 31 + this.duanwei.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlayerData)) {
                return false;
            }
            PlayerData playerData = (PlayerData)other;
            if (Double.compare(this.killNum, playerData.killNum) != 0) {
                return false;
            }
            if (this.playNum != playerData.playNum) {
                return false;
            }
            if (this.rank != playerData.rank) {
                return false;
            }
            if (Double.compare(this.winRate, playerData.winRate) != 0) {
                return false;
            }
            if (Double.compare(this.killDead, playerData.killDead) != 0) {
                return false;
            }
            if (this.score != playerData.score) {
                return false;
            }
            return Intrinsics.areEqual(this.duanwei, playerData.duanwei);
        }
    }
}

