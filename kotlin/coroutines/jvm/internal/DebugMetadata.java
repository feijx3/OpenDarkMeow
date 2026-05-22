/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.SinceKotlin
 *  kotlin.annotation.AnnotationTarget
 *  kotlin.annotation.Target
 *  kotlin.jvm.JvmName
 */
package kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import kotlin.jvm.JvmName;

@Target(allowedTargets={AnnotationTarget.CLASS})
@Retention(value=RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value={ElementType.TYPE})
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0011\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0084\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0004\b\u0003\u0010\u0002\u0012\u000e\b\u0002\u0010\u0004\u001a\u00020\u0005B\u0004\b\b(\u0006\u0012\f\b\u0002\u0010\u0007\u001a\u00020\bB\u0002\b\f\u0012\u0012\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nB\u0002\b\f\u0012\u0012\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nB\u0002\b\f\u0012\f\b\u0002\u0010\f\u001a\u00020\bB\u0002\b\f\u0012\u000e\b\u0002\u0010\r\u001a\u00020\u0005B\u0004\b\b(\u0006\u0012\u000e\b\u0002\u0010\u000e\u001a\u00020\u0005B\u0004\b\b(\u0006R\u0011\u0010\u0002\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u00058G\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8G\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n8G\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\f\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\r\u001a\u00020\u00058G\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u00058G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001b"}, d2={"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "version", "", "sourceFile", "", "", "lineNumbers", "", "localNames", "", "spilled", "indexToLabel", "methodName", "className", "v", "()I", "f", "()Ljava/lang/String;", "l", "()[I", "n", "()[Ljava/lang/String;", "s", "i", "m", "c", "kotlin-stdlib"})
@SinceKotlin(version="1.3")
public @interface DebugMetadata {
    @JvmName(name="v")
    public int v() default 1;

    @JvmName(name="f")
    public String f() default "";

    @JvmName(name="l")
    public int[] l() default {};

    @JvmName(name="n")
    public String[] n() default {};

    @JvmName(name="s")
    public String[] s() default {};

    @JvmName(name="i")
    public int[] i() default {};

    @JvmName(name="m")
    public String m() default "";

    @JvmName(name="c")
    public String c() default "";
}

