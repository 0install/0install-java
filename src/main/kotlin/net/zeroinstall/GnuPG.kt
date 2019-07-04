package net.zeroinstall

//package net.zeroinstall
//
//import com.google.common.base.Preconditions.checkNotNull
//import com.google.common.io.ByteStreams.toByteArray
//import java.io.*
//import net.zeroinstall.FeedUtils.readAll
//
///**
// * Provides access to the signature functions of GnuPG.
// */
//class GnuPG : OpenPgp {
//
//    @Throws(IOException::class)
//    override fun sign(data: ByteArray, keySpecifier: String): ByteArray {
//        val process = ProcessBuilder(
//            "gpg", "--detach-sign", "--default-key", checkNotNull(keySpecifier), "--output", "-", "-"
//        ).start()
//
//        val outputStream = process.outputStream
//        outputStream.write(data)
//        outputStream.close()
//        waitForExit(process)
//
//        return toByteArray(process.inputStream)
//    }
//
//    @Throws(IOException::class)
//    override fun exportKey(keySpecifier: String): String {
//        val process = ProcessBuilder(
//            "gpg", "-a", "--export", checkNotNull(keySpecifier)
//        ).start()
//        waitForExit(process)
//
//        return readAll(process.inputStream)
//    }
//
//    @Throws(IOException::class)
//    private fun waitForExit(process: Process) {
//        try {
//            if (process.waitFor() != 0) {
//                val errorMessage = readAll(process.errorStream)
//                throw IOException(errorMessage)
//            }
//        } catch (ex: InterruptedException) {
//            throw IOException(ex)
//        }
//
//    }
//}
