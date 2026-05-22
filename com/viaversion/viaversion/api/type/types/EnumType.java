/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.util.MathUtil;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={1.class, Fallback.class})
public final class EnumType
extends VarIntType {
    private final String[] names;
    private final Fallback fallback;

    public EnumType(String ... names) {
        this(Fallback.ZERO, names);
    }

    public EnumType(Fallback fallback, String ... names) {
        this.names = names;
        this.fallback = fallback;
    }

    @Override
    public void write(Ops ops, Integer value) {
        String name;
        if (value < 0 || value >= this.names.length) {
            String string;
            switch (this.fallback) {
                default: {
                    throw new IncompatibleClassChangeError();
                }
                case ZERO: {
                    string = this.names[0];
                    break;
                }
                case WRAP: {
                    string = this.names[Math.floorMod(value, this.names.length)];
                    break;
                }
                case CLAMP: {
                    string = this.names[MathUtil.clamp(value, 0, this.names.length - 1)];
                }
            }
            name = string;
        } else {
            name = this.names[value];
        }
        Types.STRING.write(ops, name);
    }

    public String[] names() {
        return this.names;
    }

    @NestHost(value=EnumType.class)
    public static enum Fallback {
        ZERO,
        WRAP,
        CLAMP;

    }
}

