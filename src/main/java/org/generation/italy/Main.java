package org.generation.italy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	private final static String url = "jdbc:mysql://localhost:3306/nations";
	private final static String user = "root";
	private final static String password = "root";
	
	public static void main(String[] args) {
				querynation();
				
				}
				
	private static void querynation() {
		try(Connection con = DriverManager.getConnection(url, user, password);Scanner sc =new Scanner(System.in)){
			
					 
				System.out.println("cerca una nazione:");
				String state ='%' + sc.nextLine() + '%';
					
					final String sqlRegCon = " SELECT countries.country_id AS 'id', countries.name AS 'country', regions.name AS 'region', continents.name AS 'continent' "
							 + " FROM countries "+ "JOIN regions "+ "ON countries.region_id = regions.region_id "
							 + "JOIN continents "+ "ON regions.continent_id = continents.continent_id "
							 + "WHERE countries.name LIKE ? "+ "ORDER BY countries.name ";
							
					
					try(PreparedStatement ps = con.prepareStatement(sqlRegCon)){
					ps.setString(1, state);
						try(ResultSet rs = ps.executeQuery()){
						
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final String name = rs.getString(2);
						final String Regionsname = rs.getString(3);
						final String continent = rs.getString(4);
						
						System.out.println("(" + id + ") " + name
									+ " - " + Regionsname + " - " + continent);
					}
					}
					}
				
				} catch (SQLException ex) {
					
				 System.err.println("ERROR: " );
}}}

