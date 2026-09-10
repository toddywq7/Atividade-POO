public class Vendedor extends Funcionario {
    private double totalVendido;

    public Vendedor(String nome, String cpf, double salario, double totalVendido) {
        super(nome, cpf, salario);
        if (totalVendido < 0) {
            throw new IllegalArgumentException("O total vendido não pode ser negativo.");
        }
        this.totalVendido = totalVendido;
    }

    @Override
    public double calcularBonificacao() {
        double comissao = totalVendido * 0.02;
        double bonusFixo = getSalario() * 0.05;
        return bonusFixo + comissao;
    }
}