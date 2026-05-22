/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 */
package net.darkmeow.darkmeow.utils.kotlin;

import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/darkmeow/darkmeow/utils/kotlin/BoundedArrayDeque;", "E", "Ljava/util/ArrayDeque;", "limitSize", "", "<init>", "(I)V", "add", "", "element", "(Ljava/lang/Object;)Z", "DarkMeow"})
public final class BoundedArrayDeque<E>
extends ArrayDeque<E> {
    @JvmField
    public int limitSize;

    public BoundedArrayDeque(int limitSize) {
        this.limitSize = limitSize;
    }

    @Override
    public boolean add(E element) {
        boolean bl2;
        if (element != null) {
            E it = element;
            boolean bl3 = false;
            if (super.size() >= this.limitSize) {
                super.removeFirst();
            }
            bl2 = super.add(it);
        } else {
            bl2 = false;
        }
        return bl2;
    }
}

