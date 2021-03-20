package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Pessoa;
import connection.ConnectionFactory;

public class ProdutoDAO {

	public void create(Pessoa p) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("INSERT INTO pessoa (nome) VALUES (?)");
			stmt.setString(1, p.getNome());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Erro!!!", e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public ArrayList<Pessoa> list() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Pessoa> arr = new ArrayList<Pessoa>();

		try {

			stmt = con.prepareStatement("SELECT * FROM pessoa");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setNome(rs.getString("nome"));
				p.setIdade(rs.getInt("id"));
				arr.add(p);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro!!!", e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return arr;
	}
	
	// Incomplete krai
	public void update(Pessoa p) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
	}

	public void delete(Pessoa p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM pessoa where id = " + p.getIdade());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
