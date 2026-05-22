/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bhb
 *  et
 */
package baritone;

import baritone.a;
import baritone.api.Settings;
import baritone.api.event.events.RenderEvent;
import baritone.api.event.listener.AbstractGameEventListener;
import baritone.api.selection.ISelection;
import baritone.es;
import baritone.fa;
import java.awt.Color;

public final class et
implements AbstractGameEventListener,
fa {
    private final es a;

    et(a a2, es es2) {
        this.a = es2;
        a2.getGameEventHandler().registerEventListener(this);
    }

    @Override
    public final void onRenderPass(RenderEvent iSelectionArray) {
        int n2;
        iSelectionArray = this.a.getSelections();
        float f2 = ((Float)((Settings)((Object)et.a)).selectionOpacity.value).floatValue();
        boolean bl2 = (Boolean)((Settings)((Object)et.a)).renderSelectionIgnoreDepth.value;
        float f3 = ((Float)((Settings)((Object)et.a)).selectionLineWidth.value).floatValue();
        if (!((Boolean)((Settings)((Object)et.a)).renderSelection.value).booleanValue() || iSelectionArray.length == 0) {
            return;
        }
        fa.a((Color)((Settings)((Object)et.a)).colorSelection.value, f2, f3, bl2);
        ISelection[] iSelectionArray2 = iSelectionArray;
        int n3 = iSelectionArray.length;
        for (n2 = 0; n2 < n3; ++n2) {
            fa.a(iSelectionArray2[n2].aabb(), 0.005);
        }
        if (((Boolean)((Settings)((Object)et.a)).renderSelectionCorners.value).booleanValue()) {
            ISelection iSelection;
            fa.a((Color)((Settings)((Object)et.a)).colorSelectionPos1.value, f2);
            iSelectionArray2 = iSelectionArray;
            n3 = iSelectionArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                iSelection = iSelectionArray2[n2];
                fa.a(new bhb((et)iSelection.pos1(), iSelection.pos1().a(1, 1, 1)));
            }
            fa.a((Color)((Settings)((Object)et.a)).colorSelectionPos2.value, f2);
            iSelectionArray2 = iSelectionArray;
            n3 = iSelectionArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                iSelection = iSelectionArray2[n2];
                fa.a(new bhb((et)iSelection.pos2(), iSelection.pos2().a(1, 1, 1)));
            }
        }
        fa.a(bl2);
    }
}

