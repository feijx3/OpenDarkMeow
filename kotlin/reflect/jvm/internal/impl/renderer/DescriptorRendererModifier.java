/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nDescriptorRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRenderer.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererModifier\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,331:1\n3829#2:332\n4344#2,2:333\n*S KotlinDebug\n*F\n+ 1 DescriptorRenderer.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererModifier\n*L\n325#1:332\n325#1:333,2\n*E\n"})
public final class DescriptorRendererModifier
extends Enum<DescriptorRendererModifier> {
    @NotNull
    public static final Companion Companion;
    private final boolean includeByDefault;
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL;
    public static final /* enum */ DescriptorRendererModifier VISIBILITY;
    public static final /* enum */ DescriptorRendererModifier MODALITY;
    public static final /* enum */ DescriptorRendererModifier OVERRIDE;
    public static final /* enum */ DescriptorRendererModifier ANNOTATIONS;
    public static final /* enum */ DescriptorRendererModifier INNER;
    public static final /* enum */ DescriptorRendererModifier MEMBER_KIND;
    public static final /* enum */ DescriptorRendererModifier DATA;
    public static final /* enum */ DescriptorRendererModifier INLINE;
    public static final /* enum */ DescriptorRendererModifier EXPECT;
    public static final /* enum */ DescriptorRendererModifier ACTUAL;
    public static final /* enum */ DescriptorRendererModifier CONST;
    public static final /* enum */ DescriptorRendererModifier LATEINIT;
    public static final /* enum */ DescriptorRendererModifier FUN;
    public static final /* enum */ DescriptorRendererModifier VALUE;
    private static final /* synthetic */ DescriptorRendererModifier[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private DescriptorRendererModifier(boolean includeByDefault) {
        this.includeByDefault = includeByDefault;
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[])$VALUES.clone();
    }

    public static DescriptorRendererModifier valueOf(String value) {
        return Enum.valueOf(DescriptorRendererModifier.class, value);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_3;
        void $this$filterTo$iv$iv;
        VISIBILITY = new DescriptorRendererModifier(true);
        MODALITY = new DescriptorRendererModifier(true);
        OVERRIDE = new DescriptorRendererModifier(true);
        ANNOTATIONS = new DescriptorRendererModifier(false);
        INNER = new DescriptorRendererModifier(true);
        MEMBER_KIND = new DescriptorRendererModifier(true);
        DATA = new DescriptorRendererModifier(true);
        INLINE = new DescriptorRendererModifier(true);
        EXPECT = new DescriptorRendererModifier(true);
        ACTUAL = new DescriptorRendererModifier(true);
        CONST = new DescriptorRendererModifier(true);
        LATEINIT = new DescriptorRendererModifier(true);
        FUN = new DescriptorRendererModifier(true);
        VALUE = new DescriptorRendererModifier(true);
        $VALUES = descriptorRendererModifierArray = new DescriptorRendererModifier[]{DescriptorRendererModifier.VISIBILITY, DescriptorRendererModifier.MODALITY, DescriptorRendererModifier.OVERRIDE, DescriptorRendererModifier.ANNOTATIONS, DescriptorRendererModifier.INNER, DescriptorRendererModifier.MEMBER_KIND, DescriptorRendererModifier.DATA, DescriptorRendererModifier.INLINE, DescriptorRendererModifier.EXPECT, DescriptorRendererModifier.ACTUAL, DescriptorRendererModifier.CONST, DescriptorRendererModifier.LATEINIT, DescriptorRendererModifier.FUN, DescriptorRendererModifier.VALUE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
        DescriptorRendererModifier[] $this$filter$iv = DescriptorRendererModifier.values();
        boolean $i$f$filter = false;
        DescriptorRendererModifier[] descriptorRendererModifierArray = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        int n2 = ((void)$this$filterTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void element$iv$iv;
            void it = element$iv$iv = $this$filterTo$iv$iv[i2];
            boolean bl2 = false;
            if (!it.includeByDefault) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt.toSet((List)var3_3);
        ALL = ArraysKt.toSet(DescriptorRendererModifier.values());
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

