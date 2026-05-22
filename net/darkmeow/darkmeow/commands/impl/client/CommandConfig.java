/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.commands.impl.client;

import java.io.File;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.darkmeow.darkmeow.commands.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/CommandConfig;", "Lnet/darkmeow/darkmeow/commands/Command;", "<init>", "()V", "execute", "", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "mc", "Lnet/minecraft/client/Minecraft;", "args", "", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)V", "complete", "", "(Lnet/ccbluex/liquidbounce/DarkMeow;Lnet/minecraft/client/Minecraft;[Ljava/lang/String;)Ljava/util/List;", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nCommandConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommandConfig.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,108:1\n1#2:109\n1563#3:110\n1634#3,3:111\n1878#3,3:114\n774#3:120\n865#3,2:121\n774#3:123\n865#3,2:124\n1563#3:126\n1634#3,3:127\n774#3:130\n865#3,2:131\n3829#4:117\n4344#4,2:118\n*S KotlinDebug\n*F\n+ 1 CommandConfig.kt\nnet/darkmeow/darkmeow/commands/impl/client/CommandConfig\n*L\n46#1:110\n46#1:111,3\n77#1:114,3\n99#1:120\n99#1:121,2\n100#1:123\n100#1:124,2\n101#1:126\n101#1:127,3\n102#1:130\n102#1:131,2\n93#1:117\n93#1:118,2\n*E\n"})
public final class CommandConfig
extends Command {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final TextComponentString JOIN_TO_COMPONENT;

    public CommandConfig() {
        String[] stringArray = new String[]{"Config", "CFG", "C"};
        super(stringArray);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void execute(@NotNull DarkMeow system, @NotNull Minecraft mc, @NotNull String[] args) {
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(mc, "mc");
        Intrinsics.checkNotNullParameter(args, "args");
        var4_4 = args.length == 0 != false ? "" : args[0];
        tmp = -1;
        switch (var4_4.hashCode()) {
            case 1126940025: {
                if (var4_4.equals("current")) {
                    tmp = 1;
                }
                break;
            }
            case -934641255: {
                if (var4_4.equals("reload")) {
                    tmp = 2;
                }
                break;
            }
            case 3327206: {
                if (var4_4.equals("load")) {
                    tmp = 3;
                }
                break;
            }
            case 3522941: {
                if (var4_4.equals("save")) {
                    tmp = 4;
                }
                break;
            }
            case 3322014: {
                if (var4_4.equals("list")) {
                    tmp = 5;
                }
                break;
            }
        }
        switch (tmp) {
            case 1: {
                DarkMeow.INSTANCE.getMessageManager().display.displayInfoHighLight("\u5f53\u524d\u914d\u7f6e: " + DarkMeow.INSTANCE.getConfigManager().getCurrentConfig());
                break;
            }
            case 4: {
                DarkMeow.INSTANCE.getConfigManager().save(false);
                DarkMeow.INSTANCE.getMessageManager().display.displaySuccess("\u914d\u7f6e " + DarkMeow.INSTANCE.getConfigManager().getCurrentConfig() + ".json \u4fdd\u5b58\u6210\u529f");
                break;
            }
            case 3: {
                var6_5 = args;
                it = var6_5;
                $i$a$-takeIf-CommandConfig$execute$1 = false;
                v0 /* !! */  = var5_13 = ((String[])it).length == 2 != false ? var6_5 : null;
                if (var5_13 == null) break;
                it = var5_13;
                $i$a$-let-CommandConfig$execute$2 = false;
                file = it = new File(DarkMeow.INSTANCE.getFileManager().getConfigsDir(), StringsKt.removeSuffix(args[1], (CharSequence)".json") + ".json");
                $i$a$-also-CommandConfig$execute$3 = false;
                v1 = file.exists() != false && file.isFile() != false ? Boolean.valueOf(DarkMeow.INSTANCE.getUpdateManager().addScheduledTask((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, execute$lambda$3$lambda$2(java.io.File ), ()V)((File)file))) : DarkMeow.INSTANCE.getMessageManager().display.displayError("\u914d\u7f6e " + FilesKt.getNameWithoutExtension((File)file) + " \u4e0d\u5b58\u5728");
                break;
            }
            case 2: {
                DarkMeow.INSTANCE.getUpdateManager().addScheduledTask((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, execute$lambda$4(), ()V)());
                break;
            }
            case 5: {
                var5_14 = DarkMeow.INSTANCE.getFileManager().getConfigsDir().listFiles();
                if (var5_14 != null && (var6_6 = ArraysKt.asSequence(var5_14)) != null && (it = SequencesKt.toList(var6_6)) != null) {
                    file = it;
                    $i$f$map = false;
                    var10_18 = $this$map$iv;
                    destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $i$f$mapTo = false;
                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                        var15_28 = (File)item$iv$iv;
                        var20_34 = destination$iv$iv;
                        $i$a$-map-CommandConfig$execute$5 = false;
                        Intrinsics.checkNotNull(cfg);
                        $this$execute_u24lambda_u246_u24lambda_u245 = var17_30 = new TextComponentString(FilesKt.getNameWithoutExtension((File)cfg));
                        $i$a$-apply-CommandConfig$execute$5$1 = false;
                        $this$execute_u24lambda_u246_u24lambda_u245.func_150255_a($this$execute_u24lambda_u246_u24lambda_u245.func_150256_b().func_150238_a(TextFormatting.GRAY));
                        $this$execute_u24lambda_u246_u24lambda_u245.func_150255_a($this$execute_u24lambda_u246_u24lambda_u245.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString("\u00a7f\u914d\u7f6e\u540d: " + FilesKt.getNameWithoutExtension((File)cfg) + '\n' + ("\u00a7f\u914d\u7f6e\u6587\u4ef6: " + cfg + ')') + '\n' + '\n' + "\u00a7f\u70b9\u51fb\u4ee5\u5207\u6362"))));
                        $this$execute_u24lambda_u246_u24lambda_u245.func_150255_a($this$execute_u24lambda_u246_u24lambda_u245.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ".config load " + FilesKt.getNameWithoutExtension((File)cfg))));
                        var20_34.add(var17_30);
                    }
                    v2 = (List)destination$iv$iv;
                } else {
                    v2 = null;
                }
                list = var5_14 = v2;
                $i$a$-also-CommandConfig$execute$6 = false;
                $this$execute_u24lambda_u2411_u24lambda_u247 = var8_12 = new TextComponentString("\u914d\u7f6e\u5217\u8868: ");
                $i$a$-apply-CommandConfig$execute$6$text$1 = false;
                $this$execute_u24lambda_u2411_u24lambda_u247.func_150255_a($this$execute_u24lambda_u2411_u24lambda_u247.func_150256_b().func_150238_a(TextFormatting.GRAY));
                text = var8_12;
                if (list == null) ** GOTO lbl-1000
                it /* !! */  = var9_17 = list;
                $i$a$-takeIf-CommandConfig$execute$6$1 = false;
                v3 /* !! */  = var8_12 = !((Collection)it /* !! */ ).isEmpty() != false ? var9_17 : null;
                if (var8_12 != null) {
                    it /* !! */  = (Iterable)var8_12;
                    $i$f$forEachIndexed = false;
                    index$iv = 0;
                    for (T item$iv : $this$forEachIndexed$iv) {
                        if ((var16_29 = index$iv++) < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        var17_30 = (TextComponentString)item$iv;
                        index = var16_29;
                        $i$a$-forEachIndexed-CommandConfig$execute$6$2 = false;
                        if (index > 0) {
                            text.func_150257_a((ITextComponent)CommandConfig.JOIN_TO_COMPONENT);
                        }
                        text.func_150257_a((ITextComponent)component);
                    }
                } else lbl-1000:
                // 2 sources

                {
                    $this$execute_u24lambda_u2411_u24lambda_u2410 = this;
                    $i$a$-run-CommandConfig$execute$6$3 = false;
                    text.func_150258_a("\u672a\u4efb\u4f55\u53ef\u7528\u914d\u7f6e");
                }
                system.getMessageManager().display.display((ITextComponent)text);
                break;
            }
            default: {
                system.getMessageManager().display.displayDarkCommandSyntax("config <current/save/load/list>");
            }
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
                String[] stringArray = new String[]{"current", "save", "load", "list"};
                boolean $i$f$filter = false;
                void var6_7 = $this$filter$iv;
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
                String string = args[0].toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
                if (Intrinsics.areEqual(string, "load")) {
                    Iterable $this$mapTo$iv$iv;
                    Iterable $this$map$iv;
                    Object it;
                    Iterable $this$filterTo$iv$iv;
                    Iterable $this$filter$iv;
                    File[] fileArray = DarkMeow.INSTANCE.getFileManager().getConfigsDir().listFiles();
                    if (fileArray == null) {
                        fileArray = new File[]{};
                    }
                    Iterable $i$f$filter = SequencesKt.toList(ArraysKt.asSequence(fileArray));
                    boolean $i$f$filter2 = false;
                    void destination$iv$iv = $this$filter$iv;
                    Collection destination$iv$iv2 = new ArrayList();
                    boolean $i$f$filterTo = false;
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        it = (File)element$iv$iv;
                        boolean bl3 = false;
                        if (!((File)it).isFile()) continue;
                        destination$iv$iv2.add(element$iv$iv);
                    }
                    $this$filter$iv = (List)destination$iv$iv2;
                    $i$f$filter2 = false;
                    $this$filterTo$iv$iv = $this$filter$iv;
                    destination$iv$iv2 = new ArrayList();
                    $i$f$filterTo = false;
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        it = (File)element$iv$iv;
                        boolean bl4 = false;
                        String string2 = ((File)it).getName();
                        Intrinsics.checkNotNullExpressionValue(string2, "getName(...)");
                        if (!StringsKt.endsWith$default(string2, ".json", false, 2, null)) continue;
                        destination$iv$iv2.add(element$iv$iv);
                    }
                    $this$filter$iv = (List)destination$iv$iv2;
                    boolean $i$f$map = false;
                    $this$filterTo$iv$iv = $this$map$iv;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        it = (File)item$iv$iv;
                        Collection collection = destination$iv$iv2;
                        boolean bl5 = false;
                        String string3 = ((File)it).getName();
                        Intrinsics.checkNotNullExpressionValue(string3, "getName(...)");
                        collection.add(StringsKt.removeSuffix(string3, (CharSequence)".json"));
                    }
                    $this$map$iv = (List)destination$iv$iv2;
                    $i$f$filter2 = false;
                    $this$mapTo$iv$iv = $this$filter$iv;
                    destination$iv$iv2 = new ArrayList();
                    $i$f$filterTo = false;
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        it = (String)element$iv$iv;
                        boolean bl6 = false;
                        if (!StringsKt.startsWith((String)it, ArraysKt.last(args), true)) continue;
                        destination$iv$iv2.add(element$iv$iv);
                    }
                    list = CollectionsKt.toList((List)destination$iv$iv2);
                    break;
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

    private static final void execute$lambda$3$lambda$2(File $file) {
        DarkMeow.INSTANCE.getConfigManager().load(FilesKt.getNameWithoutExtension($file));
        DarkMeow.INSTANCE.getMessageManager().display.displaySuccess("\u5df2\u52a0\u8f7d\u914d\u7f6e " + DarkMeow.INSTANCE.getConfigManager().getCurrentConfig());
    }

    private static final void execute$lambda$4() {
        DarkMeow.INSTANCE.getConfigManager().load(DarkMeow.INSTANCE.getConfigManager().getCurrentConfig());
        DarkMeow.INSTANCE.getMessageManager().display.displaySuccess("\u5df2\u91cd\u65b0\u52a0\u8f7d\u914d\u7f6e " + DarkMeow.INSTANCE.getConfigManager().getCurrentConfig());
    }

    static {
        TextComponentString textComponentString;
        Companion = new Companion(null);
        TextComponentString $this$JOIN_TO_COMPONENT_u24lambda_u2417 = textComponentString = new TextComponentString(", ");
        boolean bl2 = false;
        $this$JOIN_TO_COMPONENT_u24lambda_u2417.func_150255_a($this$JOIN_TO_COMPONENT_u24lambda_u2417.func_150256_b().func_150238_a(TextFormatting.GRAY));
        JOIN_TO_COMPONENT = textComponentString;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/darkmeow/darkmeow/commands/impl/client/CommandConfig$Companion;", "", "<init>", "()V", "JOIN_TO_COMPONENT", "Lnet/minecraft/util/text/TextComponentString;", "getJOIN_TO_COMPONENT", "()Lnet/minecraft/util/text/TextComponentString;", "DarkMeow"})
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

