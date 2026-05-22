/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend.visual_blocks;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.event.Listenable;
import net.ccbluex.liquidbounce.features.module.modules.world.scaffolds.extend.ScaffoldExtendVisualBlocks;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/visual_blocks/ScaffoldExtendVisualBlockMode;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendVisualBlocks;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendVisualBlocks;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/world/scaffolds/extend/ScaffoldExtendVisualBlocks;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onClear", "", "onPlaced", "pos", "Lnet/minecraft/util/math/BlockPos;", "onRender", "partialTicks", "", "handleEvents", "", "DarkMeow"})
public abstract class ScaffoldExtendVisualBlockMode
extends MinecraftInstance
implements Listenable {
    @NotNull
    private final String name;
    public ScaffoldExtendVisualBlocks instance;

    public ScaffoldExtendVisualBlockMode(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ScaffoldExtendVisualBlocks getInstance() {
        ScaffoldExtendVisualBlocks scaffoldExtendVisualBlocks = this.instance;
        if (scaffoldExtendVisualBlocks != null) {
            return scaffoldExtendVisualBlocks;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull ScaffoldExtendVisualBlocks scaffoldExtendVisualBlocks) {
        Intrinsics.checkNotNullParameter(scaffoldExtendVisualBlocks, "<set-?>");
        this.instance = scaffoldExtendVisualBlocks;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public abstract void onClear();

    public abstract void onPlaced(@NotNull BlockPos var1);

    public abstract void onRender(float var1);

    @Override
    public boolean handleEvents() {
        return this.getInstance().handleEvents() && Intrinsics.areEqual(this.getInstance().modeValue.get(), this.name);
    }
}

