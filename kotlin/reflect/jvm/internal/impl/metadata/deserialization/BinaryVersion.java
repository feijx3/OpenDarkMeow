/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,101:1\n5343#2,7:102\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n*L\n73#1:102,7\n*E\n"})
public abstract class BinaryVersion {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final int[] numbers;
    private final int major;
    private final int minor;
    private final int patch;
    @NotNull
    private final List<Integer> rest;

    public BinaryVersion(int ... numbers) {
        List list;
        Intrinsics.checkNotNullParameter(numbers, "numbers");
        this.numbers = numbers;
        Integer n2 = ArraysKt.getOrNull(this.numbers, 0);
        this.major = n2 != null ? n2 : -1;
        Integer n3 = ArraysKt.getOrNull(this.numbers, 1);
        this.minor = n3 != null ? n3 : -1;
        Integer n4 = ArraysKt.getOrNull(this.numbers, 2);
        int n5 = this.patch = n4 != null ? n4 : -1;
        if (this.numbers.length > 3) {
            if (this.numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + this.numbers.length + '.');
            }
            list = CollectionsKt.toList((Iterable)ArraysKt.asList(this.numbers).subList(3, this.numbers.length));
        } else {
            list = CollectionsKt.emptyList();
        }
        this.rest = list;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    @NotNull
    public final int[] toArray() {
        return this.numbers;
    }

    protected final boolean isCompatibleTo(@NotNull BinaryVersion ourVersion) {
        Intrinsics.checkNotNullParameter(ourVersion, "ourVersion");
        return this.major == 0 ? ourVersion.major == 0 && this.minor == ourVersion.minor : this.major == ourVersion.major && this.minor <= ourVersion.minor;
    }

    public final boolean isAtLeast(@NotNull BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return this.isAtLeast(version.major, version.minor, version.patch);
    }

    public final boolean isAtLeast(int major, int minor, int patch) {
        if (this.major > major) {
            return true;
        }
        if (this.major < major) {
            return false;
        }
        if (this.minor > minor) {
            return true;
        }
        if (this.minor < minor) {
            return false;
        }
        return this.patch >= patch;
    }

    public final boolean isAtMost(int major, int minor, int patch) {
        if (this.major < major) {
            return true;
        }
        if (this.major > major) {
            return false;
        }
        if (this.minor < minor) {
            return true;
        }
        if (this.minor > minor) {
            return false;
        }
        return this.patch <= patch;
    }

    @NotNull
    public String toString() {
        List versions;
        int[] $this$takeWhile$iv = this.toArray();
        boolean $i$f$takeWhile = false;
        ArrayList<Integer> list$iv = new ArrayList<Integer>();
        int n2 = $this$takeWhile$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int item$iv;
            int it = item$iv = $this$takeWhile$iv[i2];
            boolean bl2 = false;
            if (!(it != -1)) break;
            list$iv.add(item$iv);
        }
        return (versions = (List)list$iv).isEmpty() ? "unknown" : CollectionsKt.joinToString$default(versions, ".", null, null, 0, null, null, 62, null);
    }

    public boolean equals(@Nullable Object other) {
        return other != null && Intrinsics.areEqual(this.getClass(), other.getClass()) && this.major == ((BinaryVersion)other).major && this.minor == ((BinaryVersion)other).minor && this.patch == ((BinaryVersion)other).patch && Intrinsics.areEqual(this.rest, ((BinaryVersion)other).rest);
    }

    public int hashCode() {
        int result = this.major;
        result += 31 * result + this.minor;
        result += 31 * result + this.patch;
        result += 31 * result + ((Object)this.rest).hashCode();
        return result;
    }

    @SourceDebugExtension(value={"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,101:1\n1563#2:102\n1634#2,3:103\n37#3:106\n36#3,3:107\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n*L\n97#1:102\n97#1:103,3\n98#1:106\n98#1:107,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

