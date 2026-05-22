/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package net.darkmeow.irc.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jetbrains.annotations.NotNull;

public class CryptUtils {
    public static SecretKey createNewSharedKey() throws NoSuchAlgorithmException {
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        keygenerator.init(128);
        return keygenerator.generateKey();
    }

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        return generator.generateKeyPair();
    }

    public static byte[] signData(byte[] data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public static boolean verifyData(byte[] data, byte[] signatureBytes, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(signatureBytes);
    }

    public static void exportPrivateKeyToPEM(PrivateKey privateKey, File file) throws IOException {
        byte[] encoded = privateKey.getEncoded();
        String base64 = Base64.getMimeEncoder(64, new byte[]{10}).encodeToString(encoded);
        String pem = "-----BEGIN PRIVATE KEY-----\n" + base64 + "\n-----END PRIVATE KEY-----";
        Files.write(file.toPath(), pem.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
    }

    public static void exportPublicKeyToPEM(PublicKey publicKey, File file) throws IOException {
        byte[] encoded = publicKey.getEncoded();
        String base64 = Base64.getMimeEncoder(64, new byte[]{10}).encodeToString(encoded);
        String pem = "-----BEGIN PUBLIC KEY-----\n" + base64 + "\n-----END PUBLIC KEY-----";
        Files.write(file.toPath(), pem.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
    }

    public static PrivateKey loadPrivateKeyFromPEM(File file) throws Exception {
        String pem = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        pem = pem.replaceAll("-----\\w+ PRIVATE KEY-----", "").replaceAll("\\s+", "");
        byte[] decoded = Base64.getDecoder().decode(pem);
        return CryptUtils.loadPrivateKeyFromByte(decoded);
    }

    public static PublicKey loadPublicKeyFromPEM(File file) throws Exception {
        String pem = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        pem = pem.replaceAll("-----\\w+ PUBLIC KEY-----", "").replaceAll("\\s+", "");
        byte[] decoded = Base64.getDecoder().decode(pem);
        return CryptUtils.loadPublicKeyFromByte(decoded);
    }

    public static PrivateKey loadPrivateKeyFromByte(byte[] data) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(data);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    public static PublicKey loadPublicKeyFromByte(byte[] data) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(data);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    public static byte[] encryptData(Key key, byte[] data) {
        return CryptUtils.cipherOperation(1, key, data);
    }

    public static byte[] decryptData(Key key, byte[] data) {
        return CryptUtils.cipherOperation(2, key, data);
    }

    private static byte[] cipherOperation(int opMode, Key key, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance(key.getAlgorithm());
            cipher.init(opMode, key);
            return cipher.doFinal(data);
        }
        catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @NotNull
    public static PublicKey decodePublicKey(byte[] encodedKey) {
        try {
            X509EncodedKeySpec encodedkeyspec = new X509EncodedKeySpec(encodedKey);
            KeyFactory keyfactory = KeyFactory.getInstance("RSA");
            return keyfactory.generatePublic(encodedkeyspec);
        }
        catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @NotNull
    public static SecretKey decryptSharedKey(PrivateKey key, byte[] secretKeyEncrypted) {
        try {
            return new SecretKeySpec(CryptUtils.decryptData(key, secretKeyEncrypted), "AES");
        }
        catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Cipher createNetCipherInstance(int opMode, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
            cipher.init(opMode, key, new IvParameterSpec(key.getEncoded()));
            return cipher;
        }
        catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}

