/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.opengl.GL33
 */
package net.darkmeow.darkmeow.utils.visual.graphics;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.darkmeow.darkmeow.utils.visual.graphics.GLDataType;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL33;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute;", "", "stride", "", "entries", "", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$Entry;", "<init>", "(ILjava/util/List;)V", "apply", "", "Builder", "Entry", "FloatEntry", "IntEntry", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nVertexAttribute.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VertexAttribute.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,84:1\n1869#2,2:85\n*S KotlinDebug\n*F\n+ 1 VertexAttribute.kt\nnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute\n*L\n10#1:85,2\n*E\n"})
public final class VertexAttribute {
    private final int stride;
    @NotNull
    private final List<Entry> entries;

    private VertexAttribute(int stride, List<? extends Entry> entries) {
        this.stride = stride;
        this.entries = entries;
    }

    public final void apply() {
        Iterable $this$forEach$iv = this.entries;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Entry it = (Entry)element$iv;
            boolean bl2 = false;
            it.apply(this.stride);
        }
    }

    public /* synthetic */ VertexAttribute(int stride, List entries, DefaultConstructorMarker $constructor_marker) {
        this(stride, entries);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003J0\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$Builder;", "", "stride", "", "<init>", "(I)V", "pointer", "entries", "Ljava/util/ArrayList;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$Entry;", "Lkotlin/collections/ArrayList;", "int", "", "index", "size", "type", "Lnet/darkmeow/darkmeow/utils/visual/graphics/GLDataType;", "divisor", "float", "normalized", "", "build", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute;", "DarkMeow"})
    public static final class Builder {
        private final int stride;
        private int pointer;
        @NotNull
        private final ArrayList<Entry> entries;

        public Builder(int stride) {
            this.stride = stride;
            this.entries = new ArrayList();
        }

        public final void int(int index, int size, @NotNull GLDataType type, int divisor) {
            Intrinsics.checkNotNullParameter((Object)type, "type");
            this.entries.add(new IntEntry(index, size, type.getGlEnum(), this.pointer, divisor));
            this.pointer += size * type.getSize();
        }

        public static /* synthetic */ void int$default(Builder builder, int n2, int n3, GLDataType gLDataType, int n4, int n5, Object object) {
            if ((n5 & 8) != 0) {
                n4 = 0;
            }
            builder.int(n2, n3, gLDataType, n4);
        }

        public final void float(int index, int size, @NotNull GLDataType type, boolean normalized, int divisor) {
            Intrinsics.checkNotNullParameter((Object)type, "type");
            this.entries.add(new FloatEntry(index, size, type.getGlEnum(), this.pointer, normalized, divisor));
            this.pointer += size * type.getSize();
        }

        public static /* synthetic */ void float$default(Builder builder, int n2, int n3, GLDataType gLDataType, boolean bl2, int n4, int n5, Object object) {
            if ((n5 & 0x10) != 0) {
                n4 = 0;
            }
            builder.float(n2, n3, gLDataType, bl2, n4);
        }

        @NotNull
        public final VertexAttribute build() {
            return new VertexAttribute(this.stride, this.entries, null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0005\u0082\u0001\u0002\u0011\u0012\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0013\u00c0\u0006\u0001"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$Entry;", "", "index", "", "getIndex", "()I", "size", "getSize", "type", "getType", "pointer", "getPointer", "divisor", "getDivisor", "apply", "", "stride", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$FloatEntry;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$IntEntry;", "DarkMeow"})
    private static interface Entry {
        public int getIndex();

        public int getSize();

        public int getType();

        public int getPointer();

        public int getDivisor();

        public void apply(int var1);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$FloatEntry;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$Entry;", "index", "", "size", "type", "pointer", "normalized", "", "divisor", "<init>", "(IIIIZI)V", "getIndex", "()I", "getSize", "getType", "getPointer", "getNormalized", "()Z", "getDivisor", "apply", "", "stride", "DarkMeow"})
    private static final class FloatEntry
    implements Entry {
        private final int index;
        private final int size;
        private final int type;
        private final int pointer;
        private final boolean normalized;
        private final int divisor;

        public FloatEntry(int index, int size, int type, int pointer, boolean normalized, int divisor) {
            this.index = index;
            this.size = size;
            this.type = type;
            this.pointer = pointer;
            this.normalized = normalized;
            this.divisor = divisor;
        }

        @Override
        public int getIndex() {
            return this.index;
        }

        @Override
        public int getSize() {
            return this.size;
        }

        @Override
        public int getType() {
            return this.type;
        }

        @Override
        public int getPointer() {
            return this.pointer;
        }

        public final boolean getNormalized() {
            return this.normalized;
        }

        @Override
        public int getDivisor() {
            return this.divisor;
        }

        @Override
        public void apply(int stride) {
            GL20.glVertexAttribPointer((int)this.getIndex(), (int)this.getSize(), (int)this.getType(), (boolean)this.normalized, (int)stride, (long)this.getPointer());
            GL20.glEnableVertexAttribArray((int)this.getIndex());
            if (this.getDivisor() != 0) {
                GL33.glVertexAttribDivisor((int)this.getIndex(), (int)this.getDivisor());
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0013"}, d2={"Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$IntEntry;", "Lnet/darkmeow/darkmeow/utils/visual/graphics/VertexAttribute$Entry;", "index", "", "size", "type", "pointer", "divisor", "<init>", "(IIIII)V", "getIndex", "()I", "getSize", "getType", "getPointer", "getDivisor", "apply", "", "stride", "DarkMeow"})
    private static class IntEntry
    implements Entry {
        private final int index;
        private final int size;
        private final int type;
        private final int pointer;
        private final int divisor;

        public IntEntry(int index, int size, int type, int pointer, int divisor) {
            this.index = index;
            this.size = size;
            this.type = type;
            this.pointer = pointer;
            this.divisor = divisor;
        }

        @Override
        public int getIndex() {
            return this.index;
        }

        @Override
        public int getSize() {
            return this.size;
        }

        @Override
        public int getType() {
            return this.type;
        }

        @Override
        public int getPointer() {
            return this.pointer;
        }

        @Override
        public int getDivisor() {
            return this.divisor;
        }

        @Override
        public void apply(int stride) {
            GL30.glVertexAttribIPointer((int)this.getIndex(), (int)this.getSize(), (int)this.getType(), (int)stride, (long)this.getPointer());
            GL20.glEnableVertexAttribArray((int)this.getIndex());
            if (this.getDivisor() != 0) {
                GL33.glVertexAttribDivisor((int)this.getIndex(), (int)this.getDivisor());
            }
        }
    }
}

