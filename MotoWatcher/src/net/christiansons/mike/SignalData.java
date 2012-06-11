package net.christiansons.mike;
public class SignalData {
	private final Iterable<DownstreamSignalData> downstreamSignalData;
	private final UpstreamSignalData upstreamSignalData;
	
	public SignalData(Iterable<DownstreamSignalData> downstreamSignalData, UpstreamSignalData upstreamSignalData) {
		this.downstreamSignalData = downstreamSignalData;
		this.upstreamSignalData = upstreamSignalData;
	}
	
	public Iterable<DownstreamSignalData> getDownstreamSignalData() {
		return downstreamSignalData;
	}

	public UpstreamSignalData getUpstreamSignalData() {
		return upstreamSignalData;
	}

	public String toString() {
		return downstreamSignalData + " " + upstreamSignalData;
	}
}
