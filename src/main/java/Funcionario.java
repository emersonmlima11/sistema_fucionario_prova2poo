import java.util.Objects;

public class Funcionario {
    String cpf, nome;
    TipoFuncionario tipo;
    double salario;

    Funcionario(){
        this("", "", null, 0.0);
    }

    Funcionario(String cpf, String nome, TipoFuncionario tipo, double salario){
        this.cpf = cpf;
        this.nome = nome;
        this.tipo = tipo;
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Funcionario ("+this.cpf+"): "+this.nome+" do Tipo: "+this.tipo+" com salário: "+this.salario;
    }
}
