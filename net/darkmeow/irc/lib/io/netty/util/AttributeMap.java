/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util;

import net.darkmeow.irc.lib.io.netty.util.Attribute;
import net.darkmeow.irc.lib.io.netty.util.AttributeKey;

public interface AttributeMap {
    public <T> Attribute<T> attr(AttributeKey<T> var1);

    public <T> boolean hasAttr(AttributeKey<T> var1);
}

