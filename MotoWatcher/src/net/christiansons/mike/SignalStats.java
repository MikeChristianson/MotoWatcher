package net.christiansons.mike;

public class SignalStats {

	public final String channelId;
	public final String unerrored;
	public final String correctable;
	public final String uncorrectable;

	public SignalStats(String channelId, String unerrored,
			String correctable, String uncorrectable) {
		this.channelId = channelId;
		this.unerrored = unerrored;
		this.correctable = correctable;
		this.uncorrectable = uncorrectable;
	}

	public String toString() {
		return String.format("Channel %s: %s, %s, %s, %s", channelId,
				unerrored, uncorrectable, correctable, uncorrectable);
	}
}