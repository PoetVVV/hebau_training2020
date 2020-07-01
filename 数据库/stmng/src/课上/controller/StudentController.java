package 课上.controller;

import java.util.List;
import java.util.Scanner;

import 课上.pojo.Student;
import 课上.service.IStudentService;
import 课上.service.impl.StudentServiceImpl;
import 课上.view.StudentView;

/**
 * @ClassName: StudentController 
 * @Description: 学生模块控制类
 * @author: Mr.T
 * @date: 2020年6月24日 上午11:45:44
 */
public class StudentController {
	
	static Scanner sc = new Scanner(System.in);
	
	
	static IStudentService studentService = new StudentServiceImpl();
	
	/**
	 * @Title: start
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午11:46:38 
	 * @Description: 进入学生模块
	 * @return: void
	 */
	public static void start() {
		boolean flag = true;
		System.out.println("===================欢迎进入学生模块===================");
		while(flag) {
			System.out.println("1.学生列表    2.新增学生信息   3.修改学生信息  4.删除学生信息  5. 返回上级菜单");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				System.out.println("进入学生列表 ");
				//将学生信息打印在控制台
				//获取数据
				List<Student> students = studentService.queryAll();
				//展示数据
				StudentView.listView(students);
				break;
			case 2:
				//新增界面
				Student student = StudentView.addView();
				//新增学生
				String rs = studentService.add(student);
				if(rs == null ) {
					System.out.println("新增成功");
				}else {
					System.out.println(rs);
				}
				break;
			case 3:
				student = StudentView.updateView();
				rs = studentService.updateStudent(student);
				if(rs == null ) {
					System.out.println("修改成功");
				}else {
					System.out.println(rs);
				}
				break;
			case 4:
				//删除界面
				int id = StudentView.deleteView();
				boolean b = studentService.delete(id);
				if(b) {
					System.out.println("删除成功");
				}else {
					System.out.println("删除失败");
				}
				break;
			case 5:
				System.out.println("返回上级菜单");
				flag = false;
				break;
			default:
				System.out.println("指令无法识别，请按规则输入指令");
				break;
			}
		}
		
		
	}

}
