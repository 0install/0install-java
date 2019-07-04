package net.zeroinstall

import org.junit.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.StringStartsWith.startsWith

abstract class OpenPgpTest protected constructor(private val target: OpenPgp) {

    @Test
    fun testGetPublicKey() {
        assertThat(
            target.exportKey("E18CA35213A9C8F4391BD7C519BEF9B23A8C0090"),
            startsWith("-----BEGIN PGP PUBLIC KEY BLOCK-----")
        )
    }

    @Test
    fun testDetachSign() {
        val signature = target.sign(
            byteArrayOf(1, 2, 3, 4),
            "E18CA35213A9C8F4391BD7C519BEF9B23A8C0090"
        )
        assertThat("Signature not empty", signature.isNotEmpty())
    }
}
