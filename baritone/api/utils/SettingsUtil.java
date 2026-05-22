/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ain
 *  aow
 *  bib
 *  fa
 *  fq
 *  nf
 */
package baritone.api.utils;

import baritone.api.BaritoneAPI;
import baritone.api.Settings;
import baritone.api.utils.BlockUtils;
import baritone.api.utils.Helper;
import baritone.api.utils.TypeUtils;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SettingsUtil {
    public static final String SETTINGS_DEFAULT_NAME = "settings.txt";
    private static final Pattern SETTING_PATTERN = Pattern.compile("^(?<setting>[^ ]+) +(?<value>.+)");

    private static boolean isComment(String string) {
        return string.startsWith("#") || string.startsWith("//");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void forEachLine(Path object, Consumer<String> consumer) {
        object = Files.newBufferedReader((Path)object);
        Throwable throwable = null;
        try {
            String string;
            while ((string = ((BufferedReader)object).readLine()) != null) {
                if (string.isEmpty() || SettingsUtil.isComment(string)) continue;
                consumer.accept(string);
            }
            if (object == null) return;
        }
        catch (Throwable throwable2) {
            try {
                Throwable throwable3 = throwable2;
                throwable = throwable2;
                throw throwable3;
            }
            catch (Throwable throwable4) {
                if (object == null) throw throwable4;
                if (throwable != null) {
                    try {
                        ((BufferedReader)object).close();
                        throw throwable4;
                    }
                    catch (Throwable throwable5) {
                        throwable.addSuppressed(throwable5);
                    }
                    throw throwable4;
                } else {
                    ((BufferedReader)object).close();
                }
                throw throwable4;
            }
        }
        ((BufferedReader)object).close();
        return;
    }

    public static void readAndApply(Settings settings, String string2) {
        try {
            SettingsUtil.forEachLine(SettingsUtil.settingsByName(string2), string -> {
                Object object = SETTING_PATTERN.matcher((CharSequence)string);
                if (!((Matcher)object).matches()) {
                    Helper.HELPER.logDirect("Invalid syntax in setting file: ".concat(String.valueOf(string)));
                    return;
                }
                String string2 = ((Matcher)object).group("setting").toLowerCase();
                object = ((Matcher)object).group("value");
                try {
                    SettingsUtil.parseAndApply(settings, string2, (String)object);
                    return;
                }
                catch (Exception exception) {
                    Helper.HELPER.logDirect("Unable to parse line ".concat(String.valueOf(string)));
                    exception.printStackTrace();
                    return;
                }
            });
            return;
        }
        catch (NoSuchFileException noSuchFileException) {
            Helper.HELPER.logDirect("Baritone settings file not found, resetting.");
            return;
        }
        catch (Exception exception) {
            Helper.HELPER.logDirect("Exception while reading Baritone settings, some settings may be reset to default values!");
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static synchronized void save(Settings object) {
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(SettingsUtil.settingsByName(SETTINGS_DEFAULT_NAME), new OpenOption[0]);
            Throwable throwable = null;
            try {
                for (Settings.Setting setting : SettingsUtil.modifiedSettings((Settings)object)) {
                    bufferedWriter.write(SettingsUtil.settingToString(setting) + "\n");
                }
                if (bufferedWriter == null) return;
            }
            catch (Throwable throwable2) {
                try {
                    object = throwable2;
                    throwable = throwable2;
                    throw object;
                }
                catch (Throwable throwable3) {
                    if (bufferedWriter == null) throw throwable3;
                    if (throwable != null) {
                        try {
                            bufferedWriter.close();
                            throw throwable3;
                        }
                        catch (Throwable throwable4) {
                            throwable.addSuppressed(throwable4);
                        }
                        throw throwable3;
                    } else {
                        bufferedWriter.close();
                    }
                    throw throwable3;
                }
            }
            bufferedWriter.close();
            return;
        }
        catch (Exception exception) {
            Helper.HELPER.logDirect("Exception thrown while saving Baritone settings!");
            exception.printStackTrace();
            return;
        }
    }

    private static Path settingsByName(String string) {
        return bib.z().w.toPath().resolve("baritone").resolve(string);
    }

    public static List<Settings.Setting> modifiedSettings(Settings object) {
        ArrayList<Settings.Setting> arrayList = new ArrayList<Settings.Setting>();
        for (Settings.Setting<?> setting : ((Settings)((Object)object)).allSettings) {
            if (setting.value == null) {
                System.out.println("NULL SETTING?" + setting.getName());
                continue;
            }
            if (setting.isJavaOnly() || setting.value == setting.defaultValue) continue;
            arrayList.add(setting);
        }
        return arrayList;
    }

    public static String settingTypeToString(Settings.Setting setting) {
        return setting.getType().getTypeName().replaceAll("(?:\\w+\\.)+(\\w+)", "$1");
    }

    public static <T> String settingValueToString(Settings.Setting<T> setting, T t2) {
        Parser parser = Parser.getParser(setting.getType());
        if (parser == null) {
            throw new IllegalStateException("Missing " + setting.getValueClass() + " " + setting.getName());
        }
        return parser.toString(new ParserContext(setting), (Object)t2);
    }

    public static String settingValueToString(Settings.Setting setting) {
        Settings.Setting setting2 = setting;
        return SettingsUtil.settingValueToString(setting2, setting2.value);
    }

    public static String settingDefaultToString(Settings.Setting setting) {
        Settings.Setting setting2 = setting;
        return SettingsUtil.settingValueToString(setting2, setting2.defaultValue);
    }

    public static String maybeCensor(int n2) {
        if (((Boolean)BaritoneAPI.getSettings().censorCoordinates.value).booleanValue()) {
            return "<censored>";
        }
        return Integer.toString(n2);
    }

    public static String settingToString(Settings.Setting setting) {
        if (setting.isJavaOnly()) {
            return setting.getName();
        }
        return setting.getName() + " " + SettingsUtil.settingValueToString(setting);
    }

    @Deprecated
    public static boolean javaOnlySetting(Settings.Setting setting) {
        return setting.isJavaOnly();
    }

    public static void parseAndApply(Settings setting, String clazz, String string) {
        Parser parser;
        setting = ((Settings)((Object)setting)).byLowerName.get(clazz);
        if (setting == null) {
            throw new IllegalStateException("No setting by that name");
        }
        clazz = setting.getValueClass();
        if (!clazz.isInstance(string = (parser = Parser.getParser(setting.getType())).parse(new ParserContext(setting), string))) {
            throw new IllegalStateException(parser + " parser returned incorrect type, expected " + clazz + " got " + string + " which is " + string.getClass());
        }
        setting.value = string;
    }

    static enum Parser implements ISettingParser
    {
        DOUBLE(Double.class, Double::parseDouble),
        BOOLEAN(Boolean.class, Boolean::parseBoolean),
        INTEGER(Integer.class, Integer::parseInt),
        FLOAT(Float.class, Float::parseFloat),
        LONG(Long.class, Long::parseLong),
        STRING(String.class, String::new),
        ENUMFACING(fa.class, fa::a),
        COLOR(Color.class, string -> new Color(Integer.parseInt(string.split(",")[0]), Integer.parseInt(string.split(",")[1]), Integer.parseInt(string.split(",")[2])), color -> color.getRed() + "," + color.getGreen() + "," + color.getBlue()),
        VEC3I(fq.class, string -> new fq(Integer.parseInt(string.split(",")[0]), Integer.parseInt(string.split(",")[1]), Integer.parseInt(string.split(",")[2])), fq2 -> fq2.p() + "," + fq2.q() + "," + fq2.r()),
        BLOCK(aow.class, string -> BlockUtils.stringToBlockRequired(string.trim()), BlockUtils::blockToString),
        ITEM(ain.class, string -> ain.b((String)string.trim()), ain2 -> ((nf)ain.g.b(ain2)).toString()),
        LIST{

            @Override
            public final Object parse(ParserContext parserContext, String string2) {
                Parser parser = Parser.getParser(((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0]);
                return Stream.of(string2.split(",")).map(string -> parser.parse(parserContext, (String)string)).collect(Collectors.toList());
            }

            @Override
            public final String toString(ParserContext parserContext, Object object2) {
                Parser parser = Parser.getParser(((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0]);
                return ((List)object2).stream().map(object -> parser.toString(parserContext, object)).collect(Collectors.joining(","));
            }

            @Override
            public final boolean accepts(Type type) {
                return List.class.isAssignableFrom(TypeUtils.resolveBaseClass(type));
            }
        }
        ,
        MAPPING{

            @Override
            public final Object parse(ParserContext parserContext, String string2) {
                Object object = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0];
                Object object2 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[1];
                object = Parser.getParser((Type)object);
                object2 = Parser.getParser((Type)object2);
                return Stream.of(string2.split(",(?=[^,]*->)")).map(string -> string.split("->")).collect(Collectors.toMap(arg_0 -> 2.lambda$parse$1((Parser)object, parserContext, arg_0), arg_0 -> 2.lambda$parse$2((Parser)object2, parserContext, arg_0)));
            }

            @Override
            public final String toString(ParserContext parserContext, Object object) {
                Object object2 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0];
                Object object3 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[1];
                object2 = Parser.getParser((Type)object2);
                object3 = Parser.getParser((Type)object3);
                return ((Map)object).entrySet().stream().map(arg_0 -> 2.lambda$toString$3((Parser)object2, parserContext, (Parser)object3, arg_0)).collect(Collectors.joining(","));
            }

            @Override
            public final boolean accepts(Type type) {
                return Map.class.isAssignableFrom(TypeUtils.resolveBaseClass(type));
            }

            private static /* synthetic */ String lambda$toString$3(Parser parser, ParserContext parserContext, Parser parser2, Map.Entry entry) {
                return parser.toString(parserContext, entry.getKey()) + "->" + parser2.toString(parserContext, entry.getValue());
            }

            private static /* synthetic */ Object lambda$parse$2(Parser parser, ParserContext parserContext, String[] stringArray) {
                return parser.parse(parserContext, stringArray[1]);
            }

            private static /* synthetic */ Object lambda$parse$1(Parser parser, ParserContext parserContext, String[] stringArray) {
                return parser.parse(parserContext, stringArray[0]);
            }
        };

        private final Class<?> cla$$;
        private final Function<String, Object> parser;
        private final Function<Object, String> toString;

        private Parser() {
            this.cla$$ = null;
            this.parser = null;
            this.toString = null;
        }

        private <T> Parser(Class<T> clazz, Function<String, T> function) {
            this(clazz, function, Object::toString);
        }

        private <T> Parser(Class<T> clazz, Function<String, T> function, Function<T, String> function2) {
            this.cla$$ = clazz;
            this.parser = function::apply;
            this.toString = object -> (String)function2.apply(object);
        }

        public Object parse(ParserContext object, String string) {
            object = this.parser.apply(string);
            Objects.requireNonNull(object);
            return object;
        }

        public String toString(ParserContext parserContext, Object object) {
            return this.toString.apply(object);
        }

        @Override
        public boolean accepts(Type type) {
            return type instanceof Class && this.cla$$.isAssignableFrom((Class)type);
        }

        public static Parser getParser(Type type) {
            return Stream.of(Parser.values()).filter(parser -> parser.accepts(type)).findFirst().orElse(null);
        }
    }

    static class ParserContext {
        private final Settings.Setting<?> setting;

        private ParserContext(Settings.Setting<?> setting) {
            this.setting = setting;
        }

        private Settings.Setting<?> getSetting() {
            return this.setting;
        }
    }

    static interface ISettingParser<T> {
        public T parse(ParserContext var1, String var2);

        public String toString(ParserContext var1, T var2);

        public boolean accepts(Type var1);
    }
}

