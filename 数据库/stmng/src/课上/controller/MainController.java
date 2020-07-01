package 课上.controller;

import java.util.Scanner;

/**
 * @ClassName: MainController 
 * @Description: 整个控制台程序的入口
 * @author: Mr.T
 * @date: 2020年6月24日 上午11:40:37
 */
public class MainController {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("===================欢迎使用学生成绩管理系统======================");
		while(true) {
			System.out.println("1. 学生模块        2.班级模块    3.成绩模块    4.退出");
			System.out.println("请输入指令：");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				StudentController.start();
				break;
			case 2:
				ClassesController.start();
				break;
			case 3:
				ScoreController.start();
				break;
			case 4:
				System.exit(1);
				break;
			default:
				System.out.println("指令无法识别，请按规则输入指令");
				break;
			}
		}
	}

}
