/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002!\"BA\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016\u00a2\u0006\u0002\u0010 R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/Void;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "parameterTypes", "getParameterTypes", "()Ljava/util/List;", "erasedParameterTypes", "defaultValues", "", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nAnnotationConstructorCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,181:1\n1563#2:182\n1634#2,3:183\n1563#2:186\n1634#2,2:187\n1636#2:190\n1563#2:191\n1634#2,3:192\n1563#2:195\n1634#2,3:196\n1#3:189\n11318#4:199\n11429#4,4:200\n*S KotlinDebug\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller\n*L\n28#1:182\n28#1:183,3\n35#1:186\n35#1:187,2\n35#1:190\n37#1:191\n37#1:192,3\n20#1:195\n20#1:196,3\n53#1:199\n53#1:200,4\n*E\n"})
public final class AnnotationConstructorCaller
implements Caller {
    @NotNull
    private final Class<?> jClass;
    @NotNull
    private final List<String> parameterNames;
    @NotNull
    private final CallMode callMode;
    @NotNull
    private final List<Method> methods;
    @NotNull
    private final List<Type> parameterTypes;
    @NotNull
    private final List<Class<?>> erasedParameterTypes;
    @NotNull
    private final List<Object> defaultValues;

    public AnnotationConstructorCaller(@NotNull Class<?> jClass, @NotNull List<String> parameterNames, @NotNull CallMode callMode, @NotNull Origin origin, @NotNull List<Method> methods2) {
        Method method;
        Method it;
        Collection collection;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$map$iv;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(parameterNames, "parameterNames");
        Intrinsics.checkNotNullParameter((Object)callMode, "callMode");
        Intrinsics.checkNotNullParameter((Object)origin, "origin");
        Intrinsics.checkNotNullParameter(methods2, "methods");
        this.jClass = jClass;
        this.parameterNames = parameterNames;
        this.callMode = callMode;
        this.methods = methods2;
        Iterable iterable = this.methods;
        AnnotationConstructorCaller annotationConstructorCaller = this;
        boolean $i$f$map = false;
        void var8_9 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Method method2 = (Method)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.getGenericReturnType());
        }
        annotationConstructorCaller.parameterTypes = (List)destination$iv$iv;
        $this$map$iv = this.methods;
        annotationConstructorCaller = this;
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            it = (Method)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl3 = false;
            Class<?> it2 = method.getReturnType();
            boolean bl4 = false;
            Intrinsics.checkNotNull(it2);
            Class<?> clazz = ReflectClassUtilKt.getWrapperByPrimitive(it2);
            if (clazz == null) {
                clazz = it2;
            }
            collection.add(clazz);
        }
        annotationConstructorCaller.erasedParameterTypes = (List)destination$iv$iv;
        $this$map$iv = this.methods;
        annotationConstructorCaller = this;
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            method = (Method)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl5 = false;
            collection.add(method.getDefaultValue());
        }
        annotationConstructorCaller.defaultValues = (List)destination$iv$iv;
        if (this.callMode == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && !((Collection)CollectionsKt.minus((Iterable)this.parameterNames, "value")).isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ AnnotationConstructorCaller(Class clazz, List list, CallMode callMode, Origin origin, List list2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = list;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void name;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(clazz.getDeclaredMethod((String)name, new Class[0]));
            }
            list2 = (List)destination$iv$iv;
        }
        this(clazz, list, callMode, origin, list2);
    }

    @Nullable
    public Void getMember() {
        return null;
    }

    @Override
    @NotNull
    public Type getReturnType() {
        return this.jClass;
    }

    @Override
    @NotNull
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object call(@NotNull Object[] args) {
        void $this$mapIndexedTo$iv$iv;
        Intrinsics.checkNotNullParameter(args, "args");
        this.checkArguments(args);
        Object[] $this$mapIndexed$iv = args;
        boolean $i$f$mapIndexed = false;
        Object[] objectArray = $this$mapIndexed$iv;
        Collection destination$iv$iv = new ArrayList($this$mapIndexed$iv.length);
        boolean $i$f$mapIndexedTo = false;
        int index$iv$iv = 0;
        for (void item$iv$iv : $this$mapIndexedTo$iv$iv) {
            void index;
            void arg;
            Object value;
            int n2 = index$iv$iv++;
            void var12_11 = item$iv$iv;
            int n3 = n2;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            Object object = value = arg == null && this.callMode == CallMode.CALL_BY_NAME ? this.defaultValues.get((int)index) : AnnotationConstructorCallerKt.access$transformKotlinToJvm(arg, this.erasedParameterTypes.get((int)index));
            if (object == null) {
                AnnotationConstructorCallerKt.access$throwIllegalArgumentType((int)index, this.parameterNames.get((int)index), this.erasedParameterTypes.get((int)index));
                throw new KotlinNothingValueException();
            }
            collection.add(object);
        }
        List values = (List)destination$iv$iv;
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt.toMap(CollectionsKt.zip((Iterable)this.parameterNames, values)), this.methods);
    }

    public void checkArguments(@NotNull Object[] args) {
        this.default$checkArguments(args);
    }

    @Override
    public boolean isBoundInstanceCallWithValueClasses() {
        return this.default$isBoundInstanceCallWithValueClasses();
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

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"})
    public static final class CallMode
    extends Enum<CallMode> {
        public static final /* enum */ CallMode CALL_BY_NAME = new CallMode();
        public static final /* enum */ CallMode POSITIONAL_CALL = new CallMode();
        private static final /* synthetic */ CallMode[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static CallMode[] values() {
            return (CallMode[])$VALUES.clone();
        }

        public static CallMode valueOf(String value) {
            return Enum.valueOf(CallMode.class, value);
        }

        static {
            $VALUES = callModeArray = new CallMode[]{CallMode.CALL_BY_NAME, CallMode.POSITIONAL_CALL};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"})
    public static final class Origin
    extends Enum<Origin> {
        public static final /* enum */ Origin JAVA = new Origin();
        public static final /* enum */ Origin KOTLIN = new Origin();
        private static final /* synthetic */ Origin[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Origin[] values() {
            return (Origin[])$VALUES.clone();
        }

        public static Origin valueOf(String value) {
            return Enum.valueOf(Origin.class, value);
        }

        static {
            $VALUES = originArray = new Origin[]{Origin.JAVA, Origin.KOTLIN};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

