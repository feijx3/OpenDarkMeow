/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.util.internal.logging;

import java.util.HashSet;
import java.util.Set;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.FormattingTuple;

public final class MessageFormatter {
    private static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    public static FormattingTuple format(String messagePattern, Object arg) {
        return MessageFormatter.arrayFormat(messagePattern, new Object[]{arg});
    }

    public static FormattingTuple format(String messagePattern, Object argA, Object argB) {
        return MessageFormatter.arrayFormat(messagePattern, new Object[]{argA, argB});
    }

    public static FormattingTuple arrayFormat(String messagePattern, Object[] argArray) {
        Throwable throwable;
        if (argArray == null || argArray.length == 0) {
            return new FormattingTuple(messagePattern, null);
        }
        int lastArrIdx = argArray.length - 1;
        Object lastEntry = argArray[lastArrIdx];
        Throwable throwable2 = throwable = lastEntry instanceof Throwable ? (Throwable)lastEntry : null;
        if (messagePattern == null) {
            return new FormattingTuple(null, throwable);
        }
        int j2 = messagePattern.indexOf(DELIM_STR);
        if (j2 == -1) {
            return new FormattingTuple(messagePattern, throwable);
        }
        StringBuilder sbuf = new StringBuilder(messagePattern.length() + 50);
        int i2 = 0;
        int L = 0;
        do {
            boolean notEscaped;
            boolean bl2 = notEscaped = j2 == 0 || messagePattern.charAt(j2 - 1) != '\\';
            if (notEscaped) {
                sbuf.append(messagePattern, i2, j2);
            } else {
                sbuf.append(messagePattern, i2, j2 - 1);
                notEscaped = j2 >= 2 && messagePattern.charAt(j2 - 2) == '\\';
            }
            i2 = j2 + 2;
            if (notEscaped) {
                MessageFormatter.deeplyAppendParameter(sbuf, argArray[L], null);
                if (++L <= lastArrIdx) continue;
                break;
            }
            sbuf.append(DELIM_STR);
        } while ((j2 = messagePattern.indexOf(DELIM_STR, i2)) != -1);
        sbuf.append(messagePattern, i2, messagePattern.length());
        return new FormattingTuple(sbuf.toString(), L <= lastArrIdx ? throwable : null);
    }

    private static void deeplyAppendParameter(StringBuilder sbuf, Object o2, Set<Object[]> seenSet) {
        if (o2 == null) {
            sbuf.append("null");
            return;
        }
        Class<?> objClass = o2.getClass();
        if (!objClass.isArray()) {
            if (Number.class.isAssignableFrom(objClass)) {
                if (objClass == Long.class) {
                    sbuf.append((Long)o2);
                } else if (objClass == Integer.class || objClass == Short.class || objClass == Byte.class) {
                    sbuf.append(((Number)o2).intValue());
                } else if (objClass == Double.class) {
                    sbuf.append((Double)o2);
                } else if (objClass == Float.class) {
                    sbuf.append(((Float)o2).floatValue());
                } else {
                    MessageFormatter.safeObjectAppend(sbuf, o2);
                }
            } else {
                MessageFormatter.safeObjectAppend(sbuf, o2);
            }
        } else {
            sbuf.append('[');
            if (objClass == boolean[].class) {
                MessageFormatter.booleanArrayAppend(sbuf, (boolean[])o2);
            } else if (objClass == byte[].class) {
                MessageFormatter.byteArrayAppend(sbuf, (byte[])o2);
            } else if (objClass == char[].class) {
                MessageFormatter.charArrayAppend(sbuf, (char[])o2);
            } else if (objClass == short[].class) {
                MessageFormatter.shortArrayAppend(sbuf, (short[])o2);
            } else if (objClass == int[].class) {
                MessageFormatter.intArrayAppend(sbuf, (int[])o2);
            } else if (objClass == long[].class) {
                MessageFormatter.longArrayAppend(sbuf, (long[])o2);
            } else if (objClass == float[].class) {
                MessageFormatter.floatArrayAppend(sbuf, (float[])o2);
            } else if (objClass == double[].class) {
                MessageFormatter.doubleArrayAppend(sbuf, (double[])o2);
            } else {
                MessageFormatter.objectArrayAppend(sbuf, (Object[])o2, seenSet);
            }
            sbuf.append(']');
        }
    }

    private static void safeObjectAppend(StringBuilder sbuf, Object o2) {
        try {
            String oAsString = o2.toString();
            sbuf.append(oAsString);
        }
        catch (Throwable t2) {
            System.err.println("SLF4J: Failed toString() invocation on an object of type [" + o2.getClass().getName() + ']');
            t2.printStackTrace();
            sbuf.append("[FAILED toString()]");
        }
    }

    private static void objectArrayAppend(StringBuilder sbuf, Object[] a2, Set<Object[]> seenSet) {
        if (a2.length == 0) {
            return;
        }
        if (seenSet == null) {
            seenSet = new HashSet<Object[]>(a2.length);
        }
        if (seenSet.add(a2)) {
            MessageFormatter.deeplyAppendParameter(sbuf, a2[0], seenSet);
            for (int i2 = 1; i2 < a2.length; ++i2) {
                sbuf.append(", ");
                MessageFormatter.deeplyAppendParameter(sbuf, a2[i2], seenSet);
            }
            seenSet.remove(a2);
        } else {
            sbuf.append("...");
        }
    }

    private static void booleanArrayAppend(StringBuilder sbuf, boolean[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private static void byteArrayAppend(StringBuilder sbuf, byte[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private static void charArrayAppend(StringBuilder sbuf, char[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private static void shortArrayAppend(StringBuilder sbuf, short[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private static void intArrayAppend(StringBuilder sbuf, int[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private static void longArrayAppend(StringBuilder sbuf, long[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private static void floatArrayAppend(StringBuilder sbuf, float[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private static void doubleArrayAppend(StringBuilder sbuf, double[] a2) {
        if (a2.length == 0) {
            return;
        }
        sbuf.append(a2[0]);
        for (int i2 = 1; i2 < a2.length; ++i2) {
            sbuf.append(", ");
            sbuf.append(a2[i2]);
        }
    }

    private MessageFormatter() {
    }
}

