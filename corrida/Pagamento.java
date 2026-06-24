package corrida;
import passageiro.Passageiro;
import motorista.Motorista;
import java.util.Scanner;
import java.util.Random;
import passageiro.Dinheiro;
import passageiro.Carteira;
import passageiro.Cartao;
import excecoes.PagamentoRecusadoException;
import excecoes.SaldoInsuficienteException;

public class Pagamento {

    private float valor;
    private String metDePag;

    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    
    public void processarPagamento(Passageiro p, Motorista m, float valor) {
        this.metDePag= p.getMetDePag();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
    	System.out.printf("Processando pagamento de: R$%.2f%n \n", valor);
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        if (metDePag.equals("Cartao")) {
 		    Carteira c = p.getCarteira();
 		    Cartao card = (Cartao) c;

 		    float limiteAtual = card.getLimite();

 		    System.out.printf("Limite do cartão: R$ %.2f%n \n", limiteAtual);

 		    if (limiteAtual < valor) {
 		        
 		    	try {
 		    	    if (limiteAtual < valor) {
 		    	    	throw new PagamentoRecusadoException(card.toString(), "Limite Insuficiente \n", valor); 		       
 		    	    }
		    	    
 		    	    card.pagar(valor);
 		    	    System.out.println("Pagamento APROVADO no Cartão de Crédito! \n");
 		    	    System.out.printf("Limite restante: R$ %.2f%n", card.getLimite());
 		    	   System.out.println("------------------------------------");
 		    	} catch (PagamentoRecusadoException e) {

 		    		System.out.println("\nERRO: " + e.getMessage());
 	 		    	
 	 		    	if (limiteAtual > 0) {
 	 		    	    card.pagar(limiteAtual); 
 	 		    	    System.out.printf("Foi debitado o restante do seu limite: R$ %.2f%n \n", limiteAtual);
 	 		    	}
 	                
 	                float falta = valor - limiteAtual;
 	 		    	p.adicionarDivida(falta);

 	 		    	System.out.printf("O valor restante de R$ %.2f foi adicionado como DÍVIDA.%n \n", falta);
 	 		    	System.out.println("Regularize no menu 'Ver Saldo' antes da próxima corrida.");
 	                System.out.println("------------------------------------");
 	 		    }
 		    }
        }
    	
    	 else if (metDePag.equals("PIX")) {
    		 System.out.println("'1' para pagar por QRCODE | '2' pagar por Chave PIX do Motorista");
    		 String resposta = sc.nextLine();
    		 if (resposta.equals("1")) {
    			 int size = 15; 
    		        
    		        System.out.println("QRCODE GERADO:");
    		        System.out.println();
    		        for (int i = 0; i < size; i++) {
    		            for (int j = 0; j < size; j++) {
    		               
    		                if ((i < 3 && j < 3) || (i < 3 && j >= size - 3) || (i >= size - 3 && j < 3)) {
    		                   
    		                    System.out.print("██"); 
    		                } else if (Math.random() > 0.5) {
    		                   
    		                    System.out.print("██"); 
    		                } else {
    		                    System.out.print("  "); 
    		                }
    		            }
    		            System.out.println(); 
    		        }
    		        System.out.println("Pressione ENTER para confirmar a transferência...");
                    sc.nextLine();
                    System.out.println("Transferência realizada com sucesso!");
    		 }
    	 
        
    		 else if (resposta.equals("2")) {
                 
                 int tipoChave = random.nextInt(3); 
                 String chaveEscolhida = "";
                 String nomeTipo = "";

                 switch(tipoChave) {
                    case 0:
                        chaveEscolhida = m.getCpf();
                        nomeTipo = "CPF";
                        break;
                    case 1:
                        chaveEscolhida = m.getEmail();
                        nomeTipo = "E-mail";
                        break;
                    case 2:
                        chaveEscolhida = m.getTelefone();
                        nomeTipo = "Telefone";
                        break;
                 }

                 System.out.println("O motorista informou a chave PIX (" + nomeTipo + "):");
                 System.out.println(">>> " + chaveEscolhida + " <<<");
                 System.out.println();
                 System.out.println("Pressione ENTER para confirmar a transferência...");
                 sc.nextLine();
                 System.out.println("Transferência realizada com sucesso!");
             }
    	 }
    	 else if(metDePag.equals("Dinheiro")) {
 		    Carteira c = p.getCarteira();
 		    Dinheiro din = (Dinheiro) c;
 		    float saldoAtual = din.getCarteiraFisica();
 		    System.out.printf("\nSaldo na carteira: R$ %.2f%n \n", saldoAtual);
 		        
 		    try {
 		    	if (saldoAtual < valor) {
 		    		throw new SaldoInsuficienteException(p.getCpf(), saldoAtual, valor); 		       
 		    	}
		    	  
 		    		din.pagar(valor);
 		    		System.out.println("Pagamento realizado em dinheiro.");
 		    		System.out.printf("Novo saldo na carteira: R$ %.2f%n", din.getCarteiraFisica());
 		    		System.out.println("------------------------------------");
 		    		
 		    		
 		    	} catch (SaldoInsuficienteException e) {

 		    	    System.out.println(e.getMessage());
 		    
 		    	   if (saldoAtual > 0) {
 	 		    	    din.pagar(saldoAtual);
 	 		    	    System.out.printf("\nFoi debitado tudo o que tinha na carteira: R$ %.2f%n", saldoAtual);
 	 		    	}
 	                
 	                
 	 		    	float falta = valor - saldoAtual;
 	 		    	p.adicionarDivida(falta); 

 	 		    	System.out.printf("\nO valor restante de R$ %.2f foi adicionado como DÍVIDA.%n", falta);
 	 		    	System.out.println("Regularize no menu 'Ver Saldo' antes da próxima corrida.");
 	                System.out.println("------------------------------------");
 	            }
 		        
 		    }

 	 
 	 	System.out.println("Corrida finalizada.");
			System.out.println("");
		
			
			System.out.println("Avalie o motorista com 1 ou até 5 estrelas");
			int avaliacaoDoMotorista = sc.nextInt();
			m.setEstrelas(avaliacaoDoMotorista);
			
			System.out.println("O motorista está avaliando você...");
			
			try {
             Thread.sleep(2000); 
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
			
			int variacao = (random.nextInt(3) - 1);
			int avaliacaoDoPassageiro = avaliacaoDoMotorista + variacao;

			if (avaliacaoDoPassageiro < 1) {
			    avaliacaoDoPassageiro = 1;
			}
			if (avaliacaoDoPassageiro > 5) {
			    avaliacaoDoPassageiro = 5;
			}
			
			
			p.setEstrelas(avaliacaoDoPassageiro);
			System.out.println("O motorista te avaliou com: " + avaliacaoDoPassageiro + " estrelas");
			System.out.println("------------------------------------");
 }
 
    public void	receberPagamento(Passageiro p, Motorista m, float valor) {
    	this.metDePag= p.getMetDePag();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
    	System.out.printf("Processando pagamento de: R$%.2f%n \n", valor);
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        if (metDePag.equals("Cartao")) {
 		    Carteira c = p.getCarteira();
 		    Cartao card = (Cartao) c;

 		    float limiteAtual = card.getLimite();

 		    System.out.printf("Limite do cartão: R$ %.2f%n \n", limiteAtual);

 		    if (limiteAtual < valor) {
 		        
 		    	try {
 		    	    if (limiteAtual < valor) {
 		    	    	throw new PagamentoRecusadoException(card.toString(), "Limite Insuficiente \n", valor); 		       
 		    	    }
		    	    
 		    	    card.pagar(valor);
 		    	    System.out.println("Pagamento APROVADO no Cartão de Crédito! \n");
 		    	    System.out.printf("Limite restante: R$ %.2f%n", card.getLimite());
 		    	   System.out.println("------------------------------------");
 		    	} catch (PagamentoRecusadoException e) {

 		    		System.out.println("\nERRO: " + e.getMessage());
 	 		    	
 	 		    	if (limiteAtual > 0) {
 	 		    	    card.pagar(limiteAtual); 
 	 		    	    System.out.printf("Foi debitado o restante do seu limite: R$ %.2f%n \n", limiteAtual);
 	 		    	}
 	                
 	                float falta = valor - limiteAtual;
 	 		    	p.adicionarDivida(falta);

 	 		    	System.out.printf("O valor restante de R$ %.2f foi adicionado como DÍVIDA.%n \n", falta);
 	 		    	System.out.println("Regularize no menu 'Ver Saldo' antes da próxima corrida.");
 	                System.out.println("------------------------------------");
 	 		    }
 		    }
        }
    	
    	 else if (metDePag.equals("PIX")) {
    		 System.out.println("'1' para pagar por QRCODE | '2' pagar por Chave PIX do Motorista");
    		 String resposta = sc.nextLine();
    		 if (resposta.equals("1")) {
    			 int size = 15; 
    		        
    		        System.out.println("QRCODE GERADO:");
    		        System.out.println();
    		        for (int i = 0; i < size; i++) {
    		            for (int j = 0; j < size; j++) {
    		               
    		                if ((i < 3 && j < 3) || (i < 3 && j >= size - 3) || (i >= size - 3 && j < 3)) {
    		                   
    		                    System.out.print("██"); 
    		                } else if (Math.random() > 0.5) {
    		                   
    		                    System.out.print("██"); 
    		                } else {
    		                    System.out.print("  "); 
    		                }
    		            }
    		            System.out.println(); 
    		        }
    		        System.out.println("Pressione ENTER para confirmar a transferência...");
                    sc.nextLine();
                    System.out.println("Transferência realizada com sucesso!");
    		 }
    	 
        
    		 else if (resposta.equals("2")) {
                 
                 int tipoChave = random.nextInt(3); 
                 String chaveEscolhida = "";
                 String nomeTipo = "";

                 switch(tipoChave) {
                    case 0:
                        chaveEscolhida = m.getCpf();
                        nomeTipo = "CPF";
                        break;
                    case 1:
                        chaveEscolhida = m.getEmail();
                        nomeTipo = "E-mail";
                        break;
                    case 2:
                        chaveEscolhida = m.getTelefone();
                        nomeTipo = "Telefone";
                        break;
                 }

                 System.out.println("O motorista informou a chave PIX (" + nomeTipo + "):");
                 System.out.println(">>> " + chaveEscolhida + " <<<");
                 System.out.println();
                 System.out.println("Pressione ENTER para confirmar a transferência...");
                 sc.nextLine();
                 System.out.println("Transferência realizada com sucesso!");
             }
    	 }
    	 else if(metDePag.equals("Dinheiro")) {
 		    Carteira c = p.getCarteira();
 		    Dinheiro din = (Dinheiro) c;
 		    float saldoAtual = din.getCarteiraFisica();
 		    System.out.printf("\nSaldo na carteira: R$ %.2f%n \n", saldoAtual);
 		        
 		    try {
 		    	if (saldoAtual < valor) {
 		    		throw new SaldoInsuficienteException(p.getCpf(), saldoAtual, valor); 		       
 		    	}
		    	  
 		    		din.pagar(valor);
 		    		System.out.println("Pagamento realizado em dinheiro.");
 		    		System.out.printf("Novo saldo na carteira: R$ %.2f%n", din.getCarteiraFisica());
 		    		System.out.println("------------------------------------");
 		    		
 		    		
 		    	} catch (SaldoInsuficienteException e) {

 		    	    System.out.println(e.getMessage());
 		    
 		    	   if (saldoAtual > 0) {
 	 		    	    din.pagar(saldoAtual);
 	 		    	    System.out.printf("\nFoi debitado tudo o que tinha na carteira: R$ %.2f%n", saldoAtual);
 	 		    	}
 	                
 	                
 	 		    	float falta = valor - saldoAtual;
 	 		    	p.adicionarDivida(falta); 

 	 		    	System.out.printf("\nO valor restante de R$ %.2f foi adicionado como DÍVIDA.%n", falta);
 	 		    	System.out.println("Regularize no menu 'Ver Saldo' antes da próxima corrida.");
 	                System.out.println("------------------------------------");
 	            }
    	 }
    }
}
 
