/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.kmogus;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.kmogus.UtilsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\u0010\u0019\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0014\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0012\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0013\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0014\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0015\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0016\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0017\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u001a\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u001b\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u001c\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u001d\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u001e\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u001f\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b \u0010!\u00a8\u0006\""}, d2={"memcpy", "", "src", "", "srcOffset", "", "dst", "dstOffset", "length", "", "", "", "", "", "", "Lnet/darkmeow/kmogus/Ptr;", "memcpy-M-v6l84", "([BJJJJ)V", "([SJJJJ)V", "([CJJJJ)V", "([IJJJJ)V", "([JJJJJ)V", "([FJJJJ)V", "([DJJJJ)V", "memcpy-cDIb7nU", "(JJ[BJJ)V", "(JJ[SJJ)V", "(JJ[CJJ)V", "(JJ[IJJ)V", "(JJ[JJJ)V", "(JJ[FJJ)V", "(JJ[DJJ)V", "memcpy-ZK01Fg0", "(JJJJJ)V", "kmogus-core"})
public final class MemcpyKt {
    public static final void memcpy(@NotNull byte[] src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull byte[] src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull byte[] src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull byte[] src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull byte[] src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull byte[] src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull byte[] src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull short[] src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull short[] src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull short[] src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull short[] src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull short[] src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull short[] src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull short[] src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull char[] src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull char[] src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull char[] src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull char[] src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull char[] src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull char[] src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull char[] src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull int[] src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull int[] src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull int[] src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull int[] src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull int[] src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull int[] src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull int[] src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull long[] src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull long[] src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull long[] src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull long[] src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull long[] src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull long[] src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull long[] src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull float[] src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull float[] src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull float[] src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull float[] src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull float[] src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull float[] src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull float[] src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull double[] src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull double[] src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull double[] src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull double[] src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull double[] src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull double[] src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy(@NotNull double[] src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-M-v6l84(@NotNull byte[] src, long srcOffset, long dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getBYTE_ARRAY_OFFSET() + srcOffset, null, dst + dstOffset, length);
    }

    public static final void memcpy-M-v6l84(@NotNull short[] src, long srcOffset, long dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getSHORT_ARRAY_OFFSET() + srcOffset, null, dst + dstOffset, length);
    }

    public static final void memcpy-M-v6l84(@NotNull char[] src, long srcOffset, long dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getCHAR_ARRAY_OFFSET() + srcOffset, null, dst + dstOffset, length);
    }

    public static final void memcpy-M-v6l84(@NotNull int[] src, long srcOffset, long dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getINT_ARRAY_OFFSET() + srcOffset, null, dst + dstOffset, length);
    }

    public static final void memcpy-M-v6l84(@NotNull long[] src, long srcOffset, long dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getLONG_ARRAY_OFFSET() + srcOffset, null, dst + dstOffset, length);
    }

    public static final void memcpy-M-v6l84(@NotNull float[] src, long srcOffset, long dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getFLOAT_ARRAY_OFFSET() + srcOffset, null, dst + dstOffset, length);
    }

    public static final void memcpy-M-v6l84(@NotNull double[] src, long srcOffset, long dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(src, "src");
        UtilsKt.getUNSAFE().copyMemory(src, UtilsKt.getDOUBLE_ARRAY_OFFSET() + srcOffset, null, dst + dstOffset, length);
    }

    public static final void memcpy-cDIb7nU(long src, long srcOffset, @NotNull byte[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, dst, UtilsKt.getBYTE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-cDIb7nU(long src, long srcOffset, @NotNull short[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, dst, UtilsKt.getSHORT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-cDIb7nU(long src, long srcOffset, @NotNull char[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, dst, UtilsKt.getCHAR_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-cDIb7nU(long src, long srcOffset, @NotNull int[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, dst, UtilsKt.getINT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-cDIb7nU(long src, long srcOffset, @NotNull long[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, dst, UtilsKt.getLONG_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-cDIb7nU(long src, long srcOffset, @NotNull float[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, dst, UtilsKt.getFLOAT_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-cDIb7nU(long src, long srcOffset, @NotNull double[] dst, long dstOffset, long length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, dst, UtilsKt.getDOUBLE_ARRAY_OFFSET() + dstOffset, length);
    }

    public static final void memcpy-ZK01Fg0(long src, long srcOffset, long dst, long dstOffset, long length) {
        UtilsKt.getUNSAFE().copyMemory(null, src + srcOffset, null, dst + dstOffset, length);
    }
}

