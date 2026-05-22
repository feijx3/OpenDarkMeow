/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.InternalCoroutinesApi
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import kotlinx.coroutines.internal.MissingMainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0003H\u0007\u001a \u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\b\u0010\u0011\u001a\u00020\u0012H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\u00020\bX\u0082D\u00a2\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "tryCreateDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "isMissing", "", "SUPPORT_MISSING", "getSUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatchersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,130:1\n1#2:131\n*E\n"})
public final class MainDispatchersKt {
    @NotNull
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";
    private static final boolean SUPPORT_MISSING = true;

    @InternalCoroutinesApi
    @NotNull
    public static final MainCoroutineDispatcher tryCreateDispatcher(@NotNull MainDispatcherFactory $this$tryCreateDispatcher, @NotNull List<? extends MainDispatcherFactory> factories) {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        try {
            mainCoroutineDispatcher = $this$tryCreateDispatcher.createDispatcher(factories);
        }
        catch (Throwable cause) {
            mainCoroutineDispatcher = MainDispatchersKt.createMissingDispatcher(cause, $this$tryCreateDispatcher.hintOnError());
        }
        return mainCoroutineDispatcher;
    }

    @InternalCoroutinesApi
    public static final boolean isMissing(@NotNull MainCoroutineDispatcher $this$isMissing) {
        return $this$isMissing.getImmediate() instanceof MissingMainCoroutineDispatcher;
    }

    private static /* synthetic */ void getSUPPORT_MISSING$annotations() {
    }

    private static final MissingMainCoroutineDispatcher createMissingDispatcher(Throwable cause, String errorHint) {
        if (!SUPPORT_MISSING) {
            if (cause != null) {
                Throwable it = cause;
                boolean bl2 = false;
                throw it;
            }
            MainDispatchersKt.throwMissingMainDispatcherException();
            throw new KotlinNothingValueException();
        }
        return new MissingMainCoroutineDispatcher(cause, errorHint);
    }

    static /* synthetic */ MissingMainCoroutineDispatcher createMissingDispatcher$default(Throwable throwable, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        if ((n2 & 2) != 0) {
            string = null;
        }
        return MainDispatchersKt.createMissingDispatcher(throwable, string);
    }

    @NotNull
    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}

