/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  kotlin.Deprecated
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.value;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.event.EventState;
import net.ccbluex.liquidbounce.event.events.client.SetModuleValueEvent;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.value.elements.Element;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020*H\u0007J\u0006\u0010+\u001a\u00020,J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00020\u0007J\r\u00100\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0014J\u0006\u00101\u001a\u00020,J\u001d\u00102\u001a\u00020,2\u0006\u00103\u001a\u00028\u00002\b\b\u0002\u00104\u001a\u00020\u0007\u00a2\u0006\u0002\u00105J\u0015\u00106\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00107J\n\u00108\u001a\u0004\u0018\u000109H&J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u000209H&J\u001d\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00028\u00002\u0006\u00103\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020,2\u0006\u0010=\u001a\u00028\u00002\u0006\u00103\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010>J\b\u0010@\u001a\u00020AH\u0016J\u0013\u0010B\u001a\u00020\u00072\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J$\u0010\u0013\u001a\u00028\u00002\b\u0010D\u001a\u0004\u0018\u00010\u00022\n\u0010E\u001a\u0006\u0012\u0002\b\u00030FH\u0086\u0002\u00a2\u0006\u0002\u0010GJ,\u0010\u0015\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u00022\n\u0010E\u001a\u0006\u0012\u0002\b\u00030F2\u0006\u0010\u0005\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010HR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00028\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u0019R\u0013\u0010.\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b/\u0010\u0014\u00a8\u0006I"}, d2={"Lnet/ccbluex/liquidbounce/value/Value;", "T", "", "name", "", "value", "noReadSave", "", "superValue", "superValueMeta", "displayableFunc", "", "Lkotlin/Function0;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;ZLnet/ccbluex/liquidbounce/value/Value;Ljava/lang/Object;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getNoReadSave", "()Z", "setNoReadSave", "(Z)V", "getSuperValue", "()Lnet/ccbluex/liquidbounce/value/Value;", "setSuperValue", "(Lnet/ccbluex/liquidbounce/value/Value;)V", "getSuperValueMeta", "setSuperValueMeta", "getDisplayableFunc", "()Ljava/util/List;", "clickGuiElement", "Lnet/ccbluex/liquidbounce/value/elements/Element;", "getClickGuiElement", "displayable", "func", "check", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "displayableClear", "", "getDisplayable", "default", "getDefault", "get", "setDefault", "set", "newValue", "noEventCall", "(Ljava/lang/Object;Z)V", "changeValue", "(Ljava/lang/Object;)Z", "toJson", "Lcom/google/gson/JsonElement;", "fromJson", "element", "onChange", "oldValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "onChanged", "hashCode", "", "equals", "other", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Value.kt\nnet/ccbluex/liquidbounce/value/Value\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,199:1\n1740#2,3:200\n12434#3,2:203\n*S KotlinDebug\n*F\n+ 1 Value.kt\nnet/ccbluex/liquidbounce/value/Value\n*L\n87#1:200,3\n88#1:203,2\n*E\n"})
public abstract class Value<T> {
    @NotNull
    private String name;
    private T value;
    private boolean noReadSave;
    @Nullable
    private Value<?> superValue;
    @Nullable
    private Object superValueMeta;
    @NotNull
    private final List<Function0<Boolean>> displayableFunc;
    private final T default;

