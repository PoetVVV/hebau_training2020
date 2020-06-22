package myTest.demo01;

import java.sql.*;

/**
 *  jdbc数据库操作实例
 */

public class jdbcDemo01 {
    private static String url = "jdbc:mysql://127.0.0.1:3306/ld-stmng?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static String user = "root";
    public static String password = "19971221";

    public static void main(String[] args) throws Exception{
        //1.引入第三方的数据库相关 jar包
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.创建连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.创建指令对象
            //1. sql指令
        String sql = "select id, name, age, sex, classes_id as cId from student";
            //2. 指令对象
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //4.数据结果集
        ResultSet rs = pstmt.executeQuery();
        //数据元信息
        ResultSetMetaData metaData = rs.getMetaData();
        //数据部分 需要移动指针next（）
//        boolean next = rs.next();
        //判断指针
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt("age");
            String sex = rs.getString("sex");//根据列别名获取指定类型
            //班级ID  列名：classes_id 列别名： cId
            int cId = rs.getInt("cId");
            System.out.println(id + "  " +name + "  " + age + "  " + sex + "  " + cId);
        }
        //5. 释放资源！
        rs.close();
        pstmt.close();
        connection.close();
    }
}
