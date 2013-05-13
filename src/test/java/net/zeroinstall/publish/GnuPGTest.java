package net.zeroinstall.publish;

import java.io.IOException;
import static net.zeroinstall.publish.GnuPG.*;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Ignore("Communicates with a real GnuPG instance, which must be configured.")
public class GnuPGTest {

    @Test
    public void testGetPublicKey() throws IOException {
        assertThat(
                getPublicKey("E18CA35213A9C8F4391BD7C519BEF9B23A8C0090"),
                startsWith("-----BEGIN PGP PUBLIC KEY BLOCK-----"));
    }

    @Test
    public void testDetachSign() throws IOException {
        byte[] signature = detachSign("data", "E18CA35213A9C8F4391BD7C519BEF9B23A8C0090");
        assertThat(signature.length, is(greaterThan(0)));
    }
}
