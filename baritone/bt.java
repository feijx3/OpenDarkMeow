/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  rr
 */
package baritone;

import baritone.aa;
import baritone.ab;
import baritone.ac;
import baritone.ad;
import baritone.ae;
import baritone.af;
import baritone.ag;
import baritone.ah;
import baritone.ai;
import baritone.aj;
import baritone.ap;
import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.ICommand;
import baritone.api.command.argument.ICommandArgument;
import baritone.api.command.exception.CommandException;
import baritone.api.command.exception.CommandUnhandledException;
import baritone.api.command.exception.ICommandException;
import baritone.api.command.helpers.TabCompleteHelper;
import baritone.api.command.manager.ICommandManager;
import baritone.api.command.registry.Registry;
import baritone.aq;
import baritone.ar;
import baritone.as;
import baritone.at;
import baritone.au;
import baritone.av;
import baritone.aw;
import baritone.ax;
import baritone.ay;
import baritone.az;
import baritone.ba;
import baritone.bb;
import baritone.bc;
import baritone.bd;
import baritone.be;
import baritone.bf;
import baritone.bg;
import baritone.bh;
import baritone.bi;
import baritone.bm;
import baritone.bn;
import baritone.bo;
import baritone.bp;
import baritone.br;
import baritone.bs;
import baritone.command.defaults.FollowCommand;
import baritone.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bt
implements ICommandManager {
    private final Registry<ICommand> a;
    private final baritone.a a = new Registry();

    public bt(baritone.a object) {
        this.a = object;
        Objects.requireNonNull(object);
        ArrayList<Command> arrayList = new ArrayList<Command>(Arrays.asList(new ax((IBaritone)object), new bm((IBaritone)object), new ag((IBaritone)object, Arrays.asList("modified", "mod", "baritone", "modifiedsettings"), "List modified settings", "set modified"), new ag((IBaritone)object, "reset", "Reset all settings or just one", "set reset"), new av((IBaritone)object), new aw((IBaritone)object), new bb((IBaritone)object), new bc((IBaritone)object), new ah((IBaritone)object), new br((IBaritone)object), new bf((IBaritone)object), new ad((IBaritone)object), new bh((IBaritone)object), new az((IBaritone)object), new af((IBaritone)object), new ab((IBaritone)object), new at((IBaritone)object), new au((IBaritone)object), new ay((IBaritone)object), new bp((IBaritone)object), new be((IBaritone)object), new ar((IBaritone)object), new FollowCommand((IBaritone)object), new aq((IBaritone)object), new bd((IBaritone)object), new bg((IBaritone)object), new ap((IBaritone)object), new ac((IBaritone)object), new as((IBaritone)object), new ba((IBaritone)object), new ae((IBaritone)object), new bn((IBaritone)object), new bo((IBaritone)object), new bs((IBaritone)object), new ag((IBaritone)object, "sethome", "Sets your home waypoint", "waypoints save home"), new ag((IBaritone)object, "home", "Path to your home waypoint", "waypoints goto home"), new bi((IBaritone)object), new ai((IBaritone)object)));
        object = new aj((IBaritone)object);
        arrayList.add(((aj)object).a);
        arrayList.add(((aj)object).b);
        arrayList.add(((aj)object).c);
        arrayList.add(((aj)object).d);
        Collections.unmodifiableList(arrayList).forEach(this.a::register);
    }

    @Override
    public final IBaritone getBaritone() {
        return this.a;
    }

    @Override
    public final Registry<ICommand> getRegistry() {
        return this.a;
    }

    @Override
    public final ICommand getCommand(String string) {
        for (ICommand iCommand : this.a.entries) {
            if (!iCommand.getNames().contains(string.toLowerCase(Locale.US))) continue;
            return iCommand;
        }
        return null;
    }

    @Override
    public final boolean execute(String string) {
        return this.execute(bt.a(string, false));
    }

    @Override
    public final boolean execute(rr<String, List<ICommandArgument>> object) {
        if ((object = this.a((rr<String, List<ICommandArgument>>)object)) != null) {
            Object object2 = object;
            try {
                object2.a.execute(object2.a, object2.a);
            }
            catch (Throwable throwable) {
                Throwable throwable2 = throwable;
                (throwable instanceof ICommandException ? (ICommandException)((Object)throwable2) : new CommandUnhandledException(throwable2)).handle(object2.a, object2.a.getArgs());
            }
        }
        return object != null;
    }

    @Override
    public final Stream<String> tabComplete(rr<String, List<ICommandArgument>> object) {
        if ((object = this.a((rr<String, List<ICommandArgument>>)object)) == null) {
            return Stream.empty();
        }
        return ((a)object).a();
    }

    @Override
    public final Stream<String> tabComplete(String rr2) {
        rr2 = bt.a((String)rr2, true);
        String string = (String)rr2.a();
        if (((List)rr2.b()).isEmpty()) {
            return new TabCompleteHelper().addCommands(this.a.a).filterPrefix(string).stream();
        }
        return this.tabComplete(rr2);
    }

    private a a(rr<String, List<ICommandArgument>> object) {
        String string = (String)object.a();
        object = new y(this, (List)object.b());
        ICommand iCommand = this.getCommand(string);
        if (iCommand == null) {
            return null;
        }
        return new a(iCommand, string, (y)object, 0);
    }

    private static rr<String, List<ICommandArgument>> a(String object, boolean bl2) {
        String string = ((String)object).split("\\s", 2)[0];
        object = aa.a(((String)object).substring(string.length()), bl2);
        return new rr((Object)string, object);
    }

    public static rr<String, List<ICommandArgument>> a(String string) {
        return bt.a(string, false);
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static final class a {
        ICommand a;
        String a;
        y a;

        private a(ICommand iCommand, String string, y y2) {
            this.a = iCommand;
            this.a = string;
            this.a = y2;
        }

        final Stream<String> a() {
            try {
                return this.a.tabComplete(this.a, this.a);
            }
            catch (CommandException commandException) {
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return Stream.empty();
        }

        /* synthetic */ a(ICommand iCommand, String string, y y2, byte by2) {
            this(iCommand, string, y2);
        }
    }
}

