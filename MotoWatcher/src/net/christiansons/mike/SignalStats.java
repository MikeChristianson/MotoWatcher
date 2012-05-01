package net.christiansons.mike;

public class SignalStats {

	private final String channelId;
	private final String unerrored;
	private final String correctable;
	private final String uncorrectable;

	public SignalStats(String channelId, String unerrored,
			String correctable, String uncorrectable) {
		this.channelId = channelId;
		this.unerrored = unerrored;
		this.correctable = correctable;
		this.uncorrectable = uncorrectable;
	}

	public String getChannelId() {
		return channelId;
	}

	public String getUnerrored() {
		return unerrored;
	}

	public String getCorrectable() {
		return correctable;
	}

	public String getUncorrectable() {
		return uncorrectable;
	}

	public String toString() {
		return String.format("Channel %s, %s, %s, %s, %s", channelId,
				unerrored, uncorrectable, correctable, uncorrectable);
	}
}