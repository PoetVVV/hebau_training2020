package 课上.demo01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import 课上.util.JdbcUtil;

/**
 * @ClassName: JdbcDemo02 
 * @Description: 数据元信息
 * @author: Mr.T
 * @date: 2020年6月22日 上午11:36:17
 */
public class JdbcDemo02 {
	
	public static void main(String[] args) {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//创建指令对象
		//1.定义指令
		String sql = "select id,name,age,sex,classes_id as cId from student";
		//2.创建指令对象
		PreparedStatement prep = null;
		//3.接收查询结果
		ResultSet rs = null;
		try {
			prep = conn.prepareStatement(sql);
			//接收查询结果
			rs = prep.executeQuery();
			//获取数据元信息 ： 列名  列别名  列类型
			ResultSetMetaData  metaData = rs.getMetaData();
			//获取结果中列个数
			int columnCount = metaData.getColumnCount();
			System.out.println("列个数:" + columnCount); //5
			//根据列索引 获取列名称  索引值从 1 开始
			String columnName1 = metaData.getColumnName(1);
			String columnName5 = metaData.getColumnName(5);
			System.out.println("列1  名称:"+columnName1);//id
			System.out.println("列5  名称:"+columnName5);//classes_id
			String columnLabel1 = metaData.getColumnLabel(1);//id
			String columnLabel2 = metaData.getColumnLabel(5);//cId
			System.out.println("列1  别名:"+columnLabel1);
			System.out.println("列5  别名:"+columnLabel2);
			//列类型
			int columnType = metaData.getColumnType(1);
			//类型在Java中对应的类型的类名称
			String columnClassName = metaData.getColumnClassName(1);
			System.out.println(columnType +"   "+ columnClassName);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep, rs);
		}

	}

}
