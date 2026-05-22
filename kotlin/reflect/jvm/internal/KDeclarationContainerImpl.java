/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.CreateKCallableVisitor;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$0;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$1;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$2;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$3;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$$Lambda$0;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ModuleByClassLoaderKt;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 B2\u00020\u0001:\u0004?@ABB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\"\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0004J\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJE\u0010 \u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010%\u001a\u00020&H\u0002\u00a2\u0006\u0002\u0010'J=\u0010(\u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u00a2\u0006\u0002\u0010)J(\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,H\u0002J\u0018\u0010-\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001dJ \u0010/\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d2\u0006\u00100\u001a\u00020&J\u0014\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ\u0014\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ4\u00103\u001a\u0002042\u0010\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005062\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,2\u0006\u00108\u001a\u00020&H\u0002J\u0018\u00109\u001a\u00020:2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020&H\u0002J$\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0002R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006C"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "<init>", "()V", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "findPropertyDescriptor", "", "signature", "findFunctionDescriptor", "lookupMethod", "Ljava/lang/reflect/Method;", "parameterTypes", "", "returnType", "isStaticDefault", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "tryGetConstructor", "Ljava/lang/reflect/Constructor;", "", "findMethodBySignature", "desc", "findDefaultMethod", "isMember", "findConstructorBySignature", "findDefaultConstructor", "addParametersAndMasks", "", "result", "", "valueParameters", "isConstructor", "parseJvmDescriptor", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$FunctionJvmDescriptor;", "parseReturnType", "parseType", "begin", "end", "Data", "MemberBelonginess", "FunctionJvmDescriptor", "Companion", "kotlin-reflection"})
@SourceDebugExtension(value={"SMAP\nKDeclarationContainerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KDeclarationContainerImpl.kt\nkotlin/reflect/jvm/internal/KDeclarationContainerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,316:1\n1617#2,9:317\n1869#2:326\n1870#2:328\n1626#2:329\n774#2:330\n865#2,2:331\n1491#2:333\n1516#2,3:334\n1519#2,3:344\n774#2:347\n865#2,2:348\n774#2:350\n865#2,2:351\n1#3:327\n1#3:353\n382#4,7:337\n1310#5,2:354\n37#6:356\n36#6,3:357\n37#6:360\n36#6,3:361\n37#6:364\n36#6,3:365\n*S KotlinDebug\n*F\n+ 1 KDeclarationContainerImpl.kt\nkotlin/reflect/jvm/internal/KDeclarationContainerImpl\n*L\n58#1:317,9\n58#1:326\n58#1:328\n58#1:329\n83#1:330\n83#1:331,2\n103#1:333\n103#1:334,3\n103#1:344,3\n128#1:347\n128#1:348,2\n142#1:350\n142#1:351,2\n58#1:327\n103#1:337,7\n197#1:354,2\n207#1:356\n207#1:357,3\n216#1:360\n216#1:361,3\n241#1:364\n241#1:365,3\n*E\n"})
public abstract class KDeclarationContainerImpl
implements ClassBasedDeclarationContainer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    @NotNull
    private static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    @NotNull
    protected Class<?> getMethodOwner() {
        Class<?> clazz = ReflectClassUtilKt.getWrapperByPrimitive(this.getJClass());
        if (clazz == null) {
            clazz = this.getJClass();
        }
        return clazz;
    }

    @NotNull
    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    @NotNull
    public abstract Collection<PropertyDescriptor> getProperties(@NotNull Name var1);

    @NotNull
    public abstract Collection<FunctionDescriptor> getFunctions(@NotNull Name var1);

    @Nullable
    public abstract PropertyDescriptor getLocalProperty(int var1);

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final Collection<KCallableImpl<?>> getMembers(@NotNull MemberScope scope, @NotNull MemberBelonginess belonginess) {
        void $this$mapNotNullTo$iv$iv;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter((Object)belonginess, "belonginess");
        CreateKCallableVisitor visitor2 = new CreateKCallableVisitor(this){

            public KCallableImpl<?> visitConstructorDescriptor(ConstructorDescriptor descriptor2, Unit data) {
                Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
                Intrinsics.checkNotNullParameter(data, "data");
                throw new IllegalStateException("No constructors should appear here: " + descriptor2);
            }
        };
        Iterable $this$mapNotNull$iv = ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, null, null, 3, null);
        boolean $i$f$mapNotNull = false;
        Iterable iterable = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv$iv$iv.iterator();
        while (iterator2.hasNext()) {
            KCallableImpl it$iv$iv;
            Object element$iv$iv$iv;
            Object element$iv$iv = element$iv$iv$iv = iterator2.next();
            boolean bl2 = false;
            DeclarationDescriptor descriptor2 = (DeclarationDescriptor)element$iv$iv;
            boolean bl3 = false;
            if ((descriptor2 instanceof CallableMemberDescriptor && !Intrinsics.areEqual(((CallableMemberDescriptor)descriptor2).getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) && belonginess.accept((CallableMemberDescriptor)descriptor2) ? (KCallableImpl)descriptor2.accept(visitor2, Unit.INSTANCE) : null) == null) continue;
            it$iv$iv = it$iv$iv;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return CollectionsKt.toList((List)destination$iv$iv);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final PropertyDescriptor findPropertyDescriptor(@NotNull String name, @NotNull String signature) {
        Iterable $this$filterTo$iv$iv;
        void $this$filter$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        MatchResult match = LOCAL_PROPERTY_SIGNATURE.matchEntire(signature);
        if (match != null) {
            String number = match.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor propertyDescriptor = this.getLocalProperty(Integer.parseInt(number));
            if (propertyDescriptor == null) {
                throw new KotlinReflectionInternalError("Local property #" + number + " not found in " + this.getJClass());
            }
            return propertyDescriptor;
        }
        Name name2 = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(name2, "identifier(...)");
        Iterable number = this.getProperties(name2);
        boolean $i$f$filter2 = false;
        void var7_8 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo2 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            PropertyDescriptor descriptor2 = (PropertyDescriptor)element$iv$iv;
            boolean bl2 = false;
            if (!Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor2).asString(), signature)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List properties = (List)destination$iv$iv;
        if (properties.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (properties.size() != 1) {
            void $this$groupByTo$iv$iv;
            void $this$groupBy$iv;
            $this$filterTo$iv$iv = properties;
            boolean $i$f$groupBy = false;
            void $i$f$filterTo2 = $this$groupBy$iv;
            Map destination$iv$iv2 = new LinkedHashMap();
            boolean $i$f$groupByTo = false;
            for (Object element$iv$iv : $this$groupByTo$iv$iv) {
                Object object;
                PropertyDescriptor it = (PropertyDescriptor)element$iv$iv;
                boolean bl3 = false;
                DescriptorVisibility key$iv$iv = it.getVisibility();
                Map $this$getOrPut$iv$iv$iv = destination$iv$iv2;
                boolean $i$f$getOrPut = false;
                Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    boolean bl4 = false;
                    List answer$iv$iv$iv = new ArrayList();
                    $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                list$iv$iv.add(element$iv$iv);
            }
            KDeclarationContainerImpl$$Lambda$0 kDeclarationContainerImpl$$Lambda$0 = KDeclarationContainerImpl$$Lambda$0.INSTANCE;
            Collection $i$f$filter2 = MapsKt.toSortedMap(destination$iv$iv2, new KDeclarationContainerImpl$$Lambda$1(kDeclarationContainerImpl$$Lambda$0)).values();
            Intrinsics.checkNotNullExpressionValue($i$f$filter2, "<get-values>(...)");
            List mostVisibleProperties = (List)CollectionsKt.last($i$f$filter2);
            if (mostVisibleProperties.size() == 1) {
                Intrinsics.checkNotNull(mostVisibleProperties);
                return (PropertyDescriptor)CollectionsKt.first(mostVisibleProperties);
            }
            Name name3 = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(name3, "identifier(...)");
            String allMembers = CollectionsKt.joinToString$default(this.getProperties(name3), "\n", null, null, 0, null, KDeclarationContainerImpl$$Lambda$2.INSTANCE, 30, null);
            throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this + ':' + (((CharSequence)allMembers).length() == 0 ? " no members found" : '\n' + allMembers));
        }
        return (PropertyDescriptor)CollectionsKt.single(properties);
    }

    /*
     * Unable to fully structure code
     */
    @NotNull
    public final FunctionDescriptor findFunctionDescriptor(@NotNull String name, @NotNull String signature) {
        block7: {
            block6: {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(signature, "signature");
                members = null;
                functions = null;
                if (!Intrinsics.areEqual(name, "<init>")) break block6;
                members = (Collection<FunctionDescriptor>)CollectionsKt.toList((Iterable)this.getConstructorDescriptors());
                $this$filter$iv = members;
                $i$f$filter = false;
                var7_8 = $this$filter$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$filterTo = false;
                for (T element$iv$iv : $this$filterTo$iv$iv) {
                    descriptor = (ConstructorDescriptor)element$iv$iv;
                    $i$a$-filter-KDeclarationContainerImpl$findFunctionDescriptor$1 = false;
                    if (!descriptor.isPrimary()) ** GOTO lbl-1000
                    v0 = descriptor.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(v0, "getContainingDeclaration(...)");
                    if (InlineClassesUtilsKt.isMultiFieldValueClass(v0)) {
                        initial = RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString();
                        if (!(StringsKt.startsWith$default(initial, "constructor-impl", false, 2, null) != false && StringsKt.endsWith$default(initial, ")V", false, 2, null) != false)) {
                            $i$a$-require-KDeclarationContainerImpl$findFunctionDescriptor$1$descriptorSignature$1 = false;
                            var15_25 = "Invalid signature of " + descriptor + ": " + initial;
                            throw new IllegalArgumentException(var15_25.toString());
                        }
                        v1 = new StringBuilder().append(StringsKt.removeSuffix(initial, (CharSequence)"V"));
                        v2 = descriptor.getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(v2, "getContainingDeclaration(...)");
                        v3 = v1.append(ValueClassAwareCallerKt.toJvmDescriptor(v2)).toString();
                    } else lbl-1000:
                    // 2 sources

                    {
                        v3 = RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString();
                    }
                    if (!Intrinsics.areEqual(descriptorSignature = v3, signature)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                functions = (List)destination$iv$iv;
                break block7;
            }
            v4 = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(v4, "identifier(...)");
            members = this.getFunctions(v4);
            $this$filter$iv = members;
            $i$f$filter = false;
            $this$filterTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList<E>();
            $i$f$filterTo = false;
            for (T element$iv$iv : $this$filterTo$iv$iv) {
                descriptor = (FunctionDescriptor)element$iv$iv;
                $i$a$-filter-KDeclarationContainerImpl$findFunctionDescriptor$2 = false;
                if (!Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString(), signature)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            functions = (List)destination$iv$iv;
        }
        if (functions.size() != 1) {
            allMembers = CollectionsKt.joinToString$default(members, "\n", null, null, 0, null, KDeclarationContainerImpl$$Lambda$3.INSTANCE, 30, null);
            throw new KotlinReflectionInternalError("Function '" + name + "' (JVM signature: " + signature + ") not resolved in " + this + ':' + (((CharSequence)allMembers).length() == 0 != false ? " no members found" : '\n' + allMembers));
        }
        return (FunctionDescriptor)CollectionsKt.single(functions);
    }

    private final Method lookupMethod(Class<?> $this$lookupMethod, String name, Class<?>[] parameterTypes, Class<?> returnType, boolean isStaticDefault) {
        Method method;
        Class<?> clazz;
        if (isStaticDefault) {
            parameterTypes[0] = $this$lookupMethod;
        }
        if ((clazz = this.tryGetMethod($this$lookupMethod, name, parameterTypes, returnType)) != null) {
            Method it = clazz;
            boolean bl2 = false;
            return it;
        }
        clazz = $this$lookupMethod.getSuperclass();
        if (clazz != null && (method = this.lookupMethod(clazz, name, parameterTypes, returnType, isStaticDefault)) != null) {
            Method it = method;
            boolean bl3 = false;
            return it;
        }
        clazz = ArrayIteratorKt.iterator($this$lookupMethod.getInterfaces());
        while (clazz.hasNext()) {
            Class<?> defaultImpls;
            Class superInterface = (Class)clazz.next();
            Intrinsics.checkNotNull(superInterface);
            Method it = this.lookupMethod(superInterface, name, parameterTypes, returnType, isStaticDefault);
            if (it != null) {
                Method it2 = it;
                boolean bl4 = false;
                return it2;
            }
            if (!isStaticDefault || (defaultImpls = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(superInterface), superInterface.getName() + "$DefaultImpls")) == null) continue;
            parameterTypes[0] = superInterface;
            Method method2 = this.tryGetMethod(defaultImpls, name, parameterTypes, returnType);
            if (method2 == null) continue;
            Method it3 = method2;
            boolean bl5 = false;
            return it3;
        }
        return null;
    }

    private final Method tryGetMethod(Class<?> $this$tryGetMethod, String name, Class<?>[] parameterTypes, Class<?> returnType) {
        Method method;
        try {
            Method method2;
            Method result = $this$tryGetMethod.getDeclaredMethod(name, Arrays.copyOf(parameterTypes, parameterTypes.length));
            if (Intrinsics.areEqual(result.getReturnType(), returnType)) {
                method2 = result;
            } else {
                Object object;
                block5: {
                    Method[] methodArray = $this$tryGetMethod.getDeclaredMethods();
                    Intrinsics.checkNotNullExpressionValue(methodArray, "getDeclaredMethods(...)");
                    Object[] $this$firstOrNull$iv = methodArray;
                    boolean $i$f$firstOrNull = false;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        Method method3 = (Method)element$iv;
                        boolean bl2 = false;
                        if (!(Intrinsics.areEqual(method3.getName(), name) && Intrinsics.areEqual(method3.getReturnType(), returnType) && Arrays.equals(method3.getParameterTypes(), parameterTypes))) continue;
                        object = element$iv;
                        break block5;
                    }
                    object = null;
                }
                method2 = (Method)object;
            }
            method = method2;
        }
        catch (NoSuchMethodException e2) {
            method = null;
        }
        return method;
    }

    private final Constructor<?> tryGetConstructor(Class<?> $this$tryGetConstructor, List<? extends Class<?>> parameterTypes) {
        Object object;
        try {
            Collection $this$toTypedArray$iv = parameterTypes;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            object = thisCollection$iv.toArray(new Class[0]);
            object = $this$tryGetConstructor.getDeclaredConstructor(Arrays.copyOf(object, ((Class[])object).length));
        }
        catch (NoSuchMethodException e2) {
            object = null;
        }
        return object;
    }

    @Nullable
    public final Method findMethodBySignature(@NotNull String name, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        FunctionJvmDescriptor functionJvmDescriptor = this.parseJvmDescriptor(desc, true);
        Collection $this$toTypedArray$iv = functionJvmDescriptor.getParameters();
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Class[] parameterTypes = thisCollection$iv.toArray(new Class[0]);
        Class<?> clazz = functionJvmDescriptor.getReturnType();
        Intrinsics.checkNotNull(clazz);
        Class<?> returnType = clazz;
        Method method = this.lookupMethod(this.getMethodOwner(), name, parameterTypes, returnType, false);
        if (method != null) {
            Method it = method;
            boolean bl2 = false;
            return it;
        }
        if (this.getMethodOwner().isInterface() && (method = this.lookupMethod(Object.class, name, parameterTypes, returnType, false)) != null) {
            Method it = method;
            boolean bl3 = false;
            return it;
        }
        return null;
    }

    @Nullable
    public final Method findDefaultMethod(@NotNull String name, @NotNull String desc, boolean isMember) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        ArrayList parameterTypes = new ArrayList();
        if (isMember) {
            parameterTypes.add(this.getJClass());
        }
        FunctionJvmDescriptor jvmDescriptor = this.parseJvmDescriptor(desc, true);
        this.addParametersAndMasks(parameterTypes, jvmDescriptor.getParameters(), false);
        Class<?> clazz = this.getMethodOwner();
        String string = name + "$default";
        Collection $this$toTypedArray$iv = parameterTypes;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Class<?> clazz2 = jvmDescriptor.getReturnType();
        Intrinsics.checkNotNull(clazz2);
        return this.lookupMethod(clazz, string, thisCollection$iv.toArray(new Class[0]), clazz2, isMember);
    }

    @Nullable
    public final Constructor<?> findConstructorBySignature(@NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return this.tryGetConstructor(this.getJClass(), this.parseJvmDescriptor(desc, false).getParameters());
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final Constructor<?> findDefaultConstructor(@NotNull String desc) {
        void parameterTypes;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(desc, "desc");
        ArrayList arrayList2 = arrayList = new ArrayList();
        Class<?> clazz = this.getJClass();
        KDeclarationContainerImpl kDeclarationContainerImpl = this;
        boolean bl2 = false;
        List<Class<?>> parsedParameters = this.parseJvmDescriptor(desc, false).getParameters();
        this.addParametersAndMasks((List)parameterTypes, parsedParameters, true);
        Unit unit = Unit.INSTANCE;
        return kDeclarationContainerImpl.tryGetConstructor(clazz, arrayList);
    }

    private final void addParametersAndMasks(List<Class<?>> result, List<? extends Class<?>> valueParameters, boolean isConstructor) {
        List<Class<?>> withoutMarker = Intrinsics.areEqual(CollectionsKt.lastOrNull(valueParameters), DEFAULT_CONSTRUCTOR_MARKER) ? valueParameters.subList(0, valueParameters.size() - 1) : valueParameters;
        result.addAll((Collection)withoutMarker);
        int n2 = (withoutMarker.size() + 32 - 1) / 32;
        int n3 = 0;
        while (n3 < n2) {
            int it = n3++;
            boolean bl2 = false;
            Class<Integer> clazz = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(clazz, "TYPE");
            result.add(clazz);
        }
        Class<Object> clazz = isConstructor ? DEFAULT_CONSTRUCTOR_MARKER : Object.class;
        Intrinsics.checkNotNull(clazz);
        result.add(clazz);
    }

    private final FunctionJvmDescriptor parseJvmDescriptor(String desc, boolean parseReturnType) {
        ArrayList result = new ArrayList();
        int begin = 1;
        while (desc.charAt(begin) != ')') {
            int end = begin;
            while (desc.charAt(end) == '[') {
                ++end;
            }
            char c2 = desc.charAt(end);
            if (StringsKt.contains$default((CharSequence)"VZCBSIFJD", c2, false, 2, null)) {
                ++end;
            } else if (c2 == 'L') {
                end = StringsKt.indexOf$default((CharSequence)desc, ';', begin, false, 4, null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
            }
            result.add(this.parseType(desc, begin, end));
            begin = end;
        }
        Class<?> returnType = parseReturnType ? this.parseType(desc, begin + 1, desc.length()) : null;
        return new FunctionJvmDescriptor(result, returnType);
    }

    private final Class<?> parseType(String desc, int begin, int end) {
        Class<Object> clazz;
        switch (desc.charAt(begin)) {
            case 'L': {
                ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader(this.getJClass());
                String string = desc.substring(begin + 1, end - 1);
                Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                Class<?> clazz2 = classLoader.loadClass(StringsKt.replace$default(string, '/', '.', false, 4, null));
                clazz = clazz2;
                Intrinsics.checkNotNullExpressionValue(clazz2, "loadClass(...)");
                break;
            }
            case '[': {
                clazz = UtilKt.createArrayType(this.parseType(desc, begin + 1, end));
                break;
            }
            case 'V': {
                Class<Void> clazz3 = Void.TYPE;
                clazz = clazz3;
                Intrinsics.checkNotNullExpressionValue(clazz3, "TYPE");
                break;
            }
            case 'Z': {
                clazz = Boolean.TYPE;
                break;
            }
            case 'C': {
                clazz = Character.TYPE;
                break;
            }
            case 'B': {
                clazz = Byte.TYPE;
                break;
            }
            case 'S': {
                clazz = Short.TYPE;
                break;
            }
            case 'I': {
                clazz = Integer.TYPE;
                break;
            }
            case 'F': {
                clazz = Float.TYPE;
                break;
            }
            case 'J': {
                clazz = Long.TYPE;
                break;
            }
            case 'D': {
                clazz = Double.TYPE;
                break;
            }
            default: {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
            }
        }
        return clazz;
    }

    private static final int findPropertyDescriptor$lambda$3(DescriptorVisibility first, DescriptorVisibility second) {
        Integer n2 = DescriptorVisibilities.compare(first, second);
        return n2 != null ? n2 : 0;
    }

    private static final int findPropertyDescriptor$lambda$4(Function2 $tmp0, Object p0, Object p1) {
        return ((Number)$tmp0.invoke(p0, p1)).intValue();
    }

    private static final CharSequence findPropertyDescriptor$lambda$5(PropertyDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(descriptor2) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor2).asString();
    }

    private static final CharSequence findFunctionDescriptor$lambda$9(FunctionDescriptor descriptor2) {
        Intrinsics.checkNotNullParameter(descriptor2, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(descriptor2) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(descriptor2).asString();
    }

    static /* synthetic */ int accessor$KDeclarationContainerImpl$lambda0(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
        return KDeclarationContainerImpl.findPropertyDescriptor$lambda$3(descriptorVisibility, descriptorVisibility2);
    }

    static /* synthetic */ int accessor$KDeclarationContainerImpl$lambda1(Function2 function2, Object object, Object object2) {
        return KDeclarationContainerImpl.findPropertyDescriptor$lambda$4(function2, object, object2);
    }

    static /* synthetic */ CharSequence accessor$KDeclarationContainerImpl$lambda2(PropertyDescriptor propertyDescriptor) {
        return KDeclarationContainerImpl.findPropertyDescriptor$lambda$5(propertyDescriptor);
    }

    static /* synthetic */ CharSequence accessor$KDeclarationContainerImpl$lambda3(FunctionDescriptor functionDescriptor) {
        return KDeclarationContainerImpl.findFunctionDescriptor$lambda$9(functionDescriptor);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "<init>", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return LOCAL_PROPERTY_SIGNATURE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00a6\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"})
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final ReflectProperties.LazySoftVal moduleData$delegate;

        public Data() {
            KDeclarationContainerImpl kDeclarationContainerImpl = KDeclarationContainerImpl.this;
            this.moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$$Lambda$0(kDeclarationContainerImpl));
        }

        @NotNull
        public final RuntimeModuleData getModuleData() {
            Object t2 = this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(t2, "getValue(...)");
            return (RuntimeModuleData)t2;
        }

        private static final RuntimeModuleData moduleData_delegate$lambda$0(KDeclarationContainerImpl this$0) {
            return ModuleByClassLoaderKt.getOrCreateModule(this$0.getJClass());
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Data.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};
            $$delegatedProperties = kPropertyArray;
        }

        static /* synthetic */ RuntimeModuleData accessor$KDeclarationContainerImpl$Data$lambda0(KDeclarationContainerImpl kDeclarationContainerImpl) {
            return Data.moduleData_delegate$lambda$0(kDeclarationContainerImpl);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$FunctionJvmDescriptor;", "", "parameters", "", "Ljava/lang/Class;", "returnType", "<init>", "(Ljava/util/List;Ljava/lang/Class;)V", "getParameters", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/Class;", "kotlin-reflection"})
    private static final class FunctionJvmDescriptor {
        @NotNull
        private final List<Class<?>> parameters;
        @Nullable
        private final Class<?> returnType;

        public FunctionJvmDescriptor(@NotNull List<? extends Class<?>> parameters, @Nullable Class<?> returnType) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.parameters = parameters;
            this.returnType = returnType;
        }

        @NotNull
        public final List<Class<?>> getParameters() {
            return this.parameters;
        }

        @Nullable
        public final Class<?> getReturnType() {
            return this.returnType;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "kotlin-reflection"})
    protected static final class MemberBelonginess
    extends Enum<MemberBelonginess> {
        public static final /* enum */ MemberBelonginess DECLARED = new MemberBelonginess();
        public static final /* enum */ MemberBelonginess INHERITED = new MemberBelonginess();
        private static final /* synthetic */ MemberBelonginess[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public final boolean accept(@NotNull CallableMemberDescriptor member) {
            Intrinsics.checkNotNullParameter(member, "member");
            return member.getKind().isReal() == (this == DECLARED);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[])$VALUES.clone();
        }

        public static MemberBelonginess valueOf(String value) {
            return Enum.valueOf(MemberBelonginess.class, value);
        }

        static {
            $VALUES = memberBelonginessArray = new MemberBelonginess[]{MemberBelonginess.DECLARED, MemberBelonginess.INHERITED};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

