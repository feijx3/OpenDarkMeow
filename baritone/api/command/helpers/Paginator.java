/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  hg
 *  hg$a
 *  hh
 *  hj
 *  hj$a
 *  ho
 */
package baritone.api.command.helpers;

import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.exception.CommandInvalidTypeException;
import baritone.api.utils.Helper;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Paginator<E>
implements Helper {
    public final List<E> entries;
    public int pageSize = 8;
    public int page = 1;

    public Paginator(List<E> list) {
        this.entries = list;
    }

    public Paginator(E ... EArray) {
        this.entries = Arrays.asList(EArray);
    }

    public Paginator<E> setPageSize(int n2) {
        this.pageSize = n2;
        return this;
    }

    public int getMaxPage() {
        return (this.entries.size() - 1) / this.pageSize + 1;
    }

    public boolean validPage(int n2) {
        return n2 > 0 && n2 <= this.getMaxPage();
    }

    public Paginator<E> skipPages(int n2) {
        this.page += n2;
        return this;
    }

    /*
     * Unable to fully structure code
     */
    public void display(Function<E, hh> var1_1, String var2_4) {
        for (var4_7 = var3_5 = (this.page - 1) * this.pageSize; var4_7 < var3_5 + this.pageSize; ++var4_7) {
            if (var4_7 < this.entries.size()) {
                this.logDirect(new hh[]{var1_1.apply(this.entries.get(var4_7))});
                continue;
            }
            this.logDirect("--", a.i);
        }
        if (var2_4 == null) ** GOTO lbl-1000
        v0 = this;
        if (v0.validPage(v0.page - 1)) {
            v1 = 1;
        } else lbl-1000:
        // 2 sources

        {
            v1 = var4_7 = 0;
        }
        if (var2_4 == null) ** GOTO lbl-1000
        v2 = this;
        if (v2.validPage(v2.page + 1)) {
            v3 = true;
        } else lbl-1000:
        // 2 sources

        {
            v3 = false;
        }
        var1_2 = v3;
        var3_6 = new ho("<<");
        if (var4_7 != 0) {
            var3_6.b().a(new hg(hg.a.c, String.format("%s %d", new Object[]{var2_4, this.page - 1}))).a(new hj(hj.a.a, (hh)new ho("Click to view previous page")));
        } else {
            var3_6.b().a(a.i);
        }
        var4_8 = new ho(">>");
        if (var1_2) {
            var4_8.b().a(new hg(hg.a.c, String.format("%s %d", new Object[]{var2_4, this.page + 1}))).a(new hj(hj.a.a, (hh)new ho("Click to view next page")));
        } else {
            var4_8.b().a(a.i);
        }
        var1_3 = new ho("");
        var1_3.b().a(a.h);
        var1_3.a((hh)var3_6);
        var1_3.a(" | ");
        var1_3.a((hh)var4_8);
        var1_3.a(String.format(" %d/%d", new Object[]{this.page, this.getMaxPage()}));
        this.logDirect(new hh[]{var1_3});
    }

    public void display(Function<E, hh> function) {
        this.display(function, null);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, Paginator<T> paginator, Runnable runnable, Function<T, hh> function, String string) {
        int n2 = 1;
        iArgConsumer.requireMax(1);
        if (iArgConsumer.hasAny() && !paginator.validPage(n2 = iArgConsumer.getAs(Integer.class).intValue())) {
            throw new CommandInvalidTypeException(iArgConsumer.consumed(), String.format("a valid page (1-%d)", paginator.getMaxPage()), iArgConsumer.consumed().getValue());
        }
        paginator.skipPages(n2 - paginator.page);
        if (runnable != null) {
            runnable.run();
        }
        paginator.display(function, string);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, List<T> list, Runnable runnable, Function<T, hh> function, String string) {
        Paginator.paginate(iArgConsumer, new Paginator<T>(list), runnable, function, string);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, T[] TArray, Runnable runnable, Function<T, hh> function, String string) {
        Paginator.paginate(iArgConsumer, Arrays.asList(TArray), runnable, function, string);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, Paginator<T> paginator, Function<T, hh> function, String string) {
        Paginator.paginate(iArgConsumer, paginator, null, function, string);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, List<T> list, Function<T, hh> function, String string) {
        Paginator.paginate(iArgConsumer, new Paginator<T>(list), null, function, string);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, T[] TArray, Function<T, hh> function, String string) {
        Paginator.paginate(iArgConsumer, Arrays.asList(TArray), null, function, string);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, Paginator<T> paginator, Runnable runnable, Function<T, hh> function) {
        Paginator.paginate(iArgConsumer, paginator, runnable, function, null);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, List<T> list, Runnable runnable, Function<T, hh> function) {
        Paginator.paginate(iArgConsumer, new Paginator<T>(list), runnable, function, null);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, T[] TArray, Runnable runnable, Function<T, hh> function) {
        Paginator.paginate(iArgConsumer, Arrays.asList(TArray), runnable, function, null);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, Paginator<T> paginator, Function<T, hh> function) {
        Paginator.paginate(iArgConsumer, paginator, null, function, null);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, List<T> list, Function<T, hh> function) {
        Paginator.paginate(iArgConsumer, new Paginator<T>(list), null, function, null);
    }

    public static <T> void paginate(IArgConsumer iArgConsumer, T[] TArray, Function<T, hh> function) {
        Paginator.paginate(iArgConsumer, Arrays.asList(TArray), null, function, null);
    }
}

