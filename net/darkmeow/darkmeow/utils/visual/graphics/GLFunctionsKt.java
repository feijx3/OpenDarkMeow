/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL32
 *  org.lwjgl.opengl.GL45
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.opengl.GLSync
 */
package net.darkmeow.darkmeow.utils.visual.graphics;

import dev.fastmc.common.BufferUtils;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.Arr;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL45;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.GLSync;
import sun.misc.Unsafe;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a-\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007\u001a-\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000f\u001a-\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000f\u00a2\u0006\u0004\b!\u0010\u001c\u001a&\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000f\u001a&\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000f\u001a\u0016\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f\u001a\u000e\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u0007\u001a\u0016\u0010;\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u000f\u001aN\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0007\u001aU\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0017\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\"\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u0010)\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u000202X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u00103\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0016\u0010=\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2={"unsafe", "Lsun/misc/Unsafe;", "trustedLookUp", "Ljava/lang/invoke/MethodHandles$Lookup;", "getFunctionAddress", "Lkotlin/Function1;", "", "", "nglNamedBufferSubData", "Ljava/lang/invoke/MethodHandle;", "kotlin.jvm.PlatformType", "glNamedBufferSubDataFunctionPointer", "glNamedBufferSubData", "", "buffer", "", "offset", "dataSize", "pointer", "Lnet/darkmeow/kmogus/Ptr;", "glNamedBufferSubData-FU7YDJQ", "(IJJJ)V", "data", "nglNamedBufferData", "glNamedBufferDataFunctionPointer", "glNamedBufferData", "usage", "glNamedBufferData-e51TvsE", "(IJJI)V", "nglNamedBufferStorage", "glNamedBufferStorageFunctionPointer", "glNamedBufferStorage", "flags", "glNamedBufferStorage-e51TvsE", "nglDrawElementsBOMethod", "glDrawElementsFunctionPointer", "glDrawElements", "mode", "count", "type", "indices", "nglMapNamedBufferRange", "glMapNamedBufferRangeFunctionPointer", "dummyBuffer", "Ljava/nio/ByteBuffer;", "glMapNamedBufferRange", "Lnet/darkmeow/kmogus/Arr;", "length", "access", "glSyncInstance", "Lorg/lwjgl/opengl/GLSync;", "pointerSetter", "lengthBuffer", "Ljava/nio/IntBuffer;", "valueBuffer", "glFenceSync", "condition", "glDeleteSync", "sync", "glGetSynciv", "pname", "nglCompressedTextureSubImage2D", "glCompressedTextureSubImage2DFunctionPointer", "glCompressedTextureSubImage2D", "texture", "level", "xOffset", "yOffset", "width", "height", "format", "imageSize", "glCompressedTextureSubImage2D--XwA0CU", "(IIIIIIIIJ)V", "DarkMeow"})
public final class GLFunctionsKt {
    @NotNull
    private static final Unsafe unsafe;
    @NotNull
    private static final MethodHandles.Lookup trustedLookUp;
    @NotNull
    private static final Function1<String, Long> getFunctionAddress;
    private static final MethodHandle nglNamedBufferSubData;
    private static final long glNamedBufferSubDataFunctionPointer;
    private static final MethodHandle nglNamedBufferData;
    private static final long glNamedBufferDataFunctionPointer;
    private static final MethodHandle nglNamedBufferStorage;
    private static final long glNamedBufferStorageFunctionPointer;
    private static final MethodHandle nglDrawElementsBOMethod;
    private static final long glDrawElementsFunctionPointer;
    private static final MethodHandle nglMapNamedBufferRange;
    private static final long glMapNamedBufferRangeFunctionPointer;
    @NotNull
    private static final ByteBuffer dummyBuffer;
    @NotNull
    private static final GLSync glSyncInstance;
    private static final MethodHandle pointerSetter;
    @NotNull
    private static final IntBuffer lengthBuffer;
    @NotNull
    private static final IntBuffer valueBuffer;
    private static final MethodHandle nglCompressedTextureSubImage2D;
    private static final long glCompressedTextureSubImage2DFunctionPointer;

