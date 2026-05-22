/*
 * Decompiled with CFR 0.152.
 */
package com.twelvemonkeys.lang;

import com.twelvemonkeys.util.StringTokenIterator;
import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class StringUtil {
    public static final String DELIMITER_STRING = ", \t\n\r\f";

    private StringUtil() {
    }

    public static String decode(byte[] byArray, int n2, int n3, String string) {
        try {
            return new String(byArray, n2, n3, string);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new UnsupportedCharsetException(string);
        }
    }

    public static String valueOf(Object object) {
        return object != null ? object.toString() : null;
    }

    public static String toUpperCase(String string) {
        if (string != null) {
            return string.toUpperCase();
        }
        return null;
    }

    public static String toLowerCase(String string) {
        if (string != null) {
            return string.toLowerCase();
        }
        return null;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    public static boolean isEmpty(String[] stringArray) {
        if (stringArray == null) {
            return true;
        }
        for (String string : stringArray) {
            if (StringUtil.isEmpty(string)) continue;
            return false;
        }
        return true;
    }

    public static boolean contains(String string, String string2) {
        return string != null && string2 != null && string.indexOf(string2) >= 0;
    }

    public static boolean containsIgnoreCase(String string, String string2) {
        return StringUtil.indexOfIgnoreCase(string, string2, 0) >= 0;
    }

    public static boolean contains(String string, int n2) {
        return string != null && string.indexOf(n2) >= 0;
    }

    public static boolean containsIgnoreCase(String string, int n2) {
        return string != null && (string.indexOf(Character.toLowerCase((char)n2)) >= 0 || string.indexOf(Character.toUpperCase((char)n2)) >= 0);
    }

    public static int indexOfIgnoreCase(String string, String string2) {
        return StringUtil.indexOfIgnoreCase(string, string2, 0);
    }

    public static int indexOfIgnoreCase(String string, String string2, int n2) {
        if (string == null || string2 == null) {
            return -1;
        }
        if (string2.length() == 0) {
            return n2;
        }
        if (string2.length() > string.length()) {
            return -1;
        }
        char c2 = Character.toLowerCase(string2.charAt(0));
        char c3 = Character.toUpperCase(string2.charAt(0));
        int n3 = 0;
        int n4 = 0;
        for (int i2 = n2; i2 <= string.length() - string2.length(); ++i2) {
            n3 = n3 >= 0 && n3 <= i2 ? string.indexOf(c2, i2) : n3;
            int n5 = n4 = n4 >= 0 && n4 <= i2 ? string.indexOf(c3, i2) : n4;
            if (n3 < 0) {
                if (n4 < 0) {
                    return -1;
                }
                i2 = n4;
            } else if (n4 < 0) {
                i2 = n3;
            } else {
                int n6 = i2 = n3 < n4 ? n3 : n4;
            }
            if (string2.length() == 1) {
                return i2;
            }
            if (i2 > string.length() - string2.length()) {
                return -1;
            }
            if (string.charAt(i2 + string2.length() - 1) != Character.toLowerCase(string2.charAt(string2.length() - 1)) && string.charAt(i2 + string2.length() - 1) != Character.toUpperCase(string2.charAt(string2.length() - 1)) || string2.length() > 2 && !string.regionMatches(true, i2 + 1, string2, 1, string2.length() - 2)) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOfIgnoreCase(String string, String string2) {
        return StringUtil.lastIndexOfIgnoreCase(string, string2, string != null ? string.length() - 1 : -1);
    }

    public static int lastIndexOfIgnoreCase(String string, String string2, int n2) {
        if (string == null || string2 == null) {
            return -1;
        }
        if (string2.length() == 0) {
            return n2;
        }
        if (string2.length() > string.length()) {
            return -1;
        }
        char c2 = Character.toLowerCase(string2.charAt(0));
        char c3 = Character.toUpperCase(string2.charAt(0));
        int n3 = n2;
        int n4 = n2;
        for (int i2 = n2; i2 >= 0; --i2) {
            n3 = n3 >= 0 && n3 >= i2 ? string.lastIndexOf(c2, i2) : n3;
            int n5 = n4 = n4 >= 0 && n4 >= i2 ? string.lastIndexOf(c3, i2) : n4;
            if (n3 < 0) {
                if (n4 < 0) {
                    return -1;
                }
                i2 = n4;
            } else if (n4 < 0) {
                i2 = n3;
            } else {
                int n6 = i2 = n3 > n4 ? n3 : n4;
            }
            if (string2.length() == 1) {
                return i2;
            }
            if (i2 > string.length() - string2.length() || string.charAt(i2 + string2.length() - 1) != Character.toLowerCase(string2.charAt(string2.length() - 1)) && string.charAt(i2 + string2.length() - 1) != Character.toUpperCase(string2.charAt(string2.length() - 1)) || string2.length() > 2 && !string.regionMatches(true, i2 + 1, string2, 1, string2.length() - 2)) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOfIgnoreCase(String string, int n2) {
        return StringUtil.indexOfIgnoreCase(string, n2, 0);
    }

    public static int indexOfIgnoreCase(String string, int n2, int n3) {
        if (string == null) {
            return -1;
        }
        char c2 = Character.toLowerCase((char)n2);
        char c3 = Character.toUpperCase((char)n2);
        int n4 = string.indexOf(c2, n3);
        int n5 = string.indexOf(c3, n3);
        if (n4 < 0) {
            return n5;
        }
        if (n5 < 0) {
            return n4;
        }
        return n4 < n5 ? n4 : n5;
    }

    public static int lastIndexOfIgnoreCase(String string, int n2) {
        return StringUtil.lastIndexOfIgnoreCase(string, n2, string != null ? string.length() : -1);
    }

    public static int lastIndexOfIgnoreCase(String string, int n2, int n3) {
        if (string == null) {
            return -1;
        }
        char c2 = Character.toLowerCase((char)n2);
        char c3 = Character.toUpperCase((char)n2);
        int n4 = string.lastIndexOf(c2, n3);
        int n5 = string.lastIndexOf(c3, n3);
        if (n4 < 0) {
            return n5;
        }
        if (n5 < 0) {
            return n4;
        }
        return n4 > n5 ? n4 : n5;
    }

    public static String ltrim(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            if (i2 == 0) {
                return string;
            }
            return string.substring(i2);
        }
        return "";
    }

    public static String rtrim(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        for (int i2 = string.length(); i2 > 0; --i2) {
            if (Character.isWhitespace(string.charAt(i2 - 1))) continue;
            if (i2 == string.length()) {
                return string;
            }
            return string.substring(0, i2);
        }
        return "";
    }

    public static String replace(String string, String string2, String string3) {
        int n2;
        if (string2.length() == 0) {
            return string;
        }
        int n3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((n2 = string.indexOf(string2, n3)) != -1) {
            stringBuilder.append(string.substring(n3, n2));
            stringBuilder.append(string3);
            n3 = n2 + string2.length();
        }
        stringBuilder.append(string.substring(n3));
        return stringBuilder.toString();
    }

    public static String replaceIgnoreCase(String string, String string2, String string3) {
        int n2;
        if (string2.length() == 0) {
            return string;
        }
        int n3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((n2 = StringUtil.indexOfIgnoreCase(string, string2, n3)) != -1) {
            stringBuilder.append(string.substring(n3, n2));
            stringBuilder.append(string3);
            n3 = n2 + string2.length();
        }
        stringBuilder.append(string.substring(n3));
        return stringBuilder.toString();
    }

    public static String cut(String string, int n2, String string2) {
        int n3;
        if (string == null) {
            return null;
        }
        if (string2 == null) {
            string2 = "";
        }
        if ((n3 = string.length()) <= n2) {
            return string;
        }
        n3 = string.lastIndexOf(32, n2 - string2.length());
        return string.substring(0, n3) + string2;
    }

    public static String capitalize(String string, int n2) {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("Negative index not allowed: " + n2);
        }
        if (string == null || string.length() <= n2) {
            return string;
        }
        if (Character.isUpperCase(string.charAt(n2))) {
            return string;
        }
        char[] cArray = string.toCharArray();
        cArray[n2] = Character.toUpperCase(cArray[n2]);
        return new String(cArray);
    }

    public static String capitalize(String string) {
        return StringUtil.capitalize(string, 0);
    }

    @Deprecated
    static String formatNumber(long l2, int n2) throws IllegalArgumentException {
        StringBuilder stringBuilder = new StringBuilder();
        if ((double)l2 >= Math.pow(10.0, n2)) {
            throw new IllegalArgumentException("The number to format cannot contain more digits than the length argument specifies!");
        }
        for (int i2 = n2; i2 > 1 && (double)l2 < Math.pow(10.0, i2 - 1); --i2) {
            stringBuilder.append('0');
        }
        stringBuilder.append(l2);
        return stringBuilder.toString();
    }

    public static String pad(String string, int n2, String string2, boolean bl2) {
        if (string2 == null || string2.length() == 0) {
            throw new IllegalArgumentException("Pad string: \"" + string2 + "\"");
        }
        if (string.length() >= n2) {
            return string;
        }
        int n3 = n2 - string.length();
        StringBuilder stringBuilder = new StringBuilder(string2);
        while (stringBuilder.length() < n3) {
            stringBuilder.append((CharSequence)stringBuilder);
        }
        if (stringBuilder.length() > n3) {
            stringBuilder.delete(n3, stringBuilder.length());
        }
        return bl2 ? stringBuilder.append(string).toString() : stringBuilder.insert(0, string).toString();
    }

    public static Date toDate(String string) {
        return StringUtil.toDate(string, DateFormat.getInstance());
    }

    public static Date toDate(String string, String string2) {
        return StringUtil.toDate(string, new SimpleDateFormat(string2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Date toDate(String string, DateFormat dateFormat) {
        try {
            DateFormat dateFormat2 = dateFormat;
            synchronized (dateFormat2) {
                return dateFormat.parse(string);
            }
        }
        catch (ParseException parseException) {
            throw new IllegalArgumentException(parseException.getMessage() + " at pos " + parseException.getErrorOffset());
        }
    }

    public static Timestamp toTimestamp(String string) {
        return Timestamp.valueOf(string);
    }

    public static String[] toStringArray(String string, String string2) {
        if (StringUtil.isEmpty(string)) {
            return new String[0];
        }
        StringTokenIterator stringTokenIterator = new StringTokenIterator(string, string2);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (stringTokenIterator.hasMoreElements()) {
            arrayList.add(stringTokenIterator.nextToken());
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] toStringArray(String string) {
        return StringUtil.toStringArray(string, DELIMITER_STRING);
    }

    public static int[] toIntArray(String string, String string2, int n2) {
        if (StringUtil.isEmpty(string)) {
            return new int[0];
        }
        String[] stringArray = StringUtil.toStringArray(string, string2);
        int[] nArray = new int[stringArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = Integer.parseInt(stringArray[i2], n2);
        }
        return nArray;
    }

    public static int[] toIntArray(String string) {
        return StringUtil.toIntArray(string, DELIMITER_STRING, 10);
    }

    public static int[] toIntArray(String string, String string2) {
        return StringUtil.toIntArray(string, string2, 10);
    }

    public static long[] toLongArray(String string, String string2) {
        if (StringUtil.isEmpty(string)) {
            return new long[0];
        }
        String[] stringArray = StringUtil.toStringArray(string, string2);
        long[] lArray = new long[stringArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            lArray[i2] = Long.parseLong(stringArray[i2]);
        }
        return lArray;
    }

    public static long[] toLongArray(String string) {
        return StringUtil.toLongArray(string, DELIMITER_STRING);
    }

    public static double[] toDoubleArray(String string, String string2) {
        if (StringUtil.isEmpty(string)) {
            return new double[0];
        }
        String[] stringArray = StringUtil.toStringArray(string, string2);
        double[] dArray = new double[stringArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = Double.valueOf(stringArray[i2]);
        }
        return dArray;
    }

    public static double[] toDoubleArray(String string) {
        return StringUtil.toDoubleArray(string, DELIMITER_STRING);
    }

    public static Color toColor(String string) {
        if (string == null) {
            return null;
        }
        if (string.charAt(0) == '#') {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            int n5 = -1;
            if (string.length() >= 7) {
                int n6 = 1;
                if (string.length() >= 9) {
                    n5 = Integer.parseInt(string.substring(n6, n6 + 2), 16);
                    n6 += 2;
                }
                n2 = Integer.parseInt(string.substring(n6, n6 + 2), 16);
                n3 = Integer.parseInt(string.substring(n6 + 2, n6 + 4), 16);
                n4 = Integer.parseInt(string.substring(n6 + 4, n6 + 6), 16);
            } else if (string.length() >= 4) {
                int n7 = 1;
                if (string.length() >= 5) {
                    n5 = Integer.parseInt(string.substring(n7++, n7), 16) * 16;
                }
                n2 = Integer.parseInt(string.substring(n7++, n7), 16) * 16;
                n3 = Integer.parseInt(string.substring(n7++, n7), 16) * 16;
                n4 = Integer.parseInt(string.substring(n7++, n7), 16) * 16;
            }
            if (n5 != -1) {
                return new Color(n2, n3, n4, n5);
            }
            return new Color(n2, n3, n4);
        }
        try {
            int n8;
            Class<Color> clazz = Color.class;
            Field field = null;
            try {
                field = clazz.getField(string);
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (field == null) {
                field = clazz.getField(string.toLowerCase());
            }
            if (Modifier.isPublic(n8 = field.getModifiers()) && Modifier.isStatic(n8)) {
                return (Color)field.get(null);
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new IllegalArgumentException("No such color: " + string);
        }
        catch (SecurityException securityException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        return null;
    }

    public static String toColorString(Color color) {
        if (color == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(color.getRGB()));
        for (int i2 = stringBuilder.length(); i2 < 8; ++i2) {
            stringBuilder.insert(0, '0');
        }
        if (stringBuilder.charAt(0) == 'f' && stringBuilder.charAt(1) == 'f') {
            stringBuilder.delete(0, 2);
        }
        return stringBuilder.insert(0, '#').toString();
    }

    public static boolean isNumber(String string) {
        if (StringUtil.isEmpty(string)) {
            return false;
        }
        char c2 = string.charAt(0);
        if (c2 != '-' && !Character.isDigit(c2)) {
            return false;
        }
        for (int i2 = 1; i2 < string.length(); ++i2) {
            if (Character.isDigit(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    static String ensureIncludesAt(String string, String string2, int n2) {
        StringBuilder stringBuilder = new StringBuilder(string);
        try {
            String string3 = string.substring(n2, n2 + string2.length());
            if (!string3.equalsIgnoreCase(string2)) {
                stringBuilder.insert(n2, string2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return stringBuilder.toString();
    }

    static String ensureExcludesAt(String string, String string2, int n2) {
        StringBuilder stringBuilder = new StringBuilder(string);
        try {
            String string3 = string.substring(n2 + 1, n2 + string2.length() + 1);
            if (!string3.equalsIgnoreCase(string2)) {
                stringBuilder.delete(n2, n2 + string2.length());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return stringBuilder.toString();
    }

    public static String substring(String string, String string2, String string3, int n2) {
        int n3 = n2 < 0 ? 0 : n2;
        int n4 = string.indexOf(string2, n3) + string2.length();
        if (n4 < 0) {
            return null;
        }
        int n5 = string.indexOf(string3, n4);
        if (n5 < 0) {
            return null;
        }
        return string.substring(n4, n5);
    }

    @Deprecated
    static String removeSubstring(String string, char c2, char c3, int n2) {
        char[] cArray;
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = false;
        for (char c4 : cArray = string.toCharArray()) {
            if (!bl2) {
                if (c4 == c2) {
                    bl2 = true;
                    continue;
                }
                stringBuilder.append(c4);
                continue;
            }
            if (c4 != c3) continue;
            bl2 = false;
        }
        return stringBuilder.toString();
    }

    static String removeSubstrings(String string, char c2, char c3) {
        char[] cArray;
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = false;
        for (char c4 : cArray = string.toCharArray()) {
            if (!bl2) {
                if (c4 == c2) {
                    bl2 = true;
                    continue;
                }
                stringBuilder.append(c4);
                continue;
            }
            if (c4 != c3) continue;
            bl2 = false;
        }
        return stringBuilder.toString();
    }

    public static String getFirstElement(String string, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("delimiter == null");
        }
        if (StringUtil.isEmpty(string)) {
            return string;
        }
        int n2 = string.indexOf(string2);
        if (n2 >= 0) {
            return string.substring(0, n2);
        }
        return string;
    }

    public static String getLastElement(String string, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("delimiter == null");
        }
        if (StringUtil.isEmpty(string)) {
            return string;
        }
        int n2 = string.lastIndexOf(string2);
        if (n2 >= 0) {
            return string.substring(n2 + 1);
        }
        return string;
    }

    public static String toCSVString(Object[] objectArray) {
        return StringUtil.toCSVString(objectArray, ", ");
    }

    public static String toCSVString(Object[] objectArray, String string) {
        if (objectArray == null) {
            return "";
        }
        if (string == null) {
            throw new IllegalArgumentException("delimiter == null");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(string);
            }
            stringBuilder.append(objectArray[i2]);
        }
        return stringBuilder.toString();
    }

    public static String deepToString(Object object) {
        return StringUtil.deepToString(object, false, 1);
    }

    public static String deepToString(Object object, boolean bl2, int n2) {
        if (object == null) {
            return null;
        }
        if (!bl2 && !StringUtil.isIdentityToString(object)) {
            return object.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (object.getClass().isArray()) {
            Class<?> clazz = object.getClass();
            while (clazz.isArray()) {
                stringBuilder.append('[');
                stringBuilder.append(Array.getLength(object));
                stringBuilder.append(']');
                clazz = clazz.getComponentType();
            }
            stringBuilder.insert(0, clazz);
            stringBuilder.append(" {hashCode=");
            stringBuilder.append(Integer.toHexString(object.hashCode()));
            stringBuilder.append("}");
        } else {
            Method[] methodArray;
            if (StringUtil.isIdentityToString(object)) {
                stringBuilder.append(" {");
            } else {
                stringBuilder.append(" {toString=");
                stringBuilder.append(object.toString());
                stringBuilder.append(", ");
            }
            stringBuilder.append("hashCode=");
            stringBuilder.append(Integer.toHexString(object.hashCode()));
            for (Method method : methodArray = object.getClass().getMethods()) {
                Class<?>[] classArray;
                if (!Modifier.isPublic(method.getModifiers())) continue;
                String string = method.getName();
                String string2 = null;
                if (!string.equals("getClass") && string.length() > 3 && string.startsWith("get") && Character.isUpperCase(string.charAt(3))) {
                    string2 = string.substring(3);
                } else if (string.length() > 2 && string.startsWith("is") && Character.isUpperCase(string.charAt(2))) {
                    string2 = string.substring(2);
                }
                if (string2 == null) continue;
                if (string2.length() > 1 && Character.isLowerCase(string2.charAt(1))) {
                    string2 = Character.toLowerCase(string2.charAt(0)) + string2.substring(1);
                }
                boolean bl3 = (classArray = method.getParameterTypes()) != null && classArray.length > 0;
                boolean bl4 = Void.TYPE.equals(method.getReturnType());
                if (bl4 || bl3) continue;
                try {
                    Object object2 = method.invoke(object, new Object[0]);
                    stringBuilder.append(", ");
                    stringBuilder.append(string2);
                    stringBuilder.append('=');
                    if (n2 != 0 && object2 != null && StringUtil.isIdentityToString(object2)) {
                        stringBuilder.append(StringUtil.deepToString(object2, bl2, n2 > 0 ? n2 - 1 : -1));
                        continue;
                    }
                    stringBuilder.append(object2);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            stringBuilder.append('}');
            stringBuilder.insert(0, object.getClass().getName());
        }
        return stringBuilder.toString();
    }

    private static boolean isIdentityToString(Object object) {
        try {
            Method method = object.getClass().getMethod("toString", new Class[0]);
            if (method.getDeclaringClass() == Object.class) {
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public static String identityToString(Object object) {
        if (object == null) {
            return null;
        }
        return object.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(object));
    }

    public boolean matches(String string, String string2) throws PatternSyntaxException {
        return Pattern.matches(string2, string);
    }

    public String replaceFirst(String string, String string2, String string3) {
        return Pattern.compile(string2).matcher(string).replaceFirst(string3);
    }

    public String replaceAll(String string, String string2, String string3) {
        return Pattern.compile(string2).matcher(string).replaceAll(string3);
    }

    public String[] split(String string, String string2, int n2) {
        return Pattern.compile(string2).split(string, n2);
    }

    public String[] split(String string, String string2) {
        return this.split(string, string2, 0);
    }

    public static String camelToLisp(String string) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (string.length() == 0) {
            return string;
        }
        StringBuilder stringBuilder = null;
        int n2 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i2 = 1; i2 < string.length(); ++i2) {
            char c2;
            char c3 = string.charAt(i2);
            if (Character.isUpperCase(c3)) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder(string.length() + 3);
                }
                if (bl3) {
                    bl3 = false;
                    stringBuilder.append(string.substring(n2, i2));
                    if (c3 != '-') {
                        stringBuilder.append('-');
                    }
                    n2 = i2;
                    continue;
                }
                c2 = string.charAt(i2 - 1);
                if (i2 == n2 || Character.isUpperCase(c2)) {
                    bl2 = true;
                    continue;
                }
                stringBuilder.append(string.substring(n2, i2).toLowerCase());
                if (c2 != '-') {
                    stringBuilder.append('-');
                }
                stringBuilder.append(Character.toLowerCase(c3));
                n2 = i2 + 1;
                continue;
            }
            if (Character.isDigit(c3)) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder(string.length() + 3);
                }
                if (bl2) {
                    bl2 = false;
                    stringBuilder.append(string.substring(n2, i2).toLowerCase());
                    if (c3 != '-') {
                        stringBuilder.append('-');
                    }
                    n2 = i2;
                    continue;
                }
                c2 = string.charAt(i2 - 1);
                if (i2 == n2 || Character.isDigit(c2)) {
                    bl3 = true;
                    continue;
                }
                stringBuilder.append(string.substring(n2, i2).toLowerCase());
                if (c2 != '-') {
                    stringBuilder.append('-');
                }
                stringBuilder.append(Character.toLowerCase(c3));
                n2 = i2 + 1;
                continue;
            }
            if (bl3) {
                bl3 = false;
                stringBuilder.append(string.substring(n2, i2));
                if (c3 != '-') {
                    stringBuilder.append('-');
                }
                n2 = i2;
                continue;
            }
            if (!bl2) continue;
            bl2 = false;
            stringBuilder.append(string.substring(n2, i2 - 1).toLowerCase());
            if (c3 != '-') {
                stringBuilder.append('-');
            }
            n2 = i2 - 1;
        }
        if (stringBuilder != null) {
            stringBuilder.append(string.substring(n2).toLowerCase());
            return stringBuilder.toString();
        }
        return Character.isUpperCase(string.charAt(0)) ? string.toLowerCase() : string;
    }

    public static String lispToCamel(String string) {
        return StringUtil.lispToCamel(string, false);
    }

    public static String lispToCamel(String string, boolean bl2) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (string.length() == 0) {
            return string;
        }
        StringBuilder stringBuilder = null;
        int n2 = 0;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 != '-') continue;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(string.length() - 1);
            }
            if (n2 != 0 || bl2) {
                stringBuilder.append(Character.toUpperCase(string.charAt(n2)));
                ++n2;
            }
            stringBuilder.append(string.substring(n2, i2).toLowerCase());
            n2 = i2 + 1;
        }
        if (stringBuilder != null) {
            stringBuilder.append(Character.toUpperCase(string.charAt(n2)));
            stringBuilder.append(string.substring(n2 + 1).toLowerCase());
            return stringBuilder.toString();
        }
        if (bl2 && !Character.isUpperCase(string.charAt(0))) {
            return StringUtil.capitalize(string, 0);
        }
        if (!bl2 && Character.isUpperCase(string.charAt(0))) {
            return Character.toLowerCase(string.charAt(0)) + string.substring(1);
        }
        return string;
    }

    public static String reverse(String string) {
        char[] cArray = new char[string.length()];
        string.getChars(0, cArray.length, cArray, 0);
        for (int i2 = 0; i2 < cArray.length / 2; ++i2) {
            char c2 = cArray[i2];
            cArray[i2] = cArray[cArray.length - 1 - i2];
            cArray[cArray.length - 1 - i2] = c2;
        }
        return new String(cArray);
    }
}

