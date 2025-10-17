package mockito1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BancoServiceTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private BancoService bancoService;

    @Test
    public void testConsultarSaldo() {
        Conta conta = new Conta("123", 100.0);
        when(contaRepository.buscarConta("123")).thenReturn(conta);

        double saldo = bancoService.consultarSaldo("123");

        assertEquals(100.0, saldo);
        verify(contaRepository).buscarConta("123");
    }

    @Test
    public void testDepositar() {
        Conta conta = new Conta("123", 100.0);
        when(contaRepository.buscarConta("123")).thenReturn(conta);

        bancoService.depositar("123", 50.0);

        assertEquals(150.0, conta.getSaldo());
        verify(contaRepository).buscarConta("123");
        verify(contaRepository).salvar(conta);
    }
}
