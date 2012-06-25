package br.com.impacta.jdbc.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class GeneralDAO extends AbstractDAO {

	public String findDescription(int number) throws Exception {

		Connection cn = null;
		CallableStatement cs = null;

		try {

			cn = getConnection();
			cs = cn.prepareCall("{ call prc_numero_descricao(?, ?) }");

			cs.setInt(1, number);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();

			return cs.getString(2);
		
		} finally {
			closeResources(cn, null, null);
		}
	}
}
