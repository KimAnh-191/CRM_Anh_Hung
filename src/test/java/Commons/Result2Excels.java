package Commons;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class Result2Excels {
    private static String[] columns = {"TC_ID", "TC_Summary", "TC_Result", "Note"};


    public static void saveResult2ExcelFilePassed(String File_Name, String Sheet_Name, String TC_ID, String TC_Summary) throws IOException {
        //Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        Workbook workbook;
        Sheet  sheet;
        int rowNum=1;
        FileInputStream fileInputStream;
        String PathTillProject = System.getProperty("user.dir");
        String path_of_File= PathTillProject + "/src/test/Data/" + File_Name + ".xlsx";
        File file = new File(path_of_File);
        if (file.exists())
        {
            fileInputStream = new FileInputStream(path_of_File);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(Sheet_Name);
            // get last row number
            rowNum = sheet.getPhysicalNumberOfRows();

        }else {
            file.createNewFile();
            fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(Sheet_Name);

            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.BLACK.getIndex());

            // Create a CellStyle with the font
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);

            // Create cells
            for(int i = 0; i <4 ; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }
        }
            CellStyle normalStyle = createStyleNormal(workbook);
            CellStyle style = createStyleTestCasePassed(workbook);
            Row row = sheet.createRow(rowNum++);
            Cell cell;

//            row.createCell(0).setCellValue(TC_ID);
//            row.createCell(1).setCellValue(TC_Summary);
//            row.createCell(2).setCellValue();

            cell = row.createCell(0);
            cell.setCellValue(TC_ID);
            cell.setCellStyle(normalStyle);

            cell = row.createCell(1);
            cell.setCellValue(TC_Summary);
            cell.setCellStyle(normalStyle);

            cell = row.createCell(2);
            cell.setCellValue("Passed");
            cell.setCellStyle(style);



        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        fileInputStream.close();
        FileOutputStream fileOut = new FileOutputStream(path_of_File);
        workbook.write(fileOut);

        fileOut.close();
        // Closing the workbook
        workbook.close();

    }



    public static void saveResult2ExcelFileFailed(String File_Name, String Sheet_Name, String TC_ID, String TC_Summary) throws IOException {
        //Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        Workbook workbook;
        Sheet  sheet;
        int rowNum=1;
        FileInputStream fileInputStream;
        String PathTillProject = System.getProperty("user.dir");
        String path_of_File= PathTillProject + "/src/test/Data/" + File_Name + ".xlsx";
        File file = new File(path_of_File);
        if (file.exists())
        {
            fileInputStream = new FileInputStream(path_of_File);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(Sheet_Name);
            // get last row number
            rowNum = sheet.getPhysicalNumberOfRows();

        }else {
            file.createNewFile();
            fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(Sheet_Name);

            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.BLACK.getIndex());

            // Create a CellStyle with the font
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);

            // Create cells
            for(int i = 0; i <4 ; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }
        }

        CellStyle normalStyle = createStyleNormal(workbook);
        CellStyle style = createStyleTestCaseFailed(workbook);
        Row row = sheet.createRow(rowNum++);
        Cell cell;
//        row.createCell(0).setCellValue(TC_ID);
//        row.createCell(1).setCellValue(TC_Summary);

        cell = row.createCell(0);
        cell.setCellValue(TC_ID);
        cell.setCellStyle(normalStyle);

        cell = row.createCell(1);
        cell.setCellValue(TC_Summary);
        cell.setCellStyle(normalStyle);

        cell = row.createCell(2);
        cell.setCellValue("Failed");
        cell.setCellStyle(style);



        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        fileInputStream.close();
        FileOutputStream fileOut = new FileOutputStream(path_of_File);
        workbook.write(fileOut);

        fileOut.close();
        // Closing the workbook
        workbook.close();

    }

    public static CellStyle createStyleNormal(Workbook workbook)
    {


        CellStyle style = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);

        return style;

    }

    public static CellStyle createStyleTestCasePassed(Workbook workbook)
    {


        CellStyle style = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);

        return style;

    }

    public static CellStyle createStyleTestCaseFailed(Workbook workbook)
    {


        CellStyle style = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);

        return style;

    }


}
