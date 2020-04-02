package com.vichen.export.exporter;

import com.vichen.export.ExportColumn;

import java.io.File;
import java.util.List;

/**
 * @author vichen
 */
public interface Exporter {
  /**
   * 导出到文件(excel...)
   *
   * @param sheetName            标签页名称
   * @param exportColumnList 列属性
   * @param data             数据
   * @param file             文件
   * @return 成功
   */
  boolean export(String sheetName, List<ExportColumn> exportColumnList, List data, File file);

}
