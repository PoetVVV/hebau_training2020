package 课上.dao;



/**
 * @ClassName: StudentDaoV2 
 * @Description: 基于 通用数据操作类
 * @author: Mr.T
 * @date: 2020年6月24日 上午9:53:19
 */
public class StudentDaoV2 extends BaseDao {
	
	
	/**
	 * @Title: delete
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午9:09:52 
	 * @Description: 数据删除操作
	 * @return
	 * @return: boolean
	 */
	public boolean delete(String sql,Object...param)  {
		return super.update(sql, param);
	}
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午9:10:13 
	 * @Description: 数据修改操作
	 * @return
	 * @return: boolean
	 */
	public boolean update(String sql,Object...param)  {
		return super.update(sql, param);
	}

}
