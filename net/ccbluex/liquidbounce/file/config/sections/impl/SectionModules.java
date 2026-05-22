/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.config.sections.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleManager;
import net.ccbluex.liquidbounce.features.module.base.ModuleBaseConfig;
import net.ccbluex.liquidbounce.file.config.sections.ConfigSection;
import net.ccbluex.liquidbounce.value.Value;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2={"Lnet/ccbluex/liquidbounce/file/config/sections/impl/SectionModules;", "Lnet/ccbluex/liquidbounce/file/config/sections/ConfigSection;", "<init>", "()V", "load", "", "json", "Lcom/google/gson/JsonElement;", "save", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSectionModules.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SectionModules.kt\nnet/ccbluex/liquidbounce/file/config/sections/impl/SectionModules\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1869#2:106\n1869#2,2:107\n1870#2:109\n774#2:111\n865#2,2:112\n774#2:114\n865#2,2:115\n1869#2,2:117\n1869#2:119\n1869#2,2:120\n1870#2:122\n1#3:110\n*S KotlinDebug\n*F\n+ 1 SectionModules.kt\nnet/ccbluex/liquidbounce/file/config/sections/impl/SectionModules\n*L\n15#1:106\n18#1:107,2\n15#1:109\n56#1:111\n56#1:112,2\n57#1:114\n57#1:115,2\n58#1:117,2\n76#1:119\n93#1:120,2\n76#1:122\n*E\n"})
public final class SectionModules
extends ConfigSection {
    public SectionModules() {
        super("modules");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean load(@NotNull JsonElement json) {
        boolean bl2;
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonObject jsonObject2 = jsonObject = json instanceof JsonObject ? (JsonObject)json : null;
        if (jsonObject != null) {
            JsonObject jsonObject3;
            JsonObject config = jsonObject3 = jsonObject;
            boolean bl3 = false;
            Iterable $this$forEach$iv = DarkMeow.INSTANCE.getModuleManager().getModules();
            boolean $i$f$forEach = false;
            Iterator iterator2 = $this$forEach$iv.iterator();
            while (iterator2.hasNext()) {
                Object element$iv = iterator2.next();
                Module it = (Module)element$iv;
                boolean bl4 = false;
                it.setState(false);
                it.getBaseConfig().reset();
                Iterable $this$forEach$iv2 = it.getValues();
                boolean $i$f$forEach2 = false;
                for (Object element$iv2 : $this$forEach$iv2) {
                    Value value = (Value)element$iv2;
                    boolean bl5 = false;
                    value.setDefault();
                }
            }
            for (Map.Entry entrySet : config.entrySet()) {
                JsonObject jsonObject4;
                JsonObject jsonObject5;
                Object $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245;
                Object bl5;
                Module module;
                Object object;
                JsonObject data;
                Object object2;
                ModuleManager moduleManager = DarkMeow.INSTANCE.getModuleManager();
                Object k2 = entrySet.getKey();
                Intrinsics.checkNotNullExpressionValue(k2, "<get-key>(...)");
                if (moduleManager.getModule((String)k2) == null) continue;
                JsonObject it = object2 = (data = ((JsonElement)entrySet.getValue()).getAsJsonObject());
                boolean bl6 = false;
                Object object3 = object = it.has("key") ? object2 : null;
                if (object != null && (object2 = object.get("key")) != null) {
                    JsonObject it2 = bl6 = object2;
                    boolean bl7 = false;
                    Object object4 = it = it2.isJsonObject() ? bl6 : null;
                    if (it != null && (bl6 = it.getAsJsonObject()) != null) {
                        JsonObject $this$load_u24lambda_u2420_u24lambda_u246 = it2 = bl6;
                        boolean bl8 = false;
                        module.getBaseConfig().setKeyBindId($this$load_u24lambda_u2420_u24lambda_u246.get("id").getAsInt());
                        bl5 = $this$load_u24lambda_u2420_u24lambda_u246;
                        ModuleBaseConfig moduleBaseConfig = module.getBaseConfig();
                        try {
                            $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245 = bl5;
                            boolean bl9 = false;
                            String it3 = $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245.get("type").getAsString();
                            boolean bl10 = false;
                            Intrinsics.checkNotNull(it3);
                            String string = it3.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(string, "toUpperCase(...)");
                            $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245 = Result.constructor-impl((Object)ModuleBaseConfig.KeyBindType.valueOf(string));
                        }
                        catch (Throwable bl9) {
                            $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245 = Result.constructor-impl(ResultKt.createFailure(bl9));
                        }
                        bl5 = $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245;
                        $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245 = ModuleBaseConfig.KeyBindType.TOGGLE;
                        moduleBaseConfig.setKeyBindType((ModuleBaseConfig.KeyBindType)((Object)(Result.isFailure-impl(bl5) ? $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245 : bl5)));
                    }
                }
                it = object2 = data;
                boolean bl11 = false;
                Object object5 = object = it.has("hide") ? object2 : null;
                if (object != null && (object2 = object.get("hide")) != null) {
                    JsonObject it4 = it = object2;
                    boolean bl12 = false;
                    module.getBaseConfig().setHide(it4.getAsBoolean());
                }
                it = object2 = data;
                boolean bl13 = false;
                Object object6 = object = it.has("notify_toggle") ? object2 : null;
                if (object != null && (object2 = object.get("notify_toggle")) != null) {
                    JsonObject it5 = it = object2;
                    boolean bl14 = false;
                    module.getBaseConfig().setNotifyToggle(it5.getAsBoolean());
                }
                it = object2 = data;
                boolean bl15 = false;
                Object object7 = object = it.has("values") ? object2 : null;
                if (object != null && (object2 = object.get("values")) != null) {
                    JsonObject it6 = bl15 = object2;
                    boolean bl16 = false;
                    Object object8 = it = it6.isJsonObject() ? bl15 : null;
                    if (it != null && (bl15 = it.getAsJsonObject()) != null) {
                        void $this$forEach$iv3;
                        Value it7;
                        Iterable $this$filterTo$iv$iv;
                        Iterable $this$filter$iv;
                        JsonObject values = it6 = bl15;
                        boolean bl17 = false;
                        bl5 = module.getValues();
                        boolean $i$f$filter = false;
                        $this$load_u24lambda_u2420_u24lambda_u246_u24lambda_u245 = $this$filter$iv;
                        Collection destination$iv$iv = new ArrayList();
                        boolean $i$f$filterTo = false;
                        for (Object element$iv$iv : $this$filterTo$iv$iv) {
                            it7 = (Value)element$iv$iv;
                            boolean bl18 = false;
                            if (!(!it7.getNoReadSave())) continue;
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = (List)destination$iv$iv;
                        $i$f$filter = false;
                        $this$filterTo$iv$iv = $this$filter$iv;
                        destination$iv$iv = new ArrayList();
                        $i$f$filterTo = false;
                        for (Object element$iv$iv : $this$filterTo$iv$iv) {
                            it7 = (Value)element$iv$iv;
                            boolean bl19 = false;
                            if (!values.has(it7.getName())) continue;
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = (List)destination$iv$iv;
                        boolean $i$f$forEach3 = false;
                        for (Object element$iv : $this$forEach$iv3) {
                            Value it8 = (Value)element$iv;
                            boolean bl20 = false;
                            JsonElement jsonElement = values.get(it8.getName());
                            Intrinsics.checkNotNullExpressionValue(jsonElement, "get(...)");
                            it8.fromJson(jsonElement);
                        }
                    }
                }
                if (data == null) continue;
                it = object2 = data;
                boolean bl21 = false;
                object = !module.getBaseState().getLockToDefaultState() ? object2 : null;
                if (object == null) continue;
                JsonObject it9 = jsonObject5 = object;
                boolean bl22 = false;
                object2 = it9.has("state") ? jsonObject5 : null;
                if (object2 == null || (jsonObject5 = object2.get("state")) == null) continue;
                JsonObject it10 = jsonObject4 = jsonObject5;
                boolean bl23 = false;
                module.setState(it10.getAsBoolean());
            }
            JsonObject it = jsonObject3;
            boolean bl24 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public JsonElement save() {
        JsonObject json = new JsonObject();
        Iterable $this$forEach$iv = DarkMeow.INSTANCE.getModuleManager().getModules();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            void $this$save_u24lambda_u2424_u24lambda_u2422;
            JsonObject jsonObject;
            Module it = (Module)element$iv;
            boolean bl2 = false;
            JsonObject moduleJson = new JsonObject();
            if (!it.getBaseState().getLockToDefaultState()) {
                moduleJson.addProperty("state", Boolean.valueOf(it.getState()));
            }
            JsonObject jsonObject2 = jsonObject = new JsonObject();
            String string = "key";
            JsonObject jsonObject3 = moduleJson;
            boolean bl3 = false;
            $this$save_u24lambda_u2424_u24lambda_u2422.addProperty("id", (Number)it.getBaseConfig().getKeyBindId());
            String string2 = it.getBaseConfig().getKeyBindType().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string2, "toLowerCase(...)");
            $this$save_u24lambda_u2424_u24lambda_u2422.addProperty("type", string2);
            Unit unit = Unit.INSTANCE;
            jsonObject3.add(string, (JsonElement)jsonObject);
            moduleJson.addProperty("hide", Boolean.valueOf(it.getBaseConfig().getHide()));
            moduleJson.addProperty("notify_toggle", Boolean.valueOf(it.getBaseConfig().getNotifyToggle()));
            JsonObject valuesJson = new JsonObject();
            Iterable $this$forEach$iv2 = it.getValues();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                Value value = (Value)element$iv2;
                boolean bl4 = false;
                if (value.getNoReadSave()) continue;
                valuesJson.add(value.getName(), value.toJson());
            }
            moduleJson.add("values", (JsonElement)valuesJson);
            json.add(it.getName(), (JsonElement)moduleJson);
        }
        return (JsonElement)json;
    }
}

