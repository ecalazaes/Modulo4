package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre contas, realizadas pela classe {@link GerenciadoraContas}
 *
 * @author Erick Calazães
 * @date 06/09/2024
 *
 */

public class GerenciadoraContasTest1 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		/*============ Fase1: Montagem do Cenário ============*/
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 500, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<ContaCorrente>();
		contaDoBanco.addAll(Arrays.asList(conta01, conta02));

		gerContas = new GerenciadoraContas(contaDoBanco);
		
		/*============ Fase2: Execucao do Teste ============*/
		boolean sucesso = gerContas.transfereValor(idConta01, 50, idConta02);
		
		/*============ Fase3: Verificação e Análise ============*/
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(150.0));
		assertThat(conta02.getSaldo(), is(550.0));
	}
}
