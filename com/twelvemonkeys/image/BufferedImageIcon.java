/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.image;

import com.twelvemonkeys.lang.Validate;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

public class BufferedImageIcon
implements Icon {
    private final BufferedImage image;
    private final int width;
    private final int height;
    private final boolean fast;

    public BufferedImageIcon(BufferedImage bufferedImage) {
        this(bufferedImage, bufferedImage != null ? bufferedImage.getWidth() : 0, bufferedImage != null ? bufferedImage.getHeight() : 0);
    }

    public BufferedImageIcon(BufferedImage bufferedImage, int n2, int n3) {
        this(bufferedImage, n2, n3, bufferedImage.getWidth() == n2 && bufferedImage.getHeight() == n3);
    }

    public BufferedImageIcon(BufferedImage bufferedImage, int n2, int n3, boolean bl2) {
        this.image = Validate.notNull(bufferedImage, "image");
        this.width = Validate.isTrue(n2 > 0, n2, "width must be positive: %d");
        this.height = Validate.isTrue(n3 > 0, n3, "height must be positive: %d");
        this.fast = bl2;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        if (this.fast || !(graphics instanceof Graphics2D)) {
            graphics.drawImage(this.image, n2, n3, this.width, this.height, null);
        } else {
            Graphics2D graphics2D = (Graphics2D)graphics;
            AffineTransform affineTransform = AffineTransform.getTranslateInstance(n2, n3);
            affineTransform.scale((double)this.width / (double)this.image.getWidth(), (double)this.height / (double)this.image.getHeight());
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics2D.drawImage(this.image, affineTransform, null);
        }
    }
}

