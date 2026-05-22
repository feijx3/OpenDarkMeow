/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.FastServiceLoaderKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u00a2\u0006\u0002\b\tJ!\u0010\n\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u0005H\u0082\bJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0007\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J/\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0007\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\b\u0014J1\u0010\u0015\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0002\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J,\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002H\u001c0\u001fH\u0082\b\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "<init>", "()V", "PREFIX", "", "loadMainDispatcherFactory", "", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "loadMainDispatcherFactory$kotlinx_coroutines_core", "createInstanceOf", "baseClass", "Ljava/lang/Class;", "serviceClass", "load", "S", "service", "loader", "Ljava/lang/ClassLoader;", "loadProviders", "loadProviders$kotlinx_coroutines_core", "getProviderInstance", "name", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "parse", "url", "Ljava/net/URL;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "parseFile", "r", "Ljava/io/BufferedReader;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,169:1\n85#1,5:170\n85#1,5:175\n139#1,13:191\n1#2:180\n1368#3:181\n1454#3,5:182\n1557#3:187\n1628#3,3:188\n1069#4,2:204\n*S KotlinDebug\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n*L\n62#1:170,5\n69#1:175,5\n125#1:191,13\n107#1:181\n107#1:182,5\n109#1:187\n109#1:188,3\n161#1:204,2\n*E\n"})
public final class FastServiceLoader {
    @NotNull
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();
    @NotNull
    private static final String PREFIX = "META-INF/services/";

    private FastServiceLoader() {
    }

