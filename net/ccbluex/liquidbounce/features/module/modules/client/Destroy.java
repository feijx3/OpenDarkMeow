/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.Display
 */
package net.ccbluex.liquidbounce.features.module.modules.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.injection.access.AccessorMinecraft;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.Display;

@ModuleInfo(name="Destroy", category=ModuleCategory.CLIENT, canEnable=false)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/client/Destroy;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "gameWindowValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "gameWindowTitleValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "gameWindowResetICONValue", "baritoneValue", "baritoneCancelAllTasksValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "systemGCValue", "onEnable", "", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nDestroy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Destroy.kt\nnet/ccbluex/liquidbounce/features/module/modules/client/Destroy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class Destroy
extends Module {
    @NotNull
    public static final Destroy INSTANCE;
    @NotNull
    private static final BoolValue gameWindowValue;
    @NotNull
    private static final TextValue gameWindowTitleValue;
    @NotNull
    private static final BoolValue gameWindowResetICONValue;
    @NotNull
    private static final BoolValue baritoneValue;
    @NotNull
    private static final Value<Boolean> baritoneCancelAllTasksValue;
    @NotNull
    private static final BoolValue systemGCValue;

    private Destroy() {
        super(null, null, null, null, 15, null);
    }

    @Override
    public void onEnable() {
        if (((Boolean)gameWindowValue.get()).booleanValue()) {
            Display.setTitle((String)((String)gameWindowTitleValue.get()));
        }
        if (((Boolean)baritoneValue.get()).booleanValue() && baritoneCancelAllTasksValue.get().booleanValue()) {
            DarkMeow.INSTANCE.getBaritoneManager().cancelEverything();
        }
        DarkMeow.INSTANCE.destroyClient((Boolean)systemGCValue.get());
        if (gameWindowResetICONValue.getState()) {
            Minecraft minecraft = MinecraftInstance.mc_nowarp;
            Intrinsics.checkNotNull(minecraft, "null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.access.AccessorMinecraft");
            ((AccessorMinecraft)minecraft).darkMeow_setWindowIcon();
        }
    }

    private static final boolean baritoneCancelAllTasksValue$lambda$2() {
        return (Boolean)baritoneValue.get();
    }

    static {
        Value value;
        INSTANCE = new Destroy();
        gameWindowValue = new BoolValue("GameWindow", true);
        TextValue it = value = new TextValue("GameWindowTitle", "Minecraft 1.12.2");
        boolean bl2 = false;
        it.setSuperValue(gameWindowValue);
        gameWindowTitleValue = value;
        it = value = new BoolValue("GameWindowResetICON", true);
        boolean bl3 = false;
        it.setSuperValue(gameWindowValue);
        gameWindowResetICONValue = value;
        baritoneValue = new BoolValue("Baritone", false);
        baritoneCancelAllTasksValue = new BoolValue("BaritoneCancelAllTasks", false).displayable(Destroy::baritoneCancelAllTasksValue$lambda$2);
        systemGCValue = new BoolValue("SystemGC", false);
    }
}

