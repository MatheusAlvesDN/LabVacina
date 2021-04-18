package Model;

import java.util.ArrayList;

public class Pessoa {
	
	
	String nome;
	int idade;
	String cpf;
	String endereco;
	String cartaoSUS;
	String email;
	String telefone;
	String profissao;
	ArrayList<String> comorbidades;
	Status status;
	
	public Pessoa() {
		status = new NaoHabilitado();
	}
	
	public Pessoa(String cpf) {
		this.cpf = cpf;
		this.status = new NaoHabilitado();
	}
	
	public Pessoa(String nome, int idade ,String cpf, String endereco, String cartaoSUS, String email, String telefone,
			String profissao) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cartaoSUS = cartaoSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.status = new NaoHabilitado();
	}
	
	public Pessoa(String nome, String cpf, String endereco, String cartaoSUS, String email, String telefone,
			String profissao, ArrayList<String> comorbidades) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cartaoSUS = cartaoSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
		this.comorbidades = comorbidades;
	}
	
	public void changeStatus() {
		status = status.newStatus();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void  endereco(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCartaoSUS() {
		return cartaoSUS;
	}
	public void setCartaoSUS(String cartaoSUS) {
		this.cartaoSUS = cartaoSUS;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public ArrayList<String> getComorbidades() {
		return comorbidades;
	}
	public void setComorbidades(ArrayList<String> comorbidades) {
		this.comorbidades = comorbidades;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", endereco=" + endereco + ", cartaoSUS="
				+ cartaoSUS + ", email=" + email + ", telefone=" + telefone + ", profissao=" + profissao
				+ ", comorbidades=" + comorbidades + ", status=" + status.getStatus() + "]";
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	 	

}
