/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.features.module.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001%B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016\u00a8\u0006&"}, d2={"Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig;", "", "keyBindId", "", "keyBindType", "Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig$KeyBindType;", "hide", "", "notifyToggle", "<init>", "(ILnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig$KeyBindType;ZZ)V", "getKeyBindId", "()I", "setKeyBindId", "(I)V", "getKeyBindType", "()Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig$KeyBindType;", "setKeyBindType", "(Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig$KeyBindType;)V", "getHide", "()Z", "setHide", "(Z)V", "getNotifyToggle", "setNotifyToggle", "reset", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "KeyBindType", "DarkMeow"})
public final class ModuleBaseConfig {
    private int keyBindId;
    @NotNull
    private KeyBindType keyBindType;
    private boolean hide;
    private boolean notifyToggle;

    public ModuleBaseConfig(int keyBindId, @NotNull KeyBindType keyBindType, boolean hide, boolean notifyToggle) {
        Intrinsics.checkNotNullParameter((Object)keyBindType, "keyBindType");
        this.keyBindId = keyBindId;
        this.keyBindType = keyBindType;
        this.hide = hide;
        this.notifyToggle = notifyToggle;
    }

    public /* synthetic */ ModuleBaseConfig(int n2, KeyBindType keyBindType, boolean bl2, boolean bl3, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        if ((n3 & 2) != 0) {
            keyBindType = KeyBindType.TOGGLE;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        if ((n3 & 8) != 0) {
            bl3 = true;
        }
        this(n2, keyBindType, bl2, bl3);
    }

    public final int getKeyBindId() {
        return this.keyBindId;
    }

    public final void setKeyBindId(int n2) {
        this.keyBindId = n2;
    }

    @NotNull
    public final KeyBindType getKeyBindType() {
        return this.keyBindType;
    }

    public final void setKeyBindType(@NotNull KeyBindType keyBindType) {
        Intrinsics.checkNotNullParameter((Object)keyBindType, "<set-?>");
        this.keyBindType = keyBindType;
    }

    public final boolean getHide() {
        return this.hide;
    }

    public final void setHide(boolean bl2) {
        this.hide = bl2;
    }

    public final boolean getNotifyToggle() {
        return this.notifyToggle;
    }

    public final void setNotifyToggle(boolean bl2) {
        this.notifyToggle = bl2;
    }

    public final void reset() {
        this.keyBindId = 0;
        this.keyBindType = KeyBindType.TOGGLE;
        this.hide = false;
        this.notifyToggle = true;
    }

    public final int component1() {
        return this.keyBindId;
    }

    @NotNull
    public final KeyBindType component2() {
        return this.keyBindType;
    }

    public final boolean component3() {
        return this.hide;
    }

    public final boolean component4() {
        return this.notifyToggle;
    }

    @NotNull
    public final ModuleBaseConfig copy(int keyBindId, @NotNull KeyBindType keyBindType, boolean hide, boolean notifyToggle) {
        Intrinsics.checkNotNullParameter((Object)keyBindType, "keyBindType");
        return new ModuleBaseConfig(keyBindId, keyBindType, hide, notifyToggle);
    }

    public static /* synthetic */ ModuleBaseConfig copy$default(ModuleBaseConfig moduleBaseConfig, int n2, KeyBindType keyBindType, boolean bl2, boolean bl3, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n2 = moduleBaseConfig.keyBindId;
        }
        if ((n3 & 2) != 0) {
            keyBindType = moduleBaseConfig.keyBindType;
        }
        if ((n3 & 4) != 0) {
            bl2 = moduleBaseConfig.hide;
        }
        if ((n3 & 8) != 0) {
            bl3 = moduleBaseConfig.notifyToggle;
        }
        return moduleBaseConfig.copy(n2, keyBindType, bl2, bl3);
    }

    @NotNull
    public String toString() {
        return "ModuleBaseConfig(keyBindId=" + this.keyBindId + ", keyBindType=" + (Object)((Object)this.keyBindType) + ", hide=" + this.hide + ", notifyToggle=" + this.notifyToggle + ')';
    }

    public int hashCode() {
        int result = Integer.hashCode(this.keyBindId);
        result = result * 31 + this.keyBindType.hashCode();
        result = result * 31 + Boolean.hashCode(this.hide);
        result = result * 31 + Boolean.hashCode(this.notifyToggle);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModuleBaseConfig)) {
            return false;
        }
        ModuleBaseConfig moduleBaseConfig = (ModuleBaseConfig)other;
        if (this.keyBindId != moduleBaseConfig.keyBindId) {
            return false;
        }
        if (this.keyBindType != moduleBaseConfig.keyBindType) {
            return false;
        }
        if (this.hide != moduleBaseConfig.hide) {
            return false;
        }
        return this.notifyToggle == moduleBaseConfig.notifyToggle;
    }

    public ModuleBaseConfig() {
        this(0, null, false, false, 15, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/features/module/base/ModuleBaseConfig$KeyBindType;", "", "<init>", "(Ljava/lang/String;I)V", "TOGGLE", "HOLD", "DarkMeow"})
    public static final class KeyBindType
    extends Enum<KeyBindType> {
        public static final /* enum */ KeyBindType TOGGLE = new KeyBindType();
        public static final /* enum */ KeyBindType HOLD = new KeyBindType();
        private static final /* synthetic */ KeyBindType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static KeyBindType[] values() {
            return (KeyBindType[])$VALUES.clone();
        }

        public static KeyBindType valueOf(String value) {
            return Enum.valueOf(KeyBindType.class, value);
        }

        @NotNull
        public static EnumEntries<KeyBindType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = keyBindTypeArray = new KeyBindType[]{KeyBindType.TOGGLE, KeyBindType.HOLD};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

