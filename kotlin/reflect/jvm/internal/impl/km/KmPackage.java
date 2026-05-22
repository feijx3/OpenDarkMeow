/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmPackage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmPackage\n*L\n160#1:831\n160#1:832,3\n*E\n"})
public final class KmPackage
implements KmDeclarationContainer {
    @NotNull
    private final List<KmFunction> functions;
    @NotNull
    private final List<KmProperty> properties;
    @NotNull
    private final List<KmTypeAlias> typeAliases;
    @NotNull
    private final List<KmPackageExtension> extensions;

    @Override
    @NotNull
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    @Override
    @NotNull
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    @Override
    @NotNull
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    @NotNull
    public final List<KmPackageExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}

