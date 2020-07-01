package 课上.service.impl;

import java.util.List;

import 课上.dao.ClassesDao;
import 课上.dao.StudentDao;
import 课上.pojo.Classes;
import 课上.pojo.Student;
import 课上.service.IClassesService;

/**
 * @ClassName: ClassesServiceImpl 
 * @Description: 班级信息业务类实现类
 * @author: Mr.T
 * @date: 2020年6月28日 上午10:30:31
 */
public class ClassesServiceImpl  implements IClassesService{
	
	ClassesDao classesDao = new ClassesDao();
	StudentDao studentDao = new StudentDao();
	

	@Override
	public List<Classes> queryAll() {
		return classesDao.selectList();
	}


	@Override
	public String add(Classes clsss) {
		//根据名称查询 是否存在 同名班级  
		Classes classes = classesDao.selectOneByName(clsss.getName());
		if(classes != null) {
			return "班级名称已存在";
		}
		classesDao.insert(clsss);
		return null;
	}

	@Override
	public String update(Classes clsss) {
		//业务数据校验
		//班级是否存在
		Classes classes = classesDao.selectOne(clsss.getId());
		if(classes == null) {
			return "班级不存在";
		}
		//校验班级新的名称是否存在
		classes = classesDao.selectOneByName(clsss.getName());
		if(classes != null) {
			return "班级名称已存在";
		}
		classesDao.update(clsss);
		return null;
	}


	@Override
	public String delete(Integer id) {
		//业务数据校验
		//班级是否被使用 被使用则无法删除
		//根据班级ID 查询学生信息  如果存在 则说明学生有使用和班级
		List<Student> students = studentDao.selectListByClassesId(id);
		if(students!= null && !students.isEmpty()) {
			return "班级使用中，无法删除";
		}
		classesDao.delete(id);
		
		
		return null;
	}

}
