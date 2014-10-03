package net.zeroinstall.publish;

import net.zeroinstall.model.InterfaceDocument;
import static net.zeroinstall.publish.FeedUtils.*;
import org.apache.xmlbeans.XmlException;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FeedUtilsTest {

    @Test
    public void xmlPrelude() {
        InterfaceDocument feed = InterfaceDocument.Factory.newInstance();
        feed.addNewInterface();

        assertThat(toXmlText(feed), startsWith("<?xml"));
    }

    @Test
    public void xmlRoundtrip() throws XmlException {
        InterfaceDocument feed = InterfaceDocument.Factory.newInstance();
        feed.addNewInterface().addName("Test Name");
        feed = InterfaceDocument.Factory.parse(toXmlText(feed));

        assertThat(feed.getInterface().getNameArray(0), equalTo("Test Name"));
    }

    @Test
    public void stylesheet() {
        InterfaceDocument feed = InterfaceDocument.Factory.newInstance();
        feed.addNewInterface();
        addStylesheet(feed);

        assertThat(toXmlText(feed), containsString("<?xml-stylesheet type='text/xsl' href='feed.xsl'?>"));
    }
}
