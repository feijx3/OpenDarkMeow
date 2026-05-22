/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_20_5;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_2;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.Types1_21;

public final class VersionedTypes {
    public static final Types1_20_5<StructuredDataKeys1_20_5, EntityDataTypes1_20_5> V1_20_5 = new Types1_20_5<StructuredDataKeys1_20_5, EntityDataTypes1_20_5>(StructuredDataKeys1_20_5::new, EntityDataTypes1_20_5::new);
    public static final Types1_21 V1_21 = new Types1_21(StructuredDataKeys1_20_5::new, EntityDataTypes1_21::new);
    public static final Types1_20_5<StructuredDataKeys1_21_2, EntityDataTypes1_21_2> V1_21_2 = new Types1_20_5<StructuredDataKeys1_21_2, EntityDataTypes1_21_2>(StructuredDataKeys1_21_2::new, EntityDataTypes1_21_2::new);
    public static final Types1_20_5<StructuredDataKeys1_21_2, EntityDataTypes1_21_2> V1_21_4 = new Types1_20_5<StructuredDataKeys1_21_2, EntityDataTypes1_21_2>(StructuredDataKeys1_21_2::new, EntityDataTypes1_21_2::new);
    public static final Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5> V1_21_5 = new Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5>(StructuredDataKeys1_21_5::new, EntityDataTypes1_21_5::new);
    public static final Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5> V1_21_6 = new Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5>(StructuredDataKeys1_21_5::new, EntityDataTypes1_21_5::new);
}

