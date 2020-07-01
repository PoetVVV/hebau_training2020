package 课上.controller;

import java.util.List;
import java.util.Scanner;

import 课上.pojo.Classes;
import 课上.service.IClassesService;
import 课上.service.impl.ClassesServiceImpl;
import 课上.view.ClassesView;

/**
 * @ClassName: ClassesController 
 * @Description: 班级信息控制类
 * @author: Mr.T
 * @date: 2020年6月28日 上午10:21:51
 */
public class ClassesController {
	
	static Scanner sc = new Scanner(System.in);
	
	static IClassesService classesService = new ClassesServiceImpl();
	
	
	/**
	 * @Title: start
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:22:47 
	 * @Description: 班级信息启动方法
	 * @return: void
	 */
	public static void start() {
		boolean flag = true;
		System.out.println("===================欢迎进入班级模块===================");
		while(flag) {
			System.out.println("1 班级列表    2 新增班级   3 修改班级   4  删除班级   5 返回上级菜单");
			System.out.println("请输入你的选项:");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				//获取班级列表数据
				List<Classes> classes = classesService.queryAll();
				//将数据进行展示
				ClassesView.listView(classes);
				break;
			case 2:
				Classes clsss = ClassesView.addView();
				String rs = classesService.add(clsss);
				if(rs == null) {
					System.out.println("班级新增成功");
				}else {
					System.err.println(rs);
				}
				break;
			case 3:
				//新的班级信息
				clsss = ClassesView.updateView();
				rs = classesService.update(clsss);
				if(rs == null) {
					System.out.println("班级修改成功");
				}else {
					System.err.println(rs);
				}
				break;
			case 4:
				Integer id = ClassesView.deleteView();
				rs = classesService.delete(id);
				if(rs == null) {
					System.out.println("班级删除成功");
				}else {
					System.err.println(rs);
				}
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("指令无法识别");
				break;
			}
			
			
			
			
			
		}
		
		
	}
	

}
