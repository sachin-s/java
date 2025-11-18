package org.sachin.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
LogResultTable class will have the following functions
1. pushLogResult() to store the unit test case results
2. print() to display all the unit test case results in logs
3. clearPrint() to clear the stored unit test case results
 */


public class LogResultTable {

    private static final Logger log = LoggerFactory.getLogger(LogResultTable.class);

    final private String header = "====================================================================================================";
    final private String footer = "====================================================================================================\n";

    final private String separotor = "----------------------------------------------------------------------------------------------------";
    final private String pass = "✅";
    final private String fail = "❌";

    Deque<TestResult> tr = new ArrayDeque<>();
    ;

    int a;

    public void pushLogResult(String name, String input, String expected, String actual) {
        tr.offer(new TestResult(name, input, expected, actual));
    }

    public void print() {

        log.info("\n");
        log.info(header);
        log.info(String.format("%-20s | %-20s | %-20s | %-20s | %-20s","Name","Input","Expected","Actual","Result"));
        log.info(separotor);
        for (TestResult item : tr) {

            log.info(String.format("%-20s | %-20s | %-20s | %-20s | %-20s",item.getName(),item.getInput(),item.getExpected(),item.getActual(),item.getResult()?pass:fail));
        }

        log.info(footer);
    }

    public void clearPrint() {
        tr.clear();
    }

}
