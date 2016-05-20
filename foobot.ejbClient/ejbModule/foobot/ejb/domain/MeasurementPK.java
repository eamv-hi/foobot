package foobot.ejb.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MeasurementPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Uuid;
	private Timestamp time;
	private String sensor;
	
	public MeasurementPK() {
		super();
	}
	
	public MeasurementPK(String uuid, LocalDateTime time, String sensor) {
		this.Uuid = uuid;
		this.time = Timestamp.valueOf(time);
		this.sensor = sensor;
	}
	
	public String getUuid() {
		return Uuid;
	}
	public void setUuid(String uuid) {
		Uuid = uuid;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	@Override
	public String toString() {
		return "Measurement [Uuid=" + Uuid + ", time=" + time + ", sensor=" + sensor  + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Uuid == null) ? 0 : Uuid.hashCode());
		result = prime * result + ((sensor == null) ? 0 : sensor.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeasurementPK other = (MeasurementPK) obj;
		if (Uuid == null) {
			if (other.Uuid != null)
				return false;
		} else if (!Uuid.equals(other.Uuid))
			return false;
		if (sensor == null) {
			if (other.sensor != null)
				return false;
		} else if (!sensor.equals(other.sensor))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}


}
