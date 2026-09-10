public abstract class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio.");
        }
        if (salario <= 0) {
            throw new IllegalArgumentException("O salário precisa ser maior que zero.");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public abstract double calcularBonificacao();

    public double calcularRemuneracaoTotal() {
        return getSalario() + calcularBonificacao();
    }

    public void exibirHolerite() {
        System.out.println("\nFuncionário: " + getNome());
        System.out.println("Cargo: " + this.getClass().getSimpleName());
        System.out.printf("Salário: R$ %.2f%n", getSalario());
        System.out.printf("Bonificação: R$ %.2f%n", calcularBonificacao());
        System.out.printf("Remuneração total: R$ %.2f%n", calcularRemuneracaoTotal());
    }
}