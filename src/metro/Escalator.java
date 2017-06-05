package metro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Escalator implements Runnable {

	public static final Logger log = LogManager.getLogger("Escalator");

	Station s;
	int id;

	public Escalator(int id, Station s) {
		this.id = id;
		this.s = s;
	}

	@Override
	public void run() {

		while (true) {

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				log.catching(e);
			}
			if (!s.lobby.isEmpty()) {

				Passenger p = s.lobby.remove(0);
				s.passengers.add(p);
				log.info("НА ЭСКАЛАТОРЕ " + id + " ПАСАЖИР  " + p.name + p.hashCode());
				System.out.println("НА ЭСКАЛАТОРЕ " + id + " ПАСАЖИР  " + p.name + p.hashCode());
			}
		}

	}

}
