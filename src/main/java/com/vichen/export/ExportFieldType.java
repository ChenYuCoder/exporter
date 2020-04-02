package com.vichen.export;

/**
 * @author vichen
 */


public enum ExportFieldType {
  /**
   * 字符串
   */
  String,
  /**
   * 数字
   * 数据支持：long,int,float,double
   */
  Number,
  /**
   * 日期
   * 数据支持：long,Date,LocalDate
   * 输出：2020-02-02
   */
  Date,
  /**
   * 日期
   * 数据支持：long,Date,LocalDateTime
   * 输出：2020-02-02 00:00:00
   */
  DateTime;
}
