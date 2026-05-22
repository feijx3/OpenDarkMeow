/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.handler.message.notification.Notification;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/client/NotificationEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "notification", "Lnet/ccbluex/liquidbounce/handler/message/notification/Notification;", "<init>", "(Lnet/ccbluex/liquidbounce/handler/message/notification/Notification;)V", "getNotification", "()Lnet/ccbluex/liquidbounce/handler/message/notification/Notification;", "DarkMeow"})
public final class NotificationEvent
extends CancellableEvent {
    @NotNull
    private final Notification notification;

    public NotificationEvent(@NotNull Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.notification = notification;
    }

    @NotNull
    public final Notification getNotification() {
        return this.notification;
    }
}

