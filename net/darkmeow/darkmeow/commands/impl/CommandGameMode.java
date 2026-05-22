/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.world.GameType
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/CommandGameMode;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandGameMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandGameMode.kt\nnet/darkmeow/darkmeow/commands/impl/CommandGameMode\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n216#2:38\n217#2:42\n1761#3,3:39\n774#3:43\n865#3,2:44\n*S KotlinDebug\n*F\n+ 1 CommandGameMode.kt\nnet/darkmeow/darkmeow/commands/impl/CommandGameMode\n*L\n20#1:38\n20#1:42\n21#1:39,3\n35#1:43\n35#1:44,2\n*E\n"})
public final class CommandGameMode
extends Command {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final HashMap<GameType, List<String>> GAME_MODE_LINKS;

    public CommandGameMode() {
        String[] stringArray = new String[]{"GM", "GameMode"};
        super(stringArray);
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(args.length == 0)) {
            Map $this$forEach$iv = GAME_MODE_LINKS;
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.entrySet().iterator();
            while (iterator2.hasNext()) {
                boolean bl2;
                Map.Entry it;
                block5: {
                    Map.Entry element$iv;
                    it = element$iv = iterator2.next();
                    boolean bl3 = false;
                    Iterable $this$any$iv = (Iterable)it.getValue();
                    boolean $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl2 = false;
                    } else {
                        for (Object element$iv2 : $this$any$iv) {
                            String text = (String)element$iv2;
                            boolean bl4 = false;
                            if (!StringsKt.equals(text, args[0], true)) continue;
                            bl2 = true;
                            break block5;
                        }
                        bl2 = false;
                    }
                }
                if (!bl2) continue;
                mc.field_71442_b.func_78746_a((GameType)it.getKey());
                system.getMessageManager().display.displayInfo("\u6e38\u620f\u6a21\u5f0f\u5207\u6362\u6210\u529f");
                return;
            }
            system.getMessageManager().display.displayWarn("\u6e38\u620f\u6a21\u5f0f\u4e0d\u5b58\u5728");
            return;
        }
        system.getMessageManager().display.displayDarkCommandSyntax("gamemode <...>");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<String> complete(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        String[] stringArray = new String[]{"survival", "creative", "adventure", "spectator"};
        Iterable $this$filter$iv = CollectionsKt.arrayListOf(stringArray);
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it = (String)element$iv$iv;
            boolean bl2 = false;
            if (!StringsKt.startsWith$default(it, ArraysKt.last(args), false, 2, null)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    static {
        Pair[] pairArray = new Pair[4];
        String[] stringArray = new String[]{"0", "survival", "s"};
        pairArray[0] = TuplesKt.to(GameType.SURVIVAL, CollectionsKt.mutableListOf(stringArray));
        stringArray = new String[]{"1", "creative", "c"};
        pairArray[1] = TuplesKt.to(GameType.CREATIVE, CollectionsKt.mutableListOf(stringArray));
        stringArray = new String[]{"2", "adventure", "a"};
        pairArray[2] = TuplesKt.to(GameType.ADVENTURE, CollectionsKt.mutableListOf(stringArray));
        stringArray = new String[]{"3", "spectator", "sp"};
        pairArray[3] = TuplesKt.to(GameType.SPECTATOR, CollectionsKt.mutableListOf(stringArray));
        GAME_MODE_LINKS = MapsKt.hashMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R9\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/CommandGameMode$Companion;", "", "<init>", "()V", "GAME_MODE_LINKS", "Ljava/util/HashMap;", "Lnet/minecraft/world/GameType;", "", "", "Lkotlin/collections/HashMap;", "getGAME_MODE_LINKS", "()Ljava/util/HashMap;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashMap<GameType, List<String>> getGAME_MODE_LINKS() {
            return GAME_MODE_LINKS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

