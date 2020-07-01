package 课上.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName: JdbcUtil
 * @Description: jdbc数据库连接工具类
 * @author: Mr.T
 * @date: 2020年6月22日 上午11:37:35
 */
public class JdbcUtil {

	private static String url ;
	private static String user ;
	private static String password ;
	
	//静态块  当类被使用到 会先执行静态块中的代码
	static {
		//初始化连接信息
		//加载配置文件
		//JdbcUtil.class.getClassLoader()
		//使用类加载器 查找jdbc配置文件 ，且转化为输入流对象
		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//创建属性对象
		Properties  prop = new Properties();
		//将配置文件流数据 转化为属性对象
		try {
			//加载系统文件  转化为 配置对象
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("系统文件无法加载");
		}
		url = prop.getProperty("jdbc.url");
		user = prop.getProperty("jdbc.user");
		password = prop.getProperty("jdbc.password");
		//web项目中需要使用
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: getConnection
	 * @author: Mr.T   
	 * @date: 2020年6月22日 上午11:52:23 
	 * @Description: 获取jdbc连接对象
	 * @return
	 * @return: Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("连接获取失败");
		}
		return conn;
	}
	
	/**
	 * @Title: close
	 * @author: Mr.T   
	 * @date: 2020年6月22日 上午11:54:10 
	 * @Description: 释放资源
	 * @param conn
	 * @return: void
	 */
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @Title: close
	 * @author: Mr.T   
	 * @date: 2020年6月22日 上午11:55:31 
	 * @Description: 释放资源
	 * @param conn
	 * @param prep
	 * @return: void
	 */
	public static void close(Connection conn,PreparedStatement prep) {
		if(prep != null) {
			try {
				prep.close();
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @Title: close
	 * @author: Mr.T   
	 * @date: 2020年6月22日 上午11:55:23 
	 * @Description: 释放资源
	 * @param conn
	 * @param prep
	 * @param rs
	 * @return: void
	 */
	public static void close(Connection conn,PreparedStatement prep,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
				close(conn,prep);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
