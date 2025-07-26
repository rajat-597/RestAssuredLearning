package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }

    public static class DataDrivenTestingUsingExcel {

        public static void main(String[] args) throws IOException {

            FileInputStream fis = new FileInputStream("TestData.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);

            // get sheet
            Sheet sheet = workbook.getSheet("sheet1");

            // get rowNum and column num
           int rowNum =  sheet.getPhysicalNumberOfRows();
           int columnNum =   sheet.getRow(0).getPhysicalNumberOfCells();

           // iterate through rows and columns

            for(int i =1; i<=rowNum; i++){
               Row row = sheet.getRow(i);
                String username =  row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();

                System.out.println("Username: " + username + " | Password: " + password);
            }

            workbook.close();
            fis.close();

        }
    }
}