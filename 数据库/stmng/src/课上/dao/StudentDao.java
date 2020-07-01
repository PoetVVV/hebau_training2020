package 课上.dao;

import java.util.List;

import 课上.pojo.Student;

/**
 * @ClassName: StudentDao 
 * @Description: 学生数据操作类  
 * @author: Mr.T
 * @date: 2020年6月24日 上午11:30:50
 */
public class StudentDao extends BaseDao {
	/**
	 * @Title: selectList
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午11:58:07 
	 * @Description: 查询学生列表
	 * @return
	 * @return: List<Student>
	 */
	public List<Student> selectList(){
		String sql  = "select st.id,st.name,st.age,st.sex,st.classes_id as classesId,cl.name as classesName from student st left join classes cl on st.classes_id = cl.id";
		return super.selectList(sql, Student.class);
	}
	
	/**
	 * @Title: insert
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午9:28:40 
	 * @Description: 新增学生信息
	 * @param student
	 * @return: void
	 */
	public void insert(Student student) {
		String sql = "insert into student value(0,?,?,?,?)";
		super.insert(sql, student.getName(),student.getAge(),student.getSex(),student.getClassesId());
	}
	/**
	 * @Title: delete
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午9:48:18 
	 * @Description: 根据ID 删除学生信息
	 * @param id
	 * @return
	 * @return: boolean
	 */
	public boolean delete(int id) {
		String sql = "delete  from student where id = "+id;
		return super.update(sql);
	}

	public Student selectOne(Integer id) {
		String sql  = "select st.id,st.name,st.age,st.sex,st.classes_id as classesId,cl.name as classesName from student st left join classes cl on st.classes_id = cl.id where st.id = ?";
		return super.selectOne(sql, Student.class,id);
	}
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:16:18 
	 * @Description: 修改学生信息
	 * @param student
	 * @return: void
	 */
	public void update(Student student) {
		String sql = "update student set name = ?,age = ?,sex = ?,classes_id = ? where id = ?";
		super.update(sql, student.getName(),student.getAge(),student.getSex(),student.getClassesId(),student.getId());
	}
	
	/**
	 * @Title: selectListByClassesId
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:14:06 
	 * @Description: 根据班级ID 查询学生列表
	 * @param id
	 * @return
	 * @return: List<Student>
	 */
	public List<Student> selectListByClassesId(Integer id) {
		String sql = "select id from student where classes_id = ?";
		return super.selectList(sql, Student.class, id);
	}
	
	

}
