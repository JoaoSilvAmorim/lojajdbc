package beans;

public class Funcionario extends Pessoa{
	
	private double salario;
	private String cargo;

	public Funcionario(double salario, String cargo, String nome, int idade) {
		super(nome, idade);
		this.salario = salario;
		this.cargo = cargo;
	}

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
	
	
	
	public String toString() {
		return "Nome" + super.getNome();
	}

}
