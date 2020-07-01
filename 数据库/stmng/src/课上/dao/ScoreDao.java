package 课上.dao;

import java.util.List;

import 课上.pojo.Score;

/**
 * @ClassName: ScoreDao 
 * @Description: 分数数据信息操作类
 * @author: Mr.T
 * @date: 2020年6月28日 上午11:20:36
 */
public class ScoreDao extends BaseDao {

	public List<Score> selectList() {
		String sql = "select sc.id,sc.subject,sc.score,sc.st_id as stId,st.name as stName from score sc left join student st on sc.st_id = st.id";
		return super.selectList(sql, Score.class);
	}

	public void insert(Score score) {
		String sql = "insert into score value(0,?,?,?)";
		super.update(sql, score.getSubject(),score.getScore(),score.getStId());
	}

}
