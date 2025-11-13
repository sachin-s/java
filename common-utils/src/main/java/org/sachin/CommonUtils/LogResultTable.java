package org.sachin.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/*
LogResultTable class will have the following functions
1. pushLogResult() to store the unit test case results
2. print() to display all the unit test case results in logs
3. clearPrint() to clear the stored unit test case results
 */


public class LogResultTable {

    final private String header = "\n================================================================================================================================================================";
    final private String footer = "================================================================================================================================================================\n";

    final private String separotor = "----------------------------------------------------------------------------------------------------------------------------------------------------------------";
    final private String pass = "✅";
    final private String fail = "❌";

    Deque<TestResult> tr = new ArrayDeque<>();
    ;

    int a;

    public void pushLogResult(String name, String input, String expected, String actual) {
        tr.offer(new TestResult(name, input, expected, actual));
    }

    public void print() {

        System.out.println(header);

        System.out.println(String.format("%-30s | %-30s | %-30s | %-30s | %-30s","Name","Input","Expected","Actual","Result"));
        System.out.println(separotor);
        for (TestResult item : tr) {

            System.out.println(String.format("%-30s | %-30s | %-30s | %-30s | %-30s",item.getName(),item.getInput(),item.getExpected(),item.getActual(),item.getResult()?pass:fail));
        }

        System.out.println(footer);
    }

    public void clearPrint() {
        tr.clear();
    }

}
