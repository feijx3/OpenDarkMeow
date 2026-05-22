/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nplatformUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 platformUtil.kt\norg/jetbrains/kotlin/platform/PlatformUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n10#1:55\n808#2,11:44\n808#2,11:56\n*S KotlinDebug\n*F\n+ 1 platformUtil.kt\norg/jetbrains/kotlin/platform/PlatformUtilKt\n*L\n13#1:55\n10#1:44,11\n13#1:56,11\n*E\n"})
public final class PlatformUtilKt {
    @NotNull
    public static final String getPresentableDescription(@NotNull TargetPlatform $this$presentableDescription) {
        Intrinsics.checkNotNullParameter($this$presentableDescription, "<this>");
        return CollectionsKt.joinToString$default($this$presentableDescription.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
    }
}

