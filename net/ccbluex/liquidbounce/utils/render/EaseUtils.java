/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.utils.render;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002,-B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0007J \u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005H\u0007\u00a8\u0006."}, d2={"Lnet/ccbluex/liquidbounce/utils/render/EaseUtils;", "", "<init>", "()V", "easeInSine", "", "x", "easeOutSine", "easeInOutSine", "easeInQuad", "easeOutQuad", "easeInOutQuad", "easeInCubic", "easeOutCubic", "easeInOutCubic", "easeInQuart", "easeOutQuart", "easeInOutQuart", "easeInQuint", "easeOutQuint", "easeInOutQuint", "easeInExpo", "easeOutExpo", "easeInOutExpo", "easeInCirc", "easeOutCirc", "easeInOutCirc", "easeInBack", "easeOutBack", "easeInOutBack", "easeInElastic", "easeOutElastic", "easeInOutElastic", "getEnumEasingList", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "name", "", "getEnumEasingOrderList", "apply", "type", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "order", "Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "value", "EnumEasingType", "EnumEasingOrder", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nEaseUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EaseUtils.kt\nnet/ccbluex/liquidbounce/utils/render/EaseUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,281:1\n11228#2:282\n11563#2,3:283\n11228#2:290\n11563#2,3:291\n37#3:286\n36#3,3:287\n37#3:294\n36#3,3:295\n1#4:298\n*S KotlinDebug\n*F\n+ 1 EaseUtils.kt\nnet/ccbluex/liquidbounce/utils/render/EaseUtils\n*L\n255#1:282\n255#1:283,3\n260#1:290\n260#1:291,3\n255#1:286\n255#1:287,3\n260#1:294\n260#1:295,3\n*E\n"})
public final class EaseUtils {
    @NotNull
    public static final EaseUtils INSTANCE = new EaseUtils();

    private EaseUtils() {
    }

    @JvmStatic
    public static final double easeInSine(double x2) {
        return 1.0 - Math.cos(x2 * Math.PI / (double)2);
    }

    @JvmStatic
    public static final double easeOutSine(double x2) {
        return Math.sin(x2 * Math.PI / (double)2);
    }

    @JvmStatic
    public static final double easeInOutSine(double x2) {
        return -(Math.cos(Math.PI * x2) - 1.0) / (double)2;
    }

    @JvmStatic
    public static final double easeInQuad(double x2) {
        return x2 * x2;
    }

    @JvmStatic
    public static final double easeOutQuad(double x2) {
        return 1.0 - (1.0 - x2) * (1.0 - x2);
    }

    @JvmStatic
    public static final double easeInOutQuad(double x2) {
        return x2 < 0.5 ? (double)2 * x2 * x2 : 1.0 - Math.pow((double)-2 * x2 + (double)2, 2) / (double)2;
    }

    @JvmStatic
    public static final double easeInCubic(double x2) {
        return x2 * x2 * x2;
    }

    @JvmStatic
    public static final double easeOutCubic(double x2) {
        return 1.0 - Math.pow(1.0 - x2, 3);
    }

    @JvmStatic
    public static final double easeInOutCubic(double x2) {
        return x2 < 0.5 ? (double)4 * x2 * x2 * x2 : 1.0 - Math.pow((double)-2 * x2 + (double)2, 3) / (double)2;
    }

    @JvmStatic
    public static final double easeInQuart(double x2) {
        return x2 * x2 * x2 * x2;
    }

    @JvmStatic
    public static final double easeOutQuart(double x2) {
        return 1.0 - Math.pow(1.0 - x2, 4);
    }

    @JvmStatic
    public static final double easeInOutQuart(double x2) {
        return x2 < 0.5 ? (double)8 * x2 * x2 * x2 * x2 : 1.0 - Math.pow((double)-2 * x2 + (double)2, 4) / (double)2;
    }

    @JvmStatic
    public static final double easeInQuint(double x2) {
        return x2 * x2 * x2 * x2 * x2;
    }

    @JvmStatic
    public static final double easeOutQuint(double x2) {
        return 1.0 - Math.pow(1.0 - x2, 5);
    }

    @JvmStatic
    public static final double easeInOutQuint(double x2) {
        return x2 < 0.5 ? (double)16 * x2 * x2 * x2 * x2 * x2 : 1.0 - Math.pow((double)-2 * x2 + (double)2, 5) / (double)2;
    }

    @JvmStatic
    public static final double easeInExpo(double x2) {
        return x2 == 0.0 ? 0.0 : Math.pow(2.0, (double)10 * x2 - (double)10);
    }

    @JvmStatic
    public static final double easeOutExpo(double x2) {
        return x2 == 1.0 ? 1.0 : 1.0 - Math.pow(2.0, (double)-10 * x2);
    }

