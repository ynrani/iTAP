package com.itap.alm.beans;

public class ExcelMappingDO {

	private String projectName;
	private String xmlFieldName;
	private String almFieldName;
	private String fieldScopeType;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(final String projectName) {
		this.projectName = projectName;
	}

	public String getXmlFieldName() {
		return xmlFieldName;
	}

	public void setXmlFieldName(final String xmlFieldName) {
		this.xmlFieldName = xmlFieldName;
	}

	public String getAlmFieldName() {
		return almFieldName;
	}

	public void setAlmFieldName(final String almFieldName) {
		this.almFieldName = almFieldName;
	}

	public String getFieldScopeType() {
		return fieldScopeType;
	}

	public void setFieldScopeType(final String fieldScopeType) {
		this.fieldScopeType = fieldScopeType;
	}
}
