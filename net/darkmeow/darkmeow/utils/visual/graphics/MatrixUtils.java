/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GLAllocation
 *  net.minecraft.client.renderer.OpenGlHelper
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL41
 */
package net.darkmeow.darkmeow.utils.visual.graphics;

import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL41;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0000J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/MatrixUtils;", "", "<init>", "()V", "matrixBuffer", "Ljava/nio/FloatBuffer;", "getMatrixBuffer", "()Ljava/nio/FloatBuffer;", "loadProjectionMatrix", "loadModelViewMatrix", "loadMatrix", "matrix", "Lorg/joml/Matrix4f;", "getMatrix", "uploadMatrix", "", "location", "", "id", "DarkMeow"})
public final class MatrixUtils {
    @NotNull
    public static final MatrixUtils INSTANCE = new MatrixUtils();
    @NotNull
    private static final FloatBuffer matrixBuffer;

    private MatrixUtils() {
    }

    @NotNull
    public final FloatBuffer getMatrixBuffer() {
        return matrixBuffer;
    }

    @NotNull
    public final MatrixUtils loadProjectionMatrix() {
        matrixBuffer.clear();
        GL11.glGetFloat((int)2983, (FloatBuffer)matrixBuffer);
        return this;
    }

    @NotNull
    public final MatrixUtils loadModelViewMatrix() {
        matrixBuffer.clear();
        GL11.glGetFloat((int)2982, (FloatBuffer)matrixBuffer);
        return this;
    }

    @NotNull
    public final MatrixUtils loadMatrix(@NotNull Matrix4f matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        matrix.get(matrixBuffer);
        return this;
    }

    @NotNull
    public final Matrix4f getMatrix() {
        return new Matrix4f(matrixBuffer);
    }

    @NotNull
    public final Matrix4f getMatrix(@NotNull Matrix4f matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        matrix.set(matrixBuffer);
        return matrix;
    }

    public final void uploadMatrix(int location) {
        OpenGlHelper.func_153160_c((int)location, (boolean)false, (FloatBuffer)matrixBuffer);
    }

    public final void uploadMatrix(int id, int location) {
        GL41.glProgramUniformMatrix4((int)id, (int)location, (boolean)false, (FloatBuffer)matrixBuffer);
    }

    static {
        FloatBuffer floatBuffer = GLAllocation.func_74529_h((int)16);
        Intrinsics.checkNotNullExpressionValue(floatBuffer, "createDirectFloatBuffer(...)");
        matrixBuffer = floatBuffer;
    }
}

