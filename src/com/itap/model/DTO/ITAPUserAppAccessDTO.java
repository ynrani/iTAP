/*---------------------------------------------------------------------------------------
 * Object Name: ITAPUserAppAccessDTO.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          26/02/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.model.DTO;

import java.util.List;

public class ITAPUserAppAccessDTO
{
	private String id;
	private String actionBy;
	private String appId;
	private String userAccess;
	private String userId;

	private String uid;

	private List<String> users;
	private List<String> apps;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppId() {
		return appId;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public String getUserAccess() {
		return userAccess;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public List<String> getApps() {
		return apps;
	}

	public void setApps(List<String> apps) {
		this.apps = apps;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}