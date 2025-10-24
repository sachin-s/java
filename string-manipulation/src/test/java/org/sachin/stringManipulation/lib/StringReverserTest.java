package org.sachin.stringManipulation.lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringReverserTest {

    private static final Logger log = LogManager.getLogger(StringReverserTest.class);
    private static final String TABLE_BORDER =
            "╔══════════════════════════════════════════════════════════════════════════════════╗";
    private static final String TABLE_HEADER =
            "║ %-15s │ %-12s │ %-12s │ %-12s │ %-10s ║";
    private static final String TABLE_DIVIDER =
            "╟──────────────────────────────────────────────────────────────────────────────────╢";
    private static final String TABLE_BOTTOM =
            "╚══════════════════════════════════════════════════════════════════════════════════╝";

    private final StringReverser reverser = new StringReverser();

    @BeforeAll
    static void printHeader() {
        // Print immediately to console
        System.out.flush();

        log.info("╔═══════════════════════════════════════════════════════════════════════════╗");
        log.info(String.format("║ %-15s │ %-12s │ %-12s │ %-12s │ %-10s ║",
                "TEST NAME", "INPUT", "EXPECTED", "ACTUAL", "RESULT"));
        log.info("╟───────────────────────────────────────────────────────────────────────────╢");

        // Force output to appear before tests start
        System.out.flush();
    }

    @AfterAll
    static void printFooter() {
        log.info("╚═══════════════════════════════════════════════════════════════════════════╝      ");
        System.out.flush();
    }

    static Stream<TestCaseData> yamlCases() {
        Yaml yaml = new Yaml();
        try (InputStream in = StringReverserTest.class.getResourceAsStream("/testdata/stringReverser.yaml")) {
            TestFile data = yaml.loadAs(in, TestFile.class);
            List<TestCaseData> tests = data.getTests();
            return tests.stream();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML test data", e);
        }
    }


    @ParameterizedTest(name = "{index} => {0}")
    @MethodSource("yamlCases")
    void testReverseFromYaml(TestCaseData tc) {
        String actual = reverser.reverse(tc.getInput());
        boolean passed = tc.getExpected().equals(actual);

        String green = "\u001B[32m"; // green
        String red = "\u001B[31m";   // red
        String reset = "\u001B[0m";

        String result = passed ? green + "✅ PASSED" + reset : red + "❌ FAILED" + reset;

        log.info(String.format("║ %-15s │ %-12s │ %-12s │ %-12s │ %-10s ║",
                tc.getName(), tc.getInput(), tc.getExpected(), actual, result));

        assertEquals(tc.getExpected(), actual,
                () -> String.format("Failed test [%s]: expected='%s', actual='%s'",
                        tc.getName(), tc.getExpected(), actual));
    }
}
