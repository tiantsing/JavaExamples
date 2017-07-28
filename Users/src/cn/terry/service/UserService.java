package cn.terry.service;

import cn.terry.domain.User;

public interface UserService {
    //注册
	public void register(User user) throws Exception;
	//登录
	public User login(User user) throws Exception;
	//注册验证、
	public Boolean findUserByName(String name) throws Exception;
}
