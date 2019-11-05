/**   
 * Copyright © 2019 tiantsing. All rights reserved.
 * 
 * 功能描述：
 * @Package: tk.mybatis.simple.mapper 
 * @author: tianq   
 * @date: 2019年10月5日 下午7:44:27 
 */
package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.bean.SysRole;
import tk.mybatis.simple.bean.SysUser;

/**   
* Copyright: Copyright (c) 2019 tiantsing
* 
* @ClassName: UserMapperTest.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: tianq
* @date: 2019年10月5日 下午7:44:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年10月5日     tianq           v1.0.0               修改原因
*/
public class UserMapperTest extends BaseMapperTest{

	@Test
	public void testSelectById() {
		//获取Session
		SqlSession sqlSession = getSqlSession();
		try {
			//获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1L);
			Assert.assertNotNull(user);
			
			Assert.assertEquals("admin", user.getUserName());
		}finally {
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAll();
		    Assert.assertNotNull(userList);
		    Assert.assertTrue(userList.size()>0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
		    Assert.assertNotNull(roleList);
		    Assert.assertTrue(roleList.size()>0);
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.com");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			int result = userMapper.insert(user);
			Assert.assertEquals(1,result);
			Assert.assertNull(user.getId());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	@Test
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.com");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			int result = userMapper.insert2(user);
			Assert.assertEquals(1,result);
			Assert.assertNotNull(user.getId());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	@Test
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.com");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			int result = userMapper.insert3(user);
			Assert.assertEquals(1,result);
			Assert.assertNotNull(user.getId());
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	@Test
	public void testUpdateById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1L);
			Assert.assertEquals("admin", user.getUserName());
			user.setUserName("admin_test");
			user.setUserEmail("test@mybatis.tk");
			int result = userMapper.updateById(user);
			Assert.assertEquals(1,result);
			user = userMapper.selectById(1L);
			Assert.assertEquals("admin_test", user.getUserName());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	@Test
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user1 = userMapper.selectById(1L);
			Assert.assertNotNull(user1);
			Assert.assertEquals(1, userMapper.deleteById(1L));
			Assert.assertNull(userMapper.selectById(1L));
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	@Test
	public void testSelectByUser() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//只查询用户名
			SysUser query = new SysUser();
			query.setUserName("ad");
			List<SysUser> userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size()>0);
			//只查询用户邮箱时
			query = new SysUser();
			query.setUserEmail("test@mybatis.tk");
			userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size()>0);
			//当同事查询用户名和邮箱时
			query = new SysUser();
			query.setUserName("ad");
			query.setUserEmail("test@mybatis.tk");
			userList = userMapper.selectByUser(query);
			Assert.assertTrue(userList.size() == 0);
 		}finally {
			sqlSession.close();
		}
	}
}
