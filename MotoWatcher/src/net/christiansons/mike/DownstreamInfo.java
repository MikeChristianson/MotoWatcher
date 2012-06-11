package net.christiansons.mike;

public class DownstreamInfo {
	
	public final String channelId;
	public final String frequency;
	public final String snr;
	public final String modulation;
	public final String power;

	public DownstreamInfo(String channelId, String frequency, String snr, String modulation, String power) {
		this.channelId = channelId;
		this.frequency = frequency;
		this.snr = snr;
		this.modulation = modulation;
		this.power = power;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s", channelId, frequency, snr, modulation, power);
	}
}