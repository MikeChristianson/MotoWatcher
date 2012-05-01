package net.christiansons.mike;

public class DownstreamInfo {
	public String channelId;
	public String frequency;
	public String snr;
	public String modulation;
	public String power;

	public DownstreamInfo(String channelId, String frequency, String snr, String modulation, String power) {
		this.channelId = channelId;
		this.frequency = frequency;
		this.snr = snr;
		this.modulation = modulation;
		this.power = power;
	}
}