/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.ccbluex.liquidbounce.features.module.modules.fun.silence_fix_irc;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFProtocol;", "", "<init>", "()V", "PROTOCOL_VERSION", "", "PROTOCOL_KEY", "Ljava/security/PublicKey;", "getPROTOCOL_KEY", "()Ljava/security/PublicKey;", "DarkMeow"})
@SourceDebugExtension(value={"SMAP\nSFProtocol.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SFProtocol.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFProtocol\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,31:1\n11238#2:32\n11573#2,3:33\n1#3:36\n*S KotlinDebug\n*F\n+ 1 SFProtocol.kt\nnet/ccbluex/liquidbounce/features/module/modules/fun/silence_fix_irc/SFProtocol\n*L\n28#1:32\n28#1:33,3\n*E\n"})
public final class SFProtocol {
    @NotNull
    public static final SFProtocol INSTANCE;
    public static final int PROTOCOL_VERSION = 14;
    @NotNull
    private static final PublicKey PROTOCOL_KEY;

    private SFProtocol() {
    }

    @NotNull
    public final PublicKey getPROTOCOL_KEY() {
        return PROTOCOL_KEY;
    }

    /*
     * WARNING - void declaration
     */
    static {
        void var3_5;
        void $this$mapTo$iv$iv;
        INSTANCE = new SFProtocol();
        byte[] byArray = new byte[]{-72, 10, -119, -86, -72, -123, -114, -127, -94, 14, -64, 14, 127, -123, -119, -119, -119, -115, -120, -117, 10, -119, -121, -120, -72, 10, -119, -126, -118, 10, -119, -119, -120, 57, -114, -108, 90, 24, -45, 54, 9, -18, -20, 23, -33, -23, 87, -14, -40, -45, -121, 54, -72, 98, 67, 127, -99, 107, -60, 47, 107, 83, 13, 26, -126, 125, -14, 60, 27, -117, 11, 73, -33, -123, -92, -16, 42, -79, 53, -6, -16, -121, 56, 70, -16, -92, -53, -114, -3, 91, 112, -67, 54, -95, -84, 62, -103, 101, -60, 93, -109, 16, 42, 66, 87, -50, 8, -90, -125, 26, 119, -41, 77, 121, -117, 29, -69, 80, 14, -67, -26, -92, 98, 109, 118, 54, 56, 18, 76, 85, -68, 70, 67, 9, 36, -69, 85, 37, -66, -19, -52, -51, -118, -95, -56, -61, -51, -42, 68, 63, 121, 46, -90, -48, -68, -30, -68, -43, 7, 110, 31, 18, -49, -62, -39, 96, -115, -24, -106, 115, 84, 38, 122, 12, -42, -65, -8, -115, 89, -40, -110, -116, 65, 15, 82, 84, 27, -63, 99, -31, 91, 123, 114, 7, -60, -96, -1, 42, 61, -51, 79, 117, 90, 66, 18, -97, 50, -124, 80, -4, -62, 101, 68, 18, 85, -44, -62, 29, -128, -81, -25, -101, -75, -107, -14, 15, 56, 14, -115, -112, 80, -76, -73, 73, 25, 27, -61, -77, 46, -2, -74, -17, 122, -117, 23, -102, -1, -26, -95, -41, 100, -77, 18, 120, 15, 121, -68, 38, 101, -16, 121, -24, -38, -84, 115, -119, 86, 3, -6, 126, -70, -86, -12, -26, -52, 4, 119, 49, -106, -97, 2, -57, 125, 46, -114, 53, -16, 20, -33, -118, -117, -119, -120, -119};
        byte[] $this$map$iv = byArray;
        boolean $i$f$map = false;
        byte[] byArray2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n2 = ((void)$this$mapTo$iv$iv).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            void it;
            void item$iv$iv;
            void var8_10 = item$iv$iv = $this$mapTo$iv$iv[i2];
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            collection.add((byte)(it ^ 0x88));
        }
        byte[] it = CollectionsKt.toByteArray((List)var3_5);
        boolean bl3 = false;
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(it));
        Intrinsics.checkNotNullExpressionValue(publicKey, "let(...)");
        PROTOCOL_KEY = publicKey;
    }
}

