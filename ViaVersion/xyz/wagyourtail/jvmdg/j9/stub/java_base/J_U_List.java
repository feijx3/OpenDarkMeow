/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  xyz.wagyourtail.jvmdg.version.Ref
 *  xyz.wagyourtail.jvmdg.version.Stub
 */
package ViaVersion.xyz.wagyourtail.jvmdg.j9.stub.java_base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import xyz.wagyourtail.jvmdg.version.Ref;
import xyz.wagyourtail.jvmdg.version.Stub;

public class J_U_List {
    @Stub(ref=@Ref(value="Ljava/util/List;"))
    public static <E> List<E> of() {
        return Collections.emptyList();
    }

    @SafeVarargs
    @Stub(ref=@Ref(value="Ljava/util/List;"))
    public static <E> List<E> of(E ... coll) {
        return Collections.unmodifiableList(Arrays.asList(coll));
    }

    @Stub(ref=@Ref(value="Ljava/util/List;"))
    public static <E> List<E> of(E e1) {
        return Collections.singletonList(e1);
    }

    @Stub(ref=@Ref(value="Ljava/util/List;"))
    public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
        return Collections.unmodifiableList(Arrays.asList(e1, e2, e3, e4, e5, e6));
    }

    @Stub(ref=@Ref(value="Ljava/util/List;"))
    public static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return Collections.unmodifiableList(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));
    }
}

