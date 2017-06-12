package metro;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Station {

	public Lock lobbyLock = new ReentrantLock(false);
	public Condition condition = lobbyLock.newCondition();


	private String name;
	private static int id = 0;
	private int stationId;
	private long cash = 0;
	ArrayList<Passenger> passengers = new ArrayList<>();
	ArrayList<Passenger> lobby = new ArrayList<>();

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
		return "Station [name=" + name + ", id=" + stationId + ", cash=" + cash + "]";
	}

}
