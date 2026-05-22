/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 #*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\b\u001c\u001d\u001e\u001f !\"#B5\b\u0004\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0004R\u0013\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0007$%&'()*\u00a8\u0006+"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "<init>", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "getReturnType", "()Ljava/lang/reflect/Type;", "getInstanceClass", "()Ljava/lang/Class;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "checkObjectInstance", "", "obj", "", "Constructor", "BoundConstructor", "AccessorForHiddenConstructor", "AccessorForHiddenBoundConstructor", "Method", "FieldGetter", "FieldSetter", "Companion", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,281:1\n1#2:282\n*E\n"})
public abstract class CallerImpl<M extends Member>
implements Caller<M> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final M member;
    @NotNull
    private final Type returnType;
    @Nullable
    private final Class<?> instanceClass;
    @NotNull
    private final List<Type> parameterTypes;

    /*
     * WARNING - void declaration
     */
    private CallerImpl(M member, Type returnType, Class<?> instanceClass, Type[] valueParameterTypes) {
        Object object;
        block3: {
            block2: {
                void it;
                this.member = member;
                this.returnType = returnType;
                this.instanceClass = instanceClass;
                CallerImpl callerImpl = this;
                object = this.instanceClass;
                if (object == null) break block2;
                Class<?> clazz = object;
                CallerImpl callerImpl2 = callerImpl;
                boolean bl2 = false;
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(it);
                spreadBuilder.addSpread(valueParameterTypes);
                List<Object> list = CollectionsKt.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
                callerImpl = callerImpl2;
                object = list;
                if (list != null) break block3;
            }
            object = ArraysKt.toList(valueParameterTypes);
        }
        callerImpl.parameterTypes = object;
    }

    @Override
    @NotNull
    public final M getMember() {
        return this.member;
    }

    @Override
    @NotNull
    public final Type getReturnType() {
        return this.returnType;
    }

    @Nullable
    public final Class<?> getInstanceClass() {
        return this.instanceClass;
    }

    @Override
    @NotNull
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    protected final void checkObjectInstance(@Nullable Object obj) {
        if (obj == null || !this.member.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public void checkArguments(@NotNull Object[] args) {
        this.default$checkArguments(args);
    }

    @Override
    public boolean isBoundInstanceCallWithValueClasses() {
        return this.default$isBoundInstanceCallWithValueClasses();
    }

    public /* synthetic */ CallerImpl(Member member, Type returnType, Class instanceClass, Type[] valueParameterTypes, DefaultConstructorMarker $constructor_marker) {
        this(member, returnType, instanceClass, valueParameterTypes);
    }

    public void default$checkArguments(Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (CallerKt.getArity(this) != args.length) {
            throw new IllegalArgumentException("Callable expects " + CallerKt.getArity(this) + " arguments, but " + args.length + " were provided.");
        }
    }

    public boolean default$isBoundInstanceCallWithValueClasses() {
        return false;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u0003B\u001d\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "constructor", "boundReceiver", "", "<init>", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    @SourceDebugExtension(value={"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n278#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor\n*L\n76#1:282\n*E\n"})
    public static final class AccessorForHiddenBoundConstructor
    extends CallerImpl<java.lang.reflect.Constructor<?>>
    implements BoundCaller {
        @Nullable
        private final Object boundReceiver;

        public AccessorForHiddenBoundConstructor(@NotNull java.lang.reflect.Constructor<?> constructor, @Nullable Object boundReceiver) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Member member = constructor;
            Class<?> clazz = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
            Type type = clazz;
            Companion companion = Companion;
            Type[] typeArray = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(typeArray, "getGenericParameterTypes(...)");
            Object[] $this$dropFirstAndLast$iv = typeArray;
            boolean $i$f$dropFirstAndLast = false;
            super(member, type, null, (Type[])($this$dropFirstAndLast$iv.length <= 2 ? new Type[]{} : ArraysKt.copyOfRange($this$dropFirstAndLast$iv, 1, $this$dropFirstAndLast$iv.length - 1)), null);
            this.boundReceiver = boundReceiver;
        }

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.checkArguments(args);
            java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor)this.getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add(this.boundReceiver);
            spreadBuilder.addSpread(args);
            spreadBuilder.add(null);
            return constructor.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    @SourceDebugExtension(value={"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n274#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor\n*L\n62#1:282\n*E\n"})
    public static final class AccessorForHiddenConstructor
    extends CallerImpl<java.lang.reflect.Constructor<?>> {
        public AccessorForHiddenConstructor(@NotNull java.lang.reflect.Constructor<?> constructor) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Member member = constructor;
            Class<?> clazz = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
            Type type = clazz;
            Companion companion = Companion;
            Type[] typeArray = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(typeArray, "getGenericParameterTypes(...)");
            Object[] $this$dropLast$iv = typeArray;
            boolean $i$f$dropLast = false;
            super(member, type, null, (Type[])($this$dropLast$iv.length <= 1 ? new Type[]{} : ArraysKt.copyOfRange($this$dropLast$iv, 0, $this$dropLast$iv.length - 1)), null);
        }

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.checkArguments(args);
            java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor)this.getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(args);
            spreadBuilder.add(null);
            return constructor.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B\u001d\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "<init>", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class BoundConstructor
    extends CallerImpl<java.lang.reflect.Constructor<?>>
    implements BoundCaller {
        @Nullable
        private final Object boundReceiver;

        public BoundConstructor(@NotNull java.lang.reflect.Constructor<?> constructor, @Nullable Object boundReceiver) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Member member = constructor;
            Class<?> clazz = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
            Type type = clazz;
            Type[] typeArray = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(typeArray, "getGenericParameterTypes(...)");
            super(member, type, null, typeArray, null);
            this.boundReceiver = boundReceiver;
        }

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.checkArguments(args);
            java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor)this.getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(this.boundReceiver);
            spreadBuilder.addSpread(args);
            return constructor.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\b\u0001\u0010\u0006\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u0005H\u0086\b\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\b\u0001\u0010\u0006\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u0005H\u0086\b\u00a2\u0006\u0002\u0010\u0007J(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\b\u0001\u0010\u0006\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u0005H\u0086\b\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Companion;", "", "<init>", "()V", "dropFirst", "", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropLast", "dropFirstAndLast", "kotlin-reflection"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Constructor
    extends CallerImpl<java.lang.reflect.Constructor<?>> {
        /*
         * WARNING - void declaration
         */
        public Constructor(@NotNull java.lang.reflect.Constructor<?> constructor) {
            void klass;
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Member member = constructor;
            Class<?> clazz = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(clazz, "getDeclaringClass(...)");
            Class<?> clazz2 = constructor.getDeclaringClass();
            Type type = clazz;
            Member member2 = member;
            Constructor constructor2 = this;
            boolean bl2 = false;
            Class<?> outerClass = klass.getDeclaringClass();
            Class<?> clazz3 = outerClass != null && !Modifier.isStatic(klass.getModifiers()) ? outerClass : null;
            Type[] typeArray = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(typeArray, "getGenericParameterTypes(...)");
            super(member2, type, clazz3, typeArray, null);
        }

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.checkArguments(args);
            return ((java.lang.reflect.Constructor)this.getMember()).newInstance(Arrays.copyOf(args, args.length));
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\f\u0082\u0001\u0005\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "<init>", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "Static", "Instance", "JvmStaticInObject", "BoundInstance", "BoundJvmStaticInObject", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "kotlin-reflection"})
    public static abstract class FieldGetter
    extends CallerImpl<Field> {
        private FieldGetter(Field field, boolean requiresInstance) {
            Member member = field;
            Type type = field.getGenericType();
            Intrinsics.checkNotNullExpressionValue(type, "getGenericType(...)");
            super(member, type, requiresInstance ? field.getDeclaringClass() : null, new Type[0], null);
        }

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.checkArguments(args);
            return ((Field)this.getMember()).get(this.getInstanceClass() != null ? ArraysKt.first(args) : null);
        }

        public /* synthetic */ FieldGetter(Field field, boolean requiresInstance, DefaultConstructorMarker $constructor_marker) {
            this(field, requiresInstance);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "<init>", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class BoundInstance
        extends FieldGetter
        implements BoundCaller {
            @Nullable
            private final Object boundReceiver;

            public BoundInstance(@NotNull Field field, @Nullable Object boundReceiver) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, false, null);
                this.boundReceiver = boundReceiver;
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                return ((Field)this.getMember()).get(this.boundReceiver);
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
        public static final class BoundJvmStaticInObject
        extends FieldGetter
        implements BoundCaller {
            public BoundJvmStaticInObject(@NotNull Field field) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, false, null);
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
        public static final class Instance
        extends FieldGetter {
            public Instance(@NotNull Field field) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, true, null);
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "<init>", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
        public static final class JvmStaticInObject
        extends FieldGetter {
            public JvmStaticInObject(@NotNull Field field) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, true, null);
            }

            @Override
            public void checkArguments(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                super.checkArguments(args);
                this.checkObjectInstance(ArraysKt.firstOrNull(args));
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
        public static final class Static
        extends FieldGetter {
            public Static(@NotNull Field field) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, false, null);
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0011\u0012\u0013\u0014\u0015B!\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0001\u0005\u0016\u0017\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "<init>", "(Ljava/lang/reflect/Field;ZZ)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "call", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "Static", "Instance", "JvmStaticInObject", "BoundInstance", "BoundJvmStaticInObject", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "kotlin-reflection"})
    public static abstract class FieldSetter
    extends CallerImpl<Field> {
        private final boolean notNull;

        private FieldSetter(Field field, boolean notNull, boolean requiresInstance) {
            Member member = field;
            Class<Void> clazz = Void.TYPE;
            Intrinsics.checkNotNullExpressionValue(clazz, "TYPE");
            Type[] typeArray = new Type[]{field.getGenericType()};
            super(member, clazz, requiresInstance ? field.getDeclaringClass() : null, typeArray, null);
            this.notNull = notNull;
        }

        @Override
        public void checkArguments(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            super.checkArguments(args);
            if (this.notNull && ArraysKt.last(args) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.checkArguments(args);
            ((Field)this.getMember()).set(this.getInstanceClass() != null ? ArraysKt.first(args) : null, ArraysKt.last(args));
            return Unit.INSTANCE;
        }

        public /* synthetic */ FieldSetter(Field field, boolean notNull, boolean requiresInstance, DefaultConstructorMarker $constructor_marker) {
            this(field, notNull, requiresInstance);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0016\u00a2\u0006\u0002\u0010\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "<init>", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class BoundInstance
        extends FieldSetter
        implements BoundCaller {
            @Nullable
            private final Object boundReceiver;

            public BoundInstance(@NotNull Field field, boolean notNull, @Nullable Object boundReceiver) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, notNull, false, null);
                this.boundReceiver = boundReceiver;
            }

            @Override
            @NotNull
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                ((Field)this.getMember()).set(this.boundReceiver, ArraysKt.first(args));
                return Unit.INSTANCE;
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "<init>", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class BoundJvmStaticInObject
        extends FieldSetter
        implements BoundCaller {
            public BoundJvmStaticInObject(@NotNull Field field, boolean notNull) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, notNull, false, null);
            }

            @Override
            @NotNull
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                ((Field)this.getMember()).set(null, ArraysKt.last(args));
                return Unit.INSTANCE;
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "<init>", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
        public static final class Instance
        extends FieldSetter {
            public Instance(@NotNull Field field, boolean notNull) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, notNull, true, null);
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "<init>", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
        public static final class JvmStaticInObject
        extends FieldSetter {
            public JvmStaticInObject(@NotNull Field field, boolean notNull) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, notNull, true, null);
            }

            @Override
            public void checkArguments(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                super.checkArguments(args);
                this.checkObjectInstance(ArraysKt.firstOrNull(args));
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "<init>", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
        public static final class Static
        extends FieldSetter {
            public Static(@NotNull Field field, boolean notNull) {
                Intrinsics.checkNotNullParameter(field, "field");
                super(field, notNull, false, null);
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017B+\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0001\u0007\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u00a8\u0006\u001f"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "<init>", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Static", "Instance", "JvmStaticInObject", "BoundStatic", "BoundStaticMultiFieldValueClass", "BoundInstance", "BoundJvmStaticInObject", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStaticMultiFieldValueClass;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "kotlin-reflection"})
    public static abstract class Method
    extends CallerImpl<java.lang.reflect.Method> {
        private final boolean isVoidMethod;

        private Method(java.lang.reflect.Method method, boolean requiresInstance, Type[] parameterTypes) {
            Member member = method;
            Type type = method.getGenericReturnType();
            Intrinsics.checkNotNullExpressionValue(type, "getGenericReturnType(...)");
            super(member, type, requiresInstance ? method.getDeclaringClass() : null, parameterTypes, null);
            this.isVoidMethod = Intrinsics.areEqual(this.getReturnType(), Void.TYPE);
        }

        public /* synthetic */ Method(java.lang.reflect.Method method, boolean bl2, Type[] typeArray, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                boolean bl3 = bl2 = !Modifier.isStatic(method.getModifiers());
            }
            if ((n2 & 4) != 0) {
                Type[] typeArray2 = method.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(typeArray2, "getGenericParameterTypes(...)");
                typeArray = typeArray2;
            }
            this(method, bl2, typeArray, null);
        }

        @Nullable
        protected final Object callMethod(@Nullable Object instance, @NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            Object result = ((java.lang.reflect.Method)this.getMember()).invoke(instance, Arrays.copyOf(args, args.length));
            return this.isVoidMethod ? Unit.INSTANCE : result;
        }

        public /* synthetic */ Method(java.lang.reflect.Method method, boolean requiresInstance, Type[] parameterTypes, DefaultConstructorMarker $constructor_marker) {
            this(method, requiresInstance, parameterTypes);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class BoundInstance
        extends Method
        implements BoundCaller {
            @Nullable
            private final Object boundReceiver;

            public BoundInstance(@NotNull java.lang.reflect.Method method, @Nullable Object boundReceiver) {
                Intrinsics.checkNotNullParameter(method, "method");
                super(method, false, null, 4, null);
                this.boundReceiver = boundReceiver;
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                return this.callMethod(this.boundReceiver, args);
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class BoundJvmStaticInObject
        extends Method
        implements BoundCaller {
            public BoundJvmStaticInObject(@NotNull java.lang.reflect.Method method) {
                Intrinsics.checkNotNullParameter(method, "method");
                super(method, false, null, 4, null);
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                return this.callMethod(null, args);
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "isCallByToValueClassMangledMethod", "", "boundReceiver", "", "<init>", "(Ljava/lang/reflect/Method;ZLjava/lang/Object;)V", "isCallByToValueClassMangledMethod$kotlin_reflection", "()Z", "getBoundReceiver$kotlin_reflection", "()Ljava/lang/Object;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        @SourceDebugExtension(value={"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n270#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic\n*L\n142#1:282\n*E\n"})
        public static final class BoundStatic
        extends Method
        implements BoundCaller {
            private final boolean isCallByToValueClassMangledMethod;
            @Nullable
            private final Object boundReceiver;

            public BoundStatic(@NotNull java.lang.reflect.Method method, boolean isCallByToValueClassMangledMethod, @Nullable Object boundReceiver) {
                Intrinsics.checkNotNullParameter(method, "method");
                Companion companion = Companion;
                Type[] typeArray = method.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(typeArray, "getGenericParameterTypes(...)");
                Object[] $this$dropFirst$iv = typeArray;
                boolean $i$f$dropFirst = false;
                super(method, false, (Type[])($this$dropFirst$iv.length <= 1 ? new Type[]{} : ArraysKt.copyOfRange($this$dropFirst$iv, 1, $this$dropFirst$iv.length)), null);
                this.isCallByToValueClassMangledMethod = isCallByToValueClassMangledMethod;
                this.boundReceiver = boundReceiver;
            }

            public final boolean isCallByToValueClassMangledMethod$kotlin_reflection() {
                return this.isCallByToValueClassMangledMethod;
            }

            @Nullable
            public final Object getBoundReceiver$kotlin_reflection() {
                return this.boundReceiver;
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(this.boundReceiver);
                spreadBuilder.addSpread(args);
                return this.callMethod(null, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u00072\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016\u00a2\u0006\u0002\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStaticMultiFieldValueClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiverComponents", "", "", "<init>", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "getBoundReceiverComponents$kotlin_reflection", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "call", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "receiverComponentsCount", "", "getReceiverComponentsCount", "()I", "kotlin-reflection"})
        @SourceDebugExtension(value={"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStaticMultiFieldValueClass\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,281:1\n37#2:282\n36#2,3:283\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStaticMultiFieldValueClass\n*L\n155#1:282\n155#1:283,3\n*E\n"})
        public static final class BoundStaticMultiFieldValueClass
        extends Method
        implements BoundCaller {
            @NotNull
            private final Object[] boundReceiverComponents;

            public BoundStaticMultiFieldValueClass(@NotNull java.lang.reflect.Method method, @NotNull Object[] boundReceiverComponents) {
                Intrinsics.checkNotNullParameter(method, "method");
                Intrinsics.checkNotNullParameter(boundReceiverComponents, "boundReceiverComponents");
                Type[] typeArray = method.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(typeArray, "getGenericParameterTypes(...)");
                Collection $this$toTypedArray$iv = ArraysKt.drop((Object[])typeArray, boundReceiverComponents.length);
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                super(method, false, thisCollection$iv.toArray(new Type[0]), null);
                this.boundReceiverComponents = boundReceiverComponents;
            }

            @NotNull
            public final Object[] getBoundReceiverComponents$kotlin_reflection() {
                return this.boundReceiverComponents;
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(this.boundReceiverComponents);
                spreadBuilder.addSpread(args);
                return this.callMethod(null, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            }

            public final int getReceiverComponentsCount() {
                return this.boundReceiverComponents.length;
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        @SourceDebugExtension(value={"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n270#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance\n*L\n113#1:282\n*E\n"})
        public static final class Instance
        extends Method {
            public Instance(@NotNull java.lang.reflect.Method method) {
                Intrinsics.checkNotNullParameter(method, "method");
                super(method, false, null, 6, null);
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                Companion companion = Companion;
                Object[] $this$dropFirst$iv = args;
                boolean $i$f$dropFirst = false;
                return this.callMethod(args[0], $this$dropFirst$iv.length <= 1 ? new Object[]{} : ArraysKt.copyOfRange($this$dropFirst$iv, 1, $this$dropFirst$iv.length));
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        @SourceDebugExtension(value={"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n270#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject\n*L\n121#1:282\n*E\n"})
        public static final class JvmStaticInObject
        extends Method {
            public JvmStaticInObject(@NotNull java.lang.reflect.Method method) {
                Intrinsics.checkNotNullParameter(method, "method");
                super(method, true, null, 4, null);
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                this.checkObjectInstance(ArraysKt.firstOrNull(args));
                Companion companion = Companion;
                Object[] $this$dropFirst$iv = args;
                boolean $i$f$dropFirst = false;
                return this.callMethod(null, $this$dropFirst$iv.length <= 1 ? new Object[]{} : ArraysKt.copyOfRange($this$dropFirst$iv, 1, $this$dropFirst$iv.length));
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class Static
        extends Method {
            public Static(@NotNull java.lang.reflect.Method method) {
                Intrinsics.checkNotNullParameter(method, "method");
                super(method, false, null, 6, null);
            }

            @Override
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                this.checkArguments(args);
                return this.callMethod(null, args);
            }
        }
    }
}

