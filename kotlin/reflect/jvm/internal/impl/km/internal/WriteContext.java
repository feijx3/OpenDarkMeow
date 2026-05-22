/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.MutableVersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable;
import org.jetbrains.annotations.NotNull;

public class WriteContext {
    @NotNull
    private final StringTable strings;
    @NotNull
    private final MutableVersionRequirementTable versionRequirements;
    @NotNull
    private final List<MetadataExtensions> extensions;

    @NotNull
    public final StringTable getStrings() {
        return this.strings;
    }

    @NotNull
    public final MutableVersionRequirementTable getVersionRequirements$kotlin_metadata() {
        return this.versionRequirements;
    }

    @NotNull
    public final List<MetadataExtensions> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final int get(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return this.strings.getStringIndex(string);
    }

    public final int getClassName$kotlin_metadata(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return WriteUtilsKt.getClassNameIndex(this.strings, name);
    }
}

