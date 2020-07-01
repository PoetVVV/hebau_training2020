package 课上.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import 课上.pojo.Student;
import 课上.util.JdbcUtil;

/**
 * @ClassName: StudentDao 
 * @Description: 学生数据操作类
 * @author: Mr.T
 * @date: 2020年6月24日 上午9:09:03
 */
public class StudentDao {
	
	/**
	 * @Title: insert
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午9:09:32 
	 * @Description: 数据插入操作
	 * @return
	 * @return: boolean
	 */
	public boolean insert(Student student) {
		//获取连接
		Connection conn =  JdbcUtil.getConnection();
		//创建指令对象
		//1. 定义指令
		String sql = "insert into student (name,age,sex,classes_id) value(?,?,?,?)";
		//2.创建指令对象
		PreparedStatement  prep = null;
		int size = 0;
		try {
			prep = conn.prepareStatement(sql);
			//为占位符赋值
			prep.setString(1, student.getName());
			prep.setInt(2, student.getAge());
			prep.setString(3, student.getSex());
			prep.setInt(4, student.getClassesId());
			//发送指令
			size = prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep);
		}
		return size > 0 ?true:false;
	}
	/**
	 * @Title: delete
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午9:09:52 
	 * @Description: 数据删除操作
	 * @return
	 * @return: boolean
	 */
	public boolean delete(int id) {
		// 获取连接
		Connection conn = JdbcUtil.getConnection();
		//创建指令对象
		//1.定义指令
		String sql = "delete from student where id = ?";
		//2.创建指令对象
		PreparedStatement prep = null;
		//受影响的行数
		int size = 0;
		try {
			prep = conn.prepareStatement(sql);
			//为占位符赋值
			prep.setInt(1, id);
			
			//发送指令
			size = prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep);
		}
		return size > 0 ? true:false;
	}
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午9:10:13 
	 * @Description: 数据修改操作
	 * @return
	 * @return: boolean
	 */
	public boolean update(Student student) {
		// 获取连接
		Connection conn = JdbcUtil.getConnection();
		//创建指令对象
		//1.定义指令
		String sql = "update student set name = ?,age=?,sex=?,classes_id=? where id=?";
		//2.创建指令对象
		PreparedStatement prep = null;
		//受影响行数
		int size = 0;
		try {
			prep = conn.prepareStatement(sql);
			//为占位符赋值
			prep.setString(1, student.getName());
			prep.setInt(2, student.getAge());
			prep.setString(3, student.getSex());
			prep.setInt(4, student.getClassesId());
			prep.setInt(5, student.getId());
			//发送指令
			size = prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep);
		}
		return size > 0 ? true:false;
	}
	
	/**
	 * @Title: selectOne
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午10:11:50 
	 * @Description: 查询单个对象
	 * @param id
	 * @return
	 * @return: Student
	 */
	public Student selectOne(Integer id) {
		//1. 获取连接
		Connection conn = JdbcUtil.getConnection();
		//2. 创建指令对象
		// 定义指令
		String sql = "select id,name,age,sex,classes_id from student where id = ?";
		// 创建指令对象
		PreparedStatement prep = null;
		//查询结果对象
		ResultSet rs = null;
		Student student  = null;
		try {
			prep = conn.prepareStatement(sql);
			// 为占位符赋值
			prep.setInt(1, id);
			//发送指令 接收结果
			rs = prep.executeQuery();
			//将结果封装成 对象
			
			while(rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				int classesId  = rs.getInt("classes_id");
				//为对象属性赋值
				student = new Student();
				student.setId(id);
				student.setName(name);
				student.setAge(age);
				student.setSex(sex);
				student.setClassesId(classesId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep, rs);
		}
		return student;
	}
	
	
	public Student selectOne2(Integer id) {
		//1. 获取连接
		Connection conn = JdbcUtil.getConnection();
		//2. 创建指令对象
		// 定义指令
		String sql = "select id,name,age,sex,classes_id from student where id = ?";
		// 创建指令对象
		PreparedStatement prep = null;
		//查询结果对象
		ResultSet rs = null;
		Student student  = null;
		try {
			prep = conn.prepareStatement(sql);
			// 为占位符赋值
			prep.setInt(1, id);
			//发送指令 接收结果
			rs = prep.executeQuery();
			//将结果封装成对象
			//利用反射  ORM思想 实现
			/*
			 *  1. 获取结果 
			 *  	1.1 利用元信息  获取列名
			 *  	1.2 利用列名 获取值
			 *  
			 *  2. 将结果赋值到对应的属性中
			 * 		2.1. 查找到对应的属性  利用列名查找属性
			 * 		2.2. 将值赋给属性
			 */
			student = rsToObj(rs, Student.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep, rs);
		}
		return student;
	}
	
	
	
	
	/**
	 * @Title: rsToObj
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午10:26:50 
	 * @Description: 将查询结果集转化为对象 
	 * 阻碍 rsToObj 变成通用的原因    new Student()
	 * new Student 导致  rsToObj 只能返回 student 对象 
	 * @param rs   
	 * 			
	 * @return
	 * @return: Object
	 */	
	private <T> T rsToObj(ResultSet rs,Class<T> cls) {
		//声明一个对象 
		T obj = null;
		try {
			//获取数据元信息
			ResultSetMetaData metaData = rs.getMetaData();
			//获取列个数
			int columnCount = metaData.getColumnCount();
			while(rs.next()) {
				//实例化对象 使用反射创建对象
				obj = cls.newInstance();
				//循环获取查询结果的列别名
				for (int i = 1; i <= columnCount; i++) {
					//获取列别名
					String columnLabel = metaData.getColumnLabel(i);
					//根据别名获取值
					Object value = rs.getObject(columnLabel);
					//根据列名查找属性
					Field field = cls.getDeclaredField(columnLabel);
					//忽略访问修饰符
					field.setAccessible(true);
					//为属性赋值
					field.set(obj, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
