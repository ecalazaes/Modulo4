package sistemabancario;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GerenciadoraClientesTest1 {

    /**
     * Teste da funcionalidade de pesquisa de um cliente a partir do seu ID
     *
     * @Author Erick Calazães
     * @date 30/08/2024
     */
    @Test
    public void testePesquisaCliente(){

        //Instanciando 02 clientes
        Cliente cliente01 = new Cliente(1, "Erick", 33, "ecalazaes@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Maria", 25, "maria@gmail.com", 2, true);

        // Adicionando clientes na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.addAll(Arrays.asList(cliente01, cliente02));

        // Instancia da classe para o teste
        GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);

        // Execução do teste
        Cliente cliente =  gerClientes.pesquisaCliente(1);

        // Avaliação do teste
        assertThat(cliente.getId(), CoreMatchers.is(1));
        assertThat(cliente.getEmail(), CoreMatchers.is("ecalazaes@gmail.com"));
    }

    /**
     * Teste de remoção de um cliente a partir de seu ID
     *
     * @Author Erick Calazães
     * @Date 30/08/2024
     */
    @Test
    public void testeRemoveCliente() {

        //Instanciando 02 clientes
        Cliente cliente01 = new Cliente(1, "Erick", 33, "ecalazaes@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Maria", 25, "maria@gmail.com", 2, true);

        // Adicionando clientes na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.addAll(Arrays.asList(cliente01, cliente02));

        // Instancia da classe para o teste
        GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);

        // Execução do teste
        Boolean clienteRemovido = gerClientes.removeCliente(1);

        //Avaliação de teste
        assertThat(clienteRemovido.booleanValue(), CoreMatchers.is(true));
        assertThat(clienteRemovido, CoreMatchers.is(true));
        assertThat(gerClientes.getClientesDoBanco().size(), CoreMatchers.is(1));
        assertNull(gerClientes.pesquisaCliente(1));
        assertTrue(clienteRemovido);
    }
}

