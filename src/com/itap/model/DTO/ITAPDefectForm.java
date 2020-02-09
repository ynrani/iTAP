package com.itap.model.DTO;

import java.util.List;

public class ITAPDefectForm {

	private List<ITAPToolDefects> toolDefectsList ;
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<ITAPToolDefects> getToolDefectsList() {
		return toolDefectsList;
	}

	public void setToolDefectsList(List<ITAPToolDefects> toolDefectsList) {
		this.toolDefectsList = toolDefectsList;
	}
}
