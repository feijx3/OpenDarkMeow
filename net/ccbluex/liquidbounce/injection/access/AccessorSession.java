/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Session
 *  net.minecraft.util.Session$Type
 */
package net.ccbluex.liquidbounce.injection.access;

import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Session.class})
public interface AccessorSession {
    @Accessor(value="username")
    public String func_111285_a();

    @Accessor(value="playerID")
    public String func_148255_b();

    @Accessor(value="token")
    public String func_148254_d();

    @Accessor(value="sessionType")
    public Session.Type getSessionType();
}

