package org.sachin.stringManipulation.lib;

public class TestCaseData {
    private String name;
    private String input;
    private String expected;
    private String actual;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getInput() { return input; }
    public void setInput(String input) { this.input = input; }

    public String getExpected() { return expected; }
    public void setExpected(String expected) { this.expected = expected; }

    public String getActual() { return actual; }
    public void setActual(String actual) { this.actual = actual; }

    @Override
    public String toString() {
        return "input='" + input + "', expected='" + expected + "'";
    }
}
