package org.sachin.CommonUtils;

public class TestResult {

    private final String name;
    private final String input;
    private final String expected;
    private final String actual;
    private final Boolean result;

    public TestResult(String name, String input, String expected, String actual) {
        this.name = name;
        this.input = input;
        this.actual = actual;
        this.expected = expected;
        this.result = (actual.equals(expected));
    }
    public String getInput() {
        return input;
    }

    public String getExpected() {
        return expected;
    }

    public String getActual() {
        return actual;
    }

    public Boolean getResult() {
        return result;
    }


    public String getName() {
        return name;
    }
}
