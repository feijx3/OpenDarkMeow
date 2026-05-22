/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class MultiFieldValueClassRepresentation<Type extends RigidTypeMarker>
extends ValueClassRepresentation<Type> {
    @NotNull
    private final List<Pair<Name, Type>> underlyingPropertyNamesToTypes;
    @NotNull
    private final Map<Name, Type> map;

    public MultiFieldValueClassRepresentation(@NotNull List<? extends Pair<Name, ? extends Type>> underlyingPropertyNamesToTypes) {
        Intrinsics.checkNotNullParameter(underlyingPropertyNamesToTypes, "underlyingPropertyNamesToTypes");
        super(null);
        this.underlyingPropertyNamesToTypes = underlyingPropertyNamesToTypes;
        this.map = MapsKt.toMap((Iterable)this.getUnderlyingPropertyNamesToTypes());
    }

    @NotNull
    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }

    @Override
    public boolean containsPropertyWithName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.map.containsKey(name);
    }

    @NotNull
    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + this.getUnderlyingPropertyNamesToTypes() + ')';
    }
}

