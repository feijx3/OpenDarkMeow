/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.message.notification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lnet/ccbluex/liquidbounce/handler/message/notification/NotificationType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "INFO", "SUCCESS", "WARNING", "ERROR", "DarkMeow"})
public final class NotificationType
extends Enum<NotificationType> {
    private final int id;
    public static final /* enum */ NotificationType INFO = new NotificationType(0);
    public static final /* enum */ NotificationType SUCCESS = new NotificationType(1);
    public static final /* enum */ NotificationType WARNING = new NotificationType(2);
    public static final /* enum */ NotificationType ERROR = new NotificationType(3);
    private static final /* synthetic */ NotificationType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private NotificationType(int id) {
        this.id = id;
    }

    public final int getId() {
        return this.id;
    }

    public static NotificationType[] values() {
        return (NotificationType[])$VALUES.clone();
    }

    public static NotificationType valueOf(String value) {
        return Enum.valueOf(NotificationType.class, value);
    }

    @NotNull
    public static EnumEntries<NotificationType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = notificationTypeArray = new NotificationType[]{NotificationType.INFO, NotificationType.SUCCESS, NotificationType.WARNING, NotificationType.ERROR};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

