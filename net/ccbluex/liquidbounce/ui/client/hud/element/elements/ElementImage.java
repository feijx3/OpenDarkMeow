/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.client.renderer.texture.ITextureObject
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import com.google.gson.JsonElement;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import javax.imageio.ImageIO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.utils.misc.MiscUtils;
import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0012H\u0002J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementImage;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "<init>", "()V", "image", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "width", "", "height", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "createElement", "", "setImage", "", "Ljava/io/File;", "Companion", "DarkMeow"})
public final class ElementImage
extends Element {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TextValue image = new TextValue(this){
        final /* synthetic */ ElementImage this$0;
        {
            this.this$0 = $receiver;
            super("Image", "");
        }

        public void fromJson(JsonElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            super.fromJson(element);
            if (((CharSequence)this.get()).length() == 0) {
                return;
            }
            ElementImage.access$setImage(this.this$0, (String)this.get());
        }

        protected void onChanged(String oldValue, String newValue) {
            Intrinsics.checkNotNullParameter(oldValue, "oldValue");
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            if (((CharSequence)this.get()).length() == 0) {
                return;
            }
            ElementImage.access$setImage(this.this$0, (String)this.get());
        }
    };
    @NotNull
    private final ResourceLocation resourceLocation = new ResourceLocation(RandomUtils.INSTANCE.randomNumber(128));
    private int width = 64;
    private int height = 64;

    public ElementImage() {
        super("Image", 0.0, 0.0, 0.0f, null, 0, 62, null);
    }

    @Override
    @NotNull
    public ElementBorder drawElement(float partialTicks) {
        RenderUtils.drawImage(this.resourceLocation, 0, 0, this.width / 2, this.height / 2);
        return new ElementBorder(0.0f, 0.0f, (float)this.width / 2.0f, (float)this.height / 2.0f);
    }

    @Override
    public boolean createElement() {
        File file = MiscUtils.openFileChooser();
        if (file == null) {
            return false;
        }
        File file2 = file;
        if (!file2.exists()) {
            MiscUtils.showErrorPopup("Error", "The file does not exist.");
            return false;
        }
        if (file2.isDirectory()) {
            MiscUtils.showErrorPopup("Error", "The file is a directory.");
            return false;
        }
        this.setImage(file2);
        return true;
    }

    private final ElementImage setImage(String image2) {
        try {
            this.image.changeValue(image2);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(image2));
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            byteArrayInputStream.close();
            this.width = bufferedImage.getWidth();
            this.height = bufferedImage.getHeight();
            MinecraftInstance.mc.getTextureManager().func_110579_a(this.resourceLocation, (ITextureObject)new DynamicTexture(bufferedImage));
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final ElementImage setImage(@NotNull File image2) {
        Intrinsics.checkNotNullParameter(image2, "image");
        try {
            String string = Base64.getEncoder().encodeToString(Files.readAllBytes(image2.toPath()));
            Intrinsics.checkNotNullExpressionValue(string, "encodeToString(...)");
            this.setImage(string);
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public static final /* synthetic */ ElementImage access$setImage(ElementImage $this, String image2) {
        return $this.setImage(image2);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementImage$Companion;", "", "<init>", "()V", "default", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementImage;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ElementImage default() {
            ElementImage image2 = new ElementImage();
            image2.setX(0.0);
            image2.setY(0.0);
            return image2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

