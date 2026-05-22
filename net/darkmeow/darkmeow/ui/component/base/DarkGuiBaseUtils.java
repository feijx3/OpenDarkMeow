/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.ui.component.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.darkmeow.darkmeow.ui.component.AbstractComponent;
import net.darkmeow.darkmeow.ui.component.base.IDarkGuiBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u0002H\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2={"Lnet/darkmeow/darkmeow/ui/component/base/DarkGuiBaseUtils;", "", "<init>", "()V", "addComponent", "", "Type", "Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;", "Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;", "component", "postExecute", "Lkotlin/Function1;", "(Lnet/darkmeow/darkmeow/ui/component/base/IDarkGuiBase;Lnet/darkmeow/darkmeow/ui/component/AbstractComponent;Lkotlin/jvm/functions/Function1;)V", "DarkMeow"})
public final class DarkGuiBaseUtils {
    @NotNull
    public static final DarkGuiBaseUtils INSTANCE = new DarkGuiBaseUtils();

    private DarkGuiBaseUtils() {
    }

    public final <Type extends AbstractComponent> void addComponent(@NotNull IDarkGuiBase $this$addComponent, @NotNull Type component, @NotNull Function1<? super Type, Unit> postExecute) {
        Intrinsics.checkNotNullParameter($this$addComponent, "<this>");
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(postExecute, "postExecute");
        $this$addComponent.addComponent(component);
        postExecute.invoke(component);
    }

    public static /* synthetic */ void addComponent$default(DarkGuiBaseUtils darkGuiBaseUtils, IDarkGuiBase iDarkGuiBase, AbstractComponent abstractComponent, Function1 function1, int n2, Object object) {
        if ((n2 & 2) != 0) {
            function1 = DarkGuiBaseUtils::addComponent$lambda$0;
        }
        darkGuiBaseUtils.addComponent(iDarkGuiBase, abstractComponent, function1);
    }

    private static final Unit addComponent$lambda$0(AbstractComponent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}

