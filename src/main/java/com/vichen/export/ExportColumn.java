package com.vichen.export;

import java.lang.reflect.Method;

/**
 * @author vichen
 */
public class ExportColumn {
  private String name;
  private ExportFieldType type;
  private Method valueGetMethod;

  public ExportColumn(String name, ExportFieldType type, Method valueGetMethod) {
    this.name = name;
    this.type = type;
    this.valueGetMethod = valueGetMethod;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ExportFieldType getType() {
    return type;
  }

  public void setType(ExportFieldType type) {
    this.type = type;
  }

  public Method getValueGetMethod() {
    return valueGetMethod;
  }

  public void setValueGetMethod(Method valueGetMethod) {
    this.valueGetMethod = valueGetMethod;
  }

}
