package cn.terry.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.sun.org.apache.regexp.internal.recompile;

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

	@Override
	public User findUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user2 = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql="select * from users where username=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPwd());
			
			rs=ps.executeQuery();
			if (rs.next()) {
				user2 = new User();
				user2.setId(rs.getInt(1));
				user2.setUsername(rs.getString(2));
				user2.setPwd(rs.getString(3));
				user2.setEmail(rs.getString(4));
				user2.setBrithday(rs.getDate(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return user2;
	}

	@Override
	public boolean findUserByName(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where username=?");
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return false;
	}

}
