package 课上.service;

import java.util.List;

import 课上.pojo.Score;

/**
 * @ClassName: IScoreService 
 * @Description: 分数业务类
 * @author: Mr.T
 * @date: 2020年6月28日 上午11:27:13
 */
public interface IScoreService {
	/**
	 * @Title: queryAll
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:28:49 
	 * @Description: 查询分数信息
	 * @return
	 * @return: List<Score>
	 */
	List<Score> queryAll();
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:37:09 
	 * @Description: 新增分数
	 * @param score
	 * @return
	 * @return: String
	 */
	String add(Score score);

}
