package org.generation.italy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	private final static String url = "jdbc:mysql://localhost:/nations";
	private final static String user = "root";
	private final static String password = "root";
	
	public static void main(String[] args) {
				querynation();
				
				}
				
	private static void querynation() {
				Scanner sc =new Scanner(System.in);
				System.out.println("cerca una nazione:");
				String state =sc.next();
				sc.close();
				
				
				try {
					
					try(Connection con = DriverManager.getConnection(url, user, password)){
					
					final String sql = "SELECT countries.country_id,countries.name,"
							+ " countries.region_id FROM countries JOIN regions"
							+ " ON countries.region_id = regions.region_id "
							+ "JOIN continents ON regions.continent_id = continents.continent_id;";
					
					try(PreparedStatement ps = con.prepareStatement(sql)){
					ps.setString(1, state);
						try(ResultSet rs = ps.executeQuery()){
						
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final String name = rs.getString(2);
						final String Regionsname = rs.getString(3);
	
						
						
						System.out.println(id + " - " + name+
								 " - " + Regionsname + "-" + "-");
						ps.close();
					}
					}
					}
					
				}} catch (SQLException ex) {
					
					ex.printStackTrace();	
				}
				}}

