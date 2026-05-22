/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DeserializedDeclarationsFromSupertypeConflictDataKey
implements CallableDescriptor.UserDataKey<CallableMemberDescriptor> {
    @NotNull
    public static final DeserializedDeclarationsFromSupertypeConflictDataKey INSTANCE = new DeserializedDeclarationsFromSupertypeConflictDataKey();

    private DeserializedDeclarationsFromSupertypeConflictDataKey() {
    }
}

