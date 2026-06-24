package motorista;
import usuario.ListadeCadastros;
import usuario.Usuario;
import corrida.Corrida;
import excecoes.NenhumMotoristaDisponivelException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import passageiro.Passageiro;
import corrida.Corrida;
import excecoes.EstadoInvalidoDaCorridaException;


public class Motorista extends Usuario{

	private CNH cnh;
	private Veiculo veiculo;
	private String status;
	private double estrelas = 5;
	
	private List<Corrida> historicoCorridas = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	
	public Motorista() {
		
	}
	
	public Motorista(String nome, String email, String senha, String Status, String cpf, String telefone, Veiculo veiculo, double estrelas) {
		this.setNome(nome);
		this.setStatus(Status);
		this.setEmail(email);
		this.setVeiculo(veiculo);
		this.setCPF(cpf);
		this.setTelefone(telefone);
		this.estrelas = estrelas;
		this.setSenha(senha);
	}

	public String cadastrar() {
		
		System.out.println("------ Cadastro de Motorista ------");
		setNome();
		setCPF();
		setTelefone();
		setEmail();
		setSenha();
		setStatus();
		
		this.cnh = new CNH();
		this.veiculo = new Veiculo();
		this.cnh.cadastrar();
		this.veiculo.cadastrar();
		
		
		
		return "Motorista Cadastrado com sucesso";
	}
	
	public String toString() {
		return "Motorista: " + this.getNome() + " | Status: " + getStatus();
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Veiculo getVeiculo() {

		return this.veiculo;
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
	
	public void iniciarCorrida(ListadeCadastros<Passageiro> listaPassageiros) {
	  
	    String[] locais = {
	        "Setor Comercial Sul", "Asa Norte", "Asa Sul","Taguatinga Centro",
	        "Aeroporto JK", "Guará 2", "Samambaia Sul", "Ceilândia Norte", "Lago Sul", 
	        "Lago Norte", "Rodoviária Plano Piloto", "UNB Campus Darcy Ribeiro",
	        "UNB Campus FCTE", "Rodoviária Interestadual", "Jardim Botânico",
	        "Valparaíso", "Park Shopping", "Catedral", "Pontão Lago Sul", 
	        "BRT Gama", "Santa Maria Norte", "Santa Maria Sul"
	    };

	    String[] categorias = {"C", "L"};

	    boolean cad = true;
	    while(cad == true) {
	    
	    	String p = locais[r.nextInt(locais.length)];
	    
	    	String d = locais[r.nextInt(locais.length)];
	    	while (d.equals(p)) {
	    		d = "Gama";
	    	}

	    
	    	String cat = categorias[r.nextInt(categorias.length)];

	    	Corrida c = new Corrida(p, d, cat);
	    
	    	c.setMotorista(this);
	    	c.setLocPartida(p);
	    	c.setLocDestino(d);
	    	
	    	System.out.println("\nBuscando Corrida...\n");
	    	
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();		
			}
	    	
	    	c.atribuirPassageiro(listaPassageiros.getLista(), cat);
	    	
	    	System.out.println("Aceitar Corrida? S/N");
	    	String continuar = sc.nextLine();
	    	if (continuar.equalsIgnoreCase("S")) {
	    		cad = false;
	    	}
	
	    	else {
	    		System.out.println("Buscando outra corrida...");
	    		try {
	    			Thread.sleep(3000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}		
	    		continue;
	    }
	    
	    	
	    c.iniciarDeslocamento(listaPassageiros, c);
	    
	    this.historicoCorridas.add(c);
	    }
	    
	}
	
	public List<Corrida> getHistoricoCorridas(){
		return this.historicoCorridas;
	}
	
	
}
