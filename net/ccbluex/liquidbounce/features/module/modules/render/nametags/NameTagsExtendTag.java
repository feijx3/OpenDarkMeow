/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.render.nametags;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.ccbluex.liquidbounce.features.module.modules.render.NameTags;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.ClassUtils;
import net.ccbluex.liquidbounce.value.Value;
import net.ccbluex.liquidbounce.value.impl.BoolValue;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/render/nametags/NameTagsExtendTag;", "Lnet/ccbluex/liquidbounce/injection/forge/MinecraftInstance;", "modeName", "", "<init>", "(Ljava/lang/String;)V", "getModeName", "()Ljava/lang/String;", "linkedStatValue", "Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "getLinkedStatValue", "()Lnet/ccbluex/liquidbounce/value/impl/BoolValue;", "setLinkedStatValue", "(Lnet/ccbluex/liquidbounce/value/impl/BoolValue;)V", "valuePrefix", "getValuePrefix", "instance", "Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags;", "getInstance", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags;", "setInstance", "(Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags;)V", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "onRenderExtend", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "DarkMeow"})
public abstract class NameTagsExtendTag
extends MinecraftInstance {
    @NotNull
    private final String modeName;
    public BoolValue linkedStatValue;
    @NotNull
    private final String valuePrefix;
    public NameTags instance;

    public NameTagsExtendTag(@NotNull String modeName) {
        Intrinsics.checkNotNullParameter(modeName, "modeName");
        this.modeName = modeName;
        this.valuePrefix = this.modeName + '-';
    }

    @NotNull
    public final String getModeName() {
        return this.modeName;
    }

    @NotNull
    public final BoolValue getLinkedStatValue() {
        BoolValue boolValue = this.linkedStatValue;
        if (boolValue != null) {
            return boolValue;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linkedStatValue");
        return null;
    }

    public final void setLinkedStatValue(@NotNull BoolValue boolValue) {
        Intrinsics.checkNotNullParameter(boolValue, "<set-?>");
        this.linkedStatValue = boolValue;
    }

    @NotNull
    protected final String getValuePrefix() {
        return this.valuePrefix;
    }

    @NotNull
    public final NameTags getInstance() {
        NameTags nameTags = this.instance;
        if (nameTags != null) {
            return nameTags;
        }
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        return null;
    }

    public final void setInstance(@NotNull NameTags nameTags) {
        Intrinsics.checkNotNullParameter(nameTags, "<set-?>");
        this.instance = nameTags;
    }

    @NotNull
    public List<Value<?>> getValues() {
        return ClassUtils.INSTANCE.getValues(this.getClass(), this);
    }

    public abstract boolean onRenderExtend(@NotNull EntityLivingBase var1);
}

