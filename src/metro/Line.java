package metro;

import java.util.LinkedList;

public class Line {
	
	String name;
	LinkedList<Train> lineTrains;
	LinkedList<Station> lineStations;

	public Line(String name) {
		this.name = name;
		this.lineTrains= new LinkedList<>();
		this.lineStations = new LinkedList<Station>();
		
	}
}
