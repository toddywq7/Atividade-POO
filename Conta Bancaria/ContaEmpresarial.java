public class ContaEmpresarial extends ContaBancaria {
    private final double limite;
    private static final double TAXA_SAQUE = 5.00;

    public ContaEmpresarial(String numeroConta, String titular, double limite) {
        super(numeroConta, titular);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor deve ser maior que zero.");
            return false;
        }
        double totalNecessario = valor + TAXA_SAQUE;
        System.out.printf("Tentativa de saque: R$ %.2f%n", valor);

        if (getSaldo() + limite >= totalNecessario) {
            System.out.printf("Taxa de saque: R$ %.2f%n", TAXA_SAQUE);
            debitar(totalNecessario);
            System.out.println("Saque realizado com sucesso.");
            return true;
        }
        System.out.println("Erro: Saque recusado. Limite insuficiente.");
        return false;
    }

    @Override
    public void exibirExtrato() {
        super.exibirExtrato();
        double limiteDisponivel = limite + (getSaldo() < 0 ? getSaldo() : 0);
        System.out.printf("Limite disponível: R$ %.2f%n", limiteDisponivel);
    }
}