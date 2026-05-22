/*
 * Decompiled with CFR 0.152.
 */
package net.darkmeow.irc.lib.io.netty.channel;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import net.darkmeow.irc.lib.io.netty.buffer.ByteBufUtil;
import net.darkmeow.irc.lib.io.netty.channel.ChannelId;
import net.darkmeow.irc.lib.io.netty.util.internal.EmptyArrays;
import net.darkmeow.irc.lib.io.netty.util.internal.MacAddressUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.PlatformDependent;
import net.darkmeow.irc.lib.io.netty.util.internal.SystemPropertyUtil;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLogger;
import net.darkmeow.irc.lib.io.netty.util.internal.logging.InternalLoggerFactory;

public final class DefaultChannelId
implements ChannelId {
    private static final long serialVersionUID = 3884076183504074063L;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelId.class);
    private static final byte[] MACHINE_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int PROCESS_ID;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final int RANDOM_LEN = 4;
    private static final AtomicInteger nextSequence;
    private final byte[] data;
    private final int hashCode;
    private transient String shortValue;
    private transient String longValue;

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId(MACHINE_ID, PROCESS_ID, nextSequence.getAndIncrement(), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis(), PlatformDependent.threadLocalRandom().nextInt());
    }

    static int processHandlePid(ClassLoader loader) {
        int nilValue = -1;
        if (PlatformDependent.javaVersion() >= 9) {
            Long pid;
            try {
                Class<?> processHandleImplType = Class.forName("java.lang.ProcessHandle", true, loader);
                Method processHandleCurrent = processHandleImplType.getMethod("current", new Class[0]);
                Object processHandleInstance = processHandleCurrent.invoke(null, new Object[0]);
                Method processHandlePid = processHandleImplType.getMethod("pid", new Class[0]);
                pid = (Long)processHandlePid.invoke(processHandleInstance, new Object[0]);
            }
            catch (Exception e2) {
                logger.debug("Could not invoke ProcessHandle.current().pid();", e2);
                return nilValue;
            }
            if (pid > Integer.MAX_VALUE || pid < Integer.MIN_VALUE) {
                throw new IllegalStateException("Current process ID exceeds int range: " + pid);
            }
            return pid.intValue();
        }
        return nilValue;
    }

    static int jmxPid(ClassLoader loader) {
        int pid;
        String value;
        try {
            Class<?> mgmtFactoryType = Class.forName("java.lang.management.ManagementFactory", true, loader);
            Class<?> runtimeMxBeanType = Class.forName("java.lang.management.RuntimeMXBean", true, loader);
            Method getRuntimeMXBean = mgmtFactoryType.getMethod("getRuntimeMXBean", EmptyArrays.EMPTY_CLASSES);
            Object bean = getRuntimeMXBean.invoke(null, EmptyArrays.EMPTY_OBJECTS);
            Method getName = runtimeMxBeanType.getMethod("getName", EmptyArrays.EMPTY_CLASSES);
            value = (String)getName.invoke(bean, EmptyArrays.EMPTY_OBJECTS);
        }
        catch (Throwable t2) {
            logger.debug("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", t2);
            try {
                Class<?> processType = Class.forName("android.os.Process", true, loader);
                Method myPid = processType.getMethod("myPid", EmptyArrays.EMPTY_CLASSES);
                value = myPid.invoke(null, EmptyArrays.EMPTY_OBJECTS).toString();
            }
            catch (Throwable t22) {
                logger.debug("Could not invoke Process.myPid(); not Android?", t22);
                value = "";
            }
        }
        int atIndex = value.indexOf(64);
        if (atIndex >= 0) {
            value = value.substring(0, atIndex);
        }
        try {
            pid = Integer.parseInt(value);
        }
        catch (NumberFormatException e2) {
            pid = -1;
        }
        if (pid < 0) {
            pid = PlatformDependent.threadLocalRandom().nextInt();
            logger.warn("Failed to find the current process ID from '{}'; using a random value: {}", (Object)value, (Object)pid);
        }
        return pid;
    }

    static int defaultProcessId() {
        ClassLoader loader = PlatformDependent.getClassLoader(DefaultChannelId.class);
        int processId = DefaultChannelId.processHandlePid(loader);
        if (processId != -1) {
            return processId;
        }
        return DefaultChannelId.jmxPid(loader);
    }

    DefaultChannelId(byte[] machineId, int processId, int sequence, long timestamp, int random) {
        byte[] data = new byte[machineId.length + 4 + 4 + 8 + 4];
        int i2 = 0;
        System.arraycopy(machineId, 0, data, i2, machineId.length);
        DefaultChannelId.writeInt(data, i2 += machineId.length, processId);
        DefaultChannelId.writeInt(data, i2 += 4, sequence);
        DefaultChannelId.writeLong(data, i2 += 4, timestamp);
        DefaultChannelId.writeInt(data, i2 += 8, random);
        assert ((i2 += 4) == data.length);
        this.data = data;
        this.hashCode = Arrays.hashCode(data);
    }

    private static void writeInt(byte[] data, int i2, int value) {
        if (PlatformDependent.isUnaligned()) {
            PlatformDependent.putInt(data, i2, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? value : Integer.reverseBytes(value));
            return;
        }
        data[i2] = (byte)(value >>> 24);
        data[i2 + 1] = (byte)(value >>> 16);
        data[i2 + 2] = (byte)(value >>> 8);
        data[i2 + 3] = (byte)value;
    }

    private static void writeLong(byte[] data, int i2, long value) {
        if (PlatformDependent.isUnaligned()) {
            PlatformDependent.putLong(data, i2, PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? value : Long.reverseBytes(value));
            return;
        }
        data[i2] = (byte)(value >>> 56);
        data[i2 + 1] = (byte)(value >>> 48);
        data[i2 + 2] = (byte)(value >>> 40);
        data[i2 + 3] = (byte)(value >>> 32);
        data[i2 + 4] = (byte)(value >>> 24);
        data[i2 + 5] = (byte)(value >>> 16);
        data[i2 + 6] = (byte)(value >>> 8);
        data[i2 + 7] = (byte)value;
    }

    @Override
    public String asShortText() {
        String shortValue = this.shortValue;
        if (shortValue == null) {
            this.shortValue = shortValue = ByteBufUtil.hexDump(this.data, this.data.length - 4, 4);
        }
        return shortValue;
    }

    @Override
    public String asLongText() {
        String longValue = this.longValue;
        if (longValue == null) {
            this.longValue = longValue = this.newLongValue();
        }
        return longValue;
    }

    private String newLongValue() {
        StringBuilder buf = new StringBuilder(2 * this.data.length + 5);
        int machineIdLen = this.data.length - 4 - 4 - 8 - 4;
        int i2 = 0;
        i2 = this.appendHexDumpField(buf, i2, machineIdLen);
        i2 = this.appendHexDumpField(buf, i2, 4);
        i2 = this.appendHexDumpField(buf, i2, 4);
        i2 = this.appendHexDumpField(buf, i2, 8);
        i2 = this.appendHexDumpField(buf, i2, 4);
        assert (i2 == this.data.length);
        return buf.substring(0, buf.length() - 1);
    }

    private int appendHexDumpField(StringBuilder buf, int i2, int length) {
        buf.append(ByteBufUtil.hexDump(this.data, i2, length));
        buf.append('-');
        return i2 += length;
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public int compareTo(ChannelId o2) {
        if (this == o2) {
            return 0;
        }
        if (o2 instanceof DefaultChannelId) {
            byte[] otherData = ((DefaultChannelId)o2).data;
            int len1 = this.data.length;
            int len2 = otherData.length;
            int len = Math.min(len1, len2);
            for (int k2 = 0; k2 < len; ++k2) {
                byte x2 = this.data[k2];
                byte y2 = otherData[k2];
                if (x2 == y2) continue;
                return (x2 & 0xFF) - (y2 & 0xFF);
            }
            return len1 - len2;
        }
        return this.asLongText().compareTo(o2.asLongText());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultChannelId)) {
            return false;
        }
        DefaultChannelId other = (DefaultChannelId)obj;
        return this.hashCode == other.hashCode && Arrays.equals(this.data, other.data);
    }

    public String toString() {
        return this.asShortText();
    }

    static {
        nextSequence = new AtomicInteger();
        int processId = -1;
        String customProcessId = SystemPropertyUtil.get("net.darkmeow.irc.lib.io.netty.processId");
        if (customProcessId != null) {
            try {
                processId = Integer.parseInt(customProcessId);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            if (processId < 0) {
                processId = -1;
                logger.warn("-Dio.netty.processId: {} (malformed)", (Object)customProcessId);
            } else if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.processId: {} (user-set)", (Object)processId);
            }
        }
        if (processId < 0) {
            processId = DefaultChannelId.defaultProcessId();
            if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.processId: {} (auto-detected)", (Object)processId);
            }
        }
        PROCESS_ID = processId;
        byte[] machineId = null;
        String customMachineId = SystemPropertyUtil.get("net.darkmeow.irc.lib.io.netty.machineId");
        if (customMachineId != null) {
            try {
                machineId = MacAddressUtil.parseMAC(customMachineId);
            }
            catch (Exception e2) {
                logger.warn("-Dio.netty.machineId: {} (malformed)", (Object)customMachineId, (Object)e2);
            }
            if (machineId != null) {
                logger.debug("-Dio.netty.machineId: {} (user-set)", (Object)customMachineId);
            }
        }
        if (machineId == null) {
            machineId = MacAddressUtil.defaultMachineId();
            if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.machineId: {} (auto-detected)", (Object)MacAddressUtil.formatAddress(machineId));
            }
        }
        MACHINE_ID = machineId;
    }
}

