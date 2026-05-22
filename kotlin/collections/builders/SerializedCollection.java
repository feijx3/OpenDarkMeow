/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016\u00a2\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "collection", "", "tag", "", "<init>", "(Ljava/util/Collection;I)V", "()V", "writeExternal", "", "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", "", "Companion", "kotlin-stdlib"})
@SourceDebugExtension(value={"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
public final class SerializedCollection
implements Externalizable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Collection<?> collection;
    private final int tag;
    private static final long serialVersionUID = 0L;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    public SerializedCollection(@NotNull Collection<?> collection, int tag) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.tag = tag;
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    @Override
    public void writeExternal(@NotNull ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        for (Object element : this.collection) {
            output.writeObject(element);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void readExternal(@NotNull ObjectInput input) {
        Collection collection;
        Intrinsics.checkNotNullParameter(input, "input");
        byte flags = input.readByte();
        int tag = flags & 1;
        int other = flags & 0xFFFFFFFE;
        if (other != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + flags + '.');
        }
        int size = input.readInt();
        if (size < 0) {
            throw new InvalidObjectException("Illegal size value: " + size + '.');
        }
        SerializedCollection serializedCollection = this;
        switch (tag) {
            case 0: {
                List list;
                List list2 = list = CollectionsKt.createListBuilder(size);
                SerializedCollection serializedCollection2 = serializedCollection;
                boolean bl2 = false;
                int n2 = 0;
                while (n2 < size) {
                    void $this$readExternal_u24lambda_u241;
                    int it = n2++;
                    boolean bl3 = false;
                    $this$readExternal_u24lambda_u241.add(input.readObject());
                }
                SerializedCollection serializedCollection3 = serializedCollection2;
                collection = CollectionsKt.build(list);
                break;
            }
            case 1: {
                Set set;
                Set $this$readExternal_u24lambda_u241 = set = SetsKt.createSetBuilder(size);
                SerializedCollection serializedCollection4 = serializedCollection;
                boolean bl4 = false;
                int n3 = 0;
                while (n3 < size) {
                    void $this$readExternal_u24lambda_u243;
                    int it = n3++;
                    boolean bl5 = false;
                    $this$readExternal_u24lambda_u243.add(input.readObject());
                }
                SerializedCollection serializedCollection3 = serializedCollection4;
                collection = SetsKt.build(set);
                break;
            }
            default: {
                throw new InvalidObjectException("Unsupported collection type tag: " + tag + '.');
            }
        }
        serializedCollection3.collection = collection;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "<init>", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

