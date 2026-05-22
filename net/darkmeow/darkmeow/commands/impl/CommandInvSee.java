/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.commands.Command;
import net.darkmeow.darkmeow.utils.world.WorldUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/CommandInvSee;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandInvSee.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandInvSee.kt\nnet/darkmeow/darkmeow/commands/impl/CommandInvSee\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1617#2,9:58\n1869#2:67\n1870#2:69\n1626#2:70\n774#2:71\n865#2,2:72\n2767#2:74\n1878#2,3:76\n2767#2:79\n1878#2,3:81\n1#3:68\n1#3:75\n1#3:80\n*S KotlinDebug\n*F\n+ 1 CommandInvSee.kt\nnet/darkmeow/darkmeow/commands/impl/CommandInvSee\n*L\n52#1:58,9\n52#1:67\n52#1:69\n52#1:70\n53#1:71\n53#1:72,2\n27#1:74\n27#1:76,3\n31#1:79\n31#1:81,3\n52#1:68\n27#1:75\n31#1:80\n*E\n"})
public final class CommandInvSee
extends Command {
    public CommandInvSee() {
        String[] stringArray = new String[]{"InvSee"};
        super(stringArray);
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Unit unit;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(args.length == 0)) {
            Entity entity;
            WorldClient worldClient = mc.field_71441_e;
            if (worldClient != null && (entity = WorldUtils.INSTANCE.findEntity((World)worldClient, args[0])) != null) {
                Entity entity2;
                Entity entity3 = entity2 = entity;
                boolean bl2 = false;
                DarkMeow.INSTANCE.getUpdateManager().addScheduledTask(() -> CommandInvSee.execute$lambda$4$lambda$3(mc, entity3));
                unit = entity2;
            } else {
                CommandInvSee $this$execute_u24lambda_u245 = this;
                boolean bl3 = false;
                unit = system.getMessageManager().display.displayError("\u5b9e\u4f53 " + args[0] + " \u4e0d\u5b58\u5728");
            }
        } else {
            unit = system.getMessageManager().display.displayDarkCommandSyntax("invsee <entity>");
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<String> complete(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        List<String> list;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length == 1) {
            List list2;
            WorldClient worldClient = mc.field_71441_e;
            if (worldClient != null && (list2 = worldClient.field_73010_i) != null) {
                void $this$filterTo$iv$iv;
                void $this$filter$iv;
                void $this$mapNotNullTo$iv$iv;
                void $this$mapNotNull$iv;
                Iterable iterable = list2;
                boolean $i$f$mapNotNull22 = false;
                void var8_9 = $this$mapNotNull$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    String it$iv$iv;
                    Object element$iv$iv$iv;
                    Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                    boolean bl2 = false;
                    EntityPlayer it = (EntityPlayer)element$iv$iv;
                    boolean bl3 = false;
                    if (it.func_146103_bH().getName() == null) continue;
                    boolean bl4 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                Iterable $i$f$mapNotNull22 = (List)destination$iv$iv;
                boolean $i$f$filter = false;
                destination$iv$iv = $this$filter$iv;
                Collection destination$iv$iv2 = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    String it = (String)element$iv$iv;
                    boolean bl5 = false;
                    if (!StringsKt.startsWith(it, ArraysKt.last(args), true)) continue;
                    destination$iv$iv2.add(element$iv$iv);
                }
                list = (List)destination$iv$iv2;
            } else {
                list = CollectionsKt.emptyList();
            }
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    private static final void execute$lambda$4$lambda$3(Minecraft $mc, Entity $entity) {
        ItemStack slot;
        void $this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u242;
        int index;
        int n2;
        Iterable iterable;
        InventoryBasic inventoryBasic;
        EntityPlayerSP entityPlayerSP = $mc.field_71439_g;
        if (entityPlayerSP == null) {
            return;
        }
        EntityPlayerSP player = entityPlayerSP;
        InventoryBasic inventoryBasic2 = inventoryBasic = new InventoryBasic((ITextComponent)new TextComponentString($entity.func_145748_c_().func_150254_d() + " \u7684\u80cc\u5305"), 9);
        IInventory iInventory = (IInventory)player.field_71071_by;
        Minecraft minecraft = $mc;
        boolean bl2 = false;
        Iterable $this$onEachIndexed$iv = $entity.func_184214_aD();
        boolean $i$f$onEachIndexed = false;
        Iterable $this$onEachIndexed_u24lambda_u2419$iv = iterable = $this$onEachIndexed$iv;
        boolean bl3 = false;
        Iterable $this$forEachIndexed$iv$iv = $this$onEachIndexed_u24lambda_u2419$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$forEachIndexed$iv$iv) {
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ItemStack itemStack = (ItemStack)item$iv$iv;
            index = n2;
            boolean bl4 = false;
            $this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u242.func_70299_a(index, slot);
        }
        $this$onEachIndexed$iv = $entity.func_184193_aE();
        $i$f$onEachIndexed = false;
        $this$onEachIndexed_u24lambda_u2419$iv = iterable = $this$onEachIndexed$iv;
        bl3 = false;
        $this$forEachIndexed$iv$iv = $this$onEachIndexed_u24lambda_u2419$iv;
        $i$f$forEachIndexed = false;
        index$iv$iv = 0;
        for (Object item$iv$iv : $this$forEachIndexed$iv$iv) {
            if ((n2 = index$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            slot = (ItemStack)item$iv$iv;
            index = n2;
            boolean bl5 = false;
            $this$execute_u24lambda_u244_u24lambda_u243_u24lambda_u242.func_70299_a(5 + index, slot);
        }
        Unit unit = Unit.INSTANCE;
        IInventory iInventory2 = (IInventory)inventoryBasic;
        IInventory iInventory3 = iInventory;
        minecraft.func_147108_a((GuiScreen)new GuiChest(iInventory3, iInventory2));
        player.field_71070_bA.field_75152_c = -999;
    }
}

