package sistemabancario;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}
 * 
 * @author Erick Calazães
 * @date 06/09/2024
 *
 */
public class GerenciadoraClientesTest3 {
	
	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	@Before
	public void setUp() {
	/*============ Fase1: Montagem do Cenário Global ============*/
		//criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 48, "claytonchagas1@gmail", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 18, "mariachagas@gmail", 2, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.addAll(Arrays.asList(cliente01, cliente02));

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
	}
	
	//método para apagar o cenário construído a cada chamada de um método com @Test
	@After
	public void tearDown() {
		//desmontagem do cenário global
		gerClientes.limpa();
		gerClientes.getClientesDoBanco().clear();
	}
	
	
	
	/**
	 * Teste da funcionalidade de pesquisa de um cliente a partir do seu ID
	 * 
	 * @author Erick Calazães
	 * @date 06/09/2024
	 */
	@Test
	public void testPesquisaClienteExistente (){
		
//		/*============ Fase1: Montagem do Cenário ============*/
//		int idCliente01 = 1;
//		int idCliente02 = 2;
//		//criando alguns clientes
//		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 48, "claytonchagas1@gmail", 1, true);
//		Cliente cliente02 = new Cliente(idCliente02, "Maria", 18, "mariachagas@gmail", 2, true);
//		
//		//inserindo os clientes criados na lista de clientes do banco
//		List<Cliente> clientesDoBanco = new ArrayList<>();
//		clientesDoBanco.add(cliente01);
//		clientesDoBanco.add(cliente02);
//		
////		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco); -> refatorado na linha abaixo
//		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/*============ Fase2: Execucao do Teste ============*/
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		/*============ Fase3: Verificação e Análise ============*/
		assertThat(cliente.getId(), is(idCliente01));
		assertThat(cliente.getEmail(), is("claytonchagas1@gmail"));
		
	}
	
	@Test
	public void testPesquisaClienteInexistente (){
		/*============ Fase2: Execucao do Teste ============*/
		Cliente cliente = gerClientes.pesquisaCliente(10);
		
		/*============ Fase3: Verificação e Análise ============*/
		assertNull(cliente);
	}
	
	/**
	 * Teste da remocao de um cliente a partir de seu ID
	 * 
	 * @author Erick Calazães
	 * @date 06/09/2024
	 */
	@Test
	public void testRemoveClienteExistente() {
//		/*============ Fase1: Montagem do Cenário ============*/
//		int idCliente01 = 1;
//		int idCliente02 = 2;
//		//criando alguns clientes
//		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 48, "claytonchagas1@gmail", 1, true);
//		Cliente cliente02 = new Cliente(idCliente02, "Maria", 18, "mariachagas@gmail", 2, true);
//		
//		//inserindo os clientes criados na lista de clientes do banco
//		List<Cliente> clientesDoBanco = new ArrayList<>();
//		clientesDoBanco.add(cliente01);
//		clientesDoBanco.add(cliente02);
//		
////		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco); -> refatorado na linha abaixo
//		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/*============ Fase2: Execucao do Teste ============*/
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/*============ Fase3: Verificação e Análise ============*/
		assertThat(clienteRemovido, is(true));
		assertTrue(clienteRemovido);
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
		
	}
	
	@Test
	public void testRemoveClienteInexistente() {
		/*============ Fase2: Execucao do Teste ============*/
		boolean clienteRemovido = gerClientes.removeCliente(10);
		
		/*============ Fase3: Verificação e Análise ============*/
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		assertFalse(clienteRemovido);
		assertThat(clienteRemovido, is(false));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}





