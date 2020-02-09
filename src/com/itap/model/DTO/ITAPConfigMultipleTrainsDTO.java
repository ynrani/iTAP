package com.itap.model.DTO;

import java.util.List;

// Sushil Create a class to save all trains jobs in list

public class ITAPConfigMultipleTrainsDTO {

	private long serverId;

	private List<String> trainJobs;

	public List<String> getTrainJobs() {
		return trainJobs;
	}

	public void setTrainJobs(List<String> trainJobs) {
		this.trainJobs = trainJobs;
	}

	public long getServerId() {
		return serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}
}
