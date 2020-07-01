package 课上.view;

import java.util.List;
import java.util.Scanner;

import 课上.pojo.Student;

/**
 * @ClassName: StudentView 
 * @Description: 展示数据或者接收控制台输入的数据
 * @author: Mr.T
 * @date: 2020年6月24日 上午11:52:28
 */
public class StudentView {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * @Title: listView
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午11:53:21 
	 * @Description: 展示学生数据的视图
	 * @param students
	 * @return: void
	 */
	public static void listView(List<Student> students) {
		System.out.println("ID\t\t名称\t\t年龄\t\t性别\t\t班级");
		for (Student student : students) {
			System.out.println(student.getId()+"\t\t"+student.getName()+"\t\t"+student.getAge()+"\t\t"+student.getSex()+"\t\t"+student.getClassesName());
		}
	}
	
	/**
	 * @Title: addView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午9:09:12 
	 * @Description: 新增学生信息界面
	 * @return
	 * @return: Student
	 */
	public static Student  addView() {
		//获取值
		System.out.println("请输入学生名称:");
		String name = sc.next();
		System.out.println("请输入学生年龄:");
		int age = sc.nextInt();
		System.out.println("请输入学生性别:");
		String sex = sc.next();
		System.out.println("请输入学生班级ID:");
		int classesId = sc.nextInt();
		//赋值
		Student st = new Student();
		st.setName(name);
		st.setAge(age);
		st.setSex(sex);
		st.setClassesId(classesId);
		
		return st;
	}

	/**
	 * @Title: deleteView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午9:44:58 
	 * @Description: 删除学生信息界面
	 * @return
	 * @return: int
	 */
	public static int deleteView() {
		System.out.println("请输入要删除的学生信息ID：");
		int id = sc.nextInt();
		return id;
	}
	
	/**
	 * @Title: updateView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:07:19 
	 * @Description: 修改界面  根据ID 修改
	 * 	由于控制台没有办法 回显默认的数据 所以需要将所有信息重新输入一遍  且 不修改的就输入原值
	 *  ID是无法修改的
	 * @return
	 * @return: Student
	 */
	public static Student updateView() {
		//获取值
		System.out.println("请输入学生ID:");
		int id = sc.nextInt();
		System.out.println("请输入学生名称:");
		String name = sc.next();
		System.out.println("请输入学生年龄:");
		int age = sc.nextInt();
		System.out.println("请输入学生性别:");
		String sex = sc.next();
		System.out.println("请输入学生班级ID:");
		int classesId = sc.nextInt();
		Student st = new Student();
		st.setId(id);
		st.setName(name);
		st.setAge(age);
		st.setSex(sex);
		st.setClassesId(classesId);
		
		return st;
	}
}
