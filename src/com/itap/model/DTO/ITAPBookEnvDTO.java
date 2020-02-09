/*
 * Object Name : ITAPBookEnvDTO.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  Durga		12:57:41 PM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.itap.model.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Durga
 *
 */
public class ITAPBookEnvDTO {

	private String appName;
	private String envName;
	private List<String> bookedDates = new ArrayList<String>();
	private List<String> appIds;
	private String projIdUrNo;
	private String bookReqtBy;
	private String bookType;
	private List<String> avilableDates;
	private String calDate;
	private long bookId;

	public String getProjIdUrNo() {
		return projIdUrNo;
	}

	public void setProjIdUrNo(String projIdUrNo) {
		this.projIdUrNo = projIdUrNo;
	}

	public String getBookReqtBy() {
		return bookReqtBy;
	}

	public void setBookReqtBy(String bookReqtBy) {
		this.bookReqtBy = bookReqtBy;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public List<String> getAppIds() {
		return appIds;
	}

	public void setAppIds(List<String> appIds) {
		this.appIds = appIds;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getEnvName() {
		return envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public List<String> getBookedDates() {
		return bookedDates;
	}

	public void setBookedDates(List<String> bookedDates) {
		this.bookedDates = bookedDates;
	}

	public String getCalDate() {
		return calDate;
	}

	public void setCalDate(String calDate) {
		this.calDate = calDate;
	}

	public List<String> getAvilableDates() {
		return avilableDates;
	}

	public void setAvilableDates(List<String> avilableDates) {
		this.avilableDates = avilableDates;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

}
