# Excel ExportUtil
> 将Java对象导出到其他数据文件中
## 类描述

### com.vichen.export
* @ExportHeaderAnnotation：导出页注解
> 无该注解类无法导出
  * sheet：导出页名称，不设置则为类名称
* @ExportFieldAnnotation：导出属性注解

> 无该注解属性不参与导出
  * header：导出列名称
  * type：导出目标类型，见ExportFieldType

* ExportFieldType：导出属性目标数据类型
  * String：字符串
  * Number：数字
    > 数据支持：long,int,float,double
  * Date：日期
    > 数据支持：long,Date,LocalDate
    > 输出：2020-02-02
  * DateTime：日期时间
    > 数据支持：long,Date,LocalDateTime
    > 输出：2020-02-02 00:00:00

* ExportColumn：列属性对象
  * name：导出列名称
  * type：导出目标类型，见ExportFieldType
  * valueGetMethod：导出属性对应get方法
  
* ExportUtil：导出工具类
  * construtor：构造函数
    * clazz：导出的类
    * Exporter：执行器
  * export：执行函数
    * list：需要导出的数据
    * path：导出到什么路径
  
### com.vichen.export.exporter
* Exporter：执行器接口
* PoiExcelExport：PoiExcel执行器

### com.test.export
* Student：测试导出类
* ExportTest：测试导出用例


