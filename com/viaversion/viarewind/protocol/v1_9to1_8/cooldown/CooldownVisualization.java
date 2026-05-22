/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.cooldown;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.ViaRewindConfig;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.ActionBarVisualization;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.BossBarVisualization;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.DisabledCooldownVisualization;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.TitleCooldownVisualization;
import com.viaversion.viaversion.api.connection.UserConnection;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class, Factory.class})
public interface CooldownVisualization {
    public static final int MAX_PROGRESS_TEXT_LENGTH = 10;

    public void show(double var1) throws Exception;

    public void hide() throws Exception;

    public static String buildProgressText(String symbol, double cooldown) {
        int green = (int)Math.floor(10.0 * cooldown);
        int grey = 10 - green;
        StringBuilder builder = new StringBuilder("\u00a78");
        while (green-- > 0) {
            builder.append(symbol);
        }
        builder.append("\u00a77");
        while (grey-- > 0) {
            builder.append(symbol);
        }
        return builder.toString();
    }

    @NestHost(value=CooldownVisualization.class)
    public static interface Factory {
        public static final Factory DISABLED = user -> new DisabledCooldownVisualization();

        public CooldownVisualization create(UserConnection var1);

        public static Factory fromConfiguration() {
            try {
                return Factory.fromIndicator(ViaRewind.getConfig().getCooldownIndicator());
            }
            catch (IllegalArgumentException e2) {
                ViaRewind.getPlatform().getLogger().warning("Invalid cooldown-indicator setting");
                return DISABLED;
            }
        }

        public static Factory fromIndicator(ViaRewindConfig.CooldownIndicator indicator) {
            Factory factory;
            switch (indicator) {
                default: {
                    throw new IncompatibleClassChangeError();
                }
                case TITLE: {
                    factory = TitleCooldownVisualization::new;
                    break;
                }
                case BOSS_BAR: {
                    factory = BossBarVisualization::new;
                    break;
                }
                case ACTION_BAR: {
                    factory = ActionBarVisualization::new;
                    break;
                }
                case DISABLED: {
                    factory = DISABLED;
                }
            }
            return factory;
        }
    }
}

