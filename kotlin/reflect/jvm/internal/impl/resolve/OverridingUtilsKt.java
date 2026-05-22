/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$$Lambda$1;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\noverridingUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 overridingUtils.kt\norg/jetbrains/kotlin/resolve/OverridingUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,84:1\n1634#2,3:85\n855#2,2:88\n*S KotlinDebug\n*F\n+ 1 overridingUtils.kt\norg/jetbrains/kotlin/resolve/OverridingUtilsKt\n*L\n40#1:85,3\n72#1:88,2\n*E\n"})
public final class OverridingUtilsKt {
    @NotNull
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(@NotNull Collection<? extends H> $this$selectMostSpecificInEachOverridableGroup, @NotNull Function1<? super H, ? extends CallableDescriptor> descriptorByHandle) {
        Intrinsics.checkNotNullParameter($this$selectMostSpecificInEachOverridableGroup, "<this>");
        Intrinsics.checkNotNullParameter(descriptorByHandle, "descriptorByHandle");
        if ($this$selectMostSpecificInEachOverridableGroup.size() <= 1) {
            return $this$selectMostSpecificInEachOverridableGroup;
        }
        LinkedList<? extends H> queue = new LinkedList<H>($this$selectMostSpecificInEachOverridableGroup);
        SmartSet<Object> result = SmartSet.Companion.create();
        while (!((Collection)queue).isEmpty()) {
            Collection<H> overridableGroup;
            SmartSet conflictedHandles;
            Object nextHandle = CollectionsKt.first((List)queue);
            SmartSet smartSet = conflictedHandles = SmartSet.Companion.create();
            Intrinsics.checkNotNullExpressionValue(OverridingUtil.extractMembersOverridableInBothWays(nextHandle, (Collection)queue, descriptorByHandle, new OverridingUtilsKt$$Lambda$1(smartSet)), "extractMembersOverridableInBothWays(...)");
            if (overridableGroup.size() == 1 && conflictedHandles.isEmpty()) {
                Object t2 = CollectionsKt.single((Iterable)overridableGroup);
                Intrinsics.checkNotNullExpressionValue(t2, "single(...)");
                result.add(t2);
                continue;
            }
            H mostSpecific = OverridingUtil.selectMostSpecificMember(overridableGroup, descriptorByHandle);
            CallableDescriptor mostSpecificDescriptor = descriptorByHandle.invoke(mostSpecific);
            Iterable $this$filterNotTo$iv = overridableGroup;
            boolean $i$f$filterNotTo = false;
            Iterator iterator2 = $this$filterNotTo$iv.iterator();
            while (iterator2.hasNext()) {
                Object element$iv;
                Object it = element$iv = iterator2.next();
                boolean bl2 = false;
                Intrinsics.checkNotNull(it);
                if (OverridingUtil.isMoreSpecific(mostSpecificDescriptor, descriptorByHandle.invoke(it))) continue;
                ((Collection)conflictedHandles).add(element$iv);
            }
            if (!((Collection)conflictedHandles).isEmpty()) {
                result.addAll(conflictedHandles);
            }
            result.add(mostSpecific);
        }
        return result;
    }

    private static final Unit selectMostSpecificInEachOverridableGroup$lambda$2(SmartSet $conflictedHandles, Object it) {
        Intrinsics.checkNotNull(it);
        $conflictedHandles.add(it);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Unit accessor$OverridingUtilsKt$lambda1(SmartSet smartSet, Object object) {
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup$lambda$2(smartSet, object);
    }
}

