/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectMap;

public final class ServerLinks
implements StorableObject {
    private static final CompoundTag REPORT_BUG = ChatUtil.translate("known_server_link.report_bug");
    private static final CompoundTag COMMUNITY_GUIDELINES = ChatUtil.translate("known_server_link.community_guidelines");
    private static final CompoundTag SUPPORT = ChatUtil.translate("known_server_link.support");
    private static final CompoundTag STATUS = ChatUtil.translate("known_server_link.status");
    private static final CompoundTag FEEDBACK = ChatUtil.translate("known_server_link.feedback");
    private static final CompoundTag COMMUNITY = ChatUtil.translate("known_server_link.community");
    private static final CompoundTag WEBSITE = ChatUtil.translate("known_server_link.website");
    private static final CompoundTag FORUMS = ChatUtil.translate("known_server_link.forums");
    private static final CompoundTag NEWS = ChatUtil.translate("known_server_link.news");
    private static final CompoundTag ANNOUNCEMENTS = ChatUtil.translate("known_server_link.announcements");
    private final Object2ObjectMap<Tag, String> links = new Object2ObjectArrayMap<Tag, String>();

    public void storeLink(Tag tag, String uri) {
        this.links.put(tag, uri);
    }

    public void storeLink(int id, String uri) {
        switch (id) {
            case 1: {
                this.storeLink(COMMUNITY_GUIDELINES, uri);
                break;
            }
            case 2: {
                this.storeLink(SUPPORT, uri);
                break;
            }
            case 3: {
                this.storeLink(STATUS, uri);
                break;
            }
            case 4: {
                this.storeLink(FEEDBACK, uri);
                break;
            }
            case 5: {
                this.storeLink(COMMUNITY, uri);
                break;
            }
            case 6: {
                this.storeLink(WEBSITE, uri);
                break;
            }
            case 7: {
                this.storeLink(FORUMS, uri);
                break;
            }
            case 8: {
                this.storeLink(NEWS, uri);
                break;
            }
            case 9: {
                this.storeLink(ANNOUNCEMENTS, uri);
                break;
            }
            default: {
                this.storeLink(REPORT_BUG, uri);
            }
        }
    }

    public Object2ObjectMap<Tag, String> links() {
        return this.links;
    }
}

