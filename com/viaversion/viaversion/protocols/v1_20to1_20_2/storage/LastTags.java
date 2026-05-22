/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.storage;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.TagData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@NestMembers(value={RegistryTags.class})
public class LastTags
implements StorableObject {
    private final List<RegistryTags> registryTags = new ArrayList<RegistryTags>();
    private boolean sentDuringConfigPhase;

    public LastTags(PacketWrapper wrapper) {
        int length = wrapper.passthrough(Types.VAR_INT);
        for (int i2 = 0; i2 < length; ++i2) {
            ArrayList<TagData> tags = new ArrayList<TagData>();
            String registryKey = wrapper.passthrough(Types.STRING);
            int tagsSize = wrapper.passthrough(Types.VAR_INT);
            for (int j2 = 0; j2 < tagsSize; ++j2) {
                String key = wrapper.passthrough(Types.STRING);
                int[] ids = wrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                tags.add(new TagData(key, ids));
            }
            this.registryTags.add(new RegistryTags(registryKey, tags));
        }
    }

    public void sendLastTags(UserConnection connection) {
        if (this.registryTags.isEmpty()) {
            return;
        }
        PacketWrapper packet = PacketWrapper.create(ClientboundConfigurationPackets1_20_2.UPDATE_TAGS, connection);
        packet.write(Types.VAR_INT, this.registryTags.size());
        for (RegistryTags registryTag : this.registryTags) {
            packet.write(Types.STRING, registryTag.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_LastTags$RegistryTags$get$registryKey());
            packet.write(Types.VAR_INT, registryTag.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_LastTags$RegistryTags$get$tags().size());
            for (TagData tag : registryTag.jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_LastTags$RegistryTags$get$tags()) {
                packet.write(Types.STRING, tag.identifier());
                packet.write(Types.VAR_INT_ARRAY_PRIMITIVE, Arrays.copyOf(tag.entries(), tag.entries().length));
            }
        }
        packet.send(Protocol1_20To1_20_2.class);
    }

    public void setSentDuringConfigPhase(boolean sentDuringConfigPhase) {
        this.sentDuringConfigPhase = sentDuringConfigPhase;
    }

    public boolean sentDuringConfigPhase() {
        return this.sentDuringConfigPhase;
    }

    @RecordComponents(value={@RecordComponents.Value(name="registryKey", type=String.class), @RecordComponents.Value(name="tags", type=List.class)})
    @NestHost(value=LastTags.class)
    private static final class RegistryTags
    extends J_L_Record {
        private final String registryKey;
        private final List<TagData> tags;

        RegistryTags(String registryKey, List<TagData> tags) {
            this.registryKey = registryKey;
            this.tags = tags;
        }

        @Override
        public final String toString() {
            return RegistryTags.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return RegistryTags.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return RegistryTags.jvmdowngrader$equals$equals(this, o2);
        }

        public String registryKey() {
            return this.registryKey;
        }

        public List<TagData> tags() {
            return this.tags;
        }

        private static String jvmdowngrader$toString$toString(RegistryTags registryTags) {
            RegistryTags registryTags2 = registryTags;
            return "LastTags$RegistryTags[" + "registryKey=" + registryTags.registryKey + ", " + "tags=" + registryTags.tags + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(RegistryTags registryTags) {
            Object[] objectArray = new Object[]{registryTags.registryKey, registryTags.tags};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(RegistryTags registryTags, Object object) {
            if (registryTags == object) {
                return true;
            }
            if (object != null && object instanceof RegistryTags) {
                RegistryTags registryTags2 = (RegistryTags)object;
                if (Objects.equals(registryTags.registryKey, registryTags2.registryKey) && Objects.equals(registryTags.tags, registryTags2.tags)) {
                    return true;
                }
            }
            return false;
        }

        public String jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_LastTags$RegistryTags$get$registryKey() {
            return this.registryKey;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_LastTags$RegistryTags$set$registryKey(String string) {
            this.registryKey = string;
        }

        public List jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_LastTags$RegistryTags$get$tags() {
            return this.tags;
        }

        public void jvmdowngrader$nest$com_viaversion_viaversion_protocols_v1_20to1_20_2_storage_LastTags$RegistryTags$set$tags(List list) {
            this.tags = list;
        }
    }
}

