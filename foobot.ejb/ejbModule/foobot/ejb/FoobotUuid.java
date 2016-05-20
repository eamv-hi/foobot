package foobot.ejb;

import java.io.Serializable;

public class FoobotUuid implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mac;
	private String name;
	private int userId;
	private String uuid;
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "FoobotUuid [mac=" + mac + ", name=" + name + ", userId=" + userId + ", uuid=" + uuid + "]";
	}
	

}
