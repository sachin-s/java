package org.sachin.CommonUtils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Supplier;

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

    public void pushLogResult(String name, String input, String expected, Supplier<String> func) {
        long start = System.currentTimeMillis();
        String actual = func.get();   // Execute function
        long duration = (System.currentTimeMillis() - start);  // convert to ms

        tr.offer(new TestResult(name, input, expected, actual, duration));
    }

    public void print() {

        log.info("\n");
        log.info(header);
        log.info(String.format("%-15s | %-15s | %-15s | %-15s | %-10s | %-10s","Name","Input","Expected","Actual","duration","Result"));
        log.info(separotor);
        for (TestResult item : tr) {

            log.info(String.format("%-15s | %-15s | %-15s | %-15s | %-10s | %-10s",item.getName(),item.getInput(),item.getExpected(),item.getActual(),item.getDuration()+" ms",item.getResult()?pass:fail));
        }

        log.info(footer);
    }

    public void print(String excelName){
        print();

    }

    public void clearPrint() {
        tr.clear();
    }

    public void writeToExcel(String filePath, String sheetName) {
        Workbook workbook;
        File file = new File(filePath);

        try {
            // 1️⃣ Open existing workbook OR create new
            if (file.exists()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = WorkbookFactory.create(fis);
                }
            } else {
                workbook = new XSSFWorkbook();
            }

            // 2️⃣ If sheet exists → remove it
            int sheetIndex = workbook.getSheetIndex(sheetName);
            if (sheetIndex != -1) {
                workbook.removeSheetAt(sheetIndex);
            }

            // 3️⃣ Create fresh sheet
            Sheet sheet = workbook.createSheet(sheetName);

            // 4️⃣ Header
            Row header = sheet.createRow(0);
            String[] columns = {"Name", "Input", "Expected", "Actual", "Result", "Duration(ms)"};

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // 5️⃣ Fill rows
            int rowNum = 1;
            for (TestResult trItem : tr) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(trItem.getName());
                row.createCell(1).setCellValue(trItem.getInput());
                row.createCell(2).setCellValue(trItem.getExpected());
                row.createCell(3).setCellValue(trItem.getActual());
                row.createCell(4).setCellValue(trItem.getResult() ? "PASS" : "FAIL");
                row.createCell(5).setCellValue(trItem.getDuration());
            }

            // 6️⃣ Auto-size
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // 7️⃣ Write back
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

            workbook.close();
            System.out.println("Sheet overwritten successfully: " + sheetName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
