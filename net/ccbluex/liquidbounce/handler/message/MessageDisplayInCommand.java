/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.message;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.message.MessageManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0014\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017\u00a2\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001a"}, d2={"Lnet/ccbluex/liquidbounce/handler/message/MessageDisplayInCommand;", "", "command", "Lnet/ccbluex/liquidbounce/handler/message/MessageManager;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/message/MessageManager;)V", "getCommand", "()Lnet/ccbluex/liquidbounce/handler/message/MessageManager;", "display", "", "message", "Lnet/minecraft/util/text/ITextComponent;", "(Lnet/minecraft/util/text/ITextComponent;)Lkotlin/Unit;", "", "(Ljava/lang/String;)Lkotlin/Unit;", "displaySuccess", "displayWarn", "displayError", "displayInfoHighLight", "displayInfo", "displayDarkCommandSyntax", "syntax", "syntaxes", "", "([Ljava/lang/String;)V", "getPrefix", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMessageDisplayInCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageDisplayInCommand.kt\nnet/ccbluex/liquidbounce/handler/message/MessageDisplayInCommand\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,37:1\n13472#2,2:38\n*S KotlinDebug\n*F\n+ 1 MessageDisplayInCommand.kt\nnet/ccbluex/liquidbounce/handler/message/MessageDisplayInCommand\n*L\n28#1:38,2\n*E\n"})
public final class MessageDisplayInCommand {
    @NotNull
    private final MessageManager command;

    public MessageDisplayInCommand(@NotNull MessageManager command) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.command = command;
    }

    @NotNull
    public final MessageManager getCommand() {
        return this.command;
    }

    @Nullable
    public final Unit display(@NotNull ITextComponent message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ITextComponent iTextComponent = new TextComponentString(this.getPrefix()).func_150257_a(message);
        Intrinsics.checkNotNullExpressionValue(iTextComponent, "appendSibling(...)");
        return this.command.displayChatMessage(iTextComponent);
    }

    @Nullable
    public final Unit display(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.display((ITextComponent)new TextComponentString(message));
    }

    @Nullable
    public final Unit displaySuccess(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.display("\u00a7a" + message);
    }

    @Nullable
    public final Unit displayWarn(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.display("\u00a7e" + message);
    }

    @Nullable
    public final Unit displayError(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.display("\u00a7c" + message);
    }

    @Nullable
    public final Unit displayInfoHighLight(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.display("\u00a7f" + message);
    }

    @Nullable
    public final Unit displayInfo(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.display("\u00a77" + message);
    }

    @Nullable
    public final Unit displayDarkCommandSyntax(@NotNull String syntax) {
        Intrinsics.checkNotNullParameter(syntax, "syntax");
        return this.display("\u00a77Syntax: " + DarkMeow.INSTANCE.getCommandManager().getPrefix() + syntax);
    }

    public final void displayDarkCommandSyntax(@NotNull String[] syntaxes) {
        Intrinsics.checkNotNullParameter(syntaxes, "syntaxes");
        this.display("\u00a77Syntax:");
        String[] $this$forEach$iv = syntaxes;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String element$iv;
            String syntax = element$iv = $this$forEach$iv[i2];
            boolean bl2 = false;
            this.command.displayChatMessage("\u00a78> \u00a77" + DarkMeow.INSTANCE.getCommandManager().getPrefix() + syntax);
        }
    }

    @NotNull
    public final String getPrefix() {
        return "\u00a7d" + DarkMeow.INSTANCE.getCLIENT_NAME() + " \u00a78\u00bb \u00a77";
    }
}