    public Value(@NotNull String name, T value, boolean noReadSave, @Nullable Value<?> superValue, @Nullable Object superValueMeta, @NotNull List<Function0<Boolean>> displayableFunc) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayableFunc, "displayableFunc");
        this.name = name;
        this.value = value;
        this.noReadSave = noReadSave;
        this.superValue = superValue;
        this.superValueMeta = superValueMeta;
        this.displayableFunc = displayableFunc;
        this.default = this.value;
    }

    public /* synthetic */ Value(String string, Object object, boolean bl2, Value value, Object object2, List list, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            value = null;
        }
        if ((n2 & 0x10) != 0) {
            object2 = null;
        }
        if ((n2 & 0x20) != 0) {
            list = new ArrayList();
        }
        this(string, object, bl2, value, object2, list);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<set-?>");
        this.name = string;
    }

    public final T getValue() {
        return this.value;
    }

    public final void setValue(T t2) {
        this.value = t2;
    }

    public final boolean getNoReadSave() {
        return this.noReadSave;
    }

    public final void setNoReadSave(boolean bl2) {
        this.noReadSave = bl2;
    }

    @Nullable
    public final Value<?> getSuperValue() {
        return this.superValue;
    }

    public final void setSuperValue(@Nullable Value<?> value) {
        this.superValue = value;
    }

    @Nullable
    public final Object getSuperValueMeta() {
        return this.superValueMeta;
    }

    public final void setSuperValueMeta(@Nullable Object object) {
        this.superValueMeta = object;
    }

    @NotNull
    public final List<Function0<Boolean>> getDisplayableFunc() {
        return this.displayableFunc;
    }

    @NotNull
    public abstract List<Element> getClickGuiElement();

    @NotNull
    public final Value<T> displayable(@NotNull Function0<Boolean> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        this.displayableFunc.add(func);
        return this;
    }

    @Deprecated(message="\u4f7f\u7528 SuperValue")
    @NotNull
    public final Value<T> displayable(@NotNull BoolValue check) {
        Intrinsics.checkNotNullParameter(check, "check");
        this.displayableFunc.add(() -> Value.displayable$lambda$0(check));
        return this;
    }

    public final void displayableClear() {
        this.displayableFunc.clear();
    }

    /*
     * WARNING - void declaration
     */
    public boolean getDisplayable() {
        boolean bl2;
        block13: {
            boolean bl3;
            boolean bl4;
            Boolean[] booleanArray;
            block12: {
                void $this$all$iv;
                Boolean[] booleanArray2;
                int n2;
                boolean bl5;
                booleanArray = new Boolean[3];
                Value<?> value = this.superValue;
                booleanArray[0] = value != null ? value.getDisplayable() : true;
                Boolean[] booleanArray3 = booleanArray;
                int n3 = 1;
                Value<?> base = this.superValue;
                if (base instanceof BoolValue) {
                    bl5 = ((BoolValue)base).getState();
                } else if (base instanceof ListValue) {
                    Iterator iterator2 = this.superValueMeta;
                    String string = iterator2 instanceof String ? (String)((Object)iterator2) : null;
                    if (string != null) {
                        boolean bl6;
                        String string2 = string;
                        n2 = n3;
                        booleanArray2 = booleanArray3;
                        boolean bl7 = false;
                        Value<?> value2 = this.superValue;
                        Object obj = value2 != null ? value2.get() : null;
                        String string3 = obj instanceof String ? (String)obj : null;
                        if (string3 == null) {
                            bl6 = false;
                        } else {
                            void meta;
                            String currentValue = string3;
                            bl6 = StringsKt.startsWith$default((String)meta, "!", false, 2, null) ? !StringsKt.equals(StringsKt.removePrefix((String)meta, (CharSequence)"!"), currentValue, true) : StringsKt.equals((String)meta, currentValue, true);
                        }
                        bl4 = bl6;
                        booleanArray3 = booleanArray2;
                        n3 = n2;
                        bl5 = bl4;
                    } else {
                        bl5 = false;
                    }
                } else {
                    bl5 = true;
                }
                booleanArray3[n3] = bl5;
                base = this.displayableFunc;
                n2 = 2;
                booleanArray2 = booleanArray;
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl3 = true;
                } else {
                    for (Object t2 : $this$all$iv) {
                        Function0 it = (Function0)t2;
                        boolean bl8 = false;
                        if (((Boolean)it.invoke()).booleanValue()) continue;
                        bl3 = false;
                        break block12;
                    }
                    bl3 = true;
                }
            }
            bl4 = bl3;
            booleanArray2[n2] = bl4;
            Boolean[] $this$all$iv = booleanArray;
            boolean $i$f$all = false;
            for (Boolean bl7 : $this$all$iv) {
                boolean it = bl7;
                boolean bl9 = false;
                if (it) continue;
                bl2 = false;
                break block13;
            }
            bl2 = true;
        }
        return bl2;
    }

    @NotNull
    public final Value<T> setNoReadSave(boolean value) {
        this.noReadSave = value;
        return this;
    }

    public final T getDefault() {
        return this.default;
    }

    public T get() {
        return this.value;
    }

    public final void setDefault() {
        this.value = this.default;
    }

    public final void set(T newValue, boolean noEventCall) {
        if (Intrinsics.areEqual(newValue, this.value)) {
            return;
        }
        T oldValue = this.get();
        try {
            SetModuleValueEvent<T> event;
            if (!noEventCall) {
                event = new SetModuleValueEvent<T>(this, oldValue, newValue, EventState.PRE);
                EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), event, null, 2, null);
                if (event.isCancelled()) {
                    return;
                }
            }
            this.onChange(oldValue, newValue);
            this.changeValue(newValue);
            this.onChanged(oldValue, newValue);
            if (!noEventCall) {
                event = new SetModuleValueEvent<T>(this, oldValue, newValue, EventState.POST);
                EventManager.callEvent$default(DarkMeow.INSTANCE.getEventManager(), event, null, 2, null);
            }
            DarkMeow.INSTANCE.getConfigManager().smartSave();
        }
        catch (Exception e2) {
            ClientUtils.logger.error("[ValueSystem (" + this.name + ")]: " + e2.getClass().getName() + " (" + e2.getMessage() + ") [" + oldValue + " >> " + newValue + ']');
        }
    }

    public static /* synthetic */ void set$default(Value value, Object object, boolean bl2, int n2, Object object2) {
        if (object2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: set");
        }
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        value.set(object, bl2);
    }

    public boolean changeValue(T value) {
        this.value = value;
        return true;
    }

    @Nullable
    public abstract JsonElement toJson();

    public abstract void fromJson(@NotNull JsonElement var1);

    protected void onChange(T oldValue, T newValue) {
    }

    protected void onChanged(T oldValue, T newValue) {
    }

    public int hashCode() {
        int result = this.name.hashCode();
        T t2 = this.value;
        result = 31 * result + (t2 != null ? t2.hashCode() : 0);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof Value) {
            return Intrinsics.areEqual(this.name, ((Value)other).name) && Intrinsics.areEqual(this.value, ((Value)other).value) && Intrinsics.areEqual(this.displayableFunc, ((Value)other).displayableFunc);
        }
        if (Intrinsics.areEqual(this.value, other)) {
            return true;
        }
        if (this.value instanceof String && other instanceof String) {
            boolean bl2;
            try {
                T t2 = this.value;
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.String");
                bl2 = StringsKt.equals((String)t2, (String)other, true);
            }
            catch (Throwable throwable) {
                bl2 = false;
            }
            return bl2;
        }
        T t3 = this.value;
        return t3 != null ? t3.equals(other) : false;
    }

    public final T getValue(@Nullable Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.value;
    }

    public final void setValue(@Nullable Object thisRef, @NotNull KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Value.set$default(this, value, false, 2, null);
    }

    private static final boolean displayable$lambda$0(BoolValue $check) {
        return (Boolean)$check.get();
    }
}

