/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  rk
 */
package baritone.api.command.datatypes;

import baritone.api.command.datatypes.IDatatypeContext;
import baritone.api.command.datatypes.IDatatypePost;
import baritone.api.command.datatypes.RelativeCoordinate;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.utils.BetterBlockPos;
import java.util.stream.Stream;

public enum RelativeGoalBlock implements IDatatypePost<GoalBlock, BetterBlockPos>
{
    INSTANCE;


    @Override
    public final GoalBlock apply(IDatatypeContext object, BetterBlockPos betterBlockPos) {
        if (betterBlockPos == null) {
            betterBlockPos = BetterBlockPos.ORIGIN;
        }
        object = object.getConsumer();
        return new GoalBlock(rk.c((double)((Double)object.getDatatypePost(RelativeCoordinate.INSTANCE, Double.valueOf(betterBlockPos.a)))), rk.c((double)((Double)object.getDatatypePost(RelativeCoordinate.INSTANCE, Double.valueOf(betterBlockPos.b)))), rk.c((double)((Double)object.getDatatypePost(RelativeCoordinate.INSTANCE, Double.valueOf(betterBlockPos.c)))));
    }

    @Override
    public final Stream<String> tabComplete(IDatatypeContext object) {
        if ((object = object.getConsumer()).hasAtMost(3)) {
            return object.tabCompleteDatatype(RelativeCoordinate.INSTANCE);
        }
        return Stream.empty();
    }
}

