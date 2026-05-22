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
import java.net.URI;
import lombok.Generated;

public class OpenUrlClickEvent
extends ClickEvent {
    private UrlHolder url;

    public OpenUrlClickEvent(String url) {
        super(ClickEventAction.OPEN_URL);
        try {
            this.url = new UriHolder(URI.create(url));
        }
        catch (Throwable t2) {
            this.url = new StringHolder(url);
        }
    }

    public OpenUrlClickEvent(URI url) {
        super(ClickEventAction.OPEN_URL);
        this.url = new UriHolder(url);
    }

    public UrlHolder getHolder() {
        return this.url;
    }

    public OpenUrlClickEvent setHolder(UrlHolder holder) {
        this.url = holder;
        return this;
    }

    public String asString() {
        if (this.url instanceof StringHolder) {
            return ((StringHolder)this.url).getUrl();
        }
        return ((UriHolder)this.url).getUri().toString();
    }

    public URI asUri() throws IllegalArgumentException {
        if (this.url instanceof StringHolder) {
            return URI.create(((StringHolder)this.url).getUrl());
        }
        return ((UriHolder)this.url).getUri();
    }

    public OpenUrlClickEvent setUrl(String url) {
        this.url = new StringHolder(url);
        return this;
    }

    public OpenUrlClickEvent setUrl(URI url) {
        this.url = new UriHolder(url);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("url", this.url).toString();
    }

    @Override
    @Generated
    public boolean equals(Object o2) {
        if (o2 == this) {
            return true;
        }
        if (!(o2 instanceof OpenUrlClickEvent)) {
            return false;
        }
        OpenUrlClickEvent other = (OpenUrlClickEvent)o2;
        if (!other.canEqual(this)) {
            return false;
        }
        UrlHolder this$url = this.url;
        UrlHolder other$url = other.url;
        return !(this$url == null ? other$url != null : !this$url.equals(other$url));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OpenUrlClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        UrlHolder $url = this.url;
        result = result * 59 + ($url == null ? 43 : $url.hashCode());
        return result;
    }

    public static class UriHolder
    implements UrlHolder {
        private final URI uri;

        public String toString() {
            return this.uri.toString();
        }

        @Generated
        public URI getUri() {
            return this.uri;
        }

        @Generated
        public boolean equals(Object o2) {
            if (o2 == this) {
                return true;
            }
            if (!(o2 instanceof UriHolder)) {
                return false;
            }
            UriHolder other = (UriHolder)o2;
            if (!other.canEqual(this)) {
                return false;
            }
            URI this$uri = this.getUri();
            URI other$uri = other.getUri();
            return !(this$uri == null ? other$uri != null : !((Object)this$uri).equals(other$uri));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof UriHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            URI $uri = this.getUri();
            result = result * 59 + ($uri == null ? 43 : ((Object)$uri).hashCode());
            return result;
        }

        @Generated
        public UriHolder(URI uri) {
            this.uri = uri;
        }
    }

    public static class StringHolder
    implements UrlHolder {
        private final String url;

        public String toString() {
            return this.url;
        }

        @Generated
        public String getUrl() {
            return this.url;
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
            String this$url = this.getUrl();
            String other$url = other.getUrl();
            return !(this$url == null ? other$url != null : !this$url.equals(other$url));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof StringHolder;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $url = this.getUrl();
            result = result * 59 + ($url == null ? 43 : $url.hashCode());
            return result;
        }

        @Generated
        public StringHolder(String url) {
            this.url = url;
        }
    }

    public static interface UrlHolder {
    }
}

