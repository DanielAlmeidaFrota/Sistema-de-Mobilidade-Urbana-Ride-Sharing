package passageiro;

import corrida.Pagamento;
import java.util.Scanner;
import corrida.Pagamento;

public class Dinheiro extends Carteira{
	
	private float carteiraFisica;
	Scanner sc = new Scanner(System.in);
	
	
	public void cadMtdPag(Passageiro p) {
		System.out.println("Quanto você tem na carteira física hoje?");
		this.carteiraFisica = sc.nextFloat();
		sc.nextLine();
		
		System.out.println("Pagamento definido como: Dinheiro em espécie.");
		System.out.println();
		System.out.println("------------------------------------");
		p.setSaldo(this.carteiraFisica);
	}

	public float getCarteiraFisica() {
		return this.carteiraFisica;
	}

	public boolean descontarSaldo(float valor) {
		if (this.carteiraFisica >= valor) {
			this.carteiraFisica -= valor;
			return true;
		}
		return false;
	}
	
	public void adicionarSaldo() {
		System.out.println("Quanto deseja adicionar a carteira?");
		this.carteiraFisica = sc.nextFloat();
		
	}
	
	public boolean pagar(float valorCorrida) {
        if (this.carteiraFisica >= valorCorrida) {
            this.carteiraFisica -= valorCorrida;
            return true;
        } else {
            return false;
        }
    }
	
	public void setCarteiraFisica(float valor) {
		this.carteiraFisica = valor;
	}
}
