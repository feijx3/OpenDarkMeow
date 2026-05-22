/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.message.notification;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.handler.message.notification.NotificationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/handler/message/notification/Notification;", "", "title", "", "message", "type", "Lnet/ccbluex/liquidbounce/handler/message/notification/NotificationType;", "displayTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/handler/message/notification/NotificationType;J)V", "getTitle", "()Ljava/lang/String;", "getMessage", "getType", "()Lnet/ccbluex/liquidbounce/handler/message/notification/NotificationType;", "getDisplayTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "DarkMeow"})
public final class Notification {
    @NotNull
    private final String title;
    @NotNull
    private final String message;
    @NotNull
    private final NotificationType type;
    private final long displayTime;

    public Notification(@NotNull String title, @NotNull String message, @NotNull NotificationType type, long displayTime) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        this.title = title;
        this.message = message;
        this.type = type;
        this.displayTime = displayTime;
    }

    public /* synthetic */ Notification(String string, String string2, NotificationType notificationType, long l2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            notificationType = NotificationType.INFO;
        }
        if ((n2 & 8) != 0) {
            l2 = 5000L;
        }
        this(string, string2, notificationType, l2);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final NotificationType getType() {
        return this.type;
    }

    public final long getDisplayTime() {
        return this.displayTime;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final NotificationType component3() {
        return this.type;
    }

    public final long component4() {
        return this.displayTime;
    }

    @NotNull
    public final Notification copy(@NotNull String title, @NotNull String message, @NotNull NotificationType type, long displayTime) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter((Object)type, "type");
        return new Notification(title, message, type, displayTime);
    }

    public static /* synthetic */ Notification copy$default(Notification notification, String string, String string2, NotificationType notificationType, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = notification.title;
        }
        if ((n2 & 2) != 0) {
            string2 = notification.message;
        }
        if ((n2 & 4) != 0) {
            notificationType = notification.type;
        }
        if ((n2 & 8) != 0) {
            l2 = notification.displayTime;
        }
        return notification.copy(string, string2, notificationType, l2);
    }

    @NotNull
    public String toString() {
        return "Notification(title=" + this.title + ", message=" + this.message + ", type=" + (Object)((Object)this.type) + ", displayTime=" + this.displayTime + ')';
    }

    public int hashCode() {
        int result = this.title.hashCode();
        result = result * 31 + this.message.hashCode();
        result = result * 31 + this.type.hashCode();
        result = result * 31 + Long.hashCode(this.displayTime);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Notification)) {
            return false;
        }
        Notification notification = (Notification)other;
        if (!Intrinsics.areEqual(this.title, notification.title)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.message, notification.message)) {
            return false;
        }
        if (this.type != notification.type) {
            return false;
        }
        return this.displayTime == notification.displayTime;
    }
}

