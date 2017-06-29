package metro;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLines extends HttpServlet {
	ArrayList<Station> sendStations = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String in = req.getParameter("lines123");

		switch (in) {
		case "Green":
			for (int i = Db.getMinId(2); i <= (Db.getCount(2)) + (Db.getMinId(2)) - (1); i++) {
				sendStations.add(new Station(Db.getStationName(i)));
			}
			break;
		case "Blue":
			for (int i = Db.getMinId(1); i <= (Db.getCount(1)) + (Db.getMinId(1)) - (1); i++) {
				sendStations.add(new Station(Db.getStationName(i)));
			}
			break;
		case "Red":
			for (int i = Db.getMinId(3); i <= (Db.getCount(3)) + (Db.getMinId(3)) - (1); i++) {
				sendStations.add(new Station(Db.getStationName(i)));
			}
			break;
			default: //???????
		}
		
		req.setAttribute("Stations",sendStations);

	}

}
