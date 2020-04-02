package com.test.export;

import com.vichen.export.ExportUtil;
import com.vichen.export.exporter.PoiExcelExporter;
import org.junit.Test;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportTest {
  @org.junit.Test public void test() {
    ExportUtil<Student> utils = new ExportUtil<>(Student.class, new PoiExcelExporter());

    List<Student> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Student s = new Student();
      s.setName("test" + i);
      s.setAge(10);
      s.setAge1(10);
      s.setAge2(10);
      s.setAge3(10L);
      s.setAge4(10.1f);
      s.setAge5(10.1f);
      s.setAge6(10.23d);
      s.setAge7(10.12d);
      s.setDate(System.currentTimeMillis());
      s.setDate2(System.currentTimeMillis());
      s.setDate3(new Date());
      s.setDate4(LocalDate.now());
      s.setDateTime(System.currentTimeMillis());
      s.setDateTime2(System.currentTimeMillis());
      s.setDateTime3(new Date());
      s.setDateTime4(LocalDateTime.now());
      list.add(s);
    }

    System.out.print(utils.export(list, Paths.get("/Users/vichen/Desktop/temp/1.xls")));

  }

  @Test public void testNull() {
    ExportUtil<Student> utils = new ExportUtil<>(Student.class, new PoiExcelExporter());

    List<Student> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Student s = new Student();
      s.setName(null);
      s.setAge(10);
      s.setAge1(null);
      s.setAge2(10);
      s.setAge3(null);
      s.setAge4(10.1f);
      s.setAge5(null);
      s.setAge6(null);
      s.setAge7(10.12d);
      s.setDate(System.currentTimeMillis());
      s.setDate2(null);
      s.setDate3(null);
      s.setDate4(null);
      s.setDateTime(System.currentTimeMillis());
      s.setDateTime2(null);
      s.setDateTime3(null);
      s.setDateTime4(null);
      list.add(s);
    }

    System.out.print(utils.export(list, Paths.get("/Users/vichen/Desktop/temp/2.xls")));

  }
}
