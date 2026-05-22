/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data.item;

import java.util.List;

public interface ItemHasher {
    public boolean isProcessingClientboundInventoryPacket();

    public void setProcessingClientboundInventoryPacket(boolean var1);

    public void setEnchantments(List<String> var1);
}