    public static final void glNamedBufferSubData-FU7YDJQ(int buffer, long offset, long dataSize, long pointer) {
        nglNamedBufferSubData.invokeExact(buffer, offset, dataSize, pointer, glNamedBufferSubDataFunctionPointer);
    }

    public static final void glNamedBufferSubData(int buffer, long offset, long dataSize, long data) {
        nglNamedBufferSubData.invokeExact(buffer, offset, dataSize, data, glNamedBufferSubDataFunctionPointer);
    }

    public static final void glNamedBufferData-e51TvsE(int buffer, long dataSize, long pointer, int usage) {
        nglNamedBufferData.invokeExact(buffer, dataSize, pointer, usage, glNamedBufferDataFunctionPointer);
    }

    public static final void glNamedBufferData(int buffer, long dataSize, long data, int usage) {
        nglNamedBufferData.invokeExact(buffer, dataSize, data, usage, glNamedBufferDataFunctionPointer);
    }

    public static final void glNamedBufferStorage-e51TvsE(int buffer, long dataSize, long pointer, int flags) {
        nglNamedBufferStorage.invokeExact(buffer, dataSize, pointer, flags, glNamedBufferStorageFunctionPointer);
    }

    public static final void glNamedBufferStorage(int buffer, long dataSize, long data, int flags) {
        nglNamedBufferStorage.invokeExact(buffer, dataSize, data, flags, glNamedBufferStorageFunctionPointer);
    }

    public static final void glDrawElements(int mode, int count, int type, long indices) {
        nglDrawElementsBOMethod.invokeExact(mode, count, type, indices, glDrawElementsFunctionPointer);
    }

    @NotNull
    public static final Arr glMapNamedBufferRange(int buffer, long offset, long length, int access) {
        ByteBuffer byteBuffer = nglMapNamedBufferRange.invokeExact(buffer, offset, length, access, dummyBuffer, glMapNamedBufferRangeFunctionPointer);
        return Arr.Companion.wrap(byteBuffer);
    }

    public static final long glFenceSync(int condition, int flags) {
        return GL32.glFenceSync((int)condition, (int)flags).getPointer();
    }

    public static final void glDeleteSync(long sync) {
        pointerSetter.invokeExact(glSyncInstance, sync);
        GL32.glDeleteSync((GLSync)glSyncInstance);
    }

    public static final int glGetSynciv(long sync, int pname) {
        pointerSetter.invokeExact(glSyncInstance, sync);
        GL32.glGetSync((GLSync)glSyncInstance, (int)pname, (IntBuffer)lengthBuffer, (IntBuffer)valueBuffer);
        return valueBuffer.get(0);
    }

    public static final void glCompressedTextureSubImage2D(int texture, int level, int xOffset, int yOffset, int width, int height, int format, int imageSize, long data) {
        nglCompressedTextureSubImage2D.invokeExact(texture, level, xOffset, yOffset, width, height, format, imageSize, data, glCompressedTextureSubImage2DFunctionPointer);
    }

    public static final void glCompressedTextureSubImage2D--XwA0CU(int texture, int level, int xOffset, int yOffset, int width, int height, int format, int imageSize, long data) {
        nglCompressedTextureSubImage2D.invokeExact(texture, level, xOffset, yOffset, width, height, format, imageSize, data, glCompressedTextureSubImage2DFunctionPointer);
    }

    private static final long getFunctionAddress$lambda$3$lambda$2(MethodHandle $this_run, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $this_run.invokeExact(it);
    }

