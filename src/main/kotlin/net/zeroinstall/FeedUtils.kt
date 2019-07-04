package net.zeroinstall

//package net.zeroinstall
//
//import com.google.common.base.Charsets
//import com.google.common.io.BaseEncoding.base64
//import java.io.*
//import java.util.Scanner
//import net.zeroinstall.model.InterfaceDocument
//import org.apache.xmlbeans.*
//
///**
// * Utility class for performing operations on feed files.
// */
//object FeedUtils {
//
//    /**
//     * Serializes a feed to an XML string with a stylesheet declaration and an optional GnuPG signature.
//     *
//     * @param openPgp The OpenPGP implementation to use for generating the signature.
//     * @param feed The feed to be serialized.
//     * @param keySpecifier The name of the GnuPG key to use for signing. `null` for no signature.
//     * @throws IOException A problem occurred while calling the GnuPG executable.
//     * @return the java.lang.String
//     */
//    @Throws(IOException::class)
//    fun getFeedString(openPgp: OpenPgp, feed: InterfaceDocument, keySpecifier: String?): String {
//        addStylesheet(feed)
//        val xmlText = toXmlText(feed)
//        return keySpecifier?.let { appendSignature(openPgp, xmlText, it) } ?: xmlText
//    }
//
//    /**
//     * Reads the entire content of a stream to a string.
//     *
//     * @param stream The stream to read.
//     * @return The string read from the stream or `null` if the stream was empty.
//     */
//    fun readAll(stream: InputStream): String? {
//        val scanner = Scanner(stream).useDelimiter("\\A")
//        return if (scanner.hasNext()) scanner.next() else null
//    }
//
//    internal fun addStylesheet(feed: InterfaceDocument) {
//        val cursor = feed.newCursor()
//        cursor.toNextToken()
//        cursor.insertProcInst("xml-stylesheet", "type='text/xsl' href='feed.xsl'")
//    }
//
//    internal fun toXmlText(feed: InterfaceDocument): String {
//        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + feed.xmlText(XmlOptions().setUseDefaultNamespace().setSavePrettyPrint())
//    }
//
//    @Throws(IOException::class)
//    internal fun appendSignature(openPgp: OpenPgp, xmlText: String, keySpecifier: String): String {
//        var xmlText = xmlText
//        xmlText += "\n"
//
//        val xmlData = Charsets.UTF_8.encode(xmlText).array()
//        val signature = base64().encode(openPgp.sign(xmlData, keySpecifier))
//        return "$xmlText<!-- Base64 Signature\n$signature\n-->\n"
//    }
//}
