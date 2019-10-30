package com.qfedu.day73_poi.poi;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {


    public static void readXLSX() throws Exception {
        // 读取文件
        FileInputStream inputStream = new FileInputStream("d:/a.xlsx");
        // 创建工作簿对象
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        // 根据索引获取Sheet对象
        XSSFSheet sheet = workbook.getSheetAt(0);
        // 获取Row对象
        XSSFRow row = sheet.getRow(0);
        // 获取Cell对象
        XSSFCell cell = row.getCell(0);
        // 获取单元的文本内容
        String value = cell.getStringCellValue();
        System.out.println(value);

        XSSFCell cell1 = row.getCell(1);
        // 数字格式的单元格
        //System.out.println(cell1.getNumericCellValue());
        // 设置单元格的类型
        cell1.setCellType(CellType.STRING);
        System.out.println(cell1.getStringCellValue());

        workbook.close();
        inputStream.close();
    }

    public static void writeXLSX() throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建sheet对象
        XSSFSheet sheet = workbook.createSheet();
        // 创建Row对象
        XSSFRow row = sheet.createRow(0);
        // 创建单元格
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("zhangsan");
        // 生成excel时，需要输出流的对象
        FileOutputStream outputStream = new FileOutputStream("d:/b.xlsx");
        workbook.write(outputStream);

        workbook.close();
        outputStream.close();
    }

    public static void main(String[] args) {
        try {
//            readXLSX();
            writeXLSX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
