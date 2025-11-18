package org.sachin.stringManipulation.lib;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.sachin.CommonUtils.LogResultTable;

public class StringReverserTest {

    StringReverser sr = new StringReverser();
    LogResultTable lrt = new LogResultTable();
    @Test
    public void testStringReverser()
    {
        lrt.pushLogResult("String reverser","hello","olleh","olleh");
        Assert.assertEquals( sr.reverse("hello"),"olleh","reverse string should be olleh");
    }

    @AfterClass
    public void afterAllMethods() {
        lrt.print();
        lrt.clearPrint();
    }


}
