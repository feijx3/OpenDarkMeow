/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.km;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import org.jetbrains.annotations.NotNull;

public interface KmDeclarationContainer {
    @NotNull
    public List<KmFunction> getFunctions();

    @NotNull
    public List<KmProperty> getProperties();

    @NotNull
    public List<KmTypeAlias> getTypeAliases();
}

