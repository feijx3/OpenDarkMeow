/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@SideOnly(value=Side.CLIENT)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/utils/ClientUtils;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "<init>", "()V", "logger", "Lorg/apache/logging/log4j/Logger;", "logInfo", "", "msg", "", "logWarn", "t", "", "logError", "logDebug", "displayChatMessage", "message", "DarkMeow"})
public final class ClientUtils
extends MinecraftInstance {
    @NotNull
    public static final ClientUtils INSTANCE = new ClientUtils();
    @JvmField
    @NotNull
    public static final Logger logger;

    private ClientUtils() {
    }

    public final void logInfo(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        logger.info(msg);
    }

    public final void logWarn(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        logger.warn(msg);
    }

    public final void logWarn(@NotNull String msg, @NotNull Throwable t2) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(t2, "t");
        logger.warn(msg, t2);
    }

    public final void logError(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        logger.error(msg);
    }

    public final void logError(@NotNull String msg, @NotNull Throwable t2) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(t2, "t");
        logger.error(msg, t2);
    }

    public final void logDebug(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        logger.debug(msg);
    }

    @Deprecated(message="DarkMeow.messageManager.displayChatMessage(message)", replaceWith=@ReplaceWith(expression="DarkMeow.messageManager.displayChatMessage(message)", imports={"net.ccbluex.liquidbounce.DarkMeow"}))
    @JvmStatic
    public static final void displayChatMessage(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        DarkMeow.INSTANCE.getMessageManager().displayChatMessage(message);
    }

    static {
        Logger logger = LogManager.getLogger((String)"DarkMeow");
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        ClientUtils.logger = logger;
    }
}

