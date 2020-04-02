package com.test.export;

import com.vichen.export.ExportFieldAnnotation;
import com.vichen.export.ExportFieldType;
import com.vichen.export.ExportHeaderAnnotation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@ExportHeaderAnnotation public class Student {
  @ExportFieldAnnotation private String name;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private int age;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private Integer age1;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private long age2;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private Long age3;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private float age4;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private Float age5;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private Double age6;
  @ExportFieldAnnotation(type = ExportFieldType.Number) private double age7;

  @ExportFieldAnnotation(type = ExportFieldType.Date) private long date;
  @ExportFieldAnnotation(type = ExportFieldType.Date) private Long date2;
  @ExportFieldAnnotation(type = ExportFieldType.Date) private Date date3;
  @ExportFieldAnnotation(type = ExportFieldType.Date) private LocalDate date4;


  @ExportFieldAnnotation(type = ExportFieldType.DateTime) private long dateTime;
  @ExportFieldAnnotation(type = ExportFieldType.DateTime) private Long dateTime2;
  @ExportFieldAnnotation(type = ExportFieldType.DateTime) private Date dateTime3;
  @ExportFieldAnnotation(type = ExportFieldType.DateTime) private LocalDateTime dateTime4;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Integer getAge1() {
    return age1;
  }

  public void setAge1(Integer age1) {
    this.age1 = age1;
  }

  public long getAge2() {
    return age2;
  }

  public void setAge2(long age2) {
    this.age2 = age2;
  }

  public Long getAge3() {
    return age3;
  }

  public void setAge3(Long age3) {
    this.age3 = age3;
  }

  public float getAge4() {
    return age4;
  }

  public void setAge4(float age4) {
    this.age4 = age4;
  }

  public Float getAge5() {
    return age5;
  }

  public void setAge5(Float age5) {
    this.age5 = age5;
  }

  public Double getAge6() {
    return age6;
  }

  public void setAge6(Double age6) {
    this.age6 = age6;
  }

  public double getAge7() {
    return age7;
  }

  public void setAge7(double age7) {
    this.age7 = age7;
  }

  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }

  public Long getDate2() {
    return date2;
  }

  public void setDate2(Long date2) {
    this.date2 = date2;
  }

  public Date getDate3() {
    return date3;
  }

  public void setDate3(Date date3) {
    this.date3 = date3;
  }

  public LocalDate getDate4() {
    return date4;
  }

  public void setDate4(LocalDate date4) {
    this.date4 = date4;
  }

  public long getDateTime() {
    return dateTime;
  }

  public void setDateTime(long dateTime) {
    this.dateTime = dateTime;
  }

  public Long getDateTime2() {
    return dateTime2;
  }

  public void setDateTime2(Long dateTime2) {
    this.dateTime2 = dateTime2;
  }

  public Date getDateTime3() {
    return dateTime3;
  }

  public void setDateTime3(Date dateTime3) {
    this.dateTime3 = dateTime3;
  }

  public LocalDateTime getDateTime4() {
    return dateTime4;
  }

  public void setDateTime4(LocalDateTime dateTime4) {
    this.dateTime4 = dateTime4;
  }
}
