/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.lunatrius.schematica.Schematica
 *  com.github.lunatrius.schematica.client.world.SchematicWorld
 *  com.github.lunatrius.schematica.proxy.ClientProxy
 *  et
 *  rr
 */
package baritone.utils.schematic.schematica;

import baritone.api.schematic.IStaticSchematic;
import baritone.utils.schematic.schematica.SchematicAdapter;
import com.github.lunatrius.schematica.Schematica;
import com.github.lunatrius.schematica.client.world.SchematicWorld;
import com.github.lunatrius.schematica.proxy.ClientProxy;
import java.util.Optional;

public enum SchematicaHelper {


    public static boolean a() {
        try {
            Class.forName(Schematica.class.getName());
            return true;
        }
        catch (ClassNotFoundException | NoClassDefFoundError throwable) {
            return false;
        }
    }

    public static Optional<rr<IStaticSchematic, et>> a() {
        return Optional.ofNullable(ClientProxy.schematic).map(schematicWorld -> new rr((Object)new SchematicAdapter((SchematicWorld)schematicWorld), (Object)schematicWorld.position));
    }
}

