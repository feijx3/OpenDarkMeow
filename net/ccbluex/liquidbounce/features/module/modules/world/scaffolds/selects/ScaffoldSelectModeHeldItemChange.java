/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.selects;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldSelectMode;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.ScaffoldStatic;
import net.ccbluex.liquidbounce.injection.extend.ExtendPlayerControllerMP;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/selects/ScaffoldSelectModeHeldItemChange;", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/ScaffoldSelectMode;", "<init>", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "silentValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "lastSelectSlot", "", "onPlacePre", "", "onDisable", "", "searchSlots", "Ljava/util/LinkedHashMap;", "Lnet/minecraft/item/ItemStack;", "Lkotlin/collections/LinkedHashMap;", "player", "Lnet/minecraft/client/entity/EntityPlayerSP;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nScaffoldSelectModeHeldItemChange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaffoldSelectModeHeldItemChange.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/selects/ScaffoldSelectModeHeldItemChange\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,83:1\n295#2:84\n296#2:87\n295#2:88\n296#2:91\n12637#3,2:85\n12637#3,2:89\n1#4:92\n*S KotlinDebug\n*F\n+ 1 ScaffoldSelectModeHeldItemChange.kt\nnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/selects/ScaffoldSelectModeHeldItemChange\n*L\n29#1:84\n29#1:87\n35#1:88\n35#1:91\n33#1:85,2\n39#1:89,2\n*E\n"})
public final class ScaffoldSelectModeHeldItemChange
extends ScaffoldSelectMode {
    @NotNull
    private final ListValue modeValue;
    @NotNull
    private final BoolValue silentValue;
    private int lastSelectSlot;

    public ScaffoldSelectModeHeldItemChange() {
        super("HeldItemChange");
        String[] stringArray = new String[]{"First", "Last", "Sequential", "Reverse", "MoreBlock", "LessBlock", "Random"};
        this.modeValue = new ListValue("Mode", stringArray, "First");
        this.silentValue = new BoolValue("Silent", false);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean onPlacePre() {
        block38: {
            block34: {
                block37: {
                    block33: {
                        block36: {
                            block31: {
                                block35: {
                                    v0 = MinecraftInstance.mc.getPlayer();
                                    if (v0 == null) {
                                        return false;
                                    }
                                    player = v0;
                                    slots = this.searchSlots(player);
                                    slot = null;
                                    var4_4 = (String)this.modeValue.get();
                                    switch (var4_4.hashCode()) {
                                        case 2361014: {
                                            if (var4_4.equals("Last")) break;
                                            ** break;
                                        }
                                        case -1952028076: {
                                            if (!var4_4.equals("LessBlock")) {
                                                ** break;
                                            }
                                            break block34;
                                        }
                                        case 1829453087: {
                                            if (!var4_4.equals("Sequential")) {
                                                ** break;
                                            }
                                            break block35;
                                        }
                                        case -1530467646: {
                                            if (!var4_4.equals("Reverse")) {
                                                ** break;
                                            }
                                            break block36;
                                        }
                                        case -504592872: {
                                            if (!var4_4.equals("MoreBlock")) {
                                                ** break;
                                            }
                                            break block37;
                                        }
                                        case -1854418717: {
                                            if (!var4_4.equals("Random")) {
                                                ** break;
                                            }
                                            break block38;
                                        }
                                        case 67887760: {
                                            if (!var4_4.equals("First")) ** break;
                                            v1 = slots.keySet();
                                            Intrinsics.checkNotNullExpressionValue(v1, "<get-keys>(...)");
                                            slot = (Integer)CollectionsKt.firstOrNull((Iterable)v1);
                                            ** break;
                                        }
                                    }
                                    v2 = slots.keySet();
                                    Intrinsics.checkNotNullExpressionValue(v2, "<get-keys>(...)");
                                    slot = (Integer)CollectionsKt.lastOrNull((Iterable)v2);
                                    ** break;
                                }
                                v3 = slots.keySet();
                                Intrinsics.checkNotNullExpressionValue(v3, "<get-keys>(...)");
                                $this$firstOrNull$iv = v3;
                                $i$f$firstOrNull = false;
                                for (T element$iv : $this$firstOrNull$iv) {
                                    block30: {
                                        indexSlot = (Integer)element$iv;
                                        $i$a$-firstOrNull-ScaffoldSelectModeHeldItemChange$onPlacePre$1 = false;
                                        var11_29 = new Boolean[2];
                                        var11_29[0] = indexSlot > this.lastSelectSlot;
                                        v4 = slots.keySet();
                                        Intrinsics.checkNotNullExpressionValue(v4, "<get-keys>(...)");
                                        var11_29[1] = this.lastSelectSlot >= ((Number)CollectionsKt.last((Iterable)v4)).intValue();
                                        $i$f$any = false;
                                        for (void element$iv : $this$any$iv) {
                                            it = element$iv.booleanValue();
                                            $i$a$-any-ScaffoldSelectModeHeldItemChange$onPlacePre$1$1 = false;
                                            if (!it) continue;
                                            v5 = true;
                                            break block30;
                                        }
                                        v5 = false;
                                    }
                                    if (!v5) continue;
                                    v6 = element$iv;
                                    break block31;
                                }
                                v6 = null;
                            }
                            slot = v6;
                            ** break;
                        }
                        v7 = slots.keySet();
                        Intrinsics.checkNotNullExpressionValue(v7, "<get-keys>(...)");
                        $this$firstOrNull$iv = CollectionsKt.reversed((Iterable)v7);
                        $i$f$firstOrNull = false;
                        for (T element$iv : $this$firstOrNull$iv) {
                            block32: {
                                indexSlot = (Integer)element$iv;
                                $i$a$-firstOrNull-ScaffoldSelectModeHeldItemChange$onPlacePre$2 = false;
                                $this$any$iv = new Boolean[2];
                                $this$any$iv[0] = indexSlot < this.lastSelectSlot;
                                v8 = slots.keySet();
                                Intrinsics.checkNotNullExpressionValue(v8, "<get-keys>(...)");
                                $this$any$iv[1] = this.lastSelectSlot <= ((Number)CollectionsKt.first((Iterable)v8)).intValue();
                                $i$f$any = false;
                                for (Boolean element$iv : $this$any$iv) {
                                    it = element$iv;
                                    $i$a$-any-ScaffoldSelectModeHeldItemChange$onPlacePre$2$1 = false;
                                    if (!it) continue;
                                    v9 = true;
                                    break block32;
                                }
                                v9 = false;
                            }
                            if (!v9) continue;
                            v10 = element$iv;
                            break block33;
                        }
                        v10 = null;
                    }
                    slot = v10;
                    ** break;
                }
                var6_9 = ((Map)slots).entrySet();
                var7_12 = var6_9.iterator();
                if (!var7_12.hasNext()) {
                    throw new NoSuchElementException();
                }
                element$iv = var7_12.next();
                if (!var7_12.hasNext()) {
                    v11 = element$iv;
                } else {
                    indexSlot = (Map.Entry)element$iv;
                    $i$a$-maxByOrThrow-ScaffoldSelectModeHeldItemChange$onPlacePre$3 = false;
                    stack = (ItemStack)indexSlot.getValue();
                    indexSlot = stack.func_190916_E();
                    do {
                        $i$a$-maxByOrThrow-ScaffoldSelectModeHeldItemChange$onPlacePre$3 = var7_12.next();
                        stack = (Map.Entry)$i$a$-maxByOrThrow-ScaffoldSelectModeHeldItemChange$onPlacePre$3;
                        $i$a$-maxByOrThrow-ScaffoldSelectModeHeldItemChange$onPlacePre$3 = false;
                        stack = (ItemStack)stack.getValue();
                        stack = stack.func_190916_E();
                        if (indexSlot >= stack) continue;
                        element$iv = $i$a$-maxByOrThrow-ScaffoldSelectModeHeldItemChange$onPlacePre$3;
                        indexSlot = stack;
                    } while (var7_12.hasNext());
                    v11 = element$iv;
                }
                slot = (Integer)((Map.Entry)v11).getKey();
                ** break;
            }
            var6_10 = ((Map)slots).entrySet();
            var7_12 = var6_10.iterator();
            if (!var7_12.hasNext()) {
                throw new NoSuchElementException();
            }
            element$iv = var7_12.next();
            if (!var7_12.hasNext()) {
                v12 = element$iv;
            } else {
                indexSlot = (Map.Entry)element$iv;
                $i$a$-minByOrThrow-ScaffoldSelectModeHeldItemChange$onPlacePre$4 = false;
                stack = (ItemStack)indexSlot.getValue();
                indexSlot = stack.func_190916_E();
                do {
                    var10_28 = var7_12.next();
                    var11_36 = (Map.Entry)var10_28;
                    $i$a$-minByOrThrow-ScaffoldSelectModeHeldItemChange$onPlacePre$4 = false;
                    stack = (ItemStack)var11_36.getValue();
                    var11_37 = stack.func_190916_E();
                    if (indexSlot <= var11_37) continue;
                    element$iv = var10_28;
                    indexSlot = var11_37;
                } while (var7_12.hasNext());
                v12 = element$iv;
            }
            slot = (Integer)((Map.Entry)v12).getKey();
            ** break;
        }
        v13 = slots.keySet();
        Intrinsics.checkNotNullExpressionValue(v13, "<get-keys>(...)");
        slot = (Integer)CollectionsKt.randomOrNull((Collection)v13, Random.Default);
lbl160:
        // 15 sources

        var4_4 = slot;
        if (var4_4 != null) {
            var6_11 = var4_4;
            it = ((Number)var6_11).intValue();
            $i$a$-also-ScaffoldSelectModeHeldItemChange$onPlacePre$5 = false;
            if (((Boolean)this.silentValue.get()).booleanValue() && DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot == null) {
                DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot = player.field_71071_by.field_70461_c;
            }
            this.lastSelectSlot = it;
            player.field_71071_by.field_70461_c = it;
            ExtendPlayerControllerMP.INSTANCE.syncCurrentPlayItem(MinecraftInstance.mc.getPlayerController());
            it = ((Number)var6_11).intValue();
            $i$a$-let-ScaffoldSelectModeHeldItemChange$onPlacePre$6 = false;
            v14 = true;
        } else {
            v14 = false;
        }
        return v14;
    }

    @Override
    public void onDisable() {
        block2: {
            EntityPlayerSP entityPlayerSP;
            EntityPlayerSP entityPlayerSP2;
            EntityPlayerSP entityPlayerSP3 = MinecraftInstance.mc.getPlayer();
            if (entityPlayerSP3 == null) break block2;
            EntityPlayerSP it = entityPlayerSP2 = entityPlayerSP3;
            boolean bl2 = false;
            Object object = entityPlayerSP = (Boolean)this.silentValue.get() != false ? entityPlayerSP2 : null;
            if (entityPlayerSP != null) {
                EntityPlayerSP player = entityPlayerSP2 = entityPlayerSP;
                boolean bl3 = false;
                Integer n2 = DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot;
                if (n2 != null) {
                    Integer n3 = n2;
                    int slot = ((Number)n3).intValue();
                    boolean bl4 = false;
                    player.field_71071_by.field_70461_c = slot;
                    DarkMeow.INSTANCE.getInventoryManager().currentSpoofSlot = null;
                }
            }
        }
    }

    @NotNull
    public final LinkedHashMap<Integer, ItemStack> searchSlots(@NotNull EntityPlayerSP player) {
        Intrinsics.checkNotNullParameter(player, "player");
        NonNullList inventory = player.field_71069_bz.func_75138_a();
        boolean bl2 = false;
        LinkedHashMap<Integer, ItemStack> map = new LinkedHashMap<Integer, ItemStack>();
        for (int index = 36; index < 45; ++index) {
            Object object = inventory.get(index);
            Intrinsics.checkNotNullExpressionValue(object, "get(...)");
            ItemStack itemStack = (ItemStack)object;
            if (!ScaffoldStatic.INSTANCE.allowScaffoldUse(itemStack)) continue;
            ((Map)map).put(index - 36, itemStack);
        }
        return map;
    }
}

