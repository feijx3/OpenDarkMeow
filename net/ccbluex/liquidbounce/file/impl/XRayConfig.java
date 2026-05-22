/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonParser
 *  net.minecraft.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.file.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.features.module.modules.render.XRay;
import net.ccbluex.liquidbounce.file.FileConfig;
import net.ccbluex.liquidbounce.file.FileManager;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.minecraft.block.Block;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/file/impl/XRayConfig;", "Lnet/ccbluex/liquidbounce/file/FileConfig;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "loadConfig", "", "config", "", "saveConfig", "DarkMeow"})
public final class XRayConfig
extends FileConfig {
    public XRayConfig(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        super(file);
    }

    @Override
    public void loadConfig(@NotNull String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        XRay xRay = DarkMeow.INSTANCE.getModuleManager().get(XRay.class);
        Intrinsics.checkNotNull(xRay);
        XRay xRay2 = xRay;
        JsonArray jsonArray = new JsonParser().parse(config).getAsJsonArray();
        xRay2.getXrayBlocks().clear();
        Iterator iterator2 = jsonArray.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator2, "iterator(...)");
        Iterator iterator3 = iterator2;
        while (iterator3.hasNext()) {
            JsonElement jsonElement = (JsonElement)iterator3.next();
            try {
                Block block;
                if (Block.func_149684_b((String)jsonElement.getAsString()) == null) continue;
                if (xRay2.getXrayBlocks().contains(block)) {
                    ClientUtils.INSTANCE.logError("[FileManager] Skipped xray block '" + block.getRegistryName() + "' because the block is already added.");
                    continue;
                }
                xRay2.getXrayBlocks().add(block);
            }
            catch (Throwable throwable) {
                ClientUtils.INSTANCE.logError("[FileManager] Failed to add block to xray.", throwable);
            }
        }
    }

    @Override
    @NotNull
    public String saveConfig() {
        XRay xRay = DarkMeow.INSTANCE.getModuleManager().get(XRay.class);
        Intrinsics.checkNotNull(xRay);
        XRay xRay2 = xRay;
        JsonArray jsonArray = new JsonArray();
        for (Block block : xRay2.getXrayBlocks()) {
            jsonArray.add(FileManager.Companion.getPRETTY_GSON().toJsonTree((Object)Block.func_149682_b((Block)block)));
        }
        String string = FileManager.Companion.getPRETTY_GSON().toJson((JsonElement)jsonArray);
        Intrinsics.checkNotNullExpressionValue(string, "toJson(...)");
        return string;
    }
}

