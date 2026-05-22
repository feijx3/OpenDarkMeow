/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import org.jetbrains.annotations.NotNull;

public final class JvmNameResolverKt {
    @NotNull
    public static final List<JvmProtoBuf.StringTableTypes.Record> toExpandedRecordsList(@NotNull List<JvmProtoBuf.StringTableTypes.Record> $this$toExpandedRecordsList) {
        ArrayList<JvmProtoBuf.StringTableTypes.Record> arrayList;
        Intrinsics.checkNotNullParameter($this$toExpandedRecordsList, "<this>");
        ArrayList<JvmProtoBuf.StringTableTypes.Record> list = arrayList = new ArrayList<JvmProtoBuf.StringTableTypes.Record>();
        boolean bl2 = false;
        list.ensureCapacity($this$toExpandedRecordsList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : $this$toExpandedRecordsList) {
            int n2 = record.getRange();
            int n3 = 0;
            while (n3 < n2) {
                int it = n3++;
                boolean bl3 = false;
                list.add(record);
            }
        }
        list.trimToSize();
        return arrayList;
    }
}

