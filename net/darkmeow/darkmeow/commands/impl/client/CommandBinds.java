/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.input.Keyboard
 */
package net.darkmeow.darkmeow.commands.impl.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000f"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/CommandBinds;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandBinds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandBinds.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandBinds\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n774#2:78\n865#2,2:79\n2756#2:81\n774#2:83\n865#2,2:84\n1563#2:86\n1634#2,2:87\n1636#2:90\n1878#2,3:91\n1#3:82\n1#3:89\n*S KotlinDebug\n*F\n+ 1 CommandBinds.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandBinds\n*L\n22#1:78\n22#1:79,2\n23#1:81\n29#1:83\n29#1:84,2\n30#1:86\n30#1:87,2\n30#1:90\n63#1:91,3\n23#1:82\n*E\n"})
public final class CommandBinds
extends Command {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final TextComponentString JOIN_TO_COMPONENT;

    public CommandBinds() {
        String[] stringArray = new String[]{"Binds"};
        super(stringArray);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        if (Intrinsics.areEqual(args.length == 0 ? "" : args[0], "clear")) {
            void $this$onEach$iv;
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv;
            Iterable iterable = DarkMeow.INSTANCE.getModuleManager().getModules();
            boolean $i$f$filter = false;
            void var6_10 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Module it = (Module)element$iv$iv;
                boolean bl2 = false;
                if (!(it.getBaseConfig().getKeyBindId() != 0)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$onEach = false;
            void $this$onEach_u24lambda_u2418$iv = $this$filterTo$iv$iv = $this$onEach$iv;
            boolean bl3 = false;
            for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                Module module = (Module)element$iv;
                boolean bl4 = false;
                module.getBaseConfig().setKeyBindId(0);
            }
            $this$onEach$iv = $this$filterTo$iv$iv;
            List it = (List)$this$onEach$iv;
            boolean bl5 = false;
            system.getMessageManager().display.displayInfo("\u5df2\u6e05\u7a7a\u6240\u6709\u6a21\u5757\u7ed1\u5b9a\u5feb\u6377\u952e");
            List cfr_ignored_0 = (List)$this$onEach$iv;
        } else {
            List list;
            Object object;
            List list2;
            StringBuilder stringBuilder;
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Module it;
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv;
            Iterable $this$onEach$iv = DarkMeow.INSTANCE.getModuleManager().getModules();
            boolean $i$f$filter = false;
            void bl5 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                it = (Module)element$iv$iv;
                boolean bl6 = false;
                if (!(it.getBaseConfig().getKeyBindId() != 0)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$map = false;
            $this$filterTo$iv$iv = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Object object2;
                void module;
                it = (Module)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl7 = false;
                TextComponentString textComponentString = new TextComponentString(module.getName());
                TextComponentString $this$execute_u24lambda_u246_u24lambda_u245 = textComponentString;
                boolean bl8 = false;
                $this$execute_u24lambda_u246_u24lambda_u245.func_150255_a($this$execute_u24lambda_u246_u24lambda_u245.func_150256_b().func_150238_a(TextFormatting.GRAY));
                stringBuilder = new StringBuilder().append("\u00a7f\u6a21\u5757\u540d: " + module.getName()).append('\n');
                Object object3 = $this$execute_u24lambda_u246_u24lambda_u245;
                StringBuilder stringBuilder2 = new StringBuilder().append("\u00a7f\u7ed1\u5b9a\u5feb\u6377\u952e: ");
                HoverEvent.Action action = HoverEvent.Action.SHOW_TEXT;
                Style style = $this$execute_u24lambda_u246_u24lambda_u245.func_150256_b();
                TextComponentString textComponentString2 = $this$execute_u24lambda_u246_u24lambda_u245;
                try {
                    TextComponentString $this$execute_u24lambda_u246_u24lambda_u245_u24lambda_u244 = object3;
                    boolean bl9 = false;
                    object2 = Result.constructor-impl(Keyboard.getKeyName((int)module.getBaseConfig().getKeyBindId()));
                }
                catch (Throwable throwable) {
                    object2 = Result.constructor-impl(ResultKt.createFailure(throwable));
                }
                Object object4 = object2;
                object3 = object4;
                object2 = "\u65e0\u6548\u6309\u952e";
                stringBuilder = stringBuilder.append(stringBuilder2.append((String)(Result.isFailure-impl(object3) ? object2 : object3)).append(" (").append(module.getBaseConfig().getKeyBindId()).append(')').toString()).append('\n');
                stringBuilder = stringBuilder.append("\u00a7f\u7ed1\u5b9a\u89e6\u53d1\u65b9\u5f0f: " + module.getBaseConfig().getKeyBindType().name()).append('\n');
                String string = stringBuilder.append("\u00a7f\u662f\u5426\u901a\u77e5: " + module.getBaseConfig().getNotifyToggle()).append('\n').append('\n').append("\u00a7f\u70b9\u51fb\u4fee\u6539\u5feb\u6377\u952e").toString();
                ITextComponent iTextComponent = (ITextComponent)new TextComponentString(string);
                HoverEvent.Action action2 = action;
                textComponentString2.func_150255_a(style.func_150209_a(new HoverEvent(action2, iTextComponent)));
                $this$execute_u24lambda_u246_u24lambda_u245.func_150255_a($this$execute_u24lambda_u246_u24lambda_u245.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, ".bind " + module.getName() + ' ')));
                collection.add(textComponentString);
            }
            List list3 = list2 = (List)destination$iv$iv;
            boolean bl10 = false;
            TextComponentString $this$execute_u24lambda_u2411_u24lambda_u247 = object = new TextComponentString("\u7ed1\u5b9a\u5feb\u6377\u952e\u5217\u8868: ");
            boolean bl11 = false;
            $this$execute_u24lambda_u2411_u24lambda_u247.func_150255_a($this$execute_u24lambda_u2411_u24lambda_u247.func_150256_b().func_150238_a(TextFormatting.GRAY));
            TextComponentString text = object;
            Iterable it2 = list = list3;
            boolean bl12 = false;
            Object object5 = object = !((Collection)it2).isEmpty() ? list : null;
            if (object != null) {
                void $this$forEachIndexed$iv;
                it2 = (Iterable)object;
                boolean $i$f$forEachIndexed = false;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    void component;
                    int n2;
                    if ((n2 = index$iv++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    stringBuilder = (TextComponentString)item$iv;
                    int index = n2;
                    boolean bl13 = false;
                    if (index > 0) {
                        text.func_150257_a((ITextComponent)JOIN_TO_COMPONENT);
                    }
                    text.func_150257_a((ITextComponent)component);
                }
            } else {
                CommandBinds $this$execute_u24lambda_u2411_u24lambda_u2410 = this;
                boolean bl14 = false;
                text.func_150258_a("\u672a\u7ed1\u5b9a\u4efb\u4f55\u5feb\u6377\u952e");
            }
            system.getMessageManager().display.display((ITextComponent)text);
        }
    }

    static {
        TextComponentString textComponentString;
        Companion = new Companion(null);
        TextComponentString $this$JOIN_TO_COMPONENT_u24lambda_u2412 = textComponentString = new TextComponentString(", ");
        boolean bl2 = false;
        $this$JOIN_TO_COMPONENT_u24lambda_u2412.func_150255_a($this$JOIN_TO_COMPONENT_u24lambda_u2412.func_150256_b().func_150238_a(TextFormatting.GRAY));
        JOIN_TO_COMPONENT = textComponentString;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/CommandBinds$Companion;", "", "<init>", "()V", "JOIN_TO_COMPONENT", "Lnet/minecraft/util/text/TextComponentString;", "getJOIN_TO_COMPONENT", "()Lnet/minecraft/util/text/TextComponentString;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TextComponentString getJOIN_TO_COMPONENT() {
            return JOIN_TO_COMPONENT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

