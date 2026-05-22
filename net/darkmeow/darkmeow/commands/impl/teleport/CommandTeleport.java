/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.teleport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
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
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/teleport/CommandTeleport;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandTeleport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandTeleport.kt\nnet/darkmeow/darkmeow/commands/impl/teleport/CommandTeleport\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,131:1\n3829#2:132\n4344#2,2:133\n1#3:135\n1#3:146\n1617#4,9:136\n1869#4:145\n1870#4:147\n1626#4:148\n774#4:149\n865#4,2:150\n*S KotlinDebug\n*F\n+ 1 CommandTeleport.kt\nnet/darkmeow/darkmeow/commands/impl/teleport/CommandTeleport\n*L\n121#1:132\n121#1:133,2\n126#1:146\n126#1:136,9\n126#1:145\n126#1:147\n126#1:148\n127#1:149\n127#1:150,2\n*E\n"})
public final class CommandTeleport
extends Command {
    public CommandTeleport() {
        String[] stringArray = new String[]{"Teleport", "TP"};
        super(stringArray);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        block79: {
            block78: {
                block77: {
                    Intrinsics.checkNotNullParameter(system, "system");
                    Intrinsics.checkNotNullParameter(mc, "mc");
                    Intrinsics.checkNotNullParameter(args, "args");
                    var4_4 = args.length == 0 != false ? "" : args[0];
                    switch (var4_4.hashCode()) {
                        case 112: {
                            if (var4_4.equals("p")) break;
                            ** break;
                        }
                        case 114: {
                            if (!var4_4.equals("r")) {
                                ** break;
                            }
                            break block77;
                        }
                        case -1068318794: {
                            if (!var4_4.equals("motion")) {
                                ** break;
                            }
                            break block78;
                        }
                        case 101: {
                            if (!var4_4.equals("e")) {
                                ** break;
                            }
                            ** GOTO lbl41
                        }
                        case 111188: {
                            if (var4_4.equals("pos")) break;
                            ** break;
                        }
                        case 113111: {
                            if (!var4_4.equals("rot")) {
                                ** break;
                            }
                            break block77;
                        }
                        case -40300674: {
                            if (!var4_4.equals("rotation")) {
                                ** break;
                            }
                            break block77;
                        }
                        case 0x2C929929: {
                            if (var4_4.equals("position")) break;
                            ** break;
                        }
                        case 109: {
                            if (!var4_4.equals("m")) {
                                ** break;
                            }
                            break block78;
                        }
                        case -1298275357: {
                            if (!var4_4.equals("entity")) ** break;
lbl41:
                            // 2 sources

                            var5_5 = this;
                            try {
                                $this$execute_u24lambda_u242 = var5_5;
                                $i$a$-runCatching-CommandTeleport$execute$1 = false;
                                v0 = mc.field_71439_g;
                                if (v0 == null) {
                                    return;
                                }
                                player = v0;
                                v1 = player.func_184187_bx();
                                if (v1 == null) {
                                    v1 = entity = (Entity)player;
                                }
                                if (args.length < 2) {
                                    throw new Exception("");
                                }
                                var10_45 = entity.field_70170_p;
                                if (var10_45 == null || (var11_49 = WorldUtils.INSTANCE.findEntity(var10_45, args[1])) == null) {
                                    $this$execute_u24lambda_u242_u24lambda_u241 = $this$execute_u24lambda_u242;
                                    $i$a$-run-CommandTeleport$execute$1$2 = false;
                                    throw new Exception("\u672a\u627e\u5230\u5bf9\u5e94\u5b9e\u4f53");
                                }
                                otherEntity = var12_52 = var11_49;
                                $i$a$-also-CommandTeleport$execute$1$1 = false;
                                entity.func_70080_a(otherEntity.field_70165_t, otherEntity.field_70163_u, otherEntity.field_70161_v, otherEntity.field_70177_z, otherEntity.field_70125_A);
                                system.getMessageManager().display.displaySuccess("\u4f20\u9001\u6210\u529f");
                                $this$execute_u24lambda_u242 = Result.constructor-impl(var12_52);
                            }
                            catch (Throwable $i$a$-runCatching-CommandTeleport$execute$1) {
                                $this$execute_u24lambda_u242 = Result.constructor-impl(ResultKt.createFailure($i$a$-runCatching-CommandTeleport$execute$1));
                            }
                            var5_5 = $this$execute_u24lambda_u242;
                            v2 = Result.exceptionOrNull-impl(var5_5);
                            if (v2 != null) {
                                e = $this$execute_u24lambda_u242 = v2;
                                $i$a$-onFailure-CommandTeleport$execute$2 = false;
                                entity = Intrinsics.areEqual(e.getMessage(), "");
                                if (entity) {
                                    v3 = system.getMessageManager().display.displayDarkCommandSyntax("teleport entity <search>");
                                } else if (!entity) {
                                    v3 = system.getMessageManager().display.displayError("\u53c2\u6570\u6709\u8bef: " + e.getMessage());
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            if (Result.isSuccess-impl(var5_5)) {
                                it = (Entity)var5_5;
                                $i$a$-onSuccess-CommandTeleport$execute$3 = false;
                                system.getMessageManager().display.displaySuccess("\u4f20\u9001\u6210\u529f");
                            }
                            v4 = Result.box-impl(var5_5);
                            break block79;
                        }
                    }
                    var5_6 = this;
                    try {
                        $this$execute_u24lambda_u245 = var5_6;
                        $i$a$-runCatching-CommandTeleport$execute$4 = false;
                        v5 = mc.field_71439_g;
                        if (v5 == null) {
                            return;
                        }
                        player = v5;
                        v6 = player.func_184187_bx();
                        if (v6 == null) {
                            v6 = entity = (Entity)player;
                        }
                        if (args.length != 4 && args.length != 6) {
                            throw new Exception("");
                        }
                        v7 = StringsKt.toDoubleOrNull(args[1]);
                        if (v7 == null) {
                            throw new Exception("\u65e0\u6548\u7684 X \u4f4d\u7f6e\u53c2\u6570");
                        }
                        x = v7;
                        v8 = StringsKt.toDoubleOrNull(args[2]);
                        if (v8 == null) {
                            throw new Exception("\u65e0\u6548\u7684 Y \u4f4d\u7f6e\u53c2\u6570");
                        }
                        y = v8;
                        v9 = StringsKt.toDoubleOrNull(args[3]);
                        if (v9 == null) {
                            throw new Exception("\u65e0\u6548\u7684 Z \u4f4d\u7f6e\u53c2\u6570");
                        }
                        z = v9;
                        if (args.length != 6) ** GOTO lbl126
                        v10 = StringsKt.toFloatOrNull(args[4]);
                        if (v10 != null) {
                            v11 = v10.floatValue();
                        } else {
                            throw new Exception("\u65e0\u6548\u7684 Yaw \u4f4d\u7f6e\u53c2\u6570");
lbl126:
                            // 1 sources

                            v11 = yaw = entity.field_70177_z;
                        }
                        if (args.length != 6) ** GOTO lbl133
                        v12 = StringsKt.toFloatOrNull(args[5]);
                        if (v12 != null) {
                            v13 = v12.floatValue();
                        } else {
                            throw new Exception("\u65e0\u6548\u7684 Pitch \u4f4d\u7f6e\u53c2\u6570");
lbl133:
                            // 1 sources

                            v13 = entity.field_70125_A;
                        }
                        pitch = v13;
                        entity.func_70080_a(x, y, z, yaw, pitch);
                        $this$execute_u24lambda_u245 = Result.constructor-impl(Unit.INSTANCE);
                    }
                    catch (Throwable $i$a$-runCatching-CommandTeleport$execute$4) {
                        $this$execute_u24lambda_u245 = Result.constructor-impl(ResultKt.createFailure($i$a$-runCatching-CommandTeleport$execute$4));
                    }
                    var5_6 = $this$execute_u24lambda_u245;
                    v14 = Result.exceptionOrNull-impl(var5_6);
                    if (v14 != null) {
                        e = $this$execute_u24lambda_u245 = v14;
                        $i$a$-onFailure-CommandTeleport$execute$5 = false;
                        entity = Intrinsics.areEqual(e.getMessage(), "");
                        if (entity) {
                            v15 = system.getMessageManager().display.displayDarkCommandSyntax("teleport position <x> <y> <z> [yaw] [pitch]");
                        } else if (!entity) {
                            v15 = system.getMessageManager().display.displayError("\u53c2\u6570\u6709\u8bef: " + e.getMessage());
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    if (Result.isSuccess-impl(var5_6)) {
                        it = (Unit)var5_6;
                        $i$a$-onSuccess-CommandTeleport$execute$6 = false;
                        system.getMessageManager().display.displaySuccess("\u4f20\u9001\u6210\u529f");
                    }
                    v4 = Result.box-impl(var5_6);
                    break block79;
                }
                var5_7 = this;
                try {
                    $this$execute_u24lambda_u248 = var5_7;
                    $i$a$-runCatching-CommandTeleport$execute$7 = false;
                    v16 = mc.field_71439_g;
                    if (v16 == null) {
                        return;
                    }
                    player = v16;
                    v17 = player.func_184187_bx();
                    if (v17 == null) {
                        v17 = entity = (Entity)player;
                    }
                    if (args.length != 3) {
                        throw new Exception("");
                    }
                    v18 = StringsKt.toFloatOrNull(args[1]);
                    if (v18 == null) {
                        throw new Exception("\u65e0\u6548\u7684 Yaw \u4f4d\u7f6e\u53c2\u6570");
                    }
                    yaw = v18.floatValue();
                    v19 = StringsKt.toFloatOrNull(args[2]);
                    if (v19 == null) {
                        throw new Exception("\u65e0\u6548\u7684 Pitch \u4f4d\u7f6e\u53c2\u6570");
                    }
                    pitch = v19.floatValue();
                    entity.field_70177_z = yaw;
                    entity.field_70125_A = pitch;
                    $this$execute_u24lambda_u248 = Result.constructor-impl(Unit.INSTANCE);
                }
                catch (Throwable $i$a$-runCatching-CommandTeleport$execute$7) {
                    $this$execute_u24lambda_u248 = Result.constructor-impl(ResultKt.createFailure($i$a$-runCatching-CommandTeleport$execute$7));
                }
                var5_7 = $this$execute_u24lambda_u248;
                v20 = Result.exceptionOrNull-impl(var5_7);
                if (v20 != null) {
                    e = $this$execute_u24lambda_u248 = v20;
                    $i$a$-onFailure-CommandTeleport$execute$8 = false;
                    entity = Intrinsics.areEqual(e.getMessage(), "");
                    if (entity) {
                        v21 = system.getMessageManager().display.displayDarkCommandSyntax("teleport rotation <yaw> <pitch>");
                    } else if (!entity) {
                        v21 = system.getMessageManager().display.displayError("\u53c2\u6570\u6709\u8bef: " + e.getMessage());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (Result.isSuccess-impl(var5_7)) {
                    it = (Unit)var5_7;
                    $i$a$-onSuccess-CommandTeleport$execute$9 = false;
                    system.getMessageManager().display.displaySuccess("\u4f20\u9001\u6210\u529f");
                }
                v4 = Result.box-impl(var5_7);
                break block79;
            }
            var5_8 = this;
            try {
                $this$execute_u24lambda_u2411 = var5_8;
                $i$a$-runCatching-CommandTeleport$execute$10 = false;
                v22 = mc.field_71439_g;
                if (v22 == null) {
                    return;
                }
                player = v22;
                v23 = player.func_184187_bx();
                if (v23 == null) {
                    v23 = entity = (Entity)player;
                }
                if (!(4 <= (var10_48 = args.length) ? var10_48 < 6 : false)) {
                    throw new Exception("");
                }
                v24 = StringsKt.toDoubleOrNull(args[1]);
                if (v24 == null) {
                    throw new Exception("\u65e0\u6548\u7684 MotionX \u53c2\u6570");
                }
                motionX = v24;
                v25 = StringsKt.toDoubleOrNull(args[2]);
                if (v25 == null) {
                    throw new Exception("\u65e0\u6548\u7684 MotionY \u53c2\u6570");
                }
                motionY = v25;
                v26 = StringsKt.toDoubleOrNull(args[3]);
                if (v26 == null) {
                    throw new Exception("\u65e0\u6548\u7684 MotionZ \u53c2\u6570");
                }
                motionZ = v26;
                if (args.length != 5) ** GOTO lbl250
                v27 = StringsKt.toFloatOrNull(args[4]);
                if (v27 != null) {
                    v28 = v27.floatValue();
                } else {
                    throw new Exception("\u65e0\u6548\u7684 FallDistance \u53c2\u6570");
lbl250:
                    // 1 sources

                    v28 = entity.field_70143_R;
                }
                fallDistance = v28;
                entity.field_70159_w = motionX;
                entity.field_70181_x = motionY;
                entity.field_70179_y = motionZ;
                entity.field_70143_R = fallDistance;
                $this$execute_u24lambda_u2411 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch (Throwable $i$a$-runCatching-CommandTeleport$execute$10) {
                $this$execute_u24lambda_u2411 = Result.constructor-impl(ResultKt.createFailure($i$a$-runCatching-CommandTeleport$execute$10));
            }
            var5_8 = $this$execute_u24lambda_u2411;
            v29 = Result.exceptionOrNull-impl(var5_8);
            if (v29 != null) {
                e = $this$execute_u24lambda_u2411 = v29;
                $i$a$-onFailure-CommandTeleport$execute$11 = false;
                var9_44 = Intrinsics.areEqual(e.getMessage(), "");
                if (var9_44) {
                    v30 = system.getMessageManager().display.displayDarkCommandSyntax("teleport motion <x> <y> <z> [fall]");
                } else if (!var9_44) {
                    v30 = system.getMessageManager().display.displayError("\u53c2\u6570\u6709\u8bef: " + e.getMessage());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            if (Result.isSuccess-impl(var5_8)) {
                it = (Unit)var5_8;
                $i$a$-onSuccess-CommandTeleport$execute$12 = false;
                system.getMessageManager().display.displaySuccess("\u4f20\u9001\u6210\u529f");
            }
            v4 = Result.box-impl(var5_8);
            break block79;
lbl283:
            // 11 sources

            v4 = system.getMessageManager().display.displayDarkCommandSyntax("teleport <entity/position/rotation/motion> [...]");
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
        switch (args.length) {
            case 1: {
                void $this$filterTo$iv$iv;
                void $this$filter$iv;
                String[] stringArray = new String[]{"entity", "position", "rotation", "motion"};
                boolean $i$f$filter = false;
                void var6_8 = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                int n2 = ((void)$this$filterTo$iv$iv).length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void element$iv$iv;
                    void it = element$iv$iv = $this$filterTo$iv$iv[i2];
                    boolean bl2 = false;
                    if (!StringsKt.startsWith((String)it, ArraysKt.last(args), true)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                list = CollectionsKt.toList((List)destination$iv$iv);
                break;
            }
            case 2: {
                WorldClient worldClient = mc.field_71441_e;
                if (worldClient != null) {
                    WorldClient worldClient2;
                    Object object;
                    WorldClient it = object = worldClient;
                    boolean bl32 = false;
                    Object object2 = worldClient2 = StringsKt.startsWith$default(args[0], "e", false, 2, null) ? object : null;
                    if (worldClient2 != null && (object = worldClient2.field_73010_i) != null) {
                        void $this$filterTo$iv$iv;
                        void $this$filter$iv;
                        void $this$mapNotNullTo$iv$iv;
                        void $this$mapNotNull$iv;
                        Iterable bl32 = (Iterable)object;
                        boolean $i$f$mapNotNull22 = false;
                        void var10_19 = $this$mapNotNull$iv;
                        Collection destination$iv$iv = new ArrayList();
                        boolean $i$f$mapNotNullTo = false;
                        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                        boolean $i$f$forEach = false;
                        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
                        while (iterator2.hasNext()) {
                            String it$iv$iv;
                            Object element$iv$iv$iv;
                            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                            boolean bl4 = false;
                            EntityPlayer it2 = (EntityPlayer)element$iv$iv;
                            boolean bl5 = false;
                            if (it2.func_146103_bH().getName() == null) continue;
                            boolean bl6 = false;
                            destination$iv$iv.add(it$iv$iv);
                        }
                        Iterable $i$f$mapNotNull22 = (List)destination$iv$iv;
                        boolean $i$f$filter = false;
                        destination$iv$iv = $this$filter$iv;
                        Collection destination$iv$iv2 = new ArrayList();
                        boolean $i$f$filterTo = false;
                        for (Object element$iv$iv : $this$filterTo$iv$iv) {
                            String it3 = (String)element$iv$iv;
                            boolean bl7 = false;
                            if (!StringsKt.startsWith(it3, ArraysKt.last(args), true)) continue;
                            destination$iv$iv2.add(element$iv$iv);
                        }
                        list = (List)destination$iv$iv2;
                        break;
                    }
                }
                list = CollectionsKt.emptyList();
                break;
            }
            default: {
                list = CollectionsKt.emptyList();
            }
        }
        return list;
    }
}

