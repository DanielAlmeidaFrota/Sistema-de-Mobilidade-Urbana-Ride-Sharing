package excecoes;

import corrida.Corrida;


public class EstadoInvalidoDaCorridaException extends SistemaMobilidadeException {

    private final String estadoAtual;
    private final String acaoTentada;

    public EstadoInvalidoDaCorridaException(String estadoAtual, String acaoTentada) {
        super(String.format(
            "Ação '%s' inválida para corrida no estado '%s'",
            acaoTentada, estadoAtual
        ));
        this.estadoAtual = estadoAtual;
        this.acaoTentada = acaoTentada;
    }
    
    //Getters
    public String getEstadoAtual() {
        return estadoAtual;
    }
    
    public String getAcaoTentada() {
        return acaoTentada;
    }
}
