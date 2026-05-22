/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy.EventSerializer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SerializerMap<R, A extends Enum<A>, IO> {
    private final SNbt<?> sNbt;
    private final Map<A, List<EventSerializer<R, ? extends R, A, IO>>> serializers;
    private final Function<R, A> toActionFunction;

    public static <R, A extends Enum<A>, IO> Builder<R, A, IO> create(SNbt<?> sNbt) {
        return new Builder(sNbt);
    }

    private SerializerMap(SNbt<?> sNbt, List<EventSerializer<R, ? extends R, A, IO>> serializers, Function<R, A> toActionFunction) {
        this.sNbt = sNbt;
        this.toActionFunction = toActionFunction;
        HashMap<Enum, List> map = new HashMap<Enum, List>();
        for (EventSerializer<R, R, A, IO> serializer : serializers) {
            map.computeIfAbsent((Enum)serializer.getAction(), k2 -> new ArrayList()).add(serializer);
        }
        this.serializers = new EnumMap<A, List<EventSerializer<R, ? extends R, A, IO>>>(map);
    }

    public IO serialize(R event) {
        Enum action = (Enum)this.toActionFunction.apply(event);
        List<EventSerializer<R, R, A, IO>> serializers = this.serializers.get(action);
        if (serializers == null || serializers.isEmpty()) {
            throw new UnsupportedOperationException("No serializer found for " + event);
        }
        for (EventSerializer<R, R, R, IO> eventSerializer : serializers) {
            if (!eventSerializer.matches(event)) continue;
            try {
                return eventSerializer.serialize(this.sNbt, this.cast(event));
            }
            catch (Throwable throwable) {
            }
        }
        throw new UnsupportedOperationException("No serializer found for " + event);
    }

    public R deserialize(A action, IO value) {
        List<EventSerializer<R, R, A, IO>> serializers = this.serializers.get(action);
        if (serializers == null || serializers.isEmpty()) {
            return null;
        }
        for (EventSerializer<R, R, A, IO> serializer : serializers) {
            if (!serializer.matches(action)) continue;
            try {
                return serializer.deserialize(this.sNbt, value);
            }
            catch (Throwable throwable) {
            }
        }
        throw new UnsupportedOperationException("No serializer found for " + action + " - " + value);
    }

    private <X> X cast(Object o2) {
        return (X)o2;
    }

    public static class Builder<R, A extends Enum<A>, IO> {
        private final SNbt<?> sNbt;
        private final List<EventSerializer<R, ? extends R, A, IO>> serializers = new ArrayList<EventSerializer<R, ? extends R, A, IO>>();

        protected Builder(SNbt<?> sNbt) {
            this.sNbt = sNbt;
        }

        public Builder<R, A, IO> add(EventSerializer<R, ? extends R, A, IO> serializer) {
            this.serializers.add(serializer);
            return this;
        }

        public SerializerMap<R, A, IO> finalize(Function<R, A> toActionFunction) {
            return new SerializerMap(this.sNbt, this.serializers, toActionFunction);
        }
    }
}

