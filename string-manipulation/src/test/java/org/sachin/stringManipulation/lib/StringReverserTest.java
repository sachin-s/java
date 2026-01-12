package org.sachin.stringManipulation.lib;

import org.testng.Assert;
import org.testng.annotations.*;
import org.sachin.CommonUtils.LogResultTable;

public class StringReverserTest {

    StringReverser sr = new StringReverser();
    LogResultTable lrt = new LogResultTable();
    long duration;


    @Test(
            dataProvider = "reverserData",
            dataProviderClass = org.sachin.stringManipulation.utils.YamlDataProvider.class, groups = {"dataGroup"}
    )
    public void testStringReverser(String name, String input, String expected) {

        lrt.pushLogResult(name, input, expected, () -> sr.StringBufferReverse(input));
        Assert.assertEquals(sr.StringBufferReverse(input), expected, "reverse string should be " + expected);
    }

    @Test(
            dataProvider = "reverserData",
            dataProviderClass = org.sachin.stringManipulation.utils.YamlDataProvider.class, groups = {"dataGroup1"}
    )
    public void testStreamStringReverser(String name, String input, String expected) {

        lrt.pushLogResult(name, input, expected, () -> sr.StreamStringReverse(input));
        Assert.assertEquals(sr.StreamStringReverse(input), expected, "reverse string should be " + expected);
    }

    @Test(
            dataProvider = "reverserData",
            dataProviderClass = org.sachin.stringManipulation.utils.YamlDataProvider.class, groups = {"dataGroup2"}
    )
    public void testLoopStringReverser(String name, String input, String expected) {

        lrt.pushLogResult(name, input, expected, () -> sr.LoopStringReverse(input));
        Assert.assertEquals(sr.LoopStringReverse(input), expected, "reverse string should be " + expected);
    }

    @Test(
            dataProvider = "reverserData",
            dataProviderClass = org.sachin.stringManipulation.utils.YamlDataProvider.class, groups = {"dataGroup3"}
    )
    public void testRecursionStringReverser(String name, String input, String expected) {

        lrt.pushLogResult(name, input, expected, () -> sr.RecurssionStringReverse(input));
        Assert.assertEquals(sr.RecurssionStringReverse(input), expected, "reverse string should be " + expected);
    }



    @AfterGroups(groups = {"dataGroup"})
    public void afterTestGroup() {
        lrt.print();
        lrt.writeToExcel("test-output\\test-results.xlsx", "StringBufferReverse");
        lrt.clearPrint();
    }

    @AfterGroups(groups = {"dataGroup1"})
    public void afterTestGroup1() {
        lrt.print();
        lrt.writeToExcel("test-output\\test-results.xlsx", "StringStreamReverse");
        lrt.clearPrint();
    }

    @AfterGroups(groups = {"dataGroup2"})
    public void afterTestGroup2() {
        lrt.print();
        lrt.writeToExcel("test-output\\test-results.xlsx", "StringLoopReverse");
        lrt.clearPrint();
    }

    @AfterGroups(groups = {"dataGroup3"})
    public void afterTestGroup3() {
        lrt.print();
        lrt.writeToExcel("test-output\\test-results.xlsx", "StringRecursionReverse");
        lrt.clearPrint();
    }


}
