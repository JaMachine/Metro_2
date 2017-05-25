package metro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db {

	private static String url = "jdbc:mysql://localhost:3306/metro_db";
	private static String passNlog = "root";

	public static void getFrom(String q) {
		try {
			Connection con = DriverManager.getConnection(url, passNlog, passNlog);

			Statement stm = con.createStatement();

			ResultSet res = stm.executeQuery(q);

			while (res.next())
				System.out.println("id = " + res.getInt("id") + "\n" + "name = " + res.getString("name") + "\n"
						+ "cash = " + res.getInt("cash") + "\n");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
