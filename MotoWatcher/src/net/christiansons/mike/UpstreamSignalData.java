package net.christiansons.mike;

public class UpstreamSignalData {

	private final String channelId;
	private final String frequency;
	private final String rangingId;
	private final String symbolRate;
	private final String power;
	private final String modulation;
	private final String status;

	public UpstreamSignalData(String channelId, String frequency,
			String rangingId, String symbolRate, String power,
			String modulation, String status) {
		this.channelId = channelId;
		this.frequency = frequency;
		this.rangingId = rangingId;
		this.symbolRate = symbolRate;
		this.power = power;
		this.modulation = modulation;
		this.status = status;
	}

	public String getChannelId() {
		return channelId;
	}

	public String getFrequency() {
		return frequency;
	}

	public String getRangingId() {
		return rangingId;
	}

	public String getSymbolRate() {
		return symbolRate;
	}

	public String getPower() {
		return power;
	}

	public String getModulation() {
		return modulation;
	}

	public String getStatus() {
		return status;
	}

	public String toString() {
		return String.format("Upstream channel %s, %s, %s, %s, %s, %s, %s",
				channelId, frequency, rangingId, symbolRate, power,
				modulation, status);
	}
}