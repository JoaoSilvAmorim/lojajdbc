package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Pessoa;
import beans.Produto;
import connection.ConnectionFactory;

public class ProdutoDAO {

	public void create(Produto p) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("INSERT INTO produto (nome, descricao, preco) VALUES (?,?,?)");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getDescricao());
			stmt.setDouble(3, p.getPreco());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Erro!!!", e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public ArrayList<Produto> list() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> arr = new ArrayList<Produto>();

		try {

			stmt = con.prepareStatement("SELECT * FROM produto");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setPreco(rs.getDouble("preco"));
				arr.add(p);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro!!!", e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return arr;
	}
	
	
	public void update(Produto p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("UPDATE produto SET descricao = ?, preco = ? WHERE id = " + p.getId());
			stmt.setString(1, p.getDescricao());
			stmt.setDouble(2, p.getPreco());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Produto p) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM produto WHERE id = " + p.getId());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
