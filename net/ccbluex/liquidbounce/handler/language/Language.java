/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.language;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/ccbluex/liquidbounce/handler/language/Language;", "", "locale", "", "text", "base", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/handler/language/Language;)V", "file", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;Lnet/ccbluex/liquidbounce/handler/language/Language;)V", "translateMap", "Ljava/util/HashMap;", "getOrNull", "key", "get", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nLanguage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Language.kt\nnet/ccbluex/liquidbounce/handler/language/Language\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n1869#2:71\n1870#2:73\n1#3:72\n*S KotlinDebug\n*F\n+ 1 Language.kt\nnet/ccbluex/liquidbounce/handler/language/Language\n*L\n38#1:71\n38#1:73\n*E\n"})
public final class Language {
    @JvmField
    @NotNull
    public final String locale;
    @JvmField
    @NotNull
    public final String text;
    @JvmField
    @Nullable
    public final Language base;
    @JvmField
    @NotNull
    public final HashMap<String, String> translateMap;

    /*
     * WARNING - void declaration
     */
    public Language(@NotNull String locale, @NotNull String text, @Nullable Language base) {
        void $this$forEach$iv;
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(text, "text");
        this.locale = locale;
        this.text = text;
        this.base = base;
        this.translateMap = new HashMap();
        Object object = new String[]{"\n"};
        object = StringsKt.split$default((CharSequence)this.text, object, false, 0, 6, null);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object object2;
            String text2 = (String)element$iv;
            boolean bl2 = false;
            Object object3 = new String[]{"="};
            Object it = object3 = StringsKt.split$default((CharSequence)text2, (String[])object3, false, 2, 2, null);
            boolean bl3 = false;
            Object object4 = it.size() == 2 ? object3 : null;
            if (object4 == null) continue;
            Object it2 = object2 = object4;
            boolean bl4 = false;
            object3 = !StringsKt.startsWith$default((String)it2.get(0), "#", false, 2, null) ? object2 : null;
            if (object3 == null) continue;
            it2 = object2 = object3;
            boolean bl5 = false;
            Map map = this.translateMap;
            String string = ((String)it2.get(0)).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
            map.put(string, it2.get(1));
        }
    }

    public /* synthetic */ Language(String string, String string2, Language language, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            language = null;
        }
        this(string, string2, language);
    }

    public Language(@NotNull String locale, @NotNull File file, @Nullable Language base) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(file, "file");
        this(locale, FilesKt.readText(file, Charsets.UTF_8), base);
    }

    public /* synthetic */ Language(String string, File file, Language language, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            language = null;
        }
        this(string, file, language);
    }

    @Nullable
    public final String getOrNull(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(string, "toLowerCase(...)");
        String it = string;
        boolean bl2 = false;
        String string2 = this.translateMap.get(it);
        if (string2 == null) {
            Language language = this.base;
            string2 = language != null ? language.get(it) : null;
        }
        return string2;
    }

    @NotNull
    public final String get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.getOrNull(key);
        if (string == null) {
            string = key;
        }
        return string;
    }
}

