package sistemabancario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}
 * 
 * @author Erick Calazães
 * @date 06/09/2024
 *
 */
public class GerenciadoraClientesTest4 {
	
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

	// Validação quando o cliente está no intervalo de idade permitido médio
	@Test
	public void testClienteIdadePermitida1() throws IdadeNaoPermitidaException {
		// Cenário customizado para esse teste
		Cliente cliente = new Cliente(3, "Guilherme Menezes", 35, "guilherme@gmail.com", 1, true);

		// Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		// Verificação
		assertTrue(idadeValida);
	}

	// Validação quando o cliente está no intervalo de idade não permitida na borda inferior
	@Test
	public void testClienteIdadeNaoPermitida2() throws IdadeNaoPermitidaException {
		// Cenário customizado para esse teste
		Cliente cliente = new Cliente(4, "Carlos", 17, "carlos@gmail.com", 1, true);

		// Execução
		// Validação
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}

	// Validação quando o cliente está no intervalo de idade permitida na borda inferior
	@Test
	public void testClienteIdadePermitida3() throws IdadeNaoPermitidaException {
		// Cenário customizado para esse teste
		Cliente cliente = new Cliente(5, "Tutu", 18, "tutu@gmail.com", 1, true);

		// Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		// Verificação
		assertTrue(idadeValida);
	}

	// Validação quando o cliente está no intervalo de idade permitida na borda superior
	@Test
	public void testClienteIdadePermitida4() throws IdadeNaoPermitidaException {
		// Cenário customizado para esse teste
		Cliente cliente = new Cliente(6, "Clayton", 65, "clayton@gmail.com", 1, true);

		// Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

		// Verificação
		assertTrue(idadeValida);
	}

	// Validação quando o cliente está no intervalo de idade não permitida na borda superior
	@Test
	public void testClienteIdadeNaoPermitida5() throws IdadeNaoPermitidaException {
		// Cenário customizado para esse teste
		Cliente cliente = new Cliente(7, "maria", 66, "maria@gmail.com", 1, true);

		// Validação
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}




















}





