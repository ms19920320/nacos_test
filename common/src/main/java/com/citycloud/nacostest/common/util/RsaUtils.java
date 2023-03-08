package com.citycloud.nacostest.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加密解密
 *
 * @author ruoyi
 **/
public class RsaUtils {
    /**
     * 公钥
     */
    public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGa9w1qRUJncF" +
            "+KRfRC6yWcpvY77Igps43tGZsYIPqFxSL8MVSambl5hnJkK1E5r4szYSOGaqXpNVcSeniRBBf8GmFw6B+lw0JF29zgNG6H+qR/U8K9q" +
            "/CVr7T77wUgHyNqhx6rKIxBOTTcghD2yH945h95Nls0fnWEzbMu5t1GQIDAQAB";
    /**
     * 私钥
     */
    public static String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMZr3DWpFQmdwX4pF9ELrJZym9jvsiCmzje0Zmxgg" +
            "+oXFIvwxVJqZuXmGcmQrUTmvizNhI4Zqpek1VxJ6eJEEF" +
            "/waYXDoH6XDQkXb3OA0bof6pH9Twr2r8JWvtPvvBSAfI2qHHqsojEE5NNyCEPbIf3jmH3k2WzR" +
            "+dYTNsy7m3UZAgMBAAECgYEAwknjOnfxrZTXXl2GgJ9Zw4c9q1IprWcoDcuLbxuij5lB" +
            "+TUtQeIGF58UKRaNUyZNmTk0TqA7NnmkodWOOoxDKrSxU3HBO23sfsb4sf4CW8o1rC+3nOhLrdc2y" +
            "/dzyDIc1kVwCDqEhbnkbZvyOlIXmR62UP25T2/8czhPbvkJpzECQQDhdELwpYH7RKxm0BLl" +
            "+LBE4kBwMIZYDldDxKrSpe1xMH4lKvazLtmdwzsRXqas7bLKbbu/YWzHTVlm6aEIXkdTAkEA4U37Z1zpLRalFujnZlj1orrefrHdEf" +
            "+GWWjLZ4seoHiIFQr" +
            "+DViYqGc31eZu96e68s7xPFN8U5UQrBlwyuagYwJBAL6bG0j2tHipa5QUkBWrdeMW4WG4NKxXm4Fo0P78V00dsVhdBWshzcuqVdLukb2bzE+GDHfVtzCcfVwbYxB/HI8CQGPAewaQhEyKMh2qkIkn6dlakxfU9+P4FiuP0j7NwYma0+U9MK4IA87LpFT36TmM8aB/Lx9edzUqUm9f9ChhY7ECQQDFLREoA6P2hvMM+rKPyFCXqDAPCeihfoTRzOjKxh+Q2iSswXTyrIPjako81Eg4Jp/5hzQzE6T15dR/B/xbyMAm\n";
    /**
     * 私钥解密
     *
     * @param text 待解密的文本
     * @return 解密后的文本
     */
    public static String decryptByPrivateKey(String text) throws Exception {
        return decryptByPrivateKey(privateKey, text);
    }

    /**
     * 公钥解密
     *
     * @param publicKeyString 公钥
     * @param text            待解密的信息
     * @return 解密后的文本
     */
    public static String decryptByPublicKey(String publicKeyString, String text) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(text));
        return new String(result);
    }

    /**
     * 私钥加密
     *
     * @param privateKeyString 私钥
     * @param text             待加密的信息
     * @return 加密后的文本
     */
    public static String encryptByPrivateKey(String privateKeyString, String text) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(result);
    }

    /**
     * 私钥解密
     *
     * @param privateKeyString 私钥
     * @param text             待解密文本
     * @return 解密后的文本
     */
    public static String decryptByPrivateKey(String privateKeyString, String text) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec5);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(text));
        return new String(result);
    }

    /**
     * 公钥加密
     *
     * @param publicKeyString 公钥
     * @param text            待加密的文本
     * @return 加密后的文本
     */
    public static String encryptByPublicKey(String publicKeyString, String text) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec2 = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec2);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(result);
    }

    /**
     * 构建RSA密钥对
     *
     * @return 生成后的公私钥信息
     */
    public static RsaKeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyString = Base64.encodeBase64String(rsaPublicKey.getEncoded());
        String privateKeyString = Base64.encodeBase64String(rsaPrivateKey.getEncoded());
        return new RsaKeyPair(publicKeyString, privateKeyString);
    }

    /**
     * RSA密钥对对象
     */
    public static class RsaKeyPair {
        private final String publicKey;
        private final String privateKey;

        public RsaKeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }
    }


    /**
     * 只需调用一次 生成/打印新的公钥私钥  并测试是否可用
     * 控制台打印结果，解密成功 则将打印的公钥私钥重新赋值给工具类的 privateKey 、 publicKey
     *
     * @throws NoSuchAlgorithmException
     */
    public static void printNewPubKeypriKey() {
        //调用 RsaUtils.generateKeyPair() 生成RSA公钥秘钥
        // 私钥
        String tmpPriKey = "";
        // 公钥
        String tmpPubKey = "";
        try {
            RsaKeyPair rsaKeyPair = RsaUtils.generateKeyPair();
            tmpPriKey = rsaKeyPair.getPrivateKey();
            tmpPubKey = rsaKeyPair.getPublicKey();
            System.out.println("私钥：" + tmpPriKey);
            System.out.println("公钥：" + tmpPubKey);
        } catch (NoSuchAlgorithmException exception) {
            System.out.println("生成秘钥公钥失败");
        }
        // 公钥加密、私钥解密
        try {
            // 注意需要加密的原文长度不要太长 过长的字符串会导致加解密失败
            String txt = "123456789,13000000001,oUpF8uMuAJO_M2pxb1Q9zNjWeS6oob1Q9zNjWeS6oQ9zNjW,1672914158," +
                    "1672914158,啊";
            // 加密后文本
            System.out.println("加密前原文：" + txt);
            // 公钥加密 ！！！
            String rsaText = RsaUtils.encryptByPublicKey(tmpPubKey, txt);
            // 加密后文本
            System.out.println("密文：" + rsaText);
            // 私钥解密 ！！！
            System.out.println("解密后原文：" + RsaUtils.decryptByPrivateKey(tmpPriKey, rsaText));
        } catch (BadPaddingException e) {
            System.out.println(e.getStackTrace());
            System.out.println("加解密失败");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用固定的 privateKey 、 publicKey 进行加解密测试
     * 注意 需要加密的原文长度不要太长 过长的字符串会导致加解密失败
     */
    public static void tryEncryptAndDecrypt() {
        // 公钥加密、私钥解密
        try {
            // 注意需要加密的原文长度不要太长 过长的字符串会导致加解密失败
            String txt = "123456789,13000000001,oUpF8uMuAJO_M2pxb1Q9zNjWeS6oob1Q9zNjWeS6oQ9zNjW,1672914158," +
                    "1672914158,啊";
            // 加密后文本
            System.out.println("加密前原文：" + txt);
            // RsaUtils.publicKey 公钥加密 ！！！
            String rsaText = RsaUtils.encryptByPublicKey(RsaUtils.publicKey, txt);
            // 加密后文本
            System.out.println("密文：" + rsaText);
            // RsaUtils.privateKey 私钥解密 ！！！
            System.out.println("解密后原文：" + RsaUtils.decryptByPrivateKey(RsaUtils.privateKey, rsaText));
        } catch (BadPaddingException e) {
            System.out.println(e.getStackTrace());
            System.out.println("加解密失败");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
