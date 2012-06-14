package net.christiansons.mike;

import net.sourceforge.prowl.api.ProwlClient;
import net.sourceforge.prowl.api.ProwlEvent;
import net.sourceforge.prowl.exception.ProwlException;

public class ProwlNotifier implements Notifier {
	
	private final String applicationName;
	private final String apiKey;

	public ProwlNotifier(String apiKey, String applicationName) {
		this.apiKey = apiKey;
		this.applicationName = applicationName;
	}
	
	/* (non-Javadoc)
	 * @see net.christiansons.mike.Notifier#sendNotifications(java.lang.Iterable)
	 */
	@Override
	public void sendNotifications(Iterable<Event> events) throws MotoException {
		ProwlClient prowl = new ProwlClient();
		for (Event event : events) {
			pushEvent(prowl, event);
		}
	}

	void pushEvent(ProwlClient prowl, Event event) throws MotoException {
		ProwlEvent e = ProwlEventFactory.defaultProwlEvent(event, apiKey, applicationName);
		try {
			prowl.pushEvent(e);
		} catch (ProwlException ex) {
			throw new MotoException(ex);
		}
	}

}
