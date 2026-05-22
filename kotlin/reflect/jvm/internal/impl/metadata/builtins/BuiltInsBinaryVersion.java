/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsBinaryVersion
extends BinaryVersion {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final BuiltInsBinaryVersion INSTANCE;
    @JvmField
    @NotNull
    public static final BuiltInsBinaryVersion INVALID_VERSION;

    public BuiltInsBinaryVersion(int ... numbers) {
        Intrinsics.checkNotNullParameter(numbers, "numbers");
        super(Arrays.copyOf(numbers, numbers.length));
    }

    public boolean isCompatibleWithCurrentCompilerVersion() {
        return this.isCompatibleTo(INSTANCE);
    }

    static {
        int[] nArray = new int[]{1, 0, 7};
        INSTANCE = new BuiltInsBinaryVersion(nArray);
        INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);
    }

    @SourceDebugExtension(value={"SMAP\nBuiltInsBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInsBinaryVersion.kt\norg/jetbrains/kotlin/metadata/builtins/BuiltInsBinaryVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1563#2:41\n1634#2,3:42\n*S KotlinDebug\n*F\n+ 1 BuiltInsBinaryVersion.kt\norg/jetbrains/kotlin/metadata/builtins/BuiltInsBinaryVersion$Companion\n*L\n36#1:41\n36#1:42,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final BuiltInsBinaryVersion readFrom(@NotNull InputStream stream) {
            void $this$mapTo$iv$iv;
            Intrinsics.checkNotNullParameter(stream, "stream");
            DataInputStream dataInput = new DataInputStream(stream);
            Iterable $this$map$iv = new IntRange(1, dataInput.readInt());
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            Iterator iterator2 = $this$mapTo$iv$iv.iterator();
            while (iterator2.hasNext()) {
                int item$iv$iv;
                int n2 = item$iv$iv = ((IntIterator)iterator2).nextInt();
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(dataInput.readInt());
            }
            int[] nArray = CollectionsKt.toIntArray((List)destination$iv$iv);
            int[] nArray2 = Arrays.copyOf(nArray, nArray.length);
            return new BuiltInsBinaryVersion(nArray2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

