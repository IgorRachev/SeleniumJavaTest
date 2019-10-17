
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FirstTest {


   private static Comparator com;
    private static GameProcessor game;
    String testString;


    @BeforeAll
    static void initObjects() {
        com = new Comparator();
        game = new GameProcessor();
    }

    //@Test
    @DisplayName("FirstTest")
    @RepeatedTest(2)
    public void myFirstTest() {

        testString = "bulls and cows";
        Assertions.assertTrue(testString.contains(" "), "test string contains space");

    }


    @Test
    @Disabled
    void test4Digits() {

        //Assertions.assertEquals(new Hider().generator().length(), 4);
        Hider hider = new Hider();
        String value = hider.generator();
        Assertions.assertEquals(value.length(), 4);
    }

    @Test
    void testCows() {
        Comparator com = new Comparator();
        com.setTestAttemptValue(1234);
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, "6501", com);
        Assertions.assertTrue(game.cows.contains("1"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1234, 4526, 1})
    void testCows2(int testAttempt) {
        Comparator com = new Comparator();
        com.setTestAttemptValue(testAttempt);
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, "6501", com);
        Assertions.assertTrue(game.cows.contains("1"));
    }

    @ParameterizedTest
    @CsvSource(value = {"1234;4526;2", "5639;7593;3", "2639;3962;4"}, delimiter = ';')
    void testCowsCsv(int testAttempt, String hiden, String exepted) {
        Comparator com = new Comparator();
        com.setTestAttemptValue(testAttempt);
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, hiden, com);
        Assertions.assertTrue(game.cows.contains(exepted));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ';', numLinesToSkip = 1)
    void testCowsCsvFile(int testAttempt, String hiden, String exepted) {
        Comparator com = new Comparator();
        com.setTestAttemptValue(testAttempt);
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, hiden, com);
        Assertions.assertTrue(game.cows.contains(exepted));
    }


    @ParameterizedTest
    @EnumSource (value = Edata.class,names ={"data1", "data2"})
    void testCowsEnum(Edata dt) {
        Comparator com = new Comparator();
        com.setTestAttemptValue(dt.getAtt());
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, dt.getHidden(), com);
        Assertions.assertTrue(game.cows.contains(dt.getExpected()));
    }



    @ParameterizedTest
    @CsvSource(value = {"1234;4236;2", "5639;5649;3", "2639;2548;1"}, delimiter = ';')
    void testBullsCsv(int testAttempt, String hiden, String exepted) {
        Comparator com = new Comparator();
        com.setTestAttemptValue(testAttempt);
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, hiden, com);
        Assertions.assertTrue(game.bulls.contains(exepted));
    }

    @ParameterizedTest
    @CsvSource(value = {"4236;4236", "5639;5639"}, delimiter = ';')
    void test4Bulls(int testAttempt, String hiden) {
        Comparator com = new Comparator();
        com.setTestAttemptValue(testAttempt);
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, hiden, com);
        Assertions.assertTrue(game.congratsString.contains("4 BULLS!!!"));

        assertThat(game.cows, containsString("2"));
        assertThat(game.cows, equalTo("2 COWS"));
        //assertThat(game.cows, hasCowInside);
    }


    @Test
    @ValueSource(ints = {1234, 4526, 1})
    void testCows3(int testAttempt) {
        Comparator com = new Comparator();
        com.setTestAttemptValue(testAttempt);
        Hider hider = new Hider();
        GameProcessor game = new GameProcessor();
        game.isWin(com.sAttemptValue, "6501", com);

//        Assertions.assertAll(
//                ()-> Assertions.assertTrue(game.bulls.contains("1")),
//                ()-> Assertions.assertTrue("1234".contains("23")),
//                ()-> Assertions.assertTrue(game.cows.contains("3")),
//                ()-> Assertions.assertFalse(hider.generator().contains("0"))
//        );
    }



}


