package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {
	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					UPDATE vehiculos
					SET marca =  ?,
					modelo = ?,
					anio = ?,
					precio = ?,
					color = ?,
					disponible = ?,
					kilometraje = ?
					WHERE placa = ?
					""";

			ps = con.prepareStatement(sql);
			ps.setString(1, "MAZDA");
			ps.setString(2, "PICANTO");
			ps.setInt(3, 1971);
			ps.setDouble(4, 480.59);
			ps.setString(5, "ROJO");
			ps.setBoolean(6, false);
			ps.setInt(7, 800);
			ps.setString(8, "PXF0887");
			

			int fila = ps.executeUpdate();

			log.info("VEHICULOS ACTUALIZADOS: {}", fila);
			
		} catch (Exception e) {
			log.error("ERROR AL ACTUALIZAR BASE DE DATOS",e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