    @JvmStatic
    public static final double easeInOutExpo(double x2) {
        return x2 == 0.0 ? 0.0 : (x2 == 1.0 ? 1.0 : (x2 < 0.5 ? Math.pow(2.0, (double)20 * x2 - (double)10) / (double)2 : ((double)2 - Math.pow(2.0, (double)-20 * x2 + (double)10)) / (double)2));
    }

    @JvmStatic
    public static final double easeInCirc(double x2) {
        return 1.0 - Math.sqrt(1.0 - Math.pow(x2, 2));
    }

    @JvmStatic
    public static final double easeOutCirc(double x2) {
        return Math.sqrt(1.0 - Math.pow(x2 - 1.0, 2));
    }

    @JvmStatic
    public static final double easeInOutCirc(double x2) {
        return x2 < 0.5 ? (1.0 - Math.sqrt(1.0 - Math.pow((double)2 * x2, 2))) / (double)2 : (Math.sqrt(1.0 - Math.pow((double)-2 * x2 + (double)2, 2)) + 1.0) / (double)2;
    }

    @JvmStatic
    public static final double easeInBack(double x2) {
        double c1 = 1.70158;
        double c3 = c1 + 1.0;
        return c3 * x2 * x2 * x2 - c1 * x2 * x2;
    }

    @JvmStatic
    public static final double easeOutBack(double x2) {
        double c1 = 1.70158;
        double c3 = c1 + 1.0;
        return 1.0 + c3 * Math.pow(x2 - 1.0, 3) + c1 * Math.pow(x2 - 1.0, 2);
    }

    @JvmStatic
    public static final double easeInOutBack(double x2) {
        double c1 = 1.70158;
        double c2 = c1 * 1.525;
        return x2 < 0.5 ? Math.pow((double)2 * x2, 2) * ((c2 + 1.0) * (double)2 * x2 - c2) / (double)2 : (Math.pow((double)2 * x2 - (double)2, 2) * ((c2 + 1.0) * (x2 * (double)2 - (double)2) + c2) + (double)2) / (double)2;
    }

    @JvmStatic
    public static final double easeInElastic(double x2) {
        double c4 = 2.0943951023931953;
        return x2 == 0.0 ? 0.0 : (x2 == 1.0 ? 1.0 : Math.pow(-2.0, (double)10 * x2 - (double)10) * Math.sin((x2 * (double)10 - 10.75) * c4));
    }

    @JvmStatic
    public static final double easeOutElastic(double x2) {
        double c4 = 2.0943951023931953;
        return x2 == 0.0 ? 0.0 : (x2 == 1.0 ? 1.0 : Math.pow(2.0, (double)-10 * x2) * Math.sin((x2 * (double)10 - 0.75) * c4) + 1.0);
    }

    @JvmStatic
    public static final double easeInOutElastic(double x2) {
        double c5 = 1.3962634015954636;
        return x2 == 0.0 ? 0.0 : (x2 == 1.0 ? 1.0 : (x2 < 0.5 ? -(Math.pow(2.0, (double)20 * x2 - (double)10) * Math.sin(((double)20 * x2 - 11.125) * c5)) / (double)2 : Math.pow(2.0, (double)-20 * x2 + (double)10) * Math.sin(((double)20 * x2 - 11.125) * c5) / (double)2 + 1.0));
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @NotNull
    public static final ListValue getEnumEasingList(@NotNull String name) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        EnumEasingType[] enumEasingTypeArray = EnumEasingType.values();
        String string = name;
        boolean $i$f$map = false;
        void var3_4 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(((void)$this$map$iv).length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it;
            void item$iv$iv;
            void var9_10 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.toString());
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        String string2 = EnumEasingType.SINE.toString();
        String[] stringArray = thisCollection$iv.toArray(new String[0]);
        String string3 = string;
        return new ListValue(string3, stringArray, string2);
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @NotNull
    public static final ListValue getEnumEasingOrderList(@NotNull String name) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter(name, "name");
        EnumEasingOrder[] enumEasingOrderArray = EnumEasingOrder.values();
        String string = name;
        boolean $i$f$map = false;
        void var3_4 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(((void)$this$map$iv).length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it;
            void item$iv$iv;
            void var9_10 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it.toString());
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        String string2 = EnumEasingOrder.FAST_AT_START.toString();
        String[] stringArray = thisCollection$iv.toArray(new String[0]);
        String string3 = string;
        return new ListValue(string3, stringArray, string2);
    }

