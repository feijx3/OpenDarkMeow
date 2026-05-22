/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.file.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.file.FileConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u0007J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0016\u001a\u00020\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2={"Lnet/ccbluex/liquidbounce/file/impl/FriendsConfig;", "Lnet/ccbluex/liquidbounce/file/FileConfig;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "friends", "", "Lnet/ccbluex/liquidbounce/file/impl/FriendsConfig$Friend;", "getFriends", "()Ljava/util/List;", "loadConfig", "", "config", "", "saveConfig", "addFriend", "", "playerName", "alias", "removeFriend", "isFriend", "clearFriends", "Friend", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nFriendsConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FriendsConfig.kt\nnet/ccbluex/liquidbounce/file/impl/FriendsConfig\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,83:1\n1869#2:84\n1870#2:89\n37#3:85\n36#3,3:86\n*S KotlinDebug\n*F\n+ 1 FriendsConfig.kt\nnet/ccbluex/liquidbounce/file/impl/FriendsConfig\n*L\n12#1:84\n12#1:89\n14#1:85\n14#1:86,3\n*E\n"})
public final class FriendsConfig
extends FileConfig {
    @NotNull
    private final List<Friend> friends;

    public FriendsConfig(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        super(file);
        this.friends = new ArrayList();
    }

    @NotNull
    public final List<Friend> getFriends() {
        return this.friends;
    }

    @Override
    public void loadConfig(@NotNull String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.clearFriends();
        String[] stringArray = new String[]{"\n"};
        Iterable $this$forEach$iv = StringsKt.split$default((CharSequence)config, stringArray, false, 0, 6, null);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            boolean bl2;
            String line = (String)element$iv;
            boolean bl3 = false;
            if (StringsKt.contains$default((CharSequence)line, ":", false, 2, null)) {
                String[] stringArray2 = new String[]{":"};
                Collection $this$toTypedArray$iv = StringsKt.split$default((CharSequence)line, stringArray2, false, 0, 6, null);
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                String[] data = thisCollection$iv.toArray(new String[0]);
                bl2 = this.addFriend(data[0], data[1]);
                continue;
            }
            bl2 = FriendsConfig.addFriend$default(this, line, null, 2, null);
        }
    }

    @Override
    @NotNull
    public String saveConfig() {
        StringBuilder builder = new StringBuilder();
        for (Friend friend : this.friends) {
            builder.append(friend.getPlayerName()).append(":").append(friend.getAlias()).append("\n");
        }
        String string = builder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmOverloads
    public final boolean addFriend(@NotNull String playerName, @NotNull String alias) {
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        Intrinsics.checkNotNullParameter(alias, "alias");
        if (this.isFriend(playerName)) {
            return false;
        }
        this.friends.add(new Friend(playerName, alias));
        return true;
    }

    public static /* synthetic */ boolean addFriend$default(FriendsConfig friendsConfig, String string, String string2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string2 = string;
        }
        return friendsConfig.addFriend(string, string2);
    }

    public final boolean removeFriend(@NotNull String playerName) {
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        if (!this.isFriend(playerName)) {
            return false;
        }
        this.friends.removeIf(arg_0 -> FriendsConfig.removeFriend$lambda$2(arg_0 -> FriendsConfig.removeFriend$lambda$1(playerName, arg_0), arg_0));
        return true;
    }

    public final boolean isFriend(@Nullable String playerName) {
        for (Friend friend : this.friends) {
            if (!Intrinsics.areEqual(friend.getPlayerName(), playerName)) continue;
            return true;
        }
        return false;
    }

    public final void clearFriends() {
        this.friends.clear();
    }

    @JvmOverloads
    public final boolean addFriend(@NotNull String playerName) {
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        return FriendsConfig.addFriend$default(this, playerName, null, 2, null);
    }

    private static final boolean removeFriend$lambda$1(String $playerName, Friend friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        return Intrinsics.areEqual(friend.getPlayerName(), $playerName);
    }

    private static final boolean removeFriend$lambda$2(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/file/impl/FriendsConfig$Friend;", "", "playerName", "", "alias", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlayerName", "()Ljava/lang/String;", "getAlias", "DarkMeow"})
    public static final class Friend {
        @NotNull
        private final String playerName;
        @NotNull
        private final String alias;

        public Friend(@NotNull String playerName, @NotNull String alias) {
            Intrinsics.checkNotNullParameter(playerName, "playerName");
            Intrinsics.checkNotNullParameter(alias, "alias");
            this.playerName = playerName;
            this.alias = alias;
        }

        @NotNull
        public final String getPlayerName() {
            return this.playerName;
        }

        @NotNull
        public final String getAlias() {
            return this.alias;
        }
    }
}

