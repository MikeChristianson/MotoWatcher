package net.christiansons.mike;
import java.util.Collection;

import net.sourceforge.prowl.api.DefaultProwlEvent;
import net.sourceforge.prowl.api.ProwlClient;
import net.sourceforge.prowl.api.ProwlEvent;
import net.sourceforge.prowl.exception.ProwlException;


public class Notifier {
	
	private final String applicationName;
	private final String apiKey;

	public Notifier(String apiKey, String applicationName) {
		this.apiKey = apiKey;
		this.applicationName = applicationName;
	}
	
	public void sendNotifications(Iterable<Event> events) throws MotoException {
		ProwlClient prowl = new ProwlClient();
		for (Event event : events) {
			pushEvent(prowl, event);
		}
	}

	void pushEvent(ProwlClient prowl, Event event) throws MotoException {
		ProwlEvent e = makeProwlEvent(event);
		try {
			prowl.pushEvent(e);
		} catch (ProwlException ex) {
			throw new MotoException(ex);
		}
	}

	private ProwlEvent makeProwlEvent(Event event) {
		return new DefaultProwlEvent(apiKey, applicationName, event.event, event.message, 0);
	}

}
