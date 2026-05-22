/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.darkmeow.irc.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import net.ccbluex.liquidbounce.utils.file.ClientInfoUtils;
import net.darkmeow.irc.data.DataClientBrand;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2={"Lnet/darkmeow/darkmeow/irc/config/IRCStaticConfigs;", "", "<init>", "()V", "SERVER_ADDRESS", "", "SERVER_PORT", "", "CLIENT_BRAND", "Lnet/darkmeow/irc/data/DataClientBrand;", "getCLIENT_BRAND", "()Lnet/darkmeow/irc/data/DataClientBrand;", "KEY_SIGNATURE_CLIENT", "getKEY_SIGNATURE_CLIENT", "()Ljava/lang/String;", "KEY_REMOTE_VERIFY", "getKEY_REMOTE_VERIFY", "VERIFY_ON_LAUNCH", "Lnet/darkmeow/darkmeow/irc/config/IRCStaticConfigs$IRCVerify;", "getVERIFY_ON_LAUNCH", "()Lnet/darkmeow/darkmeow/irc/config/IRCStaticConfigs$IRCVerify;", "IRCVerify", "DarkMeow"})
public final class IRCStaticConfigs {
    @NotNull
    public static final IRCStaticConfigs INSTANCE = new IRCStaticConfigs();
    @NotNull
    public static final String SERVER_ADDRESS = "irc.nekocurit.asia";
    public static final int SERVER_PORT = 45020;
    @NotNull
    private static final DataClientBrand CLIENT_BRAND = new DataClientBrand("DarkMeow", ClientInfoUtils.INSTANCE.getVersion(), 0);
    @NotNull
    private static final String KEY_SIGNATURE_CLIENT = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIhBM4/qYOaMGBkg\nhohfXFxRVG/5so+HIV31eztSYq7kCJi4Yw9OFwDagNmh5uiG2QjoNS41PzKUrGxn\nIgUBw3EFFWHqM5yU2ysqXR520ExMfi0q9YUognwp0SniXJNmSv/vHiE+RllqPm6N\nulb2X8/OSlZqyAEvDiYxeVB6XRRFAgMBAAECgYAIwpRjlNCNEgW8m9Q6cVMZVltE\n5btesfPpvA4jtrzEfMG2u+gWhFFDS0kMdPXJDl5mzbMZmO/KuzdIsurDgqUDh4rC\n63H84r6M/WOPXLtiWJVhHEsDf5xc7W6y4B+HP4TwkQUTHy180xHi1kRipUViwXxh\nYiJlg7k7vfH1tn8CEQJBAM54NoYxGBlwNZO3wbhBISWNOZlHcrMcOKYyPED/FeCi\nJDPuy2QWqE7AFt4e0sgx9j4VWEl8kKWoHqKI2U+s7OkCQQCo8OzreS+2PApmxC5m\nO92ojYK7kH7+Wrexsoi5P6LS9iqgcXX6OqDCn5zZPjLgvgZZXY5WC5MpNHv1Rbp9\nACL9AkBI+S30Mcfdvc4B3pGGSOapOgfgh+MfMNtIyjqHkmCuG0CGZmDWiDeGVdf/\nO4+uGBJ7ENo6Zt9M3WWudoWv5mN5AkAvNQtvDTEI4iQh7UXt6WKZ+9kBInJqDt1v\nuSy9XwvXmVP1+151KrbLS6Cfj+LVrCPICv2AC8H2bKUKt45R6ZzdAkEAugp1uKtA\nojOTnfz41o8e/IlfF0iK72ogPhJMPY0wjHAAeAKju8Sue3Ers+983cwJwj8RQR5D\nSMFVzghFPD5NWg==";
    @NotNull
    private static final String KEY_REMOTE_VERIFY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiAu8gFa1ag+I8DjJVYDle3tK3\nfHqOektDhARhkDMdv43I2Zed5KP5YSqUFIlhCjmOo19pwl83kphnPl4VvvHaCZyl\nzUqcjQ0ox6CodhCBsbe57NNTImBNyRZGS1kr56PMws7upSfOEkBq/AIE3QOr8dSn\novdZHx7G3IJW9tOhgwIDAQAB";
    @NotNull
    private static final IRCVerify VERIFY_ON_LAUNCH = IRCVerify.FORCE;

    private IRCStaticConfigs() {
    }

    @NotNull
    public final DataClientBrand getCLIENT_BRAND() {
        return CLIENT_BRAND;
    }

    @NotNull
    public final String getKEY_SIGNATURE_CLIENT() {
        return KEY_SIGNATURE_CLIENT;
    }

    @NotNull
    public final String getKEY_REMOTE_VERIFY() {
        return KEY_REMOTE_VERIFY;
    }

    @NotNull
    public final IRCVerify getVERIFY_ON_LAUNCH() {
        return VERIFY_ON_LAUNCH;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/darkmeow/darkmeow/irc/config/IRCStaticConfigs$IRCVerify;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLE", "LITE", "FORCE", "DarkMeow"})
    public static final class IRCVerify
    extends Enum<IRCVerify> {
        public static final /* enum */ IRCVerify DISABLE = new IRCVerify();
        public static final /* enum */ IRCVerify LITE = new IRCVerify();
        public static final /* enum */ IRCVerify FORCE = new IRCVerify();
        private static final /* synthetic */ IRCVerify[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static IRCVerify[] values() {
            return (IRCVerify[])$VALUES.clone();
        }

        public static IRCVerify valueOf(String value) {
            return Enum.valueOf(IRCVerify.class, value);
        }

        @NotNull
        public static EnumEntries<IRCVerify> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = iRCVerifyArray = new IRCVerify[]{IRCVerify.DISABLE, IRCVerify.LITE, IRCVerify.FORCE};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

