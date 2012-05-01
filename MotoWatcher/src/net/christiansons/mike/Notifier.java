package net.christiansons.mike;
import java.util.Collection;

import net.sourceforge.prowl.api.DefaultProwlEvent;
import net.sourceforge.prowl.api.ProwlClient;
import net.sourceforge.prowl.api.ProwlEvent;
import net.sourceforge.prowl.exception.ProwlException;


public class Notifier {
	public static void sendNotifications(Collection<Event> events) throws MotoException {
		if(!events.isEmpty()) {
			ProwlClient prowl = new ProwlClient();
			for (Event event : events) {
				ProwlEvent e = makeProwlEvent(event);
				try {
					prowl.pushEvent(e);
				} catch (ProwlException ex) {
					throw new MotoException(ex);
				}
			}
		}
	}

	private static ProwlEvent makeProwlEvent(Event event) {
		ProwlEvent e = new DefaultProwlEvent(
				"d05f692bcc569070492e4b8956e12b713b6b2369", 
				MotoWatcher.class.getSimpleName(), 
				event.event, event.message, 0);
		return e;
	}

}
