/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.util.Either;
import java.util.Objects;

public class EitherImpl<X, Y>
implements Either<X, Y> {
    private final X left;
    private final Y right;

    protected EitherImpl(X left, Y value) {
        this.left = left;
        this.right = value;
        Preconditions.checkArgument((left == null || value == null ? 1 : 0) != 0, (Object)"Either.left and Either.right are both present");
        Preconditions.checkArgument((left != null || value != null ? 1 : 0) != 0, (Object)"Either.left and Either.right are both null");
    }

    @Override
    public boolean isLeft() {
        return this.left != null;
    }

    @Override
    public boolean isRight() {
        return this.right != null;
    }

    @Override
    public X left() {
        return this.left;
    }

    @Override
    public Y right() {
        return this.right;
    }

    public String toString() {
        return EitherImpl.jvmdowngrader$concat$toString$1(String.valueOf(this.left), String.valueOf(this.right));
    }

    public boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (o2 == null || this.getClass() != o2.getClass()) {
            return false;
        }
        EitherImpl pair = (EitherImpl)o2;
        if (!Objects.equals(this.left, pair.left)) {
            return false;
        }
        return Objects.equals(this.right, pair.right);
    }

    public int hashCode() {
        int result = this.left != null ? this.left.hashCode() : 0;
        result = 31 * result + (this.right != null ? this.right.hashCode() : 0);
        return result;
    }

    private static String jvmdowngrader$concat$toString$1(String string, String string2) {
        return "Either{" + string + ", " + string2 + "}";
    }
}

