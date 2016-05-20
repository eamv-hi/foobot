package foobot.ejb;

import java.time.LocalDateTime;

import javax.ejb.Local;

@Local
public interface Foobot {

	boolean importDataFromServer(String userid, String password, LocalDateTime from, LocalDateTime end);

}
