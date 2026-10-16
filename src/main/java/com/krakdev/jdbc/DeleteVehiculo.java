package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DeleteVehiculo {
	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.getConnection();
			String sql =  """
					DELETE FROM vehiculos
					WHERE placa = ?
					""";
			ps = con.prepareStatement(sql);
			ps.setString(1, "PXF0887");
			int filas = ps.executeUpdate();
			log.info("Anulacion exitosa de: "+ filas + " elementos");
			
		}catch(Exception e){
			log.error("ERROR EN ELIMINACION DE CONTACTO", e.getMessage());
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
