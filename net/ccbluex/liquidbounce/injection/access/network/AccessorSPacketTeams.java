/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketTeams
 */
package net.ccbluex.liquidbounce.injection.access.network;

import java.util.Collection;
import net.minecraft.network.play.server.SPacketTeams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketTeams.class})
public interface AccessorSPacketTeams {
    @Accessor(value="name")
    public String func_149312_c();

    @Accessor(value="name")
    public void setName(String var1);

    @Accessor(value="displayName")
    public String func_149306_d();

    @Accessor(value="displayName")
    public void setDisplayName(String var1);

    @Accessor(value="prefix")
    public String func_149311_e();

    @Accessor(value="prefix")
    public void setPrefix(String var1);

    @Accessor(value="suffix")
    public String func_149309_f();

    @Accessor(value="suffix")
    public void setSuffix(String var1);

    @Accessor(value="nameTagVisibility")
    public String func_179814_i();

    @Accessor(value="nameTagVisibility")
    public void setNameTagVisibility(String var1);

    @Accessor(value="collisionRule")
    public String func_186975_j();

    @Accessor(value="collisionRule")
    public void setCollisionRule(String var1);

    @Accessor(value="color")
    public int func_179813_h();

    @Accessor(value="color")
    public void setColor(int var1);

    @Accessor(value="players")
    public Collection<String> func_149310_g();

    @Accessor(value="action")
    public int func_149307_h();

    @Accessor(value="action")
    public void setAction(int var1);

    @Accessor(value="friendlyFlags")
    public int func_149308_i();

    @Accessor(value="friendlyFlags")
    public void setFriendlyFlags(int var1);
}

