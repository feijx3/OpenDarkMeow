/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.value.color;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.color.ColorValueInfo;
import net.ccbluex.liquidbounce.value.color.mode.ColorValueMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007R,\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/ccbluex/liquidbounce/value/color/ColorValueManager;", "", "<init>", "()V", "colorModes", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/value/color/mode/ColorValueMode;", "Lkotlin/collections/LinkedHashMap;", "getColorOrNull", "Ljava/awt/Color;", "info", "Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;", "offset", "", "getColor", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nColorValueManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorValueManager.kt\nnet/ccbluex/liquidbounce/value/color/ColorValueManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1#2:66\n1#2:73\n1563#3:67\n1634#3,3:68\n1056#3:71\n2756#3:72\n*S KotlinDebug\n*F\n+ 1 ColorValueManager.kt\nnet/ccbluex/liquidbounce/value/color/ColorValueManager\n*L\n34#1:73\n32#1:67\n32#1:68,3\n33#1:71\n34#1:72\n*E\n"})
public final class ColorValueManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public final LinkedHashMap<String, ColorValueMode> colorModes;
    @NotNull
    private static final ColorValueInfo DEFAULT_NORMAL;
    @NotNull
    private static final ColorValueInfo DEFAULT_BACKGROUND;

    /*
     * WARNING - void declaration
     */
    public ColorValueManager() {
        block3: {
            Iterable $this$sortedBy$iv;
            void $this$mapTo$iv$iv;
            List<Class<ColorValueMode>> list;
            List<Class<ColorValueMode>> list2;
            this.colorModes = new LinkedHashMap();
            List<Class<ColorValueMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".mode.impl", ColorValueMode.class);
            boolean bl2 = false;
            List<Class<ColorValueMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
            if (list == null) break block3;
            Iterable $this$map$iv = list;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it2;
                Class clazz = (Class)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl3 = false;
                collection.add((ColorValueMode)it2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    ColorValueMode it = (ColorValueMode)a2;
                    boolean bl2 = false;
                    Comparable comparable = Integer.valueOf(it.getPriority());
                    it = (ColorValueMode)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, it.getPriority());
                }
            });
            if (list4 != null) {
                void $this$onEach$iv;
                void var6_8;
                $this$sortedBy$iv = list4;
                boolean $i$f$onEach = false;
                void $this$onEach_u24lambda_u2418$iv = var6_8 = $this$onEach$iv;
                boolean bl4 = false;
                for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                    ColorValueMode it3 = (ColorValueMode)element$iv;
                    boolean bl5 = false;
                    ((Map)this.colorModes).put(it3.getName(), it3);
                }
                List cfr_ignored_0 = (List)var6_8;
            }
        }
    }

    @JvmOverloads
    @Nullable
    public final Color getColorOrNull(@NotNull ColorValueInfo info, int offset) {
        Intrinsics.checkNotNullParameter(info, "info");
        ColorValueMode colorValueMode = this.colorModes.get(info.getMode());
        return colorValueMode != null ? colorValueMode.getColor(info, info.getNoOffset() ? 0 : offset) : null;
    }

    public static /* synthetic */ Color getColorOrNull$default(ColorValueManager colorValueManager, ColorValueInfo colorValueInfo, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return colorValueManager.getColorOrNull(colorValueInfo, n2);
    }

    @JvmOverloads
    @NotNull
    public final Color getColor(@NotNull ColorValueInfo info, int offset) {
        Intrinsics.checkNotNullParameter(info, "info");
        Color color = this.getColorOrNull(info, offset);
        if (color == null) {
            color = new Color(0, 0, 0, 0);
        }
        return color;
    }

    public static /* synthetic */ Color getColor$default(ColorValueManager colorValueManager, ColorValueInfo colorValueInfo, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return colorValueManager.getColor(colorValueInfo, n2);
    }

    @JvmOverloads
    @Nullable
    public final Color getColorOrNull(@NotNull ColorValueInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return ColorValueManager.getColorOrNull$default(this, info, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final Color getColor(@NotNull ColorValueInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return ColorValueManager.getColor$default(this, info, 0, 2, null);
    }

    static {
        ColorValueInfo.ColorValueInfoColor[] colorValueInfoColorArray = new ColorValueInfo.ColorValueInfoColor[]{new ColorValueInfo.ColorValueInfoColor(new Color(0, 124, 255)), new ColorValueInfo.ColorValueInfoColor(new Color(160, 124, 255))};
        DEFAULT_NORMAL = new ColorValueInfo("Gradient", CollectionsKt.mutableListOf(colorValueInfoColorArray), 0, false, 160, 12, null);
        colorValueInfoColorArray = new ColorValueInfo.ColorValueInfoColor[]{new ColorValueInfo.ColorValueInfoColor(new Color(0, 0, 0))};
        DEFAULT_BACKGROUND = new ColorValueInfo("Custom", CollectionsKt.mutableListOf(colorValueInfoColorArray), 80, false, 0, 24, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/value/color/ColorValueManager$Companion;", "", "<init>", "()V", "DEFAULT_NORMAL", "Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;", "getDEFAULT_NORMAL", "()Lnet/ccbluex/liquidbounce/value/color/ColorValueInfo;", "DEFAULT_BACKGROUND", "getDEFAULT_BACKGROUND", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ColorValueInfo getDEFAULT_NORMAL() {
            return DEFAULT_NORMAL;
        }

        @NotNull
        public final ColorValueInfo getDEFAULT_BACKGROUND() {
            return DEFAULT_BACKGROUND;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

