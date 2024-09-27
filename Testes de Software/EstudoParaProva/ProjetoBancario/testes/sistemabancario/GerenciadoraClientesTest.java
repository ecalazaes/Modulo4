package sistemabancario;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}
 *
 * @author Erick Calazães
 * @date 27/09/2024
 */

public class GerenciadoraClientesTest {

    private GerenciadoraClientes gerenciadoraClientes;
    private int idCliente01 = 1;
    private int idCliente02 = 2;

    /**
     * Configura o ambiente de teste inicializando os objetos necessários.
     * Este método é executado antes de cada @teste, garantindo que o estado
     * inicial dos objetos seja o mesmo para cada execução de teste.
     *
     * @author Erick Calazães
     * @date 27/09/2024
     */
    @Before
    public void setUp() {
        Cliente c1 = new Cliente(idCliente01, "Erick", 33, "ecalazaes@gmail.com", 1, true);
        Cliente c2 = new Cliente(idCliente02, "Daniele", 38, "dani@gmail.com", 2, true);

        List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(c1, c2));

        gerenciadoraClientes = new GerenciadoraClientes(listaClientes);
    }

    /**
     * Limpa o ambiente de teste removendo os dados de clientes.
     * Este método é executado após cada @teste, garantindo que o estado do
     * sistema esteja limpo para os próximos testes.
     *
     * @author Erick Calazães
     * @date 27/09/2024
     */
    @After
    public void tearDown() {
        gerenciadoraClientes.getClientesDoBanco().clear();
    }

    /**
     * Teste da funcionalidade de pesquisa de um cliente existente no banco de dados
     *
     * Verifica se o método de pesquisa de cliente retorna corretamente o cliente
     * com base em seu ID. Além disso, valida os atributos do cliente retornado, como
     * ID, email e nome, garantindo que os dados correspondam ao esperado.
     *
     * @author Erick Calazães
     * @date 27/09/2024
     */
    @Test
    public void testPesquisaClienteExistente(){
        Cliente cliente = gerenciadoraClientes.pesquisaCliente(idCliente01);

        assertThat(cliente.getId(), is(idCliente01));
        assertThat(cliente.getEmail(), is("ecalazaes@gmail.com"));
        assertThat(cliente.getNome(), is("Erick"));
    }

    /**
     * Teste da funcionalidade de pesquisa de um cliente inexistente no banco de dados
     *
     * Verifica se o método de pesquisa de cliente retorna corretamente `null`
     * quando um cliente com o ID fornecido não existe na lista de clientes.
     *
     * @author Erick Calazães
     * @date 27/09/2024
     */
    @Test
    public void testPesquisaClienteInexistente(){
        Cliente cliente = gerenciadoraClientes.pesquisaCliente(10);

        assertNull(cliente);
    }

    /**
     * Teste da adição de um cliente ao banco de dados de clientes
     *
     * Verifica se um novo cliente é corretamente adicionado à lista de clientes
     * e se o tamanho da lista aumenta conforme esperado.
     *
     * @author Erick Calazães
     * @date 27/09/2024
     */

    @Test
    public void testAdicionarCliente(){
        int idCliente03 = 3;
        Cliente c3 = new Cliente(idCliente03, "Ronaldo", 61, "fuzipa@hotmail.com", 3, true);

        gerenciadoraClientes.adicionaCliente(c3);

        assertTrue(gerenciadoraClientes.getClientesDoBanco().contains(c3));
        assertEquals(3, gerenciadoraClientes.getClientesDoBanco().size());
    }
}































