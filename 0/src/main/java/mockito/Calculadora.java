package mockito;

public class Calculadora implements ServicoMatematico {

    @Override
    public int somar(int a, int b) {
        return a + b;
    }
}
