package com.sachin.CommonUtils;

import org.sachin.CommonUtils.LogResultTable;

public class LogResultTest {

    public static void main ( String[] args )
    {
        LogResultTable lrt = new LogResultTable();
        lrt.pushLogResult("name1","input1","res","res");
        lrt.pushLogResult("name2","input2","res","res2");
        lrt.print();

    }
}
