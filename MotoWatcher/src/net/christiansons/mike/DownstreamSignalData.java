package net.christiansons.mike;

public class DownstreamSignalData {

	private final String channelId;
	private final String frequency;
	private final String snr;
	private final String modulation;
	private final String power;
	private final SignalStats signalStats;

	public DownstreamSignalData(DownstreamInfo parameterObject, SignalStats signalStats) {
		this.channelId = parameterObject.channelId;
		this.frequency = parameterObject.frequency;
		this.snr = parameterObject.snr;
		this.modulation = parameterObject.modulation;
		this.power = parameterObject.power;
		this.signalStats = signalStats;
	}

	public String getChannelId() {
		return channelId;
	}

	public String getFrequency() {
		return frequency;
	}

	public String getSnr() {
		return snr;
	}

	public String getModulation() {
		return modulation;
	}

	public String getPower() {
		return power;
	}

	public SignalStats getSignalStats() {
		return signalStats;
	}

	public String toString() {
		return String.format("Channel %s, %s, %s, %s, %s, %s", channelId,
				frequency, snr, modulation, power, signalStats);
	}
}