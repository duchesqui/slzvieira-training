/**
 * 
 */
package br.com.impacta.jdbc.persistence;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.impacta.jdbc.model.Foto;

/**
 * @author Sandro
 * 
 */
public class FotoDAO extends AbstractDAO {

	/**
	 * @param codigo
	 * @return
	 * @throws DAOException
	 */
	public Foto findByPk(int codigo) throws DAOException {

		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream inputStream = null;
		ByteArrayOutputStream outputStream = null;
		Foto foto = null;
		byte[] stream = new byte[1024];
		int size = 0;

		try {

			cn = getConnection();
			ps = cn.prepareStatement("SELECT user_code, user_name, user_pict, orig_file_name FROM tab_foto WHERE user_code = ?");
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			if (!rs.next()) {
				return null;
			}
			
			foto = new Foto();
			foto.setCodigo(rs.getInt("user_code"));
			foto.setNome(rs.getString("user_name"));
			foto.setNomeArquivo(rs.getString("orig_file_name"));

			inputStream = rs.getBinaryStream("user_pict");
			outputStream = new ByteArrayOutputStream();

			while ((size = inputStream.read(stream)) > 0) {
				outputStream.write(stream, 0, size);
			}
			
			foto.setFoto(outputStream.toByteArray());
			return foto;

		} catch (SQLException sqle) {
			throw new DAOException("Nao foi possivel obter os dados da foto especificada.", sqle);
		} catch (IOException ioe) {
			throw new DAOException("Nao foi possivel obter os dados da foto especificada.", ioe);
		} finally {
			closeStreams(inputStream, outputStream);
			closeResources(cn, ps, rs);
		}
	}
	
	private void closeStreams(Closeable... closeableArray) {
		for (Closeable closeable : closeableArray) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {}
			}
		}
	}
}
