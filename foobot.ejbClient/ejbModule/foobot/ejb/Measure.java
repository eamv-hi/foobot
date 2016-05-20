package foobot.ejb;

import java.util.Optional;

import javax.ejb.Local;

import foobot.ejb.domain.Measurement;
import foobot.ejb.domain.MeasurementPK;

@Local
public interface Measure {

	void create(Measurement domain);

	Optional<Measurement> read(MeasurementPK key);

	void update(Measurement domain);

	void delete(MeasurementPK key);

}
