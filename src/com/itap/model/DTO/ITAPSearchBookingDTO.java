/*
 * Object Name : ITAPSearchBookingDTO.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  Durga		11:55:49 AM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.itap.model.DTO;

import java.util.List;

/**
 * @author Durga
 *
 */
public class ITAPSearchBookingDTO {
	private String app1;
	private String app2;
	private String app3;
	private String startDate;
	private String endDate;
	private List<String> passedDates;
	private List<ITAPBookEnvDTO> listITAPBookEnvDTO;
	private List<String> avilableDates;
	private List<String> apps;

	private String preDt;
	private String nxtDt;

	public List<String> getApps() {
		return apps;
	}

	public void setApps(List<String> apps) {
		this.apps = apps;
	}

	public String getApp1() {
		return app1;
	}

	public void setApp1(String app1) {
		this.app1 = app1;
	}

	public String getApp2() {
		return app2;
	}

	public void setApp2(String app2) {
		this.app2 = app2;
	}

	public String getApp3() {
		return app3;
	}

	public void setApp3(String app3) {
		this.app3 = app3;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<String> getPassedDates() {
		return passedDates;
	}

	public void setPassedDates(List<String> passedDates) {
		this.passedDates = passedDates;
	}

	public List<ITAPBookEnvDTO> getListITAPBookEnvDTO() {
		return listITAPBookEnvDTO;
	}

	public void setListITAPBookEnvDTO(List<ITAPBookEnvDTO> listITAPBookEnvDTO) {
		this.listITAPBookEnvDTO = listITAPBookEnvDTO;
	}

	public List<String> getAvilableDates() {
		return avilableDates;
	}

	public void setAvilableDates(List<String> avilableDates) {
		this.avilableDates = avilableDates;
	}

	public String getPreDt() {
		return preDt;
	}

	public void setPreDt(String preDt) {
		this.preDt = preDt;
	}

	public String getNxtDt() {
		return nxtDt;
	}

	public void setNxtDt(String nxtDt) {
		this.nxtDt = nxtDt;
	}

}
