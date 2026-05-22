/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilePathComponents;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=5, xi=49, d1={"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u00a2\u0006\u0002\b\u0003\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0005H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0000\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00058@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00058@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0013"}, d2={"getRootLength", "", "", "getRootLength$FilesKt__FilePathComponentsKt", "rootName", "Ljava/io/File;", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "isRooted", "", "(Ljava/io/File;)Z", "toComponents", "Lkotlin/io/FilePathComponents;", "subPath", "beginIndex", "endIndex", "kotlin-stdlib"}, xs="kotlin/io/FilesKt")
@SourceDebugExtension(value={"SMAP\nFilePathComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,149:1\n1563#2:150\n1634#2,3:151\n*S KotlinDebug\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n*L\n134#1:150\n134#1:151,3\n*E\n"})
class FilesKt__FilePathComponentsKt {
    private static final int getRootLength$FilesKt__FilePathComponentsKt(String $this$getRootLength) {
        int first = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, 0, false, 4, null);
        if (first == 0) {
            if ($this$getRootLength.length() > 1 && $this$getRootLength.charAt(1) == File.separatorChar && (first = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, 2, false, 4, null)) >= 0) {
                if ((first = StringsKt.indexOf$default((CharSequence)$this$getRootLength, File.separatorChar, first + 1, false, 4, null)) >= 0) {
                    return first + 1;
                }
                return $this$getRootLength.length();
            }
            return 1;
        }
        if (first > 0 && $this$getRootLength.charAt(first - 1) == ':') {
            return ++first;
        }
        if (first == -1 && StringsKt.endsWith$default((CharSequence)$this$getRootLength, ':', false, 2, null)) {
            return $this$getRootLength.length();
        }
        return 0;
    }

    @NotNull
    public static final String getRootName(@NotNull File $this$rootName) {
        Intrinsics.checkNotNullParameter($this$rootName, "<this>");
        String string = $this$rootName.getPath();
        Intrinsics.checkNotNullExpressionValue(string, "getPath(...)");
        String string2 = string;
        int n2 = 0;
        String string3 = $this$rootName.getPath();
        Intrinsics.checkNotNullExpressionValue(string3, "getPath(...)");
        int n3 = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(string3);
        String string4 = string2.substring(n2, n3);
        Intrinsics.checkNotNullExpressionValue(string4, "substring(...)");
        return string4;
    }

    @NotNull
    public static final File getRoot(@NotNull File $this$root) {
        Intrinsics.checkNotNullParameter($this$root, "<this>");
        return new File(FilesKt.getRootName($this$root));
    }

    public static final boolean isRooted(@NotNull File $this$isRooted) {
        Intrinsics.checkNotNullParameter($this$isRooted, "<this>");
        String string = $this$isRooted.getPath();
        Intrinsics.checkNotNullExpressionValue(string, "getPath(...)");
        return FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(string) > 0;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final FilePathComponents toComponents(@NotNull File $this$toComponents) {
        List list;
        Intrinsics.checkNotNullParameter($this$toComponents, "<this>");
        String path = $this$toComponents.getPath();
        Intrinsics.checkNotNull(path);
        int rootLength = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(path);
        String string = path;
        int n2 = 0;
        String string2 = string.substring(n2, rootLength);
        Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
        String rootName = string2;
        String string3 = path.substring(rootLength);
        Intrinsics.checkNotNullExpressionValue(string3, "substring(...)");
        String subPath = string3;
        if (((CharSequence)subPath).length() == 0) {
            list = CollectionsKt.emptyList();
        } else {
            void $this$mapTo$iv$iv;
            char[] cArray = new char[]{File.separatorChar};
            Iterable $this$map$iv = StringsKt.split$default((CharSequence)subPath, cArray, false, 0, 6, null);
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void p0;
                String string4 = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl2 = false;
                collection.add(new File((String)p0));
            }
            list = (List)destination$iv$iv;
        }
        List list2 = list;
        return new FilePathComponents(new File(rootName), list2);
    }

    @NotNull
    public static final File subPath(@NotNull File $this$subPath, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$subPath, "<this>");
        return FilesKt.toComponents($this$subPath).subPath(beginIndex, endIndex);
    }
}

