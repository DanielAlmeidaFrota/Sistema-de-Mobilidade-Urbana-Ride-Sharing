package main;

import java.util.Scanner;
import passageiro.Passageiro;
import passageiro.Dinheiro;
import passageiro.Cartao;
import passageiro.Carteira;
import motorista.Motorista;
import corrida.Corrida;
import usuario.ListadeCadastros;
import usuario.Login;
import motorista.Veiculo;
import java.util.List;
import usuario.LoginMotorista;


public class Principal {
		
	public Principal() {
		
	}

	public static void main(String[] args) {
		
		
		boolean cad = true;
		ListadeCadastros<Passageiro> listaPassageiros = new ListadeCadastros<>(); 
		ListadeCadastros<Motorista> listaMotoristas = new ListadeCadastros<>();
		
		Scanner sc = new Scanner(System.in);
		
		Passageiro[] passageiroPresetado = new Passageiro[10];
		passageiroPresetado[0] = new Passageiro("Eduardo Alberto", "55661865805", "dudugames@hotmail.com","Dodo2010", "ONLINE", "PIX", 4.9);
		passageiroPresetado[1] = new Passageiro("Leo Peliculas", "55162836800", "peliculasleo@outlook.com","Psma2024", "EM CORRIDA", "PIX", 3.4);
		passageiroPresetado[2] = new Passageiro("Paulo Gabriel","76613381578", "bielzice@hotmail.com","BlackCat10", "OFFLINE", "CARTAO", 4.7);
		passageiroPresetado[3] = new Passageiro("Adalberto dos Santos","78440733224", "gerencia.adal@caesb.com.br","Milena1997", "ONLINE", "PIX", 4.9);	
		passageiroPresetado[4] = new Passageiro("Antônia Zélia","48267860851", "antoniazelia@gmail.com", "Nenete85", "ONLINE", "PIX", 4.6);
		passageiroPresetado[5] = new Passageiro("Marco Aurélio","43496785063", "marcoaurelio67@gmail.com", "Aurelio192", "ONLINE", "Dinheiro", 4.5);
		passageiroPresetado[6] = new Passageiro("Cezar Augustus","33580765477", "neancezar@yahoo.com", "Augustus500", "ONLINE", "Dinheiro", 2.5);
		passageiroPresetado[7] = new Passageiro("Beatrice Oliveira","68667302368", "oliv23@hotmail.com", "Bia2010", "OFFLINE", "PIX", 4.0);
		passageiroPresetado[8] = new Passageiro("Suzana Gabrielly","52579367470", "susuki@gmail.com", "Susu15", "ONLINE","PIX", 1.0);
		passageiroPresetado[9] = new Passageiro("Yasmin Rodrigues","05814906499", "yas@gmail.com", "Yas17", "OFFLINE", "PIX", 5.0);
		
		Dinheiro[] dinPresetado = new Dinheiro[2];
		dinPresetado[0] = new Dinheiro();
		dinPresetado[1] = new Dinheiro();
		dinPresetado[0].setCarteiraFisica(12.34f);
		dinPresetado[1].setCarteiraFisica(21.23f);
		passageiroPresetado[5].setSaldo(12.34f); 
		passageiroPresetado[6].setSaldo(21.23f);
		passageiroPresetado[5].setCarteira(dinPresetado[0]);
		passageiroPresetado[6].setCarteira(dinPresetado[1]);
		
		Cartao[] cardPresetado = new Cartao[1];
		cardPresetado[0] = new Cartao();
		cardPresetado[0].setTitCartao("Paulo Gabriel");
		cardPresetado[0].setNumCartao("4004 1234 5678 9010");
		cardPresetado[0].setCVV(159);
		cardPresetado[0].setVal(1229);
		cardPresetado[0].setLimite(15.86f);
		passageiroPresetado[2].setCarteira(cardPresetado[0]);
		passageiroPresetado[2].setSaldo(15.86f);
				
		for (Passageiro p : passageiroPresetado) {
			listaPassageiros.adicionar(p);
		}
		
		Veiculo[] veiculoPresetado = new Veiculo[5];
		veiculoPresetado[0] = new Veiculo("ABC1D34", "FIAT", "TORO", "BRANCO", 2023);
		veiculoPresetado[1] = new Veiculo("BRA2E19", "Ferrari", "Puro Sangue", "Vermelho", 2024);
		veiculoPresetado[2] = new Veiculo("M0PA1O1", "Volkswagen", "KOMBI", "Amarela", 1999);
		veiculoPresetado[3] = new Veiculo("SQU1D13", "Hyundai", "Tucson", "Prata", 2015);
		veiculoPresetado[4] = new Veiculo("PAM5367", "Mini Dolphin", "BYD", "Preto", 2025);
		
		Motorista[] motoristaPresetado = new Motorista[5];
		motoristaPresetado[0] = new Motorista("Joel Divo", "joel.divo@gmail.com", "LookingFor54", "OFFLINE", "61402471017", "1199898834", veiculoPresetado[0], 4.9);
		motoristaPresetado[1] = new Motorista("Andre Lanna", "andrelanna@outlook.com", "Senha1234", "ONLINE", "16121730048", "6199586662",  veiculoPresetado[1], 4.8);
		motoristaPresetado[2] = new Motorista("Tiririca", "mimdepapai@hotmail.com", "MininuLindu1", "ONLINE", "65987933005", "6399752654",  veiculoPresetado[2], 4.1);
		motoristaPresetado[3] = new Motorista("Luciano HUCK", "huckluciano@globo.com", "Angelica1990", "EM CORRIDA", "60265716047", "6199874122", veiculoPresetado[3], 4.3);		
		motoristaPresetado[4] = new Motorista("Ingrid da Silva", "ingridsilva7@gmail.com", "Maria2022", "ONLINE", "03475644704", "64991237564", veiculoPresetado[4], 4.6);
		
		for (Motorista m : motoristaPresetado) {
			listaMotoristas.adicionar(m);
		}
		
		System.out.println("Bem Vindo ao Sistema de Mobilidade Urbana!");
		System.out.println();
		System.out.println("'1' para Cadastro | '2' para Login");
		String escolha = sc.nextLine();
		
		
		if(escolha.equals("1")) {
			while (cad == true) {
				System.out.println("Qual cadastro você deseja fazer?");
				System.out.println("");
				System.out.println("Digite 'P' para Passageiro ou 'M' para Motorista");
				String resposta = sc.nextLine();
				System.out.println();
				System.out.println("------------------------------------");
		
				if (resposta.equalsIgnoreCase("P")) {
					Passageiro p = new Passageiro();
					p.cadastrar();
					listaPassageiros.adicionar(p);
					System.out.println("Passageiro salvo!");
				
					System.out.println("Você deseja cadastrar mais algum usuário? S/N");
					String continuar = sc.nextLine();
					if (continuar.equalsIgnoreCase("N")) {
						cad = false;
					}
				
					else {
						continue;
					}
				}
			
		
				else if (resposta.equalsIgnoreCase("M"))  {
					Motorista m = new Motorista();
					m.cadastrar();
					listaMotoristas.adicionar(m);
					System.out.println("Motorista salvo!");
				
					System.out.println("Você deseja cadastrar mais algum usuário? S/N");
					String continuar = sc.nextLine();
					if (continuar.equalsIgnoreCase("N")) {
						cad = false;
					}
					else {
						continue;
					}
					System.out.println("------------------------------------");
				}
			
				else {
					System.out.println("Selecione uma das duas opções!!!");
					System.out.println();
					System.out.println("------------------------------------");
					continue;
				}
			}
	}
			System.out.println();
			System.out.println("Lista de usuários cadastrados");
			System.out.println();
			System.out.println("Lista de Passageiros:");
			for (Passageiro p : listaPassageiros.getLista()) {
				System.out.println(p);
			}
			System.out.println("------------------------------------");
			System.out.println("Lista de Motoristas:");
			for (Motorista m : listaMotoristas.getLista()) {
				System.out.println(m);
			}
		
		
		System.out.println();
		System.out.println("------------------------------------");
		
		boolean sistemaRodando = true;

        while (sistemaRodando) {
            System.out.println();
            System.out.println("------- TELA DE LOGIN -------");
            System.out.println("\nSelecione o tipo de usuário");
            System.out.println("Passageiro (P) | Motorista (M)?");
            String tipoLogin = sc.nextLine();

            if (tipoLogin.equalsIgnoreCase("P")) {
            	Login sistemaLogin = new Login(listaPassageiros);
                Passageiro pLogado = sistemaLogin.getPassageiroLogado();
                
                boolean telaDoPassageiro = true;
                while (telaDoPassageiro == true) {
                	
                	System.out.println("------- TELA DO PASSAGEIRO -------");
                	System.out.println();
                    System.out.println("Bem-vindo, " + pLogado.getNome());
                    System.out.println("Suas Estrelas: "+ pLogado.getEstrelas());
                    if(pLogado.getDivida() > 0) {
                        System.out.println(" ** ATENÇÃO: DÍVIDA DE R$ " + String.format("%.2f", pLogado.getDivida()) + " **");
                    }
                    System.out.println();
                    System.out.println("--------------------------------------");
                    System.out.println("'1' -----------------> Iniciar Corrida");
                    System.out.println("--------------------------------------");
                    System.out.println("'2' -------> Ver Histórico de Corridas");
                    System.out.println("--------------------------------------");
                    System.out.println("'3' -----------> Ver Saldo da Carteira");
                    System.out.println("--------------------------------------");
                    System.out.println("'0' -------------> Sair (Fazer Logout)");
                    System.out.println("--------------------------------------");
                    String opcao = sc.nextLine();
                    
                    if (opcao.equals("1")) {
                    	if (pLogado.getDivida() == 0) {
                    	pLogado.iniciarCorrida(listaMotoristas);
                    	}
                    	if (pLogado.getDivida() > 0) {
                    		System.out.println("Você possui uma dívida. Pague-a para poder solicitar uma corrida!");
                    		System.out.println("\n Pressione ENTER para voltar");
                        	sc.nextLine();                	
                    	}
                    }
                    
                    else if (opcao.equals("2")) {
                    	System.out.println("\n--------- Histórico ---------");
                    	List<Corrida> historico = pLogado.getHistoricoCorridas();
                    	
                    	if (historico.isEmpty()) {
                    		System.out.println("Você ainda não realizou nenhuma corrida.");
                    	}
                    	else {
                    		for (Corrida c : historico) {
                    			System.out.println(c);
                    		}
                    	}
                    	System.out.println("\nPressione ENTER para voltar");
                    	sc.nextLine();
                    }
                    
                    else if (opcao.equals("3")) {
                    	System.out.println("\n--------- Saldo ---------");
                    	System.out.println("\n Seu saldo atual: " + String.format("%.2f", pLogado.getSaldo()));
                    	System.out.println("\n Sua dívida atual: " + String.format("%.2f", pLogado.getDivida()));
                    	
                    	if (pLogado.getDivida() > 0) {
                    		System.out.println("Você deseja pagar sua dívida agora? S/N");
                    		String r = sc.nextLine();
                    		if (r.equalsIgnoreCase("S")) {
                    			pLogado.pagarDivida();
                    		}
                    	}
                    	System.out.println("\n Pressione ENTER para voltar");
                    	sc.nextLine();
                    }
                    
                    else if (opcao.equals("0")) {
                    	telaDoPassageiro = false;
                    	System.out.println("Fazendo logout...");
                    }
                    
                    else {
                    	System.out.println("Opção inválida!");
                    }
                }
                
            }else if (tipoLogin.equalsIgnoreCase("M")) {
            	LoginMotorista sistemaLogin = new LoginMotorista(listaMotoristas);
                Motorista mLogado = sistemaLogin.getMotoristaLogado();
                
                boolean telaDoMotorista = true;
                while (telaDoMotorista == true) {
                	
                	System.out.println("\n------- TELA DO MOTORISTA -------");
        	        System.out.println("Bem-vindo, " + mLogado.getNome());
        	        System.out.println("Status atual: " + mLogado.getStatus());
        	        System.out.println("Seu veículo: " + mLogado.getVeiculo());
        	        System.out.println("Suas estrelas: " + mLogado.getEstrelas());
        	        System.out.println("--------------------------------------\n");
        	        System.out.println("--------------------------------------");
                    System.out.println("'1' ------------------> Buscar Corrida");
                    System.out.println("--------------------------------------");
                    System.out.println("'2' -> Alterar Status (ONLINE/OFFLINE)");
                    System.out.println("--------------------------------------");
                    System.out.println("'3' -------> Ver Histórico de Corridas");
                    System.out.println("--------------------------------------");
                    System.out.println("'0' -------------> Sair (Fazer Logout)");
                    System.out.println("--------------------------------------");

        	        String op = sc.nextLine();

        	        switch (op) {
        	        case "1":
        	        	if (mLogado.getStatus().equals("ONLINE")) {
        	        	mLogado.iniciarCorrida(listaPassageiros);
        	        	}
        	        	else {
        	        		System.out.println("Você precisa estar ONLINE para buscar uma corrida");
        	        		System.out.println("\nPressione ENTER para continuar");
            	            sc.nextLine();
            	            break;
        	        	}
        	        break;
        	        	
        	        case "2":
        	            if (mLogado.getStatus().equalsIgnoreCase("ONLINE"))
        	                mLogado.setStatus("OFFLINE");
        	            else
        	                mLogado.setStatus("ONLINE");

        	            System.out.println("Status atualizado para: " + mLogado.getStatus());
        	            System.out.println("\nPressione ENTER para continuar");
        	            sc.nextLine();
        	            break;

        	        case "3":
        	        	System.out.println("\n--------- Histórico ---------");
        	            
        	        	List<Corrida> historico = mLogado.getHistoricoCorridas();
        	        	if (historico.isEmpty()) {
        	                System.out.println("Nenhuma corrida realizada ainda.");
        	            } else {
        	                for (Corrida c : historico) {
        	                    System.out.println(c); 
        	                    System.out.println("-------------------------");
        	                }
        	            }
        	        	System.out.println("\nPressione ENTER para continuar");
        	            sc.nextLine();
        	            break;

        	        case "0":
        	            telaDoMotorista = false;
        	            System.out.println("Logout efetuado!");
        	            break;

        	        default:
        	            System.out.println("Opção inválida!");
        	        }
        	    }
                
            }else {
            	System.out.println("Opção inválida! Tente novamente.");
                continue;
            }
      
                System.out.println("------------------------------------");
                System.out.println("Sessão finalizada.");
                System.out.println("Deseja fazer login com outro usuário? (S/N)");
                String resp = sc.nextLine();
                
                if (resp.equalsIgnoreCase("N")) {
                    sistemaRodando = false; 
                    System.out.println("Sistema encerrado. Até logo!");
                }
                
            }
        

		sc.close();
	}
	
}
