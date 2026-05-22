/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bib
 *  brz
 *  bud
 */
package baritone.api;

import baritone.api.IBaritone;
import baritone.api.cache.IWorldScanner;
import baritone.api.command.ICommandSystem;
import baritone.api.schematic.ISchematicSystem;
import java.util.List;
import java.util.Objects;

public interface IBaritoneProvider {
    public IBaritone getPrimaryBaritone();

    public List<IBaritone> getAllBaritones();

    default public IBaritone getBaritoneForPlayer(bud bud2) {
        for (IBaritone iBaritone : this.getAllBaritones()) {
            if (!Objects.equals(bud2, iBaritone.getPlayerContext().player())) continue;
            return iBaritone;
        }
        return null;
    }

    default public IBaritone getBaritoneForMinecraft(bib bib2) {
        for (IBaritone iBaritone : this.getAllBaritones()) {
            if (!Objects.equals(bib2, iBaritone.getPlayerContext().minecraft())) continue;
            return iBaritone;
        }
        return null;
    }

    default public IBaritone getBaritoneForConnection(brz brz2) {
        for (IBaritone iBaritone : this.getAllBaritones()) {
            bud bud2 = iBaritone.getPlayerContext().player();
            if (bud2 == null || bud2.d != brz2) continue;
            return iBaritone;
        }
        return null;
    }

    public IBaritone createBaritone(bib var1);

    public boolean destroyBaritone(IBaritone var1);

    public IWorldScanner getWorldScanner();

    public ICommandSystem getCommandSystem();

    public ISchematicSystem getSchematicSystem();
}

