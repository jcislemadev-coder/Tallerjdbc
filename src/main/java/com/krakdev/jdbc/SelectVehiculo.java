package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectVehiculo {
	private static final Logger log = LogManager.getLogger(SelectVehiculo.class);
	
	public static void main(String[] args) {
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
				
				try {
					con = Conexion.getConnection();
					String sql = """
							SELECT *FROM vehiculos 
							""";
					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					
					while(rs.next()) {
						String placa = rs.getString("placa");
						String marca = rs.getString("marca");
						String modelo = rs.getString("modelo");
						int anio = rs.getInt("anio");
						Double precio = rs.getDouble("precio");
						String color = rs.getString("color");
						Boolean disponible = rs.getBoolean("disponible");
						int kilometraje = rs.getInt("kilometraje");
						log.info("Vehiculo--- \nPlaca: "+ placa +"\nMarca: "+ marca + "\nModelo: "+ modelo+ "\nAño: "+anio+"\nPrecio: "+precio+"\nColor: "+color+"\nDisponible: "+disponible+"\nKilometraje: "+kilometraje );
					}
				}catch(Exception e){
					log.error("ERROR AL TRAER LOS DATOS", e);
					
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
	}

}
