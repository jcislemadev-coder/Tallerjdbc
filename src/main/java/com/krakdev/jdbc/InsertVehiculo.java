package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = """
				INSERT INTO vehiculos (placa,marca,modelo,anio,precio,color,disponible,kilometraje)
				VALUES(?,?,?,?,?,?,?,?);
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "PXF0877");
			ps.setString(2, "CHEVROLET");
			ps.setString(3, "ALTO");
			ps.setInt(4, 1998);
			ps.setDouble(5, 1090.80);
			ps.setString(6, "BLANCO");
			ps.setBoolean(7, true);
			ps.setInt(8, 5000);

			int filas = ps.executeUpdate();
			log.info("FILAS INSERTADAS: {}", filas);
		} catch (Exception e) {
			log.error("ERROR EN LA CONEXION: ", e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
