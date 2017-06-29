package metro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Starter {
	
	public static final Logger log = LogManager.getLogger("Exc");
	public static final Logger log2 = LogManager.getLogger("Lobby");
	Line line;

	public void startStations() {
		line = new Line("greenLine");
		for (int i = Db.getMinId(2); i <= (Db.getCount(2)) + (Db.getMinId(2)) - (1); i++) {
			line.lineStations.add(new Station(Db.getStationName(i)));
		}
		Line redLine = new Line("greenLine");
		for (int i = Db.getMinId(3); i <= (Db.getCount(3)) + (Db.getMinId(3)) - (1); i++) {
			redLine.lineStations.add(new Station(Db.getStationName(i)));
		}

	}
	
	public void passGo(){
		for (Station s : LineList.greenStations) {

			Thread xx = new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							log.catching(e);
							e.printStackTrace();
						}
						Passenger p = new Passenger();
						s.lobby.add(p);

						s.lobbyLock.lock();
						s.condition.signalAll();
						s.lobbyLock.unlock();

						//log2.info("НА СТАНЦИИ ПАСАЖИР  " + p.name + p.hashCode());

						//System.out.println("НА СТАНЦИИ ПАСАЖИР " + p.name +
						// p.hashCode());
					}
				}
			});

			xx.start();
			
			Escalator one = new Escalator(1, s);
			Escalator two = new Escalator(2, s);
			Escalator three = new Escalator(3, s);

			Thread tOne = new Thread(one);
			Thread tTwo = new Thread(two);
			Thread tThree = new Thread(three);

			tOne.start();
			tTwo.start();
			tThree.start();
		}

	}

}
