package corrida;

import motorista.Motorista;
import passageiro.Passageiro;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import usuario.ListadeCadastros;
import excecoes.EstadoInvalidoDaCorridaException;
import excecoes.NenhumMotoristaDisponivelException;


public class Corrida{

	private String locPartida, locDestino, categoria, status, metDePag;
	private float valor;
	private double distancia;
	private Passageiro passageiro;
	private Motorista motorista;
	
	Scanner sc = new Scanner(System.in);
	Random gerador = new Random();
	
	public Corrida(String locpartida, String locdestino, String categoria) {
		this.locPartida = locpartida;
		this.locDestino = locdestino;
		
		if (categoria.equalsIgnoreCase("C")) {
		this.categoria = "Comum";
		}
		else {
			this.categoria = "Luxo";
		}
		
		this.status = "Solicitada";
	}

	public void setPassageiro(Passageiro p) {
		this.passageiro = p;
		
	}	
	
	public void gerarDistancia() {
		
		double distanciaMinima = 2.0;
		double distanciaMaxima = 25.0;
		
		this.distancia = distanciaMinima + (gerador.nextDouble() * (distanciaMaxima - distanciaMinima));
	}
	
	
	public void solicitarCorrida(){
	
		gerarDistancia();
		
		CategoriaServico servico = new CategoriaServico();
		
		this.valor = servico.calcularPreco(this.categoria, this.distancia);
		
		System.out.println("------ Detalhes da Corrida ------");
		System.out.printf("Origem: %s | Destino: %s%n", this.locPartida, this.locDestino);
		System.out.printf("Distância: %.2f km ", this.distancia);
		System.out.println("Categoria: " + this.categoria);
		System.out.println();
		System.out.printf("Valor total: R$ %.2f%n", this.valor);
		System.out.println("------------------------------------");
			
		
	}
	
	public float getValor() {
		
		return this.valor;
	}
	
	public void atribuirPassageiro(List<Passageiro> listaPassageiros, String Categoria) {
		
		List<Passageiro> disponiveis = new ArrayList<>();
		
	    for (Passageiro p : listaPassageiros) {
	        if (p.getStatus().equalsIgnoreCase("ONLINE")) {
	            disponiveis.add(p);
	        }
	    }
	    
	    int indice = gerador.nextInt(disponiveis.size());
	    this.passageiro = disponiveis.get(indice);

		gerarDistancia();
		
		CategoriaServico servico = new CategoriaServico();
		
		this.valor = servico.calcularPreco(this.categoria, this.distancia);
	    
	    System.out.println("Passageiro Encontrado!");
	    
	
	    System.out.println("Passageiro encontrado: " + this.passageiro.getNome());
	    System.out.println("Estrelas do Passageiro: " + this.passageiro.getEstrelas());
	    System.out.println("Partida: " + this.locPartida); 
	    System.out.println("Destino: " + this.locDestino);
	    System.out.printf("Valor: R$ %.2f ",  this.valor);
	    System.out.println();
		System.out.println("------------------------------------");
	    
	}
	
	public void setLocPartida(String locPartida) {
		this.locPartida = locPartida;
	}
	
	public void setLocDestino(String locDestino) {
		this.locDestino = locDestino;
	}
	
	public void atribuirMotorista(List<Motorista> listaMotoristas) 
		        throws NenhumMotoristaDisponivelException {

		    List<Motorista> disponiveis = new ArrayList<>();

		    for (Motorista m : listaMotoristas) {
		        if (m.getStatus().equalsIgnoreCase("ONLINE")) {
		            disponiveis.add(m);
		        }
		    }

		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		    if (disponiveis.isEmpty()) {
		        throw new NenhumMotoristaDisponivelException(this.categoria);
		        
		    }

		    int indice = gerador.nextInt(disponiveis.size());
		    this.motorista = disponiveis.get(indice);
		    
		

		    this.status = "Aceita";
		    
		
		    System.out.println("Motorista encontrado: " + this.motorista.getNome());
		    System.out.println("Estrelas do Motorista: " + this.motorista.getEstrelas());
		    System.out.println("Veículo: " + this.motorista.getVeiculo().getMarca() + " " + this.motorista.getVeiculo().getModelo()); 
		    System.out.println("Placa: " + this.motorista.getVeiculo().getPlaca());
		    System.out.println("Cor: " + this.motorista.getVeiculo().getCor());
		    System.out.println();
			System.out.println("------------------------------------");
		   
		
		}
	
	public void setMotorista(Motorista m) {
		this.motorista = m;
	}
	
	public Motorista getMotorista() {
		return this.motorista;
	}
	
