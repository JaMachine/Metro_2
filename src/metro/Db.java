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

	public static void insertInto(String q) {

		try {
			Connection con = DriverManager.getConnection(url, passNlog, passNlog);

			Statement stm = con.createStatement();

			stm.executeUpdate(q);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getStationName(int i) {
		String result = "";
		try {
			Connection con = DriverManager.getConnection(url, passNlog, passNlog);

			Statement stm = con.createStatement();

			ResultSet res = stm.executeQuery("select name from metro_db.stations where id = " + i);

			while (res.next()) {
				result = result + res.getString("name");
			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return result;
	}

	public static int getCount(int i) {
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, passNlog, passNlog);

			Statement stm = con.createStatement();

			ResultSet res = stm.executeQuery("select count(*) from metro_db.stations where line = " + i);
			while (res.next()) {
				result = result + res.getInt("count(*)");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int getMinId(int i) {
		int result = 0;

		try {
			Connection con = DriverManager.getConnection(url, passNlog, passNlog);

			Statement stm = con.createStatement();

			ResultSet res = stm.executeQuery("select min(id) from metro_db.stations where line = " + i);
			while (res.next()) {
				result = result + res.getInt("min(id)");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
