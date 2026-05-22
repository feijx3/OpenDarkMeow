/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.serialization;

import org.jetbrains.annotations.NotNull;

public interface StringTable {
    public int getStringIndex(@NotNull String var1);

    public int getQualifiedClassNameIndex(@NotNull String var1, boolean var2);
}

