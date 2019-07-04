package net.zeroinstall

//package net.zeroinstall
//
//import net.zeroinstall.model.InterfaceDocument
//import net.zeroinstall.FeedUtils.*
//import org.apache.xmlbeans.XmlException
//import org.junit.*
//import org.hamcrest.MatcherAssert.assertThat
//import org.hamcrest.Matchers.*
//
//class FeedUtilsTest {
//
//    @Test
//    fun xmlPrelude() {
//        val feed = InterfaceDocument.Factory.newInstance()
//        feed.addNewInterface()
//
//        assertThat(toXmlText(feed), startsWith("<?xml"))
//    }
//
//    @Test
//    @Throws(XmlException::class)
//    fun xmlRoundtrip() {
//        var feed = InterfaceDocument.Factory.newInstance()
//        feed.addNewInterface().addName("Test Name")
//        feed = InterfaceDocument.Factory.parse(toXmlText(feed))
//
//        assertThat(feed.getInterface().getNameArray(0), equalTo("Test Name"))
//    }
//
//    @Test
//    fun stylesheet() {
//        val feed = InterfaceDocument.Factory.newInstance()
//        feed.addNewInterface()
//        addStylesheet(feed)
//
//        assertThat(toXmlText(feed), containsString("<?xml-stylesheet type='text/xsl' href='feed.xsl'?>"))
//    }
//}
