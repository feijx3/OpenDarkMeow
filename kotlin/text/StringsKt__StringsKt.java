/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.OverloadResolutionByLambdaReturnType
 *  kotlin.ReplaceWith
 *  kotlin.SinceKotlin
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.LinesIterator;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\u0006*\u00020\u00062\n\u0010\t\u001a\u00020\n\"\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\u0000\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a \u0010\u0010\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\u0011\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\n\u0010\u0013\u001a\u00020\u0005*\u00020\u0001\u001a\r\u0010\u0014\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a \u0010\u0015\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0086\u0002\u001a\u000f\u0010\u0018\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0087\b\u001aD\u0010\u0019\u001a\u0002H\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0001*\u0002H\u001a\"\u0004\b\u0001\u0010\u001a*\u0002H\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u001e\u001aD\u0010\u001f\u001a\u0002H\u001a\"\f\b\u0000\u0010\u001b*\u00020\u0001*\u0002H\u001a\"\u0004\b\u0001\u0010\u001a*\u0002H\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u00a2\u0006\u0002\u0010\u001e\u001a\u0012\u0010'\u001a\u00020\u0005*\u00020\u00012\u0006\u0010(\u001a\u00020\r\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!\u001a\u0012\u0010+\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u001d\u0010+\u001a\u00020\u0001*\u00020\u00062\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\rH\u0087\b\u001a\u001f\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\rH\u0087\b\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u001c\u00100\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00100\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00103\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00103\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00104\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00105\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001c\u00105\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\"\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0001\u001a%\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0001H\u0087\b\u001a\u001a\u00106\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!2\u0006\u00107\u001a\u00020\u0001\u001a\u001d\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!2\u0006\u00107\u001a\u00020\u0001H\u0087\b\u001a\u001a\u00108\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r\u001a\u001d\u00108\u001a\u00020\u0006*\u00020\u00062\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0087\b\u001a\u0012\u00108\u001a\u00020\u0001*\u00020\u00012\u0006\u0010*\u001a\u00020!\u001a\u0015\u00108\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020!H\u0087\b\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u0001\u001a\u0012\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u0001\u001a\u0012\u0010;\u001a\u00020\u0001*\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u0012\u0010;\u001a\u00020\u0006*\u00020\u00062\u0006\u0010<\u001a\u00020\u0001\u001a\u001a\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u001a\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001\u001a\u0012\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u00101\u001a\u00020\u0001\u001a\u0012\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u0001\u001a$\u0010>\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010>\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a$\u0010A\u001a\u00020\u0006*\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u0006\u001a\u001d\u0010B\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020\u0006H\u0087\b\u001a.\u0010B\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0014\b\b\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\b\u00f8\u0001\u0000\u001a\u001d\u0010G\u001a\u00020\u0006*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020\u0006H\u0087\b\u001a)\u0010H\u001a\u00020\u0006*\u00020\u00062\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\bI\u001a)\u0010H\u001a\u00020\u0006*\u00020\u00062\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\bJ\u001a\u0015\u0010K\u001a\u00020\u0005*\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0087\f\u001a4\u0010L\u001a\u00020\u0005*\u00020\u00012\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0005H\u0000\u001a\u001c\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010S\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a$\u0010Q\u001a\u00020\u0005*\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010S\u001a\u00020\u0005*\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010T\u001a\u00020\u0006*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001c\u0010U\u001a\u00020\u0006*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010V\u001a\u00020\r*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010W\u001a\u00020\r*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a;\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u0005H\u0002\u00a2\u0006\u0002\bZ\u001aE\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\u0006\u0010.\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0002\u00a2\u0006\u0002\b_\u001a:\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a:\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a,\u0010V\u001a\u00020\r*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a,\u0010W\u001a\u00020\r*\u00020\u00012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010X\u001a\u00020\r*\u00020\u00012\u0006\u0010a\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010b\u001a\u00020\r*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a&\u0010b\u001a\u00020\r*\u00020\u00012\u0006\u0010a\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u0005\u001a\u001f\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\b\u0002\u0010P\u001a\u00020\u0005H\u0086\u0002\u001a\u001f\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u0005H\u0086\u0002\u001a\u0015\u0010c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0087\n\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u0006\u0010f\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\rH\u0002\u00a2\u0006\u0002\bh\u001aG\u0010d\u001a\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u000e\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\rH\u0002\u00a2\u0006\u0004\bh\u0010j\u001a\u0010\u0010k\u001a\u00020l2\u0006\u0010g\u001a\u00020\rH\u0000\u001a=\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u00a2\u0006\u0002\u0010n\u001a=\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0012\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u00a2\u0006\u0002\u0010q\u001a0\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\n\u0010f\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u001a0\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\n\u0010f\u001a\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010g\u001a\u00020\r\u001a/\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u00101\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\rH\u0002\u00a2\u0006\u0002\br\u001a%\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010g\u001a\u00020\rH\u0087\b\u001a%\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010g\u001a\u00020\rH\u0087\b\u001a\u0010\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u0001\u001a\u0010\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u0001\u001a\u0018\u0010u\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0018\u0010v\u001a\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010w\u001a\u00020\u0005*\u00020\u0006H\u0007\u001a\u0013\u0010x\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010y\"\u0015\u0010 \u001a\u00020!*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0015\u0010$\u001a\u00020\r*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006z"}, d2={"trim", "", "predicate", "Lkotlin/Function1;", "", "", "", "trimStart", "trimEnd", "chars", "", "padStart", "length", "", "padChar", "padEnd", "isNullOrEmpty", "isEmpty", "isNotEmpty", "isBlank", "isNotBlank", "isNullOrBlank", "iterator", "Lkotlin/collections/CharIterator;", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifBlank", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/lang/CharSequence;)I", "hasSurrogatePairAt", "index", "substring", "range", "subSequence", "start", "end", "startIndex", "endIndex", "substringBefore", "delimiter", "missingDelimiterValue", "substringAfter", "substringBeforeLast", "substringAfterLast", "replaceRange", "replacement", "removeRange", "removePrefix", "prefix", "removeSuffix", "suffix", "removeSurrounding", "replaceBefore", "replaceAfter", "replaceAfterLast", "replaceBeforeLast", "replace", "regex", "Lkotlin/text/Regex;", "transform", "Lkotlin/text/MatchResult;", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "matches", "regionMatchesImpl", "thisOffset", "other", "otherOffset", "ignoreCase", "startsWith", "char", "endsWith", "commonPrefixWith", "commonSuffixWith", "indexOfAny", "lastIndexOfAny", "indexOf", "last", "indexOf$StringsKt__StringsKt", "findAnyOf", "Lkotlin/Pair;", "strings", "", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "string", "lastIndexOf", "contains", "rangesDelimitedBy", "Lkotlin/sequences/Sequence;", "delimiters", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "requireNonNegativeLimit", "", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "split", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "lineSequence", "lines", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
@SourceDebugExtension(value={"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1580:1\n78#1,22:1581\n112#1,5:1603\n129#1,5:1608\n78#1,22:1613\n106#1:1635\n78#1,22:1636\n112#1,5:1658\n123#1:1663\n112#1,5:1664\n129#1,5:1669\n140#1:1674\n129#1,5:1675\n78#1,22:1680\n112#1,5:1702\n129#1,5:1707\n1069#2,2:1712\n12717#3,2:1714\n12717#3,2:1716\n295#4,2:1718\n295#4,2:1720\n1563#4:1723\n1634#4,3:1724\n1563#4:1727\n1634#4,3:1728\n1#5:1722\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n106#1:1581,22\n123#1:1603,5\n140#1:1608,5\n145#1:1613,22\n150#1:1635\n150#1:1636,22\n155#1:1658,5\n160#1:1663\n160#1:1664,5\n165#1:1669,5\n170#1:1674\n170#1:1675,5\n175#1:1680,22\n186#1:1702,5\n197#1:1707,5\n310#1:1712,2\n967#1:1714,2\n991#1:1716,2\n1030#1:1718,2\n1036#1:1720,2\n1401#1:1723\n1401#1:1724,3\n1427#1:1727\n1427#1:1728,3\n*E\n"})
class StringsKt__StringsKt
extends StringsKt__StringsJVMKt {
    @NotNull
    public static final CharSequence trim(@NotNull CharSequence $this$trim, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$trim = false;
        int startIndex = 0;
        int endIndex = $this$trim.length() - 1;
        boolean startFound = false;
        while (startIndex <= endIndex) {
            int index = !startFound ? startIndex : endIndex;
            boolean match = predicate.invoke(Character.valueOf($this$trim.charAt(index)));
            if (!startFound) {
                if (!match) {
                    startFound = true;
                    continue;
                }
                ++startIndex;
                continue;
            }
            if (!match) break;
            --endIndex;
        }
        return $this$trim.subSequence(startIndex, endIndex + 1);
    }

    @NotNull
    public static final String trim(@NotNull String $this$trim, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$trim = false;
        CharSequence $this$trim$iv = $this$trim;
        boolean $i$f$trim2 = false;
        int startIndex$iv = 0;
        int endIndex$iv = $this$trim$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            boolean match$iv = predicate.invoke(Character.valueOf($this$trim$iv.charAt(index$iv)));
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                    continue;
                }
                ++startIndex$iv;
                continue;
            }
            if (!match$iv) break;
            --endIndex$iv;
        }
        return ((Object)$this$trim$iv.subSequence(startIndex$iv, endIndex$iv + 1)).toString();
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence $this$trimStart, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$trimStart = false;
        int n2 = $this$trimStart.length();
        for (int index = 0; index < n2; ++index) {
            if (predicate.invoke(Character.valueOf($this$trimStart.charAt(index))).booleanValue()) continue;
            return $this$trimStart.subSequence(index, $this$trimStart.length());
        }
        return "";
    }

    @NotNull
    public static final String trimStart(@NotNull String $this$trimStart, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        block1: {
            Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            boolean $i$f$trimStart = false;
            CharSequence $this$trimStart$iv = $this$trimStart;
            boolean $i$f$trimStart2 = false;
            int n2 = $this$trimStart$iv.length();
            for (int index$iv = 0; index$iv < n2; ++index$iv) {
                if (predicate.invoke(Character.valueOf($this$trimStart$iv.charAt(index$iv))).booleanValue()) continue;
                charSequence = $this$trimStart$iv.subSequence(index$iv, $this$trimStart$iv.length());
                break block1;
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence $this$trimEnd, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean $i$f$trimEnd = false;
        int n2 = $this$trimEnd.length() + -1;
        if (0 <= n2) {
            do {
                int index;
                if (predicate.invoke(Character.valueOf($this$trimEnd.charAt(index = n2--))).booleanValue()) continue;
                return $this$trimEnd.subSequence(0, index + 1);
            } while (0 <= n2);
        }
        return "";
    }

    @NotNull
    public static final String trimEnd(@NotNull String $this$trimEnd, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        block2: {
            Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            boolean $i$f$trimEnd = false;
            CharSequence $this$trimEnd$iv = $this$trimEnd;
            boolean $i$f$trimEnd2 = false;
            int n2 = $this$trimEnd$iv.length() + -1;
            if (0 <= n2) {
                do {
                    int index$iv;
                    if (predicate.invoke(Character.valueOf($this$trimEnd$iv.charAt(index$iv = n2--))).booleanValue()) continue;
                    charSequence = $this$trimEnd$iv.subSequence(0, index$iv + 1);
                    break block2;
                } while (0 <= n2);
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence $this$trim, char ... chars) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        CharSequence $this$trim$iv = $this$trim;
        boolean $i$f$trim = false;
        int startIndex$iv = 0;
        int endIndex$iv = $this$trim$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            char it = $this$trim$iv.charAt(index$iv);
            boolean bl2 = false;
            boolean match$iv = ArraysKt.contains(chars, it);
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                    continue;
                }
                ++startIndex$iv;
                continue;
            }
            if (!match$iv) break;
            --endIndex$iv;
        }
        return $this$trim$iv.subSequence(startIndex$iv, endIndex$iv + 1);
    }

    @NotNull
    public static final String trim(@NotNull String $this$trim, char ... chars) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        String $this$trim$iv = $this$trim;
        boolean $i$f$trim = false;
        CharSequence $this$trim$iv$iv = $this$trim$iv;
        boolean $i$f$trim2 = false;
        int startIndex$iv$iv = 0;
        int endIndex$iv$iv = $this$trim$iv$iv.length() - 1;
        boolean startFound$iv$iv = false;
        while (startIndex$iv$iv <= endIndex$iv$iv) {
            int index$iv$iv = !startFound$iv$iv ? startIndex$iv$iv : endIndex$iv$iv;
            char it = $this$trim$iv$iv.charAt(index$iv$iv);
            boolean bl2 = false;
            boolean match$iv$iv = ArraysKt.contains(chars, it);
            if (!startFound$iv$iv) {
                if (!match$iv$iv) {
                    startFound$iv$iv = true;
                    continue;
                }
                ++startIndex$iv$iv;
                continue;
            }
            if (!match$iv$iv) break;
            --endIndex$iv$iv;
        }
        return ((Object)$this$trim$iv$iv.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1)).toString();
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence $this$trimStart, char ... chars) {
        CharSequence charSequence;
        block1: {
            Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
            Intrinsics.checkNotNullParameter(chars, "chars");
            CharSequence $this$trimStart$iv = $this$trimStart;
            boolean $i$f$trimStart = false;
            int n2 = $this$trimStart$iv.length();
            for (int index$iv = 0; index$iv < n2; ++index$iv) {
                char it = $this$trimStart$iv.charAt(index$iv);
                boolean bl2 = false;
                if (ArraysKt.contains(chars, it)) continue;
                charSequence = $this$trimStart$iv.subSequence(index$iv, $this$trimStart$iv.length());
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    @NotNull
    public static final String trimStart(@NotNull String $this$trimStart, char ... chars) {
        CharSequence charSequence;
        block1: {
            Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
            Intrinsics.checkNotNullParameter(chars, "chars");
            String $this$trimStart$iv = $this$trimStart;
            boolean $i$f$trimStart = false;
            CharSequence $this$trimStart$iv$iv = $this$trimStart$iv;
            boolean $i$f$trimStart2 = false;
            int n2 = $this$trimStart$iv$iv.length();
            for (int index$iv$iv = 0; index$iv$iv < n2; ++index$iv$iv) {
                char it = $this$trimStart$iv$iv.charAt(index$iv$iv);
                boolean bl2 = false;
                if (ArraysKt.contains(chars, it)) continue;
                charSequence = $this$trimStart$iv$iv.subSequence(index$iv$iv, $this$trimStart$iv$iv.length());
                break block1;
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence $this$trimEnd, char ... chars) {
        CharSequence charSequence;
        block2: {
            Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
            Intrinsics.checkNotNullParameter(chars, "chars");
            CharSequence $this$trimEnd$iv = $this$trimEnd;
            boolean $i$f$trimEnd = false;
            int n2 = $this$trimEnd$iv.length() + -1;
            if (0 <= n2) {
                do {
                    int index$iv = n2--;
                    char it = $this$trimEnd$iv.charAt(index$iv);
                    boolean bl2 = false;
                    if (ArraysKt.contains(chars, it)) continue;
                    charSequence = $this$trimEnd$iv.subSequence(0, index$iv + 1);
                    break block2;
                } while (0 <= n2);
            }
            charSequence = "";
        }
        return charSequence;
    }

    @NotNull
    public static final String trimEnd(@NotNull String $this$trimEnd, char ... chars) {
        CharSequence charSequence;
        block2: {
            Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
            Intrinsics.checkNotNullParameter(chars, "chars");
            String $this$trimEnd$iv = $this$trimEnd;
            boolean $i$f$trimEnd = false;
            CharSequence $this$trimEnd$iv$iv = $this$trimEnd$iv;
            boolean $i$f$trimEnd2 = false;
            int n2 = $this$trimEnd$iv$iv.length() + -1;
            if (0 <= n2) {
                do {
                    int index$iv$iv = n2--;
                    char it = $this$trimEnd$iv$iv.charAt(index$iv$iv);
                    boolean bl2 = false;
                    if (ArraysKt.contains(chars, it)) continue;
                    charSequence = $this$trimEnd$iv$iv.subSequence(0, index$iv$iv + 1);
                    break block2;
                } while (0 <= n2);
            }
            charSequence = "";
        }
        return ((Object)charSequence).toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence $this$trim) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        CharSequence $this$trim$iv = $this$trim;
        boolean $i$f$trim = false;
        int startIndex$iv = 0;
        int endIndex$iv = $this$trim$iv.length() - 1;
        boolean startFound$iv = false;
        while (startIndex$iv <= endIndex$iv) {
            int index$iv = !startFound$iv ? startIndex$iv : endIndex$iv;
            char p0 = $this$trim$iv.charAt(index$iv);
            boolean bl2 = false;
            boolean match$iv = CharsKt.isWhitespace(p0);
            if (!startFound$iv) {
                if (!match$iv) {
                    startFound$iv = true;
                    continue;
                }
                ++startIndex$iv;
                continue;
            }
            if (!match$iv) break;
            --endIndex$iv;
        }
        return $this$trim$iv.subSequence(startIndex$iv, endIndex$iv + 1);
    }

    @InlineOnly
    private static final String trim(String $this$trim) {
        Intrinsics.checkNotNullParameter($this$trim, "<this>");
        return ((Object)StringsKt.trim((CharSequence)$this$trim)).toString();
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence $this$trimStart) {
        CharSequence charSequence;
        block1: {
            Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
            CharSequence $this$trimStart$iv = $this$trimStart;
            boolean $i$f$trimStart = false;
            int n2 = $this$trimStart$iv.length();
            for (int index$iv = 0; index$iv < n2; ++index$iv) {
                char p0 = $this$trimStart$iv.charAt(index$iv);
                boolean bl2 = false;
                if (CharsKt.isWhitespace(p0)) continue;
                charSequence = $this$trimStart$iv.subSequence(index$iv, $this$trimStart$iv.length());
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    @InlineOnly
    private static final String trimStart(String $this$trimStart) {
        Intrinsics.checkNotNullParameter($this$trimStart, "<this>");
        return ((Object)StringsKt.trimStart((CharSequence)$this$trimStart)).toString();
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence $this$trimEnd) {
        CharSequence charSequence;
        block2: {
            Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
            CharSequence $this$trimEnd$iv = $this$trimEnd;
            boolean $i$f$trimEnd = false;
            int n2 = $this$trimEnd$iv.length() + -1;
            if (0 <= n2) {
                do {
                    int index$iv = n2--;
                    char p0 = $this$trimEnd$iv.charAt(index$iv);
                    boolean bl2 = false;
                    if (CharsKt.isWhitespace(p0)) continue;
                    charSequence = $this$trimEnd$iv.subSequence(0, index$iv + 1);
                    break block2;
                } while (0 <= n2);
            }
            charSequence = "";
        }
        return charSequence;
    }

    @InlineOnly
    private static final String trimEnd(String $this$trimEnd) {
        Intrinsics.checkNotNullParameter($this$trimEnd, "<this>");
        return ((Object)StringsKt.trimEnd((CharSequence)$this$trimEnd)).toString();
    }

    @NotNull
    public static final CharSequence padStart(@NotNull CharSequence $this$padStart, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padStart, "<this>");
        if (length < 0) {
            throw new IllegalArgumentException("Desired length " + length + " is less than zero.");
        }
        if (length <= $this$padStart.length()) {
            return $this$padStart.subSequence(0, $this$padStart.length());
        }
        StringBuilder sb = new StringBuilder(length);
        int i2 = 1;
        int n2 = length - $this$padStart.length();
        if (i2 <= n2) {
            while (true) {
                sb.append(padChar);
                if (i2 == n2) break;
                ++i2;
            }
        }
        sb.append($this$padStart);
        return sb;
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int n2, char c2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            c2 = (char)32;
        }
        return StringsKt.padStart(charSequence, n2, c2);
    }

    @NotNull
    public static final String padStart(@NotNull String $this$padStart, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padStart, "<this>");
        return ((Object)StringsKt.padStart((CharSequence)$this$padStart, length, padChar)).toString();
    }

    public static /* synthetic */ String padStart$default(String string, int n2, char c2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            c2 = (char)32;
        }
        return StringsKt.padStart(string, n2, c2);
    }

    @NotNull
    public static final CharSequence padEnd(@NotNull CharSequence $this$padEnd, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padEnd, "<this>");
        if (length < 0) {
            throw new IllegalArgumentException("Desired length " + length + " is less than zero.");
        }
        if (length <= $this$padEnd.length()) {
            return $this$padEnd.subSequence(0, $this$padEnd.length());
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append($this$padEnd);
        int i2 = 1;
        int n2 = length - $this$padEnd.length();
        if (i2 <= n2) {
            while (true) {
                sb.append(padChar);
                if (i2 == n2) break;
                ++i2;
            }
        }
        return sb;
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int n2, char c2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            c2 = (char)32;
        }
        return StringsKt.padEnd(charSequence, n2, c2);
    }

    @NotNull
    public static final String padEnd(@NotNull String $this$padEnd, int length, char padChar) {
        Intrinsics.checkNotNullParameter($this$padEnd, "<this>");
        return ((Object)StringsKt.padEnd((CharSequence)$this$padEnd, length, padChar)).toString();
    }

    public static /* synthetic */ String padEnd$default(String string, int n2, char c2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            c2 = (char)32;
        }
        return StringsKt.padEnd(string, n2, c2);
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(CharSequence $this$isNullOrEmpty) {
        return $this$isNullOrEmpty == null || $this$isNullOrEmpty.length() == 0;
    }

    @InlineOnly
    private static final boolean isEmpty(CharSequence $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.length() == 0;
    }

    @InlineOnly
    private static final boolean isNotEmpty(CharSequence $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return $this$isNotEmpty.length() > 0;
    }

    public static final boolean isBlank(@NotNull CharSequence $this$isBlank) {
        boolean bl2;
        block1: {
            Intrinsics.checkNotNullParameter($this$isBlank, "<this>");
            CharSequence $this$all$iv = $this$isBlank;
            boolean $i$f$all = false;
            for (int i2 = 0; i2 < $this$all$iv.length(); ++i2) {
                char element$iv;
                char it = element$iv = $this$all$iv.charAt(i2);
                boolean bl3 = false;
                if (CharsKt.isWhitespace(it)) continue;
                bl2 = false;
                break block1;
            }
            bl2 = true;
        }
        return bl2;
    }

    @InlineOnly
    private static final boolean isNotBlank(CharSequence $this$isNotBlank) {
        Intrinsics.checkNotNullParameter($this$isNotBlank, "<this>");
        return !StringsKt.isBlank($this$isNotBlank);
    }

    @InlineOnly
    private static final boolean isNullOrBlank(CharSequence $this$isNullOrBlank) {
        return $this$isNullOrBlank == null || StringsKt.isBlank($this$isNullOrBlank);
    }

    @NotNull
    public static final CharIterator iterator(@NotNull CharSequence $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return new CharIterator($this$iterator){
            private int index;
            final /* synthetic */ CharSequence $this_iterator;
            {
                this.$this_iterator = $receiver;
            }

            public char nextChar() {
                int n2 = this.index;
                this.index = n2 + 1;
                return this.$this_iterator.charAt(n2);
            }

            public boolean hasNext() {
                return this.index < this.$this_iterator.length();
            }
        };
    }

    @InlineOnly
    private static final String orEmpty(String $this$orEmpty) {
        String string = $this$orEmpty;
        if (string == null) {
            string = "";
        }
        return string;
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifEmpty(C $this$ifEmpty, Function0<? extends R> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (R)($this$ifEmpty.length() == 0 ? defaultValue.invoke() : $this$ifEmpty);
    }

    @SinceKotlin(version="1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifBlank(C $this$ifBlank, Function0<? extends R> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (R)(StringsKt.isBlank($this$ifBlank) ? defaultValue.invoke() : $this$ifBlank);
    }

    @NotNull
    public static final IntRange getIndices(@NotNull CharSequence $this$indices) {
        Intrinsics.checkNotNullParameter($this$indices, "<this>");
        return new IntRange(0, $this$indices.length() - 1);
    }

    public static final int getLastIndex(@NotNull CharSequence $this$lastIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndex, "<this>");
        return $this$lastIndex.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@NotNull CharSequence $this$hasSurrogatePairAt, int index) {
        Intrinsics.checkNotNullParameter($this$hasSurrogatePairAt, "<this>");
        return (0 <= index ? index <= $this$hasSurrogatePairAt.length() - 2 : false) && Character.isHighSurrogate($this$hasSurrogatePairAt.charAt(index)) && Character.isLowSurrogate($this$hasSurrogatePairAt.charAt(index + 1));
    }

    @NotNull
    public static final String substring(@NotNull String $this$substring, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String string = $this$substring;
        int n2 = range.getStart();
        int n3 = range.getEndInclusive() + 1;
        String string2 = string.substring(n2, n3);
        Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
        return string2;
    }

    @NotNull
    public static final CharSequence subSequence(@NotNull CharSequence $this$subSequence, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter($this$subSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return $this$subSequence.subSequence(range.getStart(), range.getEndInclusive() + 1);
    }

    @Deprecated(message="Use parameters named startIndex and endIndex.", replaceWith=@ReplaceWith(expression="subSequence(startIndex = start, endIndex = end)", imports={}))
    @InlineOnly
    private static final CharSequence subSequence(String $this$subSequence, int start, int end) {
        Intrinsics.checkNotNullParameter($this$subSequence, "<this>");
        return $this$subSequence.subSequence(start, end);
    }

    @InlineOnly
    private static final String substring(CharSequence $this$substring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        return ((Object)$this$substring.subSequence(startIndex, endIndex)).toString();
    }

    static /* synthetic */ String substring$default(CharSequence $this$substring_u24default, int startIndex, int endIndex, int n2, Object object) {
        if ((n2 & 2) != 0) {
            endIndex = $this$substring_u24default.length();
        }
        Intrinsics.checkNotNullParameter($this$substring_u24default, "<this>");
        return ((Object)$this$substring_u24default.subSequence(startIndex, endIndex)).toString();
    }

    @NotNull
    public static final String substring(@NotNull CharSequence $this$substring, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return ((Object)$this$substring.subSequence(range.getStart(), range.getEndInclusive() + 1)).toString();
    }

    @NotNull
    public static final String substringBefore(@NotNull String $this$substringBefore, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringBefore, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$substringBefore, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringBefore;
            int n2 = 0;
            String string3 = string2.substring(n2, index);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringBefore$default(String string, char c2, String string2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringBefore(string, c2, string2);
    }

    @NotNull
    public static final String substringBefore(@NotNull String $this$substringBefore, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringBefore, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$substringBefore, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringBefore;
            int n2 = 0;
            String string3 = string2.substring(n2, index);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringBefore$default(String string, String string2, String string3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringBefore(string, string2, string3);
    }

    @NotNull
    public static final String substringAfter(@NotNull String $this$substringAfter, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringAfter, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$substringAfter, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringAfter;
            int n2 = index + 1;
            int n3 = $this$substringAfter.length();
            String string3 = string2.substring(n2, n3);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringAfter$default(String string, char c2, String string2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringAfter(string, c2, string2);
    }

    @NotNull
    public static final String substringAfter(@NotNull String $this$substringAfter, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringAfter, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$substringAfter, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringAfter;
            int n2 = index + delimiter.length();
            int n3 = $this$substringAfter.length();
            String string3 = string2.substring(n2, n3);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringAfter$default(String string, String string2, String string3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringAfter(string, string2, string3);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String $this$substringBeforeLast, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$substringBeforeLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringBeforeLast;
            int n2 = 0;
            String string3 = string2.substring(n2, index);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringBeforeLast$default(String string, char c2, String string2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringBeforeLast(string, c2, string2);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String $this$substringBeforeLast, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$substringBeforeLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringBeforeLast;
            int n2 = 0;
            String string3 = string2.substring(n2, index);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringBeforeLast$default(String string, String string2, String string3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringBeforeLast(string, string2, string3);
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String $this$substringAfterLast, char delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$substringAfterLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringAfterLast;
            int n2 = index + 1;
            int n3 = $this$substringAfterLast.length();
            String string3 = string2.substring(n2, n3);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringAfterLast$default(String string, char c2, String string2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string2 = string;
        }
        return StringsKt.substringAfterLast(string, c2, string2);
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String $this$substringAfterLast, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$substringAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$substringAfterLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$substringAfterLast;
            int n2 = index + delimiter.length();
            int n3 = $this$substringAfterLast.length();
            String string3 = string2.substring(n2, n3);
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        }
        return string;
    }

    public static /* synthetic */ String substringAfterLast$default(String string, String string2, String string3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = string;
        }
        return StringsKt.substringAfterLast(string, string2, string3);
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence $this$replaceRange, int startIndex, int endIndex, @NotNull CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (endIndex < startIndex) {
            throw new IndexOutOfBoundsException("End index (" + endIndex + ") is less than start index (" + startIndex + ").");
        }
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(sb.append($this$replaceRange, 0, startIndex), "append(...)");
        sb.append(replacement);
        Intrinsics.checkNotNullExpressionValue(sb.append($this$replaceRange, endIndex, $this$replaceRange.length()), "append(...)");
        return sb;
    }

    @InlineOnly
    private static final String replaceRange(String $this$replaceRange, int startIndex, int endIndex, CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return ((Object)StringsKt.replaceRange((CharSequence)$this$replaceRange, startIndex, endIndex, replacement)).toString();
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence $this$replaceRange, @NotNull IntRange range, @NotNull CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return StringsKt.replaceRange($this$replaceRange, (int)range.getStart(), range.getEndInclusive() + 1, replacement);
    }

    @InlineOnly
    private static final String replaceRange(String $this$replaceRange, IntRange range, CharSequence replacement) {
        Intrinsics.checkNotNullParameter($this$replaceRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return ((Object)StringsKt.replaceRange((CharSequence)$this$replaceRange, range, replacement)).toString();
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence $this$removeRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        if (endIndex < startIndex) {
            throw new IndexOutOfBoundsException("End index (" + endIndex + ") is less than start index (" + startIndex + ").");
        }
        if (endIndex == startIndex) {
            return $this$removeRange.subSequence(0, $this$removeRange.length());
        }
        StringBuilder sb = new StringBuilder($this$removeRange.length() - (endIndex - startIndex));
        Intrinsics.checkNotNullExpressionValue(sb.append($this$removeRange, 0, startIndex), "append(...)");
        Intrinsics.checkNotNullExpressionValue(sb.append($this$removeRange, endIndex, $this$removeRange.length()), "append(...)");
        return sb;
    }

    @InlineOnly
    private static final String removeRange(String $this$removeRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        return ((Object)StringsKt.removeRange((CharSequence)$this$removeRange, startIndex, endIndex)).toString();
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence $this$removeRange, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return StringsKt.removeRange($this$removeRange, (int)range.getStart(), range.getEndInclusive() + 1);
    }

    @InlineOnly
    private static final String removeRange(String $this$removeRange, IntRange range) {
        Intrinsics.checkNotNullParameter($this$removeRange, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return ((Object)StringsKt.removeRange((CharSequence)$this$removeRange, range)).toString();
    }

    @NotNull
    public static final CharSequence removePrefix(@NotNull CharSequence $this$removePrefix, @NotNull CharSequence prefix) {
        Intrinsics.checkNotNullParameter($this$removePrefix, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (StringsKt.startsWith$default($this$removePrefix, prefix, false, 2, null)) {
            return $this$removePrefix.subSequence(prefix.length(), $this$removePrefix.length());
        }
        return $this$removePrefix.subSequence(0, $this$removePrefix.length());
    }

    @NotNull
    public static final String removePrefix(@NotNull String $this$removePrefix, @NotNull CharSequence prefix) {
        Intrinsics.checkNotNullParameter($this$removePrefix, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (StringsKt.startsWith$default((CharSequence)$this$removePrefix, prefix, false, 2, null)) {
            String string = $this$removePrefix;
            int n2 = prefix.length();
            String string2 = string.substring(n2);
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
            return string2;
        }
        return $this$removePrefix;
    }

    @NotNull
    public static final CharSequence removeSuffix(@NotNull CharSequence $this$removeSuffix, @NotNull CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSuffix, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (StringsKt.endsWith$default($this$removeSuffix, suffix, false, 2, null)) {
            return $this$removeSuffix.subSequence(0, $this$removeSuffix.length() - suffix.length());
        }
        return $this$removeSuffix.subSequence(0, $this$removeSuffix.length());
    }

    @NotNull
    public static final String removeSuffix(@NotNull String $this$removeSuffix, @NotNull CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSuffix, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (StringsKt.endsWith$default((CharSequence)$this$removeSuffix, suffix, false, 2, null)) {
            String string = $this$removeSuffix;
            int n2 = 0;
            int n3 = $this$removeSuffix.length() - suffix.length();
            String string2 = string.substring(n2, n3);
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
            return string2;
        }
        return $this$removeSuffix;
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence $this$removeSurrounding, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if ($this$removeSurrounding.length() >= prefix.length() + suffix.length() && StringsKt.startsWith$default($this$removeSurrounding, prefix, false, 2, null) && StringsKt.endsWith$default($this$removeSurrounding, suffix, false, 2, null)) {
            return $this$removeSurrounding.subSequence(prefix.length(), $this$removeSurrounding.length() - suffix.length());
        }
        return $this$removeSurrounding.subSequence(0, $this$removeSurrounding.length());
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String $this$removeSurrounding, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if ($this$removeSurrounding.length() >= prefix.length() + suffix.length() && StringsKt.startsWith$default((CharSequence)$this$removeSurrounding, prefix, false, 2, null) && StringsKt.endsWith$default((CharSequence)$this$removeSurrounding, suffix, false, 2, null)) {
            String string = $this$removeSurrounding;
            int n2 = prefix.length();
            int n3 = $this$removeSurrounding.length() - suffix.length();
            String string2 = string.substring(n2, n3);
            Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
            return string2;
        }
        return $this$removeSurrounding;
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence $this$removeSurrounding, @NotNull CharSequence delimiter) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return StringsKt.removeSurrounding($this$removeSurrounding, delimiter, delimiter);
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String $this$removeSurrounding, @NotNull CharSequence delimiter) {
        Intrinsics.checkNotNullParameter($this$removeSurrounding, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return StringsKt.removeSurrounding($this$removeSurrounding, delimiter, delimiter);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String $this$replaceBefore, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceBefore, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$replaceBefore, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceBefore;
            int n2 = 0;
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceBefore$default(String string, char c2, String string2, String string3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceBefore(string, c2, string2, string3);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String $this$replaceBefore, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceBefore, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$replaceBefore, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceBefore;
            int n2 = 0;
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceBefore$default(String string, String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceBefore(string, string2, string3, string4);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String $this$replaceAfter, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceAfter, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$replaceAfter, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceAfter;
            int n2 = index + 1;
            int n3 = $this$replaceAfter.length();
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, n3, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceAfter$default(String string, char c2, String string2, String string3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceAfter(string, c2, string2, string3);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String $this$replaceAfter, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceAfter, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.indexOf$default((CharSequence)$this$replaceAfter, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceAfter;
            int n2 = index + delimiter.length();
            int n3 = $this$replaceAfter.length();
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, n3, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceAfter$default(String string, String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceAfter(string, string2, string3, string4);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String $this$replaceAfterLast, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$replaceAfterLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceAfterLast;
            int n2 = index + delimiter.length();
            int n3 = $this$replaceAfterLast.length();
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, n3, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceAfterLast$default(String string, String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceAfterLast(string, string2, string3, string4);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String $this$replaceAfterLast, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceAfterLast, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$replaceAfterLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceAfterLast;
            int n2 = index + 1;
            int n3 = $this$replaceAfterLast.length();
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, n3, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceAfterLast$default(String string, char c2, String string2, String string3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceAfterLast(string, c2, string2, string3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String $this$replaceBeforeLast, char delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$replaceBeforeLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceBeforeLast;
            int n2 = 0;
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceBeforeLast$default(String string, char c2, String string2, String string3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string3 = string;
        }
        return StringsKt.replaceBeforeLast(string, c2, string2, string3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String $this$replaceBeforeLast, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceBeforeLast, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int index = StringsKt.lastIndexOf$default((CharSequence)$this$replaceBeforeLast, delimiter, 0, false, 6, null);
        if (index == -1) {
            string = missingDelimiterValue;
        } else {
            String string2 = $this$replaceBeforeLast;
            int n2 = 0;
            string = ((Object)StringsKt.replaceRange((CharSequence)string2, n2, index, (CharSequence)replacement)).toString();
        }
        return string;
    }

    public static /* synthetic */ String replaceBeforeLast$default(String string, String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string4 = string;
        }
        return StringsKt.replaceBeforeLast(string, string2, string3, string4);
    }

    @InlineOnly
    private static final String replace(CharSequence $this$replace, Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replace($this$replace, replacement);
    }

    @InlineOnly
    private static final String replace(CharSequence $this$replace, Regex regex, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return regex.replace($this$replace, transform);
    }

    @InlineOnly
    private static final String replaceFirst(CharSequence $this$replaceFirst, Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replaceFirst($this$replaceFirst, replacement);
    }

    @SinceKotlin(version="1.5")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name="replaceFirstCharWithChar")
    @InlineOnly
    private static final String replaceFirstCharWithChar(String $this$replaceFirstChar, Function1<? super Character, Character> transform) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceFirstChar, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (((CharSequence)$this$replaceFirstChar).length() > 0) {
            char c2 = transform.invoke(Character.valueOf($this$replaceFirstChar.charAt(0))).charValue();
            String string2 = $this$replaceFirstChar;
            int n2 = 1;
            String string3 = string2.substring(n2);
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
            string2 = string3;
            string = c2 + string2;
        } else {
            string = $this$replaceFirstChar;
        }
        return string;
    }

    @SinceKotlin(version="1.5")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name="replaceFirstCharWithCharSequence")
    @InlineOnly
    private static final String replaceFirstCharWithCharSequence(String $this$replaceFirstChar, Function1<? super Character, ? extends CharSequence> transform) {
        String string;
        Intrinsics.checkNotNullParameter($this$replaceFirstChar, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (((CharSequence)$this$replaceFirstChar).length() > 0) {
            StringBuilder stringBuilder = new StringBuilder().append((Object)transform.invoke(Character.valueOf($this$replaceFirstChar.charAt(0))));
            String string2 = $this$replaceFirstChar;
            int n2 = 1;
            String string3 = string2.substring(n2);
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
            string = stringBuilder.append(string3).toString();
        } else {
            string = $this$replaceFirstChar;
        }
        return string;
    }

    @InlineOnly
    private static final boolean matches(CharSequence $this$matches, Regex regex) {
        Intrinsics.checkNotNullParameter($this$matches, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.matches($this$matches);
    }

    public static final boolean regionMatchesImpl(@NotNull CharSequence $this$regionMatchesImpl, int thisOffset, @NotNull CharSequence other, int otherOffset, int length, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$regionMatchesImpl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (otherOffset < 0 || thisOffset < 0 || thisOffset > $this$regionMatchesImpl.length() - length || otherOffset > other.length() - length) {
            return false;
        }
        for (int index = 0; index < length; ++index) {
            if (CharsKt.equals($this$regionMatchesImpl.charAt(thisOffset + index), other.charAt(otherOffset + index), ignoreCase)) continue;
            return false;
        }
        return true;
    }

    public static final boolean startsWith(@NotNull CharSequence $this$startsWith, char c2, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        return $this$startsWith.length() > 0 && CharsKt.equals($this$startsWith.charAt(0), c2, ignoreCase);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.startsWith(charSequence, c2, bl2);
    }

    public static final boolean endsWith(@NotNull CharSequence $this$endsWith, char c2, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        return $this$endsWith.length() > 0 && CharsKt.equals($this$endsWith.charAt(StringsKt.getLastIndex($this$endsWith)), c2, ignoreCase);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.endsWith(charSequence, c2, bl2);
    }

    public static final boolean startsWith(@NotNull CharSequence $this$startsWith, @NotNull CharSequence prefix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase && $this$startsWith instanceof String && prefix instanceof String) {
            return StringsKt.startsWith$default((String)$this$startsWith, (String)prefix, false, 2, null);
        }
        return StringsKt.regionMatchesImpl($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, bl2);
    }

    public static final boolean startsWith(@NotNull CharSequence $this$startsWith, @NotNull CharSequence prefix, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase && $this$startsWith instanceof String && prefix instanceof String) {
            return StringsKt.startsWith$default((String)$this$startsWith, (String)prefix, startIndex, false, 4, null);
        }
        return StringsKt.regionMatchesImpl($this$startsWith, startIndex, prefix, 0, prefix.length(), ignoreCase);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, n2, bl2);
    }

    public static final boolean endsWith(@NotNull CharSequence $this$endsWith, @NotNull CharSequence suffix, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!ignoreCase && $this$endsWith instanceof String && suffix instanceof String) {
            return StringsKt.endsWith$default((String)$this$endsWith, (String)suffix, false, 2, null);
        }
        return StringsKt.regionMatchesImpl($this$endsWith, $this$endsWith.length() - suffix.length(), suffix, 0, suffix.length(), ignoreCase);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.endsWith(charSequence, charSequence2, bl2);
    }

    @NotNull
    public static final String commonPrefixWith(@NotNull CharSequence $this$commonPrefixWith, @NotNull CharSequence other, boolean ignoreCase) {
        int i2;
        Intrinsics.checkNotNullParameter($this$commonPrefixWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int shortestLength = Math.min($this$commonPrefixWith.length(), other.length());
        for (i2 = 0; i2 < shortestLength && CharsKt.equals($this$commonPrefixWith.charAt(i2), other.charAt(i2), ignoreCase); ++i2) {
        }
        if (StringsKt.hasSurrogatePairAt($this$commonPrefixWith, i2 - 1) || StringsKt.hasSurrogatePairAt(other, i2 - 1)) {
            --i2;
        }
        return ((Object)$this$commonPrefixWith.subSequence(0, i2)).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, bl2);
    }

    @NotNull
    public static final String commonSuffixWith(@NotNull CharSequence $this$commonSuffixWith, @NotNull CharSequence other, boolean ignoreCase) {
        int i2;
        Intrinsics.checkNotNullParameter($this$commonSuffixWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int thisLength = $this$commonSuffixWith.length();
        int otherLength = other.length();
        int shortestLength = Math.min(thisLength, otherLength);
        for (i2 = 0; i2 < shortestLength && CharsKt.equals($this$commonSuffixWith.charAt(thisLength - i2 - 1), other.charAt(otherLength - i2 - 1), ignoreCase); ++i2) {
        }
        if (StringsKt.hasSurrogatePairAt($this$commonSuffixWith, thisLength - i2 - 1) || StringsKt.hasSurrogatePairAt(other, otherLength - i2 - 1)) {
            --i2;
        }
        return ((Object)$this$commonSuffixWith.subSequence(thisLength - i2, thisLength)).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, bl2);
    }

    public static final int indexOfAny(@NotNull CharSequence $this$indexOfAny, @NotNull char[] chars, int startIndex, boolean ignoreCase) {
        int n2;
        Intrinsics.checkNotNullParameter($this$indexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!ignoreCase && chars.length == 1 && $this$indexOfAny instanceof String) {
            char c2 = ArraysKt.single(chars);
            return ((String)$this$indexOfAny).indexOf(c2, startIndex);
        }
        int index = RangesKt.coerceAtLeast(startIndex, 0);
        if (index <= (n2 = StringsKt.getLastIndex($this$indexOfAny))) {
            while (true) {
                boolean bl2;
                block5: {
                    char charAtIndex = $this$indexOfAny.charAt(index);
                    char[] $this$any$iv = chars;
                    boolean $i$f$any = false;
                    int n3 = $this$any$iv.length;
                    for (int i2 = 0; i2 < n3; ++i2) {
                        char element$iv;
                        char it = element$iv = $this$any$iv[i2];
                        boolean bl3 = false;
                        if (!CharsKt.equals(it, charAtIndex, ignoreCase)) continue;
                        bl2 = true;
                        break block5;
                    }
                    bl2 = false;
                }
                if (bl2) {
                    return index;
                }
                if (index == n2) break;
                ++index;
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArray, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.indexOfAny(charSequence, cArray, n2, bl2);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence $this$lastIndexOfAny, @NotNull char[] chars, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$lastIndexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!ignoreCase && chars.length == 1 && $this$lastIndexOfAny instanceof String) {
            char c2 = ArraysKt.single(chars);
            return ((String)$this$lastIndexOfAny).lastIndexOf(c2, startIndex);
        }
        for (int index = RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($this$lastIndexOfAny)); -1 < index; --index) {
            boolean bl2;
            block3: {
                char charAtIndex = $this$lastIndexOfAny.charAt(index);
                char[] $this$any$iv = chars;
                boolean $i$f$any = false;
                int n2 = $this$any$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    char element$iv;
                    char it = element$iv = $this$any$iv[i2];
                    boolean bl3 = false;
                    if (!CharsKt.equals(it, charAtIndex, ignoreCase)) continue;
                    bl2 = true;
                    break block3;
                }
                bl2 = false;
            }
            if (!bl2) continue;
            return index;
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArray, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = StringsKt.getLastIndex(charSequence);
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, cArray, n2, bl2);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence $this$indexOf, CharSequence other, int startIndex, int endIndex, boolean ignoreCase, boolean last) {
        IntProgression indices;
        IntProgression intProgression = indices = !last ? (IntProgression)new IntRange(RangesKt.coerceAtLeast(startIndex, 0), RangesKt.coerceAtMost(endIndex, $this$indexOf.length())) : RangesKt.downTo(RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($this$indexOf)), RangesKt.coerceAtLeast(endIndex, 0));
        if ($this$indexOf instanceof String && other instanceof String) {
            int index = indices.getFirst();
            int n2 = indices.getLast();
            int n3 = indices.getStep();
            if (n3 > 0 && index <= n2 || n3 < 0 && n2 <= index) {
                while (true) {
                    if (StringsKt.regionMatches((String)other, 0, (String)$this$indexOf, index, ((String)other).length(), ignoreCase)) {
                        return index;
                    }
                    if (index != n2) {
                        index += n3;
                        continue;
                    }
                    break;
                }
            }
        } else {
            int index = indices.getFirst();
            int n4 = indices.getLast();
            int n5 = indices.getStep();
            if (n5 > 0 && index <= n4 || n5 < 0 && n4 <= index) {
                while (true) {
                    if (StringsKt.regionMatchesImpl(other, 0, $this$indexOf, index, other.length(), ignoreCase)) {
                        return index;
                    }
                    if (index == n4) break;
                    index += n5;
                }
            }
        }
        return -1;
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int n2, int n3, boolean bl2, boolean bl3, int n4, Object object) {
        if ((n4 & 0x10) != 0) {
            bl3 = false;
        }
        return StringsKt__StringsKt.indexOf$StringsKt__StringsKt(charSequence, charSequence2, n2, n3, bl2, bl3);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence $this$findAnyOf, Collection<String> strings, int startIndex, boolean ignoreCase, boolean last) {
        IntProgression indices;
        if (!ignoreCase && strings.size() == 1) {
            String string = (String)CollectionsKt.single((Iterable)strings);
            int index = !last ? StringsKt.indexOf$default($this$findAnyOf, string, startIndex, false, 4, null) : StringsKt.lastIndexOf$default($this$findAnyOf, string, startIndex, false, 4, null);
            return index < 0 ? null : TuplesKt.to(index, string);
        }
        IntProgression intProgression = indices = !last ? (IntProgression)new IntRange(RangesKt.coerceAtLeast(startIndex, 0), $this$findAnyOf.length()) : RangesKt.downTo(RangesKt.coerceAtMost(startIndex, StringsKt.getLastIndex($this$findAnyOf)), 0);
        if ($this$findAnyOf instanceof String) {
            int index = indices.getFirst();
            int n2 = indices.getLast();
            int n3 = indices.getStep();
            if (n3 > 0 && index <= n2 || n3 < 0 && n2 <= index) {
                while (true) {
                    Object v1;
                    block12: {
                        Iterable $this$firstOrNull$iv = strings;
                        boolean $i$f$firstOrNull = false;
                        for (Object element$iv : $this$firstOrNull$iv) {
                            String it = (String)element$iv;
                            boolean bl2 = false;
                            if (!StringsKt.regionMatches(it, 0, (String)$this$findAnyOf, index, it.length(), ignoreCase)) continue;
                            v1 = element$iv;
                            break block12;
                        }
                        v1 = null;
                    }
                    String matchingString = v1;
                    if (matchingString != null) {
                        return TuplesKt.to(index, matchingString);
                    }
                    if (index != n2) {
                        index += n3;
                        continue;
                    }
                    break;
                }
            }
        } else {
            int index = indices.getFirst();
            int n4 = indices.getLast();
            int n5 = indices.getStep();
            if (n5 > 0 && index <= n4 || n5 < 0 && n4 <= index) {
                while (true) {
                    Object v2;
                    block14: {
                        Iterable $this$firstOrNull$iv = strings;
                        boolean $i$f$firstOrNull = false;
                        for (Object element$iv : $this$firstOrNull$iv) {
                            String it = (String)element$iv;
                            boolean bl3 = false;
                            if (!StringsKt.regionMatchesImpl(it, 0, $this$findAnyOf, index, it.length(), ignoreCase)) continue;
                            v2 = element$iv;
                            break block14;
                        }
                        v2 = null;
                    }
                    String matchingString = v2;
                    if (matchingString != null) {
                        return TuplesKt.to(index, matchingString);
                    }
                    if (index == n4) break;
                    index += n5;
                }
            }
        }
        return null;
    }

    @Nullable
    public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence $this$findAnyOf, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$findAnyOf, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$findAnyOf, strings, startIndex, ignoreCase, false);
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.findAnyOf(charSequence, collection, n2, bl2);
    }

    @Nullable
    public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence $this$findLastAnyOf, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$findLastAnyOf, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$findLastAnyOf, strings, startIndex, ignoreCase, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = StringsKt.getLastIndex(charSequence);
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.findLastAnyOf(charSequence, collection, n2, bl2);
    }

    public static final int indexOfAny(@NotNull CharSequence $this$indexOfAny, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$indexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair<Integer, String> pair = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$indexOfAny, strings, startIndex, ignoreCase, false);
        return pair != null ? ((Number)pair.getFirst()).intValue() : -1;
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.indexOfAny(charSequence, collection, n2, bl2);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence $this$lastIndexOfAny, @NotNull Collection<String> strings, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$lastIndexOfAny, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair<Integer, String> pair = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$lastIndexOfAny, strings, startIndex, ignoreCase, true);
        return pair != null ? ((Number)pair.getFirst()).intValue() : -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = StringsKt.getLastIndex(charSequence);
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, collection, n2, bl2);
    }

    public static final int indexOf(@NotNull CharSequence $this$indexOf, char c2, int startIndex, boolean ignoreCase) {
        int n2;
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        if (ignoreCase || !($this$indexOf instanceof String)) {
            char[] cArray = new char[]{c2};
            n2 = StringsKt.indexOfAny($this$indexOf, cArray, startIndex, ignoreCase);
        } else {
            n2 = ((String)$this$indexOf).indexOf(c2, startIndex);
        }
        return n2;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.indexOf(charSequence, c2, n2, bl2);
    }

    public static final int indexOf(@NotNull CharSequence $this$indexOf, @NotNull String string, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        return ignoreCase || !($this$indexOf instanceof String) ? StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default($this$indexOf, string, startIndex, $this$indexOf.length(), ignoreCase, false, 16, null) : ((String)$this$indexOf).indexOf(string, startIndex);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String string, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.indexOf(charSequence, string, n2, bl2);
    }

    public static final int lastIndexOf(@NotNull CharSequence $this$lastIndexOf, char c2, int startIndex, boolean ignoreCase) {
        int n2;
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        if (ignoreCase || !($this$lastIndexOf instanceof String)) {
            char[] cArray = new char[]{c2};
            n2 = StringsKt.lastIndexOfAny($this$lastIndexOf, cArray, startIndex, ignoreCase);
        } else {
            n2 = ((String)$this$lastIndexOf).lastIndexOf(c2, startIndex);
        }
        return n2;
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = StringsKt.getLastIndex(charSequence);
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.lastIndexOf(charSequence, c2, n2, bl2);
    }

    public static final int lastIndexOf(@NotNull CharSequence $this$lastIndexOf, @NotNull String string, int startIndex, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        return ignoreCase || !($this$lastIndexOf instanceof String) ? StringsKt__StringsKt.indexOf$StringsKt__StringsKt($this$lastIndexOf, string, startIndex, 0, ignoreCase, true) : ((String)$this$lastIndexOf).lastIndexOf(string, startIndex);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String string, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = StringsKt.getLastIndex(charSequence);
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return StringsKt.lastIndexOf(charSequence, string, n2, bl2);
    }

    public static final boolean contains(@NotNull CharSequence $this$contains, @NotNull CharSequence other, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other instanceof String ? StringsKt.indexOf$default($this$contains, (String)other, 0, ignoreCase, 2, null) >= 0 : StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default($this$contains, other, 0, $this$contains.length(), ignoreCase, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.contains(charSequence, charSequence2, bl2);
    }

    public static final boolean contains(@NotNull CharSequence $this$contains, char c2, boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return StringsKt.indexOf$default($this$contains, c2, 0, ignoreCase, 2, null) >= 0;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return StringsKt.contains(charSequence, c2, bl2);
    }

    @InlineOnly
    private static final boolean contains(CharSequence $this$contains, Regex regex) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.containsMatchIn($this$contains);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence $this$rangesDelimitedBy, char[] delimiters, int startIndex, boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        return new DelimitedRangesSequence($this$rangesDelimitedBy, startIndex, limit, (arg_0, arg_1) -> StringsKt__StringsKt.rangesDelimitedBy$lambda$14$StringsKt__StringsKt(delimiters, ignoreCase, arg_0, arg_1));
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArray, int n2, boolean bl2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) != 0) {
            bl2 = false;
        }
        if ((n4 & 8) != 0) {
            n3 = 0;
        }
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArray, n2, bl2, n3);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence $this$rangesDelimitedBy, String[] delimiters, int startIndex, boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        List<String> delimitersList = ArraysKt.asList(delimiters);
        return new DelimitedRangesSequence($this$rangesDelimitedBy, startIndex, limit, (arg_0, arg_1) -> StringsKt__StringsKt.rangesDelimitedBy$lambda$16$StringsKt__StringsKt(delimitersList, ignoreCase, arg_0, arg_1));
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] stringArray, int n2, boolean bl2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) != 0) {
            bl2 = false;
        }
        if ((n4 & 8) != 0) {
            n3 = 0;
        }
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, stringArray, n2, bl2, n3);
    }

    public static final void requireNonNegativeLimit(int limit) {
        if (!(limit >= 0)) {
            boolean bl2 = false;
            String string = "Limit must be non-negative, but was " + limit;
            throw new IllegalArgumentException(string.toString());
        }
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence $this$splitToSequence, @NotNull String[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($this$splitToSequence, delimiters, 0, ignoreCase, limit, 2, null), arg_0 -> StringsKt__StringsKt.splitToSequence$lambda$18$StringsKt__StringsKt($this$splitToSequence, arg_0));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] stringArray, boolean bl2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return StringsKt.splitToSequence(charSequence, stringArray, bl2, n2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<String> split(@NotNull CharSequence $this$split, @NotNull String[] delimiters, boolean ignoreCase, int limit) {
        void $this$mapTo$iv$iv;
        String delimiter;
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1 && !(((CharSequence)(delimiter = delimiters[0])).length() == 0)) {
            return StringsKt__StringsKt.split$StringsKt__StringsKt($this$split, delimiter, ignoreCase, limit);
        }
        Iterable $this$map$iv = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($this$split, delimiters, 0, ignoreCase, limit, 2, null));
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IntRange intRange = (IntRange)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(StringsKt.substring($this$split, (IntRange)it));
        }
        return (List)destination$iv$iv;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] stringArray, boolean bl2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return StringsKt.split(charSequence, stringArray, bl2, n2);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence $this$splitToSequence, @NotNull char[] delimiters, boolean ignoreCase, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($this$splitToSequence, delimiters, 0, ignoreCase, limit, 2, null), arg_0 -> StringsKt__StringsKt.splitToSequence$lambda$20$StringsKt__StringsKt($this$splitToSequence, arg_0));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArray, boolean bl2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return StringsKt.splitToSequence(charSequence, cArray, bl2, n2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<String> split(@NotNull CharSequence $this$split, @NotNull char[] delimiters, boolean ignoreCase, int limit) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return StringsKt__StringsKt.split$StringsKt__StringsKt($this$split, String.valueOf(delimiters[0]), ignoreCase, limit);
        }
        Iterable $this$map$iv = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default($this$split, delimiters, 0, ignoreCase, limit, 2, null));
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            IntRange intRange = (IntRange)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(StringsKt.substring($this$split, (IntRange)it));
        }
        return (List)destination$iv$iv;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArray, boolean bl2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return StringsKt.split(charSequence, cArray, bl2, n2);
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence $this$split, String delimiter, boolean ignoreCase, int limit) {
        StringsKt.requireNonNegativeLimit(limit);
        int currentOffset = 0;
        int nextIndex = StringsKt.indexOf($this$split, delimiter, currentOffset, ignoreCase);
        if (nextIndex == -1 || limit == 1) {
            return CollectionsKt.listOf(((Object)$this$split).toString());
        }
        boolean isLimited = limit > 0;
        ArrayList<String> result = new ArrayList<String>(isLimited ? RangesKt.coerceAtMost(limit, 10) : 10);
        do {
            result.add(((Object)$this$split.subSequence(currentOffset, nextIndex)).toString());
            currentOffset = nextIndex + delimiter.length();
        } while ((!isLimited || result.size() != limit - 1) && (nextIndex = StringsKt.indexOf($this$split, delimiter, currentOffset, ignoreCase)) != -1);
        result.add(((Object)$this$split.subSequence(currentOffset, $this$split.length())).toString());
        return result;
    }

    @InlineOnly
    private static final List<String> split(CharSequence $this$split, Regex regex, int limit) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split($this$split, limit);
    }

    static /* synthetic */ List split$default(CharSequence $this$split_u24default, Regex regex, int limit, int n2, Object object) {
        if ((n2 & 2) != 0) {
            limit = 0;
        }
        Intrinsics.checkNotNullParameter($this$split_u24default, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split($this$split_u24default, limit);
    }

    @SinceKotlin(version="1.6")
    @InlineOnly
    private static final Sequence<String> splitToSequence(CharSequence $this$splitToSequence, Regex regex, int limit) {
        Intrinsics.checkNotNullParameter($this$splitToSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence($this$splitToSequence, limit);
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence $this$splitToSequence_u24default, Regex regex, int limit, int n2, Object object) {
        if ((n2 & 2) != 0) {
            limit = 0;
        }
        Intrinsics.checkNotNullParameter($this$splitToSequence_u24default, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence($this$splitToSequence_u24default, limit);
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull CharSequence $this$lineSequence) {
        Intrinsics.checkNotNullParameter($this$lineSequence, "<this>");
        return new Sequence<String>($this$lineSequence){
            final /* synthetic */ CharSequence $this_lineSequence$inlined;
            {
                this.$this_lineSequence$inlined = charSequence;
            }

            public Iterator<String> iterator() {
                boolean bl2 = false;
                return new LinesIterator(this.$this_lineSequence$inlined);
            }
        };
    }

    @NotNull
    public static final List<String> lines(@NotNull CharSequence $this$lines) {
        Intrinsics.checkNotNullParameter($this$lines, "<this>");
        return SequencesKt.toList(StringsKt.lineSequence($this$lines));
    }

    public static final boolean contentEqualsIgnoreCaseImpl(@Nullable CharSequence $this$contentEqualsIgnoreCaseImpl, @Nullable CharSequence other) {
        if ($this$contentEqualsIgnoreCaseImpl instanceof String && other instanceof String) {
            return StringsKt.equals((String)$this$contentEqualsIgnoreCaseImpl, (String)other, true);
        }
        if ($this$contentEqualsIgnoreCaseImpl == other) {
            return true;
        }
        if ($this$contentEqualsIgnoreCaseImpl == null || other == null || $this$contentEqualsIgnoreCaseImpl.length() != other.length()) {
            return false;
        }
        int n2 = $this$contentEqualsIgnoreCaseImpl.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (CharsKt.equals($this$contentEqualsIgnoreCaseImpl.charAt(i2), other.charAt(i2), true)) continue;
            return false;
        }
        return true;
    }

    public static final boolean contentEqualsImpl(@Nullable CharSequence $this$contentEqualsImpl, @Nullable CharSequence other) {
        if ($this$contentEqualsImpl instanceof String && other instanceof String) {
            return Intrinsics.areEqual($this$contentEqualsImpl, other);
        }
        if ($this$contentEqualsImpl == other) {
            return true;
        }
        if ($this$contentEqualsImpl == null || other == null || $this$contentEqualsImpl.length() != other.length()) {
            return false;
        }
        int n2 = $this$contentEqualsImpl.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            if ($this$contentEqualsImpl.charAt(i2) == other.charAt(i2)) continue;
            return false;
        }
        return true;
    }

    @SinceKotlin(version="1.5")
    public static final boolean toBooleanStrict(@NotNull String $this$toBooleanStrict) {
        boolean bl2;
        Intrinsics.checkNotNullParameter($this$toBooleanStrict, "<this>");
        String string = $this$toBooleanStrict;
        if (Intrinsics.areEqual(string, "true")) {
            bl2 = true;
        } else if (Intrinsics.areEqual(string, "false")) {
            bl2 = false;
        } else {
            throw new IllegalArgumentException("The string doesn't represent a boolean value: " + $this$toBooleanStrict);
        }
        return bl2;
    }

    @SinceKotlin(version="1.5")
    @Nullable
    public static final Boolean toBooleanStrictOrNull(@NotNull String $this$toBooleanStrictOrNull) {
        Intrinsics.checkNotNullParameter($this$toBooleanStrictOrNull, "<this>");
        String string = $this$toBooleanStrictOrNull;
        return Intrinsics.areEqual(string, "true") ? Boolean.valueOf(true) : (Intrinsics.areEqual(string, "false") ? Boolean.valueOf(false) : null);
    }

    private static final Pair rangesDelimitedBy$lambda$14$StringsKt__StringsKt(char[] $delimiters, boolean $ignoreCase, CharSequence $this$DelimitedRangesSequence, int currentIndex) {
        Intrinsics.checkNotNullParameter($this$DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int it = StringsKt.indexOfAny($this$DelimitedRangesSequence, $delimiters, currentIndex, $ignoreCase);
        boolean bl2 = false;
        return it < 0 ? null : TuplesKt.to(it, 1);
    }

    private static final Pair rangesDelimitedBy$lambda$16$StringsKt__StringsKt(List $delimitersList, boolean $ignoreCase, CharSequence $this$DelimitedRangesSequence, int currentIndex) {
        Pair<Integer, Integer> pair;
        Intrinsics.checkNotNullParameter($this$DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        Pair<Integer, String> pair2 = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($this$DelimitedRangesSequence, $delimitersList, currentIndex, $ignoreCase, false);
        if (pair2 != null) {
            Pair<Integer, String> it = pair2;
            boolean bl2 = false;
            pair = TuplesKt.to(it.getFirst(), it.getSecond().length());
        } else {
            pair = null;
        }
        return pair;
    }

    private static final String splitToSequence$lambda$18$StringsKt__StringsKt(CharSequence $this_splitToSequence, IntRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.substring($this_splitToSequence, it);
    }

    private static final String splitToSequence$lambda$20$StringsKt__StringsKt(CharSequence $this_splitToSequence, IntRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.substring($this_splitToSequence, it);
    }
}

