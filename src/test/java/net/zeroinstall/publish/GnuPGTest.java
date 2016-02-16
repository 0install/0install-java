package net.zeroinstall.publish;

import org.junit.*;

@Ignore("Communicates with a real GnuPG instance, which must be configured.")
public class GnuPGTest extends OpenPgpTest {

    public GnuPGTest() {
        super(new GnuPG());
    }
}
