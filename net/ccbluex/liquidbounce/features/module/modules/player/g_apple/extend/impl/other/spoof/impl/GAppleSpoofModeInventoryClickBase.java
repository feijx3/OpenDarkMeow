/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.ccbluex.liquidbounce.features.module.modules.player.g_apple.extend.impl.other.spoof.GAppleSpoofMode;
import net.darkmeow.darkmeow.event.listenable.SafeListenerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH&J\u0014\u0010\f\u001a\u00020\r*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModeInventoryClickBase;", "Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/GAppleSpoofMode;", "name", "", "<init>", "(Ljava/lang/String;)V", "shouldActive", "", "Lnet/darkmeow/darkmeow/event/listenable/SafeListenerBase;", "slot", "", "minStartCount", "post", "", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nGAppleSpoofModeInventoryClickBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GAppleSpoofModeInventoryClickBase.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModeInventoryClickBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n295#2,2:41\n*S KotlinDebug\n*F\n+ 1 GAppleSpoofModeInventoryClickBase.kt\nnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModeInventoryClickBase\n*L\n30#1:41,2\n*E\n"})
public abstract class GAppleSpoofModeInventoryClickBase
extends GAppleSpoofMode {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final List<Integer> FALL_DOWN_SLOTS;

    public GAppleSpoofModeInventoryClickBase(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        super(name);
    }

    @Override
    public boolean shouldActive(@NotNull SafeListenerBase $this$shouldActive, int slot) {
        Intrinsics.checkNotNullParameter($this$shouldActive, "<this>");
        return $this$shouldActive.getPlayer().field_71071_by.func_70445_o().func_190926_b() && ((ItemStack)$this$shouldActive.getPlayer().field_71069_bz.func_75138_a().get(slot + 36)).func_190916_E() > this.minStartCount();
    }

    public abstract int minStartCount();

    /*
     * WARNING - void declaration
     */
    @Override
    public void post(@NotNull SafeListenerBase $this$post, int slot) {
        block2: {
            Object v0;
            Object object;
            block1: {
                void $this$firstOrNull$iv;
                block3: {
                    Intrinsics.checkNotNullParameter($this$post, "<this>");
                    System.out.println();
                    if ($this$post.getPlayer().field_71071_by.func_70445_o().func_190926_b()) break block2;
                    if (!$this$post.getPlayer().field_71069_bz.func_94530_a($this$post.getPlayer().field_71071_by.func_70445_o(), $this$post.getPlayer().field_71069_bz.func_75139_a(slot + 36))) break block3;
                    $this$post.getPlayerController().func_187098_a(0, slot + 36, 0, ClickType.PICKUP, (EntityPlayer)$this$post.getPlayer());
                    break block2;
                }
                object = FALL_DOWN_SLOTS;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    int newSlot = ((Number)element$iv).intValue();
                    boolean bl2 = false;
                    if (!$this$post.getPlayer().field_71069_bz.func_94530_a($this$post.getPlayer().field_71071_by.func_70445_o(), $this$post.getPlayer().field_71069_bz.func_75139_a(newSlot))) continue;
                    v0 = element$iv;
                    break block1;
                }
                v0 = null;
            }
            Integer n2 = v0;
            if (n2 == null) break block2;
            object = n2;
            int newSlot = ((Number)object).intValue();
            boolean bl3 = false;
            $this$post.getPlayerController().func_187098_a(0, newSlot, 0, ClickType.PICKUP, (EntityPlayer)$this$post.getPlayer());
        }
    }

    static {
        List list;
        Companion = new Companion(null);
        List $this$FALL_DOWN_SLOTS_u24lambda_u242 = list = (List)new ArrayList();
        boolean bl2 = false;
        $this$FALL_DOWN_SLOTS_u24lambda_u242.addAll(CollectionsKt.toList(new IntRange(36, 44)));
        $this$FALL_DOWN_SLOTS_u24lambda_u242.addAll(CollectionsKt.toList(new IntRange(9, 35)));
        $this$FALL_DOWN_SLOTS_u24lambda_u242.add(45);
        FALL_DOWN_SLOTS = list;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/player/g_apple/extend/impl/other/spoof/impl/GAppleSpoofModeInventoryClickBase$Companion;", "", "<init>", "()V", "FALL_DOWN_SLOTS", "", "", "getFALL_DOWN_SLOTS", "()Ljava/util/List;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<Integer> getFALL_DOWN_SLOTS() {
            return FALL_DOWN_SLOTS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

