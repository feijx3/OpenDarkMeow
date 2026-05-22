/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={ChatSession.class})
public final class AcknowledgedMessagesStorage
implements StorableObject {
    private static final int MAX_HISTORY = 20;
    private static final int MINIMUM_DELAYED_ACK_COUNT = 20;
    private static final BitSet DUMMY_LAST_SEEN_MESSAGES = new BitSet();
    private Boolean secureChatEnforced;
    private ChatSession chatSession;
    private BitSet lastSeenMessages = new BitSet();
    private int delayedAckCount;

    public int updateFromMessage(int ackCount, BitSet lastSeenMessages) {
        int delayedAckCount = this.delayedAckCount;
        this.delayedAckCount = 0;
        this.lastSeenMessages = lastSeenMessages;
        return ackCount + delayedAckCount;
    }

    public int accumulateAckCount(int ackCount) {
        this.delayedAckCount += ackCount;
        int ackCountToForward = this.delayedAckCount - 20;
        if (ackCountToForward >= 20) {
            this.lastSeenMessages = DUMMY_LAST_SEEN_MESSAGES;
            this.delayedAckCount = 20;
            return ackCountToForward;
        }
        return 0;
    }

    public BitSet createSpoofedAck() {
        return this.lastSeenMessages;
    }

    public void setSecureChatEnforced(boolean secureChatEnforced) {
        this.secureChatEnforced = secureChatEnforced;
    }

    public @Nullable Boolean secureChatEnforced() {
        return this.secureChatEnforced;
    }

    public boolean isSecureChatEnforced() {
        return this.secureChatEnforced == null || this.secureChatEnforced != false;
    }

    public void queueChatSession(UUID sessionId, ProfileKey profileKey) {
        this.chatSession = new ChatSession(sessionId, profileKey);
    }

    public void sendQueuedChatSession(PacketWrapper wrapper) {
        if (this.chatSession == null) {
            return;
        }
        PacketWrapper chatSessionUpdate = wrapper.create(ServerboundPackets1_20_3.CHAT_SESSION_UPDATE);
        chatSessionUpdate.write(Types.UUID, this.chatSession.sessionId());
        chatSessionUpdate.write(Types.PROFILE_KEY, this.chatSession.profileKey());
        chatSessionUpdate.sendToServer(Protocol1_20_3To1_20_5.class);
        this.chatSession = null;
    }

    public void clear() {
        this.lastSeenMessages = new BitSet();
        this.delayedAckCount = 0;
    }

    @RecordComponents(value={@RecordComponents.Value(name="sessionId", type=UUID.class), @RecordComponents.Value(name="profileKey", type=ProfileKey.class)})
    @NestHost(value=AcknowledgedMessagesStorage.class)
    public static final class ChatSession
    extends J_L_Record {
        private final UUID sessionId;
        private final ProfileKey profileKey;

        public ChatSession(UUID sessionId, ProfileKey profileKey) {
            this.sessionId = sessionId;
            this.profileKey = profileKey;
        }

        @Override
        public final String toString() {
            return ChatSession.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return ChatSession.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return ChatSession.jvmdowngrader$equals$equals(this, o2);
        }

        public UUID sessionId() {
            return this.sessionId;
        }

        public ProfileKey profileKey() {
            return this.profileKey;
        }

        private static String jvmdowngrader$toString$toString(ChatSession chatSession) {
            ChatSession chatSession2 = chatSession;
            return "AcknowledgedMessagesStorage$ChatSession[" + "sessionId=" + chatSession.sessionId + ", " + "profileKey=" + chatSession.profileKey + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(ChatSession chatSession) {
            Object[] objectArray = new Object[]{chatSession.sessionId, chatSession.profileKey};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(ChatSession chatSession, Object object) {
            if (chatSession == object) {
                return true;
            }
            if (object != null && object instanceof ChatSession) {
                ChatSession chatSession2 = (ChatSession)object;
                if (Objects.equals(chatSession.sessionId, chatSession2.sessionId) && Objects.equals(chatSession.profileKey, chatSession2.profileKey)) {
                    return true;
                }
            }
            return false;
        }
    }
}

