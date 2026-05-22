/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.darkmeow.utils.visual.graphics;

import kotlin.Metadata;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\n\u00c0\u0006\u0001"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/GLObject;", "", "id", "", "getId", "()I", "bind", "", "unbind", "destroy", "DarkMeow"})
public interface GLObject {
    public int getId();

    public void bind();

    public void unbind();

    public void destroy();
}

