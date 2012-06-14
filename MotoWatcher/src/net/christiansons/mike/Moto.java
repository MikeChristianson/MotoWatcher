package net.christiansons.mike;
import java.io.IOException;

import nu.xom.Document;


public class Moto {
	public final static String DEFAULT_URL = "http://192.168.100.1/cmSignalData.htm";

	public static void main(String[] args) throws IOException, MotoException {
		SignalData signalData = getSignalData(args);
		System.out.println(signalData);
	}
	
	public static SignalData getSignalData() throws IOException, MotoException {
		return getSignalData(new String[0]);
	}

	static SignalData getSignalData(String[] args) throws IOException, MotoException {
		String url = DEFAULT_URL;
		if(args.length == 1) {
			url = args[0];
		}
		Document signalDataDocument = SignalDataDocumentBuilder.build(url);
		return SignalDataDocumentParser.getSignalData(signalDataDocument); 
	}
	
}
