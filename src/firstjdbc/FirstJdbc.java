package firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.ConnectionFactory;
import beans.Funcionario;
import beans.Pessoa;
import beans.Produto;
import dao.FuncionarioDAO;
import dao.ProdutoDAO;


public class FirstJdbc {

	public static void main(String[] args) {

		
		
		//Pessoa p = new Pessoa("Joao silva");
		ConnectionFactory connection = new ConnectionFactory();
		
		//Connection con = connection.getConnection();
		//connection.closeConnection(con);
		
		Produto p = new Produto("Farinha", "Branca", 5.5);
		FuncionarioDAO fd = new FuncionarioDAO();
		Funcionario f = new Funcionario(800, "gestor", "railan", 22);
		ProdutoDAO d = new ProdutoDAO(); 
		//System.out.println();
		//ArrayList<Pessoa> arr = d.list();
		//fd.create(f);
		p.setId(1);
		p.setDescricao("Azul");
		d.update(p);
		//System.out.println(arr);
		//System.out.println("ola");
		
		//Funcionario f = new Funcionario(500, "boot", "joao", 18);
		
		//System.out.println(f);
		
		
	     
	/*	Pessoa p = new Pessoa("Joao", "Victor");
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dados?useTimezone=true&serverTimezone=UTC";
		String username = "root";
		String password = "12345678";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, password);

			System.out.println("Conexao ok...");

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