    @JvmStatic
    public static final double apply(@NotNull EnumEasingType type, @NotNull EnumEasingOrder order, double value) {
        double d2;
        Object object;
        block4: {
            Intrinsics.checkNotNullParameter((Object)type, "type");
            Intrinsics.checkNotNullParameter((Object)order, "order");
            if (type == EnumEasingType.NONE) {
                return value;
            }
            String methodName = "ease" + order.getMethodName() + type.getFriendlyName();
            Method[] methodArray = INSTANCE.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(methodArray, "getDeclaredMethods(...)");
            for (Object object2 : (Object[])methodArray) {
                Method it = (Method)object2;
                boolean bl2 = false;
                if (!it.getName().equals(methodName)) continue;
                object = object2;
                break block4;
            }
            object = null;
        }
        Method it = (Method)object;
        boolean bl3 = false;
        if (it != null) {
            Object[] objectArray = new Object[]{value};
            Object object3 = it.invoke(INSTANCE, objectArray);
            Intrinsics.checkNotNull(object3, "null cannot be cast to non-null type kotlin.Double");
            d2 = (Double)object3;
        } else {
            d2 = value;
        }
        return d2;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingOrder;", "", "methodName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethodName", "()Ljava/lang/String;", "FAST_AT_START", "FAST_AT_END", "FAST_AT_START_AND_END", "DarkMeow"})
    public static final class EnumEasingOrder
    extends Enum<EnumEasingOrder> {
        @NotNull
        private final String methodName;
        public static final /* enum */ EnumEasingOrder FAST_AT_START = new EnumEasingOrder("Out");
        public static final /* enum */ EnumEasingOrder FAST_AT_END = new EnumEasingOrder("In");
        public static final /* enum */ EnumEasingOrder FAST_AT_START_AND_END = new EnumEasingOrder("InOut");
        private static final /* synthetic */ EnumEasingOrder[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private EnumEasingOrder(String methodName) {
            this.methodName = methodName;
        }

        @NotNull
        public final String getMethodName() {
            return this.methodName;
        }

        public static EnumEasingOrder[] values() {
            return (EnumEasingOrder[])$VALUES.clone();
        }

        public static EnumEasingOrder valueOf(String value) {
            return Enum.valueOf(EnumEasingOrder.class, value);
        }

        @NotNull
        public static EnumEntries<EnumEasingOrder> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = enumEasingOrderArray = new EnumEasingOrder[]{EnumEasingOrder.FAST_AT_START, EnumEasingOrder.FAST_AT_END, EnumEasingOrder.FAST_AT_START_AND_END};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/utils/render/EaseUtils$EnumEasingType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SINE", "QUAD", "CUBIC", "QUART", "QUINT", "EXPO", "CIRC", "BACK", "ELASTIC", "friendlyName", "", "getFriendlyName", "()Ljava/lang/String;", "DarkMeow"})
    public static final class EnumEasingType
    extends Enum<EnumEasingType> {
        @NotNull
        private final String friendlyName;
        public static final /* enum */ EnumEasingType NONE = new EnumEasingType();
        public static final /* enum */ EnumEasingType SINE = new EnumEasingType();
        public static final /* enum */ EnumEasingType QUAD = new EnumEasingType();
        public static final /* enum */ EnumEasingType CUBIC = new EnumEasingType();
        public static final /* enum */ EnumEasingType QUART = new EnumEasingType();
        public static final /* enum */ EnumEasingType QUINT = new EnumEasingType();
        public static final /* enum */ EnumEasingType EXPO = new EnumEasingType();
        public static final /* enum */ EnumEasingType CIRC = new EnumEasingType();
        public static final /* enum */ EnumEasingType BACK = new EnumEasingType();
        public static final /* enum */ EnumEasingType ELASTIC = new EnumEasingType();
        private static final /* synthetic */ EnumEasingType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private EnumEasingType() {
            StringBuilder stringBuilder = new StringBuilder();
            String string = this.name().substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
            String string2 = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string2, "toUpperCase(...)");
            StringBuilder stringBuilder2 = stringBuilder.append(string2);
            String string3 = this.name().substring(1, this.name().length());
            Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
            String string4 = string3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string4, "toLowerCase(...)");
            this.friendlyName = stringBuilder2.append(string4).toString();
        }

        @NotNull
        public final String getFriendlyName() {
            return this.friendlyName;
        }

        public static EnumEasingType[] values() {
            return (EnumEasingType[])$VALUES.clone();
        }

        public static EnumEasingType valueOf(String value) {
            return Enum.valueOf(EnumEasingType.class, value);
        }

        @NotNull
        public static EnumEntries<EnumEasingType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = enumEasingTypeArray = new EnumEasingType[]{EnumEasingType.NONE, EnumEasingType.SINE, EnumEasingType.QUAD, EnumEasingType.CUBIC, EnumEasingType.QUART, EnumEasingType.QUINT, EnumEasingType.EXPO, EnumEasingType.CIRC, EnumEasingType.BACK, EnumEasingType.ELASTIC};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

