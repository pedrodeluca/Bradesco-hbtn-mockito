package mockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    static Calculadora  calculadora;

    @BeforeAll
    static void main() {
        calculadora = new Calculadora();
    }

    @Test
    void testeSomar() {
        assertEquals(5, calculadora.somar(2, 3));
    }
}
