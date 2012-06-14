package net.christiansons.mike;

import net.sourceforge.prowl.api.DefaultProwlEvent;
import net.sourceforge.prowl.api.ProwlEvent;

public class ProwlEventFactory {

	public static ProwlEvent defaultProwlEvent(Event event, String apiKey, String applicationName) {
		return new DefaultProwlEvent(apiKey, applicationName, event.event, event.message, 0);
	}

}
