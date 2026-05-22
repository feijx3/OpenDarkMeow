/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.Closeable;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nreadPackageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 readPackageFragment.kt\norg/jetbrains/kotlin/metadata/builtins/ReadPackageFragmentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
public final class ReadPackageFragmentKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @NotNull
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(@NotNull InputStream $this$readBuiltinsPackageFragment) {
        Pair<Object, BuiltInsBinaryVersion> pair;
        Intrinsics.checkNotNullParameter($this$readBuiltinsPackageFragment, "<this>");
        Closeable closeable = $this$readBuiltinsPackageFragment;
        Throwable throwable = null;
        try {
            ProtoBuf.PackageFragment packageFragment;
            InputStream stream = (InputStream)closeable;
            boolean bl2 = false;
            BuiltInsBinaryVersion version = BuiltInsBinaryVersion.Companion.readFrom(stream);
            if (version.isCompatibleWithCurrentCompilerVersion()) {
                void p0;
                ExtensionRegistryLite extensionRegistryLite;
                ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite = ExtensionRegistryLite.newInstance();
                InputStream inputStream = stream;
                boolean bl3 = false;
                BuiltInsProtoBuf.registerAllExtensions((ExtensionRegistryLite)p0);
                packageFragment = ProtoBuf.PackageFragment.parseFrom(inputStream, extensionRegistryLite);
            } else {
                packageFragment = null;
            }
            ProtoBuf.PackageFragment proto = packageFragment;
            pair = TuplesKt.to(proto, version);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
        return pair;
    }
}

