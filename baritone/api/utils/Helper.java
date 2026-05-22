/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  bib
 *  hh
 *  ho
 */
package baritone.api.utils;

import baritone.api.BaritoneAPI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface Helper {
    public static final Helper HELPER = new Helper(){};
    @Deprecated
    public static final bib mc = bib.z();

    public static hh getPrefix() {
        boolean bl2;
        Calendar calendar = Calendar.getInstance();
        boolean bl3 = bl2 = calendar.get(2) == 3 && calendar.get(5) <= 3;
        ho ho2 = new ho(bl2 ? "Baritoe" : ((Boolean)BaritoneAPI.getSettings().shortBaritonePrefix.value != false ? "B" : "Baritone"));
        ho2.b().a(a.n);
        ho ho3 = new ho("");
        ho3.b().a(a.f);
        ho3.a("[");
        ho3.a((hh)ho2);
        ho3.a("]");
        return ho3;
    }

    default public void logToast(hh hh2, hh hh3) {
        bib.z().a(() -> ((BiConsumer)BaritoneAPI.getSettings().toaster.value).accept(hh2, hh3));
    }

    default public void logToast(String string, String string2) {
        this.logToast((hh)new ho(string), (hh)new ho(string2));
    }

    default public void logToast(String string) {
        this.logToast(Helper.getPrefix(), (hh)new ho(string));
    }

    default public void logNotification(String string) {
        this.logNotification(string, false);
    }

    default public void logNotification(String string, boolean bl2) {
        if (((Boolean)BaritoneAPI.getSettings().desktopNotifications.value).booleanValue()) {
            this.logNotificationDirect(string, bl2);
        }
    }

    default public void logNotificationDirect(String string) {
        this.logNotificationDirect(string, false);
    }

    default public void logNotificationDirect(String string, boolean bl2) {
        bib.z().a(() -> ((BiConsumer)BaritoneAPI.getSettings().notifier.value).accept(string, bl2));
    }

    default public void logDebug(String string) {
        if (!((Boolean)BaritoneAPI.getSettings().chatDebug.value).booleanValue()) {
            return;
        }
        this.logDirect(string, false);
    }

    default public void logDirect(boolean bl2, hh ... hhArray) {
        ho ho2 = new ho("");
        if (!bl2) {
            ho2.a(Helper.getPrefix());
            ho2.a((hh)new ho(" "));
        }
        Arrays.asList(hhArray).forEach(arg_0 -> ((hh)ho2).a(arg_0));
        if (bl2) {
            this.logToast(Helper.getPrefix(), (hh)ho2);
            return;
        }
        bib.z().a(() -> Helper.lambda$logDirect$2((hh)ho2));
    }

    default public void logDirect(hh ... hhArray) {
        this.logDirect((Boolean)BaritoneAPI.getSettings().logAsToast.value, hhArray);
    }

    default public void logDirect(String string2, a a2, boolean bl2) {
        Stream.of(string2.split("\n")).forEach(string -> {
            string = new ho(string.replace("\t", "    "));
            string.b().a(a2);
            this.logDirect(bl2, new hh[]{string});
        });
    }

    default public void logDirect(String string, a a2) {
        this.logDirect(string, a2, (Boolean)BaritoneAPI.getSettings().logAsToast.value);
    }

    default public void logDirect(String string, boolean bl2) {
        this.logDirect(string, a.h, bl2);
    }

    default public void logDirect(String string) {
        this.logDirect(string, (Boolean)BaritoneAPI.getSettings().logAsToast.value);
    }

    default public void logUnhandledException(Throwable throwable) {
        HELPER.logDirect("An unhandled exception occurred. The error is in your game's log, please report this at https://github.com/cabaletta/baritone/issues", a.m);
        throwable.printStackTrace();
    }

    private static /* synthetic */ void lambda$logDirect$2(hh hh2) {
        ((Consumer)BaritoneAPI.getSettings().logger.value).accept(hh2);
    }
}

