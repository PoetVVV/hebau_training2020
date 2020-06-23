package 课上;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: Table 
 * @Description: 表名注解
 * @author: Mr.T
 * @date: 2020年6月23日 下午12:01:03
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	
	
	String name();//表名称

}
