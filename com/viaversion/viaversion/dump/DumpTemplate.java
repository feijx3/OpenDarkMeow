/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.dump;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.dump.VersionInfo;
import com.viaversion.viaversion.libs.gson.JsonObject;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="versionInfo", type=VersionInfo.class), @RecordComponents.Value(name="configuration", type=Map.class), @RecordComponents.Value(name="platformDump", type=JsonObject.class), @RecordComponents.Value(name="injectionDump", type=JsonObject.class), @RecordComponents.Value(name="playerSample", type=JsonObject.class)})
public final class DumpTemplate
extends J_L_Record {
    private final VersionInfo versionInfo;
    private final Map<String, Object> configuration;
    private final JsonObject platformDump;
    private final JsonObject injectionDump;
    private final JsonObject playerSample;

    public DumpTemplate(VersionInfo versionInfo, Map<String, Object> configuration, JsonObject platformDump, JsonObject injectionDump, JsonObject playerSample) {
        this.versionInfo = versionInfo;
        this.configuration = configuration;
        this.platformDump = platformDump;
        this.injectionDump = injectionDump;
        this.playerSample = playerSample;
    }

    @Override
    public final String toString() {
        return DumpTemplate.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return DumpTemplate.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return DumpTemplate.jvmdowngrader$equals$equals(this, o2);
    }

    public VersionInfo versionInfo() {
        return this.versionInfo;
    }

    public Map<String, Object> configuration() {
        return this.configuration;
    }

    public JsonObject platformDump() {
        return this.platformDump;
    }

    public JsonObject injectionDump() {
        return this.injectionDump;
    }

    public JsonObject playerSample() {
        return this.playerSample;
    }

    private static String jvmdowngrader$toString$toString(DumpTemplate dumpTemplate) {
        DumpTemplate dumpTemplate2 = dumpTemplate;
        return "DumpTemplate[" + "versionInfo=" + dumpTemplate.versionInfo + ", " + "configuration=" + dumpTemplate.configuration + ", " + "platformDump=" + dumpTemplate.platformDump + ", " + "injectionDump=" + dumpTemplate.injectionDump + ", " + "playerSample=" + dumpTemplate.playerSample + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(DumpTemplate dumpTemplate) {
        Object[] objectArray = new Object[]{dumpTemplate.versionInfo, dumpTemplate.configuration, dumpTemplate.platformDump, dumpTemplate.injectionDump, dumpTemplate.playerSample};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(DumpTemplate dumpTemplate, Object object) {
        if (dumpTemplate == object) {
            return true;
        }
        if (object != null && object instanceof DumpTemplate) {
            DumpTemplate dumpTemplate2 = (DumpTemplate)object;
            if (Objects.equals(dumpTemplate.versionInfo, dumpTemplate2.versionInfo) && Objects.equals(dumpTemplate.configuration, dumpTemplate2.configuration) && Objects.equals(dumpTemplate.platformDump, dumpTemplate2.platformDump) && Objects.equals(dumpTemplate.injectionDump, dumpTemplate2.injectionDump) && Objects.equals(dumpTemplate.playerSample, dumpTemplate2.playerSample)) {
                return true;
            }
        }
        return false;
    }
}

