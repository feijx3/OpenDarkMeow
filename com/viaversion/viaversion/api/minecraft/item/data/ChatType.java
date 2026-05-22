/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="chatDecoration", type=ChatTypeDecoration.class), @RecordComponents.Value(name="narrationDecoration", type=ChatTypeDecoration.class)})
@NestMembers(value={ChatTypeDecoration.class, ChatTypeDecoration.1.class, 1.class})
public final class ChatType
extends J_L_Record
implements Copyable {
    private final ChatTypeDecoration chatDecoration;
    private final ChatTypeDecoration narrationDecoration;
    public static final HolderType<ChatType> TYPE = new HolderType<ChatType>(){

        @Override
        public ChatType readDirect(ByteBuf buffer) {
            ChatTypeDecoration chatDecoration = (ChatTypeDecoration)ChatTypeDecoration.TYPE.read(buffer);
            ChatTypeDecoration narrationDecoration = (ChatTypeDecoration)ChatTypeDecoration.TYPE.read(buffer);
            return new ChatType(chatDecoration, narrationDecoration);
        }

        @Override
        public void writeDirect(ByteBuf buffer, ChatType value) {
            ChatTypeDecoration.TYPE.write(buffer, value.chatDecoration());
            ChatTypeDecoration.TYPE.write(buffer, value.narrationDecoration());
        }
    };

    public ChatType(ChatTypeDecoration chatDecoration, ChatTypeDecoration narrationDecoration) {
        this.chatDecoration = chatDecoration;
        this.narrationDecoration = narrationDecoration;
    }

    @Override
    public ChatType copy() {
        return new ChatType(this.chatDecoration.copy(), this.narrationDecoration.copy());
    }

    @Override
    public final String toString() {
        return ChatType.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ChatType.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ChatType.jvmdowngrader$equals$equals(this, o2);
    }

    public ChatTypeDecoration chatDecoration() {
        return this.chatDecoration;
    }

    public ChatTypeDecoration narrationDecoration() {
        return this.narrationDecoration;
    }

    private static String jvmdowngrader$toString$toString(ChatType chatType) {
        ChatType chatType2 = chatType;
        return "ChatType[" + "chatDecoration=" + chatType.chatDecoration + ", " + "narrationDecoration=" + chatType.narrationDecoration + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ChatType chatType) {
        Object[] objectArray = new Object[]{chatType.chatDecoration, chatType.narrationDecoration};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ChatType chatType, Object object) {
        if (chatType == object) {
            return true;
        }
        if (object != null && object instanceof ChatType) {
            ChatType chatType2 = (ChatType)object;
            if (Objects.equals(chatType.chatDecoration, chatType2.chatDecoration) && Objects.equals(chatType.narrationDecoration, chatType2.narrationDecoration)) {
                return true;
            }
        }
        return false;
    }

    @RecordComponents(value={@RecordComponents.Value(name="translationKey", type=String.class), @RecordComponents.Value(name="parameters", type=int[].class), @RecordComponents.Value(name="style", type=Tag.class)})
    @NestHost(value=ChatType.class)
    public static final class ChatTypeDecoration
    extends J_L_Record
    implements Copyable {
        private final String translationKey;
        private final int[] parameters;
        private final Tag style;
        public static final Type<ChatTypeDecoration> TYPE = new Type<ChatTypeDecoration>(ChatTypeDecoration.class){

            @Override
            public ChatTypeDecoration read(ByteBuf buffer) {
                String translationKey = (String)Types.STRING.read(buffer);
                int[] parameters = (int[])Types.INT_ARRAY_PRIMITIVE.read(buffer);
                Tag style = (Tag)Types.TAG.read(buffer);
                return new ChatTypeDecoration(translationKey, parameters, style);
            }

            @Override
            public void write(ByteBuf buffer, ChatTypeDecoration value) {
                Types.STRING.write(buffer, value.translationKey());
                Types.INT_ARRAY_PRIMITIVE.write(buffer, value.parameters());
                Types.TAG.write(buffer, value.style());
            }
        };

        public ChatTypeDecoration(String translationKey, int[] parameters, Tag style) {
            this.translationKey = translationKey;
            this.parameters = parameters;
            this.style = style;
        }

        @Override
        public ChatTypeDecoration copy() {
            return new ChatTypeDecoration(this.translationKey, (int[])this.parameters.clone(), this.style.copy());
        }

        @Override
        public final String toString() {
            return ChatTypeDecoration.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ChatTypeDecoration.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ChatTypeDecoration.jvmdowngrader$equals$equals(this, o2);
        }

        public String translationKey() {
            return this.translationKey;
        }

        public int[] parameters() {
            return this.parameters;
        }

        public Tag style() {
            return this.style;
        }

        private static String jvmdowngrader$toString$toString(ChatTypeDecoration chatTypeDecoration) {
            ChatTypeDecoration chatTypeDecoration2 = chatTypeDecoration;
            return "ChatType$ChatTypeDecoration[" + "translationKey=" + chatTypeDecoration.translationKey + ", " + "parameters=" + chatTypeDecoration.parameters + ", " + "style=" + chatTypeDecoration.style + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ChatTypeDecoration chatTypeDecoration) {
            Object[] objectArray = new Object[]{chatTypeDecoration.translationKey, chatTypeDecoration.parameters, chatTypeDecoration.style};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ChatTypeDecoration chatTypeDecoration, Object object) {
            if (chatTypeDecoration == object) {
                return true;
            }
            if (object != null && object instanceof ChatTypeDecoration) {
                ChatTypeDecoration chatTypeDecoration2 = (ChatTypeDecoration)object;
                if (Objects.equals(chatTypeDecoration.translationKey, chatTypeDecoration2.translationKey) && Objects.equals(chatTypeDecoration.parameters, chatTypeDecoration2.parameters) && Objects.equals(chatTypeDecoration.style, chatTypeDecoration2.style)) {
                    return true;
                }
            }
            return false;
        }
    }
}

