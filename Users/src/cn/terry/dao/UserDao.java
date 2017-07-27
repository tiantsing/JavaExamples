package cn.terry.dao;

import cn.terry.domain.User;

public interface UserDao {
	//添加用户信息
  public void addUser(User user) throws Exception;
}
