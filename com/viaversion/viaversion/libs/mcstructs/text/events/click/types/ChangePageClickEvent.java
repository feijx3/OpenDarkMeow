/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class ChangePageClickEvent
extends ClickEvent {
    private PageHolder page;

    public ChangePageClickEvent(String page) {
        super(ClickEventAction.CHANGE_PAGE);
        try {
            this.page = new IntHolder(Integer.parseInt(page));
        }
        catch (Throwable t2) {
            this.page = new StringHolder(page);
        }
    }

    public ChangePageClickEvent(int page) {
        super(ClickEventAction.CHANGE_PAGE);
        this.page = new IntHolder(page);
    }

    public PageHolder getHolder() {
        return this.page;
    }

    public String asString() {
        if (this.page instanceof StringHolder) {
            return ((StringHolder)this.page).getPage();
        }
        return String.valueOf(((IntHolder)this.page).getPage());
    }

    public int asInt() throws NumberFormatException {
        if (this.page instanceof StringHolder) {
            return Integer.parseInt(((StringHolder)this.page).getPage());
        }
        return ((IntHolder)this.page).getPage();
    }

    public ChangePageClickEvent setPage(String page) {
        this.page = new StringHolder(page);
        return this;
    }

    public ChangePageClickEvent setPage(int page) {
        this.page = new IntHolder(page);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("page", this.page).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof ChangePageClickEvent)) {
            return false;
        }
        ChangePageClickEvent other = (ChangePageClickEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        PageHolder this$page = this.page;
        PageHolder other$page = other.page;
        return !(this$page == null ? other$page != null : !this$page.equals(other$page));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ChangePageClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        PageHolder $page = this.page;
        result = result * 59 + ($page == null ? 43 : $page.hashCode());
        return result;
    }

    public static class IntHolder
    implements PageHolder {
        private int page;

        public String toString() {
            return String.valueOf(this.page);
        }

        @Generated
        public int getPage() {
            return this.page;
        }

        @Generated
        public void setPage(int page) {
            this.page = page;
        }

        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof IntHolder)) {
                return false;
            }
            IntHolder other = (IntHolder)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            return this.getPage() == other.getPage();
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof IntHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getPage();
            return result;
        }

        @Generated
        public IntHolder(int page) {
            this.page = page;
        }
    }

    public static class StringHolder
    implements PageHolder {
        private String page;

        public String toString() {
            return this.page;
        }

        @Generated
        public String getPage() {
            return this.page;
        }

        @Generated
        public void setPage(String page) {
            this.page = page;
        }

        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof StringHolder)) {
                return false;
            }
            StringHolder other = (StringHolder)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$page = this.getPage();
            String other$page = other.getPage();
            return !(this$page == null ? other$page != null : !this$page.equals(other$page));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof StringHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $page = this.getPage();
            result = result * 59 + ($page == null ? 43 : $page.hashCode());
            return result;
        }

        @Generated
        public StringHolder(String page) {
            this.page = page;
        }
    }

    public static interface PageHolder {
    }
}

