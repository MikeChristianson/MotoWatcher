package net.christiansons.mike;

import java.io.IOException;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SignalDataDocumentBuilder {

	public static Document build(String url) throws IOException, MotoException {
		try {
			return buildDocument(url);
		} catch(Exception e) {
			throw new MotoException(e);
		}
	}

	private static Document buildDocument(String url) throws SAXException, ParsingException, ValidityException, IOException {
		final XMLReader tagsoup = XMLReaderFactory.createXMLReader("org.ccil.cowan.tagsoup.Parser");
		final Builder bob = new Builder(tagsoup);
		return bob.build(url);
	}

}
