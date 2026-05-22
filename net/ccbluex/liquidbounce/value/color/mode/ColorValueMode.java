/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.value.color.mode;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.color.mode.ColorValueModeSelectCount;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueMode;", "", "name", "", "count", "Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueModeSelectCount;", "priority", "", "hasSpeed", "", "hasOffset", "<init>", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueModeSelectCount;IZZ)V", "getName", "()Ljava/lang/String;", "getCount", "()Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueModeSelectCount;", "getPriority", "()I", "getHasSpeed", "()Z", "setHasSpeed", "(Z)V", "getHasOffset", "setHasOffset", "getColor", "Ljava/awt/Color;", "value", "Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;", "offset", "DarkMeow"})
public abstract class ColorValueMode {
    @NotNull
    private final String name;
    @NotNull
    private final ColorValueModeSelectCount count;
    private final int priority;
    private boolean hasSpeed;
    private boolean hasOffset;

    public ColorValueMode(@NotNull String name, @NotNull ColorValueModeSelectCount count, int priority, boolean hasSpeed, boolean hasOffset) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter((Object)count, "count");
        this.name = name;
        this.count = count;
        this.priority = priority;
        this.hasSpeed = hasSpeed;
        this.hasOffset = hasOffset;
    }

    public /* synthetic */ ColorValueMode(String string, ColorValueModeSelectCount colorValueModeSelectCount, int n2, boolean bl2, boolean bl3, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        if ((n3 & 8) != 0) {
            bl2 = false;
        }
        if ((n3 & 0x10) != 0) {
            bl3 = false;
        }
        this(string, colorValueModeSelectCount, n2, bl2, bl3);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ColorValueModeSelectCount getCount() {
        return this.count;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getHasSpeed() {
        return this.hasSpeed;
    }

    public final void setHasSpeed(boolean bl2) {
        this.hasSpeed = bl2;
    }

    public final boolean getHasOffset() {
        return this.hasOffset;
    }

    public final void setHasOffset(boolean bl2) {
        this.hasOffset = bl2;
    }

    @NotNull
    public abstract Color getColor(@NotNull ColorValueInfo var1, int var2);
}

