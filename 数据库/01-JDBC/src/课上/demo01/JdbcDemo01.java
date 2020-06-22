package 课上.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @ClassName: JdbcDemo01 
 * @Description: Jdbc数据库操作示例
 * @author: Mr.T
 * @date: 2020年6月22日 上午10:32:31
 */
public class JdbcDemo01 {
	//数据库连接地址 : ip : 端口 /数据库 ?附属信息---> 数据库软件 ---> 数据库
	//服务器时区  数据的字符集 连接安全认证 附属信息
	private static String url = "jdbc:mysql://127.0.0.1:3306/ld-stmng?useUnicode=true&characterEncoding=utf8&useSSL=true";
	//数据库的用户信息
	private static String user = "root";
	//数据库密码
	private static String password = "19971221";
	
	public static void main(String[] args) throws Exception {
		//1.引入第三方的数据库相关 jar包
		//加载驱动：在JDK8 之后 Java程序中已经不需要这一步
		//JDK环境会根据url进行自动的适配
		//在Javaweb项目中需要加载驱动这个代码
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.创建连接
			//安全认证
		Connection connection = DriverManager.getConnection(url, user, password);
		//3.创建指令对象
			//1.sql指令
		String sql = "select id,name,age,sex,classes_id as cId from student";
			//2.指令对象
		PreparedStatement statement = connection.prepareStatement(sql);
		//4.数据结果集
		ResultSet rs = statement.executeQuery();
		//在结果集中  默认的数据指针其实数据元信息那行
		//数据元信息  注意： 数据元信息进行了封装 跟数据指针没有必然关系
		ResultSetMetaData metaData = rs.getMetaData();
		//数据部分
		//数据部分需要移动数据指针 next() 向下移动
		//返回值 向下移动是否成功  如果成功 则数据指针在下一行 
		//如果失败 说明没有下一行 当前行是最后一行
		boolean next = rs.next();
		//判断指针
		if(next) {
			//columnName  列名
			//columnLabel 列的标签名 
			//columnIndex 列的索引  列的索引从1 开始
			Object id = rs.getObject(1);//id
			String name = rs.getString(2);//根据列索引 获取指定的类型
			int age = rs.getInt("age");//根据列别名获取
			String sex = rs.getString("sex");//根据列别名获取指定类型
			//班级ID  列名：classes_id 列别名： cId
			//int classesId = rs.getInt("classes_id");//根据列名获取
			int cId = rs.getInt("cId");//根据列别名获取
			System.out.println(id +"  "+name +" "+age + "  "+sex +"   "+cId);
		}
		//5.释放资源
		rs.close();
		statement.close();
		connection.close();
	}
}
