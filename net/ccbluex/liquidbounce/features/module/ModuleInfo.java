/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.Retention
 */
package net.ccbluex.liquidbounce.features.module;

import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;

@Deprecated(message="\u8bf7\u5728 Module \u521d\u59cb\u5316\u51fd\u6570\u4e2d\u4f20\u5165\u6570\u636e", level=DeprecationLevel.WARNING)
@Retention(value=AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(value=RetentionPolicy.RUNTIME)
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\u0002\u0018\u00002\u00020\u0001BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\u00020\u0003B\u0004\b\b(\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\u00020\tB\u0004\b\u0003\u0010\u0000\u0012\u000e\b\u0002\u0010\n\u001a\u00020\u000bB\u0004\b\u0007\u0010\u0002\u0012\u000e\b\u0002\u0010\f\u001a\u00020\u000bB\u0004\b\u0007\u0010\u0002R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\rR\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0004\u0010\rR\u000f\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010R\u000f\u0010\b\u001a\u00020\t\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0011R\u000f\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0012R\u000f\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/ccbluex/liquidbounce/features/module/ModuleInfo;", "", "name", "", "description", "", "category", "Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "keyBind", "", "canEnable", "", "array", "()Ljava/lang/String;", "description$annotations", "()V", "()Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "()I", "()Z", "DarkMeow"})
public @interface ModuleInfo {
    public String name();

    public String description() default "";

    public ModuleCategory category();

    public int keyBind() default 0;

    public boolean canEnable() default true;

    public boolean array() default true;

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="\u8bf7\u5728i18n\u91cc\u7f16\u8f91")
        public static /* synthetic */ void description$annotations() {
        }
    }
}

