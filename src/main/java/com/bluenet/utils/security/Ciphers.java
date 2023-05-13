package com.bluenet.utils.security;

import com.mysql.cj.log.Log;
import org.slf4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Ciphers {
    private static final String UNICODE_FORMAT = "UTF8";
    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private Logger logger;
    private KeySpec keySpec;
    private SecretKeyFactory keyFactory;
    private Cipher cipher;
    byte[] arrayBytes;
    private String encryptionKey;
    private String encryptionScheme;
    SecretKey key;

    public Ciphers(Logger logger, String encryption) throws Exception {
        this.logger = logger;
        this.encryptionKey = encryption + "%$(§$)$543538%(&";
        this.encryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        this.arrayBytes = encryptionKey.getBytes(UNICODE_FORMAT);
        this.keySpec = new DESedeKeySpec(arrayBytes);
        this.keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
        this.cipher = Cipher.getInstance(encryptionScheme);
        this.key = keyFactory.generateSecret(keySpec);
    }

    /**
     * @param source type in the object to encrypt
     * @return full encrypted String
     */
    public Object encrypt(Object source) {
        String returnment = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = String.valueOf(source).getBytes(UNICODE_FORMAT);
            byte[] encrypted = cipher.doFinal(plainText);
            returnment = new String(Base64.getEncoder().encode(encrypted));
        } catch (Exception e) {
            logger.error("There was an error, while trying to encrypt an object: ", e);
            return null;
        }
        return returnment;
    }

    /**
     * @param source encrypted String
     * @return decrypted String
     */
    public Object decrypt(Object source) {
        String returnment = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.getDecoder().decode(String.valueOf(source).getBytes());
            byte[] plainText = cipher.doFinal(encryptedText);
            returnment= new String(plainText);
        } catch (Exception e) {
            logger.error("There was an error, while trying to decrypt an object: ", e);
            return null;
        }
        return returnment;
    }
}
