package excecoes;

public class SaldoInsuficienteException extends SistemaMobilidadeException {
    
    private final String cpfPassageiro;
    private final double saldoAtual;
    private final double valorCorrida;
    
    public SaldoInsuficienteException(String cpfPassageiro, float saldoAtual, double valorCorrida) {
        super(String.format(
            "Saldo insuficiente para o passageiro CPF: %s. Saldo atual: R$ %.2f, Valor da corrida: R$ %.2f",
            cpfPassageiro, saldoAtual, valorCorrida
        ));
        this.cpfPassageiro = cpfPassageiro;
        this.saldoAtual = saldoAtual;
        this.valorCorrida = valorCorrida;
    }
    
    
    public String getCpfPassageiro() {
        return cpfPassageiro;
    }
    
    public double getSaldoAtual() {
        return saldoAtual;
    }
    
    public double getValorCorrida() {
        return valorCorrida;
    }
}
