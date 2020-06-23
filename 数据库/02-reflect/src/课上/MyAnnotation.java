package 课上;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: MyAnnotation 
 * @Description: 自定义了一个注解 ： 注解名称就叫 MyAnnotation。
 * 	目标：@Target 元注解之一  是指注解支持的目标
 * 	生效范围： @Retention   源码期  编译文件生效  运行期生效 
 * 	注解只能包含属性  且定义方式与有返回值的参数类似  
 * 	使用注解时，如果该注解的属性没有赋值，则在使用时必须指定值。
 * 
 * @author: Mr.T
 * @date: 2020年6月23日 上午11:45:36
 */
@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(value = RetentionPolicy.RUNTIME)//运行期 也能生效
public @interface MyAnnotation {
	
	
	int value();//定义了一个  int类型的  名字叫 value的属性
	
	String name();//定义了一个String类型的 名字叫 name的属性
	
	String sex() default "男" ;//为注解中的属性指定默认值

}
