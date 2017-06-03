package metro;

public class Escalator implements Runnable {

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
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!s.lobby.isEmpty()) {

				Passenger p = s.lobby.remove(0);
				s.passengers.add(p);

				System.out.println("НА ЭСКАЛАТОРЕ "+id+" ПАСАЖИР  "+p.name + p.hashCode());
			} 
		}

	}

}
