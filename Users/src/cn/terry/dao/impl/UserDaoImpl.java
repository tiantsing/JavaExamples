package cn.terry.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import cn.terry.dao.UserDao;
import cn.terry.domain.User;
import cn.terry.utils.DBUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO users(username,PASSWORD,email,brithday) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBrithday());
			ps.setString(4, date);
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败！");
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	}

}
