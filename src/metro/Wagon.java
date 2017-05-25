package metro;

import java.util.ArrayList;

public class Wagon {

	private int c; // capacity
	// private boolean m; // main wagon
	public ArrayList<Passenger> capacity = new ArrayList<>(c);

	public Wagon(boolean m) {
		// this.m = m;
		if (m == true)
			c = 340;
		else
			c = 350;
	}

	public int getC() {
		return c;
	}

}
