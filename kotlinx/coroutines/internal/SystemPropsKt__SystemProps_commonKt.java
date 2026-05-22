/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a8\u0006\t"}, d2={"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/internal/SystemPropsKt")
final class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(@NotNull String propertyName, boolean defaultValue) {
        String string = SystemPropsKt.systemProp(propertyName);
        return string != null ? Boolean.parseBoolean(string) : defaultValue;
    }

    public static final int systemProp(@NotNull String propertyName, int defaultValue, int minValue, int maxValue) {
        return (int)SystemPropsKt.systemProp(propertyName, (long)defaultValue, (long)minValue, (long)maxValue);
    }

    public static /* synthetic */ int systemProp$default(String string, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 4) != 0) {
            n3 = 1;
        }
        if ((n5 & 8) != 0) {
            n4 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(string, n2, n3, n4);
    }

    public static final long systemProp(@NotNull String propertyName, long defaultValue, long minValue, long maxValue) {
        String string = SystemPropsKt.systemProp(propertyName);
        if (string == null) {
            return defaultValue;
        }
        String value = string;
        Long l2 = StringsKt.toLongOrNull(value);
        if (l2 == null) {
            throw new IllegalStateException(("System property '" + propertyName + "' has unrecognized value '" + value + '\'').toString());
        }
        long parsed = l2;
        if (!(minValue <= parsed ? parsed <= maxValue : false)) {
            throw new IllegalStateException(("System property '" + propertyName + "' should be in range " + minValue + ".." + maxValue + ", but is '" + parsed + '\'').toString());
        }
        return parsed;
    }

    public static /* synthetic */ long systemProp$default(String string, long l2, long l3, long l4, int n2, Object object) {
        if ((n2 & 4) != 0) {
            l3 = 1L;
        }
        if ((n2 & 8) != 0) {
            l4 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(string, l2, l3, l4);
    }

    @NotNull
    public static final String systemProp(@NotNull String propertyName, @NotNull String defaultValue) {
        String string = SystemPropsKt.systemProp(propertyName);
        if (string == null) {
            string = defaultValue;
        }
        return string;
    }
}

