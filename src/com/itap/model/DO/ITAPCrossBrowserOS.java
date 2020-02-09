package com.itap.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CROSS_BROWSER_OS")
public class ITAPCrossBrowserOS implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "OS_ID")
	private int osId;
	
	@Column(name = "OS_NAME")
	private String osName;

	public int getOsId() {
		return osId;
	}

	public void setOsId(int osId) {
		this.osId = osId;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}
}
