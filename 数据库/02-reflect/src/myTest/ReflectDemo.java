package myTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射实例
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
//        getClassObj();
//        fieldDemo();
//        constructorDemo();
//        methodDemo();
        annotationDemo();
    }

//获取反射类对象
    public static void getClassObj() throws ClassNotFoundException {
        //1. 根据类的class属性 获取对应的反射类对象
        Class cls = ReflectDemo.class;
        System.out.println(cls);
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        System.out.println("****************************");

        //2. 根据方法  getClass() 获取对应的反射类对象
        cls = new ReflectDemo().getClass();
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        System.out.println("****************************");

        //3. 根据类的全路径查找类的反射类对象
        cls = Class.forName("myTest.ReflectDemo");
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
    }

//反射中的属性操作
    public static void fieldDemo() throws Exception {
        //1. 获取类对应的反射类对象
        Class cls = Student.class;
        //2. 获取属性 非私有
        Field field = cls.getField("name");
        System.out.println(field );
        System.out.println("****************************");
        //获取所有非私有属性
        Field[] fields = cls.getFields();
        for (Field field2: fields){
            System.out.println(field2);
        }
        System.out.println("****************************");
        //获取属性 包含私有
        Field sex = cls.getDeclaredField("sex");
        System.out.println(sex);
        System.out.println("****************************");
        //获取所有属性 包含私有
        fields = cls.getDeclaredFields();
        for (Field field2: fields){
            System.out.println(field2);
        }
        System.out.println("****************************");
        //属性操作
        Student st = new Student();
        sex.setAccessible(true);
        sex.set(st, "男");
        System.out.println(st);
        System.out.println("****************************");
        //获取属性值
        Object object = sex.get(st);
        System.out.println(object);
        System.out.println("****************************");
        //属性类型
        System.out.println(sex.getType().getSimpleName());
        System.out.println("****************************");
        //属性的访问修饰符
        System.out.println(sex.getModifiers());
        System.out.println("****************************");
    }

    //构造方法示例
    public static void constructorDemo() throws Exception {
        //1. 反射类对象
        Class cls = Student.class;
        //根据参数列表获取构造方法
        Constructor constructor = cls.getConstructor();
        Object obj1 = constructor.newInstance();
        System.out.println(obj1);
        //根据参数列表获取 含参构造方法
        // (Integer id, String name, Integer age, String sex)
        constructor = cls.getConstructor(Integer.class, String.class, Integer.class, String.class);
        Object obj2 = constructor.newInstance(1, "韩梅梅", 18, "女");
        System.out.println(obj2);
    }

    public static void methodDemo() throws Exception {
        //1. 获取反射类对象
        Class cls = Student.class;
        //2. 获取方法
        Method sing = cls.getDeclaredMethod("sing");
        System.out.println(sing);
        System.out.println("****************************");

//        method = cls.getMethod("sing");
//        System.out.println(method);

        Method[] methods = cls.getDeclaredMethods();
        for (Method method1: methods){
            System.out.println(method1);
        }
        System.out.println("****************************");

        methods = cls.getMethods();
        for (Method method1: methods){
            System.out.println(method1);
        }
        System.out.println("****************************");

        //方法的调用
        sing.setAccessible(true);
        sing.invoke(new myTest.Student());
    }

    //注解示例
    public static void annotationDemo() throws Exception {
        Class cls = Student.class;

        //获取所有直接注解
        Annotation[] annotations = cls.getDeclaredAnnotations();
        for (Annotation annotation: annotations){
            System.out.println(annotation);
        }

        //判断是否存在某个注解
        boolean flag = cls.isAnnotationPresent(Table.class);
        System.out.println(flag);
        if(flag){
            Table table = (Table)cls.getAnnotation(Table.class);
            System.out.println("注解中的属性值:" + table.name());
        }
    }

}
