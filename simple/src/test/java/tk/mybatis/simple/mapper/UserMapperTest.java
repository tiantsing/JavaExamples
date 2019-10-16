/**   
 * Copyright © 2019 tiantsing. All rights reserved.
 * 
 * 功能描述：
 * @Package: tk.mybatis.simple.mapper 
 * @author: tianq   
 * @date: 2019年10月5日 下午7:44:27 
 */
package tk.mybatis.simple.mapper;

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
}
