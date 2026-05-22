/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL20
 */
package net.darkmeow.darkmeow.utils.visual.graphics.shaders;

import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.utils.IOUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.GLObject;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL20;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/Shader;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/GLObject;", "vertShaderPath", "", "fragShaderPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "id", "", "getId", "()I", "createShader", "path", "shaderType", "bind", "", "unbind", "destroy", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nShader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Shader.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/Shader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public class Shader
implements GLObject {
    private final int id;

    public Shader(@NotNull String vertShaderPath, @NotNull String fragShaderPath) {
        Intrinsics.checkNotNullParameter(vertShaderPath, "vertShaderPath");
        Intrinsics.checkNotNullParameter(fragShaderPath, "fragShaderPath");
        int vertexShaderID = this.createShader(vertShaderPath, 35633);
        int fragShaderID = this.createShader(fragShaderPath, 35632);
        int id = GL20.glCreateProgram();
        GL20.glAttachShader((int)id, (int)vertexShaderID);
        GL20.glAttachShader((int)id, (int)fragShaderID);
        GL20.glLinkProgram((int)id);
        int linked = GL20.glGetProgrami((int)id, (int)35714);
        if (linked == 0) {
            System.out.println((Object)GL20.glGetProgramInfoLog((int)id, (int)1024));
            GL20.glDeleteProgram((int)id);
            throw new IllegalStateException("Shader failed to link");
        }
        this.id = id;
        GL20.glDetachShader((int)id, (int)vertexShaderID);
        GL20.glDetachShader((int)id, (int)fragShaderID);
        GL20.glDeleteShader((int)vertexShaderID);
        GL20.glDeleteShader((int)fragShaderID);
    }

    @Override
    public final int getId() {
        return this.id;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final int createShader(String path, int shaderType) {
        String string;
        InputStream inputStream = this.getClass().getResourceAsStream(path);
        Intrinsics.checkNotNull(inputStream);
        Closeable closeable = inputStream;
        Throwable throwable = null;
        try {
            InputStream it = (InputStream)closeable;
            boolean bl2 = false;
            string = IOUtils.readText$default(IOUtils.INSTANCE, it, null, 0, 3, null);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
        String srcString = string;
        int id = GL20.glCreateShader((int)shaderType);
        GL20.glShaderSource((int)id, (CharSequence)srcString);
        GL20.glCompileShader((int)id);
        int compiled = GL20.glGetShaderi((int)id, (int)35713);
        if (compiled == 0) {
            System.out.println((Object)GL20.glGetShaderInfoLog((int)id, (int)1024));
            GL20.glDeleteShader((int)id);
            throw new IllegalStateException("Failed to compile shader: " + path);
        }
        return id;
    }

    @Override
    public void bind() {
        GL20.glUseProgram((int)this.id);
    }

    @Override
    public void unbind() {
        GL20.glUseProgram((int)0);
    }

    @Override
    public void destroy() {
        GL20.glDeleteProgram((int)this.id);
    }
}

