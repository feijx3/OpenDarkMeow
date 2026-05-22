/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.task;

import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ChestDialogStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocol.ProtocolRunnable;

public final class ChestDialogViewTask
extends ProtocolRunnable {
    public ChestDialogViewTask() {
        super(Protocol1_21_6To1_21_5.class);
    }

    @Override
    public void run(UserConnection connection) {
        ChestDialogStorage storage = connection.get(ChestDialogStorage.class);
        if (storage != null) {
            storage.tick(connection);
        }
    }
}

