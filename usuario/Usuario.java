package usuario;
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Usuario extends Cadastro {

	Scanner sc = new Scanner(System.in);
	
	private String nome, email, senha, status, cpf, telefone;
	
	public Usuario() {
	
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome() {
		System.out.println("Nome: ");
		this.nome = sc.nextLine();
		System.out.println("------------------------------------");
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCPF() { 
		System.out.println("CPF: ");
		this.cpf = sc.nextLine(); 
	    System.out.println("------------------------------------");
	    
	}
	
	public void setCPF(String cpf) {
		
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail() {
		System.out.println("Email: ");
		this.email = sc.nextLine();
		System.out.println("------------------------------------");
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone() {
		System.out.print("Telefone: ");
		this.telefone = sc.nextLine();	           	            
	    System.out.println("------------------------------------");
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSenha() {
		return senha;
		
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setSenha() {
		boolean senhaAPV = false;
		
		while (!senhaAPV) {
			
			System.out.println("Senha:");
			System.out.println("* A senha deve conter no mínimo 8 caracteres");
			System.out.println("* Uma letra em mauisculo e uma minuscula");
			System.out.println("* Ao menos um número");
			String s = sc.nextLine();

			if (s.length() <8) {
				System.out.println("Senha Inválida");
				System.out.println("A senha deve conter no mínimo 8 caracteres.");
				System.out.println("------------------------------------");
				continue;
				
			}
			
			boolean temMaiuscula = false;
			boolean temMinuscula = false;
			boolean temNumero = false;
			
			for (char c : s.toCharArray()) {
				if (Character.isUpperCase(c)) 	temMaiuscula = true;
				if (Character.isLowerCase(c)) 	temMinuscula = true;
				if (Character.isDigit(c)) 		temNumero = true;
			}
			
			if (temMaiuscula && temMinuscula && temNumero) {
				senhaAPV = true;
				this.senha = s;
			}
			else {
				System.out.println("A senha não atende ao(s) requisito(s):");
				if (!temMaiuscula) 	System.out.println("-Falta uma letra maiúscula.");
				if (!temMinuscula) 	System.out.println("-Falta uma letra minúscula.");
				if (!temNumero)		System.out.println("-Falta um número");
			}
		}

		System.out.println("------------------------------------");
	}
	
	public void setStatus() {
		boolean validez = false;
		while (validez == false) {
			System.out.println("Selecione o seu Status");
			System.out.println("Digite '1' para Online ou '2' para Offline");
			String respostaStatus = sc.nextLine();
			if (respostaStatus.equals("1")) {
				this.status = "ONLINE";
				validez = true;
			}
		
			if (respostaStatus.equals("2")) {	

				this.status = "OFFLINE";
				validez = true;
			}

			else {
				System.out.println("Selecione uma das duas opções.");
				System.out.println();
			}
		}
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
}
