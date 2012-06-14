package br.com.impacta.jdbc.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class GeneralDAO extends AbstractDAO {

	public String findDescription(int number) throws DAOException {

		Connection cn = null;
		CallableStatement cs = null;

		try {

			cn = getConnection();
			cs = cn.prepareCall("{ call prc_numero_descricao(?, ?) }");

			cs.setInt(1, number);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();

			return cs.getString(2);
		
		} catch (SQLException sqle) {
			throw new DAOException("Falha ao obter descricao do numero.", sqle);
		} finally {
			closeResources(cn, null, null);
		}
	}
}
