/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bib
 *  bkb
 *  bkb$a
 *  bkc
 *  bus
 *  hh
 *  nf
 */
package baritone.api.utils.gui;

import baritone.api.BaritoneAPI;

public class BaritoneToast
implements bkb {
    private String title;
    private String subtitle;
    private long firstDrawTime;
    private boolean newDisplay;
    private long totalShowTime;

    public BaritoneToast(hh hh2, hh hh3, long l2) {
        this.title = hh2.d();
        this.subtitle = hh3 == null ? null : hh3.d();
        this.totalShowTime = l2;
    }

    public bkb.a a(bkc bkc2, long l2) {
        if (this.newDisplay) {
            this.firstDrawTime = l2;
            this.newDisplay = false;
        }
        bkc2.b().N().a(new nf("textures/gui/toasts.png"));
        bus.c((float)1.0f, (float)1.0f, (float)1.0f, (float)255.0f);
        bkc2.b(0, 0, 0, 32, 160, 32);
        if (this.subtitle == null) {
            bkc2.b().k.a(this.title, 18, 12, -11534256);
        } else {
            bkc2.b().k.a(this.title, 18, 7, -11534256);
            bkc2.b().k.a(this.subtitle, 18, 18, -16777216);
        }
        if (l2 - this.firstDrawTime < this.totalShowTime) {
            return bkb.a.a;
        }
        return bkb.a.b;
    }

    public void setDisplayedText(hh hh2, hh hh3) {
        this.title = hh2.d();
        this.subtitle = hh3 == null ? null : hh3.d();
        this.newDisplay = true;
    }

    public static void addOrUpdate(bkc bkc2, hh hh2, hh hh3, long l2) {
        BaritoneToast baritoneToast = (BaritoneToast)bkc2.a(BaritoneToast.class, new Object());
        if (baritoneToast == null) {
            bkc2.a((bkb)new BaritoneToast(hh2, hh3, l2));
            return;
        }
        baritoneToast.setDisplayedText(hh2, hh3);
    }

    public static void addOrUpdate(hh hh2, hh hh3) {
        BaritoneToast.addOrUpdate(bib.z().ao(), hh2, hh3, (Long)BaritoneAPI.getSettings().toastTimer.value);
    }
}

