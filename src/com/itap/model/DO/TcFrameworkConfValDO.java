package com.itap.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * The persistent class for the TC_FRAMEWORK_CONF_VAL database table.
 * 
 */
@Entity
@Table(name = "TC_FRAMEWORK_CONF_VAL")
@NamedQuery(name = "TcFrameworkConfValDO.findAll", query = "SELECT t FROM TcFrameworkConfValDO t")
public class TcFrameworkConfValDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FRAMEWORK_CONFIG_VAL_ID")
	private long frameworkConfigValId;

	private String fld1;

	private String fld10;

	private String fld11;

	private String fld12;

	private String fld13;

	private String fld14;

	private String fld15;

	private String fld16;

	private String fld17;

	private String fld18;

	private String fld19;

	private String fld2;

	private String fld20;

	private String fld3;

	private String fld4;

	private String fld5;

	private String fld6;

	private String fld7;

	private String fld8;

	private String fld9;

	@Column(name = "FRAMEWORK_ID")
	private String frameworkId;

	// bi-directional many-to-one association to TcFrameworkConfigDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FRAMEWORK_CONFIG_ID")
	@Cascade({ CascadeType.ALL })
	private TcFrameworkConfigDO tcFrameworkConfig;

	// bi-directional many-to-one association to TestCaseDO

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TC_ID")
	@Cascade({ CascadeType.ALL })
	private TestCaseDO testCase;

	public TcFrameworkConfValDO() {
	}

	public long getFrameworkConfigValId() {
		return this.frameworkConfigValId;
	}

	public void setFrameworkConfigValId(long frameworkConfigValId) {
		this.frameworkConfigValId = frameworkConfigValId;
	}

	public String getFld1() {
		return this.fld1;
	}

	public void setFld1(String fld1) {
		this.fld1 = fld1;
	}

	public String getFld10() {
		return this.fld10;
	}

	public void setFld10(String fld10) {
		this.fld10 = fld10;
	}

	public String getFld11() {
		return this.fld11;
	}

	public void setFld11(String fld11) {
		this.fld11 = fld11;
	}

	public String getFld12() {
		return this.fld12;
	}

	public void setFld12(String fld12) {
		this.fld12 = fld12;
	}

	public String getFld13() {
		return this.fld13;
	}

	public void setFld13(String fld13) {
		this.fld13 = fld13;
	}

	public String getFld14() {
		return this.fld14;
	}

	public void setFld14(String fld14) {
		this.fld14 = fld14;
	}

	public String getFld15() {
		return this.fld15;
	}

	public void setFld15(String fld15) {
		this.fld15 = fld15;
	}

	public String getFld16() {
		return this.fld16;
	}

	public void setFld16(String fld16) {
		this.fld16 = fld16;
	}

	public String getFld17() {
		return this.fld17;
	}

	public void setFld17(String fld17) {
		this.fld17 = fld17;
	}

	public String getFld18() {
		return this.fld18;
	}

	public void setFld18(String fld18) {
		this.fld18 = fld18;
	}

	public String getFld19() {
		return this.fld19;
	}

	public void setFld19(String fld19) {
		this.fld19 = fld19;
	}

	public String getFld2() {
		return this.fld2;
	}

	public void setFld2(String fld2) {
		this.fld2 = fld2;
	}

	public String getFld20() {
		return this.fld20;
	}

	public void setFld20(String fld20) {
		this.fld20 = fld20;
	}

	public String getFld3() {
		return this.fld3;
	}

	public void setFld3(String fld3) {
		this.fld3 = fld3;
	}

	public String getFld4() {
		return this.fld4;
	}

	public void setFld4(String fld4) {
		this.fld4 = fld4;
	}

	public String getFld5() {
		return this.fld5;
	}

	public void setFld5(String fld5) {
		this.fld5 = fld5;
	}

	public String getFld6() {
		return this.fld6;
	}

	public void setFld6(String fld6) {
		this.fld6 = fld6;
	}

	public String getFld7() {
		return this.fld7;
	}

	public void setFld7(String fld7) {
		this.fld7 = fld7;
	}

	public String getFld8() {
		return this.fld8;
	}

	public void setFld8(String fld8) {
		this.fld8 = fld8;
	}

	public String getFld9() {
		return this.fld9;
	}

	public void setFld9(String fld9) {
		this.fld9 = fld9;
	}

	public String getFrameworkId() {
		return this.frameworkId;
	}

	public void setFrameworkId(String frameworkId) {
		this.frameworkId = frameworkId;
	}

	public TcFrameworkConfigDO getTcFrameworkConfig() {
		return this.tcFrameworkConfig;
	}

	public void setTcFrameworkConfig(TcFrameworkConfigDO tcFrameworkConfig) {
		this.tcFrameworkConfig = tcFrameworkConfig;
	}

	public TestCaseDO getTestCase() {
		return this.testCase;
	}

	public void setTestCase(TestCaseDO testCase) {
		this.testCase = testCase;
	}

}