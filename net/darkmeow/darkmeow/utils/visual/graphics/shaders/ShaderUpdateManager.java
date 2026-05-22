/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL20
 */
package net.darkmeow.darkmeow.utils.visual.graphics.shaders;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.event.events.tick.TickEvent;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.ListenableOwnerExtends;
import net.darkmeow.darkmeow.event.ListenableOwnerStaticStorage;
import net.darkmeow.darkmeow.event.hook.EventHookOwnerCheck;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.AbstractShader;
import net.darkmeow.darkmeow.utils.visual.graphics.shaders.impl.WindowBlurShader;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL20;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J'\u0010\r\u001a\u00020\u000e*\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0012J'\u0010\u0013\u001a\u00020\u000e*\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0012R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/ShaderUpdateManager;", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "<init>", "()V", "shaders", "", "Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader;", "[Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/impl/WindowBlurShader;", "disable", "", "prevWindowWidth", "", "prevWindowHeight", "initialization", "", "Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/AbstractShader;", "width", "height", "([Lnet/darkmeow/darkmeow/utils/visual/graphics/shaders/AbstractShader;II)V", "update", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nShaderUpdateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShaderUpdateManager.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/ShaderUpdateManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ListenableOwnerExtends.kt\nnet/darkmeow/darkmeow/event/ListenableOwnerExtends\n*L\n1#1,41:1\n13472#2,2:42\n13472#2,2:44\n12#3,3:46\n*S KotlinDebug\n*F\n+ 1 ShaderUpdateManager.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/shaders/ShaderUpdateManager\n*L\n38#1:42,2\n39#1:44,2\n24#1:46,3\n*E\n"})
public final class ShaderUpdateManager
implements ListenableOwner {
    @NotNull
    public static final ShaderUpdateManager INSTANCE;
    @JvmField
    @NotNull
    public static final WindowBlurShader[] shaders;
    @JvmField
    public static boolean disable;
    private static int prevWindowWidth;
    private static int prevWindowHeight;

    private ShaderUpdateManager() {
    }

    public final void initialization(@NotNull AbstractShader[] $this$initialization, int width, int height) {
        Intrinsics.checkNotNullParameter($this$initialization, "<this>");
        AbstractShader[] $this$forEach$iv = $this$initialization;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            AbstractShader element$iv;
            AbstractShader it = element$iv = $this$forEach$iv[i2];
            boolean bl2 = false;
            it.updateResolution(width, height);
        }
    }

    public final void update(@NotNull AbstractShader[] $this$update, int width, int height) {
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        AbstractShader[] $this$forEach$iv = $this$update;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            AbstractShader element$iv;
            AbstractShader it = element$iv = $this$forEach$iv[i2];
            boolean bl2 = false;
            it.updateResolution(width, height);
        }
    }

    private static final Unit _init_$lambda$0(ListenerBase $this$listener, TickEvent.Post it) {
        Intrinsics.checkNotNullParameter($this$listener, "$this$listener");
        Intrinsics.checkNotNullParameter(it, "it");
        if (disable) {
            return Unit.INSTANCE;
        }
        if (prevWindowWidth != $this$listener.getMc().field_71443_c || prevWindowHeight != $this$listener.getMc().field_71440_d) {
            if (prevWindowWidth == -1 && prevWindowHeight == -1) {
                INSTANCE.initialization(shaders, $this$listener.getMc().field_71443_c, $this$listener.getMc().field_71440_d);
            }
            INSTANCE.update(shaders, $this$listener.getMc().field_71443_c, $this$listener.getMc().field_71440_d);
            GL20.glUseProgram((int)0);
            prevWindowWidth = $this$listener.getMc().field_71443_c;
            prevWindowHeight = $this$listener.getMc().field_71440_d;
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void $receiver$iv;
        INSTANCE = new ShaderUpdateManager();
        Object object = new WindowBlurShader[]{WindowBlurShader.INSTANCE};
        shaders = object;
        prevWindowWidth = -1;
        prevWindowHeight = -1;
        object = ListenableOwnerExtends.INSTANCE;
        ListenableOwner listenableOwner = INSTANCE;
        Function2<ListenerBase, TickEvent.Post, Unit> function$iv = ShaderUpdateManager::_init_$lambda$0;
        int priority$iv = 0;
        boolean $i$f$listener = false;
        ListenableOwnerStaticStorage.INSTANCE.get((ListenableOwner)$receiver$iv).add(new EventHookOwnerCheck<TickEvent.Post>(priority$iv, function$iv, Reflection.getOrCreateKotlinClass(TickEvent.Post.class), (ListenableOwner)$receiver$iv));
    }
}

