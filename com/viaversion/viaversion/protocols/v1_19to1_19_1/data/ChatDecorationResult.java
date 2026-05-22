/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_19to1_19_1.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.libs.gson.JsonElement;
import java.util.Arrays;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="content", type=JsonElement.class), @RecordComponents.Value(name="overlay", type=boolean.class)})
public final class ChatDecorationResult
extends J_L_Record {
    private final JsonElement content;
    private final boolean overlay;

    public ChatDecorationResult(JsonElement content, boolean overlay) {
        this.content = content;
        this.overlay = overlay;
    }

    @Override
    public final String toString() {
        return ChatDecorationResult.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return ChatDecorationResult.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return ChatDecorationResult.jvmdowngrader$equals$equals(this, o2);
    }

    public JsonElement content() {
        return this.content;
    }

    public boolean overlay() {
        return this.overlay;
    }

    private static String jvmdowngrader$toString$toString(ChatDecorationResult chatDecorationResult) {
        ChatDecorationResult chatDecorationResult2 = chatDecorationResult;
        return "ChatDecorationResult[" + "content=" + chatDecorationResult.content + ", " + "overlay=" + chatDecorationResult.overlay + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(ChatDecorationResult chatDecorationResult) {
        Object[] objectArray = new Object[]{chatDecorationResult.content, chatDecorationResult.overlay};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(ChatDecorationResult chatDecorationResult, Object object) {
        if (chatDecorationResult == object) {
            return true;
        }
        if (object != null && object instanceof ChatDecorationResult) {
            ChatDecorationResult chatDecorationResult2 = (ChatDecorationResult)object;
            if (Objects.equals(chatDecorationResult.content, chatDecorationResult2.content) && chatDecorationResult.overlay == chatDecorationResult2.overlay) {
                return true;
            }
        }
        return false;
    }
}

