import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;


public class CalculatorTests {

    private static Calculator cal;

    @BeforeAll
    private static void initObjects() {
        cal = new Calculator();
    }


    @ParameterizedTest
    @DisplayName("test of sum")
    @CsvSource(value = {"4;5;9", "-5;-6;-11", "-10;9;-1", "0;16;16"}, delimiter = ';')
    public void testSum(int a, int b, int sAB) {
        Assertions.assertEquals(cal.sum(a, b), sAB);
    }

    @ParameterizedTest
    @DisplayName("test of divide")
    @CsvFileSource(resources = "dataCalc.csv", delimiter = ';', numLinesToSkip = 1)
    public void testDivide(int a, int b, int result) {
        Assertions.assertEquals(cal.divide(a, b), result);
    }

    @ParameterizedTest
    @DisplayName("test of multy")
    @EnumSource(value = Edata.class, names = {"data1", "data2"})
    void testMultyEnum(EdataCal edata) {

        Assertions.assertEquals(cal.multiply(edata.getA(),edata.getB()),edata.getMulty());
    }

}
