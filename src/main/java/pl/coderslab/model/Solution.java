package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution {
	private int id;
	private String created;
	private String updated;
	private String description;
	private int excercise_id;
	private int users_id;
	
	
	
	public Solution(String description, int excercise_id, int users_id) {
		this.description = description;
		this.excercise_id = excercise_id;
		this.users_id = users_id;
	}
	
	public Solution() {
		
	}
	
	public String getCreated() {
		return created;
	}
	
	public String getUpdated() {
		return updated;
	}
	
	public void setCreated(String created) {
		this.created = created;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getExcercise_id() {
		return excercise_id;
	}
	public void setExcercise_id(int excercise_id) {
		this.excercise_id = excercise_id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public int getId() {
		return id;
	}
	
	//additional method to print the actual user data
	public void showSolution() {
		System.out.println("Id: " + getId() + ", created: " + getCreated() + ", updated: " + getUpdated() + ", description: " + getDescription() + ", users_id: " + getUsers_id() + ", excercise_id: " + getExcercise_id());
	}
	
	public void saveToDB(Connection conn) throws SQLException { 
		if (this.id == 0) {
			String sql = "INSERT INTO Solution (created, description, excercise_id, users_id) VALUES (NOW(), ?, ?, ?)"; 
			// jakie kolumny baza zwróci po zapisie nowego obiektu - w tym wypadku id
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns); 
			preparedStatement.setString(1, this.description);
			preparedStatement.setInt(2, this.excercise_id);
			preparedStatement.setInt(3, this.users_id); 
			preparedStatement.executeUpdate();
			
			//wyrzuca w resultsecie generatedColumns
			ResultSet rs = preparedStatement.getGeneratedKeys(); 
			
			//Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu.
			if (rs.next()) {
				this.id = rs.getInt(1); 
				}
			} else {
			 String sql = "UPDATE Solution SET created=NOW(), description=?, excercise_id =?, users_id = ? where id = ?"; 
			 PreparedStatement preparedStatement;
			 preparedStatement = conn.prepareStatement(sql); 
			 preparedStatement.setString(1, this.description);
			 preparedStatement.setInt(2, this.excercise_id);
			 preparedStatement.setInt(3, this.users_id);
			 preparedStatement.setInt(4, this.id);
			 preparedStatement.executeUpdate();
			 }
		}
	static public Solution loadSolutionById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM Solution where id=?";
		PreparedStatement preparedStatement;
		
		//przygotowanie Statementu z podanego stringa sql
		preparedStatement = conn.prepareStatement(sql); 
		preparedStatement.setInt(1, id);
		// wczytanie selecta 
		ResultSet resultSet = preparedStatement.executeQuery(); 
		
		//patrzy czy jest ten uzytkownik
		if (resultSet.next()) {
			
			//pobieram wartosci z resultseta - zwraca nam loadedSolutiona
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id"); 
			loadedSolution.description = resultSet.getString("description"); 
			loadedSolution.excercise_id = resultSet.getInt("excercise_id"); 
			loadedSolution.users_id = resultSet.getInt("users_id"); 
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			return loadedSolution;
			}
		
		//jesli nie ma usera o podanym id - zwraca null
	    return null;
	    }
	static public Solution[] loadAllSolutions(Connection conn) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM Solution"; 
		PreparedStatement preparedStatement; 
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery(); 
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id"); 
			loadedSolution.description = resultSet.getString("description"); 
			loadedSolution.excercise_id = resultSet.getInt("excercise_id"); 
			loadedSolution.users_id = resultSet.getInt("users_id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			solutions.add(loadedSolution);
			}
		// tworzą tablicę o takiej samej wielkosci co lista
		Solution[] uArray = new Solution[solutions.size()];
		// przekopiowują listę do tablicy
		uArray = solutions.toArray(uArray); 
		return uArray;
		}


	static public Solution[] loadAllSolutions(Connection conn, int numberSolutions) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<>();
		String sql = ("SELECT * FROM Solution ORDER BY updated desc LIMIT "+numberSolutions);
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.excercise_id = resultSet.getInt("excercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			solutions.add(loadedSolution);
		}
		// tworzą tablicę o takiej samej wielkosci co lista
		Solution[] uArray = new Solution[solutions.size()];
		// przekopiowują listę do tablicy
		uArray = solutions.toArray(uArray);
		return uArray;
	}



	public void delete(Connection conn) throws SQLException { 
		if (this.id != 0) {
			String sql = "DELETE FROM Solution WHERE id= ?"; 
			PreparedStatement preparedStatement; 
			preparedStatement = conn.prepareStatement(sql); 
			preparedStatement.setInt(1, this.id); 
			preparedStatement.executeUpdate();
			this.id=0; 
		}
	}
	static public Solution[] loadAllByUserId (Connection conn, int id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "select created, updated, description, username, users_id, excercise_id, users.id from solution join users on solution.users_id=users.id where solution.users_id =?;"; 
		PreparedStatement preparedStatement;
		
		//przygotowanie Statementu z podanego stringa sql
		preparedStatement = conn.prepareStatement(sql); 
		preparedStatement.setInt(1, id);
		// wczytanie selecta 
		ResultSet resultSet = preparedStatement.executeQuery(); 
		
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id"); 
			loadedSolution.description = resultSet.getString("description"); 
			loadedSolution.users_id = resultSet.getInt("users_id");
			loadedSolution.excercise_id = resultSet.getInt("excercise_id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			solutions.add(loadedSolution);
			}
		// tworzą tablicę o takiej samej wielkosci co lista
		Solution[] uArray = new Solution[solutions.size()];
		// przekopiowują listę do tablicy
		uArray = solutions.toArray(uArray); 
		return uArray;
	}
	
	static public Solution[] loadAllByExcerciseId (Connection conn, int id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "select created, updated, solution.description, users_id, excercise_id, excercise.id from solution join excercise on solution.excercise_id=excercise.id where solution.excercise_id =?;"; 
		PreparedStatement preparedStatement;
		
		//przygotowanie Statementu z podanego stringa sql
		preparedStatement = conn.prepareStatement(sql); 
		preparedStatement.setInt(1, id);
		// wczytanie selecta 
		ResultSet resultSet = preparedStatement.executeQuery(); 
		
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id"); 
			loadedSolution.description = resultSet.getString("solution.description"); 
			loadedSolution.users_id = resultSet.getInt("users_id");
			loadedSolution.excercise_id = resultSet.getInt("excercise_id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			solutions.add(loadedSolution);
			}
		// tworzą tablicę o takiej samej wielkosci co lista
		Solution[] uArray = new Solution[solutions.size()];
		// przekopiowują listę do tablicy
		uArray = solutions.toArray(uArray); 
		return uArray;
	}
	static public Solution[] loadAllNotUpdatedByUserId (Connection conn, int id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "select created, updated, description, username, users_id, excercise_id, users.id from solution join users on solution.users_id=users.id where solution.users_id =? and solution.updated IS null;"; 
		PreparedStatement preparedStatement;
		
		//przygotowanie Statementu z podanego stringa sql
		preparedStatement = conn.prepareStatement(sql); 
		preparedStatement.setInt(1, id);
		// wczytanie selecta 
		ResultSet resultSet = preparedStatement.executeQuery(); 
		
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id"); 
			loadedSolution.description = resultSet.getString("description"); 
			loadedSolution.users_id = resultSet.getInt("users_id");
			loadedSolution.excercise_id = resultSet.getInt("excercise_id");
			loadedSolution.created = resultSet.getString("created");
			loadedSolution.updated = resultSet.getString("updated");
			solutions.add(loadedSolution);
			}
		// tworzą tablicę o takiej samej wielkosci co lista
		Solution[] uArray = new Solution[solutions.size()];
		// przekopiowują listę do tablicy
		uArray = solutions.toArray(uArray); 
		return uArray;
	}
}
