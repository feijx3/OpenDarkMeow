/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  bhb
 *  bhc$a
 *  bhe
 *  blk
 *  bus
 *  et
 *  hg
 *  hg$a
 *  hh
 *  ho
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.util.glu.GLU
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.command.IBaritoneChatControl;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.fa;
import baritone.fc;
import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Collections;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.glu.GLU;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ez
extends blk {
    private final FloatBuffer a;
    private final FloatBuffer b;
    private final IntBuffer a;
    private final FloatBuffer c;
    private et a = BufferUtils.createFloatBuffer((int)16);
    private et b = BufferUtils.createFloatBuffer((int)16);

    public ez() {
        this.a = BufferUtils.createIntBuffer((int)16);
        this.c = BufferUtils.createFloatBuffer((int)3);
    }

    public final boolean d() {
        return false;
    }

    public final void a(int n2, int n3, float f2) {
        bhe bhe2;
        n2 = Mouse.getX();
        n3 = Mouse.getY();
        bhe bhe3 = this.a((double)n2, (double)n3, 0.0);
        bhe bhe4 = this.a((double)n2, (double)n3, 1.0);
        if (bhe3 != null && bhe4 != null && (bhe4 = this.j.f.a(bhe3.e(bhe2 = new bhe(this.j.ac().h, this.j.ac().i, this.j.ac().j)), bhe4.e(bhe2), false, false, true)) != null && bhe4.a == bhc.a.b) {
            this.b = bhe4.a();
        }
    }

    protected final void b(int n2, int n3, int n4) {
        if (this.b != null) {
            if (n4 == 0) {
                if (this.a != null && !this.a.equals((Object)this.b)) {
                    BaritoneAPI.getProvider().getPrimaryBaritone().getSelectionManager().removeAllSelections();
                    BaritoneAPI.getProvider().getPrimaryBaritone().getSelectionManager().addSelection(BetterBlockPos.from(this.a), BetterBlockPos.from(this.b));
                    ho ho2 = new ho("Selection made! For usage: " + (String)baritone.a.a().prefix.value + "help sel");
                    ho2.b().a(a.p).a(new hg(hg.a.c, IBaritoneChatControl.FORCE_COMMAND_PREFIX + "help sel"));
                    Helper.HELPER.logDirect(new hh[]{ho2});
                    this.a = null;
                } else {
                    BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.b));
                }
            } else if (n4 == 1) {
                BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalBlock(this.b.a()));
            }
        }
        this.a = null;
    }

    protected final void a(int n2, int n3, int n4) {
        this.a = this.b;
    }

    public final void a() {
        bus.c((int)2982, (FloatBuffer)((FloatBuffer)this.a.clear()));
        bus.c((int)2983, (FloatBuffer)((FloatBuffer)this.b.clear()));
        bus.a((int)2978, (IntBuffer)((IntBuffer)this.a.clear()));
        if (this.b != null) {
            fc.a(this.j.aa(), Collections.singletonList(this.b), Color.CYAN);
            if (this.a != null && !this.a.equals((Object)this.b)) {
                fa.a(Color.RED, ((Float)baritone.a.a().pathRenderLineWidthPixels.value).floatValue(), true);
                BetterBlockPos betterBlockPos = new BetterBlockPos(this.b);
                BetterBlockPos betterBlockPos2 = new BetterBlockPos(this.a);
                fa.a(new bhb((double)Math.min(betterBlockPos.a, betterBlockPos2.a), (double)Math.min(betterBlockPos.b, betterBlockPos2.b), (double)Math.min(betterBlockPos.c, betterBlockPos2.c), (double)(Math.max(betterBlockPos.a, betterBlockPos2.a) + 1), (double)(Math.max(betterBlockPos.b, betterBlockPos2.b) + 1), (double)(Math.max(betterBlockPos.c, betterBlockPos2.c) + 1)));
                fa.a(true);
            }
        }
    }

    private bhe a(double d2, double d3, double d4) {
        if (GLU.gluUnProject((float)((float)d2), (float)((float)d3), (float)((float)d4), (FloatBuffer)this.a, (FloatBuffer)this.b, (IntBuffer)this.a, (FloatBuffer)((FloatBuffer)this.c.clear()))) {
            return new bhe((double)this.c.get(0), (double)this.c.get(1), (double)this.c.get(2));
        }
        return null;
    }
}

