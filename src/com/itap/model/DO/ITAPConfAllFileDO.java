package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the AUTO_HUB_CONF_ALL_FILES database table.
 * 
 */
@Entity
@Table(name = "AUTO_HUB_CONF_ALL_FILES")
@NamedQuery(name = "ITAPConfAllFileDO.findAll", query = "SELECT a FROM ITAPConfAllFileDO a")
public class ITAPConfAllFileDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONF_ALL_FILE_ID")
	private long confAllFileId;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DATE")
	private Timestamp actionDate;

	@Column(name = "BDD_FILE_NAME")
	private String bddFileName;

	@Column(name = "BDD_FILE_PATH")
	private String bddFilePath;

	@Column(name = "CAFE_MOBFILE_NAME")
	private String cafeMobfileName;

	@Column(name = "CAFE_MOBFILE_PATH")
	private String cafeMobfilePath;

	@Column(name = "CAFE_SELFILE_NAME")
	private String cafeSelfileName;

	@Column(name = "CAFE_SELFILE_PATH")
	private String cafeSelfilePath;

	@Column(name = "CAFE_UFTFILE_NAME")
	private String cafeUftfileName;

	@Column(name = "CAFE_UFTFILE_PATH")
	private String cafeUftfilePath;

	@Column(name = "OPTIK_FILE_NAME")
	private String optikFileName;

	@Column(name = "OPTIK_FILE_PATH")
	private String optikFilePath;

	@Column(name = "TWIST_FILE_NAME")
	private String twistFileName;

	@Column(name = "TWIST_FILE_PATH")
	private String twistFilePath;

	@Column(name = "CC_FILE_PATH")
	private String ccFilePath;

	@Column(name = "CC_FILE_NAME")
	private String ccFileName;

	@Column(name = "API_FILE_PATH")
	private String apiFilePath;

	@Column(name = "API_FILE_NAME")
	private String apiFileName;

	public ITAPConfAllFileDO() {
	}

	public long getConfAllFileId() {
		return this.confAllFileId;
	}

	public void setConfAllFileId(long confAllFileId) {
		this.confAllFileId = confAllFileId;
	}

	public String getActionBy() {
		return this.actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Timestamp getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Timestamp actionDate) {
		this.actionDate = actionDate;
	}

	public String getBddFileName() {
		return this.bddFileName;
	}

	public void setBddFileName(String bddFileName) {
		this.bddFileName = bddFileName;
	}

	public String getBddFilePath() {
		return this.bddFilePath;
	}

	public void setBddFilePath(String bddFilePath) {
		this.bddFilePath = bddFilePath;
	}

	public String getCafeMobfileName() {
		return this.cafeMobfileName;
	}

	public void setCafeMobfileName(String cafeMobfileName) {
		this.cafeMobfileName = cafeMobfileName;
	}

	public String getCafeMobfilePath() {
		return this.cafeMobfilePath;
	}

	public void setCafeMobfilePath(String cafeMobfilePath) {
		this.cafeMobfilePath = cafeMobfilePath;
	}

	public String getCafeSelfileName() {
		return this.cafeSelfileName;
	}

	public void setCafeSelfileName(String cafeSelfileName) {
		this.cafeSelfileName = cafeSelfileName;
	}

	public String getCafeSelfilePath() {
		return this.cafeSelfilePath;
	}

	public void setCafeSelfilePath(String cafeSelfilePath) {
		this.cafeSelfilePath = cafeSelfilePath;
	}

	public String getCafeUftfileName() {
		return this.cafeUftfileName;
	}

	public void setCafeUftfileName(String cafeUftfileName) {
		this.cafeUftfileName = cafeUftfileName;
	}

	public String getCafeUftfilePath() {
		return this.cafeUftfilePath;
	}

	public void setCafeUftfilePath(String cafeUftfilePath) {
		this.cafeUftfilePath = cafeUftfilePath;
	}

	public String getOptikFileName() {
		return this.optikFileName;
	}

	public void setOptikFileName(String optikFileName) {
		this.optikFileName = optikFileName;
	}

	public String getOptikFilePath() {
		return this.optikFilePath;
	}

	public void setOptikFilePath(String optikFilePath) {
		this.optikFilePath = optikFilePath;
	}

	public String getTwistFileName() {
		return this.twistFileName;
	}

	public void setTwistFileName(String twistFileName) {
		this.twistFileName = twistFileName;
	}

	public String getTwistFilePath() {
		return this.twistFilePath;
	}

	public void setTwistFilePath(String twistFilePath) {
		this.twistFilePath = twistFilePath;
	}

}