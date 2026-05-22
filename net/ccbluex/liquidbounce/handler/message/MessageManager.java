/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.message;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.handler.message.MessageDisplayInCommand;
import net.ccbluex.liquidbounce.handler.message.notification.NotificationManager;
import net.ccbluex.liquidbounce.injection.backend.MinecraftImpl;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/handler/message/MessageManager;", "", "mc", "Lnet/ccbluex/liquidbounce/injection/backend/MinecraftImpl;", "<init>", "(Lnet/ccbluex/liquidbounce/injection/backend/MinecraftImpl;)V", "notificationManager", "Lnet/ccbluex/liquidbounce/handler/message/notification/NotificationManager;", "display", "Lnet/ccbluex/liquidbounce/handler/message/MessageDisplayInCommand;", "displayChatMessage", "", "message", "", "(Ljava/lang/String;)Lkotlin/Unit;", "component", "Lnet/minecraft/util/text/ITextComponent;", "(Lnet/minecraft/util/text/ITextComponent;)Lkotlin/Unit;", "DarkMeow"})
public final class MessageManager {
    @NotNull
    private final MinecraftImpl mc;
    @JvmField
    @NotNull
    public final NotificationManager notificationManager;
    @JvmField
    @NotNull
    public final MessageDisplayInCommand display;

    public MessageManager(@NotNull MinecraftImpl mc) {
        Intrinsics.checkNotNullParameter(mc, "mc");
        this.mc = mc;
        this.notificationManager = new NotificationManager();
        this.display = new MessageDisplayInCommand(this);
    }

    @Nullable
    public final Unit displayChatMessage(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return this.displayChatMessage((ITextComponent)new TextComponentString(message));
    }

    @Nullable
    public final Unit displayChatMessage(@NotNull ITextComponent component) {
        Unit unit;
        Intrinsics.checkNotNullParameter(component, "component");
        EntityPlayerSP entityPlayerSP = this.mc.getPlayer();
        if (entityPlayerSP != null) {
            entityPlayerSP.func_145747_a(component);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }
}

