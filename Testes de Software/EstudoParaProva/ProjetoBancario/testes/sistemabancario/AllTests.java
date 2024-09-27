package sistemabancario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Classe que executa todas as classes de teste relacionadas à gerência de clientes.
 *
 * Agrupa e executa em conjunto os testes de GerenciadoraClientes.
 *
 * @author Erick Calazães
 * @date 27/09/2024
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        GerenciadoraClientesTest.class
})
public class AllTests {
    // Classe utilizada apenas como configuração de suite de testes.
}
