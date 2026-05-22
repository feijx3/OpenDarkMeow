/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.Listenable;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a2\u0006\u0002\u0010\u0010J1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006\u0016"}, d2={"Lnet/darkmeow/darkmeow/commands/Command;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "roots", "", "", "<init>", "([Ljava/lang/String;)V", "root", "[Ljava/lang/String;", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "handleEvents", "", "DarkMeow"})
public abstract class Command
implements Listenable {
    @JvmField
    @NotNull
    public final String[] root;

    public Command(String ... roots) {
        Intrinsics.checkNotNullParameter(roots, "roots");
        this.root = roots;
    }

    public abstract void execute(@NotNull DarkMeow var1, @NotNull Minecraft var2, @NotNull String[] var3);

    @NotNull
    public List<String> complete(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        return CollectionsKt.emptyList();
    }

    @Override
    public boolean handleEvents() {
        return true;
    }
}

