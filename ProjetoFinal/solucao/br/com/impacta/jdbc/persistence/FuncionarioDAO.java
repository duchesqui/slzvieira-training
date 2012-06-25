package br.com.impacta.jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.impacta.jdbc.model.FuncionarioVO;

public class FuncionarioDAO extends AbstractDAO {

	public List<FuncionarioVO> findByName(String nome) throws Exception {
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<FuncionarioVO> funcionarioLista = null;
		FuncionarioVO funcionario = null;
		
		try {

			StringBuilder builder = new StringBuilder();
			builder.append("SELECT f.func_code, f.func_name, f.func_rmnt_val, r.role_code, r.role_name ");
			builder.append("FROM tab_func f JOIN tab_role r ON f.role_code = r.role_code ");
			builder.append("WHERE f.func_name LIKE ? ");
			builder.append("ORDER BY f.func_name");
			
			cn = getConnection();
			ps = cn.prepareStatement(builder.toString());
			ps.setString(1, nome);

			rs = ps.executeQuery();
			funcionarioLista = new ArrayList<FuncionarioVO>();
			
			while (rs.next()) {
				funcionario = new FuncionarioVO();
				funcionario.setId(rs.getInt("func_code"));
				funcionario.setNome(rs.getString("func_name"));
				funcionario.setSalario(rs.getDouble("func_rmnt_val"));
				funcionario.setIdCargo(rs.getInt("role_code"));
				funcionario.setNomeCargo(rs.getString("role_name"));
				funcionarioLista.add(funcionario);
			}
			
			return funcionarioLista;

		} finally {
			closeResources(cn, ps, rs);
		}
	}

	public void save(FuncionarioVO funcionario) throws Exception {

		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean exists = false;

		try {

			cn = getConnection();

			if (funcionario.getId() != 0) {

				ps = cn.prepareStatement("SELECT COUNT(*) FROM tab_func WHERE func_code = ?");
				ps.setInt(1, funcionario.getId());
				rs = ps.executeQuery();

				if (!rs.next()) {
					exists = false;
				} else if (rs.getInt(1) == 0) {
					exists = false;
				} else {
					exists = true;
				}

				closeResources(null, ps, rs);
			}

			if (exists) {
				ps = cn.prepareStatement("UPDATE tab_func SET func_name = ?, func_rmnt_val = ?, role_code = ? WHERE func_code = ?");
				ps.setInt(4, funcionario.getId());
			} else {
				ps = cn.prepareStatement("INSERT INTO tab_func (func_name, func_rmnt_val, role_code) VALUES (?, ?, ?)");
			}
			
			ps.setString(1, funcionario.getNome());
			ps.setDouble(2, funcionario.getSalario());
			ps.setInt(3, funcionario.getIdCargo());
			ps.executeUpdate();

		} finally {
			closeResources(cn, ps, rs);
		}
	}
}
