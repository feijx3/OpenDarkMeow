/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.ui.client.hud.element.elements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.message.notification.INotificationListener;
import net.ccbluex.liquidbounce.handler.message.notification.Notification;
import net.ccbluex.liquidbounce.handler.message.notification.NotificationType;
import net.ccbluex.liquidbounce.injection.forge.MinecraftInstance;
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner;
import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementBorder;
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementSide;
import net.ccbluex.liquidbounce.utils.render.EaseUtils;
import net.ccbluex.liquidbounce.value.impl.ColorValue;
import net.ccbluex.liquidbounce.value.impl.FontValue;
import net.ccbluex.liquidbounce.value.impl.IntegerValue;
import net.darkmeow.darkmeow.utils.visual.FontRendererUtils;
import net.darkmeow.darkmeow.utils.visual.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0003\u001b\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "Lnet/ccbluex/liquidbounce/handler/message/notification/INotificationListener;", "<init>", "()V", "backGroundAlphaValue", "Lnet/ccbluex/liquidbounce/value/impl/IntegerValue;", "colorValue", "Lnet/ccbluex/liquidbounce/value/impl/ColorValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/impl/FontValue;", "exampleNotification", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications$NotificationDisplay;", "notifications", "", "getNotifications", "()Ljava/util/List;", "onNotification", "", "notification", "Lnet/ccbluex/liquidbounce/handler/message/notification/Notification;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementBorder;", "partialTicks", "", "destroyElement", "", "Companion", "NotificationDisplay", "FadeState", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nElementNotifications.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementNotifications.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,210:1\n1563#2:211\n1634#2,3:212\n1878#2,3:215\n*S KotlinDebug\n*F\n+ 1 ElementNotifications.kt\nnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications\n*L\n73#1:211\n73#1:212,3\n73#1:215,3\n*E\n"})
public final class ElementNotifications
extends Element
implements INotificationListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final IntegerValue backGroundAlphaValue = new IntegerValue("BackGroundAlpha", 170, 0, 255);
    @NotNull
    private final ColorValue colorValue = new ColorValue("Color", null, false, 6, null);
    @NotNull
    private final FontValue fontValue = new FontValue("Font", new FontValue.FontInfo(null, 0, 3, null));
    @NotNull
    private final NotificationDisplay exampleNotification = new NotificationDisplay("Notification", "This is an example notification.", new Color(6590631), 1500, 500, this);
    @NotNull
    private final List<NotificationDisplay> notifications = new ArrayList();
    @NotNull
    private static final HashMap<NotificationType, Color> NOTIFICATION_COLOR_MAP;

    public ElementNotifications() {
        super("Notifications", 0.0, 0.0, 0.0f, new ElementSide(ElementSide.Horizontal.RIGHT, ElementSide.Vertical.DOWN), 0, 40, null);
        DarkMeow.INSTANCE.getMessageManager().notificationManager.registerListener(this);
    }

    @NotNull
    public final List<NotificationDisplay> getNotifications() {
        return this.notifications;
    }

    @Override
    public boolean onNotification(@NotNull Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        String string = notification.getTitle();
        String string2 = notification.getMessage();
        Color color = NOTIFICATION_COLOR_MAP.get((Object)notification.getType());
        if (color == null) {
            color = new Color(6590631);
        }
        this.notifications.add(new NotificationDisplay(string, string2, color, (int)notification.getDisplayTime(), 500, this));
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public ElementBorder drawElement(float partialTicks) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this.notifications;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            NotificationDisplay notificationDisplay = (NotificationDisplay)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add(it);
        }
        Iterable $this$forEachIndexed$iv = (List)destination$iv$iv;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            void notify;
            int n2;
            Object item$iv$iv;
            if ((n2 = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            item$iv$iv = (NotificationDisplay)item$iv;
            int index = n2;
            boolean bl3 = false;
            GlStateManager.func_179094_E();
            if (notify.drawNotification(index, this.fontValue.getFont(), ((Number)this.backGroundAlphaValue.get()).intValue())) {
                this.notifications.remove(notify);
            }
            GlStateManager.func_179121_F();
        }
        if (MinecraftInstance.mc.getCurrentScreen() instanceof GuiHudDesigner) {
            if (!this.notifications.contains(this.exampleNotification)) {
                this.notifications.add(this.exampleNotification);
            }
            this.exampleNotification.setFadeState(FadeState.STAY);
            this.exampleNotification.setDisplayTime(System.currentTimeMillis());
            return new ElementBorder(-((float)this.exampleNotification.getWidth()), -((float)this.exampleNotification.getHeight()), 0.0f, 0.0f);
        }
        return null;
    }

    @Override
    public void destroyElement() {
        DarkMeow.INSTANCE.getMessageManager().notificationManager.unregisterListener(this);
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to(NotificationType.SUCCESS, new Color(6348946)), TuplesKt.to(NotificationType.ERROR, new Color(0xFF2F2F)), TuplesKt.to(NotificationType.WARNING, new Color(16121088)), TuplesKt.to(NotificationType.INFO, new Color(6590631))};
        NOTIFICATION_COLOR_MAP = MapsKt.hashMapOf(pairArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications$Companion;", "", "<init>", "()V", "NOTIFICATION_COLOR_MAP", "Ljava/util/HashMap;", "Lnet/ccbluex/liquidbounce/handler/message/notification/NotificationType;", "Ljava/awt/Color;", "Lkotlin/collections/HashMap;", "getNOTIFICATION_COLOR_MAP", "()Ljava/util/HashMap;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashMap<NotificationType, Color> getNOTIFICATION_COLOR_MAP() {
            return NOTIFICATION_COLOR_MAP;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications$FadeState;", "", "<init>", "(Ljava/lang/String;I)V", "IN", "STAY", "OUT", "END", "DarkMeow"})
    public static final class FadeState
    extends Enum<FadeState> {
        public static final /* enum */ FadeState IN = new FadeState();
        public static final /* enum */ FadeState STAY = new FadeState();
        public static final /* enum */ FadeState OUT = new FadeState();
        public static final /* enum */ FadeState END = new FadeState();
        private static final /* synthetic */ FadeState[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static FadeState[] values() {
            return (FadeState[])$VALUES.clone();
        }

        public static FadeState valueOf(String value) {
            return Enum.valueOf(FadeState.class, value);
        }

        @NotNull
        public static EnumEntries<FadeState> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = fadeStateArray = new FadeState[]{FadeState.IN, FadeState.STAY, FadeState.OUT, FadeState.END};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2={"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications$NotificationDisplay;", "", "title", "", "content", "color", "Ljava/awt/Color;", "time", "", "animeTime", "instance", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/awt/Color;IILnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications;)V", "getTitle", "()Ljava/lang/String;", "getContent", "getColor", "()Ljava/awt/Color;", "getTime", "()I", "width", "getWidth", "setWidth", "(I)V", "height", "getHeight", "x", "", "getX", "()F", "setX", "(F)V", "fadeState", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications$FadeState;", "getFadeState", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications$FadeState;", "setFadeState", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ElementNotifications$FadeState;)V", "nowY", "displayTime", "", "getDisplayTime", "()J", "setDisplayTime", "(J)V", "animeXTime", "animeYTime", "drawNotification", "", "index", "font", "Lnet/minecraft/client/gui/FontRenderer;", "alpha", "DarkMeow"})
    public static final class NotificationDisplay {
        @NotNull
        private final String title;
        @NotNull
        private final String content;
        @NotNull
        private final Color color;
        private final int time;
        private final int animeTime;
        @NotNull
        private final ElementNotifications instance;
        private int width;
        private final int height;
        private float x;
        @NotNull
        private FadeState fadeState;
        private int nowY;
        private long displayTime;
        private long animeXTime;
        private long animeYTime;

        public NotificationDisplay(@NotNull String title, @NotNull String content, @NotNull Color color, int time, int animeTime, @NotNull ElementNotifications instance) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(instance, "instance");
            this.title = title;
            this.content = content;
            this.color = color;
            this.time = time;
            this.animeTime = animeTime;
            this.instance = instance;
            this.width = 100;
            this.height = 30;
            this.fadeState = FadeState.IN;
            this.nowY = -this.height;
            this.displayTime = System.currentTimeMillis();
            this.animeXTime = System.currentTimeMillis();
            this.animeYTime = System.currentTimeMillis();
        }

        public /* synthetic */ NotificationDisplay(String string, String string2, Color color, int n2, int n3, ElementNotifications elementNotifications, int n4, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n4 & 8) != 0) {
                n2 = 1500;
            }
            if ((n4 & 0x10) != 0) {
                n3 = 500;
            }
            this(string, string2, color, n2, n3, elementNotifications);
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        @NotNull
        public final Color getColor() {
            return this.color;
        }

        public final int getTime() {
            return this.time;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setWidth(int n2) {
            this.width = n2;
        }

        public final int getHeight() {
            return this.height;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f2) {
            this.x = f2;
        }

        @NotNull
        public final FadeState getFadeState() {
            return this.fadeState;
        }

        public final void setFadeState(@NotNull FadeState fadeState) {
            Intrinsics.checkNotNullParameter((Object)fadeState, "<set-?>");
            this.fadeState = fadeState;
        }

        public final long getDisplayTime() {
            return this.displayTime;
        }

        public final void setDisplayTime(long l2) {
            this.displayTime = l2;
        }

        public final boolean drawNotification(int index, @NotNull FontRenderer font, int alpha) {
            double pct;
            Intrinsics.checkNotNullParameter(font, "font");
            this.width = RangesKt.coerceAtLeast(100, RangesKt.coerceAtLeast(font.func_78256_a(this.content), font.func_78256_a(this.title)) + 15);
            int realY = -(index + 1) * (this.height + 2);
            long nowTime = System.currentTimeMillis();
            double transY = this.nowY;
            if (this.nowY != realY) {
                pct = (double)(nowTime - this.animeYTime) / (double)this.animeTime;
                if (pct > 1.0) {
                    this.nowY = realY;
                    pct = 1.0;
                } else {
                    pct = EaseUtils.easeOutQuart(pct);
                }
                GlStateManager.func_179137_b((double)0.0, (double)((double)(realY - this.nowY) * pct), (double)0.0);
            } else {
                this.animeYTime = nowTime;
            }
            GlStateManager.func_179137_b((double)1.0, (double)this.nowY, (double)0.0);
            pct = (double)(nowTime - this.animeXTime) / (double)this.animeTime;
            switch (WhenMappings.$EnumSwitchMapping$0[this.fadeState.ordinal()]) {
                case 1: {
                    if (pct > 1.0) {
                        this.fadeState = FadeState.STAY;
                        this.animeXTime = nowTime;
                        pct = 1.0;
                    }
                    pct = EaseUtils.easeOutQuart(pct);
                    transY += (double)(realY - this.nowY) * pct;
                    break;
                }
                case 2: {
                    pct = 1.0;
                    if (nowTime - this.animeXTime <= (long)this.time) break;
                    this.fadeState = FadeState.OUT;
                    this.animeXTime = nowTime;
                    break;
                }
                case 3: {
                    if (pct > 1.0) {
                        this.fadeState = FadeState.END;
                        this.animeXTime = nowTime;
                        pct = 2.0;
                    }
                    pct = 1.0 - EaseUtils.easeInQuart(pct);
                    break;
                }
                case 4: {
                    return true;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            GlStateManager.func_179137_b((double)((double)this.width - (double)this.width * pct), (double)0.0, (double)0.0);
            GlStateManager.func_179109_b((float)(-((float)this.width)), (float)0.0f, (float)0.0f);
            Color colors = new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), alpha / 3);
            RenderUtils.INSTANCE.drawRect(2, 0, 4, 22, colors);
            RenderUtils.INSTANCE.drawRect(3, 0, this.width + 5, 22, new Color(0, 0, 0, 150));
            RenderUtils.INSTANCE.drawRect(2, 21, (int)Math.max((long)this.width - (long)this.width * ((nowTime - this.displayTime) / (long)(this.animeTime * 2 + this.time)) + (long)5, 0L), 22, ColorValue.getColor$default(this.instance.colorValue, null, 1, null));
            FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, font, this.title, Float.valueOf(6.0f), Float.valueOf(3.0f), null, false, 24, null);
            FontRendererUtils.drawString$default(FontRendererUtils.INSTANCE, font, this.content, Float.valueOf(6.0f), Float.valueOf(12.0f), null, false, 24, null);
            return false;
        }

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[FadeState.values().length];
                try {
                    nArray[FadeState.IN.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[FadeState.STAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[FadeState.OUT.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[FadeState.END.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}

