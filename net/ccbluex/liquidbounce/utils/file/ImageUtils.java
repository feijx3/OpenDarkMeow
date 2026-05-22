/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.file;

import com.twelvemonkeys.imageio.plugins.webp.WebPImageReaderSpi;
import com.twelvemonkeys.imageio.stream.BufferedFileImageInputStreamSpi;
import com.twelvemonkeys.imageio.stream.BufferedInputStreamImageInputStreamSpi;
import com.twelvemonkeys.imageio.stream.BufferedRAFImageInputStreamSpi;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.imageio.spi.IIORegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/utils/file/ImageUtils;", "", "<init>", "()V", "convertWebPToPNG", "", "stream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "DarkMeow"})
public final class ImageUtils {
    @NotNull
    public static final ImageUtils INSTANCE = new ImageUtils();

    private ImageUtils() {
    }

    public final void convertWebPToPNG(@NotNull InputStream stream, @NotNull OutputStream outputStream) {
        block0: {
            BufferedImage bufferedImage;
            Intrinsics.checkNotNullParameter(stream, "stream");
            Intrinsics.checkNotNullParameter(outputStream, "outputStream");
            BufferedImage bufferedImage2 = ImageIO.read(stream);
            if (bufferedImage2 == null) break block0;
            BufferedImage image2 = bufferedImage = bufferedImage2;
            boolean bl2 = false;
            ImageIO.write((RenderedImage)image2, "png", outputStream);
        }
    }

    static {
        IIORegistry.getDefaultInstance().registerServiceProvider(new BufferedFileImageInputStreamSpi());
        IIORegistry.getDefaultInstance().registerServiceProvider(new BufferedInputStreamImageInputStreamSpi());
        IIORegistry.getDefaultInstance().registerServiceProvider(new BufferedRAFImageInputStreamSpi());
        IIORegistry.getDefaultInstance().registerServiceProvider(new WebPImageReaderSpi());
    }
}

