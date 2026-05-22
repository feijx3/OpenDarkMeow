/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.config.sections;

import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2={"Lnet/ccbluex/liquidbounce/file/config/sections/ConfigSection;", "", "sectionName", "", "<init>", "(Ljava/lang/String;)V", "getSectionName", "()Ljava/lang/String;", "load", "", "json", "Lcom/google/gson/JsonElement;", "save", "DarkMeow"})
public abstract class ConfigSection {
    @NotNull
    private final String sectionName;

    public ConfigSection(@NotNull String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        this.sectionName = sectionName;
    }

    @NotNull
    public final String getSectionName() {
        return this.sectionName;
    }

    public abstract boolean load(@NotNull JsonElement var1);

    @NotNull
    public abstract JsonElement save();
}

