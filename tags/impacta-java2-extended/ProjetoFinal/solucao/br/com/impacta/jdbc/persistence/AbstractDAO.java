package br.com.impacta.jdbc.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

	protected Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://sal:3306/impacta", "aluno", "java");
		return cn;
	}

	protected void closeResources(Connection cn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqle) {}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException sqle) {}
		}
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException sqle) {}
		}
	}
}
