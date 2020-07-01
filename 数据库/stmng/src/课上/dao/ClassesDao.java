package 课上.dao;

import java.util.List;

import 课上.pojo.Classes;

/**
 * @ClassName: ClassesDao 
 * @Description: 班级信息数据操作类
 * @author: Mr.T
 * @date: 2020年6月28日 上午9:24:30
 */
public class ClassesDao  extends BaseDao{
	
	
	public Classes selectOne(int id) {
		String sql = "select id,name from classes where id = ?";
		return super.selectOne(sql, Classes.class, id);
	}

	public List<Classes> selectList() {
		String sql = "select id,name from classes";
		return super.selectList(sql, Classes.class);
	}
	
	
	public Classes selectOneByName(String name) {
		String sql = "select id,name from classes where name = ?";
		return super.selectOne(sql, Classes.class, name);
	}

	public void insert(Classes clsss) {
		String sql = "insert into classes (name) value (?)";
		super.insert(sql, clsss.getName());
	}
	
	public void update(Classes clsss) {
		String sql = "update classes set name = ? where id = ?";
		super.update(sql, clsss.getName(),clsss.getId());
	}
	
	public void delete(Integer id) {
		String sql = "delete from classes where id = ?";
		super.update(sql, id);
	}

}
