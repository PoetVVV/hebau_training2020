package 课上.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import 课上.util.JdbcUtil;

/**
 * @ClassName: BaseDao
 * @Description: 数据库通用操作类
 * @author: Mr.T
 * @date: 2020年6月24日 上午9:41:09
 */
public class BaseDao {
	/**
	 * @Title: insert
	 * @author: Mr.T   
	 * @date: 2020年6月24日 上午11:20:50 
	 * @Description: 向表中添加数据 返回数据自增涨的主键值
	 * @param sql
	 * @param param
	 * @return
	 * @return: int
	 */
	public int insert(String sql, Object... param) {
		// 1. 获取连接
		Connection conn = JdbcUtil.getConnection();
		// 2. 创建指令对象
		PreparedStatement prep = null;
		int key = 0;
		try {
			//创建指令对象  会生成主键
			prep = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			// 3.对占位符进行赋值操作
			for (int i = 0; i < param.length; i++) {
				// i+1 占位符索引 占位符是从 1 开始
				prep.setObject(i + 1, param[i]);
			}
			// 发送指令
			prep.executeUpdate();
			//获取结果
			ResultSet rs = prep.getGeneratedKeys();
			//数据指针偏移
			rs.next();
			//获取主键值
			key = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, prep);
		}
		return key;
	}

	/**
	 * @Title: update
	 * @author: Mr.T
	 * @date: 2020年6月24日 上午9:42:19
	 * @Description: 对数据更新操作
	 * @param sql   sql指令
	 * @param param 参数
	 * @return 如果操作成功 则返回true 失败 false
	 * @return: boolean
	 */
	public boolean update(String sql, Object... param) {
		// 1. 获取连接
		Connection conn = JdbcUtil.getConnection();
		// 2. 创建指令对象
		PreparedStatement prep = null;
		// 受影响行数
		int size = 0;
		try {
			prep = conn.prepareStatement(sql);
			// 3.对占位符进行赋值操作
			for (int i = 0; i < param.length; i++) {
				// i+1 占位符索引 占位符是从 1 开始
				prep.setObject(i + 1, param[i]);
			}
			// 发送指令
			size = prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, prep);
		}
		return size > 0 ? true : false;
	}

	/**
	 * @Title: selectOne
	 * @author: Mr.T
	 * @date: 2020年6月24日 上午10:42:29
	 * @Description: 通用查询某个对象
	 * @param <T>
	 * @param sql
	 * @param cls
	 * @param param
	 * @return
	 * @return: T
	 */
	/*
	 * public <T> T selectOne(String sql,Class<T> cls,Object... param) { //1. 获取连接
	 * Connection conn = JdbcUtil.getConnection(); //2.创建指令对象 PreparedStatement prep
	 * = null; //结果集、 ResultSet rs = null; T obj = null; try { prep =
	 * conn.prepareStatement(sql); //3.对占位符进行赋值操作 for (int i = 0; i < param.length;
	 * i++) { //i+1 占位符索引 占位符是从 1 开始 prep.setObject(i+1, param[i]); } //4.发送指令
	 * 接收查询结果 rs = prep.executeQuery();
	 * 
	 * //将数据结果封装成 对象 obj = rsToObj(rs, cls); } catch (Exception e) {
	 * e.printStackTrace(); }finally { JdbcUtil.close(conn, prep, rs); } return obj;
	 * }
	 */
	/**
	 * @Title: selectOne
	 * @author: Mr.T
	 * @date: 2020年6月24日 上午11:04:34
	 * @Description: 通用的查询单个对象封装
	 * @param <T>
	 * @param sql
	 * @param cls
	 * @param param
	 * @return
	 * @return: T
	 */
	public <T> T selectOne(String sql, Class<T> cls, Object... param) {
		List<T> data = this.selectList(sql, cls, param);
		if (data != null && data.size() == 1) {
			return data.get(0);
		}
		return null;
	}

	/**
	 * @Title: selectList
	 * @author: Mr.T
	 * @date: 2020年6月24日 上午11:03:54
	 * @Description: 通用的查询列表封装
	 * @param <T>
	 * @param sql
	 * @param cls
	 * @param param
	 * @return
	 * @return: List<T>
	 */
	public <T> List<T> selectList(String sql, Class<T> cls, Object... param) {
		// 创建List 数据容器
		List<T> data = new ArrayList<T>();
		// 1. 获取连接
		Connection conn = JdbcUtil.getConnection();
		// 2.创建指令对象
		PreparedStatement prep = null;
		// 结果集、
		ResultSet rs = null;
		try {
			prep = conn.prepareStatement(sql);
			// 3.对占位符进行赋值操作
			for (int i = 0; i < param.length; i++) {
				// i+1 占位符索引 占位符是从 1 开始
				prep.setObject(i + 1, param[i]);
			}
			// 4.发送指令 接收查询结果
			rs = prep.executeQuery();
			// 获取数据元信息
			ResultSetMetaData metaData = rs.getMetaData();
			// 获取列个数
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {
				T obj = cls.newInstance();
				// 循环获取查询结果的列别名
				for (int i = 1; i <= columnCount; i++) {
					// 获取列别名
					String columnLabel = metaData.getColumnLabel(i);
					// 根据别名获取值
					Object value = rs.getObject(columnLabel);
					// 根据列名查找属性
					Field field = cls.getDeclaredField(columnLabel);
					// 忽略访问修饰符
					field.setAccessible(true);
					// 为属性赋值
					field.set(obj, value);
				}
				// 将每个数据对象 放入到容器中
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, prep, rs);
		}
		// 返回数据
		return data;
	}

}
