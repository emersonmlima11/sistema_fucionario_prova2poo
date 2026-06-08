import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa o sistema que gerencia funcionarios de um restaturante, Bom Prato
 * Implementa a interface SistemaFuncionarios
 * */
public class SistemaFuncionariosBomPrato implements SistemaFuncionarios{

    /**
     * Representa os dados que serão armazenados por meio de um Map
     * <p>
     *     chave: o cpf do Funcionario
     *     valor: o objeto Funcionario
     * <p/>
     * */
    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionariosBomPrato(){
        this.funcionarios = new HashMap<>();
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException{
        if(funcionarioJaExiste(funcionario.getCpf())){
            throw new FuncionarioJaExisteException("Funcionario: "+funcionario.getCpf()+" já foi cadastrado!!");
        }
        this.funcionarios.put(funcionario.getCpf(), funcionario);
    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario)
            throws FuncionarioJaExisteException{

        if(funcionarioJaExiste(cpf)){
            throw new FuncionarioJaExisteException("Funcionario: "+cpf+" já foi cadastrado!!");
        }

        this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipoFuncionario, salario));
    }

    @Override
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double salario) throws FuncionarioInexistenteException{
        if(!funcionarioJaExiste(cpfFuncionario)){
            throw new FuncionarioInexistenteException("Funcionario: "+cpfFuncionario+" Não existe!!");
        }

        this.funcionarios.get(cpfFuncionario).setSalario(salario);
    }

    @Override
    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int contador = 0;
        for(Funcionario f : this.funcionarios.values()){
            if(f.getTipo() == tipo){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return this.funcionarios.containsKey(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        List<Funcionario> funcionariosPorTipo = new ArrayList<>();

        for(Funcionario f : this.funcionarios.values()){
            if(f.getTipo() == tipo){
                funcionariosPorTipo.add(f);
            }
        }

        return funcionariosPorTipo;
    }

    @Override
    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException{
        if(!funcionarioJaExiste(cpfFuncionario)){
            throw new FuncionarioInexistenteException("Funcionario "+cpfFuncionario+" Não existe!!");
        }

        return this.funcionarios.get(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> funcionariosMaiorQue = new ArrayList<>();
        for(Funcionario f : this.funcionarios.values()){
            if(f.getSalario() > valor){
                funcionariosMaiorQue.add(f);
            }
        }
        return funcionariosMaiorQue;
    }
}
