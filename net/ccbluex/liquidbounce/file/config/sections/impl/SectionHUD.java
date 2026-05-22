/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.config.sections.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.file.config.sections.ConfigSection;
import net.ccbluex.liquidbounce.ui.client.hud.HUDManager;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/file/config/sections/impl/SectionHUD;", "Lnet/ccbluex/liquidbounce/file/config/sections/ConfigSection;", "<init>", "()V", "load", "", "json", "Lcom/google/gson/JsonElement;", "save", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSectionHUD.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SectionHUD.kt\nnet/ccbluex/liquidbounce/file/config/sections/impl/SectionHUD\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1#2:87\n1#2:89\n2756#3:88\n295#3,2:90\n1869#3,2:92\n1869#3:94\n1869#3,2:95\n1870#3:97\n*S KotlinDebug\n*F\n+ 1 SectionHUD.kt\nnet/ccbluex/liquidbounce/file/config/sections/impl/SectionHUD\n*L\n18#1:89\n18#1:88\n22#1:90,2\n44#1:92,2\n62#1:94\n76#1:95,2\n62#1:97\n*E\n"})
public final class SectionHUD
extends ConfigSection {
    public SectionHUD() {
        super("hud");
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean load(@NotNull JsonElement json) {
        JsonArray jsonArray;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonArray jsonArray2 = jsonArray = json instanceof JsonArray ? (JsonArray)json : null;
        if (jsonArray != null) {
            JsonArray jsonArray3;
            JsonArray jsonArray4;
            JsonArray it = jsonArray4 = jsonArray;
            boolean bl2 = false;
            DarkMeow.INSTANCE.getHudManager().getElements().clear();
            JsonArray jsonArray5 = jsonArray3 = jsonArray4;
            boolean bl3 = false;
            Object object = jsonArray4 = jsonArray5.size() != 0 ? jsonArray3 : null;
            if (jsonArray4 != null) {
                Iterable iterable;
                Iterable iterable2 = (Iterable)jsonArray4;
                boolean $i$f$onEach = false;
                Iterable $this$onEach_u24lambda_u2418$iv = iterable = iterable2;
                boolean bl4 = false;
                for (Object element$iv : $this$onEach_u24lambda_u2418$iv) {
                    JsonElement configElement = (JsonElement)element$iv;
                    boolean bl5 = false;
                    try {
                        Enum enum_;
                        JsonObject jsonObject;
                        Constructor constructor;
                        Map.Entry entry;
                        Object v4;
                        Object object2;
                        Object object3;
                        Object object4;
                        JsonObject configElementBase;
                        block11: {
                            void $this$firstOrNull$iv;
                            JsonObject jsonObject2;
                            configElementBase = jsonObject2 = configElement.getAsJsonObject();
                            boolean bl6 = false;
                            Set<Map.Entry<String, Class<? extends Element>>> set = DarkMeow.INSTANCE.getHudManager().getElementsBase().entrySet();
                            Intrinsics.checkNotNullExpressionValue(set, "<get-entries>(...)");
                            object4 = set;
                            boolean $i$f$firstOrNull = false;
                            object3 = $this$firstOrNull$iv.iterator();
                            while (object3.hasNext()) {
                                Object element$iv2 = object3.next();
                                object2 = (Map.Entry)element$iv2;
                                boolean bl7 = false;
                                Intrinsics.checkNotNull(object2);
                                Object k2 = object2.getKey();
                                Intrinsics.checkNotNullExpressionValue(k2, "component1(...)");
                                String name = (String)k2;
                                if (!Intrinsics.areEqual(configElementBase.get("type").getAsString(), name)) continue;
                                v4 = element$iv2;
                                break block11;
                            }
                            v4 = null;
                        }
                        if ((entry = (Map.Entry)v4) == null || (object4 = (Class)entry.getValue()) == null || (constructor = ((Class)object4).getDeclaredConstructor(new Class[0])) == null || (object3 = (Element)constructor.newInstance(new Object[0])) == null) continue;
                        Object $this$load_u24lambda_u2411_u24lambda_u2410_u24lambda_u248 = object2 = object3;
                        boolean bl8 = false;
                        ((Element)$this$load_u24lambda_u2411_u24lambda_u2410_u24lambda_u248).setX(configElementBase.get("x").getAsDouble());
                        ((Element)$this$load_u24lambda_u2411_u24lambda_u2410_u24lambda_u248).setY(configElementBase.get("y").getAsDouble());
                        ((Element)$this$load_u24lambda_u2411_u24lambda_u2410_u24lambda_u248).setScale(configElementBase.get("scale").getAsFloat());
                        JsonObject configElementFacing = jsonObject = configElementBase.get("facing").getAsJsonObject();
                        boolean bl9 = false;
                        String string = configElementFacing.get("horizontal").getAsString();
                        Intrinsics.checkNotNullExpressionValue(string, "getAsString(...)");
                        ElementSide.Horizontal horizontal = ElementSide.Horizontal.Companion.getByName(string);
                        if (horizontal != null) {
                            enum_ = horizontal;
                            ElementSide.Horizontal horizontal2 = enum_;
                            boolean bl10 = false;
                            ((Element)$this$load_u24lambda_u2411_u24lambda_u2410_u24lambda_u248).getSide().setHorizontal(horizontal2);
                        }
                        String string2 = configElementFacing.get("vertical").getAsString();
                        Intrinsics.checkNotNullExpressionValue(string2, "getAsString(...)");
                        if (ElementSide.Vertical.Companion.getByName(string2) != null) {
                            Enum vertical = enum_;
                            boolean bl11 = false;
                            ((Element)$this$load_u24lambda_u2411_u24lambda_u2410_u24lambda_u248).getSide().setVertical((ElementSide.Vertical)vertical);
                        }
                        JsonObject configElementValue = jsonObject = configElementBase.get("values").getAsJsonObject();
                        boolean bl12 = false;
                        Iterable $this$forEach$iv = ((Element)$this$load_u24lambda_u2411_u24lambda_u2410_u24lambda_u248).getValues();
                        boolean $i$f$forEach = false;
                        for (Object element$iv3 : $this$forEach$iv) {
                            Value value = (Value)element$iv3;
                            boolean bl13 = false;
                            try {
                                if (value.getNoReadSave()) continue;
                                JsonElement jsonElement = configElementValue.get(value.getName());
                                Intrinsics.checkNotNullExpressionValue(jsonElement, "get(...)");
                                value.fromJson(jsonElement);
                            }
                            catch (Throwable throwable) {
                            }
                        }
                        Object element = object2;
                        boolean bl14 = false;
                        DarkMeow.INSTANCE.getHudManager().getElements().add((Element)element);
                    }
                    catch (Throwable throwable) {
                    }
                }
                JsonArray it2 = (JsonArray)iterable;
                return true;
            }
        }
        HUDManager it = DarkMeow.INSTANCE.getHudManager().createDefault();
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public JsonElement save() {
        JsonArray jsonArray;
        JsonArray config = jsonArray = new JsonArray();
        boolean bl2 = false;
        Iterable $this$forEach$iv = DarkMeow.INSTANCE.getHudManager().getElements();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            JsonObject $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414;
            JsonObject jsonObject;
            JsonObject jsonObject2;
            Element element = (Element)element$iv;
            boolean bl3 = false;
            JsonObject $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417 = jsonObject2 = new JsonObject();
            boolean bl4 = false;
            $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417.addProperty("type", element.getBaseName());
            $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417.addProperty("x", (Number)element.getX());
            $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417.addProperty("y", (Number)element.getY());
            $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417.addProperty("scale", (Number)Float.valueOf(element.getScale()));
            JsonObject jsonObject3 = jsonObject = new JsonObject();
            String string = "facing";
            JsonObject jsonObject4 = $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417;
            boolean bl5 = false;
            $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414.addProperty("horizontal", element.getSide().getHorizontal().getSideName());
            $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414.addProperty("vertical", element.getSide().getVertical().getSideName());
            Unit unit = Unit.INSTANCE;
            jsonObject4.add(string, (JsonElement)jsonObject);
            $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414 = jsonObject = new JsonObject();
            string = "values";
            jsonObject4 = $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417;
            boolean bl6 = false;
            Iterable $this$forEach$iv2 = element.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                void $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416;
                Value value = (Value)element$iv2;
                boolean bl7 = false;
                if (value.getNoReadSave()) continue;
                $this$save_u24lambda_u2420_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416.add(value.getName(), value.toJson());
            }
            unit = Unit.INSTANCE;
            jsonObject4.add(string, (JsonElement)jsonObject);
            JsonObject configElement = jsonObject2;
            boolean bl8 = false;
            config.add((JsonElement)configElement);
        }
        return (JsonElement)jsonArray;
    }
}

