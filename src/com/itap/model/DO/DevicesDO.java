package com.itap.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICES")
public class DevicesDO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEVICE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deviceId;
	
	@Column(name = "DEVICE_NAME")
	private String deviceName;
	
	@Column(name = "DEVICE_UDID")
	private String deviceUdid;
	
	@Column(name = "GRID_ID")
	private int gridUrlId;
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceUdid() {
		return deviceUdid;
	}
	public void setDeviceUdid(String deviceUdid) {
		this.deviceUdid = deviceUdid;
	}
	public int getGridUrlId() {
		return gridUrlId;
	}
	public void setGridUrlId(int gridUrlId) {
		this.gridUrlId = gridUrlId;
	}
}
