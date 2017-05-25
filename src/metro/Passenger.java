package metro;

public class Passenger {

	String name = "";

	public Passenger() {
		for (int i = (int) ((Math.random() * 20)); i > 0; i--) {
			int r = (int) ((Math.random() * 125));
			name = name + (char) r;

		}
	}

	@Override
	public String toString() {
		return "Passenger [name =  " + name + "]";
	}

}
