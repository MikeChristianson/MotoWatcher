package net.christiansons.mike;

public interface Notifier {

	public abstract void sendNotifications(Iterable<Event> events) throws MotoException;

}