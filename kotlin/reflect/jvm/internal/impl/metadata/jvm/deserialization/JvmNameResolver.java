/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverBase;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\nJvmNameResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmNameResolver.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class JvmNameResolver
extends JvmNameResolverBase {
    @NotNull
    private final JvmProtoBuf.StringTableTypes types;

    /*
     * WARNING - void declaration
     */
    public JvmNameResolver(@NotNull JvmProtoBuf.StringTableTypes types, @NotNull String[] strings) {
        Set<Integer> set;
        void $this$_init__u24lambda_u240;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(strings, "strings");
        List<Integer> list = types.getLocalNameList();
        String[] stringArray = strings;
        JvmNameResolver jvmNameResolver = this;
        boolean bl2 = false;
        if ($this$_init__u24lambda_u240.isEmpty()) {
            set = SetsKt.emptySet();
        } else {
            Intrinsics.checkNotNull($this$_init__u24lambda_u240);
            set = CollectionsKt.toSet((Iterable)$this$_init__u24lambda_u240);
        }
        Set<Integer> set2 = set;
        List<JvmProtoBuf.StringTableTypes.Record> list2 = types.getRecordList();
        Intrinsics.checkNotNullExpressionValue(list2, "getRecordList(...)");
        super(stringArray, set2, JvmNameResolverKt.toExpandedRecordsList(list2));
        this.types = types;
    }
}

