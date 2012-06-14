package br.com.impacta.jdbc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.impacta.jdbc.model.Cargo;

public class CargoDAO extends AbstractDAO {

	public List<Cargo> findAll() throws DAOException {

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Cargo> cargoLista = null;
		Cargo cargo = null;

		try {

			cn = getConnection();
			st = cn.createStatement();
			rs = st.executeQuery("SELECT role_code, role_name FROM tab_role ORDER BY role_name");
			cargoLista = new ArrayList<Cargo>();

			while (rs.next()) {
				cargo = new Cargo();
				cargo.setId(rs.getInt("role_code"));
				cargo.setNome(rs.getString("role_name"));
				cargoLista.add(cargo);
			}

			return cargoLista;

		} catch (SQLException sqle) {
			throw new DAOException("Falha ao obter lista de cargos", sqle);
		} finally {
			closeResources(cn, st, rs);
		}
	}

	public List<Cargo> findByName(String nome) throws DAOException {

		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cargo> cargoLista = null;
		Cargo cargo = null;

		try {

			cn = getConnection();
			ps = cn.prepareStatement("SELECT role_code, role_name FROM tab_role WHERE role_name LIKE ?");
			ps.setString(1, nome);
			rs = ps.executeQuery();
			cargoLista = new ArrayList<Cargo>();

			while (rs.next()) {
				cargo = new Cargo();
				cargo.setId(rs.getInt("role_code"));
				cargo.setNome(rs.getString("role_name"));
				cargoLista.add(cargo);
			}

			return cargoLista;

		} catch (SQLException sqle) {
			throw new DAOException("Falha ao obter lista de cargos", sqle);
		} finally {
			closeResources(cn, ps, rs);
		}
	}

	public void save(Cargo cargo) throws DAOException {
		
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

		} catch (SQLException sqle) {
			throw new DAOException("Falha ao salvar o cargo especificado.", sqle);
		} finally {
			closeResources(cn, ps, rs);
		}
	}

	public static void main(String[] args) {
		try {
			CargoDAO dao = new CargoDAO();
			List<Cargo> cargoLista = dao.findByName("%");
			for (Cargo cargo : cargoLista) {
				System.out.println(cargo.getNome());
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
