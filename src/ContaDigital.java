public class ContaDigital {
    private String titular;
    private String codigoConta;
    private double saldo;
    private static final double TAXA_OPERACIONAL = 0.50;

    public ContaDigital(String titular, String codigoConta, double saldoInicial) {
        this.titular = titular;
        this.codigoConta = codigoConta;
        this.saldo = saldoInicial;
    }

    public boolean creditar(double valor) {
        if (valor > 0) {
            saldo += valor;
            saldo -= TAXA_OPERACIONAL;
            return true;
        }
        return false;
    }

    public boolean debitar(double valor) {
        if (valor > 0 && (saldo - valor - TAXA_OPERACIONAL) >= 0) {
            saldo -= (valor + TAXA_OPERACIONAL);
            return true;
        }
        return false;
    }

    public boolean transferirPara(ContaDigital destino, double valor) {
        if (valor > 0 && (saldo - valor - TAXA_OPERACIONAL) >= 0) {
            if (destino.creditar(valor)) {
                saldo -= valor + TAXA_OPERACIONAL;
                return true;
            }
        }
        return false;
    }

    public boolean pagarTitulo(double valor) {
        return debitar(valor);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public String getCodigoConta() {
        return codigoConta;
    }
}
