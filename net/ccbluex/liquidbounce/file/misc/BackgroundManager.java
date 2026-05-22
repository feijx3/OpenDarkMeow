/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.file.misc;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.file.FileManager;
import net.ccbluex.liquidbounce.utils.file.FileUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\r\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u0014"}, d2={"Lnet/ccbluex/liquidbounce/file/misc/BackgroundManager;", "", "instance", "Lnet/ccbluex/liquidbounce/file/FileManager;", "<init>", "(Lnet/ccbluex/liquidbounce/file/FileManager;)V", "getInstance", "()Lnet/ccbluex/liquidbounce/file/FileManager;", "textureId", "", "Ljava/lang/Integer;", "getBackgroundTextureId", "()Ljava/lang/Integer;", "doRender", "", "reloadBackground", "unloadBackground", "()Lkotlin/Unit;", "resetBackground", "Ljava/io/FileOutputStream;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nBackgroundManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BackgroundManager.kt\nnet/ccbluex/liquidbounce/file/misc/BackgroundManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
public final class BackgroundManager {
    @NotNull
    private final FileManager instance;
    @Nullable
    private Integer textureId;

    public BackgroundManager(@NotNull FileManager instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.instance = instance;
    }

    @NotNull
    public final FileManager getInstance() {
        return this.instance;
    }

    @Nullable
    public final Integer getBackgroundTextureId() {
        return this.textureId;
    }

    public final void doRender() {
        Integer n2 = this.textureId;
        if (n2 != null) {
            int it = ((Number)n2).intValue();
            boolean bl2 = false;
            GlStateManager.func_179144_i((int)it);
        }
        GlStateManager.func_179117_G();
    }

    public final void reloadBackground() {
        try {
            if (!this.instance.getBackgroundFile().exists() || this.instance.getBackgroundFile().isDirectory()) {
                this.resetBackground();
            }
            BufferedImage bufferedImage = ImageIO.read(this.instance.getBackgroundFile());
            int id = TextureUtil.func_110996_a();
            this.unloadBackground();
            TextureUtil.func_110987_a((int)id, (BufferedImage)bufferedImage);
            this.textureId = id;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Nullable
    public final Unit unloadBackground() {
        Unit unit;
        Unit unit2;
        Integer n2 = this.textureId;
        if (n2 != null) {
            int it = ((Number)n2).intValue();
            boolean bl2 = false;
            GlStateManager.func_179150_h((int)it);
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        Unit it = unit = unit2;
        boolean bl3 = false;
        this.textureId = null;
        return unit;
    }

    @NotNull
    public final FileOutputStream resetBackground() {
        return FileUtils.INSTANCE.unpackResourceFileWebpToPng("assets/minecraft/darkmeow/background.webp", this.instance.getBackgroundFile());
    }
}

