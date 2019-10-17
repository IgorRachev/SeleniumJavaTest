import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExampleOfNestedTest {
    private static Comparator com;
    private static GameProcessor game;

    @BeforeAll
    static void initObjects() {
        com = new Comparator();
        game = new GameProcessor();
    }

    @Nested
    public class ChildTest {

        @ParameterizedTest
        @DisplayName("Show cows")
        @ValueSource(ints = {1234, 4526, 1})
        void testCows2(int testAttempt) {
            //Comparator com = new Comparator();
            com.setTestAttemptValue(testAttempt);
            //GameProcessor game = new GameProcessor();
            game.isWin(com.sAttemptValue, "6501", com);
            Assertions.assertTrue(game.cows.contains("1"));
        }
    }
}
