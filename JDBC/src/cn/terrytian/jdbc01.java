package cn.terrytian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

/**
 * 使用JDBC实现查询数据库数据并显示在控制台
 * @author tianq
 *
 */
public class jdbc01 {
     @Test
	public  void test1() throws Exception{
		 //1、注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //1.加载驱动
         Class.forName("com.mysql.jdbc.Driver");
         //2、创建连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1", "root", "root");
		//3、得到执行sql语句的Statement对象
        Statement stmt = conn.createStatement();
		//4、执行sql语句，并返回结果
        String sql = "select id,name,password,email,birthday from users";
        ResultSet rs = stmt.executeQuery(sql);
		//5、处理结果
        while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
		//6关闭资源
        rs.close();
        stmt.close();
        conn.close();

	}
     @Test
     public void test2() throws Exception {
    	 //1、注册驱动
         //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         //1.加载驱动
          Class.forName("com.mysql.jdbc.Driver");
        //2、创建连接
        //  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1","root","root");
          Properties info = new Properties();//要参考数据库文档
          info.setProperty("user", "root");
          info.setProperty("password","root");
          //2、创建连接
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1",info);
 		//3、得到执行sql语句的Statement对象
         Statement stmt = conn.createStatement();
 		//4、执行sql语句，并返回结果
         String sql = "select id,name,password,email,birthday from users";
         ResultSet rs = stmt.executeQuery(sql);
 		//5、处理结果
         while (rs.next()) {
 			System.out.println(rs.getObject(1));
 			System.out.println(rs.getObject(2));
 			System.out.println(rs.getObject(3));
 			System.out.println(rs.getObject(4));
 			System.out.println(rs.getObject(5));
 		}
 		//6关闭资源
         rs.close();
         stmt.close();
         conn.close();
     }
     @Test
 	public  void test3() throws Exception{
 		 //1、注册驱动
         //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         //1.加载驱动
          Class.forName("com.mysql.jdbc.Driver");
          //2、创建连接
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1?user=root&password=root");
 		//3、得到执行sql语句的Statement对象
         Statement stmt = conn.createStatement();
 		//4、执行sql语句，并返回结果
         String sql = "select id,name,password,email,birthday from users";
         ResultSet rs = stmt.executeQuery(sql);
 		//5、处理结果
         while (rs.next()) {
 			System.out.println(rs.getObject(1));
 			System.out.println(rs.getObject(2));
 			System.out.println(rs.getObject(3));
 			System.out.println(rs.getObject(4));
 			System.out.println(rs.getObject(5));
 		}
 		//6关闭资源
         rs.close();
         stmt.close();
         conn.close();

 	}
}
