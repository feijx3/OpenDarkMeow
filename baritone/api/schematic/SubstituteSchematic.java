/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aom
 *  aow
 *  aox
 *  awt
 *  axj
 */
package baritone.api.schematic;

import baritone.api.schematic.AbstractSchematic;
import baritone.api.schematic.ISchematic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SubstituteSchematic
extends AbstractSchematic {
    private final ISchematic schematic;
    private final Map<aow, List<aow>> substitutions;
    private final Map<awt, Map<aow, awt>> blockStateCache = new HashMap<awt, Map<aow, awt>>();

    public SubstituteSchematic(ISchematic iSchematic, Map<aow, List<aow>> map) {
        super(iSchematic.widthX(), iSchematic.heightY(), iSchematic.lengthZ());
        this.schematic = iSchematic;
        this.substitutions = map;
    }

    @Override
    public boolean inSchematic(int n2, int n3, int n4, awt awt2) {
        return this.schematic.inSchematic(n2, n3, n4, awt2);
    }

    @Override
    public awt desiredState(int n2, int n3, int n4, awt awt2, List<awt> list) {
        awt awt3 = this.schematic.desiredState(n2, n3, n4, awt2, list);
        Object object = awt3.u();
        if (!this.substitutions.containsKey(object)) {
            return awt3;
        }
        if ((object = this.substitutions.get(object)).contains(awt2.u()) && !(awt2.u() instanceof aom)) {
            return this.withBlock(awt3, awt2.u());
        }
        Iterator iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            aow aow2 = (aow)iterator2.next();
            if (aow2 instanceof aom) {
                if (awt2.u() instanceof aom) {
                    return awt2;
                }
                return aox.a.t();
            }
            for (awt awt4 : list) {
                if (!aow2.equals(awt4.u())) continue;
                return this.withBlock(awt3, awt4.u());
            }
        }
        return ((aow)object.get(0)).t();
    }

    private awt withBlock(awt awt3, aow aow2) {
        if (this.blockStateCache.containsKey(awt3) && this.blockStateCache.get(awt3).containsKey(aow2)) {
            return this.blockStateCache.get(awt3).get(aow2);
        }
        Object object = awt3.s();
        awt awt4 = aow2.t();
        object = object.iterator();
        while (object.hasNext()) {
            axj axj2 = (axj)object.next();
            try {
                awt4 = this.copySingleProp(awt3, awt4, axj2);
            }
            catch (IllegalArgumentException illegalArgumentException) {}
        }
        this.blockStateCache.computeIfAbsent(awt3, awt2 -> new HashMap()).put(aow2, awt4);
        return awt4;
    }

    private <T extends Comparable<T>> awt copySingleProp(awt awt2, awt awt3, axj<T> axj2) {
        return awt3.a(axj2, awt2.c(axj2));
    }
}

