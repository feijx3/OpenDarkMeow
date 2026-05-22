/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  et
 *  fa
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalStrictDirection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class bp
extends Command {
    public bp(IBaritone iBaritone) {
        super(iBaritone, "tunnel");
    }

    @Override
    public final void execute(String object, IArgConsumer iArgConsumer) {
        iArgConsumer.requireMax(3);
        if (iArgConsumer.hasExactly(3)) {
            boolean bl2 = true;
            int n2 = Integer.parseInt(iArgConsumer.getArgs().get(0).getValue());
            int n3 = Integer.parseInt(iArgConsumer.getArgs().get(1).getValue());
            int n4 = Integer.parseInt(iArgConsumer.getArgs().get(2).getValue());
            if (n3 <= 0 || n2 < 2 || n4 <= 0 || n2 > 255) {
                this.logDirect("Width and depth must at least be 1 block; Height must at least be 2 blocks, and cannot be greater than the build limit.");
                bl2 = false;
            }
            if (bl2) {
                et et2;
                --n2;
                fa fa2 = this.ctx.player().bt();
                int n5 = --n3 % 2 == 0 ? 0 : 1;
                switch (fa2) {
                    case f: {
                        fa2 = new et(this.ctx.playerFeet().a, this.ctx.playerFeet().b, this.ctx.playerFeet().c - n3 / 2);
                        et2 = new et(this.ctx.playerFeet().a + n4, this.ctx.playerFeet().b + n2, this.ctx.playerFeet().c + n3 / 2 + n5);
                        break;
                    }
                    case e: {
                        fa2 = new et(this.ctx.playerFeet().a, this.ctx.playerFeet().b, this.ctx.playerFeet().c + n3 / 2 + n5);
                        et2 = new et(this.ctx.playerFeet().a - n4, this.ctx.playerFeet().b + n2, this.ctx.playerFeet().c - n3 / 2);
                        break;
                    }
                    case c: {
                        fa2 = new et(this.ctx.playerFeet().a - n3 / 2, this.ctx.playerFeet().b, this.ctx.playerFeet().c);
                        et2 = new et(this.ctx.playerFeet().a + n3 / 2 + n5, this.ctx.playerFeet().b + n2, this.ctx.playerFeet().c - n4);
                        break;
                    }
                    case d: {
                        fa2 = new et(this.ctx.playerFeet().a + n3 / 2 + n5, this.ctx.playerFeet().b, this.ctx.playerFeet().c);
                        et2 = new et(this.ctx.playerFeet().a - n3 / 2, this.ctx.playerFeet().b + n2, this.ctx.playerFeet().c + n4);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("Unexpected value: ".concat(String.valueOf(fa2)));
                    }
                }
                this.logDirect(String.format("Creating a tunnel %s block(s) high, %s block(s) wide, and %s block(s) deep", n2 + 1, n3 + 1, n4));
                this.baritone.getBuilderProcess().clearArea((et)fa2, et2);
            }
            return;
        }
        object = new GoalStrictDirection(this.ctx.playerFeet(), this.ctx.player().bt());
        this.baritone.getCustomGoalProcess().setGoalAndPath((Goal)object);
        this.logDirect(String.format("Goal: %s", object.toString()));
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Set a goal to tunnel in your current direction";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The tunnel command sets a goal that tells Baritone to mine completely straight in the direction that you're facing.", "", "Usage:", "> tunnel - No arguments, mines in a 1x2 radius.", "> tunnel <height> <width> <depth> - Tunnels in a user defined height, width and depth.");
    }
}

