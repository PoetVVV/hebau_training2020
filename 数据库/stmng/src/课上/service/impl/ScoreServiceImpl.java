package 课上.service.impl;

import java.util.List;

import 课上.dao.ScoreDao;
import 课上.dao.StudentDao;
import 课上.pojo.Score;
import 课上.pojo.Student;
import 课上.service.IScoreService;

/**
 * @ClassName: ScoreServiceImpl 
 * @Description: 分数业务实现类
 * @author: Mr.T
 * @date: 2020年6月28日 上午11:27:42
 */
public class ScoreServiceImpl implements IScoreService {
	
	ScoreDao scoreDao = new  ScoreDao();
	
	StudentDao studengDao = new StudentDao();

	@Override
	public List<Score> queryAll() {
		return scoreDao.selectList();
	}

	@Override
	public String add(Score score) {
		//业务数据校验
		//校验学生ID的合法性
		Student student = studengDao.selectOne(score.getStId());
		if(student == null) {
			return "学生信息有误";
		}
		scoreDao.insert(score);
		
		return null;
	}
	
	
	

}
