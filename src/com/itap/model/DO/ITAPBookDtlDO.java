package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the REMS_BOOK_DTLS database table.
 * 
 */
@Entity
@Table(name = "REMS_BOOK_DTLS")
@NamedQuery(name = "ITAPBookDtlDO.findAll", query = "SELECT r FROM ITAPBookDtlDO r")
public class ITAPBookDtlDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BOOK_ID")
	private long bookId;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DT")
	private Timestamp actionDt;

	@Column(name = "APP_ID")
	private String appId;

	@Column(name = "BOOK_DESC")
	private String bookDesc;

	@Temporal(TemporalType.DATE)
	@Column(name = "BOOK_END_DT")
	private Date bookEndDt;

	@Column(name = "BOOK_STS")
	private String bookSts;

	@Column(name = "BOOK_REQT_BY")
	private String bookReqtBy;

	@Column(name = "BOOK_REQT_PH")
	private String bookReqtPh;

	@Column(name = "BOOK_REQT_EMAIL")
	private String bookReqtEmail;

	@Temporal(TemporalType.DATE)
	@Column(name = "BOOK_STRT_DT_PREP")
	private Date bookStrtDtPrep;

	@Temporal(TemporalType.DATE)
	@Column(name = "BOOK_STRT_DT_TST")
	private Date bookStrtDtTst;

	@Column(name = "BOOK_TYPE")
	private String bookType;

	@Column(name = "ENV_ID")
	private String envId;

	@Column(name = "PROJ_ID_UR_NO")
	private String projIdUrNo;

	public ITAPBookDtlDO() {
	}

	public long getBookId() {
		return this.bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getActionBy() {
		return this.actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Timestamp getActionDt() {
		return this.actionDt;
	}

	public void setActionDt(Timestamp actionDt) {
		this.actionDt = actionDt;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getBookDesc() {
		return this.bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public Date getBookEndDt() {
		return this.bookEndDt;
	}

	public void setBookEndDt(Date bookEndDt) {
		this.bookEndDt = bookEndDt;
	}

	public String getBookReqtPh() {
		return this.bookReqtPh;
	}

	public void setBookReqtPh(String bookReqtPh) {
		this.bookReqtPh = bookReqtPh;
	}

	public String getBookReqtEmail() {
		return this.bookReqtEmail;
	}

	public void setBookReqtEmail(String bookReqtEmail) {
		this.bookReqtEmail = bookReqtEmail;
	}

	public Date getBookStrtDtPrep() {
		return this.bookStrtDtPrep;
	}

	public void setBookStrtDtPrep(Date bookStrtDtPrep) {
		this.bookStrtDtPrep = bookStrtDtPrep;
	}

	public Date getBookStrtDtTst() {
		return this.bookStrtDtTst;
	}

	public void setBookStrtDtTst(Date bookStrtDtTst) {
		this.bookStrtDtTst = bookStrtDtTst;
	}

	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getEnvId() {
		return this.envId;
	}

	public void setEnvId(String envId) {
		this.envId = envId;
	}

	public String getProjIdUrNo() {
		return this.projIdUrNo;
	}

	public void setProjIdUrNo(String projIdUrNo) {
		this.projIdUrNo = projIdUrNo;
	}

	public String getBookSts() {
		return bookSts;
	}

	public void setBookSts(String bookSts) {
		this.bookSts = bookSts;
	}

	public String getBookReqtBy() {
		return bookReqtBy;
	}

	public void setBookReqtBy(String bookReqtBy) {
		this.bookReqtBy = bookReqtBy;
	}

}