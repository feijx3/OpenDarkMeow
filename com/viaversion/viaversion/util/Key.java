/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 */
package com.viaversion.viaversion.util;

import org.checkerframework.checker.nullness.qual.Nullable;

public final class Key {
    private static final String MINECRAFT_NAMESPACE = "minecraft";
    private static final int MINECRAFT_NAMESPACE_LENGTH = "minecraft".length();
    private final String original;
    private final String namespace;
    private final String path;

    private Key(String original, String namespace, String path) {
        if (!Key.isValidNamespace(namespace)) {
            throw new IllegalArgumentException(Key.jvmdowngrader$concat$$init$$1(namespace));
        }
        if (!Key.isValidPath(path)) {
            throw new IllegalArgumentException(Key.jvmdowngrader$concat$$init$$2(path));
        }
        this.original = original;
        this.namespace = namespace;
        this.path = path;
    }

    public static Key of(String namespace, String path) {
        return new Key(Key.jvmdowngrader$concat$of$1(namespace, path), namespace, path);
    }

    public static Key ofPath(String path) {
        return new Key(path, MINECRAFT_NAMESPACE, path);
    }

    public static Key of(String identifier) {
        int separatorIndex = identifier.indexOf(58);
        if (separatorIndex == -1) {
            return Key.ofPath(identifier);
        }
        String namespace = separatorIndex == 0 ? MINECRAFT_NAMESPACE : identifier.substring(0, separatorIndex);
        String path = identifier.substring(separatorIndex + 1);
        return new Key(identifier, namespace, path);
    }

    public static @Nullable Key tryParse(String identifier) {
        try {
            return Key.of(identifier);
        }
        catch (IllegalArgumentException e2) {
            return null;
        }
    }

    public static String stripNamespace(String identifier) {
        int index = identifier.indexOf(58);
        if (index == -1) {
            return identifier;
        }
        return identifier.substring(index + 1);
    }

    public static String namespace(String identifier) {
        int index = identifier.indexOf(58);
        if (index == -1) {
            return MINECRAFT_NAMESPACE;
        }
        if (index == 0) {
            return MINECRAFT_NAMESPACE;
        }
        return identifier.substring(0, index);
    }

    public static String stripMinecraftNamespace(String identifier) {
        if (identifier.startsWith("minecraft:")) {
            return identifier.substring(MINECRAFT_NAMESPACE_LENGTH + 1);
        }
        if (!identifier.isEmpty() && identifier.charAt(0) == ':') {
            return identifier.substring(1);
        }
        return identifier;
    }

    public static boolean equals(String firstIdentifier, String secondIdentifier) {
        return Key.of(firstIdentifier).equals(Key.of(secondIdentifier));
    }

    public static String namespaced(String identifier) {
        int index = identifier.indexOf(58);
        if (index == -1) {
            return Key.jvmdowngrader$concat$namespaced$1(identifier);
        }
        if (index == 0) {
            return Key.jvmdowngrader$concat$namespaced$2(identifier);
        }
        return identifier;
    }

    public static boolean isValid(String identifier) {
        int separatorIndex = identifier.indexOf(58);
        if (separatorIndex == -1) {
            return Key.isValidPath(identifier);
        }
        if (separatorIndex == 0) {
            return Key.isValidPath(identifier.substring(1));
        }
        String namespace = identifier.substring(0, separatorIndex);
        String path = identifier.substring(separatorIndex + 1);
        return Key.isValidNamespace(namespace) && Key.isValidPath(path);
    }

    public String namespace() {
        return this.namespace;
    }

    public String path() {
        return this.path;
    }

    public String original() {
        return this.original;
    }

    public String minimized() {
        return this.hasMinecraftNamespace() ? this.path : this.toString();
    }

    public boolean hasMinecraftNamespace() {
        return this.namespace.equals(MINECRAFT_NAMESPACE);
    }

    public Key withNamespace(String namespace) {
        return Key.of(namespace, this.path);
    }

    public Key withPath(String path) {
        return Key.of(this.namespace, path);
    }

    public final boolean equals(Object o2) {
        if (this == o2) {
            return true;
        }
        if (!(o2 instanceof Key)) {
            return false;
        }
        Key key = (Key)o2;
        return this.namespace.equals(key.namespace) && this.path.equals(key.path);
    }

    public final boolean equals(String identifier) {
        return this.equals(Key.of(identifier));
    }

    public int hashCode() {
        int result = this.namespace.hashCode();
        result = 31 * result + this.path.hashCode();
        return result;
    }

    public String toString() {
        return Key.jvmdowngrader$concat$of$1(this.namespace, this.path);
    }

    private static boolean isValidNamespace(String namespace) {
        if (namespace == MINECRAFT_NAMESPACE) {
            return true;
        }
        int length = namespace.length();
        for (int i2 = 0; i2 < length; ++i2) {
            char c2 = namespace.charAt(i2);
            if (c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9' || c2 == '_' || c2 == '-' || c2 == '.') continue;
            return false;
        }
        return true;
    }

    private static boolean isValidPath(String path) {
        int length = path.length();
        for (int i2 = 0; i2 < length; ++i2) {
            char c2 = path.charAt(i2);
            if (c2 >= 'a' && c2 <= 'z' || c2 >= '0' && c2 <= '9' || c2 == '_' || c2 == '-' || c2 == '.' || c2 == '/') continue;
            return false;
        }
        return true;
    }

    private static String jvmdowngrader$concat$$init$$1(String string) {
        return "Invalid namespace: " + string;
    }

    private static String jvmdowngrader$concat$$init$$2(String string) {
        return "Invalid path: " + string;
    }

    private static String jvmdowngrader$concat$of$1(String string, String string2) {
        return string + ":" + string2;
    }

    private static String jvmdowngrader$concat$namespaced$1(String string) {
        return "minecraft:" + string;
    }

    private static String jvmdowngrader$concat$namespaced$2(String string) {
        return MINECRAFT_NAMESPACE + string;
    }
}

