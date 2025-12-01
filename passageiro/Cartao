package passageiro;

import java.util.Scanner;
import excecoes.PagamentoRecusadoException;

public class Cartao extends Carteira{

	Scanner sc = new Scanner(System.in);
	
	private String titCartao, numCartao;
	private int validade, cvv;
	private float limite;
	private boolean val = false;
	
	public void cadMtdPag(Passageiro p) {
		
		System.out.println("Digite o nome do Titular do Cartão: ");
		this.titCartao = sc.nextLine();
		System.out.println("------------------------------------");
		System.out.println("Digite o numero do Cartão: ");
		this.numCartao = sc.nextLine();
		
		while (val == false) {
			System.out.println("Digite a Validade: (MMAA)");
			this.validade = sc.nextInt();
			verificarValidade();
			if (val == false) {
				System.out.println("Informe uma validade utilizavel");
				}
		}
		System.out.println("------------------------------------");
		System.out.println("Digite o código CVV: ");
		this.cvv = sc.nextInt();
		System.out.println("------------------------------------");
		System.out.println("Qual o limite deste cartão?");
		this.limite = sc.nextFloat();
		System.out.println("------------------------------------");
		System.out.println("Cartão cadastrado com sucesso.");
		System.out.println("------------------------------------");
		
	}
	
	public boolean verificarValidade() {
		
		int mes = validade / 100;
		int ano = validade % 100;
		if (mes < 1 || mes > 12 || ano < 25) {
			System.out.println("Data Inválida"); 
			return false;
		}
		
		
		if (mes == 12 && ano == 25 || ano > 25) {
			System.out.println("Cartão dentro da validade");
			System.out.println("------------------------------------");
			val = true;
			return true;
		}
		else {
			System.out.println("Cartão vencido");
			System.out.println("------------------------------------");
			return false;
		}
		
	}
		
	public boolean pagar(float valorCorrida) {
		if (this.limite >= valorCorrida) {
			this.limite -= valorCorrida;
			return true;
		} else {
			return false;
		}
	}
	
	public void setLimite(float lim) {
		this.limite = lim;
	}
	
	public float getLimite() {
		return this.limite;
		}
	
	public void setTitCartao(String tit) {
		this.titCartao = tit;
	}
	
	public void setNumCartao(String numCard) {
		this.numCartao = numCard;
	}
	
	public void setVal(int val) {
		this.validade = val;
	}
	
	public void setCVV(int cvv) {
		this.cvv = cvv;
	}
	
	public String toString() {
		return this.numCartao;
	}
	
}
