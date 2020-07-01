package 课上.view;

import java.util.List;
import java.util.Scanner;

import 课上.pojo.Classes;

/**
 * @ClassName: ClassesView 
 * @Description: 班级视图
 * @author: Mr.T
 * @date: 2020年6月28日 上午10:21:27
 */
public class ClassesView {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * @Title: listView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:27:17 
	 * @Description: 展示班级信息
	 * @param classess
	 * @return: void
	 */
	public static void listView(List<Classes> classess) {
		System.out.println("班级ID\t\t班级名称");
		for (Classes classes : classess) {
			System.out.println(classes.getId() +" \t\t"+classes.getName());
		}
		System.out.println();
		System.out.println();
	}
	
	/**
	 * @Title: addView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:41:03 
	 * @Description: 新增班级信息
	 * @return: Classes  班级信息
	 */
	public static Classes addView() {
		System.out.println("请输入班级名称");
		String name = sc.next();
		Classes classes = new Classes();
		classes.setName(name);
		return classes;
	}

	/**
	 * @Title: updateView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:51:37 
	 * @Description: 修改班级视图
	 * @return
	 * @return: Classes
	 */
	public static Classes updateView() {
		System.out.println("请输入班级Id");
		int id = sc.nextInt();
		System.out.println("请输入班级名称");
		String name = sc.next();
		Classes classes = new Classes();
		classes.setId(id);
		classes.setName(name);
		return classes;
	}
	
	/**
	 * @Title: deleteView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:10:27 
	 * @Description: 删除界面
	 * @return
	 * @return: Integer
	 */
	public static Integer deleteView() {
		System.out.println("请输入要删除的班级Id");
		int id = sc.nextInt();
		return id;
	}

}
