/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.StringType;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import io.netty.buffer.ByteBuf;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={OptionalComponentType.class})
public class ComponentType
extends Type<JsonElement> {
    private static final StringType STRING_TAG = new StringType(262144);

    public ComponentType() {
        super(JsonElement.class);
    }

    @Override
    public JsonElement read(ByteBuf buffer) {
        String s2 = STRING_TAG.read(buffer);
        try {
            return JsonParser.parseString(s2);
        }
        catch (JsonSyntaxException e2) {
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().severe(ComponentType.jvmdowngrader$concat$read$1(s2));
            }
            throw e2;
        }
    }

    @Override
    public void write(ByteBuf buffer, JsonElement object) {
        STRING_TAG.write(buffer, object.toString());
    }

    private static String jvmdowngrader$concat$read$1(String string) {
        return "Error when trying to parse json: " + string;
    }

    @NestHost(value=ComponentType.class)
    public static final class OptionalComponentType
    extends OptionalType<JsonElement> {
        public OptionalComponentType() {
            super(Types.COMPONENT);
        }
    }
}

