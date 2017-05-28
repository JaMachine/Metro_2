package metro;

import java.util.ArrayList;

public class Line {
	// 1 = blue
	// 2 = green
	// 3 = red

	public static ArrayList<Station> blueStations = new ArrayList<>();
	public static ArrayList<Station> greenStations = new ArrayList<>();
	public static ArrayList<Station> redStations = new ArrayList<>();

	public static void startStations() {
		for (int i = Db.getMinId(1); i <= (Db.getCount(1)) + (Db.getMinId(1)) - (1); i++) {
			blueStations.add(new Station(Db.getStationName(i)));

		}
		for (int i = Db.getMinId(2); i <= (Db.getCount(2)) + (Db.getMinId(2)) - (1); i++) {
			greenStations.add(new Station(Db.getStationName(i)));

		}
		for (int i = Db.getMinId(3); i <= (Db.getCount(3)) + (Db.getMinId(3)) - (1); i++) {
			redStations.add(new Station(Db.getStationName(i)));

		}
	}

}
