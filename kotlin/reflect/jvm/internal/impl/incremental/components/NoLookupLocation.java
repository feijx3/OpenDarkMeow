/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.Nullable;

public final class NoLookupLocation
extends Enum<NoLookupLocation>
implements LookupLocation {
    public static final /* enum */ NoLookupLocation FROM_IDE = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FROM_BACKEND = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FROM_TEST = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FROM_BUILTINS = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_CHECK_DECLARATION_CONFLICTS = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_CHECK_OVERRIDES = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FOR_SCRIPT = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FROM_REFLECTION = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_RESOLVE_DECLARATION = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_GET_DECLARATION_SCOPE = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FOR_ALREADY_TRACKED = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_GET_ALL_DESCRIPTORS = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_TYPING = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_GET_SUPER_MEMBERS = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FOR_NON_TRACKED_SCOPE = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FROM_SYNTHETIC_SCOPE = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FROM_DESERIALIZATION = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FROM_JAVA_LOADER = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_GET_LOCAL_VARIABLE = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_FIND_BY_FQNAME = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation WHEN_GET_COMPANION_OBJECT = new NoLookupLocation();
    public static final /* enum */ NoLookupLocation FOR_DEFAULT_IMPORTS = new NoLookupLocation();
    private static final /* synthetic */ NoLookupLocation[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    @Override
    @Nullable
    public LocationInfo getLocation() {
        return null;
    }

    public static NoLookupLocation[] values() {
        return (NoLookupLocation[])$VALUES.clone();
    }

    public static NoLookupLocation valueOf(String value) {
        return Enum.valueOf(NoLookupLocation.class, value);
    }

    static {
        $VALUES = noLookupLocationArray = new NoLookupLocation[]{NoLookupLocation.FROM_IDE, NoLookupLocation.FROM_BACKEND, NoLookupLocation.FROM_TEST, NoLookupLocation.FROM_BUILTINS, NoLookupLocation.WHEN_CHECK_DECLARATION_CONFLICTS, NoLookupLocation.WHEN_CHECK_OVERRIDES, NoLookupLocation.FOR_SCRIPT, NoLookupLocation.FROM_REFLECTION, NoLookupLocation.WHEN_RESOLVE_DECLARATION, NoLookupLocation.WHEN_GET_DECLARATION_SCOPE, NoLookupLocation.WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS, NoLookupLocation.FOR_ALREADY_TRACKED, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS, NoLookupLocation.WHEN_TYPING, NoLookupLocation.WHEN_GET_SUPER_MEMBERS, NoLookupLocation.FOR_NON_TRACKED_SCOPE, NoLookupLocation.FROM_SYNTHETIC_SCOPE, NoLookupLocation.FROM_DESERIALIZATION, NoLookupLocation.FROM_JAVA_LOADER, NoLookupLocation.WHEN_GET_LOCAL_VARIABLE, NoLookupLocation.WHEN_FIND_BY_FQNAME, NoLookupLocation.WHEN_GET_COMPANION_OBJECT, NoLookupLocation.FOR_DEFAULT_IMPORTS};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

