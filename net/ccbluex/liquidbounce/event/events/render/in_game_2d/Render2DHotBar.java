/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.render.in_game_2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar;", "", "<init>", "()V", "PRE", "POST", "DarkMeow"})
public final class Render2DHotBar {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\t\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar$POST;", "Lnet/ccbluex/liquidbounce/event/Event;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "hotBarItems", "", "", "Lnet/minecraft/item/ItemStack;", "offhandItem", "<init>", "(Lnet/minecraft/entity/player/EntityPlayer;Ljava/util/Map;Lnet/minecraft/item/ItemStack;)V", "event", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar$PRE;", "(Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar$PRE;)V", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "getHotBarItems", "()Ljava/util/Map;", "getOffhandItem", "()Lnet/minecraft/item/ItemStack;", "DarkMeow"})
    public static final class POST
    extends Event {
        @NotNull
        private final EntityPlayer player;
        @NotNull
        private final Map<Integer, ItemStack> hotBarItems;
        @NotNull
        private final ItemStack offhandItem;

        public POST(@NotNull EntityPlayer player, @NotNull Map<Integer, ItemStack> hotBarItems, @NotNull ItemStack offhandItem) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(hotBarItems, "hotBarItems");
            Intrinsics.checkNotNullParameter(offhandItem, "offhandItem");
            this.player = player;
            this.hotBarItems = hotBarItems;
            this.offhandItem = offhandItem;
        }

        @NotNull
        public final EntityPlayer getPlayer() {
            return this.player;
        }

        @NotNull
        public final Map<Integer, ItemStack> getHotBarItems() {
            return this.hotBarItems;
        }

        @NotNull
        public final ItemStack getOffhandItem() {
            return this.offhandItem;
        }

        public POST(@NotNull PRE event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this(event.getPlayer(), event.getHotBarItems(), event.getOffhandItem());
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar$PRE;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "hotBarItems", "", "", "Lnet/minecraft/item/ItemStack;", "offhandItem", "<init>", "(Lnet/minecraft/entity/player/EntityPlayer;Ljava/util/Map;Lnet/minecraft/item/ItemStack;)V", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "getHotBarItems", "()Ljava/util/Map;", "getOffhandItem", "()Lnet/minecraft/item/ItemStack;", "setOffhandItem", "(Lnet/minecraft/item/ItemStack;)V", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nRender2DHotBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Render2DHotBar.kt\nnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar$PRE\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n1573#2:38\n1604#2,4:39\n*S KotlinDebug\n*F\n+ 1 Render2DHotBar.kt\nnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DHotBar$PRE\n*L\n19#1:38\n19#1:39,4\n*E\n"})
    public static final class PRE
    extends CancellableEvent {
        @NotNull
        private final EntityPlayer player;
        @NotNull
        private final Map<Integer, ItemStack> hotBarItems;
        @NotNull
        private ItemStack offhandItem;

        public PRE(@NotNull EntityPlayer player, @NotNull Map<Integer, ItemStack> hotBarItems, @NotNull ItemStack offhandItem) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(hotBarItems, "hotBarItems");
            Intrinsics.checkNotNullParameter(offhandItem, "offhandItem");
            this.player = player;
            this.hotBarItems = hotBarItems;
            this.offhandItem = offhandItem;
        }

        @NotNull
        public final EntityPlayer getPlayer() {
            return this.player;
        }

        @NotNull
        public final Map<Integer, ItemStack> getHotBarItems() {
            return this.hotBarItems;
        }

        @NotNull
        public final ItemStack getOffhandItem() {
            return this.offhandItem;
        }

        public final void setOffhandItem(@NotNull ItemStack itemStack) {
            Intrinsics.checkNotNullParameter(itemStack, "<set-?>");
            this.offhandItem = itemStack;
        }

        /*
         * WARNING - void declaration
         */
        public PRE(@NotNull EntityPlayer player) {
            Collection<Pair<Integer, void>> collection;
            void $this$mapIndexedTo$iv$iv;
            void $this$mapIndexed$iv;
            Intrinsics.checkNotNullParameter(player, "player");
            List list = player.field_71071_by.field_70462_a.subList(0, 9);
            Intrinsics.checkNotNullExpressionValue(list, "subList(...)");
            Iterable iterable = list;
            EntityPlayer entityPlayer = player;
            PRE pRE = this;
            boolean $i$f$mapIndexed = false;
            void var4_6 = $this$mapIndexed$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                void itemStack;
                void index;
                int n2;
                if ((n2 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ItemStack itemStack2 = (ItemStack)item$iv$iv;
                int n3 = n2;
                collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(TuplesKt.to((int)index, itemStack));
            }
            collection = (List)destination$iv$iv;
            Map<Integer, ItemStack> map = MapsKt.toMutableMap(MapsKt.toMap((Iterable)collection));
            ItemStack itemStack = player.func_184592_cb();
            Intrinsics.checkNotNullExpressionValue(itemStack, "getHeldItemOffhand(...)");
            pRE(entityPlayer, map, itemStack);
        }
    }
}

