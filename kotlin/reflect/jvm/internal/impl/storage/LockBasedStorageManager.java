/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.EmptySimpleLock;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;
import kotlin.reflect.jvm.internal.impl.storage.SingleThreadValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockBasedStorageManager
implements StorageManager {
    private static final String PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE){

        @Override
        @NotNull
        protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(@NotNull String source, K input) {
            if (source == null) {
                1.$$$reportNull$$$0(0);
            }
            RecursionDetectedResult recursionDetectedResult = RecursionDetectedResult.fallThrough();
            if (recursionDetectedResult == null) {
                1.$$$reportNull$$$0(1);
            }
            return recursionDetectedResult;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 1: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 1: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "source";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[1] = "recursionDetectedDefault";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "recursionDetectedDefault";
                    break;
                }
                case 1: {
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 1: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    };
    protected final SimpleLock lock;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    private final String debugText;

    private LockBasedStorageManager(@NotNull String debugText, @NotNull ExceptionHandlingStrategy exceptionHandlingStrategy, @NotNull SimpleLock lock) {
        if (debugText == null) {
            LockBasedStorageManager.$$$reportNull$$$0(4);
        }
        if (exceptionHandlingStrategy == null) {
            LockBasedStorageManager.$$$reportNull$$$0(5);
        }
        if (lock == null) {
            LockBasedStorageManager.$$$reportNull$$$0(6);
        }
        this.lock = lock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = debugText;
    }

    public LockBasedStorageManager(String debugText) {
        this(debugText, (Runnable)null, null);
    }

    public LockBasedStorageManager(String debugText, @Nullable Runnable checkCancelled, @Nullable Function1<InterruptedException, Unit> interruptedExceptionHandler) {
        this(debugText, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(checkCancelled, interruptedExceptionHandler));
    }

    public String toString() {
        return this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode()) + " (" + this.debugText + ")";
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> compute) {
        if (compute == null) {
            LockBasedStorageManager.$$$reportNull$$$0(9);
        }
        MemoizedFunctionToNotNull<? super K, ? extends V> memoizedFunctionToNotNull = this.createMemoizedFunction(compute, LockBasedStorageManager.<K>createConcurrentHashMap());
        if (memoizedFunctionToNotNull == null) {
            LockBasedStorageManager.$$$reportNull$$$0(10);
        }
        return memoizedFunctionToNotNull;
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> compute, @NotNull ConcurrentMap<K, Object> map) {
        if (compute == null) {
            LockBasedStorageManager.$$$reportNull$$$0(14);
        }
        if (map == null) {
            LockBasedStorageManager.$$$reportNull$$$0(15);
        }
        return new MapBasedMemoizedFunctionToNotNull<K, V>(this, map, compute);
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> compute) {
        if (compute == null) {
            LockBasedStorageManager.$$$reportNull$$$0(19);
        }
        MemoizedFunctionToNullable<? super K, ? extends V> memoizedFunctionToNullable = this.createMemoizedFunctionWithNullableValues(compute, LockBasedStorageManager.<K>createConcurrentHashMap());
        if (memoizedFunctionToNullable == null) {
            LockBasedStorageManager.$$$reportNull$$$0(20);
        }
        return memoizedFunctionToNullable;
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> compute, @NotNull ConcurrentMap<K, Object> map) {
        if (compute == null) {
            LockBasedStorageManager.$$$reportNull$$$0(21);
        }
        if (map == null) {
            LockBasedStorageManager.$$$reportNull$$$0(22);
        }
        return new MapBasedMemoizedFunction<K, V>(this, map, compute);
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> computable) {
        if (computable == null) {
            LockBasedStorageManager.$$$reportNull$$$0(23);
        }
        return new LockBasedNotNullLazyValue<T>(this, computable);
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> computable, final @NotNull T onRecursiveCall) {
        if (computable == null) {
            LockBasedStorageManager.$$$reportNull$$$0(26);
        }
        if (onRecursiveCall == null) {
            LockBasedStorageManager.$$$reportNull$$$0(27);
        }
        return new LockBasedNotNullLazyValue<T>(this, computable){

            @Override
            @NotNull
            protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
                RecursionDetectedResult<Object> recursionDetectedResult = RecursionDetectedResult.value(onRecursiveCall);
                if (recursionDetectedResult == null) {
                    4.$$$reportNull$$$0(0);
                }
                return recursionDetectedResult;
            }

            private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
            }
        };
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> computable, final Function1<? super Boolean, ? extends T> onRecursiveCall, final @NotNull Function1<? super T, Unit> postCompute) {
        if (computable == null) {
            LockBasedStorageManager.$$$reportNull$$$0(28);
        }
        if (postCompute == null) {
            LockBasedStorageManager.$$$reportNull$$$0(29);
        }
        return new LockBasedNotNullLazyValueWithPostCompute<T>(this, computable){

            @Override
            @NotNull
            protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
                if (onRecursiveCall == null) {
                    RecursionDetectedResult recursionDetectedResult = super.recursionDetected(firstTime);
                    if (recursionDetectedResult == null) {
                        5.$$$reportNull$$$0(0);
                    }
                    return recursionDetectedResult;
                }
                RecursionDetectedResult recursionDetectedResult = RecursionDetectedResult.value(onRecursiveCall.invoke(firstTime));
                if (recursionDetectedResult == null) {
                    5.$$$reportNull$$$0(1);
                }
                return recursionDetectedResult;
            }

            @Override
            protected void doPostCompute(@NotNull T value) {
                if (value == null) {
                    5.$$$reportNull$$$0(2);
                }
                postCompute.invoke(value);
            }

            private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                RuntimeException runtimeException;
                Object[] objectArray;
                Object[] objectArray2;
                int n3;
                String string;
                switch (n2) {
                    default: {
                        string = "@NotNull method %s.%s must not return null";
                        break;
                    }
                    case 2: {
                        string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        n3 = 2;
                        break;
                    }
                    case 2: {
                        n3 = 3;
                        break;
                    }
                }
                Object[] objectArray3 = new Object[n3];
                switch (n2) {
                    default: {
                        objectArray2 = objectArray3;
                        objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                        break;
                    }
                    case 2: {
                        objectArray2 = objectArray3;
                        objectArray3[0] = "value";
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        objectArray = objectArray2;
                        objectArray2[1] = "recursionDetected";
                        break;
                    }
                    case 2: {
                        objectArray = objectArray2;
                        objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        break;
                    }
                    case 2: {
                        objectArray = objectArray;
                        objectArray[2] = "doPostCompute";
                        break;
                    }
                }
                String string2 = String.format(string, objectArray);
                switch (n2) {
                    default: {
                        runtimeException = new IllegalStateException(string2);
                        break;
                    }
                    case 2: {
                        runtimeException = new IllegalArgumentException(string2);
                        break;
                    }
                }
                throw runtimeException;
            }
        };
    }

    @Override
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> computable) {
        if (computable == null) {
            LockBasedStorageManager.$$$reportNull$$$0(30);
        }
        return new LockBasedLazyValue<T>(this, computable);
    }

    @Override
    public <T> T compute(@NotNull Function0<? extends T> computable) {
        if (computable == null) {
            LockBasedStorageManager.$$$reportNull$$$0(34);
        }
        this.lock.lock();
        try {
            T t2 = computable.invoke();
            return t2;
        }
        catch (Throwable throwable) {
            throw this.exceptionHandlingStrategy.handleException(throwable);
        }
        finally {
            this.lock.unlock();
        }
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    @NotNull
    protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(@NotNull String source, K input) {
        if (source == null) {
            LockBasedStorageManager.$$$reportNull$$$0(35);
        }
        throw LockBasedStorageManager.sanitizeStackTrace(new AssertionError((Object)("Recursion detected " + source + (input == null ? "" : "on input: " + input) + " under " + this)));
    }

    @NotNull
    private static <T extends Throwable> T sanitizeStackTrace(@NotNull T throwable) {
        if (throwable == null) {
            LockBasedStorageManager.$$$reportNull$$$0(36);
        }
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int size = stackTrace.length;
        int firstNonStorage = -1;
        for (int i2 = 0; i2 < size; ++i2) {
            if (stackTrace[i2].getClassName().startsWith(PACKAGE_NAME)) continue;
            firstNonStorage = i2;
            break;
        }
        assert (firstNonStorage >= 0) : "This method should only be called on exceptions created in LockBasedStorageManager";
        List<StackTraceElement> list = Arrays.asList(stackTrace).subList(firstNonStorage, size);
        throwable.setStackTrace(list.toArray(new StackTraceElement[list.size()]));
        T t2 = throwable;
        if (t2 == null) {
            LockBasedStorageManager.$$$reportNull$$$0(37);
        }
        return t2;
    }

    @Override
    @NotNull
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(this, (ConcurrentMap)LockBasedStorageManager.<K>createConcurrentHashMap());
    }

    @Override
    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(this, (ConcurrentMap)LockBasedStorageManager.<K>createConcurrentHashMap());
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n2) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n3;
        String string;
        switch (n2) {
            default: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 10: 
            case 13: 
            case 20: 
            case 37: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n2) {
            default: {
                n3 = 3;
                break;
            }
            case 10: 
            case 13: 
            case 20: 
            case 37: {
                n3 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n3];
        switch (n2) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "debugText";
                break;
            }
            case 1: 
            case 3: 
            case 5: 
            case 8: {
                objectArray2 = objectArray3;
                objectArray3[0] = "exceptionHandlingStrategy";
                break;
            }
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "lock";
                break;
            }
            case 9: 
            case 11: 
            case 14: 
            case 16: 
            case 19: 
            case 21: {
                objectArray2 = objectArray3;
                objectArray3[0] = "compute";
                break;
            }
            case 10: 
            case 13: 
            case 20: 
            case 37: {
                objectArray2 = objectArray3;
                objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                break;
            }
            case 12: 
            case 17: 
            case 25: 
            case 27: {
                objectArray2 = objectArray3;
                objectArray3[0] = "onRecursiveCall";
                break;
            }
            case 15: 
            case 18: 
            case 22: {
                objectArray2 = objectArray3;
                objectArray3[0] = "map";
                break;
            }
            case 23: 
            case 24: 
            case 26: 
            case 28: 
            case 30: 
            case 31: 
            case 32: 
            case 34: {
                objectArray2 = objectArray3;
                objectArray3[0] = "computable";
                break;
            }
            case 29: 
            case 33: {
                objectArray2 = objectArray3;
                objectArray3[0] = "postCompute";
                break;
            }
            case 35: {
                objectArray2 = objectArray3;
                objectArray3[0] = "source";
                break;
            }
            case 36: {
                objectArray2 = objectArray3;
                objectArray3[0] = "throwable";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                break;
            }
            case 10: 
            case 13: {
                objectArray = objectArray2;
                objectArray2[1] = "createMemoizedFunction";
                break;
            }
            case 20: {
                objectArray = objectArray2;
                objectArray2[1] = "createMemoizedFunctionWithNullableValues";
                break;
            }
            case 37: {
                objectArray = objectArray2;
                objectArray2[1] = "sanitizeStackTrace";
                break;
            }
        }
        switch (n2) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "createWithExceptionHandling";
                break;
            }
            case 4: 
            case 5: 
            case 6: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 7: 
            case 8: {
                objectArray = objectArray;
                objectArray[2] = "replaceExceptionHandling";
                break;
            }
            case 9: 
            case 11: 
            case 12: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: {
                objectArray = objectArray;
                objectArray[2] = "createMemoizedFunction";
                break;
            }
            case 10: 
            case 13: 
            case 20: 
            case 37: {
                break;
            }
            case 19: 
            case 21: 
            case 22: {
                objectArray = objectArray;
                objectArray[2] = "createMemoizedFunctionWithNullableValues";
                break;
            }
            case 23: 
            case 24: 
            case 25: {
                objectArray = objectArray;
                objectArray[2] = "createLazyValue";
                break;
            }
            case 26: 
            case 27: {
                objectArray = objectArray;
                objectArray[2] = "createRecursionTolerantLazyValue";
                break;
            }
            case 28: 
            case 29: {
                objectArray = objectArray;
                objectArray[2] = "createLazyValueWithPostCompute";
                break;
            }
            case 30: {
                objectArray = objectArray;
                objectArray[2] = "createNullableLazyValue";
                break;
            }
            case 31: {
                objectArray = objectArray;
                objectArray[2] = "createRecursionTolerantNullableLazyValue";
                break;
            }
            case 32: 
            case 33: {
                objectArray = objectArray;
                objectArray[2] = "createNullableLazyValueWithPostCompute";
                break;
            }
            case 34: {
                objectArray = objectArray;
                objectArray[2] = "compute";
                break;
            }
            case 35: {
                objectArray = objectArray;
                objectArray[2] = "recursionDetectedDefault";
                break;
            }
            case 36: {
                objectArray = objectArray;
                objectArray[2] = "sanitizeStackTrace";
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n2) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 10: 
            case 13: 
            case 20: 
            case 37: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }

    private static class KeyWithComputation<K, V> {
        private final K key;
        private final Function0<? extends V> computation;

        public KeyWithComputation(K key, Function0<? extends V> computation) {
            this.key = key;
            this.computation = computation;
        }

        public boolean equals(Object o2) {
            if (this == o2) {
                return true;
            }
            if (o2 == null || this.getClass() != o2.getClass()) {
                return false;
            }
            KeyWithComputation that = (KeyWithComputation)o2;
            return this.key.equals(that.key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V>
    extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V>
    implements CacheWithNotNullValues<K, V> {
        private CacheWithNotNullValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> map) {
            if (storageManager == null) {
                CacheWithNotNullValuesBasedOnMemoizedFunction.$$$reportNull$$$0(0);
            }
            if (map == null) {
                CacheWithNotNullValuesBasedOnMemoizedFunction.$$$reportNull$$$0(1);
            }
            super(storageManager, map);
        }

        @Override
        @NotNull
        public V computeIfAbsent(K key, @NotNull Function0<? extends V> computation) {
            if (computation == null) {
                CacheWithNotNullValuesBasedOnMemoizedFunction.$$$reportNull$$$0(2);
            }
            V result = super.computeIfAbsent(key, computation);
            assert (result != null) : "computeIfAbsent() returned null under " + this.getStorageManager();
            V v2 = result;
            if (v2 == null) {
                CacheWithNotNullValuesBasedOnMemoizedFunction.$$$reportNull$$$0(3);
            }
            return v2;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 3: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 3: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "map";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "computation";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[1] = "computeIfAbsent";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
                case 2: {
                    objectArray = objectArray;
                    objectArray[2] = "computeIfAbsent";
                    break;
                }
                case 3: {
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 3: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }

    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V>
    extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V>
    implements CacheWithNullableValues<K, V> {
        private CacheWithNullableValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> map) {
            if (storageManager == null) {
                CacheWithNullableValuesBasedOnMemoizedFunction.$$$reportNull$$$0(0);
            }
            if (map == null) {
                CacheWithNullableValuesBasedOnMemoizedFunction.$$$reportNull$$$0(1);
            }
            super(storageManager, map, new Function1<KeyWithComputation<K, V>, V>(){

                @Override
                public V invoke(KeyWithComputation<K, V> computation) {
                    return computation.computation.invoke();
                }
            });
        }

        @Nullable
        public V computeIfAbsent(K key, @NotNull Function0<? extends V> computation) {
            if (computation == null) {
                CacheWithNullableValuesBasedOnMemoizedFunction.$$$reportNull$$$0(2);
            }
            return this.invoke(new KeyWithComputation<K, V>(key, computation));
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = new Object[3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "map";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "computation";
                    break;
                }
            }
            objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[2] = "<init>";
                    break;
                }
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[2] = "computeIfAbsent";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }

    private static class MapBasedMemoizedFunctionToNotNull<K, V>
    extends MapBasedMemoizedFunction<K, V>
    implements MemoizedFunctionToNotNull<K, V> {
        public MapBasedMemoizedFunctionToNotNull(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<K, Object> map, @NotNull Function1<? super K, ? extends V> compute) {
            if (storageManager == null) {
                MapBasedMemoizedFunctionToNotNull.$$$reportNull$$$0(0);
            }
            if (map == null) {
                MapBasedMemoizedFunctionToNotNull.$$$reportNull$$$0(1);
            }
            if (compute == null) {
                MapBasedMemoizedFunctionToNotNull.$$$reportNull$$$0(2);
            }
            super(storageManager, map, compute);
        }

        @Override
        @NotNull
        public V invoke(K input) {
            Object result = super.invoke(input);
            assert (result != null) : "compute() returned null under " + this.getStorageManager();
            Object v2 = result;
            if (v2 == null) {
                MapBasedMemoizedFunctionToNotNull.$$$reportNull$$$0(3);
            }
            return v2;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 3: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 3: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "map";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "compute";
                    break;
                }
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[1] = "invoke";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
                case 3: {
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 3: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }

    private static class MapBasedMemoizedFunction<K, V>
    implements MemoizedFunctionToNullable<K, V> {
        private final LockBasedStorageManager storageManager;
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;

        public MapBasedMemoizedFunction(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<K, Object> map, @NotNull Function1<? super K, ? extends V> compute) {
            if (storageManager == null) {
                MapBasedMemoizedFunction.$$$reportNull$$$0(0);
            }
            if (map == null) {
                MapBasedMemoizedFunction.$$$reportNull$$$0(1);
            }
            if (compute == null) {
                MapBasedMemoizedFunction.$$$reportNull$$$0(2);
            }
            this.storageManager = storageManager;
            this.cache = map;
            this.compute = compute;
        }

        @Override
        @Nullable
        public V invoke(K input) {
            Object value = this.cache.get(input);
            if (value != null && value != NotValue.COMPUTING) {
                return WrappedValues.unescapeExceptionOrNull(value);
            }
            this.storageManager.lock.lock();
            try {
                V v2;
                RecursionDetectedResult<V> result;
                value = this.cache.get(input);
                if (value == NotValue.COMPUTING) {
                    value = NotValue.RECURSION_WAS_DETECTED;
                    result = this.recursionDetected(input, true);
                    if (!result.isFallThrough()) {
                        V v3 = result.getValue();
                        return v3;
                    }
                }
                if (value == NotValue.RECURSION_WAS_DETECTED && !(result = this.recursionDetected(input, false)).isFallThrough()) {
                    V v4 = result.getValue();
                    return v4;
                }
                if (value != null) {
                    result = WrappedValues.unescapeExceptionOrNull(value);
                    return (V)result;
                }
                AssertionError error = null;
                try {
                    this.cache.put(input, (Object)NotValue.COMPUTING);
                    V typedValue = this.compute.invoke(input);
                    Object oldValue = this.cache.put(input, WrappedValues.escapeNull(typedValue));
                    if (oldValue != NotValue.COMPUTING) {
                        error = this.raceCondition(input, oldValue);
                        throw error;
                    }
                    v2 = typedValue;
                }
                catch (Throwable throwable) {
                    if (ExceptionUtilsKt.isProcessCanceledException(throwable)) {
                        Object remove;
                        try {
                            remove = this.cache.remove(input);
                        }
                        catch (Throwable e2) {
                            throw this.unableToRemoveKey(input, e2);
                        }
                        if (remove != NotValue.COMPUTING) {
                            throw this.inconsistentComputingKey(input, remove);
                        }
                        throw (RuntimeException)throwable;
                    }
                    if (throwable == error) {
                        try {
                            this.cache.remove(input);
                        }
                        catch (Throwable e3) {
                            throw this.unableToRemoveKey(input, e3);
                        }
                        throw this.storageManager.exceptionHandlingStrategy.handleException(throwable);
                    }
                    Object oldValue = this.cache.put(input, WrappedValues.escapeThrowable(throwable));
                    if (oldValue != NotValue.COMPUTING) {
                        throw this.raceCondition(input, oldValue);
                    }
                    throw this.storageManager.exceptionHandlingStrategy.handleException(throwable);
                }
                return v2;
            }
            finally {
                this.storageManager.lock.unlock();
            }
        }

        @NotNull
        protected RecursionDetectedResult<V> recursionDetected(K input, boolean firstTime) {
            RecursionDetectedResult recursionDetectedResult = this.storageManager.recursionDetectedDefault("", input);
            if (recursionDetectedResult == null) {
                MapBasedMemoizedFunction.$$$reportNull$$$0(3);
            }
            return recursionDetectedResult;
        }

        @NotNull
        private AssertionError raceCondition(K input, Object oldValue) {
            AssertionError assertionError = (AssertionError)((Object)LockBasedStorageManager.sanitizeStackTrace((Throwable)((Object)new AssertionError((Object)("Race condition detected on input " + input + ". Old value is " + oldValue + " under " + this.storageManager)))));
            if (assertionError == null) {
                MapBasedMemoizedFunction.$$$reportNull$$$0(4);
            }
            return assertionError;
        }

        private AssertionError inconsistentComputingKey(K input, Object oldValue) {
            return (AssertionError)((Object)LockBasedStorageManager.sanitizeStackTrace((Throwable)((Object)new AssertionError((Object)("Inconsistent key detected. " + (Object)((Object)NotValue.COMPUTING) + " is expected, was: " + oldValue + ", most probably race condition detected on input " + input + " under " + this.storageManager)))));
        }

        private AssertionError unableToRemoveKey(K input, Throwable throwable) {
            return (AssertionError)((Object)LockBasedStorageManager.sanitizeStackTrace((Throwable)((Object)new AssertionError("Unable to remove " + input + " under " + this.storageManager, throwable))));
        }

        @Override
        public boolean isComputed(K key) {
            Object value = this.cache.get(key);
            return value != null && value != NotValue.COMPUTING;
        }

        protected LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 3: 
                case 4: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 3: 
                case 4: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "map";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "compute";
                    break;
                }
                case 3: 
                case 4: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[1] = "recursionDetected";
                    break;
                }
                case 4: {
                    objectArray = objectArray2;
                    objectArray2[1] = "raceCondition";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
                case 3: 
                case 4: {
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 3: 
                case 4: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }

    private static class LockBasedNotNullLazyValue<T>
    extends LockBasedLazyValue<T>
    implements NotNullLazyValue<T> {
        public LockBasedNotNullLazyValue(@NotNull LockBasedStorageManager storageManager, @NotNull Function0<? extends T> computable) {
            if (storageManager == null) {
                LockBasedNotNullLazyValue.$$$reportNull$$$0(0);
            }
            if (computable == null) {
                LockBasedNotNullLazyValue.$$$reportNull$$$0(1);
            }
            super(storageManager, computable);
        }

        @Override
        @NotNull
        public T invoke() {
            Object result = super.invoke();
            assert (result != null) : "compute() returned null";
            Object t2 = result;
            if (t2 == null) {
                LockBasedNotNullLazyValue.$$$reportNull$$$0(2);
            }
            return t2;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 2: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 2: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "computable";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                    break;
                }
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[1] = "invoke";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
                case 2: {
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 2: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }

    private static abstract class LockBasedNotNullLazyValueWithPostCompute<T>
    extends LockBasedLazyValueWithPostCompute<T>
    implements NotNullLazyValue<T> {
        public LockBasedNotNullLazyValueWithPostCompute(@NotNull LockBasedStorageManager storageManager, @NotNull Function0<? extends T> computable) {
            if (storageManager == null) {
                LockBasedNotNullLazyValueWithPostCompute.$$$reportNull$$$0(0);
            }
            if (computable == null) {
                LockBasedNotNullLazyValueWithPostCompute.$$$reportNull$$$0(1);
            }
            super(storageManager, computable);
        }

        @Override
        @NotNull
        public T invoke() {
            Object result = super.invoke();
            assert (result != null) : "compute() returned null";
            Object t2 = result;
            if (t2 == null) {
                LockBasedNotNullLazyValueWithPostCompute.$$$reportNull$$$0(2);
            }
            return t2;
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 2: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 2: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "computable";
                    break;
                }
                case 2: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
                    break;
                }
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[1] = "invoke";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
                case 2: {
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 2: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }

    private static abstract class LockBasedLazyValueWithPostCompute<T>
    extends LockBasedLazyValue<T> {
        @Nullable
        private volatile SingleThreadValue<T> valuePostCompute;

        public LockBasedLazyValueWithPostCompute(@NotNull LockBasedStorageManager storageManager, @NotNull Function0<? extends T> computable) {
            if (storageManager == null) {
                LockBasedLazyValueWithPostCompute.$$$reportNull$$$0(0);
            }
            if (computable == null) {
                LockBasedLazyValueWithPostCompute.$$$reportNull$$$0(1);
            }
            super(storageManager, computable);
            this.valuePostCompute = null;
        }

        @Override
        public T invoke() {
            SingleThreadValue<T> postComputeCache = this.valuePostCompute;
            if (postComputeCache != null && postComputeCache.hasValue()) {
                return postComputeCache.getValue();
            }
            return super.invoke();
        }

        @Override
        protected final void postCompute(T value) {
            this.valuePostCompute = new SingleThreadValue<T>(value);
            try {
                this.doPostCompute(value);
            }
            finally {
                this.valuePostCompute = null;
            }
        }

        protected abstract void doPostCompute(T var1);

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            Object[] objectArray;
            Object[] objectArray2 = new Object[3];
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[0] = "computable";
                    break;
                }
            }
            objectArray[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objectArray[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }

    private static class LockBasedLazyValue<T>
    implements NullableLazyValue<T> {
        private final LockBasedStorageManager storageManager;
        private final Function0<? extends T> computable;
        @Nullable
        private volatile Object value;

        public LockBasedLazyValue(@NotNull LockBasedStorageManager storageManager, @NotNull Function0<? extends T> computable) {
            if (storageManager == null) {
                LockBasedLazyValue.$$$reportNull$$$0(0);
            }
            if (computable == null) {
                LockBasedLazyValue.$$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = storageManager;
            this.computable = computable;
        }

        public boolean isComputed() {
            return this.value != NotValue.NOT_COMPUTED && this.value != NotValue.COMPUTING;
        }

        @Override
        public T invoke() {
            Object _value = this.value;
            if (!(_value instanceof NotValue)) {
                return (T)WrappedValues.unescapeThrowable(_value);
            }
            this.storageManager.lock.lock();
            try {
                T t2;
                RecursionDetectedResult<T> result;
                _value = this.value;
                if (!(_value instanceof NotValue)) {
                    Object v2 = WrappedValues.unescapeThrowable(_value);
                    return (T)v2;
                }
                if (_value == NotValue.COMPUTING) {
                    this.value = NotValue.RECURSION_WAS_DETECTED;
                    result = this.recursionDetected(true);
                    if (!result.isFallThrough()) {
                        T t3 = result.getValue();
                        return t3;
                    }
                }
                if (_value == NotValue.RECURSION_WAS_DETECTED && !(result = this.recursionDetected(false)).isFallThrough()) {
                    T t4 = result.getValue();
                    return t4;
                }
                this.value = NotValue.COMPUTING;
                try {
                    T typedValue = this.computable.invoke();
                    this.postCompute(typedValue);
                    this.value = typedValue;
                    t2 = typedValue;
                }
                catch (Throwable throwable) {
                    if (ExceptionUtilsKt.isProcessCanceledException(throwable)) {
                        this.value = NotValue.NOT_COMPUTED;
                        throw (RuntimeException)throwable;
                    }
                    if (this.value == NotValue.COMPUTING) {
                        this.value = WrappedValues.escapeThrowable(throwable);
                    }
                    throw this.storageManager.exceptionHandlingStrategy.handleException(throwable);
                }
                return t2;
            }
            finally {
                this.storageManager.lock.unlock();
            }
        }

        @NotNull
        protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
            RecursionDetectedResult recursionDetectedResult = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedResult == null) {
                LockBasedLazyValue.$$$reportNull$$$0(2);
            }
            return recursionDetectedResult;
        }

        protected void postCompute(T value) {
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n2) {
            RuntimeException runtimeException;
            Object[] objectArray;
            Object[] objectArray2;
            int n3;
            String string;
            switch (n2) {
                default: {
                    string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 2: 
                case 3: {
                    string = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            switch (n2) {
                default: {
                    n3 = 3;
                    break;
                }
                case 2: 
                case 3: {
                    n3 = 2;
                    break;
                }
            }
            Object[] objectArray3 = new Object[n3];
            switch (n2) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "storageManager";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "computable";
                    break;
                }
                case 2: 
                case 3: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
                }
                case 2: {
                    objectArray = objectArray2;
                    objectArray2[1] = "recursionDetected";
                    break;
                }
                case 3: {
                    objectArray = objectArray2;
                    objectArray2[1] = "renderDebugInformation";
                    break;
                }
            }
            switch (n2) {
                default: {
                    objectArray = objectArray;
                    objectArray[2] = "<init>";
                    break;
                }
                case 2: 
                case 3: {
                    break;
                }
            }
            String string2 = String.format(string, objectArray);
            switch (n2) {
                default: {
                    runtimeException = new IllegalArgumentException(string2);
                    break;
                }
                case 2: 
                case 3: {
                    runtimeException = new IllegalStateException(string2);
                    break;
                }
            }
            throw runtimeException;
        }
    }

    private static enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED;

    }

    private static class RecursionDetectedResult<T> {
        private final T value;
        private final boolean fallThrough;

        @NotNull
        public static <T> RecursionDetectedResult<T> value(T value) {
            return new RecursionDetectedResult<T>(value, false);
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<Object>(null, true);
        }

        private RecursionDetectedResult(T value, boolean fallThrough) {
            this.value = value;
            this.fallThrough = fallThrough;
        }

        public T getValue() {
            assert (!this.fallThrough) : "A value requested from FALL_THROUGH in " + this;
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            return this.isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    public static interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy(){

            @Override
            @NotNull
            public RuntimeException handleException(@NotNull Throwable throwable) {
                if (throwable == null) {
                    1.$$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(throwable);
            }

            private static /* synthetic */ void $$$reportNull$$$0(int n2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }
        };

        @NotNull
        public RuntimeException handleException(@NotNull Throwable var1);
    }
}

