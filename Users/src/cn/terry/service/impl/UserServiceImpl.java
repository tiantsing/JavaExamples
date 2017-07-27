package cn.terry.service.impl;

import cn.terry.dao.UserDao;
import cn.terry.dao.impl.UserDaoImpl;
import cn.terry.domain.User;
import cn.terry.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userdao=new UserDaoImpl();
	public void register(User user) throws Exception {
        userdao.addUser(user);
	}

}
