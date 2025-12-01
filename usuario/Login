package usuario;
import passageiro.Passageiro;
import java.util.Scanner;

public class Login {

	Scanner sc = new Scanner(System.in);
	
	private Passageiro passageiroLogado;
	private String email, senha;
	private boolean achou = false;
	
	public Login(ListadeCadastros<Passageiro> listaPassageiros) {
	
		while (achou == false) {
			
			System.out.println("\nEmail: ");
			this.email = sc.nextLine();
			System.out.println("Senha: ");
			this.senha = sc.nextLine();
			achou = pesquisarPassageiro(listaPassageiros);
			
			if (achou == false) {
				System.out.println("Usuário ou senha incorretos! Tente novamente. \n");
			}
		}
		
		System.out.println("Login realizado com sucesso!");
	}

	public boolean pesquisarPassageiro(ListadeCadastros<Passageiro> listaGeral) {
		
		for (Passageiro p : listaGeral.getLista()) {
			
			if (p.getEmail().equals(this.email) && p.getSenha().equals(this.senha)) {
				this.passageiroLogado = p;
				return true;
			}
			
		}
		
		return false;
		
	}

	public Passageiro getPassageiroLogado() {
		return this.passageiroLogado;
	}
	
	
	
}
