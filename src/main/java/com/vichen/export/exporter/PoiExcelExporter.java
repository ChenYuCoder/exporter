package com.vichen.export.exporter;

import com.vichen.export.ExportColumn;
import com.vichen.export.ExportFieldType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author vichen
 */
public class PoiExcelExporter implements Exporter {

  @Override public boolean export(String sheetName, List<ExportColumn> columnList, List<?> rowList,
    File file) {
    Workbook workbook = null;
    String path = file.getPath();
    if (path.endsWith(".xlsx")) {
      workbook = new XSSFWorkbook();
    } else if (path.endsWith(".xls") || path.endsWith(".et")) {
      workbook = new HSSFWorkbook();
    }
    if (workbook == null) {
      throw new RuntimeException("exl文件存在问题，文件路径为：" + path);
    }
    //创建工作表对象
    Sheet sheet = workbook.createSheet(sheetName);

    //创建表头
    Row header = sheet.createRow(0);

    for (int i = 0; i < columnList.size(); i++) {
      Cell cell = header.createCell(i);
      cell.setCellValue(columnList.get(i) == null ? "空表头" : columnList.get(i).getName());
    }

    //填充数据
    for (int j = 1; j < rowList.size() + 1; j++) {
      Object rowValue = rowList.get(j - 1);

      Row row = sheet.createRow(j);

      for (int i = 0; i < columnList.size(); i++) {
        ExportColumn exportColumn = columnList.get(i);
        if (exportColumn == null) {
          continue;
        }

        Cell cell = row.createCell(i);
        if (exportColumn.getType().equals(ExportFieldType.Number)) {
          cell.setCellValue(((Number) convert(exportColumn, rowValue)).doubleValue());
        } else {
          cell.setCellValue((String) convert(exportColumn, rowValue));
        }
      }
    }

    try (FileOutputStream out = new FileOutputStream(file)) {
      workbook.write(out);
    } catch (Exception e) {
      throw new RuntimeException("写入excel发生异常", e);
    }
    return true;

  }



}
