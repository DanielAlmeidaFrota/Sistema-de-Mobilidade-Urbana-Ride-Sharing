package excecoes;

public class NenhumMotoristaDisponivelException extends SistemaMobilidadeException {
    
    private final String categoriaSolicitada;
    
    public NenhumMotoristaDisponivelException(String categoriaSolicitada) {
        super(String.format(
            "Nenhum motorista disponível para a categoria '%s'",
            categoriaSolicitada
        ));
        this.categoriaSolicitada = categoriaSolicitada;
    }
    
    public NenhumMotoristaDisponivelException(String mensagem, String categoriaSolicitada) {
        super(mensagem);
        this.categoriaSolicitada = categoriaSolicitada;
    }
    
    // Getters
    public String getCategoriaSolicitada() {
        return categoriaSolicitada;
    }
}
