import java.util.List;

public interface SistemaFuncionarios {
    /**
     * Metodo que cadastra um funcionario por meio de um objeto
     * @param funcionario objeto do tipo Funcionario.
     * @throws FuncionarioJaExisteException chama essa exceção caso já existe esse funcionario cadastrado
     * */
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException;

    /**
     * Metodo que cadastra cria e cadastra um funcionario
     * @param nome
     * @param salario
     * @param cpf
     * @param tipoFuncionario
     * @throws FuncionarioJaExisteException chama essa exceção caso já existe esse funcionario cadastrado.
     * */
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario)
            throws FuncionarioJaExisteException;

    /**
     * Metodo que altera o salario de um funcionario específico.
     * @param cpfFuncionario cpf que identifica o funcionario que será pesquisado.
     * @param salario novo salário do funcionario.
     * @throws FuncionarioInexistenteException caso o funcionario que foi designado não existe no armazenamento.
     * */
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double salario) throws FuncionarioInexistenteException;

    /**
     * Metodo que contabiliza quantos funcionarios de um determinado tipo existem
     * @param tipo cargo que será contabilizado
     * @return quantidade de funcionario do tipo designado
     * */
    public int contarFuncionariosDoTipo(TipoFuncionario tipo);

    /**
     * Metodo que verifica se um funcionario existe
     * @param cpfFuncionario identificação do funcionario que será verificado
     * @return true, caso exista esse funcionario, false, caso não exista esse funcionario
     * */
    public boolean funcionarioJaExiste(String cpfFuncionario);

    /**
     * Metodo que pesquisa uma lista de funcionario de um tipo
     * @param tipo cargo designado para pesquisa
     * @return Lista com todos os funcionario do tipo
     * */
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo);

    /**
     * Metodo que pesquisa um funcionario específico
     * @param cpfFuncionario identificação do funcionario
     * @return objeto que representa o funcionario designado
     * @throws FuncionarioInexistenteException caso o funcionario do cpf passado não exista
     * */
    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException;

    /**
     * Metodo que pesquisa todos os funcionarios com o salario maior do que o designado
     * @param valor quantidade que servira de filtro para pesquisa
     * @return lista de funcionario que possuam um salario maior que o designado
     * */
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor);
}
