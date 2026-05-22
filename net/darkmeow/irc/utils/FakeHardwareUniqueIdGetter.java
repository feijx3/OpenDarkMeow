/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.UUID;

public final class FakeHardwareUniqueIdGetter {
    public static final File FILE_ID = new File(System.getProperty("user.home"), ".hardware_unique_id");

    private FakeHardwareUniqueIdGetter() {
    }

    public static String get() {
        try {
            if (FILE_ID.exists()) {
                return new String(Files.readAllBytes(FILE_ID.toPath())).trim();
            }
            String newId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            Files.write(FILE_ID.toPath(), newId.getBytes(), new OpenOption[0]);
            return newId;
        }
        catch (Exception ignored) {
            return "error";
        }
    }
}

