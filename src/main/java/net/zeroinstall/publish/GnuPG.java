package net.zeroinstall.publish;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.io.ByteStreams.toByteArray;
import java.io.*;
import static net.zeroinstall.publish.FeedUtils.readAll;

/**
 * Provides access to the signature functions of GnuPG.
 */
public class GnuPG implements OpenPgp {

    @Override
    public byte[] sign(byte[] data, String keySpecifier) throws IOException {
        Process process = new ProcessBuilder(
                "gpg", "--detach-sign", "--default-key", checkNotNull(keySpecifier), "--output", "-", "-").
                start();

        OutputStream outputStream = process.getOutputStream();
        outputStream.write(data);
        outputStream.close();
        waitForExit(process);

        return toByteArray(process.getInputStream());
    }

    @Override
    public String exportKey(String keySpecifier) throws IOException {
        Process process = new ProcessBuilder(
                "gpg", "-a", "--export", checkNotNull(keySpecifier)).
                start();
        waitForExit(process);

        return readAll(process.getInputStream());
    }

    private static void waitForExit(Process process) throws IOException {
        try {
            if (process.waitFor() != 0) {
                String errorMessage = readAll(process.getErrorStream());
                throw new IOException(errorMessage);
            }
        } catch (InterruptedException ex) {
            throw new IOException(ex);
        }
    }
}
