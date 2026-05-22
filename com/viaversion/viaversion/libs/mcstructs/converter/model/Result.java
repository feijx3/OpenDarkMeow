/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.converter.model;

import com.viaversion.viaversion.libs.mcstructs.converter.model.CodecException;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Generated;

public interface Result<T> {
    public static <T> Result<T> success(T result) {
        return new Success(result);
    }

    public static <T> Result<T> error(String error) {
        return new Error(new CodecException(error));
    }

    public static <T> Result<T> error(Throwable cause) {
        return new Error(new CodecException(cause));
    }

    public static <T> Result<T> mergeErrors(String error, Collection<Result<?>> errors) {
        String errorMessages = errors.stream().filter(Result::isError).map(Result::getError).map(Throwable::getMessage).map((? super T s2) -> "[" + s2 + "]").collect(Collectors.joining(","));
        CodecException exception = new CodecException(error + ": " + errorMessages);
        errors.stream().filter(Result::isError).map(Result::getError).forEach(exception::addSuppressed);
        return new Error(exception);
    }

    public static <T> Result<T> unexpected(Object actual, Class<?> ... expected) {
        return Result.unexpected(actual, (String[])Arrays.stream(expected).map(Class::getSimpleName).toArray(String[]::new));
    }

    public static <T> Result<T> unexpected(Object actual, String ... expected) {
        return Result.error("Expected " + String.join((CharSequence)"/", expected) + " but got " + (actual == null ? "null" : actual.getClass().getSimpleName()));
    }

    public T get();

    public CodecException getError();

    public T getOrThrow(Function<Throwable, ? extends Throwable> var1);

    public T orElse(T var1);

    public T orElseThrow(Function<Throwable, ? extends Throwable> var1);

    public <N> Result<N> map(Function<T, N> var1);

    public <N> Result<N> mapResult(Function<T, Result<N>> var1);

    public <N> Result<N> mapError();

    public boolean isSuccessful();

    public boolean isError();

    public String toString();

    public boolean equals(Object var1);

    public int hashCode();

    public static class Error<T>
    implements Result<T> {
        private final CodecException error;

        private Error(CodecException error) {
            this.error = error;
        }

        @Override
        public T get() {
            throw this.error;
        }

        @Override
        public CodecException getError() {
            return this.error;
        }

        @Override
        public T getOrThrow(Function<Throwable, ? extends Throwable> exceptionSupplier) {
            throw exceptionSupplier.apply(this.error);
        }

        @Override
        public T orElse(T other) {
            return other;
        }

        @Override
        public T orElseThrow(Function<Throwable, ? extends Throwable> exceptionSupplier) {
            throw exceptionSupplier.apply(this.error);
        }

        @Override
        public <N> Result<N> map(Function<T, N> mapper) {
            return this.mapError();
        }

        @Override
        public <N> Result<N> mapResult(Function<T, Result<N>> mapper) {
            return this.mapError();
        }

        @Override
        public <N> Result<N> mapError() {
            return this;
        }

        @Override
        public boolean isSuccessful() {
            return false;
        }

        @Override
        public boolean isError() {
            return true;
        }

        @Override
        public String toString() {
            return "Error{" + this.error.getMessage() + "}";
        }

        @Override
        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof Error)) {
                return false;
            }
            Error other = (Error)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            CodecException this$error = this.getError();
            CodecException other$error = other.getError();
            return !(this$error == null ? other$error != null : !this$error.equals(other$error));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Error;
        }

        @Override
        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            CodecException $error = this.getError();
            result = result * 59 + ($error == null ? 43 : $error.hashCode());
            return result;
        }
    }

    public static class Success<T>
    implements Result<T> {
        private final T result;

        private Success(T result) {
            this.result = result;
        }

        @Override
        public T get() {
            return this.result;
        }

        @Override
        public CodecException getError() {
            return null;
        }

        @Override
        public T getOrThrow(Function<Throwable, ? extends Throwable> exceptionSupplier) {
            return this.result;
        }

        @Override
        public T orElse(T other) {
            return this.result;
        }

        @Override
        public T orElseThrow(Function<Throwable, ? extends Throwable> exceptionSupplier) {
            return this.result;
        }

        @Override
        public <N> Result<N> map(Function<T, N> mapper) {
            return Result.success(mapper.apply(this.result));
        }

        @Override
        public <N> Result<N> mapResult(Function<T, Result<N>> mapper) {
            return mapper.apply(this.result);
        }

        @Override
        public <N> Result<N> mapError() {
            return Result.error("No error");
        }

        @Override
        public boolean isSuccessful() {
            return true;
        }

        @Override
        public boolean isError() {
            return false;
        }

        @Override
        public String toString() {
            return "Success{" + this.result + "}";
        }

        @Override
        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof Success)) {
                return false;
            }
            Success other = (Success)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            T this$result = this.result;
            T other$result = other.result;
            return !(this$result == null ? other$result != null : !this$result.equals(other$result));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Success;
        }

        @Override
        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            T $result = this.result;
            result = result * 59 + ($result == null ? 43 : $result.hashCode());
            return result;
        }
    }
}

