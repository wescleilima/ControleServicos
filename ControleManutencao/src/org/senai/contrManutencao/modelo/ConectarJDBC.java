package org.senai.contrManutencao.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarJDBC {

	public Connection getConectar() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/controle_manutencao", "root", "");

		} catch (Exception e) {
			System.out.println("erro de conex�o");
			return null;
		}

	}

}
