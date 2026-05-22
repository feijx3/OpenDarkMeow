/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.utils.visual.graphics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.utils.visual.graphics.VertexAttribute;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\bH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\t"}, d2={"buildAttribute", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute;", "stride", "", "block", "Lkotlin/Function1;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$Builder;", "", "Lkotlin/ExtensionFunctionType;", "DarkMeow"})
public final class VertexAttributeKt {
    @NotNull
    public static final VertexAttribute buildAttribute(int stride, @NotNull Function1<? super VertexAttribute.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean $i$f$buildAttribute = false;
        VertexAttribute.Builder builder = new VertexAttribute.Builder(stride);
        block.invoke(builder);
        return builder.build();
    }
}

