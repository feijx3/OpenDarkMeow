/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion.converter;

import com.viaversion.nbt.conversion.ConverterRegistry;
import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTagConverter
implements TagConverter<ListTag, List> {
    @Override
    public List convert(ListTag tag) {
        ArrayList ret = new ArrayList();
        Object tags = tag.getValue();
        Iterator iterator2 = tags.iterator();
        while (iterator2.hasNext()) {
            Tag t2 = (Tag)iterator2.next();
            ret.add(ConverterRegistry.convertToValue(t2));
        }
        return ret;
    }

    @Override
    public ListTag convert(List value) {
        ArrayList tags = new ArrayList();
        for (Object o2 : value) {
            tags.add(ConverterRegistry.convertToTag(o2));
        }
        return new ListTag(tags);
    }
}

