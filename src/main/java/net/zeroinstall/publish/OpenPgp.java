package net.zeroinstall.publish;

import java.io.IOException;

/**
 * Provides access to an encryption/signature system compatible with the OpenPGP
 * standard.
 */
public interface OpenPgp {

    /**
     * Creates a detached OpenPGP signature using a specific secret key.
     *
     * @param data The data to sign.
     * @param keySpecifier The key ID of the secret key to use for signing.
     * @return The signature in binary format.
     * @throws IOException The signature could not be generated
     */
    public byte[] sign(byte[] data, String keySpecifier) throws IOException;

    /**
     * Exports the public key for a specific key in the keyring.
     *
     * @param keySpecifier The key ID of the public key to export.
     * @return The public key in ASCII Armored format. Always uses Unix-style
     * linebreaks.
     * @throws IOException The key could not be exported.
     */
    public String exportKey(String keySpecifier) throws IOException;
}
