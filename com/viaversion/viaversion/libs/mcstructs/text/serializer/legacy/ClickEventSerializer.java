/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.ChangePageClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenFileClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.OpenUrlClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.RunCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.SuggestCommandClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.types.TwitchUserInfoClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy.EventSerializer;
import java.util.function.Predicate;

public class ClickEventSerializer<T extends ClickEvent>
extends EventSerializer<ClickEvent, T, ClickEventAction, String> {
    public static final ClickEventSerializer<OpenUrlClickEvent> OPEN_URL = ClickEventSerializer.create(OpenUrlClickEvent.class::isInstance, OpenUrlClickEvent::asString, ClickEventAction.OPEN_URL, OpenUrlClickEvent::new);
    public static final ClickEventSerializer<OpenFileClickEvent> OPEN_FILE = ClickEventSerializer.create(OpenFileClickEvent.class::isInstance, OpenFileClickEvent::getPath, ClickEventAction.OPEN_FILE, OpenFileClickEvent::new);
    public static final ClickEventSerializer<RunCommandClickEvent> RUN_COMMAND = ClickEventSerializer.create(RunCommandClickEvent.class::isInstance, RunCommandClickEvent::getCommand, ClickEventAction.RUN_COMMAND, RunCommandClickEvent::new);
    public static final ClickEventSerializer<TwitchUserInfoClickEvent> TWITCH_USER_INFO = ClickEventSerializer.create(TwitchUserInfoClickEvent.class::isInstance, TwitchUserInfoClickEvent::getUser, ClickEventAction.TWITCH_USER_INFO, TwitchUserInfoClickEvent::new);
    public static final ClickEventSerializer<SuggestCommandClickEvent> SUGGEST_COMMAND = ClickEventSerializer.create(SuggestCommandClickEvent.class::isInstance, SuggestCommandClickEvent::getCommand, ClickEventAction.SUGGEST_COMMAND, SuggestCommandClickEvent::new);
    public static final ClickEventSerializer<ChangePageClickEvent> CHANGE_PAGE = ClickEventSerializer.create(ChangePageClickEvent.class::isInstance, ChangePageClickEvent::asString, ClickEventAction.CHANGE_PAGE, ChangePageClickEvent::new);

    private static <T extends ClickEvent> ClickEventSerializer<T> create(Predicate<ClickEvent> classMatcher, EventSerializer.BasicIOFunction<T, String> serializer, ClickEventAction action, EventSerializer.BasicIOFunction<String, T> deserializer) {
        return new ClickEventSerializer<T>(classMatcher, serializer, action, deserializer);
    }

    protected ClickEventSerializer(Predicate<ClickEvent> classMatcher, EventSerializer.IOFunction<T, String> serializer, ClickEventAction action, EventSerializer.IOFunction<String, T> deserializer) {
        super(classMatcher, serializer, action, deserializer);
    }
}

