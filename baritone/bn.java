/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aom
 *  et
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.utils.BetterBlockPos;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class bn
extends Command {
    public bn(IBaritone iBaritone) {
        super(iBaritone, "surface", "top");
    }

    @Override
    public final void execute(String object, IArgConsumer iArgConsumer) {
        object = this.ctx.playerFeet();
        int n2 = this.ctx.world().M();
        int n3 = this.ctx.world().ab();
        if (object.q() > n2 && this.ctx.world().o((et)((BetterBlockPos)((Object)object)).up()).u() instanceof aom) {
            this.logDirect("Already at surface");
            return;
        }
        for (n2 = Math.max(object.q(), n2); n2 < n3; ++n2) {
            BetterBlockPos betterBlockPos = new BetterBlockPos(object.p(), n2, object.r());
            if (this.ctx.world().o((et)betterBlockPos).u() instanceof aom || betterBlockPos.q() <= object.q()) continue;
            object = new GoalBlock(betterBlockPos.up());
            this.logDirect(String.format("Going to: %s", object.toString()));
            this.baritone.getCustomGoalProcess().setGoalAndPath((Goal)object);
            return;
        }
        this.logDirect("No higher location found");
    }

    @Override
    public final Stream<String> tabComplete(String string, IArgConsumer iArgConsumer) {
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Used to get out of caves, mines, ...";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The surface/top command tells Baritone to head towards the closest surface-like area.", "", "This can be the surface or the highest available air space, depending on circumstances.", "", "Usage:", "> surface - Used to get out of caves, mines, ...", "> top - Used to get out of caves, mines, ...");
    }
}

