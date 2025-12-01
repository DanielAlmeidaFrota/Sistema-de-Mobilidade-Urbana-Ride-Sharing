package usuario;

import java.util.Scanner;
import motorista.Motorista;
import usuario.ListadeCadastros;

public class LoginMotorista {

    Scanner sc = new Scanner(System.in);

    private Motorista motoristaLogado;
    private String email, senha;
    private boolean achou = false;

    public LoginMotorista(ListadeCadastros<Motorista> listaMotoristas) {

        while (achou == false) {
            System.out.println("\nEmail: ");
            this.email = sc.nextLine();
            System.out.println("Senha: ");
            this.senha = sc.nextLine();
            achou = pesquisarMotorista(listaMotoristas);

            if (achou == false) {
                System.out.println("Usuário ou senha incorretos! Tente novamente. \n");
            }
        }

        System.out.println("Login realizado com sucesso!");
    }

    public boolean pesquisarMotorista(ListadeCadastros<Motorista> lista) {
        for (Motorista m : lista.getLista()) {
            if (m.getEmail().equals(this.email) &&
                m.getSenha().equals(this.senha)) {
                this.motoristaLogado = m;
                return true;
            }
        }
        return false;
    }

    public Motorista getMotoristaLogado() {
        return motoristaLogado;
    }
}
