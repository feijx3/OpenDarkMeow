/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/CommandToggle;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandToggle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandToggle.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandToggle\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1563#2:32\n1634#2,3:33\n774#2:36\n865#2,2:37\n*S KotlinDebug\n*F\n+ 1 CommandToggle.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandToggle\n*L\n25#1:32\n25#1:33,3\n26#1:36\n26#1:37,2\n*E\n"})
public final class CommandToggle
extends Command {
    public CommandToggle() {
        String[] stringArray = new String[]{"Toggle", "T"};
        super(stringArray);
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(args.length == 0)) {
            Module module = system.getModuleManager().getModule(args[0]);
            if (module != null) {
                Module module2;
                Module module3 = module2 = module;
                boolean bl2 = false;
                DarkMeow.INSTANCE.getUpdateManager().addScheduledTask(() -> CommandToggle.execute$lambda$1$lambda$0(module3));
            } else {
                CommandToggle $this$execute_u24lambda_u242 = this;
                boolean bl3 = false;
                system.getMessageManager().display.displayWarn("\u6a21\u5757 " + args[0] + " \u4e0d\u5b58\u5728");
            }
            return;
        }
        system.getMessageManager().display.displayDarkCommandSyntax("toggle <\u6a21\u5757\u540d>");
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
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            String it;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv;
            Iterable iterable = system.getModuleManager().getModules();
            boolean $i$f$map = false;
            void var6_6 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Module module = (Module)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(((Module)((Object)it)).getName());
            }
            $this$map$iv = (List)destination$iv$iv;
            boolean $i$f$filter = false;
            $this$mapTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                it = (String)element$iv$iv;
                boolean bl3 = false;
                if (!StringsKt.startsWith(it, ArraysKt.last(args), true)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list = CollectionsKt.toList((List)destination$iv$iv);
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    private static final void execute$lambda$1$lambda$0(Module $module) {
        $module.setState(!$module.getState());
    }
}

