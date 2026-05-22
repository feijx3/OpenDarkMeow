/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class ag
extends Command {
    private final String a;
    private String b;

    public ag(IBaritone iBaritone, List<String> list, String string, String string2) {
        super(iBaritone, list.toArray(new String[0]));
        this.a = string;
        this.b = string2;
    }

    public ag(IBaritone iBaritone, String string, String string2, String string3) {
        super(iBaritone, string);
        this.a = string2;
        this.b = string3;
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        this.baritone.getCommandManager().execute(String.format("%s %s", this.b, iArgConsumer.rawRest()));
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return this.baritone.getCommandManager().tabComplete(String.format("%s %s", this.b, iArgConsumer.rawRest()));
    }

    @Override
    public final String getShortDesc() {
        return this.a;
    }

    @Override
    public final List<String> getLongDesc() {
        return Collections.singletonList(String.format("This command is an alias, for: %s ...", this.b));
    }
}

