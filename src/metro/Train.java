package metro;

import java.util.ArrayList;

public class Train {

	private static int trainId = 0;
	private int id;

	ArrayList<Wagon> train = new ArrayList<>();

	public Train() {
		trainId++;
		id = trainId;

		train.add(new Wagon(true));
		train.add(new Wagon(true));
		for (int i = 0; i < 3; i++)
			train.add(new Wagon(false));
	}

	public ArrayList<Wagon> getTrain() {
		return train;
	}

	public int getId() {
		return id;

	}

}
