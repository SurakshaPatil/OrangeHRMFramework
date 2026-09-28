package com.orangehrm.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtility(String filePath, String sheetName) throws IOException {

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(
                        filePath.startsWith("/")
                                ? filePath.substring(1)
                                : filePath
                );

        if (inputStream == null) {
            throw new FileNotFoundException(
                    "Excel file not found in classpath: " + filePath
            );
        }

        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new IllegalArgumentException(
                    "Excel sheet not found: " + sheetName
            );
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