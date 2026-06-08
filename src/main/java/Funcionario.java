import java.util.Objects;

/**
 * Representa um funcionario do local
 * <p>
 *     Usada para demonostrar a modelagem de dados de um funcionario
 *     para ser usado como um objeto de manipulação e armazenamento
 * </p>
 * */
public class Funcionario {
    /**
     * Variáveis principais da classe
     * cpf: chave primaria de identificação
     * */
    private String cpf, nome;
    private TipoFuncionario tipo;
    private double salario;

    /**
     * Construtor Genérico sem Params
     * */
    Funcionario(){
        this("", "", null, 0.0);
    }

    /**
     * Construtor com sem Params
     * @param cpf identificação do Funcionario
     * @param nome nome completo do Funcionario
     * @param salario valor que o Funcionario recebe
     * @param tipo cargo que o Funcionario ocupa
     * */
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

    /**
     * Metodo que compara se um objeto é igual ao outro
     * Comparação por meio do Cpf
     * */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(cpf, that.cpf);
    }

    /**
     * Metodo que gera um código unico para cada objeto
     * */
    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Funcionario ("+this.cpf+"): "+this.nome+" do Tipo: "+this.tipo+" com salário: "+this.salario;
    }
}
