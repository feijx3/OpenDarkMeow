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
import java.util.List;
import java.util.Objects;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="enabled", type=boolean.class), @RecordComponents.Value(name="name", type=String.class), @RecordComponents.Value(name="version", type=String.class), @RecordComponents.Value(name="main", type=String.class), @RecordComponents.Value(name="authors", type=List.class)})
public final class PluginInfo
extends J_L_Record {
    private final boolean enabled;
    private final String name;
    private final String version;
    private final String main;
    private final List<String> authors;

    public PluginInfo(boolean enabled, String name, String version, String main, List<String> authors) {
        this.enabled = enabled;
        this.name = name;
        this.version = version;
        this.main = main;
        this.authors = authors;
    }

    @Override
    public final String toString() {
        return PluginInfo.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return PluginInfo.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return PluginInfo.jvmdowngrader$equals$equals(this, o2);
    }

    public boolean enabled() {
        return this.enabled;
    }

    public String name() {
        return this.name;
    }

    public String version() {
        return this.version;
    }

    public String main() {
        return this.main;
    }

    public List<String> authors() {
        return this.authors;
    }

    private static String jvmdowngrader$toString$toString(PluginInfo pluginInfo) {
        PluginInfo pluginInfo2 = pluginInfo;
        return "PluginInfo[" + "enabled=" + pluginInfo.enabled + ", " + "name=" + pluginInfo.name + ", " + "version=" + pluginInfo.version + ", " + "main=" + pluginInfo.main + ", " + "authors=" + pluginInfo.authors + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(PluginInfo pluginInfo) {
        Object[] objectArray = new Object[]{pluginInfo.enabled, pluginInfo.name, pluginInfo.version, pluginInfo.main, pluginInfo.authors};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(PluginInfo pluginInfo, Object object) {
        if (pluginInfo == object) {
            return true;
        }
        if (object != null && object instanceof PluginInfo) {
            PluginInfo pluginInfo2 = (PluginInfo)object;
            if (pluginInfo.enabled == pluginInfo2.enabled && Objects.equals(pluginInfo.name, pluginInfo2.name) && Objects.equals(pluginInfo.version, pluginInfo2.version) && Objects.equals(pluginInfo.main, pluginInfo2.main) && Objects.equals(pluginInfo.authors, pluginInfo2.authors)) {
                return true;
            }
        }
        return false;
    }
}

