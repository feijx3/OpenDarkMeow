/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.render.entity;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.ChangeValueEvent;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\n\u000b\fB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\r\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "Lnet/minecraft/util/ResourceLocation;", "info", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "resource", "<init>", "(Lnet/minecraft/client/network/NetworkPlayerInfo;Lnet/minecraft/util/ResourceLocation;)V", "getInfo", "()Lnet/minecraft/client/network/NetworkPlayerInfo;", "Skin", "Cape", "SkinType", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$Cape;", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$Skin;", "DarkMeow"})
public abstract class RenderEntityPlayerSkinEvent
extends ChangeValueEvent<ResourceLocation> {
    @NotNull
    private final NetworkPlayerInfo info;

    private RenderEntityPlayerSkinEvent(NetworkPlayerInfo info, ResourceLocation resource) {
        super(resource);
        this.info = info;
    }

    @NotNull
    public final NetworkPlayerInfo getInfo() {
        return this.info;
    }

    public /* synthetic */ RenderEntityPlayerSkinEvent(NetworkPlayerInfo info, ResourceLocation resource, DefaultConstructorMarker $constructor_marker) {
        this(info, resource);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$Cape;", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent;", "info", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "resource", "Lnet/minecraft/util/ResourceLocation;", "<init>", "(Lnet/minecraft/client/network/NetworkPlayerInfo;Lnet/minecraft/util/ResourceLocation;)V", "DarkMeow"})
    public static final class Cape
    extends RenderEntityPlayerSkinEvent {
        public Cape(@NotNull NetworkPlayerInfo info, @NotNull ResourceLocation resource) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(resource, "resource");
            super(info, resource, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$Skin;", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent;", "info", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "resource", "Lnet/minecraft/util/ResourceLocation;", "<init>", "(Lnet/minecraft/client/network/NetworkPlayerInfo;Lnet/minecraft/util/ResourceLocation;)V", "DarkMeow"})
    public static final class Skin
    extends RenderEntityPlayerSkinEvent {
        public Skin(@NotNull NetworkPlayerInfo info, @NotNull ResourceLocation resource) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(resource, "resource");
            super(info, resource, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$SkinType;", "Lnet/ccbluex/liquidbounce/event/ChangeValueEvent;", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$SkinType$Type;", "info", "Lnet/minecraft/client/network/NetworkPlayerInfo;", "type", "<init>", "(Lnet/minecraft/client/network/NetworkPlayerInfo;Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$SkinType$Type;)V", "getInfo", "()Lnet/minecraft/client/network/NetworkPlayerInfo;", "Type", "DarkMeow"})
    public static final class SkinType
    extends ChangeValueEvent<Type> {
        @NotNull
        private final NetworkPlayerInfo info;

        public SkinType(@NotNull NetworkPlayerInfo info, @NotNull Type type) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter((Object)type, "type");
            super(type);
            this.info = info;
        }

        @NotNull
        public final NetworkPlayerInfo getInfo() {
            return this.info;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$SkinType$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Slim", "getVanillaName", "", "Companion", "DarkMeow"})
        public static final class Type
        extends Enum<Type> {
            @NotNull
            public static final Companion Companion;
            public static final /* enum */ Type Default;
            public static final /* enum */ Type Slim;
            private static final /* synthetic */ Type[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            @NotNull
            public final String getVanillaName() {
                String string = this.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
                return string;
            }

            public static Type[] values() {
                return (Type[])$VALUES.clone();
            }

            public static Type valueOf(String value) {
                return Enum.valueOf(Type.class, value);
            }

            @NotNull
            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            @JvmStatic
            @NotNull
            public static final Type fromVanillaName(@NotNull String name) {
                return Companion.fromVanillaName(name);
            }

            static {
                Default = new Type();
                Slim = new Type();
                $VALUES = typeArray = new Type[]{Type.Default, Type.Slim};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
                Companion = new Companion(null);
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$SkinType$Type$Companion;", "", "<init>", "()V", "fromVanillaName", "Lnet/ccbluex/liquidbounce/event/events/render/entity/RenderEntityPlayerSkinEvent$SkinType$Type;", "name", "", "DarkMeow"})
            public static final class Companion {
                private Companion() {
                }

                @JvmStatic
                @NotNull
                public final Type fromVanillaName(@NotNull String name) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    String string = name;
                    return Intrinsics.areEqual(string, "default") ? Default : (Intrinsics.areEqual(string, "slim") ? Slim : Default);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }
    }
}

