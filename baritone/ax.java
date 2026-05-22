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
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.IBaritoneChatControl;
import baritone.api.command.ICommand;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.exception.CommandNotFoundException;
import baritone.api.command.helpers.Paginator;
import baritone.api.command.helpers.TabCompleteHelper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ax
extends Command {
    public ax(IBaritone iBaritone) {
        super(iBaritone, "help", "?");
    }

    @Override
    public final void execute(String string, IArgConsumer object) {
        object.requireMax(1);
        if (!object.hasAny() || object.is(Integer.class)) {
            Paginator.paginate((IArgConsumer)object, new Paginator(this.baritone.getCommandManager().getRegistry().descendingStream().filter(iCommand -> !iCommand.hiddenFromHelp()).collect(Collectors.toList())), () -> this.logDirect("All Baritone commands (clickable):"), iCommand -> {
                String string2 = String.join((CharSequence)"/", iCommand.getNames());
                String string3 = iCommand.getNames().get(0);
                ho ho2 = new ho(" - " + iCommand.getShortDesc());
                ho2.b().a(a.i);
                string2 = new ho(string2);
                string2.b().a(a.p);
                ho ho3 = new ho("");
                ho3.b().a(a.h);
                ho3.a((hh)string2);
                ho3.a("\n" + iCommand.getShortDesc());
                ho3.a("\n\nClick to view full help");
                string = IBaritoneChatControl.FORCE_COMMAND_PREFIX + String.format("%s %s", string, iCommand.getNames().get(0));
                iCommand = new ho(string3);
                iCommand.b().a(a.h);
                iCommand.a((hh)ho2);
                iCommand.b().a(new hj(hj.a.a, (hh)ho3)).a(new hg(hg.a.c, string));
                return iCommand;
            }, IBaritoneChatControl.FORCE_COMMAND_PREFIX + string);
            return;
        }
        object = object.getString().toLowerCase();
        ICommand iCommand2 = this.baritone.getCommandManager().getCommand((String)object);
        if (iCommand2 == null) {
            throw new CommandNotFoundException((String)object);
        }
        this.logDirect(String.format("%s - %s", String.join((CharSequence)" / ", iCommand2.getNames()), iCommand2.getShortDesc()));
        this.logDirect("");
        iCommand2.getLongDesc().forEach(this::logDirect);
        this.logDirect("");
        object = new ho("Click to return to the help menu");
        object.b().a(new hg(hg.a.c, IBaritoneChatControl.FORCE_COMMAND_PREFIX + string));
        this.logDirect(new hh[]{object});
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        if (iArgConsumer.hasExactlyOne()) {
            return new TabCompleteHelper().addCommands(this.baritone.getCommandManager()).filterPrefix(iArgConsumer.getString()).stream();
        }
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "View all commands or help on specific ones";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("Using this command, you can view detailed help information on how to use certain commands of Baritone.", "", "Usage:", "> help - Lists all commands and their short descriptions.", "> help <command> - Displays help information on a specific command.");
    }
}

