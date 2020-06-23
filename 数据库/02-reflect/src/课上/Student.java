package 课上;

@Table(name = "student")
public class Student {
	
	@Column(name = "id",length = 11,type = "int")
	private Integer id;
	
	@Column(name = "name",length = 30,type = "varchar")
	public String name;
	
	private Integer age;
	
	private String sex;
	
	public Student() {}
	
	public Student(Integer id, String name, Integer age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	
	public void study() {
		System.out.println("学习使我漂亮");
	}
	
	private void sing() {
		System.out.println("我是的一只来自东北哈士奇");
	}

}
