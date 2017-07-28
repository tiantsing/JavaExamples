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
	@Override
	public User login(User user) throws Exception {
		//userdao.findUser(user);
		return userdao.findUser(user);
	}
	@Override
	public Boolean findUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return userdao.findUserByName(name);
	}

}
