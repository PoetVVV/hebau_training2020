package 课上.view;

import java.util.List;
import java.util.Scanner;

import 课上.pojo.Score;

/**
 * @ClassName: ScoreView 
 * @Description: 分数视图
 * @author: Mr.T
 * @date: 2020年6月28日 上午11:21:20
 */
public class ScoreView {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * @Title: listView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:22:00 
	 * @Description: 展示分数信息
	 * @param scores
	 * @return: void
	 */
	public static void listView(List<Score> scores) {
		System.out.println("分数ID\t\t科目名称\t\t分数\t\t学生");
		for (Score score : scores) {
			System.out.println(score.getId()+"\t\t"+score.getSubject()+"\t\t"+score.getScore()+"\t\t"+score.getStName());
		}
	}
	/**
	 * @Title: addView
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:33:40 
	 * @Description: 新增分数
	 * @return
	 * @return: Score
	 */
	public static Score addView() {
		System.out.println("请输入科目名称:");
		String subject = sc.next();
		System.out.println("请输入分数");
		int score = sc.nextInt();
		System.out.println("请输入学生ID");
		int stId = sc.nextInt();
		Score s = new Score();
		s.setSubject(subject);
		s.setScore(score);
		s.setStId(stId);
		return s;
	}

}
