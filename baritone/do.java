/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aox
 *  awt
 *  axt
 *  bud
 *  et
 *  fa
 */
package baritone;

import baritone.a;
import baritone.api.process.PathingCommand;
import baritone.api.process.PathingCommandType;
import baritone.api.utils.input.Input;
import baritone.ca;
import baritone.cb;
import baritone.cc;
import baritone.dk;
import baritone.dp;
import baritone.eu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class do
extends eu {
    private HashMap<et, awt> a = new HashMap();

    public do(a a2) {
        super(a2);
    }

    @Override
    public final boolean isActive() {
        if (this.a.player() == null || this.a.world() == null) {
            return false;
        }
        if (!((Boolean)baritone.a.a().backfill.value).booleanValue()) {
            return false;
        }
        if (((Boolean)baritone.a.a().allowParkour.value).booleanValue()) {
            this.logDirect("Backfill cannot be used with allowParkour true");
            baritone.a.a().backfill.value = Boolean.FALSE;
            return false;
        }
        for (et et2 : new ArrayList<et>(this.a.keySet())) {
            if (!(this.a.world().f(et2) instanceof axt) && this.a.world().o(et2).u() == aox.a) continue;
            this.a.remove(et2);
        }
        do do_ = this;
        if (do_.a.getSelectedBlock().isPresent() && ((a)((Object)do_.a)).a.isPathing()) {
            do_.a.put(do_.a.getSelectedBlock().get(), do_.a.world().o(do_.a.getSelectedBlock().get()));
        }
        ((a)((Object)this.a)).a.clearAllKeys();
        return !this.a().isEmpty();
    }

    @Override
    public final PathingCommand onTick(boolean bl2, boolean bl3) {
        if (!bl3) {
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
        }
        ((a)((Object)this.a)).a.clearAllKeys();
        block5: for (et et2 : this.a()) {
            cc cc2 = new cc();
            switch (dp.a[cb.a(cc2, this.a, et2, false, false) - 1]) {
                case 1: {
                    continue block5;
                }
                case 2: {
                    ((a)((Object)this.a)).a.setInputForceState(Input.CLICK_RIGHT, true);
                    return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
                }
                case 3: {
                    ((a)((Object)this.a)).a.updateTarget(Optional.ofNullable(cc2.a.a).get(), true);
                    return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
                }
            }
            throw new IllegalStateException();
        }
        return new PathingCommand(null, PathingCommandType.DEFER);
    }

    private List<et> a() {
        return this.a.keySet().stream().filter(et2 -> this.a.world().o(et2).u() == aox.a).filter(et2 -> this.a.world().a(aox.d, et2, false, fa.b, null)).filter(object -> {
            et et2 = object;
            object = ((a)((Object)this.a)).a.a;
            return !(object == null || ((dk)object).b() || ((dk)object).a ? false : Arrays.asList(((ca)((dk)object).getPath().movements().get(((dk)object).getPosition())).a()).contains(et2));
        }).sorted(Comparator.comparingDouble(arg_0 -> ((bud)this.a.player()).c(arg_0)).reversed()).collect(Collectors.toList());
    }

    @Override
    public final void onLostControl() {
        if (this.a != null && !this.a.isEmpty()) {
            this.a.clear();
        }
    }

    @Override
    public final String displayName0() {
        return "Backfill";
    }

    @Override
    public final boolean isTemporary() {
        return true;
    }

    @Override
    public final double priority() {
        return 5.0;
    }
}

