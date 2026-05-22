/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class NbtComponent
extends TextComponent {
    private String component;
    private boolean resolve;
    private TextComponent separator;
    private NbtDataSource dataSource;

    public NbtComponent(String component, boolean resolve, NbtDataSource dataSource) {
        this(component, resolve, null, dataSource);
    }

    public NbtComponent(String component, boolean resolve, @Nullable TextComponent separator, NbtDataSource dataSource) {
        this.component = component;
        this.resolve = resolve;
        this.separator = separator;
        this.dataSource = dataSource;
    }

    public String getComponent() {
        return this.component;
    }

    public NbtComponent setComponent(String component) {
        this.component = component;
        return this;
    }

    public boolean isResolve() {
        return this.resolve;
    }

    public NbtComponent setResolve(boolean resolve) {
        this.resolve = resolve;
        return this;
    }

    @Nullable
    public TextComponent getSeparator() {
        return this.separator;
    }

    public NbtComponent setSeparator(TextComponent separator) {
        this.separator = separator;
        return this;
    }

    public NbtDataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(NbtDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String asSingleString() {
        return "";
    }

    @Override
    public TextComponent copy() {
        return this.copyMetaTo(this.shallowCopy());
    }

    @Override
    public TextComponent shallowCopy() {
        NbtComponent copy = new NbtComponent(this.component, this.resolve, this.separator, this.dataSource);
        return copy.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).add("siblings", this.getSiblings(), siblings -> !siblings.isEmpty()).add("style", this.getStyle(), style -> !style.isEmpty()).add("component", this.component).add("resolve", this.resolve).add("separator", this.separator, Objects::nonNull).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof NbtComponent)) {
            return false;
        }
        NbtComponent other = (NbtComponent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o2)) {
            return false;
        }
        if (this.isResolve() != other.isResolve()) {
            return false;
        }
        String this$component = this.getComponent();
        String other$component = other.getComponent();
        if (this$component == null ? other$component != null : !this$component.equals(other$component)) {
            return false;
        }
        TextComponent this$separator = this.getSeparator();
        TextComponent other$separator = other.getSeparator();
        if (this$separator == null ? other$separator != null : !((Object)this$separator).equals(other$separator)) {
            return false;
        }
        NbtDataSource this$dataSource = this.getDataSource();
        NbtDataSource other$dataSource = other.getDataSource();
        return !(this$dataSource == null ? other$dataSource != null : !this$dataSource.equals(other$dataSource));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof NbtComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        result = result * 59 + (this.isResolve() ? 79 : 97);
        String $component = this.getComponent();
        result = result * 59 + ($component == null ? 43 : $component.hashCode());
        TextComponent $separator = this.getSeparator();
        result = result * 59 + ($separator == null ? 43 : ((Object)$separator).hashCode());
        NbtDataSource $dataSource = this.getDataSource();
        result = result * 59 + ($dataSource == null ? 43 : $dataSource.hashCode());
        return result;
    }
}

