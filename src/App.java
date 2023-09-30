import java.util.logging.Logger;

public class App {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(App.class.getName());
        logger.info("===== Tests Started: =====");
        AppTest.test1();
        logger.info("Test 1 done");
        AppTest.test2();
        logger.info("Test 2 done");
        AppTest.test3();
        logger.info("Test 3 done");
        AppTest.test4();
        logger.info("Test 4 done");
    }
}
