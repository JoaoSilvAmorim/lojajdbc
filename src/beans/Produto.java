package beans;

public class Produto {
	
	private String nome;
	private String descricao;
	private double preco;
	private int id;
	
	
	public Produto() {/* constructor empty */} 
	
	
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}
	
	
	
	
	

}
