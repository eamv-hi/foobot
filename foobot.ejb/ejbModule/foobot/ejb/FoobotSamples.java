package foobot.ejb;

import java.io.Serializable;
import java.util.List;

public class FoobotSamples implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uuid;
	private long start;
	private long end;
	private List<String> sensors;
	private List<String> units;
	private List<List<Double>> datapoints;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public List<String> getSensors() {
		return sensors;
	}
	public void setSensors(List<String> sensors) {
		this.sensors = sensors;
	}
	public List<String> getUnits() {
		return units;
	}
	public void setUnits(List<String> units) {
		this.units = units;
	}
	public List<List<Double>> getDatapoints() {
		return datapoints;
	}
	public void setDatapoints(List<List<Double>> datapoints) {
		this.datapoints = datapoints;
	}
	@Override
	public String toString() {
		return "FoobotSamples [uuid=" + uuid + ", start=" + start + ", end=" + end + ", sensors=" + sensors + ", units="
				+ units + ", datapoints=" + datapoints + "]";
	}

}
