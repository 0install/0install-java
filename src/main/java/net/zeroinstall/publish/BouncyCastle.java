package net.zeroinstall.publish;

import com.google.common.base.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import org.bouncycastle.bcpg.*;
import org.bouncycastle.openpgp.*;

/**
 * Provides access to the OpenPGP signature functions of Bouncy Castle.
 */
public class BouncyCastle implements OpenPgp {

    @Override
    public byte[] sign(byte[] data, String keySpecifier) throws IOException {
        PGPSecretKey pgpSecretKey = null; //SecretBundle.getSecretKey(keySpecifier);
        if (pgpSecretKey == null) {
            throw new IOException("Specified OpenPGP key not found on system");
        }

        try {
            PGPPrivateKey pgpPrivateKey = getPrivateKey(pgpSecretKey, "");
            PGPSignatureGenerator signatureGenerator = new PGPSignatureGenerator(pgpSecretKey.getPublicKey().getAlgorithm(), HashAlgorithmTags.SHA1, PGPUtil.getDefaultProvider());
            signatureGenerator.initSign(PGPSignature.BINARY_DOCUMENT, pgpPrivateKey);
            signatureGenerator.update(data);
            return signatureGenerator.generate().getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new IOException(ex);
        } catch (NoSuchProviderException ex) {
            throw new IOException(ex);
        } catch (PGPException ex) {
            throw new IOException(ex);
        } catch (SignatureException ex) {
            throw new IOException(ex);
        }
    }

    private static PGPPrivateKey getPrivateKey(PGPSecretKey secretKey, String passphrase) throws PGPException {
        return secretKey.extractPrivateKey(passphrase.toCharArray(), Security.getProvider(null));
    }

    @Override
    public String exportKey(String keySpecifier) throws IOException {
        return null;
//        PGPPublicKey publicKey;
//        if (SecretBundle.getSecretKey(keySpecifier) != null) {
//            publicKey = SecretBundle.getSecretKey(keySpecifier).PublicKey;
//        } else {
//            publicKey = null;
//        }
//        if (publicKey == null) {
//            publicKey = PublicBundle.getPublicKey(keySpecifier);
//        }
//        if (publicKey == null) {
//            throw new IOException("Specified OpenPGP key not found on system");
//        }
//
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        ArmoredOutputStream armored = new ArmoredOutputStream(output);
//        publicKey.encode(armored);
//        return Charsets.US_ASCII.decode(ByteBuffer.wrap(output.toByteArray()))
//                .toString().replace(System.lineSeparator(), "\n");
    }
}
