package 课上.test;

import 课上.dao.BaseDao;
import 课上.pojo.Student;

public class Test {
	
	public static void main(String[] args) {
		
		BaseDao dao = new BaseDao();
		String sql = "insert into student (name,age,sex,classes_id) value(?,?,?,?)";
		int id = dao.insert(sql, "李磊",18,"男",1);
		System.out.println(id);
//		String sql = "delete from student where id = 2";
//		boolean update = dao.update(sql);
//		System.out.println(update);
		//String sql = "update student set name = ?,age=?,classes_id=? where id=?";
		//boolean update = dao.update(sql, "李磊",18,1,1);
		//System.out.println(update);
		//String sql = "select id,name,age,sex,classes_id as classesId from student where id = ?";
		//Student student = dao.selectOne(sql, Student.class, 1);
		//student  类中 没有 classes_id 这个属性 
		//System.out.println(student);
		
	}
}
