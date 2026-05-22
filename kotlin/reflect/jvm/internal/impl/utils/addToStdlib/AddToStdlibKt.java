/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.reflect.jvm.internal.impl.utils.addToStdlib;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension(value={"SMAP\naddToStdlib.kt\nKotlin\n*S Kotlin\n*F\n+ 1 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,416:1\n21#1,2:417\n76#1,11:419\n294#1,16:434\n332#1,13:450\n404#1,2:466\n406#1:471\n3829#2:430\n4344#2,2:431\n1#3:433\n1634#4,3:463\n1634#4,3:468\n*S KotlinDebug\n*F\n+ 1 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n67#1:417,2\n73#1:419,11\n286#1:434,16\n348#1:450,13\n409#1:466,2\n409#1:471\n137#1:430\n137#1:431,2\n405#1:463,3\n409#1:468,3\n*E\n"})
public final class AddToStdlibKt {
    @NotNull
    private static final ConcurrentHashMap<Function0<?>, Object> constantMap = new ConcurrentHashMap();

    @NotNull
    public static final Void shouldNotBeCalled(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new IllegalStateException(message.toString());
    }

    public static /* synthetic */ Void shouldNotBeCalled$default(String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = "should not be called";
        }
        return AddToStdlibKt.shouldNotBeCalled(string);
    }
}

