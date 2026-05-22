/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.opengl.GL45
 */
package net.darkmeow.darkmeow.utils.visual.graphics.buffer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.utils.visual.graphics.GLDataType;
import net.darkmeow.darkmeow.utils.visual.graphics.GLFunctionsKt;
import net.darkmeow.darkmeow.utils.visual.graphics.VertexAttribute;
import net.darkmeow.kmogus.MutableArr;
import net.darkmeow.kmogus.MutableArrKt;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL45;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f\u00a8\u0006\u001b"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/buffer/PersistentMappedVBO;", "", "<init>", "()V", "vbo", "", "arr", "Lnet/darkmeow/kmogus/MutableArr;", "getArr", "()Lnet/darkmeow/kmogus/MutableArr;", "drawOffset", "getDrawOffset", "()I", "setDrawOffset", "(I)V", "sync", "", "end", "", "onRunGameLoopEnd", "POS2_COLOR", "getPOS2_COLOR", "POS3_COLOR", "getPOS3_COLOR", "createVao", "vertexAttribute", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nPersistentMappedVBO.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistentMappedVBO.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/buffer/PersistentMappedVBO\n+ 2 VertexAttribute.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttributeKt\n*L\n1#1,77:1\n83#2:78\n83#2:79\n*S KotlinDebug\n*F\n+ 1 PersistentMappedVBO.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/buffer/PersistentMappedVBO\n*L\n58#1:78\n63#1:79\n*E\n"})
public final class PersistentMappedVBO {
    @NotNull
    public static final PersistentMappedVBO INSTANCE;
    private static final int vbo;
    @NotNull
    private static final MutableArr arr;
    private static int drawOffset;
    private static long sync;
    private static final int POS2_COLOR;
    private static final int POS3_COLOR;

    private PersistentMappedVBO() {
    }

    @NotNull
    public final MutableArr getArr() {
        return arr;
    }

    public final int getDrawOffset() {
        return drawOffset;
    }

    public final void setDrawOffset(int n2) {
        drawOffset = n2;
    }

    public final void end() {
        drawOffset = (int)(arr.getPos() / 16L);
    }

    public final void onRunGameLoopEnd() {
        if (sync == 0L) {
            if (arr.getPos() >= arr.getLen() / (long)2) {
                sync = GLFunctionsKt.glFenceSync(37143, 0);
            }
        } else if (GLFunctionsKt.glGetSynciv(sync, 37140) == 37145) {
            GLFunctionsKt.glDeleteSync(sync);
            sync = 0L;
            arr.setPos(0L);
            drawOffset = 0;
        }
    }

    public final int getPOS2_COLOR() {
        return POS2_COLOR;
    }

    public final int getPOS3_COLOR() {
        return POS3_COLOR;
    }

    public final int createVao(@NotNull VertexAttribute vertexAttribute) {
        Intrinsics.checkNotNullParameter(vertexAttribute, "vertexAttribute");
        int vaoID = GL45.glCreateVertexArrays();
        GL30.glBindVertexArray((int)vaoID);
        GL15.glBindBuffer((int)34962, (int)vbo);
        vertexAttribute.apply();
        GL30.glBindVertexArray((int)0);
        GL15.glBindBuffer((int)34962, (int)0);
        return vaoID;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $this$POS3_COLOR_u24lambda_u242;
        VertexAttribute.Builder $this$POS2_COLOR_u24lambda_u241;
        VertexAttribute.Builder builder;
        int n2;
        INSTANCE = new PersistentMappedVBO();
        int $this$vbo_u24lambda_u240 = n2 = GL45.glCreateBuffers();
        boolean bl2 = false;
        GLFunctionsKt.glNamedBufferStorage($this$vbo_u24lambda_u240, 0x4000000L, 0L, 194);
        vbo = n2;
        arr = MutableArrKt.asMutable(GLFunctionsKt.glMapNamedBufferRange(vbo, 0L, 0x4000000L, 226));
        int stride$iv = 16;
        boolean $i$f$buildAttribute = false;
        VertexAttribute.Builder builder2 = builder = new VertexAttribute.Builder(stride$iv);
        PersistentMappedVBO persistentMappedVBO = INSTANCE;
        boolean bl3 = false;
        VertexAttribute.Builder.float$default($this$POS2_COLOR_u24lambda_u241, 0, 2, GLDataType.GL_FLOAT, false, 0, 16, null);
        VertexAttribute.Builder.float$default($this$POS2_COLOR_u24lambda_u241, 1, 4, GLDataType.GL_UNSIGNED_BYTE, true, 0, 16, null);
        POS2_COLOR = persistentMappedVBO.createVao(builder.build());
        stride$iv = 16;
        $i$f$buildAttribute = false;
        $this$POS2_COLOR_u24lambda_u241 = builder = new VertexAttribute.Builder(stride$iv);
        persistentMappedVBO = INSTANCE;
        boolean bl4 = false;
        VertexAttribute.Builder.float$default((VertexAttribute.Builder)$this$POS3_COLOR_u24lambda_u242, 0, 3, GLDataType.GL_FLOAT, false, 0, 16, null);
        VertexAttribute.Builder.float$default((VertexAttribute.Builder)$this$POS3_COLOR_u24lambda_u242, 1, 4, GLDataType.GL_UNSIGNED_BYTE, true, 0, 16, null);
        POS3_COLOR = persistentMappedVBO.createVao(builder.build());
    }
}

