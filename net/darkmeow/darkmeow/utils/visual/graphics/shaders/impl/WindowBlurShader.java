/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.shader.Framebuffer
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.opengl.GL41
 *  org.lwjgl.opengl.GL45
 */
package net.darkmeow.darkmeow.utils.visual.graphics.shaders.impl;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.darkmeow.darkmeow.manager.visual.gl.SafeGlStateManager;
import net.darkmeow.darkmeow.structs.Vec4f32;
import net.darkmeow.darkmeow.utils.Helper;
import net.darkmeow.darkmeow.utils.visual.GlStateManagerUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.GLDataType;
import net.darkmeow.darkmeow.utils.visual.graphics.MatrixUtils;
import net.darkmeow.darkmeow.utils.visual.graphics.VertexAttribute;
import net.darkmeow.darkmeow.utils.visual.graphics.buffer.PersistentMappedVBO;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.AbstractShader;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.DrawShader;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.Shader;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.ShaderUpdateManager;
import net.darkmeow.kmogus.MutableArr;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL41;
import org.lwjgl.opengl.GL45;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u00014B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016J<\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)H\u0007J<\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020)2\u0006\u0010$\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010&\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020)H\u0007J \u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0002J(\u00101\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020)2\u0006\u0010$\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010&\u001a\u00020)H\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0006H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019\u00a8\u00065"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/AbstractShader;", "Lnet/darkmeow/darkmeow/utils/Helper;", "<init>", "()V", "vao", "", "getVao", "()I", "setVao", "(I)V", "fbo1", "Lnet/minecraft/client/shader/Framebuffer;", "getFbo1", "()Lnet/minecraft/client/shader/Framebuffer;", "setFbo1", "(Lnet/minecraft/client/shader/Framebuffer;)V", "fbo2", "getFbo2", "setFbo2", "passH", "Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader$Pass;", "getPassH", "()Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader$Pass;", "setPassH", "(Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader$Pass;)V", "passV", "getPassV", "setPassV", "initialization", "", "width", "height", "updateResolution", "render", "x1", "y1", "x2", "y2", "pass", "radius", "", "drawPass", "shader", "x", "y", "bindFbo", "from", "to", "putVertices", "setTextureParam", "textureID", "Pass", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nWindowBlurShader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowBlurShader.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader\n+ 2 VertexAttribute.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttributeKt\n*L\n1#1,218:1\n83#2:219\n*S KotlinDebug\n*F\n+ 1 WindowBlurShader.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader\n*L\n36#1:219\n*E\n"})
public final class WindowBlurShader
extends AbstractShader
implements Helper {
    @NotNull
    public static final WindowBlurShader INSTANCE = new WindowBlurShader();
    private static int vao;
    public static Framebuffer fbo1;
    public static Framebuffer fbo2;
    public static Pass passH;
    public static Pass passV;

    private WindowBlurShader() {
    }

    public final int getVao() {
        return vao;
    }

    public final void setVao(int n2) {
        vao = n2;
    }

    @NotNull
    public final Framebuffer getFbo1() {
        Framebuffer framebuffer = fbo1;
        if (framebuffer != null) {
            return framebuffer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fbo1");
        return null;
    }

    public final void setFbo1(@NotNull Framebuffer framebuffer) {
        Intrinsics.checkNotNullParameter(framebuffer, "<set-?>");
        fbo1 = framebuffer;
    }

    @NotNull
    public final Framebuffer getFbo2() {
        Framebuffer framebuffer = fbo2;
        if (framebuffer != null) {
            return framebuffer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fbo2");
        return null;
    }

    public final void setFbo2(@NotNull Framebuffer framebuffer) {
        Intrinsics.checkNotNullParameter(framebuffer, "<set-?>");
        fbo2 = framebuffer;
    }

    @NotNull
    public final Pass getPassH() {
        Pass pass = passH;
        if (pass != null) {
            return pass;
        }
        Intrinsics.throwUninitializedPropertyAccessException("passH");
        return null;
    }

    public final void setPassH(@NotNull Pass pass) {
        Intrinsics.checkNotNullParameter(pass, "<set-?>");
        passH = pass;
    }

    @NotNull
    public final Pass getPassV() {
        Pass pass = passV;
        if (pass != null) {
            return pass;
        }
        Intrinsics.throwUninitializedPropertyAccessException("passV");
        return null;
    }

    public final void setPassV(@NotNull Pass pass) {
        Intrinsics.checkNotNullParameter(pass, "<set-?>");
        passV = pass;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void initialization(int width, int height) {
        void $this$initialization_u24lambda_u240;
        VertexAttribute.Builder builder;
        int stride$iv = 16;
        boolean $i$f$buildAttribute = false;
        VertexAttribute.Builder builder2 = builder = new VertexAttribute.Builder(stride$iv);
        PersistentMappedVBO persistentMappedVBO = PersistentMappedVBO.INSTANCE;
        boolean bl2 = false;
        VertexAttribute.Builder.float$default((VertexAttribute.Builder)$this$initialization_u24lambda_u240, 0, 4, GLDataType.GL_FLOAT, false, 0, 16, null);
        vao = persistentMappedVBO.createVao(builder.build());
        this.setFbo1(new Framebuffer(width, height, false));
        this.setFbo2(new Framebuffer(width, height, false));
        this.setPassH(new Pass("/assets/minecraft/darkmeow/shaders/WindowBlurH.vsh"));
        this.setPassV(new Pass("/assets/minecraft/darkmeow/shaders/WindowBlurV.vsh"));
    }

    @Override
    public void updateResolution(int width, int height) {
        this.getPassH().updateResolution(width, height);
        this.getPassV().updateResolution(width, height);
        this.getFbo1().func_147613_a(width, height);
        this.setTextureParam(this.getFbo1().field_147617_g);
        this.getFbo2().func_147613_a(width, height);
        this.setTextureParam(this.getFbo2().field_147617_g);
    }

    @JvmOverloads
    public final void render(int x1, int y1, int x2, int y2, int pass, float radius) {
        this.render((float)x1, (float)y1, (float)x2, (float)y2, pass, radius);
    }

    public static /* synthetic */ void render$default(WindowBlurShader windowBlurShader, int n2, int n3, int n4, int n5, int n6, float f2, int n7, Object object) {
        if ((n7 & 0x10) != 0) {
            n6 = 1;
        }
        if ((n7 & 0x20) != 0) {
            f2 = 0.0f;
        }
        windowBlurShader.render(n2, n3, n4, n5, n6, f2);
    }

    @JvmOverloads
    public final void render(float x1, float y1, float x2, float y2, int pass, float radius) {
        if (ShaderUpdateManager.disable || pass == 0) {
            return;
        }
        this.setTextureParam(this.getMc().func_147110_a().field_147617_g);
        this.putVertices(x1, y1, x2, y2);
        GlStateManager.func_179138_g((int)OpenGlHelper.field_77478_a);
        GlStateManagerUtils.INSTANCE.unapplyBlend();
        SafeGlStateManager.enableLineSmooth();
        SafeGlStateManager.enableDepthClamp();
        GlStateManager.func_179097_i();
        GlStateManager.func_179132_a((boolean)false);
        this.getPassH().updateSize(x2, y2);
        this.getPassH().updateCornerRadius(RangesKt.coerceIn(radius, 0.0f, Math.min(x2 - x1, y2 - y1) / (float)2));
        this.getPassV().updateSize(x2, y2);
        this.getPassV().updateCornerRadius(RangesKt.coerceIn(radius, 0.0f, Math.min(x2 - x1, y2 - y1) / (float)2));
        this.getPassH().updateMatrix();
        this.getPassV().updateMatrix();
        GL30.glBindVertexArray((int)vao);
        float extend = (float)pass - 1.0f;
        Framebuffer framebuffer = this.getMc().func_147110_a();
        Intrinsics.checkNotNullExpressionValue(framebuffer, "getFramebuffer(...)");
        this.bindFbo(framebuffer, this.getFbo1());
        this.drawPass(this.getPassH(), extend, extend + 1.0f);
        while (extend > 0.0f) {
            this.bindFbo(this.getFbo1(), this.getFbo2());
            this.drawPass(this.getPassV(), extend, extend);
            this.bindFbo(this.getFbo2(), this.getFbo1());
            this.drawPass(this.getPassH(), extend - 1.0f, extend);
            float f2 = extend;
            extend = f2 + -1.0f;
        }
        Framebuffer framebuffer2 = this.getFbo1();
        Framebuffer framebuffer3 = this.getMc().func_147110_a();
        Intrinsics.checkNotNullExpressionValue(framebuffer3, "getFramebuffer(...)");
        this.bindFbo(framebuffer2, framebuffer3);
        this.drawPass(this.getPassV(), 0.0f, 0.0f);
        this.getFbo1().func_147606_d();
        PersistentMappedVBO.INSTANCE.end();
        GL30.glBindVertexArray((int)0);
        GL20.glUseProgram((int)0);
        SafeGlStateManager.disableDepthClamp();
        GlStateManager.func_179126_j();
        GlStateManager.func_179132_a((boolean)true);
    }

    public static /* synthetic */ void render$default(WindowBlurShader windowBlurShader, float f2, float f3, float f4, float f5, int n2, float f6, int n3, Object object) {
        if ((n3 & 0x10) != 0) {
            n2 = 1;
        }
        if ((n3 & 0x20) != 0) {
            f6 = 0.0f;
        }
        windowBlurShader.render(f2, f3, f4, f5, n2, f6);
    }

    private final void drawPass(Pass shader, float x2, float y2) {
        shader.bind();
        shader.updateExtend(x2, y2);
        GL11.glDrawArrays((int)4, (int)PersistentMappedVBO.INSTANCE.getDrawOffset(), (int)6);
    }

    private final void bindFbo(Framebuffer from, Framebuffer to) {
        from.func_147612_c();
        to.func_147610_a(false);
    }

    private final void putVertices(float x1, float y1, float x2, float y2) {
        MutableArr array = PersistentMappedVBO.INSTANCE.getArr();
        long struct = Vec4f32.constructor-impl(array);
        Vec4f32.setX-impl(struct, x1);
        Vec4f32.setY-impl(struct, y1);
        Vec4f32.setZ-impl(struct, -1.0f);
        Vec4f32.setW-impl(struct, 1.0f);
        long l2 = struct;
        struct = Vec4f32.inc-7npMAm4(l2);
        Vec4f32.setX-impl(struct, x1);
        Vec4f32.setY-impl(struct, y2);
        Vec4f32.setZ-impl(struct, -1.0f);
        Vec4f32.setW-impl(struct, -1.0f);
        l2 = struct;
        struct = Vec4f32.inc-7npMAm4(l2);
        Vec4f32.setX-impl(struct, x2);
        Vec4f32.setY-impl(struct, y2);
        Vec4f32.setZ-impl(struct, 1.0f);
        Vec4f32.setW-impl(struct, -1.0f);
        l2 = struct;
        struct = Vec4f32.inc-7npMAm4(l2);
        Vec4f32.setX-impl(struct, x2);
        Vec4f32.setY-impl(struct, y1);
        Vec4f32.setZ-impl(struct, 1.0f);
        Vec4f32.setW-impl(struct, 1.0f);
        l2 = struct;
        struct = Vec4f32.inc-7npMAm4(l2);
        Vec4f32.setX-impl(struct, x1);
        Vec4f32.setY-impl(struct, y1);
        Vec4f32.setZ-impl(struct, -1.0f);
        Vec4f32.setW-impl(struct, 1.0f);
        l2 = struct;
        struct = Vec4f32.inc-7npMAm4(l2);
        Vec4f32.setX-impl(struct, x2);
        Vec4f32.setY-impl(struct, y2);
        Vec4f32.setZ-impl(struct, 1.0f);
        Vec4f32.setW-impl(struct, -1.0f);
        l2 = struct;
        struct = Vec4f32.inc-7npMAm4(l2);
        array.pos-4d6bxmI(Vec4f32.getPtr-hthgLag(struct));
    }

    private final void setTextureParam(int textureID) {
        GL45.glTextureParameteri((int)textureID, (int)10241, (int)9729);
        GL45.glTextureParameteri((int)textureID, (int)10240, (int)9729);
        GL45.glTextureParameteri((int)textureID, (int)10242, (int)33071);
        GL45.glTextureParameteri((int)textureID, (int)10243, (int)33071);
    }

    @JvmOverloads
    public final void render(int x1, int y1, int x2, int y2, int pass) {
        WindowBlurShader.render$default(this, x1, y1, x2, y2, pass, 0.0f, 32, null);
    }

    @JvmOverloads
    public final void render(int x1, int y1, int x2, int y2) {
        WindowBlurShader.render$default(this, x1, y1, x2, y2, 0, 0.0f, 48, null);
    }

    @JvmOverloads
    public final void render(float x1, float y1, float x2, float y2, int pass) {
        WindowBlurShader.render$default(this, x1, y1, x2, y2, pass, 0.0f, 32, null);
    }

    @JvmOverloads
    public final void render(float x1, float y1, float x2, float y2) {
        WindowBlurShader.render$default(this, x1, y1, x2, y2, 0, 0.0f, 48, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t\u00a8\u0006\u001f"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader$Pass;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/DrawShader;", "vertShaderPath", "", "<init>", "(Ljava/lang/String;)V", "reverseProjectionUniform", "", "getReverseProjectionUniform", "()I", "resolutionUniform", "getResolutionUniform", "extendUniform", "getExtendUniform", "sizeUniform", "getSizeUniform", "cornerRadiusUniform", "getCornerRadiusUniform", "updateExtend", "", "x", "", "y", "updateResolution", "width", "height", "updateSize", "x2", "y2", "updateCornerRadius", "radius", "DarkMeow"})
    @SourceDebugExtension(value={"SMAP\nWindowBlurShader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowBlurShader.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader$Pass\n+ 2 Shader.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/ShaderKt\n*L\n1#1,218:1\n72#2,4:219\n*S KotlinDebug\n*F\n+ 1 WindowBlurShader.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader$Pass\n*L\n190#1:219,4\n*E\n"})
    public static class Pass
    extends DrawShader {
        private final int reverseProjectionUniform;
        private final int resolutionUniform;
        private final int extendUniform;
        private final int sizeUniform;
        private final int cornerRadiusUniform;

        public Pass(@NotNull String vertShaderPath) {
            Intrinsics.checkNotNullParameter(vertShaderPath, "vertShaderPath");
            super(vertShaderPath, "/assets/minecraft/darkmeow/shaders/WindowBlur.fsh");
            this.reverseProjectionUniform = GL20.glGetUniformLocation((int)this.getId(), (CharSequence)"reverseProjection");
            this.resolutionUniform = GL20.glGetUniformLocation((int)this.getId(), (CharSequence)"resolution");
            this.extendUniform = GL20.glGetUniformLocation((int)this.getId(), (CharSequence)"extend");
            this.sizeUniform = GL20.glGetUniformLocation((int)this.getId(), (CharSequence)"size");
            this.cornerRadiusUniform = GL20.glGetUniformLocation((int)this.getId(), (CharSequence)"radius");
            Shader $this$use$iv = this;
            boolean $i$f$use = false;
            $this$use$iv.bind();
            Pass $this$_init__u24lambda_u240 = (Pass)$this$use$iv;
            boolean bl2 = false;
            $this$_init__u24lambda_u240.updateResolution(WindowBlurShader.INSTANCE.getMc().field_71443_c, WindowBlurShader.INSTANCE.getMc().field_71440_d);
            GL20.glUniform1i((int)GL20.glGetUniformLocation((int)$this$_init__u24lambda_u240.getId(), (CharSequence)"background"), (int)0);
            GL20.glUseProgram((int)0);
        }

        public final int getReverseProjectionUniform() {
            return this.reverseProjectionUniform;
        }

        public final int getResolutionUniform() {
            return this.resolutionUniform;
        }

        public final int getExtendUniform() {
            return this.extendUniform;
        }

        public final int getSizeUniform() {
            return this.sizeUniform;
        }

        public final int getCornerRadiusUniform() {
            return this.cornerRadiusUniform;
        }

        public final void updateExtend(float x2, float y2) {
            GL41.glProgramUniform2f((int)this.getId(), (int)this.extendUniform, (float)x2, (float)y2);
        }

        public final void updateResolution(float width, float height) {
            GL41.glProgramUniform2f((int)this.getId(), (int)this.resolutionUniform, (float)width, (float)height);
            Matrix4f matrix = new Matrix4f().ortho(0.0f, width, 0.0f, height, 1000.0f, 3000.0f).invert();
            Intrinsics.checkNotNull(matrix);
            MatrixUtils.INSTANCE.loadMatrix(matrix).uploadMatrix(this.getId(), this.reverseProjectionUniform);
        }

        public final void updateSize(float x2, float y2) {
            GL41.glProgramUniform2f((int)this.getId(), (int)this.sizeUniform, (float)x2, (float)y2);
        }

        public final void updateCornerRadius(float radius) {
            GL41.glProgramUniform1f((int)this.getId(), (int)this.cornerRadiusUniform, (float)radius);
        }
    }
}

