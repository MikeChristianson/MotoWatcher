package net.christiansons.mike;

public class DownstreamSignalData {

	private final SignalStats signalStats;
	private final DownstreamInfo downstreamInfo;

	public DownstreamSignalData(DownstreamInfo downstreamInfo, SignalStats signalStats) {
		this.downstreamInfo = downstreamInfo;
		this.signalStats = signalStats;
	}

	public String getChannelId() {
		return downstreamInfo.channelId;
	}

	public String getFrequency() {
		return downstreamInfo.frequency;
	}

	public String getSnr() {
		return downstreamInfo.snr;
	}

	public String getModulation() {
		return downstreamInfo.modulation;
	}

	public String getPower() {
		return downstreamInfo.power;
	}

	public SignalStats getSignalStats() {
		return signalStats;
	}

	public String toString() {
		return String.format("%s, %s", downstreamInfo, signalStats);
	}
}