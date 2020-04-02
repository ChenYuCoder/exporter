package com.vichen.export.exporter;

import com.vichen.export.ExportColumn;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author vichen
 */
public interface Exporter {

  DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  /**
   * 导出到文件(excel...)
   *
   * @param sheetName        标签页名称
   * @param exportColumnList 列属性
   * @param data             数据
   * @param file             文件
   * @return 成功
   */
  boolean export(String sheetName, List<ExportColumn> exportColumnList, List<?> data, File file);

  /**
   * 默认：转换数据类型为excel目标类型
   *
   * @param exportColumn 列属性
   * @param rowValue     行对象
   * @return 目标对象类型
   */

  default Object convert(ExportColumn exportColumn, Object rowValue) {
    Object value;
    try {
      value = exportColumn.getValueGetMethod().invoke(rowValue);
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException("导出时发生异常", e);
    }
    switch (exportColumn.getType()) {
      case String:
        return value;

      case Number:
        if (value == null) {
          return 0;
        }
        if (value instanceof Number) {
          return value;
        } else if (value instanceof String) {
          return Double.parseDouble((String) value);
        }

      case Date:
        if (value instanceof String) {
          return value;
        } else {

          if (value instanceof Long) {
            return dateToString(new Date((long) value), DATE_FORMATTER);
          } else if (value instanceof Date) {
            dateToString((Date) value, DATE_FORMATTER);
          } else if (value instanceof LocalDate) {
            return ((LocalDate) value).format(DATE_FORMATTER);
          } else if (value instanceof LocalDateTime) {
            return ((LocalDateTime) value).format(DATE_FORMATTER);
          }
        }

      case DateTime:
        if (value instanceof String) {
          return value;
        } else {

          if (value instanceof Long) {
            return dateToString(new Date((long) value), DATE_TIME_FORMATTER);
          } else if (value instanceof Date) {
            return dateToString((Date) value, DATE_TIME_FORMATTER);
          } else if (value instanceof LocalDateTime) {
            return ((LocalDateTime) value).format(DATE_TIME_FORMATTER);
          }
        }
      default:
        return value == null ? "" : value.toString();
    }

  }

  /**
   * 默认：日期对象格式化
   *
   * @param date      日期对象
   * @param formatter 输出格式
   * @return 格式化后时间
   */

  default String dateToString(Date date, DateTimeFormatter formatter) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.of(ZoneId.SHORT_IDS.get("CTT")))
      .format(formatter);
  }



}
