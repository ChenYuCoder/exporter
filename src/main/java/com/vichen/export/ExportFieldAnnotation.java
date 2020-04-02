package com.vichen.export;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExportFieldAnnotation {
    String header() default "default";

    ExportFieldType type() default ExportFieldType.String;
}
