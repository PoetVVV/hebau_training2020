package myTest;

//自定义1个 注解
//注解名称就叫 MyAnnotation

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    int value();

    String name();

    String sex() default "男";
}
