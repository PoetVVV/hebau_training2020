package myTest;

@Table(name = "student")
public class Student {

    @Column(name = "id", length = 11, type = "int")
    private Integer id;

    @Column(name = "name", length = 30, type = "varchar")
    public String name;

    private Integer age;

    private String sex;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @MyAnnotation(value = 1,name = "lzw")
    public Student() {};
    public Student(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void study(){
        System.out.println("公有-学习");
    }

    private void sing(){
        System.out.println("私有-唱歌");
    }

}
