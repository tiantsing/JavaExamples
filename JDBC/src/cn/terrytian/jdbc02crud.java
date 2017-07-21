package cn.terrytian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.terrytian.entity.Users;

public class jdbc02crud {

	public static void main(String[] args) throws Exception {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 驱动连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest1", "root", "root");

		Statement statement = conn.createStatement();

		String sql = "select id,name,password,email,birthday from users";
		ResultSet rs = statement.executeQuery(sql);
		List<Users> list = new ArrayList<Users>();
		while (rs.next()) {
			Users u = new Users();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		}
		for(Users users : list) {
			System.out.println(users);
		}
		//6关闭资源
        rs.close();
        statement.close();
        conn.close();
	}

}