    @NotNull
    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        List<MainDispatcherFactory> list;
        Class<MainDispatcherFactory> clz = MainDispatcherFactory.class;
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return this.load(clz, clz.getClassLoader());
        }
        try {
            MainDispatcherFactory mainDispatcherFactory;
            Object clz$iv;
            ArrayList<Object> result = new ArrayList<Object>(2);
            FastServiceLoader fastServiceLoader = this;
            Object serviceClass$iv = "kotlinx.coroutines.android.AndroidDispatcherFactory";
            boolean $i$f$createInstanceOf = false;
            try {
                clz$iv = Class.forName((String)serviceClass$iv, true, clz.getClassLoader());
                clz$iv = (MainDispatcherFactory)clz.cast(((Class)clz$iv).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            catch (ClassNotFoundException classNotFoundException) {
                clz$iv = null;
            }
            Class<?> mainFactory = clz$iv;
            if (mainFactory == null) {
                return this.load(clz, clz.getClassLoader());
            }
            result.add(mainFactory);
            serviceClass$iv = this;
            String serviceClass$iv2 = "kotlinx.coroutines.test.internal.TestMainDispatcherFactory";
            boolean $i$f$createInstanceOf2 = false;
            try {
                Class<?> clz$iv2 = Class.forName(serviceClass$iv2, true, clz.getClassLoader());
                mainDispatcherFactory = (MainDispatcherFactory)clz.cast(clz$iv2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            catch (ClassNotFoundException classNotFoundException) {
                mainDispatcherFactory = null;
            }
            MainDispatcherFactory mainDispatcherFactory2 = mainDispatcherFactory;
            if (mainDispatcherFactory2 != null) {
                MainDispatcherFactory mainDispatcherFactory3;
                MainDispatcherFactory $this$loadMainDispatcherFactory_u24lambda_u240 = mainDispatcherFactory3 = mainDispatcherFactory2;
                boolean bl2 = false;
                result.add($this$loadMainDispatcherFactory_u24lambda_u240);
            }
        }
        catch (Throwable throwable) {
            list = this.load(clz, clz.getClassLoader());
        }
        return list;
    }

    private final MainDispatcherFactory createInstanceOf(Class<MainDispatcherFactory> baseClass, String serviceClass) {
        MainDispatcherFactory mainDispatcherFactory;
        boolean $i$f$createInstanceOf = false;
        try {
            Class<?> clz = Class.forName(serviceClass, true, baseClass.getClassLoader());
            mainDispatcherFactory = baseClass.cast(clz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (ClassNotFoundException classNotFoundException) {
            mainDispatcherFactory = null;
        }
        return mainDispatcherFactory;
    }

    private final <S> List<S> load(Class<S> service, ClassLoader loader) {
        List<Object> list;
        try {
            list = this.loadProviders$kotlinx_coroutines_core(service, loader);
        }
        catch (Throwable throwable) {
            list = CollectionsKt.toList((Iterable)ServiceLoader.load(service, loader));
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <S> List<S> loadProviders$kotlinx_coroutines_core(@NotNull Class<S> service, @NotNull ClassLoader loader) {
        void $this$mapTo$iv$iv;
        Object list$iv$iv;
        URL it;
        Iterable $this$flatMapTo$iv$iv;
        void $this$flatMap$iv;
        String fullServiceName = PREFIX + service.getName();
        Enumeration<URL> urls = loader.getResources(fullServiceName);
        ArrayList<URL> arrayList = Collections.list(urls);
        Intrinsics.checkNotNullExpressionValue(arrayList, "list(...)");
        Iterable iterable = arrayList;
        boolean $i$f$flatMap = false;
        void var8_8 = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            it = (URL)element$iv$iv;
            boolean bl2 = false;
            list$iv$iv = INSTANCE.parse(it);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Set providers = CollectionsKt.toSet((List)destination$iv$iv);
        if (!(!((Collection)providers).isEmpty())) {
            boolean $i$a$-require-FastServiceLoader$loadProviders$22 = false;
            String $i$a$-require-FastServiceLoader$loadProviders$22 = "No providers were loaded with FastServiceLoader";
            throw new IllegalArgumentException($i$a$-require-FastServiceLoader$loadProviders$22.toString());
        }
        Iterable $this$map$iv = providers;
        boolean $i$f$map = false;
        $this$flatMapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            list$iv$iv = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl3 = false;
            collection.add(INSTANCE.getProviderInstance((String)((Object)it), loader, service));
        }
        return (List)destination$iv$iv;
    }

    private final <S> S getProviderInstance(String name, ClassLoader loader, Class<S> service) {
        Class<?> clazz = Class.forName(name, false, loader);
        if (!service.isAssignableFrom(clazz)) {
            boolean bl2 = false;
            String string = "Expected service of class " + service + ", but found " + clazz;
            throw new IllegalArgumentException(string.toString());
        }
        return service.cast(clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    private final List<String> parse(URL url) {
        List<String> list;
        String path = url.toString();
        if (StringsKt.startsWith$default(path, "jar", false, 2, null)) {
            String pathToJar = StringsKt.substringBefore$default(StringsKt.substringAfter$default(path, "jar:file:", null, 2, null), '!', null, 2, null);
            String entry = StringsKt.substringAfter$default(path, "!/", null, 2, null);
            FastServiceLoader fastServiceLoader = this;
            JarFile $this$use$iv = new JarFile(pathToJar, false);
            boolean $i$f$use = false;
            Throwable cause$iv = null;
            JarFile file = $this$use$iv;
            boolean bl2 = false;
            Closeable closeable = new BufferedReader(new InputStreamReader(file.getInputStream(new ZipEntry(entry)), "UTF-8"));
            Throwable throwable = null;
            BufferedReader r2 = (BufferedReader)closeable;
            boolean bl3 = false;
            List<String> list2 = INSTANCE.parseFile(r2);
            CloseableKt.closeFinally(closeable, throwable);
            List<String> list3 = list2;
            $this$use$iv.close();
            return list3;
            {
                catch (Throwable throwable2) {
                    try {
                        try {
                            try {
                                throwable = throwable2;
                                throw throwable2;
                            }
                            catch (Throwable throwable3) {
                                CloseableKt.closeFinally(closeable, throwable);
                                throw throwable3;
                            }
                        }
                        catch (Throwable e$iv) {
                            cause$iv = e$iv;
                            throw e$iv;
                        }
                    }
                    catch (Throwable throwable4) {
                        try {
                            $this$use$iv.close();
                        }
                        catch (Throwable closeException$iv) {
                            if (cause$iv == null) {
                                throw closeException$iv;
                            }
                            ExceptionsKt.addSuppressed(cause$iv, closeException$iv);
                            throw cause$iv;
                        }
                        throw throwable4;
                    }
                }
            }
        }
        Closeable closeable = new BufferedReader(new InputStreamReader(url.openStream()));
        Throwable throwable = null;
        try {
            BufferedReader reader = (BufferedReader)closeable;
            boolean bl4 = false;
            list = INSTANCE.parseFile(reader);
        }
        catch (Throwable throwable5) {
            throwable = throwable5;
            throw throwable5;
        }
        finally {
            CloseableKt.closeFinally(closeable, throwable);
        }
        return list;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final <R> R use(JarFile $this$use, Function1<? super JarFile, ? extends R> block) {
        R r2;
        boolean $i$f$use = false;
        Throwable cause = null;
        try {
            r2 = block.invoke($this$use);
        }
        catch (Throwable e2) {
            try {
                cause = e2;
                throw e2;
            }
            catch (Throwable throwable) {
                InlineMarker.finallyStart(1);
                try {
                    $this$use.close();
                }
                catch (Throwable closeException) {
                    if (cause == null) {
                        throw closeException;
                    }
                    ExceptionsKt.addSuppressed(cause, closeException);
                    throw cause;
                }
                InlineMarker.finallyEnd(1);
                throw throwable;
            }
        }
        InlineMarker.finallyStart(1);
        $this$use.close();
        InlineMarker.finallyEnd(1);
        return r2;
    }

    private final List<String> parseFile(BufferedReader r2) {
        Set names = new LinkedHashSet();
        while (r2.readLine() != null) {
            boolean bl2;
            String serviceName;
            block3: {
                String line;
                serviceName = ((Object)StringsKt.trim((CharSequence)StringsKt.substringBefore$default(line, "#", null, 2, null))).toString();
                CharSequence $this$all$iv = serviceName;
                boolean $i$f$all = false;
                for (int i2 = 0; i2 < $this$all$iv.length(); ++i2) {
                    char element$iv;
                    char it = element$iv = $this$all$iv.charAt(i2);
                    boolean bl3 = false;
                    if (it == '.' || Character.isJavaIdentifierPart(it)) continue;
                    bl2 = false;
                    break block3;
                }
                bl2 = true;
            }
            if (!bl2) {
                boolean bl4 = false;
                String string = "Illegal service provider class name: " + serviceName;
                throw new IllegalArgumentException(string.toString());
            }
            if (!(((CharSequence)serviceName).length() > 0)) continue;
            names.add(serviceName);
        }
        return CollectionsKt.toList(names);
    }
}

