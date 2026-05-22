/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.network.packet_forward;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.network.PacketForward;
import net.ccbluex.liquidbounce.features.module.modules.network.packet_forward.PacketForwardChannel;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.darkmeow.darkmeow.event.ListenableOwner;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardExtend;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "name", "", "defaultState", "", "force", "<init>", "(Ljava/lang/String;ZZ)V", "getName", "()Ljava/lang/String;", "getDefaultState", "()Z", "getForce", "linkedStatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getLinkedStatValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "setLinkedStatValue", "(Lnet/ccbluex/liquidbounce/value/impl/BoolValue;)V", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/network/PacketForward;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onRemoteConnect", "", "client", "Lnet/ccbluex/liquidbounce/features/module/modules/network/packet_forward/PacketForwardChannel;", "handleEvents", "DarkMeow"})
public abstract class PacketForwardExtend
implements ListenableOwner {
    @NotNull
    private final String name;
    private final boolean defaultState;
    private final boolean force;
    public BoolValue linkedStatValue;
    public PacketForward instance;

    public PacketForwardExtend(@NotNull String name, boolean defaultState, boolean force) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.defaultState = defaultState;
        this.force = force;
    }

    public /* synthetic */ PacketForwardExtend(String string, boolean bl2, boolean bl3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            bl3 = false;
        }
        this(string, bl2, bl3);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getDefaultState() {
        return this.defaultState;
    }

    public final boolean getForce() {
        return this.force;
    }

    @NotNull
    public final BoolValue getLinkedStatValue() {
        BoolValue boolValue = this.linkedStatValue;
        if (boolValue != null) {
            return boolValue;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linkedStatValue");
        return null;
    }

    public final void setLinkedStatValue(@NotNull BoolValue boolValue) {
        Intrinsics.checkNotNullParameter(boolValue, "<set-?>");
        this.linkedStatValue = boolValue;
    }

    @NotNull
    public final PacketForward getInstance() {
        PacketForward packetForward = this.instance;
        if (packetForward != null) {
            return packetForward;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull PacketForward packetForward) {
        Intrinsics.checkNotNullParameter(packetForward, "<set-?>");
        this.instance = packetForward;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public void onRemoteConnect(@NotNull PacketForwardChannel client) {
        Intrinsics.checkNotNullParameter(client, "client");
    }

    @Override
    public boolean handleEvents() {
        return this.getInstance().handleEvents() && (Boolean)this.getLinkedStatValue().get() != false;
    }
}

