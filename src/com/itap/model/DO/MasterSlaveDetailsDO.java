package com.itap.model.DO;

public class MasterSlaveDetailsDO {
	private String name;
	private String architecture;
	private String clockDifference;
	private String freeDiskSpace;
	private String freeSwapSpace;
	private String freeTempSpace;
	private String responseTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getClockDifference() {
		return clockDifference;
	}

	public void setClockDifference(String clockDifference) {
		this.clockDifference = clockDifference;
	}

	public String getFreeDiskSpace() {
		return freeDiskSpace;
	}

	public void setFreeDiskSpace(String freeDiskSpace) {
		this.freeDiskSpace = freeDiskSpace;
	}

	public String getFreeSwapSpace() {
		return freeSwapSpace;
	}

	public void setFreeSwapSpace(String freeSwapSpace) {
		this.freeSwapSpace = freeSwapSpace;
	}

	public String getFreeTempSpace() {
		return freeTempSpace;
	}

	public void setFreeTempSpace(String freeTempSpace) {
		this.freeTempSpace = freeTempSpace;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

}
