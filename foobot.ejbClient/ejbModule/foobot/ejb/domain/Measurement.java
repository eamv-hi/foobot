package foobot.ejb.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Measurement implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Uuid;
	private LocalDateTime time;
	private String sensor;
	private String units;
	private double value;
	
	public String getUuid() {
		return Uuid;
	}
	public void setUuid(String uuid) {
		Uuid = uuid;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Measurement [Uuid=" + Uuid + ", time=" + time + ", sensor=" + sensor + ", units=" + units + ", value="
				+ value + "]";
	}


}
