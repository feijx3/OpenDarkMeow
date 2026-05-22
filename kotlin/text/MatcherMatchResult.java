/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.RegexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "", "getValue", "()Ljava/lang/String;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "groupValues_", "", "groupValues", "getGroupValues", "()Ljava/util/List;", "next", "kotlin-stdlib"})
final class MatcherMatchResult
implements MatchResult {
    @NotNull
    private final Matcher matcher;
    @NotNull
    private final CharSequence input;
    @NotNull
    private final MatchGroupCollection groups;
    @Nullable
    private List<String> groupValues_;

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new MatchNamedGroupCollection(this){
            final /* synthetic */ MatcherMatchResult this$0;
            {
                this.this$0 = $receiver;
            }

            public int getSize() {
                return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
            }

            public boolean isEmpty() {
                return false;
            }

            public Iterator<MatchGroup> iterator() {
                return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), arg_0 -> groups.1.iterator$lambda$0(this, arg_0)).iterator();
            }

            public MatchGroup get(int index) {
                MatchGroup matchGroup;
                IntRange range = RegexKt.access$range(MatcherMatchResult.access$getMatchResult(this.this$0), index);
                if (range.getStart() >= 0) {
                    String string = MatcherMatchResult.access$getMatchResult(this.this$0).group(index);
                    Intrinsics.checkNotNullExpressionValue(string, "group(...)");
                    matchGroup = new MatchGroup(string, range);
                } else {
                    matchGroup = null;
                }
                return matchGroup;
            }

            public MatchGroup get(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(MatcherMatchResult.access$getMatchResult(this.this$0), name);
            }

            private static final MatchGroup iterator$lambda$0(groups.1 this$0, int it) {
                return this$0.get(it);
            }
        };
    }

    private final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override
    @NotNull
    public IntRange getRange() {
        return RegexKt.access$range(this.getMatchResult());
    }

    @Override
    @NotNull
    public String getValue() {
        String string = this.getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(string, "group(...)");
        return string;
    }

    @Override
    @NotNull
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override
    @NotNull
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new AbstractList<String>(this){
                final /* synthetic */ MatcherMatchResult this$0;
                {
                    this.this$0 = $receiver;
                }

                public int getSize() {
                    return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
                }

                public String get(int index) {
                    String string = MatcherMatchResult.access$getMatchResult(this.this$0).group(index);
                    if (string == null) {
                        string = "";
                    }
                    return string;
                }
            };
        }
        List<String> list = this.groupValues_;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override
    @Nullable
    public MatchResult next() {
        MatchResult matchResult;
        int nextIndex = this.getMatchResult().end() + (this.getMatchResult().end() == this.getMatchResult().start() ? 1 : 0);
        if (nextIndex <= this.input.length()) {
            Matcher matcher = this.matcher.pattern().matcher(this.input);
            Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
            matchResult = RegexKt.access$findNext(matcher, nextIndex, this.input);
        } else {
            matchResult = null;
        }
        return matchResult;
    }

    @Override
    @NotNull
    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    public static final /* synthetic */ java.util.regex.MatchResult access$getMatchResult(MatcherMatchResult $this) {
        return $this.getMatchResult();
    }
}

