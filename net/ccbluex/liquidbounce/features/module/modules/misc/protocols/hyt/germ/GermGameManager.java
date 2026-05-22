/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.features.module.modules.misc.protocols.hyt.germ.games.GermGame;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003Re\u0010\u0004\u001aV\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b0\u0005j*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/GermGameManager;", "", "<init>", "()V", "games", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/games/GermGame;", "Lkotlin/collections/HashMap;", "getGames", "()Ljava/util/HashMap;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGermGameManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GermGameManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/GermGameManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,24:1\n1563#2:25\n1634#2,3:26\n1056#2:29\n1869#2,2:30\n*S KotlinDebug\n*F\n+ 1 GermGameManager.kt\nnet/ccbluex/liquidbounce/features/module/modules/misc/protocols/hyt/germ/GermGameManager\n*L\n15#1:25\n15#1:26,3\n16#1:29\n17#1:30,2\n*E\n"})
public final class GermGameManager {
    @NotNull
    private final HashMap<String, HashMap<String, GermGame>> games = new HashMap();

    /*
     * WARNING - void declaration
     */
    public GermGameManager() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".games.impl", GermGame.class);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Class clazz = (Class)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((GermGame)it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        Iterable $this$sortedBy$iv = (List)destination$iv$iv;
        boolean $i$f$sortedBy = false;
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

            public final int compare(T a2, T b2) {
                GermGame it = (GermGame)a2;
                boolean bl2 = false;
                Comparable comparable = Integer.valueOf(-it.getCategory().ordinal() * 100 - it.getEntry());
                it = (GermGame)b2;
                Comparable comparable2 = comparable;
                bl2 = false;
                return ComparisonsKt.compareValues(comparable2, -it.getCategory().ordinal() * 100 - it.getEntry());
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            GermGame it = (GermGame)element$iv;
            boolean bl3 = false;
            if (!this.games.containsKey(it.getCategory().name())) {
                ((Map)this.games).put(it.getCategory().name(), new HashMap());
            }
            HashMap<String, GermGame> hashMap = this.games.get(it.getCategory().name());
            if (hashMap == null) continue;
            hashMap.put(it.getName(), it);
        }
    }

    @NotNull
    public final HashMap<String, HashMap<String, GermGame>> getGames() {
        return this.games;
    }
}

