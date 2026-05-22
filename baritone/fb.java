/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhc
 *  bhc$a
 *  buc
 *  ub
 *  ud
 */
package baritone;

import baritone.a;
import baritone.api.BaritoneAPI;
import baritone.api.event.events.TickEvent;
import baritone.api.utils.IInputOverrideHandler;
import baritone.api.utils.input.Input;
import baritone.c;
import baritone.ev;
import baritone.ew;
import baritone.fh;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class fb
extends c
implements IInputOverrideHandler {
    private final Map<Input, Boolean> a;
    public final ev a;
    private final ew a = new HashMap<Input, Boolean>();

    public fb(a a2) {
        super(a2);
        this.a = new ev(a2.getPlayerContext());
        this.a = new ew(a2.getPlayerContext());
    }

    @Override
    public final boolean isInputForcedDown(Input input) {
        if (input == null) {
            return false;
        }
        return this.a.getOrDefault((Object)input, Boolean.FALSE);
    }

    @Override
    public final void setInputForceState(Input input, boolean bl2) {
        this.a.put(input, bl2);
    }

    @Override
    public final void clearAllKeys() {
        this.a.clear();
    }

    @Override
    public final void onTick(TickEvent object) {
        boolean bl2;
        block17: {
            int n2;
            if (((TickEvent)object).getType() == TickEvent.Type.OUT) {
                return;
            }
            if (this.isInputForcedDown(Input.CLICK_LEFT)) {
                this.setInputForceState(Input.CLICK_RIGHT, false);
            }
            int n3 = this.isInputForcedDown(Input.CLICK_LEFT);
            object = this.a;
            bhc bhc2 = ((ev)object).a.objectMouseOver();
            int n4 = n2 = bhc2 != null && bhc2.a == bhc.a.b ? 1 : 0;
            if (n3 != 0 && n2 != 0) {
                if (!((ev)object).a) {
                    ((ev)object).a.playerController().syncHeldItem();
                    ((ev)object).a.playerController().clickBlock(bhc2.a(), bhc2.b);
                    ((ev)object).a.player().a(ub.a);
                }
                if (((ev)object).a.playerController().onPlayerDamageBlock(bhc2.a(), bhc2.b)) {
                    ((ev)object).a.player().a(ub.a);
                }
                ((ev)object).a.playerController().setHittingBlock(false);
                ((ev)object).a = true;
            } else if (((ev)object).a) {
                ((ev)object).a();
                ((ev)object).a = false;
            }
            n3 = this.isInputForcedDown(Input.CLICK_RIGHT);
            object = this.a;
            if (((ew)object).a > 0) {
                --((ew)object).a;
            } else {
                bhc2 = ((ew)object).a.objectMouseOver();
                if (n3 != 0 && !((ew)object).a.player().L() && bhc2 != null && bhc2.a() != null && bhc2.a == bhc.a.b) {
                    ((ew)object).a = (Integer)baritone.a.a().rightClickSpeed.value;
                    for (ub ub2 : ub.values()) {
                        if (((ew)object).a.playerController().processRightClickBlock(((ew)object).a.player(), ((ew)object).a.world(), bhc2.a(), bhc2.b, bhc2.c, ub2) == ud.a) {
                            ((ew)object).a.player().a(ub2);
                            break;
                        }
                        if (!((ew)object).a.player().b(ub2).b() && ((ew)object).a.playerController().processRightClick(((ew)object).a.player(), ((ew)object).a.world(), ub2) == ud.a) break;
                    }
                }
            }
            object = this;
            Input[] inputArray = new Input[]{Input.MOVE_FORWARD, Input.MOVE_BACK, Input.MOVE_LEFT, Input.MOVE_RIGHT, Input.SNEAK, Input.JUMP};
            for (n2 = 0; n2 < 6; ++n2) {
                Input input = inputArray[n2];
                if (!((fb)object).isInputForcedDown(input)) continue;
                bl2 = true;
                break block17;
            }
            bl2 = ((a)((Object)((fb)object).a)).a.isPathing() || ((fb)object).a != BaritoneAPI.getProvider().getPrimaryBaritone();
        }
        if (bl2) {
            if (this.a.player().e.getClass() != fh.class) {
                this.a.player().e = new fh(this);
                return;
            }
        } else if (this.a.player().e.getClass() == fh.class) {
            this.a.player().e = new buc(this.a.minecraft().t);
        }
    }
}

