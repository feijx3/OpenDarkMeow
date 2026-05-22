/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b\u00a8\u0006\u001d"}, d2={"Lkotlin/text/CharDirectionality;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nCharDirectionality.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CharDirectionality.kt\nkotlin/text/CharDirectionality\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n1208#2,2:125\n1236#2,4:127\n*S KotlinDebug\n*F\n+ 1 CharDirectionality.kt\nkotlin/text/CharDirectionality\n*L\n118#1:125,2\n118#1:127,4\n*E\n"})
public final class CharDirectionality
extends Enum<CharDirectionality> {
    @NotNull
    public static final Companion Companion;
    private final int value;
    @NotNull
    private static final Lazy<Map<Integer, CharDirectionality>> directionalityMap$delegate;
    public static final /* enum */ CharDirectionality UNDEFINED;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_ARABIC;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER_SEPARATOR;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER_TERMINATOR;
    public static final /* enum */ CharDirectionality ARABIC_NUMBER;
    public static final /* enum */ CharDirectionality COMMON_NUMBER_SEPARATOR;
    public static final /* enum */ CharDirectionality NONSPACING_MARK;
    public static final /* enum */ CharDirectionality BOUNDARY_NEUTRAL;
    public static final /* enum */ CharDirectionality PARAGRAPH_SEPARATOR;
    public static final /* enum */ CharDirectionality SEGMENT_SEPARATOR;
    public static final /* enum */ CharDirectionality WHITESPACE;
    public static final /* enum */ CharDirectionality OTHER_NEUTRALS;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT_EMBEDDING;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT_OVERRIDE;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_EMBEDDING;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_OVERRIDE;
    public static final /* enum */ CharDirectionality POP_DIRECTIONAL_FORMAT;
    private static final /* synthetic */ CharDirectionality[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private CharDirectionality(int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[])$VALUES.clone();
    }

    public static CharDirectionality valueOf(String value) {
        return Enum.valueOf(CharDirectionality.class, value);
    }

    @NotNull
    public static EnumEntries<CharDirectionality> getEntries() {
        return $ENTRIES;
    }

    /*
     * WARNING - void declaration
     */
    private static final Map directionalityMap_delegate$lambda$1() {
        void $this$associateByTo$iv$iv;
        Iterable $this$associateBy$iv = CharDirectionality.getEntries();
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Iterable iterable = $this$associateBy$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it;
            CharDirectionality charDirectionality = (CharDirectionality)((Object)element$iv$iv);
            Map map = destination$iv$iv;
            boolean bl2 = false;
            map.put(it.value, element$iv$iv);
        }
        return destination$iv$iv;
    }

    static {
        UNDEFINED = new CharDirectionality(-1);
        LEFT_TO_RIGHT = new CharDirectionality(0);
        RIGHT_TO_LEFT = new CharDirectionality(1);
        RIGHT_TO_LEFT_ARABIC = new CharDirectionality(2);
        EUROPEAN_NUMBER = new CharDirectionality(3);
        EUROPEAN_NUMBER_SEPARATOR = new CharDirectionality(4);
        EUROPEAN_NUMBER_TERMINATOR = new CharDirectionality(5);
        ARABIC_NUMBER = new CharDirectionality(6);
        COMMON_NUMBER_SEPARATOR = new CharDirectionality(7);
        NONSPACING_MARK = new CharDirectionality(8);
        BOUNDARY_NEUTRAL = new CharDirectionality(9);
        PARAGRAPH_SEPARATOR = new CharDirectionality(10);
        SEGMENT_SEPARATOR = new CharDirectionality(11);
        WHITESPACE = new CharDirectionality(12);
        OTHER_NEUTRALS = new CharDirectionality(13);
        LEFT_TO_RIGHT_EMBEDDING = new CharDirectionality(14);
        LEFT_TO_RIGHT_OVERRIDE = new CharDirectionality(15);
        RIGHT_TO_LEFT_EMBEDDING = new CharDirectionality(16);
        RIGHT_TO_LEFT_OVERRIDE = new CharDirectionality(17);
        POP_DIRECTIONAL_FORMAT = new CharDirectionality(18);
        $VALUES = charDirectionalityArray = new CharDirectionality[]{CharDirectionality.UNDEFINED, CharDirectionality.LEFT_TO_RIGHT, CharDirectionality.RIGHT_TO_LEFT, CharDirectionality.RIGHT_TO_LEFT_ARABIC, CharDirectionality.EUROPEAN_NUMBER, CharDirectionality.EUROPEAN_NUMBER_SEPARATOR, CharDirectionality.EUROPEAN_NUMBER_TERMINATOR, CharDirectionality.ARABIC_NUMBER, CharDirectionality.COMMON_NUMBER_SEPARATOR, CharDirectionality.NONSPACING_MARK, CharDirectionality.BOUNDARY_NEUTRAL, CharDirectionality.PARAGRAPH_SEPARATOR, CharDirectionality.SEGMENT_SEPARATOR, CharDirectionality.WHITESPACE, CharDirectionality.OTHER_NEUTRALS, CharDirectionality.LEFT_TO_RIGHT_EMBEDDING, CharDirectionality.LEFT_TO_RIGHT_OVERRIDE, CharDirectionality.RIGHT_TO_LEFT_EMBEDDING, CharDirectionality.RIGHT_TO_LEFT_OVERRIDE, CharDirectionality.POP_DIRECTIONAL_FORMAT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
        directionalityMap$delegate = LazyKt.lazy(CharDirectionality::directionalityMap_delegate$lambda$1);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006R'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Lkotlin/text/CharDirectionality$Companion;", "", "<init>", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        private final Map<Integer, CharDirectionality> getDirectionalityMap() {
            Lazy lazy = directionalityMap$delegate;
            return (Map)lazy.getValue();
        }

        @NotNull
        public final CharDirectionality valueOf(int directionality) {
            CharDirectionality charDirectionality = this.getDirectionalityMap().get(directionality);
            if (charDirectionality == null) {
                throw new IllegalArgumentException("Directionality #" + directionality + " is not defined.");
            }
            return charDirectionality;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

