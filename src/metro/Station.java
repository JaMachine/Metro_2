package metro;

import java.util.ArrayList;

public class Station {

	private String name;
	private static int id = 0;
	private int stationId;
	private long cash = 0;
	ArrayList<Passenger> passengers = new ArrayList<>();

	public Station(String name) {
		id++;
		stationId = id;
		this.name = name;

	}

	public long getCash() {
		return cash;
	}

	public int getStationId() {
		return stationId;
	}

	public void setCash(long cashbox) {
		this.cash = cashbox;
	}

	@Override
	public String toString() {
		return "Station [name=" + name + ", id=" + id + ", cash=" + cash + "]";
	}

}