    static {
        boolean bl2 = false;
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Object object = theUnsafe.get(null);
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type sun.misc.Unsafe");
        unsafe = (Unsafe)object;
        boolean bl3 = false;
        Field trustedLookupField = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
        Object object2 = unsafe.getObject(unsafe.staticFieldBase(trustedLookupField), unsafe.staticFieldOffset(trustedLookupField));
        Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type java.lang.invoke.MethodHandles.Lookup");
        trustedLookUp = (MethodHandles.Lookup)object2;
        MethodHandle $this$getFunctionAddress_u24lambda_u243 = trustedLookUp.findStatic(GLContext.class, "getFunctionAddress", MethodType.methodType(Long.TYPE, String.class));
        boolean bl4 = false;
        getFunctionAddress = arg_0 -> GLFunctionsKt.getFunctionAddress$lambda$3$lambda$2($this$getFunctionAddress_u24lambda_u243, arg_0);
        Object object3 = new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE};
        nglNamedBufferSubData = trustedLookUp.findStatic(GL45.class, "nglNamedBufferSubData", MethodType.methodType(Void.TYPE, Integer.TYPE, object3));
        glNamedBufferSubDataFunctionPointer = ((Number)getFunctionAddress.invoke("glNamedBufferSubData")).longValue();
        object3 = new Class[]{Long.TYPE, Long.TYPE, Integer.TYPE, Long.TYPE};
        nglNamedBufferData = trustedLookUp.findStatic(GL45.class, "nglNamedBufferData", MethodType.methodType(Void.TYPE, Integer.TYPE, object3));
        glNamedBufferDataFunctionPointer = ((Number)getFunctionAddress.invoke("glNamedBufferData")).longValue();
        object3 = new Class[]{Long.TYPE, Long.TYPE, Integer.TYPE, Long.TYPE};
        nglNamedBufferStorage = trustedLookUp.findStatic(GL45.class, "nglNamedBufferStorage", MethodType.methodType(Void.TYPE, Integer.TYPE, object3));
        glNamedBufferStorageFunctionPointer = ((Number)getFunctionAddress.invoke("glNamedBufferStorage")).longValue();
        object3 = new Class[]{Integer.TYPE, Integer.TYPE, Long.TYPE, Long.TYPE};
        nglDrawElementsBOMethod = trustedLookUp.findStatic(GL11.class, "nglDrawElementsBO", MethodType.methodType(Void.TYPE, Integer.TYPE, object3));
        glDrawElementsFunctionPointer = ((Number)getFunctionAddress.invoke("glDrawElements")).longValue();
        object3 = new Class[]{Long.TYPE, Long.TYPE, Integer.TYPE, ByteBuffer.class, Long.TYPE};
        nglMapNamedBufferRange = trustedLookUp.findStatic(GL45.class, "nglMapNamedBufferRange", MethodType.methodType(ByteBuffer.class, Integer.TYPE, object3));
        glMapNamedBufferRangeFunctionPointer = ((Number)getFunctionAddress.invoke("glMapNamedBufferRange")).longValue();
        Object object4 = unsafe.allocateInstance(BufferUtils.getDIRECT_BYTE_BUFFER_CLASS());
        Intrinsics.checkNotNull(object4, "null cannot be cast to non-null type java.nio.ByteBuffer");
        dummyBuffer = (ByteBuffer)object4;
        Object object5 = unsafe.allocateInstance(GLSync.class);
        Intrinsics.checkNotNull(object5, "null cannot be cast to non-null type org.lwjgl.opengl.GLSync");
        glSyncInstance = (GLSync)object5;
        pointerSetter = trustedLookUp.findSetter(GLSync.class, "pointer", Long.TYPE);
        Object $this$lengthBuffer_u24lambda_u244 = object3 = BufferUtils.allocateInt(1);
        boolean bl5 = false;
        ((IntBuffer)$this$lengthBuffer_u24lambda_u244).put(1);
        ((Buffer)$this$lengthBuffer_u24lambda_u244).flip();
        lengthBuffer = object3;
        valueBuffer = BufferUtils.allocateInt(1);
        object3 = new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Long.TYPE, Long.TYPE};
        nglCompressedTextureSubImage2D = trustedLookUp.findStatic(GL45.class, "nglCompressedTextureSubImage2D", MethodType.methodType(Void.TYPE, Integer.TYPE, object3));
        glCompressedTextureSubImage2DFunctionPointer = ((Number)getFunctionAddress.invoke("glCompressedTextureSubImage2D")).longValue();
    }
}

