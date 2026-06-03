import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaFuncionariosBomPratoTest {
    @Test
    public void testaCadastroEPesquisa(){
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try{
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças", TipoFuncionario.GERENTE, 3000));
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");
            //TODO
        }catch (FuncionarioJaExisteException | FuncionarioInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }
}
