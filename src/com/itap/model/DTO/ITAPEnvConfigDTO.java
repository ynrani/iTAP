/*---------------------------------------------------------------------------------------
 * Object Name: ITAPEnvConfigDTO.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          10/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.model.DTO;

public class ITAPEnvConfigDTO
{
	private String envConfigId;
	private String actionBy;
	private String envDesc;
	private String envDockUrl;
	private String envHost;
	private String envIp;
	private String envName;
	private String envPassowrd;
	private String envSsl;
	private String envType;
	private String envUserName;

	public void setEnvConfigId(String envConfigId) {
		this.envConfigId = envConfigId;
	}

	public String getEnvConfigId() {
		return envConfigId;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setEnvDesc(String envDesc) {
		this.envDesc = envDesc;
	}

	public String getEnvDesc() {
		return envDesc;
	}

	public void setEnvDockUrl(String envDockUrl) {
		this.envDockUrl = envDockUrl;
	}

	public String getEnvDockUrl() {
		return envDockUrl;
	}

	public void setEnvHost(String envHost) {
		this.envHost = envHost;
	}

	public String getEnvHost() {
		return envHost;
	}

	public void setEnvIp(String envIp) {
		this.envIp = envIp;
	}

	public String getEnvIp() {
		return envIp;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getEnvName() {
		return envName;
	}

	public void setEnvPassowrd(String envPassowrd) {
		this.envPassowrd = envPassowrd;
	}

	public String getEnvPassowrd() {
		return envPassowrd;
	}

	public void setEnvSsl(String envSsl) {
		this.envSsl = envSsl;
	}

	public String getEnvSsl() {
		return envSsl;
	}

	public void setEnvType(String envType) {
		this.envType = envType;
	}

	public String getEnvType() {
		return envType;
	}

	public void setEnvUserName(String envUserName) {
		this.envUserName = envUserName;
	}

	public String getEnvUserName() {
		return envUserName;
	}

}