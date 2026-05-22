/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadContext;
import kotlin.reflect.jvm.internal.impl.km.internal.WriteContext;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions$Companion$$Lambda$0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MetadataExtensions {
    @NotNull
    public static final Companion Companion = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions$Companion.$$INSTANCE;

    public void readClassExtensions(@NotNull KmClass var1, @NotNull ProtoBuf.Class var2, @NotNull ReadContext var3);

    public void readFunctionExtensions(@NotNull KmFunction var1, @NotNull ProtoBuf.Function var2, @NotNull ReadContext var3);

    public void readPropertyExtensions(@NotNull KmProperty var1, @NotNull ProtoBuf.Property var2, @NotNull ReadContext var3);

    public void readConstructorExtensions(@NotNull KmConstructor var1, @NotNull ProtoBuf.Constructor var2, @NotNull ReadContext var3);

    public void readTypeParameterExtensions(@NotNull KmTypeParameter var1, @NotNull ProtoBuf.TypeParameter var2, @NotNull ReadContext var3);

    public void readEnumEntryExtensions(@NotNull KmEnumEntry var1, @NotNull ProtoBuf.EnumEntry var2, @NotNull ReadContext var3);

    public void readTypeExtensions(@NotNull KmType var1, @NotNull ProtoBuf.Type var2, @NotNull ReadContext var3);

    public void readTypeAliasExtensions(@NotNull KmTypeAlias var1, @NotNull ProtoBuf.TypeAlias var2, @NotNull ReadContext var3);

    public void readValueParameterExtensions(@NotNull KmValueParameter var1, @NotNull ProtoBuf.ValueParameter var2, @NotNull ReadContext var3);

    public void writePropertyExtensions(@NotNull KmProperty var1, @NotNull ProtoBuf.Property.Builder var2, @NotNull WriteContext var3);

    public void writeTypeParameterExtensions(@NotNull KmTypeParameter var1, @NotNull ProtoBuf.TypeParameter.Builder var2, @NotNull WriteContext var3);

    public void writeTypeExtensions(@NotNull KmType var1, @NotNull ProtoBuf.Type.Builder var2, @NotNull WriteContext var3);

    public void writeValueParameterExtensions(@NotNull KmValueParameter var1, @NotNull ProtoBuf.ValueParameter.Builder var2, @NotNull WriteContext var3);

    @NotNull
    public KmClassExtension createClassExtension();

    @NotNull
    public KmFunctionExtension createFunctionExtension();

    @NotNull
    public KmPropertyExtension createPropertyExtension();

    @NotNull
    public KmConstructorExtension createConstructorExtension();

    @NotNull
    public KmTypeParameterExtension createTypeParameterExtension();

    @Nullable
    public KmEnumEntryExtension createEnumEntryExtension();

    @NotNull
    public KmTypeExtension createTypeExtension();

    @Nullable
    public KmTypeAliasExtension createTypeAliasExtension();

    @Nullable
    public KmValueParameterExtension createValueParameterExtension();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final Lazy<List<MetadataExtensions>> INSTANCES$delegate;

        private Companion() {
        }

        @NotNull
        public final List<MetadataExtensions> getINSTANCES$kotlin_metadata() {
            Lazy<List<MetadataExtensions>> lazy = INSTANCES$delegate;
            return lazy.getValue();
        }

        private static final List INSTANCES_delegate$lambda$1() {
            List list;
            ServiceLoader<MetadataExtensions> serviceLoader = ServiceLoader.load(MetadataExtensions.class, MetadataExtensions.class.getClassLoader());
            Intrinsics.checkNotNullExpressionValue(serviceLoader, "load(...)");
            List it = list = CollectionsKt.toList((Iterable)serviceLoader);
            boolean bl2 = false;
            if (it.isEmpty()) {
                throw new IllegalStateException("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager".toString());
            }
            return list;
        }

        static {
            $$INSTANCE = new Companion();
            INSTANCES$delegate = LazyKt.lazy(MetadataExtensions$Companion$$Lambda$0.INSTANCE);
        }

        static /* synthetic */ List accessor$MetadataExtensions$Companion$lambda0() {
            return kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions$Companion.INSTANCES_delegate$lambda$1();
        }
    }
}

