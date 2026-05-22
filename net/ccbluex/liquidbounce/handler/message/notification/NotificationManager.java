/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.message.notification;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.events.client.NotificationEvent;
import net.ccbluex.liquidbounce.handler.message.notification.INotificationListener;
import net.ccbluex.liquidbounce.handler.message.notification.Notification;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/handler/message/notification/NotificationManager;", "", "<init>", "()V", "listeners", "", "Lnet/ccbluex/liquidbounce/handler/message/notification/INotificationListener;", "push", "", "notification", "Lnet/ccbluex/liquidbounce/handler/message/notification/Notification;", "noEvent", "registerListener", "listener", "unregisterListener", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nNotificationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationManager.kt\nnet/ccbluex/liquidbounce/handler/message/notification/NotificationManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1#2:57\n1869#3,2:58\n*S KotlinDebug\n*F\n+ 1 NotificationManager.kt\nnet/ccbluex/liquidbounce/handler/message/notification/NotificationManager\n*L\n35#1:58,2\n*E\n"})
public final class NotificationManager {
    @JvmField
    @NotNull
    public final List<INotificationListener> listeners = new ArrayList();

    @JvmOverloads
    public final boolean push(@NotNull Notification notification, boolean noEvent) {
        boolean bl2;
        Notification notification2;
        boolean bl3;
        Object object;
        NotificationEvent notificationEvent;
        Notification notification3;
        Intrinsics.checkNotNullParameter(notification, "notification");
        Notification it = notification3 = notification;
        boolean bl4 = false;
        NotificationEvent it2 = notificationEvent = new NotificationEvent(it);
        boolean bl5 = false;
        Object object2 = object = !noEvent ? notificationEvent : null;
        if (object != null) {
            NotificationEvent event = it2 = object;
            boolean bl6 = false;
            EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), event, null, 2, null);
            NotificationEvent event2 = it2;
            boolean bl7 = false;
            bl3 = !event2.isCancelled();
        } else {
            bl3 = true;
        }
        Notification notification4 = notification2 = bl3 ? notification3 : null;
        if (notification2 != null) {
            Notification notification5;
            Notification it3 = notification5 = notification2;
            boolean bl8 = false;
            Iterable $this$forEach$iv = this.listeners;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                INotificationListener listener = (INotificationListener)element$iv;
                boolean bl9 = false;
                listener.onNotification(it3);
            }
            Notification it4 = notification5;
            boolean bl10 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    public static /* synthetic */ boolean push$default(NotificationManager notificationManager, Notification notification, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return notificationManager.push(notification, bl2);
    }

    public final boolean registerListener(@NotNull INotificationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.add(listener);
    }

    public final boolean unregisterListener(@NotNull INotificationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.remove(listener);
    }

    @JvmOverloads
    public final boolean push(@NotNull Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        return NotificationManager.push$default(this, notification, false, 2, null);
    }
}

