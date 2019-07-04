package net.zeroinstall

//package net.zeroinstall
//
//import com.google.common.base.Charsets
//import java.io.ByteArrayOutputStream
//import java.io.IOException
//import java.nio.ByteBuffer
//import java.security.NoSuchAlgorithmException
//import java.security.NoSuchProviderException
//import java.security.Security
//import java.security.SignatureException
//import org.bouncycastle.bcpg.*
//import org.bouncycastle.openpgp.*
//
///**
// * Provides access to the OpenPGP signature functions of Bouncy Castle.
// */
//class BouncyCastle : OpenPgp {
//
//    @Throws(IOException::class)
//    fun sign(data: ByteArray, keySpecifier: String): ByteArray {
//        val pgpSecretKey: Nothing =
//            null
//                ?: throw IOException("Specified OpenPGP key not found on system") //SecretBundle.getSecretKey(keySpecifier);
//
//        try {
//            val pgpPrivateKey = getPrivateKey(pgpSecretKey, "")
//            val signatureGenerator = PGPSignatureGenerator(
//                pgpSecretKey.getPublicKey().getAlgorithm(),
//                HashAlgorithmTags.SHA1,
//                PGPUtil.getDefaultProvider()
//            )
//            signatureGenerator.initSign(PGPSignature.BINARY_DOCUMENT, pgpPrivateKey)
//            signatureGenerator.update(data)
//            return signatureGenerator.generate().getEncoded()
//        } catch (ex: NoSuchAlgorithmException) {
//            throw IOException(ex)
//        } catch (ex: NoSuchProviderException) {
//            throw IOException(ex)
//        } catch (ex: PGPException) {
//            throw IOException(ex)
//        } catch (ex: SignatureException) {
//            throw IOException(ex)
//        }
//
//    }
//
//    @Throws(PGPException::class)
//    private fun getPrivateKey(secretKey: PGPSecretKey, passphrase: String): PGPPrivateKey {
//        return secretKey.extractPrivateKey(passphrase.toCharArray(), Security.getProvider(null))
//    }
//
//    @Throws(IOException::class)
//    fun exportKey(keySpecifier: String): String {
//        var publicKey: PGPPublicKey?
//        if (SecretBundle.getSecretKey(keySpecifier) != null) {
//            publicKey = SecretBundle.getSecretKey(keySpecifier).PublicKey
//        } else {
//            publicKey = null
//        }
//        if (publicKey == null) {
//            publicKey = PublicBundle.getPublicKey(keySpecifier)
//        }
//        if (publicKey == null) {
//            throw IOException("Specified OpenPGP key not found on system")
//        }
//
//        val output = ByteArrayOutputStream()
//        val armored = ArmoredOutputStream(output)
//        publicKey!!.encode(armored)
//        return Charsets.US_ASCII.decode(ByteBuffer.wrap(output.toByteArray()))
//            .toString().replace(System.lineSeparator(), "\n")
//    }
//}
