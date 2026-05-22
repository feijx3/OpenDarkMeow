/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$$Lambda$0;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002()B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\u001b\u0010$\u001a\u0004\u0018\u00010%2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0016\u00a2\u0006\u0002\u0010'R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00028\u0000X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010#\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2={"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "oldCaller", "isDefault", "", "<init>", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "caller", "member", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "isBoundInstanceCallWithValueClasses", "()Z", "data", "Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "slices", "", "Lkotlin/ranges/IntRange;", "[Lkotlin/ranges/IntRange;", "getRealSlicesOfParameters", "index", "", "hasMfvcParameters", "call", "", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "MultiFieldValueClassPrimaryConstructorCaller", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nValueClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,392:1\n1761#2,3:393\n1563#2:396\n1634#2,3:397\n1761#2,3:409\n1634#2,3:412\n37#3:400\n36#3,3:401\n37#3:405\n36#3,3:406\n37#3:415\n36#3,3:416\n1#4:404\n*S KotlinDebug\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller\n*L\n45#1:393,3\n48#1:396\n48#1:397,3\n166#1:409,3\n184#1:412,3\n48#1:400\n48#1:401,3\n155#1:405\n155#1:406,3\n192#1:415\n192#1:416,3\n*E\n"})
public final class ValueClassAwareCaller<M extends Member>
implements Caller<M> {
    private final boolean isDefault;
    @NotNull
    private final Caller<M> caller;
    private final M member;
    @NotNull
    private final BoxUnboxData data;
    @NotNull
    private final IntRange[] slices;
    private final boolean hasMfvcParameters;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public ValueClassAwareCaller(@NotNull CallableMemberDescriptor descriptor, @NotNull Caller<? extends M> oldCaller, boolean isDefault) {
        block29: {
            block31: {
                block30: {
                    block28: {
                        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                        Intrinsics.checkNotNullParameter(oldCaller, "oldCaller");
                        super();
                        this.isDefault = isDefault;
                        v0 = this;
                        if (!(oldCaller instanceof CallerImpl.Method.BoundStatic)) break block30;
                        v1 = descriptor.getExtensionReceiverParameter();
                        if (v1 == null) {
                            v1 = descriptor.getDispatchReceiverParameter();
                        }
                        v2 = receiverType = v1 != null ? v1.getType() : null;
                        if (receiverType == null || !InlineClassesUtilsKt.needsMfvcFlattening((KotlinType)receiverType)) ** GOTO lbl-1000
                        if (!this.isDefault) ** GOTO lbl-1000
                        v3 = descriptor.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(v3, "getValueParameters(...)");
                        var5_5 = v3;
                        var23_7 = v0;
                        $i$f$any = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            v4 = false;
                        } else {
                            for (E element$iv : $this$any$iv) {
                                it = (ValueParameterDescriptor)element$iv;
                                $i$a$-any-ValueClassAwareCaller$caller$1 = false;
                                if (!it.declaresDefaultValue()) continue;
                                v4 = true;
                                break block28;
                            }
                            v4 = false;
                        }
                    }
                    var24_27 = v4;
                    v0 = var23_7;
                    if (var24_27) lbl-1000:
                    // 2 sources

                    {
                        v5 = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType((KotlinType)receiverType));
                        Intrinsics.checkNotNull(v5);
                        unboxMethods = v5;
                        var7_12 = (Iterable)unboxMethods;
                        var23_7 = v0;
                        $i$f$map = false;
                        it = $this$map$iv;
                        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $i$f$mapTo = false;
                        for (Object item$iv$iv : $this$mapTo$iv$iv) {
                            var14_36 = (Method)item$iv$iv;
                            var24_28 = destination$iv$iv;
                            $i$a$-map-ValueClassAwareCaller$caller$boundReceiverComponents$1 = false;
                            var24_28.add(it.invoke(((CallerImpl.Method.BoundStatic)oldCaller).getBoundReceiver$kotlin_reflection(), new Object[0]));
                        }
                        v0 = var23_7;
                        $this$map$iv = (List)destination$iv$iv;
                        $i$f$toTypedArray = false;
                        thisCollection$iv = $this$toTypedArray$iv;
                        boundReceiverComponents = thisCollection$iv.toArray(new Object[0]);
                        v6 = new CallerImpl.Method.BoundStaticMultiFieldValueClass((Method)((CallerImpl.Method)oldCaller).getMember(), boundReceiverComponents);
                    } else lbl-1000:
                    // 2 sources

                    {
                        v6 = oldCaller;
                    }
                    break block31;
                }
                v6 = oldCaller;
            }
            v0.caller = v6;
            this.member = this.caller.getMember();
            unboxMethods = this;
            var23_7 = this;
            $i$a$-run-ValueClassAwareCaller$data$1 = false;
            v7 = descriptor.getReturnType();
            Intrinsics.checkNotNull(v7);
            returnType /* !! */  = v7;
            if (!(descriptor instanceof FunctionDescriptor) || !((FunctionDescriptor)descriptor).isSuspend()) ** GOTO lbl-1000
            v8 = InlineClassesUtilsKt.substitutedUnderlyingType((KotlinType)returnType /* !! */ );
            if (v8 != null) {
                it = v8;
                $i$a$-let-ValueClassAwareCaller$data$1$box$1 = false;
                v9 = KotlinBuiltIns.isPrimitiveType(it);
            } else {
                v9 = false;
            }
            if (v9) {
                v10 = null;
            } else lbl-1000:
            // 2 sources

            {
                v11 = ValueClassAwareCallerKt.access$toInlineClass((KotlinType)returnType /* !! */ );
                v10 = box = v11 != null ? ValueClassAwareCallerKt.access$getBoxMethod(v11, descriptor) : null;
            }
            if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(descriptor)) {
                v12 = new BoxUnboxData(IntRange.Companion.getEMPTY(), new List[0], box);
            } else {
                if ($this$data_u24lambda_u245.caller instanceof CallerImpl.Method.BoundStatic && !((CallerImpl.Method.BoundStatic)$this$data_u24lambda_u245.caller).isCallByToValueClassMangledMethod$kotlin_reflection()) {
                    v13 = -1;
                } else if ($this$data_u24lambda_u245.caller instanceof CallerImpl.Method.BoundStaticMultiFieldValueClass) {
                    v13 = -1;
                } else if (descriptor instanceof ConstructorDescriptor) {
                    v13 = $this$data_u24lambda_u245.caller instanceof BoundCaller ? -1 : 0;
                } else if (descriptor.getDispatchReceiverParameter() != null && !($this$data_u24lambda_u245.caller instanceof BoundCaller)) {
                    v14 = descriptor.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(v14, "getContainingDeclaration(...)");
                    v13 = InlineClassesUtilsKt.isValueClass(v14) ? 0 : 1;
                } else {
                    v13 = 0;
                }
                shift = v13;
                flattenedShift = $this$data_u24lambda_u245.caller instanceof CallerImpl.Method.BoundStaticMultiFieldValueClass != false ? -((CallerImpl.Method.BoundStaticMultiFieldValueClass)$this$data_u24lambda_u245.caller).getReceiverComponentsCount() : shift;
                kotlinParameterTypes = ValueClassAwareCallerKt.access$makeKotlinParameterTypes(descriptor, $this$data_u24lambda_u245.caller.getMember(), ValueClassAwareCaller$$Lambda$0.INSTANCE);
                item$iv$iv = kotlinParameterTypes;
                it = 0;
                $i$a$-map-ValueClassAwareCaller$caller$boundReceiverComponents$1 = item$iv$iv.iterator();
                while ($i$a$-map-ValueClassAwareCaller$caller$boundReceiverComponents$1.hasNext()) {
                    var16_40 = $i$a$-map-ValueClassAwareCaller$caller$boundReceiverComponents$1.next();
                    var17_41 = (KotlinType)var16_40;
                    var18_43 = it;
                    $i$a$-sumOfInt-ValueClassAwareCaller$data$1$totalParametersTypeSize$1 = false;
                    v15 = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType((KotlinType)it));
                    var20_46 = v15 != null ? v15.size() : 1;
                    it = var18_43 + var20_46;
                }
                totalParametersTypeSize = it;
                extraArgumentsTail = ($this$data_u24lambda_u245.isDefault != false ? (totalParametersTypeSize + 32 - 1) / 32 + 1 : 0) + (descriptor instanceof FunctionDescriptor != false && ((FunctionDescriptor)descriptor).isSuspend() != false ? 1 : 0);
                expectedArgsSize = totalParametersTypeSize + flattenedShift + extraArgumentsTail;
                ValueClassAwareCallerKt.access$checkParametersSize((Caller)$this$data_u24lambda_u245, expectedArgsSize, descriptor, $this$data_u24lambda_u245.isDefault);
                argumentRange = RangesKt.until(Math.max(shift, 0), kotlinParameterTypes.size() + shift);
                var19_45 = new List[expectedArgsSize];
                for (var17_42 = 0; var17_42 < expectedArgsSize; ++var17_42) {
                    var21_47 = var17_42;
                    var22_48 = argumentRange.getFirst();
                    var19_45[var21_47] = (var21_47 <= argumentRange.getLast() ? var22_48 <= var21_47 : false) != false ? ValueClassAwareCallerKt.access$getValueClassUnboxMethods(TypeSubstitutionKt.asSimpleType((KotlinType)kotlinParameterTypes.get(var21_47 - shift)), descriptor) : null;
                }
                unbox = var19_45;
                v12 = new BoxUnboxData(argumentRange, unbox, box);
            }
            var23_7.data = v12;
            $this$data_u24lambda_u245 = receiverType = CollectionsKt.createListBuilder();
            var23_7 = this;
            $i$a$-buildList-ValueClassAwareCaller$slices$1 = false;
            returnType /* !! */  = this.caller;
            v16 = returnType /* !! */  instanceof CallerImpl.Method.BoundStaticMultiFieldValueClass != false ? ((CallerImpl.Method.BoundStaticMultiFieldValueClass)this.caller).getBoundReceiverComponents$kotlin_reflection().length : (currentOffset = returnType /* !! */  instanceof CallerImpl.Method.BoundStatic != false ? 1 : 0);
            if (currentOffset > 0) {
                $this$slices_u24lambda_u246.add(RangesKt.until(0, currentOffset));
            }
            returnType /* !! */  = this.data.getUnboxParameters();
            var10_26 = returnType /* !! */ .length;
            for (totalParametersTypeSize = 0; totalParametersTypeSize < var10_26; ++totalParametersTypeSize) {
                v17 = parameterUnboxMethods = returnType /* !! */ [totalParametersTypeSize];
                length = v17 != null ? v17.size() : 1;
                $this$slices_u24lambda_u246.add(RangesKt.until(currentOffset, currentOffset + length));
                currentOffset += length;
            }
            receiverType = CollectionsKt.build(receiverType);
            $i$f$toTypedArray = false;
            thisCollection$iv = $this$toTypedArray$iv;
            var23_7.slices = thisCollection$iv.toArray(new IntRange[0]);
            $this$toTypedArray$iv = this.data.getArgumentRange();
            var23_7 = this;
            $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                v18 = false;
            } else {
                var6_11 = $this$any$iv.iterator();
                while (var6_11.hasNext()) {
                    it = element$iv = ((IntIterator)var6_11).nextInt();
                    $i$a$-any-ValueClassAwareCaller$hasMfvcParameters$1 = false;
                    v19 = this.data.getUnboxParameters()[it];
                    if (!(v19 == null ? false : v19.size() > 1)) continue;
                    v18 = true;
                    break block29;
                }
                v18 = false;
            }
        }
        var23_7.hasMfvcParameters = var24_27 = v18;
    }

    @Override
    public M getMember() {
        return this.member;
    }

    @Override
    @NotNull
    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    @Override
    @NotNull
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override
    public boolean isBoundInstanceCallWithValueClasses() {
        return this.caller instanceof CallerImpl.Method.BoundInstance;
    }

    @NotNull
    public final IntRange getRealSlicesOfParameters(int index) {
        IntRange intRange;
        boolean bl2 = 0 <= index ? index < this.slices.length : false;
        if (bl2) {
            intRange = this.slices[index];
        } else if (this.slices.length == 0) {
            intRange = new IntRange(index, index);
        } else {
            int start = index - this.slices.length + (ArraysKt.last(this.slices).getLast() + 1);
            intRange = new IntRange(start, start);
        }
        return intRange;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object call(@NotNull Object[] args) {
        Object[] objectArray;
        Object[] objectArray2;
        Intrinsics.checkNotNullParameter(args, "args");
        IntRange range = this.data.getArgumentRange();
        List<Method>[] unbox = this.data.getUnboxParameters();
        Method box = this.data.getBox();
        if (range.isEmpty()) {
            objectArray2 = args;
        } else if (this.hasMfvcParameters) {
            void $this$toTypedArray$iv;
            int index;
            List<Object> list;
            List<Object> $this$call_u24lambda_u249 = list = CollectionsKt.createListBuilder(args.length);
            boolean bl2 = false;
            int n2 = range.getFirst();
            for (index = 0; index < n2; ++index) {
                $this$call_u24lambda_u249.add(args[index]);
            }
            index = range.getFirst();
            if (index <= (n2 = range.getLast())) {
                while (true) {
                    Object object;
                    List<Method> methods2 = unbox[index];
                    Object arg = args[index];
                    if (methods2 != null) {
                        Iterable $this$mapTo$iv = methods2;
                        boolean $i$f$mapTo = false;
                        for (Object item$iv : $this$mapTo$iv) {
                            Object object2;
                            void it;
                            Method method = (Method)item$iv;
                            Collection collection = $this$call_u24lambda_u249;
                            boolean bl3 = false;
                            Object object3 = arg;
                            if (object3 != null) {
                                object2 = it.invoke(object3, new Object[0]);
                            } else {
                                Class<?> clazz = it.getReturnType();
                                Intrinsics.checkNotNullExpressionValue(clazz, "getReturnType(...)");
                                object2 = UtilKt.defaultPrimitiveValue(clazz);
                            }
                            collection.add(object2);
                        }
                        object = $this$call_u24lambda_u249;
                    } else {
                        object = $this$call_u24lambda_u249.add(arg);
                    }
                    if (index == n2) break;
                    ++index;
                }
            }
            if ((index = range.getLast() + 1) <= (n2 = ArraysKt.getLastIndex(args))) {
                while (true) {
                    $this$call_u24lambda_u249.add(args[index]);
                    if (index == n2) break;
                    ++index;
                }
            }
            Collection collection = CollectionsKt.build(list);
            boolean $i$f$toTypedArray = false;
            void thisCollection$iv = $this$toTypedArray$iv;
            objectArray2 = thisCollection$iv.toArray(new Object[0]);
        } else {
            int n3 = args.length;
            objectArray = new Object[n3];
            for (int $this$toTypedArray$iv = 0; $this$toTypedArray$iv < n3; ++$this$toTypedArray$iv) {
                Object object;
                int n4 = $this$toTypedArray$iv;
                int index = range.getFirst();
                boolean bl4 = n4 <= range.getLast() ? index <= n4 : false;
                if (bl4) {
                    List<Method> list = unbox[n4];
                    Method method = list != null ? CollectionsKt.single(list) : null;
                    Object arg = args[n4];
                    if (method == null) {
                        object = arg;
                    } else {
                        Object object4 = arg;
                        if (object4 != null) {
                            object = method.invoke(object4, new Object[0]);
                        } else {
                            Class<?> clazz = method.getReturnType();
                            Intrinsics.checkNotNullExpressionValue(clazz, "getReturnType(...)");
                            object = UtilKt.defaultPrimitiveValue(clazz);
                        }
                    }
                } else {
                    object = args[n4];
                }
                objectArray[n4] = object;
            }
            objectArray2 = objectArray;
        }
        Object[] unboxedArguments = objectArray2;
        Object result = this.caller.call(unboxedArguments);
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        Object object = box;
        if (object == null || (object = ((Method)object).invoke(null, objectArray = new Object[]{result})) == null) {
            object = result;
        }
        return object;
    }

    private static final boolean data$lambda$5$lambda$3(ClassDescriptor $this$makeKotlinParameterTypes) {
        Intrinsics.checkNotNullParameter($this$makeKotlinParameterTypes, "$this$makeKotlinParameterTypes");
        return InlineClassesUtilsKt.isValueClass($this$makeKotlinParameterTypes);
    }

    static /* synthetic */ boolean accessor$ValueClassAwareCaller$lambda0(ClassDescriptor classDescriptor) {
        return ValueClassAwareCaller.data$lambda$5$lambda$3(classDescriptor);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unboxParameters", "", "", "Ljava/lang/reflect/Method;", "box", "<init>", "(Lkotlin/ranges/IntRange;[Ljava/util/List;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getUnboxParameters", "()[Ljava/util/List;", "[Ljava/util/List;", "getBox", "()Ljava/lang/reflect/Method;", "kotlin-reflection"})
    private static final class BoxUnboxData {
        @NotNull
        private final IntRange argumentRange;
        @NotNull
        private final List<Method>[] unboxParameters;
        @Nullable
        private final Method box;

        public BoxUnboxData(@NotNull IntRange argumentRange, @NotNull List<Method>[] unboxParameters, @Nullable Method box) {
            Intrinsics.checkNotNullParameter(argumentRange, "argumentRange");
            Intrinsics.checkNotNullParameter(unboxParameters, "unboxParameters");
            this.argumentRange = argumentRange;
            this.unboxParameters = unboxParameters;
            this.box = box;
        }

        @NotNull
        public final IntRange getArgumentRange() {
            return this.argumentRange;
        }

        @NotNull
        public final List<Method>[] getUnboxParameters() {
            return this.unboxParameters;
        }

        @Nullable
        public final Method getBox() {
            return this.box;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0016\u00a2\u0006\u0002\u0010#R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u0019\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c\u00a8\u0006$"}, d2={"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$MultiFieldValueClassPrimaryConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "constructorDesc", "", "originalParameters", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "<init>", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/util/List;)V", "constructorImpl", "Ljava/lang/reflect/Method;", "boxMethod", "parameterUnboxMethods", "member", "getMember", "()Ljava/lang/Void;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "originalParametersGroups", "Ljava/lang/Class;", "getOriginalParametersGroups", "()Ljava/util/List;", "parameterTypes", "getParameterTypes", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    @SourceDebugExtension(value={"SMAP\nValueClassAwareCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$MultiFieldValueClassPrimaryConstructorCaller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,392:1\n1563#2:393\n1634#2,3:394\n1573#2:397\n1604#2,3:398\n1563#2:401\n1634#2,3:402\n1607#2:405\n1374#2:406\n1460#2,2:407\n1563#2:409\n1634#2,3:410\n1462#2,3:413\n37#3:416\n36#3,3:417\n*S KotlinDebug\n*F\n+ 1 ValueClassAwareCaller.kt\nkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$MultiFieldValueClassPrimaryConstructorCaller\n*L\n224#1:393\n224#1:394,3\n232#1:397\n232#1:398,3\n234#1:401\n234#1:402,3\n232#1:405\n241#1:406\n241#1:407,2\n241#1:409\n241#1:410,3\n241#1:413,3\n241#1:416\n241#1:417,3\n*E\n"})
    public static final class MultiFieldValueClassPrimaryConstructorCaller
    implements Caller {
        @NotNull
        private final Method constructorImpl;
        @NotNull
        private final Method boxMethod;
        @NotNull
        private final List<List<Method>> parameterUnboxMethods;
        @NotNull
        private final List<List<Class<?>>> originalParametersGroups;
        @NotNull
        private final List<Type> parameterTypes;

        /*
         * WARNING - void declaration
         */
        public MultiFieldValueClassPrimaryConstructorCaller(@NotNull FunctionDescriptor descriptor2, @NotNull KDeclarationContainerImpl container, @NotNull String constructorDesc, @NotNull List<? extends ParameterDescriptor> originalParameters) {
            void $this$mapIndexedTo$iv$iv;
            void $this$mapIndexed$iv;
            Collection collection;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv;
            Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(constructorDesc, "constructorDesc");
            Intrinsics.checkNotNullParameter(originalParameters, "originalParameters");
            Method method = container.findMethodBySignature("constructor-impl", constructorDesc);
            Intrinsics.checkNotNull(method);
            this.constructorImpl = method;
            Method method2 = container.findMethodBySignature("box-impl", StringsKt.removeSuffix(constructorDesc, (CharSequence)"V") + ReflectClassUtilKt.getDesc(container.getJClass()));
            Intrinsics.checkNotNull(method2);
            this.boxMethod = method2;
            Iterable iterable = originalParameters;
            MultiFieldValueClassPrimaryConstructorCaller multiFieldValueClassPrimaryConstructorCaller = this;
            boolean $i$f$map = false;
            void var7_8 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void parameter;
                ParameterDescriptor parameterDescriptor = (ParameterDescriptor)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl2 = false;
                KotlinType kotlinType = parameter.getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType, "getType(...)");
                collection.add(ValueClassAwareCallerKt.access$getValueClassUnboxMethods(TypeSubstitutionKt.asSimpleType(kotlinType), descriptor2));
            }
            multiFieldValueClassPrimaryConstructorCaller.parameterUnboxMethods = (List)destination$iv$iv;
            $this$map$iv = originalParameters;
            multiFieldValueClassPrimaryConstructorCaller = this;
            boolean $i$f$mapIndexed = false;
            $this$mapTo$iv$iv = $this$mapIndexed$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            boolean $i$f$mapIndexedTo = false;
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                List list;
                void index;
                void it;
                int n2;
                if ((n2 = index$iv$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ParameterDescriptor parameterDescriptor = (ParameterDescriptor)item$iv$iv;
                int n3 = n2;
                collection = destination$iv$iv;
                boolean bl3 = false;
                ClassifierDescriptor classifierDescriptor = it.getType().getConstructor().getDeclarationDescriptor();
                Intrinsics.checkNotNull(classifierDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
                List<Method> list2 = this.parameterUnboxMethods.get((int)index);
                if (list2 != null) {
                    void $this$mapTo$iv$iv2;
                    Iterable $this$map$iv2 = list2;
                    boolean $i$f$map2 = false;
                    Iterable iterable2 = $this$map$iv2;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    boolean $i$f$mapTo2 = false;
                    for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                        void it2;
                        Method method3 = (Method)item$iv$iv2;
                        Collection collection2 = destination$iv$iv2;
                        boolean bl4 = false;
                        collection2.add(it2.getReturnType());
                    }
                    list = (List)destination$iv$iv2;
                } else {
                    Class<?> clazz = UtilKt.toJavaClass(classDescriptor);
                    Intrinsics.checkNotNull(clazz);
                    list = CollectionsKt.listOf(clazz);
                }
                collection.add(list);
            }
            multiFieldValueClassPrimaryConstructorCaller.originalParametersGroups = (List)destination$iv$iv;
            this.parameterTypes = CollectionsKt.flatten((Iterable)this.originalParametersGroups);
        }

        @Nullable
        public Void getMember() {
            return null;
        }

        @Override
        @NotNull
        public Type getReturnType() {
            Class<?> clazz = this.boxMethod.getReturnType();
            Intrinsics.checkNotNullExpressionValue(clazz, "getReturnType(...)");
            return clazz;
        }

        @NotNull
        public final List<List<Class<?>>> getOriginalParametersGroups() {
            return this.originalParametersGroups;
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
            void $this$flatMapTo$iv$iv;
            Intrinsics.checkNotNullParameter(args, "args");
            Iterable $this$flatMap$iv = ArraysKt.zip(args, (Iterable)this.parameterUnboxMethods);
            boolean $i$f$flatMap = false;
            Iterable iterable = $this$flatMap$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$flatMapTo = false;
            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                List list;
                List unboxMethods;
                Pair pair = (Pair)element$iv$iv;
                boolean bl2 = false;
                Object arg = pair.component1();
                List list2 = unboxMethods = (List)pair.component2();
                if (list2 != null) {
                    void $this$mapTo$iv$iv;
                    Iterable $this$map$iv = list2;
                    boolean $i$f$map = false;
                    Iterable iterable2 = $this$map$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        Method method = (Method)item$iv$iv;
                        Collection collection = destination$iv$iv2;
                        boolean bl3 = false;
                        collection.add(it.invoke(arg, new Object[0]));
                    }
                    list = (List)destination$iv$iv2;
                } else {
                    list = CollectionsKt.listOf(arg);
                }
                Iterable list$iv$iv = list;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            Collection $this$toTypedArray$iv = (List)destination$iv$iv;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            Object[] newArgs = thisCollection$iv.toArray(new Object[0]);
            this.constructorImpl.invoke(null, Arrays.copyOf(newArgs, newArgs.length));
            return this.boxMethod.invoke(null, Arrays.copyOf(newArgs, newArgs.length));
        }

        @Override
        public boolean isBoundInstanceCallWithValueClasses() {
            return this.default$isBoundInstanceCallWithValueClasses();
        }

        public boolean default$isBoundInstanceCallWithValueClasses() {
            return false;
        }
    }
}

