package foobot.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import foobot.ejb.domain.Measurement;
import foobot.ejb.domain.MeasurementPK;

@Entity
@IdClass(MeasurementPK.class)
public class Measurements implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String Uuid;
	@Id
	private Timestamp time;
	@Id
	private String sensor;
	private String units;
	private double value;
	
	public Measurements() {
		super();
	}
	
	public Measurements(Measurement measure) {
		update(measure);
	}
	
	public Measurements update(Measurement measure) {
		this.Uuid = measure.getUuid();
		this.time = Timestamp.valueOf(measure.getTime());
		this.sensor = measure.getSensor();
		this.units = measure.getUnits();
		this.value = measure.getValue();
		return this;
	}
	
	public Measurement map(Measurement measure) {
		measure.setUuid(this.Uuid);
		measure.setTime(this.time.toLocalDateTime());
		measure.setSensor(this.sensor);
		measure.setUnits(this.units);
		measure.setValue(this.value);
		return measure;
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


}
