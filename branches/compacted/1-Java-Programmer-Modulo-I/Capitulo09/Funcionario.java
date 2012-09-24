public class Funcionario {

    private long matricula;
    private String nome;
    private double salario;

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString() {
        return "Matricula: " + matricula
             + "\nNome     : " + nome
             + "\nSalario  : " + salario;
    }
}
