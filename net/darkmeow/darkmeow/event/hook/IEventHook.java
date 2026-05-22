/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.event.hook;

import kotlin.Metadata;
import kotlin.reflect.KClass;
import net.ccbluex.liquidbounce.event.Event;
import net.darkmeow.darkmeow.event.ListenableOwner;
import net.darkmeow.darkmeow.event.listenable.ListenerBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0016\u00c0\u0006\u0001"}, d2={"Lnet/darkmeow/darkmeow/event/hook/IEventHook;", "Type", "Lnet/ccbluex/liquidbounce/event/Event;", "", "priority", "", "getPriority", "()I", "type", "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "owner", "Lnet/darkmeow/darkmeow/event/ListenableOwner;", "getOwner", "()Lnet/darkmeow/darkmeow/event/ListenableOwner;", "invoke", "", "base", "Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;", "event", "(Lnet/darkmeow/darkmeow/event/listenable/ListenerBase;Lnet/ccbluex/liquidbounce/event/Event;)V", "DarkMeow"})
public interface IEventHook<Type extends Event> {
    default public int getPriority() {
        return 0;
    }

    @NotNull
    public KClass<? extends Type> getType();

    @NotNull
    public ListenableOwner getOwner();

    public void invoke(@NotNull ListenerBase var1, @NotNull Type var2);
}

