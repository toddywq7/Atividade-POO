public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, String titular) {
        super(numeroConta, titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor deve ser maior que zero.");
            return false;
        }
        if (getSaldo() >= valor) {
            debitar(valor);
            System.out.println("Saque realizado com sucesso.");
            return true;
        }
        System.out.println("Erro: Conta poupança não pode ficar negativa.");
        return false;
    }
}