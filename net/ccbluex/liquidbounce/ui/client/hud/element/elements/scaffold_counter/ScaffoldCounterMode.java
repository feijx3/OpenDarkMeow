/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.ElementScaffoldCounter;
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.scaffold_counter.ScaffoldCounterData;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterMode;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "instance", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScaffoldCounter;", "getInstance", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScaffoldCounter;", "setInstance", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementScaffoldCounter;)V", "render", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "data", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/scaffold_counter/ScaffoldCounterData;", "DarkMeow"})
public abstract class ScaffoldCounterMode {
    @NotNull
    private final String name;
    public ElementScaffoldCounter instance;

    public ScaffoldCounterMode(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ElementScaffoldCounter getInstance() {
        ElementScaffoldCounter elementScaffoldCounter = this.instance;
        if (elementScaffoldCounter != null) {
            return elementScaffoldCounter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull ElementScaffoldCounter elementScaffoldCounter) {
        Intrinsics.checkNotNullParameter(elementScaffoldCounter, "<set-?>");
        this.instance = elementScaffoldCounter;
    }

    @NotNull
    public abstract ElementBorder render(@NotNull ScaffoldCounterData var1);
}

