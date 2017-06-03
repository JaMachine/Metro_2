package metro;

public class aaMain {

	public static void main(String[] args) {

		Line.startStations();

		Station s = Line.blueStations.get(0);

		Thread xx = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Passenger p = new Passenger();
					s.lobby.add(p);

					System.out.println("НА СТАНЦИИ ПАСАЖИР  " + p.name + p.hashCode());
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
		
	
		// System.out.println(Db.getCount (1));

		// Db.insertInto("insert into stations (name,cash,line)values('Akadem
		// Gorodok',0,3)");

		//

		//

		//

		// Train t = new Train();
		//
		// System.out.println(t.getTrain().get(1).getC());
		// for (int i = 0; i < 123; i++) {
		// t.getTrain().get(1).capacity.add(new Passenger());
		//
		// }
		// System.out.println((t.getTrain().get(1).getC()) -
		// (t.getTrain().get(1).capacity.size()));

		//

		//

		// Wagon w = new Wagon(true);
		//
		// while (w.capacity.size() < w.getC)
		// w.capacity.add(new Passenger());
		//
		// System.out.println(w.capacity.size());
		// System.out.println(w.capacity.get(w.capacity.size() - 1));
		// w.capacity.remove((int) (Math.random()) * (w.capacity.size() - 1));
		// System.out.println(w.capacity.size());

		//

		//

		// Db.getFrom("select * from stations");

	}

}
