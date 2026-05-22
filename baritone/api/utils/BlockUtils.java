/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aow
 *  nf
 */
package baritone.api.utils;

import java.util.HashMap;
import java.util.Map;

public class BlockUtils {
    private static transient Map<String, aow> resourceCache = new HashMap<String, aow>();

    public static String blockToString(aow aow2) {
        aow2 = (nf)aow.h.b((Object)aow2);
        String string = aow2.a();
        if (!aow2.b().equals("minecraft")) {
            string = aow2.toString();
        }
        return string;
    }

    public static aow stringToBlockRequired(String string) {
        aow aow2 = BlockUtils.stringToBlockNullable(string);
        if (aow2 == null) {
            throw new IllegalArgumentException(String.format("Invalid block name %s", string));
        }
        return aow2;
    }

    public static aow stringToBlockNullable(String string) {
        aow aow2 = resourceCache.get(string);
        if (aow2 != null) {
            return aow2;
        }
        if (resourceCache.containsKey(string)) {
            return null;
        }
        aow2 = aow.b((String)(string.contains(":") ? string : "minecraft:".concat(String.valueOf(string))));
        HashMap<String, aow> hashMap = new HashMap<String, aow>(resourceCache);
        hashMap.put(string, aow2);
        resourceCache = hashMap;
        return aow2;
    }

    private BlockUtils() {
    }
}

