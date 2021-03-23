package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Funcionario;
import beans.Produto;

public class FuncionarioDAO {

	public void create(Funcionario f) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("INSERT INTO funcionario (salario, cargo, nome, idade) values(?,?,?,?)");
			stmt.setDouble(1, f.getSalario());
			stmt.setString(2, f.getCargo());
			stmt.setString(3, f.getNome());
			stmt.setInt(4, f.getIdade());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro!!!", e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public ArrayList<Funcionario> list() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Funcionario> arr = new ArrayList<Funcionario>();

		try {
			stmt = con.prepareStatement("SELECT * FROM funcionario");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Funcionario f = new Funcionario();

				f.setNome(rs.getString("nome"));
				f.setId(rs.getInt("id"));
				f.setSalario(rs.getDouble("salario"));
				f.setIdade(rs.getInt("idade"));
				f.setCargo(rs.getString("cargo"));

				arr.add(f);

			}

		} catch (SQLException e) {

			throw new RuntimeException();

		} finally {

			ConnectionFactory.closeConnection(con, stmt, rs);

		}

		return null;
	}
	
	
	public void delete(Funcionario f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM funcionario where id = " + f.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro!!!", e);
		}
	}
	
	
}
