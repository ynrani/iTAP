package com.itap.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CROSS_BROWSER_GRID")
public class ITAPCrossBrowserGridDO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "GRID_ID")
	private int gridId;
	
	@Column(name = "GRID_TYPE")
	private String gridType;
	
	@Column(name = "GRID_URL")
	private String gridUrl;
	
	public int getGridId() {
		return gridId;
	}
	public void setGridId(int gridId) {
		this.gridId = gridId;
	}
	public String getGridType() {
		return gridType;
	}
	public void setGridType(String gridType) {
		this.gridType = gridType;
	}
	public String getGridUrl() {
		return gridUrl;
	}
	public void setGridUrl(String gridUrl) {
		this.gridUrl = gridUrl;
	}

}
