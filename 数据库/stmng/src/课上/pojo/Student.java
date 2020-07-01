package 课上.pojo;

/**
 * @ClassName: Student 
 * @Description: 学生信息
 * @author: Mr.T
 * @date: 2020年6月24日 上午11:30:14
 */
public class Student {
	
	//学生ID
	private Integer id;
	//学生名称
	private String name;
	//学生年龄
	private Integer age;
	//学生性别
	private String sex;
	//学生班级ID
	private Integer classesId;
	//班级名称
	private String classesName;
	
	
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
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
	
	
	

}
