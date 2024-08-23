package sistemabancario;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class GerenciadoraClientesTest1 {

    @Test
    public void testPesquisaCliente(){

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
        assertThat(cliente.getId(), CoreMatchers.is(1));
        assertThat(cliente.getEmail(), CoreMatchers.is("ecalazaes@gmail.com"));
    }
}
