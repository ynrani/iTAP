package com.itap.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CROSS_BROWSER_BROWSEROPTIONS")
public class ITAPCrossBrowserOptions implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BROWSER_ID")
	private int id;
	
	@Column(name = "BROWSER_OS_ID")
	private int osId;
	
	@Column(name = "BROWSER_NAME")
	private String browserName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOsId() {
		return osId;
	}

	public void setOsId(int osId) {
		this.osId = osId;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	@Column(name = "BROWSER_VERSION")
	private String browserVersion;

}
