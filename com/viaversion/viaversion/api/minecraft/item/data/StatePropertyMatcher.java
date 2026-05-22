/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents
 *  xyz.wagyourtail.jvmdg.j16.RecordComponents$Value
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import ViaVersion.xyz.wagyourtail.jvmdg.j16.stub.java_base.J_L_Record;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Either;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;
import xyz.wagyourtail.jvmdg.j16.RecordComponents;

@RecordComponents(value={@RecordComponents.Value(name="name", type=String.class), @RecordComponents.Value(name="matcher", type=Either.class)})
@NestMembers(value={RangedMatcher.class, 1.class})
public final class StatePropertyMatcher
extends J_L_Record {
    private final String name;
    private final Either<String, RangedMatcher> matcher;
    public static final Type<StatePropertyMatcher> TYPE = new Type<StatePropertyMatcher>(StatePropertyMatcher.class){

        @Override
        public StatePropertyMatcher read(ByteBuf buffer) {
            String name = (String)Types.STRING.read(buffer);
            if (buffer.readBoolean()) {
                String value = (String)Types.STRING.read(buffer);
                return new StatePropertyMatcher(name, Either.left(value));
            }
            String minValue = (String)Types.OPTIONAL_STRING.read(buffer);
            String maxValue = (String)Types.OPTIONAL_STRING.read(buffer);
            return new StatePropertyMatcher(name, Either.right(new RangedMatcher(minValue, maxValue)));
        }

        @Override
        public void write(ByteBuf buffer, StatePropertyMatcher value) {
            Types.STRING.write(buffer, value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$get$name());
            if (value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$get$matcher().isLeft()) {
                buffer.writeBoolean(true);
                Types.STRING.write(buffer, (String)value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$get$matcher().left());
            } else {
                buffer.writeBoolean(false);
                Types.OPTIONAL_STRING.write(buffer, ((RangedMatcher)value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$get$matcher().right()).minValue());
                Types.OPTIONAL_STRING.write(buffer, ((RangedMatcher)value.jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$get$matcher().right()).maxValue());
            }
        }
    };
    public static final Type<StatePropertyMatcher[]> ARRAY_TYPE = new ArrayType<StatePropertyMatcher>(TYPE);

    public StatePropertyMatcher(String name, Either<String, RangedMatcher> matcher) {
        this.name = name;
        this.matcher = matcher;
    }

    @Override
    public final String toString() {
        return StatePropertyMatcher.jvmdowngrader$toString$toString(this);
    }

    @Override
    public final int hashCode() {
        return StatePropertyMatcher.jvmdowngrader$hashCode$hashCode(this);
    }

    @Override
    public final boolean equals(Object o2) {
        return StatePropertyMatcher.jvmdowngrader$equals$equals(this, o2);
    }

    public String name() {
        return this.name;
    }

    public Either<String, RangedMatcher> matcher() {
        return this.matcher;
    }

    private static String jvmdowngrader$toString$toString(StatePropertyMatcher statePropertyMatcher) {
        StatePropertyMatcher statePropertyMatcher2 = statePropertyMatcher;
        return "StatePropertyMatcher[" + "name=" + statePropertyMatcher.name + ", " + "matcher=" + statePropertyMatcher.matcher + "]";
    }

    private static int jvmdowngrader$hashCode$hashCode(StatePropertyMatcher statePropertyMatcher) {
        Object[] objectArray = new Object[]{statePropertyMatcher.name, statePropertyMatcher.matcher};
        return Arrays.hashCode(objectArray);
    }

    private static boolean jvmdowngrader$equals$equals(StatePropertyMatcher statePropertyMatcher, Object object) {
        if (statePropertyMatcher == object) {
            return true;
        }
        if (object != null && object instanceof StatePropertyMatcher) {
            StatePropertyMatcher statePropertyMatcher2 = (StatePropertyMatcher)object;
            if (Objects.equals(statePropertyMatcher.name, statePropertyMatcher2.name) && Objects.equals(statePropertyMatcher.matcher, statePropertyMatcher2.matcher)) {
                return true;
            }
        }
        return false;
    }

    public String jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$get$name() {
        return this.name;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$set$name(String string) {
        this.name = string;
    }

    public Either jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$get$matcher() {
        return this.matcher;
    }

    public void jvmdowngrader$nest$com_viaversion_viaversion_api_minecraft_item_data_StatePropertyMatcher$set$matcher(Either either) {
        this.matcher = either;
    }

    @RecordComponents(value={@RecordComponents.Value(name="minValue", type=String.class), @RecordComponents.Value(name="maxValue", type=String.class)})
    @NestHost(value=StatePropertyMatcher.class)
    public static final class RangedMatcher
    extends J_L_Record {
        private final @Nullable String minValue;
        private final @Nullable String maxValue;

        public RangedMatcher(@Nullable String minValue, @Nullable String maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        @Override
        public final String toString() {
            return RangedMatcher.jvmdowngrader$toString$toString(this);
        }

        @Override
        public final int hashCode() {
            return RangedMatcher.jvmdowngrader$hashCode$hashCode(this);
        }

        @Override
        public final boolean equals(Object o2) {
            return RangedMatcher.jvmdowngrader$equals$equals(this, o2);
        }

        public @Nullable String minValue() {
            return this.minValue;
        }

        public @Nullable String maxValue() {
            return this.maxValue;
        }

        private static String jvmdowngrader$toString$toString(RangedMatcher rangedMatcher) {
            RangedMatcher rangedMatcher2 = rangedMatcher;
            return "StatePropertyMatcher$RangedMatcher[" + "minValue=" + rangedMatcher.minValue + ", " + "maxValue=" + rangedMatcher.maxValue + "]";
        }

        private static int jvmdowngrader$hashCode$hashCode(RangedMatcher rangedMatcher) {
            Object[] objectArray = new Object[]{rangedMatcher.minValue, rangedMatcher.maxValue};
            return Arrays.hashCode(objectArray);
        }

        private static boolean jvmdowngrader$equals$equals(RangedMatcher rangedMatcher, Object object) {
            if (rangedMatcher == object) {
                return true;
            }
            if (object != null && object instanceof RangedMatcher) {
                RangedMatcher rangedMatcher2 = (RangedMatcher)object;
                if (Objects.equals(rangedMatcher.minValue, rangedMatcher2.minValue) && Objects.equals(rangedMatcher.maxValue, rangedMatcher2.maxValue)) {
                    return true;
                }
            }
            return false;
        }
    }
}

