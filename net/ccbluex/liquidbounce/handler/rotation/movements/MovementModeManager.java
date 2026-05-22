/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.handler.rotation.movements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.handler.rotation.movements.mode.MovementMode;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/ccbluex/liquidbounce/handler/rotation/movements/MovementModeManager;", "", "<init>", "()V", "modes", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/handler/rotation/movements/mode/MovementMode;", "Lkotlin/collections/HashMap;", "getModes", "()Ljava/util/HashMap;", "listModes", "", "getListModes", "()Ljava/util/List;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nMovementModeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovementModeManager.kt\nnet/ccbluex/liquidbounce/handler/rotation/movements/MovementModeManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,28:1\n1#2:29\n1#2:35\n1563#3:30\n1634#3,3:31\n2756#3:34\n*S KotlinDebug\n*F\n+ 1 MovementModeManager.kt\nnet/ccbluex/liquidbounce/handler/rotation/movements/MovementModeManager\n*L\n22#1:35\n21#1:30\n21#1:31,3\n22#1:34\n*E\n"})
public final class MovementModeManager {
    @NotNull
    private final HashMap<String, MovementMode> modes = new HashMap();
    @NotNull
    private final List<String> listModes = new ArrayList();

    /*
     * WARNING - void declaration
     */
    public MovementModeManager() {
        try {
            List<Class<MovementMode>> list;
            List<Class<MovementMode>> list2;
            List<Class<MovementMode>> it = list2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".mode.impl", MovementMode.class);
            boolean bl2 = false;
            List<Class<MovementMode>> list3 = list = !((Collection)it).isEmpty() ? list2 : null;
            if (list != null) {
                void $this$onEach$iv;
                MovementMode it2;
                void $this$mapTo$iv$iv;
                Iterable $this$map$iv;
                List<Class<MovementMode>> list4;
                Iterable<Class<MovementMode>> it3 = list4 = list;
                boolean bl3 = false;
                this.modes.clear();
                this.listModes.clear();
                this.listModes.add("None");
                it3 = list4;
                boolean $i$f$map = false;
                void var6_8 = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Class clazz = (Class)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl4 = false;
                    collection.add((MovementMode)ClassUtils.INSTANCE.getObjectInstance(it2));
                }
                $this$map$iv = (List)destination$iv$iv;
                boolean $i$f$onEach = false;
                void $this$onEach_u24lambda_u2418$iv = var6_8 = $this$onEach$iv;
                boolean bl5 = false;
                for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                    it2 = (MovementMode)element$iv;
                    boolean bl6 = false;
                    ((Map)this.modes).put(it2.getName(), it2);
                    this.listModes.add(it2.getName());
                }
                List cfr_ignored_0 = (List)var6_8;
            }
        }
        catch (Throwable throwable) {
        }
    }

    @NotNull
    public final HashMap<String, MovementMode> getModes() {
        return this.modes;
    }

    @NotNull
    public final List<String> getListModes() {
        return this.listModes;
    }
}

