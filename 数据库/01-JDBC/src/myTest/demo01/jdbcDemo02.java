package myTest.demo01;

import myTest.util.jdbcUtil;

import java.sql.*;

public class jdbcDemo02 {
    public static void main(String[] args) {
        Connection conn = jdbcUtil.getConnection();
        String sql = "select id, name, age, sex, classes_id as cId from student";
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            prep = conn.prepareStatement(sql);
            //接受查询结果
            rs = prep.executeQuery();
            //获取数据元信息
            ResultSetMetaData metaData = rs.getMetaData();

            //获取列个数
            int columnCount = metaData.getColumnCount();
            System.out.println("列个数: " + columnCount );
            //根据索引，获取列名称
            String  columnName1 = metaData.getColumnName(1);
            String  columnName5 = metaData.getColumnName(5);
            System.out.println("列1名: " + columnName1);
            System.out.println("列5名: " + columnName5);

            String columnLabel1 = metaData.getColumnLabel(1);
            String columnLabel5 = metaData.getColumnLabel(5);
            System.out.println("列1别名: " + columnLabel1);
            System.out.println("列5别名: " + columnLabel5);

            //列数据类型
            int columnType = metaData.getColumnType(1);
            String columnClassName = metaData.getColumnClassName(1);
            System.out.println(columnType + "  " + columnClassName);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(conn, prep, rs);
        }

    }
}
