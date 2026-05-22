/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.internal.IntrinsicConstEvaluation
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__AppendableKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001\u001a\u0011\u0010\t\u001a\u00020\n*\u00020\u0001H\u0002\u00a2\u0006\u0002\b\u000b\u001a!\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\b\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\b\u000e\u001aJ\u0010\u000f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0082\b\u00a2\u0006\u0002\b\u0014\u00a8\u0006\u0015"}, d2={"trimMargin", "", "marginPrefix", "replaceIndentByMargin", "newIndent", "trimIndent", "replaceIndent", "prependIndent", "indent", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "getIndentFunction", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "kotlin-stdlib"}, xs="kotlin/text/StringsKt")
@SourceDebugExtension(value={"SMAP\nIndent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,129:1\n119#1,2:131\n121#1,4:146\n126#1,2:159\n119#1,2:168\n121#1,4:183\n126#1,2:190\n1#2:130\n1#2:156\n1#2:187\n1#2:211\n1583#3,11:133\n1878#3,2:144\n1880#3:157\n1594#3:158\n774#3:161\n865#3,2:162\n1563#3:164\n1634#3,3:165\n1583#3,11:170\n1878#3,2:181\n1880#3:188\n1594#3:189\n1583#3,11:198\n1878#3,2:209\n1880#3:212\n1594#3:213\n158#4,6:150\n158#4,6:192\n*S KotlinDebug\n*F\n+ 1 Indent.kt\nkotlin/text/StringsKt__IndentKt\n*L\n42#1:131,2\n42#1:146,4\n42#1:159,2\n83#1:168,2\n83#1:183,4\n83#1:190,2\n42#1:156\n83#1:187\n120#1:211\n42#1:133,11\n42#1:144,2\n42#1:157\n42#1:158\n79#1:161\n79#1:162,2\n80#1:164\n80#1:165,3\n83#1:170,11\n83#1:181,2\n83#1:188\n83#1:189\n120#1:198,11\n120#1:209,2\n120#1:212\n120#1:213\n43#1:150,6\n107#1:192,6\n*E\n"})
class StringsKt__IndentKt
extends StringsKt__AppendableKt {
    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimMargin(@NotNull String $this$trimMargin, @NotNull String marginPrefix) {
        Intrinsics.checkNotNullParameter($this$trimMargin, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return StringsKt.replaceIndentByMargin($this$trimMargin, "", marginPrefix);
    }

    public static /* synthetic */ String trimMargin$default(String string, String string2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = "|";
        }
        return StringsKt.trimMargin(string, string2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String replaceIndentByMargin(@NotNull String $this$replaceIndentByMargin, @NotNull String newIndent, @NotNull String marginPrefix) {
        void resultSizeEstimate$iv;
        void $this$mapIndexedNotNullTo$iv$iv$iv;
        void $this$reindent$iv;
        List<String> lines;
        Intrinsics.checkNotNullParameter($this$replaceIndentByMargin, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (!(!StringsKt.isBlank(marginPrefix))) {
            boolean $i$a$-require-StringsKt__IndentKt$replaceIndentByMargin$22 = false;
            String $i$a$-require-StringsKt__IndentKt$replaceIndentByMargin$22 = "marginPrefix must be non-blank string.";
            throw new IllegalArgumentException($i$a$-require-StringsKt__IndentKt$replaceIndentByMargin$22.toString());
        }
        List<String> $i$a$-require-StringsKt__IndentKt$replaceIndentByMargin$22 = lines = StringsKt.lines($this$replaceIndentByMargin);
        int n2 = $this$replaceIndentByMargin.length() + newIndent.length() * lines.size();
        Function1<String, String> indentAddFunction$iv = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(newIndent);
        boolean $i$f$reindent = false;
        int lastIndex$iv = CollectionsKt.getLastIndex($this$reindent$iv);
        Iterable $this$mapIndexedNotNull$iv$iv = (Iterable)$this$reindent$iv;
        boolean $i$f$mapIndexedNotNull = false;
        Iterable iterable = $this$mapIndexedNotNull$iv$iv;
        Collection destination$iv$iv$iv = new ArrayList();
        boolean $i$f$mapIndexedNotNullTo = false;
        void $this$forEachIndexed$iv$iv$iv$iv = $this$mapIndexedNotNullTo$iv$iv$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv$iv$iv$iv = 0;
        for (Object item$iv$iv$iv$iv : $this$forEachIndexed$iv$iv$iv$iv) {
            String string;
            void value$iv;
            void element$iv$iv$iv;
            int n3;
            if ((n3 = index$iv$iv$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object t2 = item$iv$iv$iv$iv;
            int index$iv$iv$iv = n3;
            boolean bl2 = false;
            String string2 = (String)element$iv$iv$iv;
            int index$iv = index$iv$iv$iv;
            boolean bl3 = false;
            if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank((CharSequence)value$iv)) {
                string = null;
            } else {
                String string3;
                int n4;
                void line;
                block11: {
                    line = value$iv;
                    boolean bl4 = false;
                    CharSequence $this$indexOfFirst$iv = (CharSequence)line;
                    boolean $i$f$indexOfFirst = false;
                    int n5 = $this$indexOfFirst$iv.length();
                    for (int index$iv2 = 0; index$iv2 < n5; ++index$iv2) {
                        char it = $this$indexOfFirst$iv.charAt(index$iv2);
                        boolean bl5 = false;
                        if (!(!CharsKt.isWhitespace(it))) continue;
                        n4 = index$iv2;
                        break block11;
                    }
                    n4 = -1;
                }
                int firstNonWhitespaceIndex = n4;
                if (firstNonWhitespaceIndex == -1) {
                    string3 = null;
                } else if (StringsKt.startsWith$default((String)line, marginPrefix, firstNonWhitespaceIndex, false, 4, null)) {
                    void var28_30 = line;
                    int n6 = firstNonWhitespaceIndex + marginPrefix.length();
                    Intrinsics.checkNotNull(var28_30, "null cannot be cast to non-null type java.lang.String");
                    String string4 = var28_30.substring(n6);
                    string3 = string4;
                    Intrinsics.checkNotNullExpressionValue(string4, "substring(...)");
                } else {
                    string3 = null;
                }
                string = string3;
                if (string3 == null || (string = indentAddFunction$iv.invoke(string)) == null) {
                    string = value$iv;
                }
            }
            if (string == null) continue;
            String it$iv$iv$iv = string;
            boolean bl6 = false;
            destination$iv$iv$iv.add(it$iv$iv$iv);
        }
        return ((StringBuilder)CollectionsKt.joinTo$default((List)destination$iv$iv$iv, new StringBuilder((int)resultSizeEstimate$iv), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String string, String string2, String string3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = "";
        }
        if ((n2 & 2) != 0) {
            string3 = "|";
        }
        return StringsKt.replaceIndentByMargin(string, string2, string3);
    }

    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimIndent(@NotNull String $this$trimIndent) {
        Intrinsics.checkNotNullParameter($this$trimIndent, "<this>");
        return StringsKt.replaceIndent($this$trimIndent, "");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final String replaceIndent(@NotNull String $this$replaceIndent, @NotNull String newIndent) {
        void resultSizeEstimate$iv;
        void $this$mapIndexedNotNullTo$iv$iv$iv;
        void $this$reindent$iv;
        Object item$iv$iv2;
        void $this$mapTo$iv$iv;
        void $this$map$iv22;
        String p0;
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv;
        Intrinsics.checkNotNullParameter($this$replaceIndent, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List<String> lines = StringsKt.lines($this$replaceIndent);
        Iterable iterable = lines;
        boolean $i$f$filter = false;
        void var7_7 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            p0 = (String)element$iv$iv;
            boolean bl2 = false;
            boolean bl3 = !StringsKt.isBlank(p0);
            if (!bl3) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$map = false;
        $this$filterTo$iv$iv = $this$map$iv22;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv22, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
            p0 = (String)item$iv$iv2;
            Collection collection = destination$iv$iv;
            boolean bl4 = false;
            collection.add(StringsKt__IndentKt.indentWidth$StringsKt__IndentKt(p0));
        }
        Integer n2 = (Integer)CollectionsKt.minOrNull((List)destination$iv$iv);
        int minCommonIndent = n2 != null ? n2 : 0;
        List<String> list = lines;
        int $this$map$iv22 = $this$replaceIndent.length() + newIndent.length() * lines.size();
        Function1<String, String> indentAddFunction$iv = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(newIndent);
        boolean $i$f$reindent = false;
        int lastIndex$iv = CollectionsKt.getLastIndex($this$reindent$iv);
        Iterable $this$mapIndexedNotNull$iv$iv = (Iterable)$this$reindent$iv;
        boolean $i$f$mapIndexedNotNull = false;
        item$iv$iv2 = $this$mapIndexedNotNull$iv$iv;
        Collection destination$iv$iv$iv = new ArrayList();
        boolean $i$f$mapIndexedNotNullTo = false;
        void $this$forEachIndexed$iv$iv$iv$iv = $this$mapIndexedNotNullTo$iv$iv$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv$iv$iv$iv = 0;
        for (Object item$iv$iv$iv$iv : $this$forEachIndexed$iv$iv$iv$iv) {
            String string;
            void value$iv;
            void element$iv$iv$iv;
            int n3;
            if ((n3 = index$iv$iv$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object t2 = item$iv$iv$iv$iv;
            int index$iv$iv$iv = n3;
            boolean bl5 = false;
            String string2 = (String)element$iv$iv$iv;
            int index$iv = index$iv$iv$iv;
            boolean bl6 = false;
            if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank((CharSequence)value$iv)) {
                string = null;
            } else {
                void line = value$iv;
                boolean bl7 = false;
                string = StringsKt.drop((String)line, minCommonIndent);
                if (string == null || (string = indentAddFunction$iv.invoke(string)) == null) {
                    string = value$iv;
                }
            }
            if (string == null) continue;
            String it$iv$iv$iv = string;
            boolean bl8 = false;
            destination$iv$iv$iv.add(it$iv$iv$iv);
        }
        return ((StringBuilder)CollectionsKt.joinTo$default((List)destination$iv$iv$iv, new StringBuilder((int)resultSizeEstimate$iv), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static /* synthetic */ String replaceIndent$default(String string, String string2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = "";
        }
        return StringsKt.replaceIndent(string, string2);
    }

    @NotNull
    public static final String prependIndent(@NotNull String $this$prependIndent, @NotNull String indent) {
        Intrinsics.checkNotNullParameter($this$prependIndent, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence($this$prependIndent), arg_0 -> StringsKt__IndentKt.prependIndent$lambda$5$StringsKt__IndentKt(indent, arg_0)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String string, String string2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = "    ";
        }
        return StringsKt.prependIndent(string, string2);
    }

    /*
     * WARNING - void declaration
     */
    private static final int indentWidth$StringsKt__IndentKt(String $this$indentWidth) {
        void var2_2;
        int n2;
        block1: {
            CharSequence $this$indexOfFirst$iv = $this$indentWidth;
            boolean $i$f$indexOfFirst = false;
            int n3 = $this$indexOfFirst$iv.length();
            for (int index$iv = 0; index$iv < n3; ++index$iv) {
                char it = $this$indexOfFirst$iv.charAt(index$iv);
                boolean bl2 = false;
                if (!(!CharsKt.isWhitespace(it))) continue;
                n2 = index$iv;
                break block1;
            }
            n2 = -1;
        }
        int it = n2;
        boolean bl3 = false;
        return it == -1 ? $this$indentWidth.length() : var2_2;
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String indent) {
        return ((CharSequence)indent).length() == 0 ? StringsKt__IndentKt::getIndentFunction$lambda$8$StringsKt__IndentKt : arg_0 -> StringsKt__IndentKt.getIndentFunction$lambda$9$StringsKt__IndentKt(indent, arg_0);
    }

    /*
     * WARNING - void declaration
     */
    private static final String reindent$StringsKt__IndentKt(List<String> $this$reindent, int resultSizeEstimate, Function1<? super String, String> indentAddFunction, Function1<? super String, String> indentCutFunction) {
        void $this$mapIndexedNotNullTo$iv$iv;
        boolean $i$f$reindent = false;
        int lastIndex = CollectionsKt.getLastIndex($this$reindent);
        Iterable $this$mapIndexedNotNull$iv = $this$reindent;
        boolean $i$f$mapIndexedNotNull = false;
        Iterable iterable = $this$mapIndexedNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapIndexedNotNullTo = false;
        void $this$forEachIndexed$iv$iv$iv = $this$mapIndexedNotNullTo$iv$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$forEachIndexed$iv$iv$iv) {
            String string;
            void value;
            void element$iv$iv;
            int n2;
            if ((n2 = index$iv$iv$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object t2 = item$iv$iv$iv;
            int index$iv$iv = n2;
            boolean bl2 = false;
            String string2 = (String)element$iv$iv;
            int index = index$iv$iv;
            boolean bl3 = false;
            if ((index == 0 || index == lastIndex) && StringsKt.isBlank((CharSequence)value)) {
                string = null;
            } else {
                string = indentCutFunction.invoke((String)value);
                if (string == null || (string = indentAddFunction.invoke(string)) == null) {
                    string = value;
                }
            }
            if (string == null) continue;
            String it$iv$iv = string;
            boolean bl4 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        return ((StringBuilder)CollectionsKt.joinTo$default((List)destination$iv$iv, new StringBuilder(resultSizeEstimate), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    private static final String prependIndent$lambda$5$StringsKt__IndentKt(String $indent, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.isBlank(it) ? (it.length() < $indent.length() ? $indent : it) : $indent + it;
    }

    private static final String getIndentFunction$lambda$8$StringsKt__IndentKt(String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return line;
    }

    private static final String getIndentFunction$lambda$9$StringsKt__IndentKt(String $indent, String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return $indent + line;
    }
}

