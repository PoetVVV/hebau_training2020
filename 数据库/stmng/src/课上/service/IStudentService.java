package 课上.service;

import java.util.List;

import 课上.pojo.Student;

public interface IStudentService {
	
	/**
	 * @Title: queryAll
	 * @author: Mr.T   
	 * @date: 2020年6月24日 下午12:02:51 
	 * @Description: 查询所有学生信息
	 * @return
	 * @return: List<Student>
	 */
	public List<Student> queryAll();
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午9:14:48 
	 * @Description: 添加学生信息
	 * @param student
	 * @return   业务消息   如何 成功 返回null  失败则返回失败原因
	 * @return: String
	 */
	public String add(Student student);
	/**
	 * @Title: delete
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午9:47:33 
	 * @Description: 根据学生ID删除学生信息
	 * @param id
	 * @return
	 * @return: boolean
	 */
	public boolean delete(int id);
	/**
	 * @Title: updateStudent
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:12:34 
	 * @Description: 修改学生信息
	 * @param student
	 * @return
	 * @return: String
	 */
	public String updateStudent(Student student);

}
