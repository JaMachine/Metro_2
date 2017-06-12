package metro;

import java.util.Random;

public class Driver {

	private int exp;
	private static int id = 0;
	private int driverId;

	public Driver() {
		id++;
		driverId = id;

		int r = (int) ((Math.random() * 2));

		if (r == 0) {
			this.exp = 20 + (int) ((Math.random() * 5));
		} else if (r == 1) {
			this.exp = 50 + (int) ((Math.random() * 5));
		} else {
			this.exp = 100 + (int) ((Math.random() * 5));
		}

	}

	public void rndExp() {
		Random r = new Random();

		this.exp += r.nextInt(20);


	}

	public int getExp() {
		return exp;
	}

	public int getDriverId() {
		return driverId;
	}

	@Override
	public String toString() {
		return "Driver [exp=" + exp + ", driverId=" + driverId + "]";
	}

}
