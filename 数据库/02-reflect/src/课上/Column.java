package 课上;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: Column 
 * @Description: 列名注解
 * @author: Mr.T
 * @date: 2020年6月23日 下午12:02:29
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	
	String name();//列的名称
	
	String type() default "varchar";//列的类型
	
	int length() default 30;//列的数据长度

}
