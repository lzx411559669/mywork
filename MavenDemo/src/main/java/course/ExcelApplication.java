package course;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;

public class ExcelApplication {

    public static void main(String[] args) {

            write();
    }
    public static void write(){
        Workbook wb = new HSSFWorkbook();
       // Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);

        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*public   static void write(){
        OutputStream fileOut=null;
        try  {
            //File file=new File("workbook.xlsx");
            fileOut = new FileOutputStream("workbook.xlsx");
            Workbook wb = null;
            wb = new XSSFWorkbook();

            Sheet sheet = wb.createSheet("new sheet");
            Sheet sheet2 = wb.createSheet("second sheet");
            Sheet sheet3 = wb.createSheet(" sheet");
            CreationHelper createHelper = wb.getCreationHelper();
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
    }*/

}