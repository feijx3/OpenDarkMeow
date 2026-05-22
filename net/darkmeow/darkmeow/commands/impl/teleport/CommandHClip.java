/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.teleport;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/teleport/CommandHClip;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandHClip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandHClip.kt\nnet/darkmeow/darkmeow/commands/impl/teleport/CommandHClip\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,29:1\n1#2:30\n*E\n"})
public final class CommandHClip
extends Command {
    public CommandHClip() {
        String[] stringArray = new String[]{"HClip"};
        super(stringArray);
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Object object;
        Integer n2;
        String[] stringArray;
        Object object2;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        String[] it = object2 = args;
        boolean bl2 = false;
        Object object3 = stringArray = !(it.length == 0) ? object2 : null;
        if (stringArray != null && (object2 = stringArray[0]) != null && (n2 = StringsKt.toIntOrNull((String)object2)) != null) {
            Integer n3 = n2;
            int xz = ((Number)n3).intValue();
            boolean bl3 = false;
            EntityPlayerSP entityPlayerSP = mc.field_71439_g;
            if (entityPlayerSP != null) {
                EntityPlayerSP player = entityPlayerSP;
                Entity entity = player.func_184187_bx();
                if (entity == null) {
                    entity = (Entity)player;
                }
                Entity entity2 = entity;
                double yaw = Math.toRadians(entity2.field_70177_z);
                entity2.func_70107_b(entity2.field_70165_t + -Math.sin(yaw) * (double)xz, entity2.field_70163_u, entity2.field_70161_v + Math.cos(yaw) * (double)xz);
                system.getMessageManager().display.displaySuccess("\u4f20\u9001\u6210\u529f");
            }
            object = ((Number)n3).intValue();
        } else {
            CommandHClip $this$execute_u24lambda_u242 = this;
            boolean bl4 = false;
            object = system.getMessageManager().display.displayDarkCommandSyntax("hclip <Number>");
        }
    }
}

