package net.christiansons.mike;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

import nu.xom.Document;
import nu.xom.Nodes;
import nu.xom.XPathContext;


public class SignalDataDocumentParser {

	private final static XPathContext context = new XPathContext("html", "http://www.w3.org/1999/xhtml");

	public static SignalData getSignalData(final Document statusPage) {
		final Iterable<DownstreamSignalData> downstreamSignalData = getDownstreamSignalData(statusPage);
		final UpstreamSignalData upstreamSignalData = getUpstreamSignalData(statusPage);
		final SignalData signalData = new SignalData(downstreamSignalData, upstreamSignalData);
		return signalData;
	}

	private static Iterable<DownstreamSignalData> getDownstreamSignalData(final Document document) {
		Deque<DownstreamSignalData> downstreamSignalData = new ArrayDeque<DownstreamSignalData>();
		for (int i = 2; i < 6; i++) {  //four columns, starting at position 2
			SignalStats signalStats = getSignalStats(document, i);
			DownstreamInfo downstreamInfo = getDownstreamInfo(document, i);
			DownstreamSignalData signalData = new DownstreamSignalData(downstreamInfo, signalStats);
			downstreamSignalData.add(signalData);
		}
		return Collections.unmodifiableCollection(downstreamSignalData);
	}

	private static SignalStats getSignalStats(final Document document, int i) {
		String signalQuery = String.format("//html:body/html:center[3]/html:table/html:tbody/html:tr/html:td[%d]", i);
		Nodes signalNodes = document.query(signalQuery, context);
		String signalChannelId = getText(signalNodes, 0);
		String unerrored = getText(signalNodes, 1);
		String correctable = getText(signalNodes, 2);
		String uncorrectable = getText(signalNodes, 3);
		SignalStats signalStats = new SignalStats(signalChannelId, unerrored, correctable, uncorrectable);
		return signalStats;
	}

	private static DownstreamInfo getDownstreamInfo(final Document document, int i) {
		String downstreamQuery = String.format("//html:body/html:center[1]/html:table/html:tbody/html:tr/html:td[%d]", i);
		Nodes downstreamNodes = document.query(downstreamQuery, context);
		String downstreamChannelId = getText(downstreamNodes, 0);
		String frequency = getText(downstreamNodes, 1);
		String snr = getText(downstreamNodes, 2);
		String modulation = getText(downstreamNodes, 3);
		String power = getText(downstreamNodes, 4);
	
		DownstreamInfo info = new DownstreamInfo(downstreamChannelId, frequency, snr, modulation, power);
		return info;
	}

	private static UpstreamSignalData getUpstreamSignalData(final Document signal) {
		String upstreamQuery = "//html:body/html:center[2]/html:table/html:tbody/html:tr/html:td[2]";
		Nodes upstreamNodes = signal.query(upstreamQuery, context);
		String channelId = getText(upstreamNodes, 0);
		String frequency = getText(upstreamNodes, 1);
		String rangingId = getText(upstreamNodes, 2);
		String symbolRate = getText(upstreamNodes, 3);
		String power = getText(upstreamNodes, 4);
		String modulation = getText(upstreamNodes, 5);
		String status = getText(upstreamNodes, 6);
	
		UpstreamSignalData upstreamSignalData = new UpstreamSignalData(channelId, frequency, rangingId, symbolRate, power, modulation, status);
		return upstreamSignalData;
	}

	private static String getText(Nodes nodes, int index) {
		return clean(nodes.get(index).getValue());
	}

	private static String clean(String string) {
		string = string.replaceAll("\\s\\s+", " ");
		string = string.replaceAll("\u00A0", "");
		string = string.replaceAll("\n", "");
		string = string.trim();
		return string;
	}

}
