package br.com.impacta.projetofinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe base para implementacao dos DAOs do projeto final.
 * Deve ser utilizada como classe mae de cada DAO da aplicacao.
 * 
 * @author sandro.vieira
 * @version 1.0, 17/06/2012 - sandro.vieira - Implementacao.
 */
public abstract class AbstractDAO {

	/**
	 * Obtem uma conexao com a base de dados.
	 * @return Conexao com a base utilizada pela aplicacao.
	 * @throws Exception Falha ao realizar a conexao com a base ou falha ao carregar o driver.
	 */
	protected Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://sal:3306/impacta", "aluno", "java");
		return cn;
	}

	/**
	 * Finaliza os recursos de acesso a base utilizados pelo DAO.
	 * @param cn Conexao a ser fechada ou null.
	 * @param st Statement a ser fechado ou null.
	 * @param rs ResultSet a ser fechado ou null.
	 */
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
