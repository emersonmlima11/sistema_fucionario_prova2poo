import java.util.List;

public interface SistemaFuncionarios {
    public void cadastrarFuncionario(Funcionario funcionario);
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario);
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double salario);
    public int contarFuncionariosDoTipo(TipoFuncionario tipo);
    public boolean funcionarioJaExiste(String cpfFuncionario);
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo);
    public Funcionario pesquisarFuncionario(String cpfFuncionario);
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor);
    }
}
