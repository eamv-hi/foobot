package foobot.ejb;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import foobot.ejb.domain.Measurement;
import foobot.ejb.domain.MeasurementPK;
import foobot.entities.Measurements;

/**
 * Session Bean implementation class MeasurementBean
 */
@Stateless
public class MeasurementBean implements Measure {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Measurement domain) {
		MeasurementPK key = new MeasurementPK(domain.getUuid(), domain.getTime(), domain.getSensor());
		Measurements entity = em.find(Measurements.class, key);
		if (entity == null) {
			Measurements measure = new Measurements(domain);
			em.persist(measure);
		}
	}

	@Override
	public Optional<Measurement> read(MeasurementPK key) {
		Optional<Measurement> opt = Optional.empty();
		Measurements entity = em.find(Measurements.class, key);
		if (entity != null) {
			opt = Optional.of(entity.map(new Measurement()));
		}
		return opt;
	}

	@Override
	public void update(Measurement domain) {
		MeasurementPK key = new MeasurementPK(domain.getUuid(), domain.getTime(), domain.getSensor());
		Measurements entity = em.find(Measurements.class, key);
		if (entity != null) {
			entity.update(domain);
		} else {
			throw new RuntimeException("Measurement with id " + key + " not found");
		}
	}

	@Override
	public void delete(MeasurementPK key) {
		Measurements entity = em.find(Measurements.class, key);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new RuntimeException("Measurement with id " + key + " not found");
		}
	}

}
