/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000\u0084\u0001\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0010(\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a\u001e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\u001aO\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u00a2\u0006\u0002\u0010\b\u001a!\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\b\u001a!\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\b\u001aO\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u00a2\u0006\u0002\u0010\b\u001a6\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\fj\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\b\u00a2\u0006\u0002\u0010\u000e\u001a_\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\fj\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u00a2\u0006\u0002\u0010\u000f\u001a6\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\b\u00a2\u0006\u0002\u0010\u0013\u001a_\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011j\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u00a2\u0006\u0002\u0010\u0014\u001aX\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032%\b\u0001\u0010\u0016\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\u0002\b\u0019H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a`\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u001a\u001a\u00020\u001b2%\b\u0001\u0010\u0016\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\u0002\b\u0019H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a'\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\b\u001a:\u0010\u001e\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a3\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\b\u001aL\u0010 \u001a\u0002H!\"\u0014\b\u0000\u0010\"*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010%\u001a9\u0010&\u001a\u00020\u001d\"\t\b\u0000\u0010\u0002\u00a2\u0006\u0002\b'\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001a\u0002H\u0002H\u0087\n\u00a2\u0006\u0002\u0010)\u001a;\u0010*\u001a\u0004\u0018\u0001H\u0003\"\t\b\u0000\u0010\u0002\u00a2\u0006\u0002\b'\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001a\u0002H\u0002H\u0087\n\u00a2\u0006\u0002\u0010+\u001a:\u0010,\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001a\u0002H\u00022\u0006\u0010-\u001a\u0002H\u0003H\u0087\n\u00a2\u0006\u0002\u0010.\u001a1\u0010/\u001a\u00020\u001d\"\t\b\u0000\u0010\u0002\u00a2\u0006\u0002\b'*\u000e\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010(\u001a\u0002H\u0002H\u0087\b\u00a2\u0006\u0002\u0010)\u001a7\u00100\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002\"\t\b\u0001\u0010\u0003\u00a2\u0006\u0002\b'*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010-\u001a\u0002H\u0003H\u0087\b\u00a2\u0006\u0002\u0010)\u001a;\u00101\u001a\u0004\u0018\u0001H\u0003\"\t\b\u0000\u0010\u0002\u00a2\u0006\u0002\b'\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001a\u0002H\u0002H\u0087\b\u00a2\u0006\u0002\u0010+\u001a*\u00102\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0087\n\u00a2\u0006\u0002\u00104\u001a*\u00105\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0087\n\u00a2\u0006\u0002\u00104\u001a1\u00106\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0087\b\u001aP\u00107\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001a\u0002H\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00030$H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\u00a2\u0006\u0002\u00108\u001aC\u00109\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001a\u0002H\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00030$H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108\u001a1\u0010:\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010+\u001aC\u0010;\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001a\u0002H\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00030$H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108\u001a9\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003030=\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\n\u001a<\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030?0>\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\nH\u0087\n\u00a2\u0006\u0002\b@\u001aw\u0010A\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!\"\u0018\b\u0003\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H!0\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010B\u001a\u0002H\"2\u001e\u0010C\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u001aw\u0010E\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!\"\u0018\b\u0003\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H!\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010B\u001a\u0002H\"2\u001e\u0010C\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u001aG\u0010F\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u001a\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\u00a2\u0006\u0002\u0010G\u001a@\u0010F\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070H\u001a@\u0010F\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070I\u001a\\\u0010J\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010C\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0086\b\u00f8\u0001\u0000\u001a\\\u0010K\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010C\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0086\b\u00f8\u0001\u0000\u001aJ\u0010L\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086\b\u00f8\u0001\u0000\u001aJ\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086\b\u00f8\u0001\u0000\u001aq\u0010O\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010B\u001a\u0002H\"2\u001e\u0010M\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u001aV\u0010P\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010M\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086\b\u00f8\u0001\u0000\u001aq\u0010Q\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010B\u001a\u0002H\"2\u001e\u0010M\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u001aV\u0010R\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010M\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001d0\u0017H\u0086\b\u00f8\u0001\u0000\u001a4\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070H\u001aO\u0010S\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070H2\u0006\u0010B\u001a\u0002H\"\u00a2\u0006\u0002\u0010T\u001a;\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\u00a2\u0006\u0002\u0010\b\u001aQ\u0010S\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u00062\u0006\u0010B\u001a\u0002H\"\u00a2\u0006\u0002\u0010U\u001a4\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070I\u001aO\u0010S\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070I2\u0006\u0010B\u001a\u0002H\"\u00a2\u0006\u0002\u0010V\u001a2\u0010S\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001a2\u0010W\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aM\u0010S\u001a\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010B\u001a\u0002H\"H\u0007\u00a2\u0006\u0002\u0010X\u001aG\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0002\u001aM\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070HH\u0086\u0002\u001aT\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0086\u0002\u00a2\u0006\u0002\u0010[\u001aM\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070IH\u0086\u0002\u001aI\u0010Y\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010\\\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0002\u001a=\u0010]\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\n\u001aC\u0010]\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070HH\u0087\n\u001aJ\u0010]\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u001a\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0087\n\u00a2\u0006\u0002\u0010G\u001aC\u0010]\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070IH\u0087\n\u001a=\u0010]\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\n\u001a@\u0010^\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001a\u0002H\u0002H\u0087\u0002\u00a2\u0006\u0002\u0010_\u001aA\u0010^\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010`\u001a\b\u0012\u0004\u0012\u0002H\u00020HH\u0087\u0002\u001aH\u0010^\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010`\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0087\u0002\u00a2\u0006\u0002\u0010a\u001aA\u0010^\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010`\u001a\b\u0012\u0004\u0012\u0002H\u00020IH\u0087\u0002\u001a2\u0010b\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001a\u0002H\u0002H\u0087\n\u00a2\u0006\u0002\u0010c\u001a3\u0010b\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\f\u0010`\u001a\b\u0012\u0004\u0012\u0002H\u00020HH\u0087\n\u001a:\u0010b\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u000e\u0010`\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0087\n\u00a2\u0006\u0002\u0010d\u001a3\u0010b\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\f\u0010`\u001a\b\u0012\u0004\u0012\u0002H\u00020IH\u0087\n\u001a0\u0010e\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006f"}, d2={"emptyMap", "", "K", "V", "mapOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "()Ljava/util/HashMap;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "()Ljava/util/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "buildMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "isNotEmpty", "", "isNullOrEmpty", "orEmpty", "ifEmpty", "R", "M", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contains", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "set", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "containsKey", "containsValue", "remove", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "toPair", "getOrElse", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getValue", "getOrPut", "iterator", "", "", "", "mutableIterator", "mapValuesTo", "destination", "transform", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "mapKeysTo", "putAll", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "Lkotlin/sequences/Sequence;", "mapValues", "mapKeys", "filterKeys", "predicate", "filterValues", "filterTo", "filter", "filterNotTo", "filterNot", "toMap", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "plus", "pair", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "map", "plusAssign", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "kotlin-stdlib"}, xs="kotlin/collections/MapsKt")
@SourceDebugExtension(value={"SMAP\nMaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,814:1\n413#1:824\n424#1:829\n521#1,6:834\n546#1,6:840\n1#2:815\n1252#3,4:816\n1252#3,4:820\n1252#3,4:825\n1252#3,4:830\n*S KotlinDebug\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n463#1:824\n478#1:829\n536#1:834,6\n561#1:840,6\n413#1:816,4\n424#1:820,4\n463#1:825,4\n478#1:830,4\n*E\n"})
class MapsKt__MapsKt
extends MapsKt__MapsJVMKt {
    @NotNull
    public static final <K, V> Map<K, V> emptyMap() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        Intrinsics.checkNotNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> ... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return pairs.length > 0 ? MapsKt.toMap(pairs, (Map)new LinkedHashMap(MapsKt.mapCapacity(pairs.length))) : MapsKt.emptyMap();
    }

    @InlineOnly
    private static final <K, V> Map<K, V> mapOf() {
        return MapsKt.emptyMap();
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    @NotNull
    public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V> ... pairs) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap $this$mutableMapOf_u24lambda_u240 = linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(pairs.length));
        boolean bl2 = false;
        MapsKt.putAll((Map)$this$mutableMapOf_u24lambda_u240, pairs);
        return linkedHashMap;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap();
    }

    @NotNull
    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V> ... pairs) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        HashMap $this$hashMapOf_u24lambda_u241 = hashMap = new HashMap(MapsKt.mapCapacity(pairs.length));
        boolean bl2 = false;
        MapsKt.putAll((Map)$this$hashMapOf_u24lambda_u241, pairs);
        return hashMap;
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap();
    }

    @NotNull
    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V> ... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return (LinkedHashMap)MapsKt.toMap(pairs, (Map)new LinkedHashMap(MapsKt.mapCapacity(pairs.length)));
    }

    @SinceKotlin(version="1.6")
    @InlineOnly
    private static final <K, V> Map<K, V> buildMap(@BuilderInference Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map map = MapsKt.createMapBuilder();
        builderAction.invoke(map);
        return MapsKt.build(map);
    }

    @SinceKotlin(version="1.6")
    @InlineOnly
    private static final <K, V> Map<K, V> buildMap(int capacity, @BuilderInference Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map map = MapsKt.createMapBuilder(capacity);
        builderAction.invoke(map);
        return MapsKt.build(map);
    }

    @InlineOnly
    private static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return !$this$isNotEmpty.isEmpty();
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> $this$isNullOrEmpty) {
        return $this$isNullOrEmpty == null || $this$isNullOrEmpty.isEmpty();
    }

    @InlineOnly
    private static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> $this$orEmpty) {
        Map<K, Object> map = $this$orEmpty;
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return map;
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <M extends Map<?, ?> & R, R> R ifEmpty(M $this$ifEmpty, Function0<? extends R> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (R)($this$ifEmpty.isEmpty() ? defaultValue.invoke() : $this$ifEmpty);
    }

    @InlineOnly
    private static final <K, V> boolean contains(Map<? extends K, ? extends V> $this$contains, K key) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.containsKey(key);
    }

    @InlineOnly
    private static final <K, V> V get(Map<? extends K, ? extends V> $this$get, K key) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        return $this$get.get(key);
    }

    @InlineOnly
    private static final <K, V> void set(Map<K, V> $this$set, K key, V value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        $this$set.put(key, value);
    }

    @InlineOnly
    private static final <K> boolean containsKey(Map<? extends K, ?> $this$containsKey, K key) {
        Intrinsics.checkNotNullParameter($this$containsKey, "<this>");
        return $this$containsKey.containsKey(key);
    }

    @InlineOnly
    private static final <K, V> boolean containsValue(Map<K, ? extends V> $this$containsValue, V value) {
        Intrinsics.checkNotNullParameter($this$containsValue, "<this>");
        return $this$containsValue.containsValue(value);
    }

    @InlineOnly
    private static final <K, V> V remove(Map<? extends K, V> $this$remove, K key) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return TypeIntrinsics.asMutableMap($this$remove).remove(key);
    }

    @InlineOnly
    private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> $this$component1) {
        Intrinsics.checkNotNullParameter($this$component1, "<this>");
        return $this$component1.getKey();
    }

    @InlineOnly
    private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> $this$component2) {
        Intrinsics.checkNotNullParameter($this$component2, "<this>");
        return $this$component2.getValue();
    }

    @InlineOnly
    private static final <K, V> Pair<K, V> toPair(Map.Entry<? extends K, ? extends V> $this$toPair) {
        Intrinsics.checkNotNullParameter($this$toPair, "<this>");
        return new Pair<K, V>($this$toPair.getKey(), $this$toPair.getValue());
    }

    @InlineOnly
    private static final <K, V> V getOrElse(Map<K, ? extends V> $this$getOrElse, K key, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter($this$getOrElse, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v2 = $this$getOrElse.get(key);
        if (v2 == null) {
            v2 = defaultValue.invoke();
        }
        return v2;
    }

    public static final <K, V> V getOrElseNullable(@NotNull Map<K, ? extends V> $this$getOrElseNullable, K key, @NotNull Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter($this$getOrElseNullable, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean $i$f$getOrElseNullable = false;
        V value = $this$getOrElseNullable.get(key);
        if (value == null && !$this$getOrElseNullable.containsKey(key)) {
            return defaultValue.invoke();
        }
        return value;
    }

    @SinceKotlin(version="1.1")
    public static final <K, V> V getValue(@NotNull Map<K, ? extends V> $this$getValue, K key) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        return MapsKt.getOrImplicitDefaultNullable($this$getValue, key);
    }

    public static final <K, V> V getOrPut(@NotNull Map<K, V> $this$getOrPut, K key, @NotNull Function0<? extends V> defaultValue) {
        V v2;
        Intrinsics.checkNotNullParameter($this$getOrPut, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean $i$f$getOrPut = false;
        V value = $this$getOrPut.get(key);
        if (value == null) {
            V answer = defaultValue.invoke();
            $this$getOrPut.put(key, answer);
            v2 = answer;
        } else {
            v2 = value;
        }
        return v2;
    }

    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return $this$iterator.entrySet().iterator();
    }

    @JvmName(name="mutableIterator")
    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return $this$iterator.entrySet().iterator();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(@NotNull Map<? extends K, ? extends V> $this$mapValuesTo, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$mapValuesTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv = $this$mapValuesTo.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv : $this$associateByTo$iv) {
            void it;
            Map.Entry entry = (Map.Entry)element$iv;
            M m2 = destination;
            boolean bl2 = false;
            m2.put(it.getKey(), transform.invoke((Map.Entry<K, V>)element$iv));
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(@NotNull Map<? extends K, ? extends V> $this$mapKeysTo, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$mapKeysTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean $i$f$mapKeysTo = false;
        Iterable $this$associateByTo$iv = $this$mapKeysTo.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv : $this$associateByTo$iv) {
            void it;
            Map.Entry entry = (Map.Entry)element$iv;
            R r2 = transform.invoke((Map.Entry<K, V>)element$iv);
            M m2 = destination;
            boolean bl2 = false;
            Object v2 = it.getValue();
            m2.put(r2, v2);
        }
        return destination;
    }

    public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> $this$putAll, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (Pair<K, V> pair : pairs) {
            K key = pair.component1();
            V value = pair.component2();
            $this$putAll.put(key, value);
        }
    }

    public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> $this$putAll, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (Pair<K, V> pair : pairs) {
            K key = pair.component1();
            V value = pair.component2();
            $this$putAll.put(key, value);
        }
    }

    public static final <K, V> void putAll(@NotNull Map<? super K, ? super V> $this$putAll, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        Iterator<Pair<K, V>> iterator2 = pairs.iterator();
        while (iterator2.hasNext()) {
            Pair<K, V> pair = iterator2.next();
            K key = pair.component1();
            V value = pair.component2();
            $this$putAll.put(key, value);
        }
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R> Map<K, R> mapValues(@NotNull Map<? extends K, ? extends V> $this$mapValues, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        void $this$mapValuesTo$iv;
        Intrinsics.checkNotNullParameter($this$mapValues, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean $i$f$mapValues = false;
        Map<K, V> map = $this$mapValues;
        Map destination$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues.size()));
        boolean $i$f$mapValuesTo = false;
        Iterable $this$associateByTo$iv$iv = $this$mapValuesTo$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv;
            Map map2 = destination$iv;
            boolean bl2 = false;
            map2.put(it$iv.getKey(), transform.invoke((Map.Entry<K, V>)element$iv$iv));
        }
        return destination$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V, R> Map<R, V> mapKeys(@NotNull Map<? extends K, ? extends V> $this$mapKeys, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        void $this$mapKeysTo$iv;
        Intrinsics.checkNotNullParameter($this$mapKeys, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        boolean $i$f$mapKeys = false;
        Map<K, V> map = $this$mapKeys;
        Map destination$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys.size()));
        boolean $i$f$mapKeysTo = false;
        Iterable $this$associateByTo$iv$iv = $this$mapKeysTo$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it$iv;
            Map.Entry entry = (Map.Entry)element$iv$iv;
            R r2 = transform.invoke((Map.Entry<K, V>)element$iv$iv);
            Map map2 = destination$iv;
            boolean bl2 = false;
            Object v2 = it$iv.getValue();
            map2.put(r2, v2);
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, V> Map<K, V> filterKeys(@NotNull Map<? extends K, ? extends V> $this$filterKeys, @NotNull Function1<? super K, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterKeys, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$filterKeys = false;
        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : $this$filterKeys.entrySet()) {
            if (!predicate.invoke(entry.getKey()).booleanValue()) continue;
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @NotNull
    public static final <K, V> Map<K, V> filterValues(@NotNull Map<? extends K, ? extends V> $this$filterValues, @NotNull Function1<? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterValues, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$filterValues = false;
        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : $this$filterValues.entrySet()) {
            if (!predicate.invoke(entry.getValue()).booleanValue()) continue;
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(@NotNull Map<? extends K, ? extends V> $this$filterTo, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$filterTo = false;
        for (Map.Entry<K, V> element : $this$filterTo.entrySet()) {
            if (!predicate.invoke(element).booleanValue()) continue;
            destination.put(element.getKey(), element.getValue());
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> filter(@NotNull Map<? extends K, ? extends V> $this$filter, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        void $this$filterTo$iv;
        Intrinsics.checkNotNullParameter($this$filter, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$filter = false;
        Map<? extends K, ? extends V> map = $this$filter;
        Map destination$iv = new LinkedHashMap();
        boolean $i$f$filterTo = false;
        for (Map.Entry element$iv : $this$filterTo$iv.entrySet()) {
            if (!predicate.invoke(element$iv).booleanValue()) continue;
            destination$iv.put(element$iv.getKey(), element$iv.getValue());
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(@NotNull Map<? extends K, ? extends V> $this$filterNotTo, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterNotTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$filterNotTo = false;
        for (Map.Entry<K, V> element : $this$filterNotTo.entrySet()) {
            if (predicate.invoke(element).booleanValue()) continue;
            destination.put(element.getKey(), element.getValue());
        }
        return destination;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> filterNot(@NotNull Map<? extends K, ? extends V> $this$filterNot, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        void $this$filterNotTo$iv;
        Intrinsics.checkNotNullParameter($this$filterNot, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$filterNot = false;
        Map<? extends K, ? extends V> map = $this$filterNot;
        Map destination$iv = new LinkedHashMap();
        boolean $i$f$filterNotTo = false;
        for (Map.Entry element$iv : $this$filterNotTo$iv.entrySet()) {
            if (predicate.invoke(element$iv).booleanValue()) continue;
            destination$iv.put(element$iv.getKey(), element$iv.getValue());
        }
        return destination$iv;
    }

    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> $this$toMap) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        if ($this$toMap instanceof Collection) {
            Map map;
            switch (((Collection)$this$toMap).size()) {
                case 0: {
                    map = MapsKt.emptyMap();
                    break;
                }
                case 1: {
                    map = MapsKt.mapOf($this$toMap instanceof List ? (Pair)((List)$this$toMap).get(0) : (Pair)((Collection)$this$toMap).iterator().next());
                    break;
                }
                default: {
                    map = MapsKt.toMap($this$toMap, (Map)new LinkedHashMap(MapsKt.mapCapacity(((Collection)$this$toMap).size())));
                }
            }
            return map;
        }
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap($this$toMap, (Map)new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> $this$toMap, @NotNull M destination) {
        M m2;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        M $this$toMap_u24lambda_u244 = m2 = destination;
        boolean bl2 = false;
        MapsKt.putAll($this$toMap_u24lambda_u244, $this$toMap);
        return m2;
    }

    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Pair<? extends K, ? extends V>[] $this$toMap) {
        Map<Object, Object> map;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        switch ($this$toMap.length) {
            case 0: {
                map = MapsKt.emptyMap();
                break;
            }
            case 1: {
                map = MapsKt.mapOf($this$toMap[0]);
                break;
            }
            default: {
                map = MapsKt.toMap($this$toMap, (Map)new LinkedHashMap(MapsKt.mapCapacity($this$toMap.length)));
            }
        }
        return map;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Pair<? extends K, ? extends V>[] $this$toMap, @NotNull M destination) {
        M m2;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        M $this$toMap_u24lambda_u245 = m2 = destination;
        boolean bl2 = false;
        MapsKt.putAll($this$toMap_u24lambda_u245, $this$toMap);
        return m2;
    }

    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> $this$toMap) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap($this$toMap, (Map)new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Sequence<? extends Pair<? extends K, ? extends V>> $this$toMap, @NotNull M destination) {
        M m2;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        M $this$toMap_u24lambda_u246 = m2 = destination;
        boolean bl2 = false;
        MapsKt.putAll($this$toMap_u24lambda_u246, $this$toMap);
        return m2;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> toMap(@NotNull Map<? extends K, ? extends V> $this$toMap) {
        Map<Object, Object> map;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        switch ($this$toMap.size()) {
            case 0: {
                map = MapsKt.emptyMap();
                break;
            }
            case 1: {
                map = MapsKt.toSingletonMap($this$toMap);
                break;
            }
            default: {
                map = MapsKt.toMutableMap($this$toMap);
            }
        }
        return map;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> toMutableMap(@NotNull Map<? extends K, ? extends V> $this$toMutableMap) {
        Intrinsics.checkNotNullParameter($this$toMutableMap, "<this>");
        return new LinkedHashMap<K, V>($this$toMutableMap);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(@NotNull Map<? extends K, ? extends V> $this$toMap, @NotNull M destination) {
        M m2;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        M $this$toMap_u24lambda_u247 = m2 = destination;
        boolean bl2 = false;
        $this$toMap_u24lambda_u247.putAll($this$toMap);
        return m2;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $this$plus, @NotNull Pair<? extends K, ? extends V> pair) {
        Map map;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        if ($this$plus.isEmpty()) {
            map = MapsKt.mapOf(pair);
        } else {
            LinkedHashMap<K, V> linkedHashMap;
            LinkedHashMap<K, V> $this$plus_u24lambda_u248 = linkedHashMap = new LinkedHashMap<K, V>($this$plus);
            boolean bl2 = false;
            $this$plus_u24lambda_u248.put(pair.getFirst(), pair.getSecond());
            map = linkedHashMap;
        }
        return map;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $this$plus, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Map map;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        if ($this$plus.isEmpty()) {
            map = MapsKt.toMap(pairs);
        } else {
            LinkedHashMap<? extends K, ? extends V> linkedHashMap;
            LinkedHashMap<? extends K, ? extends V> $this$plus_u24lambda_u249 = linkedHashMap = new LinkedHashMap<K, V>($this$plus);
            boolean bl2 = false;
            MapsKt.putAll((Map)$this$plus_u24lambda_u249, pairs);
            map = linkedHashMap;
        }
        return map;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $this$plus, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        Map map;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        if ($this$plus.isEmpty()) {
            map = MapsKt.toMap(pairs);
        } else {
            LinkedHashMap<? extends K, ? extends V> linkedHashMap;
            LinkedHashMap<? extends K, ? extends V> $this$plus_u24lambda_u2410 = linkedHashMap = new LinkedHashMap<K, V>($this$plus);
            boolean bl2 = false;
            MapsKt.putAll((Map)$this$plus_u24lambda_u2410, pairs);
            map = linkedHashMap;
        }
        return map;
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $this$plus, @NotNull Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        LinkedHashMap<? extends K, ? extends V> linkedHashMap;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        LinkedHashMap<? extends K, ? extends V> $this$plus_u24lambda_u2411 = linkedHashMap = new LinkedHashMap<K, V>($this$plus);
        boolean bl2 = false;
        MapsKt.putAll((Map)$this$plus_u24lambda_u2411, pairs);
        return MapsKt.optimizeReadOnlyMap((Map)linkedHashMap);
    }

    @NotNull
    public static final <K, V> Map<K, V> plus(@NotNull Map<? extends K, ? extends V> $this$plus, @NotNull Map<? extends K, ? extends V> map) {
        LinkedHashMap<? extends K, ? extends V> linkedHashMap;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap<? extends K, ? extends V> $this$plus_u24lambda_u2412 = linkedHashMap = new LinkedHashMap<K, V>($this$plus);
        boolean bl2 = false;
        $this$plus_u24lambda_u2412.putAll(map);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        $this$plusAssign.put(pair.getFirst(), pair.getSecond());
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MapsKt.putAll($this$plusAssign, pairs);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MapsKt.putAll($this$plusAssign, pairs);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MapsKt.putAll($this$plusAssign, pairs);
    }

    @InlineOnly
    private static final <K, V> void plusAssign(Map<? super K, ? super V> $this$plusAssign, Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        $this$plusAssign.putAll(map);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $this$minus, K key) {
        Map<K, V> map;
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Map<K, V> $this$minus_u24lambda_u2413 = map = MapsKt.toMutableMap($this$minus);
        boolean bl2 = false;
        $this$minus_u24lambda_u2413.remove(key);
        return MapsKt.optimizeReadOnlyMap(map);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $this$minus, @NotNull Iterable<? extends K> keys) {
        Map<K, V> map;
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Map<K, V> $this$minus_u24lambda_u2414 = map = MapsKt.toMutableMap($this$minus);
        boolean bl2 = false;
        CollectionsKt.removeAll((Collection)$this$minus_u24lambda_u2414.keySet(), keys);
        return MapsKt.optimizeReadOnlyMap(map);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $this$minus, @NotNull K[] keys) {
        Map<K, V> map;
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Map<K, V> $this$minus_u24lambda_u2415 = map = MapsKt.toMutableMap($this$minus);
        boolean bl2 = false;
        CollectionsKt.removeAll((Collection)$this$minus_u24lambda_u2415.keySet(), keys);
        return MapsKt.optimizeReadOnlyMap(map);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <K, V> Map<K, V> minus(@NotNull Map<? extends K, ? extends V> $this$minus, @NotNull Sequence<? extends K> keys) {
        Map<K, V> map;
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Map<K, V> $this$minus_u24lambda_u2416 = map = MapsKt.toMutableMap($this$minus);
        boolean bl2 = false;
        CollectionsKt.removeAll((Collection)$this$minus_u24lambda_u2416.keySet(), keys);
        return MapsKt.optimizeReadOnlyMap(map);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, K key) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        $this$minusAssign.remove(key);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        CollectionsKt.removeAll((Collection)$this$minusAssign.keySet(), keys);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, K[] keys) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        CollectionsKt.removeAll((Collection)$this$minusAssign.keySet(), keys);
    }

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <K, V> void minusAssign(Map<K, V> $this$minusAssign, Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        CollectionsKt.removeAll((Collection)$this$minusAssign.keySet(), keys);
    }

    @NotNull
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(@NotNull Map<K, ? extends V> $this$optimizeReadOnlyMap) {
        Map<K, Object> map;
        Intrinsics.checkNotNullParameter($this$optimizeReadOnlyMap, "<this>");
        switch ($this$optimizeReadOnlyMap.size()) {
            case 0: {
                map = MapsKt.emptyMap();
                break;
            }
            case 1: {
                map = MapsKt.toSingletonMap($this$optimizeReadOnlyMap);
                break;
            }
            default: {
                map = $this$optimizeReadOnlyMap;
            }
        }
        return map;
    }
}

