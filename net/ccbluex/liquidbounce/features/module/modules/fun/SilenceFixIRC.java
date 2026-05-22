/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.event.EventManager;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFConfig;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.SFExtend;
import net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.ccbluex.liquidbounce.value.impl.ListValue;
import net.ccbluex.liquidbounce.value.impl.TextValue;
import net.darkmeow.irc.utils.FakeHardwareUniqueIdGetter;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixIRC;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "<init>", "()V", "usernameValue", "Lnet/ccbluex/liquidbounce/value/impl/TextValue;", "passwordValue", "hardWareIdModeValue", "Lnet/ccbluex/liquidbounce/value/impl/ListValue;", "hardWareIdCustomInputValue", "extends", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFExtend;", "getExtends", "()Ljava/util/Map;", "client", "Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "getClient", "()Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;", "setClient", "(Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;)V", "onEnable", "", "onDisable", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSilenceFixIRC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SilenceFixIRC.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixIRC\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1#2:100\n1563#3:101\n1634#3,3:102\n1056#3:105\n1869#3:106\n1869#3,2:107\n1870#3:109\n774#3:110\n865#3,2:111\n1869#3,2:113\n774#3:115\n865#3,2:116\n1869#3,2:118\n774#3:120\n865#3,2:121\n1869#3,2:123\n*S KotlinDebug\n*F\n+ 1 SilenceFixIRC.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/SilenceFixIRC\n*L\n42#1:101\n42#1:102,3\n43#1:105\n44#1:106\n48#1:107,2\n44#1:109\n68#1:110\n68#1:111,2\n69#1:113,2\n93#1:115\n93#1:116,2\n94#1:118,2\n83#1:120\n83#1:121,2\n84#1:123,2\n*E\n"})
public final class SilenceFixIRC
extends Module {
    @JvmField
    @NotNull
    public final TextValue usernameValue = new TextValue("Username", "111");
    @JvmField
    @NotNull
    public final TextValue passwordValue = new TextValue("Password", "111");
    @JvmField
    @NotNull
    public final ListValue hardWareIdModeValue;
    @JvmField
    @NotNull
    public final TextValue hardWareIdCustomInputValue;
    @NotNull
    private final Map<String, SFExtend> extends;
    public SFConnection client;

    /*
     * WARNING - void declaration
     */
    public SilenceFixIRC() {
        super("SilenceFixIRC", ModuleCategory.FUN, null, null, 12, null);
        void $this$hardWareIdCustomInputValue_u24lambda_u241;
        Object $this$hardWareIdCustomInputValue_u24lambda_u240;
        Object object = new String[]{"System", "Empty", "Custom"};
        this.hardWareIdModeValue = new ListValue("HardWareIdMode", (String[])object, "System");
        Object object2 = object = new TextValue("HardWareIdCustomInput", "_empty_");
        Object object3 = this;
        boolean bl2 = false;
        $this$hardWareIdCustomInputValue_u24lambda_u240.setSuperValue(this.hardWareIdModeValue);
        $this$hardWareIdCustomInputValue_u24lambda_u240 = object;
        boolean bl3 = false;
        $this$hardWareIdCustomInputValue_u24lambda_u241.setSuperValueMeta("Custom");
        ((SilenceFixIRC)object3).hardWareIdCustomInputValue = object;
        this.extends = new LinkedHashMap();
        this.getValues().add(this.usernameValue);
        this.getValues().add(this.passwordValue);
        Object it = object2 = ClassUtils.INSTANCE.resolvePackage(this.getClass().getPackage().getName() + ".silence_fix_irc.extend", SFExtend.class);
        boolean bl4 = false;
        Object object4 = object = !((Collection)it).isEmpty() ? object2 : null;
        if (object != null) {
            Iterable $this$sortedBy$iv;
            BoolValue it2;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = (Iterable)object;
            boolean $i$f$map22 = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Class clazz = (Class)item$iv$iv;
                object3 = destination$iv$iv;
                boolean bl5 = false;
                object3.add((SFExtend)((Class)((Object)it2)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            Iterable $i$f$map22 = (List)destination$iv$iv;
            boolean $i$f$sortedBy = false;
            List list = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator(){

                public final int compare(T a2, T b2) {
                    SFExtend it = (SFExtend)a2;
                    boolean bl2 = false;
                    Comparable comparable = (Comparable)((Object)it.getName());
                    it = (SFExtend)b2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)it.getName()));
                }
            });
            if (list != null) {
                void $this$forEach$iv;
                $this$sortedBy$iv = list;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    SFExtend extend = (SFExtend)element$iv;
                    boolean bl6 = false;
                    BoolValue bl5 = it2 = new BoolValue(extend.getName(), extend.getDefaultState() || extend.getForce());
                    SFExtend sFExtend = extend;
                    boolean bl7 = false;
                    if (!extend.getForce()) {
                        void it3;
                        this.getValues().add((Value<?>)it3);
                    }
                    sFExtend.setLinkedStatValue(it2);
                    extend.setInstance(this);
                    Iterable $this$forEach$iv2 = extend.getValues();
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Value value = (Value)element$iv2;
                        boolean bl8 = false;
                        value.setName(extend.getName() + value.getName());
                        if (value.getSuperValue() == null) {
                            value.setSuperValue(extend.getLinkedStatValue());
                        }
                        this.getValues().add(value);
                    }
                    this.extends.put(extend.getName(), extend);
                    EventManager eventManager = DarkMeow.INSTANCE.getEventManager();
                    Intrinsics.checkNotNull(extend);
                    EventManager.registerListener$default(eventManager, extend, false, false, 6, null);
                }
            }
        }
    }

    @NotNull
    public final Map<String, SFExtend> getExtends() {
        return this.extends;
    }

    @NotNull
    public final SFConnection getClient() {
        SFConnection sFConnection = this.client;
        if (sFConnection != null) {
            return sFConnection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("client");
        return null;
    }

    public final void setClient(@NotNull SFConnection sFConnection) {
        Intrinsics.checkNotNullParameter(sFConnection, "<set-?>");
        this.client = sFConnection;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void onEnable() {
        block9: {
            block8: {
                $this$filter$iv = this.extends.values();
                $i$f$filter = false;
                var3_4 = $this$filter$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$filterTo = false;
                for (T element$iv$iv : $this$filterTo$iv$iv) {
                    it = (SFExtend)element$iv$iv;
                    $i$a$-filter-SilenceFixIRC$onEnable$1 = false;
                    if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$forEach$iv = (List)destination$iv$iv;
                $i$f$forEach = false;
                for (E element$iv : $this$forEach$iv) {
                    it = (SFExtend)element$iv;
                    $i$a$-forEach-SilenceFixIRC$onEnable$2 = false;
                    it.onEnable();
                }
                v0 = (String)this.usernameValue.get();
                v1 = (String)this.passwordValue.get();
                var2_3 = (String)this.hardWareIdModeValue.get();
                switch (var2_3.hashCode()) {
                    case 67081517: {
                        if (var2_3.equals("Empty")) break;
                        ** break;
                    }
                    case 2029746065: {
                        if (!var2_3.equals("Custom")) {
                            ** break;
                        }
                        break block8;
                    }
                    case -1803461041: {
                        if (!var2_3.equals("System")) ** break;
                        v2 = FakeHardwareUniqueIdGetter.get();
                        break block9;
                    }
                }
                v2 = "_empty_";
                break block9;
            }
            v2 = (String)this.hardWareIdCustomInputValue.get();
            break block9;
lbl43:
            // 4 sources

            v2 = "_unknown_";
        }
        var1_1 = v2;
        Intrinsics.checkNotNull(var1_1);
        this.setClient(SFConnection.Companion.create(new SFConfig(v0, v1, var1_1, (Function1<SFConnection, Unit>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onEnable$lambda$12(net.ccbluex.liquidbounce.features.module.modules.fun.SilenceFixIRC net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc.network.SFConnection ), (Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/network/SFConnection;)Lkotlin/Unit;)((SilenceFixIRC)this))));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void onDisable() {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this.extends.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            SFExtend it = (SFExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SFExtend it = (SFExtend)element$iv;
            boolean bl3 = false;
            it.onDisable();
        }
        SFConnection.close$default(this.getClient(), null, 1, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit onEnable$lambda$12(SilenceFixIRC this$0, SFConnection connection) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(connection, "connection");
        Iterable $this$filter$iv = this$0.extends.values();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            SFExtend it = (SFExtend)element$iv$iv;
            boolean bl2 = false;
            if (!((Boolean)it.getLinkedStatValue().get()).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            SFExtend it = (SFExtend)element$iv;
            boolean bl3 = false;
            it.onConnected(connection);
        }
        return Unit.INSTANCE;
    }
}

