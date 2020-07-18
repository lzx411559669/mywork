package com.youkeda.bmach;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelApplication {

    public static void main(String[] args) {
      new ExcelApplication().write();

    }
    public  void write(){
        OutputStream fileOut=null;
        try  {

            fileOut = new FileOutputStream("workbook.xlsx");
            Workbook wb = new XSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("new sheet");
            Sheet sheet2 = wb.createSheet("second sheet");
            Row row = sheet.createRow(0);
            // Create a cell and put a value in it.
            Cell cell = row.createCell(0);
            cell.setCellValue(1);

            // Or do it on one line.
            row.createCell(1).setCellValue(1.2);
            row.createCell(2).setCellValue(
                    createHelper.createRichTextString("This is a string"));
            row.createCell(3).setCellValue(true);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOut!=null){
                try {
                  fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
