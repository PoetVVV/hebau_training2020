package 课上;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: ReflectDemo 
 * @Description: 反射示例
 * @author: Mr.T
 * @date: 2020年6月23日 上午10:21:20
 */
public class ReflectDemo {
	
	
	public static void main(String[] args) throws Exception {
		//getClassObj();
		//fieldDemo();
		//constructorDemo();
		//methodDemo();
		annotationDemo();
	}
	
	
	/**
	 * @Title: getClassObj
	 * @author: Mr.T   
	 * @date: 2020年6月23日 上午10:21:53 
	 * @Description: 获取反射类对象
	 * @return: void
	 * @throws ClassNotFoundException 
	 */
	public static void getClassObj() throws ClassNotFoundException {
		//1. 根据 类的class属性 获取对应的反射类对象
		Class cls = ReflectDemo.class;
		System.out.println(cls);
		System.out.println(cls.getName());//类的全路径  包名.类名
		System.out.println(cls.getSimpleName()); //类简称  类名
		//2. 根据方法  getClass() 获取对应的反射类对象
		cls = new ReflectDemo().getClass();
		System.out.println(cls.getName());//类的全路径  包名.类名
		System.out.println(cls.getSimpleName()); //类简称  类名
		//3. 根据类的全路径查找类的反射类对象
		cls = Class.forName("com.bjsxt.demo.ReflectDemo");
		System.out.println(cls.getName());//类的全路径  包名.类名
		System.out.println(cls.getSimpleName()); //类简称  类名
	}
	/**
	 * @Title: fieldDemo
	 * @author: Mr.T   
	 * @date: 2020年6月23日 上午10:39:57 
	 * @Description: 反射中的属性操作
	 * @return: void
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static void fieldDemo() throws Exception {
		//1.获取类对应的反射类对象
		Class cls = Student.class;
		//2.获取属性 非私有属性
		Field field = cls.getField("name");
		System.out.println(field);
		// 获取所有非私有属性
		Field[] fields = cls.getFields();
		for (Field field2 : fields) {
			System.out.println(field2);
		}
		//获取属性 包含私有的
		Field sex = cls.getDeclaredField("sex");
		System.out.println(sex);
		System.out.println("======================");
		//获取所有的属性 包含私有的
		fields = cls.getDeclaredFields();
		for (Field field2 : fields) {
			System.out.println(field2);
		}
		//属性操作
		Student st = new Student();
		//此时 sex属性是私有属性 但是私有属性 无法在其它类中直接操作
		//setAccessible 设置访问标记 访问修饰符  设置为true 则是 忽略这个访问标记
		sex.setAccessible(true);
		sex.set(st, "男");
		System.out.println(st);
		//获取属性值  获取 st对象的 sex属性值
		Object object = sex.get(st);
		System.out.println(object);
		//属性类型
		System.out.println(sex.getType().getSimpleName());
		//属性的访问修饰符
		System.out.println(sex.getModifiers());
	}

	/**
	 * @Title: constructorDemo
	 * @author: Mr.T   
	 * @date: 2020年6月23日 上午11:20:15 
	 * @Description: 构造方法示例
	 * @return: void
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void constructorDemo() throws Exception {
		//1.反射类对象
		Class cls = Student.class;
		//根据参数列表获取构造
		Constructor constructor = cls.getConstructor();//获取无参构造方法
		Object obj1 = constructor.newInstance();
		System.out.println(obj1);
		//根据参数列表类型 获取对应的构造方法
		//(Integer id, String name, Integer age, String sex)
		constructor = cls.getConstructor(Integer.class,String.class,Integer.class,String.class);
		Object obj2 = constructor.newInstance(1,"韩梅梅",18,"女");
		System.out.println(obj2);
	}
	
	/**
	 * @Title: methodDemo
	 * @author: Mr.T   
	 * @date: 2020年6月23日 上午11:31:28 
	 * @Description: 反射方法相关操作
	 * @throws Exception
	 * @return: void
	 */
	public static void methodDemo() throws Exception {
		//1.获取反射类对象
		Class cls = Student.class;
		//2.获取方法
		Method sing = cls.getDeclaredMethod("sing");//根据方法名和参数 获取方法 包含私有的
		System.out.println(sing);
		//method = cls.getMethod("sing");//不包含私有的
		//System.out.println(method);
		System.out.println("----------------------");
		Method[] methods = cls.getDeclaredMethods();
		for (Method method2 : methods) {
			System.out.println(method2);
		}
		System.out.println("----------------------");
		methods = cls.getMethods();
		for (Method method2 : methods) {
			System.out.println(method2);
		}
		//方法的调用 是需要对象
		//设置忽略访问修饰符
		sing.setAccessible(true);
		sing.invoke(new Student());
	}
	
	/**
	 * @Title: annotationDemo
	 * @author: Mr.T   
	 * @date: 2020年6月23日 下午12:05:52 
	 * @Description: 注解示例
	 * @throws Exception
	 * @return: void
	 */
	public static void annotationDemo() throws Exception {
		//1.获取反射类
		Class cls = Student.class;
		//获取所有直接注解
		Annotation[] annotations = cls.getDeclaredAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
		//判断是否存在某个注解
		boolean flag = cls.isAnnotationPresent(Table.class);
		System.out.println(flag);
		if(flag) {
			//获取指定注解
			Table table = (Table) cls.getAnnotation(Table.class);
			System.out.println("注解中的属性值:"+table.name());
		}
		
	}
	
}
