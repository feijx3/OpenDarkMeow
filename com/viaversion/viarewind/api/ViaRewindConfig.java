/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viarewind.api;

import com.viaversion.viaversion.api.configuration.Config;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={CooldownIndicator.class})
public interface ViaRewindConfig
extends Config {
    public CooldownIndicator getCooldownIndicator();

    public boolean isReplaceAdventureMode();

    public boolean isReplaceParticles();

    public int getMaxBookPages();

    public int getMaxBookPageSize();

    public boolean isEmulateWorldBorder();

    public boolean alwaysShowOriginalMobName();

    public String getWorldBorderParticle();

    public boolean isEnableOffhand();

    public String getOffhandCommand();

    public boolean emulateLevitationEffect();

    public boolean handlePlayerCombatPacket();

    @NestHost(value=ViaRewindConfig.class)
    public static enum CooldownIndicator {
        TITLE,
        ACTION_BAR,
        BOSS_BAR,
        DISABLED;

    }
}

