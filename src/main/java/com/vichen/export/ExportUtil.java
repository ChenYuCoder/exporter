package com.vichen.export;

import com.vichen.export.exporter.Exporter;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vichen
 */
public class ExportUtil<T> {
  private Exporter exporter;

  private List<ExportColumn> columnList = new ArrayList<>();
  private String sheetName;

  private ExportUtil() {
  }

  public ExportUtil(Class<?> clazz, Exporter exporter) {
    init(clazz, exporter);
  }

  public void init(Class<?> clazz, Exporter exporter) {
    this.exporter = exporter;
    //检查数据是否为可导出类

    if (!clazz.isAnnotationPresent(ExportHeaderAnnotation.class)) {
      throw new RuntimeException("this class must have HeaderAnnotation");
    }
    String defaultName = "default";

    //获取sheet
    ExportHeaderAnnotation headerAnnotation =
      (ExportHeaderAnnotation) clazz.getAnnotation(ExportHeaderAnnotation.class);
    sheetName = headerAnnotation.sheet().equals(defaultName) ?
      clazz.getSimpleName() :
      headerAnnotation.sheet();

    //获取headers和valueGetMethods
    Field[] fields = clazz.getDeclaredFields();
    for (Field value : fields) {
      ExportFieldAnnotation exportFieldAnnotation =
        value.getAnnotation(ExportFieldAnnotation.class);
      if (exportFieldAnnotation == null) {
        continue;
      }
      String header = exportFieldAnnotation.header();
      String fieldName = value.getName();
      String getMethodName =
        "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
      try {
        Method fieldGetMethod = clazz.getMethod(getMethodName);


        columnList.add(new ExportColumn(header.equals(defaultName) ? fieldName : header,
          exportFieldAnnotation.type(), fieldGetMethod));
      } catch (NoSuchMethodException e) {
        throw new RuntimeException(fieldName + "缺少get方法:" + getMethodName, e);
      }
    }

    if (columnList.size() == 0) {
      throw new RuntimeException("无需要导出的属性");
    }
  }

  public <S extends T> boolean export(List<S> list, Path path) {

    //检查数据是否为空
    if (list == null || list.isEmpty()) {
      throw new RuntimeException("空数据不需要导出");
    }

    //检查文件是否存在
    File file = path.toFile();
    File parentFile = file.getParentFile();
    if (!parentFile.exists()) {
      if (parentFile.mkdirs()) {
        throw new RuntimeException("无法创建文件夹");
      }
    }

    exporter.export(sheetName, columnList, list, file);

    return true;
  }

  public <S extends T> boolean export(List<ExportColumn> exportColumnList, String sheetName,
    List<S> list, Path path) {

    //检查数据是否为空
    if (list == null || list.isEmpty()) {
      throw new RuntimeException("空数据不需要导出");
    }

    //检查文件是否存在
    File file = path.toFile();
    File parentFile = file.getParentFile();
    if (!parentFile.exists()) {
      if (parentFile.mkdirs()) {
        throw new RuntimeException("无法创建文件夹");
      }
    }

    exporter.export(sheetName, exportColumnList, list, file);

    return true;
  }

}
