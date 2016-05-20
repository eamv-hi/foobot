package foobot.ejb.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Batch implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uuid;
	private LocalDateTime start;
	private LocalDateTime end;
	private String compatibility;
	
	private List<Measurement> measurements = new ArrayList<>();

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public String getCompatibility() {
		return compatibility;
	}

	public void setCompatibility(String compatibility) {
		this.compatibility = compatibility;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	@Override
	public String toString() {
		return "Batch [uuid=" + uuid + ", start=" + start + ", end=" + end + ", compatibility=" + compatibility
				+ ", measurements=" + measurements + "]";
	}
	
	

}
