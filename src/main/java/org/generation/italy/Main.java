package org.generation.italy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
	
		
				String url = "jdbc:mysql://localhost:/nations";
				String user = "root";
				String password = "root";
				String continentsName = "";
				 
				Connection con = null;
				try {
					
					con = DriverManager.getConnection(url, user, password);
					
					final String sql = "SELECT countries.country_id,countries.name,"
							+ " countries.region_id FROM countries JOIN regions"
							+ " ON countries.region_id = regions.region_id "
							+ "JOIN continents ON regions.continent_id = continents.continent_id;";
					
					PreparedStatement ps = con.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						final int id = rs.getInt(1);
						final String name = rs.getString(2);
						final String Regionsname = rs.getString(3);
						final String Continentsname = rs.getString(3);
						
						
						System.out.println(id + " - " + name+
								 " - " + Regionsname + "-" );
					}
					
					ps.close();
					
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				} finally{
					
					try {
						con.close();
					} catch (Exception e) { }
				}

			}

		

	}

