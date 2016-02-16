package net.zeroinstall.publish;

import com.google.common.base.Charsets;
import static com.google.common.io.BaseEncoding.base64;
import java.io.*;
import java.util.Scanner;
import net.zeroinstall.model.InterfaceDocument;
import org.apache.xmlbeans.*;

/**
 * Utility class for performing operations on feed files.
 */
public final class FeedUtils {

    private FeedUtils() {
    }

    /**
     * Serializes a feed to an XML string with a stylesheet declaration and an
     * optional GnuPG signature.
     *
     * @param openPgp The OpenPGP implementation to use for generating the
     * signature.
     * @param feed The feed to be serialized.
     * @param keySpecifier The name of the GnuPG key to use for signing.
     * <code>null</code> for no signature.
     * @throws IOException A problem occurred while calling the GnuPG
     * executable.
     * @return the java.lang.String
     */
    public static String getFeedString(OpenPgp openPgp, InterfaceDocument feed, String keySpecifier) throws IOException {
        addStylesheet(feed);
        String xmlText = toXmlText(feed);
        return (keySpecifier == null) ? xmlText : appendSignature(openPgp, xmlText, keySpecifier);
    }

    /**
     * Reads the entire content of a stream to a string.
     *
     * @param stream The stream to read.
     * @return The string read from the stream or <code>null</code> if the
     * stream was empty.
     */
    public static String readAll(InputStream stream) {
        Scanner scanner = new Scanner(stream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : null;
    }

    static void addStylesheet(InterfaceDocument feed) {
        XmlCursor cursor = feed.newCursor();
        cursor.toNextToken();
        cursor.insertProcInst("xml-stylesheet", "type='text/xsl' href='feed.xsl'");
    }

    static String toXmlText(InterfaceDocument feed) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + feed.xmlText(new XmlOptions().setUseDefaultNamespace().setSavePrettyPrint());
    }

    static String appendSignature(OpenPgp openPgp, String xmlText, String keySpecifier) throws IOException {
        xmlText += "\n";

        byte[] xmlData = Charsets.UTF_8.encode(xmlText).array();
        String signature = base64().encode(openPgp.sign(xmlData, keySpecifier));
        return xmlText + "<!-- Base64 Signature\n" + signature + "\n-->\n";
    }
}
