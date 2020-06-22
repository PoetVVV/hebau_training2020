package myTest.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtil {
    private static String url;
    private static String user;
    private static String password;

    //当类被调用， 会先执行静态块中的代码
    static {

        //web中需要使用
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //使用类加载器， 查找jdbc配置文件， 且转化为输入流对象
        InputStream in = jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //创建属性对象
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("系统文件无法加载");
        }
        url = prop.getProperty("jdbc.url");
        user = prop.getProperty("jdbc.user");
        password = prop.getProperty("jdbc.password");
    }

    //获取jdbc连接对象
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("连接获取失败");
        }
        return conn;
    }


    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement prep){
        if(prep != null){
            try {
                prep.close();
                close(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement prep, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
                close(conn, prep);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
