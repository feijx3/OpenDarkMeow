/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension(value={"SMAP\nReflectKotlinClassFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectKotlinClassFinder.kt\norg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClassFinder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
public final class ReflectKotlinClassFinder
implements KotlinClassFinder {
    @NotNull
    private final ClassLoader classLoader;
    @NotNull
    private final BuiltInsResourceLoader builtInsResourceLoader;

    public ReflectKotlinClassFinder(@NotNull ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.classLoader = classLoader;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final KotlinClassFinder.Result findKotlinClass(String fqName) {
        KotlinClassFinder.Result.KotlinClass kotlinClass;
        Class<?> clazz = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, fqName);
        if (clazz != null) {
            Class<?> it = clazz;
            boolean bl2 = false;
            ReflectKotlinClass reflectKotlinClass = ReflectKotlinClass.Factory.create(it);
            clazz = reflectKotlinClass;
            if (reflectKotlinClass != null) {
                KotlinJvmBinaryClass p0 = (KotlinJvmBinaryClass)((Object)clazz);
                boolean bl3 = false;
                kotlinClass = new KotlinClassFinder.Result.KotlinClass(p0, null, 2, null);
                return kotlinClass;
            }
        }
        kotlinClass = null;
        return kotlinClass;
    }

    @Override
    @Nullable
    public KotlinClassFinder.Result findKotlinClassOrContent(@NotNull ClassId classId, @NotNull MetadataVersion metadataVersion) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        return this.findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(classId));
    }

    @Override
    @Nullable
    public KotlinClassFinder.Result findKotlinClassOrContent(@NotNull JavaClass javaClass, @NotNull MetadataVersion metadataVersion) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Object object = javaClass.getFqName();
        if (object == null || (object = ((FqName)object).asString()) == null) {
            return null;
        }
        return this.findKotlinClass((String)object);
    }

    @Override
    @Nullable
    public InputStream findBuiltInsData(@NotNull FqName packageFqName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        if (!packageFqName.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME)) {
            return null;
        }
        return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(packageFqName));
    }
}

