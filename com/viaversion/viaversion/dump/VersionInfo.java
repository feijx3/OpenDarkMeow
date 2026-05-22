/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.dump;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="javaVersion", type=String.class), @RecordComponents.Value(name="operatingSystem", type=String.class), @RecordComponents.Value(name="serverProtocol", type=int.class), @RecordComponents.Value(name="serverVersion", type=String.class), @RecordComponents.Value(name="enabledProtocols", type=Set.class), @RecordComponents.Value(name="platformName", type=String.class), @RecordComponents.Value(name="platformVersion", type=String.class), @RecordComponents.Value(name="pluginVersion", type=String.class), @RecordComponents.Value(name="implementationVersion", type=String.class), @RecordComponents.Value(name="subPlatforms", type=Set.class)})
public final class VersionInfo
extends J_L_Record {
    private final String javaVersion;
    private final String operatingSystem;
    private final int serverProtocol;
    private final String serverVersion;
    private final Set<String> enabledProtocols;
    private final String platformName;
    private final String platformVersion;
    private final String pluginVersion;
    private final String implementationVersion;
    private final Set<String> subPlatforms;

    public VersionInfo(String javaVersion, String operatingSystem, int serverProtocol, String serverVersion, Set<String> enabledProtocols, String platformName, String platformVersion, String pluginVersion, String implementationVersion, Set<String> subPlatforms) {
        this.javaVersion = javaVersion;
        this.operatingSystem = operatingSystem;
        this.serverProtocol = serverProtocol;
        this.serverVersion = serverVersion;
        this.enabledProtocols = enabledProtocols;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.pluginVersion = pluginVersion;
        this.implementationVersion = implementationVersion;
        this.subPlatforms = subPlatforms;
    }

    @Override
    public final String toString() {
        return VersionInfo.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return VersionInfo.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return VersionInfo.jvmdowngrader$equals$equals(this, o2);
    }

    public String javaVersion() {
        return this.javaVersion;
    }

    public String operatingSystem() {
        return this.operatingSystem;
    }

    public int serverProtocol() {
        return this.serverProtocol;
    }

    public String serverVersion() {
        return this.serverVersion;
    }

    public Set<String> enabledProtocols() {
        return this.enabledProtocols;
    }

    public String platformName() {
        return this.platformName;
    }

    public String platformVersion() {
        return this.platformVersion;
    }

    public String pluginVersion() {
        return this.pluginVersion;
    }

    public String implementationVersion() {
        return this.implementationVersion;
    }

    public Set<String> subPlatforms() {
        return this.subPlatforms;
    }

    private static String jvmdowngrader$toString$toString(VersionInfo versionInfo) {
        VersionInfo versionInfo2 = versionInfo;
        return "VersionInfo[" + "javaVersion=" + versionInfo.javaVersion + ", " + "operatingSystem=" + versionInfo.operatingSystem + ", " + "serverProtocol=" + versionInfo.serverProtocol + ", " + "serverVersion=" + versionInfo.serverVersion + ", " + "enabledProtocols=" + versionInfo.enabledProtocols + ", " + "platformName=" + versionInfo.platformName + ", " + "platformVersion=" + versionInfo.platformVersion + ", " + "pluginVersion=" + versionInfo.pluginVersion + ", " + "implementationVersion=" + versionInfo.implementationVersion + ", " + "subPlatforms=" + versionInfo.subPlatforms + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(VersionInfo versionInfo) {
        Object[] objectArray = new Object[]{versionInfo.javaVersion, versionInfo.operatingSystem, versionInfo.serverProtocol, versionInfo.serverVersion, versionInfo.enabledProtocols, versionInfo.platformName, versionInfo.platformVersion, versionInfo.pluginVersion, versionInfo.implementationVersion, versionInfo.subPlatforms};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(VersionInfo versionInfo, Object object) {
        if (versionInfo == object) {
            return true;
        }
        if (object != null && object instanceof VersionInfo) {
            VersionInfo versionInfo2 = (VersionInfo)object;
            if (Objects.equals(versionInfo.javaVersion, versionInfo2.javaVersion) && Objects.equals(versionInfo.operatingSystem, versionInfo2.operatingSystem) && versionInfo.serverProtocol == versionInfo2.serverProtocol && Objects.equals(versionInfo.serverVersion, versionInfo2.serverVersion) && Objects.equals(versionInfo.enabledProtocols, versionInfo2.enabledProtocols) && Objects.equals(versionInfo.platformName, versionInfo2.platformName) && Objects.equals(versionInfo.platformVersion, versionInfo2.platformVersion) && Objects.equals(versionInfo.pluginVersion, versionInfo2.pluginVersion) && Objects.equals(versionInfo.implementationVersion, versionInfo2.implementationVersion) && Objects.equals(versionInfo.subPlatforms, versionInfo2.subPlatforms)) {
                return true;
            }
        }
        return false;
    }
}

