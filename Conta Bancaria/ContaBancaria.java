public abstract class ContaBancaria {
    private final String numeroConta;
    private final String titular;
    private double saldo;

    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: Depósitos devem ser maiores que zero.");
            return;
        }
        this.saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado.%n", valor);
    }

    protected void debitar(double valor) {
        this.saldo -= valor;
    }

    public abstract boolean sacar(double valor);

    public void exibirExtrato() {
        System.out.printf("Conta: %s%nTitular: %s%nSaldo atual: R$ %.2f%n", numeroConta, titular, saldo);
    }
}