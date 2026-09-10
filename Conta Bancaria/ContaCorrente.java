public class ContaCorrente extends ContaBancaria {
    private final double limite;

    public ContaCorrente(String numeroConta, String titular, double limite) {
        super(numeroConta, titular);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor deve ser maior que zero.");
            return false;
        }
        if (getSaldo() + limite >= valor) {
            debitar(valor);
            System.out.println("Saque realizado com sucesso.");
            return true;
        }
        System.out.println("Erro: Saque recusado. Limite excedido.");
        return false;
    }

    @Override
    public void exibirExtrato() {
        super.exibirExtrato();
        double limiteDisponivel = limite + (getSaldo() < 0 ? getSaldo() : 0);
        System.out.printf("Limite disponível: R$ %.2f%n", limiteDisponivel);
    }
}