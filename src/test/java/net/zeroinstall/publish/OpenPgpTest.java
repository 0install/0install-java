package net.zeroinstall.publish;

import java.io.IOException;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public abstract class OpenPgpTest {

    private final OpenPgp target;

    protected OpenPgpTest(OpenPgp target) {
        this.target = target;
    }

    @Test
    public void testGetPublicKey() throws IOException {
        assertThat(
                target.exportKey("E18CA35213A9C8F4391BD7C519BEF9B23A8C0090"),
                startsWith("-----BEGIN PGP PUBLIC KEY BLOCK-----"));
    }

    @Test
    public void testDetachSign() throws IOException {
        byte[] signature = target.sign(
                new byte[]{1, 2, 3, 4},
                "E18CA35213A9C8F4391BD7C519BEF9B23A8C0090");
        assertThat(signature.length, is(greaterThan(0)));
    }
}
