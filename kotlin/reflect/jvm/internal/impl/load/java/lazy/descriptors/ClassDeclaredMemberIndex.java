/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nDeclaredMemberIndex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeclaredMemberIndex.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/ClassDeclaredMemberIndex\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n996#2:67\n1025#2,3:68\n1028#2,3:78\n682#2:81\n712#2,4:82\n1163#2,3:95\n1163#2,3:98\n382#3,7:71\n774#4:86\n865#4,2:87\n1208#4,2:89\n1236#4,4:91\n*S KotlinDebug\n*F\n+ 1 DeclaredMemberIndex.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/ClassDeclaredMemberIndex\n*L\n52#1:67\n52#1:68,3\n52#1:78,3\n53#1:81\n53#1:82,4\n57#1:95,3\n60#1:98,3\n52#1:71,7\n54#1:86\n54#1:87,2\n54#1:89,2\n54#1:91,4\n*E\n"})
public class ClassDeclaredMemberIndex
implements DeclaredMemberIndex {
    @NotNull
    private final JavaClass jClass;
    @NotNull
    private final Function1<JavaMember, Boolean> memberFilter;
    @NotNull
    private final Function1<JavaMethod, Boolean> methodFilter;
    @NotNull
    private final Map<Name, List<JavaMethod>> methods;
    @NotNull
    private final Map<Name, JavaField> fields;
    @NotNull
    private final Map<Name, JavaRecordComponent> components;

    /*
     * WARNING - void declaration
     */
    public ClassDeclaredMemberIndex(@NotNull JavaClass jClass, @NotNull Function1<? super JavaMember, Boolean> memberFilter) {
        void $this$associateByTo$iv$iv;
        Iterable $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Object object;
        void $this$associateByTo$iv$iv2;
        Iterable $this$associateBy$iv;
        Object list$iv$iv;
        JavaMethod m2;
        void $this$groupByTo$iv$iv;
        Sequence<JavaMember> $this$groupBy$iv;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(memberFilter, "memberFilter");
        this.jClass = jClass;
        this.memberFilter = memberFilter;
        ClassDeclaredMemberIndex classDeclaredMemberIndex = this;
        this.methodFilter = new ClassDeclaredMemberIndex$$Lambda$0(classDeclaredMemberIndex);
        Sequence<JavaMethod> sequence = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getMethods()), this.methodFilter);
        ClassDeclaredMemberIndex classDeclaredMemberIndex2 = this;
        boolean $i$f$groupBy = false;
        void var5_9 = $this$groupBy$iv;
        Map destination$iv$iv = new LinkedHashMap();
        boolean $i$f$groupByTo = false;
        for (Object element$iv$iv : $this$groupByTo$iv$iv) {
            Object object2;
            m2 = (JavaMethod)element$iv$iv;
            boolean bl2 = false;
            Name key$iv$iv = m2.getName();
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
            boolean $i$f$getOrPut = false;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                boolean bl3 = false;
                List answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object2 = answer$iv$iv$iv;
            } else {
                object2 = value$iv$iv$iv;
            }
            list$iv$iv = (List)object2;
            list$iv$iv.add(element$iv$iv);
        }
        classDeclaredMemberIndex2.methods = destination$iv$iv;
        $this$groupBy$iv = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getFields()), this.memberFilter);
        classDeclaredMemberIndex2 = this;
        boolean $i$f$associateBy22 = false;
        $this$groupByTo$iv$iv = $this$associateBy$iv;
        destination$iv$iv = new LinkedHashMap();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv2) {
            list$iv$iv = (JavaField)element$iv$iv;
            object = destination$iv$iv;
            boolean bl4 = false;
            object.put(m2.getName(), element$iv$iv);
        }
        classDeclaredMemberIndex2.fields = destination$iv$iv;
        $this$associateBy$iv = this.jClass.getRecordComponents();
        Function1<JavaMember, Boolean> $i$f$associateBy22 = this.memberFilter;
        classDeclaredMemberIndex2 = this;
        boolean $i$f$filter = false;
        destination$iv$iv = $this$filter$iv;
        Object destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            void predicate$iv;
            if (!((Boolean)predicate$iv.invoke(element$iv$iv)).booleanValue()) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv2;
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        $this$filterTo$iv$iv = $this$associateBy$iv;
        destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo2 = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it;
            JavaRecordComponent bl4 = (JavaRecordComponent)element$iv$iv;
            object = destination$iv$iv2;
            boolean bl5 = false;
            object.put(it.getName(), element$iv$iv);
        }
        classDeclaredMemberIndex2.components = destination$iv$iv2;
    }

    @Override
    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<JavaMethod> list = this.methods.get(name);
        return list != null ? (Collection)list : (Collection)CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getMethodNames() {
        void var2_2;
        void $this$mapTo$iv;
        Sequence<JavaMethod> sequence = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getMethods()), this.methodFilter);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void p0;
            JavaMethod javaMethod = (JavaMethod)item$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            collection.add(p0.getName());
        }
        return (Set)var2_2;
    }

    @Override
    @Nullable
    public JavaField findFieldByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.fields.get(name);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getFieldNames() {
        void var2_2;
        void $this$mapTo$iv;
        Sequence<JavaMember> sequence = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getFields()), this.memberFilter);
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        for (Object item$iv : $this$mapTo$iv) {
            void p0;
            JavaField javaField = (JavaField)item$iv;
            Collection collection = destination$iv;
            boolean bl2 = false;
            collection.add(p0.getName());
        }
        return (Set)var2_2;
    }

    @Override
    @NotNull
    public Set<Name> getRecordComponentNames() {
        return this.components.keySet();
    }

    @Override
    @Nullable
    public JavaRecordComponent findRecordComponentByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.components.get(name);
    }

    private static final boolean methodFilter$lambda$0(ClassDeclaredMemberIndex this$0, JavaMethod m2) {
        Intrinsics.checkNotNullParameter(m2, "m");
        return this$0.memberFilter.invoke(m2) != false && !JavaLoadingKt.isObjectMethodInInterface(m2);
    }

    static /* synthetic */ boolean accessor$ClassDeclaredMemberIndex$lambda0(ClassDeclaredMemberIndex classDeclaredMemberIndex, JavaMethod javaMethod) {
        return ClassDeclaredMemberIndex.methodFilter$lambda$0(classDeclaredMemberIndex, javaMethod);
    }
}

