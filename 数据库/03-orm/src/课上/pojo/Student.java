package 课上.pojo;

public class Student {
	
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String sex;
	
	private Integer classesId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getClassesId() {
		return classesId;
	}

	public void setClassesId(Integer classesId) {
		this.classesId = classesId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", classesId=" + classesId
				+ "]";
	}

	

}
