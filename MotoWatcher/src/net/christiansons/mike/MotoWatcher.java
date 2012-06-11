package net.christiansons.mike;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;

public class MotoWatcher {
	public static void main(String[] args) throws IOException, MotoException, InterruptedException {
		SignalData signalData = Moto.getSignalData();
		
		Iterable<DownstreamSignalData> downstreamSignalData = signalData.getDownstreamSignalData();
		Collection<Event> downstreamSignalDataMessages = checkDownstreamSignalData(downstreamSignalData);
		UpstreamSignalData upstreamSignalData = signalData.getUpstreamSignalData();
		Event checkUpstreamSignalDataMessage = checkUpstreamSignalData(upstreamSignalData);
		
		Collection<Event> events = new ArrayDeque<Event>(downstreamSignalDataMessages);
		if(checkUpstreamSignalDataMessage != null) {
			events.add(checkUpstreamSignalDataMessage);
		}
		
		Notifier notifier = new Notifier("apiKey", MotoWatcher.class.getSimpleName());
		notifier.sendNotifications(events);
	}

	private static Collection<Event> checkDownstreamSignalData(Iterable<DownstreamSignalData> downstreamSignalData) {
		Deque<Event> messages = new ArrayDeque<Event>();
		for (DownstreamSignalData downstreamSignalDatum : downstreamSignalData) {
			String channelId = downstreamSignalDatum.getChannelId();
			
			String power = downstreamSignalDatum.getPower();
			String[] split = power.split(" ");
			int powerLevel = Integer.valueOf(split[0]);
			if(powerLevel < -15 || powerLevel > 15) {
				Event n = new Event("Downstream Power Level", "out of range: " + powerLevel);
				messages.add(n);
			}
			
			String snr = downstreamSignalDatum.getSnr();
			String [] ssplit = snr.split(" ");
			int signalRatio = Integer.valueOf(ssplit[0]);
			if(signalRatio < 35) {
				Event n = new Event("Downstream Signal-to-Noise Ratio", "out of range: " + signalRatio);
				messages.add(n);
			}
		}
		
		return Collections.unmodifiableCollection(messages);
	}

	private static Event checkUpstreamSignalData(UpstreamSignalData upstreamSignalData) {
		String power = upstreamSignalData.getPower();
		String[] split = power.split(" ");
		int powerLevel = Integer.valueOf(split[0]);
		if(powerLevel < 39 || powerLevel > 52) {
			Event n = new Event("Upstream Power Level", "out of range: " + powerLevel);
			return n;
		}
		return null;
	}
	
}
