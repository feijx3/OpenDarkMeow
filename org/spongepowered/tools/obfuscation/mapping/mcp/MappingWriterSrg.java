/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mapping.mcp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mapping.common.MappingWriter;

public class MappingWriterSrg
extends MappingWriter {
    public MappingWriterSrg(Messager messager, Filer filer) {
        super(messager, filer);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(String output, ObfuscationType type, IMappingConsumer.MappingSet<MappingField> fields2, IMappingConsumer.MappingSet<MappingMethod> methods2) {
        if (output == null) {
            return;
        }
        PrintWriter writer = null;
        try {
            writer = this.openFileWriter(output, type + " output SRGs");
            this.writeFieldMappings(writer, fields2);
            this.writeMethodMappings(writer, methods2);
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (Exception exception) {}
            }
        }
    }

    protected void writeFieldMappings(PrintWriter writer, IMappingConsumer.MappingSet<MappingField> fields2) {
        for (IMappingConsumer.MappingSet.Pair pair : fields2) {
            writer.println(this.formatFieldMapping(pair));
        }
    }

    protected void writeMethodMappings(PrintWriter writer, IMappingConsumer.MappingSet<MappingMethod> methods2) {
        for (IMappingConsumer.MappingSet.Pair pair : methods2) {
            writer.println(this.formatMethodMapping(pair));
        }
    }

    protected String formatFieldMapping(IMappingConsumer.MappingSet.Pair<MappingField> mapping) {
        return String.format("FD: %s/%s %s/%s", ((MappingField)mapping.from).getOwner(), ((MappingField)mapping.from).getName(), ((MappingField)mapping.to).getOwner(), ((MappingField)mapping.to).getName());
    }

    protected String formatMethodMapping(IMappingConsumer.MappingSet.Pair<MappingMethod> mapping) {
        return String.format("MD: %s %s %s %s", ((MappingMethod)mapping.from).getName(), ((MappingMethod)mapping.from).getDesc(), ((MappingMethod)mapping.to).getName(), ((MappingMethod)mapping.to).getDesc());
    }
}

