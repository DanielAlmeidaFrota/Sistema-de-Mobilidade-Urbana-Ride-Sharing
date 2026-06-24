package motorista;
import java.util.Scanner;

public class CNH {

	private int validade;
	private long numDeRegistro;
	private String catHab;
	private boolean val = false;
	
	Scanner sc = new Scanner(System.in);
	
	public CNH() {
		
	}

	public String cadastrar() {
		System.out.println("------ Cadastro de CNH ------");
		
		while (val == false) {
			System.out.println("Digite a Validade: (MMAA)");
			this.validade = sc.nextInt();
			verificarValidade();
			if (val == false) {
				System.out.println("Informe uma validade utilizavel");
				}
		}
		
		System.out.println("Digite o número de registro: ");
		this.numDeRegistro = sc.nextLong();
		System.out.println("------------------------------------");
		System.out.println("");
		return "CNH cadastrada com sucesso.";
		
	}
	
	public boolean verificarValidade() {
		
		int mes = validade / 100;
		int ano = validade % 100;
		if (mes < 1 || mes > 12 || ano < 25 || ano > 35) {
			System.out.println("Data Inválida"); 
			return false;
		}
		
		
		if (mes == 12 && ano == 25 || ano > 25) {
			System.out.println("CNH dentro da validade");
			System.out.println("------------------------------------");
			val = true;
			return true;
		}
		else {
			System.out.println("CNH vencida");
			System.out.println("------------------------------------");
			return false;
		}
		
	}
	
	
}
