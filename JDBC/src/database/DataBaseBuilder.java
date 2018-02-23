package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import databaseContent.Mountain;;

public class DataBaseBuilder {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:mountains.db";

	private Connection conn;
	private Statement stat;

	public DataBaseBuilder() {
		try {
			Class.forName(DataBaseBuilder.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem polaczenia");
			e.printStackTrace();
		}

		createTables();
	}

	public boolean createTables() {
		String createMountain = "CREATE TABLE IF NOT EXISTS mountains (id_mountain INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), range varchar(255), height int, path varchar(255), text text )";
		try {
			stat.execute(createMountain);
		} catch (SQLException e) {
			System.err.println("Blad przy tworzeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertMountain(String name, String range, int height, String path, String text) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into mountains values (NULL, ?, ?, ?,?,?);");
			prepStmt.setString(1, name);
			prepStmt.setString(2, range);
			prepStmt.setInt(3, height);
			prepStmt.setString(4, path);
			prepStmt.setString(5, text);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad przy wstawianiu gory");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void change(String searchedField, String searchedValue, String changedField, String newValue) {

		try {
			// Polecenie zmiany
			String changeSQL = "UPDATE mountains SET " + changedField + " = '" + newValue + "' WHERE " + searchedField
					+ "='" + searchedValue + "';";
			System.out.println("Polecenie zmiany:\n" + changeSQL);
			// Uwaga: wywołujemy metodę executeUpdate
			stat.executeUpdate(changeSQL);

		} catch (Exception e) {
			System.out.println("Nie mogę poprawić danych " + e.getMessage());
		}
	}

	public void delete(String deleteField, String deleteValue) {

		try {
			String deleteSQL = "DELETE FROM mountains WHERE " + deleteField + "='" + deleteValue + "';";
			System.out.println("Polecenie:\n" + deleteSQL);
			stat.executeUpdate(deleteSQL);

		} catch (Exception e) {
			System.out.println("Nie mogę usunąć danych " + e.getMessage());
		}
	}

	public List<Mountain> selectMountain(String Query) {
		List<Mountain> mountains = new LinkedList<Mountain>();
		try {
			ResultSet result = stat.executeQuery(Query);
			int id, height;
			String name, range, path, text;
			while (result.next()) {
				id = result.getInt("id_mountain");
				name = result.getString("name");
				range = result.getString("range");
				height = result.getInt("height");
				path = result.getString("path");
				text = result.getString("text");
				mountains.add(new Mountain(id, name, range, height, path, text));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mountains;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Problem z zamknieciem polaczenia");
			e.printStackTrace();
		}
	}
}