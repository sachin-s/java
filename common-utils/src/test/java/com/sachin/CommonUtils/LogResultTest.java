package com.sachin.CommonUtils;

import org.sachin.CommonUtils.LogResultTable;

public class LogResultTest {
    void printTest(){
        LogResultTable lrt = new LogResultTable();
        lrt.print();
    }

    public static void main ( String[] args )
    {
        LogResultTable lrt = new LogResultTable();
        lrt.pushLogResult("name1","input1","res","res");
        lrt.pushLogResult("name2","input2","res","res2");
        lrt.pushLogResult("name3","input3","res3","res3");
        lrt.print();

    }
}
