package 课上.service.impl;

import java.util.List;

import 课上.dao.ClassesDao;
import 课上.dao.StudentDao;
import 课上.pojo.Classes;
import 课上.pojo.Student;
import 课上.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	
	StudentDao studentDao = new StudentDao();
	ClassesDao classesDao = new ClassesDao();

	@Override
	public List<Student> queryAll() {
		return studentDao.selectList();
	}

	@Override
	public String add(Student student) {
		/*
		  一般业务方法 返回值是一个对象
		  	业务码
		 	业务消息
		 	业务数据结果 
		 */
		//业务数据校验  校验班级ID是否合法
		//如果返回的是 boolean值   如果校验合法性 需要多种情况
		// 手机号  学号  身份证号 都要校验合法性。
		//如果不合法 返回的false  此时false代表什么？
		//校验班级是否合法 根据班级查询班级信息  如果存在 则合法 不存在  则不合法
		Classes classes = classesDao.selectOne(student.getClassesId());
		if(classes == null) {
			return "班级信息有误";
		}
		studentDao.insert(student);
		return null;
	}

	@Override
	public boolean delete(int id) {
		return studentDao.delete(id);
	}
	
	
	@Override
	public String updateStudent(Student student) {
		//进行业务数据校验
		//1.校验学生ID的合法性
		Student st = studentDao.selectOne(student.getId());
		if(st == null) {
			return "学生信息不存在";
		}
		//2.校验班级信息
		Classes classes = classesDao.selectOne(student.getClassesId());
		if(classes == null) {
			return "班级信息有误";
		}
		studentDao.update(student);
		return null;
	}

}
