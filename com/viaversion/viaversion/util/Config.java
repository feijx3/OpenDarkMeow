/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.qual.Nullable
 *  xyz.wagyourtail.jvmdg.j11.NestHost
 *  xyz.wagyourtail.jvmdg.j11.NestMembers
 */
package com.viaversion.viaversion.util;

import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.snakeyaml.DumperOptions;
import com.viaversion.viaversion.libs.snakeyaml.LoaderOptions;
import com.viaversion.viaversion.libs.snakeyaml.Yaml;
import com.viaversion.viaversion.libs.snakeyaml.constructor.SafeConstructor;
import com.viaversion.viaversion.libs.snakeyaml.nodes.NodeId;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Tag;
import com.viaversion.viaversion.libs.snakeyaml.representer.Representer;
import com.viaversion.viaversion.util.CommentStore;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.InputStreamSupplier;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;
import xyz.wagyourtail.jvmdg.j11.NestHost;
import xyz.wagyourtail.jvmdg.j11.NestMembers;

@NestMembers(value={CustomSafeConstructor.class})
public abstract class Config {
    private static final ThreadLocal<Yaml> YAML = ThreadLocal.withInitial(() -> {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(false);
        options.setIndent(2);
        return new Yaml(new CustomSafeConstructor(), new Representer(options), options);
    });
    private final CommentStore commentStore = new CommentStore('.', 2);
    private final File configFile;
    protected final Logger logger;
    private Map<String, Object> config;

    protected Config(File configFile, Logger logger) {
        this.configFile = configFile;
        this.logger = logger;
    }

    public URL getDefaultConfigURL() {
        return this.getClass().getClassLoader().getResource("assets/viaversion/config.yml");
    }

    public InputStream getDefaultConfigInputStream() {
        return this.getClass().getClassLoader().getResourceAsStream("assets/viaversion/config.yml");
    }

    public Map<String, Object> loadConfig(File location) {
        URL defaultConfigUrl = this.getDefaultConfigURL();
        if (defaultConfigUrl != null) {
            return this.loadConfig(location, defaultConfigUrl);
        }
        return this.loadConfig(location, this::getDefaultConfigInputStream);
    }

    public synchronized Map<String, Object> loadConfig(File location, URL jarConfigFile) {
        return this.loadConfig(location, jarConfigFile::openStream);
    }

    private synchronized Map<String, Object> loadConfig(File location, InputStreamSupplier configSupplier) {
        Map mergedConfig;
        List<String> unsupported = this.getUnsupportedOptions();
        try (InputStream inputStream = configSupplier.get();){
            this.commentStore.storeComments(inputStream);
            for (String option : unsupported) {
                List<String> list = this.commentStore.header(option);
                if (list == null) continue;
                list.clear();
            }
        }
        catch (IOException e2) {
            throw new RuntimeException("Failed to load default config comments", e2);
        }
        Map config = null;
        if (location.exists()) {
            try (FileInputStream input = new FileInputStream(location);){
                config = (Map)YAML.get().load(input);
            }
            catch (IOException e3) {
                throw new RuntimeException("Failed to load config", e3);
            }
            catch (Exception e4) {
                this.logger.severe("Failed to load config, make sure your input is valid");
                throw new RuntimeException("Failed to load config (malformed input?)", e4);
            }
        }
        if (config == null) {
            config = new HashMap();
        }
        try (InputStream stream = configSupplier.get();){
            mergedConfig = (Map)YAML.get().load(stream);
        }
        catch (IOException e5) {
            throw new RuntimeException("Failed to load default config", e5);
        }
        for (String string : unsupported) {
            mergedConfig.remove(string);
        }
        for (Map.Entry entry : config.entrySet()) {
            mergedConfig.computeIfPresent((String)entry.getKey(), (key, value) -> entry.getValue());
        }
        this.handleConfig(mergedConfig);
        this.save(location, mergedConfig);
        return mergedConfig;
    }

    protected abstract void handleConfig(Map<String, Object> var1);

    public synchronized void save(File location, Map<String, Object> config) {
        try {
            this.commentStore.writeComments(YAML.get().dump(config), location);
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public abstract List<String> getUnsupportedOptions();

    public void set(String path, Object value) {
        this.config.put(path, value);
    }

    public void save() {
        if (this.configFile.getParentFile() != null) {
            this.configFile.getParentFile().mkdirs();
        }
        this.save(this.configFile, this.config);
    }

    public void save(File file) {
        this.save(file, this.config);
    }

    public void reload() {
        if (this.configFile.getParentFile() != null) {
            this.configFile.getParentFile().mkdirs();
        }
        this.config = new ConcurrentSkipListMap<String, Object>(this.loadConfig(this.configFile));
    }

    public Map<String, Object> getValues() {
        return this.config;
    }

    public <T> @Nullable T get(String key, T def) {
        Object o2 = this.config.get(key);
        if (o2 != null) {
            return (T)o2;
        }
        return def;
    }

    public boolean getBoolean(String key, boolean def) {
        Object o2 = this.config.get(key);
        if (o2 instanceof Boolean) {
            return (Boolean)o2;
        }
        return def;
    }

    public @Nullable String getString(String key, @Nullable String def) {
        Object o2 = this.config.get(key);
        if (o2 instanceof String) {
            return (String)o2;
        }
        return def;
    }

    public int getInt(String key, int def) {
        Object o2 = this.config.get(key);
        if (o2 instanceof Number) {
            return ((Number)o2).intValue();
        }
        return def;
    }

    public double getDouble(String key, double def) {
        Object o2 = this.config.get(key);
        if (o2 instanceof Number) {
            return ((Number)o2).doubleValue();
        }
        return def;
    }

    public List<Integer> getIntegerList(String key) {
        Object o2 = this.config.get(key);
        return o2 != null ? (List)o2 : new ArrayList();
    }

    public List<String> getStringList(String key) {
        Object o2 = this.config.get(key);
        return o2 != null ? (List)o2 : new ArrayList();
    }

    public <T> List<T> getListSafe(String key, Class<T> type, String invalidValueMessage) {
        Object o2 = this.config.get(key);
        if (o2 instanceof List) {
            List list = (List)o2;
            ArrayList<T> filteredValues = new ArrayList<T>();
            for (Object o1 : list) {
                if (type.isInstance(o1)) {
                    filteredValues.add(type.cast(o1));
                    continue;
                }
                if (invalidValueMessage == null) continue;
                this.logger.warning(String.format(invalidValueMessage, o1));
            }
            return filteredValues;
        }
        return new ArrayList();
    }

    public @Nullable JsonElement getSerializedComponent(String key) {
        Object o2 = this.config.get(key);
        if (o2 != null && !((String)o2).isEmpty()) {
            return ComponentUtil.legacyToJson((String)o2);
        }
        return null;
    }

    @NestHost(value=Config.class)
    private static final class CustomSafeConstructor
    extends SafeConstructor {
        public CustomSafeConstructor() {
            super(new LoaderOptions());
            this.yamlClassConstructors.put(NodeId.mapping, new SafeConstructor.ConstructYamlMap());
            this.yamlConstructors.put(Tag.OMAP, new SafeConstructor.ConstructYamlOmap());
        }
    }
}

