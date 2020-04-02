package com.vichen.export;

import java.lang.annotation.*;

/**
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExportHeaderAnnotation {
    /**
     * 标签页名称
     *
     */
    String sheet() default "default";
}
