/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.ccbluex.liquidbounce.handler.language;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.ccbluex.liquidbounce.DarkMeow;
import net.ccbluex.liquidbounce.handler.ManagerBase;
import net.ccbluex.liquidbounce.handler.language.Language;
import net.ccbluex.liquidbounce.utils.file.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0007J-\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0018J+\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0017\"\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R,\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007`\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/ccbluex/liquidbounce/handler/language/LanguageManager;", "Lnet/ccbluex/liquidbounce/handler/ManagerBase;", "system", "Lnet/ccbluex/liquidbounce/DarkMeow;", "<init>", "(Lnet/ccbluex/liquidbounce/DarkMeow;)V", "baseLanguage", "Lnet/ccbluex/liquidbounce/handler/language/Language;", "currentLanguage", "languages", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onReload", "", "unpackDefaultLanguages", "", "force", "reloadLanguages", "noUnPacket", "getOrNull", "key", "args", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "get", "switch", "str", "Companion", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nLanguageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageManager.kt\nnet/ccbluex/liquidbounce/handler/language/LanguageManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n1#2:133\n13472#3,2:134\n13472#3,2:136\n*S KotlinDebug\n*F\n+ 1 LanguageManager.kt\nnet/ccbluex/liquidbounce/handler/language/LanguageManager\n*L\n65#1:134,2\n94#1:136,2\n*E\n"})
public final class LanguageManager
extends ManagerBase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Language baseLanguage;
    @JvmField
    @NotNull
    public Language currentLanguage;
    @JvmField
    @NotNull
    public final HashMap<String, Language> languages;
    @NotNull
    public static final String LANGUAGE_DEFAULT = "en_us";
    @NotNull
    private static final String[] LANGUAGES_LIST;

    public LanguageManager(@NotNull DarkMeow system) {
        Intrinsics.checkNotNullParameter(system, "system");
        super(system);
        this.currentLanguage = this.baseLanguage = new Language(LANGUAGE_DEFAULT, FileUtils.INSTANCE.readResourceFileAsString(DarkMeow.INSTANCE.getFileManager().resourceDir + "/languages/en_us.lang"), null, 4, null);
        this.languages = new HashMap();
    }

    @Override
    public void onReload() {
        LanguageManager.reloadLanguages$default(this, false, 1, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmOverloads
    public final boolean unpackDefaultLanguages(boolean force) {
        File file;
        File file2;
        File it = file2 = DarkMeow.INSTANCE.getFileManager().getLanguageDir();
        boolean bl2 = false;
        if (it.exists()) {
            if (!force) return false;
        }
        boolean bl3 = true;
        if (!bl3) return false;
        File file3 = file2;
        File file4 = file3;
        if (file4 == null) return false;
        File it2 = file = file4;
        boolean bl4 = false;
        if (!it2.mkdirs()) {
            if (!force) return false;
        }
        boolean bl5 = true;
        if (!bl5) return false;
        File file5 = file;
        file2 = file5;
        if (file2 == null) return false;
        File dir = file2;
        boolean bl6 = false;
        try {
            String[] $this$forEach$iv = LANGUAGES_LIST;
            boolean $i$f$forEach = false;
            int n2 = 0;
            int n3 = $this$forEach$iv.length;
            while (n2 < n3) {
                String element$iv;
                String language = element$iv = $this$forEach$iv[n2];
                boolean bl7 = false;
                FileUtils.INSTANCE.unpackResourceFile(DarkMeow.INSTANCE.getFileManager().resourceDir + "/languages/" + language + ".lang", new File(dir, language + ".lang"));
                ++n2;
            }
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static /* synthetic */ boolean unpackDefaultLanguages$default(LanguageManager languageManager, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        return languageManager.unpackDefaultLanguages(bl2);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @JvmOverloads
    public final boolean reloadLanguages(boolean noUnPacket) {
        void $this$forEach$iv;
        File[] fileArray;
        File[] fileArray2;
        File[] fileArray3;
        File[] it = fileArray3 = DarkMeow.INSTANCE.getFileManager().getLanguageDir();
        boolean bl2 = false;
        if (!it.exists() && !noUnPacket) {
            this.unpackDefaultLanguages(false);
        }
        it = fileArray3;
        boolean bl3 = false;
        if (!it.exists()) return false;
        File[] fileArray4 = fileArray3;
        File[] fileArray5 = fileArray4;
        if (fileArray5 == null) return false;
        fileArray3 = fileArray5.listFiles();
        if (fileArray3 == null) return false;
        File[] it2 = fileArray2 = fileArray3;
        boolean bl4 = false;
        if (it2.length == 0) {
            return false;
        }
        boolean bl5 = false;
        if (bl5) return false;
        boolean bl6 = true;
        if (!bl6) return false;
        File[] fileArray6 = fileArray2;
        File[] fileArray7 = fileArray6;
        if (fileArray7 == null) return false;
        File[] it3 = fileArray = fileArray7;
        boolean bl7 = false;
        this.languages.clear();
        it3 = fileArray;
        boolean $i$f$forEach = false;
        int n2 = ((void)$this$forEach$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void element$iv;
            void it4 = element$iv = $this$forEach$iv[i2];
            boolean bl8 = false;
            Map map = this.languages;
            Intrinsics.checkNotNull(it4);
            map.put(FilesKt.getNameWithoutExtension((File)it4), new Language(FilesKt.getNameWithoutExtension((File)it4), (File)it4, null));
        }
        Unit it5 = Unit.INSTANCE;
        return true;
    }

    public static /* synthetic */ boolean reloadLanguages$default(LanguageManager languageManager, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        return languageManager.reloadLanguages(bl2);
    }

    @Nullable
    public final String getOrNull(@NotNull String key, String ... args) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        String string2 = this.currentLanguage.getOrNull(key);
        if (string2 != null) {
            String it = string2;
            boolean bl2 = false;
            String[] stringArray = Arrays.copyOf(args, args.length);
            String string3 = String.format(it, Arrays.copyOf(stringArray, stringArray.length));
            string = string3;
            Intrinsics.checkNotNullExpressionValue(string3, "format(...)");
        } else {
            string = null;
        }
        return string;
    }

    @NotNull
    public final String get(@NotNull String key, String ... args) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        String string = this.getOrNull(key, Arrays.copyOf(args, args.length));
        if (string == null) {
            string = "";
        }
        return string;
    }

    public final boolean switch(@NotNull String str) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(str, "str");
        Language language = this.languages.get(str);
        if (language != null) {
            Language language2;
            Language it = language2 = language;
            boolean bl3 = false;
            this.currentLanguage = it;
            Language it2 = language2;
            boolean bl4 = false;
            bl2 = true;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @JvmOverloads
    public final boolean unpackDefaultLanguages() {
        return LanguageManager.unpackDefaultLanguages$default(this, false, 1, null);
    }

    @JvmOverloads
    public final boolean reloadLanguages() {
        return LanguageManager.reloadLanguages$default(this, false, 1, null);
    }

    static {
        String[] stringArray = new String[]{LANGUAGE_DEFAULT};
        LANGUAGES_LIST = stringArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2={"Lnet/ccbluex/liquidbounce/handler/language/LanguageManager$Companion;", "", "<init>", "()V", "LANGUAGE_DEFAULT", "", "LANGUAGES_LIST", "", "getLANGUAGES_LIST", "()[Ljava/lang/String;", "[Ljava/lang/String;", "DarkMeow"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String[] getLANGUAGES_LIST() {
            return LANGUAGES_LIST;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

