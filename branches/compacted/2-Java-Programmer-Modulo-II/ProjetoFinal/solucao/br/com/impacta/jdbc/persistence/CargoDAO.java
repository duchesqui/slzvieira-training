package br.com.impacta.jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.impacta.jdbc.model.CargoVO;

public class CargoDAO extends AbstractDAO {

	public List<CargoVO> findAll() throws Exception {

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		List<CargoVO> cargoLista = null;
		CargoVO cargo = null;

		try {

			cn = getConnection();
			st = cn.createStatement();
			rs = st.executeQuery("SELECT role_code, role_name FROM tab_role ORDER BY role_name");
			cargoLista = new ArrayList<CargoVO>();

			while (rs.next()) {
				cargo = new CargoVO();
				cargo.setId(rs.getInt("role_code"));
				cargo.setNome(rs.getString("role_name"));
				cargoLista.add(cargo);
			}

			return cargoLista;

		} finally {
			closeResources(cn, st, rs);
		}
	}

	public List<CargoVO> findByName(String nome) throws Exception {

		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CargoVO> cargoLista = null;
		CargoVO cargo = null;

		try {

			cn = getConnection();
			ps = cn.prepareStatement("SELECT role_code, role_name FROM tab_role WHERE role_name LIKE ?");
			ps.setString(1, nome);
			rs = ps.executeQuery();
			cargoLista = new ArrayList<CargoVO>();

			while (rs.next()) {
				cargo = new CargoVO();
				cargo.setId(rs.getInt("role_code"));
				cargo.setNome(rs.getString("role_name"));
				cargoLista.add(cargo);
			}

			return cargoLista;

		} finally {
			closeResources(cn, ps, rs);
		}
	}

	public void save(CargoVO cargo) throws Exception {
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean exists = false;
		
		try {

			cn = getConnection();
			
			if (cargo.getId() != 0) {

				ps = cn.prepareStatement("SELECT COUNT(*) FROM tab_role WHERE role_code = ?");
				ps.setInt(1, cargo.getId());
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
				ps = cn.prepareStatement("UPDATE tab_role SET role_name = ? WHERE role_code = ?");
				ps.setInt(2, cargo.getId());
			} else {
				ps = cn.prepareStatement("INSERT INTO tab_role (role_name) VALUES (?)");
			}
			
			ps.setString(1, cargo.getNome());
			ps.executeUpdate();

		} finally {
			closeResources(cn, ps, rs);
		}
	}
}
