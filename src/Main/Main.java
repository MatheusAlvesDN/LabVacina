package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Pessoa;


public class Main {
	static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		do{
		System.out.println("APLICATIVO DE CONTROLE DE VACINA��O");	
		System.out.println("SELECIONA OP��O:");
		System.out.println("1-REGISTRAR USU�RIO");
		System.out.println("2-CONSULTAR USU�RIO");
		System.out.println("3-CONFIRMAR APLICA��O DE DOSE");
		System.out.println("4-HABILITAR VACINA��O");
		System.out.println("5-ALTERAR USU�RIO");
		System.out.println("INSIRA QUALQUER OUTRO NUMERO PRA FINALIZAR O APLICATIVO");
		int s = sc.nextInt();
		if(s==1)
			registrarPessoa();
		if(s==2)
			System.out.println(consultarUsuario());
		if(s==3)
			confirmarVacinacao();
		if(s==4)
			habilitarVacinacao();
		if(s==5)
			alterarPessoa();
		if(s<1 || s>5) 
			break;
		clearScreen();
		
		}while(true);		
	}
		
	public static void registrarPessoa() {
		System.out.println("Nome:");
		String nome = sc.next();
		System.out.println("Idade:");
		int idade = sc.nextInt();
		System.out.println("CPF:");
		String cpf = sc.next();
		System.out.println("Endere�o:");
		String endereco = sc.next();
		System.out.println("Cart�o do SUS:");
		String cartaoSUS = sc.next();
		System.out.println("Email:");
		String email = sc.next();
		System.out.println("Telefone:");
		String telefone = sc.next();
		System.out.println("Profiss�o:");
		String profissao = sc.next();
		pessoas.add(new Pessoa(nome, idade, cpf, endereco, cartaoSUS, email, telefone, profissao));
		System.out.println("Usu�rio registrado");
	}	
	
	public static void alterarPessoa() {
		System.out.println("Inserir CPF do usu�rio:");
		String cpf = sc.next();
		Pessoa pessoa = new Pessoa(cpf);
		for(Pessoa p: pessoas) {
		if(p.equals(pessoa)) {
			boolean bol = true;
			do {
			System.out.println("APLICATIVO DE CONTROLE DE VACINA��O");	
			System.out.println("SELECIONA OP��O:");
			System.out.println("1-ALTERAR NOME");
			System.out.println("2-ALTERAR IDADE");
			System.out.println("3-ALTERAR CPF");
			System.out.println("4-ALTERAR ENDERE�O");
			System.out.println("5-ALTERAR CART�O DO SUS");
			System.out.println("6-ALTERAR EMAIL");
			System.out.println("7-ALTERAR TELEFONE");
			System.out.println("8-ALTERAR PROFISS�O");			
			System.out.println("9-ADICIONAR COMORBIDADE");
			System.out.println("INSIRA QUALQUER OUTRO NUMERO PARA RETORNAR A PAGINA INICIAL");
			int op = sc.nextInt();
			switch(op) {
				case 1:
					System.out.println("Nome:");
					p.setNome(sc.next());
					break;
				case 2:
					System.out.println("Idade:");
					p.setIdade(sc.nextInt());
					break;
				case 3:
					System.out.println("CPF:");
					p.setCpf(sc.next());
					break;
				case 4:
					System.out.println("Endere�o:");
					p.setEndereco(sc.next());
					break;
				case 5:
					System.out.println("Cart�o do SUS:");
					p.setCartaoSUS(sc.next());
					break;
				case 6:
					System.out.println("Email:");
					p.setEmail(sc.next());
					break;
				case 7:
					System.out.println("Telefone:");
					p.setTelefone(sc.next());
					break;
				case 8:
					System.out.println("Profiss�o:");
					p.setProfissao(sc.next());
					break;
				case 9:
					System.out.println("Comorbidade:");
					p.addComorbidade(sc.next());
					break;
			}
			clearScreen();
			if(op<1 || op > 8)
				bol = false;
			}while(bol);
		}
		}
	}	
		
	
	public static String consultarUsuario() {
		System.out.println("Inserir CPF do usu�rio:");
		String cpf = sc.next();
		Pessoa pessoa = new Pessoa(cpf);
		for(Pessoa p: pessoas) 
			if (pessoa.equals(p)) {
				if(p.getStatus().getStatus().equals("Primeira dose j� aplicada! Na fila para receber a segunda dose!") && p.getStatus().doseDisp())
					p.changeStatus();
				return p.toString();
			}
		return "Usu�rio n�o cadastrado";
	}
	
	private static void confirmarVacinacao() {
		System.out.println("Inserir CPF do usu�rio:");
		String cpf = sc.next();
		Pessoa pessoa = new Pessoa(cpf);
		boolean bol = true;
		for(Pessoa p: pessoas) {
			if (pessoa.equals(p)) {
				if(p.getStatus().doseDisp()) {
					System.out.println("Dose aplicada no usu�rio:" + p.getNome() + " -  " + p.getCpf());
					p.changeStatus();
					System.out.println("Status atual: " + p.getStatus().getStatus());
					
					bol = false;
				}else {
					System.out.println("Dose n�o pode ser aplicada no usu�rio:" + p.getNome() + " -  " + p.getCpf());
					System.out.println("Status atual: " + p.getStatus().getStatus());
					bol = false;
				}
			}	
		}
		if(bol) {
			System.out.println("Usu�rio com o CPF " + cpf + " n�o encontrado");
		}
		System.out.println("Insira qualquer para continuar.");
		sc.next();
	}

	public static void habilitarVacinacao() {
		System.out.println("1-Habilitar idade para primeira dose");
		System.out.println("2-Habilitar profiss�o para a primeira dose");
		System.out.println("3-Habilitar comorbidade para a primeira dose");
		System.out.println("INSIRA QUALQUER OUTRO NUMERO PARA RETORNAR A PAGINA INICIAL");

		int op = sc.nextInt();
		if(op == 1)
			habilitarIdade();
		if(op == 2)
			habilitarProfissao();
		if(op == 3)
			habilitarComorbidade();
	}
	
	private static void habilitarIdade() {
		System.out.println("INSERIR NOVA IDADE PARA A PRIMEIRA DOSE");
		int idade = sc.nextInt();
		for (Pessoa p: pessoas) {
			if(p.getIdade() >= idade && p.getStatus().getStatus().equals("N�O HABILITADO PARA RECEBER A VACINA")) {
				p.changeStatus();
			}
		}
		
		System.out.println("Pessoas com " + idade + " anos ou mais agora est�o aptos a receber a vacina!");
	}
	
	private static void habilitarProfissao() {
		System.out.println("INSERIR NOVA PROFISS�O PARA A PRIMEIRA DOSE");
		String trab = sc.next();
		for (Pessoa p: pessoas) {
			if(p.getProfissao().equals(trab) && p.getStatus().getStatus().equals("N�O HABILITADO PARA RECEBER A VACINA")) {
				p.changeStatus();
			}
		}
		
		System.out.println("Pessoas com a profiss�o " + trab + " agora est�o aptos a receber a vacina!");
	}
	
	public static void habilitarComorbidade() {
		System.out.println("INSERIR NOVA COMORBIDADE PARA A PRIMEIRA DOSE");
		String doenca = sc.next();
		for (Pessoa p: pessoas) {
			if(p.getComorbidades().contains(doenca) && p.getStatus().getStatus().equals("N�O HABILITADO PARA RECEBER A VACINA")) {
				p.changeStatus();
			}
		}
		
		System.out.println("Pessoas com a comorbidade " + doenca + " agora est�o aptos a receber a vacina!");
	}

	public static void clearScreen() {
		for(int i = 0; i <= 20; i++)
			System.out.println();
	}

}
