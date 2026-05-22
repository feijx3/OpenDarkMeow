/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL20
 */
package net.darkmeow.darkmeow.utils.visual.graphics.shaders;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.Shader;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL20;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0002\b\u0006H\u0086\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\b"}, d2={"use", "", "T", "Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/Shader;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/Shader;Lkotlin/jvm/functions/Function1;)V", "DarkMeow"})
public final class ShaderKt {
    public static final <T extends Shader> void use(@NotNull T $this$use, @NotNull Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter($this$use, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        boolean $i$f$use = false;
        $this$use.bind();
        block.invoke($this$use);
        GL20.glUseProgram((int)0);
    }
}

