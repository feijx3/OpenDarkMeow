/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.message.notification;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.handler.message.notification.Notification;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2={"Lnet/ccbluex/liquidbounce/handler/message/notification/INotificationListener;", "", "onNotification", "", "notification", "Lnet/ccbluex/liquidbounce/handler/message/notification/Notification;", "DarkMeow"})
public interface INotificationListener {
    public boolean onNotification(@NotNull Notification var1);
}

