/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.event.events.render.in_game_2d;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.CancellableEvent;
import net.ccbluex.liquidbounce.event.Event;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "<init>", "()V", "PRE", "RenderItemSide", "DarkMeow"})
public final class Render2DItemInFirstPersonEvent
extends CancellableEvent {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017\u00a8\u0006("}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$PRE;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "swingHand", "Lnet/minecraft/util/EnumHand;", "swingProgress", "", "itemStackMainHand", "Lnet/minecraft/item/ItemStack;", "itemStackOffHand", "equippedProgressMainHand", "equippedProgressOffHand", "partialTicks", "<init>", "(Lnet/minecraft/client/entity/AbstractClientPlayer;Lnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;FFF)V", "getPlayer", "()Lnet/minecraft/client/entity/AbstractClientPlayer;", "getSwingHand", "()Lnet/minecraft/util/EnumHand;", "setSwingHand", "(Lnet/minecraft/util/EnumHand;)V", "getSwingProgress", "()F", "setSwingProgress", "(F)V", "getItemStackMainHand", "()Lnet/minecraft/item/ItemStack;", "setItemStackMainHand", "(Lnet/minecraft/item/ItemStack;)V", "getItemStackOffHand", "setItemStackOffHand", "getEquippedProgressMainHand", "setEquippedProgressMainHand", "getEquippedProgressOffHand", "setEquippedProgressOffHand", "getPartialTicks", "removeEquippedProgressMainHand", "", "removeEquippedProgressOffHand", "DarkMeow"})
    public static final class PRE
    extends CancellableEvent {
        @NotNull
        private final AbstractClientPlayer player;
        @NotNull
        private EnumHand swingHand;
        private float swingProgress;
        @NotNull
        private ItemStack itemStackMainHand;
        @NotNull
        private ItemStack itemStackOffHand;
        private float equippedProgressMainHand;
        private float equippedProgressOffHand;
        private final float partialTicks;

        public PRE(@NotNull AbstractClientPlayer player, @NotNull EnumHand swingHand, float swingProgress, @NotNull ItemStack itemStackMainHand, @NotNull ItemStack itemStackOffHand, float equippedProgressMainHand, float equippedProgressOffHand, float partialTicks) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(swingHand, "swingHand");
            Intrinsics.checkNotNullParameter(itemStackMainHand, "itemStackMainHand");
            Intrinsics.checkNotNullParameter(itemStackOffHand, "itemStackOffHand");
            this.player = player;
            this.swingHand = swingHand;
            this.swingProgress = swingProgress;
            this.itemStackMainHand = itemStackMainHand;
            this.itemStackOffHand = itemStackOffHand;
            this.equippedProgressMainHand = equippedProgressMainHand;
            this.equippedProgressOffHand = equippedProgressOffHand;
            this.partialTicks = partialTicks;
        }

        @NotNull
        public final AbstractClientPlayer getPlayer() {
            return this.player;
        }

        @NotNull
        public final EnumHand getSwingHand() {
            return this.swingHand;
        }

        public final void setSwingHand(@NotNull EnumHand enumHand) {
            Intrinsics.checkNotNullParameter(enumHand, "<set-?>");
            this.swingHand = enumHand;
        }

        public final float getSwingProgress() {
            return this.swingProgress;
        }

        public final void setSwingProgress(float f2) {
            this.swingProgress = f2;
        }

        @NotNull
        public final ItemStack getItemStackMainHand() {
            return this.itemStackMainHand;
        }

        public final void setItemStackMainHand(@NotNull ItemStack itemStack) {
            Intrinsics.checkNotNullParameter(itemStack, "<set-?>");
            this.itemStackMainHand = itemStack;
        }

        @NotNull
        public final ItemStack getItemStackOffHand() {
            return this.itemStackOffHand;
        }

        public final void setItemStackOffHand(@NotNull ItemStack itemStack) {
            Intrinsics.checkNotNullParameter(itemStack, "<set-?>");
            this.itemStackOffHand = itemStack;
        }

        public final float getEquippedProgressMainHand() {
            return this.equippedProgressMainHand;
        }

        public final void setEquippedProgressMainHand(float f2) {
            this.equippedProgressMainHand = f2;
        }

        public final float getEquippedProgressOffHand() {
            return this.equippedProgressOffHand;
        }

        public final void setEquippedProgressOffHand(float f2) {
            this.equippedProgressOffHand = f2;
        }

        public final float getPartialTicks() {
            return this.partialTicks;
        }

        public final void removeEquippedProgressMainHand() {
            this.equippedProgressMainHand = 0.0f;
        }

        public final void removeEquippedProgressOffHand() {
            this.equippedProgressOffHand = 0.0f;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$RenderItemSide;", "", "<init>", "()V", "PRE", "POST", "DarkMeow"})
    public static final class RenderItemSide {

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0004\b\u000e\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$RenderItemSide$POST;", "Lnet/ccbluex/liquidbounce/event/Event;", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "itemStack", "Lnet/minecraft/item/ItemStack;", "transformType", "Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;", "leftHand", "", "equippedProgressMainHand", "", "equippedProgressOffHand", "partialTicks", "<init>", "(Lnet/minecraft/client/entity/AbstractClientPlayer;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;ZFFF)V", "event", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$RenderItemSide$PRE;", "(Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$RenderItemSide$PRE;)V", "getPlayer", "()Lnet/minecraft/client/entity/AbstractClientPlayer;", "getItemStack", "()Lnet/minecraft/item/ItemStack;", "getTransformType", "()Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;", "getLeftHand", "()Z", "getEquippedProgressMainHand", "()F", "getEquippedProgressOffHand", "getPartialTicks", "DarkMeow"})
        public static final class POST
        extends Event {
            @NotNull
            private final AbstractClientPlayer player;
            @NotNull
            private final ItemStack itemStack;
            @NotNull
            private final ItemCameraTransforms.TransformType transformType;
            private final boolean leftHand;
            private final float equippedProgressMainHand;
            private final float equippedProgressOffHand;
            private final float partialTicks;

            public POST(@NotNull AbstractClientPlayer player, @NotNull ItemStack itemStack, @NotNull ItemCameraTransforms.TransformType transformType, boolean leftHand, float equippedProgressMainHand, float equippedProgressOffHand, float partialTicks) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(itemStack, "itemStack");
                Intrinsics.checkNotNullParameter(transformType, "transformType");
                this.player = player;
                this.itemStack = itemStack;
                this.transformType = transformType;
                this.leftHand = leftHand;
                this.equippedProgressMainHand = equippedProgressMainHand;
                this.equippedProgressOffHand = equippedProgressOffHand;
                this.partialTicks = partialTicks;
            }

            @NotNull
            public final AbstractClientPlayer getPlayer() {
                return this.player;
            }

            @NotNull
            public final ItemStack getItemStack() {
                return this.itemStack;
            }

            @NotNull
            public final ItemCameraTransforms.TransformType getTransformType() {
                return this.transformType;
            }

            public final boolean getLeftHand() {
                return this.leftHand;
            }

            public final float getEquippedProgressMainHand() {
                return this.equippedProgressMainHand;
            }

            public final float getEquippedProgressOffHand() {
                return this.equippedProgressOffHand;
            }

            public final float getPartialTicks() {
                return this.partialTicks;
            }

            public POST(@NotNull PRE event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this(event.getPlayer(), event.getItemStack(), event.getTransformType(), event.getLeftHand(), event.getEquippedProgressMainHand(), event.getEquippedProgressOffHand(), event.getPartialTicks());
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0004\b\u000e\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"\u00a8\u0006%"}, d2={"Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$RenderItemSide$PRE;", "Lnet/ccbluex/liquidbounce/event/CancellableEvent;", "player", "Lnet/minecraft/client/entity/AbstractClientPlayer;", "itemStack", "Lnet/minecraft/item/ItemStack;", "transformType", "Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;", "leftHand", "", "equippedProgressMainHand", "", "equippedProgressOffHand", "partialTicks", "<init>", "(Lnet/minecraft/client/entity/AbstractClientPlayer;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;ZFFF)V", "event", "Lnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$PRE;", "(Lnet/minecraft/client/entity/AbstractClientPlayer;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;ZLnet/ccbluex/liquidbounce/event/events/render/in_game_2d/Render2DItemInFirstPersonEvent$PRE;)V", "getPlayer", "()Lnet/minecraft/client/entity/AbstractClientPlayer;", "getItemStack", "()Lnet/minecraft/item/ItemStack;", "setItemStack", "(Lnet/minecraft/item/ItemStack;)V", "getTransformType", "()Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;", "setTransformType", "(Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;)V", "getLeftHand", "()Z", "setLeftHand", "(Z)V", "getEquippedProgressMainHand", "()F", "getEquippedProgressOffHand", "getPartialTicks", "DarkMeow"})
        public static final class PRE
        extends CancellableEvent {
            @NotNull
            private final AbstractClientPlayer player;
            @NotNull
            private ItemStack itemStack;
            @NotNull
            private ItemCameraTransforms.TransformType transformType;
            private boolean leftHand;
            private final float equippedProgressMainHand;
            private final float equippedProgressOffHand;
            private final float partialTicks;

            public PRE(@NotNull AbstractClientPlayer player, @NotNull ItemStack itemStack, @NotNull ItemCameraTransforms.TransformType transformType, boolean leftHand, float equippedProgressMainHand, float equippedProgressOffHand, float partialTicks) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(itemStack, "itemStack");
                Intrinsics.checkNotNullParameter(transformType, "transformType");
                this.player = player;
                this.itemStack = itemStack;
                this.transformType = transformType;
                this.leftHand = leftHand;
                this.equippedProgressMainHand = equippedProgressMainHand;
                this.equippedProgressOffHand = equippedProgressOffHand;
                this.partialTicks = partialTicks;
            }

            @NotNull
            public final AbstractClientPlayer getPlayer() {
                return this.player;
            }

            @NotNull
            public final ItemStack getItemStack() {
                return this.itemStack;
            }

            public final void setItemStack(@NotNull ItemStack itemStack) {
                Intrinsics.checkNotNullParameter(itemStack, "<set-?>");
                this.itemStack = itemStack;
            }

            @NotNull
            public final ItemCameraTransforms.TransformType getTransformType() {
                return this.transformType;
            }

            public final void setTransformType(@NotNull ItemCameraTransforms.TransformType transformType) {
                Intrinsics.checkNotNullParameter(transformType, "<set-?>");
                this.transformType = transformType;
            }

            public final boolean getLeftHand() {
                return this.leftHand;
            }

            public final void setLeftHand(boolean bl2) {
                this.leftHand = bl2;
            }

            public final float getEquippedProgressMainHand() {
                return this.equippedProgressMainHand;
            }

            public final float getEquippedProgressOffHand() {
                return this.equippedProgressOffHand;
            }

            public final float getPartialTicks() {
                return this.partialTicks;
            }

            public PRE(@NotNull AbstractClientPlayer player, @NotNull ItemStack itemStack, @NotNull ItemCameraTransforms.TransformType transformType, boolean leftHand, @NotNull net.ccbluex.liquidbounce.event.events.render.in_game_2d.Render2DItemInFirstPersonEvent$PRE event) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(itemStack, "itemStack");
                Intrinsics.checkNotNullParameter(transformType, "transformType");
                Intrinsics.checkNotNullParameter(event, "event");
                this(player, itemStack, transformType, leftHand, event.getEquippedProgressMainHand(), event.getEquippedProgressOffHand(), event.getPartialTicks());
            }
        }
    }
}