	public void iniciarDeslocamento(ListadeCadastros<Passageiro> listaPassageiros, Corrida c) {
		
		this.status = "Indo até o Passageiro";
	    System.out.println("Status: " + this.status);
	   
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    
	    System.out.println("");
	    this.status = "Aguardando Passageiro";
	    System.out.println("Status: " + this.status);
	    
	    System.out.println("\n------- PAINEL DO MOTORISTA -------");
	    boolean continuar = false;
	    while(!continuar) {
	    System.out.println("1 - Cancelar Corrida\n2 - Continuar Corrida");
	    String resposta = sc.nextLine();
	    try {

	        if (resposta.equals("1")) {
	            throw new EstadoInvalidoDaCorridaException(
	                this.status,
	                "Cancelar Corrida"
	            );
	        }

	    } catch (EstadoInvalidoDaCorridaException e) {
	        System.out.println("\n>>> Operação não permitida!");
	        System.out.println(e.getMessage());
	        System.out.println("A corrida continuará normalmente...\n");

	        resposta = "2"; 
	    }

	    if(resposta.equals("2")) {
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();		
			}
	        continuar = true;
	    }

	    else {
	        System.out.println("Opção inválida! Tente novamente.");
	        continue;
	    }
		
	    System.out.println("\nIniciando Viagem...");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();		
		}	
	    }
	    
	    finalizarDeslocamento(this.motorista);
	}	
	
	
	public void iniciarDeslocamento(ListadeCadastros<Motorista> listaMotoristas, Corrida c, Passageiro p, Motorista m) {
		System.out.println("Motorista a caminho...");
		boolean continuar = false;
		while (continuar == false) {
			System.out.println("Digite '1' para Prosseguir ou '2' para Cancelar a corrida.");
			String resposta = sc.nextLine();
		
			if ( resposta.equalsIgnoreCase("1")) {
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		
			System.out.println("O seu motorista chegou.");
			System.out.println();
			
			continuar = true;
			this.status = "EM ANDAMENTO...";
			System.out.println("Status: "+ this.status);
			System.out.println();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			finalizarViagem(p, m);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			}
		
			else if (resposta.equalsIgnoreCase("2")) {
				cancelarCorrida(listaMotoristas, p);
				continuar = true;
			}
		
			else {
				System.out.println("Seleção inválida");
			}
		}
	}
	
	public void finalizarViagem(Passageiro p, Motorista m) {
		
		this.metDePag = p.getMetDePag();
		
		System.out.println("Chegamos ao Destino!");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();		
		}	
		Pagamento pag = new Pagamento();
		pag.processarPagamento(p, m, this.valor);
		this.status = "Finalizada";
	}
	
	public void finalizarViagem() {
		System.out.println("\nChegamos ao Destino!");
		String formaDePagamento = this.passageiro.getMetDePag();
		
		Pagamento pag = new Pagamento();
		pag.receberPagamento(this.passageiro, this.motorista, this.valor);
		
		this.status = "Finalizada";
	}
	
	public void cancelarCorrida(ListadeCadastros<Motorista> listaMotoristas, Passageiro p){
		System.out.println("Corrida cancelada.");
		System.out.println("");
		System.out.println("Você deseja solicitar uma nova corrida? S/N");
		String resposta = sc.nextLine();
		if (resposta.equalsIgnoreCase("S")) {
			p.iniciarCorrida(listaMotoristas);
		}
		else {System.out.println("Volte Sempre!");}
	}
	
	public void cancelarCorrida() {
		System.out.println("Corrida cancelada.");
	}
	
	public void finalizarDeslocamento(Motorista m) {
		System.out.println("\nViagem em andamento...");
	    try {
	        Thread.sleep(3000);
	    } catch (Exception e) {
	    	
	    }

	    finalizarViagem();
	    	
	    System.out.println("Avalie o passageiro com 1 ou até 5 estrelas");
		int avaliacaoDoPassageiro = sc.nextInt();
		this.passageiro.setEstrelas(avaliacaoDoPassageiro);
			
		System.out.println("O passageiro está avaliando você...");
			
		try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
			
		int variacao = (gerador.nextInt(3) - 1);
		int avaliacaoDoMotorista = avaliacaoDoPassageiro + variacao;

		if (avaliacaoDoMotorista < 1) {
			avaliacaoDoMotorista = 1;
		}
		if (avaliacaoDoMotorista > 5) {
			avaliacaoDoMotorista = 5;
		}
			
			
		this.motorista.setEstrelas(avaliacaoDoPassageiro);
		System.out.println("O passageiro te avaliou com: " + avaliacaoDoPassageiro + " estrelas");
		System.out.println("------------------------------------");
			
	} 
	
	public String toString() {
		return String.format("Origem: %s \nDestino: %s \nCategoria: %s\nValor: R$ %.2f \nMotorista: %s \nPlaca: %s \nPassageiro: %s \n", 
	            this.locPartida, this.locDestino, this.categoria, this.valor, this.motorista.getNome(), this.motorista.getVeiculo().getPlaca(), this.passageiro.getNome());
	}
	
}
