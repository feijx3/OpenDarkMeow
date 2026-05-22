/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import java.util.function.Predicate;

public class EventSerializer<R, T extends R, A extends Enum<A>, IO> {
    private final Predicate<R> classMatcher;
    private final IOFunction<T, IO> serializer;
    private final A action;
    private final IOFunction<IO, T> deserializer;

    protected EventSerializer(Predicate<R> classMatcher, IOFunction<T, IO> serializer, A action, IOFunction<IO, T> deserializer) {
        this.classMatcher = classMatcher;
        this.serializer = serializer;
        this.action = action;
        this.deserializer = deserializer;
    }

    public A getAction() {
        return this.action;
    }

    public boolean matches(R rawType) {
        return this.classMatcher.test(rawType);
    }

    public IO serialize(SNbt<?> sNbt, T value) throws Throwable {
        return this.serializer.apply(sNbt, value);
    }

    public boolean matches(A action) {
        return this.action == action;
    }

    public T deserialize(SNbt<?> sNbt, IO value) throws Throwable {
        return this.deserializer.apply(sNbt, value);
    }

    @FunctionalInterface
    protected static interface BasicIOFunction<I, O>
    extends IOFunction<I, O> {
        public O apply(I var1) throws Throwable;

        @Override
        default public O apply(SNbt<?> sNbt, I value) throws Throwable {
            return this.apply(value);
        }
    }

    @FunctionalInterface
    protected static interface IOFunction<I, O> {
        public O apply(SNbt<?> var1, I var2) throws Throwable;
    }
}

