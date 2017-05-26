package metro;

import java.util.ArrayList;

public class Line {
	// 1 = blue

	public static ArrayList<Station> blueStations = new ArrayList<>();

	public static void startStations() {
		for (int i = 1; i < 19; i++) {
			blueStations.add(new Station(Db.getStationName(i)));

		}
	}

}
