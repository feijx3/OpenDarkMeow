/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.converter.model;

import java.util.function.Function;
import javax.annotation.Nonnull;
import lombok.Generated;

public interface Either<L, R> {
    public static <L, R> Either<L, R> left(@Nonnull L left) {
        return new Left(left);
    }

    public static <L, R> Either<L, R> right(@Nonnull R right) {
        return new Right(right);
    }

    public static <T> T unwrap(Either<? extends T, ? extends T> either) {
        return either.isLeft() ? either.getLeft() : either.getRight();
    }

    public L getLeft();

    public R getRight();

    public boolean isLeft();

    public boolean isRight();

    public <ML, MR> Either<ML, MR> map(Function<L, ML> var1, Function<R, MR> var2);

    public <T> T xmap(Function<L, T> var1, Function<R, T> var2);

    public Either<R, L> swap();

    public String toString();

    public boolean equals(Object var1);

    public int hashCode();

    public static class Right<L, R>
    implements Either<L, R> {
        private final R right;

        private Right(R right) {
            this.right = right;
        }

        @Override
        public L getLeft() {
            return null;
        }

        @Override
        public R getRight() {
            return this.right;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public <ML, MR> Either<ML, MR> map(Function<L, ML> leftMapper, Function<R, MR> rightMapper) {
            return Either.right(rightMapper.apply(this.right));
        }

        @Override
        public <T> T xmap(Function<L, T> leftMapper, Function<R, T> rightMapper) {
            return rightMapper.apply(this.right);
        }

        @Override
        public Either<R, L> swap() {
            return Either.left(this.right);
        }

        @Override
        public String toString() {
            return "Right{" + this.getRight() + "}";
        }

        @Override
        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof Right)) {
                return false;
            }
            Right other = (Right)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            R this$right = this.getRight();
            R other$right = other.getRight();
            return !(this$right == null ? other$right != null : !this$right.equals(other$right));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Right;
        }

        @Override
        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            R $right = this.getRight();
            result = result * 59 + ($right == null ? 43 : $right.hashCode());
            return result;
        }
    }

    public static class Left<L, R>
    implements Either<L, R> {
        private final L left;

        private Left(L left) {
            this.left = left;
        }

        @Override
        public L getLeft() {
            return this.left;
        }

        @Override
        public R getRight() {
            return null;
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public <ML, MR> Either<ML, MR> map(Function<L, ML> leftMapper, Function<R, MR> rightMapper) {
            return Either.left(leftMapper.apply(this.getLeft()));
        }

        @Override
        public <T> T xmap(Function<L, T> leftMapper, Function<R, T> rightMapper) {
            return leftMapper.apply(this.getLeft());
        }

        @Override
        public Either<R, L> swap() {
            return Either.right(this.left);
        }

        @Override
        public String toString() {
            return "Left{" + this.getLeft() + "}";
        }

        @Override
        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof Left)) {
                return false;
            }
            Left other = (Left)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            L this$left = this.getLeft();
            L other$left = other.getLeft();
            return !(this$left == null ? other$left != null : !this$left.equals(other$left));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Left;
        }

        @Override
        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            L $left = this.getLeft();
            result = result * 59 + ($left == null ? 43 : $left.hashCode());
            return result;
        }
    }
}

