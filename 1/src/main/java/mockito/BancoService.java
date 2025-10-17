package mockito1;

public class BancoService {
    private ContaRepository contaRepository;

    public BancoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public double consultarSaldo(String numeroConta) {
        Conta conta = contaRepository.buscarConta(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada");
        }
        return conta.getSaldo();
    }

    public void depositar(String numeroConta, double valor) {
        Conta conta = contaRepository.buscarConta(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada");
        }
        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.salvar(conta);
    }
}
