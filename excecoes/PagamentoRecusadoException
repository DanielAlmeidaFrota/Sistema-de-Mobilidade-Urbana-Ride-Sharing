package excecoes;


public class PagamentoRecusadoException extends SistemaMobilidadeException {
    
    private final String numeroCartao;
    private final String motivoRecusa;
    private final double valorTransacao;
    
    public PagamentoRecusadoException(String numeroCartao, String motivoRecusa, double valorTransacao) {
        super(String.format(
            "Pagamento recusado para cartão %s. Motivo: %s. Valor: R$ %.2f",
            numeroCartao, motivoRecusa, valorTransacao));
        this.numeroCartao = numeroCartao;
        this.motivoRecusa = motivoRecusa;
        this.valorTransacao = valorTransacao;
    }
    
    public PagamentoRecusadoException(String numeroCartao, String motivoRecusa, double valorTransacao, Throwable causa) {
        super(String.format(
            "Pagamento recusado para cartão %s. Motivo: %s. Valor: R$ %.2f",
            numeroCartao, motivoRecusa, valorTransacao), causa);
        this.numeroCartao = numeroCartao;
        this.motivoRecusa = motivoRecusa;
        this.valorTransacao = valorTransacao;
    }
    
    public String getNumeroCartao() {
        return numeroCartao;
    }
    
    public String getMotivoRecusa() {
        return motivoRecusa;
    }
    
    public double getValorTransacao() {
        return valorTransacao;
    }
}
