package cn.terry.dao;

import cn.terry.domain.User;

public interface UserDao {
	//添加用户信息
  public void addUser(User user) throws Exception;
  //登录，根据用户名密码查找数据
  public User findUser(User user) throws Exception;
  //注册，根据用户名验证是否存在
  public boolean findUserByName(String username);
}
