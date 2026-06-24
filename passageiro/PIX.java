package passageiro;

import java.util.Scanner;

public class PIX extends Carteira{
	
	Scanner sc = new Scanner(System.in);
	
	private String email, cpf, telefone;
	

	public void cadMtdPag(Passageiro p) {
		System.out.println("Qual tipo de chave deseja cadastrar?");
		System.out.println("Digite C para CPF / E para Email / T para Telefone");
		String tpChave = sc.nextLine();
		
		if (tpChave.equalsIgnoreCase("C")) {
			String cpfProvisorio = p.getCpf();
			System.out.println("Deseja utilizar o CPF já cadastrado? S/N");
			System.out.println("---->"+cpfProvisorio);
			String resposta = sc.nextLine();
			
			if (resposta.equalsIgnoreCase("N")) {
				System.out.println("Digite o CPF: ");
				String cpfDefinitivo = sc.nextLine();
				this.cpf = cpfDefinitivo;
				}
				else {
					this.cpf = cpfProvisorio; 
				}
			}
		else if (tpChave.equalsIgnoreCase("E")) {
			String emailProvisorio = p.getEmail();
			System.out.println("Deseja utilizar o Email já cadastrado? S/N");
			System.out.println("---->"+emailProvisorio);
			String resposta = sc.nextLine();
			
			if (resposta.equalsIgnoreCase("N")) {
				System.out.println("Digite o Email: ");
				String emailDefinitivo = sc.nextLine();
				this.email = emailDefinitivo;
				}
				else {
					this.email = emailProvisorio; 
			
				}
			}
		
		else if (tpChave.equalsIgnoreCase("T")) {
			String telProvisorio = p.getTelefone();
			System.out.println("Deseja utilizar o telefone já cadastrado? S/N");
			System.out.println("---->"+telProvisorio);
			String resposta = sc.nextLine();
			
			if (resposta.equalsIgnoreCase("N")) {
				System.out.println("Digite o Telefone: ");
				String telDefinitivo = sc.nextLine();
				this.telefone = telDefinitivo;
				
				}
				
			else {
				this.telefone = telProvisorio;
			}
			
			
		}
		
		System.out.println("Chave cadastrada com sucesso.");
		
	}
	
}





