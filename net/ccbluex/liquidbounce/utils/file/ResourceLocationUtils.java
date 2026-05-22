/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import javax.imageio.ImageIO;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\t2\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/utils/file/ResourceLocationUtils;", "", "<init>", "()V", "toResourceLocation", "Lnet/minecraft/util/ResourceLocation;", "Ljava/io/File;", "namespace", "", "Ljava/io/InputStream;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nResourceLocationUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceLocationUtils.kt\nnet/ccbluex/liquidbounce/utils/file/ResourceLocationUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public final class ResourceLocationUtils {
    @NotNull
    public static final ResourceLocationUtils INSTANCE = new ResourceLocationUtils();

    private ResourceLocationUtils() {
    }

    @JvmOverloads
    @Nullable
    public final ResourceLocation toResourceLocation(@NotNull File $this$toResourceLocation, @NotNull String namespace) {
        ResourceLocation resourceLocation;
        File file;
        File file2;
        Intrinsics.checkNotNullParameter($this$toResourceLocation, "<this>");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        File it = file2 = $this$toResourceLocation;
        boolean bl2 = false;
        File file3 = file = it.exists() ? file2 : null;
        if (file != null) {
            ResourceLocation resourceLocation2;
            it = file;
            boolean bl3 = false;
            try {
                resourceLocation2 = INSTANCE.toResourceLocation(new FileInputStream(it), namespace);
            }
            catch (Throwable throwable) {
                resourceLocation2 = null;
            }
            resourceLocation = resourceLocation2;
        } else {
            resourceLocation = null;
        }
        return resourceLocation;
    }

    public static /* synthetic */ ResourceLocation toResourceLocation$default(ResourceLocationUtils resourceLocationUtils, File file, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = DarkMeow.INSTANCE.getCLIENT_NAME().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
            string = stringBuilder.append(string2).append(':').append(file.getName()).toString();
        }
        return resourceLocationUtils.toResourceLocation(file, string);
    }

    @Nullable
    public final ResourceLocation toResourceLocation(@NotNull InputStream $this$toResourceLocation, @NotNull String namespace) {
        Intrinsics.checkNotNullParameter($this$toResourceLocation, "<this>");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        return MinecraftInstance.mc.getTextureManager().func_110578_a(namespace, new DynamicTexture(ImageIO.read($this$toResourceLocation)));
    }

    @JvmOverloads
    @Nullable
    public final ResourceLocation toResourceLocation(@NotNull File $this$toResourceLocation) {
        Intrinsics.checkNotNullParameter($this$toResourceLocation, "<this>");
        return ResourceLocationUtils.toResourceLocation$default(this, $this$toResourceLocation, null, 1, null);
    }
}

