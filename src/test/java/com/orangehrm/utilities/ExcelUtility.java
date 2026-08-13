package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtility(String filePath, String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(filePath);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public int getRowCount() {

        return sheet.getLastRowNum();

    }

    public int getColumnCount() {

        return sheet.getRow(0).getLastCellNum();

    }

    public String getCellData(int row, int column) {

        return sheet.getRow(row).getCell(column).toString();

    }
    
    public Object[][] getExcelData() {

        int rows = getRowCount();
        int cols = getColumnCount();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = getCellData(i, j);

            }
        }

        return data;

    }

}