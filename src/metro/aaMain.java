package metro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class aaMain {

	public static final Logger log = LogManager.getLogger("Exc");
	public static final Logger log2 = LogManager.getLogger("Lobby");

	public static void main(String[] args) throws InterruptedException {

		LineList.startStations();
		Starter start = new Starter();
		start.passGo();

		Line greenLine = new Line("greenLine");
		for (int i = Db.getMinId(2); i <= (Db.getCount(2)) + (Db.getMinId(2)) - (1); i++) {
			greenLine.lineStations.add(new Station(Db.getStationName(i)));
		}
		Line redLine = new Line("greenLine");
		for (int i = Db.getMinId(3); i <= (Db.getCount(3)) + (Db.getMinId(3)) - (1); i++) {
			redLine.lineStations.add(new Station(Db.getStationName(i)));
		}

		ArrayList<Train> trains = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			trains.add(new Train());
			greenLine.lineTrains.add(new Train());
			redLine.lineTrains.add(new Train());
		}

		//
		//
		//
		//
		//
		//

		
		
		
		Station stationTest = LineList.greenStations.get(5);
		Train trainTest = trains.get(1);
		CyclicBarrier barrier = new CyclicBarrier(trainTest.train.size(), new Runnable() {
			
			@Override
			public void run() {
				System.out.println("поезд уехал");
				System.out.println("в первом вагоне пасажиров = " +trainTest.train.get(0).capacity.size());
				
			}
		});

		for (Wagon w : trainTest.train) {
			new Thread(new Runnable() {
				public void run() {

					
					if (!stationTest.lobby.isEmpty() && w.capacity.size() < w.getC()) {
						w.capacity.add(stationTest.passengers.remove(0));
					}
					
					try {
						barrier.await();
					} catch (Exception e) {
						e.getMessage();
					}
				}
			});

			
			
			
			//
			//
			//
			//
			//
			//

			Comparator<Driver> copmarator = new Comparator<Driver>() {

				@Override
				public int compare(Driver o1, Driver o2) {
					if (o1.getExp() > o2.getExp()) {
						return -1;
					}
					if (o1.getExp() < o2.getExp()) {
						return 1;
					}
					return 0;
				}

			};
			PriorityBlockingQueue<Driver> drivers = new PriorityBlockingQueue<>(5, copmarator);

			for (int i = 0; i < 5; i++) {
				drivers.add(new Driver());
			}
			// System.out.println(drivers);

			ArrayList<Thread> threads = new ArrayList<>();
			for (Train t : trains) {

				Thread driverThread = new Thread(new Runnable() {

					public void run() {

						try {
							Driver d = drivers.take();
							d.rndExp();
							Thread.sleep(((long) (Math.random() * 1000)) + 1);
							System.out.println(d.toString() + t.toString());

							drivers.put(d);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
				threads.add(driverThread);

				driverThread.start();

			}
			for (Thread t : threads) {
				t.join();
			}

			// System.out.println("\n" + drivers);

			// System.out.println(Db.getCount (1));

			// Db.insertInto("insert into stations
			// (name,cash,line)values('Akadem
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
			// w.capacity.remove((int) (Math.random()) * (w.capacity.size() -
			// 1));
			// System.out.println(w.capacity.size());

			//

			//

			// Db.getFrom("select * from stations");

		}

	}
}
