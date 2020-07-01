package 课上.service;

import java.util.List;

import 课上.pojo.Classes;

/**
 * @ClassName: IClassesService 
 * @Description: 班级信息业务类
 * @author: Mr.T
 * @date: 2020年6月28日 上午10:29:44
 */
public interface IClassesService {
	
	/**
	 * @Title: queryAll
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:30:10 
	 * @Description: 查询所有的班级信息
	 * @return
	 * @return: List<Classes>
	 */
	public List<Classes> queryAll();
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:45:30 
	 * @Description: 新增班级
	 * @param clsss
	 * @return
	 * @return: String
	 */
	public String add(Classes clsss);
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午10:53:01 
	 * @Description: 修改班级信息
	 * @param clsss
	 * @return
	 * @return: String
	 */
	public String update(Classes clsss);
	/**
	 * @Title: delete
	 * @author: Mr.T   
	 * @date: 2020年6月28日 上午11:11:17 
	 * @Description: 根据ID 删除班级信息
	 * @param id
	 * @return
	 * @return: String
	 */
	public String delete(Integer id);

}
