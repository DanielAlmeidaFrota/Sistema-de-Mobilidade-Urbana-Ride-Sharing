package passageiro;
import usuario.ListadeCadastros;
import usuario.Usuario;
import corrida.Corrida;
import java.util.Scanner;
import motorista.Motorista;
import java.util.ArrayList;
import java.util.List;
import excecoes.NenhumMotoristaDisponivelException;

public class Passageiro extends Usuario{

	private String status;
	private Carteira carteira;
	private String metDePag;
	private double estrelas = 5;
	private float divida = 0;
	private float saldo;
	
	private List<Corrida> historicoCorridas = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	
	public Passageiro(String nome, String cpf, String email, String senha, String Status, String metDePag, double estrelas) {
		this.setEmail(email);
		this.setCPF(cpf);
		this.setNome(nome);
		this.setStatus(Status);
		this.setMetDePag(metDePag);
		this.estrelas = estrelas;
		this.setSenha(senha);
	}
	
	public Passageiro() {
				
	}

	public String cadastrar() {
		
		System.out.println("------ Cadastro de Passageiro ------");
		setNome();
		setCPF();
		setTelefone();
		setEmail();
		setSenha();
		this.status = "ONLINE";
		
		System.out.println("Escolha o método de pagamento inicial:");
        System.out.println("1 - Cartão | 2 - PIX | 3 - Dinheiro");
        int opcao = sc.nextInt();
        sc.nextLine(); 
        
        switch(opcao) {
            case 1:
                this.carteira = new Cartao();
                this.metDePag = "Cartao";
                break;
            case 2:
                this.carteira = new PIX();
                this.metDePag = "PIX";
                break;
            default:
                this.carteira = new Dinheiro();
                this.metDePag = "Dinheiro";
                break;
        }
        
        
        this.carteira.cadMtdPag(this);
		
		return "Passageiro cadastrado com sucesso.";
	}
	
	public void setMetDePag(String metDePag) {
		this.metDePag = metDePag;
	}
	
	public String getMetDePag() {
		return this.metDePag;
	}
	
	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}
	
	public Carteira getCarteira() {
		return this.carteira;
	}
	
	public void iniciarCorrida(ListadeCadastros<Motorista> listaDeMotoristas) {
		
		System.out.println("Insira o local de partida: ");
		String p = sc.nextLine();
		System.out.println("Insira o local de destino: ");
		String d = sc.nextLine();
		System.out.println("Selecione a categoria da sua viagem: ");
		System.out.println("Digite 'C' para Categoria Comum / Digite 'L' para Categoria Luxo");
		String cat = sc.nextLine();
		
		Corrida c = new Corrida(p, d, cat); 
				
		c.setPassageiro(this);
		
		c.solicitarCorrida();
		this.status = "Solicitando Corrida";
		System.out.println(this.status);
		System.out.println();
		System.out.println("Buscando motorista...");
		System.out.println();
		
		try {
            c.atribuirMotorista(listaDeMotoristas.getLista());
        } catch (NenhumMotoristaDisponivelException e) {
            System.out.println(e.getMessage());
            System.out.println("Voltando ao menu inicial...");
            return;    
        }
		
		c.iniciarDeslocamento(listaDeMotoristas, c, this, c.getMotorista());
		
		this.historicoCorridas.add(c);
	}

	
	public List<Corrida> getHistoricoCorridas(){
		return this.historicoCorridas;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getEstrelas() { 
        return estrelas;
    }

	public int getQuantidadeCorridas() {
	    if (this.historicoCorridas == null) {
	        return 0;
	    }
	    return this.historicoCorridas.size();
	}
	
	public void setEstrelas(double novaNota) {
		int totalCorridas = getQuantidadeCorridas();
		
		if (totalCorridas <= 1 ) {
			this.estrelas = (this.estrelas + novaNota)/2;
		}
		else {
			this.estrelas = (this.estrelas * (totalCorridas - 1) + novaNota)/totalCorridas;
		}
	}
	
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public float getDivida() { 
        return divida;
    }

	public float adicionarDivida(float valorFaltante) { 
        this.saldo = 0;
		this.divida += valorFaltante;
        return this.divida;
    }
    
    public void pagarDivida() { 
        System.out.println("Realizando a transferência...");
        this.divida = 0;
        System.out.println("Transferência Concluida.");
    }
	

	public String toString() {
		return "Passageiro: " + this.getNome() + " | Status: " + getStatus();
	}
	
	
	
}
