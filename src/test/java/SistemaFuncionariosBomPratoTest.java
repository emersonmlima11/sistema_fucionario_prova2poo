import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFuncionariosBomPratoTest {
    @Test
    public void testaCadastroEPesquisa(){
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try{
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças", TipoFuncionario.GERENTE, 3000));
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");
            sistema.cadastrarFuncionario(new Funcionario("222.222.222-22", "João Paulo Silva", TipoFuncionario.COZINHEIRO, 5000));
            List<Funcionario> funcionarios = sistema.pesquisarFuncionariosComSalarioMaiorQue(2000);
            assertEquals(2, funcionarios.size());
            assertEquals(1, sistema.contarFuncionariosDoTipo(TipoFuncionario.COZINHEIRO));
        }catch (FuncionarioJaExisteException | FuncionarioInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    public void testaAlterarSalarioDeFuncionario(){
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try{
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças", TipoFuncionario.GERENTE, 3000));
            assertEquals(3000, sistema.pesquisarFuncionario("333.333.333-33").getSalario());
            sistema.alterarSalarioDeFuncionario("333.333.333-33", 5000);
            assertEquals(5000, sistema.pesquisarFuncionario("333.333.333-33").getSalario());
            sistema.cadastrarFuncionario(new Funcionario("222.222.222-22", "João Paulo Silva", TipoFuncionario.COZINHEIRO, 4000));
            assertEquals(4000, sistema.pesquisarFuncionario("222.222.222-22").getSalario());
            assertFalse(sistema.pesquisarFuncionario("222.222.222-22").getSalario() == sistema.pesquisarFuncionario("333.333.333-33").getSalario());
            sistema.alterarSalarioDeFuncionario("222.222.222-22", sistema.pesquisarFuncionario("333.333.333-33").getSalario());
            assertTrue(sistema.pesquisarFuncionario("222.222.222-22").getSalario() == sistema.pesquisarFuncionario("333.333.333-33").getSalario());

        }catch (FuncionarioJaExisteException | FuncionarioInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }
}
