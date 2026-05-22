/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Keyboard
 */
package net.darkmeow.darkmeow.commands.impl.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseConfig;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/CommandBind;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandBind.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandBind.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandBind\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,46:1\n1#2:47\n1563#3:48\n1634#3,3:49\n774#3:52\n865#3,2:53\n1563#3:55\n1634#3,3:56\n774#3:59\n865#3,2:60\n3829#4:62\n4344#4,2:63\n*S KotlinDebug\n*F\n+ 1 CommandBind.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandBind\n*L\n34#1:48\n34#1:49,3\n35#1:52\n35#1:53,2\n38#1:55\n38#1:56,3\n39#1:59\n39#1:60,2\n42#1:62\n42#1:63,2\n*E\n"})
public final class CommandBind
extends Command {
    public CommandBind() {
        String[] stringArray = new String[]{"Bind"};
        super(stringArray);
    }

    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length >= 2) {
            Module module = system.getModuleManager().getModule(args[0]);
            if (module != null) {
                String string;
                Object object;
                Module module2;
                Module module3 = module2 = module;
                boolean bl2 = false;
                Object object2 = this;
                try {
                    String string2;
                    CommandBind $this$execute_u24lambda_u243_u24lambda_u241 = object2;
                    boolean bl3 = false;
                    String[] stringArray = args;
                    int n2 = 2;
                    if (n2 < stringArray.length) {
                        string2 = stringArray[n2];
                    } else {
                        int it = n2;
                        boolean bl4 = false;
                        string2 = module3.getBaseConfig().getKeyBindType().toString();
                    }
                    String string3 = string2.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(string3, "toUpperCase(...)");
                    object = Result.constructor-impl((Object)ModuleBaseConfig.KeyBindType.valueOf(string3));
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl(ResultKt.createFailure(throwable));
                }
                object2 = object;
                object = module3.getBaseConfig().getKeyBindType();
                ModuleBaseConfig.KeyBindType type = (ModuleBaseConfig.KeyBindType)((Object)(Result.isFailure-impl(object2) ? object : object2));
                object = args;
                int n3 = 3;
                if (n3 < ((String[])object).length) {
                    string = object[n3];
                } else {
                    int it = n3;
                    boolean bl5 = false;
                    string = String.valueOf(module3.getBaseConfig().getNotifyToggle());
                }
                boolean notifyToggle = StringsKt.startsWith(string, "t", true);
                ModuleBaseConfig moduleBaseConfig = module3.getBaseConfig();
                String string4 = args[1].toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(string4, "toUpperCase(...)");
                moduleBaseConfig.setKeyBindId(Keyboard.getKeyIndex((String)string4));
                module3.getBaseConfig().setKeyBindType(type);
                module3.getBaseConfig().setNotifyToggle(notifyToggle);
                system.getMessageManager().display.displayInfo("\u6210\u529f\u8bbe\u7f6e\u6a21\u5757 " + args[0] + " \u7684\u5feb\u6377\u952e\u4e3a " + Keyboard.getKeyName((int)module3.getBaseConfig().getKeyBindId()));
            } else {
                CommandBind $this$execute_u24lambda_u244 = this;
                boolean bl6 = false;
                system.getMessageManager().display.displayWarn("\u6a21\u5757 " + args[0] + " \u4e0d\u5b58\u5728");
            }
            return;
        }
        system.getMessageManager().display.displayDarkCommandSyntax("bind <module> <id(or none)> [type]");
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
                String it;
                void $this$mapTo$iv$iv;
                Iterable $this$map$iv;
                Iterable iterable = system.getModuleManager().getModules();
                boolean $i$f$map = false;
                void var6_10 = $this$map$iv;
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
                break;
            }
            case 3: {
                Object it;
                Iterable $this$mapTo$iv$iv;
                Iterable $this$map$iv;
                Iterable $this$filter$iv = ModuleBaseConfig.KeyBindType.getEntries();
                boolean $i$f$map = false;
                void $this$filterTo$iv$iv = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    it = (ModuleBaseConfig.KeyBindType)((Object)item$iv$iv);
                    Collection collection = destination$iv$iv;
                    boolean bl4 = false;
                    String string = it.name().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
                    collection.add(string);
                }
                $this$map$iv = (List)destination$iv$iv;
                boolean $i$f$filter = false;
                $this$mapTo$iv$iv = $this$filter$iv;
                destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    it = (String)element$iv$iv;
                    boolean bl5 = false;
                    if (!StringsKt.startsWith((String)it, ArraysKt.last(args), true)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                list = CollectionsKt.toList((List)destination$iv$iv);
                break;
            }
            case 4: {
                String[] $this$filter$iv = new String[]{"true", "false"};
                boolean $i$f$filter = false;
                String[] $this$filterTo$iv$iv = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                int n2 = $this$filterTo$iv$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    String element$iv$iv;
                    String it = element$iv$iv = $this$filterTo$iv$iv[i2];
                    boolean bl6 = false;
                    if (!StringsKt.startsWith(it, ArraysKt.last(args), true)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                list = CollectionsKt.toList((List)destination$iv$iv);
                break;
            }
            default: {
                list = CollectionsKt.emptyList();
            }
        }
        return list;
    }
}

