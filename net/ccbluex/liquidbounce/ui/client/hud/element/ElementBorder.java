/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element;

import kotlin.Metadata;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u001c"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "", "x", "", "y", "x2", "y2", "<init>", "(FFFF)V", "getX", "()F", "getY", "getX2", "getY2", "draw", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DarkMeow"})
public final class ElementBorder {
    private final float x;
    private final float y;
    private final float x2;
    private final float y2;

    public ElementBorder(float x2, float y2, float x22, float y22) {
        this.x = x2;
        this.y = y2;
        this.x2 = x22;
        this.y2 = y22;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getX2() {
        return this.x2;
    }

    public final float getY2() {
        return this.y2;
    }

    public final void draw() {
        RenderUtils.drawBorderedRect(this.x, this.y, this.x2, this.y2, 3.0f, Integer.MIN_VALUE, 0);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final float component3() {
        return this.x2;
    }

    public final float component4() {
        return this.y2;
    }

    @NotNull
    public final ElementBorder copy(float x2, float y2, float x22, float y22) {
        return new ElementBorder(x2, y2, x22, y22);
    }

    public static /* synthetic */ ElementBorder copy$default(ElementBorder elementBorder, float f2, float f3, float f4, float f5, int n2, Object object) {
        if ((n2 & 1) != 0) {
            f2 = elementBorder.x;
        }
        if ((n2 & 2) != 0) {
            f3 = elementBorder.y;
        }
        if ((n2 & 4) != 0) {
            f4 = elementBorder.x2;
        }
        if ((n2 & 8) != 0) {
            f5 = elementBorder.y2;
        }
        return elementBorder.copy(f2, f3, f4, f5);
    }

    @NotNull
    public String toString() {
        return "ElementBorder(x=" + this.x + ", y=" + this.y + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
    }

    public int hashCode() {
        int result = Float.hashCode(this.x);
        result = result * 31 + Float.hashCode(this.y);
        result = result * 31 + Float.hashCode(this.x2);
        result = result * 31 + Float.hashCode(this.y2);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ElementBorder)) {
            return false;
        }
        ElementBorder elementBorder = (ElementBorder)other;
        if (Float.compare(this.x, elementBorder.x) != 0) {
            return false;
        }
        if (Float.compare(this.y, elementBorder.y) != 0) {
            return false;
        }
        if (Float.compare(this.x2, elementBorder.x2) != 0) {
            return false;
        }
        return Float.compare(this.y2, elementBorder.y2) == 0;
    }
}

