/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$$Lambda$0;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nSignatureBuildingComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponents\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,40:1\n11228#2:41\n11563#2,3:42\n11563#2,3:49\n37#3:45\n36#3,3:46\n*S KotlinDebug\n*F\n+ 1 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponents\n*L\n21#1:41\n21#1:42,3\n26#1:49,3\n21#1:45\n21#1:46,3\n*E\n"})
public final class SignatureBuildingComponents {
    @NotNull
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    @NotNull
    public final String javaLang(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/lang/" + name;
    }

    @NotNull
    public final String javaUtil(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/" + name;
    }

    @NotNull
    public final String javaFunction(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/function/" + name;
    }

    @NotNull
    public final String javaUtilConcurrentAtomic(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/concurrent/atomic/" + name;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final String[] constructors(String ... signatures) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        String[] $this$map$iv = signatures;
        boolean $i$f$map = false;
        String[] stringArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it;
            void item$iv$iv;
            void var10_10 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add("<init>(" + (String)it + ")V");
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        return thisCollection$iv.toArray(new String[0]);
    }

    @NotNull
    public final Set<String> inJavaLang(@NotNull String name, String ... signatures) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        return this.inClass(this.javaLang(name), Arrays.copyOf(signatures, signatures.length));
    }

    @NotNull
    public final Set<String> inJavaUtil(@NotNull String name, String ... signatures) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        return this.inClass(this.javaUtil(name), Arrays.copyOf(signatures, signatures.length));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Set<String> inClass(@NotNull String internalName, String ... signatures) {
        void $this$mapTo$iv;
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        String[] stringArray = signatures;
        Collection destination$iv = new LinkedHashSet();
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it;
            void item$iv;
            void var9_9 = item$iv = $this$mapTo$iv[i2];
            Collection collection = destination$iv;
            boolean bl2 = false;
            collection.add(internalName + '.' + (String)it);
        }
        return (Set)destination$iv;
    }

    @NotNull
    public final String signature(@NotNull String internalName, @NotNull String jvmDescriptor) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        Intrinsics.checkNotNullParameter(jvmDescriptor, "jvmDescriptor");
        return internalName + '.' + jvmDescriptor;
    }

    @NotNull
    public final String jvmDescriptor(@NotNull String name, @NotNull List<String> parameters, @NotNull String ret) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(ret, "ret");
        return name + '(' + CollectionsKt.joinToString$default(parameters, "", null, null, 0, null, SignatureBuildingComponents$$Lambda$0.INSTANCE, 30, null) + ')' + this.escapeClassName(ret);
    }

    private final String escapeClassName(String internalName) {
        return internalName.length() > 1 ? 'L' + internalName + ';' : internalName;
    }

    private static final CharSequence jvmDescriptor$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.escapeClassName(it);
    }

    static /* synthetic */ CharSequence accessor$SignatureBuildingComponents$lambda0(String string) {
        return SignatureBuildingComponents.jvmDescriptor$lambda$2(string);
    }
}

