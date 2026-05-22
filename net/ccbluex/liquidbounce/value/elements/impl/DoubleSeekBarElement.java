/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.value.elements.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.ClosedRange;
import net.ccbluex.liquidbounce.value.elements.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH&J\b\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2={"Lnet/ccbluex/liquidbounce/value/elements/impl/DoubleSeekBarElement;", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "<init>", "()V", "selected", "Lnet/ccbluex/liquidbounce/value/elements/impl/DoubleSeekBarElement$DoubleSeekBarSelected;", "getSelected", "()Lnet/ccbluex/liquidbounce/value/elements/impl/DoubleSeekBarElement$DoubleSeekBarSelected;", "setSelected", "(Lnet/ccbluex/liquidbounce/value/elements/impl/DoubleSeekBarElement$DoubleSeekBarSelected;)V", "getTitle", "", "getLength", "", "getValue", "Lkotlin/ranges/ClosedRange;", "getOffset", "getIsInt", "", "onClicked", "", "value", "DoubleSeekBarSelected", "DarkMeow"})
public abstract class DoubleSeekBarElement
extends Element {
    @Nullable
    private DoubleSeekBarSelected selected;

    @Nullable
    public DoubleSeekBarSelected getSelected() {
        return this.selected;
    }

    public void setSelected(@Nullable DoubleSeekBarSelected doubleSeekBarSelected) {
        this.selected = doubleSeekBarSelected;
    }

    @NotNull
    public abstract String getTitle();

    public abstract float getLength();

    @NotNull
    public abstract ClosedRange<Float> getValue();

    public abstract float getOffset();

    public abstract boolean getIsInt();

    public abstract void onClicked(@NotNull ClosedRange<Float> var1);

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/value/elements/impl/DoubleSeekBarElement$DoubleSeekBarSelected;", "", "<init>", "(Ljava/lang/String;I)V", "MIN", "MAX", "DarkMeow"})
    public static final class DoubleSeekBarSelected
    extends Enum<DoubleSeekBarSelected> {
        public static final /* enum */ DoubleSeekBarSelected MIN = new DoubleSeekBarSelected();
        public static final /* enum */ DoubleSeekBarSelected MAX = new DoubleSeekBarSelected();
        private static final /* synthetic */ DoubleSeekBarSelected[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static DoubleSeekBarSelected[] values() {
            return (DoubleSeekBarSelected[])$VALUES.clone();
        }

        public static DoubleSeekBarSelected valueOf(String value) {
            return Enum.valueOf(DoubleSeekBarSelected.class, value);
        }

        @NotNull
        public static EnumEntries<DoubleSeekBarSelected> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = doubleSeekBarSelectedArray = new DoubleSeekBarSelected[]{DoubleSeekBarSelected.MIN, DoubleSeekBarSelected.MAX};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

