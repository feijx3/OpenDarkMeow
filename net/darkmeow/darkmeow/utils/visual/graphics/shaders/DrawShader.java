/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL41
 */
package net.darkmeow.darkmeow.utils.visual.graphics.shaders;

import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.utils.visual.graphics.MatrixUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.Shader;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL41;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/DrawShader;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/Shader;", "vertShaderPath", "", "fragShaderPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "projectionUniform", "", "modelViewUniform", "updateMatrix", "", "updateProjectionMatrix", "matrix", "Lorg/joml/Matrix4f;", "uploadProjectionMatrix", "buffer", "Ljava/nio/FloatBuffer;", "updateModelViewMatrix", "uploadModelViewMatrix", "DarkMeow"})
public class DrawShader
extends Shader {
    private final int projectionUniform;
    private final int modelViewUniform;

    public DrawShader(@NotNull String vertShaderPath, @NotNull String fragShaderPath) {
        Intrinsics.checkNotNullParameter(vertShaderPath, "vertShaderPath");
        Intrinsics.checkNotNullParameter(fragShaderPath, "fragShaderPath");
        super(vertShaderPath, fragShaderPath);
        this.projectionUniform = GL20.glGetUniformLocation((int)this.getId(), (CharSequence)"projection");
        this.modelViewUniform = GL20.glGetUniformLocation((int)this.getId(), (CharSequence)"modelView");
    }

    public final void updateMatrix() {
        this.updateModelViewMatrix();
        this.updateProjectionMatrix();
    }

    public final void updateProjectionMatrix() {
        MatrixUtils.INSTANCE.loadProjectionMatrix().uploadMatrix(this.getId(), this.projectionUniform);
    }

    public final void updateProjectionMatrix(@NotNull Matrix4f matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        MatrixUtils.INSTANCE.loadMatrix(matrix).uploadMatrix(this.getId(), this.projectionUniform);
    }

    public final void uploadProjectionMatrix(@NotNull FloatBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        GL41.glProgramUniformMatrix4((int)this.getId(), (int)this.projectionUniform, (boolean)false, (FloatBuffer)buffer);
    }

    public final void updateModelViewMatrix() {
        MatrixUtils.INSTANCE.loadModelViewMatrix().uploadMatrix(this.getId(), this.modelViewUniform);
    }

    public final void updateModelViewMatrix(@NotNull Matrix4f matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        MatrixUtils.INSTANCE.loadMatrix(matrix).uploadMatrix(this.getId(), this.modelViewUniform);
    }

    public final void uploadModelViewMatrix(@NotNull FloatBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        GL41.glProgramUniformMatrix4((int)this.getId(), (int)this.modelViewUniform, (boolean)false, (FloatBuffer)buffer);
    }
}

