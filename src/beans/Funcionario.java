package beans;

public class Funcionario extends Pessoa{
	
	private double salario;
	private String cargo;
	private int id;

	public Funcionario(double salario, String cargo, String nome, int idade) {
		super(nome, idade);
		this.salario = salario;
		this.cargo = cargo;
	}
	
	public Funcionario() {/*Empty*/}


	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String toString() {
		return "Nome" + super.getNome();
	}

}
