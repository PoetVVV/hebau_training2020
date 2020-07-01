package 课上.controller;

import java.util.List;
import java.util.Scanner;

import 课上.pojo.Score;
import 课上.service.IScoreService;
import 课上.service.impl.ScoreServiceImpl;
import 课上.view.ScoreView;

/**
 * @ClassName: ScoreController 
 * @Description: 分数控制类
 * @author: Mr.T
 * @date: 2020年6月28日 上午11:21:03
 */
public class ScoreController {
	
	
	static Scanner sc = new Scanner(System.in);
	static IScoreService scoreService = new ScoreServiceImpl();
	
	/**
	 * @Title: start
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:24:52 
	 * @Description: 分数核心控制方法
	 * @return: void
	 */
	public static void start() {
		boolean flag = true;
		System.out.println("===================欢迎进入分数模块===================");
		while(flag) {
			System.out.println("1 分数列表    2 新增分数    3 返回上级菜单");
			System.out.println("请输入你的选项:");
			int m = sc.nextInt();
			switch (m) {
			case 1:
				//获取分数列表数据
				List<Score> scores = scoreService.queryAll();
				//将数据进行展示
				ScoreView.listView(scores);
				break;
			case 2:
				Score score = ScoreView.addView();
				String rs = scoreService.add(score);
				if(rs == null) {
					System.out.println("新增成功");
				}else {
					System.err.println(rs);
				}
				break;
			case 3:
				flag = false;
				break;
			default:
				System.out.println("指令无法识别");
				break;
			}
			
		}
		
		
	}

}
