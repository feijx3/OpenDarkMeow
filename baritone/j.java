/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  aou
 *  aou$a
 *  awt
 *  axj
 *  et
 *  fa
 *  hg
 *  hg$a
 *  hh
 *  hj
 *  hj$a
 *  ho
 */
package baritone;

import baritone.api.cache.IWaypoint;
import baritone.api.cache.Waypoint;
import baritone.api.command.IBaritoneChatControl;
import baritone.api.event.events.BlockInteractEvent;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.c;
import baritone.ex;

public final class j
extends c {
    public j(baritone.a a2) {
        super(a2);
    }

    @Override
    public final void onBlockInteract(BlockInteractEvent object) {
        awt awt2;
        if (!((Boolean)baritone.a.a().doBedWaypoints.value).booleanValue()) {
            return;
        }
        if (object.getType() == BlockInteractEvent.Type.USE && (awt2 = ex.a(this.a, (et)(object = BetterBlockPos.from(object.getPos())))).u() instanceof aou) {
            if (awt2.c((axj)aou.a) == aou.a.b) {
                object = ((BetterBlockPos)((Object)object)).offset((fa)awt2.c((axj)aou.D));
            }
            if (!this.a.a.a().getWaypoints().getByTag(IWaypoint.Tag.BED).stream().map(IWaypoint::getLocation).filter(((BetterBlockPos)((Object)object))::equals).findFirst().isPresent()) {
                this.a.a.a().getWaypoints().addWaypoint(new Waypoint("bed", IWaypoint.Tag.BED, (BetterBlockPos)((Object)object)));
            }
        }
    }

    @Override
    public final void onPlayerDeath() {
        if (!((Boolean)baritone.a.a().doDeathWaypoints.value).booleanValue()) {
            return;
        }
        Waypoint waypoint = new Waypoint("death", IWaypoint.Tag.DEATH, this.a.playerFeet());
        this.a.a.a().getWaypoints().addWaypoint(waypoint);
        ho ho2 = new ho("Death position saved.");
        ho2.b().a(a.p).a(new hj(hj.a.a, (hh)new ho("Click to goto death"))).a(new hg(hg.a.c, String.format("%s%s goto %s @ %d", IBaritoneChatControl.FORCE_COMMAND_PREFIX, "wp", waypoint.getTag().getName(), waypoint.getCreationTimestamp())));
        Helper.HELPER.logDirect(new hh[]{ho2});
    }
}

