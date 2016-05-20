package foobot.ejb;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import foobot.ejb.domain.Measurement;

/**
 * Session Bean implementation class FoobotBean
 */
@Stateless
public class FoobotBean implements Foobot {
	@EJB private Measure ejb;
	
	private final static String path = "https://api.foobot.io/v2/";

	@Override
	public boolean importDataFromServer(String userid, String password, LocalDateTime from, LocalDateTime end) {
		boolean rc = false;
		String jwt = performLogin(userid, password);
		List<FoobotUuid> uuids = getIdentity(userid, jwt);
		for (FoobotUuid uuid : uuids) {
			FoobotSamples samples = getSamples(uuid.getUuid(), from, end, jwt);
			persistSamples(samples);
		}
		

		return rc;
	}
	
	private String performLogin(String userid, String password) {
		Client client = ClientBuilder.newClient();
		
		// login
		Response loginresp = client.target(path + "user/" + userid + "/login/")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.json("{\"password\":\"" + password + "\"}"));
		String jwt = loginresp.getHeaderString("x-auth-token");
		client.close();
		return jwt;
	}
	
	private List<FoobotUuid> getIdentity(String userid, String jwt) {
		Client client = ClientBuilder.newClient();
		List<FoobotUuid> uuids = client.target(path + "owner/" + userid + "/device/")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("x-auth-token", jwt)
				.get(new GenericType<List<FoobotUuid>>(){});
		client.close();
		return uuids;
	}
	
	private FoobotSamples getSamples(String uuid, LocalDateTime from, LocalDateTime end, String jwt) {
		// Test get samples
		Client client = ClientBuilder.newClient();
		DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
		FoobotSamples samples = client.target(path + "device/" + 
				uuid + 
				"/datapoint/" +
				from.format(format) +
				"/" +
				end.format(format) +
				"/0/")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("x-auth-token", jwt)
				.get(FoobotSamples.class);
		client.close();
		return samples;
	}
	
	private void persistSamples(FoobotSamples samples) {
		for (List<Double> sample: samples.getDatapoints()) {
			LocalDateTime time = LocalDateTime.ofEpochSecond((long) sample.get(0).doubleValue(), 0, ZoneOffset.UTC);
			for (int i=1; i < samples.getSensors().size(); i++) {
				Measurement measure = new Measurement();
				measure.setUuid(samples.getUuid());
				measure.setTime(time);
				measure.setSensor(samples.getSensors().get(i));
				measure.setUnits(samples.getUnits().get(i));
				measure.setValue(sample.get(i));
				ejb.create(measure);
			}
		}
	}
}
