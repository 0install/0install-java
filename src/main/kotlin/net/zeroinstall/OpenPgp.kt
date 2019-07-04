package net.zeroinstall

import java.io.IOException

/**
 * Provides access to an encryption/signature system compatible with the OpenPGP standard.
 */
interface OpenPgp {

    /**
     * Creates a detached OpenPGP signature using a specific secret key.
     *
     * @param data The data to sign.
     * @param keySpecifier The key ID of the secret key to use for signing.
     * @return The signature in binary format.
     * @throws IOException The signature could not be generated.
     */
    @Throws(IOException::class)
    fun sign(data: ByteArray, keySpecifier: String): ByteArray

    /**
     * Exports the public key for a specific key in the keyring.
     *
     * @param keySpecifier The key ID of the public key to export.
     * @return The public key in ASCII Armored format. Always uses Unix-style linebreaks.
     * @throws IOException The key could not be exported.
     */
    @Throws(IOException::class)
    fun exportKey(keySpecifier: String): String
}
