package cn.terrytian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

/**
 * ʹ��JDBCʵ�ֲ�ѯ���ݿ����ݲ���ʾ�ڿ���̨
 * @author tianq
 *
 */
public class jdbc01 {
     @Test
	public  void test1() throws Exception{
		 //1��ע������
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //1.��������
         Class.forName("com.mysql.jdbc.Driver");
         //2����������
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1", "root", "root");
		//3���õ�ִ��sql����Statement����
        Statement stmt = conn.createStatement();
		//4��ִ��sql��䣬�����ؽ��
        String sql = "select id,name,password,email,birthday from users";
        ResultSet rs = stmt.executeQuery(sql);
		//5��������
        while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
		//6�ر���Դ
        rs.close();
        stmt.close();
        conn.close();

	}
     @Test
     public void test2() throws Exception {
    	 //1��ע������
         //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         //1.��������
          Class.forName("com.mysql.jdbc.Driver");
        //2����������
        //  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1","root","root");
          Properties info = new Properties();//Ҫ�ο����ݿ��ĵ�
          info.setProperty("user", "root");
          info.setProperty("password","root");
          //2����������
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1",info);
 		//3���õ�ִ��sql����Statement����
         Statement stmt = conn.createStatement();
 		//4��ִ��sql��䣬�����ؽ��
         String sql = "select id,name,password,email,birthday from users";
         ResultSet rs = stmt.executeQuery(sql);
 		//5��������
         while (rs.next()) {
 			System.out.println(rs.getObject(1));
 			System.out.println(rs.getObject(2));
 			System.out.println(rs.getObject(3));
 			System.out.println(rs.getObject(4));
 			System.out.println(rs.getObject(5));
 		}
 		//6�ر���Դ
         rs.close();
         stmt.close();
         conn.close();
     }
     @Test
 	public  void test3() throws Exception{
 		 //1��ע������
         //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
         //1.��������
          Class.forName("com.mysql.jdbc.Driver");
          //2����������
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1?user=root&password=root");
 		//3���õ�ִ��sql����Statement����
         Statement stmt = conn.createStatement();
 		//4��ִ��sql��䣬�����ؽ��
         String sql = "select id,name,password,email,birthday from users";
         ResultSet rs = stmt.executeQuery(sql);
 		//5��������
         while (rs.next()) {
 			System.out.println(rs.getObject(1));
 			System.out.println(rs.getObject(2));
 			System.out.println(rs.getObject(3));
 			System.out.println(rs.getObject(4));
 			System.out.println(rs.getObject(5));
 		}
 		//6�ر���Դ
         rs.close();
         stmt.close();
         conn.close();

 	}
}
